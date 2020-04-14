package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.zzb;
import com.google.android.gms.drive.events.zzo;
import com.google.android.gms.drive.events.zzr;
import com.google.android.gms.drive.events.zzv;

public final class zzfk implements Creator<zzfj> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ChangeEvent changeEvent = null;
        CompletionEvent completionEvent = null;
        zzo zzo = null;
        zzb zzb = null;
        zzv zzv = null;
        zzr zzr = null;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 2) {
                i = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 3) {
                changeEvent = (ChangeEvent) SafeParcelReader.createParcelable(parcel, readHeader, ChangeEvent.CREATOR);
            } else if (fieldId == 5) {
                completionEvent = (CompletionEvent) SafeParcelReader.createParcelable(parcel, readHeader, CompletionEvent.CREATOR);
            } else if (fieldId == 6) {
                zzo = (zzo) SafeParcelReader.createParcelable(parcel, readHeader, zzo.CREATOR);
            } else if (fieldId == 7) {
                zzb = (zzb) SafeParcelReader.createParcelable(parcel, readHeader, zzb.CREATOR);
            } else if (fieldId == 9) {
                zzv = (zzv) SafeParcelReader.createParcelable(parcel, readHeader, zzv.CREATOR);
            } else if (fieldId != 10) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                zzr = (zzr) SafeParcelReader.createParcelable(parcel, readHeader, zzr.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        zzfj zzfj = new zzfj(i, changeEvent, completionEvent, zzo, zzb, zzv, zzr);
        return zzfj;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzfj[i];
    }
}
