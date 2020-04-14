package com.adcolony.sdk;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import com.google.android.gms.drive.DriveFile;
import org.json.JSONObject;

public class AdColonyInterstitial {
    public static final int ADCOLONY_IAP_ENGAGEMENT_END_CARD = 0;
    public static final int ADCOLONY_IAP_ENGAGEMENT_OVERLAY = 1;

    /* renamed from: a */
    private AdColonyInterstitialListener f107a;

    /* renamed from: b */
    private C0580c f108b;

    /* renamed from: c */
    private AdColonyAdOptions f109c;

    /* renamed from: d */
    private C0487ag f110d;

    /* renamed from: e */
    private int f111e;

    /* renamed from: f */
    private String f112f;

    /* renamed from: g */
    private String f113g;

    /* renamed from: h */
    private String f114h;

    /* renamed from: i */
    private int f115i;

    /* renamed from: j */
    private String f116j;

    /* renamed from: k */
    private boolean f117k;

    /* renamed from: l */
    private boolean f118l;

    /* renamed from: m */
    private boolean f119m;

    AdColonyInterstitial(String str, AdColonyInterstitialListener adColonyInterstitialListener, String str2) {
        this.f107a = adColonyInterstitialListener;
        this.f116j = str2;
        this.f112f = str;
    }

    public boolean show() {
        if (!C0476a.m84b()) {
            return false;
        }
        C0666j a = C0476a.m77a();
        if (this.f118l) {
            new C0749a().mo8726a("This ad object has already been shown. Please request a new ad ").mo8726a("via AdColony.requestInterstitial.").mo8728a(C0748w.f1169e);
            return false;
        } else if (this.f117k) {
            new C0749a().mo8726a("This ad object has expired. Please request a new ad via AdColony").mo8726a(".requestInterstitial.").mo8728a(C0748w.f1169e);
            return false;
        } else if (a.mo8590x()) {
            new C0749a().mo8726a("Can not show ad while an interstitial is already active.").mo8728a(C0748w.f1169e);
            return false;
        } else if (mo8132a((AdColonyZone) a.mo8572f().get(this.f116j))) {
            new C0749a().mo8726a("Skipping show()").mo8728a(C0748w.f1168d);
            return false;
        } else {
            JSONObject a2 = C0746u.m892a();
            C0746u.m902a(a2, AdColonyAdapterUtils.KEY_ZONE_ID, this.f116j);
            C0746u.m912b(a2, "type", 0);
            C0746u.m902a(a2, "id", this.f112f);
            AdColonyAdOptions adColonyAdOptions = this.f109c;
            if (adColonyAdOptions != null) {
                C0746u.m913b(a2, "pre_popup", adColonyAdOptions.f64a);
                C0746u.m913b(a2, "post_popup", this.f109c.f65b);
            }
            AdColonyZone adColonyZone = (AdColonyZone) a.mo8572f().get(this.f116j);
            if (adColonyZone != null && adColonyZone.isRewarded() && a.mo8575i() == null) {
                new C0749a().mo8726a("Rewarded ad: show() called with no reward listener set.").mo8728a(C0748w.f1169e);
            }
            new C0480ab("AdSession.launch_ad_unit", 1, a2).mo8217b();
            return true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo8132a(AdColonyZone adColonyZone) {
        if (adColonyZone != null) {
            if (adColonyZone.getPlayFrequency() <= 1) {
                return false;
            }
            if (adColonyZone.mo8192b() == 0) {
                adColonyZone.mo8189a(adColonyZone.getPlayFrequency() - 1);
                return false;
            }
            adColonyZone.mo8189a(adColonyZone.mo8192b() - 1);
        }
        return true;
    }

    public boolean cancel() {
        if (this.f108b != null) {
            Context c = C0476a.m85c();
            if (c == null || (c instanceof AdColonyInterstitialActivity)) {
                JSONObject a = C0746u.m892a();
                C0746u.m902a(a, "id", this.f108b.mo8463b());
                new C0480ab("AdSession.on_request_close", this.f108b.mo8467c(), a).mo8217b();
                return true;
            }
        }
        return false;
    }

    public AdColonyInterstitialListener getListener() {
        return this.f107a;
    }

    public void setListener(@NonNull AdColonyInterstitialListener adColonyInterstitialListener) {
        this.f107a = adColonyInterstitialListener;
    }

    public String getZoneID() {
        return this.f116j;
    }

    public boolean isExpired() {
        return this.f117k || this.f118l;
    }

    public boolean destroy() {
        C0476a.m77a().mo8578l().mo8509c().remove(this.f112f);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo8131a() {
        Context c = C0476a.m85c();
        if (c == null || !C0476a.m84b()) {
            return false;
        }
        C0476a.m77a().mo8566c(true);
        C0476a.m77a().mo8553a(this.f108b);
        C0476a.m77a().mo8551a(this);
        new C0749a().mo8726a("Launching fullscreen Activity via AdColonyInterstitial's launch ").mo8726a("method.").mo8728a(C0748w.f1166b);
        Intent intent = new Intent(c, AdColonyInterstitialActivity.class);
        if (c instanceof Application) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
        }
        c.startActivity(intent);
        this.f118l = true;
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8129a(JSONObject jSONObject) {
        if (jSONObject.length() > 0) {
            this.f110d = new C0487ag(jSONObject, this.f112f);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8127a(C0580c cVar) {
        this.f108b = cVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8130a(boolean z) {
        this.f117k = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8126a(AdColonyAdOptions adColonyAdOptions) {
        this.f109c = adColonyAdOptions;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8125a(int i) {
        this.f115i = i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8134b(int i) {
        this.f111e = i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo8133b() {
        String str = this.f113g;
        return str == null ? "" : str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8128a(String str) {
        this.f113g = str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public String mo8137c() {
        String str = this.f114h;
        return str == null ? "" : str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8135b(String str) {
        this.f114h = str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public C0580c mo8139d() {
        return this.f108b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public int mo8141e() {
        return this.f111e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public String mo8142f() {
        return this.f112f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8136b(boolean z) {
        this.f119m = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public boolean mo8143g() {
        return this.f110d != null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public C0487ag mo8146h() {
        return this.f110d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public boolean mo8147i() {
        return this.f119m;
    }
}
