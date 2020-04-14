package com.inmobi.media;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.facebook.share.internal.ShareConstants;
import com.inmobi.ads.rendering.InMobiAdActivity;
import com.inmobi.media.C2319dd.C2323a;
import com.inmobi.media.C2349dv.C2352a;
import com.inmobi.media.C2452f.C2453a;
import com.inmobi.media.C2600j.C2618a;
import com.tapjoy.TJAdUnitConstants.String;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.h */
/* compiled from: NativeAdContainer */
public class C2542h implements ActivityLifecycleCallbacks, C2452f {
    /* access modifiers changed from: private */

    /* renamed from: w */
    public static final String f5574w = "h";

    /* renamed from: A */
    private C2368ec f5575A;

    /* renamed from: B */
    private int f5576B = -1;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public C2542h f5577C;

    /* renamed from: D */
    private C2214bc f5578D = null;

    /* renamed from: E */
    private String f5579E = null;

    /* renamed from: F */
    private C2600j f5580F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public C2542h f5581G;

    /* renamed from: H */
    private C2618a f5582H;

    /* renamed from: I */
    private final C2453a f5583I = new C2453a() {
        /* renamed from: a */
        public final void mo28374a() {
            C2542h.f5574w;
            C2552c h = C2542h.this.mo28497h();
            if (h != null) {
                h.mo28542a();
            }
        }

        /* renamed from: a */
        public final void mo28375a(Object obj) {
            if (C2542h.this.mo28504o() != null) {
                C2552c h = C2542h.this.mo28497h();
                if (h != null) {
                    h.mo28545b();
                }
            }
        }

        /* renamed from: b */
        public final void mo28376b(Object obj) {
            C2552c h = C2542h.this.mo28497h();
            if (h != null) {
                h.mo28549f();
            }
        }
    };

    /* renamed from: J */
    private ExecutorService f5584J;

    /* renamed from: K */
    private Runnable f5585K = new Runnable() {
        public final void run() {
            if (!C2542h.this.f5595j && C2542h.this.getPlacementType() == 0 && C2542h.this.f5586a.f4566c) {
                C2542h.f5574w;
                C2542h.m5457a(C2542h.this);
            }
        }
    };

    /* renamed from: a */
    protected C2220bg f5586a;
    @NonNull

    /* renamed from: b */
    C2426eq f5587b;
    @NonNull

    /* renamed from: c */
    public final String f5588c;

    /* renamed from: d */
    public final long f5589d;

    /* renamed from: e */
    public final String f5590e;

    /* renamed from: f */
    public final boolean f5591f;
    @Nullable

    /* renamed from: g */
    protected Set<C2298cs> f5592g;

    /* renamed from: h */
    protected C2300cu f5593h;

    /* renamed from: i */
    protected boolean f5594i;

    /* renamed from: j */
    public boolean f5595j;

    /* renamed from: k */
    protected boolean f5596k;
    @NonNull

    /* renamed from: l */
    public C2542h f5597l;
    @Nullable

    /* renamed from: m */
    protected C2552c f5598m;
    @NonNull

    /* renamed from: n */
    protected WeakReference<Context> f5599n = new WeakReference<>(null);
    @Nullable

    /* renamed from: o */
    WeakReference<Activity> f5600o;

    /* renamed from: p */
    boolean f5601p = false;

    /* renamed from: q */
    public int f5602q = 0;

    /* renamed from: r */
    public boolean f5603r = false;

    /* renamed from: s */
    Intent f5604s = null;

    /* renamed from: t */
    public C2600j f5605t;

    /* renamed from: u */
    public int f5606u;

    /* renamed from: v */
    public final C2323a f5607v = new C2323a() {
        /* renamed from: a */
        public final void mo28179a(View view, boolean z) {
            C2542h.this.mo28493a(z);
        }
    };

    /* renamed from: x */
    private int f5608x;
    @NonNull

    /* renamed from: y */
    private Set<Integer> f5609y = new HashSet();
    @NonNull

    /* renamed from: z */
    private List<C2214bc> f5610z = new ArrayList();

    /* renamed from: com.inmobi.media.h$a */
    /* compiled from: NativeAdContainer */
    final class C2550a extends Thread {

        /* renamed from: b */
        private WeakReference<C2542h> f5619b;

        C2550a(C2542h hVar) {
            this.f5619b = new WeakReference<>(hVar);
        }

        public final void run() {
            if (C2542h.this.mo28504o() == null) {
                C2542h.f5574w;
                return;
            }
            C2542h hVar = (C2542h) this.f5619b.get();
            if (hVar != null && !hVar.f5595j) {
                try {
                    C2220bg k = hVar.mo28500k();
                    if (C2542h.this.mo28504o() != null) {
                        if (k.f4568e.length() != 0) {
                            C2542h.f5574w;
                            JSONObject b = k.mo27960b();
                            if (b != null) {
                                C2220bg bgVar = new C2220bg(C2542h.this.getPlacementType(), b, k, C2542h.this.getPlacementType() == 0, C2542h.this.getAdConfig());
                                if (bgVar.mo27963d()) {
                                    C2542h a = C2551b.m5532a(C2542h.this.mo28504o(), 0, bgVar, C2542h.this.f5588c, null, C2542h.this.f5587b, C2542h.this.f5589d, C2542h.this.f5591f, C2542h.this.f5590e);
                                    C2542h.f5574w;
                                    a.mo28490a((C2452f) hVar);
                                    a.f5605t = hVar.f5605t;
                                    hVar.f5581G = a;
                                    return;
                                }
                                C2542h.f5574w;
                                return;
                            }
                            return;
                        }
                    }
                    C2542h.f5574w;
                } catch (Exception e) {
                    C2542h.f5574w;
                    C2463fd.m5161a().mo28382a(new C2495fz(e));
                }
            }
        }
    }

