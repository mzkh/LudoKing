package com.inmobi.ads.rendering;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.facebook.internal.NativeProtocol;
import com.inmobi.media.C2220bg;
import com.inmobi.media.C2235bp;
import com.inmobi.media.C2242bv;
import com.inmobi.media.C2300cu;
import com.inmobi.media.C2390ej;
import com.inmobi.media.C2403ek;
import com.inmobi.media.C2426eq;
import com.inmobi.media.C2436er;
import com.inmobi.media.C2452f;
import com.inmobi.media.C2463fd;
import com.inmobi.media.C2495fz;
import com.inmobi.media.C2505gd;
import com.inmobi.media.C2507gf;
import com.inmobi.media.C2514gh;
import com.inmobi.media.C2528gq;
import com.inmobi.media.C2542h;
import com.inmobi.media.C2596i;
import com.inmobi.media.C2600j;
import com.inmobi.media.C2600j.C2618a;
import com.tapjoy.TJAdUnitConstants.String;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"ClickableViewAccessibility"})
public class InMobiAdActivity extends Activity {
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: b */
    public static Map<Integer, C2136a> f4249b = new HashMap();
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: c */
    public static Map<Integer, Intent> f4250c = new HashMap();

    /* renamed from: d */
    public static Integer f4251d = null;
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: e */
    public static Map<Integer, Object> f4252e = new HashMap();

    /* renamed from: f */
    public static Integer f4253f = null;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final String f4254g = "InMobiAdActivity";

    /* renamed from: h */
    private static SparseArray<C2452f> f4255h = new SparseArray<>();

    /* renamed from: i */
    private static C2600j f4256i;

    /* renamed from: j */
    private static C2618a f4257j;

    /* renamed from: a */
    public boolean f4258a = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C2452f f4259k;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: l */
    public C2600j f4260l;

    /* renamed from: m */
    private C2242bv f4261m;

    /* renamed from: n */
    private C2242bv f4262n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C2390ej f4263o;

    /* renamed from: p */
    private int f4264p;

    /* renamed from: q */
    private int f4265q;

    /* renamed from: r */
    private boolean f4266r = false;

    /* renamed from: s */
    private boolean f4267s = false;

    /* renamed from: com.inmobi.ads.rendering.InMobiAdActivity$a */
    public interface C2136a {
    }

    static {
        Integer valueOf = Integer.valueOf(0);
        f4251d = valueOf;
        f4253f = valueOf;
    }

    /* renamed from: a */
    public static int m4207a(C2452f fVar) {
        int hashCode = fVar.hashCode();
        f4255h.put(hashCode, fVar);
        return hashCode;
    }

    /* renamed from: a */
    public static void m4212a(@NonNull Object obj) {
        f4255h.remove(obj.hashCode());
    }

    /* renamed from: a */
    public static void m4211a(C2600j jVar) {
        f4256i = jVar;
    }

