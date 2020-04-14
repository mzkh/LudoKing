package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.WorkerThread;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbjv extends zzbio {
    private final Executor zzfbx;
    private final zzada zzfeo;
    private final Runnable zzfep;

    public zzbjv(zzbkn zzbkn, zzada zzada, Runnable runnable, Executor executor) {
        super(zzbkn);
        this.zzfeo = zzada;
        this.zzfep = runnable;
        this.zzfbx = executor;
    }

    public final zzwr getVideoController() {
        return null;
    }

    public final void zza(ViewGroup viewGroup, zzua zzua) {
    }

    public final zzcvu zzaet() {
        return null;
    }

    public final View zzaeu() {
        return null;
    }

    public final int zzaez() {
        return 0;
    }

    public final void zzjs() {
    }

    @WorkerThread
    public final void zzafa() {
        this.zzfbx.execute(new zzbjx(this, new zzbju(new AtomicReference(this.zzfep))));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zze(Runnable runnable) {
        try {
            if (!this.zzfeo.zzq(ObjectWrapper.wrap(runnable))) {
                runnable.run();
            }
        } catch (RemoteException unused) {
            runnable.run();
        }
    }
}
