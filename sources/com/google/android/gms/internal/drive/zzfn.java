package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.drive.zzu;

@Class(creator = "OnListEntriesResponseCreator")
@Reserved({1})
public final class zzfn extends zzu {
    public static final Creator<zzfn> CREATOR = new zzfo();
    @Field(mo15151id = 3)
    final boolean zzdy;
    @Field(mo15151id = 2)
    final DataHolder zzhs;

    @Constructor
    public zzfn(@Param(mo15154id = 2) DataHolder dataHolder, @Param(mo15154id = 3) boolean z) {
        this.zzhs = dataHolder;
        this.zzdy = z;
    }

    /* access modifiers changed from: protected */
    public final void zza(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzhs, i, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzdy);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final DataHolder zzal() {
        return this.zzhs;
    }
}
