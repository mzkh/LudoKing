package com.inmobi.media;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.inmobi.media.C2444ev.C2445a;
import com.inmobi.media.C2447ex.C2448a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

/* renamed from: com.inmobi.media.es */
/* compiled from: ConfigComponent */
public class C2438es {
    @VisibleForTesting

    /* renamed from: a */
    public static boolean f5246a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f5247b = "es";

    /* renamed from: c */
    private static Map<C2436er, ArrayList<WeakReference<C2441c>>> f5248c = new HashMap();

    /* renamed from: d */
    private static C2439a f5249d;

    /* renamed from: com.inmobi.media.es$a */
    /* compiled from: ConfigComponent */
    static final class C2439a extends Handler implements C2445a {

        /* renamed from: a */
        private List<C2436er> f5250a = new ArrayList();

        /* renamed from: b */
        private Map<C2440b, Map<String, C2436er>> f5251b = new HashMap();

        /* renamed from: c */
        private Map<String, C2436er> f5252c = new HashMap();

        /* renamed from: d */
        private ExecutorService f5253d;

        C2439a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            C2446ew ewVar;
            Message message2 = message;
            int i = message2.what;
            int i2 = 0;
            String str = "root";
            int i3 = 1;
            if (i == 1) {
                C2436er erVar = (C2436er) message2.obj;
                if (erVar.f5244n == null) {
                    C2438es.f5247b;
                    erVar.mo28340a();
                    return;
                }
                String a = erVar.mo28340a();
                String str2 = erVar.f5244n;
                new C2442et();
                C2440b bVar = new C2440b(((C2454fa) C2442et.m5101a(str, str2)).mo28378b(a), str2);
                if (this.f5251b.get(bVar) != null && ((Map) this.f5251b.get(bVar)).containsKey(a)) {
                    i2 = 1;
                }
                Map<String, C2436er> map = this.f5252c;
                if (map != null && map.containsKey(a)) {
                    i2 = 1;
                }
                C2438es.f5247b;
                erVar.mo28340a();
                if (i2 == 0) {
                    this.f5250a.add(erVar);
                    if (!hasMessages(2)) {
                        Message obtain = Message.obtain();
                        obtain.what = 2;
                        obtain.obj = erVar.f5244n;
                        sendMessage(obtain);
                    }
                } else {
                    C2438es.f5247b;
                    erVar.mo28340a();
                }
            } else if (i == 2) {
                new C2442et();
                C2454fa faVar = (C2454fa) C2442et.m5101a(str, (String) message2.obj);
                Message obtain2 = Message.obtain();
                obtain2.what = 3;
                obtain2.obj = message2.obj;
                sendMessageDelayed(obtain2, (long) (faVar.f5301c * 1000));
            } else if (i == 3) {
                List<C2436er> list = this.f5250a;
                while (i2 < list.size()) {
                    C2436er erVar2 = (C2436er) list.get(i2);
                    if (erVar2.f5244n != null) {
                        new C2442et();
                        C2440b bVar2 = new C2440b(((C2454fa) C2442et.m5101a(str, erVar2.f5244n)).mo28378b(erVar2.mo28340a()), erVar2.f5244n);
                        HashMap hashMap = (HashMap) this.f5251b.get(bVar2);
                        if (hashMap == null) {
                            hashMap = new HashMap();
                            this.f5251b.put(bVar2, hashMap);
                        }
                        hashMap.put(erVar2.mo28340a(), erVar2);
                    }
                    i2++;
                }
                this.f5250a.clear();
                ExecutorService executorService = this.f5253d;
                if (executorService == null || executorService.isShutdown()) {
                    this.f5253d = Executors.newFixedThreadPool(1);
                    Message obtain3 = Message.obtain();
                    obtain3.what = 4;
                    obtain3.obj = message2.obj;
                    sendMessage(obtain3);
                }
            } else if (i != 4) {
                if (i != 5) {
                    C2438es.f5247b;
                    int i4 = message2.what;
                } else {
                    ExecutorService executorService2 = this.f5253d;
                    if (executorService2 != null && !executorService2.isShutdown()) {
                        this.f5252c = null;
                        this.f5251b.clear();
                        removeMessages(3);
                        this.f5253d.shutdownNow();
                    }
                }
            } else if (!this.f5251b.isEmpty()) {
                Entry entry = (Entry) this.f5251b.entrySet().iterator().next();
                this.f5252c = (Map) entry.getValue();
                this.f5251b.remove(entry.getKey());
                C2440b bVar3 = (C2440b) entry.getKey();
                Map<String, C2436er> map2 = this.f5252c;
                String str3 = (String) message2.obj;
                new C2442et();
                C2454fa faVar2 = (C2454fa) C2442et.m5101a(str, str3);
                int i5 = faVar2.f5300b;
                int i6 = faVar2.f5299a;
                C2540gy gyVar = new C2540gy(faVar2.f5243m.f5245a);
                int c = C2532gs.m5404c();
                if (c != 0 || !map2.containsKey(str)) {
                    i3 = c;
                } else {
                    map2 = C2438es.m5088a((Map) map2);
                }
                String str4 = bVar3.f5254a;
                C2446ew ewVar2 = r7;
                C2540gy gyVar2 = gyVar;
                int i7 = i6;
                int i8 = i5;
                C2446ew ewVar3 = new C2446ew(map2, gyVar, str4, i6, i5, i3, str3);
                if (map2.containsKey(str)) {
                    ewVar = new C2446ew(C2438es.m5088a((Map) map2), gyVar2, faVar2.mo28379d(), i7, i8, true, i3, str3);
                } else {
                    ewVar = null;
                }
                this.f5253d.execute(new C2444ev(this, ewVar2, ewVar));
            } else {
                C2438es.f5247b;
                sendEmptyMessage(5);
            }
        }

