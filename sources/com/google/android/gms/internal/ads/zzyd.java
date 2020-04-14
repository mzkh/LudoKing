package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "RequestConfigurationParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzyd extends AbstractSafeParcelable {
    public static final Creator<zzyd> CREATOR = new zzyc();
    @Field(mo15151id = 1)
    private final int zzabj;
    @Field(mo15151id = 2)
    private final int zzabk;

    @Constructor
    public zzyd(@Param(mo15154id = 1) int i, @Param(mo15154id = 2) int i2) {
        this.zzabj = i;
        this.zzabk = i2;
    }

    public zzyd(RequestConfiguration requestConfiguration) {
        this.zzabj = requestConfiguration.getTagForChildDirectedTreatment();
        this.zzabk = requestConfiguration.getTagForUnderAgeOfConsent();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzabj);
        SafeParcelWriter.writeInt(parcel, 2, this.zzabk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
