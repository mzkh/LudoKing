package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
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
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.zzc;
import com.google.android.gms.games.internal.zzd;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;
import java.util.List;

@UsedByReflection("GamesClientImpl.java")
@Class(creator = "TurnBasedMatchEntityCreator")
@Reserved({1000})
public final class TurnBasedMatchEntity extends zzd implements TurnBasedMatch {
    public static final Creator<TurnBasedMatchEntity> CREATOR = new zzc();
    @Field(getter = "getData", mo15151id = 12)
    private final byte[] data;
    @Field(getter = "getDescription", mo15151id = 20)
    private final String description;
    @Field(getter = "getVersion", mo15151id = 11)
    private final int version;
    @Field(getter = "getLastUpdatedTimestamp", mo15151id = 6)
    private final long zzfm;
    @Field(getter = "getGame", mo15151id = 1)
    private final GameEntity zzlp;
    @Field(getter = "getCreationTimestamp", mo15151id = 4)
    private final long zzoz;
    @Field(getter = "getParticipants", mo15151id = 13)
    private final ArrayList<ParticipantEntity> zzpc;
    @Field(getter = "getVariant", mo15151id = 10)
    private final int zzpd;
    @Field(getter = "getAutoMatchCriteria", mo15151id = 17)
    @Nullable
    private final Bundle zzpz;
    @Field(getter = "getCreatorId", mo15151id = 3)
    private final String zzqd;
    @Field(getter = "getMatchId", mo15151id = 2)
    private final String zzqm;
    @Field(getter = "getLastUpdaterId", mo15151id = 5)
    private final String zzqn;
    @Field(getter = "getPendingParticipantId", mo15151id = 7)
    private final String zzqo;
    @Field(getter = "getStatus", mo15151id = 8)
    private final int zzqp;
    @Field(getter = "getRematchId", mo15151id = 14)
    private final String zzqq;
    @Field(getter = "getPreviousMatchData", mo15151id = 15)
    private final byte[] zzqr;
    @Field(getter = "getMatchNumber", mo15151id = 16)
    private final int zzqs;
    @Field(getter = "getTurnStatus", mo15151id = 18)
    private final int zzqt;
    @Field(getter = "isLocallyModified", mo15151id = 19)
    private final boolean zzqu;
    @Field(getter = "getDescriptionParticipantId", mo15151id = 21)
    private final String zzqv;

    public TurnBasedMatchEntity(@NonNull TurnBasedMatch turnBasedMatch) {
        this(turnBasedMatch, ParticipantEntity.zza((List<Participant>) turnBasedMatch.getParticipants()));
    }

    public final TurnBasedMatch freeze() {
        return this;
    }

    public final boolean isDataValid() {
        return true;
    }

    private TurnBasedMatchEntity(@NonNull TurnBasedMatch turnBasedMatch, @NonNull ArrayList<ParticipantEntity> arrayList) {
        this.zzlp = new GameEntity(turnBasedMatch.getGame());
        this.zzqm = turnBasedMatch.getMatchId();
        this.zzqd = turnBasedMatch.getCreatorId();
        this.zzoz = turnBasedMatch.getCreationTimestamp();
        this.zzqn = turnBasedMatch.getLastUpdaterId();
        this.zzfm = turnBasedMatch.getLastUpdatedTimestamp();
        this.zzqo = turnBasedMatch.getPendingParticipantId();
        this.zzqp = turnBasedMatch.getStatus();
        this.zzqt = turnBasedMatch.getTurnStatus();
        this.zzpd = turnBasedMatch.getVariant();
        this.version = turnBasedMatch.getVersion();
        this.zzqq = turnBasedMatch.getRematchId();
        this.zzqs = turnBasedMatch.getMatchNumber();
        this.zzpz = turnBasedMatch.getAutoMatchCriteria();
        this.zzqu = turnBasedMatch.isLocallyModified();
        this.description = turnBasedMatch.getDescription();
        this.zzqv = turnBasedMatch.getDescriptionParticipantId();
        byte[] data2 = turnBasedMatch.getData();
        if (data2 == null) {
            this.data = null;
        } else {
            this.data = new byte[data2.length];
            System.arraycopy(data2, 0, this.data, 0, data2.length);
        }
        byte[] previousMatchData = turnBasedMatch.getPreviousMatchData();
        if (previousMatchData == null) {
            this.zzqr = null;
        } else {
            this.zzqr = new byte[previousMatchData.length];
            System.arraycopy(previousMatchData, 0, this.zzqr, 0, previousMatchData.length);
        }
        this.zzpc = arrayList;
    }

