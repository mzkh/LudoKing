package com.inmobi.media;

import android.app.Application;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.inmobi.media.C2300cu.C2301a;
import com.inmobi.media.C2620l.C2637b;
import com.moat.analytics.mobile.inm.NativeDisplayTracker;
import com.moat.analytics.mobile.inm.NativeDisplayTracker.MoatUserInteractionType;
import com.tapjoy.TJAdUnitConstants.String;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.di */
/* compiled from: MoatTrackedNativeV2DisplayAd */
public class C2332di extends C2299ct {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final String f4935d = C2332di.class.getSimpleName();
    @NonNull

    /* renamed from: e */
    private final WeakReference<Context> f4936e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public NativeDisplayTracker f4937f;
    @NonNull

    /* renamed from: g */
    private Map<String, Object> f4938g;
    @NonNull

    /* renamed from: h */
    private C2300cu f4939h;

    public C2332di(@NonNull Context context, @NonNull C2300cu cuVar, @NonNull C2542h hVar, @NonNull Map<String, Object> map) {
        super(hVar);
        this.f4936e = new WeakReference<>(context);
        this.f4939h = cuVar;
        this.f4938g = map;
    }

    @Nullable
    /* renamed from: c */
    public final View mo28151c() {
        return this.f4939h.mo28151c();
    }

    @Nullable
    /* renamed from: a */
    public final View mo28144a(View view, ViewGroup viewGroup, boolean z) {
        return this.f4939h.mo28144a(view, viewGroup, z);
    }

    @Nullable
    /* renamed from: b */
    public final View mo28150b() {
        return this.f4939h.mo28150b();
    }

    /* renamed from: a */
    public final C2301a mo28145a() {
        return this.f4939h.mo28145a();
    }

    /* renamed from: a */
    public final void mo28149a(@Nullable View... viewArr) {
        try {
            View b = this.f4939h.mo28150b();
            if (b != null) {
                Application d = C2505gd.m5301d();
                if (this.f4855c.f5182i.f5241k && d != null && ((Boolean) this.f4938g.get(String.ENABLED)).booleanValue()) {
                    String str = "zMoatIID";
                    if (this.f4937f == null) {
                        String str2 = (String) this.f4938g.get("partnerCode");
                        HashMap a = C2637b.m5955a("moatClientLevel", "moatClientSlicer", (JSONArray) this.f4938g.get("clientLevels"), (JSONArray) this.f4938g.get("clientSlicers"), (JSONObject) this.f4938g.get("zMoatExtras"));
                        a.put(str, (String) this.f4938g.get(str));
                        this.f4937f = C2330dg.m4796a(d, str2, b, a);
                    }
                    b.setOnTouchListener(new OnTouchListener() {
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            C2332di.this.f4937f.reportUserInteractionEvent(MoatUserInteractionType.TOUCH);
                            C2332di.this.f4935d;
                            C2332di.this.f4937f.hashCode();
                            return true;
                        }
                    });
                    this.f4937f.startTracking();
                    this.f4938g.get(str);
                }
            }
        } catch (Exception e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        } catch (Throwable th) {
            this.f4939h.mo28149a(viewArr);
            throw th;
        }
        this.f4939h.mo28149a(viewArr);
    }

    /* renamed from: d */
    public final void mo28152d() {
        try {
            if (this.f4937f != null) {
                this.f4937f.stopTracking();
                this.f4938g.get("zMoatIID");
            }
        } catch (Exception e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        } catch (Throwable th) {
            this.f4939h.mo28152d();
            throw th;
        }
        this.f4939h.mo28152d();
    }

    /* renamed from: a */
    public final void mo28146a(int i) {
        if (4 == i) {
            try {
                this.f4937f.reportUserInteractionEvent(MoatUserInteractionType.CLICK);
                this.f4937f.hashCode();
            } catch (Exception e) {
                C2463fd.m5161a().mo28382a(new C2495fz(e));
            } catch (Throwable th) {
                this.f4939h.mo28146a(i);
                throw th;
            }
        }
        this.f4939h.mo28146a(i);
    }

    /* renamed from: a */
    public final void mo28147a(Context context, int i) {
        this.f4939h.mo28147a(context, i);
    }

    /* renamed from: e */
    public final void mo28153e() {
        this.f4937f = null;
        this.f4936e.clear();
        super.mo28153e();
        this.f4939h.mo28153e();
    }
}
