package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;

public interface SnapshotMetadata extends Parcelable, Freezable<SnapshotMetadata> {
    public static final long PLAYED_TIME_UNKNOWN = -1;
    public static final long PROGRESS_VALUE_UNKNOWN = -1;

    float getCoverImageAspectRatio();

    @Nullable
    Uri getCoverImageUri();

    @KeepName
    @Deprecated
    @Nullable
    String getCoverImageUrl();

    String getDescription();

    void getDescription(CharArrayBuffer charArrayBuffer);

    @Nullable
    String getDeviceName();

    Game getGame();

    long getLastModifiedTimestamp();

    Player getOwner();

    long getPlayedTime();

    long getProgressValue();

    String getSnapshotId();

    String getTitle();

    String getUniqueName();

    boolean hasChangePending();
}
