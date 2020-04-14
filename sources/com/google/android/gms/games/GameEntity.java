package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.common.util.RetainForClient;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

@RetainForClient
@UsedByReflection("GamesClientImpl.java")
@Class(creator = "GameEntityCreator")
@Reserved({1000})
public final class GameEntity extends GamesDowngradeableSafeParcel implements Game {
    public static final Creator<GameEntity> CREATOR = new zza();
    @Field(getter = "getDescription", mo15151id = 5)
    private final String description;
    @Field(getter = "isRealTimeMultiplayerEnabled", mo15151id = 16)
    private final boolean zzaa;
    @Field(getter = "isTurnBasedMultiplayerEnabled", mo15151id = 17)
    private final boolean zzab;
    @Field(getter = "getIconImageUrl", mo15151id = 18)
    private final String zzac;
    @Field(getter = "getHiResImageUrl", mo15151id = 19)
    private final String zzad;
    @Field(getter = "getFeaturedImageUrl", mo15151id = 20)
    private final String zzae;
    @Field(getter = "isMuted", mo15151id = 21)
    private final boolean zzaf;
    @Field(getter = "isIdentitySharingConfirmed", mo15151id = 22)
    private final boolean zzag;
    @Field(getter = "areSnapshotsEnabled", mo15151id = 23)
    private final boolean zzah;
    @Field(getter = "getThemeColor", mo15151id = 24)
    private final String zzai;
    @Field(getter = "hasGamepadSupport", mo15151id = 25)
    private final boolean zzaj;
    @Field(getter = "getApplicationId", mo15151id = 1)
    private final String zzm;
    @Field(getter = "getDisplayName", mo15151id = 2)
    private final String zzn;
    @Field(getter = "getPrimaryCategory", mo15151id = 3)
    private final String zzo;
    @Field(getter = "getSecondaryCategory", mo15151id = 4)
    private final String zzp;
    @Field(getter = "getDeveloperName", mo15151id = 6)
    private final String zzq;
    @Field(getter = "getIconImageUri", mo15151id = 7)
    private final Uri zzr;
    @Field(getter = "getHiResImageUri", mo15151id = 8)
    private final Uri zzs;
    @Field(getter = "getFeaturedImageUri", mo15151id = 9)
    private final Uri zzt;
    @Field(getter = "isPlayEnabledGame", mo15151id = 10)
    private final boolean zzu;
    @Field(getter = "isInstanceInstalled", mo15151id = 11)
    private final boolean zzv;
    @Field(getter = "getInstancePackageName", mo15151id = 12)
    private final String zzw;
    @Field(getter = "getGameplayAclStatus", mo15151id = 13)
    private final int zzx;
    @Field(getter = "getAchievementTotalCount", mo15151id = 14)
    private final int zzy;
    @Field(getter = "getLeaderboardCount", mo15151id = 15)
    private final int zzz;

    static final class zza extends zzh {
        zza() {
        }

        public final GameEntity zzb(Parcel parcel) {
            Uri uri;
            Uri uri2;
            Uri uri3;
            if (GameEntity.zzb(GameEntity.getUnparcelClientVersion()) || GameEntity.canUnparcelSafely(GameEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            if (readString7 == null) {
                uri = null;
            } else {
                uri = Uri.parse(readString7);
            }
            String readString8 = parcel.readString();
            if (readString8 == null) {
                uri2 = null;
            } else {
                uri2 = Uri.parse(readString8);
            }
            String readString9 = parcel.readString();
            if (readString9 == null) {
                uri3 = null;
            } else {
                uri3 = Uri.parse(readString9);
            }
            GameEntity gameEntity = new GameEntity(readString, readString2, readString3, readString4, readString5, readString6, uri, uri2, uri3, parcel.readInt() > 0, parcel.readInt() > 0, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), false, false, null, null, null, false, false, false, null, false);
            return gameEntity;
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }
    }

