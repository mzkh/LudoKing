package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdsr {
    private static final zzdsr zzhnt = new zzdsr();
    private final zzdsy zzhnu = new zzdrt();
    private final ConcurrentMap<Class<?>, zzdsv<?>> zzhnv = new ConcurrentHashMap();

    public static zzdsr zzbbf() {
        return zzhnt;
    }

    public final <T> zzdsv<T> zzh(Class<T> cls) {
        String str = "messageType";
        zzdqx.zza(cls, str);
        zzdsv<T> zzdsv = (zzdsv) this.zzhnv.get(cls);
        if (zzdsv != null) {
            return zzdsv;
        }
        zzdsv<T> zzg = this.zzhnu.zzg(cls);
        zzdqx.zza(cls, str);
        zzdqx.zza(zzg, "schema");
        zzdsv zzdsv2 = (zzdsv) this.zzhnv.putIfAbsent(cls, zzg);
        return zzdsv2 != null ? zzdsv2 : zzg;
    }

    public final <T> zzdsv<T> zzax(T t) {
        return zzh(t.getClass());
    }

    private zzdsr() {
    }
}
