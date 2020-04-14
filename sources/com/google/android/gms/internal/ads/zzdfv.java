package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdjn.zzb;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdfv extends zzdem<zzdel, zzdit, zzdjc> {
    public zzdfv() {
        super(zzdel.class, zzdit.class, zzdjc.class, "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
    }

    public final int getVersion() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void zzd(zzdsg zzdsg) throws GeneralSecurityException {
    }

    /* access modifiers changed from: protected */
    public final zzb zzapp() {
        return zzb.ASYMMETRIC_PUBLIC;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdsg zzt(zzdpm zzdpm) throws zzdrg {
        return zzdjc.zzbj(zzdpm);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdsg zzs(zzdpm zzdpm) throws zzdrg {
        return zzdit.zzbb(zzdpm);
    }

    public final /* synthetic */ zzdsg zzg(zzdsg zzdsg) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zze(zzdsg zzdsg) throws GeneralSecurityException {
        zzdit zzdit = (zzdit) zzdsg;
        zzdip zzaso = zzdit.zzaso();
        zzdiw zzasq = zzaso.zzasq();
        zzdmx zzdmx = new zzdmx(zzdno.zza(zzdgf.zza(zzasq.zzatb()), zzdit.zzasg().toByteArray(), zzdit.zzash().toByteArray()), zzasq.zzatc().toByteArray(), zzdgf.zza(zzasq.zzaqp()), zzdgf.zza(zzaso.zzass()), new zzdgh(zzaso.zzasr().zzasl()));
        return zzdmx;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzc(zzdsg zzdsg) throws GeneralSecurityException {
        zzdit zzdit = (zzdit) zzdsg;
        zzdou.zzx(zzdit.getVersion(), 0);
        zzdgf.zza(zzdit.zzaso());
    }
}
