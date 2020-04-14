package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.GamesStatusCodes;

final class zzg extends zzat<Status> {
    zzg(ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void onSignOutComplete() {
        setResult(GamesStatusCodes.zza(0));
    }
}
