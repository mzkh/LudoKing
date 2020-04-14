package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzla implements Creator<zzky> {
    zzla() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzky[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzky(parcel);
    }
}
