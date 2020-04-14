package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzb implements Creator<AppContentActionEntity> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new AppContentActionEntity[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList arrayList = null;
        String str = null;
        Bundle bundle = null;
        String str2 = null;
        String str3 = null;
        AppContentAnnotationEntity appContentAnnotationEntity = null;
        String str4 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    arrayList = SafeParcelReader.createTypedList(parcel, readHeader, AppContentConditionEntity.CREATOR);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    bundle = SafeParcelReader.createBundle(parcel, readHeader);
                    break;
                case 6:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 7:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 8:
                    appContentAnnotationEntity = (AppContentAnnotationEntity) SafeParcelReader.createParcelable(parcel, readHeader, AppContentAnnotationEntity.CREATOR);
                    break;
                case 9:
                    str4 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        AppContentActionEntity appContentActionEntity = new AppContentActionEntity(arrayList, str, bundle, str2, str3, appContentAnnotationEntity, str4);
        return appContentActionEntity;
    }
}
