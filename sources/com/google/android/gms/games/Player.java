package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.internal.player.zza;

@VisibleForTesting
public interface Player extends Parcelable, Freezable<Player> {
    public static final long CURRENT_XP_UNKNOWN = -1;
    public static final long TIMESTAMP_UNKNOWN = -1;

    @Nullable
    Uri getBannerImageLandscapeUri();

    @KeepName
    @Deprecated
    @Nullable
    String getBannerImageLandscapeUrl();

    @Nullable
    Uri getBannerImagePortraitUri();

    @KeepName
    @Deprecated
    @Nullable
    String getBannerImagePortraitUrl();

    String getDisplayName();

    void getDisplayName(CharArrayBuffer charArrayBuffer);

    @Nullable
    Uri getHiResImageUri();

    @KeepName
    @Deprecated
    @Nullable
    String getHiResImageUrl();

    @Nullable
    Uri getIconImageUri();

    @KeepName
    @Deprecated
    @Nullable
    String getIconImageUrl();

    long getLastPlayedWithTimestamp();

    @Nullable
    PlayerLevelInfo getLevelInfo();

    String getName();

    String getPlayerId();

    long getRetrievedTimestamp();

    @Nullable
    String getTitle();

    void getTitle(CharArrayBuffer charArrayBuffer);

    boolean hasHiResImage();

    boolean hasIconImage();

    boolean isMuted();

    @Nullable
    String zzh();

    boolean zzi();

    @Deprecated
    int zzj();

    boolean zzk();

    @Nullable
    zza zzl();

    int zzm();

    long zzn();

    long zzo();
}
