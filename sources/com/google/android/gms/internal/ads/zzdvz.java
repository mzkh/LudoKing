package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdvz<T> implements zzdwb<T> {
    private zzdwo<T> zzhxn;

    public final T get() {
        zzdwo<T> zzdwo = this.zzhxn;
        if (zzdwo != null) {
            return zzdwo.get();
        }
        throw new IllegalStateException();
    }

    public static <T> void zzaw(zzdwo<T> zzdwo, zzdwo<T> zzdwo2) {
        zzdwh.checkNotNull(zzdwo2);
        zzdvz zzdvz = (zzdvz) zzdwo;
        if (zzdvz.zzhxn == null) {
            zzdvz.zzhxn = zzdwo2;
            return;
        }
        throw new IllegalStateException();
    }
}
