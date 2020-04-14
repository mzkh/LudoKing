package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
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
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzd;

@UsedByReflection("GamesClientImpl.java")
@Class(creator = "EventEntityCreator")
@Reserved({1000})
public final class EventEntity extends zzd implements Event {
    public static final Creator<EventEntity> CREATOR = new zza();
    @Field(getter = "getDescription", mo15151id = 3)
    private final String description;
    @Field(getter = "getName", mo15151id = 2)
    private final String name;
    @Field(getter = "getValue", mo15151id = 7)
    private final long value;
    @Field(getter = "getIconImageUrl", mo15151id = 5)
    private final String zzac;
    @Field(getter = "getPlayer", mo15151id = 6)
    private final PlayerEntity zzfj;
    @Field(getter = "getEventId", mo15151id = 1)
    private final String zzgl;
    @Field(getter = "getFormattedValue", mo15151id = 8)
    private final String zzgm;
    @Field(getter = "isVisible", mo15151id = 9)
    private final boolean zzgn;
    @Field(getter = "getIconImageUri", mo15151id = 4)
    private final Uri zzr;

    public EventEntity(Event event) {
        this.zzgl = event.getEventId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.zzr = event.getIconImageUri();
        this.zzac = event.getIconImageUrl();
        this.zzfj = (PlayerEntity) event.getPlayer().freeze();
        this.value = event.getValue();
        this.zzgm = event.getFormattedValue();
        this.zzgn = event.isVisible();
    }

    public final Event freeze() {
        return this;
    }

    public final boolean isDataValid() {
        return true;
    }

    @Constructor
    EventEntity(@Param(mo15154id = 1) String str, @Param(mo15154id = 2) String str2, @Param(mo15154id = 3) String str3, @Param(mo15154id = 4) Uri uri, @Param(mo15154id = 5) String str4, @Param(mo15154id = 6) Player player, @Param(mo15154id = 7) long j, @Param(mo15154id = 8) String str5, @Param(mo15154id = 9) boolean z) {
        this.zzgl = str;
        this.name = str2;
        this.description = str3;
        this.zzr = uri;
        this.zzac = str4;
        this.zzfj = new PlayerEntity(player);
        this.value = j;
        this.zzgm = str5;
        this.zzgn = z;
    }

    public final String getEventId() {
        return this.zzgl;
    }

    public final String getName() {
        return this.name;
    }

    public final void getName(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.name, charArrayBuffer);
    }

    public final String getDescription() {
        return this.description;
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.description, charArrayBuffer);
    }

    public final Uri getIconImageUri() {
        return this.zzr;
    }

    public final String getIconImageUrl() {
        return this.zzac;
    }

    public final Player getPlayer() {
        return this.zzfj;
    }

    public final long getValue() {
        return this.value;
    }

    public final String getFormattedValue() {
        return this.zzgm;
    }

    public final void getFormattedValue(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzgm, charArrayBuffer);
    }

    public final boolean isVisible() {
        return this.zzgn;
    }

    public final int hashCode() {
        return zza(this);
    }

    static int zza(Event event) {
        return Objects.hashCode(event.getEventId(), event.getName(), event.getDescription(), event.getIconImageUri(), event.getIconImageUrl(), event.getPlayer(), Long.valueOf(event.getValue()), event.getFormattedValue(), Boolean.valueOf(event.isVisible()));
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    static boolean zza(Event event, Object obj) {
        if (!(obj instanceof Event)) {
            return false;
        }
        if (event == obj) {
            return true;
        }
        Event event2 = (Event) obj;
        return Objects.equal(event2.getEventId(), event.getEventId()) && Objects.equal(event2.getName(), event.getName()) && Objects.equal(event2.getDescription(), event.getDescription()) && Objects.equal(event2.getIconImageUri(), event.getIconImageUri()) && Objects.equal(event2.getIconImageUrl(), event.getIconImageUrl()) && Objects.equal(event2.getPlayer(), event.getPlayer()) && Objects.equal(Long.valueOf(event2.getValue()), Long.valueOf(event.getValue())) && Objects.equal(event2.getFormattedValue(), event.getFormattedValue()) && Objects.equal(Boolean.valueOf(event2.isVisible()), Boolean.valueOf(event.isVisible()));
    }

    public final String toString() {
        return zzb(this);
    }

    static String zzb(Event event) {
        return Objects.toStringHelper(event).add("Id", event.getEventId()).add("Name", event.getName()).add("Description", event.getDescription()).add("IconImageUri", event.getIconImageUri()).add("IconImageUrl", event.getIconImageUrl()).add("Player", event.getPlayer()).add("Value", Long.valueOf(event.getValue())).add("FormattedValue", event.getFormattedValue()).add("isVisible", Boolean.valueOf(event.isVisible())).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getEventId(), false);
        SafeParcelWriter.writeString(parcel, 2, getName(), false);
        SafeParcelWriter.writeString(parcel, 3, getDescription(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, getIconImageUri(), i, false);
        SafeParcelWriter.writeString(parcel, 5, getIconImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, getPlayer(), i, false);
        SafeParcelWriter.writeLong(parcel, 7, getValue());
        SafeParcelWriter.writeString(parcel, 8, getFormattedValue(), false);
        SafeParcelWriter.writeBoolean(parcel, 9, isVisible());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
