package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;

final class zzbr extends zzbw {
    private final /* synthetic */ boolean zzjz;
    private final /* synthetic */ String[] zzkn;

    zzbr(zzbn zzbn, GoogleApiClient googleApiClient, boolean z, String[] strArr) {
        this.zzjz = z;
        this.zzkn = strArr;
        super(googleApiClient, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zzb((ResultHolder<LoadQuestsResult>) this, this.zzjz, this.zzkn);
    }
}
