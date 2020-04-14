package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.zzr;
import java.util.List;

public final class zzb implements Creator<Query> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzr zzr = null;
        String str = null;
        SortOrder sortOrder = null;
        List list = null;
        List list2 = null;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    zzr = (zzr) SafeParcelReader.createParcelable(parcel, readHeader, zzr.CREATOR);
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    sortOrder = (SortOrder) SafeParcelReader.createParcelable(parcel, readHeader, SortOrder.CREATOR);
                    break;
                case 5:
                    list = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 6:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 7:
                    list2 = SafeParcelReader.createTypedList(parcel, readHeader, DriveSpace.CREATOR);
                    break;
                case 8:
                    z2 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        Query query = new Query(zzr, str, sortOrder, list, z, list2, z2);
        return query;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Query[i];
    }
}
