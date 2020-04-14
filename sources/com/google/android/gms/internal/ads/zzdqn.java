package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdqn {
    private static final zzdql<?> zzhht = new zzdqk();
    private static final zzdql<?> zzhhu = zzaze();

    private static zzdql<?> zzaze() {
        try {
            return (zzdql) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzdql<?> zzazf() {
        return zzhht;
    }

    static zzdql<?> zzazg() {
        zzdql<?> zzdql = zzhhu;
        if (zzdql != null) {
            return zzdql;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
