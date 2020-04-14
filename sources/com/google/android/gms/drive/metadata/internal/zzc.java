package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

@Class(creator = "CustomPropertyCreator")
@Reserved({1})
public final class zzc extends AbstractSafeParcelable {
    public static final Creator<zzc> CREATOR = new zzd();
    @Field(mo15151id = 3)
    @Nullable
    final String value;
    @Field(mo15151id = 2)
    final CustomPropertyKey zzio;

    @Constructor
    public zzc(@Param(mo15154id = 2) CustomPropertyKey customPropertyKey, @Param(mo15154id = 3) @Nullable String str) {
        Preconditions.checkNotNull(customPropertyKey, "key");
        this.zzio = customPropertyKey;
        this.value = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            zzc zzc = (zzc) obj;
            return Objects.equal(this.zzio, zzc.zzio) && Objects.equal(this.value, zzc.value);
        }
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzio, this.value);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzio, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.value, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
