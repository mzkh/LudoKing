package com.google.firebase.iid;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-iid@@19.0.1 */
final /* synthetic */ class zzaw implements OnCompleteListener {
    private final zzax zza;

    zzaw(zzax zzax) {
        this.zza = zzax;
    }

    public final void onComplete(Task task) {
        this.zza.zza();
    }
}
