package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.Player;

@VisibleForTesting
public interface Participant extends Parcelable, Freezable<Participant> {
    public static final int STATUS_DECLINED = 3;
    public static final int STATUS_FINISHED = 5;
    public static final int STATUS_INVITED = 1;
    public static final int STATUS_JOINED = 2;
    public static final int STATUS_LEFT = 4;
    public static final int STATUS_NOT_INVITED_YET = 0;
    public static final int STATUS_UNRESPONSIVE = 6;

    int getCapabilities();

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

    String getParticipantId();

    @Nullable
    Player getPlayer();

    @Nullable
    ParticipantResult getResult();

    int getStatus();

    boolean isConnectedToRoom();

    String zzdn();
}
