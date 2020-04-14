package com.inmobi.media;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.browser.customtabs.CustomTabsClient;
import com.facebook.appevents.AppEventsConstants;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.media.C2620l.C2636a;
import java.util.Map;

/* renamed from: com.inmobi.media.n */
/* compiled from: BannerAdUnit */
public class C2640n extends C2620l implements ActivityLifecycleCallbacks {
    /* access modifiers changed from: private */

    /* renamed from: r */
    public static final String f5907r = "n";

    /* renamed from: s */
    private boolean f5908s = false;

    /* renamed from: t */
    private boolean f5909t = false;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f5910u = 0;

    /* renamed from: g */
    public String mo28771g() {
        return "banner";
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public final int mo28772h() {
        return 0;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    /* renamed from: b */
    static /* synthetic */ int m5961b(C2640n nVar) {
        int i = nVar.f5910u - 1;
        nVar.f5910u = i;
        return i;
    }

    public C2640n(@NonNull Context context, @NonNull C2159ai aiVar, @Nullable C2636a aVar) {
        super(context, aiVar, aVar);
        aiVar.mo27849e();
        mo28741a(context, aiVar, aVar);
    }

    /* renamed from: a */
    public void mo28740a(Context context) {
        super.mo28740a(context);
    }

    /* renamed from: T */
    public void mo28818T() {
        C2600j jVar = (C2600j) mo28781p();
        if (jVar != null) {
            this.f5909t = true;
            jVar.mo28357a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: v */
    public final boolean mo28787v() {
        try {
            CustomTabsClient.class.getName();
            return false;
        } catch (NoClassDefFoundError unused) {
            return true;
        }
    }

    /* renamed from: b */
    public void mo28825b(boolean z) {
        if (z) {
            StringBuilder sb = new StringBuilder("Initiating Banner refresh for placement id: ");
            sb.append(mo28769e().toString());
            C2514gh.m5342a(2, "InMobi", sb.toString());
        }
        this.f5908s = z;
        mo28788w();
    }

    /* renamed from: U */
    public boolean mo28819U() {
        return this.f5909t;
    }

    /* renamed from: V */
    public boolean mo28820V() {
        return mo28770f() == 8;
    }

    @Nullable
    /* renamed from: q */
    public C2600j mo28782q() {
        C2600j q = super.mo28782q();
        if (this.f5909t && q != null) {
            q.mo28357a();
        }
        return q;
    }

    /* renamed from: c */
    public void mo28826c(String str) {
        mo28769e().mo27842a(str);
    }

    /* access modifiers changed from: protected */
    @NonNull
    /* renamed from: i */
    public final Map<String, String> mo28773i() {
        Map<String, String> i = super.mo28773i();
        i.put("u-rt", this.f5908s ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        i.put("mk-ad-slot", mo28769e().mo27856j());
        return i;
    }

    /* access modifiers changed from: 0000 */
    @UiThread
    /* renamed from: a */
    public final void mo28754a(boolean z) {
        super.mo28754a(z);
        StringBuilder sb = new StringBuilder("Banner ad fetch successful for placement id: ");
        sb.append(mo28769e().toString());
        C2514gh.m5342a(2, "InMobi", sb.toString());
        if (mo28770f() == 2) {
            C2636a l = mo28777l();
            if (l != null) {
                l.mo28805a();
            }
        }
    }

    @UiThread
    /* renamed from: P */
    public void mo28736P() {
        mo28723C();
        try {
            if (!mo28735O()) {
                mo28737Q();
                this.f5862j.post(new Runnable() {
                    public final void run() {
                        C2640n.this.mo28785t();
                    }
                });
            }
        } catch (IllegalStateException unused) {
            mo28743a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR), true);
        }
    }

    /* renamed from: c */
    public void mo28533c(C2600j jVar) {
        super.mo28533c(jVar);
        this.f5862j.post(new Runnable() {
            public final void run() {
                String str = "InMobi";
                try {
                    if (C2640n.this.mo28770f() == 2) {
                        C2640n.this.mo28763c(2);
                        C2640n.this.f5854b = 4;
                        C2640n.this.mo28728H();
                        StringBuilder sb = new StringBuilder("Successfully loaded Banner ad markup in the WebView for placement id: ");
                        sb.append(C2640n.this.mo28769e().toString());
                        C2514gh.m5342a(2, str, sb.toString());
                        if (C2640n.this.mo28777l() != null) {
                            C2640n.this.mo28777l().mo27783b();
                        }
                        C2640n.this.mo28790y();
                    }
                } catch (Exception unused) {
                    C2514gh.m5342a(1, str, "Unable to load ad; SDK encountered an internal error");
                    C2640n.f5907r;
                }
            }
        });
    }

    /* renamed from: d */
    public void mo28534d(C2600j jVar) {
        super.mo28534d(jVar);
        this.f5862j.post(new Runnable() {
            public final void run() {
                try {
                    if (C2640n.this.mo28770f() == 4) {
                        C2640n.this.f5854b = 7;
                    }
                } catch (Exception unused) {
                    C2514gh.m5342a(1, "InMobi", "Unable to load ad; SDK encountered an internal error");
                    C2640n.f5907r;
                }
            }
        });
    }

    /* renamed from: f */
    public synchronized void mo28536f(C2600j jVar) {
        super.mo28536f(jVar);
        this.f5862j.post(new Runnable() {
            public final void run() {
                String str = "InMobi";
                try {
                    if (C2640n.this.mo28770f() == 7) {
                        C2640n.this.f5910u = C2640n.this.f5910u + 1;
                        C2640n.this.f5854b = 8;
                        StringBuilder sb = new StringBuilder("Successfully displayed banner ad for placement Id : ");
                        sb.append(C2640n.this.mo28769e().toString());
                        C2514gh.m5342a(2, str, sb.toString());
                        if (C2640n.this.mo28777l() != null) {
                            C2640n.this.mo28777l().mo27792e();
                        }
                    } else if (C2640n.this.mo28770f() == 8) {
                        C2640n.this.f5910u = C2640n.this.f5910u + 1;
                    }
                } catch (Exception unused) {
                    C2514gh.m5342a(1, str, "Unable to display ad; SDK encountered an internal error");
                    C2640n.f5907r;
                }
            }
        });
    }

    /* renamed from: g */
    public synchronized void mo28537g(C2600j jVar) {
        super.mo28537g(jVar);
        this.f5862j.post(new Runnable() {
            public final void run() {
                try {
                    if (C2640n.this.mo28770f() == 8 && C2640n.m5961b(C2640n.this) == 0) {
                        C2640n.this.f5854b = 7;
                        if (C2640n.this.mo28777l() != null) {
                            C2640n.this.mo28777l().mo27793f();
                        }
                    }
                } catch (Exception unused) {
                    C2514gh.m5342a(1, "InMobi", "Unable to dismiss ad; SDK encountered an internal error");
                    C2640n.f5907r;
                }
            }
        });
    }

    /* renamed from: W */
    public void mo28821W() {
        int f = mo28770f();
        if (f == 4 || f == 7 || f == 8) {
            C2452f p = mo28781p();
            if (p != null) {
                C2300cu viewableAd = p.getViewableAd();
                if (viewableAd != null) {
                    viewableAd.mo28147a(mo28767d(), 1);
                }
            }
        }
    }

    /* renamed from: X */
    public void mo28822X() {
        int f = mo28770f();
        if (f == 4 || f == 7 || f == 8) {
            C2452f p = mo28781p();
            if (p != null) {
                C2300cu viewableAd = p.getViewableAd();
                if (viewableAd != null) {
                    viewableAd.mo28147a(mo28767d(), 0);
                }
            }
        }
    }

    /* renamed from: Y */
    public void mo28823Y() {
        if (mo28767d() instanceof Activity) {
            ((Activity) mo28767d()).getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    public void onActivityStarted(Activity activity) {
        Context d = mo28767d();
        if (d != null && d.equals(activity)) {
            mo28822X();
        }
    }

    public void onActivityStopped(Activity activity) {
        Context d = mo28767d();
        if (d != null && d.equals(activity)) {
            mo28821W();
        }
    }

    public void onActivityDestroyed(Activity activity) {
        Context d = mo28767d();
        if (d != null && d.equals(activity)) {
            ((Activity) d).getApplication().unregisterActivityLifecycleCallbacks(this);
            mo28722B();
        }
    }

    /* renamed from: b */
    public void mo28529b() {
        super.mo28529b();
        this.f5869q = true;
        this.f5862j.post(new Runnable() {
            public final void run() {
                C2452f p = C2640n.this.mo28781p();
                if (p != null) {
                    p.destroy();
                }
            }
        });
    }

    /* renamed from: Z */
    public void mo28824Z() {
        Context d = mo28767d();
        if (d != null) {
            C2505gd.m5286a(d, (ActivityLifecycleCallbacks) this);
        }
    }

    /* renamed from: w */
    public void mo28788w() {
        boolean z = false;
        if (mo28787v()) {
            mo28743a(new InMobiAdRequestStatus(StatusCode.MISSING_REQUIRED_DEPENDENCIES), true);
        } else if (1 == mo28770f() || 2 == mo28770f()) {
            C2514gh.m5342a(1, f5907r, "An ad load is already in progress. Please wait for the load to complete before requesting for another ad");
        } else {
            String str = "InMobi";
            if (8 == mo28770f()) {
                mo28743a(new InMobiAdRequestStatus(StatusCode.AD_ACTIVE), false);
                StringBuilder sb = new StringBuilder(C2143ab.f4298a);
                sb.append(mo28769e().mo27849e());
                C2514gh.m5342a(1, str, sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder("Fetching a Banner ad for placement id: ");
                sb2.append(mo28769e().toString());
                C2514gh.m5342a(2, str, sb2.toString());
                this.f5865m = false;
                z = true;
            }
        }
        if (z) {
            super.mo28788w();
        }
    }
}
