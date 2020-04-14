package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.zze;
import com.google.android.gms.drive.events.zzt;
import com.google.android.gms.drive.events.zzx;

public final class zzk implements Creator<zzj> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        DriveId driveId = null;
        zze zze = null;
        zzx zzx = null;
        zzt zzt = null;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 2) {
                driveId = (DriveId) SafeParcelReader.createParcelable(parcel, readHeader, DriveId.CREATOR);
            } else if (fieldId == 3) {
                i = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 4) {
                zze = (zze) SafeParcelReader.createParcelable(parcel, readHeader, zze.CREATOR);
            } else if (fieldId == 5) {
                zzx = (zzx) SafeParcelReader.createParcelable(parcel, readHeader, zzx.CREATOR);
            } else if (fieldId != 6) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                zzt = (zzt) SafeParcelReader.createParcelable(parcel, readHeader, zzt.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        zzj zzj = new zzj(driveId, i, zze, zzx, zzt);
        return zzj;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzj[i];
    }
}
