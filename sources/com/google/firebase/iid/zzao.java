package com.google.firebase.iid;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.firebase_messaging.zze;

/* compiled from: com.google.firebase:firebase-iid@@19.0.1 */
final class zzao extends zze {
    private final /* synthetic */ zzal zza;

    zzao(zzal zzal, Looper looper) {
        this.zza = zzal;
        super(looper);
    }

    public final void handleMessage(Message message) {
        this.zza.zza(message);
    }
}
