package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.iab.omid.library.inmobi.adsession.VerificationScriptResource;
import com.iab.omid.library.inmobi.adsession.video.VastProperties;
import com.inmobi.media.C2300cu.C2301a;
import com.inmobi.media.C2344ds.C2345a;
import java.lang.ref.WeakReference;
import java.util.List;

/* renamed from: com.inmobi.media.dr */
/* compiled from: OmidTrackedNativeV2VideoAd */
public class C2343dr extends C2299ct {

    /* renamed from: d */
    private static final String f4969d = "dr";

    /* renamed from: e */
    private final VastProperties f4970e;
    @NonNull

    /* renamed from: f */
    private final WeakReference<Context> f4971f;
    @NonNull

    /* renamed from: g */
    private final C2300cu f4972g;
    @NonNull

    /* renamed from: h */
    private C2336dl f4973h;
    @Nullable

    /* renamed from: i */
    private WeakReference<View> f4974i;

    public C2343dr(@NonNull Context context, @NonNull C2300cu cuVar, @NonNull C2596i iVar, @NonNull C2336dl dlVar, VastProperties vastProperties) {
        super(iVar);
        this.f4971f = new WeakReference<>(context);
        this.f4972g = cuVar;
        this.f4973h = dlVar;
        this.f4970e = vastProperties;
    }

    @Nullable
    /* renamed from: c */
    public final View mo28151c() {
        return this.f4972g.mo28151c();
    }

    @Nullable
    /* renamed from: a */
    public final View mo28144a(View view, ViewGroup viewGroup, boolean z) {
        return this.f4972g.mo28144a(view, viewGroup, z);
    }

    @Nullable
    /* renamed from: b */
    public final View mo28150b() {
        return this.f4972g.mo28150b();
    }

    /* renamed from: a */
    public final C2301a mo28145a() {
        return this.f4972g.mo28145a();
    }

    /* renamed from: a */
    public final void mo28147a(Context context, int i) {
        this.f4972g.mo28147a(context, i);
    }

    /* renamed from: e */
    public final void mo28153e() {
        super.mo28153e();
        try {
            this.f4971f.clear();
            if (this.f4974i != null) {
                this.f4974i.clear();
            }
            this.f4973h = null;
        } catch (Exception e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        } catch (Throwable th) {
            this.f4972g.mo28153e();
            throw th;
        }
        this.f4972g.mo28153e();
    }

    @NonNull
    /* renamed from: a */
    public static C2336dl m4865a(@NonNull List<VerificationScriptResource> list, String str) {
        return new C2337dm("native_video_ad", C2345a.f4975a.mo28197a(list, str));
    }

    /* renamed from: a */
    public final void mo28149a(@Nullable View... viewArr) {
        try {
            if (this.f4855c.f5182i.f5242l.f5211f && C2345a.f4975a.mo28199a() && (this.f4853a instanceof C2596i)) {
                C2403ek ekVar = (C2403ek) this.f4853a.getVideoContainerView();
                if (ekVar != null) {
                    this.f4974i = new WeakReference<>(ekVar);
                    this.f4973h.mo28193a((View) this.f4974i.get(), null, this.f4972g.mo28150b());
                    this.f4973h.hashCode();
                }
            }
        } catch (Exception e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        } catch (Throwable th) {
            this.f4972g.mo28149a(viewArr);
            throw th;
        }
        this.f4972g.mo28149a(viewArr);
    }

