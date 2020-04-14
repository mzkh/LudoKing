package com.inmobi.ads;

import android.content.Context;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.inmobi.ads.listeners.InterstitialAdEventListener;
import com.inmobi.media.C2205au;
import com.inmobi.media.C2463fd;
import com.inmobi.media.C2495fz;
import com.inmobi.media.C2505gd;
import com.inmobi.media.C2514gh;
import com.inmobi.media.C2528gq;
import com.inmobi.media.C2657t;
import com.inmobi.media.C2674z;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

public final class InMobiInterstitial {

    /* renamed from: a */
    private static final String f4226a = "InMobiInterstitial";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C2657t f4227b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public InterstitialAdEventListener f4228c;

    /* renamed from: d */
    private Context f4229d;

    /* renamed from: e */
    private boolean f4230e = false;

    /* renamed from: f */
    private boolean f4231f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f4232g = "";

    /* renamed from: h */
    private WeakReference<Context> f4233h;
    @NonNull

    /* renamed from: i */
    private C2205au f4234i = new C2205au();

    /* renamed from: com.inmobi.ads.InMobiInterstitial$a */
    static class C2126a extends C2674z {

        /* renamed from: a */
        private WeakReference<InMobiInterstitial> f4235a;

        C2126a(@NonNull InMobiInterstitial inMobiInterstitial) {
            this.f4235a = new WeakReference<>(inMobiInterstitial);
        }

        /* renamed from: e */
        public final void mo27706e() {
            InMobiInterstitial inMobiInterstitial = (InMobiInterstitial) this.f4235a.get();
            if (inMobiInterstitial != null && inMobiInterstitial.f4228c != null) {
                inMobiInterstitial.f4228c.onAdReceived(inMobiInterstitial);
            }
        }

        /* renamed from: a */
        public final void mo27685a() {
            InMobiInterstitial inMobiInterstitial = (InMobiInterstitial) this.f4235a.get();
            if (inMobiInterstitial != null) {
                if (inMobiInterstitial.f4228c != null) {
                    inMobiInterstitial.f4228c.onAdLoadSucceeded(inMobiInterstitial);
                }
                inMobiInterstitial.f4232g = inMobiInterstitial.f4227b.mo27796u();
            }
        }

        /* renamed from: a */
        public final void mo27686a(InMobiAdRequestStatus inMobiAdRequestStatus) {
            InMobiInterstitial inMobiInterstitial = (InMobiInterstitial) this.f4235a.get();
            if (inMobiInterstitial != null && inMobiInterstitial.f4228c != null) {
                inMobiInterstitial.f4228c.onAdLoadFailed(inMobiInterstitial, inMobiAdRequestStatus);
            }
        }

        /* renamed from: f */
        public final void mo27707f() {
            InMobiInterstitial inMobiInterstitial = (InMobiInterstitial) this.f4235a.get();
            if (inMobiInterstitial != null && inMobiInterstitial.f4228c != null) {
                inMobiInterstitial.f4228c.onAdWillDisplay(inMobiInterstitial);
            }
        }

        /* renamed from: g */
        public final void mo27708g() {
            InMobiInterstitial inMobiInterstitial = (InMobiInterstitial) this.f4235a.get();
            if (inMobiInterstitial != null && inMobiInterstitial.f4228c != null) {
                inMobiInterstitial.f4228c.onAdDisplayFailed(inMobiInterstitial);
            }
        }

        /* renamed from: b */
        public final void mo27689b() {
            InMobiInterstitial inMobiInterstitial = (InMobiInterstitial) this.f4235a.get();
            if (inMobiInterstitial != null && inMobiInterstitial.f4228c != null) {
                inMobiInterstitial.f4228c.onAdDisplayed(inMobiInterstitial);
            }
        }

        /* renamed from: c */
        public final void mo27692c() {
            InMobiInterstitial inMobiInterstitial = (InMobiInterstitial) this.f4235a.get();
            if (inMobiInterstitial != null && inMobiInterstitial.f4228c != null) {
                inMobiInterstitial.f4228c.onAdDismissed(inMobiInterstitial);
            }
        }

        /* renamed from: a */
        public final void mo27687a(@NonNull Map<Object, Object> map) {
            InMobiInterstitial inMobiInterstitial = (InMobiInterstitial) this.f4235a.get();
            if (inMobiInterstitial != null && inMobiInterstitial.f4228c != null) {
                inMobiInterstitial.f4228c.onAdClicked(inMobiInterstitial, map);
            }
        }

        /* renamed from: b */
        public final void mo27691b(@NonNull Map<Object, Object> map) {
            InMobiInterstitial inMobiInterstitial = (InMobiInterstitial) this.f4235a.get();
            if (inMobiInterstitial != null && inMobiInterstitial.f4228c != null) {
                inMobiInterstitial.f4228c.onRewardsUnlocked(inMobiInterstitial, map);
            }
        }

