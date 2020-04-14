package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;

final class zzbq extends zzbw {
    private final /* synthetic */ boolean zzjz;
    private final /* synthetic */ int zzkd;
    private final /* synthetic */ int[] zzkm;

    zzbq(zzbn zzbn, GoogleApiClient googleApiClient, int[] iArr, int i, boolean z) {
        this.zzkm = iArr;
        this.zzkd = i;
        this.zzjz = z;
        super(googleApiClient, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zza((ResultHolder<LoadQuestsResult>) this, this.zzkm, this.zzkd, this.zzjz);
    }
}
