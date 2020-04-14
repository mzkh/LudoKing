package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcks implements zzcga<zzbio> {
    private final zzcyg zzfgb;
    private final zzbjn zzfxm;
    private final zzddl zzgag;
    private final Context zzgal;
    @Nullable
    private final zzaah zzgam;

    public zzcks(Context context, zzbjn zzbjn, zzcyg zzcyg, zzddl zzddl, @Nullable zzaah zzaah) {
        this.zzgal = context;
        this.zzfxm = zzbjn;
        this.zzfgb = zzcyg;
        this.zzgag = zzddl;
        this.zzgam = zzaah;
    }

    public final boolean zza(zzcvz zzcvz, zzcvr zzcvr) {
        return (this.zzgam == null || zzcvr.zzgje == null || zzcvr.zzgje.zzdib == null) ? false : true;
    }

    public final zzddi<zzbio> zzb(zzcvz zzcvz, zzcvr zzcvr) {
        zzckx zzckx = new zzckx(this, new View(this.zzgal), null, zzckv.zzgaq, (zzcvu) zzcvr.zzgjg.get(0));
        zzbir zza = this.zzfxm.zza(new zzbla(zzcvz, zzcvr, null), (zzbiv) zzckx);
        return this.zzfgb.zzu(zzcyd.CUSTOM_RENDER_SYN).zza((zzcxq) new zzcku(this, new zzaaa(zza.zzade(), zzcvr.zzgje.zzdhz, zzcvr.zzgje.zzdib)), this.zzgag).zzw(zzcyd.CUSTOM_RENDER_ACK).zzb(zzdcy.zzah(zza.zzadc())).zzant();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(zzaaa zzaaa) throws Exception {
        this.zzgam.zza(zzaaa);
    }
}
