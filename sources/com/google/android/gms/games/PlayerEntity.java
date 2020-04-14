package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Asserts;
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
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

@RetainForClient
@UsedByReflection("GamesClientImpl.java")
@Class(creator = "PlayerEntityCreator")
@Reserved({1000})
public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
    public static final Creator<PlayerEntity> CREATOR = new zza();
    @Field(getter = "getName", mo15151id = 21)
    private final String name;
    @Field(getter = "getIconImageUrl", mo15151id = 8)
    @Nullable
    private final String zzac;
    @Field(getter = "getHiResImageUrl", mo15151id = 9)
    @Nullable
    private final String zzad;
    @Field(getter = "getPlayerId", mo15151id = 1)
    private String zzbz;
    @Field(getter = "getRetrievedTimestamp", mo15151id = 5)
    private final long zzca;
    @Field(getter = "isInCircles", mo15151id = 6)
    private final int zzcb;
    @Field(getter = "getLastPlayedWithTimestamp", mo15151id = 7)
    private final long zzcc;
    @Field(getter = "getTitle", mo15151id = 14)
    @Nullable
    private final String zzcd;
    @Field(getter = "getMostRecentGameInfo", mo15151id = 15)
    @Nullable
    private final MostRecentGameInfoEntity zzce;
    @Field(getter = "getLevelInfo", mo15151id = 16)
    @Nullable
    private final PlayerLevelInfo zzcf;
    @Field(getter = "isProfileVisible", mo15151id = 18)
    private final boolean zzcg;
    @Field(getter = "hasDebugAccess", mo15151id = 19)
    private final boolean zzch;
    @Field(getter = "getGamerTag", mo15151id = 20)
    @Nullable
    private final String zzci;
    @Field(getter = "getBannerImageLandscapeUri", mo15151id = 22)
    @Nullable
    private final Uri zzcj;
    @Field(getter = "getBannerImageLandscapeUrl", mo15151id = 23)
    @Nullable
    private final String zzck;
    @Field(getter = "getBannerImagePortraitUri", mo15151id = 24)
    @Nullable
    private final Uri zzcl;
    @Field(getter = "getBannerImagePortraitUrl", mo15151id = 25)
    @Nullable
    private final String zzcm;
    @Field(getter = "getGamerFriendStatus", mo15151id = 26)
    private final int zzcn;
    @Field(getter = "getGamerFriendUpdateTimestamp", mo15151id = 27)
    private final long zzco;
    @Field(getter = "isMuted", mo15151id = 28)
    private final boolean zzcp;
    @Field(defaultValue = "-1", getter = "getTotalUnlockedAchievement", mo15151id = 29)
    private final long zzcq;
    @Field(getter = "getDisplayName", mo15151id = 2)
    private String zzn;
    @Field(getter = "getIconImageUri", mo15151id = 3)
    @Nullable
    private final Uri zzr;
    @Field(getter = "getHiResImageUri", mo15151id = 4)
    @Nullable
    private final Uri zzs;

    static final class zza extends zzap {
        zza() {
        }

        public final PlayerEntity zzc(Parcel parcel) {
            Uri uri;
            Uri uri2;
            if (PlayerEntity.zzb(PlayerEntity.getUnparcelClientVersion()) || PlayerEntity.canUnparcelSafely(PlayerEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            long readLong = parcel.readLong();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            if (readString3 == null) {
                uri = null;
            } else {
                uri = Uri.parse(readString3);
            }
            if (readString4 == null) {
                uri2 = null;
            } else {
                uri2 = Uri.parse(readString4);
            }
            PlayerEntity playerEntity = new PlayerEntity(readString, readString2, uri, uri2, readLong, -1, -1, null, null, null, null, null, true, false, readString5, readString6, null, null, null, null, -1, -1, false, -1);
            return playerEntity;
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }
    }

    public PlayerEntity(Player player) {
        this(player, true);
    }

    public final Player freeze() {
        return this;
    }

    public final boolean isDataValid() {
        return true;
    }

    private PlayerEntity(Player player, boolean z) {
        MostRecentGameInfoEntity mostRecentGameInfoEntity;
        this.zzbz = player.getPlayerId();
        this.zzn = player.getDisplayName();
        this.zzr = player.getIconImageUri();
        this.zzac = player.getIconImageUrl();
        this.zzs = player.getHiResImageUri();
        this.zzad = player.getHiResImageUrl();
        this.zzca = player.getRetrievedTimestamp();
        this.zzcb = player.zzj();
        this.zzcc = player.getLastPlayedWithTimestamp();
        this.zzcd = player.getTitle();
        this.zzcg = player.zzk();
        com.google.android.gms.games.internal.player.zza zzl = player.zzl();
        if (zzl == null) {
            mostRecentGameInfoEntity = null;
        } else {
            mostRecentGameInfoEntity = new MostRecentGameInfoEntity(zzl);
        }
        this.zzce = mostRecentGameInfoEntity;
        this.zzcf = player.getLevelInfo();
        this.zzch = player.zzi();
        this.zzci = player.zzh();
        this.name = player.getName();
        this.zzcj = player.getBannerImageLandscapeUri();
        this.zzck = player.getBannerImageLandscapeUrl();
        this.zzcl = player.getBannerImagePortraitUri();
        this.zzcm = player.getBannerImagePortraitUrl();
        this.zzcn = player.zzm();
        this.zzco = player.zzn();
        this.zzcp = player.isMuted();
        this.zzcq = player.zzo();
        Asserts.checkNotNull(this.zzbz);
        Asserts.checkNotNull(this.zzn);
        Asserts.checkState(this.zzca > 0);
    }

    @Constructor
    PlayerEntity(@Param(mo15154id = 1) String str, @Param(mo15154id = 2) String str2, @Param(mo15154id = 3) @Nullable Uri uri, @Param(mo15154id = 4) @Nullable Uri uri2, @Param(mo15154id = 5) long j, @Param(mo15154id = 6) int i, @Param(mo15154id = 7) long j2, @Param(mo15154id = 8) @Nullable String str3, @Param(mo15154id = 9) @Nullable String str4, @Param(mo15154id = 14) @Nullable String str5, @Param(mo15154id = 15) @Nullable MostRecentGameInfoEntity mostRecentGameInfoEntity, @Param(mo15154id = 16) @Nullable PlayerLevelInfo playerLevelInfo, @Param(mo15154id = 18) boolean z, @Param(mo15154id = 19) boolean z2, @Param(mo15154id = 20) @Nullable String str6, @Param(mo15154id = 21) String str7, @Param(mo15154id = 22) @Nullable Uri uri3, @Param(mo15154id = 23) @Nullable String str8, @Param(mo15154id = 24) @Nullable Uri uri4, @Param(mo15154id = 25) @Nullable String str9, @Param(mo15154id = 26) int i2, @Param(mo15154id = 27) long j3, @Param(mo15154id = 28) boolean z3, @Param(mo15154id = 29) long j4) {
        this.zzbz = str;
        this.zzn = str2;
        this.zzr = uri;
        this.zzac = str3;
        this.zzs = uri2;
        this.zzad = str4;
        this.zzca = j;
        this.zzcb = i;
        this.zzcc = j2;
        this.zzcd = str5;
        this.zzcg = z;
        this.zzce = mostRecentGameInfoEntity;
        this.zzcf = playerLevelInfo;
        this.zzch = z2;
        this.zzci = str6;
        this.name = str7;
        this.zzcj = uri3;
        this.zzck = str8;
        this.zzcl = uri4;
        this.zzcm = str9;
        this.zzcn = i2;
        this.zzco = j3;
        this.zzcp = z3;
        this.zzcq = j4;
    }

    public final String getPlayerId() {
        return this.zzbz;
    }

    public final String getDisplayName() {
        return this.zzn;
    }

    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzn, charArrayBuffer);
    }

    @Nullable
    public final String zzh() {
        return this.zzci;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean zzi() {
        return this.zzch;
    }

    public final boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    @Nullable
    public final Uri getIconImageUri() {
        return this.zzr;
    }

    @Nullable
    public final String getIconImageUrl() {
        return this.zzac;
    }

    public final boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    @Nullable
    public final Uri getHiResImageUri() {
        return this.zzs;
    }

    @Nullable
    public final String getHiResImageUrl() {
        return this.zzad;
    }

    public final long getRetrievedTimestamp() {
        return this.zzca;
    }

    public final long getLastPlayedWithTimestamp() {
        return this.zzcc;
    }

    public final int zzj() {
        return this.zzcb;
    }

    public final boolean zzk() {
        return this.zzcg;
    }

    @Nullable
    public final String getTitle() {
        return this.zzcd;
    }

    public final void getTitle(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzcd, charArrayBuffer);
    }

    @Nullable
    public final PlayerLevelInfo getLevelInfo() {
        return this.zzcf;
    }

    @Nullable
    public final com.google.android.gms.games.internal.player.zza zzl() {
        return this.zzce;
    }

    @Nullable
    public final Uri getBannerImageLandscapeUri() {
        return this.zzcj;
    }

    @Nullable
    public final String getBannerImageLandscapeUrl() {
        return this.zzck;
    }

    @Nullable
    public final Uri getBannerImagePortraitUri() {
        return this.zzcl;
    }

    @Nullable
    public final String getBannerImagePortraitUrl() {
        return this.zzcm;
    }

    public final int zzm() {
        return this.zzcn;
    }

    public final long zzn() {
        return this.zzco;
    }

    public final boolean isMuted() {
        return this.zzcp;
    }

    public final long zzo() {
        return this.zzcq;
    }

    public final int hashCode() {
        return zza((Player) this);
    }

    static int zza(Player player) {
        return Objects.hashCode(player.getPlayerId(), player.getDisplayName(), Boolean.valueOf(player.zzi()), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()), player.getTitle(), player.getLevelInfo(), player.zzh(), player.getName(), player.getBannerImageLandscapeUri(), player.getBannerImagePortraitUri(), Integer.valueOf(player.zzm()), Long.valueOf(player.zzn()), Boolean.valueOf(player.isMuted()), Long.valueOf(player.zzo()));
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    static boolean zza(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player == obj) {
            return true;
        }
        Player player2 = (Player) obj;
        return Objects.equal(player2.getPlayerId(), player.getPlayerId()) && Objects.equal(player2.getDisplayName(), player.getDisplayName()) && Objects.equal(Boolean.valueOf(player2.zzi()), Boolean.valueOf(player.zzi())) && Objects.equal(player2.getIconImageUri(), player.getIconImageUri()) && Objects.equal(player2.getHiResImageUri(), player.getHiResImageUri()) && Objects.equal(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp())) && Objects.equal(player2.getTitle(), player.getTitle()) && Objects.equal(player2.getLevelInfo(), player.getLevelInfo()) && Objects.equal(player2.zzh(), player.zzh()) && Objects.equal(player2.getName(), player.getName()) && Objects.equal(player2.getBannerImageLandscapeUri(), player.getBannerImageLandscapeUri()) && Objects.equal(player2.getBannerImagePortraitUri(), player.getBannerImagePortraitUri()) && Objects.equal(Integer.valueOf(player2.zzm()), Integer.valueOf(player.zzm())) && Objects.equal(Long.valueOf(player2.zzn()), Long.valueOf(player.zzn())) && Objects.equal(Boolean.valueOf(player2.isMuted()), Boolean.valueOf(player.isMuted())) && Objects.equal(Long.valueOf(player2.zzo()), Long.valueOf(player.zzo()));
    }

    public final String toString() {
        return zzb(this);
    }

    static String zzb(Player player) {
        String str = "DisplayName";
        String str2 = "HasDebugAccess";
        String str3 = "IconImageUri";
        String str4 = "IconImageUrl";
        String str5 = "HiResImageUri";
        String str6 = "HiResImageUrl";
        String str7 = "RetrievedTimestamp";
        String str8 = "Title";
        String str9 = "LevelInfo";
        String str10 = "GamerTag";
        String str11 = "Name";
        String str12 = "BannerImageLandscapeUri";
        String str13 = "BannerImageLandscapeUrl";
        String str14 = "BannerImagePortraitUri";
        String str15 = "BannerImagePortraitUrl";
        String str16 = "GamerFriendStatus";
        String str17 = "GamerFriendUpdateTimestamp";
        String str18 = "IsMuted";
        return Objects.toStringHelper(player).add("PlayerId", player.getPlayerId()).add(str, player.getDisplayName()).add(str2, Boolean.valueOf(player.zzi())).add(str3, player.getIconImageUri()).add(str4, player.getIconImageUrl()).add(str5, player.getHiResImageUri()).add(str6, player.getHiResImageUrl()).add(str7, Long.valueOf(player.getRetrievedTimestamp())).add(str8, player.getTitle()).add(str9, player.getLevelInfo()).add(str10, player.zzh()).add(str11, player.getName()).add(str12, player.getBannerImageLandscapeUri()).add(str13, player.getBannerImageLandscapeUrl()).add(str14, player.getBannerImagePortraitUri()).add(str15, player.getBannerImagePortraitUrl()).add(str16, Integer.valueOf(player.zzm())).add(str17, Long.valueOf(player.zzn())).add(str18, Boolean.valueOf(player.isMuted())).add("totalUnlockedAchievement", Long.valueOf(player.zzo())).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (!shouldDowngrade()) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 1, getPlayerId(), false);
            SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
            SafeParcelWriter.writeParcelable(parcel, 3, getIconImageUri(), i, false);
            SafeParcelWriter.writeParcelable(parcel, 4, getHiResImageUri(), i, false);
            SafeParcelWriter.writeLong(parcel, 5, getRetrievedTimestamp());
            SafeParcelWriter.writeInt(parcel, 6, this.zzcb);
            SafeParcelWriter.writeLong(parcel, 7, getLastPlayedWithTimestamp());
            SafeParcelWriter.writeString(parcel, 8, getIconImageUrl(), false);
            SafeParcelWriter.writeString(parcel, 9, getHiResImageUrl(), false);
            SafeParcelWriter.writeString(parcel, 14, getTitle(), false);
            SafeParcelWriter.writeParcelable(parcel, 15, this.zzce, i, false);
            SafeParcelWriter.writeParcelable(parcel, 16, getLevelInfo(), i, false);
            SafeParcelWriter.writeBoolean(parcel, 18, this.zzcg);
            SafeParcelWriter.writeBoolean(parcel, 19, this.zzch);
            SafeParcelWriter.writeString(parcel, 20, this.zzci, false);
            SafeParcelWriter.writeString(parcel, 21, this.name, false);
            SafeParcelWriter.writeParcelable(parcel, 22, getBannerImageLandscapeUri(), i, false);
            SafeParcelWriter.writeString(parcel, 23, getBannerImageLandscapeUrl(), false);
            SafeParcelWriter.writeParcelable(parcel, 24, getBannerImagePortraitUri(), i, false);
            SafeParcelWriter.writeString(parcel, 25, getBannerImagePortraitUrl(), false);
            SafeParcelWriter.writeInt(parcel, 26, this.zzcn);
            SafeParcelWriter.writeLong(parcel, 27, this.zzco);
            SafeParcelWriter.writeBoolean(parcel, 28, this.zzcp);
            SafeParcelWriter.writeLong(parcel, 29, this.zzcq);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
        parcel.writeString(this.zzbz);
        parcel.writeString(this.zzn);
        Uri uri = this.zzr;
        String str = null;
        parcel.writeString(uri == null ? null : uri.toString());
        Uri uri2 = this.zzs;
        if (uri2 != null) {
            str = uri2.toString();
        }
        parcel.writeString(str);
        parcel.writeLong(this.zzca);
    }
}
