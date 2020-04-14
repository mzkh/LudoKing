package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks;

final class zzad implements ResultHolder<Status> {
    private final /* synthetic */ SignOutCallbacks zzhj;

    zzad(SignOutCallbacks signOutCallbacks) {
        this.zzhj = signOutCallbacks;
    }

    public final void setFailedResult(Status status) {
        this.zzhj.onSignOutComplete();
    }

    public final /* synthetic */ void setResult(Object obj) {
        this.zzhj.onSignOutComplete();
    }
}
