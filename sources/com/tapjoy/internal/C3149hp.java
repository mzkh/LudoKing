package com.tapjoy.internal;

import com.facebook.AccessToken;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.TapjoyConstants;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import com.unity3d.services.purchasing.core.TransactionDetailsUtilities;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.tapjoy.internal.hp */
public final class C3149hp {

    /* renamed from: com.tapjoy.internal.hp$1 */
    static /* synthetic */ class C31501 {

        /* renamed from: a */
        static final /* synthetic */ int[] f7466a = new int[C3035ey.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.tapjoy.internal.ey[] r0 = com.tapjoy.internal.C3035ey.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7466a = r0
                int[] r0 = f7466a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.tapjoy.internal.ey r1 = com.tapjoy.internal.C3035ey.APP     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f7466a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.tapjoy.internal.ey r1 = com.tapjoy.internal.C3035ey.CAMPAIGN     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f7466a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.tapjoy.internal.ey r1 = com.tapjoy.internal.C3035ey.CUSTOM     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f7466a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.tapjoy.internal.ey r1 = com.tapjoy.internal.C3035ey.USAGES     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3149hp.C31501.<clinit>():void");
        }
    }

    /* renamed from: a */
    public static String m7286a(C3041fa faVar) {
        C2895bh b = new C2895bh().mo29882c().mo29876a("sdk").mo29881b(faVar.f7077t).mo29876a("os_name").mo29881b(faVar.f7068k).mo29876a("os_ver").mo29881b(faVar.f7069l).mo29876a("device_id").mo29881b(faVar.f7065h).mo29876a("device_maker").mo29881b(faVar.f7066i).mo29876a("device_model").mo29881b(faVar.f7067j).mo29876a(TapjoyConstants.TJC_PACKAGE_ID).mo29881b(faVar.f7075r).mo29876a(TapjoyConstants.TJC_PACKAGE_SIGN).mo29881b(faVar.f7076s).mo29876a("locale").mo29881b(faVar.f7073p).mo29876a(TapjoyConstants.TJC_DEVICE_TIMEZONE).mo29881b(faVar.f7074q);
        if (faVar.f7070m != null) {
            b.mo29876a(TapjoyConstants.TJC_DEVICE_DISPLAY_DENSITY).mo29875a((Number) faVar.f7070m);
        }
        if (faVar.f7071n != null) {
            b.mo29876a(TapjoyConstants.TJC_DEVICE_DISPLAY_WIDTH).mo29875a((Number) faVar.f7071n);
        }
        if (faVar.f7072o != null) {
            b.mo29876a(TapjoyConstants.TJC_DEVICE_DISPLAY_HEIGHT).mo29875a((Number) faVar.f7072o);
        }
        if (faVar.f7064g != null) {
            b.mo29876a("mac").mo29881b(faVar.f7064g);
        }
        if (faVar.f7078u != null) {
            b.mo29876a(TapjoyConstants.TJC_DEVICE_COUNTRY_SIM).mo29881b(faVar.f7078u);
        }
        if (faVar.f7079v != null) {
            b.mo29876a("country_net").mo29881b(faVar.f7079v);
        }
        if (faVar.f7080w != null) {
            b.mo29876a("imei").mo29881b(faVar.f7080w);
        }
        if (faVar.f7081x != null) {
            b.mo29876a(TapjoyConstants.TJC_ANDROID_ID).mo29881b(faVar.f7081x);
        }
        return b.mo29883d().toString();
    }

    /* renamed from: a */
    public static String m7282a(C3023eu euVar) {
        C2895bh c = new C2895bh().mo29882c();
        if (euVar.f6963e != null) {
            c.mo29876a(TapjoyConstants.TJC_PACKAGE_VERSION).mo29881b(euVar.f6963e);
        }
        if (euVar.f6964f != null) {
            c.mo29876a(TapjoyConstants.TJC_PACKAGE_REVISION).mo29875a((Number) euVar.f6964f);
        }
        if (euVar.f6965g != null) {
            c.mo29876a("data_ver").mo29881b(euVar.f6965g);
        }
        if (euVar.f6966h != null) {
            c.mo29876a(TapjoyConstants.TJC_INSTALLER).mo29881b(euVar.f6966h);
        }
        if (euVar.f6967i != null) {
            c.mo29876a("store").mo29881b(euVar.f6967i);
        }
        return c.mo29883d().toString();
    }

    /* renamed from: a */
    public static String m7287a(C3062fh fhVar) {
        return m7288a(fhVar, null);
    }

