package com.google.android.gms.internal.nearby;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "OnEndpointFoundParamsCreator")
@Reserved({1000})
public final class zzer extends AbstractSafeParcelable {
    public static final Creator<zzer> CREATOR = new zzes();
    @Field(getter = "getEndpointId", mo15151id = 1)
    private String zzca;
    @Field(getter = "getEndpointName", mo15151id = 3)
    private String zzq;
    @Field(getter = "getServiceId", mo15151id = 2)
    private String zzu;
    @Field(getter = "getBluetoothDevice", mo15151id = 4)
    @Nullable
    private BluetoothDevice zzv;

    private zzer() {
    }

    @Constructor
    zzer(@Param(mo15154id = 1) String str, @Param(mo15154id = 2) String str2, @Param(mo15154id = 3) String str3, @Param(mo15154id = 4) @Nullable BluetoothDevice bluetoothDevice) {
        this.zzca = str;
        this.zzu = str2;
        this.zzq = str3;
        this.zzv = bluetoothDevice;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzer) {
            zzer zzer = (zzer) obj;
            return Objects.equal(this.zzca, zzer.zzca) && Objects.equal(this.zzu, zzer.zzu) && Objects.equal(this.zzq, zzer.zzq) && Objects.equal(this.zzv, zzer.zzv);
        }
    }

    public final String getEndpointName() {
        return this.zzq;
    }

    public final String getServiceId() {
        return this.zzu;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzca, this.zzu, this.zzq, this.zzv);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzca, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzu, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzq, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzv, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zze() {
        return this.zzca;
    }

    @Nullable
    public final BluetoothDevice zzk() {
        return this.zzv;
    }
}
