package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantRef;
import com.google.android.gms.measurement.api.AppMeasurementSdk.ConditionalUserProperty;
import java.util.ArrayList;

public final class zzf extends DataBufferRef implements Room {
    private final int zznx;

    zzf(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zznx = i2;
    }

    public final int describeContents() {
        return 0;
    }

    public final String getRoomId() {
        return getString("external_match_id");
    }

    public final String getCreatorId() {
        return getString("creator_external");
    }

    public final long getCreationTimestamp() {
        return getLong(ConditionalUserProperty.CREATION_TIMESTAMP);
    }

    public final int getStatus() {
        return getInteger("status");
    }

    public final String getDescription() {
        return getString("description");
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("description", charArrayBuffer);
    }

    public final int getVariant() {
        return getInteger("variant");
    }

    @Nullable
    public final Bundle getAutoMatchCriteria() {
        if (!getBoolean("has_automatch_criteria")) {
            return null;
        }
        return RoomConfig.createAutoMatchCriteria(getInteger("automatch_min_players"), getInteger("automatch_max_players"), getLong("automatch_bit_mask"));
    }

    public final ArrayList<Participant> getParticipants() {
        ArrayList<Participant> arrayList = new ArrayList<>(this.zznx);
        for (int i = 0; i < this.zznx; i++) {
            arrayList.add(new ParticipantRef(this.mDataHolder, this.mDataRow + i));
        }
        return arrayList;
    }

    public final int getAutoMatchWaitEstimateSeconds() {
        return getInteger("automatch_wait_estimate_sec");
    }

    public final int getParticipantStatus(String str) {
        return RoomEntity.zza((Room) this, str);
    }

    public final ArrayList<String> getParticipantIds() {
        return RoomEntity.zzc(this);
    }

    public final String getParticipantId(String str) {
        return RoomEntity.zzb(this, str);
    }

    public final Participant getParticipant(String str) {
        return RoomEntity.zzc(this, str);
    }

    public final int hashCode() {
        return RoomEntity.zza((Room) this);
    }

    public final boolean equals(Object obj) {
        return RoomEntity.zza((Room) this, obj);
    }

    public final String toString() {
        return RoomEntity.zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((RoomEntity) ((Room) freeze())).writeToParcel(parcel, i);
    }

    public final /* synthetic */ Object freeze() {
        return new RoomEntity(this);
    }
}
