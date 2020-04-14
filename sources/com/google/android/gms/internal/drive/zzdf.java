package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

final class zzdf extends TaskApiCall<zzaw, Void> {
    private final /* synthetic */ DriveResource zzfo;
    private final /* synthetic */ List zzfz;

    zzdf(zzch zzch, DriveResource driveResource, List list) {
        this.zzfo = driveResource;
        this.zzfz = list;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzgq(this.zzfo.getDriveId(), this.zzfz), (zzeq) new zzhl(taskCompletionSource));
    }
}
