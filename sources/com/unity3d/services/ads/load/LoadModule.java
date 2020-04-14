package com.unity3d.services.ads.load;

import android.text.TextUtils;
import com.unity3d.services.core.configuration.IInitializationListener;
import com.unity3d.services.core.configuration.IInitializationNotificationCenter;
import com.unity3d.services.core.configuration.InitializationNotificationCenter;
import com.unity3d.services.core.properties.SdkProperties;
import java.util.LinkedHashMap;

public class LoadModule implements IInitializationListener {
    private static LoadModule instance;
    private IInitializationNotificationCenter _initializationNotificationCenter;
    private ILoadBridge _loadBridge;
    private LinkedHashMap<String, Integer> _loadEventBuffer = new LinkedHashMap<>();

    public void onSdkInitializationFailed(String str, int i) {
    }

    public static LoadModule getInstance() {
        if (instance == null) {
            instance = new LoadModule(new LoadBridge(), InitializationNotificationCenter.getInstance());
        }
        return instance;
    }

    public LoadModule(ILoadBridge iLoadBridge, IInitializationNotificationCenter iInitializationNotificationCenter) {
        this._loadBridge = iLoadBridge;
        this._initializationNotificationCenter = iInitializationNotificationCenter;
        this._initializationNotificationCenter.addListener(this);
    }

    public synchronized void load(String str) {
        addPlacementId(str);
        if (SdkProperties.isInitialized()) {
            sendLoadEvents();
        }
    }

    public synchronized void onSdkInitialized() {
        sendLoadEvents();
    }

    private void addPlacementId(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this._loadEventBuffer.containsKey(str)) {
            Integer num = (Integer) this._loadEventBuffer.get(str);
            if (num != null) {
                this._loadEventBuffer.put(str, Integer.valueOf(num.intValue() + 1));
                return;
            }
            this._loadEventBuffer.put(str, new Integer(1));
            return;
        }
        this._loadEventBuffer.put(str, new Integer(1));
    }

    private void sendLoadEvents() {
        if (this._loadEventBuffer.keySet().size() > 0) {
            this._loadBridge.loadPlacements(this._loadEventBuffer);
        }
        this._loadEventBuffer = new LinkedHashMap<>();
    }
}
