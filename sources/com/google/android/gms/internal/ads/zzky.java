package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzky extends zzle {
    public static final Creator<zzky> CREATOR = new zzla();
    private final String description;
    private final String mimeType;
    private final int zzazo;
    private final byte[] zzazp;

    public zzky(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.mimeType = str;
        this.description = null;
        this.zzazo = 3;
        this.zzazp = bArr;
    }

    zzky(Parcel parcel) {
        super("APIC");
        this.mimeType = parcel.readString();
        this.description = parcel.readString();
        this.zzazo = parcel.readInt();
        this.zzazp = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzky zzky = (zzky) obj;
            return this.zzazo == zzky.zzazo && zzof.zza(this.mimeType, zzky.mimeType) && zzof.zza(this.description, zzky.description) && Arrays.equals(this.zzazp, zzky.zzazp);
        }
    }

    public final int hashCode() {
        int i = (this.zzazo + 527) * 31;
        String str = this.mimeType;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((hashCode + i2) * 31) + Arrays.hashCode(this.zzazp);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mimeType);
        parcel.writeString(this.description);
        parcel.writeInt(this.zzazo);
        parcel.writeByteArray(this.zzazp);
    }
}
