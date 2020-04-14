package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbmk.zza;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcjb extends zzciw<zzbrs> {
    private final zzbpn zzerr;
    private final zzcle zzewq;
    private final zzbei zzfza;
    private final zza zzfzb;

    public zzcjb(zzbei zzbei, zza zza, zzcle zzcle, zzbpn zzbpn) {
        this.zzfza = zzbei;
        this.zzfzb = zza;
        this.zzewq = zzcle;
        this.zzerr = zzbpn;
    }

    /* access modifiers changed from: protected */
    public final zzddi<zzbrs> zza(zzcwe zzcwe, Bundle bundle) {
        return this.zzfza.zzabk().zzd(this.zzfzb.zza(zzcwe).zze(bundle).zzafy()).zzd(this.zzerr).zzb(this.zzewq).zzadf().zzaca().zzafs();
    }
}
