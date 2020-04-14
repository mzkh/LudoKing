package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdjn.zzb;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdfi extends zzdem<zzdec, zzdhe, zzdhf> {
    public zzdfi() {
        super(zzdec.class, zzdhe.class, zzdhf.class, "type.googleapis.com/google.crypto.tink.AesEaxKey");
    }

    public final int getVersion() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final zzb zzapp() {
        return zzb.SYMMETRIC;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdsg zzt(zzdpm zzdpm) throws zzdrg {
        return zzdhf.zzae(zzdpm);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdsg zzs(zzdpm zzdpm) throws zzdrg {
        return zzdhe.zzad(zzdpm);
    }

    public final /* synthetic */ zzdsg zzg(zzdsg zzdsg) throws GeneralSecurityException {
        zzdhf zzdhf = (zzdhf) zzdsg;
        return (zzdhe) ((zzdqw) zzdhe.zzard().zzaf(zzdpm.zzy(zzdoj.zzff(zzdhf.getKeySize()))).zzb(zzdhf.zzarc()).zzdx(0).zzazr());
    }

    public final /* synthetic */ Object zze(zzdsg zzdsg) throws GeneralSecurityException {
        zzdhe zzdhe = (zzdhe) zzdsg;
        return new zzdmf(zzdhe.zzaqj().toByteArray(), zzdhe.zzarc().zzaqz());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzd(zzdsg zzdsg) throws GeneralSecurityException {
        zzdhf zzdhf = (zzdhf) zzdsg;
        zzdou.zzfg(zzdhf.getKeySize());
        if (zzdhf.zzarc().zzaqz() != 12 && zzdhf.zzarc().zzaqz() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzc(zzdsg zzdsg) throws GeneralSecurityException {
        zzdhe zzdhe = (zzdhe) zzdsg;
        zzdou.zzx(zzdhe.getVersion(), 0);
        zzdou.zzfg(zzdhe.zzaqj().size());
        if (zzdhe.zzarc().zzaqz() != 12 && zzdhe.zzarc().zzaqz() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
