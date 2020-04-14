package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "ExceptionParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzavq extends AbstractSafeParcelable {
    public static final Creator<zzavq> CREATOR = new zzavs();
    @Field(mo15151id = 2)
    public final int errorCode;
    @Field(mo15151id = 1)
    public final String zzdtw;

    @Nullable
    public static zzavq zza(Throwable th, int i) {
        return new zzavq(th.getMessage(), i);
    }

    @Constructor
    zzavq(@Param(mo15154id = 1) @Nullable String str, @Param(mo15154id = 2) int i) {
        if (str == null) {
            str = "";
        }
        this.zzdtw = str;
        this.errorCode = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdtw, false);
        SafeParcelWriter.writeInt(parcel, 2, this.errorCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
