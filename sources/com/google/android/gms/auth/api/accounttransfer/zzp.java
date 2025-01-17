package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zzp implements Creator<zzo> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        List list = null;
        List list2 = null;
        List list3 = null;
        List list4 = null;
        List list5 = null;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    list = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 3:
                    list2 = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 4:
                    list3 = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 5:
                    list4 = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 6:
                    list5 = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        zzo zzo = new zzo(i, list, list2, list3, list4, list5);
        return zzo;
    }
}
