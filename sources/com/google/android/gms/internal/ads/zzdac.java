package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.CallSuper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public class zzdac extends Handler {
    private static volatile zzdaf zzgok;

    public zzdac() {
    }

    public zzdac(Looper looper) {
        super(looper);
    }

    public final void dispatchMessage(Message message) {
        zzb(message);
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void zzb(Message message) {
        super.dispatchMessage(message);
    }
}
