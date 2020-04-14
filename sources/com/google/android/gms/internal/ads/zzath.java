package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import javax.annotation.ParametersAreNonnullByDefault;

@Class(creator = "SignalConfigurationParcelCreator")
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzath extends AbstractSafeParcelable {
    public static final Creator<zzath> CREATOR = new zzatk();
    @Field(mo15151id = 2)
    public final String zzblw;
    @Field(mo15151id = 1)
    public final String zzbqy;
    @Field(mo15151id = 3)
    public final zzua zzdpz;

    @Constructor
    public zzath(@Param(mo15154id = 1) String str, @Param(mo15154id = 2) String str2, @Param(mo15154id = 3) zzua zzua) {
        this.zzbqy = str;
        this.zzblw = str2;
        this.zzdpz = zzua;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzbqy, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzblw, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdpz, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
