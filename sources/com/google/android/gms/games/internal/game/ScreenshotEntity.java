package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.games.internal.zzd;

@UsedByReflection("GamesClientImpl.java")
@Class(creator = "ScreenshotEntityCreator")
@Reserved({1000})
public final class ScreenshotEntity extends zzd implements Parcelable, Freezable {
    public static final Creator<ScreenshotEntity> CREATOR = new zzc();
    @Field(getter = "getHeight", mo15151id = 3)
    private final int height;
    @Field(getter = "getUri", mo15151id = 1)
    private final Uri uri;
    @Field(getter = "getWidth", mo15151id = 2)
    private final int width;

    @Constructor
    public ScreenshotEntity(@Param(mo15154id = 1) Uri uri2, @Param(mo15154id = 2) int i, @Param(mo15154id = 3) int i2) {
        this.uri = uri2;
        this.width = i;
        this.height = i2;
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final boolean isDataValid() {
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.uri, Integer.valueOf(this.width), Integer.valueOf(this.height));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ScreenshotEntity) {
            if (this == obj) {
                return true;
            }
            ScreenshotEntity screenshotEntity = (ScreenshotEntity) obj;
            if (Objects.equal(screenshotEntity.uri, this.uri) && Objects.equal(Integer.valueOf(screenshotEntity.width), Integer.valueOf(this.width)) && Objects.equal(Integer.valueOf(screenshotEntity.height), Integer.valueOf(this.height))) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Uri", this.uri).add("Width", Integer.valueOf(this.width)).add("Height", Integer.valueOf(this.height)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.uri, i, false);
        SafeParcelWriter.writeInt(parcel, 2, this.width);
        SafeParcelWriter.writeInt(parcel, 3, this.height);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