    public GameEntity(Game game) {
        this.zzm = game.getApplicationId();
        this.zzo = game.getPrimaryCategory();
        this.zzp = game.getSecondaryCategory();
        this.description = game.getDescription();
        this.zzq = game.getDeveloperName();
        this.zzn = game.getDisplayName();
        this.zzr = game.getIconImageUri();
        this.zzac = game.getIconImageUrl();
        this.zzs = game.getHiResImageUri();
        this.zzad = game.getHiResImageUrl();
        this.zzt = game.getFeaturedImageUri();
        this.zzae = game.getFeaturedImageUrl();
        this.zzu = game.zzb();
        this.zzv = game.zzd();
        this.zzw = game.zze();
        this.zzx = 1;
        this.zzy = game.getAchievementTotalCount();
        this.zzz = game.getLeaderboardCount();
        this.zzaa = game.isRealTimeMultiplayerEnabled();
        this.zzab = game.isTurnBasedMultiplayerEnabled();
        this.zzaf = game.isMuted();
        this.zzag = game.zzc();
        this.zzah = game.areSnapshotsEnabled();
        this.zzai = game.getThemeColor();
        this.zzaj = game.hasGamepadSupport();
    }

    public final Game freeze() {
        return this;
    }

    public final boolean isDataValid() {
        return true;
    }

    @Constructor
    GameEntity(@Param(mo15154id = 1) String str, @Param(mo15154id = 2) String str2, @Param(mo15154id = 3) String str3, @Param(mo15154id = 4) String str4, @Param(mo15154id = 5) String str5, @Param(mo15154id = 6) String str6, @Param(mo15154id = 7) Uri uri, @Param(mo15154id = 8) Uri uri2, @Param(mo15154id = 9) Uri uri3, @Param(mo15154id = 10) boolean z, @Param(mo15154id = 11) boolean z2, @Param(mo15154id = 12) String str7, @Param(mo15154id = 13) int i, @Param(mo15154id = 14) int i2, @Param(mo15154id = 15) int i3, @Param(mo15154id = 16) boolean z3, @Param(mo15154id = 17) boolean z4, @Param(mo15154id = 18) String str8, @Param(mo15154id = 19) String str9, @Param(mo15154id = 20) String str10, @Param(mo15154id = 21) boolean z5, @Param(mo15154id = 22) boolean z6, @Param(mo15154id = 23) boolean z7, @Param(mo15154id = 24) String str11, @Param(mo15154id = 25) boolean z8) {
        this.zzm = str;
        this.zzn = str2;
        this.zzo = str3;
        this.zzp = str4;
        this.description = str5;
        this.zzq = str6;
        this.zzr = uri;
        this.zzac = str8;
        this.zzs = uri2;
        this.zzad = str9;
        this.zzt = uri3;
        this.zzae = str10;
        this.zzu = z;
        this.zzv = z2;
        this.zzw = str7;
        this.zzx = i;
        this.zzy = i2;
        this.zzz = i3;
        this.zzaa = z3;
        this.zzab = z4;
        this.zzaf = z5;
        this.zzag = z6;
        this.zzah = z7;
        this.zzai = str11;
        this.zzaj = z8;
    }

    public final String getApplicationId() {
        return this.zzm;
    }

