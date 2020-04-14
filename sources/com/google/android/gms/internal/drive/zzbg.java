package com.google.android.gms.internal.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.CreateFileActivityOptions;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbg extends TaskApiCall<zzaw, IntentSender> {
    private final /* synthetic */ CreateFileActivityOptions zzep;

    zzbg(zzbb zzbb, CreateFileActivityOptions createFileActivityOptions) {
        this.zzep = createFileActivityOptions;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzaw zzaw = (zzaw) anyClient;
        zzeo zzeo = (zzeo) zzaw.getService();
        this.zzep.zzdc.zza(zzaw.getContext());
        zzu zzu = new zzu(this.zzep.zzdc, this.zzep.zzdi.intValue(), this.zzep.zzay, this.zzep.zzbb, Integer.valueOf(this.zzep.zzdj));
        taskCompletionSource.setResult(zzeo.zza(zzu));
    }
}
