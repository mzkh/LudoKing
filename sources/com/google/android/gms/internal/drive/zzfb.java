package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.drive.Contents;

@Class(creator = "OnContentsResponseCreator")
@Reserved({1})
public final class zzfb extends AbstractSafeParcelable {
    public static final Creator<zzfb> CREATOR = new zzfc();
    @Field(mo15151id = 2)
    final Contents zzeq;
    @Field(mo15151id = 3)
    final boolean zzhf;

    @Constructor
    public zzfb(@Param(mo15154id = 2) Contents contents, @Param(mo15154id = 3) boolean z) {
        this.zzeq = contents;
        this.zzhf = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzeq, i, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzhf);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final Contents zzai() {
        return this.zzeq;
    }
}
