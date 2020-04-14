package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.tapjoy.TapjoyConstants;

public final class SnapshotMetadataRef extends DataBufferRef implements SnapshotMetadata {
    private final Game zznw;
    private final Player zzsh;

    public SnapshotMetadataRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.zznw = new GameRef(dataHolder, i);
        this.zzsh = new PlayerRef(dataHolder, i);
    }

    public final int describeContents() {
        return 0;
    }

    public final Game getGame() {
        return this.zznw;
    }

    public final Player getOwner() {
        return this.zzsh;
    }

    public final String getSnapshotId() {
        return getString("external_snapshot_id");
    }

    public final Uri getCoverImageUri() {
        return parseUri("cover_icon_image_uri");
    }

    public final String getCoverImageUrl() {
        return getString("cover_icon_image_url");
    }

    public final float getCoverImageAspectRatio() {
        float f = getFloat("cover_icon_image_height");
        float f2 = getFloat("cover_icon_image_width");
        if (f == 0.0f) {
            return 0.0f;
        }
        return f2 / f;
    }

    public final String getUniqueName() {
        return getString("unique_name");
    }

    public final String getTitle() {
        return getString("title");
    }

    public final String getDescription() {
        return getString("description");
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("description", charArrayBuffer);
    }

    public final long getLastModifiedTimestamp() {
        return getLong("last_modified_timestamp");
    }

    public final long getPlayedTime() {
        return getLong("duration");
    }

    public final boolean hasChangePending() {
        return getInteger("pending_change_count") > 0;
    }

    public final long getProgressValue() {
        return getLong("progress_value");
    }

    public final String getDeviceName() {
        return getString(TapjoyConstants.TJC_DEVICE_NAME);
    }

    public final int hashCode() {
        return SnapshotMetadataEntity.zza(this);
    }

    public final boolean equals(Object obj) {
        return SnapshotMetadataEntity.zza(this, obj);
    }

    public final String toString() {
        return SnapshotMetadataEntity.zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((SnapshotMetadataEntity) ((SnapshotMetadata) freeze())).writeToParcel(parcel, i);
    }

    public final /* synthetic */ Object freeze() {
        return new SnapshotMetadataEntity(this);
    }
}
