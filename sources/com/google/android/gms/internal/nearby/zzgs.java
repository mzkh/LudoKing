package com.google.android.gms.internal.nearby;

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
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class(creator = "NearbyDeviceCreator")
public final class zzgs extends AbstractSafeParcelable {
    public static final Creator<zzgs> CREATOR = new zzgt();
    private static final String zzgu = null;
    public static final zzgs zzgv = new zzgs("", null);
    @VersionField(mo15157id = 1000)
    private final int zzex;
    @Field(getter = "getHandle", mo15151id = 3)
    private final String zzgw;
    @Field(getter = "getBluetoothAddress", mo15151id = 6)
    @Nullable
    private final String zzgx;

    @Constructor
    zzgs(@Param(mo15154id = 1000) int i, @Param(mo15154id = 3) @Nullable String str, @Param(mo15154id = 6) @Nullable String str2) {
        this.zzex = ((Integer) Preconditions.checkNotNull(Integer.valueOf(i))).intValue();
        if (str == null) {
            str = "";
        }
        this.zzgw = str;
        this.zzgx = str2;
    }

    private zzgs(String str, String str2) {
        this(1, str, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgs)) {
            return false;
        }
        zzgs zzgs = (zzgs) obj;
        return Objects.equal(this.zzgw, zzgs.zzgw) && Objects.equal(this.zzgx, zzgs.zzgx);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzgw, this.zzgx);
    }

    public final String toString() {
        String str = this.zzgw;
        String str2 = this.zzgx;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(str2).length());
        sb.append("NearbyDevice{handle=");
        sb.append(str);
        sb.append(", bluetoothAddress=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 3, this.zzgw, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzgx, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzex);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
