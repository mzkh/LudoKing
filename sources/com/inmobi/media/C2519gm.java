package com.inmobi.media;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.PowerManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.inmobi.media.gm */
/* compiled from: SystemBroadcastObserver */
public class C2519gm {

    /* renamed from: a */
    private static final String f5520a = "gm";

    /* renamed from: b */
    private static HashMap<String, CopyOnWriteArrayList<C2523c>> f5521b = new HashMap<>();

    /* renamed from: c */
    private static HashMap<String, C2522b> f5522c = new HashMap<>();

    /* renamed from: d */
    private static HashMap<String, NetworkCallback> f5523d = new HashMap<>();

    /* renamed from: com.inmobi.media.gm$a */
    /* compiled from: SystemBroadcastObserver */
    static class C2521a {

        /* renamed from: a */
        static final C2519gm f5525a = new C2519gm();
    }

    /* renamed from: com.inmobi.media.gm$b */
    /* compiled from: SystemBroadcastObserver */
    static final class C2522b extends BroadcastReceiver {

        /* renamed from: a */
        private static final String f5526a = "b";

        C2522b() {
        }

        @SuppressLint({"MissingPermission"})
        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                try {
                    if (intent.getAction() != null) {
                        boolean z = true;
                        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                            if (connectivityManager != null) {
                                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                                    C2519gm.m5370b(z, intent.getAction());
                                    intent.getAction();
                                }
                            }
                        } else if ("android.os.action.DEVICE_IDLE_MODE_CHANGED".equalsIgnoreCase(intent.getAction())) {
                            PowerManager powerManager = (PowerManager) context.getSystemService("power");
                            if (powerManager != null && VERSION.SDK_INT >= 23) {
                                z = powerManager.isDeviceIdleMode();
                                C2519gm.m5370b(z, intent.getAction());
                                intent.getAction();
                            }
                        } else if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                            C2519gm.m5370b(z, intent.getAction());
                            intent.getAction();
                        }
                        z = false;
                        C2519gm.m5370b(z, intent.getAction());
                        intent.getAction();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: com.inmobi.media.gm$c */
    /* compiled from: SystemBroadcastObserver */
    public interface C2523c {
        /* renamed from: a */
        void mo27900a(boolean z);
    }

    /* renamed from: a */
    public static C2519gm m5364a() {
        return C2521a.f5525a;
    }

    /* renamed from: a */
    public final void mo28471a(String str, C2523c cVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) f5521b.get(str);
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(cVar);
        } else {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            copyOnWriteArrayList.add(cVar);
        }
        f5521b.put(str, copyOnWriteArrayList);
        if (copyOnWriteArrayList.size() == 1) {
            m5366a(str);
        }
    }

    /* renamed from: a */
    public final void mo28470a(C2523c cVar) {
        if (VERSION.SDK_INT < 28) {
            mo28471a("android.net.conn.CONNECTIVITY_CHANGE", cVar);
        } else {
            mo28471a("SYSTEM_CONNECTIVITY_CHANGE", cVar);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private void m5366a(String str) {
        Context c = C2505gd.m5298c();
        if (c != null) {
            if ("SYSTEM_CONNECTIVITY_CHANGE".equals(str)) {
                ConnectivityManager connectivityManager = (ConnectivityManager) c.getSystemService("connectivity");
                if (connectivityManager != null) {
                    C25201 r1 = new NetworkCallback() {
                        public final void onAvailable(Network network) {
                            super.onAvailable(network);
                            C2519gm.m5370b(true, "SYSTEM_CONNECTIVITY_CHANGE");
                        }

                        public final void onLost(Network network) {
                            super.onLost(network);
                            C2519gm.m5370b(false, "SYSTEM_CONNECTIVITY_CHANGE");
                        }
                    };
                    f5523d.put(str, r1);
                    connectivityManager.registerDefaultNetworkCallback(r1);
                }
                return;
            }
            C2522b bVar = new C2522b();
            f5522c.put(str, bVar);
            c.registerReceiver(bVar, new IntentFilter(str));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m5370b(boolean z, String str) {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) f5521b.get(str);
        if (copyOnWriteArrayList != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                try {
                    ((C2523c) it.next()).mo27900a(z);
                } catch (Exception unused) {
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m5365a(C2523c cVar, String str) {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) f5521b.get(str);
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(cVar);
            if (copyOnWriteArrayList.size() == 0) {
                Context c = C2505gd.m5298c();
                if (c != null) {
                    if ("SYSTEM_CONNECTIVITY_CHANGE".equals(str) && f5523d.get(str) != null) {
                        ConnectivityManager connectivityManager = (ConnectivityManager) c.getSystemService("connectivity");
                        if (connectivityManager != null) {
                            connectivityManager.unregisterNetworkCallback((NetworkCallback) f5523d.get(str));
                            f5523d.remove(str);
                        }
                    } else if (f5522c.get(str) != null) {
                        c.unregisterReceiver((BroadcastReceiver) f5522c.get(str));
                        f5522c.remove(str);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public static void m5369b(C2523c cVar) {
        if (VERSION.SDK_INT < 28) {
            m5365a(cVar, "android.net.conn.CONNECTIVITY_CHANGE");
        } else {
            m5365a(cVar, "SYSTEM_CONNECTIVITY_CHANGE");
        }
    }
}
