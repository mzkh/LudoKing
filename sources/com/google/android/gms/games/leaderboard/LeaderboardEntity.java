package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

@UsedByReflection("GamesClientImpl.java")
public final class LeaderboardEntity implements Leaderboard {
    private final String zzac;
    private final String zzn;
    private final String zznt;
    private final int zznu;
    private final ArrayList<LeaderboardVariantEntity> zznv;
    private final Game zznw;
    private final Uri zzr;

    public LeaderboardEntity(Leaderboard leaderboard) {
        Game game;
        this.zznt = leaderboard.getLeaderboardId();
        this.zzn = leaderboard.getDisplayName();
        this.zzr = leaderboard.getIconImageUri();
        this.zzac = leaderboard.getIconImageUrl();
        this.zznu = leaderboard.getScoreOrder();
        Game game2 = leaderboard.getGame();
        if (game2 == null) {
            game = null;
        } else {
            game = new GameEntity(game2);
        }
        this.zznw = game;
        ArrayList variants = leaderboard.getVariants();
        int size = variants.size();
        this.zznv = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.zznv.add((LeaderboardVariantEntity) ((LeaderboardVariant) variants.get(i)).freeze());
        }
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String getLeaderboardId() {
        return this.zznt;
    }

    public final String getDisplayName() {
        return this.zzn;
    }

    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzn, charArrayBuffer);
    }

    public final Uri getIconImageUri() {
        return this.zzr;
    }

    public final String getIconImageUrl() {
        return this.zzac;
    }

    public final int getScoreOrder() {
        return this.zznu;
    }

    public final ArrayList<LeaderboardVariant> getVariants() {
        return new ArrayList<>(this.zznv);
    }

    public final Game getGame() {
        return this.zznw;
    }

    public final int hashCode() {
        return zza(this);
    }

    static int zza(Leaderboard leaderboard) {
        return Objects.hashCode(leaderboard.getLeaderboardId(), leaderboard.getDisplayName(), leaderboard.getIconImageUri(), Integer.valueOf(leaderboard.getScoreOrder()), leaderboard.getVariants());
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    static boolean zza(Leaderboard leaderboard, Object obj) {
        if (!(obj instanceof Leaderboard)) {
            return false;
        }
        if (leaderboard == obj) {
            return true;
        }
        Leaderboard leaderboard2 = (Leaderboard) obj;
        return Objects.equal(leaderboard2.getLeaderboardId(), leaderboard.getLeaderboardId()) && Objects.equal(leaderboard2.getDisplayName(), leaderboard.getDisplayName()) && Objects.equal(leaderboard2.getIconImageUri(), leaderboard.getIconImageUri()) && Objects.equal(Integer.valueOf(leaderboard2.getScoreOrder()), Integer.valueOf(leaderboard.getScoreOrder())) && Objects.equal(leaderboard2.getVariants(), leaderboard.getVariants());
    }

    public final String toString() {
        return zzb(this);
    }

    static String zzb(Leaderboard leaderboard) {
        return Objects.toStringHelper(leaderboard).add("LeaderboardId", leaderboard.getLeaderboardId()).add("DisplayName", leaderboard.getDisplayName()).add("IconImageUri", leaderboard.getIconImageUri()).add("IconImageUrl", leaderboard.getIconImageUrl()).add("ScoreOrder", Integer.valueOf(leaderboard.getScoreOrder())).add("Variants", leaderboard.getVariants()).toString();
    }
}
