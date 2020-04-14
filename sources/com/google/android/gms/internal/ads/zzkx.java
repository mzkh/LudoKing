package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzkx implements Parcelable {
    public static final Creator<zzkx> CREATOR = new zzkw();
    private final zza[] zzazn;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public interface zza extends Parcelable {
    }

    public zzkx(List<? extends zza> list) {
        this.zzazn = new zza[list.size()];
        list.toArray(this.zzazn);
    }

    public final int describeContents() {
        return 0;
    }

    zzkx(Parcel parcel) {
        this.zzazn = new zza[parcel.readInt()];
        int i = 0;
        while (true) {
            zza[] zzaArr = this.zzazn;
            if (i < zzaArr.length) {
                zzaArr[i] = (zza) parcel.readParcelable(zza.class.getClassLoader());
                i++;
            } else {
                return;
            }
        }
    }

    public final int length() {
        return this.zzazn.length;
    }

    public final zza zzar(int i) {
        return this.zzazn[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzazn, ((zzkx) obj).zzazn);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzazn);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zzazn.length);
        for (zza writeParcelable : this.zzazn) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
