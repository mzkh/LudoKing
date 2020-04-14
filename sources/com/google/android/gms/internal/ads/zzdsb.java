package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdsb {
    private static final zzdrz zzhmx = zzbax();
    private static final zzdrz zzhmy = new zzdsc();

    static zzdrz zzbav() {
        return zzhmx;
    }

    static zzdrz zzbaw() {
        return zzhmy;
    }

    private static zzdrz zzbax() {
        try {
            return (zzdrz) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
