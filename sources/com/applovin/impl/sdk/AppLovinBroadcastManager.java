package com.applovin.impl.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AppLovinBroadcastManager {

    /* renamed from: f */
    private static AppLovinBroadcastManager f2049f;

    /* renamed from: g */
    private static final Object f2050g = new Object();

    /* renamed from: a */
    private final Context f2051a;

    /* renamed from: b */
    private final HashMap<BroadcastReceiver, ArrayList<C1050b>> f2052b = new HashMap<>();

    /* renamed from: c */
    private final HashMap<String, ArrayList<C1050b>> f2053c = new HashMap<>();

    /* renamed from: d */
    private final ArrayList<C1049a> f2054d = new ArrayList<>();

    /* renamed from: e */
    private final Handler f2055e = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                AppLovinBroadcastManager.this.m1878a();
            } else {
                super.handleMessage(message);
            }
        }
    };

    /* renamed from: com.applovin.impl.sdk.AppLovinBroadcastManager$a */
    private static class C1049a {

        /* renamed from: a */
        final Intent f2057a;

        /* renamed from: b */
        final List<C1050b> f2058b;

        C1049a(Intent intent, List<C1050b> list) {
            this.f2057a = intent;
            this.f2058b = list;
        }
    }

    /* renamed from: com.applovin.impl.sdk.AppLovinBroadcastManager$b */
    private static class C1050b {

        /* renamed from: a */
        final IntentFilter f2059a;

        /* renamed from: b */
        final BroadcastReceiver f2060b;

        /* renamed from: c */
        boolean f2061c;

        /* renamed from: d */
        boolean f2062d;

        C1050b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f2059a = intentFilter;
            this.f2060b = broadcastReceiver;
        }
    }

    private AppLovinBroadcastManager(Context context) {
        this.f2051a = context;
    }

    /* renamed from: a */
    private List<C1050b> m1877a(Intent intent) {
        synchronized (this.f2052b) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f2051a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set categories = intent.getCategories();
            List<C1050b> list = (List) this.f2053c.get(action);
            if (list == null) {
                return null;
            }
            List<C1050b> list2 = null;
            for (C1050b bVar : list) {
                if (!bVar.f2061c) {
                    C1050b bVar2 = bVar;
                    if (bVar.f2059a.match(action, resolveTypeIfNeeded, scheme, data, categories, "AppLovinBroadcastManager") >= 0) {
                        List<C1050b> arrayList = list2 == null ? new ArrayList<>() : list2;
                        arrayList.add(bVar2);
                        bVar2.f2061c = true;
                        list2 = arrayList;
                    }
                }
            }
            if (list2 == null) {
                return null;
            }
            for (C1050b bVar3 : list2) {
                bVar3.f2061c = false;
            }
            return list2;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (r2 >= r0) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        r3 = r1[r2];
        r4 = r3.f2058b.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        if (r4.hasNext() == false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        r5 = (com.applovin.impl.sdk.AppLovinBroadcastManager.C1050b) r4.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        if (r5.f2062d != false) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        r5.f2060b.onReceive(r8.f2051a, r3.f2057a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        r0 = r1.length;
        r2 = 0;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m1878a() {
        /*
            r8 = this;
        L_0x0000:
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<com.applovin.impl.sdk.AppLovinBroadcastManager$b>> r0 = r8.f2052b
            monitor-enter(r0)
            java.util.ArrayList<com.applovin.impl.sdk.AppLovinBroadcastManager$a> r1 = r8.f2054d     // Catch:{ all -> 0x0043 }
            int r1 = r1.size()     // Catch:{ all -> 0x0043 }
            if (r1 > 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            return
        L_0x000d:
            com.applovin.impl.sdk.AppLovinBroadcastManager$a[] r1 = new com.applovin.impl.sdk.AppLovinBroadcastManager.C1049a[r1]     // Catch:{ all -> 0x0043 }
            java.util.ArrayList<com.applovin.impl.sdk.AppLovinBroadcastManager$a> r2 = r8.f2054d     // Catch:{ all -> 0x0043 }
            r2.toArray(r1)     // Catch:{ all -> 0x0043 }
            java.util.ArrayList<com.applovin.impl.sdk.AppLovinBroadcastManager$a> r2 = r8.f2054d     // Catch:{ all -> 0x0043 }
            r2.clear()     // Catch:{ all -> 0x0043 }
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            int r0 = r1.length
            r2 = 0
        L_0x001c:
            if (r2 >= r0) goto L_0x0000
            r3 = r1[r2]
            java.util.List<com.applovin.impl.sdk.AppLovinBroadcastManager$b> r4 = r3.f2058b
            java.util.Iterator r4 = r4.iterator()
        L_0x0026:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0040
            java.lang.Object r5 = r4.next()
            com.applovin.impl.sdk.AppLovinBroadcastManager$b r5 = (com.applovin.impl.sdk.AppLovinBroadcastManager.C1050b) r5
            boolean r6 = r5.f2062d
            if (r6 != 0) goto L_0x0026
            android.content.BroadcastReceiver r5 = r5.f2060b
            android.content.Context r6 = r8.f2051a
            android.content.Intent r7 = r3.f2057a
            r5.onReceive(r6, r7)
            goto L_0x0026
        L_0x0040:
            int r2 = r2 + 1
            goto L_0x001c
        L_0x0043:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            throw r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.AppLovinBroadcastManager.m1878a():void");
    }

    public static AppLovinBroadcastManager getInstance(Context context) {
        AppLovinBroadcastManager appLovinBroadcastManager;
        synchronized (f2050g) {
            if (f2049f == null) {
                f2049f = new AppLovinBroadcastManager(context.getApplicationContext());
            }
            appLovinBroadcastManager = f2049f;
        }
        return appLovinBroadcastManager;
    }

    public void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f2052b) {
            C1050b bVar = new C1050b(intentFilter, broadcastReceiver);
            ArrayList arrayList = (ArrayList) this.f2052b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.f2052b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(bVar);
            Iterator actionsIterator = intentFilter.actionsIterator();
            while (actionsIterator.hasNext()) {
                String str = (String) actionsIterator.next();
                ArrayList arrayList2 = (ArrayList) this.f2053c.get(str);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    this.f2053c.put(str, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean sendBroadcast(android.content.Intent r5) {
        /*
            r4 = this;
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<com.applovin.impl.sdk.AppLovinBroadcastManager$b>> r0 = r4.f2052b
            monitor-enter(r0)
            java.util.List r1 = r4.m1877a(r5)     // Catch:{ all -> 0x0026 }
            if (r1 != 0) goto L_0x000c
            r5 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            return r5
        L_0x000c:
            java.util.ArrayList<com.applovin.impl.sdk.AppLovinBroadcastManager$a> r2 = r4.f2054d     // Catch:{ all -> 0x0026 }
            com.applovin.impl.sdk.AppLovinBroadcastManager$a r3 = new com.applovin.impl.sdk.AppLovinBroadcastManager$a     // Catch:{ all -> 0x0026 }
            r3.<init>(r5, r1)     // Catch:{ all -> 0x0026 }
            r2.add(r3)     // Catch:{ all -> 0x0026 }
            android.os.Handler r5 = r4.f2055e     // Catch:{ all -> 0x0026 }
            r1 = 1
            boolean r5 = r5.hasMessages(r1)     // Catch:{ all -> 0x0026 }
            if (r5 != 0) goto L_0x0024
            android.os.Handler r5 = r4.f2055e     // Catch:{ all -> 0x0026 }
            r5.sendEmptyMessage(r1)     // Catch:{ all -> 0x0026 }
        L_0x0024:
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            return r1
        L_0x0026:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.AppLovinBroadcastManager.sendBroadcast(android.content.Intent):boolean");
    }

    public void sendBroadcastSync(Intent intent) {
        List<C1050b> a = m1877a(intent);
        if (a != null) {
            for (C1050b bVar : a) {
                if (!bVar.f2062d) {
                    bVar.f2060b.onReceive(this.f2051a, intent);
                }
            }
        }
    }

    public void sendBroadcastSyncWithPendingBroadcasts(Intent intent) {
        if (sendBroadcast(intent)) {
            m1878a();
        }
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f2052b) {
            List<C1050b> list = (List) this.f2052b.remove(broadcastReceiver);
            if (list != null) {
                for (C1050b bVar : list) {
                    bVar.f2062d = true;
                    Iterator actionsIterator = bVar.f2059a.actionsIterator();
                    while (actionsIterator.hasNext()) {
                        String str = (String) actionsIterator.next();
                        List list2 = (List) this.f2053c.get(str);
                        if (list2 != null) {
                            Iterator it = list2.iterator();
                            while (it.hasNext()) {
                                if (((C1050b) it.next()).f2060b == broadcastReceiver) {
                                    bVar.f2062d = true;
                                    it.remove();
                                }
                            }
                            if (list2.size() <= 0) {
                                this.f2053c.remove(str);
                            }
                        }
                    }
                }
            }
        }
    }
}
