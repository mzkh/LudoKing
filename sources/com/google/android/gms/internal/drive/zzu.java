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
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

@Class(creator = "CreateFileIntentSenderRequestCreator")
@Reserved({1})
public final class zzu extends AbstractSafeParcelable {
    public static final Creator<zzu> CREATOR = new zzv();
    @Field(mo15151id = 4)
    private final String zzay;
    @Field(mo15151id = 5)
    private final DriveId zzbb;
    @Field(mo15151id = 2)
    private final MetadataBundle zzdl;
    @Field(mo15151id = 6)
    private final Integer zzdm;
    @Field(mo15151id = 3)
    private final int zzj;

    @Constructor
    @VisibleForTesting
    public zzu(@Param(mo15154id = 2) MetadataBundle metadataBundle, @Param(mo15154id = 3) int i, @Param(mo15154id = 4) String str, @Param(mo15154id = 5) DriveId driveId, @Param(mo15154id = 6) Integer num) {
        this.zzdl = metadataBundle;
        this.zzj = i;
        this.zzay = str;
        this.zzbb = driveId;
        this.zzdm = num;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdl, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzj);
        SafeParcelWriter.writeString(parcel, 4, this.zzay, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzbb, i, false);
        SafeParcelWriter.writeIntegerObject(parcel, 6, this.zzdm, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
