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

@Class(creator = "RewardedVideoAdRequestParcelCreator")
@Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzaqo extends AbstractSafeParcelable {
    public static final Creator<zzaqo> CREATOR = new zzaqn();
    @Field(mo15151id = 3)
    public final String zzbqy;
    @Field(mo15151id = 2)
    public final zztx zzdiu;

    @Constructor
    public zzaqo(@Param(mo15154id = 2) zztx zztx, @Param(mo15154id = 3) String str) {
        this.zzdiu = zztx;
        this.zzbqy = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdiu, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzbqy, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
