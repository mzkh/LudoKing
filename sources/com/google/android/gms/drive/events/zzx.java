package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.drive.DriveSpace;
import java.util.List;
import java.util.Locale;

@Class(creator = "TransferStateOptionsCreator")
@Reserved({1})
public final class zzx extends AbstractSafeParcelable {
    public static final Creator<zzx> CREATOR = new zzy();
    @Field(mo15151id = 2)
    private final List<DriveSpace> zzbw;

    @Constructor
    zzx(@Param(mo15154id = 2) @NonNull List<DriveSpace> list) {
        this.zzbw = list;
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return Objects.equal(this.zzbw, ((zzx) obj).zzbw);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzbw);
    }

    public final String toString() {
        return String.format(Locale.US, "TransferStateOptions[Spaces=%s]", new Object[]{this.zzbw});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzbw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
