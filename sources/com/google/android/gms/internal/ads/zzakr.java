package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzakr extends zzwq {
    private final Object lock = new Object();
    private volatile zzws zzddr;

    public final void play() throws RemoteException {
        throw new RemoteException();
    }

    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    public final void stop() throws RemoteException {
        throw new RemoteException();
    }

    public final void mute(boolean z) throws RemoteException {
        throw new RemoteException();
    }

    public final boolean isMuted() throws RemoteException {
        throw new RemoteException();
    }

    public final int getPlaybackState() throws RemoteException {
        throw new RemoteException();
    }

    public final float zzox() throws RemoteException {
        throw new RemoteException();
    }

    public final float zzoy() throws RemoteException {
        throw new RemoteException();
    }

    public final void zza(zzws zzws) throws RemoteException {
        synchronized (this.lock) {
            this.zzddr = zzws;
        }
    }

    public final zzws zzoz() throws RemoteException {
        zzws zzws;
        synchronized (this.lock) {
            zzws = this.zzddr;
        }
        return zzws;
    }

    public final float getAspectRatio() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean isCustomControlsEnabled() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean isClickToExpandEnabled() throws RemoteException {
        throw new RemoteException();
    }
}
