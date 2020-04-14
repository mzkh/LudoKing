package com.unity3d.services.core.connectivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.util.HashSet;
import java.util.Iterator;

public class ConnectivityMonitor {
    private static int _connected = -1;
    private static HashSet<IConnectivityListener> _listeners = null;
    private static boolean _listening = false;
    private static int _networkType = -1;
    private static boolean _webappMonitoring = false;
    private static boolean _wifi = false;

    /* renamed from: com.unity3d.services.core.connectivity.ConnectivityMonitor$1 */
    static /* synthetic */ class C34481 {

        /* renamed from: $SwitchMap$com$unity3d$services$core$connectivity$ConnectivityEvent */
        static final /* synthetic */ int[] f8095xede9def6 = new int[ConnectivityEvent.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.unity3d.services.core.connectivity.ConnectivityEvent[] r0 = com.unity3d.services.core.connectivity.ConnectivityEvent.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8095xede9def6 = r0
                int[] r0 = f8095xede9def6     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.unity3d.services.core.connectivity.ConnectivityEvent r1 = com.unity3d.services.core.connectivity.ConnectivityEvent.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f8095xede9def6     // Catch:{ NoSuchFieldError -> 0x001f }
                com.unity3d.services.core.connectivity.ConnectivityEvent r1 = com.unity3d.services.core.connectivity.ConnectivityEvent.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f8095xede9def6     // Catch:{ NoSuchFieldError -> 0x002a }
                com.unity3d.services.core.connectivity.ConnectivityEvent r1 = com.unity3d.services.core.connectivity.ConnectivityEvent.NETWORK_CHANGE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.connectivity.ConnectivityMonitor.C34481.<clinit>():void");
        }
    }

    public static void setConnectionMonitoring(boolean z) {
        _webappMonitoring = z;
        updateListeningStatus();
    }

    public static void addListener(IConnectivityListener iConnectivityListener) {
        if (_listeners == null) {
            _listeners = new HashSet<>();
        }
        _listeners.add(iConnectivityListener);
        updateListeningStatus();
    }

    public static void removeListener(IConnectivityListener iConnectivityListener) {
        HashSet<IConnectivityListener> hashSet = _listeners;
        if (hashSet != null) {
            hashSet.remove(iConnectivityListener);
            updateListeningStatus();
        }
    }

    public static void stopAll() {
        _listeners = null;
        _webappMonitoring = false;
        updateListeningStatus();
    }

    private static void updateListeningStatus() {
        if (!_webappMonitoring) {
            HashSet<IConnectivityListener> hashSet = _listeners;
            if (hashSet == null || hashSet.isEmpty()) {
                stopListening();
                return;
            }
        }
        startListening();
    }

    private static void startListening() {
        if (!_listening) {
            _listening = true;
            initConnectionStatus();
            if (VERSION.SDK_INT < 21) {
                ConnectivityChangeReceiver.register();
            } else {
                ConnectivityNetworkCallback.register();
            }
        }
    }

    private static void stopListening() {
        if (_listening) {
            _listening = false;
            if (VERSION.SDK_INT < 21) {
                ConnectivityChangeReceiver.unregister();
            } else {
                ConnectivityNetworkCallback.unregister();
            }
        }
    }

    private static void initConnectionStatus() {
        ConnectivityManager connectivityManager = (ConnectivityManager) ClientProperties.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            boolean z = false;
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                _connected = 0;
            } else {
                _connected = 1;
                if (activeNetworkInfo.getType() == 1) {
                    z = true;
                }
                _wifi = z;
                if (!_wifi) {
                    _networkType = ((TelephonyManager) ClientProperties.getApplicationContext().getSystemService("phone")).getNetworkType();
                }
            }
        }
    }

    public static void connected() {
        if (_connected != 1) {
            DeviceLog.debug("Unity Ads connectivity change: connected");
            initConnectionStatus();
            HashSet<IConnectivityListener> hashSet = _listeners;
            if (hashSet != null) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    ((IConnectivityListener) it.next()).onConnected();
                }
            }
            sendToWebview(ConnectivityEvent.CONNECTED, _wifi, _networkType);
        }
    }

    public static void disconnected() {
        if (_connected != 0) {
            _connected = 0;
            DeviceLog.debug("Unity Ads connectivity change: disconnected");
            HashSet<IConnectivityListener> hashSet = _listeners;
            if (hashSet != null) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    ((IConnectivityListener) it.next()).onDisconnected();
                }
            }
            sendToWebview(ConnectivityEvent.DISCONNECTED, false, 0);
        }
    }

    public static void connectionStatusChanged() {
        boolean z = true;
        if (_connected == 1) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) ClientProperties.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() != 1) {
                    z = false;
                }
                int networkType = ((TelephonyManager) ClientProperties.getApplicationContext().getSystemService("phone")).getNetworkType();
                boolean z2 = _wifi;
                if (z != z2 || (networkType != _networkType && !z2)) {
                    _wifi = z;
                    _networkType = networkType;
                    DeviceLog.debug("Unity Ads connectivity change: network change");
                    sendToWebview(ConnectivityEvent.NETWORK_CHANGE, z, networkType);
                }
            }
        }
    }

    private static void sendToWebview(ConnectivityEvent connectivityEvent, boolean z, int i) {
        if (_webappMonitoring) {
            WebViewApp currentApp = WebViewApp.getCurrentApp();
            if (currentApp != null && currentApp.isWebAppLoaded()) {
                int i2 = C34481.f8095xede9def6[connectivityEvent.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        currentApp.sendEvent(WebViewEventCategory.CONNECTIVITY, ConnectivityEvent.DISCONNECTED, new Object[0]);
                    } else if (i2 == 3) {
                        if (z) {
                            currentApp.sendEvent(WebViewEventCategory.CONNECTIVITY, ConnectivityEvent.NETWORK_CHANGE, Boolean.valueOf(z), Integer.valueOf(0));
                        } else {
                            currentApp.sendEvent(WebViewEventCategory.CONNECTIVITY, ConnectivityEvent.NETWORK_CHANGE, Boolean.valueOf(z), Integer.valueOf(i));
                        }
                    }
                } else if (z) {
                    currentApp.sendEvent(WebViewEventCategory.CONNECTIVITY, ConnectivityEvent.CONNECTED, Boolean.valueOf(z), Integer.valueOf(0));
                } else {
                    currentApp.sendEvent(WebViewEventCategory.CONNECTIVITY, ConnectivityEvent.CONNECTED, Boolean.valueOf(z), Integer.valueOf(i));
                }
            }
        }
    }
}
