package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Intent;
import com.applovin.impl.sdk.C1180g.C1185a;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.utils.C1239a;
import com.applovin.impl.sdk.utils.C1246g;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinUserService.OnConsentDialogDismissListener;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.applovin.sdk.AppLovinWebViewActivity.EventListener;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.sdk.h */
public class C1186h implements C1185a, EventListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final AtomicBoolean f2892a = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static WeakReference<AppLovinWebViewActivity> f2893b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C1192i f2894c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1227o f2895d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnConsentDialogDismissListener f2896e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C1180g f2897f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public WeakReference<Activity> f2898g = new WeakReference<>(null);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C1239a f2899h;

    C1186h(C1192i iVar) {
        this.f2894c = iVar;
        this.f2895d = iVar.mo10249v();
        if (iVar.mo10180F() != null) {
            this.f2898g = new WeakReference<>(iVar.mo10180F());
        }
        iVar.mo10217aa().mo9736a(new C1239a() {
            public void onActivityStarted(Activity activity) {
                C1186h.this.f2898g = new WeakReference(activity);
            }
        });
        this.f2897f = new C1180g(this, iVar);
    }

    /* renamed from: a */
    private void m2544a(boolean z, long j) {
        m2552f();
        if (z) {
            mo10169a(j);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m2546a(C1192i iVar) {
        String str = "AppLovinSdk";
        if (mo10171c()) {
            C1227o.m2841i(str, "Consent dialog already showing");
            return false;
        } else if (!C1246g.m2947a(iVar.mo10179D())) {
            C1227o.m2841i(str, "No internet available, skip showing of consent dialog");
            return false;
        } else {
            String str2 = "ConsentDialogManager";
            if (!((Boolean) iVar.mo10202a(C1096c.f2323al)).booleanValue()) {
                this.f2895d.mo10382e(str2, "Blocked publisher from showing consent dialog");
                return false;
            } else if (C1277l.m3042b((String) iVar.mo10202a(C1096c.f2324am))) {
                return true;
            } else {
                this.f2895d.mo10382e(str2, "AdServer returned empty consent dialog URL");
                return false;
            }
        }
    }

    /* renamed from: f */
    private void m2552f() {
        this.f2894c.mo10217aa().mo9737b(this.f2899h);
        if (mo10171c()) {
            AppLovinWebViewActivity appLovinWebViewActivity = (AppLovinWebViewActivity) f2893b.get();
            f2893b = null;
            if (appLovinWebViewActivity != null) {
                appLovinWebViewActivity.finish();
                OnConsentDialogDismissListener onConsentDialogDismissListener = this.f2896e;
                if (onConsentDialogDismissListener != null) {
                    onConsentDialogDismissListener.onDismiss();
                    this.f2896e = null;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo10167a() {
        if (this.f2898g.get() != null) {
            final Activity activity = (Activity) this.f2898g.get();
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    C1186h.this.mo10170a(activity, (OnConsentDialogDismissListener) null);
                }
            }, ((Long) this.f2894c.mo10202a(C1096c.f2326ao)).longValue());
        }
    }

    /* renamed from: a */
    public void mo10169a(final long j) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                C1186h.this.f2895d.mo10378b("ConsentDialogManager", "Scheduling repeating consent alert");
                C1186h.this.f2897f.mo10161a(j, C1186h.this.f2894c, C1186h.this);
            }
        });
    }

    /* renamed from: a */
    public void mo10170a(final Activity activity, final OnConsentDialogDismissListener onConsentDialogDismissListener) {
        activity.runOnUiThread(new Runnable() {
            public void run() {
                C1186h hVar = C1186h.this;
                if (!hVar.m2546a(hVar.f2894c) || C1186h.f2892a.getAndSet(true)) {
                    OnConsentDialogDismissListener onConsentDialogDismissListener = onConsentDialogDismissListener;
                    if (onConsentDialogDismissListener != null) {
                        onConsentDialogDismissListener.onDismiss();
                    }
                    return;
                }
                C1186h.this.f2898g = new WeakReference(activity);
                C1186h.this.f2896e = onConsentDialogDismissListener;
                C1186h.this.f2899h = new C1239a() {
                    public void onActivityStarted(Activity activity) {
                        if (activity instanceof AppLovinWebViewActivity) {
                            if (!C1186h.this.mo10171c() || C1186h.f2893b.get() != activity) {
                                AppLovinWebViewActivity appLovinWebViewActivity = (AppLovinWebViewActivity) activity;
                                C1186h.f2893b = new WeakReference(appLovinWebViewActivity);
                                appLovinWebViewActivity.loadUrl((String) C1186h.this.f2894c.mo10202a(C1096c.f2324am), C1186h.this);
                            }
                            C1186h.f2892a.set(false);
                        }
                    }
                };
                C1186h.this.f2894c.mo10217aa().mo9736a(C1186h.this.f2899h);
                Intent intent = new Intent(activity, AppLovinWebViewActivity.class);
                intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, C1186h.this.f2894c.mo10246t());
                intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_IMMERSIVE_MODE_ON, (Serializable) C1186h.this.f2894c.mo10202a(C1096c.f2325an));
                activity.startActivity(intent);
            }
        });
    }

    /* renamed from: b */
    public void mo10168b() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo10171c() {
        WeakReference<AppLovinWebViewActivity> weakReference = f2893b;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public void onReceivedEvent(String str) {
        boolean booleanValue;
        C1192i iVar;
        C1096c<Long> cVar;
        if ("accepted".equalsIgnoreCase(str)) {
            AppLovinPrivacySettings.setHasUserConsent(true, this.f2894c.mo10179D());
            m2552f();
            return;
        }
        if ("rejected".equalsIgnoreCase(str)) {
            AppLovinPrivacySettings.setHasUserConsent(false, this.f2894c.mo10179D());
            booleanValue = ((Boolean) this.f2894c.mo10202a(C1096c.f2327ap)).booleanValue();
            iVar = this.f2894c;
            cVar = C1096c.f2332au;
        } else if ("closed".equalsIgnoreCase(str)) {
            booleanValue = ((Boolean) this.f2894c.mo10202a(C1096c.f2328aq)).booleanValue();
            iVar = this.f2894c;
            cVar = C1096c.f2333av;
        } else if (AppLovinWebViewActivity.EVENT_DISMISSED_VIA_BACK_BUTTON.equalsIgnoreCase(str)) {
            booleanValue = ((Boolean) this.f2894c.mo10202a(C1096c.f2329ar)).booleanValue();
            iVar = this.f2894c;
            cVar = C1096c.f2334aw;
        } else {
            return;
        }
        m2544a(booleanValue, ((Long) iVar.mo10202a(cVar)).longValue());
    }
}