        /* renamed from: d */
        public final void mo27693d() {
            InMobiInterstitial inMobiInterstitial = (InMobiInterstitial) this.f4235a.get();
            if (inMobiInterstitial != null && inMobiInterstitial.f4228c != null) {
                inMobiInterstitial.f4228c.onUserLeftApplication(inMobiInterstitial);
            }
        }

        /* renamed from: a */
        public final void mo27688a(byte[] bArr) {
            InMobiInterstitial inMobiInterstitial = (InMobiInterstitial) this.f4235a.get();
            if (inMobiInterstitial != null && inMobiInterstitial.f4228c != null) {
                inMobiInterstitial.f4228c.onRequestPayloadCreated(bArr);
            }
        }

        /* renamed from: b */
        public final void mo27690b(InMobiAdRequestStatus inMobiAdRequestStatus) {
            InMobiInterstitial inMobiInterstitial = (InMobiInterstitial) this.f4235a.get();
            if (inMobiInterstitial != null && inMobiInterstitial.f4228c != null) {
                inMobiInterstitial.f4228c.onRequestPayloadCreationFailed(inMobiAdRequestStatus);
            }
        }
    }

    public InMobiInterstitial(@NonNull Context context, long j, @NonNull InterstitialAdEventListener interstitialAdEventListener) {
        if (!C2505gd.m5297b()) {
            C2514gh.m5342a(1, f4226a, "Please initialize the SDK before creating an Interstitial ad");
            return;
        }
        this.f4230e = true;
        this.f4229d = context.getApplicationContext();
        this.f4234i.f4505a = j;
        this.f4233h = new WeakReference<>(context);
        this.f4228c = interstitialAdEventListener;
        this.f4227b = new C2657t(new C2126a(this));
    }

    public final void setListener(@NonNull InterstitialAdEventListener interstitialAdEventListener) {
        this.f4228c = interstitialAdEventListener;
    }

    public final void setKeywords(String str) {
        if (this.f4230e) {
            this.f4234i.f4506b = str;
        }
    }

    /* renamed from: a */
    private boolean m4173a() {
        if (!this.f4230e) {
            C2514gh.m5342a(1, f4226a, "InMobiInterstitial is not initialized, your call is ignored.");
        } else if (this.f4228c == null) {
            C2514gh.m5342a(1, f4226a, "Listener supplied is null, your call is ignored.");
        } else if (this.f4229d != null) {
            return true;
        } else {
            C2514gh.m5342a(1, f4226a, "Context supplied is null, your call is ignored.");
        }
        return false;
    }

    public final void getSignals() {
        if (m4173a()) {
            this.f4227b.mo28865a(this.f4234i, this.f4229d);
            this.f4227b.mo27775H();
        }
    }

    public final void load(byte[] bArr) {
        if (m4173a()) {
            if (this.f4227b.mo27795p() == null) {
                C2514gh.m5342a(1, f4226a, "Either getSignals() is not called or InMobiInterstitial is not initialized, your call is ignored.");
            } else {
                this.f4231f = true;
                this.f4227b.mo27788b(bArr);
            }
        }
    }

    @UiThread
    public final void load() {
        try {
            if (m4173a()) {
                this.f4231f = true;
                this.f4227b.mo28865a(this.f4234i, this.f4229d);
                if (VERSION.SDK_INT >= 29) {
                    if ((this.f4233h == null ? null : (Context) this.f4233h.get()) != null) {
                        C2528gq.m5394a((Context) this.f4233h.get());
                    }
                }
                this.f4232g = "";
                this.f4227b.mo28866o();
            }
        } catch (Exception e) {
            C2514gh.m5342a(1, f4226a, "Unable to load ad; SDK encountered an unexpected error");
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        }
    }

    @UiThread
    public final void show() {
        try {
            if (!this.f4231f) {
                C2514gh.m5342a(1, f4226a, "load() must be called before trying to show the ad");
            } else if (this.f4230e) {
                this.f4227b.mo28868r();
            } else {
                C2514gh.m5342a(1, f4226a, "InMobiInterstitial is not initialized, your call is ignored.");
            }
        } catch (Exception e) {
            C2514gh.m5342a(1, f4226a, "Unable to show ad; SDK encountered an unexpected error");
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        }
    }

    @Deprecated
    public final void show(int i, int i2) {
        C2514gh.m5342a(1, f4226a, String.format("The %s API has been deprecated and API will be removed in the subsequent versions", new Object[]{"show(int, int)"}));
        show();
    }

    public final boolean isReady() {
        return this.f4230e && this.f4227b.mo28867q();
    }

    public final JSONObject getAdMetaInfo() {
        return this.f4230e ? this.f4227b.mo27797v() : new JSONObject();
    }

    public final String getCreativeId() {
        return this.f4232g;
    }

    public final void setExtras(Map<String, String> map) {
        if (this.f4230e) {
            this.f4234i.f4507c = map;
        }
    }

    public final void disableHardwareAcceleration() {
        if (this.f4230e) {
            this.f4234i.f4508d = true;
        }
    }
}
