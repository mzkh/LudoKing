package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzdvt {
    public abstract void zzhr(String str);

    public static zzdvt zzn(Class cls) {
        if (System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik")) {
            return new zzdvq(cls.getSimpleName());
        }
        return new zzdvs(cls.getSimpleName());
    }
}
