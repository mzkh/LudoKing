package com.google.android.gms.internal.ads;

import com.google.firebase.messaging.cpp.SerializedEventUnion;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbc {
    public static int zza(byte b) {
        return b < 0 ? b + SerializedEventUnion.NONE : b;
    }

    public static long zza(ByteBuffer byteBuffer) {
        long j = (long) byteBuffer.getInt();
        return j < 0 ? j + 4294967296L : j;
    }

    public static int zzb(ByteBuffer byteBuffer) {
        return (zza(byteBuffer.get()) << 8) + 0 + zza(byteBuffer.get());
    }

    public static long zzc(ByteBuffer byteBuffer) {
        long zza = (zza(byteBuffer) << 32) + 0;
        if (zza >= 0) {
            return zza + zza(byteBuffer);
        }
        throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
    }

    public static double zzd(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        double d = (double) (0 | ((bArr[0] << 24) & SerializedEventUnion.NONE) | ((bArr[1] << 16) & SerializedEventUnion.NONE) | ((bArr[2] << 8) & SerializedEventUnion.NONE) | (bArr[3] & 255));
        Double.isNaN(d);
        return d / 65536.0d;
    }

    public static double zze(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        double d = (double) (0 | ((bArr[0] << 24) & SerializedEventUnion.NONE) | ((bArr[1] << 16) & SerializedEventUnion.NONE) | ((bArr[2] << 8) & SerializedEventUnion.NONE) | (bArr[3] & 255));
        Double.isNaN(d);
        return d / 1.073741824E9d;
    }

    public static String zzf(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
