package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzb implements Creator<VideoConfiguration> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new VideoConfiguration[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                i = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 2) {
                i2 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 7) {
                z = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId == 8) {
                z2 = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId != 9) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                z3 = SafeParcelReader.readBoolean(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        VideoConfiguration videoConfiguration = new VideoConfiguration(i, i2, z, z2, z3);
        return videoConfiguration;
    }
}
