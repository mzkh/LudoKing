package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final /* synthetic */ class zzxe implements Runnable {
    private final zzxc zzcez;
    private final OnInitializationCompleteListener zzcfa;

    zzxe(zzxc zzxc, OnInitializationCompleteListener onInitializationCompleteListener) {
        this.zzcez = zzxc;
        this.zzcfa = onInitializationCompleteListener;
    }

    public final void run() {
        this.zzcez.zza(this.zzcfa);
    }
}
