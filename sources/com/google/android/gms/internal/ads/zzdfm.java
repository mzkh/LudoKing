package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdfm implements zzdec {
    private static final byte[] zzgtg = new byte[0];
    private final zzdjt zzgth;
    private final zzdec zzgti;

    public zzdfm(zzdjt zzdjt, zzdec zzdec) {
        this.zzgth = zzdjt;
        this.zzgti = zzdec;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] byteArray = zzdey.zzb(this.zzgth).toByteArray();
        byte[] zzc = this.zzgti.zzc(byteArray, zzgtg);
        byte[] zzc2 = ((zzdec) zzdey.zza(this.zzgth.zzatu(), byteArray, zzdec.class)).zzc(bArr, bArr2);
        return ByteBuffer.allocate(zzc.length + 4 + zzc2.length).putInt(zzc.length).put(zzc).put(zzc2).array();
    }
}
