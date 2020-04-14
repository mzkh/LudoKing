package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zze;

final class zzaq extends zzax {
    private final /* synthetic */ String zzbr;
    private final /* synthetic */ boolean zzjz;
    private final /* synthetic */ int zzke;
    private final /* synthetic */ int zzkf;
    private final /* synthetic */ int zzkg;

    zzaq(zzal zzal, GoogleApiClient googleApiClient, String str, int i, int i2, int i3, boolean z) {
        this.zzbr = str;
        this.zzke = i;
        this.zzkf = i2;
        this.zzkg = i3;
        this.zzjz = z;
        super(googleApiClient, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zzb(this, this.zzbr, this.zzke, this.zzkf, this.zzkg, this.zzjz);
    }
}
