package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
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
import com.google.android.gms.common.util.RetainForClient;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.ArrayList;
import java.util.List;

@RetainForClient
@UsedByReflection("GamesClientImpl.java")
@Class(creator = "ParticipantEntityCreator")
@Reserved({1000})
public final class ParticipantEntity extends GamesDowngradeableSafeParcel implements Participant {
    public static final Creator<ParticipantEntity> CREATOR = new zza();
    @Field(getter = "getStatus", mo15151id = 5)
    private final int status;
    @Field(getter = "getIconImageUrl", mo15151id = 11)
    @Nullable
    private final String zzac;
    @Field(getter = "getHiResImageUrl", mo15151id = 12)
    @Nullable
    private final String zzad;
    @Field(getter = "getPlayer", mo15151id = 8)
    @Nullable
    private final PlayerEntity zzfj;
    @Field(getter = "getDisplayName", mo15151id = 2)
    private final String zzn;
    @Field(getter = "getParticipantId", mo15151id = 1)
    private final String zzpg;
    @Field(getter = "getClientAddress", mo15151id = 6)
    private final String zzph;
    @Field(getter = "isConnectedToRoom", mo15151id = 7)
    private final boolean zzpi;
    @Field(getter = "getCapabilities", mo15151id = 9)
    private final int zzpj;
    @Field(getter = "getResult", mo15151id = 10)
    @Nullable
    private final ParticipantResult zzpk;
    @Field(getter = "getIconImageUri", mo15151id = 3)
    @Nullable
    private final Uri zzr;
    @Field(getter = "getHiResImageUri", mo15151id = 4)
    @Nullable
    private final Uri zzs;

    static final class zza extends zzc {
        zza() {
        }

        public final ParticipantEntity zzf(Parcel parcel) {
            Uri uri;
            Uri uri2;
            if (ParticipantEntity.zzb(ParticipantEntity.getUnparcelClientVersion()) || ParticipantEntity.canUnparcelSafely(ParticipantEntity.class.getCanonicalName())) {
                Parcel parcel2 = parcel;
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            int readInt = parcel.readInt();
            String readString5 = parcel.readString();
            boolean z = true;
            boolean z2 = parcel.readInt() > 0;
            if (parcel.readInt() <= 0) {
                z = false;
            }
            PlayerEntity playerEntity = z ? (PlayerEntity) PlayerEntity.CREATOR.createFromParcel(parcel) : null;
            if (readString3 == null) {
                uri = null;
            } else {
                uri = Uri.parse(readString3);
            }
            if (readString4 == null) {
                uri2 = null;
            } else {
                uri2 = Uri.parse(readString4);
            }
            ParticipantEntity participantEntity = new ParticipantEntity(readString, readString2, uri, uri2, readInt, readString5, z2, playerEntity, 7, null, null, null);
            return participantEntity;
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }
    }

    public static ArrayList<ParticipantEntity> zza(@NonNull List<Participant> list) {
        ParticipantEntity participantEntity;
        ArrayList<ParticipantEntity> arrayList = new ArrayList<>(list.size());
        for (Participant participant : list) {
            if (participant instanceof ParticipantEntity) {
                participantEntity = (ParticipantEntity) participant;
            } else {
                participantEntity = new ParticipantEntity(participant);
            }
            arrayList.add(participantEntity);
        }
        return arrayList;
    }

    public final Participant freeze() {
        return this;
    }

    public final boolean isDataValid() {
        return true;
    }

    public ParticipantEntity(Participant participant) {
        PlayerEntity playerEntity;
        Player player = participant.getPlayer();
        if (player == null) {
            playerEntity = null;
        } else {
            playerEntity = new PlayerEntity(player);
        }
        this(participant, playerEntity);
    }

    private ParticipantEntity(Participant participant, @Nullable PlayerEntity playerEntity) {
        this.zzpg = participant.getParticipantId();
        this.zzn = participant.getDisplayName();
        this.zzr = participant.getIconImageUri();
        this.zzs = participant.getHiResImageUri();
        this.status = participant.getStatus();
        this.zzph = participant.zzdn();
        this.zzpi = participant.isConnectedToRoom();
        this.zzfj = playerEntity;
        this.zzpj = participant.getCapabilities();
        this.zzpk = participant.getResult();
        this.zzac = participant.getIconImageUrl();
        this.zzad = participant.getHiResImageUrl();
    }

    @Constructor
    ParticipantEntity(@Param(mo15154id = 1) String str, @Param(mo15154id = 2) String str2, @Param(mo15154id = 3) @Nullable Uri uri, @Param(mo15154id = 4) @Nullable Uri uri2, @Param(mo15154id = 5) int i, @Param(mo15154id = 6) String str3, @Param(mo15154id = 7) boolean z, @Param(mo15154id = 8) @Nullable PlayerEntity playerEntity, @Param(mo15154id = 9) int i2, @Param(mo15154id = 10) @Nullable ParticipantResult participantResult, @Param(mo15154id = 11) @Nullable String str4, @Param(mo15154id = 12) @Nullable String str5) {
        this.zzpg = str;
        this.zzn = str2;
        this.zzr = uri;
        this.zzs = uri2;
        this.status = i;
        this.zzph = str3;
        this.zzpi = z;
        this.zzfj = playerEntity;
        this.zzpj = i2;
        this.zzpk = participantResult;
        this.zzac = str4;
        this.zzad = str5;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String zzdn() {
        return this.zzph;
    }

    public final boolean isConnectedToRoom() {
        return this.zzpi;
    }

    public final String getDisplayName() {
        PlayerEntity playerEntity = this.zzfj;
        if (playerEntity == null) {
            return this.zzn;
        }
        return playerEntity.getDisplayName();
    }

    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        PlayerEntity playerEntity = this.zzfj;
        if (playerEntity == null) {
            String str = this.zzn;
            if (str == null) {
                charArrayBuffer.sizeCopied = 0;
            } else {
                DataUtils.copyStringToBuffer(str, charArrayBuffer);
            }
        } else {
            playerEntity.getDisplayName(charArrayBuffer);
        }
    }

