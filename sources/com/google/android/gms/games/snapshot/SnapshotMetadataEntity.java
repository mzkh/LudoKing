package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzd;

@UsedByReflection("GamesClientImpl.java")
@Class(creator = "SnapshotMetadataEntityCreator")
@Reserved({1000})
public final class SnapshotMetadataEntity extends zzd implements SnapshotMetadata {
    public static final Creator<SnapshotMetadataEntity> CREATOR = new zzd();
    @Field(getter = "getDescription", mo15151id = 8)
    private final String description;
    @Field(getter = "getDeviceName", mo15151id = 15)
    @Nullable
    private final String deviceName;
    @Field(getter = "getTitle", mo15151id = 7)
    private final String zzcd;
    @Field(getter = "getSnapshotId", mo15151id = 3)
    private final String zzhs;
    @Field(getter = "getGame", mo15151id = 1)
    private final GameEntity zzlp;
    @Field(getter = "getCoverImageUri", mo15151id = 5)
    @Nullable
    private final Uri zzrw;
    @Field(getter = "getOwner", mo15151id = 2)
    private final PlayerEntity zzrz;
    @Field(getter = "getCoverImageUrl", mo15151id = 6)
    @Nullable
    private final String zzsa;
    @Field(getter = "getLastModifiedTimestamp", mo15151id = 9)
    private final long zzsb;
    @Field(getter = "getPlayedTime", mo15151id = 10)
    private final long zzsc;
    @Field(getter = "getCoverImageAspectRatio", mo15151id = 11)
    private final float zzsd;
    @Field(getter = "getUniqueName", mo15151id = 12)
    private final String zzse;
    @Field(getter = "hasChangePending", mo15151id = 13)
    private final boolean zzsf;
    @Field(getter = "getProgressValue", mo15151id = 14)
    private final long zzsg;

    public SnapshotMetadataEntity(SnapshotMetadata snapshotMetadata) {
        this(snapshotMetadata, new PlayerEntity(snapshotMetadata.getOwner()));
    }

    public final SnapshotMetadata freeze() {
        return this;
    }

    public final boolean isDataValid() {
        return true;
    }

    private SnapshotMetadataEntity(SnapshotMetadata snapshotMetadata, PlayerEntity playerEntity) {
        this.zzlp = new GameEntity(snapshotMetadata.getGame());
        this.zzrz = playerEntity;
        this.zzhs = snapshotMetadata.getSnapshotId();
        this.zzrw = snapshotMetadata.getCoverImageUri();
        this.zzsa = snapshotMetadata.getCoverImageUrl();
        this.zzsd = snapshotMetadata.getCoverImageAspectRatio();
        this.zzcd = snapshotMetadata.getTitle();
        this.description = snapshotMetadata.getDescription();
        this.zzsb = snapshotMetadata.getLastModifiedTimestamp();
        this.zzsc = snapshotMetadata.getPlayedTime();
        this.zzse = snapshotMetadata.getUniqueName();
        this.zzsf = snapshotMetadata.hasChangePending();
        this.zzsg = snapshotMetadata.getProgressValue();
        this.deviceName = snapshotMetadata.getDeviceName();
    }

    @Constructor
    SnapshotMetadataEntity(@Param(mo15154id = 1) GameEntity gameEntity, @Param(mo15154id = 2) PlayerEntity playerEntity, @Param(mo15154id = 3) String str, @Param(mo15154id = 5) @Nullable Uri uri, @Param(mo15154id = 6) @Nullable String str2, @Param(mo15154id = 7) String str3, @Param(mo15154id = 8) String str4, @Param(mo15154id = 9) long j, @Param(mo15154id = 10) long j2, @Param(mo15154id = 11) float f, @Param(mo15154id = 12) String str5, @Param(mo15154id = 13) boolean z, @Param(mo15154id = 14) long j3, @Param(mo15154id = 15) @Nullable String str6) {
        this.zzlp = gameEntity;
        this.zzrz = playerEntity;
        this.zzhs = str;
        this.zzrw = uri;
        this.zzsa = str2;
        this.zzsd = f;
        this.zzcd = str3;
        this.description = str4;
        this.zzsb = j;
        this.zzsc = j2;
        this.zzse = str5;
        this.zzsf = z;
        this.zzsg = j3;
        this.deviceName = str6;
    }

    public final Game getGame() {
        return this.zzlp;
    }

    public final Player getOwner() {
        return this.zzrz;
    }

    public final String getSnapshotId() {
        return this.zzhs;
    }

    @Nullable
    public final Uri getCoverImageUri() {
        return this.zzrw;
    }

    @Nullable
    public final String getCoverImageUrl() {
        return this.zzsa;
    }

    public final float getCoverImageAspectRatio() {
        return this.zzsd;
    }

