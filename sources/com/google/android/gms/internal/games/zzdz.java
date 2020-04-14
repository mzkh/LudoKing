package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.video.Videos.CaptureAvailableResult;

final class zzdz extends zzea {
    private final /* synthetic */ int zzlg;

    zzdz(zzdw zzdw, GoogleApiClient googleApiClient, int i) {
        this.zzlg = i;
        super(googleApiClient, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zzb((ResultHolder<CaptureAvailableResult>) this, this.zzlg);
    }
}
