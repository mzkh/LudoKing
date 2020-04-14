package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.drive.events.ListenerToken;

public final class zzg implements ListenerToken {
    private final ListenerKey zzcw;
    private ICancelToken zzcx = null;

    public zzg(ListenerKey listenerKey) {
        this.zzcw = listenerKey;
    }

    public final boolean cancel() {
        ICancelToken iCancelToken = this.zzcx;
        if (iCancelToken != null) {
            try {
                iCancelToken.cancel();
                return true;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    public final void setCancelToken(ICancelToken iCancelToken) {
        this.zzcx = iCancelToken;
    }

    public final ListenerKey zzac() {
        return this.zzcw;
    }
}
