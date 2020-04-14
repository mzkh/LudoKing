package com.google.firebase.iid;

import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-iid@@19.0.1 */
final /* synthetic */ class zze implements Executor {
    static final Executor zza = new zze();

    private zze() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
