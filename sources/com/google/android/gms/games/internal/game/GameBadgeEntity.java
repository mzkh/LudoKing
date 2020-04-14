package com.google.android.gms.games.internal.game;

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
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

@UsedByReflection("GamesClientImpl.java")
@Class(creator = "GameBadgeEntityCreator")
@Reserved({1000})
public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements zza {
    public static final Creator<GameBadgeEntity> CREATOR = new zza();
    @Field(getter = "getDescription", mo15151id = 3)
    private String description;
    @Field(getter = "getType", mo15151id = 1)
    private int type;
    @Field(getter = "getTitle", mo15151id = 2)
    private String zzcd;
    @Field(getter = "getIconImageUri", mo15151id = 4)
    private Uri zzr;

    static final class zza extends zzb {
        zza() {
        }

        public final GameBadgeEntity zzd(Parcel parcel) {
            Uri uri;
            if (GameBadgeEntity.zzb(GameBadgeEntity.getUnparcelClientVersion()) || GameBadgeEntity.canUnparcelSafely(GameBadgeEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (readString3 == null) {
                uri = null;
            } else {
                uri = Uri.parse(readString3);
            }
            return new GameBadgeEntity(readInt, readString, readString2, uri);
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }
    }

    @Constructor
    GameBadgeEntity(@Param(mo15154id = 1) int i, @Param(mo15154id = 2) String str, @Param(mo15154id = 3) String str2, @Param(mo15154id = 4) Uri uri) {
        this.type = i;
        this.zzcd = str;
        this.description = str2;
        this.zzr = uri;
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final boolean isDataValid() {
        return true;
    }

    public final int getType() {
        return this.type;
    }

    public final String getTitle() {
        return this.zzcd;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Uri getIconImageUri() {
        return this.zzr;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(getType()), getTitle(), getDescription(), getIconImageUri());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zza) {
            if (this == obj) {
                return true;
            }
            zza zza2 = (zza) obj;
            if (Objects.equal(Integer.valueOf(zza2.getType()), getTitle()) && Objects.equal(zza2.getDescription(), getIconImageUri())) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Type", Integer.valueOf(getType())).add("Title", getTitle()).add("Description", getDescription()).add("IconImageUri", getIconImageUri()).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (!shouldDowngrade()) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.type);
            SafeParcelWriter.writeString(parcel, 2, this.zzcd, false);
            SafeParcelWriter.writeString(parcel, 3, this.description, false);
            SafeParcelWriter.writeParcelable(parcel, 4, this.zzr, i, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
        parcel.writeInt(this.type);
        parcel.writeString(this.zzcd);
        parcel.writeString(this.description);
        Uri uri = this.zzr;
        parcel.writeString(uri == null ? null : uri.toString());
    }
}
