package com.unity3d.services.core.configuration;

import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class InitializationNotificationCenter implements IInitializationNotificationCenter {
    private static InitializationNotificationCenter instance;
    private HashMap<Integer, WeakReference<IInitializationListener>> _sdkListeners = new HashMap<>();

    public static InitializationNotificationCenter getInstance() {
        if (instance == null) {
            instance = new InitializationNotificationCenter();
        }
        return instance;
    }

    public void addListener(IInitializationListener iInitializationListener) {
        synchronized (this._sdkListeners) {
            if (iInitializationListener != null) {
                this._sdkListeners.put(new Integer(iInitializationListener.hashCode()), new WeakReference(iInitializationListener));
            }
        }
    }

    public void removeListener(IInitializationListener iInitializationListener) {
        synchronized (this._sdkListeners) {
            if (iInitializationListener != null) {
                removeListener(new Integer(iInitializationListener.hashCode()));
            }
        }
    }

    public void triggerOnSdkInitialized() {
        synchronized (this._sdkListeners) {
            ArrayList arrayList = new ArrayList();
            for (Entry entry : this._sdkListeners.entrySet()) {
                if (((WeakReference) entry.getValue()).get() != null) {
                    final IInitializationListener iInitializationListener = (IInitializationListener) ((WeakReference) entry.getValue()).get();
                    Utilities.runOnUiThread(new Runnable() {
                        public void run() {
                            iInitializationListener.onSdkInitialized();
                        }
                    });
                } else {
                    arrayList.add(entry.getKey());
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this._sdkListeners.remove((Integer) it.next());
            }
        }
    }

    public void triggerOnSdkInitializationFailed(String str, final int i) {
        synchronized (this._sdkListeners) {
            StringBuilder sb = new StringBuilder();
            sb.append("SDK Failed to Initialize due to ");
            sb.append(str);
            final String sb2 = sb.toString();
            DeviceLog.error(sb2);
            ArrayList arrayList = new ArrayList();
            for (Entry entry : this._sdkListeners.entrySet()) {
                if (((WeakReference) entry.getValue()).get() != null) {
                    final IInitializationListener iInitializationListener = (IInitializationListener) ((WeakReference) entry.getValue()).get();
                    Utilities.runOnUiThread(new Runnable() {
                        public void run() {
                            iInitializationListener.onSdkInitializationFailed(sb2, i);
                        }
                    });
                } else {
                    arrayList.add(entry.getKey());
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this._sdkListeners.remove((Integer) it.next());
            }
        }
    }

    private void removeListener(Integer num) {
        this._sdkListeners.remove(num);
    }
}
