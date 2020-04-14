package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.applovin.impl.mediation.C0997g;
import com.applovin.impl.mediation.C0998h;
import com.applovin.impl.mediation.C1035j;
import com.applovin.impl.mediation.C1041k;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.p006a.C0908a;
import com.applovin.impl.mediation.p014b.C0962e;
import com.applovin.impl.sdk.network.C1211a;
import com.applovin.impl.sdk.network.C1217c;
import com.applovin.impl.sdk.network.C1217c.C1218a;
import com.applovin.impl.sdk.network.C1220e;
import com.applovin.impl.sdk.network.PostbackServiceImpl;
import com.applovin.impl.sdk.p018ad.C1083e;
import com.applovin.impl.sdk.p019b.C1095b;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p019b.C1097d;
import com.applovin.impl.sdk.p019b.C1098e;
import com.applovin.impl.sdk.p019b.C1099f;
import com.applovin.impl.sdk.p020c.C1103c;
import com.applovin.impl.sdk.p020c.C1110f;
import com.applovin.impl.sdk.p020c.C1113g;
import com.applovin.impl.sdk.p020c.C1114h;
import com.applovin.impl.sdk.p020c.C1116j;
import com.applovin.impl.sdk.p021d.C1122a;
import com.applovin.impl.sdk.p021d.C1127ac;
import com.applovin.impl.sdk.p021d.C1146k;
import com.applovin.impl.sdk.p021d.C1159r;
import com.applovin.impl.sdk.p021d.C1159r.C1161a;
import com.applovin.impl.sdk.utils.C1246g;
import com.applovin.impl.sdk.utils.C1280n;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdk.SdkInitializationListener;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinUserService;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.i */
public class C1192i {

    /* renamed from: a */
    protected static Context f2909a;

    /* renamed from: A */
    private C1103c f2910A;

    /* renamed from: B */
    private C1234t f2911B;

    /* renamed from: C */
    private C1061a f2912C;

    /* renamed from: D */
    private C1207n f2913D;

    /* renamed from: E */
    private C1233s f2914E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public C1217c f2915F;

    /* renamed from: G */
    private C1178e f2916G;

    /* renamed from: H */
    private PostbackServiceImpl f2917H;

    /* renamed from: I */
    private C1220e f2918I;

    /* renamed from: J */
    private C0998h f2919J;

    /* renamed from: K */
    private C0997g f2920K;

    /* renamed from: L */
    private MediationServiceImpl f2921L;

    /* renamed from: M */
    private C1041k f2922M;

    /* renamed from: N */
    private C0908a f2923N;

    /* renamed from: O */
    private C1035j f2924O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public final Object f2925P = new Object();
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public boolean f2926Q = false;

    /* renamed from: R */
    private boolean f2927R = false;

    /* renamed from: S */
    private boolean f2928S = false;

    /* renamed from: T */
    private boolean f2929T = false;

    /* renamed from: U */
    private boolean f2930U = false;

    /* renamed from: V */
    private String f2931V = "";

    /* renamed from: W */
    private SdkInitializationListener f2932W;

    /* renamed from: X */
    private SdkInitializationListener f2933X;
    /* access modifiers changed from: private */

    /* renamed from: Y */
    public AppLovinSdkConfiguration f2934Y;

    /* renamed from: b */
    protected C1097d f2935b;

    /* renamed from: c */
    private String f2936c;

    /* renamed from: d */
    private WeakReference<Activity> f2937d;

    /* renamed from: e */
    private long f2938e;

    /* renamed from: f */
    private AppLovinSdkSettings f2939f;

    /* renamed from: g */
    private AppLovinAdServiceImpl f2940g;

    /* renamed from: h */
    private NativeAdServiceImpl f2941h;

    /* renamed from: i */
    private EventServiceImpl f2942i;

    /* renamed from: j */
    private UserServiceImpl f2943j;

    /* renamed from: k */
    private VariableServiceImpl f2944k;

    /* renamed from: l */
    private AppLovinSdk f2945l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public C1227o f2946m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public C1159r f2947n;

    /* renamed from: o */
    private C1211a f2948o;

    /* renamed from: p */
    private C1114h f2949p;

    /* renamed from: q */
    private C1116j f2950q;

    /* renamed from: r */
    private C1196j f2951r;

    /* renamed from: s */
    private C1099f f2952s;

    /* renamed from: t */
    private C1110f f2953t;

    /* renamed from: u */
    private C1186h f2954u;

    /* renamed from: v */
    private C1280n f2955v;

    /* renamed from: w */
    private C1100c f2956w;

    /* renamed from: x */
    private C1228p f2957x;

