package com.adcolony.sdk;

import android.util.Log;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.y */
class C0752y {

    /* renamed from: a */
    static boolean f1184a = false;

    /* renamed from: b */
    static final int f1185b = 4000;

    /* renamed from: c */
    static final int f1186c = 4;

    /* renamed from: d */
    static final int f1187d = 3;

    /* renamed from: e */
    static final int f1188e = 2;

    /* renamed from: f */
    static final int f1189f = 1;

    /* renamed from: g */
    static final int f1190g = 0;

    /* renamed from: h */
    static final int f1191h = -1;

    /* renamed from: i */
    static int f1192i = 3;

    /* renamed from: j */
    static JSONObject f1193j = C0746u.m892a();

    /* renamed from: k */
    static int f1194k = 1;

    /* renamed from: l */
    static C0492ai f1195l;

    /* renamed from: m */
    private static ExecutorService f1196m = null;

    /* renamed from: n */
    private static final Queue<Runnable> f1197n = new ConcurrentLinkedQueue();

    C0752y() {
    }

    /* renamed from: a */
    static void m954a(int i, String str, boolean z) {
        m952a(0, i, str, z);
    }

    /* renamed from: a */
    static void m952a(int i, int i2, String str, boolean z) {
        if (!m957a(m960b(i, i2, str, z))) {
            synchronized (f1197n) {
                f1197n.add(m960b(i, i2, str, z));
            }
        }
    }

    /* renamed from: b */
    private static Runnable m960b(final int i, final int i2, final String str, final boolean z) {
        return new Runnable() {
            public void run() {
                C0752y.m953a(i, str, i2);
                int i = 0;
                while (i <= str.length() / 4000) {
                    int i2 = i * 4000;
                    i++;
                    int i3 = i * 4000;
                    if (i3 > str.length()) {
                        i3 = str.length();
                    }
                    if (i2 == 3 && C0752y.m959a(C0746u.m921f(C0752y.f1193j, Integer.toString(i)), 3, z)) {
                        Log.d("AdColony [TRACE]", str.substring(i2, i3));
                    } else if (i2 == 2 && C0752y.m959a(C0746u.m921f(C0752y.f1193j, Integer.toString(i)), 2, z)) {
                        Log.i("AdColony [INFO]", str.substring(i2, i3));
                    } else if (i2 == 1 && C0752y.m959a(C0746u.m921f(C0752y.f1193j, Integer.toString(i)), 1, z)) {
                        Log.w("AdColony [WARNING]", str.substring(i2, i3));
                    } else if (i2 == 0 && C0752y.m959a(C0746u.m921f(C0752y.f1193j, Integer.toString(i)), 0, z)) {
                        Log.e("AdColony [ERROR]", str.substring(i2, i3));
                    } else if (i2 == -1 && C0752y.f1192i >= -1) {
                        Log.e("AdColony [FATAL]", str.substring(i2, i3));
                    }
                }
            }
        };
    }

    /* renamed from: a */
    static boolean m959a(JSONObject jSONObject, int i, boolean z) {
        int c = C0746u.m914c(jSONObject, "print_level");
        boolean d = C0746u.m918d(jSONObject, "log_private");
        if (jSONObject.length() == 0) {
            c = f1192i;
            d = f1184a;
        }
        boolean z2 = false;
        if ((z && !d) || c == 4) {
            return false;
        }
        if (c >= i) {
            z2 = true;
        }
        return z2;
    }

    /* renamed from: a */
    static void m951a() {
        ExecutorService executorService = f1196m;
        if (executorService == null || executorService.isShutdown() || f1196m.isTerminated()) {
            f1196m = Executors.newSingleThreadExecutor();
        }
        synchronized (f1197n) {
            while (!f1197n.isEmpty()) {
                m957a((Runnable) f1197n.poll());
            }
        }
    }

