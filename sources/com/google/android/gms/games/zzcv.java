package com.google.android.gms.games;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.games.TurnBasedMultiplayerClient.MatchOutOfDateApiException;
import com.google.android.gms.games.internal.zzbl;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;

final class zzcv implements zzbl<TurnBasedMatch> {
    zzcv() {
    }

    public final /* synthetic */ ApiException zza(@NonNull Status status, @NonNull Object obj) {
        TurnBasedMatch turnBasedMatch = (TurnBasedMatch) obj;
        if (status.getStatusCode() == 26593) {
            return new MatchOutOfDateApiException(status, turnBasedMatch);
        }
        return ApiExceptionUtil.fromStatus(status);
    }
}
