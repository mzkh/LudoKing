package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.games.internal.zzbp;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.video.Videos.CaptureOverlayStateListener;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcz extends zzbp<CaptureOverlayStateListener> {
    zzcz(VideosClient videosClient, ListenerKey listenerKey) {
        super(listenerKey);
    }

    /* access modifiers changed from: protected */
    public final void zzc(zze zze, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException, SecurityException {
        zze.zzcg();
        taskCompletionSource.setResult(Boolean.valueOf(true));
    }
}