    @Constructor
    TurnBasedMatchEntity(@Param(mo15154id = 1) GameEntity gameEntity, @Param(mo15154id = 2) String str, @Param(mo15154id = 3) String str2, @Param(mo15154id = 4) long j, @Param(mo15154id = 5) String str3, @Param(mo15154id = 6) long j2, @Param(mo15154id = 7) String str4, @Param(mo15154id = 8) int i, @Param(mo15154id = 10) int i2, @Param(mo15154id = 11) int i3, @Param(mo15154id = 12) byte[] bArr, @Param(mo15154id = 13) ArrayList<ParticipantEntity> arrayList, @Param(mo15154id = 14) String str5, @Param(mo15154id = 15) byte[] bArr2, @Param(mo15154id = 16) int i4, @Param(mo15154id = 17) @Nullable Bundle bundle, @Param(mo15154id = 18) int i5, @Param(mo15154id = 19) boolean z, @Param(mo15154id = 20) String str6, @Param(mo15154id = 21) String str7) {
        this.zzlp = gameEntity;
        this.zzqm = str;
        this.zzqd = str2;
        this.zzoz = j;
        this.zzqn = str3;
        this.zzfm = j2;
        this.zzqo = str4;
        this.zzqp = i;
        this.zzqt = i5;
        this.zzpd = i2;
        this.version = i3;
        this.data = bArr;
        this.zzpc = arrayList;
        this.zzqq = str5;
        this.zzqr = bArr2;
        this.zzqs = i4;
        this.zzpz = bundle;
        this.zzqu = z;
        this.description = str6;
        this.zzqv = str7;
    }

    public final Game getGame() {
        return this.zzlp;
    }

    public final String getMatchId() {
        return this.zzqm;
    }

    public final String getCreatorId() {
        return this.zzqd;
    }

    public final long getCreationTimestamp() {
        return this.zzoz;
    }

    public final String getLastUpdaterId() {
        return this.zzqn;
    }

    public final long getLastUpdatedTimestamp() {
        return this.zzfm;
    }

    public final String getPendingParticipantId() {
        return this.zzqo;
    }

    public final int getStatus() {
        return this.zzqp;
    }

    public final int getTurnStatus() {
        return this.zzqt;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDescriptionParticipantId() {
        return this.zzqv;
    }

    public final Participant getDescriptionParticipant() {
        String descriptionParticipantId = getDescriptionParticipantId();
        if (descriptionParticipantId == null) {
            return null;
        }
        return getParticipant(descriptionParticipantId);
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.description, charArrayBuffer);
    }

    public final int getVariant() {
        return this.zzpd;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final int getVersion() {
        return this.version;
    }

    public final String getRematchId() {
        return this.zzqq;
    }

    public final byte[] getPreviousMatchData() {
        return this.zzqr;
    }

    public final int getMatchNumber() {
        return this.zzqs;
    }

    @Nullable
    public final Bundle getAutoMatchCriteria() {
        return this.zzpz;
    }

    public final int getAvailableAutoMatchSlots() {
        Bundle bundle = this.zzpz;
        if (bundle == null) {
            return 0;
        }
        return bundle.getInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS);
    }

    public final boolean canRematch() {
        return this.zzqp == 2 && this.zzqq == null;
    }

