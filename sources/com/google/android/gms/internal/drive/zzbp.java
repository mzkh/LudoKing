package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;

final class zzbp implements DownloadProgressListener {
    private final ListenerHolder<DownloadProgressListener> zzey;

    public zzbp(ListenerHolder<DownloadProgressListener> listenerHolder) {
        this.zzey = listenerHolder;
    }

    public final void onProgress(long j, long j2) {
        ListenerHolder<DownloadProgressListener> listenerHolder = this.zzey;
        zzbq zzbq = new zzbq(this, j, j2);
        listenerHolder.notifyListener(zzbq);
    }
}
