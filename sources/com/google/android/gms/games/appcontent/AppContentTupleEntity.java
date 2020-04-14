package com.google.android.gms.games.appcontent;

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
@Class(creator = "AppContentTupleEntityCreator")
@Reserved({1000})
public final class AppContentTupleEntity extends zzd implements zzk {
    public static final Creator<AppContentTupleEntity> CREATOR = new zzl();
    @Field(getter = "getName", mo15151id = 1)
    private final String name;
    @Field(getter = "getValue", mo15151id = 2)
    private final String value;

    @Constructor
    AppContentTupleEntity(@Param(mo15154id = 1) String str, @Param(mo15154id = 2) String str2) {
        this.name = str;
        this.value = str2;
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }

    public final int hashCode() {
        return Objects.hashCode(getName(), getValue());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzk) {
            if (this == obj) {
                return true;
            }
            zzk zzk = (zzk) obj;
            if (Objects.equal(zzk.getName(), getName()) && Objects.equal(zzk.getValue(), getValue())) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Name", getName()).add("Value", getValue()).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.name, false);
        SafeParcelWriter.writeString(parcel, 2, this.value, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
