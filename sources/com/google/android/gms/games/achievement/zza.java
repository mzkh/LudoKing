package com.google.android.gms.games.achievement;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.games.PlayerEntity;

public final class zza implements Creator<AchievementEntity> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new AchievementEntity[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        long j2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        Uri uri = null;
        String str4 = null;
        Uri uri2 = null;
        String str5 = null;
        String str6 = null;
        PlayerEntity playerEntity = null;
        String str7 = null;
        String str8 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        float f = -1.0f;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 2:
                    i = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 4:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 5:
                    uri = (Uri) SafeParcelReader.createParcelable(parcel2, readHeader, Uri.CREATOR);
                    break;
                case 6:
                    str4 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 7:
                    uri2 = (Uri) SafeParcelReader.createParcelable(parcel2, readHeader, Uri.CREATOR);
                    break;
                case 8:
                    str5 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 9:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 10:
                    str6 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 11:
                    playerEntity = (PlayerEntity) SafeParcelReader.createParcelable(parcel2, readHeader, PlayerEntity.CREATOR);
                    break;
                case 12:
                    i3 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 13:
                    i4 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 14:
                    str7 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 15:
                    j = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 16:
                    j2 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 17:
                    f = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 18:
                    str8 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        AchievementEntity achievementEntity = new AchievementEntity(str, i, str2, str3, uri, str4, uri2, str5, i2, str6, playerEntity, i3, i4, str7, j, j2, f, str8);
        return achievementEntity;
    }
}
