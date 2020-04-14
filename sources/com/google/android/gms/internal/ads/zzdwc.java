package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdwc<T> implements zzdvv<T>, zzdwo<T> {
    private static final Object zzhxo = new Object();
    private volatile Object zzduz = zzhxo;
    private volatile zzdwo<T> zzhxp;

    private zzdwc(zzdwo<T> zzdwo) {
        this.zzhxp = zzdwo;
    }

    public final T get() {
        T t = this.zzduz;
        if (t == zzhxo) {
            synchronized (this) {
                t = this.zzduz;
                if (t == zzhxo) {
                    t = this.zzhxp.get();
                    T t2 = this.zzduz;
                    if (t2 != zzhxo && !(t2 instanceof zzdwi)) {
                        if (t2 != t) {
                            String valueOf = String.valueOf(t2);
                            String valueOf2 = String.valueOf(t);
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118 + String.valueOf(valueOf2).length());
                            sb.append("Scoped provider was invoked recursively returning different results: ");
                            sb.append(valueOf);
                            sb.append(" & ");
                            sb.append(valueOf2);
                            sb.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    this.zzduz = t;
                    this.zzhxp = null;
                }
            }
        }
        return t;
    }

    public static <P extends zzdwo<T>, T> zzdwo<T> zzan(P p) {
        zzdwh.checkNotNull(p);
        if (p instanceof zzdwc) {
            return p;
        }
        return new zzdwc(p);
    }

    public static <P extends zzdwo<T>, T> zzdvv<T> zzao(P p) {
        if (p instanceof zzdvv) {
            return (zzdvv) p;
        }
        return new zzdwc((zzdwo) zzdwh.checkNotNull(p));
    }
}
