package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zza implements Creator<VideoCapabilities> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new VideoCapabilities[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean[] zArr = null;
        boolean[] zArr2 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                z = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId == 2) {
                z2 = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId == 3) {
                z3 = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId == 4) {
                zArr = SafeParcelReader.createBooleanArray(parcel, readHeader);
            } else if (fieldId != 5) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                zArr2 = SafeParcelReader.createBooleanArray(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        VideoCapabilities videoCapabilities = new VideoCapabilities(z, z2, z3, zArr, zArr2);
        return videoCapabilities;
    }
}
