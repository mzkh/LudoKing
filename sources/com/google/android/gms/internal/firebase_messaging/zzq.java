package com.google.android.gms.internal.firebase_messaging;

/* compiled from: com.google.firebase:firebase-iid@@19.0.1 */
final class zzq extends zzm {
    private final zzp zza = new zzp();

    zzq() {
    }

    public final void zza(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        } else if (th2 != null) {
            this.zza.zza(th, true).add(th2);
        } else {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
    }
}
