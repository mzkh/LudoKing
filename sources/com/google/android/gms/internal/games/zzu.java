package com.google.android.gms.internal.games;

import android.annotation.SuppressLint;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.zze;

public final class zzu implements Events {
    public final PendingResult<LoadEventsResult> loadByIds(GoogleApiClient googleApiClient, boolean z, String... strArr) {
        return googleApiClient.enqueue(new zzv(this, googleApiClient, z, strArr));
    }

    public final PendingResult<LoadEventsResult> load(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.enqueue(new zzw(this, googleApiClient, z));
    }

    @SuppressLint({"MissingRemoteException"})
    public final void increment(GoogleApiClient googleApiClient, String str, int i) {
        zze zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            if (zzb.isConnected()) {
                zzb.zza(str, i);
            } else {
                googleApiClient.execute(new zzx(this, googleApiClient, str, i));
            }
        }
    }
}
