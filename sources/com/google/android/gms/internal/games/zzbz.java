package com.google.android.gms.internal.games;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import java.util.ArrayList;
import java.util.List;

public final class zzbz implements Requests {
    public final void registerRequestListener(GoogleApiClient googleApiClient, OnRequestReceivedListener onRequestReceivedListener) {
        zze zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzf(googleApiClient.registerListener(onRequestReceivedListener));
        }
    }

    public final void unregisterRequestListener(GoogleApiClient googleApiClient) {
        zze zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzbk();
        }
    }

    public final Intent getInboxIntent(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzbv();
    }

    public final Intent getSendIntent(GoogleApiClient googleApiClient, int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        return Games.zza(googleApiClient).zza(i, bArr, i2, bitmap, str);
    }

    public final int getMaxPayloadSize(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzbw();
    }

    public final int getMaxLifetimeDays(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzbx();
    }

    public final PendingResult<UpdateRequestsResult> acceptRequest(GoogleApiClient googleApiClient, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return acceptRequests(googleApiClient, arrayList);
    }

    public final PendingResult<UpdateRequestsResult> acceptRequests(GoogleApiClient googleApiClient, List<String> list) {
        return googleApiClient.execute(new zzca(this, googleApiClient, list == null ? null : (String[]) list.toArray(new String[list.size()])));
    }

    public final PendingResult<UpdateRequestsResult> dismissRequest(GoogleApiClient googleApiClient, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return dismissRequests(googleApiClient, arrayList);
    }

    public final PendingResult<UpdateRequestsResult> dismissRequests(GoogleApiClient googleApiClient, List<String> list) {
        return googleApiClient.execute(new zzcb(this, googleApiClient, list == null ? null : (String[]) list.toArray(new String[list.size()])));
    }

    public final PendingResult<LoadRequestsResult> loadRequests(GoogleApiClient googleApiClient, int i, int i2, int i3) {
        zzcc zzcc = new zzcc(this, googleApiClient, i, i2, i3);
        return googleApiClient.enqueue(zzcc);
    }

    public final ArrayList<GameRequest> getGameRequestsFromInboxResponse(Intent intent) {
        if (intent == null) {
            return new ArrayList<>();
        }
        return getGameRequestsFromBundle(intent.getExtras());
    }

    public final ArrayList<GameRequest> getGameRequestsFromBundle(Bundle bundle) {
        if (bundle != null) {
            String str = Requests.EXTRA_REQUESTS;
            if (bundle.containsKey(str)) {
                ArrayList arrayList = (ArrayList) bundle.get(str);
                ArrayList<GameRequest> arrayList2 = new ArrayList<>();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList2.add((GameRequest) arrayList.get(i));
                }
                return arrayList2;
            }
        }
        return new ArrayList<>();
    }
}
