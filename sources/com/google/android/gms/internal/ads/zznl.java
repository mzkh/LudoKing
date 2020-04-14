package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zznl {
    /* access modifiers changed from: private */
    public final ExecutorService zzbfm;
    /* access modifiers changed from: private */
    public zznn<? extends zznq> zzbfn;
    /* access modifiers changed from: private */
    public IOException zzbfo;

    public zznl(String str) {
        this.zzbfm = zzof.zzbf(str);
    }

    public final <T extends zznq> long zza(T t, zzno<T> zzno, int i) {
        Looper myLooper = Looper.myLooper();
        zznr.checkState(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        zznn zznn = new zznn(this, myLooper, t, zzno, i, elapsedRealtime);
        zznn.zzee(0);
        return elapsedRealtime;
    }

    public final boolean isLoading() {
        return this.zzbfn != null;
    }

    public final void zzie() {
        this.zzbfn.zzk(false);
    }

    public final void zza(Runnable runnable) {
        zznn<? extends zznq> zznn = this.zzbfn;
        if (zznn != null) {
            zznn.zzk(true);
        }
        this.zzbfm.execute(runnable);
        this.zzbfm.shutdown();
    }

    public final void zzbb(int i) throws IOException {
        IOException iOException = this.zzbfo;
        if (iOException == null) {
            zznn<? extends zznq> zznn = this.zzbfn;
            if (zznn != null) {
                zznn.zzbb(zznn.zzbft);
                return;
            }
            return;
        }
        throw iOException;
    }
}
