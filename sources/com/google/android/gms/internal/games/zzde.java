package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;

final class zzde extends zzdu {
    private final /* synthetic */ String zzey;
    private final /* synthetic */ byte[] zzla;
    private final /* synthetic */ String zzlb;
    private final /* synthetic */ ParticipantResult[] zzlc;

    zzde(zzcz zzcz, GoogleApiClient googleApiClient, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
        this.zzey = str;
        this.zzla = bArr;
        this.zzlb = str2;
        this.zzlc = participantResultArr;
        super(googleApiClient, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zza((ResultHolder<UpdateMatchResult>) this, this.zzey, this.zzla, this.zzlb, this.zzlc);
    }
}
