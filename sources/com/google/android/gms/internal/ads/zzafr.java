package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "AdapterStatusParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzafr extends AbstractSafeParcelable {
    public static final Creator<zzafr> CREATOR = new zzafq();
    @Field(mo15151id = 4)
    public final String description;
    @Field(mo15151id = 1)
    public final String zzcyn;
    @Field(mo15151id = 2)
    public final boolean zzcyo;
    @Field(mo15151id = 3)
    public final int zzcyp;

    @Constructor
    public zzafr(@Param(mo15154id = 1) String str, @Param(mo15154id = 2) boolean z, @Param(mo15154id = 3) int i, @Param(mo15154id = 4) String str2) {
        this.zzcyn = str;
        this.zzcyo = z;
        this.zzcyp = i;
        this.description = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzcyn, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzcyo);
        SafeParcelWriter.writeInt(parcel, 3, this.zzcyp);
        SafeParcelWriter.writeString(parcel, 4, this.description, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
