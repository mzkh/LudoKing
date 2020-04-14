package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcmm extends zzvc {
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public boolean zzadc = false;
    private final String zzbqy;
    private final zzcmq<zzbkk> zzgcs;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public String zzgct;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public String zzgcu;

    public zzcmm(zzcmq<zzbkk> zzcmq, String str) {
        this.zzgcs = zzcmq;
        this.zzbqy = str;
    }

    public final synchronized boolean isLoading() throws RemoteException {
        return this.zzgcs.isLoading();
    }

    public final void zzb(zztx zztx) throws RemoteException {
        zza(zztx, 1);
    }

    public final synchronized void zza(zztx zztx, int i) throws RemoteException {
        this.zzgct = null;
        this.zzgcu = null;
        this.zzadc = this.zzgcs.zza(zztx, this.zzbqy, new zzcmv(i), new zzcmp(this));
    }

    public final synchronized String getMediationAdapterClassName() {
        return this.zzgct;
    }

    public final synchronized String zzju() {
        return this.zzgcu;
    }
}
