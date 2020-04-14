package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzkz extends zzle {
    public static final Creator<zzkz> CREATOR = new zzlc();
    public final String description;
    private final String zzaft;
    public final String zzazq;

    public zzkz(String str, String str2, String str3) {
        super("COMM");
        this.zzaft = str;
        this.description = str2;
        this.zzazq = str3;
    }

    zzkz(Parcel parcel) {
        super("COMM");
        this.zzaft = parcel.readString();
        this.description = parcel.readString();
        this.zzazq = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzkz zzkz = (zzkz) obj;
            return zzof.zza(this.description, zzkz.description) && zzof.zza(this.zzaft, zzkz.zzaft) && zzof.zza(this.zzazq, zzkz.zzazq);
        }
    }

    public final int hashCode() {
        String str = this.zzaft;
        int i = 0;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.zzazq;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzaex);
        parcel.writeString(this.zzaft);
        parcel.writeString(this.zzazq);
    }
}
