package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdjn.zzb;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdfh extends zzdem<zzdec, zzdgo, zzdgp> {
    public zzdfh() throws GeneralSecurityException {
        super(zzdec.class, zzdgo.class, zzdgp.class, "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzdey.zza((zzden<P>) new zzdfj<P>());
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
        return zzdgp.zzv(zzdpm);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdsg zzs(zzdpm zzdpm) throws zzdrg {
        return zzdgo.zzu(zzdpm);
    }

    public final /* synthetic */ zzdsg zzg(zzdsg zzdsg) throws GeneralSecurityException {
        zzdgp zzdgp = (zzdgp) zzdsg;
        zzdgx zzdgx = (zzdgx) zzdey.zza("type.googleapis.com/google.crypto.tink.AesCtrKey", (zzdsg) zzdgp.zzaqf());
        return (zzdgo) ((zzdqw) zzdgo.zzaqd().zzb(zzdgx).zzb((zzdji) zzdey.zza("type.googleapis.com/google.crypto.tink.HmacKey", (zzdsg) zzdgp.zzaqg())).zzdu(0).zzazr());
    }

    public final /* synthetic */ Object zze(zzdsg zzdsg) throws GeneralSecurityException {
        zzdgo zzdgo = (zzdgo) zzdsg;
        return new zzdnr((zzdof) zzdey.zza("type.googleapis.com/google.crypto.tink.AesCtrKey", (zzdsg) zzdgo.zzaqb(), zzdof.class), (zzdet) zzdey.zza("type.googleapis.com/google.crypto.tink.HmacKey", (zzdsg) zzdgo.zzaqc(), zzdet.class), zzdgo.zzaqc().zzatk().zzatr());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzd(zzdsg zzdsg) throws GeneralSecurityException {
        zzdou.zzfg(((zzdgp) zzdsg).zzaqf().getKeySize());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzc(zzdsg zzdsg) throws GeneralSecurityException {
        zzdou.zzx(((zzdgo) zzdsg).getVersion(), 0);
    }
}
