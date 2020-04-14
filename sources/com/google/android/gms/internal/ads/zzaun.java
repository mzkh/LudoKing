package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzaun implements Runnable {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzaul zzdta;

    zzaun(zzaul zzaul, Context context) {
        this.zzdta = zzaul;
        this.val$context = context;
    }

    public final void run() {
        synchronized (this.zzdta.zzdsv) {
            this.zzdta.zzber = zzaul.zzaq(this.val$context);
            this.zzdta.zzdsv.notifyAll();
        }
    }
}
