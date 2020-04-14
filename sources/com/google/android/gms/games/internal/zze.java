package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.FirstPartyScopes;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.api.internal.DataHolderResult;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolder.Notifier;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.GamesExtraArgs;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.Games.GetServerAuthCodeResult;
import com.google.android.gms.games.GamesClientStatusCodes;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestEntity;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.PlayerStatsBuffer;
import com.google.android.gms.games.stats.PlayerStatsEntity;
import com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.Videos.CaptureAvailableResult;
import com.google.android.gms.games.video.Videos.CaptureCapabilitiesResult;
import com.google.android.gms.games.video.Videos.CaptureOverlayStateListener;
import com.google.android.gms.games.video.Videos.CaptureStateResult;
import com.google.android.gms.internal.games.zzeh;
import com.google.android.gms.internal.games.zzej;
import com.google.android.gms.internal.games.zzek;
import com.google.android.gms.signin.internal.SignInClientImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class zze extends GmsClient<zzbu> {
    private final zzej zzgo = new zzf(this);
    private final String zzgp;
    private PlayerEntity zzgq;
    private GameEntity zzgr;
    private final zzby zzgs;
    private boolean zzgt = false;
    private final Binder zzgu;
    private final long zzgv;
    private boolean zzgw = false;
    private final GamesOptions zzgx;
    private Bundle zzgy;

    private static final class zza extends zzl implements AcceptQuestResult {
        private final Quest zzhk;

        zza(DataHolder dataHolder) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzhk = new QuestEntity((Quest) questBuffer.get(0));
                } else {
                    this.zzhk = null;
                }
            } finally {
                questBuffer.release();
            }
        }

        public final Quest getQuest() {
            return this.zzhk;
        }
    }

    private static final class zzaa extends zzbd implements LoadMatchResult {
        zzaa(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class zzab implements LoadMatchesResult {
        private final Status zzhl;
        private final LoadMatchesResponse zzic;

        zzab(Status status, Bundle bundle) {
            this.zzhl = status;
            this.zzic = new LoadMatchesResponse(bundle);
        }

        public final Status getStatus() {
            return this.zzhl;
        }

        public final LoadMatchesResponse getMatches() {
            return this.zzic;
        }

        public final void release() {
            this.zzic.release();
        }
    }

    private static final class zzac extends zzl implements LoadPlayerScoreResult {
        private final LeaderboardScoreEntity zzid;

        zzac(DataHolder dataHolder) {
            super(dataHolder);
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(dataHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.zzid = (LeaderboardScoreEntity) ((LeaderboardScore) leaderboardScoreBuffer.get(0)).freeze();
                } else {
                    this.zzid = null;
                }
            } finally {
                leaderboardScoreBuffer.release();
            }
        }

        public final LeaderboardScore getScore() {
            return this.zzid;
        }
    }

    private static final class zzad extends zzl implements LoadPlayerStatsResult {
        private final PlayerStats zzie;

        zzad(DataHolder dataHolder) {
            super(dataHolder);
            PlayerStatsBuffer playerStatsBuffer = new PlayerStatsBuffer(dataHolder);
            try {
                if (playerStatsBuffer.getCount() > 0) {
                    this.zzie = new PlayerStatsEntity((PlayerStats) playerStatsBuffer.get(0));
                } else {
                    this.zzie = null;
                }
            } finally {
                playerStatsBuffer.release();
            }
        }

        public final PlayerStats getPlayerStats() {
            return this.zzie;
        }
    }

    private static final class zzae extends zzl implements LoadPlayersResult {
        private final PlayerBuffer zzif;

        zzae(DataHolder dataHolder) {
            super(dataHolder);
            this.zzif = new PlayerBuffer(dataHolder);
        }

        public final PlayerBuffer getPlayers() {
            return this.zzif;
        }
    }

    private static final class zzaf extends zzl implements LoadQuestsResult {
        zzaf(DataHolder dataHolder) {
            super(dataHolder);
        }

        public final QuestBuffer getQuests() {
            return new QuestBuffer(this.mDataHolder);
        }
    }

    private static final class zzag implements LoadRequestsResult {
        private final Status zzhl;
        private final Bundle zzig;

        zzag(Status status, Bundle bundle) {
            this.zzhl = status;
            this.zzig = bundle;
        }

        public final Status getStatus() {
            return this.zzhl;
        }

        public final GameRequestBuffer getRequests(int i) {
            String str;
            if (i == 1) {
                str = "GIFT";
            } else if (i != 2) {
                StringBuilder sb = new StringBuilder(33);
                sb.append("Unknown request type: ");
                sb.append(i);
                zzbd.m3401e("RequestType", sb.toString());
                str = "UNKNOWN_TYPE";
            } else {
                str = "WISH";
            }
            if (!this.zzig.containsKey(str)) {
                return null;
            }
            return new GameRequestBuffer((DataHolder) this.zzig.get(str));
        }

        public final void release() {
            for (String parcelable : this.zzig.keySet()) {
                DataHolder dataHolder = (DataHolder) this.zzig.getParcelable(parcelable);
                if (dataHolder != null) {
                    dataHolder.close();
                }
            }
        }
    }

    private static final class zzah extends zzl implements LoadScoresResult {
        private final LeaderboardEntity zzih;
        private final LeaderboardScoreBuffer zzii;

        /* JADX INFO: finally extract failed */
        zzah(DataHolder dataHolder, DataHolder dataHolder2) {
            super(dataHolder2);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(dataHolder);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.zzih = (LeaderboardEntity) ((Leaderboard) leaderboardBuffer.get(0)).freeze();
                } else {
                    this.zzih = null;
                }
                leaderboardBuffer.release();
                this.zzii = new LeaderboardScoreBuffer(dataHolder2);
            } catch (Throwable th) {
                leaderboardBuffer.release();
                throw th;
            }
        }

        public final Leaderboard getLeaderboard() {
            return this.zzih;
        }

        public final LeaderboardScoreBuffer getScores() {
            return this.zzii;
        }
    }

    private static final class zzai extends zzl implements LoadSnapshotsResult {
        zzai(DataHolder dataHolder) {
            super(dataHolder);
        }

        public final SnapshotMetadataBuffer getSnapshots() {
            return new SnapshotMetadataBuffer(this.mDataHolder);
        }
    }

    private static final class zzaj extends zzu<OnTurnBasedMatchUpdateReceivedListener> {
        zzaj(ListenerHolder<OnTurnBasedMatchUpdateReceivedListener> listenerHolder) {
            super(listenerHolder);
        }

        public final void zzr(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                TurnBasedMatch turnBasedMatch = turnBasedMatchBuffer.getCount() > 0 ? (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze() : null;
                if (turnBasedMatch != null) {
                    zzc(new zzag(turnBasedMatch));
                }
            } finally {
                turnBasedMatchBuffer.release();
            }
        }

        public final void onTurnBasedMatchRemoved(String str) {
            zzc(new zzah(str));
        }
    }

    private static final class zzak extends zzl implements OpenSnapshotResult {
        private final String zzek;
        private final Snapshot zzik;
        private final Snapshot zzil;
        private final SnapshotContents zzim;

        zzak(DataHolder dataHolder, Contents contents) {
            this(dataHolder, null, contents, null, null);
        }

        /* JADX INFO: finally extract failed */
        zzak(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() == 0) {
                    this.zzik = null;
                    this.zzil = null;
                } else {
                    boolean z = true;
                    if (snapshotMetadataBuffer.getCount() == 1) {
                        if (dataHolder.getStatusCode() == 4004) {
                            z = false;
                        }
                        Asserts.checkState(z);
                        this.zzik = new SnapshotEntity(new SnapshotMetadataEntity((SnapshotMetadata) snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(contents));
                        this.zzil = null;
                    } else {
                        this.zzik = new SnapshotEntity(new SnapshotMetadataEntity((SnapshotMetadata) snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(contents));
                        this.zzil = new SnapshotEntity(new SnapshotMetadataEntity((SnapshotMetadata) snapshotMetadataBuffer.get(1)), new SnapshotContentsEntity(contents2));
                    }
                }
                snapshotMetadataBuffer.release();
                this.zzek = str;
                this.zzim = new SnapshotContentsEntity(contents3);
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
                throw th;
            }
        }

        public final Snapshot getSnapshot() {
            return this.zzik;
        }

        public final String getConflictId() {
            return this.zzek;
        }

        public final Snapshot getConflictingSnapshot() {
            return this.zzil;
        }

        public final SnapshotContents getResolutionSnapshotContents() {
            return this.zzim;
        }
    }

    private static final class zzal extends zzat<LoadPlayersResult> {
        zzal(ResultHolder<LoadPlayersResult> resultHolder) {
            super(resultHolder);
        }

        public final void zze(DataHolder dataHolder) {
            setResult(new zzae(dataHolder));
        }

        public final void zzf(DataHolder dataHolder) {
            setResult(new zzae(dataHolder));
        }
    }

    private static final class zzam extends zzu<QuestUpdateListener> {
        zzam(ListenerHolder<QuestUpdateListener> listenerHolder) {
            super(listenerHolder);
        }

        public final void zzak(DataHolder dataHolder) {
            Quest zzba = zzba(dataHolder);
            if (zzba != null) {
                zzc(new zzai(zzba));
            }
        }

        private static Quest zzba(DataHolder dataHolder) {
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                return questBuffer.getCount() > 0 ? (Quest) ((Quest) questBuffer.get(0)).freeze() : null;
            } finally {
                questBuffer.release();
            }
        }
    }

    private static final class zzan extends zzat<LoadQuestsResult> {
        zzan(ResultHolder<LoadQuestsResult> resultHolder) {
            super(resultHolder);
        }

        public final void zzam(DataHolder dataHolder) {
            setResult(new zzaf(dataHolder));
        }
    }

    private static final class zzao extends zza {
        private final ListenerHolder<ReliableMessageSentCallback> zzio;

        zzao(ListenerHolder<ReliableMessageSentCallback> listenerHolder) {
            this.zzio = listenerHolder;
        }

        public final void zza(int i, int i2, String str) {
            ListenerHolder<ReliableMessageSentCallback> listenerHolder = this.zzio;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.zza((zzap<T>) new zzaj<T>(i, i2, str)));
            }
        }
    }

    private interface zzap<T> {
        void accept(T t);
    }

    private static final class zzaq extends zzu<OnRequestReceivedListener> {
        zzaq(ListenerHolder<OnRequestReceivedListener> listenerHolder) {
            super(listenerHolder);
        }

        public final void zzm(DataHolder dataHolder) {
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            try {
                GameRequest gameRequest = gameRequestBuffer.getCount() > 0 ? (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze() : null;
                if (gameRequest != null) {
                    zzc(new zzak(gameRequest));
                }
            } finally {
                gameRequestBuffer.release();
            }
        }

        public final void onRequestRemoved(String str) {
            zzc(new zzal(str));
        }
    }

    private static final class zzar extends zzat<LoadRequestsResult> {
        zzar(ResultHolder<LoadRequestsResult> resultHolder) {
            super(resultHolder);
        }

        public final void zzb(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            setResult(new zzag(GamesStatusCodes.zza(i), bundle));
        }
    }

    private static final class zzas extends zzat<UpdateRequestsResult> {
        zzas(ResultHolder<UpdateRequestsResult> resultHolder) {
            super(resultHolder);
        }

        public final void zzad(DataHolder dataHolder) {
            setResult(new zzbi(dataHolder));
        }
    }

    private static abstract class zzat<T> extends zza {
        private final ResultHolder<T> zzis;

        zzat(ResultHolder<T> resultHolder) {
            this.zzis = (ResultHolder) Preconditions.checkNotNull(resultHolder, "Holder must not be null");
        }

        /* access modifiers changed from: 0000 */
        public final void setResult(T t) {
            this.zzis.setResult(t);
        }
    }

    private static final class zzau extends zza {
        private final ListenerHolder<? extends RoomUpdateListener> zzit;
        private final ListenerHolder<? extends RoomStatusUpdateListener> zziu;
        private final ListenerHolder<? extends RealTimeMessageReceivedListener> zziv;

        zzau(ListenerHolder<? extends RoomUpdateListener> listenerHolder) {
            this(listenerHolder, null, null);
        }

        zzau(ListenerHolder<? extends RoomUpdateListener> listenerHolder, @Nullable ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder2, @Nullable ListenerHolder<? extends RealTimeMessageReceivedListener> listenerHolder3) {
            this.zzit = (ListenerHolder) Preconditions.checkNotNull(listenerHolder, "Callbacks must not be null");
            this.zziu = listenerHolder2;
            this.zziv = listenerHolder3;
        }

        public final void zzs(DataHolder dataHolder) {
            this.zzit.notifyListener(zze.zza(dataHolder, zzam.zziw));
        }

        public final void zzt(DataHolder dataHolder) {
            this.zzit.notifyListener(zze.zza(dataHolder, zzan.zziw));
        }

        public final void onLeftRoom(int i, String str) {
            this.zzit.notifyListener(zze.zza((zzap<T>) new zzav<T>(i, str)));
        }

        public final void zzw(DataHolder dataHolder) {
            this.zzit.notifyListener(zze.zza(dataHolder, zzaw.zziw));
        }

        public final void zzu(DataHolder dataHolder) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziu;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.zza(dataHolder, zzax.zzja));
            }
        }

        public final void zzv(DataHolder dataHolder) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziu;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.zza(dataHolder, zzay.zzja));
            }
        }

        public final void zzx(DataHolder dataHolder) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziu;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.zza(dataHolder, zzaz.zzja));
            }
        }

        public final void zzy(DataHolder dataHolder) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziu;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.zza(dataHolder, zzba.zzja));
            }
        }

        public final void zze(DataHolder dataHolder, String[] strArr) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziu;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.zza(dataHolder, strArr, zzbb.zzix));
            }
        }

        public final void zzf(DataHolder dataHolder, String[] strArr) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziu;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.zza(dataHolder, strArr, zzbc.zzix));
            }
        }

        public final void zza(DataHolder dataHolder, String[] strArr) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziu;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.zza(dataHolder, strArr, zzao.zzix));
            }
        }

        public final void zzb(DataHolder dataHolder, String[] strArr) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziu;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.zza(dataHolder, strArr, zzap.zzix));
            }
        }

        public final void zzc(DataHolder dataHolder, String[] strArr) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziu;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.zza(dataHolder, strArr, zzaq.zzix));
            }
        }

        public final void zzd(DataHolder dataHolder, String[] strArr) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziu;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.zza(dataHolder, strArr, zzar.zzix));
            }
        }

        public final void onP2PConnected(String str) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziu;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.zza((zzap<T>) new zzas<T>(str)));
            }
        }

        public final void onP2PDisconnected(String str) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziu;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.zza((zzap<T>) new zzat<T>(str)));
            }
        }

        public final void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) {
            ListenerHolder<? extends RealTimeMessageReceivedListener> listenerHolder = this.zziv;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.zza((zzap<T>) new zzau<T>(realTimeMessage)));
            }
        }
    }

    private interface zzav<T> {
        void zza(T t, Room room, ArrayList<String> arrayList);
    }

    private interface zzaw<T> {
        void zza(T t, Room room);
    }

    private static final class zzax extends zzat<OpenSnapshotResult> {
        zzax(ResultHolder<OpenSnapshotResult> resultHolder) {
            super(resultHolder);
        }

        public final void zza(DataHolder dataHolder, Contents contents) {
            setResult(new zzak(dataHolder, contents));
        }

        public final void zza(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            zzak zzak = new zzak(dataHolder, str, contents, contents2, contents3);
            setResult(zzak);
        }
    }

    private static final class zzay extends zzat<LoadSnapshotsResult> {
        zzay(ResultHolder<LoadSnapshotsResult> resultHolder) {
            super(resultHolder);
        }

        public final void zzag(DataHolder dataHolder) {
            setResult(new zzai(dataHolder));
        }
    }

    private interface zzaz<T> {
        void zza(T t, int i, Room room);
    }

    private static final class zzb extends zzat<UpdateAchievementResult> {
        zzb(ResultHolder<UpdateAchievementResult> resultHolder) {
            super(resultHolder);
        }

        public final void zzb(int i, String str) {
            setResult(new zzbg(i, str));
        }
    }

    private static final class zzba extends zzl implements SubmitScoreResult {
        private final ScoreSubmissionData zzjb;

        zzba(DataHolder dataHolder) {
            super(dataHolder);
            try {
                this.zzjb = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        public final ScoreSubmissionData getScoreData() {
            return this.zzjb;
        }
    }

    private static final class zzbb extends zzat<InitiateMatchResult> {
        zzbb(ResultHolder<InitiateMatchResult> resultHolder) {
            super(resultHolder);
        }

        public final void zzo(DataHolder dataHolder) {
            setResult(new zzn(dataHolder));
        }
    }

    private static final class zzbc extends zzat<LeaveMatchResult> {
        zzbc(ResultHolder<LeaveMatchResult> resultHolder) {
            super(resultHolder);
        }

        public final void zzq(DataHolder dataHolder) {
            setResult(new zzt(dataHolder));
        }
    }

    private static abstract class zzbd extends zzl {
        private final TurnBasedMatch match;

        zzbd(DataHolder dataHolder) {
            super(dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.match = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                } else {
                    this.match = null;
                }
            } finally {
                turnBasedMatchBuffer.release();
            }
        }

        public TurnBasedMatch getMatch() {
            return this.match;
        }
    }

    private static final class zzbe extends zzat<UpdateMatchResult> {
        zzbe(ResultHolder<UpdateMatchResult> resultHolder) {
            super(resultHolder);
        }

        public final void zzp(DataHolder dataHolder) {
            setResult(new zzbh(dataHolder));
        }
    }

    private static final class zzbf extends zzat<LoadMatchesResult> {
        zzbf(ResultHolder<LoadMatchesResult> resultHolder) {
            super(resultHolder);
        }

        public final void zza(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            setResult(new zzab(GamesStatusCodes.zza(i), bundle));
        }
    }

    private static final class zzbg implements UpdateAchievementResult {
        private final String zzfc;
        private final Status zzhl;

        zzbg(int i, String str) {
            this.zzhl = GamesStatusCodes.zza(i);
            this.zzfc = str;
        }

        public final Status getStatus() {
            return this.zzhl;
        }

        public final String getAchievementId() {
            return this.zzfc;
        }
    }

    private static final class zzbh extends zzbd implements UpdateMatchResult {
        zzbh(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class zzbi extends zzl implements UpdateRequestsResult {
        private final zzek zzjc;

        zzbi(DataHolder dataHolder) {
            super(dataHolder);
            this.zzjc = zzek.zzbb(dataHolder);
        }

        public final int getRequestOutcome(String str) {
            return this.zzjc.getRequestOutcome(str);
        }

        public final Set<String> getRequestIds() {
            return this.zzjc.getRequestIds();
        }
    }

    private static final class zzc implements CancelMatchResult {
        private final Status zzhl;
        private final String zzhm;

        zzc(Status status, String str) {
            this.zzhl = status;
            this.zzhm = str;
        }

        public final Status getStatus() {
            return this.zzhl;
        }

        public final String getMatchId() {
            return this.zzhm;
        }
    }

    private static final class zzd implements CaptureAvailableResult {
        private final Status zzhl;
        private final boolean zzhn;

        zzd(Status status, boolean z) {
            this.zzhl = status;
            this.zzhn = z;
        }

        public final Status getStatus() {
            return this.zzhl;
        }

        public final boolean isAvailable() {
            return this.zzhn;
        }
    }

    /* renamed from: com.google.android.gms.games.internal.zze$zze reason: collision with other inner class name */
    private static final class C3498zze implements CaptureCapabilitiesResult {
        private final Status zzhl;
        private final VideoCapabilities zzho;

        C3498zze(Status status, VideoCapabilities videoCapabilities) {
            this.zzhl = status;
            this.zzho = videoCapabilities;
        }

        public final Status getStatus() {
            return this.zzhl;
        }

        public final VideoCapabilities getCapabilities() {
            return this.zzho;
        }
    }

    private static final class zzf implements CaptureStateResult {
        private final Status zzhl;
        private final CaptureState zzhp;

        zzf(Status status, CaptureState captureState) {
            this.zzhl = status;
            this.zzhp = captureState;
        }

        public final Status getStatus() {
            return this.zzhl;
        }

        public final CaptureState getCaptureState() {
            return this.zzhp;
        }
    }

    private static final class zzg extends zzl implements ClaimMilestoneResult {
        private final Quest zzhk;
        private final Milestone zzhq;

        zzg(DataHolder dataHolder, String str) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzhk = new QuestEntity((Quest) questBuffer.get(0));
                    List zzdq = this.zzhk.zzdq();
                    int size = zzdq.size();
                    for (int i = 0; i < size; i++) {
                        if (((Milestone) zzdq.get(i)).getMilestoneId().equals(str)) {
                            this.zzhq = (Milestone) zzdq.get(i);
                            return;
                        }
                    }
                    this.zzhq = null;
                } else {
                    this.zzhq = null;
                    this.zzhk = null;
                }
                questBuffer.release();
            } finally {
                questBuffer.release();
            }
        }

        public final Milestone getMilestone() {
            return this.zzhq;
        }

        public final Quest getQuest() {
            return this.zzhk;
        }
    }

    private static final class zzh extends zzl implements CommitSnapshotResult {
        private final SnapshotMetadata zzhr;

        zzh(DataHolder dataHolder) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() > 0) {
                    this.zzhr = new SnapshotMetadataEntity((SnapshotMetadata) snapshotMetadataBuffer.get(0));
                } else {
                    this.zzhr = null;
                }
            } finally {
                snapshotMetadataBuffer.release();
            }
        }

        public final SnapshotMetadata getSnapshotMetadata() {
            return this.zzhr;
        }
    }

    private static final class zzi implements DeleteSnapshotResult {
        private final Status zzhl;
        private final String zzhs;

        zzi(int i, String str) {
            this.zzhl = GamesStatusCodes.zza(i);
            this.zzhs = str;
        }

        public final Status getStatus() {
            return this.zzhl;
        }

        public final String getSnapshotId() {
            return this.zzhs;
        }
    }

    private static final class zzj extends zzat<LoadEventsResult> {
        zzj(ResultHolder<LoadEventsResult> resultHolder) {
            super(resultHolder);
        }

        public final void zzb(DataHolder dataHolder) {
            setResult(new zzx(dataHolder));
        }
    }

    private class zzk extends zzeh {
        zzk() {
            super(zze.this.getContext().getMainLooper(), 1000);
        }

        /* access modifiers changed from: protected */
        public final void zzf(String str, int i) {
            try {
                if (zze.this.isConnected()) {
                    ((zzbu) zze.this.getService()).zza(str, i);
                    return;
                }
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 89);
                sb.append("Unable to increment event ");
                sb.append(str);
                sb.append(" by ");
                sb.append(i);
                sb.append(" because the games client is no longer connected");
                zzbd.m3401e("GamesClientImpl", sb.toString());
            } catch (RemoteException e) {
                zze.zza(e);
            } catch (SecurityException e2) {
                zze.zza(e2);
            }
        }
    }

    private static abstract class zzl extends DataHolderResult {
        zzl(DataHolder dataHolder) {
            super(dataHolder, GamesStatusCodes.zza(dataHolder.getStatusCode()));
        }
    }

    private static final class zzm implements GetServerAuthCodeResult {
        private final Status zzhl;
        private final String zzht;

        zzm(Status status, String str) {
            this.zzhl = status;
            this.zzht = str;
        }

        public final Status getStatus() {
            return this.zzhl;
        }

        public final String getCode() {
            return this.zzht;
        }
    }

    private static final class zzn extends zzbd implements InitiateMatchResult {
        zzn(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class zzo extends zzu<OnInvitationReceivedListener> {
        zzo(ListenerHolder<OnInvitationReceivedListener> listenerHolder) {
            super(listenerHolder);
        }

        public final void zzl(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            try {
                Invitation invitation = invitationBuffer.getCount() > 0 ? (Invitation) ((Invitation) invitationBuffer.get(0)).freeze() : null;
                if (invitation != null) {
                    zzc(new zzae(invitation));
                }
            } finally {
                invitationBuffer.release();
            }
        }

        public final void onInvitationRemoved(String str) {
            zzc(new zzaf(str));
        }
    }

    private static final class zzp extends zzat<LoadInvitationsResult> {
        zzp(ResultHolder<LoadInvitationsResult> resultHolder) {
            super(resultHolder);
        }

        public final void zzk(DataHolder dataHolder) {
            setResult(new zzz(dataHolder));
        }
    }

    private static final class zzq extends zzl implements LeaderboardMetadataResult {
        private final LeaderboardBuffer zzhw;

        zzq(DataHolder dataHolder) {
            super(dataHolder);
            this.zzhw = new LeaderboardBuffer(dataHolder);
        }

        public final LeaderboardBuffer getLeaderboards() {
            return this.zzhw;
        }
    }

    private static final class zzr extends zzat<LoadScoresResult> {
        zzr(ResultHolder<LoadScoresResult> resultHolder) {
            super(resultHolder);
        }

        public final void zza(DataHolder dataHolder, DataHolder dataHolder2) {
            setResult(new zzah(dataHolder, dataHolder2));
        }
    }

    private static final class zzs extends zzat<LeaderboardMetadataResult> {
        zzs(ResultHolder<LeaderboardMetadataResult> resultHolder) {
            super(resultHolder);
        }

        public final void zzc(DataHolder dataHolder) {
            setResult(new zzq(dataHolder));
        }
    }

    private static final class zzt extends zzbd implements LeaveMatchResult {
        zzt(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static abstract class zzu<T> extends zza {
        private final ListenerHolder<T> zzhx;

        zzu(ListenerHolder<T> listenerHolder) {
            this.zzhx = (ListenerHolder) Preconditions.checkNotNull(listenerHolder, "Callback must not be null");
        }

        /* access modifiers changed from: 0000 */
        public final void zzc(zzap<T> zzap) {
            this.zzhx.notifyListener(zze.zza(zzap));
        }
    }

    private static abstract class zzv<T> implements Notifier<T> {
        private zzv() {
        }

        public void onNotifyListenerFailed() {
        }

        /* synthetic */ zzv(zzf zzf) {
            this();
        }
    }

    private static final class zzw extends zzl implements LoadAchievementsResult {
        private final AchievementBuffer zzhy;

        zzw(DataHolder dataHolder) {
            super(dataHolder);
            this.zzhy = new AchievementBuffer(dataHolder);
        }

        public final AchievementBuffer getAchievements() {
            return this.zzhy;
        }
    }

    private static final class zzx extends zzl implements LoadEventsResult {
        private final EventBuffer zzhz;

        zzx(DataHolder dataHolder) {
            super(dataHolder);
            this.zzhz = new EventBuffer(dataHolder);
        }

        public final EventBuffer getEvents() {
            return this.zzhz;
        }
    }

    private static final class zzy extends zzl implements LoadGamesResult {
        private final GameBuffer zzia;

        zzy(DataHolder dataHolder) {
            super(dataHolder);
            this.zzia = new GameBuffer(dataHolder);
        }

        public final GameBuffer getGames() {
            return this.zzia;
        }
    }

    private static final class zzz extends zzl implements LoadInvitationsResult {
        private final InvitationBuffer zzib;

        zzz(DataHolder dataHolder) {
            super(dataHolder);
            this.zzib = new InvitationBuffer(dataHolder);
        }

        public final InvitationBuffer getInvitations() {
            return this.zzib;
        }
    }

    public zze(Context context, Looper looper, ClientSettings clientSettings, GamesOptions gamesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 1, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzgp = clientSettings.getRealClientPackageName();
        this.zzgu = new Binder();
        this.zzgs = zzby.zza(this, clientSettings.getGravityForPopups());
        this.zzgv = (long) hashCode();
        this.zzgx = gamesOptions;
        if (this.zzgx.zzaz) {
            return;
        }
        if (clientSettings.getViewForPopups() != null || (context instanceof Activity)) {
            zza(clientSettings.getViewForPopups());
        }
    }

    public int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* access modifiers changed from: protected */
    public String getServiceDescriptor() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    /* access modifiers changed from: protected */
    public String getStartServiceAction() {
        return "com.google.android.gms.games.service.START";
    }

    public boolean requiresSignIn() {
        return true;
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        this.zzgt = false;
    }

    public final void zzk(int i) {
        this.zzgs.setGravity(i);
    }

    public final void zza(View view) {
        this.zzgs.zzb(view);
    }

    /* access modifiers changed from: protected */
    public Set<Scope> validateScopes(Set<Scope> set) {
        HashSet hashSet = new HashSet(set);
        boolean contains = set.contains(Games.SCOPE_GAMES);
        boolean contains2 = set.contains(Games.SCOPE_GAMES_LITE);
        if (set.contains(Games.zzam)) {
            Preconditions.checkState(!contains, "Cannot have both %s and %s!", Scopes.GAMES, FirstPartyScopes.GAMES_1P);
        } else {
            Preconditions.checkState(contains || contains2, "Games APIs requires %s function.", Scopes.GAMES_LITE);
            if (contains2 && contains) {
                hashSet.remove(Games.SCOPE_GAMES_LITE);
            }
        }
        return hashSet;
    }

    public void connect(ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.zzgq = null;
        this.zzgr = null;
        super.connect(connectionProgressReportCallbacks);
    }

    public void disconnect() {
        this.zzgt = false;
        if (isConnected()) {
            try {
                zzbu zzbu = (zzbu) getService();
                zzbu.zzci();
                this.zzgo.flush();
                zzbu.zza(this.zzgv);
            } catch (RemoteException unused) {
                zzbd.m3404w("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    public Bundle getConnectionHint() {
        try {
            Bundle connectionHint = ((zzbu) getService()).getConnectionHint();
            if (connectionHint != null) {
                connectionHint.setClassLoader(zze.class.getClassLoader());
                this.zzgy = connectionHint;
            }
            return connectionHint;
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    @Nullable
    public final Bundle zzat() {
        Bundle connectionHint = getConnectionHint();
        if (connectionHint == null) {
            connectionHint = this.zzgy;
        }
        this.zzgy = null;
        return connectionHint;
    }

    /* access modifiers changed from: protected */
    public Bundle getGetServiceRequestExtraArgs() {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle zzg2 = this.zzgx.zzg();
        zzg2.putString(GamesExtraArgs.GAME_PACKAGE_NAME, this.zzgp);
        zzg2.putString(GamesExtraArgs.DESIRED_LOCALE, locale);
        zzg2.putParcelable(GamesExtraArgs.WINDOW_TOKEN, new BinderWrapper(this.zzgs.zzcp()));
        zzg2.putInt("com.google.android.gms.games.key.API_VERSION", 6);
        zzg2.putBundle(GamesExtraArgs.SIGNIN_OPTIONS, SignInClientImpl.createBundleFromClientSettings(getClientSettings()));
        return zzg2;
    }

    public final String zzau() throws RemoteException {
        return ((zzbu) getService()).zzau();
    }

    public final String zzav() {
        try {
            return zzau();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zza(String str, ResultHolder<GetServerAuthCodeResult> resultHolder) throws RemoteException {
        Preconditions.checkNotEmpty(str, "Please provide a valid serverClientId");
        try {
            ((zzbu) getService()).zza(str, (zzbq) new zzy(resultHolder));
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final String zza(boolean z) throws RemoteException {
        PlayerEntity playerEntity = this.zzgq;
        if (playerEntity != null) {
            return playerEntity.getPlayerId();
        }
        return ((zzbu) getService()).zzck();
    }

    public final String zzb(boolean z) {
        try {
            return zza(true);
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    /* JADX INFO: finally extract failed */
    public final Player zzaw() throws RemoteException {
        checkConnected();
        synchronized (this) {
            if (this.zzgq == null) {
                PlayerBuffer playerBuffer = new PlayerBuffer(((zzbu) getService()).zzcl());
                try {
                    if (playerBuffer.getCount() > 0) {
                        this.zzgq = (PlayerEntity) ((Player) playerBuffer.get(0)).freeze();
                    }
                    playerBuffer.release();
                } catch (Throwable th) {
                    playerBuffer.release();
                    throw th;
                }
            }
        }
        return this.zzgq;
    }

    public final Player zzax() {
        try {
            return zzaw();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    /* JADX INFO: finally extract failed */
    public final Game zzay() throws RemoteException {
        checkConnected();
        synchronized (this) {
            if (this.zzgr == null) {
                GameBuffer gameBuffer = new GameBuffer(((zzbu) getService()).zzcm());
                try {
                    if (gameBuffer.getCount() > 0) {
                        this.zzgr = (GameEntity) ((Game) gameBuffer.get(0)).freeze();
                    }
                    gameBuffer.release();
                } catch (Throwable th) {
                    gameBuffer.release();
                    throw th;
                }
            }
        }
        return this.zzgr;
    }

    public final Game zzaz() {
        try {
            return zzay();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zza(ResultHolder<LoadPlayersResult> resultHolder, String str, boolean z) throws RemoteException {
        try {
            ((zzbu) getService()).zzb((zzbq) new zzal(resultHolder), str, z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(ResultHolder<LoadPlayersResult> resultHolder, int i, boolean z, boolean z2) throws RemoteException {
        try {
            ((zzbu) getService()).zza((zzbq) new zzal(resultHolder), i, z, z2);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(ResultHolder<LoadPlayersResult> resultHolder, String str, int i, boolean z, boolean z2) throws RemoteException {
        if (((str.hashCode() == 156408498 && str.equals("played_with")) ? (char) 0 : 65535) != 0) {
            String str2 = "Invalid player collection: ";
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        try {
            ((zzbu) getService()).zza((zzbq) new zzal(resultHolder), str, i, z, z2);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(ResultHolder<LoadPlayersResult> resultHolder, boolean z) throws RemoteException {
        try {
            ((zzbu) getService()).zzc((zzbq) new zzal(resultHolder), z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final Intent zzba() throws RemoteException {
        return ((zzbu) getService()).zzba();
    }

    public final Intent zzbb() {
        try {
            return zzba();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final Intent zza(String str, int i, int i2) {
        try {
            return ((zzbu) getService()).zzb(str, i, i2);
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zzb(ResultHolder<LeaderboardMetadataResult> resultHolder, boolean z) throws RemoteException {
        try {
            ((zzbu) getService()).zzb((zzbq) new zzs(resultHolder), z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzb(ResultHolder<LeaderboardMetadataResult> resultHolder, String str, boolean z) throws RemoteException {
        try {
            ((zzbu) getService()).zza((zzbq) new zzs(resultHolder), str, z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(ResultHolder<LoadPlayerScoreResult> resultHolder, String str, String str2, int i, int i2) throws RemoteException {
        try {
            ((zzbu) getService()).zza((zzbq) new zzz(resultHolder), (String) null, str2, i, i2);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(ResultHolder<LoadScoresResult> resultHolder, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        try {
            ((zzbu) getService()).zza(new zzr(resultHolder), str, i, i2, i3, z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzb(ResultHolder<LoadScoresResult> resultHolder, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        try {
            ((zzbu) getService()).zzb(new zzr(resultHolder), str, i, i2, i3, z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(ResultHolder<LoadScoresResult> resultHolder, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) throws RemoteException {
        try {
            ((zzbu) getService()).zza((zzbq) new zzr(resultHolder), leaderboardScoreBuffer.zzdi().zzdj(), i, i2);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(ResultHolder<SubmitScoreResult> resultHolder, String str, long j, String str2) throws RemoteException {
        try {
            ((zzbu) getService()).zza(resultHolder == null ? null : new zzaa(resultHolder), str, j, str2);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final Intent zzbc() {
        try {
            return ((zzbu) getService()).zzbc();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zzc(ResultHolder<LoadAchievementsResult> resultHolder, boolean z) throws RemoteException {
        try {
            ((zzbu) getService()).zza((zzbq) new zzab(resultHolder), z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(ResultHolder<UpdateAchievementResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbu) getService()).zza((zzbq) resultHolder == null ? null : new zzb(resultHolder), str, this.zzgs.zzcp(), this.zzgs.zzco());
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzb(ResultHolder<UpdateAchievementResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbu) getService()).zzb(resultHolder == null ? null : new zzb(resultHolder), str, this.zzgs.zzcp(), this.zzgs.zzco());
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(ResultHolder<UpdateAchievementResult> resultHolder, String str, int i) throws RemoteException {
        try {
            ((zzbu) getService()).zza(resultHolder == null ? null : new zzb(resultHolder), str, i, this.zzgs.zzcp(), this.zzgs.zzco());
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzb(ResultHolder<UpdateAchievementResult> resultHolder, String str, int i) throws RemoteException {
        try {
            ((zzbu) getService()).zzb(resultHolder == null ? null : new zzb(resultHolder), str, i, this.zzgs.zzcp(), this.zzgs.zzco());
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzd(ResultHolder<LoadEventsResult> resultHolder, boolean z) throws RemoteException {
        this.zzgo.flush();
        try {
            ((zzbu) getService()).zze((zzbq) new zzj(resultHolder), z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(ResultHolder<LoadEventsResult> resultHolder, boolean z, String... strArr) throws RemoteException {
        this.zzgo.flush();
        try {
            ((zzbu) getService()).zza((zzbq) new zzj(resultHolder), z, strArr);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(String str, int i) {
        this.zzgo.zza(str, i);
    }

    public final Intent zzbd() {
        try {
            return ((zzbu) getService()).zzbd();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final Intent zzbe() {
        try {
            return ((zzbu) getService()).zzbe();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zza(ListenerHolder<OnInvitationReceivedListener> listenerHolder) throws RemoteException {
        ((zzbu) getService()).zza((zzbq) new zzo(listenerHolder), this.zzgv);
    }

    public final void zzb(ListenerHolder<OnInvitationReceivedListener> listenerHolder) {
        try {
            zza(listenerHolder);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zzbf() throws RemoteException {
        ((zzbu) getService()).zzb(this.zzgv);
    }

    public final void zzbg() {
        try {
            zzbf();
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zzc(ListenerHolder<OnTurnBasedMatchUpdateReceivedListener> listenerHolder) throws RemoteException {
        ((zzbu) getService()).zzb((zzbq) new zzaj(listenerHolder), this.zzgv);
    }

    public final void zzd(ListenerHolder<OnTurnBasedMatchUpdateReceivedListener> listenerHolder) {
        try {
            zzc(listenerHolder);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zzbh() throws RemoteException {
        ((zzbu) getService()).zzc(this.zzgv);
    }

    public final void zzbi() {
        try {
            zzbh();
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zze(ListenerHolder<QuestUpdateListener> listenerHolder) {
        try {
            ((zzbu) getService()).zzd((zzbq) new zzam(listenerHolder), this.zzgv);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zzbj() {
        try {
            ((zzbu) getService()).zze(this.zzgv);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zzf(ListenerHolder<OnRequestReceivedListener> listenerHolder) {
        try {
            ((zzbu) getService()).zzc((zzbq) new zzaq(listenerHolder), this.zzgv);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zzbk() {
        try {
            ((zzbu) getService()).zzd(this.zzgv);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final Intent zza(PlayerEntity playerEntity) throws RemoteException {
        return ((zzbu) getService()).zza(playerEntity);
    }

    public final Intent zzb(PlayerEntity playerEntity) {
        try {
            return zza(playerEntity);
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final Intent zzbl() throws RemoteException {
        return ((zzbu) getService()).zzbl();
    }

    public final Intent zzbm() {
        try {
            return zzbl();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final Intent zza(Room room, int i) throws RemoteException {
        return ((zzbu) getService()).zza((RoomEntity) room.freeze(), i);
    }

    public final Intent zzb(Room room, int i) {
        try {
            return zza(room, i);
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final Intent zzbn() throws RemoteException {
        return ((zzbu) getService()).zzbn();
    }

    public final Intent zzbo() {
        try {
            return zzbn();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zza(ResultHolder<LoadGamesResult> resultHolder) throws RemoteException {
        try {
            ((zzbu) getService()).zzb((zzbq) new zzac(resultHolder));
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public void onUserSignOut(@NonNull SignOutCallbacks signOutCallbacks) {
        try {
            zzb((ResultHolder<Status>) new zzad<Status>(signOutCallbacks));
        } catch (RemoteException unused) {
            signOutCallbacks.onSignOutComplete();
        }
    }

    public final void zzb(ResultHolder<Status> resultHolder) throws RemoteException {
        this.zzgo.flush();
        try {
            ((zzbu) getService()).zza((zzbq) new zzg(resultHolder));
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final int zzbp() throws RemoteException {
        return ((zzbu) getService()).zzbp();
    }

    public final int zzbq() {
        try {
            return zzbp();
        } catch (RemoteException e) {
            zza(e);
            return 4368;
        }
    }

    public final String zzbr() throws RemoteException {
        return ((zzbu) getService()).zzbr();
    }

    public final String zzbs() {
        try {
            return zzbr();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zza(ResultHolder<LoadInvitationsResult> resultHolder, int i) throws RemoteException {
        try {
            ((zzbu) getService()).zza((zzbq) new zzp(resultHolder), i);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzb(String str, int i) throws RemoteException {
        ((zzbu) getService()).zzb(str, i);
    }

    public final void zzc(String str, int i) {
        try {
            zzb(str, i);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zzd(String str, int i) throws RemoteException {
        ((zzbu) getService()).zzd(str, i);
    }

    public final void zze(String str, int i) {
        try {
            zzd(str, i);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final Intent zza(int i, int i2, boolean z) throws RemoteException {
        return ((zzbu) getService()).zza(i, i2, z);
    }

    public final Intent zzb(int i, int i2, boolean z) {
        try {
            return zza(i, i2, z);
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zza(ResultHolder<InitiateMatchResult> resultHolder, TurnBasedMatchConfig turnBasedMatchConfig) throws RemoteException {
        try {
            ((zzbu) getService()).zza((zzbq) new zzbb(resultHolder), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.zzdp(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzc(ResultHolder<InitiateMatchResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbu) getService()).zzb((zzbq) new zzbb(resultHolder), str);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzd(ResultHolder<InitiateMatchResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbu) getService()).zzc((zzbq) new zzbb(resultHolder), str);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final int zzbt() throws RemoteException {
        return ((zzbu) getService()).zzbt();
    }

    public final int zzbu() {
        try {
            return zzbt();
        } catch (RemoteException e) {
            zza(e);
            return -1;
        }
    }

    public final void zza(ResultHolder<UpdateMatchResult> resultHolder, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException {
        try {
            ((zzbu) getService()).zza((zzbq) new zzbe(resultHolder), str, bArr, str2, participantResultArr);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(ResultHolder<UpdateMatchResult> resultHolder, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException {
        try {
            ((zzbu) getService()).zza((zzbq) new zzbe(resultHolder), str, bArr, participantResultArr);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zze(ResultHolder<LeaveMatchResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbu) getService()).zze((zzbq) new zzbc(resultHolder), str);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(ResultHolder<LeaveMatchResult> resultHolder, String str, String str2) throws RemoteException {
        try {
            ((zzbu) getService()).zza((zzbq) new zzbc(resultHolder), str, str2);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzf(ResultHolder<CancelMatchResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbu) getService()).zzd((zzbq) new zzh(resultHolder), str);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzb(String str) throws RemoteException {
        ((zzbu) getService()).zzf(str);
    }

    public final void zzc(String str) {
        try {
            zzb(str);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zza(ResultHolder<LoadMatchesResult> resultHolder, int i, int[] iArr) throws RemoteException {
        try {
            ((zzbu) getService()).zza((zzbq) new zzbf(resultHolder), i, iArr);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzg(ResultHolder<LoadMatchResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbu) getService()).zzf((zzbq) new zzi(resultHolder), str);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final Intent zzc(int i, int i2, boolean z) throws RemoteException {
        return ((zzbu) getService()).zzc(i, i2, z);
    }

    public final Intent zzd(int i, int i2, boolean z) {
        try {
            return zzc(i, i2, z);
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zza(ListenerHolder<? extends RoomUpdateListener> listenerHolder, ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder2, ListenerHolder<? extends RealTimeMessageReceivedListener> listenerHolder3, RoomConfig roomConfig) throws RemoteException {
        ((zzbu) getService()).zza(new zzau(listenerHolder, listenerHolder2, listenerHolder3), this.zzgu, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), false, this.zzgv);
    }

    public final void zzb(ListenerHolder<? extends RoomUpdateListener> listenerHolder, ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder2, ListenerHolder<? extends RealTimeMessageReceivedListener> listenerHolder3, RoomConfig roomConfig) {
        try {
            zza(listenerHolder, listenerHolder2, listenerHolder3, roomConfig);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zzc(ListenerHolder<? extends RoomUpdateListener> listenerHolder, ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder2, ListenerHolder<? extends RealTimeMessageReceivedListener> listenerHolder3, RoomConfig roomConfig) throws RemoteException {
        ((zzbu) getService()).zza((zzbq) new zzau(listenerHolder, listenerHolder2, listenerHolder3), (IBinder) this.zzgu, roomConfig.getInvitationId(), false, this.zzgv);
    }

    public final void zzd(ListenerHolder<? extends RoomUpdateListener> listenerHolder, ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder2, ListenerHolder<? extends RealTimeMessageReceivedListener> listenerHolder3, RoomConfig roomConfig) {
        try {
            zzc(listenerHolder, listenerHolder2, listenerHolder3, roomConfig);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zza(ListenerHolder<? extends RoomUpdateListener> listenerHolder, String str) {
        try {
            ((zzbu) getService()).zza((zzbq) new zzau(listenerHolder), str);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final int zza(ListenerHolder<ReliableMessageSentCallback> listenerHolder, byte[] bArr, String str, String str2) throws RemoteException {
        return ((zzbu) getService()).zza((zzbq) new zzao(listenerHolder), bArr, str, str2);
    }

    public final int zzb(ListenerHolder<ReliableMessageSentCallback> listenerHolder, byte[] bArr, String str, String str2) {
        try {
            return zza(listenerHolder, bArr, str, str2);
        } catch (RemoteException e) {
            zza(e);
            return -1;
        }
    }

    public final int zza(byte[] bArr, String str, String[] strArr) {
        String str2 = "Participant IDs must not be null";
        Preconditions.checkNotNull(strArr, str2);
        try {
            Preconditions.checkNotNull(strArr, str2);
            return ((zzbu) getService()).zzb(bArr, str, strArr);
        } catch (RemoteException e) {
            zza(e);
            return -1;
        }
    }

    public final int zza(byte[] bArr, String str) throws RemoteException {
        return ((zzbu) getService()).zzb(bArr, str, (String[]) null);
    }

    public final int zzb(byte[] bArr, String str) {
        try {
            return zza(bArr, str);
        } catch (RemoteException e) {
            zza(e);
            return -1;
        }
    }

    public final void zzl(int i) throws RemoteException {
        ((zzbu) getService()).zzl(i);
    }

    public final void zzm(int i) {
        try {
            zzl(i);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final Intent zzbv() {
        try {
            return ((zzbu) getService()).zzbv();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final Intent zza(int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        try {
            Intent zza2 = ((zzbu) getService()).zza(i, bArr, i2, str);
            Preconditions.checkNotNull(bitmap, "Must provide a non null icon");
            zza2.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
            return zza2;
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final int zzbw() {
        try {
            return ((zzbu) getService()).zzbw();
        } catch (RemoteException e) {
            zza(e);
            return -1;
        }
    }

    public final int zzbx() {
        try {
            return ((zzbu) getService()).zzbx();
        } catch (RemoteException e) {
            zza(e);
            return -1;
        }
    }

    public final void zza(ResultHolder<UpdateRequestsResult> resultHolder, String[] strArr) throws RemoteException {
        try {
            ((zzbu) getService()).zza((zzbq) new zzas(resultHolder), strArr);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzb(ResultHolder<UpdateRequestsResult> resultHolder, String[] strArr) throws RemoteException {
        try {
            ((zzbu) getService()).zzb((zzbq) new zzas(resultHolder), strArr);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(ResultHolder<LoadRequestsResult> resultHolder, int i, int i2, int i3) throws RemoteException {
        try {
            ((zzbu) getService()).zza((zzbq) new zzar(resultHolder), i, i2, i3);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zze(ResultHolder<LoadPlayerStatsResult> resultHolder, boolean z) throws RemoteException {
        try {
            ((zzbu) getService()).zzf((zzbq) new zzj(resultHolder), z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final Intent zza(int[] iArr) {
        try {
            return ((zzbu) getService()).zza(iArr);
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final Intent zzd(String str) {
        try {
            return ((zzbu) getService()).zzd(str);
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zzh(ResultHolder<AcceptQuestResult> resultHolder, String str) throws RemoteException {
        this.zzgo.flush();
        try {
            ((zzbu) getService()).zzh(new zzk(resultHolder), str);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzb(ResultHolder<ClaimMilestoneResult> resultHolder, String str, String str2) throws RemoteException {
        this.zzgo.flush();
        try {
            Preconditions.checkNotNull(str2, "MilestoneId must not be null");
            ((zzbu) getService()).zzb((zzbq) new zzl(resultHolder, str2), str, str2);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(ResultHolder<LoadQuestsResult> resultHolder, int[] iArr, int i, boolean z) throws RemoteException {
        this.zzgo.flush();
        try {
            ((zzbu) getService()).zza((zzbq) new zzan(resultHolder), iArr, i, z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzb(ResultHolder<LoadQuestsResult> resultHolder, boolean z, String[] strArr) throws RemoteException {
        this.zzgo.flush();
        try {
            ((zzbu) getService()).zza((zzbq) new zzan(resultHolder), strArr, z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zze(String str) {
        try {
            ((zzbu) getService()).zza(str, this.zzgs.zzcp(), this.zzgs.zzco());
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final int zzby() throws RemoteException {
        return ((zzbu) getService()).zzby();
    }

    public final int zzbz() {
        try {
            return zzby();
        } catch (RemoteException e) {
            zza(e);
            return -1;
        }
    }

    public final int zzca() throws RemoteException {
        return ((zzbu) getService()).zzca();
    }

    public final int zzcb() {
        try {
            return zzca();
        } catch (RemoteException e) {
            zza(e);
            return -1;
        }
    }

    public final Intent zza(String str, boolean z, boolean z2, int i) throws RemoteException {
        return ((zzbu) getService()).zza(str, z, z2, i);
    }

    public final Intent zzb(String str, boolean z, boolean z2, int i) {
        try {
            return zza(str, z, z2, i);
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zzf(ResultHolder<LoadSnapshotsResult> resultHolder, boolean z) throws RemoteException {
        try {
            ((zzbu) getService()).zzd((zzbq) new zzay(resultHolder), z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(ResultHolder<OpenSnapshotResult> resultHolder, String str, boolean z, int i) throws RemoteException {
        try {
            ((zzbu) getService()).zza((zzbq) new zzax(resultHolder), str, z, i);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(ResultHolder<CommitSnapshotResult> resultHolder, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        Preconditions.checkState(!snapshotContents.isClosed(), "Snapshot already closed");
        BitmapTeleporter zzdt = snapshotMetadataChange.zzdt();
        if (zzdt != null) {
            zzdt.setTempDir(getContext().getCacheDir());
        }
        Contents zzds = snapshotContents.zzds();
        snapshotContents.close();
        try {
            ((zzbu) getService()).zza((zzbq) new zzm(resultHolder), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzds);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(Snapshot snapshot) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        Preconditions.checkState(!snapshotContents.isClosed(), "Snapshot already closed");
        Contents zzds = snapshotContents.zzds();
        snapshotContents.close();
        ((zzbu) getService()).zza(zzds);
    }

    public final void zzb(Snapshot snapshot) {
        try {
            zza(snapshot);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zzi(ResultHolder<DeleteSnapshotResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbu) getService()).zzg(new zzn(resultHolder), str);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(ResultHolder<OpenSnapshotResult> resultHolder, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) throws RemoteException {
        Preconditions.checkState(!snapshotContents.isClosed(), "SnapshotContents already closed");
        BitmapTeleporter zzdt = snapshotMetadataChange.zzdt();
        if (zzdt != null) {
            zzdt.setTempDir(getContext().getCacheDir());
        }
        Contents zzds = snapshotContents.zzds();
        snapshotContents.close();
        try {
            ((zzbu) getService()).zza((zzbq) new zzax(resultHolder), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzds);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzc(ResultHolder<CaptureCapabilitiesResult> resultHolder) throws RemoteException {
        try {
            ((zzbu) getService()).zzc((zzbq) new zzo(resultHolder));
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final Intent zzcc() throws RemoteException {
        return ((zzbu) getService()).zzcn();
    }

    public final Intent zzcd() {
        try {
            return zzcc();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zzd(ResultHolder<CaptureStateResult> resultHolder) throws RemoteException {
        try {
            ((zzbu) getService()).zzd((zzbq) new zzq(resultHolder));
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzb(ResultHolder<CaptureAvailableResult> resultHolder, int i) throws RemoteException {
        try {
            ((zzbu) getService()).zzb((zzbq) new zzr(resultHolder), i);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final boolean zzce() throws RemoteException {
        return ((zzbu) getService()).zzce();
    }

    public final boolean zzcf() {
        try {
            return zzce();
        } catch (RemoteException e) {
            zza(e);
            return false;
        }
    }

    public final void zzg(ListenerHolder<CaptureOverlayStateListener> listenerHolder) throws RemoteException {
        ((zzbu) getService()).zze((zzbq) new zzs(listenerHolder), this.zzgv);
    }

    public final void zzh(ListenerHolder<CaptureOverlayStateListener> listenerHolder) {
        try {
            zzg(listenerHolder);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zzcg() throws RemoteException {
        ((zzbu) getService()).zzf(this.zzgv);
    }

    public final void zzch() {
        try {
            zzcg();
        } catch (RemoteException e) {
            zza(e);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zza(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((zzbu) getService()).zza(iBinder, bundle);
            } catch (RemoteException e) {
                zza(e);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzci() {
        if (isConnected()) {
            try {
                ((zzbu) getService()).zzci();
            } catch (RemoteException e) {
                zza(e);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void zza(RemoteException remoteException) {
        zzbd.m3405w("GamesClientImpl", "service died", remoteException);
    }

    /* access modifiers changed from: private */
    public static void zza(SecurityException securityException) {
        zzbd.m3402e("GamesClientImpl", "Is player signed out?", securityException);
    }

    private static <R> void zza(ResultHolder<R> resultHolder, SecurityException securityException) {
        if (resultHolder != null) {
            resultHolder.setFailedResult(GamesClientStatusCodes.zza(4));
        }
    }

    /* access modifiers changed from: private */
    public static Room zzay(DataHolder dataHolder) {
        com.google.android.gms.games.multiplayer.realtime.zzb zzb2 = new com.google.android.gms.games.multiplayer.realtime.zzb(dataHolder);
        try {
            return zzb2.getCount() > 0 ? (Room) ((Room) zzb2.get(0)).freeze() : null;
        } finally {
            zzb2.release();
        }
    }

    /* access modifiers changed from: protected */
    public void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null) {
            bundle.setClassLoader(zze.class.getClassLoader());
            this.zzgt = bundle.getBoolean("show_welcome_popup");
            this.zzgw = this.zzgt;
            this.zzgq = (PlayerEntity) bundle.getParcelable("com.google.android.gms.games.current_player");
            this.zzgr = (GameEntity) bundle.getParcelable("com.google.android.gms.games.current_game");
        }
        super.onPostInitHandler(i, iBinder, bundle, i2);
    }

    /* access modifiers changed from: private */
    public static <T> Notifier<T> zza(zzap<T> zzap2) {
        return new zzu(zzap2);
    }

    /* access modifiers changed from: private */
    public static <T> Notifier<T> zza(DataHolder dataHolder, zzaw<T> zzaw2) {
        return new zzv(zzaw2, dataHolder);
    }

    /* access modifiers changed from: private */
    public static <T> Notifier<T> zza(DataHolder dataHolder, String[] strArr, zzav<T> zzav2) {
        return new zzw(zzav2, dataHolder, new ArrayList(Arrays.asList(strArr)));
    }

    /* access modifiers changed from: private */
    public static <T> Notifier<T> zza(DataHolder dataHolder, zzaz<T> zzaz2) {
        return new zzx(zzaz2, dataHolder);
    }

    public /* synthetic */ void onConnectedLocked(@NonNull IInterface iInterface) {
        zzbu zzbu = (zzbu) iInterface;
        super.onConnectedLocked(zzbu);
        if (this.zzgt) {
            this.zzgs.zzcr();
            this.zzgt = false;
        }
        if (!this.zzgx.zzar && !this.zzgx.zzaz) {
            try {
                zzbu.zza((zzbs) new zzp(new zzbw(this.zzgs.zzcq())), this.zzgv);
            } catch (RemoteException e) {
                zza(e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
        if (queryLocalInterface instanceof zzbu) {
            return (zzbu) queryLocalInterface;
        }
        return new zzbv(iBinder);
    }
}
