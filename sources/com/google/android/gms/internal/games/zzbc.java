package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.internal.zze;

public final class zzbc implements Notifications {
    public final void clearAll(GoogleApiClient googleApiClient) {
        clear(googleApiClient, Notifications.NOTIFICATION_TYPES_ALL);
    }

    public final void clear(GoogleApiClient googleApiClient, int i) {
        zze zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzm(i);
        }
    }
}