    @Nullable
    public final Uri getIconImageUri() {
        PlayerEntity playerEntity = this.zzfj;
        if (playerEntity == null) {
            return this.zzr;
        }
        return playerEntity.getIconImageUri();
    }

    @Nullable
    public final String getIconImageUrl() {
        PlayerEntity playerEntity = this.zzfj;
        if (playerEntity == null) {
            return this.zzac;
        }
        return playerEntity.getIconImageUrl();
    }

    @Nullable
    public final Uri getHiResImageUri() {
        PlayerEntity playerEntity = this.zzfj;
        if (playerEntity == null) {
            return this.zzs;
        }
        return playerEntity.getHiResImageUri();
    }

    public final String getHiResImageUrl() {
        PlayerEntity playerEntity = this.zzfj;
        if (playerEntity == null) {
            return this.zzad;
        }
        return playerEntity.getHiResImageUrl();
    }

    public final String getParticipantId() {
        return this.zzpg;
    }

    public final Player getPlayer() {
        return this.zzfj;
    }

    public final ParticipantResult getResult() {
        return this.zzpk;
    }

    public final int getCapabilities() {
        return this.zzpj;
    }

    public final void setShouldDowngrade(boolean z) {
        super.setShouldDowngrade(z);
        PlayerEntity playerEntity = this.zzfj;
        if (playerEntity != null) {
            playerEntity.setShouldDowngrade(z);
        }
    }

    public final int hashCode() {
        return zza((Participant) this);
    }

    static int zza(Participant participant) {
        return Objects.hashCode(participant.getPlayer(), Integer.valueOf(participant.getStatus()), participant.zzdn(), Boolean.valueOf(participant.isConnectedToRoom()), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), Integer.valueOf(participant.getCapabilities()), participant.getResult(), participant.getParticipantId());
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    static boolean zza(Participant participant, Object obj) {
        if (!(obj instanceof Participant)) {
            return false;
        }
        if (participant == obj) {
            return true;
        }
        Participant participant2 = (Participant) obj;
        return Objects.equal(participant2.getPlayer(), participant.getPlayer()) && Objects.equal(Integer.valueOf(participant2.getStatus()), Integer.valueOf(participant.getStatus())) && Objects.equal(participant2.zzdn(), participant.zzdn()) && Objects.equal(Boolean.valueOf(participant2.isConnectedToRoom()), Boolean.valueOf(participant.isConnectedToRoom())) && Objects.equal(participant2.getDisplayName(), participant.getDisplayName()) && Objects.equal(participant2.getIconImageUri(), participant.getIconImageUri()) && Objects.equal(participant2.getHiResImageUri(), participant.getHiResImageUri()) && Objects.equal(Integer.valueOf(participant2.getCapabilities()), Integer.valueOf(participant.getCapabilities())) && Objects.equal(participant2.getResult(), participant.getResult()) && Objects.equal(participant2.getParticipantId(), participant.getParticipantId());
    }

    public final String toString() {
        return zzb(this);
    }

    static String zzb(Participant participant) {
        return Objects.toStringHelper(participant).add("ParticipantId", participant.getParticipantId()).add("Player", participant.getPlayer()).add("Status", Integer.valueOf(participant.getStatus())).add("ClientAddress", participant.zzdn()).add("ConnectedToRoom", Boolean.valueOf(participant.isConnectedToRoom())).add("DisplayName", participant.getDisplayName()).add("IconImage", participant.getIconImageUri()).add("IconImageUrl", participant.getIconImageUrl()).add("HiResImage", participant.getHiResImageUri()).add("HiResImageUrl", participant.getHiResImageUrl()).add("Capabilities", Integer.valueOf(participant.getCapabilities())).add("Result", participant.getResult()).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (!shouldDowngrade()) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 1, getParticipantId(), false);
            SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
            SafeParcelWriter.writeParcelable(parcel, 3, getIconImageUri(), i, false);
            SafeParcelWriter.writeParcelable(parcel, 4, getHiResImageUri(), i, false);
            SafeParcelWriter.writeInt(parcel, 5, getStatus());
            SafeParcelWriter.writeString(parcel, 6, this.zzph, false);
            SafeParcelWriter.writeBoolean(parcel, 7, isConnectedToRoom());
            SafeParcelWriter.writeParcelable(parcel, 8, getPlayer(), i, false);
            SafeParcelWriter.writeInt(parcel, 9, this.zzpj);
            SafeParcelWriter.writeParcelable(parcel, 10, getResult(), i, false);
            SafeParcelWriter.writeString(parcel, 11, getIconImageUrl(), false);
            SafeParcelWriter.writeString(parcel, 12, getHiResImageUrl(), false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
        parcel.writeString(this.zzpg);
        parcel.writeString(this.zzn);
        Uri uri = this.zzr;
        String str = null;
        parcel.writeString(uri == null ? null : uri.toString());
        Uri uri2 = this.zzs;
        if (uri2 != null) {
            str = uri2.toString();
        }
        parcel.writeString(str);
        parcel.writeInt(this.status);
        parcel.writeString(this.zzph);
        parcel.writeInt(this.zzpi ? 1 : 0);
        if (this.zzfj == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        this.zzfj.writeToParcel(parcel, i);
    }
}
