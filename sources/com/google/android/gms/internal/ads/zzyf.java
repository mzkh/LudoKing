package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "SearchAdRequestParcelCreator")
@Reserved({1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14})
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzyf extends AbstractSafeParcelable {
    public static final Creator<zzyf> CREATOR = new zzye();
    @Field(mo15151id = 15)
    public final String zzblu;

    public zzyf(SearchAdRequest searchAdRequest) {
        this.zzblu = searchAdRequest.getQuery();
    }

    @Constructor
    zzyf(@Param(mo15154id = 15) String str) {
        this.zzblu = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 15, this.zzblu, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
