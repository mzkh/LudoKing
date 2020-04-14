package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "InitializationParamsCreator")
public final class zzx extends AbstractSafeParcelable {
    public static final Creator<zzx> CREATOR = new zzw();
    @Field(mo15151id = 5)
    public final String origin;
    @Field(mo15151id = 1)
    public final long zzr;
    @Field(mo15151id = 2)
    public final long zzs;
    @Field(mo15151id = 3)
    public final boolean zzt;
    @Field(mo15151id = 4)
    public final String zzu;
    @Field(mo15151id = 6)
    public final String zzv;
    @Field(mo15151id = 7)
    public final Bundle zzw;

    @Constructor
    public zzx(@Param(mo15154id = 1) long j, @Param(mo15154id = 2) long j2, @Param(mo15154id = 3) boolean z, @Param(mo15154id = 4) String str, @Param(mo15154id = 5) String str2, @Param(mo15154id = 6) String str3, @Param(mo15154id = 7) Bundle bundle) {
        this.zzr = j;
        this.zzs = j2;
        this.zzt = z;
        this.zzu = str;
        this.origin = str2;
        this.zzv = str3;
        this.zzw = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zzr);
        SafeParcelWriter.writeLong(parcel, 2, this.zzs);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzt);
        SafeParcelWriter.writeString(parcel, 4, this.zzu, false);
        SafeParcelWriter.writeString(parcel, 5, this.origin, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzv, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
