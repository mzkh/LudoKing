package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzz<T> {
    public final T result;
    public final zzd zzbh;
    public final zzae zzbi;
    public boolean zzbj;

    public static <T> zzz<T> zza(T t, zzd zzd) {
        return new zzz<>(t, zzd);
    }

    public static <T> zzz<T> zzd(zzae zzae) {
        return new zzz<>(zzae);
    }

    private zzz(T t, zzd zzd) {
        this.zzbj = false;
        this.result = t;
        this.zzbh = zzd;
        this.zzbi = null;
    }

    private zzz(zzae zzae) {
        this.zzbj = false;
        this.result = null;
        this.zzbh = null;
        this.zzbi = zzae;
    }
}
