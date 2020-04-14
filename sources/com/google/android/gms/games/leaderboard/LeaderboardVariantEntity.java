package com.google.android.gms.games.leaderboard;

import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.internal.games.zzeg;

@UsedByReflection("GamesClientImpl.java")
public final class LeaderboardVariantEntity implements LeaderboardVariant {
    private final int zzol;
    private final int zzom;
    private final boolean zzon;
    private final long zzoo;
    private final String zzop;
    private final long zzoq;
    private final String zzor;
    private final String zzos;
    private final long zzot;
    private final String zzou;
    private final String zzov;
    private final String zzow;

    public LeaderboardVariantEntity(LeaderboardVariant leaderboardVariant) {
        this.zzol = leaderboardVariant.getTimeSpan();
        this.zzom = leaderboardVariant.getCollection();
        this.zzon = leaderboardVariant.hasPlayerInfo();
        this.zzoo = leaderboardVariant.getRawPlayerScore();
        this.zzop = leaderboardVariant.getDisplayPlayerScore();
        this.zzoq = leaderboardVariant.getPlayerRank();
        this.zzor = leaderboardVariant.getDisplayPlayerRank();
        this.zzos = leaderboardVariant.getPlayerScoreTag();
        this.zzot = leaderboardVariant.getNumScores();
        this.zzou = leaderboardVariant.zzdk();
        this.zzov = leaderboardVariant.zzdl();
        this.zzow = leaderboardVariant.zzdm();
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final boolean isDataValid() {
        return true;
    }

    public final int getTimeSpan() {
        return this.zzol;
    }

    public final int getCollection() {
        return this.zzom;
    }

    public final boolean hasPlayerInfo() {
        return this.zzon;
    }

    public final long getRawPlayerScore() {
        return this.zzoo;
    }

    public final String getDisplayPlayerScore() {
        return this.zzop;
    }

    public final long getPlayerRank() {
        return this.zzoq;
    }

    public final String getDisplayPlayerRank() {
        return this.zzor;
    }

    public final String getPlayerScoreTag() {
        return this.zzos;
    }

    public final long getNumScores() {
        return this.zzot;
    }

    public final String zzdk() {
        return this.zzou;
    }

    public final String zzdl() {
        return this.zzov;
    }

    public final String zzdm() {
        return this.zzow;
    }

    public final int hashCode() {
        return zza(this);
    }

    static int zza(LeaderboardVariant leaderboardVariant) {
        return Objects.hashCode(Integer.valueOf(leaderboardVariant.getTimeSpan()), Integer.valueOf(leaderboardVariant.getCollection()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo()), Long.valueOf(leaderboardVariant.getRawPlayerScore()), leaderboardVariant.getDisplayPlayerScore(), Long.valueOf(leaderboardVariant.getPlayerRank()), leaderboardVariant.getDisplayPlayerRank(), Long.valueOf(leaderboardVariant.getNumScores()), leaderboardVariant.zzdk(), leaderboardVariant.zzdm(), leaderboardVariant.zzdl());
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    static boolean zza(LeaderboardVariant leaderboardVariant, Object obj) {
        if (!(obj instanceof LeaderboardVariant)) {
            return false;
        }
        if (leaderboardVariant == obj) {
            return true;
        }
        LeaderboardVariant leaderboardVariant2 = (LeaderboardVariant) obj;
        return Objects.equal(Integer.valueOf(leaderboardVariant2.getTimeSpan()), Integer.valueOf(leaderboardVariant.getTimeSpan())) && Objects.equal(Integer.valueOf(leaderboardVariant2.getCollection()), Integer.valueOf(leaderboardVariant.getCollection())) && Objects.equal(Boolean.valueOf(leaderboardVariant2.hasPlayerInfo()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo())) && Objects.equal(Long.valueOf(leaderboardVariant2.getRawPlayerScore()), Long.valueOf(leaderboardVariant.getRawPlayerScore())) && Objects.equal(leaderboardVariant2.getDisplayPlayerScore(), leaderboardVariant.getDisplayPlayerScore()) && Objects.equal(Long.valueOf(leaderboardVariant2.getPlayerRank()), Long.valueOf(leaderboardVariant.getPlayerRank())) && Objects.equal(leaderboardVariant2.getDisplayPlayerRank(), leaderboardVariant.getDisplayPlayerRank()) && Objects.equal(Long.valueOf(leaderboardVariant2.getNumScores()), Long.valueOf(leaderboardVariant.getNumScores())) && Objects.equal(leaderboardVariant2.zzdk(), leaderboardVariant.zzdk()) && Objects.equal(leaderboardVariant2.zzdm(), leaderboardVariant.zzdm()) && Objects.equal(leaderboardVariant2.zzdl(), leaderboardVariant.zzdl());
    }

    public final String toString() {
        return zzb(this);
    }

    static String zzb(LeaderboardVariant leaderboardVariant) {
        String str;
        ToStringHelper add = Objects.toStringHelper(leaderboardVariant).add("TimeSpan", zzeg.zzn(leaderboardVariant.getTimeSpan()));
        int collection = leaderboardVariant.getCollection();
        if (collection == -1) {
            str = "UNKNOWN";
        } else if (collection == 0) {
            str = "PUBLIC";
        } else if (collection == 1) {
            str = "SOCIAL";
        } else if (collection == 2) {
            str = "SOCIAL_1P";
        } else {
            StringBuilder sb = new StringBuilder(43);
            sb.append("Unknown leaderboard collection: ");
            sb.append(collection);
            throw new IllegalArgumentException(sb.toString());
        }
        Object obj = "none";
        ToStringHelper add2 = add.add("Collection", str).add("RawPlayerScore", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getRawPlayerScore()) : obj).add("DisplayPlayerScore", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerScore() : obj).add("PlayerRank", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getPlayerRank()) : obj);
        if (leaderboardVariant.hasPlayerInfo()) {
            obj = leaderboardVariant.getDisplayPlayerRank();
        }
        return add2.add("DisplayPlayerRank", obj).add("NumScores", Long.valueOf(leaderboardVariant.getNumScores())).add("TopPageNextToken", leaderboardVariant.zzdk()).add("WindowPageNextToken", leaderboardVariant.zzdm()).add("WindowPagePrevToken", leaderboardVariant.zzdl()).toString();
    }
}
