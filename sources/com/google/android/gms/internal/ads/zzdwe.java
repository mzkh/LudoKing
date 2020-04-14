package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdwe<T> implements zzdvv<T>, zzdwb<T> {
    private static final zzdwe<Object> zzhxr = new zzdwe<>(null);
    private final T zzduz;

    public static <T> zzdwb<T> zzbb(T t) {
        return new zzdwe(zzdwh.zza(t, "instance cannot be null"));
    }

    public static <T> zzdwb<T> zzbc(T t) {
        if (t == null) {
            return zzhxr;
        }
        return new zzdwe(t);
    }

    private zzdwe(T t) {
        this.zzduz = t;
    }

    public final T get() {
        return this.zzduz;
    }
}
