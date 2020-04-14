package com.inmobi.media;

import android.content.Context;
import android.os.SystemClock;
import com.inmobi.media.C2426eq.C2432f;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.inmobi.media.do */
/* compiled from: OmidServiceJsFetcher */
public class C2339do {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f4958a = "do";

    /* renamed from: a */
    public static void m4844a(final C2432f fVar) {
        String str = fVar.f5210e;
        final int i = fVar.f5207b;
        final int i2 = fVar.f5208c;
        if (str != null) {
            final C2486fr frVar = new C2486fr("GET", str);
            HashMap hashMap = new HashMap();
            hashMap.put("Accept-Encoding", "gzip");
            frVar.f5450v = false;
            frVar.f5444p = false;
            frVar.mo28407a((Map<String, String>) hashMap);
            new Thread(new Runnable() {
                public final void run() {
                    if (C2339do.m4845b(fVar)) {
                        int i = 0;
                        while (true) {
                            if (i > i) {
                                break;
                            }
                            C2339do.f4958a;
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            C2487fs a = new C2488ft(frVar).mo28422a();
                            try {
                                C2566hi.m5571a().mo28564a(frVar.mo28416i());
                                C2566hi.m5571a().mo28565b(a.mo28421d());
                                C2566hi.m5571a().mo28566c(SystemClock.elapsedRealtime() - elapsedRealtime);
                            } catch (Exception unused) {
                                C2339do.f4958a;
                            }
                            Context c = C2505gd.m5298c();
                            if (a.mo28417a()) {
                                C2339do.f4958a;
                                i++;
                                if (i > i) {
                                    break;
                                }
                                try {
                                    Thread.sleep((long) (i2 * 1000));
                                } catch (InterruptedException unused2) {
                                    C2339do.f4958a;
                                }
                            } else if (c != null) {
                                C2517gk gkVar = new C2517gk(c, "omid_js_store");
                                List list = (List) a.f5454c.get("Content-Encoding");
                                String str = "omid_js_string";
                                if (list == null || !((String) list.get(0)).equals("gzip")) {
                                    gkVar.mo28469a(str, a.mo28418b());
                                    C2339do.f4958a;
                                } else {
                                    C2339do.f4958a;
                                    byte[] a2 = C2515gi.m5355a(a.mo28420c());
                                    if (a2 != null) {
                                        try {
                                            gkVar.mo28469a(str, new String(a2, "UTF-8"));
                                            C2339do.f4958a;
                                            return;
                                        } catch (UnsupportedEncodingException unused3) {
                                            C2339do.f4958a;
                                            C2339do.f4958a;
                                        }
                                    }
                                    return;
                                }
                            }
                        }
                    }
                }
            }).start();
        }
    }

    /* renamed from: b */
    static /* synthetic */ boolean m4845b(C2432f fVar) {
        Context c = C2505gd.m5298c();
        if (c != null) {
            if ((System.currentTimeMillis() / 1000) - new C2517gk(c, "omid_js_store").mo28466a() > fVar.f5206a) {
                return true;
            }
        }
        return false;
    }
}
