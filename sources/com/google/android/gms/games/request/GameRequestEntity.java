package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@UsedByReflection("GamesClientImpl.java")
@Class(creator = "GameRequestEntityCreator")
@Reserved({1000})
@Deprecated
public final class GameRequestEntity extends zzd implements GameRequest {
    public static final Creator<GameRequestEntity> CREATOR = new zza();
    @Field(getter = "getData", mo15151id = 3)
    private final byte[] data;
    @Field(getter = "getStatus", mo15151id = 12)
    private final int status;
    @Field(getter = "getType", mo15151id = 7)
    private final int type;
    @Field(getter = "getGame", mo15151id = 1)
    private final GameEntity zzlp;
    @Field(getter = "getCreationTimestamp", mo15151id = 9)
    private final long zzoz;
    @Field(getter = "getSender", mo15151id = 2)
    private final PlayerEntity zzrk;
    @Field(getter = "getRequestId", mo15151id = 4)
    private final String zzrl;
    @Field(getter = "getRecipients", mo15151id = 5)
    private final ArrayList<PlayerEntity> zzrm;
    @Field(getter = "getExpirationTimestamp", mo15151id = 10)
    private final long zzrn;
    @Field(getter = "getRecipientStatusBundle", mo15151id = 11)
    private final Bundle zzro;

    public GameRequestEntity(GameRequest gameRequest) {
        this.zzlp = new GameEntity(gameRequest.getGame());
        this.zzrk = new PlayerEntity(gameRequest.getSender());
        this.zzrl = gameRequest.getRequestId();
        this.type = gameRequest.getType();
        this.zzoz = gameRequest.getCreationTimestamp();
        this.zzrn = gameRequest.getExpirationTimestamp();
        this.status = gameRequest.getStatus();
        byte[] data2 = gameRequest.getData();
        if (data2 == null) {
            this.data = null;
        } else {
            this.data = new byte[data2.length];
            System.arraycopy(data2, 0, this.data, 0, data2.length);
        }
        List recipients = gameRequest.getRecipients();
        int size = recipients.size();
        this.zzrm = new ArrayList<>(size);
        this.zzro = new Bundle();
        for (int i = 0; i < size; i++) {
            Player player = (Player) ((Player) recipients.get(i)).freeze();
            String playerId = player.getPlayerId();
            this.zzrm.add((PlayerEntity) player);
            this.zzro.putInt(playerId, gameRequest.getRecipientStatus(playerId));
        }
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final boolean isDataValid() {
        return true;
    }

    @Constructor
    GameRequestEntity(@Param(mo15154id = 1) GameEntity gameEntity, @Param(mo15154id = 2) PlayerEntity playerEntity, @Param(mo15154id = 3) byte[] bArr, @Param(mo15154id = 4) String str, @Param(mo15154id = 5) ArrayList<PlayerEntity> arrayList, @Param(mo15154id = 7) int i, @Param(mo15154id = 9) long j, @Param(mo15154id = 10) long j2, @Param(mo15154id = 11) Bundle bundle, @Param(mo15154id = 12) int i2) {
        this.zzlp = gameEntity;
        this.zzrk = playerEntity;
        this.data = bArr;
        this.zzrl = str;
        this.zzrm = arrayList;
        this.type = i;
        this.zzoz = j;
        this.zzrn = j2;
        this.zzro = bundle;
        this.status = i2;
    }

    public final String getRequestId() {
        return this.zzrl;
    }

    public final Game getGame() {
        return this.zzlp;
    }

    public final Player getSender() {
        return this.zzrk;
    }

    public final List<Player> getRecipients() {
        return new ArrayList(this.zzrm);
    }

    public final boolean isConsumed(String str) {
        return getRecipientStatus(str) == 1;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final int getType() {
        return this.type;
    }

    public final long getCreationTimestamp() {
        return this.zzoz;
    }

    public final long getExpirationTimestamp() {
        return this.zzrn;
    }

    public final int getRecipientStatus(String str) {
        return this.zzro.getInt(str, 0);
    }

    public final int getStatus() {
        return this.status;
    }

    public final int hashCode() {
        return zza(this);
    }

    static int zza(GameRequest gameRequest) {
        return (Arrays.hashCode(zzb(gameRequest)) * 31) + Objects.hashCode(gameRequest.getGame(), gameRequest.getRecipients(), gameRequest.getRequestId(), gameRequest.getSender(), Integer.valueOf(gameRequest.getType()), Long.valueOf(gameRequest.getCreationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    static boolean zza(GameRequest gameRequest, Object obj) {
        if (!(obj instanceof GameRequest)) {
            return false;
        }
        if (gameRequest == obj) {
            return true;
        }
        GameRequest gameRequest2 = (GameRequest) obj;
        return Objects.equal(gameRequest2.getGame(), gameRequest.getGame()) && Objects.equal(gameRequest2.getRecipients(), gameRequest.getRecipients()) && Objects.equal(gameRequest2.getRequestId(), gameRequest.getRequestId()) && Objects.equal(gameRequest2.getSender(), gameRequest.getSender()) && Arrays.equals(zzb(gameRequest2), zzb(gameRequest)) && Objects.equal(Integer.valueOf(gameRequest2.getType()), Integer.valueOf(gameRequest.getType())) && Objects.equal(Long.valueOf(gameRequest2.getCreationTimestamp()), Long.valueOf(gameRequest.getCreationTimestamp())) && Objects.equal(Long.valueOf(gameRequest2.getExpirationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    private static int[] zzb(GameRequest gameRequest) {
        List recipients = gameRequest.getRecipients();
        int size = recipients.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = gameRequest.getRecipientStatus(((Player) recipients.get(i)).getPlayerId());
        }
        return iArr;
    }

    public final String toString() {
        return zzc(this);
    }

    static String zzc(GameRequest gameRequest) {
        String str = "Sender";
        String str2 = "Recipients";
        String str3 = "Data";
        String str4 = "RequestId";
        String str5 = "Type";
        String str6 = "CreationTimestamp";
        return Objects.toStringHelper(gameRequest).add("Game", gameRequest.getGame()).add(str, gameRequest.getSender()).add(str2, gameRequest.getRecipients()).add(str3, gameRequest.getData()).add(str4, gameRequest.getRequestId()).add(str5, Integer.valueOf(gameRequest.getType())).add(str6, Long.valueOf(gameRequest.getCreationTimestamp())).add("ExpirationTimestamp", Long.valueOf(gameRequest.getExpirationTimestamp())).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getGame(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getSender(), i, false);
        SafeParcelWriter.writeByteArray(parcel, 3, getData(), false);
        SafeParcelWriter.writeString(parcel, 4, getRequestId(), false);
        SafeParcelWriter.writeTypedList(parcel, 5, getRecipients(), false);
        SafeParcelWriter.writeInt(parcel, 7, getType());
        SafeParcelWriter.writeLong(parcel, 9, getCreationTimestamp());
        SafeParcelWriter.writeLong(parcel, 10, getExpirationTimestamp());
        SafeParcelWriter.writeBundle(parcel, 11, this.zzro, false);
        SafeParcelWriter.writeInt(parcel, 12, getStatus());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