        /* renamed from: a */
        public final void mo28347a(C2448a aVar) {
            new C2442et();
            if (aVar.mo28355a()) {
                C2438es.f5247b;
                aVar.f5277b.mo28340a();
            } else if (aVar.f5276a == 304) {
                C2438es.f5247b;
                aVar.f5277b.mo28340a();
                if (aVar.f5277b.f5244n != null) {
                    C2442et.m5103a(aVar.f5277b.mo28340a(), aVar.f5277b.f5244n, System.currentTimeMillis());
                }
            } else {
                C2442et.m5102a(aVar.f5277b);
                try {
                    C2438es.f5247b;
                    aVar.f5277b.mo28340a();
                    C2438es.f5247b;
                    aVar.f5277b.mo28342b();
                    C2438es.f5247b;
                    C2438es.m5094b(aVar.f5277b);
                } catch (JSONException unused) {
                }
            }
        }

        /* renamed from: a */
        public final void mo28348a(String str) {
            Message obtain = Message.obtain();
            obtain.what = 4;
            obtain.obj = str;
            sendMessage(obtain);
        }
    }

    /* renamed from: com.inmobi.media.es$b */
    /* compiled from: ConfigComponent */
    static class C2440b {
        @NonNull

        /* renamed from: a */
        final String f5254a;
        @NonNull

        /* renamed from: b */
        private final String f5255b;

        C2440b(@NonNull String str, @NonNull String str2) {
            this.f5254a = str;
            this.f5255b = str2;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C2440b)) {
                return false;
            }
            C2440b bVar = (C2440b) obj;
            if (!this.f5254a.equals(bVar.f5254a) || !this.f5255b.equals(bVar.f5255b)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return this.f5254a.hashCode() + this.f5255b.hashCode();
        }
    }

    /* renamed from: com.inmobi.media.es$c */
    /* compiled from: ConfigComponent */
    public interface C2441c {
        /* renamed from: a */
        void mo27896a(C2436er erVar);
    }

    static {
        HandlerThread handlerThread = new HandlerThread("ConfigBootstrapHandler");
        handlerThread.start();
        f5249d = new C2439a(handlerThread.getLooper());
    }

    /* renamed from: a */
    public static synchronized void m5089a() {
        synchronized (C2438es.class) {
            if (!f5246a) {
                f5246a = true;
                m5086a("root", C2505gd.m5306f());
                m5087a("root", C2505gd.m5306f(), null);
                for (Entry key : f5248c.entrySet()) {
                    C2436er erVar = (C2436er) key.getKey();
                    m5094b(m5086a(erVar.mo28340a(), erVar.f5244n));
                }
            }
        }
    }

    /* renamed from: b */
    public static synchronized void m5093b() {
        synchronized (C2438es.class) {
            if (f5246a) {
                f5246a = false;
                f5249d.sendEmptyMessage(5);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m5094b(C2436er erVar) {
        ArrayList arrayList = (ArrayList) f5248c.get(erVar);
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) != null) {
                    C2441c cVar = (C2441c) ((WeakReference) arrayList.get(i)).get();
                    if (cVar != null) {
                        cVar.mo27896a(erVar);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized C2436er m5087a(String str, @Nullable String str2, @Nullable C2441c cVar) {
        Object obj;
        synchronized (C2438es.class) {
            C2436er a = C2436er.m5081a(str, str2);
            if (!f5246a) {
                return a;
            }
            ArrayList arrayList = (ArrayList) f5248c.get(a);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            if (cVar == null) {
                obj = null;
            } else {
                obj = new WeakReference(cVar);
            }
            arrayList.add(obj);
            f5248c.put(a, arrayList);
            C2436er a2 = m5086a(str, str2);
            return a2;
        }
    }

    /* renamed from: a */
    public static void m5091a(@NonNull String str) {
        new C2442et();
        C2454fa faVar = (C2454fa) C2442et.m5101a("root", str);
        String str2 = faVar.f5303e.f5311a;
        String str3 = faVar.f5303e.f5312b;
        if (str2.trim().length() != 0 && m5095b(C2506ge.m5320b(), str2.trim())) {
            String str4 = f5247b;
            StringBuilder sb = new StringBuilder("A newer version (version ");
            sb.append(str2);
            sb.append(") of the InMobi SDK is available! You are currently on an older version (Version ");
            sb.append(C2506ge.m5320b());
            sb.append("). Please download the latest InMobi SDK from ");
            sb.append(str3);
            C2514gh.m5342a(2, str4, sb.toString());
        }
    }

    /* renamed from: a */
    private static synchronized C2436er m5086a(String str, @Nullable String str2) {
        synchronized (C2438es.class) {
            new C2442et();
            C2436er a = C2436er.m5081a(str, str2);
            if (str2 == null) {
                return a;
            }
            if (C2442et.m5104b("root", str2)) {
                m5097c(C2436er.m5081a("root", str2));
                return a;
            }
            C2454fa faVar = (C2454fa) C2442et.m5101a("root", str2);
            if (m5092a(C2442et.m5105c("root", str2), faVar.mo28377a("root"))) {
                m5097c(C2436er.m5081a("root", str2));
            }
            if (C2442et.m5104b(str, str2)) {
                m5097c(a);
                return a;
            }
            C2436er a2 = C2442et.m5101a(str, str2);
            if (!m5092a(C2442et.m5105c(str, str2), faVar.mo28377a(str))) {
                return a2;
            }
            m5097c(a);
            return a;
        }
    }

    /* renamed from: a */
    private static boolean m5092a(long j, long j2) {
        return System.currentTimeMillis() - j > j2 * 1000;
    }

    /* renamed from: c */
    private static void m5097c(C2436er erVar) {
        Message obtainMessage = f5249d.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = erVar;
        f5249d.sendMessage(obtainMessage);
    }

    /* renamed from: b */
    private static boolean m5095b(String str, String str2) {
        String str3 = "\\.";
        String[] split = str.split(str3);
        String[] split2 = str2.split(str3);
        try {
            for (String valueOf : split) {
                if (Integer.valueOf(valueOf).intValue() < 0) {
                    return false;
                }
            }
            for (String valueOf2 : split2) {
                if (Integer.valueOf(valueOf2).intValue() < 0) {
                    return false;
                }
            }
            int length = split.length < split2.length ? split.length : split2.length;
            int i = 0;
            while (i < length) {
                if (split[i].equals(split2[i])) {
                    i++;
                } else if (Integer.valueOf(split[i]).intValue() < Integer.valueOf(split2[i]).intValue()) {
                    return true;
                } else {
                    return false;
                }
            }
            if (split.length < split2.length) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
        }
    }

    /* renamed from: a */
    static /* synthetic */ Map m5088a(Map map) {
        HashMap hashMap = new HashMap(1);
        String str = "root";
        hashMap.put(str, map.get(str));
        return hashMap;
    }
}
