package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zze;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcln implements zze {
    private final /* synthetic */ zzbru zzgbe;

    zzcln(zzcli zzcli, zzbru zzbru) {
        this.zzgbe = zzbru;
    }

    public final void zzg(View view) {
    }

    public final void zzjl() {
        this.zzgbe.zzach().onAdClicked();
    }

    public final void zzjm() {
        this.zzgbe.zzaci().onAdImpression();
        this.zzgbe.zzacj().zzagq();
    }
}
