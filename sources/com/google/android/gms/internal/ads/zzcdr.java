package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzcdr implements zzdcj<zzape, zzcvz> {
    /* access modifiers changed from: private */
    public final zzbox zzfun;

    public zzcdr(zzbox zzbox) {
        this.zzfun = zzbox;
    }

    /* access modifiers changed from: protected */
    public abstract zzddi<zzcvz> zze(zzape zzape) throws zzccu;

    public final /* synthetic */ zzddi zzf(Object obj) throws Exception {
        zzape zzape = (zzape) obj;
        this.zzfun.zzb(zzape);
        zzddi zze = zze(zzape);
        zzdcy.zza(zze, new zzcdq(this), zzaxn.zzdwn);
        return zze;
    }
}
