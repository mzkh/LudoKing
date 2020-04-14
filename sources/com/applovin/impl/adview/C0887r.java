package com.applovin.impl.adview;

import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import com.applovin.impl.p005a.C0769a;
import com.applovin.impl.p005a.C0769a.C0773c;
import com.applovin.impl.p005a.C0776d;
import com.applovin.impl.p005a.C0780g;
import com.applovin.impl.p005a.C0781h;
import com.applovin.impl.p005a.C0782i;
import com.applovin.impl.p005a.C0786k;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p019b.C1096c;
import com.tapjoy.TJAdUnitConstants.String;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.adview.r */
public class C0887r extends C0842m {

    /* renamed from: a */
    private final Set<C0780g> f1609a = new HashSet();

    /* renamed from: a */
    private void m1345a() {
        if (isFullyWatched() && !this.f1609a.isEmpty()) {
            C1227o oVar = this.logger;
            StringBuilder sb = new StringBuilder();
            sb.append("Firing ");
            sb.append(this.f1609a.size());
            sb.append(" un-fired video progress trackers when video was completed.");
            oVar.mo10381d("InterstitialActivity", sb.toString());
            m1350a(this.f1609a);
        }
    }

    /* renamed from: a */
    private void m1346a(C0773c cVar) {
        m1347a(cVar, C0776d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m1347a(C0773c cVar, C0776d dVar) {
        m1349a(cVar, "", dVar);
    }

    /* renamed from: a */
    private void m1348a(C0773c cVar, String str) {
        m1349a(cVar, str, C0776d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m1349a(C0773c cVar, String str, C0776d dVar) {
        if (isVastAd()) {
            m1351a(((C0769a) this.currentAd).mo8875a(cVar, str), dVar);
        }
    }

    /* renamed from: a */
    private void m1350a(Set<C0780g> set) {
        m1351a(set, C0776d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m1351a(Set<C0780g> set, C0776d dVar) {
        if (isVastAd() && set != null && !set.isEmpty()) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds((long) this.videoView.getCurrentPosition());
            C0786k i = m1352b().mo8895i();
            Uri a = i != null ? i.mo8958a() : null;
            C1227o oVar = this.logger;
            StringBuilder sb = new StringBuilder();
            sb.append("Firing ");
            sb.append(set.size());
            sb.append(" tracker(s): ");
            sb.append(set);
            oVar.mo10378b("InterstitialActivity", sb.toString());
            C0782i.m1083a(set, seconds, a, dVar, this.sdk);
        }
    }

    /* renamed from: b */
    private C0769a m1352b() {
        if (this.currentAd instanceof C0769a) {
            return (C0769a) this.currentAd;
        }
        return null;
    }

    public void clickThroughFromVideo(PointF pointF) {
        super.clickThroughFromVideo(pointF);
        m1346a(C0773c.VIDEO_CLICK);
    }

    public void dismiss() {
        if (isVastAd()) {
            C0773c cVar = C0773c.VIDEO;
            String str = String.CLOSE;
            m1348a(cVar, str);
            m1348a(C0773c.COMPANION, str);
        }
        super.dismiss();
    }

    public void handleCountdownStep() {
        if (isVastAd()) {
            long seconds = ((long) this.computedLengthSeconds) - TimeUnit.MILLISECONDS.toSeconds((long) (this.videoView.getDuration() - this.videoView.getCurrentPosition()));
            HashSet hashSet = new HashSet();
            for (C0780g gVar : new HashSet(this.f1609a)) {
                if (gVar.mo8942a(seconds, getVideoPercentViewed())) {
                    hashSet.add(gVar);
                    this.f1609a.remove(gVar);
                }
            }
            m1350a((Set<C0780g>) hashSet);
        }
    }

    public void handleMediaError(String str) {
        m1347a(C0773c.ERROR, C0776d.MEDIA_FILE_ERROR);
        super.handleMediaError(str);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (isVastAd()) {
            this.f1609a.addAll(m1352b().mo8876a(C0773c.VIDEO, C0781h.f1292a));
            m1346a(C0773c.IMPRESSION);
            m1348a(C0773c.VIDEO, "creativeView");
        }
    }

    public void playVideo() {
        this.countdownManager.mo9084a("PROGRESS_TRACKING", ((Long) this.sdk.mo10202a(C1096c.f2500eF)).longValue(), (C0830a) new C0830a() {
            /* renamed from: a */
            public void mo9088a() {
                C0887r.this.handleCountdownStep();
            }

            /* renamed from: b */
            public boolean mo9089b() {
                return C0887r.this.shouldContinueFullLengthVideoCountdown();
            }
        });
        super.playVideo();
    }

    public void showPoststitial() {
        if (isVastAd()) {
            m1345a();
            if (!C0782i.m1090c(m1352b())) {
                dismiss();
                return;
            } else if (!this.poststitialWasDisplayed) {
                m1348a(C0773c.COMPANION, "creativeView");
            } else {
                return;
            }
        }
        super.showPoststitial();
    }

    public void skipVideo() {
        m1348a(C0773c.VIDEO, "skip");
        super.skipVideo();
    }

    public void toggleMute() {
        String str;
        C0773c cVar;
        super.toggleMute();
        if (this.videoMuted) {
            cVar = C0773c.VIDEO;
            str = "mute";
        } else {
            cVar = C0773c.VIDEO;
            str = "unmute";
        }
        m1348a(cVar, str);
    }
}
