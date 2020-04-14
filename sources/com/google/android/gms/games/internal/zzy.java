package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.Games.GetServerAuthCodeResult;
import com.google.android.gms.games.GamesStatusCodes;

final class zzy extends zzat<GetServerAuthCodeResult> {
    zzy(ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zza(int i, String str) {
        setResult(new zzm(GamesStatusCodes.zza(i), str));
    }
}
