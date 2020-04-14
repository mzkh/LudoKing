package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdjn.zzb;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdfp extends zzdem<zzdec, zzdkf, zzdkg> {
    public zzdfp() {
        super(zzdec.class, zzdkf.class, zzdkg.class, "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
    }

    public final int getVersion() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void zzd(zzdsg zzdsg) throws GeneralSecurityException {
    }

    /* access modifiers changed from: protected */
    public final zzb zzapp() {
        return zzb.REMOTE;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdsg zzt(zzdpm zzdpm) throws zzdrg {
        return zzdkg.zzbs(zzdpm);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdsg zzs(zzdpm zzdpm) throws zzdrg {
        return zzdkf.zzbr(zzdpm);
    }

    public final /* synthetic */ zzdsg zzg(zzdsg zzdsg) throws GeneralSecurityException {
        return (zzdkf) ((zzdqw) zzdkf.zzavd().zzb((zzdkg) zzdsg).zzey(0).zzazr());
    }

    public final /* synthetic */ Object zze(zzdsg zzdsg) throws GeneralSecurityException {
        zzdkf zzdkf = (zzdkf) zzdsg;
        String zzavf = zzdkf.zzavc().zzavf();
        return new zzdfm(zzdkf.zzavc().zzavg(), zzdeq.zzgp(zzavf).zzgr(zzavf));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzc(zzdsg zzdsg) throws GeneralSecurityException {
        zzdou.zzx(((zzdkf) zzdsg).getVersion(), 0);
    }
}
