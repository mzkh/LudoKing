package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbpf extends zzbpm<AppEventListener> implements zzady {
    public zzbpf(Set<zzbqs<AppEventListener>> set) {
        super(set);
    }

    public final synchronized void onAppEvent(String str, String str2) {
        zza((zzbpo<ListenerT>) new zzbpi<ListenerT>(str, str2));
    }
}
