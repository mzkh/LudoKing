package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbar extends zzay {
    static final zzbar zzedb = new zzbar();

    zzbar() {
    }

    public final zzbb zza(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzbd();
        }
        if ("mvhd".equals(str)) {
            return new zzbg();
        }
        return new zzbf(str);
    }
}
