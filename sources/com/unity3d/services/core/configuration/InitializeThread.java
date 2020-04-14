package com.unity3d.services.core.configuration;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.ConditionVariable;
import com.tapjoy.TapjoyConstants;
import com.unity3d.services.core.api.Lifecycle;
import com.unity3d.services.core.connectivity.ConnectivityMonitor;
import com.unity3d.services.core.connectivity.IConnectivityListener;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.WebRequest;
import com.unity3d.services.core.webview.WebViewApp;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

public class InitializeThread extends Thread {
    private static InitializeThread _thread;
    private InitializeState _state;
    private boolean _stopThread = false;

    private static abstract class InitializeState {
        public abstract InitializeState execute();

        private InitializeState() {
        }
    }

    public static class InitializeStateComplete extends InitializeState {
        private Configuration _configuration;

        public InitializeStateComplete(Configuration configuration) {
            super();
            this._configuration = configuration;
        }

        public InitializeState execute() {
            for (String moduleConfiguration : this._configuration.getModuleConfigurationList()) {
                IModuleConfiguration moduleConfiguration2 = this._configuration.getModuleConfiguration(moduleConfiguration);
                if (moduleConfiguration2 != null) {
                    moduleConfiguration2.initCompleteState(this._configuration);
                }
            }
            return null;
        }
    }

    public static class InitializeStateConfig extends InitializeState {
        private Configuration _configuration;
        private int _maxRetries = 6;
        private int _retries = 0;
        private int _retryDelay = 5;

        public InitializeStateConfig(Configuration configuration) {
            super();
            this._configuration = configuration;
        }

        public InitializeState execute() {
            StringBuilder sb = new StringBuilder();
            sb.append("Unity Ads init: load configuration from ");
            sb.append(SdkProperties.getConfigUrl());
            DeviceLog.info(sb.toString());
            try {
                this._configuration.makeRequest();
                return new InitializeStateLoadCache(this._configuration);
            } catch (Exception e) {
                int i = this._retries;
                if (i >= this._maxRetries) {
                    return new InitializeStateNetworkError(e, this, this._configuration);
                }
                this._retryDelay *= 2;
                this._retries = i + 1;
                return new InitializeStateRetry(this, this._retryDelay);
            }
        }
    }

    public static class InitializeStateCreate extends InitializeState {
        private Configuration _configuration;
        private String _webViewData;

        public InitializeStateCreate(Configuration configuration, String str) {
            super();
            this._configuration = configuration;
            this._webViewData = str;
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }

        public String getWebData() {
            return this._webViewData;
        }

        public InitializeState execute() {
            String str = "create webapp";
            DeviceLog.debug("Unity Ads init: creating webapp");
            Configuration configuration = this._configuration;
            configuration.setWebViewData(this._webViewData);
            try {
                if (WebViewApp.create(configuration)) {
                    return new InitializeStateComplete(this._configuration);
                }
                DeviceLog.error("Unity Ads WebApp creation failed!");
                return new InitializeStateError(str, new Exception("Creation of WebApp failed!"), this._configuration);
            } catch (IllegalThreadStateException e) {
                DeviceLog.exception("Illegal Thread", e);
                return new InitializeStateError(str, e, this._configuration);
            }
        }
    }

    public static class InitializeStateError extends InitializeState {
        protected Configuration _configuration;
        Exception _exception;
        String _state;

        public InitializeStateError(String str, Exception exc, Configuration configuration) {
            super();
            this._state = str;
            this._exception = exc;
            this._configuration = configuration;
        }

        public InitializeState execute() {
            StringBuilder sb = new StringBuilder();
            sb.append("Unity Ads init: halting init in ");
            sb.append(this._state);
            sb.append(": ");
            sb.append(this._exception.getMessage());
            DeviceLog.error(sb.toString());
            for (String moduleConfiguration : this._configuration.getModuleConfigurationList()) {
                IModuleConfiguration moduleConfiguration2 = this._configuration.getModuleConfiguration(moduleConfiguration);
                if (moduleConfiguration2 != null) {
                    moduleConfiguration2.initErrorState(this._configuration, this._state, this._exception.getMessage());
                }
            }
            return null;
        }
    }

    public static class InitializeStateForceReset extends InitializeStateReset {
        public InitializeStateForceReset() {
            super(new Configuration());
        }

        public InitializeState execute() {
            super.execute();
            return null;
        }
    }

    public static class InitializeStateInitModules extends InitializeState {
        private Configuration _configuration;

        public InitializeStateInitModules(Configuration configuration) {
            super();
            this._configuration = configuration;
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }

