package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;

@VisibleForTesting
public interface zze extends Parcelable, Freezable<zze> {
    List<zza> getActions();

    String getDescription();

    Bundle getExtras();

    String getId();

    String getTitle();

    String getType();

    String zzaa();

    List<zzc> zzai();

    int zzaj();

    String zzak();

    int zzal();

    List<zzg> zzz();
}
