package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import androidx.annotation.Nullable;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class AchievementRef extends DataBufferRef implements Achievement {
    AchievementRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final int describeContents() {
        return 0;
    }

    public final String getAchievementId() {
        return getString("external_achievement_id");
    }

    public final String getApplicationId() {
        return getString("external_game_id");
    }

    public final int getType() {
        return getInteger("type");
    }

    public final String getName() {
        return getString("name");
    }

    public final void getName(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("name", charArrayBuffer);
    }

    public final String getDescription() {
        return getString("description");
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("description", charArrayBuffer);
    }

    public final Uri getUnlockedImageUri() {
        return parseUri("unlocked_icon_image_uri");
    }

    public final String getUnlockedImageUrl() {
        return getString("unlocked_icon_image_url");
    }

    public final Uri getRevealedImageUri() {
        return parseUri("revealed_icon_image_uri");
    }

    public final String getRevealedImageUrl() {
        return getString("revealed_icon_image_url");
    }

    public final int getTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return getInteger("total_steps");
    }

    public final String getFormattedTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return getString("formatted_total_steps");
    }

    public final void getFormattedTotalSteps(CharArrayBuffer charArrayBuffer) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        copyToBuffer("formatted_total_steps", charArrayBuffer);
    }

    public final Player getPlayer() {
        return (Player) Preconditions.checkNotNull(zzw());
    }

    @Nullable
    public final Player zzw() {
        if (hasNull("external_player_id")) {
            return null;
        }
        return new PlayerRef(this.mDataHolder, this.mDataRow);
    }

    public final int getState() {
        return getInteger(ServerProtocol.DIALOG_PARAM_STATE);
    }

    public final int getCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return getInteger("current_steps");
    }

    public final String getFormattedCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        return getString("formatted_current_steps");
    }

    public final void getFormattedCurrentSteps(CharArrayBuffer charArrayBuffer) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        Asserts.checkState(z);
        copyToBuffer("formatted_current_steps", charArrayBuffer);
    }

    public final long getLastUpdatedTimestamp() {
        return getLong("last_updated_timestamp");
    }

    public final long getXpValue() {
        String str = "instance_xp_value";
        if (!hasColumn(str) || hasNull(str)) {
            return getLong("definition_xp_value");
        }
        return getLong(str);
    }

    public final float zzx() {
        String str = "rarity_percent";
        if (!hasColumn(str) || hasNull(str)) {
            return -1.0f;
        }
        return getFloat(str);
    }

    public final String toString() {
        return AchievementEntity.zza(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((AchievementEntity) ((Achievement) freeze())).writeToParcel(parcel, i);
    }

    public final /* synthetic */ Object freeze() {
        return new AchievementEntity(this);
    }
}
