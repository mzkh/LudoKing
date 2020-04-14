package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;

public final class zza implements Creator<EventEntity> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new EventEntity[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        Uri uri = null;
        String str4 = null;
        Player player = null;
        String str5 = null;
        long j = 0;
        boolean z = false;
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
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 4:
                    uri = (Uri) SafeParcelReader.createParcelable(parcel2, readHeader, Uri.CREATOR);
                    break;
                case 5:
                    str4 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 6:
                    player = (PlayerEntity) SafeParcelReader.createParcelable(parcel2, readHeader, PlayerEntity.CREATOR);
                    break;
                case 7:
                    j = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 8:
                    str5 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 9:
                    z = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        EventEntity eventEntity = new EventEntity(str, str2, str3, uri, str4, player, j, str5, z);
        return eventEntity;
    }
}
