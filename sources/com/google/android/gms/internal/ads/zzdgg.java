package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdjn.zzb;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdgg extends zzdem<zzdet, zzdji, zzdjj> {
    public zzdgg() {
        super(zzdet.class, zzdji.class, zzdjj.class, "type.googleapis.com/google.crypto.tink.HmacKey");
    }

    public final int getVersion() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final zzb zzapp() {
        return zzb.SYMMETRIC;
    }

    private static void zza(zzdjm zzdjm) throws GeneralSecurityException {
        if (zzdjm.zzatr() >= 10) {
            int i = zzdgj.zzgtk[zzdjm.zzatq().ordinal()];
            String str = "tag size too big";
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new GeneralSecurityException("unknown hash type");
                    } else if (zzdjm.zzatr() > 64) {
                        throw new GeneralSecurityException(str);
                    }
                } else if (zzdjm.zzatr() > 32) {
                    throw new GeneralSecurityException(str);
                }
            } else if (zzdjm.zzatr() > 20) {
                throw new GeneralSecurityException(str);
            }
        } else {
            throw new GeneralSecurityException("tag size too small");
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdsg zzt(zzdpm zzdpm) throws zzdrg {
        return zzdjj.zzbl(zzdpm);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdsg zzs(zzdpm zzdpm) throws zzdrg {
        return zzdji.zzbk(zzdpm);
    }

    public final /* synthetic */ zzdsg zzg(zzdsg zzdsg) throws GeneralSecurityException {
        zzdjj zzdjj = (zzdjj) zzdsg;
        return (zzdji) ((zzdqw) zzdji.zzatl().zzem(0).zzc(zzdjj.zzatk()).zzbm(zzdpm.zzy(zzdoj.zzff(zzdjj.getKeySize()))).zzazr());
    }

    public final /* synthetic */ Object zze(zzdsg zzdsg) throws GeneralSecurityException {
        zzdji zzdji = (zzdji) zzdsg;
        zzdjg zzatq = zzdji.zzatk().zzatq();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzdji.zzaqj().toByteArray(), "HMAC");
        int zzatr = zzdji.zzatk().zzatr();
        int i = zzdgj.zzgtk[zzatq.ordinal()];
        if (i == 1) {
            return new zzdoi("HMACSHA1", secretKeySpec, zzatr);
        }
        if (i == 2) {
            return new zzdoi("HMACSHA256", secretKeySpec, zzatr);
        }
        if (i == 3) {
            return new zzdoi("HMACSHA512", secretKeySpec, zzatr);
        }
        throw new GeneralSecurityException("unknown hash");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzd(zzdsg zzdsg) throws GeneralSecurityException {
        zzdjj zzdjj = (zzdjj) zzdsg;
        if (zzdjj.getKeySize() >= 16) {
            zza(zzdjj.zzatk());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzc(zzdsg zzdsg) throws GeneralSecurityException {
        zzdji zzdji = (zzdji) zzdsg;
        zzdou.zzx(zzdji.getVersion(), 0);
        if (zzdji.zzaqj().size() >= 16) {
            zza(zzdji.zzatk());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }
}
