package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.common.util.RetainForClient;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.zzc;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;
import java.util.List;

@RetainForClient
@UsedByReflection("GamesClientImpl.java")
@Class(creator = "RoomEntityCreator")
@Reserved({1000})
public final class RoomEntity extends GamesDowngradeableSafeParcel implements Room {
    public static final Creator<RoomEntity> CREATOR = new zza();
    @Field(getter = "getDescription", mo15151id = 5)
    private final String description;
    @Field(getter = "getCreationTimestamp", mo15151id = 3)
    private final long zzoz;
    @Field(getter = "getParticipants", mo15151id = 8)
    private final ArrayList<ParticipantEntity> zzpc;
    @Field(getter = "getVariant", mo15151id = 6)
    private final int zzpd;
    @Field(getter = "getAutoMatchCriteria", mo15151id = 7)
    @Nullable
    private final Bundle zzpz;
    @Field(getter = "getRoomId", mo15151id = 1)
    private final String zzqc;
    @Field(getter = "getCreatorId", mo15151id = 2)
    private final String zzqd;
    @Field(getter = "getStatus", mo15151id = 4)
    private final int zzqe;
    @Field(getter = "getAutoMatchWaitEstimateSeconds", mo15151id = 9)
    private final int zzqf;

    static final class zza extends zze {
        zza() {
        }

