package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.internal.zzbe;
import com.google.android.gms.games.internal.zzbl;
import com.google.android.gms.games.internal.zzbm;
import com.google.android.gms.games.internal.zzbn;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchUpdateCallback;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.internal.games.zzt;
import com.google.android.gms.tasks.Task;
import java.util.List;

public class TurnBasedMultiplayerClient extends zzt {
    private static final zzbl<TurnBasedMatch> zzen = new zzcv();
    private static final ResultConverter<LoadMatchesResult, LoadMatchesResponse> zzeo = new zzce();
    private static final zzbm<LoadMatchesResult> zzep = new zzcf();
    private static final ResultConverter<LoadMatchResult, TurnBasedMatch> zzeq = new zzcg();
    private static final ResultConverter<CancelMatchResult, String> zzer = new zzch();
    private static final zzbn zzes = new zzci();
    private static final ResultConverter<LeaveMatchResult, Void> zzet = new zzcj();
    private static final ResultConverter<LeaveMatchResult, TurnBasedMatch> zzeu = new zzck();
    private static final zzbn zzev = new zzcl();
    private static final ResultConverter<UpdateMatchResult, TurnBasedMatch> zzew = new zzcm();
    private static final ResultConverter<InitiateMatchResult, TurnBasedMatch> zzex = new zzcn();

    public static class MatchOutOfDateApiException extends ApiException {
        protected final TurnBasedMatch match;

        MatchOutOfDateApiException(@NonNull Status status, @NonNull TurnBasedMatch turnBasedMatch) {
            super(status);
            this.match = turnBasedMatch;
        }

        public TurnBasedMatch getMatch() {
            return this.match;
        }
    }

