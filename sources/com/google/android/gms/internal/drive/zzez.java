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
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.zza;
import com.google.android.gms.drive.zzu;
import java.util.List;

@Class(creator = "OnChangesResponseCreator")
@Reserved({1})
public final class zzez extends zzu {
    public static final Creator<zzez> CREATOR = new zzfa();
    @Field(mo15151id = 2)
    private final DataHolder zzhb;
    @Field(mo15151id = 3)
    private final List<DriveId> zzhc;
    @Field(mo15151id = 4)
    private final zza zzhd;
    @Field(mo15151id = 5)
    private final boolean zzhe;

    @Constructor
    public zzez(@Param(mo15154id = 2) DataHolder dataHolder, @Param(mo15154id = 3) List<DriveId> list, @Param(mo15154id = 4) zza zza, @Param(mo15154id = 5) boolean z) {
        this.zzhb = dataHolder;
        this.zzhc = list;
        this.zzhd = zza;
        this.zzhe = z;
    }

    /* access modifiers changed from: protected */
    public final void zza(Parcel parcel, int i) {
        int i2 = i | 1;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzhb, i2, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzhc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzhd, i2, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzhe);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
