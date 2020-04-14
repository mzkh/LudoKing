package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.PublisherAdView;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzads implements Runnable {
    private final /* synthetic */ PublisherAdView zzcww;
    private final /* synthetic */ zzvl zzcwx;
    private final /* synthetic */ zzadt zzcwy;

    zzads(zzadt zzadt, PublisherAdView publisherAdView, zzvl zzvl) {
        this.zzcwy = zzadt;
        this.zzcww = publisherAdView;
        this.zzcwx = zzvl;
    }

    public final void run() {
        if (this.zzcww.zza(this.zzcwx)) {
            this.zzcwy.zzcwz.onPublisherAdViewLoaded(this.zzcww);
        } else {
            zzaxi.zzeu("Could not bind.");
        }
    }
}
