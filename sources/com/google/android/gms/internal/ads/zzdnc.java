package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdnc {
    private final zzdog zzhcj;
    private final zzdog zzhck;

    public zzdnc(byte[] bArr, byte[] bArr2) {
        this.zzhcj = zzdog.zzu(bArr);
        this.zzhck = zzdog.zzu(bArr2);
    }

    public final byte[] zzaww() {
        zzdog zzdog = this.zzhcj;
        if (zzdog == null) {
            return null;
        }
        return zzdog.getBytes();
    }

    public final byte[] zzawx() {
        zzdog zzdog = this.zzhck;
        if (zzdog == null) {
            return null;
        }
        return zzdog.getBytes();
    }
}
