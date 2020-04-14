package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

final class zzbl implements ResultCallback<Status> {
    zzbl(zzbi zzbi) {
    }

    public final /* synthetic */ void onResult(Result result) {
        Status status = (Status) result;
        if (!status.isSuccess()) {
            zzbi.zzbx.efmt("DriveContentsImpl", "Error discarding contents, status: %s", status);
        }
    }
}
