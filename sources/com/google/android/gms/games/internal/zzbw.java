package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "PopupLocationInfoParcelableCreator")
@Reserved({1000})
public final class zzbw extends zzd {
    public static final Creator<zzbw> CREATOR = new zzbx();
    @Field(getter = "getInfoBundle", mo15151id = 1)
    private final Bundle zzjt;
    @Field(getter = "getWindowToken", mo15151id = 2)
    private final IBinder zzju;

    public zzbw(zzca zzca) {
        this.zzjt = zzca.zzcs();
        this.zzju = zzca.zzju;
    }

    @Constructor
    zzbw(@Param(mo15154id = 1) Bundle bundle, @Param(mo15154id = 2) IBinder iBinder) {
        this.zzjt = bundle;
        this.zzju = iBinder;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zzjt, false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzju, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