    /* renamed from: com.inmobi.media.h$b */
    /* compiled from: NativeAdContainer */
    public static final class C2551b {
        /* renamed from: a */
        public static C2542h m5532a(@NonNull Context context, int i, @NonNull C2220bg bgVar, @NonNull String str, @Nullable Set<C2298cs> set, @NonNull C2426eq eqVar, long j, boolean z, String str2) {
            if (bgVar.mo27964e().contains(ShareConstants.VIDEO_URL)) {
                C2596i iVar = new C2596i(context, i, bgVar, str, set, eqVar, j, z, str2);
                return iVar;
            }
            C2542h hVar = new C2542h(context, i, bgVar, str, set, eqVar, j, z, str2);
            return hVar;
        }
    }

    /* renamed from: com.inmobi.media.h$c */
    /* compiled from: NativeAdContainer */
    public interface C2552c {
        /* renamed from: a */
        void mo28542a();

        /* renamed from: a */
        void mo28543a(Map<String, String> map);

        /* renamed from: a */
        void mo28544a(boolean z);

        /* renamed from: b */
        void mo28545b();

        /* renamed from: c */
        void mo28546c();

        /* renamed from: d */
        void mo28547d();

        /* renamed from: e */
        void mo28548e();

        /* renamed from: f */
        void mo28549f();

        /* renamed from: g */
        void mo28550g();

        /* renamed from: h */
        void mo28551h();

        /* renamed from: i */
        void mo28552i();
    }

    /* renamed from: a */
    public final void mo28357a() {
    }

    public String getMarkupType() {
        return "inmobiJson";
    }

    @Nullable
    public View getVideoContainerView() {
        return null;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public boolean mo28513q() {
        return false;
    }

    C2542h(@NonNull Context context, int i, @NonNull C2220bg bgVar, @NonNull String str, @Nullable Set<C2298cs> set, @NonNull C2426eq eqVar, long j, boolean z, String str2) {
        this.f5608x = i;
        this.f5586a = bgVar;
        this.f5588c = str;
        this.f5589d = j;
        this.f5591f = z;
        this.f5590e = str2;
        mo28490a((C2452f) this);
        this.f5594i = false;
        this.f5595j = false;
        this.f5587b = eqVar;
        if (set != null) {
            this.f5592g = new HashSet(set);
        }
        this.f5586a.f4567d.f4560z = System.currentTimeMillis();
        mo28486a(context);
        this.f5606u = -1;
        this.f5584J = Executors.newSingleThreadExecutor();
        this.f5584J.submit(this.f5585K);
    }

    /* renamed from: d */
    public final void mo28362d() {
        Activity o = mo28504o();
        if (o != null && !this.f5595j) {
            int i = this.f5586a.f4564a;
            if (i == 1) {
                o.setRequestedOrientation(1);
            } else if (i != 2) {
                o.setRequestedOrientation(o.getRequestedOrientation());
            } else {
                o.setRequestedOrientation(0);
            }
        }
    }

    @Nullable
    public C2453a getFullScreenEventsListener() {
        return this.f5583I;
    }

    public int getPlacementType() {
        return this.f5608x;
    }

    /* renamed from: a */
    public final void mo28486a(Context context) {
        this.f5599n = new WeakReference<>(context);
        C2505gd.m5286a(context, (ActivityLifecycleCallbacks) this);
    }

    @Nullable
    /* renamed from: g */
    public final Context mo28496g() {
        return (Context) this.f5599n.get();
    }

    /* renamed from: a */
    public final void mo28359a(String str) {
        Context context = (Context) this.f5599n.get();
        if (context != null && C2513gg.m5338a(str)) {
            InMobiAdActivity.m4211a((C2600j) null);
            InMobiAdActivity.m4210a(mo28520x());
            Intent intent = new Intent(context, InMobiAdActivity.class);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 100);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.IN_APP_BROWSER_URL", str);
            intent.putExtra("placementId", this.f5589d);
            intent.putExtra("creativeId", this.f5590e);
            intent.putExtra("impressionId", this.f5588c);
            intent.putExtra("allowAutoRedirection", this.f5591f);
            C2505gd.m5287a(context, intent);
        }
    }

    /* renamed from: a */
    public final void mo28490a(@NonNull C2452f fVar) {
        if (fVar instanceof C2542h) {
            this.f5597l = (C2542h) fVar;
        }
    }

    @Nullable
    /* renamed from: h */
    public final C2552c mo28497h() {
        return this.f5598m;
    }

    /* renamed from: a */
    public final void mo28491a(@NonNull C2552c cVar) {
        this.f5598m = cVar;
    }

    @Nullable
    /* renamed from: i */
    public final View mo28498i() {
        C2300cu cuVar = this.f5593h;
        if (cuVar == null) {
            return null;
        }
        return cuVar.mo28150b();
    }

