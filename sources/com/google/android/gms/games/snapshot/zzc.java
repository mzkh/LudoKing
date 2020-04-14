package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzc implements Creator<SnapshotMetadataChangeEntity> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new SnapshotMetadataChangeEntity[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        Long l = null;
        BitmapTeleporter bitmapTeleporter = null;
        Uri uri = null;
        Long l2 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId == 2) {
                l = SafeParcelReader.readLongObject(parcel, readHeader);
            } else if (fieldId == 4) {
                uri = (Uri) SafeParcelReader.createParcelable(parcel, readHeader, Uri.CREATOR);
            } else if (fieldId == 5) {
                bitmapTeleporter = (BitmapTeleporter) SafeParcelReader.createParcelable(parcel, readHeader, BitmapTeleporter.CREATOR);
            } else if (fieldId != 6) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                l2 = SafeParcelReader.readLongObject(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        SnapshotMetadataChangeEntity snapshotMetadataChangeEntity = new SnapshotMetadataChangeEntity(str, l, bitmapTeleporter, uri, l2);
        return snapshotMetadataChangeEntity;
    }
}
