package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.nearby.messages.BleSignal;

@Class(creator = "BleSignalImplCreator")
public final class zza extends AbstractSafeParcelable implements BleSignal {
    public static final Creator<zza> CREATOR = new zzb();
    @VersionField(mo15157id = 1)
    private final int versionCode;
    @Field(mo15151id = 2)
    private final int zzhb;
    @Field(mo15151id = 3)
    private final int zzhc;

    @Constructor
    zza(@Param(mo15154id = 1) int i, @Param(mo15154id = 2) int i2, @Param(mo15154id = 3) int i3) {
        this.versionCode = i;
        this.zzhb = i2;
        if (-169 >= i3 || i3 >= 87) {
            i3 = Integer.MIN_VALUE;
        }
        this.zzhc = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleSignal)) {
            return false;
        }
        BleSignal bleSignal = (BleSignal) obj;
        return this.zzhb == bleSignal.getRssi() && this.zzhc == bleSignal.getTxPower();
    }

    public final int getRssi() {
        return this.zzhb;
    }

    public final int getTxPower() {
        return this.zzhc;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzhb), Integer.valueOf(this.zzhc));
    }

    public final String toString() {
        int i = this.zzhb;
        int i2 = this.zzhc;
        StringBuilder sb = new StringBuilder(48);
        sb.append("BleSignal{rssi=");
        sb.append(i);
        sb.append(", txPower=");
        sb.append(i2);
        sb.append('}');
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeInt(parcel, 2, this.zzhb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzhc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
