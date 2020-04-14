package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import javax.annotation.ParametersAreNonnullByDefault;

@Class(creator = "ServerSideVerificationOptionsParcelCreator")
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzarr extends AbstractSafeParcelable {
    public static final Creator<zzarr> CREATOR = new zzaru();
    @Field(mo15151id = 1)
    public final String zzdnz;
    @Field(mo15151id = 2)
    public final String zzdoa;

    public zzarr(ServerSideVerificationOptions serverSideVerificationOptions) {
        this(serverSideVerificationOptions.getUserId(), serverSideVerificationOptions.getCustomData());
    }

    @Constructor
    public zzarr(@Param(mo15154id = 1) String str, @Param(mo15154id = 2) String str2) {
        this.zzdnz = str;
        this.zzdoa = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdnz, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzdoa, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
