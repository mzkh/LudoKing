package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbsm implements zzo {
    private final zzboo zzfio;
    private final zzbqo zzfip;

    public zzbsm(zzboo zzboo, zzbqo zzbqo) {
        this.zzfio = zzboo;
        this.zzfip = zzbqo;
    }

    public final void zzsi() {
        this.zzfio.zzsi();
        this.zzfip.onHide();
    }

    public final void onPause() {
        this.zzfio.onPause();
    }

    public final void onResume() {
        this.zzfio.onResume();
    }

    public final void zzsj() {
        this.zzfio.zzsj();
        this.zzfip.zzagp();
    }
}
