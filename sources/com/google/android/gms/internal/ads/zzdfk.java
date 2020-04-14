package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdjn.zzb;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdfk extends zzdem<zzdec, zzdhy, zzdjc> {
    public zzdfk() {
        super(zzdec.class, zzdhy.class, zzdjc.class, "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
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
        return zzdhy.zzap(zzdpm);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdsg zzg(zzdsg zzdsg) throws GeneralSecurityException {
        return (zzdhy) ((zzdqw) zzdhy.zzaru().zzec(0).zzaq(zzdpm.zzy(zzdoj.zzff(32))).zzazr());
    }

    public final /* synthetic */ Object zze(zzdsg zzdsg) throws GeneralSecurityException {
        return new zzdms(((zzdhy) zzdsg).zzaqj().toByteArray());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzc(zzdsg zzdsg) throws GeneralSecurityException {
        zzdhy zzdhy = (zzdhy) zzdsg;
        zzdou.zzx(zzdhy.getVersion(), 0);
        if (zzdhy.zzaqj().size() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }
}