    /* renamed from: d */
    public final void mo28152d() {
        try {
            if (!((C2596i) this.f4853a).mo28501l()) {
                this.f4973h.mo28190a();
                this.f4973h.hashCode();
            }
        } catch (Exception e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        } catch (Throwable th) {
            this.f4972g.mo28152d();
            throw th;
        }
        this.f4972g.mo28152d();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0068, code lost:
        if (((com.inmobi.media.C2596i) r6.f4853a).mo28501l() != false) goto L_0x006a;
     */
    @android.annotation.SuppressLint({"SwitchIntDef"})
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo28146a(int r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = 5
            r2 = 0
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r7 == r1) goto L_0x005a
            r1 = 6
            if (r7 == r1) goto L_0x0013
            r1 = 13
            if (r7 == r1) goto L_0x0011
            r1 = 14
            goto L_0x0070
        L_0x0011:
            r3 = 0
            goto L_0x0070
        L_0x0013:
            com.inmobi.media.f r1 = r6.f4853a     // Catch:{ Exception -> 0x007a }
            boolean r1 = r1 instanceof com.inmobi.media.C2596i     // Catch:{ Exception -> 0x007a }
            if (r1 == 0) goto L_0x0070
            com.inmobi.media.f r1 = r6.f4853a     // Catch:{ Exception -> 0x007a }
            android.view.View r1 = r1.getVideoContainerView()     // Catch:{ Exception -> 0x007a }
            com.inmobi.media.ek r1 = (com.inmobi.media.C2403ek) r1     // Catch:{ Exception -> 0x007a }
            if (r1 == 0) goto L_0x0056
            com.inmobi.media.ej r0 = r1.getVideoView()     // Catch:{ Exception -> 0x007a }
            int r0 = r0.getDuration()     // Catch:{ Exception -> 0x007a }
            com.inmobi.media.ej r1 = r1.getVideoView()     // Catch:{ Exception -> 0x007a }
            java.lang.Object r1 = r1.getTag()     // Catch:{ Exception -> 0x007a }
            com.inmobi.media.bp r1 = (com.inmobi.media.C2235bp) r1     // Catch:{ Exception -> 0x007a }
            java.util.Map<java.lang.String, java.lang.Object> r4 = r1.f4542v     // Catch:{ Exception -> 0x007a }
            java.lang.String r5 = "currentMediaVolume"
            java.lang.Object r4 = r4.get(r5)     // Catch:{ Exception -> 0x007a }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Exception -> 0x007a }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x007a }
            if (r4 <= 0) goto L_0x0058
            java.util.Map<java.lang.String, java.lang.Object> r1 = r1.f4542v     // Catch:{ Exception -> 0x007a }
            java.lang.String r4 = "lastMediaVolume"
            java.lang.Object r1 = r1.get(r4)     // Catch:{ Exception -> 0x007a }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x007a }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x007a }
            if (r1 != 0) goto L_0x0058
            goto L_0x0070
        L_0x0056:
            r2 = 1065353216(0x3f800000, float:1.0)
        L_0x0058:
            r3 = r2
            goto L_0x0070
        L_0x005a:
            com.inmobi.media.f r1 = r6.f4853a     // Catch:{ Exception -> 0x007a }
            boolean r1 = r1 instanceof com.inmobi.media.C2596i     // Catch:{ Exception -> 0x007a }
            if (r1 == 0) goto L_0x0070
            com.inmobi.media.f r1 = r6.f4853a     // Catch:{ Exception -> 0x007a }
            com.inmobi.media.i r1 = (com.inmobi.media.C2596i) r1     // Catch:{ Exception -> 0x007a }
            boolean r1 = r1.mo28501l()     // Catch:{ Exception -> 0x007a }
            if (r1 == 0) goto L_0x0070
        L_0x006a:
            com.inmobi.media.cu r0 = r6.f4972g
            r0.mo28146a(r7)
            return
        L_0x0070:
            com.inmobi.media.dl r1 = r6.f4973h     // Catch:{ Exception -> 0x007a }
            com.iab.omid.library.inmobi.adsession.video.VastProperties r2 = r6.f4970e     // Catch:{ Exception -> 0x007a }
            r1.mo28192a(r7, r0, r3, r2)     // Catch:{ Exception -> 0x007a }
            goto L_0x006a
        L_0x0078:
            r0 = move-exception
            goto L_0x0088
        L_0x007a:
            r0 = move-exception
            com.inmobi.media.fd r1 = com.inmobi.media.C2463fd.m5161a()     // Catch:{ all -> 0x0078 }
            com.inmobi.media.fz r2 = new com.inmobi.media.fz     // Catch:{ all -> 0x0078 }
            r2.<init>(r0)     // Catch:{ all -> 0x0078 }
            r1.mo28382a(r2)     // Catch:{ all -> 0x0078 }
            goto L_0x006a
        L_0x0088:
            com.inmobi.media.cu r1 = r6.f4972g
            r1.mo28146a(r7)
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2343dr.mo28146a(int):void");
    }
}
