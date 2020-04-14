package com.adcolony.sdk;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings.System;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.i */
class C0665i extends ContentObserver {

    /* renamed from: a */
    private AudioManager f927a;

    /* renamed from: b */
    private AdColonyInterstitial f928b;

    public boolean deliverSelfNotifications() {
        return false;
    }

    public C0665i(Handler handler, AdColonyInterstitial adColonyInterstitial) {
        super(handler);
        Context c = C0476a.m85c();
        if (c != null) {
            this.f927a = (AudioManager) c.getSystemService("audio");
            this.f928b = adColonyInterstitial;
            c.getApplicationContext().getContentResolver().registerContentObserver(System.CONTENT_URI, true, this);
        }
    }

    public void onChange(boolean z) {
        if (this.f927a != null) {
            AdColonyInterstitial adColonyInterstitial = this.f928b;
            if (adColonyInterstitial != null && adColonyInterstitial.mo8139d() != null) {
                double streamVolume = (double) ((((float) this.f927a.getStreamVolume(3)) / 15.0f) * 100.0f);
                JSONObject a = C0746u.m892a();
                C0746u.m900a(a, "audio_percentage", streamVolume);
                C0746u.m902a(a, "ad_session_id", this.f928b.mo8139d().mo8463b());
                C0746u.m912b(a, "id", this.f928b.mo8139d().mo8470d());
                new C0480ab("AdContainer.on_audio_change", this.f928b.mo8139d().mo8467c(), a).mo8217b();
                new C0749a().mo8726a("Volume changed to ").mo8723a(streamVolume).mo8728a(C0748w.f1168d);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8541a() {
        Context c = C0476a.m85c();
        if (c != null) {
            c.getApplicationContext().getContentResolver().unregisterContentObserver(this);
        }
        this.f928b = null;
        this.f927a = null;
    }
}
