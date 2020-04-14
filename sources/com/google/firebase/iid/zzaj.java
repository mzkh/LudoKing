package com.google.firebase.iid;

import android.util.Pair;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-iid@@19.0.1 */
final /* synthetic */ class zzaj implements Continuation {
    private final zzak zza;
    private final Pair zzb;

    zzaj(zzak zzak, Pair pair) {
        this.zza = zzak;
        this.zzb = pair;
    }

    public final Object then(Task task) {
        return this.zza.zza(this.zzb, task);
    }
}
