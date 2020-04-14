package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "StringParcelCreator")
@Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzapg extends AbstractSafeParcelable {
    public static final Creator<zzapg> CREATOR = new zzapf();
    @Field(mo15151id = 2)
    String zzdmd;

    @Constructor
    public zzapg(@Param(mo15154id = 2) String str) {
        this.zzdmd = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzdmd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
