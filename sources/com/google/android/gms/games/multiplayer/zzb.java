package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.measurement.api.AppMeasurementSdk.ConditionalUserProperty;
import java.util.ArrayList;

public final class zzb extends DataBufferRef implements Invitation {
    private final Game zznw;
    private final ArrayList<Participant> zzpc;
    private final ParticipantRef zzpf;

    zzb(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zznw = new GameRef(dataHolder, i);
        this.zzpc = new ArrayList<>(i2);
        String string = getString("external_inviter_id");
        ParticipantRef participantRef = null;
        for (int i3 = 0; i3 < i2; i3++) {
            ParticipantRef participantRef2 = new ParticipantRef(this.mDataHolder, this.mDataRow + i3);
            if (participantRef2.getParticipantId().equals(string)) {
                participantRef = participantRef2;
            }
            this.zzpc.add(participantRef2);
        }
        this.zzpf = (ParticipantRef) Preconditions.checkNotNull(participantRef, "Must have a valid inviter!");
    }

    public final int describeContents() {
        return 0;
    }

    public final Game getGame() {
        return this.zznw;
    }

    public final String getInvitationId() {
        return getString("external_invitation_id");
    }

    public final Participant getInviter() {
        return this.zzpf;
    }

    public final long getCreationTimestamp() {
        return Math.max(getLong(ConditionalUserProperty.CREATION_TIMESTAMP), getLong("last_modified_timestamp"));
    }

    public final ArrayList<Participant> getParticipants() {
        return this.zzpc;
    }

    public final int getInvitationType() {
        return getInteger("type");
    }

    public final int getVariant() {
        return getInteger("variant");
    }

    public final int getAvailableAutoMatchSlots() {
        if (!getBoolean("has_automatch_criteria")) {
            return 0;
        }
        return getInteger("automatch_max_players");
    }

    public final int hashCode() {
        return InvitationEntity.zza((Invitation) this);
    }

    public final boolean equals(Object obj) {
        return InvitationEntity.zza(this, obj);
    }

    public final String toString() {
        return InvitationEntity.zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((InvitationEntity) ((Invitation) freeze())).writeToParcel(parcel, i);
    }

    public final /* synthetic */ Object freeze() {
        return new InvitationEntity(this);
    }
}
