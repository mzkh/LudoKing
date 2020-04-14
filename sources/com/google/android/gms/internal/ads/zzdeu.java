package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdeu<P> {
    private final P zzgsr;
    private final byte[] zzgss;
    private final zzdjr zzgst;
    private final zzdkj zzgsu;

    public zzdeu(P p, byte[] bArr, zzdjr zzdjr, zzdkj zzdkj) {
        this.zzgsr = p;
        this.zzgss = Arrays.copyOf(bArr, bArr.length);
        this.zzgst = zzdjr;
        this.zzgsu = zzdkj;
    }

    public final P zzapr() {
        return this.zzgsr;
    }

    public final zzdjr zzaps() {
        return this.zzgst;
    }

    public final zzdkj zzapt() {
        return this.zzgsu;
    }

    public final byte[] zzapu() {
        byte[] bArr = this.zzgss;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }
}
