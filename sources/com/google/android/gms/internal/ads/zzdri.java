package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
public enum zzdri {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, Integer.valueOf(0)),
    LONG(Long.TYPE, Long.class, Long.valueOf(0)),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.valueOf(false)),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzdpm.class, zzdpm.class, zzdpm.zzhgb),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    
    private final Class<?> zzhlz;
    private final Class<?> zzhma;
    private final Object zzhmb;

    private zzdri(Class<?> cls, Class<?> cls2, Object obj) {
        this.zzhlz = cls;
        this.zzhma = cls2;
        this.zzhmb = obj;
    }

    public final Class<?> zzbal() {
        return this.zzhma;
    }
}
