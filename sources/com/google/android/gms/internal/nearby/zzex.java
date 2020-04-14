package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;

@Class(creator = "OnPayloadTransferUpdateParamsCreator")
@Reserved({1000})
public final class zzex extends AbstractSafeParcelable {
    public static final Creator<zzex> CREATOR = new zzey();
    @Field(getter = "getRemoteEndpointId", mo15151id = 1)
    private String zzat;
    @Field(getter = "getUpdate", mo15151id = 2)
    private PayloadTransferUpdate zzdm;

    private zzex() {
    }

    @Constructor
    zzex(@Param(mo15154id = 1) String str, @Param(mo15154id = 2) PayloadTransferUpdate payloadTransferUpdate) {
        this.zzat = str;
        this.zzdm = payloadTransferUpdate;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzex) {
            zzex zzex = (zzex) obj;
            return Objects.equal(this.zzat, zzex.zzat) && Objects.equal(this.zzdm, zzex.zzdm);
        }
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzat, this.zzdm);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzat, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdm, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zzg() {
        return this.zzat;
    }

    public final PayloadTransferUpdate zzn() {
        return this.zzdm;
    }
}