    /* renamed from: a */
    private static String m7288a(C3062fh fhVar, C3026ev evVar) {
        C2895bh c = new C2895bh().mo29882c();
        if (fhVar.f7196s != null) {
            c.mo29876a(TapjoyConstants.TJC_INSTALLED).mo29875a((Number) fhVar.f7196s);
        }
        if (fhVar.f7197t != null) {
            c.mo29876a(TapjoyConstants.TJC_REFERRER).mo29881b(fhVar.f7197t);
        }
        String str = "idfa_optout";
        String str2 = "idfa";
        if (fhVar.f7184G != null) {
            c.mo29876a(str2).mo29881b(fhVar.f7184G);
            if (fhVar.f7185H != null && fhVar.f7185H.booleanValue()) {
                c.mo29876a(str).mo29873a(1);
            }
        } else if (!(evVar == null || evVar.f7000r == null || !C1835hc.f3840a.equals(evVar.f7000r))) {
            String b = C3147hn.m7280b();
            if (b != null) {
                c.mo29876a(str2).mo29881b(b);
                if (C3147hn.m7281c()) {
                    c.mo29876a(str).mo29873a(1);
                }
            }
        }
        if (fhVar.f7198u != null) {
            c.mo29876a(TapjoyConstants.TJC_USER_WEEKLY_FREQUENCY).mo29873a((long) Math.max(fhVar.f7198u.intValue(), 1));
        }
        if (fhVar.f7199v != null) {
            c.mo29876a(TapjoyConstants.TJC_USER_MONTHLY_FREQUENCY).mo29873a((long) Math.max(fhVar.f7199v.intValue(), 1));
        }
        if (fhVar.f7200w.size() > 0) {
            ArrayList arrayList = new ArrayList(fhVar.f7200w.size());
            for (C3053fe feVar : fhVar.f7200w) {
                if (feVar.f7152h != null) {
                    arrayList.add(feVar.f7150f);
                }
            }
            if (!arrayList.isEmpty()) {
                c.mo29876a("push").mo29872a();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    c.mo29881b((String) it.next());
                }
                c.mo29880b();
            }
        }
        c.mo29876a("session").mo29882c();
        String str3 = "total_count";
        if (fhVar.f7201x != null) {
            c.mo29876a(str3).mo29875a((Number) fhVar.f7201x);
        }
        if (fhVar.f7202y != null) {
            c.mo29876a("total_length").mo29875a((Number) fhVar.f7202y);
        }
        String str4 = "last_at";
        if (fhVar.f7203z != null) {
            c.mo29876a(str4).mo29875a((Number) fhVar.f7203z);
        }
        if (fhVar.f7178A != null) {
            c.mo29876a("last_length").mo29875a((Number) fhVar.f7178A);
        }
        c.mo29883d();
        c.mo29876a("purchase").mo29882c();
        if (fhVar.f7179B != null) {
            c.mo29876a("currency").mo29881b(fhVar.f7179B);
        }
        if (fhVar.f7180C != null) {
            c.mo29876a(str3).mo29875a((Number) fhVar.f7180C);
        }
        if (fhVar.f7181D != null) {
            c.mo29876a("total_price").mo29875a((Number) fhVar.f7181D);
        }
        if (fhVar.f7182E != null) {
            c.mo29876a(str4).mo29875a((Number) fhVar.f7182E);
        }
        if (fhVar.f7183F != null) {
            c.mo29876a("last_price").mo29875a((Number) fhVar.f7183F);
        }
        c.mo29883d();
        if (fhVar.f7186I != null) {
            c.mo29876a(AccessToken.USER_ID_KEY).mo29881b(fhVar.f7186I);
        }
        if (fhVar.f7187J != null) {
            c.mo29876a(TapjoyConstants.TJC_USER_LEVEL).mo29875a((Number) fhVar.f7187J);
        }
        if (fhVar.f7188K != null) {
            c.mo29876a(TapjoyConstants.TJC_USER_FRIEND_COUNT).mo29875a((Number) fhVar.f7188K);
        }
        if (fhVar.f7189L != null) {
            c.mo29876a(TapjoyConstants.TJC_USER_VARIABLE_1).mo29881b(fhVar.f7189L);
        }
        if (fhVar.f7190M != null) {
            c.mo29876a(TapjoyConstants.TJC_USER_VARIABLE_2).mo29881b(fhVar.f7190M);
        }
        if (fhVar.f7191N != null) {
            c.mo29876a(TapjoyConstants.TJC_USER_VARIABLE_3).mo29881b(fhVar.f7191N);
        }
        if (fhVar.f7192O != null) {
            c.mo29876a(TapjoyConstants.TJC_USER_VARIABLE_4).mo29881b(fhVar.f7192O);
        }
        if (fhVar.f7193P != null) {
            c.mo29876a(TapjoyConstants.TJC_USER_VARIABLE_5).mo29881b(fhVar.f7193P);
        }
        if (fhVar.f7194Q.size() > 0) {
            c.mo29876a("tags").mo29877a((Collection) fhVar.f7194Q);
        }
        if (Boolean.TRUE.equals(fhVar.f7195R)) {
            c.mo29876a("push_optout").mo29873a(1);
        }
        return c.mo29883d().toString();
    }

    /* renamed from: a */
    private static String m7283a(C3026ev evVar, boolean z, boolean z2, boolean z3) {
        String str = "type";
        String str2 = "name";
        C2895bh b = new C2895bh().mo29882c().mo29876a(str).mo29881b(m7285a(evVar.f6996n)).mo29876a(str2).mo29881b(evVar.f6997o);
        b.mo29876a("time");
        String str3 = "systime";
        if (evVar.f6999q != null) {
            b.mo29875a((Number) evVar.f6998p);
            b.mo29876a(str3).mo29875a((Number) evVar.f6999q);
        } else if (!C3256v.m7570c() || evVar.f7000r == null || evVar.f7001s == null || !C1835hc.f3840a.equals(evVar.f7000r)) {
            b.mo29875a((Number) evVar.f6998p);
        } else {
            b.mo29873a(C3256v.m7566a(evVar.f7001s.longValue()));
            b.mo29876a(str3).mo29875a((Number) evVar.f6998p);
        }
        if (evVar.f7002t != null) {
            b.mo29876a("duration").mo29875a((Number) evVar.f7002t);
        }
        if (!z && evVar.f7003u != null) {
            b.mo29876a(String.VIDEO_INFO).mo29874a((C2901bl) new C2902bm(m7286a(evVar.f7003u)));
        }
        if (!z2 && evVar.f7004v != null) {
            b.mo29876a(TapjoyConstants.TJC_APP_PLACEMENT).mo29874a((C2901bl) new C2902bm(m7282a(evVar.f7004v)));
        }
        if (!z3 && evVar.f7005w != null) {
            b.mo29876a("user").mo29874a((C2901bl) new C2902bm(m7288a(evVar.f7005w, evVar)));
        }
        if (evVar.f7007y != null) {
            b.mo29876a("event_seq").mo29875a((Number) evVar.f7007y);
        }
        String str4 = "category";
        if (evVar.f7008z != null) {
            C2895bh a = b.mo29876a("event_prev");
            C3032ex exVar = evVar.f7008z;
            C2895bh b2 = new C2895bh().mo29882c().mo29876a(str).mo29881b(m7285a(exVar.f7039e)).mo29876a(str2).mo29881b(exVar.f7040f);
            if (exVar.f7041g != null) {
                b2.mo29876a(str4).mo29881b(exVar.f7041g);
            }
            a.mo29874a((C2901bl) new C2902bm(b2.mo29883d().toString()));
        }
        if (evVar.f6984A != null) {
            C2895bh a2 = b.mo29876a("purchase");
            C3050fd fdVar = evVar.f6984A;
            C2895bh b3 = new C2895bh().mo29882c().mo29876a("product_id").mo29881b(fdVar.f7119h);
            if (fdVar.f7120i != null) {
                b3.mo29876a("product_quantity").mo29875a((Number) fdVar.f7120i);
            }
            if (fdVar.f7121j != null) {
                b3.mo29876a("product_price").mo29875a((Number) fdVar.f7121j);
            }
            if (fdVar.f7122k != null) {
                b3.mo29876a("product_price_currency").mo29881b(fdVar.f7122k);
            }
            if (fdVar.f7130s != null) {
                b3.mo29876a("currency_price").mo29881b(fdVar.f7130s);
            }
            if (fdVar.f7123l != null) {
                b3.mo29876a("product_type").mo29881b(fdVar.f7123l);
            }
            if (fdVar.f7124m != null) {
                b3.mo29876a("product_title").mo29881b(fdVar.f7124m);
            }
            if (fdVar.f7125n != null) {
                b3.mo29876a("product_description").mo29881b(fdVar.f7125n);
            }
            if (fdVar.f7126o != null) {
                b3.mo29876a("transaction_id").mo29881b(fdVar.f7126o);
            }
            if (fdVar.f7127p != null) {
                b3.mo29876a("transaction_state").mo29875a((Number) fdVar.f7127p);
            }
            if (fdVar.f7128q != null) {
                b3.mo29876a("transaction_date").mo29875a((Number) fdVar.f7128q);
            }
            if (fdVar.f7129r != null) {
                b3.mo29876a("campaign_id").mo29881b(fdVar.f7129r);
            }
            if (fdVar.f7131t != null) {
                b3.mo29876a(TransactionDetailsUtilities.RECEIPT).mo29881b(fdVar.f7131t);
            }
            if (fdVar.f7132u != null) {
                b3.mo29876a(InAppPurchaseMetaData.KEY_SIGNATURE).mo29881b(fdVar.f7132u);
            }
            a2.mo29874a((C2901bl) new C2902bm(b3.mo29883d().toString()));
        }
        if (evVar.f6985B != null) {
            b.mo29876a("exception").mo29881b(evVar.f6985B);
        }
        try {
            String str5 = "meta";
            if (evVar.f6987D != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (evVar.f6986C != null) {
                    C1812bn.m3464b(evVar.f6986C).mo18054a((Map) linkedHashMap);
                }
                C3047fc fcVar = evVar.f6987D;
                if (fcVar.f7108d != null) {
                    linkedHashMap.put("fq7_change", fcVar.f7108d);
                }
                if (fcVar.f7109e != null) {
                    linkedHashMap.put("fq30_change", fcVar.f7109e);
                }
                if (fcVar.f7110f != null) {
                    linkedHashMap.put(TJAdUnitConstants.PARAM_PUSH_ID, fcVar.f7110f);
                }
                b.mo29876a(str5).mo29878a((Map) linkedHashMap);
            } else if (evVar.f6986C != null) {
                b.mo29876a(str5).mo29874a((C2901bl) new C2902bm(evVar.f6986C));
            }
        } catch (IOException unused) {
        }
        if (evVar.f6992I != null) {
            b.mo29876a(String.USAGE_TRACKER_DIMENSIONS).mo29874a((C2901bl) new C2902bm(evVar.f6992I));
        }
        if (evVar.f6993J != null) {
            b.mo29876a("count").mo29875a((Number) evVar.f6993J);
        }
        if (evVar.f6994K != null) {
            b.mo29876a("first_time").mo29875a((Number) evVar.f6994K);
        }
        if (evVar.f6995L != null) {
            b.mo29876a("last_time").mo29875a((Number) evVar.f6995L);
        }
        if (evVar.f6988E != null) {
            b.mo29876a(str4).mo29881b(evVar.f6988E);
        }
        if (evVar.f6989F != null) {
            b.mo29876a("p1").mo29881b(evVar.f6989F);
        }
        if (evVar.f6990G != null) {
            b.mo29876a("p2").mo29881b(evVar.f6990G);
        }
        if (evVar.f6991H.size() > 0) {
            b.mo29876a(String.USAGE_TRACKER_VALUES).mo29882c();
            for (C3037ez ezVar : evVar.f6991H) {
                b.mo29876a(ezVar.f7049e).mo29875a((Number) ezVar.f7050f);
            }
            b.mo29883d();
        }
        return b.mo29883d().toString();
    }

    /* renamed from: a */
    public static String m7284a(C3029ew ewVar) {
        boolean z;
        C3023eu euVar;
        boolean z2;
        C2895bh a = new C2895bh().mo29872a();
        C3041fa faVar = null;
        C3023eu euVar2 = null;
        C3062fh fhVar = null;
        for (C3026ev evVar : ewVar.f7035d) {
            boolean z3 = true;
            if (faVar == null || !faVar.equals(evVar.f7003u)) {
                faVar = evVar.f7003u;
                z = false;
            } else {
                z = true;
            }
            if (euVar2 == null || !euVar2.equals(evVar.f7004v)) {
                euVar = evVar.f7004v;
                z2 = false;
            } else {
                euVar = euVar2;
                z2 = true;
            }
            if (fhVar == null || !fhVar.equals(evVar.f7005w)) {
                fhVar = evVar.f7005w;
                z3 = false;
            }
            a.mo29874a((C2901bl) new C2902bm(m7283a(evVar, z, z2, z3)));
            euVar2 = euVar;
        }
        return a.mo29880b().toString();
    }

    /* renamed from: a */
    private static String m7285a(C3035ey eyVar) {
        int i = C31501.f7466a[eyVar.ordinal()];
        if (i == 1) {
            return TapjoyConstants.TJC_APP_PLACEMENT;
        }
        if (i == 2) {
            return Param.CAMPAIGN;
        }
        if (i == 3) {
            return "custom";
        }
        if (i == 4) {
            return "usages";
        }
        throw new RuntimeException();
    }
}
