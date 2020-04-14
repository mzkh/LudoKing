package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.common.FirstPartyScopes;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.appcontent.zzm;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.internal.games.zzac;
import com.google.android.gms.internal.games.zzah;
import com.google.android.gms.internal.games.zzal;
import com.google.android.gms.internal.games.zzbb;
import com.google.android.gms.internal.games.zzbc;
import com.google.android.gms.internal.games.zzbd;
import com.google.android.gms.internal.games.zzbn;
import com.google.android.gms.internal.games.zzby;
import com.google.android.gms.internal.games.zzbz;
import com.google.android.gms.internal.games.zzch;
import com.google.android.gms.internal.games.zzcv;
import com.google.android.gms.internal.games.zzcz;
import com.google.android.gms.internal.games.zzdw;
import com.google.android.gms.internal.games.zze;
import com.google.android.gms.internal.games.zzs;
import com.google.android.gms.internal.games.zzu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@KeepForSdk
@VisibleForTesting
public final class Games {
    @Deprecated
    public static final Api<GamesOptions> API = new Api<>("Games.API", zzak, CLIENT_KEY);
    @Deprecated
    public static final Achievements Achievements = new zze();
    static final ClientKey<com.google.android.gms.games.internal.zze> CLIENT_KEY = new ClientKey<>();
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final String EXTRA_STATUS = "status";
    @Deprecated
    public static final Events Events = new zzu();
    @Deprecated
    public static final GamesMetadata GamesMetadata = new zzac();
    @Deprecated
    public static final Invitations Invitations = new zzah();
    @Deprecated
    public static final Leaderboards Leaderboards = new zzal();
    @Deprecated
    public static final Notifications Notifications = new zzbc();
    @Deprecated
    public static final Players Players = new zzbd();
    @Deprecated
    public static final Quests Quests = new zzbn();
    @Deprecated
    public static final RealTimeMultiplayer RealTimeMultiplayer = new zzby();
    @Deprecated
    public static final Requests Requests = new zzbz();
    public static final Scope SCOPE_GAMES = new Scope(Scopes.GAMES);
    public static final Scope SCOPE_GAMES_LITE = new Scope(Scopes.GAMES_LITE);
    @Deprecated
    public static final Snapshots Snapshots = new zzch();
    @Deprecated
    public static final Stats Stats = new zzcv();
    @Deprecated
    public static final TurnBasedMultiplayer TurnBasedMultiplayer = new zzcz();
    @Deprecated
    public static final Videos Videos = new zzdw();
    private static final AbstractClientBuilder<com.google.android.gms.games.internal.zze, GamesOptions> zzak = new zzi();
    private static final AbstractClientBuilder<com.google.android.gms.games.internal.zze, GamesOptions> zzal = new zzj();
    @ShowFirstParty
    public static final Scope zzam = new Scope(FirstPartyScopes.GAMES_1P);
    @ShowFirstParty
    private static final Api<GamesOptions> zzan = new Api<>("Games.API_1P", zzal, CLIENT_KEY);
    private static final zzm zzao = new zzs();
    private static final Multiplayer zzap = new zzbb();

    public static final class GamesOptions implements GoogleSignInOptionsExtension, HasGoogleSignInAccountOptions, Optional {
        public final boolean zzar;
        public final boolean zzas;
        public final int zzat;
        public final boolean zzau;
        public final int zzav;
        public final String zzaw;
        public final ArrayList<String> zzax;
        public final boolean zzay;
        public final boolean zzaz;
        public final boolean zzba;
        public final GoogleSignInAccount zzbb;
        public final String zzbc;

        public static final class Builder {
            private boolean zzar;
            private boolean zzas;
            private int zzat;
            private boolean zzau;
            private int zzav;
            private String zzaw;
            private ArrayList<String> zzax;
            private boolean zzay;
            private boolean zzaz;
            private boolean zzba;
            GoogleSignInAccount zzbb;
            private String zzbc;

            private Builder() {
                this.zzar = false;
                this.zzas = true;
                this.zzat = 17;
                this.zzau = false;
                this.zzav = 4368;
                this.zzaw = null;
                this.zzax = new ArrayList<>();
                this.zzay = false;
                this.zzaz = false;
                this.zzba = false;
                this.zzbb = null;
                this.zzbc = null;
            }

