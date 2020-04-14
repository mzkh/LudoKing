package com.google.android.gms.games.appcontent;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public interface zzk extends Parcelable, Freezable<zzk> {
    String getName();

    String getValue();
}
