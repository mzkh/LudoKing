package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzj implements Creator<AppContentSectionEntity> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new AppContentSectionEntity[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        String str = null;
        Bundle bundle = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        ArrayList arrayList3 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                arrayList = SafeParcelReader.createTypedList(parcel, readHeader, AppContentActionEntity.CREATOR);
            } else if (fieldId != 14) {
                switch (fieldId) {
                    case 3:
                        arrayList2 = SafeParcelReader.createTypedList(parcel, readHeader, AppContentCardEntity.CREATOR);
                        break;
                    case 4:
                        str = SafeParcelReader.createString(parcel, readHeader);
                        break;
                    case 5:
                        bundle = SafeParcelReader.createBundle(parcel, readHeader);
                        break;
                    case 6:
                        str2 = SafeParcelReader.createString(parcel, readHeader);
                        break;
                    case 7:
                        str3 = SafeParcelReader.createString(parcel, readHeader);
                        break;
                    case 8:
                        str4 = SafeParcelReader.createString(parcel, readHeader);
                        break;
                    case 9:
                        str5 = SafeParcelReader.createString(parcel, readHeader);
                        break;
                    case 10:
                        str6 = SafeParcelReader.createString(parcel, readHeader);
                        break;
                    default:
                        SafeParcelReader.skipUnknownField(parcel, readHeader);
                        break;
                }
            } else {
                arrayList3 = SafeParcelReader.createTypedList(parcel, readHeader, AppContentAnnotationEntity.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        AppContentSectionEntity appContentSectionEntity = new AppContentSectionEntity(arrayList, arrayList2, str, bundle, str2, str3, str4, str5, str6, arrayList3);
        return appContentSectionEntity;
    }
}
