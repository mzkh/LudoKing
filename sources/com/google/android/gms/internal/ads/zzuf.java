package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.appopen.AppOpenAd.AppOpenAdOrientation;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "AppOpenAdOptionsParcelCreator")
@Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzuf extends AbstractSafeParcelable {
    public static final Creator<zzuf> CREATOR = new zzue();
    @Field(mo15151id = 2)
    @AppOpenAdOrientation
    public final int orientation;

    @Constructor
    public zzuf(@Param(mo15154id = 2) @AppOpenAdOrientation int i) {
        this.orientation = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.orientation);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
