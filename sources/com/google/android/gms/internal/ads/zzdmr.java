package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
abstract class zzdmr implements zzdec {
    private final zzdmp zzhbr;
    private final zzdmp zzhbs;

    public zzdmr(byte[] bArr) throws InvalidKeyException {
        this.zzhbr = zzd(bArr, 1);
        this.zzhbs = zzd(bArr, 0);
    }

    /* access modifiers changed from: 0000 */
    public abstract zzdmp zzd(byte[] bArr, int i) throws InvalidKeyException;

    public byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length <= (Integer.MAX_VALUE - this.zzhbr.zzawv()) - 16) {
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length + this.zzhbr.zzawv() + 16);
            if (allocate.remaining() >= bArr.length + this.zzhbr.zzawv() + 16) {
                int position = allocate.position();
                this.zzhbr.zza(allocate, bArr);
                allocate.position(position);
                byte[] bArr3 = new byte[this.zzhbr.zzawv()];
                allocate.get(bArr3);
                allocate.limit(allocate.limit() - 16);
                if (bArr2 == null) {
                    bArr2 = new byte[0];
                }
                byte[] bArr4 = new byte[32];
                this.zzhbs.zzc(bArr3, 0).get(bArr4);
                int length = bArr2.length % 16 == 0 ? bArr2.length : (bArr2.length + 16) - (bArr2.length % 16);
                int remaining = allocate.remaining();
                int i = remaining % 16;
                int i2 = (i == 0 ? remaining : (remaining + 16) - i) + length;
                ByteBuffer order = ByteBuffer.allocate(i2 + 16).order(ByteOrder.LITTLE_ENDIAN);
                order.put(bArr2);
                order.position(length);
                order.put(allocate);
                order.position(i2);
                order.putLong((long) bArr2.length);
                order.putLong((long) remaining);
                byte[] zzf = zzdok.zzf(bArr4, order.array());
                allocate.limit(allocate.limit() + 16);
                allocate.put(zzf);
                return allocate.array();
            }
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
