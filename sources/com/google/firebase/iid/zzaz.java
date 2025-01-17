package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;

/* compiled from: com.google.firebase:firebase-iid@@19.0.1 */
final /* synthetic */ class zzaz implements Runnable {
    private final zzax zza;
    private final Intent zzb;

    zzaz(zzax zzax, Intent intent) {
        this.zza = zzax;
        this.zzb = intent;
    }

    public final void run() {
        zzax zzax = this.zza;
        String action = this.zzb.getAction();
        StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
        sb.append("Service took too long to process intent: ");
        sb.append(action);
        sb.append(" App may get closed.");
        Log.w("FirebaseInstanceId", sb.toString());
        zzax.zza();
    }
}
