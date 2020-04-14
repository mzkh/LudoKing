package com.google.android.gms.internal.games;

import java.util.concurrent.atomic.AtomicReference;

public abstract class zzej {
    private final AtomicReference<zzeh> zzln = new AtomicReference<>();

    /* access modifiers changed from: protected */
    public abstract zzeh zzcj();

    public final void flush() {
        zzeh zzeh = (zzeh) this.zzln.get();
        if (zzeh != null) {
            zzeh.flush();
        }
    }

    public final void zza(String str, int i) {
        zzeh zzeh = (zzeh) this.zzln.get();
        if (zzeh == null) {
            zzeh = zzcj();
            if (!this.zzln.compareAndSet(null, zzeh)) {
                zzeh = (zzeh) this.zzln.get();
            }
        }
        zzeh.zzg(str, i);
    }
}
