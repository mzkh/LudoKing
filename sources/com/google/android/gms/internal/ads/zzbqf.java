package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbqf implements zzdwb<zzbpn> {
    private final zzbpn zzfhv;

    private zzbqf(zzbpn zzbpn) {
        this.zzfhv = zzbpn;
    }

    public static zzbqf zzv(zzbpn zzbpn) {
        return new zzbqf(zzbpn);
    }

    public final /* synthetic */ Object get() {
        zzbpn zzbpn = this.zzfhv;
        if (zzbpn != null) {
            return (zzbpn) zzdwh.zza(zzbpn, "Cannot return null from a non-@Nullable @Provides method");
        }
        throw null;
    }
}
