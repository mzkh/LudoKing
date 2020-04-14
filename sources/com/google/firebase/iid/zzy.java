package com.google.firebase.iid;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: com.google.firebase:firebase-iid@@19.0.1 */
final /* synthetic */ class zzy implements Callback {
    private final zzv zza;

    zzy(zzv zzv) {
        this.zza = zzv;
    }

    public final boolean handleMessage(Message message) {
        return this.zza.zza(message);
    }
}
