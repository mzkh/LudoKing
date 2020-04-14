package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "HttpResponseParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaff extends AbstractSafeParcelable {
    public static final Creator<zzaff> CREATOR = new zzafe();
    @Field(mo15151id = 4)
    public final byte[] data;
    @Field(mo15151id = 3)
    public final int statusCode;
    @Field(mo15151id = 7)
    public final boolean zzac;
    @Field(mo15151id = 8)
    public final long zzad;
    @Field(mo15151id = 5)
    public final String[] zzcyg;
    @Field(mo15151id = 6)
    public final String[] zzcyh;
    @Field(mo15151id = 1)
    public final boolean zzcyi;
    @Field(mo15151id = 2)
    public final String zzcyj;

    @Constructor
    zzaff(@Param(mo15154id = 1) boolean z, @Param(mo15154id = 2) String str, @Param(mo15154id = 3) int i, @Param(mo15154id = 4) byte[] bArr, @Param(mo15154id = 5) String[] strArr, @Param(mo15154id = 6) String[] strArr2, @Param(mo15154id = 7) boolean z2, @Param(mo15154id = 8) long j) {
        this.zzcyi = z;
        this.zzcyj = str;
        this.statusCode = i;
        this.data = bArr;
        this.zzcyg = strArr;
        this.zzcyh = strArr2;
        this.zzac = z2;
        this.zzad = j;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zzcyi);
        SafeParcelWriter.writeString(parcel, 2, this.zzcyj, false);
        SafeParcelWriter.writeInt(parcel, 3, this.statusCode);
        SafeParcelWriter.writeByteArray(parcel, 4, this.data, false);
        SafeParcelWriter.writeStringArray(parcel, 5, this.zzcyg, false);
        SafeParcelWriter.writeStringArray(parcel, 6, this.zzcyh, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzac);
        SafeParcelWriter.writeLong(parcel, 8, this.zzad);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
