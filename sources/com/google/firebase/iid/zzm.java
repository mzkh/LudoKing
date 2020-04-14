package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-iid@@19.0.1 */
final /* synthetic */ class zzm implements Runnable {
    private final zzk zza;
    private final Bundle zzb;
    private final TaskCompletionSource zzc;

    zzm(zzk zzk, Bundle bundle, TaskCompletionSource taskCompletionSource) {
        this.zza = zzk;
        this.zzb = bundle;
        this.zzc = taskCompletionSource;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc);
    }
}
