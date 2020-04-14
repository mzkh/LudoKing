package com.google.android.gms.games.internal.experience;

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
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.zzd;

@UsedByReflection("GamesClientImpl.java")
@Class(creator = "ExperienceEventEntityCreator")
@Reserved({1000})
public final class ExperienceEventEntity extends zzd implements ExperienceEvent {
    public static final Creator<ExperienceEventEntity> CREATOR = new zza();
    @Field(getter = "getType", mo15151id = 10)
    private final int type;
    @Field(getter = "getIconImageUrl", mo15151id = 5)
    private final String zzac;
    @Field(getter = "getExperienceId", mo15151id = 1)
    private final String zzlo;
    @Field(getter = "getGame", mo15151id = 2)
    private final GameEntity zzlp;
    @Field(getter = "getDisplayTitle", mo15151id = 3)
    private final String zzlq;
    @Field(getter = "getDisplayDescription", mo15151id = 4)
    private final String zzlr;
    @Field(getter = "getCreatedTimestamp", mo15151id = 7)
    private final long zzls;
    @Field(getter = "getXpEarned", mo15151id = 8)
    private final long zzlt;
    @Field(getter = "getCurrentXp", mo15151id = 9)
    private final long zzlu;
    @Field(getter = "getNewLevel", mo15151id = 11)
    private final int zzlv;
    @Field(getter = "getIconImageUri", mo15151id = 6)
    private final Uri zzr;

    @Constructor
    ExperienceEventEntity(@Param(mo15154id = 1) String str, @Param(mo15154id = 2) GameEntity gameEntity, @Param(mo15154id = 3) String str2, @Param(mo15154id = 4) String str3, @Param(mo15154id = 5) String str4, @Param(mo15154id = 6) Uri uri, @Param(mo15154id = 7) long j, @Param(mo15154id = 8) long j2, @Param(mo15154id = 9) long j3, @Param(mo15154id = 10) int i, @Param(mo15154id = 11) int i2) {
        this.zzlo = str;
        this.zzlp = gameEntity;
        this.zzlq = str2;
        this.zzlr = str3;
        this.zzac = str4;
        this.zzr = uri;
        this.zzls = j;
        this.zzlt = j2;
        this.zzlu = j3;
        this.type = i;
        this.zzlv = i2;
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String zzcu() {
        return this.zzlo;
    }

    public final Game getGame() {
        return this.zzlp;
    }

    public final String zzcv() {
        return this.zzlq;
    }

    public final String zzcw() {
        return this.zzlr;
    }

    public final String getIconImageUrl() {
        return this.zzac;
    }

    public final Uri getIconImageUri() {
        return this.zzr;
    }

    public final long zzcx() {
        return this.zzls;
    }

    public final long zzcy() {
        return this.zzlt;
    }

    public final long zzcz() {
        return this.zzlu;
    }

    public final int getType() {
        return this.type;
    }

    public final int zzda() {
        return this.zzlv;
    }

    public final int hashCode() {
        return Objects.hashCode(zzcu(), getGame(), zzcv(), zzcw(), getIconImageUrl(), getIconImageUri(), Long.valueOf(zzcx()), Long.valueOf(zzcy()), Long.valueOf(zzcz()), Integer.valueOf(getType()), Integer.valueOf(zzda()));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ExperienceEvent) {
            if (this == obj) {
                return true;
            }
            ExperienceEvent experienceEvent = (ExperienceEvent) obj;
            if (Objects.equal(experienceEvent.zzcu(), zzcu()) && Objects.equal(experienceEvent.getGame(), getGame()) && Objects.equal(experienceEvent.zzcv(), zzcv()) && Objects.equal(experienceEvent.zzcw(), zzcw()) && Objects.equal(experienceEvent.getIconImageUrl(), getIconImageUrl()) && Objects.equal(experienceEvent.getIconImageUri(), getIconImageUri()) && Objects.equal(Long.valueOf(experienceEvent.zzcx()), Long.valueOf(zzcx())) && Objects.equal(Long.valueOf(experienceEvent.zzcy()), Long.valueOf(zzcy())) && Objects.equal(Long.valueOf(experienceEvent.zzcz()), Long.valueOf(zzcz())) && Objects.equal(Integer.valueOf(experienceEvent.getType()), Integer.valueOf(getType())) && Objects.equal(Integer.valueOf(experienceEvent.zzda()), Integer.valueOf(zzda()))) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("ExperienceId", zzcu()).add("Game", getGame()).add("DisplayTitle", zzcv()).add("DisplayDescription", zzcw()).add("IconImageUrl", getIconImageUrl()).add("IconImageUri", getIconImageUri()).add("CreatedTimestamp", Long.valueOf(zzcx())).add("XpEarned", Long.valueOf(zzcy())).add("CurrentXp", Long.valueOf(zzcz())).add("Type", Integer.valueOf(getType())).add("NewLevel", Integer.valueOf(zzda())).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzlo, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzlp, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzlq, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzlr, false);
        SafeParcelWriter.writeString(parcel, 5, getIconImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzr, i, false);
        SafeParcelWriter.writeLong(parcel, 7, this.zzls);
        SafeParcelWriter.writeLong(parcel, 8, this.zzlt);
        SafeParcelWriter.writeLong(parcel, 9, this.zzlu);
        SafeParcelWriter.writeInt(parcel, 10, this.type);
        SafeParcelWriter.writeInt(parcel, 11, this.zzlv);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
