package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdwl<T> implements zzdwo<T> {
    private static final Object zzhxo = new Object();
    private volatile Object zzduz = zzhxo;
    private volatile zzdwo<T> zzhxp;

    private zzdwl(zzdwo<T> zzdwo) {
        this.zzhxp = zzdwo;
    }

    public final T get() {
        T t = this.zzduz;
        if (t != zzhxo) {
            return t;
        }
        zzdwo<T> zzdwo = this.zzhxp;
        if (zzdwo == null) {
            return this.zzduz;
        }
        T t2 = zzdwo.get();
        this.zzduz = t2;
        this.zzhxp = null;
        return t2;
    }

    public static <P extends zzdwo<T>, T> zzdwo<T> zzan(P p) {
        return ((p instanceof zzdwl) || (p instanceof zzdwc)) ? p : new zzdwl((zzdwo) zzdwh.checkNotNull(p));
    }
}
