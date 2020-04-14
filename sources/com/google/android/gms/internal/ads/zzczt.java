package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class(creator = "GassRequestParcelCreator")
/* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
public final class zzczt extends AbstractSafeParcelable {
    public static final Creator<zzczt> CREATOR = new zzczs();
    @Field(mo15151id = 2)
    private final String packageName;
    @VersionField(mo15157id = 1)
    private final int versionCode;
    @Field(mo15151id = 3)
    private final String zzgof;

    @Constructor
    zzczt(@Param(mo15154id = 1) int i, @Param(mo15154id = 2) String str, @Param(mo15154id = 3) String str2) {
        this.versionCode = i;
        this.packageName = str;
        this.zzgof = str2;
    }

    public zzczt(String str, String str2) {
        this(1, str, str2);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, this.packageName, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzgof, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
