package com.inmobi.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.ads.listeners.BannerAdEventListener;
import com.inmobi.media.C2138a.C2139a;
import com.inmobi.media.C2138a.C2140b;
import com.inmobi.media.C2205au;
import com.inmobi.media.C2211b;
import com.inmobi.media.C2505gd;
import com.inmobi.media.C2514gh;
import com.inmobi.media.C2528gq;
import com.inmobi.media.C2594hv;
import com.inmobi.media.C2647o;
import com.inmobi.media.C2674z;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

public final class InMobiBanner extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f4205a = "InMobiBanner";
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: b */
    public BannerAdEventListener f4206b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C2647o f4207c;

    /* renamed from: d */
    private boolean f4208d = false;

    /* renamed from: e */
    private int f4209e;

    /* renamed from: f */
    private boolean f4210f = true;
    @Nullable

    /* renamed from: g */
    private C2211b f4211g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f4212h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f4213i = 0;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public AnimationType f4214j = AnimationType.ROTATE_HORIZONTAL_AXIS;

    /* renamed from: k */
    private long f4215k = 0;
    @Nullable

    /* renamed from: l */
    private WeakReference<Activity> f4216l;
    @NonNull

    /* renamed from: m */
    private C2205au f4217m = new C2205au();

    public enum AnimationType {
        ANIMATION_OFF,
        ROTATE_HORIZONTAL_AXIS,
        ANIMATION_ALPHA,
        ROTATE_VERTICAL_AXIS
    }

    /* renamed from: com.inmobi.ads.InMobiBanner$a */
    interface C2123a {
        /* renamed from: a */
        void mo27684a();
    }

    /* renamed from: com.inmobi.ads.InMobiBanner$b */
    static class C2124b extends C2674z {

        /* renamed from: a */
        private WeakReference<InMobiBanner> f4223a;

        C2124b(@NonNull InMobiBanner inMobiBanner) {
            this.f4223a = new WeakReference<>(inMobiBanner);
        }

        /* renamed from: a */
        public final void mo27685a() {
            final InMobiBanner inMobiBanner = (InMobiBanner) this.f4223a.get();
            if (inMobiBanner != null) {
                try {
                    if (!inMobiBanner.f4207c.mo28851w() && inMobiBanner.f4207c.mo28845b(inMobiBanner)) {
                        C2594hv.m5662a().mo28611a(new Runnable(new C2123a() {
                            /* renamed from: a */
                            public final void mo27684a() {
                                try {
                                    if (inMobiBanner.f4206b != null) {
                                        inMobiBanner.f4206b.onAdLoadSucceeded(inMobiBanner);
                                    }
                                    inMobiBanner.m4154e();
                                } catch (Exception unused) {
                                    C2514gh.m5342a(1, InMobiBanner.f4205a, "Encountered unexpected error in scheduling refresh for banner ad");
                                    InMobiBanner.f4205a;
                                }
                            }
                        }) {
                            public final void run() {
                                InMobiBanner.this.f4207c.mo28847q();
                                try {
                                    AnimationType e = InMobiBanner.this.f4214j;
                                    float width = (float) InMobiBanner.this.getWidth();
                                    float height = (float) InMobiBanner.this.getHeight();
                                    Animation animation = 0;
                                    if (e == AnimationType.ANIMATION_ALPHA) {
                                        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.5f);
                                        alphaAnimation.setDuration(1000);
                                        alphaAnimation.setFillAfter(false);
                                        alphaAnimation.setInterpolator(new DecelerateInterpolator());
                                        animation = alphaAnimation;
                                    } else if (e == AnimationType.ROTATE_HORIZONTAL_AXIS) {
                                        C2139a aVar = new C2139a(width / 2.0f, height / 2.0f);
                                        aVar.setDuration(500);
                                        aVar.setFillAfter(false);
                                        aVar.setInterpolator(new AccelerateInterpolator());
                                        animation = aVar;
                                    } else if (e == AnimationType.ROTATE_VERTICAL_AXIS) {
                                        C2140b bVar = new C2140b(width / 2.0f, height / 2.0f);
                                        bVar.setDuration(500);
                                        bVar.setFillAfter(false);
                                        bVar.setInterpolator(new AccelerateInterpolator());
                                        animation = bVar;
                                    }
                                    InMobiBanner.this.f4207c.mo28842a((RelativeLayout) InMobiBanner.this);
                                    if (animation != 0) {
                                        InMobiBanner.this.startAnimation(animation);
                                    }
                                    r3.mo27684a();
                                } catch (Exception unused) {
                                    C2514gh.m5342a(1, InMobiBanner.f4205a, "Unexpected error while displaying Banner Ad.");
                                    InMobiBanner.f4205a;
                                }
                            }
                        });
                    }
                } catch (Exception unused) {
                    C2514gh.m5342a(1, InMobiBanner.f4205a, "Encountered unexpected error in loading banner ad");
                    InMobiBanner.f4205a;
                }
            }
        }

        /* renamed from: a */
        public final void mo27686a(InMobiAdRequestStatus inMobiAdRequestStatus) {
            InMobiBanner inMobiBanner = (InMobiBanner) this.f4223a.get();
            if (inMobiBanner != null) {
                try {
                    if (inMobiBanner.f4206b != null) {
                        inMobiBanner.f4206b.onAdLoadFailed(inMobiBanner, inMobiAdRequestStatus);
                    }
                    inMobiBanner.m4154e();
                } catch (Exception unused) {
                    C2514gh.m5342a(1, InMobiBanner.f4205a, "Encountered unexpected error in loading banner ad");
                    InMobiBanner.f4205a;
                }
            }
        }

        /* renamed from: b */
        public final void mo27689b() {
            InMobiBanner inMobiBanner = (InMobiBanner) this.f4223a.get();
            if (!(inMobiBanner == null || inMobiBanner.f4206b == null)) {
                inMobiBanner.f4206b.onAdDisplayed(inMobiBanner);
            }
        }

        /* renamed from: c */
        public final void mo27692c() {
            InMobiBanner inMobiBanner = (InMobiBanner) this.f4223a.get();
            if (inMobiBanner != null) {
                try {
                    if (inMobiBanner.f4206b != null) {
                        inMobiBanner.f4206b.onAdDismissed(inMobiBanner);
                    }
                    inMobiBanner.m4154e();
                } catch (Exception unused) {
                    C2514gh.m5342a(1, InMobiBanner.f4205a, "Encountered unexpected error in closing banner ad");
                    InMobiBanner.f4205a;
                }
            }
        }

        /* renamed from: a */
        public final void mo27687a(@NonNull Map<Object, Object> map) {
            InMobiBanner inMobiBanner = (InMobiBanner) this.f4223a.get();
            if (!(inMobiBanner == null || inMobiBanner.f4206b == null)) {
                inMobiBanner.f4206b.onAdClicked(inMobiBanner, map);
            }
        }

        /* renamed from: d */
        public final void mo27693d() {
            InMobiBanner inMobiBanner = (InMobiBanner) this.f4223a.get();
            if (!(inMobiBanner == null || inMobiBanner.f4206b == null)) {
                inMobiBanner.f4206b.onUserLeftApplication(inMobiBanner);
            }
        }

        /* renamed from: b */
        public final void mo27691b(@NonNull Map<Object, Object> map) {
            InMobiBanner inMobiBanner = (InMobiBanner) this.f4223a.get();
            if (!(inMobiBanner == null || inMobiBanner.f4206b == null)) {
                inMobiBanner.f4206b.onRewardsUnlocked(inMobiBanner, map);
            }
        }

        /* renamed from: a */
        public final void mo27688a(byte[] bArr) {
            InMobiBanner inMobiBanner = (InMobiBanner) this.f4223a.get();
            if (!(inMobiBanner == null || inMobiBanner.f4206b == null)) {
                inMobiBanner.f4206b.onRequestPayloadCreated(bArr);
            }
        }

        /* renamed from: b */
        public final void mo27690b(InMobiAdRequestStatus inMobiAdRequestStatus) {
            InMobiBanner inMobiBanner = (InMobiBanner) this.f4223a.get();
            if (!(inMobiBanner == null || inMobiBanner.f4206b == null)) {
                inMobiBanner.f4206b.onRequestPayloadCreationFailed(inMobiAdRequestStatus);
            }
        }
    }

    public InMobiBanner(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!C2505gd.m5297b()) {
            C2514gh.m5342a(1, f4205a, "Please initialize the SDK before creating a Banner ad");
            return;
        }
        if (context instanceof Activity) {
            this.f4216l = new WeakReference<>((Activity) context);
        }
        this.f4207c = new C2647o(new C2124b(this));
        String str = "http://schemas.android.com/apk/lib/com.inmobi.ads";
        String attributeValue = attributeSet.getAttributeValue(str, "placementId");
        String attributeValue2 = attributeSet.getAttributeValue(str, "refreshInterval");
        if (attributeValue != null) {
            long a = m4141a(attributeValue);
            if (a != Long.MIN_VALUE) {
                this.f4217m.f4505a = a;
                this.f4208d = true;
            } else {
                C2514gh.m5342a(1, f4205a, "AdPlacement id value is not supplied in XML layout. Banner creation failed.");
            }
        }
        m4142a(getContext());
        this.f4209e = this.f4207c.mo28850t();
        this.f4211g = new C2211b(this);
        if (attributeValue2 != null) {
            try {
                setRefreshInterval(Integer.parseInt(attributeValue2.trim()));
            } catch (NumberFormatException unused) {
                C2514gh.m5342a(1, f4205a, "Refresh interval value supplied in XML layout is not valid. Falling back to default value.");
            }
        }
    }

    /* renamed from: a */
    private static long m4141a(@NonNull String str) {
        String str2 = "Placement id value supplied in XML layout is not valid. Please make sure placement id is in plid-0123456789 format.";
        String str3 = "Invalid Placement id: ";
        try {
            StringBuilder sb = new StringBuilder(str.trim());
            if ("plid-".equalsIgnoreCase(sb.substring(0, 5))) {
                return Long.parseLong(sb.substring(5, sb.length()).trim());
            }
            C2514gh.m5342a(1, f4205a, str2);
            C2514gh.m5342a(1, f4205a, str3.concat(String.valueOf(str)));
            return Long.MIN_VALUE;
        } catch (NumberFormatException unused) {
            C2514gh.m5342a(1, f4205a, "Placement id value supplied in XML layout is not valid. Banner creation failed.");
            C2514gh.m5342a(1, f4205a, str3.concat(String.valueOf(str)));
        } catch (StringIndexOutOfBoundsException unused2) {
            C2514gh.m5342a(1, f4205a, str2);
            C2514gh.m5342a(1, f4205a, str3.concat(String.valueOf(str)));
        }
    }

    public InMobiBanner(@NonNull Context context, long j) {
        super(context);
        if (!C2505gd.m5297b()) {
            C2514gh.m5342a(1, f4205a, "Please initialize the SDK before creating a Banner ad");
            return;
        }
        if (context instanceof Activity) {
            this.f4216l = new WeakReference<>((Activity) context);
        }
        this.f4207c = new C2647o(new C2124b(this));
        this.f4217m.f4505a = j;
        this.f4208d = true;
        m4142a(context);
        this.f4209e = this.f4207c.mo28850t();
        this.f4211g = new C2211b(this);
    }

    /* renamed from: b */
    private boolean m4148b(boolean z) {
        if (!this.f4208d) {
            C2514gh.m5342a(1, f4205a, "InMobiBanner is not initialized. Ignoring your call");
        } else if (!z || this.f4206b != null) {
            return true;
        } else {
            C2514gh.m5342a(1, f4205a, "Listener supplied is null, Ignoring your call.");
        }
        return false;
    }

    public final void getSignals() {
        if (m4148b(true)) {
            m4142a(getContext());
            setEnableAutoRefresh(false);
            this.f4207c.mo27775H();
        }
    }

    public final void load(byte[] bArr) {
        if (m4148b(false)) {
            this.f4207c.mo27788b(bArr);
        }
    }

    @UiThread
    public final void load() {
        if (m4148b(false)) {
            mo27658a(false);
        }
    }

    /* renamed from: a */
    public final void mo27658a(final boolean z) {
        try {
            if (!C2505gd.m5297b()) {
                C2514gh.m5342a(1, f4205a, "InMobiBanner is not initialized. Ignoring InMobiBanner.load()");
                return;
            }
            if (this.f4208d) {
                m4142a(getContext());
                if (this.f4207c.mo28851w()) {
                    if (this.f4206b != null) {
                        this.f4206b.onAdLoadFailed(this, new InMobiAdRequestStatus(StatusCode.AD_ACTIVE));
                    }
                    C2514gh.m5342a(1, f4205a, "An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad.");
                    return;
                }
                if (!mo27659a()) {
                    if (getLayoutParams() == null) {
                        C2514gh.m5342a(1, f4205a, "The layout params of the banner must be set before calling load or call setBannerSize(int widthInDp, int heightInDp) before load");
                        this.f4207c.mo27778a(this.f4207c.mo27795p(), new InMobiAdRequestStatus(StatusCode.REQUEST_INVALID));
                        return;
                    }
                    if (getLayoutParams().width != -2) {
                        if (getLayoutParams().height != -2) {
                            m4152d();
                        }
                    }
                    C2514gh.m5342a(1, f4205a, "The height or width of a Banner ad can't be WRAP_CONTENT or call setBannerSize(int widthInDp, int heightInDp) before load");
                    this.f4207c.mo27778a(this.f4207c.mo27795p(), new InMobiAdRequestStatus(StatusCode.REQUEST_INVALID));
                    return;
                }
                if (!mo27659a()) {
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            try {
                                if (InMobiBanner.this.mo27659a()) {
                                    InMobiBanner.this.m4156f();
                                    if (InMobiBanner.this.m4150c()) {
                                        InMobiBanner.this.f4207c.mo28843a(InMobiBanner.this.getFrameSizeString(), z);
                                    }
                                } else {
                                    C2514gh.m5342a(1, InMobiBanner.f4205a, "The height or width of the banner can not be determined");
                                    InMobiBanner.this.f4207c.mo27778a(InMobiBanner.this.f4207c.mo27795p(), new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
                                }
                            } catch (Exception unused) {
                                C2514gh.m5342a(1, InMobiBanner.f4205a, "SDK encountered unexpected error while loading an ad");
                                InMobiBanner.f4205a;
                            }
                        }
                    }, 200);
                    return;
                }
                m4156f();
                if (m4150c()) {
                    this.f4207c.mo28843a(getFrameSizeString(), z);
                }
            }
        } catch (Exception unused) {
            C2514gh.m5342a(1, f4205a, "Unable to load ad; SDK encountered an unexpected error");
        }
    }

    public final void load(@NonNull Context context) {
        if (m4148b(false)) {
            if (context instanceof Activity) {
                this.f4216l = new WeakReference<>((Activity) context);
            } else {
                this.f4216l = null;
            }
            m4142a(context);
            mo27658a(false);
        }
    }

    public final JSONObject getAdMetaInfo() {
        return this.f4208d ? this.f4207c.mo27797v() : new JSONObject();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m4150c() {
        long j = this.f4215k;
        if (j != 0 && !this.f4207c.mo28844a(j)) {
            return false;
        }
        this.f4215k = SystemClock.elapsedRealtime();
        return true;
    }

    public final void setExtras(Map<String, String> map) {
        if (this.f4208d) {
            this.f4217m.f4507c = map;
        }
    }

    public final void setKeywords(String str) {
        if (this.f4208d) {
            this.f4217m.f4506b = str;
        }
    }

    public final void setListener(@NonNull BannerAdEventListener bannerAdEventListener) {
        this.f4206b = bannerAdEventListener;
    }

    public final void setEnableAutoRefresh(boolean z) {
        try {
            if (this.f4208d && this.f4210f != z) {
                this.f4210f = z;
                if (this.f4210f) {
                    m4154e();
                } else {
                    m4156f();
                }
            }
        } catch (Exception unused) {
            C2514gh.m5342a(1, f4205a, "Unable to setup auto-refresh on the ad; SDK encountered an unexpected error");
        }
    }

    public final void setRefreshInterval(int i) {
        try {
            if (this.f4208d) {
                m4142a(getContext());
                this.f4209e = this.f4207c.mo28840a(i, this.f4209e);
            }
        } catch (Exception unused) {
            C2514gh.m5342a(1, f4205a, "Unable to set refresh interval for the ad; SDK encountered an unexpected error");
        }
    }

    public final void setAnimationType(AnimationType animationType) {
        if (this.f4208d) {
            this.f4214j = animationType;
        }
    }

    public final void disableHardwareAcceleration() {
        this.f4217m.f4508d = true;
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        try {
            super.onAttachedToWindow();
            this.f4207c.mo28853y();
            if (this.f4208d) {
                m4152d();
                if (!mo27659a()) {
                    getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                        public final void onGlobalLayout() {
                            try {
                                InMobiBanner.this.f4212h = C2528gq.m5396b(InMobiBanner.this.getMeasuredWidth());
                                InMobiBanner.this.f4213i = C2528gq.m5396b(InMobiBanner.this.getMeasuredHeight());
                                if (InMobiBanner.this.mo27659a()) {
                                    if (VERSION.SDK_INT >= 16) {
                                        InMobiBanner.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                        return;
                                    }
                                    InMobiBanner.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                                }
                            } catch (Exception unused) {
                                C2514gh.m5342a(1, InMobiBanner.f4205a, "InMobiBanner$1.onGlobalLayout() handler threw unexpected error");
                                InMobiBanner.f4205a;
                            }
                        }
                    });
                }
                m4154e();
            }
        } catch (Exception unused) {
            C2514gh.m5342a(1, f4205a, "InMobiBanner#onAttachedToWindow() handler threw unexpected error");
        }
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            if (this.f4208d) {
                m4156f();
            }
            this.f4207c.mo28852x();
        } catch (Exception unused) {
            C2514gh.m5342a(1, f4205a, "InMobiBanner.onDetachedFromWindow() handler threw unexpected error");
        }
    }

    /* renamed from: d */
    private void m4152d() {
        if (getLayoutParams() != null) {
            this.f4212h = C2528gq.m5396b(getLayoutParams().width);
            this.f4213i = C2528gq.m5396b(getLayoutParams().height);
        }
    }

    public final void setBannerSize(@IntRange(from = 1) int i, @IntRange(from = 1) int i2) {
        if (this.f4208d) {
            this.f4212h = i;
            this.f4213i = i2;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo27659a() {
        return this.f4212h > 0 && this.f4213i > 0;
    }

    /* access modifiers changed from: private */
    @NonNull
    public String getFrameSizeString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4212h);
        sb.append("x");
        sb.append(this.f4213i);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final void onVisibilityChanged(@NonNull View view, int i) {
        try {
            super.onVisibilityChanged(view, i);
            if (this.f4208d) {
                if (i == 0) {
                    m4154e();
                    return;
                }
                m4156f();
            }
        } catch (Exception unused) {
            C2514gh.m5342a(1, f4205a, "InMobiBanner$1.onVisibilityChanged() handler threw unexpected error");
        }
    }

    public final void onWindowFocusChanged(boolean z) {
        try {
            super.onWindowFocusChanged(z);
            if (this.f4208d) {
                if (z) {
                    m4154e();
                    return;
                }
                m4156f();
            }
        } catch (Exception unused) {
            C2514gh.m5342a(1, f4205a, "InMobiBanner$1.onWindowFocusChanged() handler threw unexpected error");
        }
    }

    /* renamed from: a */
    private void m4142a(@NonNull Context context) {
        this.f4207c.mo28841a(context, this.f4217m, getFrameSizeString());
        C2647o oVar = this.f4207c;
        int i = this.f4209e;
        this.f4209e = oVar.mo28840a(i, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m4154e() {
        if (isShown() && hasWindowFocus()) {
            C2211b bVar = this.f4211g;
            if (bVar != null) {
                bVar.removeMessages(1);
            }
            if (this.f4207c.mo28846o() && this.f4210f) {
                C2211b bVar2 = this.f4211g;
                if (bVar2 != null) {
                    bVar2.sendEmptyMessageDelayed(1, (long) (this.f4209e * 1000));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m4156f() {
        C2211b bVar = this.f4211g;
        if (bVar != null) {
            bVar.removeMessages(1);
        }
    }

    public final void resume() {
        try {
            if (this.f4216l == null) {
                this.f4207c.mo28848r();
            }
        } catch (Exception unused) {
            C2514gh.m5342a(1, "InMobi", "Could not resume ad; SDK encountered an unexpected error");
        }
    }

    public final void pause() {
        try {
            if (this.f4216l == null) {
                this.f4207c.mo28849s();
            }
        } catch (Exception unused) {
            C2514gh.m5342a(1, "InMobi", "Could not pause ad; SDK encountered an unexpected error");
        }
    }

    public final String getCreativeId() {
        return this.f4208d ? this.f4207c.mo27796u() : "";
    }

    @UiThread
    public final void destroy() {
        m4156f();
        this.f4208d = false;
        removeAllViews();
        this.f4207c.mo28854z();
        this.f4206b = null;
    }
}
