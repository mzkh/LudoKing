package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.iab.omid.library.inmobi.adsession.VerificationScriptResource;
import com.inmobi.media.C2344ds.C2345a;
import java.util.List;

/* renamed from: com.inmobi.media.dq */
/* compiled from: OmidTrackedNativeDisplayAd */
public class C2342dq extends C2299ct {

    /* renamed from: d */
    private static final String f4966d = "dq";
    @NonNull

    /* renamed from: e */
    private final C2300cu f4967e;
    @NonNull

    /* renamed from: f */
    private C2336dl f4968f;

    public C2342dq(@NonNull C2452f fVar, @NonNull C2300cu cuVar, @NonNull C2336dl dlVar) {
        super(fVar);
        this.f4967e = cuVar;
        this.f4968f = dlVar;
    }

    @Nullable
    /* renamed from: c */
    public final View mo28151c() {
        return this.f4967e.mo28151c();
    }

    @Nullable
    /* renamed from: a */
    public final View mo28144a(View view, ViewGroup viewGroup, boolean z) {
        return this.f4967e.mo28144a(view, viewGroup, z);
    }

    @Nullable
    /* renamed from: b */
    public final View mo28150b() {
        return this.f4967e.mo28150b();
    }

    /* renamed from: d */
    public final void mo28152d() {
        try {
            this.f4968f.mo28190a();
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.f4967e.mo28152d();
            throw th;
        }
        this.f4967e.mo28152d();
    }

    /* renamed from: a */
    public final void mo28146a(int i) {
        try {
            this.f4968f.mo28191a(i);
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.f4967e.mo28146a(i);
            throw th;
        }
        this.f4967e.mo28146a(i);
    }

    /* renamed from: a */
    public final void mo28147a(Context context, int i) {
        this.f4967e.mo28147a(context, i);
    }

    /* renamed from: e */
    public final void mo28153e() {
        super.mo28153e();
        try {
            this.f4968f = null;
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.f4967e.mo28153e();
            throw th;
        }
        this.f4967e.mo28153e();
    }

    @NonNull
    /* renamed from: a */
    public static C2336dl m4856a(@NonNull List<VerificationScriptResource> list, String str) {
        return new C2337dm("native_display_ad", C2345a.f4975a.mo28197a(list, str));
    }

    /* renamed from: a */
    public final void mo28149a(@Nullable View... viewArr) {
        try {
            if (this.f4855c.f5182i.f5242l.f5211f && C2345a.f4975a.mo28199a() && (this.f4853a instanceof C2542h)) {
                View i = ((C2542h) this.f4853a).mo28498i();
                if (i != null) {
                    this.f4968f.mo28193a(i, null, this.f4967e.mo28150b());
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.f4967e.mo28149a(viewArr);
            throw th;
        }
        this.f4967e.mo28149a(viewArr);
    }
}