    /* renamed from: y */
    private C1206m f2958y;

    /* renamed from: z */
    private C1083e f2959z;

    /* renamed from: E */
    public static Context m2558E() {
        return f2909a;
    }

    /* renamed from: af */
    private void m2560af() {
        this.f2915F.mo10334a((C1218a) new C1218a() {
            /* renamed from: a */
            public void mo10256a() {
                C1192i.this.f2946m.mo10380c("AppLovinSdk", "Connected to internet - re-initializing SDK");
                synchronized (C1192i.this.f2925P) {
                    if (!C1192i.this.f2926Q) {
                        C1192i.this.mo10225b();
                    }
                }
                C1192i.this.f2915F.mo10335b(this);
            }

            /* renamed from: b */
            public void mo10257b() {
            }
        });
    }

    /* renamed from: A */
    public C1041k mo10176A() {
        return this.f2922M;
    }

    /* renamed from: B */
    public C1035j mo10177B() {
        return this.f2924O;
    }

    /* renamed from: C */
    public C1097d mo10178C() {
        return this.f2935b;
    }

    /* renamed from: D */
    public Context mo10179D() {
        return f2909a;
    }

    /* renamed from: F */
    public Activity mo10180F() {
        WeakReference<Activity> weakReference = this.f2937d;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    /* renamed from: G */
    public long mo10181G() {
        return this.f2938e;
    }

    /* renamed from: H */
    public boolean mo10182H() {
        return this.f2929T;
    }

    /* renamed from: I */
    public boolean mo10183I() {
        return this.f2930U;
    }

    /* renamed from: J */
    public C1211a mo10184J() {
        return this.f2948o;
    }

    /* renamed from: K */
    public C1159r mo10185K() {
        return this.f2947n;
    }

    /* renamed from: L */
    public C1114h mo10186L() {
        return this.f2949p;
    }

    /* renamed from: M */
    public C1116j mo10187M() {
        return this.f2950q;
    }

    /* renamed from: N */
    public C1220e mo10188N() {
        return this.f2918I;
    }

    /* renamed from: O */
    public C1196j mo10189O() {
        return this.f2951r;
    }

    /* renamed from: P */
    public C1110f mo10190P() {
        return this.f2953t;
    }

    /* renamed from: Q */
    public C1186h mo10191Q() {
        return this.f2954u;
    }

    /* renamed from: R */
    public PostbackServiceImpl mo10192R() {
        return this.f2917H;
    }

    /* renamed from: S */
    public AppLovinSdk mo10193S() {
        return this.f2945l;
    }

    /* renamed from: T */
    public C1100c mo10194T() {
        return this.f2956w;
    }

    /* renamed from: U */
    public C1228p mo10195U() {
        return this.f2957x;
    }

    /* renamed from: V */
    public C1206m mo10196V() {
        return this.f2958y;
    }

    /* renamed from: W */
    public C1083e mo10197W() {
        return this.f2959z;
    }

    /* renamed from: X */
    public C1103c mo10198X() {
        return this.f2910A;
    }

    /* renamed from: Y */
    public C1234t mo10199Y() {
        return this.f2911B;
    }

    /* renamed from: Z */
    public C1207n mo10200Z() {
        return this.f2913D;
    }

    /* renamed from: a */
    public <ST> C1096c<ST> mo10201a(String str, C1096c<ST> cVar) {
        return this.f2935b.mo9950a(str, cVar);
    }

    /* renamed from: a */
    public <T> T mo10202a(C1096c<T> cVar) {
        return this.f2935b.mo9951a(cVar);
    }

    /* renamed from: a */
    public <T> T mo10203a(C1098e<T> eVar) {
        return mo10222b(eVar, null);
    }

    /* renamed from: a */
    public <T> T mo10204a(String str, T t, Class cls, SharedPreferences sharedPreferences) {
        C1099f fVar = this.f2952s;
        return C1099f.m2148a(str, t, cls, sharedPreferences);
    }

    /* renamed from: a */
    public void mo10205a() {
        synchronized (this.f2925P) {
            if (!this.f2926Q && !this.f2927R) {
                mo10225b();
            }
        }
    }

    /* renamed from: a */
    public void mo10206a(long j) {
        this.f2954u.mo10169a(j);
    }

    /* renamed from: a */
    public void mo10207a(SharedPreferences sharedPreferences) {
        this.f2952s.mo9963a(sharedPreferences);
    }

    /* renamed from: a */
    public void mo10208a(C0962e eVar) {
        if (!this.f2947n.mo10134a()) {
            List b = mo10224b((C1096c) C1095b.f2250a);
            if (b.size() > 0 && this.f2920K.mo9545b().containsAll(b)) {
                this.f2946m.mo10378b("AppLovinSdk", "All required adapters initialized");
                this.f2947n.mo10138e();
                mo10231e();
            }
        }
    }

    /* renamed from: a */
    public <T> void mo10209a(C1098e<T> eVar, T t) {
        this.f2952s.mo9965a(eVar, t);
    }

    /* renamed from: a */
    public <T> void mo10210a(C1098e<T> eVar, T t, SharedPreferences sharedPreferences) {
        this.f2952s.mo9966a(eVar, t, sharedPreferences);
    }

    /* renamed from: a */
    public void mo10211a(SdkInitializationListener sdkInitializationListener) {
        if (!mo10230d()) {
            this.f2932W = sdkInitializationListener;
        } else if (sdkInitializationListener != null) {
            sdkInitializationListener.onSdkInitialized(this.f2934Y);
        }
    }

    /* renamed from: a */
    public void mo10212a(AppLovinSdk appLovinSdk) {
        this.f2945l = appLovinSdk;
    }

    /* renamed from: a */
    public void mo10213a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Setting plugin version: ");
        sb.append(str);
        C1227o.m2838f("AppLovinSdk", sb.toString());
        this.f2935b.mo9953a(C1096c.f2522eb, (Object) str);
        this.f2935b.mo9952a();
    }

