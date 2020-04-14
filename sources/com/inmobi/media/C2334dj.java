package com.inmobi.media;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.inmobi.media.C2426eq.C2435i;
import com.inmobi.media.C2620l.C2637b;
import com.moat.analytics.mobile.inm.MoatAdEvent;
import com.moat.analytics.mobile.inm.MoatAdEventType;
import com.moat.analytics.mobile.inm.ReactiveVideoTracker;
import com.tapjoy.TJAdUnitConstants.String;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.dj */
/* compiled from: MoatTrackedNativeVideoAd */
public class C2334dj extends C2299ct {

    /* renamed from: d */
    private static final String f4941d = "dj";
    @NonNull

    /* renamed from: e */
    private final WeakReference<Context> f4942e;

    /* renamed from: f */
    private ReactiveVideoTracker f4943f;
    @NonNull

    /* renamed from: g */
    private Map<String, Object> f4944g;
    @NonNull

    /* renamed from: h */
    private C2300cu f4945h;

    /* renamed from: i */
    private boolean f4946i = false;

    public C2334dj(@NonNull Context context, @NonNull C2300cu cuVar, @NonNull C2596i iVar, @NonNull Map<String, Object> map) {
        super(iVar);
        this.f4942e = new WeakReference<>(context);
        this.f4945h = cuVar;
        this.f4944g = map;
        this.f4943f = (ReactiveVideoTracker) map.get("moatTracker");
    }

    @Nullable
    /* renamed from: a */
    public final View mo28144a(View view, ViewGroup viewGroup, boolean z) {
        return this.f4945h.mo28144a(view, viewGroup, z);
    }

    @Nullable
    /* renamed from: b */
    public final View mo28150b() {
        return this.f4945h.mo28150b();
    }

    /* renamed from: a */
    public final void mo28149a(@Nullable View... viewArr) {
        try {
            Application d = C2505gd.m5301d();
            C2435i iVar = this.f4855c.f5182i;
            if (d != null && (this.f4853a instanceof C2596i) && iVar.f5241k && ((Boolean) this.f4944g.get(String.ENABLED)).booleanValue() && this.f4943f == null) {
                this.f4943f = C2330dg.m4797a(d, (String) this.f4944g.get("partnerCode"));
                this.f4944g.put("moatTracker", this.f4943f);
                this.f4946i = true;
            }
        } catch (Exception e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        } catch (Throwable th) {
            this.f4945h.mo28149a(viewArr);
            throw th;
        }
        this.f4945h.mo28149a(viewArr);
    }

    @SuppressLint({"SwitchIntDef"})
    /* renamed from: a */
    public final void mo28146a(int i) {
        String str = "zMoatVASTIDs";
        try {
            if (this.f4943f != null) {
                this.f4943f.hashCode();
                switch (i) {
                    case 1:
                        this.f4943f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_ENTER_FULLSCREEN));
                        break;
                    case 2:
                        this.f4943f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_EXIT_FULLSCREEN));
                        break;
                    case 3:
                        this.f4943f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_STOPPED));
                        break;
                    case 5:
                    case 16:
                        C2403ek ekVar = (C2403ek) this.f4853a.getVideoContainerView();
                        if (!(ekVar == null || this.f4943f == null)) {
                            C2390ej videoView = ekVar.getVideoView();
                            if (!this.f4946i) {
                                this.f4943f.changeTargetView(ekVar);
                                break;
                            } else {
                                ReactiveVideoTracker reactiveVideoTracker = this.f4943f;
                                HashMap a = C2637b.m5955a("level", "slicer", (JSONArray) this.f4944g.get("clientLevels"), (JSONArray) this.f4944g.get("clientSlicers"), (JSONObject) this.f4944g.get("zMoatExtras"));
                                a.put(str, (String) this.f4944g.get(str));
                                reactiveVideoTracker.trackVideoAd(a, Integer.valueOf(videoView.getDuration()), ekVar);
                                this.f4946i = false;
                                break;
                            }
                        }
                    case 6:
                        C2403ek ekVar2 = (C2403ek) this.f4853a.getVideoContainerView();
                        if (ekVar2 != null) {
                            this.f4943f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_START, Integer.valueOf(ekVar2.getVideoView().getMediaPlayer().getCurrentPosition())));
                            break;
                        }
                        break;
                    case 7:
                        this.f4943f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_PAUSED));
                        break;
                    case 8:
                        this.f4943f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_PLAYING));
                        break;
                    case 9:
                        this.f4943f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_FIRST_QUARTILE));
                        break;
                    case 10:
                        this.f4943f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_MID_POINT));
                        break;
                    case 11:
                        this.f4943f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_THIRD_QUARTILE));
                        break;
                    case 12:
                        this.f4943f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_COMPLETE));
                        break;
                    case 13:
                        this.f4943f.setPlayerVolume(MoatAdEvent.VOLUME_MUTED);
                        break;
                    case 14:
                        this.f4943f.setPlayerVolume(MoatAdEvent.VOLUME_UNMUTED);
                        break;
                    case 15:
                        this.f4943f.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_SKIPPED));
                        break;
                }
            }
        } catch (Exception e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        } catch (Throwable th) {
            this.f4945h.mo28146a(i);
            throw th;
        }
        this.f4945h.mo28146a(i);
    }

    /* renamed from: a */
    public final void mo28147a(Context context, int i) {
        this.f4945h.mo28147a(context, i);
    }

    /* renamed from: e */
    public final void mo28153e() {
        this.f4943f = null;
        this.f4942e.clear();
        super.mo28153e();
        this.f4945h.mo28153e();
    }

    /* renamed from: d */
    public final void mo28152d() {
        try {
            if (!((C2596i) this.f4853a).mo28501l() && this.f4943f != null) {
                this.f4943f.stopTracking();
            }
        } catch (Exception e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        } catch (Throwable th) {
            this.f4945h.mo28152d();
            throw th;
        }
        this.f4945h.mo28152d();
    }
}
