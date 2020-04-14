package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzc implements Creator<zzb> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zze zze = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(readHeader) != 3) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                zze = (zze) SafeParcelReader.createParcelable(parcel, readHeader, zze.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzb(zze);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzb[i];
    }
}
