package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzfk implements Creator<zzfh> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        byte[] bArr = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        String str = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        long j = 0;
        long j2 = -1;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    j = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 2:
                    i = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 3:
                    bArr = SafeParcelReader.createByteArray(parcel2, readHeader);
                    break;
                case 4:
                    parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.createParcelable(parcel2, readHeader, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 6:
                    j2 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 7:
                    parcelFileDescriptor2 = (ParcelFileDescriptor) SafeParcelReader.createParcelable(parcel2, readHeader, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        zzfh zzfh = new zzfh(j, i, bArr, parcelFileDescriptor, str, j2, parcelFileDescriptor2);
        return zzfh;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzfh[i];
    }
}
