package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.internal.zzbo;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.video.Videos.CaptureOverlayStateListener;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcy extends zzbo<CaptureOverlayStateListener> {
    private final /* synthetic */ ListenerHolder zzbj;

    zzcy(VideosClient videosClient, ListenerHolder listenerHolder, ListenerHolder listenerHolder2) {
        this.zzbj = listenerHolder2;
        super(listenerHolder);
    }

    /* access modifiers changed from: protected */
    public final void zzb(zze zze, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException, SecurityException {
        zze.zzg(this.zzbj);
        taskCompletionSource.setResult(null);
    }
}
