package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zzbq;
import com.google.android.gms.games.internal.zzbu;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbg extends zzag<String> {
    private final /* synthetic */ String zzdi;

    zzbg(RealTimeMultiplayerClient realTimeMultiplayerClient, String str) {
        this.zzdi = str;
    }

    /* access modifiers changed from: protected */
    public final void zza(zze zze, TaskCompletionSource<String> taskCompletionSource) throws RemoteException {
        ((zzbu) zze.getService()).zza((zzbq) new zzbh(this, taskCompletionSource), this.zzdi);
    }
}
