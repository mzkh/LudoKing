package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbmk.zza;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzciz extends zzciw<zzbio> {
    private final zzbth zzelt;
    private final zzbpn zzerr;
    private final zzcle zzewq;
    private final ViewGroup zzfdl;
    private final zzbou zzffd;
    private final zzbei zzfza;
    private final zza zzfzb;

    public zzciz(zzbei zzbei, zza zza, zzcle zzcle, zzbpn zzbpn, zzbth zzbth, zzbou zzbou, @Nullable ViewGroup viewGroup) {
        this.zzfza = zzbei;
        this.zzfzb = zza;
        this.zzewq = zzcle;
        this.zzerr = zzbpn;
        this.zzelt = zzbth;
        this.zzffd = zzbou;
        this.zzfdl = viewGroup;
    }

    /* access modifiers changed from: protected */
    public final zzddi<zzbio> zza(zzcwe zzcwe, Bundle bundle) {
        return this.zzfza.zzabi().zzc(this.zzfzb.zza(zzcwe).zze(bundle).zzafy()).zzc(this.zzerr).zza(this.zzewq).zzb(this.zzelt).zza(new zzbkh(this.zzffd)).zzb(new zzbin(this.zzfdl)).zzacz().zzaca().zzafs();
    }
}