    /* renamed from: b */
    static void m961b() {
        ExecutorService executorService = f1196m;
        if (executorService != null) {
            executorService.shutdown();
            try {
                if (!f1196m.awaitTermination(1, TimeUnit.SECONDS)) {
                    f1196m.shutdownNow();
                    if (!f1196m.awaitTermination(1, TimeUnit.SECONDS)) {
                        System.err.println("ADCLogManager: ScheduledExecutorService did not terminate");
                    }
                }
            } catch (InterruptedException unused) {
                f1196m.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }

    /* renamed from: a */
    static boolean m958a(JSONObject jSONObject, int i) {
        int c = C0746u.m914c(jSONObject, "send_level");
        if (jSONObject.length() == 0) {
            c = f1194k;
        }
        return c >= i && c != 4;
    }

    /* renamed from: a */
    static void m956a(HashMap<String, Object> hashMap) {
        try {
            f1195l = new C0492ai(new C0747v(new URL("https://wd.adcolony.com/logs")), Executors.newSingleThreadScheduledExecutor(), hashMap);
            f1195l.mo8257a(5, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    static void m953a(int i, String str, int i2) {
        if (f1195l != null) {
            if (i2 == 3 && m958a(C0746u.m921f(f1193j, Integer.toString(i)), 3)) {
                f1195l.mo8264c(str);
            } else if (i2 == 2 && m958a(C0746u.m921f(f1193j, Integer.toString(i)), 2)) {
                f1195l.mo8265d(str);
            } else if (i2 == 1 && m958a(C0746u.m921f(f1193j, Integer.toString(i)), 1)) {
                f1195l.mo8266e(str);
            } else if (i2 == 0 && m958a(C0746u.m921f(f1193j, Integer.toString(i)), 0)) {
                f1195l.mo8267f(str);
            }
        }
    }

    /* renamed from: a */
    static void m955a(C0720q qVar) {
        C0492ai aiVar = f1195l;
        if (aiVar != null && f1194k != 4) {
            aiVar.mo8258a(qVar);
        }
    }

    /* renamed from: c */
    static void m962c() {
        C0476a.m81a("Log.set_log_level", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0752y.f1192i = C0746u.m914c(abVar.mo8220c(), "level");
            }
        });
        C0476a.m81a("Log.public.trace", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0752y.m952a(C0746u.m914c(abVar.mo8220c(), "module"), 3, C0746u.m908b(abVar.mo8220c(), "message"), false);
            }
        });
        C0476a.m81a("Log.private.trace", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0752y.m952a(C0746u.m914c(abVar.mo8220c(), "module"), 3, C0746u.m908b(abVar.mo8220c(), "message"), true);
            }
        });
        C0476a.m81a("Log.public.info", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0752y.m952a(C0746u.m914c(abVar.mo8220c(), "module"), 2, C0746u.m908b(abVar.mo8220c(), "message"), false);
            }
        });
        C0476a.m81a("Log.private.info", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0752y.m952a(C0746u.m914c(abVar.mo8220c(), "module"), 2, C0746u.m908b(abVar.mo8220c(), "message"), true);
            }
        });
        C0476a.m81a("Log.public.warning", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0752y.m952a(C0746u.m914c(abVar.mo8220c(), "module"), 1, C0746u.m908b(abVar.mo8220c(), "message"), false);
            }
        });
        C0476a.m81a("Log.private.warning", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0752y.m952a(C0746u.m914c(abVar.mo8220c(), "module"), 1, C0746u.m908b(abVar.mo8220c(), "message"), true);
            }
        });
        C0476a.m81a("Log.public.error", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0752y.m952a(C0746u.m914c(abVar.mo8220c(), "module"), 0, C0746u.m908b(abVar.mo8220c(), "message"), false);
            }
        });
        C0476a.m81a("Log.private.error", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0752y.m952a(C0746u.m914c(abVar.mo8220c(), "module"), 0, C0746u.m908b(abVar.mo8220c(), "message"), true);
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8741a(JSONArray jSONArray) {
        f1193j = mo8742b(jSONArray);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public JSONObject mo8742b(JSONArray jSONArray) {
        JSONObject a = C0746u.m892a();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject d = C0746u.m917d(jSONArray, i);
            C0746u.m904a(a, Integer.toString(C0746u.m914c(d, "id")), d);
        }
        return a;
    }

    /* renamed from: a */
    private static boolean m957a(Runnable runnable) {
        try {
            if (f1196m != null && !f1196m.isShutdown() && !f1196m.isTerminated()) {
                f1196m.submit(runnable);
                return true;
            }
        } catch (RejectedExecutionException unused) {
            Log.e("ADCLogError", "Internal error when submitting log to executor service.");
        }
        return false;
    }
}