        public InitializeState execute() {
            for (String moduleConfiguration : this._configuration.getModuleConfigurationList()) {
                IModuleConfiguration moduleConfiguration2 = this._configuration.getModuleConfiguration(moduleConfiguration);
                if (moduleConfiguration2 != null && !moduleConfiguration2.initModuleState(this._configuration)) {
                    return null;
                }
            }
            return new InitializeStateConfig(this._configuration);
        }
    }

    public static class InitializeStateLoadCache extends InitializeState {
        private Configuration _configuration;

        public InitializeStateLoadCache(Configuration configuration) {
            super();
            this._configuration = configuration;
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }

        public InitializeState execute() {
            DeviceLog.debug("Unity Ads init: check if webapp can be loaded from local cache");
            try {
                byte[] readFileBytes = Utilities.readFileBytes(new File(SdkProperties.getLocalWebViewFile()));
                String Sha256 = Utilities.Sha256(readFileBytes);
                if (Sha256 == null || !Sha256.equals(this._configuration.getWebViewHash())) {
                    return new InitializeStateLoadWeb(this._configuration);
                }
                try {
                    String str = new String(readFileBytes, "UTF-8");
                    DeviceLog.info("Unity Ads init: webapp loaded from local cache");
                    return new InitializeStateCreate(this._configuration, str);
                } catch (UnsupportedEncodingException e) {
                    return new InitializeStateError("load cache", e, this._configuration);
                }
            } catch (IOException e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unity Ads init: webapp not found in local cache: ");
                sb.append(e2.getMessage());
                DeviceLog.debug(sb.toString());
                return new InitializeStateLoadWeb(this._configuration);
            }
        }
    }

    public static class InitializeStateLoadWeb extends InitializeState {
        private Configuration _configuration;
        private int _maxRetries = 6;
        private int _retries = 0;
        private int _retryDelay = 5;

        public InitializeStateLoadWeb(Configuration configuration) {
            super();
            this._configuration = configuration;
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }

        public InitializeState execute() {
            StringBuilder sb = new StringBuilder();
            sb.append("Unity Ads init: loading webapp from ");
            sb.append(this._configuration.getWebViewUrl());
            DeviceLog.info(sb.toString());
            try {
                try {
                    String makeRequest = new WebRequest(this._configuration.getWebViewUrl(), "GET", null).makeRequest();
                    String webViewHash = this._configuration.getWebViewHash();
                    if (webViewHash == null || Utilities.Sha256(makeRequest).equals(webViewHash)) {
                        if (webViewHash != null) {
                            Utilities.writeFile(new File(SdkProperties.getLocalWebViewFile()), makeRequest);
                        }
                        return new InitializeStateCreate(this._configuration, makeRequest);
                    }
                    return new InitializeStateError("load web", new Exception("Invalid webViewHash"), this._configuration);
                } catch (Exception e) {
                    int i = this._retries;
                    if (i >= this._maxRetries) {
                        return new InitializeStateNetworkError(e, this, this._configuration);
                    }
                    this._retryDelay *= 2;
                    this._retries = i + 1;
                    return new InitializeStateRetry(this, this._retryDelay);
                }
            } catch (MalformedURLException e2) {
                DeviceLog.exception("Malformed URL", e2);
                return new InitializeStateError("make webrequest", e2, this._configuration);
            }
        }
    }

    public static class InitializeStateNetworkError extends InitializeStateError implements IConnectivityListener {
        protected static final int CONNECTED_EVENT_THRESHOLD_MS = 10000;
        protected static final int MAX_CONNECTED_EVENTS = 500;
        private static long _lastConnectedEventTimeMs;
        private static int _receivedConnectedEvents;
        private ConditionVariable _conditionVariable;
        private InitializeState _erroredState;

        public InitializeStateNetworkError(Exception exc, InitializeState initializeState, Configuration configuration) {
            super("network error", exc, configuration);
            this._erroredState = initializeState;
        }

        public InitializeState execute() {
            DeviceLog.error("Unity Ads init: network error, waiting for connection events");
            this._conditionVariable = new ConditionVariable();
            ConnectivityMonitor.addListener(this);
            if (this._conditionVariable.block(600000)) {
                ConnectivityMonitor.removeListener(this);
                return this._erroredState;
            }
            ConnectivityMonitor.removeListener(this);
            return new InitializeStateError("network error", new Exception("No connected events within the timeout!"), this._configuration);
        }

