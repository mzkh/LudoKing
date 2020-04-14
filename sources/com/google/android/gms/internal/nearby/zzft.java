package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzft implements Creator<zzfq> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        String str = null;
        String str2 = null;
        byte[] bArr = null;
        IBinder iBinder4 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    iBinder = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 2:
                    iBinder2 = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 3:
                    iBinder3 = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 4:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 6:
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 7:
                    iBinder4 = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        zzfq zzfq = new zzfq(iBinder, iBinder2, iBinder3, str, str2, bArr, iBinder4);
        return zzfq;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzfq[i];
    }
}
