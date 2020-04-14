package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbrl extends zzbpm<VideoLifecycleCallbacks> {
    @GuardedBy("this")
    private boolean zzehn;

    protected zzbrl(Set<zzbqs<VideoLifecycleCallbacks>> set) {
        super(set);
    }

    public final void onVideoPause() {
        zza(zzbrk.zzfgz);
    }

    public final void onVideoEnd() {
        zza(zzbrn.zzfgz);
    }

    public final synchronized void onVideoStart() {
        zza(zzbrm.zzfgz);
        this.zzehn = true;
    }

    public final synchronized void onVideoPlay() {
        if (!this.zzehn) {
            zza(zzbrp.zzfgz);
            this.zzehn = true;
        }
        zza(zzbro.zzfgz);
    }
}
