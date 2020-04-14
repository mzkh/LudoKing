package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzok implements Parcelable {
    public static final Creator<zzok> CREATOR = new zzoj();
    private int zzafv;
    public final int zzapv;
    public final int zzapw;
    public final int zzapx;
    public final byte[] zzbgz;

    public zzok(int i, int i2, int i3, byte[] bArr) {
        this.zzapv = i;
        this.zzapx = i2;
        this.zzapw = i3;
        this.zzbgz = bArr;
    }

    public final int describeContents() {
        return 0;
    }

    zzok(Parcel parcel) {
        this.zzapv = parcel.readInt();
        this.zzapx = parcel.readInt();
        this.zzapw = parcel.readInt();
        this.zzbgz = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzok zzok = (zzok) obj;
            return this.zzapv == zzok.zzapv && this.zzapx == zzok.zzapx && this.zzapw == zzok.zzapw && Arrays.equals(this.zzbgz, zzok.zzbgz);
        }
    }

    public final String toString() {
        int i = this.zzapv;
        int i2 = this.zzapx;
        int i3 = this.zzapw;
        boolean z = this.zzbgz != null;
        StringBuilder sb = new StringBuilder(55);
        sb.append("ColorInfo(");
        sb.append(i);
        String str = ", ";
        sb.append(str);
        sb.append(i2);
        sb.append(str);
        sb.append(i3);
        sb.append(str);
        sb.append(z);
        sb.append(")");
        return sb.toString();
    }

    public final int hashCode() {
        if (this.zzafv == 0) {
            this.zzafv = ((((((this.zzapv + 527) * 31) + this.zzapx) * 31) + this.zzapw) * 31) + Arrays.hashCode(this.zzbgz);
        }
        return this.zzafv;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zzapv);
        parcel.writeInt(this.zzapx);
        parcel.writeInt(this.zzapw);
        parcel.writeInt(this.zzbgz != null ? 1 : 0);
        byte[] bArr = this.zzbgz;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
