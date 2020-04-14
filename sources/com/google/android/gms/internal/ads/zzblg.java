package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzblg<T> {
    private final zzcdt zzffx;
    private final zzcdw zzffy;
    private final zzdwo<zzddi<zzape>> zzffz;
    private final zzcwe zzfga;
    private final zzcyg zzfgb;
    private final zzbgt zzfgc;
    private final zzcjg<T> zzfgd;
    private final zzbpk zzfge;
    @Nullable
    private final zzcvz zzfgf;

    zzblg(zzcdt zzcdt, zzcdw zzcdw, zzdwo<zzddi<zzape>> zzdwo, zzcwe zzcwe, zzcyg zzcyg, zzbgt zzbgt, zzcjg<T> zzcjg, zzbpk zzbpk, @Nullable zzcvz zzcvz) {
        this.zzffx = zzcdt;
        this.zzffy = zzcdw;
        this.zzffz = zzdwo;
        this.zzfga = zzcwe;
        this.zzfgb = zzcyg;
        this.zzfgc = zzbgt;
        this.zzfgd = zzcjg;
        this.zzfge = zzbpk;
        this.zzfgf = zzcvz;
    }

    public final zzddi<T> zzafs() {
        zzcxp zzcxp;
        if (this.zzfgf != null) {
            zzcxp = this.zzfgb.zzu(zzcyd.SERVER_TRANSACTION).zzb(zzdcy.zzah(this.zzfgf)).zzant();
        } else {
            zzq.zzkp().zzmh();
            if (this.zzfga.zzgkg.zzcck != null) {
                zzcxp = this.zzfgb.zzu(zzcyd.SERVER_TRANSACTION).zzb(this.zzffy.zzaki()).zzant();
            } else {
                zzcxp = this.zzfgb.zza(zzcyd.SERVER_TRANSACTION, (zzddi) this.zzffz.get()).zza(this.zzffx).zzant();
            }
        }
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcrp)).booleanValue()) {
            return this.zzfgb.zza(zzcyd.RENDERER, (zzddi<I>) zzcxp).zza(this.zzfgc).zza(this.zzfgd).zzant();
        }
        return this.zzfgb.zza(zzcyd.RENDERER, (zzddi<I>) zzcxp).zza(this.zzfgc).zza(this.zzfgd).zza((long) ((Integer) zzuv.zzon().zzd(zzza.zzcrq)).intValue(), TimeUnit.SECONDS).zzant();
    }
}
