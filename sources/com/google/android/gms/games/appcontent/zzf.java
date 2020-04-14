package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzf implements Creator<AppContentCardEntity> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new AppContentCardEntity[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        String str = null;
        String str2 = null;
        Bundle bundle = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    arrayList = SafeParcelReader.createTypedList(parcel2, readHeader, AppContentActionEntity.CREATOR);
                    break;
                case 2:
                    arrayList2 = SafeParcelReader.createTypedList(parcel2, readHeader, AppContentAnnotationEntity.CREATOR);
                    break;
                case 3:
                    arrayList3 = SafeParcelReader.createTypedList(parcel2, readHeader, AppContentConditionEntity.CREATOR);
                    break;
                case 4:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 5:
                    i = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 6:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 7:
                    bundle = SafeParcelReader.createBundle(parcel2, readHeader);
                    break;
                case 10:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 11:
                    str4 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 12:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 13:
                    str5 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 14:
                    str6 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        AppContentCardEntity appContentCardEntity = new AppContentCardEntity(arrayList, arrayList2, arrayList3, str, i, str2, bundle, str3, str4, i2, str5, str6);
        return appContentCardEntity;
    }
}
