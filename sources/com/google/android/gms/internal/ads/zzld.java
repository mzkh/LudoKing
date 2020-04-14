package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzld extends zzle {
    public static final Creator<zzld> CREATOR = new zzlg();
    private final String description;
    private final String value;

    public zzld(String str, String str2, String str3) {
        super(str);
        this.description = null;
        this.value = str3;
    }

    zzld(Parcel parcel) {
        super(parcel.readString());
        this.description = parcel.readString();
        this.value = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzld zzld = (zzld) obj;
            return this.zzaex.equals(zzld.zzaex) && zzof.zza(this.description, zzld.description) && zzof.zza(this.value, zzld.value);
        }
    }

    public final int hashCode() {
        int hashCode = (this.zzaex.hashCode() + 527) * 31;
        String str = this.description;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.value;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzaex);
        parcel.writeString(this.description);
        parcel.writeString(this.value);
    }
}