        public final RoomEntity zzg(Parcel parcel) {
            if (RoomEntity.zzb(RoomEntity.getUnparcelClientVersion()) || RoomEntity.canUnparcelSafely(RoomEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            String readString3 = parcel.readString();
            int readInt2 = parcel.readInt();
            Bundle readBundle = parcel.readBundle();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i = 0; i < readInt3; i++) {
                arrayList.add((ParticipantEntity) ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            RoomEntity roomEntity = new RoomEntity(readString, readString2, readLong, readInt, readString3, readInt2, readBundle, arrayList, -1);
            return roomEntity;
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }
    }

    public RoomEntity(Room room) {
        this(room, ParticipantEntity.zza((List<Participant>) room.getParticipants()));
    }

    public final Room freeze() {
        return this;
    }

    public final boolean isDataValid() {
        return true;
    }

    private RoomEntity(Room room, ArrayList<ParticipantEntity> arrayList) {
        this.zzqc = room.getRoomId();
        this.zzqd = room.getCreatorId();
        this.zzoz = room.getCreationTimestamp();
        this.zzqe = room.getStatus();
        this.description = room.getDescription();
        this.zzpd = room.getVariant();
        this.zzpz = room.getAutoMatchCriteria();
        this.zzpc = arrayList;
        this.zzqf = room.getAutoMatchWaitEstimateSeconds();
    }

    @Constructor
    RoomEntity(@Param(mo15154id = 1) String str, @Param(mo15154id = 2) String str2, @Param(mo15154id = 3) long j, @Param(mo15154id = 4) int i, @Param(mo15154id = 5) String str3, @Param(mo15154id = 6) int i2, @Param(mo15154id = 7) @Nullable Bundle bundle, @Param(mo15154id = 8) ArrayList<ParticipantEntity> arrayList, @Param(mo15154id = 9) int i3) {
        this.zzqc = str;
        this.zzqd = str2;
        this.zzoz = j;
        this.zzqe = i;
        this.description = str3;
        this.zzpd = i2;
        this.zzpz = bundle;
        this.zzpc = arrayList;
        this.zzqf = i3;
    }

    public final String getRoomId() {
        return this.zzqc;
    }

    public final String getCreatorId() {
        return this.zzqd;
    }

    public final long getCreationTimestamp() {
        return this.zzoz;
    }

    public final int getStatus() {
        return this.zzqe;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.description, charArrayBuffer);
    }

    public final int getVariant() {
        return this.zzpd;
    }

    @Nullable
    public final Bundle getAutoMatchCriteria() {
        return this.zzpz;
    }

    public final ArrayList<Participant> getParticipants() {
        return new ArrayList<>(this.zzpc);
    }

    public final int getAutoMatchWaitEstimateSeconds() {
        return this.zzqf;
    }

    public final int getParticipantStatus(String str) {
        return zza((Room) this, str);
    }

    public final ArrayList<String> getParticipantIds() {
        return zzc(this);
    }

    public final String getParticipantId(String str) {
        return zzb(this, str);
    }

    public final Participant getParticipant(String str) {
        return zzc(this, str);
    }

    public final void setShouldDowngrade(boolean z) {
        super.setShouldDowngrade(z);
        int size = this.zzpc.size();
        for (int i = 0; i < size; i++) {
            ((ParticipantEntity) this.zzpc.get(i)).setShouldDowngrade(z);
        }
    }

    public final int hashCode() {
        return zza((Room) this);
    }

    static int zza(Room room) {
        return Objects.hashCode(room.getRoomId(), room.getCreatorId(), Long.valueOf(room.getCreationTimestamp()), Integer.valueOf(room.getStatus()), room.getDescription(), Integer.valueOf(room.getVariant()), Integer.valueOf(zzc.zza(room.getAutoMatchCriteria())), room.getParticipants(), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    public final boolean equals(Object obj) {
        return zza((Room) this, obj);
    }

    static boolean zza(Room room, Object obj) {
        if (!(obj instanceof Room)) {
            return false;
        }
        if (room == obj) {
            return true;
        }
        Room room2 = (Room) obj;
        return Objects.equal(room2.getRoomId(), room.getRoomId()) && Objects.equal(room2.getCreatorId(), room.getCreatorId()) && Objects.equal(Long.valueOf(room2.getCreationTimestamp()), Long.valueOf(room.getCreationTimestamp())) && Objects.equal(Integer.valueOf(room2.getStatus()), Integer.valueOf(room.getStatus())) && Objects.equal(room2.getDescription(), room.getDescription()) && Objects.equal(Integer.valueOf(room2.getVariant()), Integer.valueOf(room.getVariant())) && zzc.zza(room2.getAutoMatchCriteria(), room.getAutoMatchCriteria()) && Objects.equal(room2.getParticipants(), room.getParticipants()) && Objects.equal(Integer.valueOf(room2.getAutoMatchWaitEstimateSeconds()), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    public final String toString() {
        return zzb(this);
    }

    static String zzb(Room room) {
        return Objects.toStringHelper(room).add("RoomId", room.getRoomId()).add("CreatorId", room.getCreatorId()).add("CreationTimestamp", Long.valueOf(room.getCreationTimestamp())).add("RoomStatus", Integer.valueOf(room.getStatus())).add("Description", room.getDescription()).add("Variant", Integer.valueOf(room.getVariant())).add("AutoMatchCriteria", room.getAutoMatchCriteria()).add("Participants", room.getParticipants()).add("AutoMatchWaitEstimateSeconds", Integer.valueOf(room.getAutoMatchWaitEstimateSeconds())).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (!shouldDowngrade()) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 1, getRoomId(), false);
            SafeParcelWriter.writeString(parcel, 2, getCreatorId(), false);
            SafeParcelWriter.writeLong(parcel, 3, getCreationTimestamp());
            SafeParcelWriter.writeInt(parcel, 4, getStatus());
            SafeParcelWriter.writeString(parcel, 5, getDescription(), false);
            SafeParcelWriter.writeInt(parcel, 6, getVariant());
            SafeParcelWriter.writeBundle(parcel, 7, getAutoMatchCriteria(), false);
            SafeParcelWriter.writeTypedList(parcel, 8, getParticipants(), false);
            SafeParcelWriter.writeInt(parcel, 9, getAutoMatchWaitEstimateSeconds());
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
        parcel.writeString(this.zzqc);
        parcel.writeString(this.zzqd);
        parcel.writeLong(this.zzoz);
        parcel.writeInt(this.zzqe);
        parcel.writeString(this.description);
        parcel.writeInt(this.zzpd);
        parcel.writeBundle(this.zzpz);
        int size = this.zzpc.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            ((ParticipantEntity) this.zzpc.get(i2)).writeToParcel(parcel, i);
        }
    }

    static int zza(Room room, String str) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        String roomId = room.getRoomId();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 28 + String.valueOf(roomId).length());
        sb.append("Participant ");
        sb.append(str);
        sb.append(" is not in room ");
        sb.append(roomId);
        throw new IllegalStateException(sb.toString());
    }

    static ArrayList<String> zzc(Room room) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(((Participant) participants.get(i)).getParticipantId());
        }
        return arrayList;
    }

    static String zzb(Room room, String str) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            Player player = participant.getPlayer();
            if (player != null && player.getPlayerId().equals(str)) {
                return participant.getParticipantId();
            }
        }
        return null;
    }

    static Participant zzc(Room room, String str) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        String roomId = room.getRoomId();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 29 + String.valueOf(roomId).length());
        sb.append("Participant ");
        sb.append(str);
        sb.append(" is not in match ");
        sb.append(roomId);
        throw new IllegalStateException(sb.toString());
    }
}
