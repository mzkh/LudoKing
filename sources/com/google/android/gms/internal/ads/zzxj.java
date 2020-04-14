package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzxj extends zzafx {
    private final OnInitializationCompleteListener zzcfc;
    private final /* synthetic */ zzxc zzcfd;

    private zzxj(zzxc zzxc, OnInitializationCompleteListener onInitializationCompleteListener) {
        this.zzcfd = zzxc;
        this.zzcfc = onInitializationCompleteListener;
    }

    public final void zzc(List<zzafr> list) throws RemoteException {
        this.zzcfc.onInitializationComplete(zzxc.zzb(list));
    }

    /* synthetic */ zzxj(zzxc zzxc, OnInitializationCompleteListener onInitializationCompleteListener, zzxg zzxg) {
        this(zzxc, onInitializationCompleteListener);
    }
}
