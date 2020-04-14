package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import javax.annotation.ParametersAreNonnullByDefault;

@Class(creator = "RtbVersionInfoParcelCreator")
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzamr extends AbstractSafeParcelable {
    public static final Creator<zzamr> CREATOR = new zzamq();
    @Field(mo15151id = 1)
    private final int major;
    @Field(mo15151id = 2)
    private final int minor;
    @Field(mo15151id = 3)
    private final int zzdfd;

    public static zzamr zza(VersionInfo versionInfo) {
        return new zzamr(versionInfo.getMajorVersion(), versionInfo.getMinorVersion(), versionInfo.getMicroVersion());
    }

    @Constructor
    zzamr(@Param(mo15154id = 1) int i, @Param(mo15154id = 2) int i2, @Param(mo15154id = 3) int i3) {
        this.major = i;
        this.minor = i2;
        this.zzdfd = i3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.major);
        SafeParcelWriter.writeInt(parcel, 2, this.minor);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdfd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String toString() {
        int i = this.major;
        int i2 = this.minor;
        int i3 = this.zzdfd;
        StringBuilder sb = new StringBuilder(35);
        sb.append(i);
        String str = ".";
        sb.append(str);
        sb.append(i2);
        sb.append(str);
        sb.append(i3);
        return sb.toString();
    }
}
