package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "VersionInfoParcelCreator")
@Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzaxl extends AbstractSafeParcelable {
    public static final Creator<zzaxl> CREATOR = new zzaxo();
    @Field(mo15151id = 2)
    public String zzblz;
    @Field(mo15151id = 3)
    public int zzdwe;
    @Field(mo15151id = 4)
    public int zzdwf;
    @Field(mo15151id = 5)
    public boolean zzdwg;
    @Field(mo15151id = 6)
    private boolean zzdwh;

    public zzaxl(int i, int i2, boolean z) {
        this(i, i2, z, false, false);
    }

    public zzaxl(int i, int i2, boolean z, boolean z2) {
        this(i, i2, true, false, false);
    }

    private zzaxl(int i, int i2, boolean z, boolean z2, boolean z3) {
        String str = z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1";
        StringBuilder sb = new StringBuilder(str.length() + 36);
        sb.append("afma-sdk-a-v");
        sb.append(i);
        String str2 = ".";
        sb.append(str2);
        sb.append(i2);
        sb.append(str2);
        sb.append(str);
        this(sb.toString(), i, i2, z, false);
    }

    @Constructor
    zzaxl(@Param(mo15154id = 2) String str, @Param(mo15154id = 3) int i, @Param(mo15154id = 4) int i2, @Param(mo15154id = 5) boolean z, @Param(mo15154id = 6) boolean z2) {
        this.zzblz = str;
        this.zzdwe = i;
        this.zzdwf = i2;
        this.zzdwg = z;
        this.zzdwh = z2;
    }

    public static zzaxl zzwo() {
        return new zzaxl(12451009, 12451009, true);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzblz, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdwe);
        SafeParcelWriter.writeInt(parcel, 4, this.zzdwf);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzdwg);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzdwh);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
