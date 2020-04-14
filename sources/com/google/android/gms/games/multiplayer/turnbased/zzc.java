package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public final class zzc implements Creator<TurnBasedMatchEntity> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new TurnBasedMatchEntity[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        long j2 = 0;
        GameEntity gameEntity = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        byte[] bArr = null;
        ArrayList arrayList = null;
        String str5 = null;
        byte[] bArr2 = null;
        Bundle bundle = null;
        String str6 = null;
        String str7 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
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
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 4:
                    j = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 5:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 6:
                    j2 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 7:
                    str4 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 8:
                    i = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 10:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 11:
                    i3 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 12:
                    bArr = SafeParcelReader.createByteArray(parcel2, readHeader);
                    break;
                case 13:
                    arrayList = SafeParcelReader.createTypedList(parcel2, readHeader, ParticipantEntity.CREATOR);
                    break;
                case 14:
                    str5 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 15:
                    bArr2 = SafeParcelReader.createByteArray(parcel2, readHeader);
                    break;
                case 16:
                    i4 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 17:
                    bundle = SafeParcelReader.createBundle(parcel2, readHeader);
                    break;
                case 18:
                    i5 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 19:
                    z = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 20:
                    str6 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 21:
                    str7 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        TurnBasedMatchEntity turnBasedMatchEntity = new TurnBasedMatchEntity(gameEntity, str, str2, j, str3, j2, str4, i, i2, i3, bArr, arrayList, str5, bArr2, i4, bundle, i5, z, str6, str7);
        return turnBasedMatchEntity;
    }
}
