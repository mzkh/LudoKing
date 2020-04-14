package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.RetainForClient;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.ArrayList;
import java.util.List;

@RetainForClient
@UsedByReflection("GamesClientImpl.java")
@Class(creator = "InvitationEntityCreator")
@Reserved({1000})
public final class InvitationEntity extends GamesDowngradeableSafeParcel implements Invitation {
    public static final Creator<InvitationEntity> CREATOR = new zza();
    @Field(getter = "getGame", mo15151id = 1)
    private final GameEntity zzlp;
    @Field(getter = "getInvitationId", mo15151id = 2)
    private final String zzoy;
    @Field(getter = "getCreationTimestamp", mo15151id = 3)
    private final long zzoz;
    @Field(getter = "getInvitationType", mo15151id = 4)
    private final int zzpa;
    @Field(getter = "getInviter", mo15151id = 5)
    private final ParticipantEntity zzpb;
    @Field(getter = "getParticipants", mo15151id = 6)
    private final ArrayList<ParticipantEntity> zzpc;
    @Field(getter = "getVariant", mo15151id = 7)
    private final int zzpd;
    @Field(getter = "getAvailableAutoMatchSlots", mo15151id = 8)
    private final int zzpe;

    static final class zza extends zza {
        zza() {
        }

        public final InvitationEntity zze(Parcel parcel) {
            if (InvitationEntity.zzb(InvitationEntity.getUnparcelClientVersion()) || InvitationEntity.canUnparcelSafely(InvitationEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            GameEntity gameEntity = (GameEntity) GameEntity.CREATOR.createFromParcel(parcel);
            String readString = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            ParticipantEntity participantEntity = (ParticipantEntity) ParticipantEntity.CREATOR.createFromParcel(parcel);
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i = 0; i < readInt2; i++) {
                arrayList.add((ParticipantEntity) ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            InvitationEntity invitationEntity = new InvitationEntity(gameEntity, readString, readLong, readInt, participantEntity, arrayList, -1, 0);
            return invitationEntity;
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }
    }

    InvitationEntity(@NonNull Invitation invitation) {
        this(invitation, ParticipantEntity.zza((List<Participant>) invitation.getParticipants()));
    }

    public final Invitation freeze() {
        return this;
    }

    public final boolean isDataValid() {
        return true;
    }

    private InvitationEntity(@NonNull Invitation invitation, @NonNull ArrayList<ParticipantEntity> arrayList) {
        ParticipantEntity participantEntity;
        this.zzlp = new GameEntity(invitation.getGame());
        this.zzoy = invitation.getInvitationId();
        this.zzoz = invitation.getCreationTimestamp();
        this.zzpa = invitation.getInvitationType();
        this.zzpd = invitation.getVariant();
        this.zzpe = invitation.getAvailableAutoMatchSlots();
        String participantId = invitation.getInviter().getParticipantId();
        this.zzpc = arrayList;
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                participantEntity = null;
                break;
            }
            Object obj = arrayList2.get(i);
            i++;
            participantEntity = (ParticipantEntity) obj;
            if (participantEntity.getParticipantId().equals(participantId)) {
                break;
            }
        }
        Preconditions.checkNotNull(participantEntity, "Must have a valid inviter!");
        this.zzpb = participantEntity;
    }

    @Constructor
    InvitationEntity(@Param(mo15154id = 1) GameEntity gameEntity, @Param(mo15154id = 2) String str, @Param(mo15154id = 3) long j, @Param(mo15154id = 4) int i, @Param(mo15154id = 5) ParticipantEntity participantEntity, @Param(mo15154id = 6) ArrayList<ParticipantEntity> arrayList, @Param(mo15154id = 7) int i2, @Param(mo15154id = 8) int i3) {
        this.zzlp = gameEntity;
        this.zzoy = str;
        this.zzoz = j;
        this.zzpa = i;
        this.zzpb = participantEntity;
        this.zzpc = arrayList;
        this.zzpd = i2;
        this.zzpe = i3;
    }

    public final Game getGame() {
        return this.zzlp;
    }

