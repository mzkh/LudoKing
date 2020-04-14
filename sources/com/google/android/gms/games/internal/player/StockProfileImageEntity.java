package com.google.android.gms.games.internal.player;

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
import com.google.android.gms.games.internal.zzd;

@UsedByReflection("GamesClientImpl.java")
@Class(creator = "StockProfileImageEntityCreator")
@Reserved({1000})
public final class StockProfileImageEntity extends zzd implements StockProfileImage {
    public static final Creator<StockProfileImageEntity> CREATOR = new zzf();
    @Field(getter = "getImageUri", mo15151id = 2)
    private final Uri zzfu;
    @Field(getter = "getImageUrl", mo15151id = 1)
    private final String zznq;

    @Constructor
    public StockProfileImageEntity(@Param(mo15154id = 1) String str, @Param(mo15154id = 2) Uri uri) {
        this.zznq = str;
        this.zzfu = uri;
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String getImageUrl() {
        return this.zznq;
    }

    public final Uri zzae() {
        return this.zzfu;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zznq, this.zzfu);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof StockProfileImage)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        StockProfileImage stockProfileImage = (StockProfileImage) obj;
        return Objects.equal(this.zznq, stockProfileImage.getImageUrl()) && Objects.equal(this.zzfu, stockProfileImage.zzae());
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("ImageId", this.zznq).add("ImageUri", this.zzfu).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzfu, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
