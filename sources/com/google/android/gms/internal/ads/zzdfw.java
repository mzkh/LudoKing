package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdjn.zzb;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdfw extends zzdem<zzdei, zzdis, zzdio> implements zzden<zzdei> {
    public zzdfw() {
        super(zzdei.class, zzdis.class, zzdio.class, "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
    }

    public final int getVersion() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final zzb zzapp() {
        return zzb.ASYMMETRIC_PRIVATE;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdsg zzt(zzdpm zzdpm) throws zzdrg {
        return zzdio.zzaz(zzdpm);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdsg zzs(zzdpm zzdpm) throws zzdrg {
        return zzdis.zzba(zzdpm);
    }

    public final /* synthetic */ zzdsg zzg(zzdsg zzdsg) throws GeneralSecurityException {
        zzdio zzdio = (zzdio) zzdsg;
        KeyPair zza = zzdno.zza(zzdno.zza(zzdgf.zza(zzdio.zzaso().zzasq().zzatb())));
        ECPublicKey eCPublicKey = (ECPublicKey) zza.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) zza.getPrivate();
        ECPoint w = eCPublicKey.getW();
        return (zzdis) ((zzdqw) zzdis.zzasw().zzeg(0).zzb((zzdit) ((zzdqw) zzdit.zzasy().zzeh(0).zzc(zzdio.zzaso()).zzbd(zzdpm.zzy(w.getAffineX().toByteArray())).zzbe(zzdpm.zzy(w.getAffineY().toByteArray())).zzazr())).zzbc(zzdpm.zzy(eCPrivateKey.getS().toByteArray())).zzazr());
    }

    public final /* synthetic */ Object zze(zzdsg zzdsg) throws GeneralSecurityException {
        zzdis zzdis = (zzdis) zzdsg;
        zzdip zzaso = zzdis.zzasv().zzaso();
        zzdiw zzasq = zzaso.zzasq();
        zzdmy zzdmy = new zzdmy(zzdno.zza(zzdgf.zza(zzasq.zzatb()), zzdis.zzaqj().toByteArray()), zzasq.zzatc().toByteArray(), zzdgf.zza(zzasq.zzaqp()), zzdgf.zza(zzaso.zzass()), new zzdgh(zzaso.zzasr().zzasl()));
        return zzdmy;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzd(zzdsg zzdsg) throws GeneralSecurityException {
        zzdgf.zza(((zzdio) zzdsg).zzaso());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzc(zzdsg zzdsg) throws GeneralSecurityException {
        zzdis zzdis = (zzdis) zzdsg;
        if (!(zzdis.zzaqj().size() == 0)) {
            zzdou.zzx(zzdis.getVersion(), 0);
            zzdgf.zza(zzdis.zzasv().zzaso());
            return;
        }
        throw new GeneralSecurityException("invalid ECIES private key");
    }
}
