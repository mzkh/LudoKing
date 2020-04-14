package com.google.android.gms.internal.games;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import java.util.List;

public final class zzcz implements TurnBasedMultiplayer {
    public final Intent getInboxIntent(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzbd();
    }

    public final void registerMatchUpdateListener(GoogleApiClient googleApiClient, OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
        zze zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzd(googleApiClient.registerListener(onTurnBasedMatchUpdateReceivedListener));
        }
    }

    public final void unregisterMatchUpdateListener(GoogleApiClient googleApiClient) {
        zze zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzbi();
        }
    }

    public final Intent getSelectOpponentsIntent(GoogleApiClient googleApiClient, int i, int i2) {
        return Games.zza(googleApiClient).zzb(i, i2, true);
    }

    public final Intent getSelectOpponentsIntent(GoogleApiClient googleApiClient, int i, int i2, boolean z) {
        return Games.zza(googleApiClient).zzb(i, i2, z);
    }

    public final PendingResult<InitiateMatchResult> createMatch(GoogleApiClient googleApiClient, TurnBasedMatchConfig turnBasedMatchConfig) {
        return googleApiClient.execute(new zzda(this, googleApiClient, turnBasedMatchConfig));
    }

    public final PendingResult<InitiateMatchResult> rematch(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new zzdc(this, googleApiClient, str));
    }

    public final PendingResult<InitiateMatchResult> acceptInvitation(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new zzdd(this, googleApiClient, str));
    }

    public final void declineInvitation(GoogleApiClient googleApiClient, String str) {
        zze zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zze(str, 1);
        }
    }

    public final void dismissInvitation(GoogleApiClient googleApiClient, String str) {
        zze zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzc(str, 1);
        }
    }

    public final int getMaxMatchDataSize(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzbu();
    }

    public final PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient googleApiClient, String str, byte[] bArr, String str2) {
        return takeTurn(googleApiClient, str, bArr, str2, (ParticipantResult[]) null);
    }

    public final PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient googleApiClient, String str, byte[] bArr, String str2, ParticipantResult... participantResultArr) {
        zzde zzde = new zzde(this, googleApiClient, str, bArr, str2, participantResultArr);
        return googleApiClient.execute(zzde);
    }

    public final PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient googleApiClient, String str, byte[] bArr, String str2, List<ParticipantResult> list) {
        return takeTurn(googleApiClient, str, bArr, str2, list == null ? null : (ParticipantResult[]) list.toArray(new ParticipantResult[list.size()]));
    }

    public final PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient googleApiClient, String str) {
        return finishMatch(googleApiClient, str, (byte[]) null, (ParticipantResult[]) null);
    }

    public final PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient googleApiClient, String str, byte[] bArr, ParticipantResult... participantResultArr) {
        zzdf zzdf = new zzdf(this, googleApiClient, str, bArr, participantResultArr);
        return googleApiClient.execute(zzdf);
    }

    public final PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient googleApiClient, String str, byte[] bArr, List<ParticipantResult> list) {
        return finishMatch(googleApiClient, str, bArr, list == null ? null : (ParticipantResult[]) list.toArray(new ParticipantResult[list.size()]));
    }

    public final PendingResult<LeaveMatchResult> leaveMatch(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new zzdg(this, googleApiClient, str));
    }

    public final PendingResult<LeaveMatchResult> leaveMatchDuringTurn(GoogleApiClient googleApiClient, String str, String str2) {
        return googleApiClient.execute(new zzdh(this, googleApiClient, str, str2));
    }

    public final PendingResult<CancelMatchResult> cancelMatch(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new zzdi(this, str, googleApiClient, str));
    }

    public final void dismissMatch(GoogleApiClient googleApiClient, String str) {
        zze zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzc(str);
        }
    }

    public final PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient googleApiClient, int[] iArr) {
        return loadMatchesByStatus(googleApiClient, 0, iArr);
    }

    public final PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient googleApiClient, int i, int[] iArr) {
        return googleApiClient.enqueue(new zzdj(this, googleApiClient, i, iArr));
    }

    public final PendingResult<LoadMatchResult> loadMatch(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.enqueue(new zzdb(this, googleApiClient, str));
    }
}
