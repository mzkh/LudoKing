package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnFailureListener;

final class zzbs implements OnFailureListener {
    private final /* synthetic */ String zzbm;
    private final /* synthetic */ zzbd zzcq;

    zzbs(zzbd zzbd, String str) {
        this.zzcq = zzbd;
        this.zzbm = str;
    }

    public final void onFailure(Exception exc) {
        if (!(exc instanceof ApiException) || ((ApiException) exc).getStatusCode() != 8003) {
            this.zzcq.zzc(this.zzbm);
        }
    }
}
