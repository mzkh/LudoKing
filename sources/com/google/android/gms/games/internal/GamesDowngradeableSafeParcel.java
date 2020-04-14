package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.util.GmsVersion;

public abstract class GamesDowngradeableSafeParcel extends DowngradeableSafeParcel {
    public boolean prepareForClientVersion(int i) {
        setShouldDowngrade(!zzb(Integer.valueOf(i)));
        return true;
    }

    /* access modifiers changed from: protected */
    public static boolean zzb(Integer num) {
        if (num == null) {
            return false;
        }
        return GmsVersion.isAtLeastFenacho(num.intValue());
    }
}
