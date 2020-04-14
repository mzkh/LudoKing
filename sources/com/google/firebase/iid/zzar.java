package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.Nullable;

@VisibleForTesting
/* compiled from: com.google.firebase:firebase-iid@@19.0.1 */
final class zzar extends BroadcastReceiver {
    @Nullable
    private zzas zza;

    public zzar(zzas zzas) {
        this.zza = zzas;
    }

    public final void zza() {
        if (FirebaseInstanceId.zzd()) {
            Log.d("FirebaseInstanceId", "Connectivity change received registered");
        }
        this.zza.zza().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public final void onReceive(Context context, Intent intent) {
        zzas zzas = this.zza;
        if (zzas != null && zzas.zzb()) {
            if (FirebaseInstanceId.zzd()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            FirebaseInstanceId.zza((Runnable) this.zza, 0);
            this.zza.zza().unregisterReceiver(this);
            this.zza = null;
        }
    }
}
