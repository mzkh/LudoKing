package com.google.android.gms.internal.nearby;

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
import java.util.Arrays;

@Class(creator = "OnConnectionRequestParamsCreator")
@Reserved({1000})
public final class zzej extends AbstractSafeParcelable {
    public static final Creator<zzej> CREATOR = new zzek();
    @Field(getter = "getRemoteEndpointId", mo15151id = 1)
    private String zzat;
    @Field(getter = "getHandshakeData", mo15151id = 3)
    @Nullable
    private byte[] zzau;
    @Field(getter = "getRemoteEndpointName", mo15151id = 2)
    private String zzdj;

    private zzej() {
    }

    @Constructor
    zzej(@Param(mo15154id = 1) String str, @Param(mo15154id = 2) String str2, @Param(mo15154id = 3) @Nullable byte[] bArr) {
        this.zzat = str;
        this.zzdj = str2;
        this.zzau = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzej) {
            zzej zzej = (zzej) obj;
            return Objects.equal(this.zzat, zzej.zzat) && Objects.equal(this.zzdj, zzej.zzdj) && Arrays.equals(this.zzau, zzej.zzau);
        }
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzat, this.zzdj, Integer.valueOf(Arrays.hashCode(this.zzau)));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzat, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzdj, false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzau, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zzg() {
        return this.zzat;
    }

    public final String zzh() {
        return this.zzdj;
    }

    @Nullable
    public final byte[] zzj() {
        return this.zzau;
    }
}
