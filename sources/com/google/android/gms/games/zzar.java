package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzar implements Creator<PlayerLevelInfo> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new PlayerLevelInfo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        PlayerLevel playerLevel = null;
        PlayerLevel playerLevel2 = null;
        long j = 0;
        long j2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                j = SafeParcelReader.readLong(parcel, readHeader);
            } else if (fieldId == 2) {
                j2 = SafeParcelReader.readLong(parcel, readHeader);
            } else if (fieldId == 3) {
                playerLevel = (PlayerLevel) SafeParcelReader.createParcelable(parcel, readHeader, PlayerLevel.CREATOR);
            } else if (fieldId != 4) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                playerLevel2 = (PlayerLevel) SafeParcelReader.createParcelable(parcel, readHeader, PlayerLevel.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        PlayerLevelInfo playerLevelInfo = new PlayerLevelInfo(j, j2, playerLevel, playerLevel2);
        return playerLevelInfo;
    }
}
