package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.iab.omid.library.inmobi.adsession.AdSessionContext;
import com.inmobi.media.C2344ds.C2345a;

/* renamed from: com.inmobi.media.dp */
/* compiled from: OmidTrackedHtmlAd */
public class C2341dp extends C2299ct {

    /* renamed from: d */
    private static final String f4963d = "dp";
    @NonNull

    /* renamed from: e */
    private final C2300cu f4964e;
    @NonNull

    /* renamed from: f */
    private C2336dl f4965f;

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047  */
    @androidx.annotation.Nullable
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.inmobi.media.C2336dl m4847a(@androidx.annotation.NonNull java.lang.String r3, @androidx.annotation.Nullable com.inmobi.media.C2600j r4, @androidx.annotation.Nullable java.lang.String r5, boolean r6) {
        /*
            com.iab.omid.library.inmobi.adsession.AdSessionContext r4 = m4846a(r4, r5)
            int r5 = r3.hashCode()
            r0 = -284840886(0xffffffffef05ac4a, float:-4.136979E28)
            r1 = 3
            r2 = 2
            if (r5 == r0) goto L_0x002e
            r0 = 112202875(0x6b0147b, float:6.6233935E-35)
            if (r5 == r0) goto L_0x0024
            r0 = 1425678798(0x54fa21ce, float:8.5944718E12)
            if (r5 == r0) goto L_0x001a
            goto L_0x0038
        L_0x001a:
            java.lang.String r5 = "nonvideo"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0038
            r3 = 2
            goto L_0x0039
        L_0x0024:
            java.lang.String r5 = "video"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0038
            r3 = 3
            goto L_0x0039
        L_0x002e:
            java.lang.String r5 = "unknown"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0038
            r3 = 1
            goto L_0x0039
        L_0x0038:
            r3 = -1
        L_0x0039:
            if (r3 == r2) goto L_0x0047
            if (r3 == r1) goto L_0x003f
            r3 = 0
            goto L_0x004e
        L_0x003f:
            com.inmobi.media.dm r3 = new com.inmobi.media.dm
            java.lang.String r5 = "html_video_ad"
            r3.<init>(r5, r4, r6)
            goto L_0x004e
        L_0x0047:
            com.inmobi.media.dm r3 = new com.inmobi.media.dm
            java.lang.String r5 = "html_display_ad"
            r3.<init>(r5, r4)
        L_0x004e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2341dp.m4847a(java.lang.String, com.inmobi.media.j, java.lang.String, boolean):com.inmobi.media.dl");
    }

    public C2341dp(@NonNull C2452f fVar, @NonNull C2300cu cuVar, @NonNull C2336dl dlVar) {
        super(fVar);
        this.f4964e = cuVar;
        this.f4965f = dlVar;
    }

    @Nullable
    /* renamed from: c */
    public final View mo28151c() {
        return this.f4964e.mo28151c();
    }

    @Nullable
    /* renamed from: a */
    public final View mo28144a(View view, ViewGroup viewGroup, boolean z) {
        return this.f4964e.mo28144a(view, viewGroup, z);
    }

    @Nullable
    /* renamed from: b */
    public final View mo28150b() {
        return this.f4964e.mo28150b();
    }

    /* renamed from: d */
    public final void mo28152d() {
        try {
            this.f4965f.mo28190a();
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.f4964e.mo28152d();
            throw th;
        }
        this.f4964e.mo28152d();
    }

    /* renamed from: a */
    public final void mo28146a(int i) {
        this.f4964e.mo28146a(i);
    }

    /* renamed from: a */
    public final void mo28147a(Context context, int i) {
        this.f4964e.mo28147a(context, i);
    }

    /* renamed from: e */
    public final void mo28153e() {
        super.mo28153e();
        try {
            this.f4965f = null;
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.f4964e.mo28153e();
            throw th;
        }
        this.f4964e.mo28153e();
    }

    @Nullable
    /* renamed from: a */
    public static AdSessionContext m4846a(@Nullable C2600j jVar, @Nullable String str) {
        if (jVar != null) {
            return C2345a.f4975a.mo28196a((WebView) jVar, str);
        }
        return null;
    }

    /* renamed from: a */
    public final void mo28149a(@Nullable View... viewArr) {
        try {
            if (this.f4855c.f5182i.f5242l.f5211f && C2345a.f4975a.mo28199a()) {
                View view = this.f4853a instanceof C2542h ? ((C2542h) this.f4853a).mo28518v() : this.f4964e.mo28150b() instanceof WebView ? (WebView) this.f4964e.mo28150b() : null;
                if (view != null) {
                    this.f4965f.mo28193a(view, viewArr, null);
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.f4964e.mo28149a(viewArr);
            throw th;
        }
        this.f4964e.mo28149a(viewArr);
    }
}
