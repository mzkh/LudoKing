package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;

public final class RealTimeMessage implements Parcelable {
    public static final Creator<RealTimeMessage> CREATOR = new zza();
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;
    private final String zzpo;
    private final byte[] zzpp;
    private final int zzpq;

    private RealTimeMessage(String str, byte[] bArr, int i) {
        this.zzpo = (String) Preconditions.checkNotNull(str);
        this.zzpp = (byte[]) ((byte[]) Preconditions.checkNotNull(bArr)).clone();
        this.zzpq = i;
    }

    public final int describeContents() {
        return 0;
    }

    public final String getSenderParticipantId() {
        return this.zzpo;
    }

    public final byte[] getMessageData() {
        return this.zzpp;
    }

    public final boolean isReliable() {
        return this.zzpq == 1;
    }

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzpo);
        parcel.writeByteArray(this.zzpp);
        parcel.writeInt(this.zzpq);
    }

    /* synthetic */ RealTimeMessage(Parcel parcel, zza zza) {
        this(parcel);
    }
}
