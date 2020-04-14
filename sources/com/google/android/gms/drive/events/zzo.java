package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.drive.zzu;

@Class(creator = "QueryResultEventParcelableCreator")
@Reserved({1})
public final class zzo extends zzu implements DriveEvent {
    public static final Creator<zzo> CREATOR = new zzp();
    @Field(mo15151id = 2)
    @Nullable
    private final DataHolder zzat;
    @Field(mo15151id = 3)
    private final boolean zzco;
    @Field(mo15151id = 4)
    private final int zzcp;

    @Constructor
    public zzo(@Param(mo15154id = 2) @Nullable DataHolder dataHolder, @Param(mo15154id = 3) boolean z, @Param(mo15154id = 4) int i) {
        this.zzat = dataHolder;
        this.zzco = z;
        this.zzcp = i;
    }

    public final int getType() {
        return 3;
    }

    public final void zza(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzat, i, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzco);
        SafeParcelWriter.writeInt(parcel, 4, this.zzcp);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zzaa() {
        return this.zzcp;
    }

    @Nullable
    public final DataHolder zzy() {
        return this.zzat;
    }

    public final boolean zzz() {
        return this.zzco;
    }
}