            private Builder(GamesOptions gamesOptions) {
                this.zzar = false;
                this.zzas = true;
                this.zzat = 17;
                this.zzau = false;
                this.zzav = 4368;
                this.zzaw = null;
                this.zzax = new ArrayList<>();
                this.zzay = false;
                this.zzaz = false;
                this.zzba = false;
                this.zzbb = null;
                this.zzbc = null;
                if (gamesOptions != null) {
                    this.zzar = gamesOptions.zzar;
                    this.zzas = gamesOptions.zzas;
                    this.zzat = gamesOptions.zzat;
                    this.zzau = gamesOptions.zzau;
                    this.zzav = gamesOptions.zzav;
                    this.zzaw = gamesOptions.zzaw;
                    this.zzax = gamesOptions.zzax;
                    this.zzay = gamesOptions.zzay;
                    this.zzaz = gamesOptions.zzaz;
                    this.zzba = gamesOptions.zzba;
                    this.zzbb = gamesOptions.zzbb;
                    this.zzbc = gamesOptions.zzbc;
                }
            }

            public final Builder setShowConnectingPopup(boolean z) {
                this.zzas = z;
                this.zzat = 17;
                return this;
            }

            public final Builder setShowConnectingPopup(boolean z, int i) {
                this.zzas = z;
                this.zzat = i;
                return this;
            }

            public final Builder setSdkVariant(int i) {
                this.zzav = i;
                return this;
            }

            public final GamesOptions build() {
                GamesOptions gamesOptions = new GamesOptions(this.zzar, this.zzas, this.zzat, this.zzau, this.zzav, this.zzaw, this.zzax, this.zzay, this.zzaz, this.zzba, this.zzbb, this.zzbc, null);
                return gamesOptions;
            }

            /* synthetic */ Builder(zzi zzi) {
                this();
            }

            /* synthetic */ Builder(GamesOptions gamesOptions, zzi zzi) {
                this((GamesOptions) null);
            }
        }

        private GamesOptions(boolean z, boolean z2, int i, boolean z3, int i2, String str, ArrayList<String> arrayList, boolean z4, boolean z5, boolean z6, GoogleSignInAccount googleSignInAccount, String str2) {
            this.zzar = z;
            this.zzas = z2;
            this.zzat = i;
            this.zzau = z3;
            this.zzav = i2;
            this.zzaw = str;
            this.zzax = arrayList;
            this.zzay = z4;
            this.zzaz = z5;
            this.zzba = z6;
            this.zzbb = googleSignInAccount;
            this.zzbc = str2;
        }

