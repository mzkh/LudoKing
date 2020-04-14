package com.adcolony.sdk;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.iab.omid.library.adcolony.adsession.Partner;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.j */
class C0666j implements C0704a {

    /* renamed from: H */
    private static volatile String f929H = "";

    /* renamed from: a */
    static final String f930a = "026ae9c9824b3e483fa6c71fa88f57ae27816141";

    /* renamed from: b */
    static final String f931b = "7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5";

    /* renamed from: e */
    static String f932e = "https://adc3-launch.adcolony.com/v4/launch";

    /* renamed from: A */
    private HashMap<String, AdColonyZone> f933A = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: B */
    public HashMap<Integer, C0557av> f934B = new HashMap<>();

    /* renamed from: C */
    private String f935C;

    /* renamed from: D */
    private String f936D;

    /* renamed from: E */
    private String f937E;

    /* renamed from: F */
    private String f938F;

    /* renamed from: G */
    private String f939G = "";

    /* renamed from: I */
    private boolean f940I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public boolean f941J;

    /* renamed from: K */
    private boolean f942K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public boolean f943L;

    /* renamed from: M */
    private boolean f944M;

    /* renamed from: N */
    private boolean f945N;

    /* renamed from: O */
    private boolean f946O;

    /* renamed from: P */
    private boolean f947P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public boolean f948Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public boolean f949R;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public boolean f950S;

    /* renamed from: T */
    private int f951T;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public int f952U = 1;

    /* renamed from: V */
    private final int f953V = 120;

    /* renamed from: W */
    private ActivityLifecycleCallbacks f954W;
    /* access modifiers changed from: private */

    /* renamed from: X */
    public Partner f955X = null;

    /* renamed from: c */
    C0691l f956c;

    /* renamed from: d */
    C0486af f957d;

    /* renamed from: f */
    boolean f958f;

    /* renamed from: g */
    private C0689k f959g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C0481ac f960h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C0705o f961i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C0498al f962j;

    /* renamed from: k */
    private C0595d f963k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public C0697m f964l;

    /* renamed from: m */
    private C0722r f965m;

    /* renamed from: n */
    private C0511aq f966n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C0509ao f967o;

    /* renamed from: p */
    private C0752y f968p;

    /* renamed from: q */
    private C0580c f969q;

    /* renamed from: r */
    private AdColonyAdView f970r;

    /* renamed from: s */
    private AdColonyInterstitial f971s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public AdColonyRewardListener f972t;

    /* renamed from: u */
    private HashMap<String, AdColonyCustomMessageListener> f973u = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: v */
    public AdColonyAppOptions f974v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public C0480ab f975w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f976x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public C0480ab f977y;

    /* renamed from: z */
    private JSONObject f978z;

