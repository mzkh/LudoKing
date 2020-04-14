package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdjn.zzb;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdfl extends zzdem<zzdec, zzdhq, zzdhr> {
    public zzdfl() {
        super(zzdec.class, zzdhq.class, zzdhr.class, "type.googleapis.com/google.crypto.tink.AesGcmKey");
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
        return zzdhr.zzak(zzdpm);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdsg zzs(zzdpm zzdpm) throws zzdrg {
        return zzdhq.zzaj(zzdpm);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdsg zzg(zzdsg zzdsg) throws GeneralSecurityException {
        return (zzdhq) ((zzdqw) zzdhq.zzaro().zzal(zzdpm.zzy(zzdoj.zzff(((zzdhr) zzdsg).getKeySize()))).zzdz(0).zzazr());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zze(zzdsg zzdsg) throws GeneralSecurityException {
        return new zzdmh(((zzdhq) zzdsg).zzaqj().toByteArray());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzd(zzdsg zzdsg) throws GeneralSecurityException {
        zzdou.zzfg(((zzdhr) zzdsg).getKeySize());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzc(zzdsg zzdsg) throws GeneralSecurityException {
        zzdhq zzdhq = (zzdhq) zzdsg;
        zzdou.zzx(zzdhq.getVersion(), 0);
        zzdou.zzfg(zzdhq.zzaqj().size());
    }
}
