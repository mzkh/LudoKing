package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdjn.zzb;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdfj extends zzdem<zzdof, zzdgx, zzdha> {
    public zzdfj() {
        super(zzdof.class, zzdgx.class, zzdha.class, "type.googleapis.com/google.crypto.tink.AesCtrKey");
    }

    public final int getVersion() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final zzb zzapp() {
        return zzb.SYMMETRIC;
    }

    private static void zza(zzdhb zzdhb) throws GeneralSecurityException {
        if (zzdhb.zzaqz() < 12 || zzdhb.zzaqz() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdsg zzt(zzdpm zzdpm) throws zzdrg {
        return zzdha.zzac(zzdpm);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdsg zzs(zzdpm zzdpm) throws zzdrg {
        return zzdgx.zzaa(zzdpm);
    }

    public final /* synthetic */ zzdsg zzg(zzdsg zzdsg) throws GeneralSecurityException {
        zzdha zzdha = (zzdha) zzdsg;
        return (zzdgx) ((zzdqw) zzdgx.zzaqu().zzc(zzdha.zzaqt()).zzab(zzdpm.zzy(zzdoj.zzff(zzdha.getKeySize()))).zzdw(0).zzazr());
    }

    public final /* synthetic */ Object zze(zzdsg zzdsg) throws GeneralSecurityException {
        zzdgx zzdgx = (zzdgx) zzdsg;
        return new zzdmg(zzdgx.zzaqj().toByteArray(), zzdgx.zzaqt().zzaqz());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzd(zzdsg zzdsg) throws GeneralSecurityException {
        zzdha zzdha = (zzdha) zzdsg;
        zzdou.zzfg(zzdha.getKeySize());
        zza(zzdha.zzaqt());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzc(zzdsg zzdsg) throws GeneralSecurityException {
        zzdgx zzdgx = (zzdgx) zzdsg;
        zzdou.zzx(zzdgx.getVersion(), 0);
        zzdou.zzfg(zzdgx.zzaqj().size());
        zza(zzdgx.zzaqt());
    }
}
