package com.google.android.gms.games.internal.experience;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.Game;

@VisibleForTesting
public interface ExperienceEvent extends Parcelable, Freezable<ExperienceEvent> {
    Game getGame();

    Uri getIconImageUri();

    @KeepName
    @Deprecated
    String getIconImageUrl();

    int getType();

    String zzcu();

    String zzcv();

    String zzcw();

    long zzcx();

    long zzcy();

    long zzcz();

    int zzda();
}
