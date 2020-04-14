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
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.zzb;
import com.google.android.gms.drive.events.zzo;
import com.google.android.gms.drive.events.zzr;
import com.google.android.gms.drive.events.zzv;

@Class(creator = "OnEventResponseCreator")
@Reserved({1, 4, 8})
public final class zzfj extends AbstractSafeParcelable {
    public static final Creator<zzfj> CREATOR = new zzfk();
    @Field(mo15151id = 2)
    private final int zzcy;
    @Field(mo15151id = 3)
    private final ChangeEvent zzhl;
    @Field(mo15151id = 5)
    private final CompletionEvent zzhm;
    @Field(mo15151id = 6)
    private final zzo zzhn;
    @Field(mo15151id = 7)
    private final zzb zzho;
    @Field(mo15151id = 9)
    private final zzv zzhp;
    @Field(mo15151id = 10)
    private final zzr zzhq;

    @Constructor
    zzfj(@Param(mo15154id = 2) int i, @Param(mo15154id = 3) ChangeEvent changeEvent, @Param(mo15154id = 5) CompletionEvent completionEvent, @Param(mo15154id = 6) zzo zzo, @Param(mo15154id = 7) zzb zzb, @Param(mo15154id = 9) zzv zzv, @Param(mo15154id = 10) zzr zzr) {
        this.zzcy = i;
        this.zzhl = changeEvent;
        this.zzhm = completionEvent;
        this.zzhn = zzo;
        this.zzho = zzb;
        this.zzhp = zzv;
        this.zzhq = zzr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzcy);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzhl, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzhm, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzhn, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzho, i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzhp, i, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzhq, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final DriveEvent zzak() {
        int i = this.zzcy;
        if (i == 1) {
            return this.zzhl;
        }
        if (i == 2) {
            return this.zzhm;
        }
        if (i == 3) {
            return this.zzhn;
        }
        if (i == 4) {
            return this.zzho;
        }
        if (i == 7) {
            return this.zzhp;
        }
        if (i == 8) {
            return this.zzhq;
        }
        StringBuilder sb = new StringBuilder(33);
        sb.append("Unexpected event type ");
        sb.append(i);
        throw new IllegalStateException(sb.toString());
    }
}
