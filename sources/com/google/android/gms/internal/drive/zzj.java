package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.zze;
import com.google.android.gms.drive.events.zzt;
import com.google.android.gms.drive.events.zzx;

@Class(creator = "AddEventListenerRequestCreator")
@Reserved({1})
public final class zzj extends AbstractSafeParcelable {
    public static final Creator<zzj> CREATOR = new zzk();
    @Field(mo15151id = 4)
    @Nullable
    private final zze zzbt;
    @Field(mo15151id = 3)
    final int zzcy;
    @Field(mo15151id = 5)
    @Nullable
    private final zzx zzcz;
    @Field(mo15151id = 6)
    @Nullable
    private final zzt zzda;
    @Field(mo15151id = 2)
    @Nullable
    final DriveId zzk;

    public zzj(int i, DriveId driveId) {
        this((DriveId) Preconditions.checkNotNull(driveId), 1, null, null, null);
    }

    @Constructor
    zzj(@Param(mo15154id = 2) DriveId driveId, @Param(mo15154id = 3) int i, @Param(mo15154id = 4) zze zze, @Param(mo15154id = 5) zzx zzx, @Param(mo15154id = 6) zzt zzt) {
        this.zzk = driveId;
        this.zzcy = i;
        this.zzbt = zze;
        this.zzcz = zzx;
        this.zzda = zzt;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzk, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzcy);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzbt, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzcz, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzda, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
