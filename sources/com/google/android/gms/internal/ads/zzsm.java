package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzsm {
    private final byte[] zzbtz;
    private int zzbua;
    private int zzbub;
    private final /* synthetic */ zzsi zzbuc;

    private zzsm(zzsi zzsi, byte[] bArr) {
        this.zzbuc = zzsi;
        this.zzbtz = bArr;
    }

    public final synchronized void zzdh() {
        try {
            if (this.zzbuc.zzbtx) {
                this.zzbuc.zzbtw.zzc(this.zzbtz);
                this.zzbuc.zzbtw.zzl(this.zzbua);
                this.zzbuc.zzbtw.zzm(this.zzbub);
                this.zzbuc.zzbtw.zza(null);
                this.zzbuc.zzbtw.zzdh();
            }
        } catch (RemoteException e) {
            zzaxi.zzb("Clearcut log failed", e);
        }
    }

    public final zzsm zzbp(int i) {
        this.zzbua = i;
        return this;
    }

    public final zzsm zzbq(int i) {
        this.zzbub = i;
        return this;
    }
}
