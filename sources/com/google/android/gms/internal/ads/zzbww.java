package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbww implements zzdcj {
    private final zzddi zzfov;

    zzbww(zzddi zzddi) {
        this.zzfov = zzddi;
    }

    public final zzddi zzf(Object obj) {
        zzddi zzddi = this.zzfov;
        if (obj != null) {
            return zzddi;
        }
        return zzdcy.zzi(new zzcjh("Retrieve required value in native ad response failed.", 0));
    }
}
