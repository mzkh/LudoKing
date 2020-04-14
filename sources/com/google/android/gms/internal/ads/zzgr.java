package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzgr implements Creator<zzgo> {
    zzgr() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzgo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzgo(parcel);
    }
}