        public final int getExtensionType() {
            return 1;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GamesOptions)) {
                return false;
            }
            GamesOptions gamesOptions = (GamesOptions) obj;
            if (this.zzar == gamesOptions.zzar && this.zzas == gamesOptions.zzas && this.zzat == gamesOptions.zzat && this.zzau == gamesOptions.zzau && this.zzav == gamesOptions.zzav) {
                String str = this.zzaw;
                if (str != null ? str.equals(gamesOptions.zzaw) : gamesOptions.zzaw == null) {
                    if (this.zzax.equals(gamesOptions.zzax) && this.zzay == gamesOptions.zzay && this.zzaz == gamesOptions.zzaz && this.zzba == gamesOptions.zzba) {
                        GoogleSignInAccount googleSignInAccount = this.zzbb;
                        if (googleSignInAccount != null ? googleSignInAccount.equals(gamesOptions.zzbb) : gamesOptions.zzbb == null) {
                            if (TextUtils.equals(this.zzbc, gamesOptions.zzbc)) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }

        public final int hashCode() {
            int i = ((((((((((this.zzar ? 1 : 0) + true) * 31) + (this.zzas ? 1 : 0)) * 31) + this.zzat) * 31) + (this.zzau ? 1 : 0)) * 31) + this.zzav) * 31;
            String str = this.zzaw;
            int i2 = 0;
            int hashCode = (((((((((i + (str == null ? 0 : str.hashCode())) * 31) + this.zzax.hashCode()) * 31) + (this.zzay ? 1 : 0)) * 31) + (this.zzaz ? 1 : 0)) * 31) + (this.zzba ? 1 : 0)) * 31;
            GoogleSignInAccount googleSignInAccount = this.zzbb;
            int hashCode2 = (hashCode + (googleSignInAccount == null ? 0 : googleSignInAccount.hashCode())) * 31;
            String str2 = this.zzbc;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return hashCode2 + i2;
        }

        public final List<Scope> getImpliedScopes() {
            if (this.zzay) {
                return Collections.singletonList(Games.SCOPE_GAMES);
            }
            return Collections.singletonList(Games.SCOPE_GAMES_LITE);
        }

        public final Bundle toBundle() {
            return zzg();
        }

        public final Bundle zzg() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.zzar);
            bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.zzas);
            bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.zzat);
            bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.zzau);
            bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.zzav);
            bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.zzaw);
            bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.zzax);
            bundle.putBoolean("com.google.android.gms.games.key.requireGooglePlus", this.zzay);
            bundle.putBoolean("com.google.android.gms.games.key.unauthenticated", this.zzaz);
            bundle.putBoolean("com.google.android.gms.games.key.skipWelcomePopup", this.zzba);
            bundle.putParcelable("com.google.android.gms.games.key.googleSignInAccount", this.zzbb);
            bundle.putString("com.google.android.gms.games.key.realClientPackageName", this.zzbc);
            return bundle;
        }

        public static Builder builder() {
            return new Builder((zzi) null);
        }

        public final GoogleSignInAccount getGoogleSignInAccount() {
            return this.zzbb;
        }

        /* synthetic */ GamesOptions(boolean z, boolean z2, int i, boolean z3, int i2, String str, ArrayList arrayList, boolean z4, boolean z5, boolean z6, GoogleSignInAccount googleSignInAccount, String str2, zzi zzi) {
            this(z, z2, i, z3, i2, str, arrayList, z4, z5, z6, googleSignInAccount, str2);
        }
    }

    @KeepForSdk
    @Deprecated
    public interface GetServerAuthCodeResult extends Result {
        @KeepForSdk
        String getCode();
    }

    public static abstract class zza<T extends Result> extends ApiMethodImpl<T, com.google.android.gms.games.internal.zze> {
        public zza(GoogleApiClient googleApiClient) {
            super((AnyClientKey<A>) Games.CLIENT_KEY, googleApiClient);
        }
    }

    private static abstract class zzb extends AbstractClientBuilder<com.google.android.gms.games.internal.zze, GamesOptions> {
        private zzb() {
        }

        public int getPriority() {
            return 1;
        }

        public /* synthetic */ Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            GamesOptions gamesOptions = (GamesOptions) obj;
            if (gamesOptions == null) {
                gamesOptions = new Builder((zzi) null).build();
            }
            com.google.android.gms.games.internal.zze zze = new com.google.android.gms.games.internal.zze(context, looper, clientSettings, gamesOptions, connectionCallbacks, onConnectionFailedListener);
            return zze;
        }

        /* synthetic */ zzb(zzi zzi) {
            this();
        }
    }

    private static abstract class zzc extends zza<GetServerAuthCodeResult> {
        private zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return new zzm(this, status);
        }

        /* synthetic */ zzc(GoogleApiClient googleApiClient, zzi zzi) {
            this(googleApiClient);
        }
    }

    private static abstract class zzd extends zza<Status> {
        private zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return status;
        }

        /* synthetic */ zzd(GoogleApiClient googleApiClient, zzi zzi) {
            this(googleApiClient);
        }
    }

    private Games() {
    }

    public static com.google.android.gms.games.internal.zze zza(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, true);
    }

    public static com.google.android.gms.games.internal.zze zza(GoogleApiClient googleApiClient, boolean z) {
        Preconditions.checkArgument(googleApiClient != null, "GoogleApiClient parameter is required.");
        Preconditions.checkState(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        return zzb(googleApiClient, z);
    }

    public static com.google.android.gms.games.internal.zze zzb(GoogleApiClient googleApiClient, boolean z) {
        Preconditions.checkState(googleApiClient.hasApi(API), "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(API);
        if (z && !hasConnectedApi) {
            throw new IllegalStateException("GoogleApiClient has an optional Games.API and is not connected to Games. Use GoogleApiClient.hasConnectedApi(Games.API) to guard this call.");
        } else if (hasConnectedApi) {
            return (com.google.android.gms.games.internal.zze) googleApiClient.getClient(CLIENT_KEY);
        } else {
            return null;
        }
    }

    @Deprecated
    public static void setGravityForPopups(GoogleApiClient googleApiClient, int i) {
        com.google.android.gms.games.internal.zze zza2 = zza(googleApiClient, false);
        if (zza2 != null) {
            zza2.zzk(i);
        }
    }

    @Deprecated
    public static void setViewForPopups(GoogleApiClient googleApiClient, View view) {
        Preconditions.checkNotNull(view);
        com.google.android.gms.games.internal.zze zza2 = zza(googleApiClient, false);
        if (zza2 != null) {
            zza2.zza(view);
        }
    }

    @RequiresPermission("android.permission.GET_ACCOUNTS")
    @Deprecated
    public static String getCurrentAccountName(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, true).zzav();
    }

    @KeepForSdk
    @Deprecated
    public static PendingResult<GetServerAuthCodeResult> getGamesServerAuthCode(GoogleApiClient googleApiClient, String str) {
        Preconditions.checkNotEmpty(str, "Please provide a valid serverClientId");
        return googleApiClient.execute(new zzk(googleApiClient, str));
    }

    @Deprecated
    public static String getAppId(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, true).zzbs();
    }

    @Deprecated
    public static Intent getSettingsIntent(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, true).zzbo();
    }

    @Deprecated
    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new zzl(googleApiClient));
    }

    private static GamesOptions zza(@NonNull GoogleSignInAccount googleSignInAccount) {
        Builder builder = new Builder(null, null);
        builder.zzbb = googleSignInAccount;
        return builder.setSdkVariant(1052947).build();
    }

    public static GamesMetadataClient getGamesMetadataClient(@NonNull Activity activity, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new GamesMetadataClient(activity, zza(googleSignInAccount));
    }

    public static GamesMetadataClient getGamesMetadataClient(@NonNull Context context, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new GamesMetadataClient(context, zza(googleSignInAccount));
    }

    public static AchievementsClient getAchievementsClient(@NonNull Activity activity, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new AchievementsClient(activity, zza(googleSignInAccount));
    }

    public static AchievementsClient getAchievementsClient(@NonNull Context context, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new AchievementsClient(context, zza(googleSignInAccount));
    }

    public static EventsClient getEventsClient(@NonNull Activity activity, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new EventsClient(activity, zza(googleSignInAccount));
    }

    public static EventsClient getEventsClient(@NonNull Context context, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new EventsClient(context, zza(googleSignInAccount));
    }

    public static LeaderboardsClient getLeaderboardsClient(@NonNull Activity activity, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new LeaderboardsClient(activity, zza(googleSignInAccount));
    }

    public static LeaderboardsClient getLeaderboardsClient(@NonNull Context context, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new LeaderboardsClient(context, zza(googleSignInAccount));
    }

    public static InvitationsClient getInvitationsClient(@NonNull Activity activity, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new InvitationsClient(activity, zza(googleSignInAccount));
    }

    public static InvitationsClient getInvitationsClient(@NonNull Context context, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new InvitationsClient(context, zza(googleSignInAccount));
    }

    public static TurnBasedMultiplayerClient getTurnBasedMultiplayerClient(@NonNull Activity activity, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new TurnBasedMultiplayerClient(activity, zza(googleSignInAccount));
    }

    public static TurnBasedMultiplayerClient getTurnBasedMultiplayerClient(@NonNull Context context, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new TurnBasedMultiplayerClient(context, zza(googleSignInAccount));
    }

    public static RealTimeMultiplayerClient getRealTimeMultiplayerClient(@NonNull Activity activity, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new RealTimeMultiplayerClient(activity, zza(googleSignInAccount));
    }

    public static RealTimeMultiplayerClient getRealTimeMultiplayerClient(@NonNull Context context, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new RealTimeMultiplayerClient(context, zza(googleSignInAccount));
    }

    public static PlayersClient getPlayersClient(@NonNull Activity activity, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new PlayersClient(activity, zza(googleSignInAccount));
    }

    public static PlayersClient getPlayersClient(@NonNull Context context, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new PlayersClient(context, zza(googleSignInAccount));
    }

    public static NotificationsClient getNotificationsClient(@NonNull Activity activity, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new NotificationsClient(activity, zza(googleSignInAccount));
    }

    public static NotificationsClient getNotificationsClient(@NonNull Context context, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new NotificationsClient(context, zza(googleSignInAccount));
    }

    public static SnapshotsClient getSnapshotsClient(@NonNull Activity activity, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new SnapshotsClient(activity, zza(googleSignInAccount));
    }

    public static SnapshotsClient getSnapshotsClient(@NonNull Context context, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new SnapshotsClient(context, zza(googleSignInAccount));
    }

    public static PlayerStatsClient getPlayerStatsClient(@NonNull Activity activity, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new PlayerStatsClient(activity, zza(googleSignInAccount));
    }

    public static PlayerStatsClient getPlayerStatsClient(@NonNull Context context, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new PlayerStatsClient(context, zza(googleSignInAccount));
    }

    public static VideosClient getVideosClient(@NonNull Activity activity, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new VideosClient(activity, zza(googleSignInAccount));
    }

    public static VideosClient getVideosClient(@NonNull Context context, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new VideosClient(context, zza(googleSignInAccount));
    }

    public static GamesClient getGamesClient(@NonNull Activity activity, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new GamesClient(activity, zza(googleSignInAccount));
    }

    public static GamesClient getGamesClient(@NonNull Context context, @NonNull GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new GamesClient(context, zza(googleSignInAccount));
    }

    @Deprecated
    public static int getSdkVariant(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, true).zzbq();
    }
}
