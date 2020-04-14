package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.nearby.messages.Distance;
import java.util.Locale;

@Class(creator = "DistanceImplCreator")
public final class zze extends AbstractSafeParcelable implements Distance {
    public static final Creator<zze> CREATOR = new zzf();
    @Field(mo15151id = 2)
    private final int accuracy;
    @VersionField(mo15157id = 1)
    private final int versionCode;
    @Field(mo15151id = 3)
    private final double zzhg;

    public zze(int i, double d) {
        this(1, 1, Double.NaN);
    }

    @Constructor
    zze(@Param(mo15154id = 1) int i, @Param(mo15154id = 2) int i2, @Param(mo15154id = 3) double d) {
        this.versionCode = i;
        this.accuracy = i2;
        this.zzhg = d;
    }

    public final int compareTo(@NonNull Distance distance) {
        if (!Double.isNaN(getMeters()) || !Double.isNaN(distance.getMeters())) {
            return Double.compare(getMeters(), distance.getMeters());
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zze)) {
            return false;
        }
        zze zze = (zze) obj;
        return getAccuracy() == zze.getAccuracy() && compareTo((Distance) zze) == 0;
    }

    public final int getAccuracy() {
        return this.accuracy;
    }

    public final double getMeters() {
        return this.zzhg;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(getAccuracy()), Double.valueOf(getMeters()));
    }

    public final String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[2];
        objArr[0] = Double.valueOf(this.zzhg);
        objArr[1] = this.accuracy != 1 ? "UNKNOWN" : "LOW";
        return String.format(locale, "(%.1fm, %s)", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeInt(parcel, 2, this.accuracy);
        SafeParcelWriter.writeDouble(parcel, 3, this.zzhg);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
