package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdmm {
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    public static byte[] decode(String str) {
        byte[] bytes = str.getBytes(UTF_8);
        int length = bytes.length;
        zzdmo zzdmo = new zzdmo(2, new byte[((length * 3) / 4)]);
        if (!zzdmo.zzb(bytes, 0, length, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (zzdmo.zzhbk == zzdmo.zzhbj.length) {
            return zzdmo.zzhbj;
        } else {
            byte[] bArr = new byte[zzdmo.zzhbk];
            System.arraycopy(zzdmo.zzhbj, 0, bArr, 0, zzdmo.zzhbk);
            return bArr;
        }
    }
}