    public final String getDisplayName() {
        return this.zzn;
    }

    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzn, charArrayBuffer);
    }

    public final String getPrimaryCategory() {
        return this.zzo;
    }

    public final String getSecondaryCategory() {
        return this.zzp;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.description, charArrayBuffer);
    }

    public final String getDeveloperName() {
        return this.zzq;
    }

    public final void getDeveloperName(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzq, charArrayBuffer);
    }

    public final Uri getIconImageUri() {
        return this.zzr;
    }

    public final String getIconImageUrl() {
        return this.zzac;
    }

    public final Uri getHiResImageUri() {
        return this.zzs;
    }

    public final String getHiResImageUrl() {
        return this.zzad;
    }

    public final Uri getFeaturedImageUri() {
        return this.zzt;
    }

    public final String getFeaturedImageUrl() {
        return this.zzae;
    }

    public final boolean isMuted() {
        return this.zzaf;
    }

    public final boolean zzc() {
        return this.zzag;
    }

    public final boolean zzb() {
        return this.zzu;
    }

    public final boolean zzd() {
        return this.zzv;
    }

    public final String zze() {
        return this.zzw;
    }

    public final int getAchievementTotalCount() {
        return this.zzy;
    }

    public final int getLeaderboardCount() {
        return this.zzz;
    }

    public final boolean isRealTimeMultiplayerEnabled() {
        return this.zzaa;
    }

    public final boolean isTurnBasedMultiplayerEnabled() {
        return this.zzab;
    }

    public final boolean areSnapshotsEnabled() {
        return this.zzah;
    }

    public final String getThemeColor() {
        return this.zzai;
    }

    public final boolean hasGamepadSupport() {
        return this.zzaj;
    }

    public final int hashCode() {
        return zza((Game) this);
    }

    static int zza(Game game) {
        return Objects.hashCode(game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), Boolean.valueOf(game.zzb()), Boolean.valueOf(game.zzd()), game.zze(), Integer.valueOf(game.getAchievementTotalCount()), Integer.valueOf(game.getLeaderboardCount()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isMuted()), Boolean.valueOf(game.zzc()), Boolean.valueOf(game.areSnapshotsEnabled()), game.getThemeColor(), Boolean.valueOf(game.hasGamepadSupport()));
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    static boolean zza(Game game, Object obj) {
        if (!(obj instanceof Game)) {
            return false;
        }
        if (game == obj) {
            return true;
        }
        Game game2 = (Game) obj;
        return Objects.equal(game2.getApplicationId(), game.getApplicationId()) && Objects.equal(game2.getDisplayName(), game.getDisplayName()) && Objects.equal(game2.getPrimaryCategory(), game.getPrimaryCategory()) && Objects.equal(game2.getSecondaryCategory(), game.getSecondaryCategory()) && Objects.equal(game2.getDescription(), game.getDescription()) && Objects.equal(game2.getDeveloperName(), game.getDeveloperName()) && Objects.equal(game2.getIconImageUri(), game.getIconImageUri()) && Objects.equal(game2.getHiResImageUri(), game.getHiResImageUri()) && Objects.equal(game2.getFeaturedImageUri(), game.getFeaturedImageUri()) && Objects.equal(Boolean.valueOf(game2.zzb()), Boolean.valueOf(game.zzb())) && Objects.equal(Boolean.valueOf(game2.zzd()), Boolean.valueOf(game.zzd())) && Objects.equal(game2.zze(), game.zze()) && Objects.equal(Integer.valueOf(game2.getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) && Objects.equal(Integer.valueOf(game2.getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount())) && Objects.equal(Boolean.valueOf(game2.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled())) && Objects.equal(Boolean.valueOf(game2.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled())) && Objects.equal(Boolean.valueOf(game2.isMuted()), Boolean.valueOf(game.isMuted())) && Objects.equal(Boolean.valueOf(game2.zzc()), Boolean.valueOf(game.zzc())) && Objects.equal(Boolean.valueOf(game2.areSnapshotsEnabled()), Boolean.valueOf(game.areSnapshotsEnabled())) && Objects.equal(game2.getThemeColor(), game.getThemeColor()) && Objects.equal(Boolean.valueOf(game2.hasGamepadSupport()), Boolean.valueOf(game.hasGamepadSupport()));
    }

    public final String toString() {
        return zzb(this);
    }

    static String zzb(Game game) {
        return Objects.toStringHelper(game).add("ApplicationId", game.getApplicationId()).add("DisplayName", game.getDisplayName()).add("PrimaryCategory", game.getPrimaryCategory()).add("SecondaryCategory", game.getSecondaryCategory()).add("Description", game.getDescription()).add("DeveloperName", game.getDeveloperName()).add("IconImageUri", game.getIconImageUri()).add("IconImageUrl", game.getIconImageUrl()).add("HiResImageUri", game.getHiResImageUri()).add("HiResImageUrl", game.getHiResImageUrl()).add("FeaturedImageUri", game.getFeaturedImageUri()).add("FeaturedImageUrl", game.getFeaturedImageUrl()).add("PlayEnabledGame", Boolean.valueOf(game.zzb())).add("InstanceInstalled", Boolean.valueOf(game.zzd())).add("InstancePackageName", game.zze()).add("AchievementTotalCount", Integer.valueOf(game.getAchievementTotalCount())).add("LeaderboardCount", Integer.valueOf(game.getLeaderboardCount())).add("RealTimeMultiplayerEnabled", Boolean.valueOf(game.isRealTimeMultiplayerEnabled())).add("TurnBasedMultiplayerEnabled", Boolean.valueOf(game.isTurnBasedMultiplayerEnabled())).add("AreSnapshotsEnabled", Boolean.valueOf(game.areSnapshotsEnabled())).add("ThemeColor", game.getThemeColor()).add("HasGamepadSupport", Boolean.valueOf(game.hasGamepadSupport())).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (!shouldDowngrade()) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 1, getApplicationId(), false);
            SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
            SafeParcelWriter.writeString(parcel, 3, getPrimaryCategory(), false);
            SafeParcelWriter.writeString(parcel, 4, getSecondaryCategory(), false);
            SafeParcelWriter.writeString(parcel, 5, getDescription(), false);
            SafeParcelWriter.writeString(parcel, 6, getDeveloperName(), false);
            SafeParcelWriter.writeParcelable(parcel, 7, getIconImageUri(), i, false);
            SafeParcelWriter.writeParcelable(parcel, 8, getHiResImageUri(), i, false);
            SafeParcelWriter.writeParcelable(parcel, 9, getFeaturedImageUri(), i, false);
            SafeParcelWriter.writeBoolean(parcel, 10, this.zzu);
            SafeParcelWriter.writeBoolean(parcel, 11, this.zzv);
            SafeParcelWriter.writeString(parcel, 12, this.zzw, false);
            SafeParcelWriter.writeInt(parcel, 13, this.zzx);
            SafeParcelWriter.writeInt(parcel, 14, getAchievementTotalCount());
            SafeParcelWriter.writeInt(parcel, 15, getLeaderboardCount());
            SafeParcelWriter.writeBoolean(parcel, 16, isRealTimeMultiplayerEnabled());
            SafeParcelWriter.writeBoolean(parcel, 17, isTurnBasedMultiplayerEnabled());
            SafeParcelWriter.writeString(parcel, 18, getIconImageUrl(), false);
            SafeParcelWriter.writeString(parcel, 19, getHiResImageUrl(), false);
            SafeParcelWriter.writeString(parcel, 20, getFeaturedImageUrl(), false);
            SafeParcelWriter.writeBoolean(parcel, 21, this.zzaf);
            SafeParcelWriter.writeBoolean(parcel, 22, this.zzag);
            SafeParcelWriter.writeBoolean(parcel, 23, areSnapshotsEnabled());
            SafeParcelWriter.writeString(parcel, 24, getThemeColor(), false);
            SafeParcelWriter.writeBoolean(parcel, 25, hasGamepadSupport());
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
        parcel.writeString(this.zzm);
        parcel.writeString(this.zzn);
        parcel.writeString(this.zzo);
        parcel.writeString(this.zzp);
        parcel.writeString(this.description);
        parcel.writeString(this.zzq);
        Uri uri = this.zzr;
        String str = null;
        parcel.writeString(uri == null ? null : uri.toString());
        Uri uri2 = this.zzs;
        parcel.writeString(uri2 == null ? null : uri2.toString());
        Uri uri3 = this.zzt;
        if (uri3 != null) {
            str = uri3.toString();
        }
        parcel.writeString(str);
        parcel.writeInt(this.zzu ? 1 : 0);
        parcel.writeInt(this.zzv ? 1 : 0);
        parcel.writeString(this.zzw);
        parcel.writeInt(this.zzx);
        parcel.writeInt(this.zzy);
        parcel.writeInt(this.zzz);
    }
}