    @NonNull
    public C2426eq getAdConfig() {
        return this.f5587b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public final void mo28499j() {
        Map a = mo28484a((C2214bc) this.f5586a.f4567d);
        mo28358a(1, a);
        mo28358a(2, a);
    }

    @SuppressLint({"SwitchIntDef"})
    public C2300cu getViewableAd() {
        String str = "deferred";
        Context m = mo28502m();
        if (this.f5593h == null && m != null) {
            mo28499j();
            this.f5593h = new C2317db(m, this, new C2303cw(this, this.f5605t));
            Set<C2298cs> set = this.f5592g;
            if (set != null) {
                for (C2298cs csVar : set) {
                    try {
                        int i = csVar.f4851a;
                        if (i != 1) {
                            if (i == 3) {
                                C2336dl dlVar = (C2336dl) csVar.f4852b.get("omidAdSession");
                                if (csVar.f4852b.containsKey(str)) {
                                    ((Boolean) csVar.f4852b.get(str)).booleanValue();
                                }
                                if (dlVar != null) {
                                    if (this.f5606u == 0) {
                                        this.f5593h = new C2341dp(this, this.f5593h, dlVar);
                                    } else {
                                        this.f5593h = new C2342dq(this, this.f5593h, dlVar);
                                    }
                                }
                            }
                        } else if (this.f5606u == 0) {
                            this.f5593h = new C2331dh(this, m, this.f5593h, csVar.f4852b);
                        } else {
                            csVar.f4852b.put("zMoatIID", UUID.randomUUID().toString());
                            this.f5593h = new C2332di(m, this.f5593h, this, csVar.f4852b);
                        }
                    } catch (Exception e) {
                        C2463fd.m5161a().mo28382a(new C2495fz(e));
                    }
                }
            }
        }
        return this.f5593h;
    }

    @NonNull
    /* renamed from: k */
    public final C2220bg mo28500k() {
        return this.f5586a;
    }

    /* renamed from: c */
    public final boolean mo28361c() {
        return this.f5595j;
    }

    public void destroy() {
        if (!this.f5595j) {
            this.f5595j = true;
            this.f5576B = -1;
            C2542h hVar = this.f5577C;
            if (hVar != null) {
                hVar.mo28360b();
            }
            this.f5595j = true;
            this.f5598m = null;
            C2368ec C = m5448C();
            if (C != null) {
                C2349dv dvVar = C.f5032b;
                for (C2352a aVar : dvVar.f4981a) {
                    aVar.f4989a.cancel();
                }
                dvVar.f4981a.clear();
                C.mo28241a();
            }
            this.f5575A = null;
            this.f5610z.clear();
            C2300cu cuVar = this.f5593h;
            if (cuVar != null) {
                cuVar.mo28152d();
                this.f5593h.mo28153e();
            }
            m5449D();
            this.f5599n.clear();
            WeakReference<Activity> weakReference = this.f5600o;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.f5586a = null;
            this.f5605t = null;
            C2542h hVar2 = this.f5581G;
            if (hVar2 != null) {
                hVar2.destroy();
                this.f5581G = null;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public boolean mo28501l() {
        return getPlacementType() == 0 && mo28504o() != null;
    }

    @Nullable
    /* renamed from: m */
    public final Context mo28502m() {
        return (1 == getPlacementType() || mo28501l()) ? mo28504o() : (Context) this.f5599n.get();
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public final boolean mo28503n() {
        return this.f5594i;
    }

    /* renamed from: a */
    private C2214bc m5451a(@NonNull C2214bc bcVar, @NonNull C2220bg bgVar, @NonNull String str) {
        if (C2513gg.m5336a((Context) this.f5599n.get(), str)) {
            return bcVar;
        }
        String[] split = str.split("\\|");
        C2214bc b = bgVar.mo27959b(split[0]);
        if (b == null) {
            return m5461b(bgVar.f4569f, bcVar);
        }
        if (b.equals(bcVar)) {
            return null;
        }
        if (1 == split.length || 2 == split.length) {
            b.f4533m = 1;
            return b;
        }
        b.f4533m = C2220bg.m4487a(split[2]);
        return b;
    }

    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m5460b(java.lang.String r6) {
        /*
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r6 = r6.toLowerCase(r0)
            java.lang.String r6 = r6.trim()
            int r0 = r6.hashCode()
            r1 = 5
            r2 = 4
            r3 = 1
            r4 = 3
            r5 = 2
            switch(r0) {
                case -934641255: goto L_0x0053;
                case -934524953: goto L_0x0049;
                case 0: goto L_0x003f;
                case 3127582: goto L_0x0035;
                case 3443508: goto L_0x002b;
                case 3532159: goto L_0x0021;
                case 110066619: goto L_0x0017;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x005d
        L_0x0017:
            java.lang.String r0 = "fullscreen"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x005d
            r6 = 6
            goto L_0x005e
        L_0x0021:
            java.lang.String r0 = "skip"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x005d
            r6 = 2
            goto L_0x005e
        L_0x002b:
            java.lang.String r0 = "play"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x005d
            r6 = 7
            goto L_0x005e
        L_0x0035:
            java.lang.String r0 = "exit"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x005d
            r6 = 5
            goto L_0x005e
        L_0x003f:
            java.lang.String r0 = ""
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x005d
            r6 = 1
            goto L_0x005e
        L_0x0049:
            java.lang.String r0 = "replay"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x005d
            r6 = 4
            goto L_0x005e
        L_0x0053:
            java.lang.String r0 = "reload"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x005d
            r6 = 3
            goto L_0x005e
        L_0x005d:
            r6 = -1
        L_0x005e:
            switch(r6) {
                case 2: goto L_0x0067;
                case 3: goto L_0x0066;
                case 4: goto L_0x0066;
                case 5: goto L_0x0065;
                case 6: goto L_0x0064;
                case 7: goto L_0x0063;
                default: goto L_0x0061;
            }
        L_0x0061:
            r6 = 0
            return r6
        L_0x0063:
            return r1
        L_0x0064:
            return r2
        L_0x0065:
            return r3
        L_0x0066:
            return r4
        L_0x0067:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2542h.m5460b(java.lang.String):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0070, code lost:
        if (com.inmobi.media.C2513gg.m5336a(m5450E(), r2) != false) goto L_0x0072;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo28489a(@androidx.annotation.NonNull com.inmobi.media.C2214bc r6, boolean r7) {
        /*
            r5 = this;
            com.inmobi.media.bg r0 = r5.f5586a
            boolean r0 = r0.f4573j
            if (r0 == 0) goto L_0x009f
            boolean r0 = r5.f5595j
            if (r0 == 0) goto L_0x000b
            return
        L_0x000b:
            com.inmobi.media.bg r0 = r5.f5586a
            com.inmobi.media.bc r0 = r5.m5461b(r0, r6)
            if (r0 == 0) goto L_0x009f
            java.util.Map r1 = r5.mo28484a(r0)
            int r6 = r6.f4529i
            r0.f4529i = r6
            java.lang.String r6 = r0.f4522b
            java.lang.String r2 = "VIDEO"
            boolean r6 = r2.equals(r6)
            if (r6 != 0) goto L_0x0029
            boolean r6 = r0.f4528h
            if (r6 == 0) goto L_0x009f
        L_0x0029:
            int r6 = r0.f4529i
            com.inmobi.media.cu r2 = r5.f5593h
            if (r2 == 0) goto L_0x0033
            r3 = 4
            r2.mo28146a(r3)
        L_0x0033:
            if (r6 != 0) goto L_0x0036
            return
        L_0x0036:
            java.lang.String r2 = r0.f4538r
            r3 = 2
            int r4 = r0.f4533m
            if (r3 != r4) goto L_0x005c
            r3 = r0
            com.inmobi.media.bp r3 = (com.inmobi.media.C2235bp) r3
            com.inmobi.media.cr r3 = r3.mo27982b()
            com.inmobi.media.ck r3 = r3.mo28142f()
            if (r3 == 0) goto L_0x005c
            java.lang.String r4 = r3.f4800e
            if (r4 == 0) goto L_0x005c
            java.lang.String r4 = r3.f4800e
            java.lang.String r4 = r4.trim()
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x005c
            java.lang.String r2 = r3.f4800e
        L_0x005c:
            android.content.Context r3 = r5.m5450E()
            boolean r3 = com.inmobi.media.C2513gg.m5336a(r3, r2)
            if (r3 != 0) goto L_0x0072
            java.lang.String r2 = r0.f4539s
            android.content.Context r3 = r5.m5450E()
            boolean r3 = com.inmobi.media.C2513gg.m5336a(r3, r2)
            if (r3 == 0) goto L_0x009f
        L_0x0072:
            java.lang.String r1 = com.inmobi.media.C2515gi.m5347a(r2, r1)
            boolean r2 = r5.f5603r
            if (r2 == 0) goto L_0x009c
            if (r7 != 0) goto L_0x009c
            com.inmobi.media.h r7 = m5471f(r5)
            if (r7 != 0) goto L_0x0083
            return
        L_0x0083:
            com.inmobi.media.h$c r7 = r7.f5598m
            if (r7 == 0) goto L_0x0097
            r2 = 1
            if (r2 != r6) goto L_0x0094
            boolean r6 = com.inmobi.media.C2513gg.m5338a(r1)
            if (r6 == 0) goto L_0x0094
            r7.mo28546c()
            goto L_0x0097
        L_0x0094:
            r7.mo28550g()
        L_0x0097:
            r5.f5578D = r0
            r5.f5579E = r1
            return
        L_0x009c:
            r5.m5454a(r0, r6, r1)
        L_0x009f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2542h.mo28489a(com.inmobi.media.bc, boolean):void");
    }

    /* renamed from: a */
    public final void mo28485a(int i, C2214bc bcVar) {
        if (!this.f5609y.contains(Integer.valueOf(i)) && !this.f5595j) {
            mo28621z();
            m5453a(i, (C2216be) bcVar);
        }
    }

    public void setFullScreenActivityContext(Activity activity) {
        this.f5600o = new WeakReference<>(activity);
    }

    @Nullable
    /* renamed from: o */
    public final Activity mo28504o() {
        WeakReference<Activity> weakReference = this.f5600o;
        if (weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    /* renamed from: z */
    private void mo28621z() {
        C2216be a = this.f5586a.mo27957a(0);
        if (!this.f5609y.contains(Integer.valueOf(0)) && a != null) {
            m5453a(0, a);
        }
    }

    /* renamed from: a */
    public final Map<String, String> mo28484a(@NonNull C2214bc bcVar) {
        HashMap hashMap = new HashMap(3);
        if (!this.f5595j) {
            C2220bg bgVar = this.f5586a;
            if (bgVar != null) {
                hashMap.put("$LTS", String.valueOf(bgVar.f4567d.f4560z));
                C2216be a = C2220bg.m4493a(bcVar);
                long currentTimeMillis = System.currentTimeMillis();
                if (!(a == null || 0 == a.f4560z)) {
                    currentTimeMillis = a.f4560z;
                }
                hashMap.put("$STS", String.valueOf(currentTimeMillis));
                hashMap.put("$TS", String.valueOf(System.currentTimeMillis()));
                hashMap.putAll(this.f5586a.mo27958a());
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    private static void m5464b(@Nullable C2214bc bcVar, @Nullable Map<String, String> map) {
        if (bcVar != null) {
            bcVar.mo27940a("page_view", map);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28493a(boolean z) {
        if (z) {
            m5446A();
        } else {
            m5447B();
        }
    }

    /* renamed from: b */
    static C2231bn m5462b(View view) {
        if (view != null) {
            return (C2231bn) view.findViewWithTag("timerView");
        }
        return null;
    }

    /* renamed from: c */
    protected static void m5466c(View view) {
        C2231bn b = m5462b(view);
        if (b != null) {
            b.mo27971b();
        }
    }

    /* renamed from: d */
    protected static void m5468d(View view) {
        C2231bn b = m5462b(view);
        if (b != null && b.f4613c != null && !b.f4613c.isRunning()) {
            b.f4613c.setCurrentPlayTime(b.f4612b);
            b.f4613c.start();
        }
    }

    /* renamed from: A */
    private void m5446A() {
        C2368ec C = m5448C();
        if (C != null) {
            C.f5032b.mo28211a();
        }
    }

    /* renamed from: B */
    private void m5447B() {
        C2368ec C = m5448C();
        if (C != null) {
            C.f5032b.mo28213b();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: p */
    public final void mo28512p() {
        C2542h f = m5471f(this);
        if (f != null) {
            C2552c cVar = f.f5598m;
            if (cVar != null) {
                cVar.mo28546c();
            }
            this.f5584J.submit(new Runnable() {
                public final void run() {
                    if (C2542h.this.f5577C == null) {
                        C2542h.m5457a(C2542h.this);
                    }
                    int a = InMobiAdActivity.m4207a((C2452f) C2542h.this.f5577C);
                    Intent intent = new Intent((Context) C2542h.this.f5599n.get(), InMobiAdActivity.class);
                    intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_INDEX", a);
                    intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 102);
                    intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_IS_FULL_SCREEN", true);
                    intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_TYPE", 201);
                    if (C2542h.this.f5603r) {
                        C2542h.this.f5604s = intent;
                    } else {
                        C2505gd.m5287a((Context) C2542h.this.f5599n.get(), intent);
                    }
                }
            });
        }
    }

    /* renamed from: r */
    public final void mo28514r() {
        if (mo28513q()) {
            this.f5601p = true;
            C2552c cVar = this.f5598m;
            if (cVar != null && this.f5586a.f4570g != null) {
                cVar.mo28543a(this.f5586a.f4570g);
            }
        }
    }

    /* renamed from: a */
    private void mo28612a(C2235bp bpVar) {
        C2284ck f = bpVar.mo27982b().mo28142f();
        if (f != null && f.f4801g) {
            for (C2234bo a : f.mo28122a("closeEndCard")) {
                C2235bp.m4470a(a, mo28484a((C2214bc) bpVar));
            }
            f.f4801g = false;
        }
    }

    /* renamed from: f */
    private static C2542h m5471f(@Nullable C2542h hVar) {
        while (hVar != null) {
            if (hVar.mo28504o() == null) {
                C2542h hVar2 = hVar.f5597l;
                if (hVar != hVar2) {
                    hVar = hVar2;
                }
            }
            return hVar;
        }
        return null;
    }

    @Nullable
    /* renamed from: C */
    private C2368ec m5448C() {
        C2365eb ebVar;
        C2300cu cuVar = this.f5593h;
        if (cuVar == null) {
            ebVar = null;
        } else {
            ebVar = (C2365eb) cuVar.mo28145a();
        }
        if (ebVar != null) {
            this.f5575A = ebVar.f5025b;
        }
        return this.f5575A;
    }

    /* renamed from: a */
    private void m5454a(@NonNull C2214bc bcVar, int i, String str) {
        if (1 == i) {
            m5467c(str);
        } else {
            m5459a(str, bcVar.f4539s, bcVar);
        }
    }

    /* renamed from: a */
    private void m5459a(@NonNull String str, @Nullable String str2, @NonNull C2214bc bcVar) {
        if (this.f5599n.get() != null) {
            String a = C2513gg.m5335a((Context) this.f5599n.get(), str, str2);
            if (a != null) {
                C2542h f = m5471f(this);
                if (f != null) {
                    C2552c cVar = f.f5598m;
                    if (cVar != null && !this.f5603r) {
                        cVar.mo28550g();
                    }
                    if (a.equals(str2)) {
                        bcVar.mo27940a("TRACKER_EVENT_TYPE_FALLBACK_URL", mo28484a(bcVar));
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        com.inmobi.media.C2513gg.m5340b(r0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0034 */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5467c(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.ref.WeakReference<android.content.Context> r0 = r3.f5599n
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            android.app.Activity r1 = r3.mo28504o()
            if (r1 != 0) goto L_0x0018
            com.inmobi.media.h$c r1 = r3.f5598m
            if (r1 == 0) goto L_0x0018
            r1.mo28546c()
        L_0x0018:
            java.lang.String r1 = com.inmobi.media.C2361e.m4920a(r0)
            com.inmobi.media.eq r2 = r3.getAdConfig()     // Catch:{ Exception -> 0x0034 }
            boolean r2 = r2.f5178e     // Catch:{ Exception -> 0x0034 }
            if (r1 == 0) goto L_0x0030
            if (r2 != 0) goto L_0x0027
            goto L_0x0030
        L_0x0027:
            com.inmobi.media.bu r1 = new com.inmobi.media.bu     // Catch:{ Exception -> 0x0034 }
            r1.<init>(r4, r0, r3)     // Catch:{ Exception -> 0x0034 }
            r1.mo27988b()     // Catch:{ Exception -> 0x0034 }
            return
        L_0x0030:
            r3.mo28359a(r4)     // Catch:{ Exception -> 0x0034 }
            return
        L_0x0034:
            com.inmobi.media.C2513gg.m5340b(r0, r4)     // Catch:{ URISyntaxException -> 0x0037 }
        L_0x0037:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2542h.m5467c(java.lang.String):void");
    }

    /* renamed from: D */
    private void m5449D() {
        Context context = (Context) this.f5599n.get();
        if (context instanceof Activity) {
            ((Activity) context).getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    public void onActivityStarted(Activity activity) {
        Context E = m5450E();
        if (E != null && E.equals(activity)) {
            mo28515s();
        }
    }

    /* renamed from: s */
    public final void mo28515s() {
        this.f5596k = false;
        m5468d(mo28498i());
        m5446A();
        C2300cu cuVar = this.f5593h;
        if (cuVar != null) {
            cuVar.mo28147a(m5450E(), 0);
        }
    }

    public void onActivityStopped(Activity activity) {
        Context E = m5450E();
        if (E != null && E.equals(activity)) {
            mo28516t();
        }
    }

    /* renamed from: E */
    private Context m5450E() {
        Activity o = mo28504o();
        return o == null ? (Context) this.f5599n.get() : o;
    }

    /* renamed from: t */
    public void mo28516t() {
        this.f5596k = true;
        m5466c(mo28498i());
        m5447B();
        C2300cu cuVar = this.f5593h;
        if (cuVar != null) {
            cuVar.mo28147a(m5450E(), 1);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        C2300cu cuVar = this.f5593h;
        if (cuVar != null) {
            cuVar.mo28147a(activity, 2);
        }
        m5449D();
    }

    /* renamed from: u */
    public final void mo28517u() {
        C2214bc bcVar = this.f5578D;
        if (bcVar == null || this.f5579E == null) {
            if (!(this.f5604s == null || this.f5599n.get() == null)) {
                C2505gd.m5287a((Context) this.f5599n.get(), this.f5604s);
            }
            return;
        }
        m5454a(bcVar, bcVar.f4529i, this.f5579E);
    }

    @Nullable
    /* renamed from: v */
    public final C2600j mo28518v() {
        C2600j jVar = this.f5605t;
        return jVar == null ? this.f5580F : jVar;
    }

    /* renamed from: w */
    public final void mo28519w() {
        new C2550a(this).start();
    }

    @NonNull
    /* renamed from: x */
    public final C2618a mo28520x() {
        if (this.f5582H == null) {
            this.f5582H = new C2618a() {
                /* renamed from: a */
                public final void mo28525a() {
                }

                /* renamed from: a */
                public final void mo28526a(C2600j jVar) {
                }

                /* renamed from: a */
                public final void mo28527a(C2600j jVar, @NonNull HashMap<Object, Object> hashMap) {
                }

                /* renamed from: a */
                public final void mo28528a(String str, Map<String, Object> map) {
                }

                /* renamed from: b */
                public final void mo28529b() {
                }

                /* renamed from: b */
                public final void mo28530b(C2600j jVar) {
                }

                /* renamed from: c */
                public final void mo28533c(C2600j jVar) {
                }

                /* renamed from: d */
                public final void mo28534d(C2600j jVar) {
                }

                /* renamed from: h */
                public final void mo28538h(C2600j jVar) {
                }

                /* renamed from: e */
                public final void mo28535e(C2600j jVar) {
                    C2552c h = C2542h.this.mo28497h();
                    if (h != null) {
                        h.mo28542a();
                    }
                }

                /* renamed from: f */
                public final void mo28536f(C2600j jVar) {
                    C2552c h = C2542h.this.mo28497h();
                    if (h != null) {
                        h.mo28545b();
                    }
                }

                /* renamed from: g */
                public final void mo28537g(C2600j jVar) {
                    C2552c h = C2542h.this.mo28497h();
                    if (h != null) {
                        h.mo28549f();
                    }
                }

                /* renamed from: b */
                public final void mo28531b(C2600j jVar, @NonNull HashMap<Object, Object> hashMap) {
                    C2552c h = C2542h.this.mo28497h();
                    if (h != null) {
                        h.mo28548e();
                    }
                }

                /* renamed from: i */
                public final void mo28539i(C2600j jVar) {
                    C2552c h = C2542h.this.mo28497h();
                    if (h != null) {
                        h.mo28550g();
                    }
                }

                /* renamed from: j */
                public final void mo28540j(C2600j jVar) {
                    C2552c h = C2542h.this.mo28497h();
                    if (h != null && C2542h.this.getPlacementType() == 0) {
                        h.mo28546c();
                    }
                }

                /* renamed from: c */
                public final C2591hu mo28532c() {
                    return C2591hu.m5639b().mo28610a();
                }
            };
        }
        return this.f5582H;
    }

    /* renamed from: a */
    public final void mo28358a(int i, Map<String, String> map) {
        if (!this.f5595j) {
            if (i == 1) {
                this.f5586a.f4567d.mo27940a("load", map);
            } else if (i != 2) {
                if (i != 3) {
                }
            } else {
                this.f5586a.f4567d.mo27940a("client_fill", map);
            }
        }
    }

    /* renamed from: e */
    public final void mo28364e() {
        C2552c cVar = this.f5598m;
        if (cVar != null) {
            cVar.mo28545b();
        }
    }

    /* renamed from: f */
    public final void mo28365f() {
        C2552c cVar = this.f5598m;
        if (cVar != null) {
            cVar.mo28549f();
        }
    }

    /* renamed from: a */
    private void m5453a(int i, @NonNull C2216be beVar) {
        if (!this.f5595j) {
            this.f5609y.add(Integer.valueOf(i));
            beVar.f4560z = System.currentTimeMillis();
            if (this.f5594i) {
                m5464b((C2214bc) beVar, mo28484a((C2214bc) beVar));
            } else {
                this.f5610z.add(beVar);
            }
        }
    }

    @Nullable
    /* renamed from: b */
    private C2214bc m5461b(@Nullable C2220bg bgVar, @NonNull C2214bc bcVar) {
        C2214bc bcVar2 = null;
        if (bgVar == null) {
            return null;
        }
        String str = bcVar.f4538r;
        String str2 = bcVar.f4539s;
        if (str != null) {
            bcVar2 = m5451a(bcVar, bgVar, str);
        }
        if (bcVar2 == null && str2 != null) {
            bcVar2 = m5451a(bcVar, bgVar, str2);
        }
        return bcVar2;
    }

    @Nullable
    /* renamed from: a */
    public static C2214bc m5452a(@Nullable C2220bg bgVar, @NonNull C2214bc bcVar) {
        while (bgVar != null) {
            String str = bcVar.f4530j;
            if (str == null || str.length() == 0) {
                bcVar.f4532l = 0;
                return bcVar;
            }
            String[] split = str.split("\\|");
            if (1 == split.length) {
                bcVar.f4532l = m5460b(split[0]);
                return bcVar;
            }
            C2214bc b = bgVar.mo27959b(split[0]);
            if (b == null) {
                bgVar = bgVar.f4569f;
            } else if (b.equals(bcVar)) {
                return null;
            } else {
                b.f4532l = m5460b(split[1]);
                return b;
            }
        }
        return null;
    }

    /* renamed from: a */
    public final void mo28488a(@Nullable View view, @NonNull C2214bc bcVar) {
        if (!this.f5595j) {
            mo28621z();
            C2214bc b = m5461b(this.f5586a, bcVar);
            if (b != null) {
                Map a = mo28484a(b);
                m5455a(b, a);
                if (!b.equals(bcVar)) {
                    m5455a(bcVar, a);
                }
            } else {
                m5455a(bcVar, mo28484a(bcVar));
            }
            C2542h f = m5471f(this);
            if (f != null) {
                if (!bcVar.f4538r.trim().isEmpty()) {
                    C2552c cVar = f.f5598m;
                    if (cVar != null) {
                        cVar.mo28548e();
                    }
                }
                C2214bc a2 = m5452a(this.f5586a, bcVar);
                if (a2 != null) {
                    if (view != null) {
                        if (ShareConstants.VIDEO_URL.equals(a2.f4522b) && 5 == a2.f4532l) {
                            view.setVisibility(4);
                            bcVar.f4544x = 4;
                        }
                    }
                    mo28494b(a2);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo28487a(View view) {
        if (!this.f5594i && !this.f5595j) {
            this.f5594i = true;
            this.f5586a.f4567d.mo27940a("Impression", mo28484a((C2214bc) this.f5586a.f4567d));
            mo28621z();
            for (C2214bc bcVar : this.f5610z) {
                m5464b(bcVar, mo28484a(bcVar));
            }
            this.f5610z.clear();
            this.f5593h.mo28146a(0);
            C2542h f = m5471f(this);
            if (f != null) {
                C2552c cVar = f.f5598m;
                if (cVar != null) {
                    cVar.mo28547d();
                }
            }
        }
    }

    /* renamed from: a */
    private static void m5455a(@NonNull C2214bc bcVar, @Nullable Map<String, String> map) {
        int i = bcVar.f4533m;
        String str = String.CLICK;
        if (2 == i) {
            C2284ck f = ((C2235bp) bcVar).mo27982b().mo28142f();
            if (f == null || (f.f4800e == null && bcVar.f4538r != null)) {
                bcVar.mo27940a(str, map);
            } else if (f.f4799d.size() > 0) {
                for (C2234bo a : f.mo28122a(str)) {
                    C2214bc.m4470a(a, map);
                }
                return;
            }
            return;
        }
        bcVar.mo27940a(str, map);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo28494b(@NonNull C2214bc bcVar) {
        int i = bcVar.f4532l;
        if (i != 0) {
            String str = "InMobi";
            if (i == 1) {
                try {
                    if (this.f5605t != null) {
                        this.f5605t.mo28633e("window.imraid.broadcastEvent('close');");
                    }
                    mo28360b();
                } catch (Exception e) {
                    C2514gh.m5342a(2, str, "SDK encountered unexpected error in exiting video");
                    C2463fd.m5161a().mo28382a(new C2495fz(e));
                }
            } else if (i == 3) {
                try {
                    if (this.f5605t != null) {
                        this.f5605t.mo28633e("window.imraid.broadcastEvent('replay');");
                    }
                    if (mo28498i() != null) {
                        View i2 = mo28498i();
                        ViewGroup viewGroup = (ViewGroup) i2.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(i2);
                        }
                    }
                    C2542h hVar = this.f5597l;
                    C2231bn b = m5462b(hVar.mo28498i());
                    if (!(b == null || b.f4613c == null || !b.f4613c.isRunning())) {
                        b.f4613c.setCurrentPlayTime(b.f4611a * 1000);
                        b.mo27970a(1.0f);
                    }
                    if (ShareConstants.VIDEO_URL.equals(bcVar.f4522b) && (hVar instanceof C2596i)) {
                        C2403ek ekVar = (C2403ek) hVar.getVideoContainerView();
                        if (ekVar != null) {
                            C2390ej videoView = ekVar.getVideoView();
                            C2235bp bpVar = (C2235bp) videoView.getTag();
                            if (bpVar != null) {
                                if (bpVar.mo27981a()) {
                                    videoView.mo28278e();
                                } else {
                                    videoView.mo28277d();
                                }
                            } else if (1 == getPlacementType()) {
                                videoView.mo28278e();
                            } else {
                                videoView.mo28277d();
                            }
                            mo28612a(bpVar);
                            videoView.start();
                        }
                    }
                } catch (Exception e2) {
                    C2514gh.m5342a(2, str, "SDK encountered unexpected error in replaying video");
                    C2463fd.m5161a().mo28382a(new C2495fz(e2));
                }
            } else if (i != 4) {
                if (i != 5) {
                    this.f5601p = true;
                    C2600j jVar = this.f5605t;
                    if (!(jVar == null || jVar == null)) {
                        jVar.mo28633e("window.imraid.broadcastEvent('skip');");
                    }
                    m5466c(mo28498i());
                    mo28495c(bcVar);
                }
            } else {
                try {
                    if (getPlacementType() == 0) {
                        mo28512p();
                    }
                } catch (Exception e3) {
                    C2514gh.m5342a(2, str, "SDK encountered unexpected error in launching fullscreen ad");
                    C2463fd.m5161a().mo28382a(new C2495fz(e3));
                }
            }
        }
    }

    /* renamed from: b */
    public final void mo28360b() {
        Activity activity;
        try {
            if (!this.f5595j) {
                C2542h f = m5471f(this);
                if (f != null) {
                    f.mo28514r();
                    InMobiAdActivity.m4212a((Object) f);
                    if (f instanceof C2596i) {
                        C2403ek ekVar = (C2403ek) ((C2596i) f).getVideoContainerView();
                        if (ekVar != null) {
                            C2390ej videoView = ekVar.getVideoView();
                            C2235bp bpVar = (C2235bp) videoView.getTag();
                            bpVar.f4542v.put("seekPosition", Integer.valueOf(videoView.getCurrentPosition()));
                            bpVar.f4542v.put("lastMediaVolume", Integer.valueOf(videoView.getVolume()));
                            if (bpVar.f4545y != null) {
                                ((C2235bp) bpVar.f4545y).mo27980a(bpVar);
                            }
                            mo28612a(bpVar);
                        }
                    }
                    if (f.f5600o == null) {
                        activity = null;
                    } else {
                        activity = (Activity) f.f5600o.get();
                    }
                    if (activity instanceof InMobiAdActivity) {
                        ((InMobiAdActivity) activity).f4258a = true;
                        activity.finish();
                        if (this.f5576B != -1) {
                            activity.overridePendingTransition(0, this.f5576B);
                        }
                    }
                    this.f5597l.f5577C = null;
                    this.f5597l.f5584J.submit(this.f5585K);
                }
            }
        } catch (Exception e) {
            C2514gh.m5342a(2, "InMobi", "SDK encountered unexpected error in exiting video");
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        }
    }

    /* renamed from: a */
    public final void mo28492a(C2600j jVar) {
        if (this.f5606u == 0 && this.f5580F == null && this.f5605t == null) {
            this.f5580F = jVar;
        }
    }

    @UiThread
    /* renamed from: c */
    public final void mo28495c(@Nullable C2214bc bcVar) {
        C2542h hVar = this.f5581G;
        if (hVar == null || mo28498i() == null) {
            C2514gh.m5342a(2, "InMobi", "Failed to show end card");
            mo28360b();
        } else {
            try {
                ViewGroup viewGroup = (ViewGroup) mo28498i();
                View a = hVar.getViewableAd().mo28144a(null, viewGroup, false);
                if (a != null) {
                    viewGroup.addView(a);
                    a.setClickable(true);
                    hVar.m5446A();
                    if (bcVar instanceof C2235bp) {
                        C2284ck f = ((C2235bp) bcVar).mo27982b().mo28142f();
                        if (f != null) {
                            f.f4801g = true;
                        }
                    }
                } else {
                    mo28360b();
                }
            } catch (Exception e) {
                mo28360b();
                C2463fd.m5161a().mo28382a(new C2495fz(e));
            }
        }
    }

    @NonNull
    public /* bridge */ /* synthetic */ Object getDataModel() {
        return this.f5586a;
    }

    /* renamed from: a */
    static /* synthetic */ void m5457a(C2542h hVar) {
        C2542h hVar2 = hVar;
        C2220bg bgVar = hVar2.f5586a;
        if (bgVar.f4568e.length() != 0) {
            JSONObject b = bgVar.mo27960b();
            if (b != null) {
                C2220bg bgVar2 = new C2220bg(hVar.getPlacementType(), b, bgVar, hVar.getPlacementType() == 0, hVar.getAdConfig());
                bgVar2.f4566c = bgVar.f4566c;
                bgVar2.f4573j = bgVar.f4573j;
                Context context = (Context) hVar2.f5599n.get();
                if (bgVar2.mo27963d() && context != null) {
                    hVar2.f5577C = C2551b.m5532a(context, 0, bgVar2, hVar2.f5588c, hVar2.f5592g, hVar2.f5587b, hVar2.f5589d, hVar2.f5591f, hVar2.f5590e);
                    hVar2.f5577C.mo28490a((C2452f) hVar2);
                    C2552c cVar = hVar2.f5598m;
                    if (cVar != null) {
                        hVar2.f5577C.f5598m = cVar;
                    }
                    if (bgVar.f4566c) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public final void run() {
                                C2542h.this.f5577C.getViewableAd().mo28144a(null, new RelativeLayout(C2542h.this.mo28502m()), false);
                            }
                        });
                    }
                }
            }
        }
    }
}
