package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.ads.zzin.zza;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzio implements Creator<zza> {
    zzio() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zza[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zza(parcel);
    }
}
