package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class(creator = "SendDataRequestCreator")
public final class zzaf extends AbstractSafeParcelable {
    public static final Creator<zzaf> CREATOR = new zzag();
    @Field(mo15151id = 2)
    private final String accountType;
    @Field(mo15151id = 3)
    private final byte[] zzbp;
    @VersionField(mo15157id = 1)
    private final int zzv;

    public zzaf(String str, byte[] bArr) {
        this(1, str, bArr);
    }

    @Constructor
    zzaf(@Param(mo15154id = 1) int i, @Param(mo15154id = 2) String str, @Param(mo15154id = 3) byte[] bArr) {
        this.zzv = 1;
        this.accountType = (String) Preconditions.checkNotNull(str);
        this.zzbp = (byte[]) Preconditions.checkNotNull(bArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzv);
        SafeParcelWriter.writeString(parcel, 2, this.accountType, false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzbp, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
