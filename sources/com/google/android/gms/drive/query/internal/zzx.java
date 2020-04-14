package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "OperatorCreator")
@Reserved({1000})
public final class zzx extends AbstractSafeParcelable {
    public static final Creator<zzx> CREATOR = new zzy();
    public static final zzx zzma = new zzx("=");
    public static final zzx zzmb = new zzx("<");
    public static final zzx zzmc = new zzx("<=");
    public static final zzx zzmd = new zzx(">");
    public static final zzx zzme = new zzx(">=");
    public static final zzx zzmf = new zzx("and");
    public static final zzx zzmg = new zzx("or");
    private static final zzx zzmh = new zzx("not");
    public static final zzx zzmi = new zzx("contains");
    @Field(mo15151id = 1)
    private final String tag;

    @Constructor
    zzx(@Param(mo15154id = 1) String str) {
        this.tag = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzx zzx = (zzx) obj;
        String str = this.tag;
        if (str == null) {
            if (zzx.tag != null) {
                return false;
            }
        } else if (!str.equals(zzx.tag)) {
            return false;
        }
        return true;
    }

    public final String getTag() {
        return this.tag;
    }

    public final int hashCode() {
        String str = this.tag;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.tag, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