        public void onConnected() {
            _receivedConnectedEvents++;
            DeviceLog.debug("Unity Ads init got connected event");
            if (shouldHandleConnectedEvent()) {
                this._conditionVariable.open();
            }
            if (_receivedConnectedEvents > 500) {
                ConnectivityMonitor.removeListener(this);
            }
            _lastConnectedEventTimeMs = System.currentTimeMillis();
        }

        public void onDisconnected() {
            DeviceLog.debug("Unity Ads init got disconnected event");
        }

        private boolean shouldHandleConnectedEvent() {
            return System.currentTimeMillis() - _lastConnectedEventTimeMs >= TapjoyConstants.TIMER_INCREMENT && _receivedConnectedEvents <= 500;
        }
    }

    public static class InitializeStateReset extends InitializeState {
        private Configuration _configuration;

        public InitializeStateReset(Configuration configuration) {
            super();
            this._configuration = configuration;
        }

        public InitializeState execute() {
            DeviceLog.debug("Unity Ads init: starting init");
            final ConditionVariable conditionVariable = new ConditionVariable();
            final WebViewApp currentApp = WebViewApp.getCurrentApp();
            String str = "reset webapp";
            if (currentApp != null) {
                currentApp.setWebAppLoaded(false);
                boolean block = conditionVariable.block(TapjoyConstants.TIMER_INCREMENT);
                currentApp.setWebAppInitialized(false);
                if (currentApp.getWebView() != null) {
                    Utilities.runOnUiThread(new Runnable() {
                        public void run() {
                            currentApp.getWebView().destroy();
                            currentApp.setWebView(null);
                            conditionVariable.open();
                        }
                    });
                    block = conditionVariable.block(TapjoyConstants.TIMER_INCREMENT);
                }
                if (!block) {
                    return new InitializeStateError(str, new Exception("Reset failed on opening ConditionVariable"), this._configuration);
                }
            }
            if (VERSION.SDK_INT > 13) {
                unregisterLifecycleCallbacks();
            }
            SdkProperties.setCacheDirectory(null);
            if (SdkProperties.getCacheDirectory() == null) {
                return new InitializeStateError(str, new Exception("Cache directory is NULL"), this._configuration);
            }
            SdkProperties.setInitialized(false);
            this._configuration.setConfigUrl(SdkProperties.getConfigUrl());
            for (String moduleConfiguration : this._configuration.getModuleConfigurationList()) {
                IModuleConfiguration moduleConfiguration2 = this._configuration.getModuleConfiguration(moduleConfiguration);
                if (moduleConfiguration2 != null) {
                    moduleConfiguration2.resetState(this._configuration);
                }
            }
            return new InitializeStateInitModules(this._configuration);
        }

        @TargetApi(14)
        private void unregisterLifecycleCallbacks() {
            if (Lifecycle.getLifecycleListener() != null) {
                if (ClientProperties.getApplication() != null) {
                    ClientProperties.getApplication().unregisterActivityLifecycleCallbacks(Lifecycle.getLifecycleListener());
                }
                Lifecycle.setLifecycleListener(null);
            }
        }
    }

    public static class InitializeStateRetry extends InitializeState {
        int _delay;
        InitializeState _state;

        public InitializeStateRetry(InitializeState initializeState, int i) {
            super();
            this._state = initializeState;
            this._delay = i;
        }

        public InitializeState execute() {
            StringBuilder sb = new StringBuilder();
            sb.append("Unity Ads init: retrying in ");
            sb.append(this._delay);
            sb.append(" seconds");
            DeviceLog.debug(sb.toString());
            try {
                Thread.sleep(((long) this._delay) * 1000);
            } catch (InterruptedException e) {
                DeviceLog.exception("Init retry interrupted", e);
            }
            return this._state;
        }
    }

    private InitializeThread(InitializeState initializeState) {
        this._state = initializeState;
    }

    public void run() {
        while (true) {
            InitializeState initializeState = this._state;
            if (initializeState == null || (initializeState instanceof InitializeStateComplete) || this._stopThread) {
                _thread = null;
            } else {
                this._state = initializeState.execute();
            }
        }
        _thread = null;
    }

    public void quit() {
        this._stopThread = true;
    }

    public static synchronized void initialize(Configuration configuration) {
        synchronized (InitializeThread.class) {
            if (_thread == null) {
                _thread = new InitializeThread(new InitializeStateReset(configuration));
                _thread.setName("UnityAdsInitializeThread");
                _thread.start();
            }
        }
    }

    public static synchronized void reset() {
        synchronized (InitializeThread.class) {
            if (_thread == null) {
                _thread = new InitializeThread(new InitializeStateForceReset());
                _thread.setName("UnityAdsResetThread");
                _thread.start();
            }
        }
    }
}
