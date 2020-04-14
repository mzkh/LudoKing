package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.games.internal.zzc;
import com.google.android.gms.games.internal.zzd;

@UsedByReflection("GamesClientImpl.java")
@Class(creator = "AppContentAnnotationEntityCreator")
@Reserved({1000})
public final class AppContentAnnotationEntity extends zzd implements zzc {
    public static final Creator<AppContentAnnotationEntity> CREATOR = new zzd();
    @Field(getter = "getDescription", mo15151id = 1)
    private final String description;
    @Field(getter = "getTitle", mo15151id = 3)
    private final String zzcd;
    @Field(getter = "getId", mo15151id = 5)
    private final String zzfr;
    @Field(getter = "getImageUri", mo15151id = 2)
    private final Uri zzfu;
    @Field(getter = "getLayoutSlot", mo15151id = 6)
    private final String zzfv;
    @Field(getter = "getImageDefaultId", mo15151id = 7)
    private final String zzfw;
    @Field(getter = "getImageHeight", mo15151id = 8)
    private final int zzfx;
    @Field(getter = "getImageWidth", mo15151id = 9)
    private final int zzfy;
    @Field(getter = "getModifiers", mo15151id = 10)
    private final Bundle zzfz;

    @Constructor
    AppContentAnnotationEntity(@Param(mo15154id = 1) String str, @Param(mo15154id = 2) Uri uri, @Param(mo15154id = 3) String str2, @Param(mo15154id = 5) String str3, @Param(mo15154id = 6) String str4, @Param(mo15154id = 7) String str5, @Param(mo15154id = 8) int i, @Param(mo15154id = 9) int i2, @Param(mo15154id = 10) Bundle bundle) {
        this.description = str;
        this.zzfr = str3;
        this.zzfw = str5;
        this.zzfx = i;
        this.zzfu = uri;
        this.zzfy = i2;
        this.zzfv = str4;
        this.zzfz = bundle;
        this.zzcd = str2;
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getId() {
        return this.zzfr;
    }

    public final String zzac() {
        return this.zzfw;
    }

    public final int zzad() {
        return this.zzfx;
    }

    public final Uri zzae() {
        return this.zzfu;
    }

    public final int zzag() {
        return this.zzfy;
    }

    public final String zzah() {
        return this.zzfv;
    }

    public final Bundle zzaf() {
        return this.zzfz;
    }

    public final String getTitle() {
        return this.zzcd;
    }

    public final int hashCode() {
        return Objects.hashCode(getDescription(), getId(), zzac(), Integer.valueOf(zzad()), zzae(), Integer.valueOf(zzag()), zzah(), Integer.valueOf(zzc.zza(zzaf())), getTitle());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzc) {
            if (this == obj) {
                return true;
            }
            zzc zzc = (zzc) obj;
            if (Objects.equal(zzc.getDescription(), getDescription()) && Objects.equal(zzc.getId(), getId()) && Objects.equal(zzc.zzac(), zzac()) && Objects.equal(Integer.valueOf(zzc.zzad()), Integer.valueOf(zzad())) && Objects.equal(zzc.zzae(), zzae()) && Objects.equal(Integer.valueOf(zzc.zzag()), Integer.valueOf(zzag())) && Objects.equal(zzc.zzah(), zzah()) && zzc.zza(zzc.zzaf(), zzaf()) && Objects.equal(zzc.getTitle(), getTitle())) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        String str = "Id";
        String str2 = "ImageDefaultId";
        String str3 = "ImageHeight";
        String str4 = "ImageUri";
        ToStringHelper add = Objects.toStringHelper(this).add("Description", getDescription()).add(str, getId()).add(str2, zzac()).add(str3, Integer.valueOf(zzad())).add(str4, zzae());
        return add.add(ExifInterface.TAG_IMAGE_WIDTH, Integer.valueOf(zzag())).add("LayoutSlot", zzah()).add("Modifiers", zzaf()).add("Title", getTitle()).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.description, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzfu, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzcd, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzfr, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzfv, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzfw, false);
        SafeParcelWriter.writeInt(parcel, 8, this.zzfx);
        SafeParcelWriter.writeInt(parcel, 9, this.zzfy);
        SafeParcelWriter.writeBundle(parcel, 10, this.zzfz, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
