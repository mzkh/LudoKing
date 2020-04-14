package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzble implements zzo {
    private final zzbnr zzffv;
    private AtomicBoolean zzffw = new AtomicBoolean(false);

    public zzble(zzbnr zzbnr) {
        this.zzffv = zzbnr;
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void zzsi() {
        this.zzffw.set(true);
        this.zzffv.onAdClosed();
    }

    public final void zzsj() {
        this.zzffv.onAdOpened();
    }

    public final boolean isClosed() {
        return this.zzffw.get();
    }
}
