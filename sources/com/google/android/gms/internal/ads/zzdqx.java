package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
public final class zzdqx {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final byte[] zzhlj;
    private static final ByteBuffer zzhlk;
    private static final zzdpy zzhll;

    public static int zzbj(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zzfk(long j) {
        return (int) (j ^ (j >>> 32));
    }

    static boolean zzn(zzdsg zzdsg) {
        return false;
    }

    static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    static <T> T zza(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean zzac(byte[] bArr) {
        return zzdtw.zzac(bArr);
    }

    public static String zzad(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int zza = zza(length, bArr, 0, length);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 = (i4 * 31) + bArr[i5];
        }
        return i4;
    }

    static Object zzd(Object obj, Object obj2) {
        return ((zzdsg) obj).zzazx().zzi((zzdsg) obj2).zzazq();
    }

    static {
        byte[] bArr = new byte[0];
        zzhlj = bArr;
        zzhlk = ByteBuffer.wrap(bArr);
        byte[] bArr2 = zzhlj;
        zzhll = zzdpy.zzc(bArr2, 0, bArr2.length, false);
    }
}