    /* renamed from: a */
    public void mo10214a(String str, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        C1099f fVar;
        C1098e<String> eVar;
        String bool;
        String str2 = "AppLovinSdk";
        this.f2936c = str;
        this.f2938e = System.currentTimeMillis();
        this.f2939f = appLovinSdkSettings;
        this.f2934Y = new SdkConfigurationImpl(this);
        f2909a = context.getApplicationContext();
        if (context instanceof Activity) {
            this.f2937d = new WeakReference<>((Activity) context);
        }
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            this.f2946m = new C1227o(this);
            this.f2952s = new C1099f(this);
            this.f2935b = new C1097d(this);
            this.f2935b.mo9957b();
            this.f2916G = new C1178e(this);
            this.f2953t = new C1110f(this);
            this.f2953t.mo10032b();
            this.f2958y = new C1206m(this);
            this.f2956w = new C1100c(this);
            this.f2957x = new C1228p(this);
            this.f2959z = new C1083e(this);
            this.f2942i = new EventServiceImpl(this);
            this.f2943j = new UserServiceImpl(this);
            this.f2944k = new VariableServiceImpl(this);
            this.f2910A = new C1103c(this);
            this.f2947n = new C1159r(this);
            this.f2948o = new C1211a(this);
            this.f2949p = new C1114h(this);
            this.f2950q = new C1116j(this);
            this.f2951r = new C1196j(this);
            this.f2912C = new C1061a(context);
            this.f2940g = new AppLovinAdServiceImpl(this);
            this.f2941h = new NativeAdServiceImpl(this);
            this.f2911B = new C1234t(this);
            this.f2913D = new C1207n(this);
            this.f2917H = new PostbackServiceImpl(this);
            this.f2918I = new C1220e(this);
            this.f2919J = new C0998h(this);
            this.f2920K = new C0997g(this);
            this.f2921L = new MediationServiceImpl(this);
            this.f2923N = new C0908a(this);
            this.f2922M = new C1041k();
            this.f2924O = new C1035j(this);
            this.f2954u = new C1186h(this);
            this.f2955v = new C1280n(this);
            this.f2914E = new C1233s(this);
            if (((Boolean) this.f2935b.mo9951a(C1096c.f2449dG)).booleanValue()) {
                this.f2915F = new C1217c(context);
            }
            if (TextUtils.isEmpty(str)) {
                this.f2928S = true;
                C1227o.m2841i(str2, "Unable to find AppLovin SDK key. Please add  meta-data android:name=\"applovin.sdk.key\" android:value=\"YOUR_SDK_KEY_HERE\" into AndroidManifest.xml.");
                StringWriter stringWriter = new StringWriter();
                new Throwable("").printStackTrace(new PrintWriter(stringWriter));
                String stringWriter2 = stringWriter.toString();
                StringBuilder sb = new StringBuilder();
                sb.append("Called with an invalid SDK key from: ");
                sb.append(stringWriter2);
                C1227o.m2841i(str2, sb.toString());
            }
            if (!mo10248u()) {
                if (((Boolean) this.f2935b.mo9951a(C1096c.f2313ab)).booleanValue()) {
                    appLovinSdkSettings.setTestAdsEnabled(C1281o.m3102b(context));
                    appLovinSdkSettings.setVerboseLogging(C1281o.m3106c(context));
                    mo10178C().mo9954a(appLovinSdkSettings);
                    mo10178C().mo9952a();
                }
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                if (TextUtils.isEmpty((String) this.f2952s.mo9970b(C1098e.f2555a, null, defaultSharedPreferences))) {
                    this.f2929T = true;
                    fVar = this.f2952s;
                    eVar = C1098e.f2555a;
                    bool = Boolean.toString(true);
                } else {
                    fVar = this.f2952s;
                    eVar = C1098e.f2555a;
                    bool = Boolean.toString(false);
                }
                fVar.mo9966a(eVar, bool, defaultSharedPreferences);
                if (((Boolean) this.f2952s.mo9969b(C1098e.f2556b, Boolean.valueOf(false))).booleanValue()) {
                    this.f2946m.mo10378b(str2, "Initializing SDK for non-maiden launch");
                    this.f2930U = true;
                } else {
                    this.f2946m.mo10378b(str2, "Initializing SDK for maiden launch");
                    this.f2952s.mo9965a(C1098e.f2556b, Boolean.valueOf(true));
                }
                if (TextUtils.isEmpty((String) mo10203a(C1098e.f2561g))) {
                    mo10209a(C1098e.f2561g, (T) String.valueOf(((int) (Math.random() * 100.0d)) + 1));
                }
                boolean a = C1246g.m2947a(mo10179D());
                if (!((Boolean) this.f2935b.mo9951a(C1096c.f2450dH)).booleanValue() || a) {
                    mo10225b();
                }
                if (((Boolean) this.f2935b.mo9951a(C1096c.f2449dG)).booleanValue() && !a) {
                    this.f2946m.mo10380c(str2, "SDK initialized with no internet connection - listening for connection");
                    m2560af();
                }
            } else {
                mo10216a(false);
            }
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    /* renamed from: a */
    public <T> void mo10215a(String str, T t, Editor editor) {
        this.f2952s.mo9967a(str, t, editor);
    }

    /* renamed from: a */
    public void mo10216a(boolean z) {
        synchronized (this.f2925P) {
            this.f2926Q = false;
            this.f2927R = z;
        }
        List b = mo10224b((C1096c) C1095b.f2250a);
        if (b.isEmpty()) {
            this.f2947n.mo10138e();
            mo10231e();
            return;
        }
        long longValue = ((Long) mo10202a(C1095b.f2251b)).longValue();
        C1127ac acVar = new C1127ac(this, true, new Runnable() {
            public void run() {
                if (!C1192i.this.f2947n.mo10134a()) {
                    C1192i.this.f2946m.mo10378b("AppLovinSdk", "Timing out adapters init...");
                    C1192i.this.f2947n.mo10138e();
                    C1192i.this.mo10231e();
                }
            }
        });
        C1227o oVar = this.f2946m;
        StringBuilder sb = new StringBuilder();
        sb.append("Waiting for required adapters to init: ");
        sb.append(b);
        sb.append(" - timing out in ");
        sb.append(longValue);
        sb.append("ms...");
        oVar.mo10378b("AppLovinSdk", sb.toString());
        this.f2947n.mo10133a((C1122a) acVar, C1161a.MEDIATION_TIMEOUT, longValue, true);
    }

    /* renamed from: aa */
    public C1061a mo10217aa() {
        return this.f2912C;
    }

    /* renamed from: ab */
    public C1233s mo10218ab() {
        return this.f2914E;
    }

    /* renamed from: ac */
    public C1178e mo10219ac() {
        return this.f2916G;
    }

    /* renamed from: ad */
    public AppLovinBroadcastManager mo10220ad() {
        return AppLovinBroadcastManager.getInstance(f2909a);
    }

    /* renamed from: ae */
    public Activity mo10221ae() {
        Activity F = mo10180F();
        if (F != null) {
            return F;
        }
        Activity a = mo10217aa().mo9735a();
        if (a != null) {
            return a;
        }
        return null;
    }

    /* renamed from: b */
    public <T> T mo10222b(C1098e<T> eVar, T t) {
        return this.f2952s.mo9969b(eVar, t);
    }

    /* renamed from: b */
    public <T> T mo10223b(C1098e<T> eVar, T t, SharedPreferences sharedPreferences) {
        return this.f2952s.mo9970b(eVar, t, sharedPreferences);
    }

    /* renamed from: b */
    public List<String> mo10224b(C1096c cVar) {
        return this.f2935b.mo9956b(cVar);
    }

    /* renamed from: b */
    public void mo10225b() {
        synchronized (this.f2925P) {
            this.f2926Q = true;
            mo10185K().mo10137d();
            mo10185K().mo10131a((C1122a) new C1146k(this), C1161a.MAIN);
        }
    }

    /* renamed from: b */
    public <T> void mo10226b(C1098e<T> eVar) {
        this.f2952s.mo9964a(eVar);
    }

    /* renamed from: b */
    public void mo10227b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Setting user id: ");
        sb.append(str);
        C1227o.m2838f("AppLovinSdk", sb.toString());
        this.f2955v.mo10444a(str);
    }

