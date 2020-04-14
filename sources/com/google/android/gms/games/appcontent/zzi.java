package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;

@VisibleForTesting
public interface zzi extends Parcelable, Freezable<zzi> {
    List<zza> getActions();

    Bundle getExtras();

    String getId();

    String getTitle();

    String getType();

    String zzaa();

    List<zzc> zzai();

    String zzak();

    List<zze> zzaq();

    String zzar();
}
