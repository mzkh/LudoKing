package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: com.google.firebase:firebase-iid@@19.0.1 */
final class zzf implements Creator<zzd> {
    zzf() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzd[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder != null) {
            return new zzd(readStrongBinder);
        }
        return null;
    }
}
