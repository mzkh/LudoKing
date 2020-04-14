package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.nearby.zzgp;
import com.google.android.gms.internal.nearby.zzgu;
import com.google.android.gms.nearby.messages.internal.zzad;
import java.util.List;

public final class zzc implements Creator<MessageFilter> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        List list = null;
        List list2 = null;
        List list3 = null;
        int i = 0;
        boolean z = false;
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                list = SafeParcelReader.createTypedList(parcel, readHeader, zzad.CREATOR);
            } else if (fieldId == 2) {
                list2 = SafeParcelReader.createTypedList(parcel, readHeader, zzgu.CREATOR);
            } else if (fieldId == 3) {
                z = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId == 4) {
                list3 = SafeParcelReader.createTypedList(parcel, readHeader, zzgp.CREATOR);
            } else if (fieldId == 5) {
                i2 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId != 1000) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                i = SafeParcelReader.readInt(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        MessageFilter messageFilter = new MessageFilter(i, list, list2, z, list3, i2);
        return messageFilter;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new MessageFilter[i];
    }
}
