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
import java.util.Arrays;

@Class(creator = "OnConnectionInitiatedParamsCreator")
public final class zzeh extends AbstractSafeParcelable {
    public static final Creator<zzeh> CREATOR = new zzei();
    @Field(getter = "getRemoteEndpointId", mo15151id = 1)
    private String zzat;
    @Field(getter = "getHandshakeData", mo15151id = 5)
    @Nullable
    private byte[] zzau;
    @Field(getter = "getRemoteEndpointName", mo15151id = 2)
    private String zzdj;
    @Field(getter = "getAuthenticationToken", mo15151id = 3)
    private String zzr;
    @Field(getter = "getIsIncomingConnection", mo15151id = 4)
    private boolean zzs;

    private zzeh() {
    }

    @Constructor
    zzeh(@Param(mo15154id = 1) String str, @Param(mo15154id = 2) String str2, @Param(mo15154id = 3) String str3, @Param(mo15154id = 4) boolean z, @Param(mo15154id = 5) @Nullable byte[] bArr) {
        this.zzat = str;
        this.zzdj = str2;
        this.zzr = str3;
        this.zzs = z;
        this.zzau = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzeh) {
            zzeh zzeh = (zzeh) obj;
            return Objects.equal(this.zzat, zzeh.zzat) && Objects.equal(this.zzdj, zzeh.zzdj) && Objects.equal(this.zzr, zzeh.zzr) && Objects.equal(Boolean.valueOf(this.zzs), Boolean.valueOf(zzeh.zzs)) && Arrays.equals(this.zzau, zzeh.zzau);
        }
    }

    public final String getAuthenticationToken() {
        return this.zzr;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzat, this.zzdj, this.zzr, Boolean.valueOf(this.zzs), Integer.valueOf(Arrays.hashCode(this.zzau)));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzat, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzdj, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzr, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzs);
        SafeParcelWriter.writeByteArray(parcel, 5, this.zzau, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zzg() {
        return this.zzat;
    }

    public final String zzh() {
        return this.zzdj;
    }

    public final boolean zzi() {
        return this.zzs;
    }
}
