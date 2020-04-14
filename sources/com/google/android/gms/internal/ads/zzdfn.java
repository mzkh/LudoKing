package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdjn.zzb;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdfn extends zzdem<zzdec, zzdkb, zzdkc> {
    public zzdfn() {
        super(zzdec.class, zzdkb.class, zzdkc.class, "type.googleapis.com/google.crypto.tink.KmsAeadKey");
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
        return zzdkc.zzbq(zzdpm);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdsg zzs(zzdpm zzdpm) throws zzdrg {
        return zzdkb.zzbp(zzdpm);
    }

    public final /* synthetic */ zzdsg zzg(zzdsg zzdsg) throws GeneralSecurityException {
        return (zzdkb) ((zzdqw) zzdkb.zzaux().zzb((zzdkc) zzdsg).zzex(0).zzazr());
    }

    public final /* synthetic */ Object zze(zzdsg zzdsg) throws GeneralSecurityException {
        String zzauz = ((zzdkb) zzdsg).zzauw().zzauz();
        return zzdeq.zzgp(zzauz).zzgr(zzauz);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzc(zzdsg zzdsg) throws GeneralSecurityException {
        zzdou.zzx(((zzdkb) zzdsg).getVersion(), 0);
    }
}
