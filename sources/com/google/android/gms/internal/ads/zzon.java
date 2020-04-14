package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzon {
    public final List<byte[]> zzafe;
    public final int zzaqq;

    public static zzon zzh(zzoc zzoc) throws zzgv {
        List list;
        try {
            zzoc.zzbh(21);
            int readUnsignedByte = zzoc.readUnsignedByte() & 3;
            int readUnsignedByte2 = zzoc.readUnsignedByte();
            int position = zzoc.getPosition();
            int i = 0;
            int i2 = 0;
            while (i < readUnsignedByte2) {
                zzoc.zzbh(1);
                int readUnsignedShort = zzoc.readUnsignedShort();
                int i3 = i2;
                for (int i4 = 0; i4 < readUnsignedShort; i4++) {
                    int readUnsignedShort2 = zzoc.readUnsignedShort();
                    i3 += readUnsignedShort2 + 4;
                    zzoc.zzbh(readUnsignedShort2);
                }
                i++;
                i2 = i3;
            }
            zzoc.zzbg(position);
            byte[] bArr = new byte[i2];
            int i5 = 0;
            int i6 = 0;
            while (i5 < readUnsignedByte2) {
                zzoc.zzbh(1);
                int readUnsignedShort3 = zzoc.readUnsignedShort();
                int i7 = i6;
                for (int i8 = 0; i8 < readUnsignedShort3; i8++) {
                    int readUnsignedShort4 = zzoc.readUnsignedShort();
                    System.arraycopy(zznx.zzbfz, 0, bArr, i7, zznx.zzbfz.length);
                    int length = i7 + zznx.zzbfz.length;
                    System.arraycopy(zzoc.data, zzoc.getPosition(), bArr, length, readUnsignedShort4);
                    i7 = length + readUnsignedShort4;
                    zzoc.zzbh(readUnsignedShort4);
                }
                i5++;
                i6 = i7;
            }
            if (i2 == 0) {
                list = null;
            } else {
                list = Collections.singletonList(bArr);
            }
            return new zzon(list, readUnsignedByte + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzgv("Error parsing HEVC config", e);
        }
    }

    private zzon(List<byte[]> list, int i) {
        this.zzafe = list;
        this.zzaqq = i;
    }
}