    public final String getUniqueName() {
        return this.zzse;
    }

    public final String getTitle() {
        return this.zzcd;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.description, charArrayBuffer);
    }

    public final long getLastModifiedTimestamp() {
        return this.zzsb;
    }

    public final long getPlayedTime() {
        return this.zzsc;
    }

    public final boolean hasChangePending() {
        return this.zzsf;
    }

    public final long getProgressValue() {
        return this.zzsg;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final int hashCode() {
        return zza(this);
    }

    static int zza(SnapshotMetadata snapshotMetadata) {
        return Objects.hashCode(snapshotMetadata.getGame(), snapshotMetadata.getOwner(), snapshotMetadata.getSnapshotId(), snapshotMetadata.getCoverImageUri(), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio()), snapshotMetadata.getTitle(), snapshotMetadata.getDescription(), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getPlayedTime()), snapshotMetadata.getUniqueName(), Boolean.valueOf(snapshotMetadata.hasChangePending()), Long.valueOf(snapshotMetadata.getProgressValue()), snapshotMetadata.getDeviceName());
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    static boolean zza(SnapshotMetadata snapshotMetadata, Object obj) {
        if (!(obj instanceof SnapshotMetadata)) {
            return false;
        }
        if (snapshotMetadata == obj) {
            return true;
        }
        SnapshotMetadata snapshotMetadata2 = (SnapshotMetadata) obj;
        return Objects.equal(snapshotMetadata2.getGame(), snapshotMetadata.getGame()) && Objects.equal(snapshotMetadata2.getOwner(), snapshotMetadata.getOwner()) && Objects.equal(snapshotMetadata2.getSnapshotId(), snapshotMetadata.getSnapshotId()) && Objects.equal(snapshotMetadata2.getCoverImageUri(), snapshotMetadata.getCoverImageUri()) && Objects.equal(Float.valueOf(snapshotMetadata2.getCoverImageAspectRatio()), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())) && Objects.equal(snapshotMetadata2.getTitle(), snapshotMetadata.getTitle()) && Objects.equal(snapshotMetadata2.getDescription(), snapshotMetadata.getDescription()) && Objects.equal(Long.valueOf(snapshotMetadata2.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())) && Objects.equal(Long.valueOf(snapshotMetadata2.getPlayedTime()), Long.valueOf(snapshotMetadata.getPlayedTime())) && Objects.equal(snapshotMetadata2.getUniqueName(), snapshotMetadata.getUniqueName()) && Objects.equal(Boolean.valueOf(snapshotMetadata2.hasChangePending()), Boolean.valueOf(snapshotMetadata.hasChangePending())) && Objects.equal(Long.valueOf(snapshotMetadata2.getProgressValue()), Long.valueOf(snapshotMetadata.getProgressValue())) && Objects.equal(snapshotMetadata2.getDeviceName(), snapshotMetadata.getDeviceName());
    }

    public final String toString() {
        return zzb(this);
    }

    static String zzb(SnapshotMetadata snapshotMetadata) {
        return Objects.toStringHelper(snapshotMetadata).add("Game", snapshotMetadata.getGame()).add("Owner", snapshotMetadata.getOwner()).add("SnapshotId", snapshotMetadata.getSnapshotId()).add("CoverImageUri", snapshotMetadata.getCoverImageUri()).add("CoverImageUrl", snapshotMetadata.getCoverImageUrl()).add("CoverImageAspectRatio", Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())).add("Description", snapshotMetadata.getDescription()).add("LastModifiedTimestamp", Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())).add("PlayedTime", Long.valueOf(snapshotMetadata.getPlayedTime())).add("UniqueName", snapshotMetadata.getUniqueName()).add("ChangePending", Boolean.valueOf(snapshotMetadata.hasChangePending())).add("ProgressValue", Long.valueOf(snapshotMetadata.getProgressValue())).add("DeviceName", snapshotMetadata.getDeviceName()).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getGame(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getOwner(), i, false);
        SafeParcelWriter.writeString(parcel, 3, getSnapshotId(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, getCoverImageUri(), i, false);
        SafeParcelWriter.writeString(parcel, 6, getCoverImageUrl(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzcd, false);
        SafeParcelWriter.writeString(parcel, 8, getDescription(), false);
        SafeParcelWriter.writeLong(parcel, 9, getLastModifiedTimestamp());
        SafeParcelWriter.writeLong(parcel, 10, getPlayedTime());
        SafeParcelWriter.writeFloat(parcel, 11, getCoverImageAspectRatio());
        SafeParcelWriter.writeString(parcel, 12, getUniqueName(), false);
        SafeParcelWriter.writeBoolean(parcel, 13, hasChangePending());
        SafeParcelWriter.writeLong(parcel, 14, getProgressValue());
        SafeParcelWriter.writeString(parcel, 15, getDeviceName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
