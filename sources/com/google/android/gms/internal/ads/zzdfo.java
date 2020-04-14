package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdjn.zzb;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdfo extends zzdem<zzdec, zzdlc, zzdjc> {
    public zzdfo() {
        super(zzdec.class, zzdlc.class, zzdjc.class, "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
    }

    public final int getVersion() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void zzd(zzdsg zzdsg) throws GeneralSecurityException {
    }

    /* access modifiers changed from: protected */
    public final zzb zzapp() {
        return zzb.SYMMETRIC;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdsg zzt(zzdpm zzdpm) throws zzdrg {
        return zzdjc.zzbj(zzdpm);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdsg zzs(zzdpm zzdpm) throws zzdrg {
        return zzdlc.zzcv(zzdpm);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdsg zzg(zzdsg zzdsg) throws GeneralSecurityException {
        return (zzdlc) ((zzdqw) zzdlc.zzaws().zzfe(0).zzcy(zzdpm.zzy(zzdoj.zzff(32))).zzazr());
    }

    public final /* synthetic */ Object zze(zzdsg zzdsg) throws GeneralSecurityException {
        return new zzdov(((zzdlc) zzdsg).zzaqj().toByteArray());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzc(zzdsg zzdsg) throws GeneralSecurityException {
        zzdlc zzdlc = (zzdlc) zzdsg;
        zzdou.zzx(zzdlc.getVersion(), 0);
        if (zzdlc.zzaqj().size() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }
}
