package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;

@Class(creator = "OpenFileIntentSenderRequestCreator")
@Reserved({1})
public final class zzgg extends AbstractSafeParcelable {
    public static final Creator<zzgg> CREATOR = new zzgh();
    @Field(mo15151id = 2)
    private final String zzay;
    @Field(mo15151id = 3)
    private final String[] zzaz;
    @Field(mo15151id = 4)
    private final DriveId zzbb;
    @Field(mo15151id = 5)
    private final FilterHolder zzbc;

    @Constructor
    @VisibleForTesting
    public zzgg(@Param(mo15154id = 2) String str, @Param(mo15154id = 3) String[] strArr, @Param(mo15154id = 4) DriveId driveId, @Param(mo15154id = 5) FilterHolder filterHolder) {
        this.zzay = str;
        this.zzaz = strArr;
        this.zzbb = driveId;
        this.zzbc = filterHolder;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzay, false);
        SafeParcelWriter.writeStringArray(parcel, 3, this.zzaz, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzbb, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzbc, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