    public final boolean isLocallyModified() {
        return this.zzqu;
    }

    public final int getParticipantStatus(String str) {
        return zza((TurnBasedMatch) this, str);
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

    public final ArrayList<Participant> getParticipants() {
        return new ArrayList<>(this.zzpc);
    }

    public final int hashCode() {
        return zza(this);
    }

    static int zza(TurnBasedMatch turnBasedMatch) {
        return Objects.hashCode(turnBasedMatch.getGame(), turnBasedMatch.getMatchId(), turnBasedMatch.getCreatorId(), Long.valueOf(turnBasedMatch.getCreationTimestamp()), turnBasedMatch.getLastUpdaterId(), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp()), turnBasedMatch.getPendingParticipantId(), Integer.valueOf(turnBasedMatch.getStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus()), turnBasedMatch.getDescription(), Integer.valueOf(turnBasedMatch.getVariant()), Integer.valueOf(turnBasedMatch.getVersion()), turnBasedMatch.getParticipants(), turnBasedMatch.getRematchId(), Integer.valueOf(turnBasedMatch.getMatchNumber()), Integer.valueOf(zzc.zza(turnBasedMatch.getAutoMatchCriteria())), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    public final boolean equals(Object obj) {
        return zza((TurnBasedMatch) this, obj);
    }

    static boolean zza(TurnBasedMatch turnBasedMatch, Object obj) {
        if (!(obj instanceof TurnBasedMatch)) {
            return false;
        }
        if (turnBasedMatch == obj) {
            return true;
        }
        TurnBasedMatch turnBasedMatch2 = (TurnBasedMatch) obj;
        return Objects.equal(turnBasedMatch2.getGame(), turnBasedMatch.getGame()) && Objects.equal(turnBasedMatch2.getMatchId(), turnBasedMatch.getMatchId()) && Objects.equal(turnBasedMatch2.getCreatorId(), turnBasedMatch.getCreatorId()) && Objects.equal(Long.valueOf(turnBasedMatch2.getCreationTimestamp()), Long.valueOf(turnBasedMatch.getCreationTimestamp())) && Objects.equal(turnBasedMatch2.getLastUpdaterId(), turnBasedMatch.getLastUpdaterId()) && Objects.equal(Long.valueOf(turnBasedMatch2.getLastUpdatedTimestamp()), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())) && Objects.equal(turnBasedMatch2.getPendingParticipantId(), turnBasedMatch.getPendingParticipantId()) && Objects.equal(Integer.valueOf(turnBasedMatch2.getStatus()), Integer.valueOf(turnBasedMatch.getStatus())) && Objects.equal(Integer.valueOf(turnBasedMatch2.getTurnStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus())) && Objects.equal(turnBasedMatch2.getDescription(), turnBasedMatch.getDescription()) && Objects.equal(Integer.valueOf(turnBasedMatch2.getVariant()), Integer.valueOf(turnBasedMatch.getVariant())) && Objects.equal(Integer.valueOf(turnBasedMatch2.getVersion()), Integer.valueOf(turnBasedMatch.getVersion())) && Objects.equal(turnBasedMatch2.getParticipants(), turnBasedMatch.getParticipants()) && Objects.equal(turnBasedMatch2.getRematchId(), turnBasedMatch.getRematchId()) && Objects.equal(Integer.valueOf(turnBasedMatch2.getMatchNumber()), Integer.valueOf(turnBasedMatch.getMatchNumber())) && zzc.zza(turnBasedMatch2.getAutoMatchCriteria(), turnBasedMatch.getAutoMatchCriteria()) && Objects.equal(Integer.valueOf(turnBasedMatch2.getAvailableAutoMatchSlots()), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())) && Objects.equal(Boolean.valueOf(turnBasedMatch2.isLocallyModified()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    public final String toString() {
        return zzb(this);
    }

    static String zzb(TurnBasedMatch turnBasedMatch) {
        return Objects.toStringHelper(turnBasedMatch).add("Game", turnBasedMatch.getGame()).add("MatchId", turnBasedMatch.getMatchId()).add("CreatorId", turnBasedMatch.getCreatorId()).add("CreationTimestamp", Long.valueOf(turnBasedMatch.getCreationTimestamp())).add("LastUpdaterId", turnBasedMatch.getLastUpdaterId()).add("LastUpdatedTimestamp", Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())).add("PendingParticipantId", turnBasedMatch.getPendingParticipantId()).add("MatchStatus", Integer.valueOf(turnBasedMatch.getStatus())).add("TurnStatus", Integer.valueOf(turnBasedMatch.getTurnStatus())).add("Description", turnBasedMatch.getDescription()).add("Variant", Integer.valueOf(turnBasedMatch.getVariant())).add("Data", turnBasedMatch.getData()).add("Version", Integer.valueOf(turnBasedMatch.getVersion())).add("Participants", turnBasedMatch.getParticipants()).add("RematchId", turnBasedMatch.getRematchId()).add("PreviousData", turnBasedMatch.getPreviousMatchData()).add("MatchNumber", Integer.valueOf(turnBasedMatch.getMatchNumber())).add("AutoMatchCriteria", turnBasedMatch.getAutoMatchCriteria()).add("AvailableAutoMatchSlots", Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())).add("LocallyModified", Boolean.valueOf(turnBasedMatch.isLocallyModified())).add("DescriptionParticipantId", turnBasedMatch.getDescriptionParticipantId()).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getGame(), i, false);
        SafeParcelWriter.writeString(parcel, 2, getMatchId(), false);
        SafeParcelWriter.writeString(parcel, 3, getCreatorId(), false);
        SafeParcelWriter.writeLong(parcel, 4, getCreationTimestamp());
        SafeParcelWriter.writeString(parcel, 5, getLastUpdaterId(), false);
        SafeParcelWriter.writeLong(parcel, 6, getLastUpdatedTimestamp());
        SafeParcelWriter.writeString(parcel, 7, getPendingParticipantId(), false);
        SafeParcelWriter.writeInt(parcel, 8, getStatus());
        SafeParcelWriter.writeInt(parcel, 10, getVariant());
        SafeParcelWriter.writeInt(parcel, 11, getVersion());
        SafeParcelWriter.writeByteArray(parcel, 12, getData(), false);
        SafeParcelWriter.writeTypedList(parcel, 13, getParticipants(), false);
        SafeParcelWriter.writeString(parcel, 14, getRematchId(), false);
        SafeParcelWriter.writeByteArray(parcel, 15, getPreviousMatchData(), false);
        SafeParcelWriter.writeInt(parcel, 16, getMatchNumber());
        SafeParcelWriter.writeBundle(parcel, 17, getAutoMatchCriteria(), false);
        SafeParcelWriter.writeInt(parcel, 18, getTurnStatus());
        SafeParcelWriter.writeBoolean(parcel, 19, isLocallyModified());
        SafeParcelWriter.writeString(parcel, 20, getDescription(), false);
        SafeParcelWriter.writeString(parcel, 21, getDescriptionParticipantId(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    static int zza(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        String matchId = turnBasedMatch.getMatchId();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 29 + String.valueOf(matchId).length());
        sb.append("Participant ");
        sb.append(str);
        sb.append(" is not in match ");
        sb.append(matchId);
        throw new IllegalStateException(sb.toString());
    }

    static ArrayList<String> zzc(TurnBasedMatch turnBasedMatch) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(((Participant) participants.get(i)).getParticipantId());
        }
        return arrayList;
    }

    static String zzb(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
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

    static Participant zzc(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        String matchId = turnBasedMatch.getMatchId();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 29 + String.valueOf(matchId).length());
        sb.append("Participant ");
        sb.append(str);
        sb.append(" is not in match ");
        sb.append(matchId);
        throw new IllegalStateException(sb.toString());
    }
}
