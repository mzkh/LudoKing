package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzlc implements Creator<zzkz> {
    zzlc() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzkz[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzkz(parcel);
    }
}
