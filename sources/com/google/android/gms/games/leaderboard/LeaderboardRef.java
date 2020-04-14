package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

public final class LeaderboardRef extends DataBufferRef implements Leaderboard {
    private final Game zznw;
    private final int zznx;

    LeaderboardRef(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zznx = i2;
        this.zznw = new GameRef(dataHolder, i);
    }

    public final String getLeaderboardId() {
        return getString("external_leaderboard_id");
    }

    public final String getDisplayName() {
        return getString("name");
    }

    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("name", charArrayBuffer);
    }

    public final Uri getIconImageUri() {
        return parseUri("board_icon_image_uri");
    }

    public final String getIconImageUrl() {
        return getString("board_icon_image_url");
    }

    public final int getScoreOrder() {
        return getInteger("score_order");
    }

    public final ArrayList<LeaderboardVariant> getVariants() {
        ArrayList<LeaderboardVariant> arrayList = new ArrayList<>(this.zznx);
        for (int i = 0; i < this.zznx; i++) {
            arrayList.add(new zzb(this.mDataHolder, this.mDataRow + i));
        }
        return arrayList;
    }

    public final Game getGame() {
        return this.zznw;
    }

    public final int hashCode() {
        return LeaderboardEntity.zza(this);
    }

    public final boolean equals(Object obj) {
        return LeaderboardEntity.zza(this, obj);
    }

    public final String toString() {
        return LeaderboardEntity.zzb(this);
    }

    public final /* synthetic */ Object freeze() {
        return new LeaderboardEntity(this);
    }
}
