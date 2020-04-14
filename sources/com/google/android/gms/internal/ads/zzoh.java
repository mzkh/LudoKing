package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzoh {
    private final int height;
    private final int width;
    public final List<byte[]> zzafe;
    public final int zzaqq;
    public final float zzbgk;

    public static zzoh zzf(zzoc zzoc) throws zzgv {
        float f;
        int i;
        int i2;
        try {
            zzoc.zzbh(4);
            int readUnsignedByte = (zzoc.readUnsignedByte() & 3) + 1;
            if (readUnsignedByte != 3) {
                ArrayList arrayList = new ArrayList();
                int readUnsignedByte2 = zzoc.readUnsignedByte() & 31;
                for (int i3 = 0; i3 < readUnsignedByte2; i3++) {
                    arrayList.add(zzg(zzoc));
                }
                int readUnsignedByte3 = zzoc.readUnsignedByte();
                for (int i4 = 0; i4 < readUnsignedByte3; i4++) {
                    arrayList.add(zzg(zzoc));
                }
                if (readUnsignedByte2 > 0) {
                    zzoa zzd = zznx.zzd((byte[]) arrayList.get(0), readUnsignedByte, ((byte[]) arrayList.get(0)).length);
                    int i5 = zzd.width;
                    int i6 = zzd.height;
                    f = zzd.zzbgk;
                    i2 = i5;
                    i = i6;
                } else {
                    i2 = -1;
                    i = -1;
                    f = 1.0f;
                }
                zzoh zzoh = new zzoh(arrayList, readUnsignedByte, i2, i, f);
                return zzoh;
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzgv("Error parsing AVC config", e);
        }
    }

    private zzoh(List<byte[]> list, int i, int i2, int i3, float f) {
        this.zzafe = list;
        this.zzaqq = i;
        this.width = i2;
        this.height = i3;
        this.zzbgk = f;
    }

    private static byte[] zzg(zzoc zzoc) {
        int readUnsignedShort = zzoc.readUnsignedShort();
        int position = zzoc.getPosition();
        zzoc.zzbh(readUnsignedShort);
        return zznu.zzc(zzoc.data, position, readUnsignedShort);
    }
}
