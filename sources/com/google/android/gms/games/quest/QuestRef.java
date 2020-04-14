package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.List;

@VisibleForTesting
public final class QuestRef extends DataBufferRef implements Quest {
    private final Game zznw;
    private final int zznx;

    QuestRef(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zznw = new GameRef(dataHolder, i);
        this.zznx = i2;
    }

    public final int describeContents() {
        return 0;
    }

    public final String getQuestId() {
        return getString("external_quest_id");
    }

    public final String getName() {
        return getString("quest_name");
    }

    public final void getName(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("quest_name", charArrayBuffer);
    }

    public final String getDescription() {
        return getString("quest_description");
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("quest_description", charArrayBuffer);
    }

    public final Uri getIconImageUri() {
        return parseUri("quest_icon_image_uri");
    }

    public final String getIconImageUrl() {
        return getString("quest_icon_image_url");
    }

    public final Uri getBannerImageUri() {
        return parseUri("quest_banner_image_uri");
    }

    public final String getBannerImageUrl() {
        return getString("quest_banner_image_url");
    }

    public final Milestone getCurrentMilestone() {
        return (Milestone) zzdq().get(0);
    }

    public final List<Milestone> zzdq() {
        ArrayList arrayList = new ArrayList(this.zznx);
        for (int i = 0; i < this.zznx; i++) {
            arrayList.add(new zzb(this.mDataHolder, this.mDataRow + i));
        }
        return arrayList;
    }

    public final Game getGame() {
        return this.zznw;
    }

    public final int getState() {
        return getInteger("quest_state");
    }

    public final int getType() {
        return getInteger("quest_type");
    }

    public final long getAcceptedTimestamp() {
        return getLong("accepted_ts");
    }

    public final long getEndTimestamp() {
        return getLong("quest_end_ts");
    }

    public final long getLastUpdatedTimestamp() {
        return getLong("quest_last_updated_ts");
    }

    public final long zzdr() {
        return getLong("notification_ts");
    }

    public final long getStartTimestamp() {
        return getLong("quest_start_ts");
    }

    public final boolean isEndingSoon() {
        return getLong("notification_ts") <= System.currentTimeMillis() + TapjoyConstants.SESSION_ID_INACTIVITY_TIME;
    }

    public final int hashCode() {
        return QuestEntity.zza(this);
    }

    public final boolean equals(Object obj) {
        return QuestEntity.zza(this, obj);
    }

    public final String toString() {
        return QuestEntity.zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((QuestEntity) ((Quest) freeze())).writeToParcel(parcel, i);
    }

    public final /* synthetic */ Object freeze() {
        return new QuestEntity(this);
    }
}