    public final String getInvitationId() {
        return this.zzoy;
    }

    public final Participant getInviter() {
        return this.zzpb;
    }

    public final long getCreationTimestamp() {
        return this.zzoz;
    }

    public final ArrayList<Participant> getParticipants() {
        return new ArrayList<>(this.zzpc);
    }

    public final int getInvitationType() {
        return this.zzpa;
    }

    public final int getVariant() {
        return this.zzpd;
    }

    public final int getAvailableAutoMatchSlots() {
        return this.zzpe;
    }

    public final void setShouldDowngrade(boolean z) {
        super.setShouldDowngrade(z);
        this.zzlp.setShouldDowngrade(z);
        this.zzpb.setShouldDowngrade(z);
        int size = this.zzpc.size();
        for (int i = 0; i < size; i++) {
            ((ParticipantEntity) this.zzpc.get(i)).setShouldDowngrade(z);
        }
    }

    public final int hashCode() {
        return zza((Invitation) this);
    }

    static int zza(Invitation invitation) {
        return Objects.hashCode(invitation.getGame(), invitation.getInvitationId(), Long.valueOf(invitation.getCreationTimestamp()), Integer.valueOf(invitation.getInvitationType()), invitation.getInviter(), invitation.getParticipants(), Integer.valueOf(invitation.getVariant()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    static boolean zza(Invitation invitation, Object obj) {
        if (!(obj instanceof Invitation)) {
            return false;
        }
        if (invitation == obj) {
            return true;
        }
        Invitation invitation2 = (Invitation) obj;
        return Objects.equal(invitation2.getGame(), invitation.getGame()) && Objects.equal(invitation2.getInvitationId(), invitation.getInvitationId()) && Objects.equal(Long.valueOf(invitation2.getCreationTimestamp()), Long.valueOf(invitation.getCreationTimestamp())) && Objects.equal(Integer.valueOf(invitation2.getInvitationType()), Integer.valueOf(invitation.getInvitationType())) && Objects.equal(invitation2.getInviter(), invitation.getInviter()) && Objects.equal(invitation2.getParticipants(), invitation.getParticipants()) && Objects.equal(Integer.valueOf(invitation2.getVariant()), Integer.valueOf(invitation.getVariant())) && Objects.equal(Integer.valueOf(invitation2.getAvailableAutoMatchSlots()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    public final String toString() {
        return zzb(this);
    }

    static String zzb(Invitation invitation) {
        return Objects.toStringHelper(invitation).add("Game", invitation.getGame()).add("InvitationId", invitation.getInvitationId()).add("CreationTimestamp", Long.valueOf(invitation.getCreationTimestamp())).add("InvitationType", Integer.valueOf(invitation.getInvitationType())).add("Inviter", invitation.getInviter()).add("Participants", invitation.getParticipants()).add("Variant", Integer.valueOf(invitation.getVariant())).add("AvailableAutoMatchSlots", Integer.valueOf(invitation.getAvailableAutoMatchSlots())).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (!shouldDowngrade()) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeParcelable(parcel, 1, getGame(), i, false);
            SafeParcelWriter.writeString(parcel, 2, getInvitationId(), false);
            SafeParcelWriter.writeLong(parcel, 3, getCreationTimestamp());
            SafeParcelWriter.writeInt(parcel, 4, getInvitationType());
            SafeParcelWriter.writeParcelable(parcel, 5, getInviter(), i, false);
            SafeParcelWriter.writeTypedList(parcel, 6, getParticipants(), false);
            SafeParcelWriter.writeInt(parcel, 7, getVariant());
            SafeParcelWriter.writeInt(parcel, 8, getAvailableAutoMatchSlots());
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
        this.zzlp.writeToParcel(parcel, i);
        parcel.writeString(this.zzoy);
        parcel.writeLong(this.zzoz);
        parcel.writeInt(this.zzpa);
        this.zzpb.writeToParcel(parcel, i);
        int size = this.zzpc.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            ((ParticipantEntity) this.zzpc.get(i2)).writeToParcel(parcel, i);
        }
    }
}
