package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;

final class zzdf extends zzdu {
    private final /* synthetic */ String zzey;
    private final /* synthetic */ byte[] zzla;
    private final /* synthetic */ ParticipantResult[] zzlc;

    zzdf(zzcz zzcz, GoogleApiClient googleApiClient, String str, byte[] bArr, ParticipantResult[] participantResultArr) {
        this.zzey = str;
        this.zzla = bArr;
        this.zzlc = participantResultArr;
        super(googleApiClient, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zza((ResultHolder<UpdateMatchResult>) this, this.zzey, this.zzla, this.zzlc);
    }
}
