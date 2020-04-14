package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.zzn;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcy extends TaskApiCall<zzaw, Void> {
    private final /* synthetic */ MetadataChangeSet zzeu;
    private final /* synthetic */ DriveContents zzfv;
    private final /* synthetic */ zzn zzfw;

    zzcy(zzch zzch, zzn zzn, DriveContents driveContents, MetadataChangeSet metadataChangeSet) {
        this.zzfw = zzn;
        this.zzfv = driveContents;
        this.zzeu = metadataChangeSet;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzaw zzaw = (zzaw) anyClient;
        try {
            this.zzfw.zza(zzaw);
        } catch (IllegalStateException e) {
            taskCompletionSource.setException(e);
        }
        this.zzfv.zzi();
        this.zzeu.zzp().zza(zzaw.getContext());
        zzeo zzeo = (zzeo) zzaw.getService();
        zzm zzm = new zzm(this.zzfv.getDriveId(), this.zzeu.zzp(), this.zzfv.zzh().getRequestId(), this.zzfv.zzh().zza(), this.zzfw);
        zzeo.zza(zzm, (zzeq) new zzhl(taskCompletionSource));
    }
}
