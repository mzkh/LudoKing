package com.google.android.gms.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.GetServerAuthCodeResult;

final class zzm implements GetServerAuthCodeResult {
    private final /* synthetic */ Status zzbd;

    zzm(zzc zzc, Status status) {
        this.zzbd = status;
    }

    public final String getCode() {
        return null;
    }

    public final Status getStatus() {
        return this.zzbd;
    }
}
