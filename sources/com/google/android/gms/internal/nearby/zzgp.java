package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.Arrays;

@Class(creator = "BleFilterCreator")
public final class zzgp extends AbstractSafeParcelable {
    public static final Creator<zzgp> CREATOR = new zzgq();
    @VersionField(getter = "getVersionCode", mo15157id = 1)
    private final int zzex;
    @Field(getter = "getServiceUuid", mo15151id = 4)
    @Nullable
    private final ParcelUuid zzge;
    @Field(getter = "getServiceUuidMask", mo15151id = 5)
    @Nullable
    private final ParcelUuid zzgf;
    @Field(getter = "getServiceDataUuid", mo15151id = 6)
    @Nullable
    private final ParcelUuid zzgg;
    @Field(getter = "getServiceData", mo15151id = 7)
    @Nullable
    private final byte[] zzgh;
    @Field(getter = "getServiceDataMask", mo15151id = 8)
    @Nullable
    private final byte[] zzgi;
    @Field(getter = "getManufacturerId", mo15151id = 9)
    private final int zzgj;
    @Field(getter = "getManufacturerData", mo15151id = 10)
    @Nullable
    private final byte[] zzgk;
    @Field(getter = "getManufacturerDataMask", mo15151id = 11)
    @Nullable
    private final byte[] zzgl;

    @Constructor
    zzgp(@Param(mo15154id = 1) int i, @Param(mo15154id = 4) ParcelUuid parcelUuid, @Param(mo15154id = 5) ParcelUuid parcelUuid2, @Param(mo15154id = 6) ParcelUuid parcelUuid3, @Param(mo15154id = 7) byte[] bArr, @Param(mo15154id = 8) byte[] bArr2, @Param(mo15154id = 9) int i2, @Param(mo15154id = 10) byte[] bArr3, @Param(mo15154id = 11) byte[] bArr4) {
        this.zzex = i;
        this.zzge = parcelUuid;
        this.zzgf = parcelUuid2;
        this.zzgg = parcelUuid3;
        this.zzgh = bArr;
        this.zzgi = bArr2;
        this.zzgj = i2;
        this.zzgk = bArr3;
        this.zzgl = bArr4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzgp zzgp = (zzgp) obj;
            return this.zzgj == zzgp.zzgj && Arrays.equals(this.zzgk, zzgp.zzgk) && Arrays.equals(this.zzgl, zzgp.zzgl) && Objects.equal(this.zzgg, zzgp.zzgg) && Arrays.equals(this.zzgh, zzgp.zzgh) && Arrays.equals(this.zzgi, zzgp.zzgi) && Objects.equal(this.zzge, zzgp.zzge) && Objects.equal(this.zzgf, zzgp.zzgf);
        }
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzgj), Integer.valueOf(Arrays.hashCode(this.zzgk)), Integer.valueOf(Arrays.hashCode(this.zzgl)), this.zzgg, Integer.valueOf(Arrays.hashCode(this.zzgh)), Integer.valueOf(Arrays.hashCode(this.zzgi)), this.zzge, this.zzgf);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzex);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzge, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzgf, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzgg, i, false);
        SafeParcelWriter.writeByteArray(parcel, 7, this.zzgh, false);
        SafeParcelWriter.writeByteArray(parcel, 8, this.zzgi, false);
        SafeParcelWriter.writeInt(parcel, 9, this.zzgj);
        SafeParcelWriter.writeByteArray(parcel, 10, this.zzgk, false);
        SafeParcelWriter.writeByteArray(parcel, 11, this.zzgl, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
