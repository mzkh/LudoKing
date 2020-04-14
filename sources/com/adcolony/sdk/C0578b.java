package com.adcolony.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout.LayoutParams;
import androidx.core.view.ViewCompat;
import java.util.Iterator;
import java.util.Map.Entry;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.b */
class C0578b extends Activity {

    /* renamed from: a */
    static final int f530a = 0;

    /* renamed from: b */
    static final int f531b = 1;

    /* renamed from: c */
    C0580c f532c;

    /* renamed from: d */
    int f533d = -1;

    /* renamed from: e */
    String f534e;

    /* renamed from: f */
    int f535f;

    /* renamed from: g */
    boolean f536g;

    /* renamed from: h */
    boolean f537h;

    /* renamed from: i */
    boolean f538i;

    /* renamed from: j */
    boolean f539j;

    /* renamed from: k */
    boolean f540k;

    /* renamed from: l */
    boolean f541l;

    /* renamed from: m */
    C0629e f542m;

    C0578b() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!C0476a.m84b() || C0476a.m77a().mo8586t() == null) {
            finish();
            return;
        }
        C0666j a = C0476a.m77a();
        this.f538i = false;
        this.f532c = a.mo8586t();
        this.f532c.mo8466b(false);
        if (C0543at.m331g()) {
            this.f532c.mo8466b(true);
        }
        this.f534e = this.f532c.mo8463b();
        this.f535f = this.f532c.mo8467c();
        this.f542m = (C0629e) C0476a.m77a().mo8578l().mo8513f().get(this.f534e);
        this.f539j = a.mo8567d().getMultiWindowEnabled();
        if (this.f539j) {
            getWindow().addFlags(2048);
            getWindow().clearFlags(1024);
        } else {
            getWindow().addFlags(1024);
            getWindow().clearFlags(2048);
        }
        requestWindowFeature(1);
        getWindow().getDecorView().setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        if (a.mo8567d().getKeepScreenOn()) {
            getWindow().addFlags(128);
        }
        ViewParent parent = this.f532c.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this.f532c);
        }
        setContentView(this.f532c);
        String str = "AdSession.finish_fullscreen_ad";
        this.f532c.mo8488m().add(C0476a.m76a(str, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                C0578b.this.mo8152a(abVar);
            }
        }, true));
        this.f532c.mo8489n().add(str);
        mo8453a(this.f533d);
        if (!this.f532c.mo8496s()) {
            JSONObject a2 = C0746u.m892a();
            C0746u.m902a(a2, "id", this.f532c.mo8463b());
            C0746u.m912b(a2, "screen_width", this.f532c.mo8493p());
            C0746u.m912b(a2, "screen_height", this.f532c.mo8490o());
            String str2 = "AdSession.on_fullscreen_ad_started";
            new C0749a().mo8726a(str2).mo8728a(C0748w.f1166b);
            new C0480ab(str2, this.f532c.mo8467c(), a2).mo8217b();
            this.f532c.mo8469c(true);
        } else {
            mo8452a();
        }
    }

    public void onPause() {
        super.onPause();
        mo8454a(this.f537h);
        this.f537h = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8454a(boolean z) {
        this.f542m = (C0629e) C0476a.m77a().mo8578l().mo8513f().get(this.f534e);
        Iterator it = this.f532c.mo8473e().entrySet().iterator();
        while (it.hasNext() && !isFinishing()) {
            C0546au auVar = (C0546au) ((Entry) it.next()).getValue();
            if (!auVar.mo8386j() && auVar.mo8385i().isPlaying()) {
                auVar.mo8382f();
            }
        }
        C0629e eVar = this.f542m;
        if (eVar != null) {
            eVar.mo8526a();
        }
        AdColonyInterstitial v = C0476a.m77a().mo8588v();
        if (v != null && v.mo8143g() && v.mo8146h().mo8252e() != null && z && this.f540k) {
            v.mo8146h().mo8247a("pause");
        }
    }

    public void onResume() {
        super.onResume();
        mo8452a();
        mo8455b(this.f537h);
        this.f537h = true;
        this.f541l = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8455b(boolean z) {
        for (Entry value : this.f532c.mo8473e().entrySet()) {
            C0546au auVar = (C0546au) value.getValue();
            if (!auVar.mo8386j() && !auVar.mo8385i().isPlaying() && !C0476a.m77a().mo8584r().mo8661c()) {
                auVar.mo8381e();
            }
        }
        C0629e eVar = this.f542m;
        if (eVar != null) {
            eVar.mo8528b();
        }
        AdColonyInterstitial v = C0476a.m77a().mo8588v();
        if (v != null && v.mo8143g() && v.mo8146h().mo8252e() != null) {
            if ((!z || (z && !this.f540k)) && this.f541l) {
                v.mo8146h().mo8247a("resume");
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (z && this.f537h) {
            C0476a.m77a().mo8577k().mo8295c(true);
            mo8455b(this.f537h);
            this.f540k = true;
        } else if (!z && this.f537h) {
            new C0749a().mo8726a("Activity is active but window does not have focus, pausing.").mo8728a(C0748w.f1168d);
            C0476a.m77a().mo8577k().mo8294b(true);
            mo8454a(this.f537h);
            this.f540k = false;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (C0476a.m84b() && this.f532c != null && !this.f536g) {
            if ((VERSION.SDK_INT < 24 || !C0543at.m331g()) && !this.f532c.mo8495r()) {
                JSONObject a = C0746u.m892a();
                C0746u.m902a(a, "id", this.f532c.mo8463b());
                new C0480ab("AdSession.on_error", this.f532c.mo8467c(), a).mo8217b();
                this.f538i = true;
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this instanceof AdColonyInterstitialActivity) {
            mo8452a();
        } else {
            ((AdColonyAdViewActivity) this).mo8061c();
        }
    }

    public void onBackPressed() {
        JSONObject a = C0746u.m892a();
        C0746u.m902a(a, "id", this.f532c.mo8463b());
        new C0480ab("AdSession.on_back_button", this.f532c.mo8467c(), a).mo8217b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8452a() {
        C0666j a = C0476a.m77a();
        if (this.f532c == null) {
            this.f532c = a.mo8586t();
        }
        C0580c cVar = this.f532c;
        if (cVar != null) {
            cVar.mo8466b(false);
            if (C0543at.m331g()) {
                this.f532c.mo8466b(true);
            }
            int q = a.mo8579m().mo8641q();
            int r = this.f539j ? a.mo8579m().mo8642r() - C0543at.m321c(C0476a.m85c()) : a.mo8579m().mo8642r();
            if (q > 0 && r > 0) {
                JSONObject a2 = C0746u.m892a();
                JSONObject a3 = C0746u.m892a();
                float p = a.mo8579m().mo8640p();
                C0746u.m912b(a3, "width", (int) (((float) q) / p));
                C0746u.m912b(a3, "height", (int) (((float) r) / p));
                C0746u.m912b(a3, "app_orientation", C0543at.m335j(C0543at.m332h()));
                C0746u.m912b(a3, "x", 0);
                C0746u.m912b(a3, "y", 0);
                String str = "ad_session_id";
                C0746u.m902a(a3, str, this.f532c.mo8463b());
                C0746u.m912b(a2, "screen_width", q);
                C0746u.m912b(a2, "screen_height", r);
                C0746u.m902a(a2, str, this.f532c.mo8463b());
                C0746u.m912b(a2, "id", this.f532c.mo8470d());
                this.f532c.setLayoutParams(new LayoutParams(q, r));
                this.f532c.mo8464b(q);
                this.f532c.mo8457a(r);
                new C0480ab("MRAID.on_size_change", this.f532c.mo8467c(), a3).mo8217b();
                new C0480ab("AdContainer.on_orientation_change", this.f532c.mo8467c(), a2).mo8217b();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8152a(C0480ab abVar) {
        int c = C0746u.m914c(abVar.mo8220c(), "status");
        if ((c == 5 || c == 0 || c == 6 || c == 1) && !this.f536g) {
            C0666j a = C0476a.m77a();
            C0697m r = a.mo8584r();
            a.mo8562b(abVar);
            if (r.mo8660b() != null) {
                r.mo8660b().dismiss();
                r.mo8658a((AlertDialog) null);
            }
            if (!this.f538i) {
                finish();
            }
            this.f536g = true;
            ((ViewGroup) getWindow().getDecorView()).removeAllViews();
            a.mo8566c(false);
            JSONObject a2 = C0746u.m892a();
            C0746u.m902a(a2, "id", this.f532c.mo8463b());
            new C0480ab("AdSession.on_close", this.f532c.mo8467c(), a2).mo8217b();
            a.mo8553a((C0580c) null);
            a.mo8551a((AdColonyInterstitial) null);
            a.mo8548a((AdColonyAdView) null);
            C0476a.m77a().mo8578l().mo8509c().remove(this.f532c.mo8463b());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8453a(int i) {
        if (i == 0) {
            setRequestedOrientation(7);
        } else if (i != 1) {
            setRequestedOrientation(4);
        } else {
            setRequestedOrientation(6);
        }
        this.f533d = i;
    }
}
