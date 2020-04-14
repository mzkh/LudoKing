package com.adcolony.sdk;

import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdColonyInterstitialActivity extends C0578b {

    /* renamed from: n */
    AdColonyInterstitial f120n;

    /* renamed from: o */
    private C0665i f121o;

    public AdColonyInterstitialActivity() {
        AdColonyInterstitial adColonyInterstitial;
        if (!C0476a.m84b()) {
            adColonyInterstitial = null;
        } else {
            adColonyInterstitial = C0476a.m77a().mo8588v();
        }
        this.f120n = adColonyInterstitial;
    }

    public /* bridge */ /* synthetic */ void onBackPressed() {
        super.onBackPressed();
    }

    public /* bridge */ /* synthetic */ void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    public /* bridge */ /* synthetic */ void onPause() {
        super.onPause();
    }

    public /* bridge */ /* synthetic */ void onResume() {
        super.onResume();
    }

    public /* bridge */ /* synthetic */ void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void onCreate(Bundle bundle) {
        AdColonyInterstitial adColonyInterstitial = this.f120n;
        this.f533d = adColonyInterstitial == null ? 0 : adColonyInterstitial.mo8141e();
        super.onCreate(bundle);
        if (C0476a.m84b()) {
            AdColonyInterstitial adColonyInterstitial2 = this.f120n;
            if (adColonyInterstitial2 != null) {
                C0487ag h = adColonyInterstitial2.mo8146h();
                if (h != null) {
                    h.mo8246a(this.f120n.mo8139d());
                }
                this.f121o = new C0665i(new Handler(Looper.getMainLooper()), this.f120n);
                if (this.f120n.getListener() != null) {
                    this.f120n.getListener().onOpened(this.f120n);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8152a(C0480ab abVar) {
        super.mo8152a(abVar);
        C0595d l = C0476a.m77a().mo8578l();
        C0629e eVar = (C0629e) l.mo8513f().remove(this.f534e);
        if (eVar != null) {
            for (MediaPlayer mediaPlayer : eVar.mo8530c().mo8208c().values()) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                mediaPlayer.release();
            }
            eVar.mo8532d().mo8304a().autoPause();
            eVar.mo8532d().mo8304a().release();
        }
        JSONObject f = C0746u.m921f(abVar.mo8220c(), "v4iap");
        JSONArray g = C0746u.m922g(f, "product_ids");
        if (f != null) {
            AdColonyInterstitial adColonyInterstitial = this.f120n;
            if (!(adColonyInterstitial == null || adColonyInterstitial.getListener() == null || g.length() <= 0)) {
                this.f120n.getListener().onIAPEvent(this.f120n, C0746u.m915c(g, 0), C0746u.m914c(f, "engagement_type"));
            }
        }
        l.mo8502a(this.f532c);
        if (this.f120n != null) {
            l.mo8509c().remove(this.f120n.mo8142f());
        }
        AdColonyInterstitial adColonyInterstitial2 = this.f120n;
        if (!(adColonyInterstitial2 == null || adColonyInterstitial2.getListener() == null)) {
            this.f120n.getListener().onClosed(this.f120n);
            this.f120n.mo8127a((C0580c) null);
            this.f120n.setListener(null);
            this.f120n = null;
        }
        C0665i iVar = this.f121o;
        if (iVar != null) {
            iVar.mo8541a();
            this.f121o = null;
        }
        new C0749a().mo8726a("finish_ad call finished").mo8728a(C0748w.f1168d);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8151a(AdColonyInterstitial adColonyInterstitial) {
        this.f120n = adColonyInterstitial;
    }
}
