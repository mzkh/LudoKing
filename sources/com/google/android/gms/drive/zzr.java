package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "PermissionCreator")
@Reserved({1})
public final class zzr extends AbstractSafeParcelable {
    public static final Creator<zzr> CREATOR = new zzs();
    @Field(getter = "getAccountType", mo15151id = 3)
    private int accountType;
    @Field(getter = "getAccountIdentifier", mo15151id = 2)
    @Nullable
    private String zzbe;
    @Field(getter = "getAccountDisplayName", mo15151id = 4)
    @Nullable
    private String zzbf;
    @Field(getter = "getPhotoLink", mo15151id = 5)
    @Nullable
    private String zzbg;
    @Field(getter = "getRole", mo15151id = 6)
    private int zzbh;
    @Field(getter = "isLinkRequiredForAccess", mo15151id = 7)
    private boolean zzbi;

    @Constructor
    public zzr(@Param(mo15154id = 2) @Nullable String str, @Param(mo15154id = 3) int i, @Param(mo15154id = 4) @Nullable String str2, @Param(mo15154id = 5) @Nullable String str3, @Param(mo15154id = 6) int i2, @Param(mo15154id = 7) boolean z) {
        this.zzbe = str;
        this.accountType = i;
        this.zzbf = str2;
        this.zzbg = str3;
        this.zzbh = i2;
        this.zzbi = z;
    }

    private static boolean zzb(int i) {
        switch (i) {
            case 256:
            case 257:
            case 258:
                return true;
            default:
                return false;
        }
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (obj == this) {
                return true;
            }
            zzr zzr = (zzr) obj;
            return Objects.equal(this.zzbe, zzr.zzbe) && this.accountType == zzr.accountType && this.zzbh == zzr.zzbh && this.zzbi == zzr.zzbi;
        }
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzbe, Integer.valueOf(this.accountType), Integer.valueOf(this.zzbh), Boolean.valueOf(this.zzbi));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        boolean z = false;
        SafeParcelWriter.writeString(parcel, 2, !zzb(this.accountType) ? null : this.zzbe, false);
        int i2 = -1;
        SafeParcelWriter.writeInt(parcel, 3, !zzb(this.accountType) ? -1 : this.accountType);
        SafeParcelWriter.writeString(parcel, 4, this.zzbf, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbg, false);
        int i3 = this.zzbh;
        if (i3 == 0 || i3 == 1 || i3 == 2 || i3 == 3) {
            z = true;
        }
        if (z) {
            i2 = this.zzbh;
        }
        SafeParcelWriter.writeInt(parcel, 6, i2);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzbi);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
