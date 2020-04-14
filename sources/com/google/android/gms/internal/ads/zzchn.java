package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzchn extends zzaqs implements zzbnz {
    @GuardedBy("this")
    private zzboc zzfye;
    @GuardedBy("this")
    private zzaqp zzfyh;
    @GuardedBy("this")
    private zzbrj zzfyi;

    public final synchronized void zza(zzaqp zzaqp) {
        this.zzfyh = zzaqp;
    }

    public final synchronized void zza(zzboc zzboc) {
        this.zzfye = zzboc;
    }

    public final synchronized void zza(zzbrj zzbrj) {
        this.zzfyi = zzbrj;
    }

    public final synchronized void zzai(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzfyh != null) {
            this.zzfyh.zzai(iObjectWrapper);
        }
        if (this.zzfyi != null) {
            this.zzfyi.onInitializationSucceeded();
        }
    }

    public final synchronized void zzd(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        if (this.zzfyh != null) {
            this.zzfyh.zzd(iObjectWrapper, i);
        }
        if (this.zzfyi != null) {
            this.zzfyi.zzde(i);
        }
    }

    public final synchronized void zzal(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzfyh != null) {
            this.zzfyh.zzal(iObjectWrapper);
        }
    }

    public final synchronized void zza(IObjectWrapper iObjectWrapper, zzaqt zzaqt) throws RemoteException {
        if (this.zzfyh != null) {
            this.zzfyh.zza(iObjectWrapper, zzaqt);
        }
    }

    public final synchronized void zzan(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzfyh != null) {
            this.zzfyh.zzan(iObjectWrapper);
        }
    }

    public final synchronized void zzam(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzfyh != null) {
            this.zzfyh.zzam(iObjectWrapper);
        }
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        if (this.zzfyh != null) {
            this.zzfyh.zze(iObjectWrapper, i);
        }
        if (this.zzfye != null) {
            this.zzfye.onAdFailedToLoad(i);
        }
    }

    public final synchronized void zzao(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzfyh != null) {
            this.zzfyh.zzao(iObjectWrapper);
        }
    }

    public final synchronized void zzap(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzfyh != null) {
            this.zzfyh.zzap(iObjectWrapper);
        }
    }

    public final synchronized void zzak(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzfyh != null) {
            this.zzfyh.zzak(iObjectWrapper);
        }
    }

    public final synchronized void zzaj(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzfyh != null) {
            this.zzfyh.zzaj(iObjectWrapper);
        }
        if (this.zzfye != null) {
            this.zzfye.onAdLoaded();
        }
    }

    public final synchronized void zzb(Bundle bundle) throws RemoteException {
        if (this.zzfyh != null) {
            this.zzfyh.zzb(bundle);
        }
    }
}
