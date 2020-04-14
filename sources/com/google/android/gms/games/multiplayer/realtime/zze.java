package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class zze implements Creator<RoomEntity> {
    /* renamed from: zzg */
    public RoomEntity createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        ArrayList arrayList = null;
        long j = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 2:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 3:
                    j = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 4:
                    i = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 5:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 6:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 7:
                    bundle = SafeParcelReader.createBundle(parcel2, readHeader);
                    break;
                case 8:
                    arrayList = SafeParcelReader.createTypedList(parcel2, readHeader, ParticipantEntity.CREATOR);
                    break;
                case 9:
                    i3 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        RoomEntity roomEntity = new RoomEntity(str, str2, j, i, str3, i2, bundle, arrayList, i3);
        return roomEntity;
    }

    public /* synthetic */ Object[] newArray(int i) {
        return new RoomEntity[i];
    }
}
