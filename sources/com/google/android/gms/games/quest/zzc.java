package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

public final class zzc implements Creator<QuestEntity> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new QuestEntity[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        GameEntity gameEntity = null;
        String str = null;
        Uri uri = null;
        String str2 = null;
        String str3 = null;
        Uri uri2 = null;
        String str4 = null;
        String str5 = null;
        ArrayList arrayList = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    gameEntity = (GameEntity) SafeParcelReader.createParcelable(parcel2, readHeader, GameEntity.CREATOR);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 3:
                    j = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 4:
                    uri = (Uri) SafeParcelReader.createParcelable(parcel2, readHeader, Uri.CREATOR);
                    break;
                case 5:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 6:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 7:
                    j2 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 8:
                    j3 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 9:
                    uri2 = (Uri) SafeParcelReader.createParcelable(parcel2, readHeader, Uri.CREATOR);
                    break;
                case 10:
                    str4 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 12:
                    str5 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 13:
                    j4 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 14:
                    j5 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 15:
                    i = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 16:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 17:
                    arrayList = SafeParcelReader.createTypedList(parcel2, readHeader, MilestoneEntity.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        QuestEntity questEntity = new QuestEntity(gameEntity, str, j, uri, str2, str3, j2, j3, uri2, str4, str5, j4, j5, i, i2, arrayList);
        return questEntity;
    }
}
