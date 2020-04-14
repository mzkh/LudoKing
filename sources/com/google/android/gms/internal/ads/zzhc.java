package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzhc {
    private static final int[] zzagk = {1, 2, 3, 6};
    private static final int[] zzagl = {48000, 44100, 32000};
    private static final int[] zzagm = {24000, 22050, 16000};
    private static final int[] zzagn = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzago = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] zzagp = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static zzgo zza(zzoc zzoc, String str, String str2, zzin zzin) {
        int i = zzagl[(zzoc.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzoc.readUnsignedByte();
        int i2 = zzagn[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i2++;
        }
        return zzgo.zza(str, "audio/ac3", null, -1, -1, i2, i, null, null, 0, str2);
    }

    public static int zzes() {
        return 1536;
    }

    public static zzgo zzb(zzoc zzoc, String str, String str2, zzin zzin) {
        zzoc.zzbh(2);
        int i = zzagl[(zzoc.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzoc.readUnsignedByte();
        int i2 = zzagn[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i2++;
        }
        return zzgo.zza(str, "audio/eac3", null, -1, -1, i2, i, null, null, 0, str2);
    }

    public static int zzh(ByteBuffer byteBuffer) {
        int i = 6;
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i = zzagk[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        return i * 256;
    }
}