    C0666j() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Context mo8547a() {
        return C0476a.m85c();
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0113  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8550a(com.adcolony.sdk.AdColonyAppOptions r5, boolean r6) {
        /*
            r4 = this;
            r4.f942K = r6
            r4.f974v = r5
            com.adcolony.sdk.ac r0 = new com.adcolony.sdk.ac
            r0.<init>()
            r4.f960h = r0
            com.adcolony.sdk.k r0 = new com.adcolony.sdk.k
            r0.<init>()
            r4.f959g = r0
            com.adcolony.sdk.o r0 = new com.adcolony.sdk.o
            r0.<init>()
            r4.f961i = r0
            com.adcolony.sdk.o r0 = r4.f961i
            r0.mo8668a()
            com.adcolony.sdk.al r0 = new com.adcolony.sdk.al
            r0.<init>()
            r4.f962j = r0
            com.adcolony.sdk.al r0 = r4.f962j
            r0.mo8291a()
            com.adcolony.sdk.d r0 = new com.adcolony.sdk.d
            r0.<init>()
            r4.f963k = r0
            com.adcolony.sdk.d r0 = r4.f963k
            r0.mo8501a()
            com.adcolony.sdk.m r0 = new com.adcolony.sdk.m
            r0.<init>()
            r4.f964l = r0
            com.adcolony.sdk.r r0 = new com.adcolony.sdk.r
            r0.<init>()
            r4.f965m = r0
            com.adcolony.sdk.r r0 = r4.f965m
            r0.mo8692a()
            com.adcolony.sdk.y r0 = new com.adcolony.sdk.y
            r0.<init>()
            r4.f968p = r0
            com.adcolony.sdk.y r0 = r4.f968p
            com.adcolony.sdk.C0752y.m962c()
            com.adcolony.sdk.ao r0 = new com.adcolony.sdk.ao
            r0.<init>()
            r4.f967o = r0
            com.adcolony.sdk.ao r0 = r4.f967o
            r0.mo8312a()
            com.adcolony.sdk.aq r0 = new com.adcolony.sdk.aq
            r0.<init>()
            r4.f966n = r0
            com.adcolony.sdk.aq r0 = r4.f966n
            r0.mo8325a()
            com.adcolony.sdk.l r0 = new com.adcolony.sdk.l
            r0.<init>()
            r4.f956c = r0
            com.adcolony.sdk.l r0 = r4.f956c
            r0.mo8629e()
            com.adcolony.sdk.af r0 = new com.adcolony.sdk.af
            r0.<init>()
            r4.f957d = r0
            com.adcolony.sdk.af r0 = r4.f957d
            java.lang.String r0 = r0.mo8243c()
            r4.f935C = r0
            android.content.Context r0 = com.adcolony.sdk.C0476a.m85c()
            com.adcolony.sdk.AdColony.m10a(r0, r5)
            r5 = 0
            r0 = 1
            if (r6 != 0) goto L_0x013b
            java.io.File r6 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.adcolony.sdk.ao r2 = r4.f967o
            java.lang.String r2 = r2.mo8318g()
            r1.append(r2)
            java.lang.String r2 = "026ae9c9824b3e483fa6c71fa88f57ae27816141"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r6.<init>(r1)
            boolean r6 = r6.exists()
            r4.f945N = r6
            java.io.File r6 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.adcolony.sdk.ao r3 = r4.f967o
            java.lang.String r3 = r3.mo8318g()
            r1.append(r3)
            java.lang.String r3 = "7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r6.<init>(r1)
            boolean r6 = r6.exists()
            r4.f946O = r6
            boolean r6 = r4.f945N
            if (r6 == 0) goto L_0x010c
            boolean r6 = r4.f946O
            if (r6 == 0) goto L_0x010c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            com.adcolony.sdk.ao r1 = r4.f967o
            java.lang.String r1 = r1.mo8318g()
            r6.append(r1)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            org.json.JSONObject r6 = com.adcolony.sdk.C0746u.m916c(r6)
            java.lang.String r1 = "sdkVersion"
            java.lang.String r6 = com.adcolony.sdk.C0746u.m908b(r6, r1)
            com.adcolony.sdk.l r1 = r4.f956c
            java.lang.String r1 = r1.mo8615F()
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x010c
            r6 = 1
            goto L_0x010d
        L_0x010c:
            r6 = 0
        L_0x010d:
            r4.f944M = r6
            boolean r6 = r4.f945N
            if (r6 == 0) goto L_0x0133
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            com.adcolony.sdk.ao r1 = r4.f967o
            java.lang.String r1 = r1.mo8318g()
            r6.append(r1)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            org.json.JSONObject r6 = com.adcolony.sdk.C0746u.m916c(r6)
            r4.f978z = r6
            org.json.JSONObject r6 = r4.f978z
            r4.m651b(r6)
        L_0x0133:
            boolean r6 = r4.f944M
            r4.m664e(r6)
            r4.m642I()
        L_0x013b:
            com.adcolony.sdk.j$1 r6 = new com.adcolony.sdk.j$1
            r6.<init>()
            java.lang.String r1 = "Module.load"
            com.adcolony.sdk.C0476a.m81a(r1, r6)
            com.adcolony.sdk.j$12 r6 = new com.adcolony.sdk.j$12
            r6.<init>()
            java.lang.String r1 = "Module.unload"
            com.adcolony.sdk.C0476a.m81a(r1, r6)
            com.adcolony.sdk.j$14 r6 = new com.adcolony.sdk.j$14
            r6.<init>()
            java.lang.String r1 = "AdColony.on_configured"
            com.adcolony.sdk.C0476a.m81a(r1, r6)
            com.adcolony.sdk.j$15 r6 = new com.adcolony.sdk.j$15
            r6.<init>()
            java.lang.String r1 = "AdColony.get_app_info"
            com.adcolony.sdk.C0476a.m81a(r1, r6)
            com.adcolony.sdk.j$16 r6 = new com.adcolony.sdk.j$16
            r6.<init>()
            java.lang.String r1 = "AdColony.v4vc_reward"
            com.adcolony.sdk.C0476a.m81a(r1, r6)
            com.adcolony.sdk.j$17 r6 = new com.adcolony.sdk.j$17
            r6.<init>()
            java.lang.String r1 = "AdColony.zone_info"
            com.adcolony.sdk.C0476a.m81a(r1, r6)
            com.adcolony.sdk.j$18 r6 = new com.adcolony.sdk.j$18
            r6.<init>()
            java.lang.String r1 = "AdColony.probe_launch_server"
            com.adcolony.sdk.C0476a.m81a(r1, r6)
            com.adcolony.sdk.j$19 r6 = new com.adcolony.sdk.j$19
            r6.<init>()
            java.lang.String r1 = "Crypto.sha1"
            com.adcolony.sdk.C0476a.m81a(r1, r6)
            com.adcolony.sdk.j$20 r6 = new com.adcolony.sdk.j$20
            r6.<init>()
            java.lang.String r1 = "Crypto.crc32"
            com.adcolony.sdk.C0476a.m81a(r1, r6)
            com.adcolony.sdk.j$2 r6 = new com.adcolony.sdk.j$2
            r6.<init>()
            java.lang.String r1 = "Crypto.uuid"
            com.adcolony.sdk.C0476a.m81a(r1, r6)
            com.adcolony.sdk.j$3 r6 = new com.adcolony.sdk.j$3
            r6.<init>()
            java.lang.String r1 = "Device.query_advertiser_info"
            com.adcolony.sdk.C0476a.m81a(r1, r6)
            com.adcolony.sdk.j$4 r6 = new com.adcolony.sdk.j$4
            r6.<init>()
            java.lang.String r1 = "AdColony.controller_version"
            com.adcolony.sdk.C0476a.m81a(r1, r6)
            com.adcolony.sdk.ao r6 = r4.f967o
            int r6 = com.adcolony.sdk.C0543at.m298a(r6)
            if (r6 != r0) goto L_0x01bd
            r1 = 1
            goto L_0x01be
        L_0x01bd:
            r1 = 0
        L_0x01be:
            r4.f948Q = r1
            r1 = 2
            if (r6 != r1) goto L_0x01c4
            r5 = 1
        L_0x01c4:
            r4.f949R = r5
            com.adcolony.sdk.j$5 r5 = new com.adcolony.sdk.j$5
            r5.<init>()
            com.adcolony.sdk.C0543at.m309a(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C0666j.mo8550a(com.adcolony.sdk.AdColonyAppOptions, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: E */
    public void m638E() {
        JSONObject a = C0746u.m892a();
        C0746u.m902a(a, "type", "AdColony.on_configuration_completed");
        JSONArray jSONArray = new JSONArray();
        for (String put : mo8572f().keySet()) {
            jSONArray.put(put);
        }
        JSONObject a2 = C0746u.m892a();
        C0746u.m903a(a2, AdColonyAdapterUtils.KEY_ZONE_IDS, jSONArray);
        C0746u.m904a(a, "message", a2);
        new C0480ab("CustomMessage.controller_send", 0, a).mo8217b();
    }

    /* renamed from: e */
    private boolean m664e(boolean z) {
        return m649a(z, false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo8560b() {
        return this.f939G;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public JSONObject mo8564c() {
        return this.f978z;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m649a(boolean z, boolean z2) {
        if (!C0476a.m86d()) {
            return false;
        }
        this.f947P = z2;
        this.f944M = z;
        if (z && !z2 && !m641H()) {
            return false;
        }
        m639F();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: F */
    public void m639F() {
        new Thread(new Runnable() {
            public void run() {
                JSONObject a = C0746u.m892a();
                C0746u.m902a(a, "url", C0666j.f932e);
                C0746u.m902a(a, Param.CONTENT_TYPE, "application/json");
                C0746u.m902a(a, "content", C0666j.this.mo8579m().mo8619J().toString());
                new C0749a().mo8726a("Launch: ").mo8726a(C0666j.this.mo8579m().mo8619J().toString()).mo8728a(C0748w.f1166b);
                new C0749a().mo8726a("Saving Launch to ").mo8726a(C0666j.this.f967o.mo8318g()).mo8726a(C0666j.f930a).mo8728a(C0748w.f1168d);
                C0666j.this.f961i.mo8670a(new C0703n(new C0480ab("WebServices.post", 0, a), C0666j.this));
            }
        }).start();
    }

    /* renamed from: a */
    private boolean m648a(JSONObject jSONObject) {
        if (!this.f944M) {
            new C0749a().mo8726a("Non-standard launch. Downloading new controller.").mo8728a(C0748w.f1170f);
            return true;
        }
        JSONObject jSONObject2 = this.f978z;
        if (jSONObject2 != null) {
            String str = "controller";
            String str2 = "sha1";
            if (C0746u.m908b(C0746u.m921f(jSONObject2, str), str2).equals(C0746u.m908b(C0746u.m921f(jSONObject, str), str2))) {
                return false;
            }
        }
        new C0749a().mo8726a("Controller sha1 does not match, downloading new controller.").mo8728a(C0748w.f1170f);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m666f(C0480ab abVar) {
        mo8557a(C0746u.m914c(abVar.mo8220c(), "id"));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8556a(boolean z) {
        this.f942K = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m668g(C0480ab abVar) {
        JSONObject jSONObject = this.f974v.f100d;
        C0746u.m902a(jSONObject, "app_id", this.f974v.f97a);
        C0746u.m903a(jSONObject, AdColonyAdapterUtils.KEY_ZONE_IDS, this.f974v.f99c);
        JSONObject a = C0746u.m892a();
        C0746u.m904a(a, "options", jSONObject);
        abVar.mo8216a(a).mo8217b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo8559a(final C0480ab abVar) {
        String str = "id";
        final Context c = C0476a.m85c();
        if (c == null) {
            return false;
        }
        try {
            int c2 = abVar.mo8220c().has(str) ? C0746u.m914c(abVar.mo8220c(), str) : 0;
            if (c2 <= 0) {
                c2 = this.f960h.mo8231d();
            }
            mo8557a(c2);
            final boolean d = C0746u.m918d(abVar.mo8220c(), "is_display_module");
            C0543at.m309a((Runnable) new Runnable() {
                public void run() {
                    C0557av avVar = new C0557av(c.getApplicationContext(), C0666j.this.f960h.mo8231d(), d);
                    avVar.mo8405a(true, abVar);
                    C0666j.this.f934B.put(Integer.valueOf(avVar.mo8236a()), avVar);
                }
            });
            return true;
        } catch (RuntimeException e) {
            C0749a aVar = new C0749a();
            StringBuilder sb = new StringBuilder();
            sb.append(e.toString());
            sb.append(": during WebView initialization.");
            aVar.mo8726a(sb.toString()).mo8726a(" Disabling AdColony.").mo8728a(C0748w.f1171g);
            AdColony.disable();
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8562b(C0480ab abVar) {
        this.f975w = abVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo8565c(C0480ab abVar) {
        this.f977y = abVar;
    }

    /* renamed from: G */
    private void m640G() {
        if (C0476a.m77a().mo8577k().mo8300e()) {
            this.f951T++;
            int i = this.f952U;
            int i2 = this.f951T;
            int i3 = 120;
            if (i * i2 <= 120) {
                i3 = i * i2;
            }
            this.f952U = i3;
            C0543at.m309a((Runnable) new Runnable() {
                public void run() {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            if (C0476a.m77a().mo8577k().mo8300e()) {
                                C0666j.this.m639F();
                            }
                        }
                    }, (long) (C0666j.this.f952U * 1000));
                }
            });
            return;
        }
        new C0749a().mo8726a("Max launch server download attempts hit, or AdColony is no longer").mo8726a(" active.").mo8728a(C0748w.f1170f);
    }

    /* renamed from: a */
    public void mo8554a(C0703n nVar, C0480ab abVar, Map<String, List<String>> map) {
        if (nVar.f1042a.equals(f932e)) {
            if (nVar.f1044c) {
                new C0749a().mo8726a("Launch: ").mo8726a(nVar.f1043b).mo8728a(C0748w.f1166b);
                JSONObject a = C0746u.m894a(nVar.f1043b, "Parsing launch response");
                C0746u.m902a(a, "sdkVersion", mo8579m().mo8615F());
                StringBuilder sb = new StringBuilder();
                sb.append(this.f967o.mo8318g());
                sb.append(f930a);
                C0746u.m923h(a, sb.toString());
                if (!m658c(a)) {
                    if (!this.f944M) {
                        new C0749a().mo8726a("Incomplete or disabled launch server response. ").mo8726a("Disabling AdColony until next launch.").mo8728a(C0748w.f1171g);
                        mo8556a(true);
                    }
                    return;
                }
                if (m648a(a)) {
                    new C0749a().mo8726a("Controller missing or out of date. Downloading controller").mo8728a(C0748w.f1168d);
                    JSONObject a2 = C0746u.m892a();
                    C0746u.m902a(a2, "url", this.f936D);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.f967o.mo8318g());
                    sb2.append(f931b);
                    C0746u.m902a(a2, "filepath", sb2.toString());
                    this.f961i.mo8670a(new C0703n(new C0480ab("WebServices.download", 0, a2), this));
                }
                this.f978z = a;
            } else {
                m640G();
            }
        } else if (nVar.f1042a.equals(this.f936D)) {
            if (!m654b(this.f937E) && !C0557av.f465a) {
                new C0749a().mo8726a("Downloaded controller sha1 does not match, retrying.").mo8728a(C0748w.f1169e);
                m640G();
            } else if (!this.f944M && !this.f947P) {
                C0543at.m309a((Runnable) new Runnable() {
                    public void run() {
                        boolean l = C0666j.this.m641H();
                        C0749a aVar = new C0749a();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Loaded library. Success=");
                        sb.append(l);
                        aVar.mo8726a(sb.toString()).mo8728a(C0748w.f1166b);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: H */
    public boolean m641H() {
        this.f960h.mo8224a();
        return true;
    }

    /* renamed from: b */
    private boolean m654b(String str) {
        Context c = C0476a.m85c();
        if (c != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(c.getFilesDir().getAbsolutePath());
            sb.append("/adc3/");
            sb.append(f931b);
            File file = new File(sb.toString());
            if (file.exists()) {
                return C0543at.m312a(str, file);
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo8558a(Context context, C0480ab abVar) {
        if (context == null) {
            return false;
        }
        Info info = null;
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo(context);
        } catch (NoClassDefFoundError unused) {
            new C0749a().mo8726a("Google Play Services ads dependencies are missing. Collecting ").mo8726a("Android ID instead of Advertising ID.").mo8728a(C0748w.f1169e);
            return false;
        } catch (NoSuchMethodError unused2) {
            new C0749a().mo8726a("Google Play Services is out of date, please update to GPS 4.0+. ").mo8726a("Collecting Android ID instead of Advertising ID.").mo8728a(C0748w.f1169e);
        } catch (Exception e) {
            e.printStackTrace();
            if (Build.MANUFACTURER.equals("Amazon")) {
                return false;
            }
            new C0749a().mo8726a("Advertising ID is not available. Collecting Android ID instead of").mo8726a(" Advertising ID.").mo8728a(C0748w.f1169e);
            return false;
        }
        if (info == null) {
            return false;
        }
        mo8579m().mo8621a(info.getId());
        C0752y.f1195l.f218g.put("advertisingId", mo8579m().mo8627c());
        mo8579m().mo8626b(info.isLimitAdTrackingEnabled());
        mo8579m().mo8623a(true);
        if (abVar != null) {
            JSONObject a = C0746u.m892a();
            C0746u.m902a(a, "advertiser_id", mo8579m().mo8627c());
            C0746u.m913b(a, "limit_ad_tracking", mo8579m().mo8631g());
            abVar.mo8216a(a).mo8217b();
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8549a(AdColonyAppOptions adColonyAppOptions) {
        synchronized (this.f963k.mo8509c()) {
            for (Entry value : this.f963k.mo8509c().entrySet()) {
                AdColonyInterstitial adColonyInterstitial = (AdColonyInterstitial) value.getValue();
                AdColonyInterstitialListener listener = adColonyInterstitial.getListener();
                adColonyInterstitial.mo8130a(true);
                if (listener != null) {
                    listener.onExpiring(adColonyInterstitial);
                }
            }
            this.f963k.mo8509c().clear();
        }
        this.f943L = false;
        mo8557a(1);
        this.f933A.clear();
        this.f974v = adColonyAppOptions;
        this.f960h.mo8224a();
        m649a(true, true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo8557a(int i) {
        C0485ae a = this.f960h.mo8222a(i);
        final C0557av avVar = (C0557av) this.f934B.remove(Integer.valueOf(i));
        boolean z = false;
        if (a == null) {
            return false;
        }
        if (avVar != null && avVar.mo8416l()) {
            z = true;
        }
        C066810 r2 = new Runnable() {
            public void run() {
                C0557av avVar = avVar;
                if (avVar != null && avVar.mo8417m()) {
                    avVar.loadUrl("about:blank");
                    avVar.clearCache(true);
                    avVar.removeAllViews();
                    avVar.mo8404a(true);
                    avVar.destroy();
                }
                if (C0666j.this.f977y != null) {
                    C0666j.this.f977y.mo8217b();
                    C0666j.this.f977y = null;
                    C0666j.this.f976x = false;
                }
            }
        };
        if (z) {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            new Handler().postDelayed(r2, 1000);
        } else {
            r2.run();
        }
        return true;
    }

    /* renamed from: b */
    private void m651b(JSONObject jSONObject) {
        if (!C0557av.f465a) {
            JSONObject f = C0746u.m921f(jSONObject, "logging");
            C0752y.f1194k = C0746u.m888a(f, "send_level", 1);
            C0752y.f1184a = C0746u.m918d(f, "log_private");
            C0752y.f1192i = C0746u.m888a(f, "print_level", 3);
            this.f968p.mo8741a(C0746u.m922g(f, "modules"));
        }
        mo8579m().mo8622a(C0746u.m921f(jSONObject, "metadata"));
        this.f939G = C0746u.m908b(C0746u.m921f(jSONObject, "controller"), "version");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r1 = new java.lang.StringBuilder();
        r1.append(r3.f967o.mo8318g());
        r1.append(f930a);
        new java.io.File(r1.toString()).delete();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0047 */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m658c(org.json.JSONObject r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0014
            com.adcolony.sdk.w$a r4 = new com.adcolony.sdk.w$a
            r4.<init>()
            java.lang.String r1 = "Launch response verification failed - response is null or unknown"
            com.adcolony.sdk.w$a r4 = r4.mo8726a(r1)
            com.adcolony.sdk.w r1 = com.adcolony.sdk.C0748w.f1168d
            r4.mo8728a(r1)
            return r0
        L_0x0014:
            java.lang.String r1 = "controller"
            org.json.JSONObject r1 = com.adcolony.sdk.C0746u.m921f(r4, r1)     // Catch:{ Exception -> 0x0047 }
            java.lang.String r2 = "url"
            java.lang.String r2 = com.adcolony.sdk.C0746u.m908b(r1, r2)     // Catch:{ Exception -> 0x0047 }
            r3.f936D = r2     // Catch:{ Exception -> 0x0047 }
            java.lang.String r2 = "sha1"
            java.lang.String r1 = com.adcolony.sdk.C0746u.m908b(r1, r2)     // Catch:{ Exception -> 0x0047 }
            r3.f937E = r1     // Catch:{ Exception -> 0x0047 }
            java.lang.String r1 = "status"
            java.lang.String r1 = com.adcolony.sdk.C0746u.m908b(r4, r1)     // Catch:{ Exception -> 0x0047 }
            r3.f938F = r1     // Catch:{ Exception -> 0x0047 }
            java.lang.String r1 = "pie"
            java.lang.String r1 = com.adcolony.sdk.C0746u.m908b(r4, r1)     // Catch:{ Exception -> 0x0047 }
            f929H = r1     // Catch:{ Exception -> 0x0047 }
            boolean r1 = com.adcolony.sdk.AdColonyEventTracker.m42b()     // Catch:{ Exception -> 0x0047 }
            if (r1 == 0) goto L_0x0043
            com.adcolony.sdk.AdColonyEventTracker.m38a()     // Catch:{ Exception -> 0x0047 }
        L_0x0043:
            r3.m651b(r4)     // Catch:{ Exception -> 0x0047 }
            goto L_0x0068
        L_0x0047:
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0067 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0067 }
            r1.<init>()     // Catch:{ Exception -> 0x0067 }
            com.adcolony.sdk.ao r2 = r3.f967o     // Catch:{ Exception -> 0x0067 }
            java.lang.String r2 = r2.mo8318g()     // Catch:{ Exception -> 0x0067 }
            r1.append(r2)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r2 = "026ae9c9824b3e483fa6c71fa88f57ae27816141"
            r1.append(r2)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0067 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x0067 }
            r4.delete()     // Catch:{ Exception -> 0x0067 }
            goto L_0x0068
        L_0x0067:
        L_0x0068:
            java.lang.String r4 = r3.f938F
            java.lang.String r1 = "disable"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x00af
            boolean r4 = com.adcolony.sdk.C0557av.f465a
            if (r4 != 0) goto L_0x00af
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0095 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0095 }
            r1.<init>()     // Catch:{ Exception -> 0x0095 }
            com.adcolony.sdk.ao r2 = r3.f967o     // Catch:{ Exception -> 0x0095 }
            java.lang.String r2 = r2.mo8318g()     // Catch:{ Exception -> 0x0095 }
            r1.append(r2)     // Catch:{ Exception -> 0x0095 }
            java.lang.String r2 = "7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5"
            r1.append(r2)     // Catch:{ Exception -> 0x0095 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0095 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x0095 }
            r4.delete()     // Catch:{ Exception -> 0x0095 }
        L_0x0095:
            com.adcolony.sdk.w$a r4 = new com.adcolony.sdk.w$a
            r4.<init>()
            java.lang.String r1 = "Launch server response with disabled status. Disabling AdColony "
            com.adcolony.sdk.w$a r4 = r4.mo8726a(r1)
            java.lang.String r1 = "until next launch."
            com.adcolony.sdk.w$a r4 = r4.mo8726a(r1)
            com.adcolony.sdk.w r1 = com.adcolony.sdk.C0748w.f1170f
            r4.mo8728a(r1)
            com.adcolony.sdk.AdColony.disable()
            return r0
        L_0x00af:
            java.lang.String r4 = r3.f936D
            java.lang.String r1 = ""
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x00c1
            java.lang.String r4 = r3.f938F
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x00dc
        L_0x00c1:
            boolean r4 = com.adcolony.sdk.C0557av.f465a
            if (r4 != 0) goto L_0x00dc
            com.adcolony.sdk.w$a r4 = new com.adcolony.sdk.w$a
            r4.<init>()
            java.lang.String r1 = "Missing controller status or URL. Disabling AdColony until next "
            com.adcolony.sdk.w$a r4 = r4.mo8726a(r1)
            java.lang.String r1 = "launch."
            com.adcolony.sdk.w$a r4 = r4.mo8726a(r1)
            com.adcolony.sdk.w r1 = com.adcolony.sdk.C0748w.f1171g
            r4.mo8728a(r1)
            return r0
        L_0x00dc:
            r4 = 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C0666j.m658c(org.json.JSONObject):boolean");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo8569d(final C0480ab abVar) {
        if (this.f972t == null) {
            return false;
        }
        C0543at.m309a((Runnable) new Runnable() {
            public void run() {
                C0666j.this.f972t.onReward(new AdColonyReward(abVar));
            }
        });
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo8570e(C0480ab abVar) {
        AdColonyZone adColonyZone;
        if (this.f942K) {
            new C0749a().mo8726a("AdColony is disabled. Ignoring zone_info message.").mo8728a(C0748w.f1170f);
            return;
        }
        String b = C0746u.m908b(abVar.mo8220c(), AdColonyAdapterUtils.KEY_ZONE_ID);
        if (this.f933A.containsKey(b)) {
            adColonyZone = (AdColonyZone) this.f933A.get(b);
        } else {
            AdColonyZone adColonyZone2 = new AdColonyZone(b);
            this.f933A.put(b, adColonyZone2);
            adColonyZone = adColonyZone2;
        }
        adColonyZone.mo8190a(abVar);
    }

    /* renamed from: I */
    private void m642I() {
        Application application;
        Context c = C0476a.m85c();
        if (c != null && this.f954W == null && VERSION.SDK_INT > 14) {
            this.f954W = new ActivityLifecycleCallbacks() {
                public void onActivityDestroyed(Activity activity) {
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                public void onActivityStarted(Activity activity) {
                }

                public void onActivityStopped(Activity activity) {
                }

                public void onActivityResumed(Activity activity) {
                    C0476a.f151b = true;
                    C0476a.m78a((Context) activity);
                    Context c = C0476a.m85c();
                    if (c == null || !C0666j.this.f962j.mo8296c() || !(c instanceof C0578b) || ((C0578b) c).f536g) {
                        new C0749a().mo8726a("onActivityResumed() Activity Lifecycle Callback").mo8728a(C0748w.f1168d);
                        C0476a.m78a((Context) activity);
                        if (C0666j.this.f975w != null) {
                            C0666j.this.f975w.mo8216a(C0666j.this.f975w.mo8220c()).mo8217b();
                            C0666j.this.f975w = null;
                        }
                        C0666j.this.f941J = false;
                        C0666j.this.f962j.mo8297d(true);
                        C0666j.this.f962j.mo8299e(true);
                        C0666j.this.f962j.mo8301f(false);
                        if (C0666j.this.f958f && !C0666j.this.f962j.mo8300e()) {
                            C0666j.this.f962j.mo8292a(true);
                        }
                        C0666j.this.f964l.mo8657a();
                        if (C0752y.f1195l == null || C0752y.f1195l.f215d == null || C0752y.f1195l.f215d.isShutdown() || C0752y.f1195l.f215d.isTerminated()) {
                            AdColony.m10a((Context) activity, C0476a.m77a().f974v);
                        }
                        return;
                    }
                    new C0749a().mo8726a("Ignoring onActivityResumed").mo8728a(C0748w.f1168d);
                }

                public void onActivityPaused(Activity activity) {
                    C0476a.f151b = false;
                    C0666j.this.f962j.mo8297d(false);
                    C0666j.this.f962j.mo8299e(true);
                    C0476a.m77a().mo8579m().mo8618I();
                }

                public void onActivityCreated(Activity activity, Bundle bundle) {
                    if (!C0666j.this.f962j.mo8300e()) {
                        C0666j.this.f962j.mo8292a(true);
                    }
                    C0476a.m78a((Context) activity);
                }
            };
            if (c instanceof Application) {
                application = (Application) c;
            } else {
                application = ((Activity) c).getApplication();
            }
            application.registerActivityLifecycleCallbacks(this.f954W);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public AdColonyAppOptions mo8567d() {
        if (this.f974v == null) {
            this.f974v = new AdColonyAppOptions();
        }
        return this.f974v;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public boolean mo8571e() {
        return this.f974v != null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8561b(@NonNull AdColonyAppOptions adColonyAppOptions) {
        this.f974v = adColonyAppOptions;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public HashMap<String, AdColonyZone> mo8572f() {
        return this.f933A;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8563b(boolean z) {
        this.f941J = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public boolean mo8573g() {
        return this.f941J;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public boolean mo8574h() {
        return this.f942K;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public AdColonyRewardListener mo8575i() {
        return this.f972t;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8552a(AdColonyRewardListener adColonyRewardListener) {
        this.f972t = adColonyRewardListener;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public C0722r mo8576j() {
        if (this.f965m == null) {
            this.f965m = new C0722r();
            this.f965m.mo8692a();
        }
        return this.f965m;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public C0498al mo8577k() {
        if (this.f962j == null) {
            this.f962j = new C0498al();
            this.f962j.mo8291a();
        }
        return this.f962j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public C0595d mo8578l() {
        if (this.f963k == null) {
            this.f963k = new C0595d();
            this.f963k.mo8501a();
        }
        return this.f963k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public C0691l mo8579m() {
        if (this.f956c == null) {
            this.f956c = new C0691l();
            this.f956c.mo8629e();
        }
        return this.f956c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public C0511aq mo8580n() {
        if (this.f966n == null) {
            this.f966n = new C0511aq();
            this.f966n.mo8325a();
        }
        return this.f966n;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public C0509ao mo8581o() {
        if (this.f967o == null) {
            this.f967o = new C0509ao();
            this.f967o.mo8312a();
        }
        return this.f967o;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: p */
    public C0486af mo8582p() {
        if (this.f957d == null) {
            this.f957d = new C0486af();
        }
        return this.f957d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public C0481ac mo8583q() {
        if (this.f960h == null) {
            this.f960h = new C0481ac();
            this.f960h.mo8224a();
        }
        return this.f960h;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public C0697m mo8584r() {
        if (this.f964l == null) {
            this.f964l = new C0697m();
        }
        return this.f964l;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: s */
    public C0705o mo8585s() {
        if (this.f961i == null) {
            this.f961i = new C0705o();
        }
        return this.f961i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: t */
    public C0580c mo8586t() {
        return this.f969q;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8553a(C0580c cVar) {
        this.f969q = cVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: u */
    public AdColonyAdView mo8587u() {
        return this.f970r;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8548a(AdColonyAdView adColonyAdView) {
        this.f970r = adColonyAdView;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: v */
    public AdColonyInterstitial mo8588v() {
        return this.f971s;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8551a(AdColonyInterstitial adColonyInterstitial) {
        this.f971s = adColonyInterstitial;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: w */
    public String mo8589w() {
        return this.f935C;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8555a(String str) {
        this.f935C = str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: x */
    public boolean mo8590x() {
        return this.f940I;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo8566c(boolean z) {
        this.f940I = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: y */
    public HashMap<Integer, C0557av> mo8591y() {
        return this.f934B;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: z */
    public boolean mo8592z() {
        return this.f976x;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo8568d(boolean z) {
        this.f976x = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: A */
    public HashMap<String, AdColonyCustomMessageListener> mo8544A() {
        return this.f973u;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: B */
    public boolean mo8545B() {
        return this.f943L;
    }

    /* renamed from: C */
    static String m637C() {
        return f929H;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: D */
    public Partner mo8546D() {
        return this.f955X;
    }
}
