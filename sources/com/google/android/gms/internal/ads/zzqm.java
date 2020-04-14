package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzqm extends zzqf {
    private MessageDigest zzbql;

    public final byte[] zzbq(String str) {
        byte[] bArr;
        String[] split = str.split(" ");
        int i = 4;
        if (split.length == 1) {
            int zzbs = zzqj.zzbs(split[0]);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(zzbs);
            bArr = allocate.array();
        } else if (split.length < 5) {
            bArr = new byte[(split.length << 1)];
            for (int i2 = 0; i2 < split.length; i2++) {
                int zzbs2 = zzqj.zzbs(split[i2]);
                int i3 = (zzbs2 >> 16) ^ (65535 & zzbs2);
                byte[] bArr2 = {(byte) i3, (byte) (i3 >> 8)};
                int i4 = i2 << 1;
                bArr[i4] = bArr2[0];
                bArr[i4 + 1] = bArr2[1];
            }
        } else {
            bArr = new byte[split.length];
            for (int i5 = 0; i5 < split.length; i5++) {
                int zzbs3 = zzqj.zzbs(split[i5]);
                bArr[i5] = (byte) ((zzbs3 >> 24) ^ (((zzbs3 & 255) ^ ((zzbs3 >> 8) & 255)) ^ ((zzbs3 >> 16) & 255)));
            }
        }
        this.zzbql = zzlz();
        synchronized (this.mLock) {
            if (this.zzbql == null) {
                byte[] bArr3 = new byte[0];
                return bArr3;
            }
            this.zzbql.reset();
            this.zzbql.update(bArr);
            byte[] digest = this.zzbql.digest();
            if (digest.length <= 4) {
                i = digest.length;
            }
            byte[] bArr4 = new byte[i];
            System.arraycopy(digest, 0, bArr4, 0, bArr4.length);
            return bArr4;
        }
    }
}
