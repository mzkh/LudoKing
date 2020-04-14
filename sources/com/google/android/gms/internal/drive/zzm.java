package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.zzn;

@Class(creator = "CloseContentsAndUpdateMetadataRequestCreator")
@Reserved({1})
public final class zzm extends AbstractSafeParcelable {
    public static final Creator<zzm> CREATOR = new zzn();
    @Field(mo15151id = 6)
    private final String zzal;
    @Field(mo15151id = 5)
    private final boolean zzam;
    @Field(defaultValue = "true", mo15151id = 10)
    private final boolean zzar;
    @Field(mo15151id = 2)
    private final DriveId zzdb;
    @Field(mo15151id = 3)
    private final MetadataBundle zzdc;
    @Field(mo15151id = 4)
    @Nullable
    private final Contents zzdd;
    @Field(mo15151id = 7)
    private final int zzde;
    @Field(mo15151id = 8)
    private final int zzdf;
    @Field(mo15151id = 9)
    private final boolean zzdg;

    @VisibleForTesting
    public zzm(DriveId driveId, MetadataBundle metadataBundle, int i, boolean z, zzn zzn) {
        this(driveId, metadataBundle, null, zzn.zzl(), zzn.zzk(), zzn.zzm(), i, z, zzn.zzo());
    }

    @Constructor
    zzm(@Param(mo15154id = 2) DriveId driveId, @Param(mo15154id = 3) MetadataBundle metadataBundle, @Param(mo15154id = 4) Contents contents, @Param(mo15154id = 5) boolean z, @Param(mo15154id = 6) String str, @Param(mo15154id = 7) int i, @Param(mo15154id = 8) int i2, @Param(mo15154id = 9) boolean z2, @Param(mo15154id = 10) boolean z3) {
        this.zzdb = driveId;
        this.zzdc = metadataBundle;
        this.zzdd = contents;
        this.zzam = z;
        this.zzal = str;
        this.zzde = i;
        this.zzdf = i2;
        this.zzdg = z2;
        this.zzar = z3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdb, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdc, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzdd, i, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzam);
        SafeParcelWriter.writeString(parcel, 6, this.zzal, false);
        SafeParcelWriter.writeInt(parcel, 7, this.zzde);
        SafeParcelWriter.writeInt(parcel, 8, this.zzdf);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzdg);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzar);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
