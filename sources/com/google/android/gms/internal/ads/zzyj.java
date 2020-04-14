package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "VideoOptionsParcelCreator")
@Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzyj extends AbstractSafeParcelable {
    public static final Creator<zzyj> CREATOR = new zzyi();
    @Field(mo15151id = 2)
    public final boolean zzabp;
    @Field(mo15151id = 3)
    public final boolean zzabq;
    @Field(mo15151id = 4)
    public final boolean zzabr;

    public zzyj(VideoOptions videoOptions) {
        this(videoOptions.getStartMuted(), videoOptions.getCustomControlsRequested(), videoOptions.getClickToExpandRequested());
    }

    @Constructor
    public zzyj(@Param(mo15154id = 2) boolean z, @Param(mo15154id = 3) boolean z2, @Param(mo15154id = 4) boolean z3) {
        this.zzabp = z;
        this.zzabq = z2;
        this.zzabr = z3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzabp);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzabq);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzabr);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
