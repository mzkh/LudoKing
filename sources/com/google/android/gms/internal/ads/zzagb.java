package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "MediationConfigurationParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzagb extends AbstractSafeParcelable {
    public static final Creator<zzagb> CREATOR = new zzaga();
    @Field(mo15151id = 2)
    public final Bundle extras;
    @Field(mo15151id = 1)
    public final String zzcys;

    @Constructor
    public zzagb(@Param(mo15154id = 1) String str, @Param(mo15154id = 2) Bundle bundle) {
        this.zzcys = str;
        this.extras = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzcys, false);
        SafeParcelWriter.writeBundle(parcel, 2, this.extras, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
