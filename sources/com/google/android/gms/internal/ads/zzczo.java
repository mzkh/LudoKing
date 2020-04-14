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

@Class(creator = "GassEventParcelCreator")
/* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
public final class zzczo extends AbstractSafeParcelable {
    public static final Creator<zzczo> CREATOR = new zzczr();
    @VersionField(mo15157id = 1)
    private final int versionCode;
    @Field(mo15151id = 2)
    private final byte[] zzgoe;

    @Constructor
    zzczo(@Param(mo15154id = 1) int i, @Param(mo15154id = 2) byte[] bArr) {
        this.versionCode = i;
        this.zzgoe = bArr;
    }

    public zzczo(byte[] bArr) {
        this(1, bArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzgoe, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
