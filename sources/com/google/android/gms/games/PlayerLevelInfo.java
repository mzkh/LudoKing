package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.games.internal.zzd;

@Class(creator = "PlayerLevelInfoCreator")
@Reserved({1000})
public final class PlayerLevelInfo extends zzd {
    public static final Creator<PlayerLevelInfo> CREATOR = new zzar();
    @Field(getter = "getCurrentXpTotal", mo15151id = 1)
    private final long zzcu;
    @Field(getter = "getLastLevelUpTimestamp", mo15151id = 2)
    private final long zzcv;
    @Field(getter = "getCurrentLevel", mo15151id = 3)
    private final PlayerLevel zzcw;
    @Field(getter = "getNextLevel", mo15151id = 4)
    private final PlayerLevel zzcx;

    @Constructor
    public PlayerLevelInfo(@Param(mo15154id = 1) long j, @Param(mo15154id = 2) long j2, @Param(mo15154id = 3) PlayerLevel playerLevel, @Param(mo15154id = 4) PlayerLevel playerLevel2) {
        Preconditions.checkState(j != -1);
        Preconditions.checkNotNull(playerLevel);
        Preconditions.checkNotNull(playerLevel2);
        this.zzcu = j;
        this.zzcv = j2;
        this.zzcw = playerLevel;
        this.zzcx = playerLevel2;
    }

    public final long getCurrentXpTotal() {
        return this.zzcu;
    }

    public final long getLastLevelUpTimestamp() {
        return this.zzcv;
    }

    public final PlayerLevel getCurrentLevel() {
        return this.zzcw;
    }

    public final PlayerLevel getNextLevel() {
        return this.zzcx;
    }

    public final boolean isMaxLevel() {
        return this.zzcw.equals(this.zzcx);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevelInfo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        PlayerLevelInfo playerLevelInfo = (PlayerLevelInfo) obj;
        return Objects.equal(Long.valueOf(this.zzcu), Long.valueOf(playerLevelInfo.zzcu)) && Objects.equal(Long.valueOf(this.zzcv), Long.valueOf(playerLevelInfo.zzcv)) && Objects.equal(this.zzcw, playerLevelInfo.zzcw) && Objects.equal(this.zzcx, playerLevelInfo.zzcx);
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zzcu), Long.valueOf(this.zzcv), this.zzcw, this.zzcx);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getCurrentXpTotal());
        SafeParcelWriter.writeLong(parcel, 2, getLastLevelUpTimestamp());
        SafeParcelWriter.writeParcelable(parcel, 3, getCurrentLevel(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getNextLevel(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
