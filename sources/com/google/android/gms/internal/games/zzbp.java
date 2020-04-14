package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;

final class zzbp extends zzbu {
    private final /* synthetic */ String zzha;
    private final /* synthetic */ String zzkl;

    zzbp(zzbn zzbn, GoogleApiClient googleApiClient, String str, String str2) {
        this.zzkl = str;
        this.zzha = str2;
        super(googleApiClient, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zzb((ResultHolder<ClaimMilestoneResult>) this, this.zzkl, this.zzha);
    }
}
