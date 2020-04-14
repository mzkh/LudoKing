package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

public class zza implements Creator<InvitationEntity> {
    /* renamed from: zze */
    public InvitationEntity createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        GameEntity gameEntity = null;
        String str = null;
        ParticipantEntity participantEntity = null;
        ArrayList arrayList = null;
        long j = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
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
                    i = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 5:
                    participantEntity = (ParticipantEntity) SafeParcelReader.createParcelable(parcel2, readHeader, ParticipantEntity.CREATOR);
                    break;
                case 6:
                    arrayList = SafeParcelReader.createTypedList(parcel2, readHeader, ParticipantEntity.CREATOR);
                    break;
                case 7:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 8:
                    i3 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        InvitationEntity invitationEntity = new InvitationEntity(gameEntity, str, j, i, participantEntity, arrayList, i2, i3);
        return invitationEntity;
    }

    public /* synthetic */ Object[] newArray(int i) {
        return new InvitationEntity[i];
    }
}
