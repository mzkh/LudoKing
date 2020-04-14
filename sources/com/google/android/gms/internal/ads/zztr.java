package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "AdDataParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zztr extends AbstractSafeParcelable {
    public static final Creator<zztr> CREATOR = new zztq();
    @Field(mo15151id = 1)
    public final String zzcbt;
    @Field(mo15151id = 2)
    public final String zzcbu;

    @Constructor
    public zztr(@Param(mo15154id = 1) String str, @Param(mo15154id = 2) String str2) {
        this.zzcbt = str;
        this.zzcbu = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzcbt, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzcbu, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
