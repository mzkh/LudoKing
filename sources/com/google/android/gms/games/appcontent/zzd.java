package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzd implements Creator<AppContentAnnotationEntity> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new AppContentAnnotationEntity[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        Uri uri = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        Bundle bundle = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 2:
                    uri = (Uri) SafeParcelReader.createParcelable(parcel, readHeader, Uri.CREATOR);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 6:
                    str4 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 7:
                    str5 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 8:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 9:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 10:
                    bundle = SafeParcelReader.createBundle(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        AppContentAnnotationEntity appContentAnnotationEntity = new AppContentAnnotationEntity(str, uri, str2, str3, str4, str5, i, i2, bundle);
        return appContentAnnotationEntity;
    }
}
