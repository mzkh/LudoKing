package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdmx implements zzdel {
    private static final byte[] zzgtg = new byte[0];
    private final zzdmz zzhby;
    private final String zzhbz;
    private final byte[] zzhca;
    private final zzdns zzhcb;
    private final zzdmv zzhcc;

    public zzdmx(ECPublicKey eCPublicKey, byte[] bArr, String str, zzdns zzdns, zzdmv zzdmv) throws GeneralSecurityException {
        zzdno.zza(eCPublicKey);
        this.zzhby = new zzdmz(eCPublicKey);
        this.zzhca = bArr;
        this.zzhbz = str;
        this.zzhcb = zzdns;
        this.zzhcc = zzdmv;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzdnc zza = this.zzhby.zza(this.zzhbz, this.zzhca, bArr2, this.zzhcc.zzaqa(), this.zzhcb);
        byte[] zzc = this.zzhcc.zzl(zza.zzawx()).zzc(bArr, zzgtg);
        byte[] zzaww = zza.zzaww();
        return ByteBuffer.allocate(zzaww.length + zzc.length).put(zzaww).put(zzc).array();
    }
}