    TurnBasedMultiplayerClient(@NonNull Context context, @NonNull GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    TurnBasedMultiplayerClient(@NonNull Activity activity, @NonNull GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public Task<Intent> getInboxIntent() {
        return doRead((TaskApiCall<A, TResult>) new zzcd<A,TResult>(this));
    }

    public Task<Void> registerTurnBasedMatchUpdateCallback(@NonNull TurnBasedMatchUpdateCallback turnBasedMatchUpdateCallback) {
        ListenerHolder registerListener = registerListener(turnBasedMatchUpdateCallback, TurnBasedMatchUpdateCallback.class.getSimpleName());
        return doRegisterEventListener(new zzco(this, registerListener, registerListener), new zzcp(this, registerListener.getListenerKey()));
    }

    public Task<Boolean> unregisterTurnBasedMatchUpdateCallback(@NonNull TurnBasedMatchUpdateCallback turnBasedMatchUpdateCallback) {
        return doUnregisterEventListener(ListenerHolders.createListenerKey(turnBasedMatchUpdateCallback, TurnBasedMatchUpdateCallback.class.getSimpleName()));
    }

    public Task<Intent> getSelectOpponentsIntent(@IntRange(from = 1) int i, @IntRange(from = 1) int i2) {
        return getSelectOpponentsIntent(i, i2, true);
    }

    public Task<Intent> getSelectOpponentsIntent(@IntRange(from = 1) int i, @IntRange(from = 1) int i2, boolean z) {
        return doRead((TaskApiCall<A, TResult>) new zzcq<A,TResult>(this, i, i2, z));
    }

    public Task<TurnBasedMatch> createMatch(@NonNull TurnBasedMatchConfig turnBasedMatchConfig) {
        return zzbe.toTask(Games.TurnBasedMultiplayer.createMatch(asGoogleApiClient(), turnBasedMatchConfig), zzex);
    }

    public Task<TurnBasedMatch> rematch(@NonNull String str) {
        return zzbe.toTask(Games.TurnBasedMultiplayer.rematch(asGoogleApiClient(), str), zzex);
    }

    public Task<TurnBasedMatch> acceptInvitation(@NonNull String str) {
        return zzbe.toTask(Games.TurnBasedMultiplayer.acceptInvitation(asGoogleApiClient(), str), zzex);
    }

    public Task<Void> declineInvitation(@NonNull String str) {
        return doWrite((TaskApiCall<A, TResult>) new zzcr<A,TResult>(this, str));
    }

    public Task<Void> dismissInvitation(@NonNull String str) {
        return doWrite((TaskApiCall<A, TResult>) new zzcs<A,TResult>(this, str));
    }

    public Task<Integer> getMaxMatchDataSize() {
        return doRead((TaskApiCall<A, TResult>) new zzct<A,TResult>(this));
    }

    public Task<TurnBasedMatch> takeTurn(@NonNull String str, @Nullable byte[] bArr, @Nullable String str2) {
        return zze(Games.TurnBasedMultiplayer.takeTurn(asGoogleApiClient(), str, bArr, str2));
    }

    public Task<TurnBasedMatch> takeTurn(@NonNull String str, @Nullable byte[] bArr, @Nullable String str2, @Nullable ParticipantResult... participantResultArr) {
        return zze(Games.TurnBasedMultiplayer.takeTurn(asGoogleApiClient(), str, bArr, str2, participantResultArr));
    }

    public Task<TurnBasedMatch> takeTurn(@NonNull String str, @Nullable byte[] bArr, @Nullable String str2, @Nullable List<ParticipantResult> list) {
        return zze(Games.TurnBasedMultiplayer.takeTurn(asGoogleApiClient(), str, bArr, str2, list));
    }

    public Task<TurnBasedMatch> finishMatch(@NonNull String str) {
        return zze(Games.TurnBasedMultiplayer.finishMatch(asGoogleApiClient(), str));
    }

    public Task<TurnBasedMatch> finishMatch(@NonNull String str, @Nullable byte[] bArr, @Nullable ParticipantResult... participantResultArr) {
        return zze(Games.TurnBasedMultiplayer.finishMatch(asGoogleApiClient(), str, bArr, participantResultArr));
    }

    public Task<TurnBasedMatch> finishMatch(@NonNull String str, @Nullable byte[] bArr, @Nullable List<ParticipantResult> list) {
        return zze(Games.TurnBasedMultiplayer.finishMatch(asGoogleApiClient(), str, bArr, list));
    }

    public Task<Void> leaveMatch(@NonNull String str) {
        return zzd(Games.TurnBasedMultiplayer.leaveMatch(asGoogleApiClient(), str));
    }

    public Task<Void> leaveMatchDuringTurn(@NonNull String str, @Nullable String str2) {
        return zzd(Games.TurnBasedMultiplayer.leaveMatchDuringTurn(asGoogleApiClient(), str, str2));
    }

    public Task<String> cancelMatch(@NonNull String str) {
        return zzbe.toTask(Games.TurnBasedMultiplayer.cancelMatch(asGoogleApiClient(), str), zzer);
    }

    public Task<Void> dismissMatch(@NonNull String str) {
        return doWrite((TaskApiCall<A, TResult>) new zzcu<A,TResult>(this, str));
    }

    public Task<AnnotatedData<LoadMatchesResponse>> loadMatchesByStatus(@NonNull int[] iArr) {
        return zzbe.zza(Games.TurnBasedMultiplayer.loadMatchesByStatus(asGoogleApiClient(), iArr), zzeo, zzep);
    }

    public Task<AnnotatedData<LoadMatchesResponse>> loadMatchesByStatus(int i, @NonNull int[] iArr) {
        return zzbe.zza(Games.TurnBasedMultiplayer.loadMatchesByStatus(asGoogleApiClient(), i, iArr), zzeo, zzep);
    }

    public Task<AnnotatedData<TurnBasedMatch>> loadMatch(@NonNull String str) {
        return zzbe.zza(Games.TurnBasedMultiplayer.loadMatch(asGoogleApiClient(), str), zzeq);
    }

    private static Task<Void> zzd(@NonNull PendingResult<LeaveMatchResult> pendingResult) {
        return zzbe.zza(pendingResult, zzes, zzet, zzeu, zzen);
    }

    private static Task<TurnBasedMatch> zze(@NonNull PendingResult<UpdateMatchResult> pendingResult) {
        zzbn zzbn = zzev;
        ResultConverter<UpdateMatchResult, TurnBasedMatch> resultConverter = zzew;
        return zzbe.zza(pendingResult, zzbn, resultConverter, resultConverter, zzen);
    }
}
