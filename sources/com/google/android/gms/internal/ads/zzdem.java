package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdjn.zzb;
import com.google.android.gms.internal.ads.zzdsg;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzdem<P, KeyProto extends zzdsg, KeyFormatProto extends zzdsg> implements zzden<P> {
    private final Class<P> zzgsl;
    private final Class<KeyProto> zzgsm;
    private final Class<KeyFormatProto> zzgsn;
    private final String zzgso;

    protected zzdem(Class<P> cls, Class<KeyProto> cls2, Class<KeyFormatProto> cls3, String str) {
        this.zzgsl = cls;
        this.zzgsm = cls2;
        this.zzgsn = cls3;
        this.zzgso = str;
    }

    /* access modifiers changed from: protected */
    public abstract zzb zzapp();

    /* access modifiers changed from: protected */
    public abstract void zzc(KeyProto keyproto) throws GeneralSecurityException;

    /* access modifiers changed from: protected */
    public abstract void zzd(KeyFormatProto keyformatproto) throws GeneralSecurityException;

    /* access modifiers changed from: protected */
    public abstract P zze(KeyProto keyproto) throws GeneralSecurityException;

    /* access modifiers changed from: protected */
    public abstract KeyProto zzg(KeyFormatProto keyformatproto) throws GeneralSecurityException;

    /* access modifiers changed from: protected */
    public abstract KeyProto zzs(zzdpm zzdpm) throws zzdrg;

    /* access modifiers changed from: protected */
    public abstract KeyFormatProto zzt(zzdpm zzdpm) throws zzdrg;

    private static <Casted> Casted zza(Object obj, String str, Class<Casted> cls) throws GeneralSecurityException {
        if (cls.isInstance(obj)) {
            return obj;
        }
        throw new GeneralSecurityException(str);
    }

    public final P zzp(zzdpm zzdpm) throws GeneralSecurityException {
        try {
            return zzf(zzs(zzdpm));
        } catch (zzdrg e) {
            String str = "Failures parsing proto of type ";
            String valueOf = String.valueOf(this.zzgsm.getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), e);
        }
    }

    public final P zza(zzdsg zzdsg) throws GeneralSecurityException {
        String valueOf = String.valueOf(this.zzgsm.getName());
        String str = "Expected proto of type ";
        return zzf((zzdsg) zza(zzdsg, valueOf.length() != 0 ? str.concat(valueOf) : new String(str), this.zzgsm));
    }

    public final zzdsg zzq(zzdpm zzdpm) throws GeneralSecurityException {
        try {
            return zzh(zzt(zzdpm));
        } catch (zzdrg e) {
            String str = "Failures parsing proto of type ";
            String valueOf = String.valueOf(this.zzgsn.getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), e);
        }
    }

    public final zzdsg zzb(zzdsg zzdsg) throws GeneralSecurityException {
        String valueOf = String.valueOf(this.zzgsn.getName());
        String str = "Expected proto of type ";
        return zzh((zzdsg) zza(zzdsg, valueOf.length() != 0 ? str.concat(valueOf) : new String(str), this.zzgsn));
    }

    public final String getKeyType() {
        return this.zzgso;
    }

    public final zzdjn zzr(zzdpm zzdpm) throws GeneralSecurityException {
        try {
            return (zzdjn) ((zzdqw) zzdjn.zzatx().zzgw(this.zzgso).zzbo(zzh(zzt(zzdpm)).zzaxg()).zzb(zzapp()).zzazr());
        } catch (zzdrg e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }

    public final Class<P> zzapo() {
        return this.zzgsl;
    }

    private final P zzf(KeyProto keyproto) throws GeneralSecurityException {
        zzc(keyproto);
        return zze(keyproto);
    }

    private final KeyProto zzh(KeyFormatProto keyformatproto) throws GeneralSecurityException {
        zzd(keyformatproto);
        KeyProto zzg = zzg(keyformatproto);
        zzc(zzg);
        return zzg;
    }
}
