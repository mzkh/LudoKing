package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "InterstitialAdParameterParcelCreator")
@Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzg extends AbstractSafeParcelable {
    public static final Creator<zzg> CREATOR = new zzj();
    @Field(mo15151id = 2)
    public final boolean zzbkw;
    @Field(mo15151id = 3)
    public final boolean zzbkx;
    @Field(mo15151id = 4)
    private final String zzbky;
    @Field(mo15151id = 5)
    public final boolean zzbkz;
    @Field(mo15151id = 6)
    public final float zzbla;
    @Field(mo15151id = 7)
    public final int zzblb;
    @Field(mo15151id = 8)
    public final boolean zzblc;
    @Field(mo15151id = 9)
    public final boolean zzbld;
    @Field(mo15151id = 10)
    public final boolean zzble;

    public zzg(boolean z, boolean z2, boolean z3, float f, int i, boolean z4, boolean z5, boolean z6) {
        this(false, z2, null, false, 0.0f, -1, z4, z5, z6);
    }

    @Constructor
    zzg(@Param(mo15154id = 2) boolean z, @Param(mo15154id = 3) boolean z2, @Param(mo15154id = 4) String str, @Param(mo15154id = 5) boolean z3, @Param(mo15154id = 6) float f, @Param(mo15154id = 7) int i, @Param(mo15154id = 8) boolean z4, @Param(mo15154id = 9) boolean z5, @Param(mo15154id = 10) boolean z6) {
        this.zzbkw = z;
        this.zzbkx = z2;
        this.zzbky = str;
        this.zzbkz = z3;
        this.zzbla = f;
        this.zzblb = i;
        this.zzblc = z4;
        this.zzbld = z5;
        this.zzble = z6;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzbkw);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzbkx);
        SafeParcelWriter.writeString(parcel, 4, this.zzbky, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzbkz);
        SafeParcelWriter.writeFloat(parcel, 6, this.zzbla);
        SafeParcelWriter.writeInt(parcel, 7, this.zzblb);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzblc);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzbld);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzble);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