    /* renamed from: a */
    public static void m4210a(C2618a aVar) {
        f4257j = aVar;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!this.f4258a) {
            int i = this.f4264p;
            if (100 == i) {
                C2600j jVar = this.f4260l;
                if (!(jVar == null || jVar.getFullScreenEventsListener() == null)) {
                    try {
                        if (!this.f4266r) {
                            this.f4266r = true;
                            this.f4260l.getFullScreenEventsListener().mo28375a(this.f4260l);
                        }
                    } catch (Exception unused) {
                    }
                }
            } else if (this.f4265q == 200 && 102 == i) {
                C2452f fVar = this.f4259k;
                if (!(fVar == null || fVar.getFullScreenEventsListener() == null)) {
                    if (!this.f4266r) {
                        this.f4266r = true;
                        this.f4259k.getFullScreenEventsListener().mo28375a(null);
                    }
                }
            } else if (201 == this.f4265q) {
                if (this.f4259k instanceof C2596i) {
                    C2390ej ejVar = this.f4263o;
                    if (ejVar != null) {
                        final C2235bp bpVar = (C2235bp) ejVar.getTag();
                        if (bpVar != null && this.f4267s) {
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                                public final void run() {
                                    if (InMobiAdActivity.this.f4259k == null) {
                                        return;
                                    }
                                    if (InMobiAdActivity.this.f4259k.getPlacementType() != 1 || !((Boolean) bpVar.f4542v.get("didCompleteQ4")).booleanValue()) {
                                        InMobiAdActivity.this.f4263o.start();
                                    }
                                }
                            }, 50);
                        }
                        if (this.f4259k.getFullScreenEventsListener() != null) {
                            try {
                                if (!this.f4266r) {
                                    this.f4266r = true;
                                    this.f4259k.getFullScreenEventsListener().mo28375a(bpVar);
                                }
                            } catch (Exception e) {
                                C2463fd.m5161a().mo28382a(new C2495fz(e));
                            }
                        }
                    }
                }
                C2452f fVar2 = this.f4259k;
                if (fVar2 instanceof C2542h) {
                    try {
                        if (!this.f4266r) {
                            this.f4266r = true;
                            fVar2.getFullScreenEventsListener().mo28375a(null);
                        }
                    } catch (Exception e2) {
                        C2463fd.m5161a().mo28382a(new C2495fz(e2));
                    }
                }
            }
            this.f4267s = false;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:38|39|(1:41)) */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009b, code lost:
        if (r7.f4259k.getFullScreenEventsListener() != null) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009d, code lost:
        r7.f4259k.getFullScreenEventsListener().mo28374a();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x0095 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStart() {
        /*
            r7 = this;
            java.lang.String r0 = "time"
            super.onStart()
            boolean r1 = r7.f4258a
            if (r1 != 0) goto L_0x00c5
            r1 = 102(0x66, float:1.43E-43)
            int r2 = r7.f4264p
            if (r1 != r2) goto L_0x00c5
            com.inmobi.media.f r1 = r7.f4259k
            if (r1 == 0) goto L_0x00c5
            com.inmobi.media.cu r1 = r1.getViewableAd()
            r2 = 200(0xc8, float:2.8E-43)
            int r3 = r7.f4265q
            r4 = 0
            if (r2 != r3) goto L_0x0049
            com.inmobi.media.f r0 = r7.f4259k
            int r0 = r0.getPlacementType()
            r2 = 1
            if (r2 != r0) goto L_0x00c5
            r0 = 2
            android.view.View[] r0 = new android.view.View[r0]     // Catch:{ Exception -> 0x0036 }
            com.inmobi.media.bv r3 = r7.f4261m     // Catch:{ Exception -> 0x0036 }
            r0[r4] = r3     // Catch:{ Exception -> 0x0036 }
            com.inmobi.media.bv r3 = r7.f4262n     // Catch:{ Exception -> 0x0036 }
            r0[r2] = r3     // Catch:{ Exception -> 0x0036 }
            r1.mo28149a(r0)     // Catch:{ Exception -> 0x0036 }
            return
        L_0x0036:
            com.inmobi.media.f r0 = r7.f4259k
            com.inmobi.media.f$a r0 = r0.getFullScreenEventsListener()
            if (r0 == 0) goto L_0x0048
            com.inmobi.media.f r0 = r7.f4259k
            com.inmobi.media.f$a r0 = r0.getFullScreenEventsListener()
            r0.mo28374a()
        L_0x0048:
            return
        L_0x0049:
            r2 = 201(0xc9, float:2.82E-43)
            if (r2 != r3) goto L_0x00c5
            com.inmobi.media.f r2 = r7.f4259k     // Catch:{ Exception -> 0x00a7 }
            com.inmobi.media.eq r2 = r2.getAdConfig()     // Catch:{ Exception -> 0x00a7 }
            android.view.View r3 = r1.mo28150b()     // Catch:{ Exception -> 0x00a7 }
            if (r3 == 0) goto L_0x00a6
            com.inmobi.media.f r3 = r7.f4259k     // Catch:{ Exception -> 0x00a7 }
            boolean r3 = r3 instanceof com.inmobi.media.C2596i     // Catch:{ Exception -> 0x00a7 }
            if (r3 == 0) goto L_0x0089
            com.inmobi.media.ej r3 = r7.f4263o     // Catch:{ Exception -> 0x00a7 }
            java.lang.Object r3 = r3.getTag()     // Catch:{ Exception -> 0x00a7 }
            com.inmobi.media.bp r3 = (com.inmobi.media.C2235bp) r3     // Catch:{ Exception -> 0x00a7 }
            if (r3 == 0) goto L_0x0088
            com.inmobi.media.eq$i r2 = r2.f5182i     // Catch:{ Exception -> 0x00a7 }
            int r5 = r2.f5237g     // Catch:{ Exception -> 0x00a7 }
            java.util.Map<java.lang.String, java.lang.Object> r6 = r3.f4640G     // Catch:{ Exception -> 0x00a7 }
            boolean r6 = r6.containsKey(r0)     // Catch:{ Exception -> 0x00a7 }
            if (r6 == 0) goto L_0x0081
            java.util.Map<java.lang.String, java.lang.Object> r3 = r3.f4640G     // Catch:{ Exception -> 0x00a7 }
            java.lang.Object r0 = r3.get(r0)     // Catch:{ Exception -> 0x00a7 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x00a7 }
            int r5 = r0.intValue()     // Catch:{ Exception -> 0x00a7 }
        L_0x0081:
            r2.f5237g = r5     // Catch:{ Exception -> 0x00a7 }
            android.view.View[] r0 = new android.view.View[r4]     // Catch:{ Exception -> 0x00a7 }
            r1.mo28149a(r0)     // Catch:{ Exception -> 0x00a7 }
        L_0x0088:
            return
        L_0x0089:
            com.inmobi.media.f r0 = r7.f4259k     // Catch:{ Exception -> 0x00a7 }
            boolean r0 = r0 instanceof com.inmobi.media.C2542h     // Catch:{ Exception -> 0x00a7 }
            if (r0 == 0) goto L_0x00a6
            android.view.View[] r0 = new android.view.View[r4]     // Catch:{ Exception -> 0x0095 }
            r1.mo28149a(r0)     // Catch:{ Exception -> 0x0095 }
            return
        L_0x0095:
            com.inmobi.media.f r0 = r7.f4259k     // Catch:{ Exception -> 0x00a7 }
            com.inmobi.media.f$a r0 = r0.getFullScreenEventsListener()     // Catch:{ Exception -> 0x00a7 }
            if (r0 == 0) goto L_0x00a6
            com.inmobi.media.f r0 = r7.f4259k     // Catch:{ Exception -> 0x00a7 }
            com.inmobi.media.f$a r0 = r0.getFullScreenEventsListener()     // Catch:{ Exception -> 0x00a7 }
            r0.mo28374a()     // Catch:{ Exception -> 0x00a7 }
        L_0x00a6:
            return
        L_0x00a7:
            r0 = move-exception
            com.inmobi.media.f r1 = r7.f4259k
            com.inmobi.media.f$a r1 = r1.getFullScreenEventsListener()
            if (r1 == 0) goto L_0x00b9
            com.inmobi.media.f r1 = r7.f4259k
            com.inmobi.media.f$a r1 = r1.getFullScreenEventsListener()
            r1.mo28374a()
        L_0x00b9:
            com.inmobi.media.fd r1 = com.inmobi.media.C2463fd.m5161a()
            com.inmobi.media.fz r2 = new com.inmobi.media.fz
            r2.<init>(r0)
            r1.mo28382a(r2)
        L_0x00c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.rendering.InMobiAdActivity.onStart():void");
    }

    /* access modifiers changed from: protected */
    @TargetApi(23)
    public void onCreate(Bundle bundle) {
        C2426eq eqVar;
        super.onCreate(bundle);
        if (!C2505gd.m5292a()) {
            finish();
            C2514gh.m5342a(2, "InMobi", "Session not found, AdActivity will be closed");
            return;
        }
        this.f4266r = false;
        if (VERSION.SDK_INT >= 29) {
            C2528gq.m5394a((Context) this);
        }
        this.f4264p = getIntent().getIntExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 102);
        int i = this.f4264p;
        if (i == 100) {
            String stringExtra = getIntent().getStringExtra("com.inmobi.ads.rendering.InMobiAdActivity.IN_APP_BROWSER_URL");
            long longExtra = getIntent().getLongExtra("placementId", Long.MIN_VALUE);
            boolean booleanExtra = getIntent().getBooleanExtra("allowAutoRedirection", false);
            String stringExtra2 = getIntent().getStringExtra("impressionId");
            String stringExtra3 = getIntent().getStringExtra("creativeId");
            C2618a aVar = C2600j.f5757a;
            C2600j jVar = f4256i;
            if (jVar != null) {
                aVar = jVar.getListener();
                eqVar = f4256i.getAdConfig();
            } else {
                eqVar = (C2426eq) C2436er.m5081a("ads", C2505gd.m5306f());
                C2618a aVar2 = f4257j;
                if (aVar2 != null) {
                    aVar = aVar2;
                }
            }
            try {
                this.f4260l = new C2600j(this, 1, null, stringExtra2);
                this.f4260l.setPlacementId(longExtra);
                this.f4260l.setCreativeId(stringExtra3);
                this.f4260l.setAllowAutoRedirection(booleanExtra);
                this.f4260l.setShouldFireRenderBeacon(false);
                this.f4260l.setIsInAppBrowser(true);
                this.f4260l.mo28623a(aVar, eqVar, false, false);
                RelativeLayout relativeLayout = new RelativeLayout(this);
                LayoutParams layoutParams = new LayoutParams(-1, -1);
                layoutParams.addRule(10);
                layoutParams.addRule(2, 65533);
                relativeLayout.setBackgroundColor(-1);
                relativeLayout.addView(this.f4260l, layoutParams);
                float f = C2528gq.m5393a().f5543c;
                LinearLayout linearLayout = new LinearLayout(this);
                LayoutParams layoutParams2 = new LayoutParams(-1, (int) (48.0f * f));
                linearLayout.setOrientation(0);
                linearLayout.setId(65533);
                linearLayout.setWeightSum(100.0f);
                linearLayout.setBackgroundResource(17301658);
                linearLayout.setBackgroundColor(-7829368);
                layoutParams2.addRule(12);
                relativeLayout.addView(linearLayout, layoutParams2);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
                layoutParams3.weight = 25.0f;
                C2242bv bvVar = new C2242bv(this, f, 2);
                bvVar.setOnTouchListener(new OnTouchListener() {
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 1) {
                            view.setBackgroundColor(-7829368);
                            InMobiAdActivity.this.f4258a = true;
                            InMobiAdActivity.this.finish();
                            return true;
                        }
                        if (motionEvent.getAction() == 0) {
                            view.setBackgroundColor(-16711681);
                        }
                        return true;
                    }
                });
                linearLayout.addView(bvVar, layoutParams3);
                C2242bv bvVar2 = new C2242bv(this, f, 3);
                bvVar2.setOnTouchListener(new OnTouchListener() {
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 1) {
                            view.setBackgroundColor(-7829368);
                            InMobiAdActivity.this.f4260l.reload();
                            return true;
                        }
                        if (motionEvent.getAction() == 0) {
                            view.setBackgroundColor(-16711681);
                        }
                        return true;
                    }
                });
                linearLayout.addView(bvVar2, layoutParams3);
                C2242bv bvVar3 = new C2242bv(this, f, 4);
                bvVar3.setOnTouchListener(new OnTouchListener() {
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 1) {
                            view.setBackgroundColor(-7829368);
                            if (InMobiAdActivity.this.f4260l.canGoBack()) {
                                InMobiAdActivity.this.f4260l.goBack();
                            } else {
                                InMobiAdActivity.this.f4258a = true;
                                InMobiAdActivity.this.finish();
                            }
                            return true;
                        }
                        if (motionEvent.getAction() == 0) {
                            view.setBackgroundColor(-16711681);
                        }
                        return true;
                    }
                });
                linearLayout.addView(bvVar3, layoutParams3);
                C2242bv bvVar4 = new C2242bv(this, f, 6);
                bvVar4.setOnTouchListener(new OnTouchListener() {
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 1) {
                            view.setBackgroundColor(-7829368);
                            if (InMobiAdActivity.this.f4260l.canGoForward()) {
                                InMobiAdActivity.this.f4260l.goForward();
                            }
                            return true;
                        }
                        if (motionEvent.getAction() == 0) {
                            view.setBackgroundColor(-16711681);
                        }
                        return true;
                    }
                });
                linearLayout.addView(bvVar4, layoutParams3);
                setContentView(relativeLayout);
                this.f4260l.loadUrl(stringExtra);
                this.f4260l.setFullScreenActivityContext(this);
            } catch (Exception e) {
                C2463fd.m5161a().mo28382a(new C2495fz(e));
                aVar.mo28535e(null);
                finish();
            }
        } else {
            if (i == 102) {
                String str = "com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_INDEX";
                if (getIntent().hasExtra(str)) {
                    this.f4259k = (C2452f) f4255h.get(getIntent().getIntExtra(str, -1));
                    if (this.f4259k == null) {
                        finish();
                        return;
                    }
                    this.f4265q = getIntent().getIntExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_TYPE", 0);
                    if (this.f4265q == 0) {
                        if (this.f4259k.getFullScreenEventsListener() != null) {
                            this.f4259k.getFullScreenEventsListener().mo28374a();
                        }
                        finish();
                        return;
                    }
                    if (getIntent().getBooleanExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_IS_FULL_SCREEN", false)) {
                        requestWindowFeature(1);
                        getWindow().setFlags(1024, 1024);
                    }
                    int i2 = this.f4265q;
                    String str2 = String.HTML;
                    if (200 != i2 || str2.equals(this.f4259k.getMarkupType())) {
                        String str3 = "inmobiJson";
                        if (201 != this.f4265q || str3.equals(this.f4259k.getMarkupType())) {
                            try {
                                this.f4259k.setFullScreenActivityContext(this);
                                FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
                                RelativeLayout relativeLayout2 = new RelativeLayout(getApplicationContext());
                                relativeLayout2.setId(65534);
                                float f2 = C2528gq.m5393a().f5543c;
                                if (str2.equals(this.f4259k.getMarkupType())) {
                                    relativeLayout2.setBackgroundColor(0);
                                    LayoutParams layoutParams4 = new LayoutParams(-1, -1);
                                    layoutParams4.addRule(10);
                                    int i3 = (int) (50.0f * f2);
                                    LayoutParams layoutParams5 = new LayoutParams(i3, i3);
                                    layoutParams5.addRule(11);
                                    this.f4261m = new C2242bv(this, f2, 0);
                                    this.f4261m.setId(65532);
                                    this.f4261m.setOnClickListener(new OnClickListener() {
                                        public final void onClick(View view) {
                                            InMobiAdActivity.this.f4258a = true;
                                            try {
                                                InMobiAdActivity.this.f4259k.mo28360b();
                                            } catch (Exception unused) {
                                                InMobiAdActivity.f4254g;
                                                C2514gh.m5342a(2, "InMobi", "SDK encountered unexpected error in processing close request");
                                            }
                                        }
                                    });
                                    this.f4262n = new C2242bv(this, f2, 1);
                                    this.f4262n.setId(65531);
                                    this.f4262n.setOnClickListener(new OnClickListener() {
                                        public final void onClick(View view) {
                                            InMobiAdActivity.this.f4258a = true;
                                            try {
                                                InMobiAdActivity.this.f4259k.mo28360b();
                                            } catch (Exception unused) {
                                                InMobiAdActivity.f4254g;
                                                C2514gh.m5342a(2, "InMobi", "SDK encountered unexpected error in processing close request");
                                            }
                                        }
                                    });
                                    View c = this.f4259k.getViewableAd().mo28151c();
                                    if (c != null) {
                                        ViewGroup viewGroup = (ViewGroup) c.getParent();
                                        if (viewGroup != null) {
                                            viewGroup.removeView(c);
                                        }
                                        relativeLayout2.addView(c, layoutParams4);
                                        relativeLayout2.addView(this.f4261m, layoutParams5);
                                        relativeLayout2.addView(this.f4262n, layoutParams5);
                                        ((C2600j) this.f4259k).mo28626a(((C2600j) this.f4259k).f5808n);
                                        ((C2600j) this.f4259k).mo28629b(((C2600j) this.f4259k).f5805k);
                                    }
                                } else if (str3.equals(this.f4259k.getMarkupType())) {
                                    int placementType = this.f4259k.getPlacementType();
                                    relativeLayout2.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                                    C2220bg bgVar = (C2220bg) this.f4259k.getDataModel();
                                    Point point = bgVar.f4567d.f4523c.f4546a;
                                    C2300cu viewableAd = this.f4259k.getViewableAd();
                                    View b = bgVar.f4566c ? viewableAd.mo28150b() : null;
                                    if (b == null) {
                                        b = viewableAd.mo28144a(null, relativeLayout2, false);
                                    }
                                    if (this.f4259k instanceof C2596i) {
                                        C2403ek ekVar = (C2403ek) this.f4259k.getVideoContainerView();
                                        if (ekVar != null) {
                                            this.f4263o = ekVar.getVideoView();
                                            this.f4263o.requestFocus();
                                            C2235bp bpVar = (C2235bp) this.f4263o.getTag();
                                            if (bpVar.f4545y != null) {
                                                bpVar.mo27980a((C2235bp) bpVar.f4545y);
                                            }
                                            String str4 = "placementType";
                                            if (placementType == 0) {
                                                bpVar.f4542v.put(str4, Integer.valueOf(0));
                                            } else {
                                                bpVar.f4542v.put(str4, Integer.valueOf(1));
                                            }
                                        }
                                    }
                                    if (b != null) {
                                        relativeLayout2.addView(b, new LayoutParams(point.x, point.y));
                                    }
                                    this.f4259k.mo28362d();
                                } else {
                                    if (this.f4259k.getFullScreenEventsListener() != null) {
                                        this.f4259k.getFullScreenEventsListener().mo28374a();
                                    }
                                    finish();
                                    return;
                                }
                                frameLayout.addView(relativeLayout2, new LayoutParams(-1, -1));
                                return;
                            } catch (Exception e2) {
                                this.f4259k.setFullScreenActivityContext(null);
                                if (this.f4259k.getFullScreenEventsListener() != null) {
                                    this.f4259k.getFullScreenEventsListener().mo28374a();
                                }
                                finish();
                                C2463fd.m5161a().mo28382a(new C2495fz(e2));
                                return;
                            }
                        }
                    }
                    if (this.f4259k.getFullScreenEventsListener() != null) {
                        this.f4259k.getFullScreenEventsListener().mo28374a();
                    }
                    finish();
                }
            } else {
                String str5 = "id";
                if (i == 103) {
                    int intExtra = getIntent().getIntExtra(str5, -1);
                    if (intExtra != -1) {
                        startActivityForResult((Intent) f4250c.get(Integer.valueOf(intExtra)), intExtra);
                    }
                } else if (i == 104) {
                    int intExtra2 = getIntent().getIntExtra(str5, -1);
                    if (intExtra2 != -1) {
                        String[] stringArrayExtra = getIntent().getStringArrayExtra(NativeProtocol.RESULT_ARGS_PERMISSIONS);
                        if (stringArrayExtra != null && stringArrayExtra.length > 0 && VERSION.SDK_INT >= 23) {
                            C2507gf.m5327b();
                            requestPermissions(stringArrayExtra, intExtra2);
                        }
                    }
                }
            }
        }
    }

    public void onStop() {
        super.onStop();
        if (!this.f4258a) {
            this.f4267s = true;
            C2390ej ejVar = this.f4263o;
            if (ejVar != null) {
                ejVar.pause();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        String str = "SDK encountered unexpected error while finishing fullscreen view";
        String str2 = "InMobi";
        if (this.f4258a) {
            int i = this.f4264p;
            if (100 == i) {
                C2600j jVar = this.f4260l;
                if (!(jVar == null || jVar.getFullScreenEventsListener() == null)) {
                    try {
                        this.f4260l.getFullScreenEventsListener().mo28376b(this.f4260l);
                        this.f4260l.destroy();
                        this.f4260l = null;
                    } catch (Exception unused) {
                    }
                }
            } else if (102 == i) {
                C2452f fVar = this.f4259k;
                if (!(fVar == null || fVar.getFullScreenEventsListener() == null)) {
                    int i2 = this.f4265q;
                    if (200 == i2) {
                        try {
                            this.f4259k.getFullScreenEventsListener().mo28376b(null);
                        } catch (Exception unused2) {
                            C2514gh.m5342a(2, str2, str);
                        }
                    } else if (201 == i2) {
                        C2452f fVar2 = this.f4259k;
                        if (fVar2 instanceof C2596i) {
                            C2403ek ekVar = (C2403ek) ((C2596i) fVar2).getVideoContainerView();
                            if (ekVar != null) {
                                try {
                                    this.f4259k.getFullScreenEventsListener().mo28376b((C2235bp) ekVar.getVideoView().getTag());
                                } catch (Exception e) {
                                    C2514gh.m5342a(2, str2, str);
                                    C2463fd.m5161a().mo28382a(new C2495fz(e));
                                }
                            }
                        } else if (fVar2 instanceof C2542h) {
                            try {
                                fVar2.getFullScreenEventsListener().mo28376b(null);
                            } catch (Exception e2) {
                                C2514gh.m5342a(2, str2, str);
                                C2463fd.m5161a().mo28382a(new C2495fz(e2));
                            }
                        }
                    }
                }
            }
            C2452f fVar3 = this.f4259k;
            if (fVar3 != null) {
                fVar3.destroy();
                this.f4259k = null;
            }
        } else {
            int i3 = this.f4264p;
            if (100 != i3 && 102 == i3) {
                C2452f fVar4 = this.f4259k;
                if (fVar4 != null) {
                    int i4 = this.f4265q;
                    if (200 == i4) {
                        C2600j jVar2 = (C2600j) fVar4;
                        jVar2.setFullScreenActivityContext(null);
                        try {
                            jVar2.mo28360b();
                        } catch (Exception unused3) {
                            C2514gh.m5342a(2, str2, "SDK encountered unexpected error in processing close request");
                        }
                    } else if (201 == i4) {
                        if (fVar4 instanceof C2596i) {
                            C2596i iVar = (C2596i) fVar4;
                            C2390ej ejVar = this.f4263o;
                            if (ejVar != null) {
                                C2235bp bpVar = (C2235bp) ejVar.getTag();
                                if (bpVar != null) {
                                    if (1 == iVar.getPlacementType()) {
                                        this.f4263o.mo28268a();
                                    }
                                    if (this.f4259k.getFullScreenEventsListener() != null) {
                                        try {
                                            this.f4259k.getFullScreenEventsListener().mo28376b(bpVar);
                                        } catch (Exception e3) {
                                            C2514gh.m5342a(2, str2, str);
                                            C2463fd.m5161a().mo28382a(new C2495fz(e3));
                                        }
                                    }
                                }
                            }
                        } else if ((fVar4 instanceof C2542h) && fVar4.getFullScreenEventsListener() != null) {
                            try {
                                this.f4259k.getFullScreenEventsListener().mo28376b(null);
                            } catch (Exception e4) {
                                C2514gh.m5342a(2, str2, str);
                                C2463fd.m5161a().mo28382a(new C2495fz(e4));
                            }
                        }
                    }
                    m4212a((Object) this.f4259k);
                    this.f4259k.destroy();
                    this.f4259k = null;
                }
            }
        }
        super.onDestroy();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C2600j jVar = this.f4260l;
        if (jVar != null) {
            if ("Resized".equals(jVar.f5797c) && jVar.getResizeProperties() != null) {
                jVar.f5800f.mo28104a();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (((C2136a) f4249b.remove(Integer.valueOf(i))) != null) {
            f4250c.remove(Integer.valueOf(i));
            this.f4258a = true;
            finish();
        }
    }

    public void onMultiWindowModeChanged(boolean z) {
        super.onMultiWindowModeChanged(z);
        if (!z) {
            C2600j jVar = this.f4260l;
            if (jVar != null) {
                jVar.setOrientationProperties(jVar.getOrientationProperties());
            }
            C2452f fVar = this.f4259k;
            if (fVar != null) {
                fVar.mo28362d();
            }
        }
    }

    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        super.onMultiWindowModeChanged(z, configuration);
        onMultiWindowModeChanged(z);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        C2507gf.m5328c();
        f4252e.remove(Integer.valueOf(i));
        finish();
    }

    public void onBackPressed() {
        String str = "isFullScreen";
        String str2 = "didRequestFullScreen";
        int i = this.f4264p;
        if (i == 102) {
            C2452f fVar = this.f4259k;
            if (fVar != null && !fVar.mo28361c()) {
                String str3 = "InMobi";
                if (200 == this.f4265q) {
                    C2600j jVar = (C2600j) this.f4259k;
                    if (jVar != null) {
                        if (jVar.f5810p != null) {
                            jVar.mo28624a(jVar.f5810p, "broadcastEvent('backButtonPressed')");
                        }
                        if (!jVar.f5809o) {
                            this.f4258a = true;
                            try {
                                jVar.mo28360b();
                                return;
                            } catch (Exception unused) {
                                C2514gh.m5342a(2, str3, "SDK encountered unexpected error in processing close request");
                            }
                        } else {
                            return;
                        }
                    }
                    return;
                }
                C2452f fVar2 = this.f4259k;
                if (fVar2 instanceof C2596i) {
                    C2596i iVar = (C2596i) fVar2;
                    if (iVar != null && !iVar.mo28500k().f4565b) {
                        this.f4258a = true;
                        C2390ej ejVar = this.f4263o;
                        if (ejVar != null) {
                            C2235bp bpVar = (C2235bp) ejVar.getTag();
                            if (bpVar != null) {
                                if (1 == iVar.getPlacementType()) {
                                    this.f4263o.mo28268a();
                                }
                                try {
                                    if (((Boolean) bpVar.f4542v.get(str)).booleanValue()) {
                                        bpVar.f4542v.put("seekPosition", Integer.valueOf(this.f4263o.getCurrentPosition()));
                                        if (!iVar.f5595j && ((Boolean) bpVar.f4542v.get(str2)).booleanValue()) {
                                            bpVar.f4542v.put(str2, Boolean.FALSE);
                                            if (bpVar.f4545y != null) {
                                                bpVar.f4545y.f4542v.put(str2, Boolean.FALSE);
                                            }
                                            iVar.mo28360b();
                                            bpVar.f4542v.put(str, Boolean.FALSE);
                                        }
                                    }
                                    return;
                                } catch (Exception e) {
                                    C2514gh.m5342a(2, str3, "SDK encountered unexpected error in closing video");
                                    C2463fd.m5161a().mo28382a(new C2495fz(e));
                                }
                            }
                            return;
                        }
                        finish();
                    }
                } else if (fVar2 instanceof C2542h) {
                    C2542h hVar = (C2542h) fVar2;
                    if (hVar == null) {
                        finish();
                    } else if (!hVar.mo28500k().f4565b) {
                        hVar.mo28360b();
                    }
                }
            }
        } else if (i == 100) {
            this.f4258a = true;
            finish();
        }
    }
}
