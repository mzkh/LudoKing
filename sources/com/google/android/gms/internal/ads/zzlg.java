package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzlg implements Creator<zzld> {
    zzlg() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzld[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzld(parcel);
    }
}
