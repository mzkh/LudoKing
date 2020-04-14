package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzdus {
    protected volatile int zzhrh = -1;

    public void zza(zzduj zzduj) throws IOException {
    }

    /* access modifiers changed from: protected */
    public int zznx() {
        return 0;
    }

    public final int zzazu() {
        int zznx = zznx();
        this.zzhrh = zznx;
        return zznx;
    }

    public static final byte[] zzb(zzdus zzdus) {
        byte[] bArr = new byte[zzdus.zzazu()];
        try {
            zzduj zzp = zzduj.zzp(bArr, 0, bArr.length);
            zzdus.zza(zzp);
            zzp.zzayv();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public String toString() {
        return zzdur.zza(this);
    }

    /* renamed from: zzbci */
    public zzdus clone() throws CloneNotSupportedException {
        return (zzdus) super.clone();
    }
}
