package com.google.firebase.iid;

import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.firebase:firebase-iid@@19.0.1 */
final /* synthetic */ class zzb implements ThreadFactory {
    static final ThreadFactory zza = new zzb();

    private zzb() {
    }

    public final Thread newThread(Runnable runnable) {
        return zzc.zza(runnable);
    }
}