    /* renamed from: c */
    public void mo10228c(String str) {
        mo10209a(C1098e.f2579y, (T) str);
    }

    /* renamed from: c */
    public boolean mo10229c() {
        boolean z;
        synchronized (this.f2925P) {
            z = this.f2926Q;
        }
        return z;
    }

    /* renamed from: d */
    public boolean mo10230d() {
        boolean z;
        synchronized (this.f2925P) {
            z = this.f2927R;
        }
        return z;
    }

    /* renamed from: e */
    public void mo10231e() {
        final SdkInitializationListener sdkInitializationListener = this.f2932W;
        if (sdkInitializationListener != null) {
            if (mo10230d()) {
                this.f2932W = null;
                this.f2933X = null;
            } else if (this.f2933X != sdkInitializationListener) {
                if (((Boolean) mo10202a(C1096c.f2318ag)).booleanValue()) {
                    this.f2932W = null;
                } else {
                    this.f2933X = sdkInitializationListener;
                }
            } else {
                return;
            }
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    C1192i.this.f2946m.mo10378b("AppLovinSdk", "Calling back publisher's initialization completion handler...");
                    sdkInitializationListener.onSdkInitialized(C1192i.this.f2934Y);
                }
            }, Math.max(0, ((Long) mo10202a(C1096c.f2319ah)).longValue()));
        }
    }

    /* renamed from: f */
    public void mo10232f() {
        long b = this.f2949p.mo10039b(C1113g.f2662g);
        this.f2935b.mo9958c();
        this.f2935b.mo9952a();
        this.f2949p.mo10038a();
        this.f2910A.mo9995b();
        this.f2950q.mo10050b();
        this.f2949p.mo10041b(C1113g.f2662g, b + 1);
        mo10225b();
    }

    /* renamed from: g */
    public void mo10233g() {
        this.f2923N.mo9306b();
    }

    /* renamed from: h */
    public boolean mo10234h() {
        return this.f2911B.mo10399d();
    }

    /* renamed from: i */
    public String mo10235i() {
        return this.f2955v.mo10443a();
    }

    /* renamed from: j */
    public String mo10236j() {
        return this.f2955v.mo10445b();
    }

    /* renamed from: k */
    public String mo10237k() {
        return this.f2955v.mo10446c();
    }

    /* renamed from: l */
    public AppLovinSdkSettings mo10238l() {
        return this.f2939f;
    }

    /* renamed from: m */
    public AppLovinSdkConfiguration mo10239m() {
        return this.f2934Y;
    }

    /* renamed from: n */
    public String mo10240n() {
        return (String) mo10203a(C1098e.f2579y);
    }

    /* renamed from: o */
    public AppLovinAdServiceImpl mo10241o() {
        return this.f2940g;
    }

    /* renamed from: p */
    public NativeAdServiceImpl mo10242p() {
        return this.f2941h;
    }

    /* renamed from: q */
    public AppLovinEventService mo10243q() {
        return this.f2942i;
    }

    /* renamed from: r */
    public AppLovinUserService mo10244r() {
        return this.f2943j;
    }

    /* renamed from: s */
    public VariableServiceImpl mo10245s() {
        return this.f2944k;
    }

    /* renamed from: t */
    public String mo10246t() {
        return this.f2936c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CoreSdk{sdkKey='");
        sb.append(this.f2936c);
        sb.append('\'');
        sb.append(", enabled=");
        sb.append(this.f2927R);
        sb.append(", isFirstSession=");
        sb.append(this.f2929T);
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: u */
    public boolean mo10248u() {
        return this.f2928S;
    }

    /* renamed from: v */
    public C1227o mo10249v() {
        return this.f2946m;
    }

    /* renamed from: w */
    public C0998h mo10250w() {
        return this.f2919J;
    }

    /* renamed from: x */
    public C0997g mo10251x() {
        return this.f2920K;
    }

    /* renamed from: y */
    public MediationServiceImpl mo10252y() {
        return this.f2921L;
    }

    /* renamed from: z */
    public C0908a mo10253z() {
        return this.f2923N;
    }
}
