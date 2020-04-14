package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.games.internal.zzd;

@Class(creator = "ParticipantResultCreator")
@Reserved({1000})
public final class ParticipantResult extends zzd {
    public static final Creator<ParticipantResult> CREATOR = new zzd();
    public static final int MATCH_RESULT_DISAGREED = 5;
    public static final int MATCH_RESULT_DISCONNECT = 4;
    public static final int MATCH_RESULT_LOSS = 1;
    public static final int MATCH_RESULT_NONE = 3;
    public static final int MATCH_RESULT_TIE = 2;
    public static final int MATCH_RESULT_UNINITIALIZED = -1;
    public static final int MATCH_RESULT_WIN = 0;
    public static final int PLACING_UNINITIALIZED = -1;
    @Field(getter = "getParticipantId", mo15151id = 1)
    private final String zzpg;
    @Field(getter = "getResult", mo15151id = 2)
    private final int zzpm;
    @Field(getter = "getPlacing", mo15151id = 3)
    private final int zzpn;

    @Constructor
    public ParticipantResult(@Param(mo15154id = 1) String str, @Param(mo15154id = 2) int i, @Param(mo15154id = 3) int i2) {
        this.zzpg = (String) Preconditions.checkNotNull(str);
        boolean z = true;
        if (!(i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5)) {
            z = false;
        }
        Preconditions.checkState(z);
        this.zzpm = i;
        this.zzpn = i2;
    }

    public final String getParticipantId() {
        return this.zzpg;
    }

    public final int getResult() {
        return this.zzpm;
    }

    public final int getPlacing() {
        return this.zzpn;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getParticipantId(), false);
        SafeParcelWriter.writeInt(parcel, 2, getResult());
        SafeParcelWriter.writeInt(parcel, 3, getPlacing());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(getPlacing()), Integer.valueOf(getResult()), getParticipantId());
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ParticipantResult)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ParticipantResult participantResult = (ParticipantResult) obj;
        return participantResult.getPlacing() == getPlacing() && participantResult.getResult() == getResult() && Objects.equal(participantResult.getParticipantId(), getParticipantId());
    }
}
