package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcml implements AppEventListener {
    @GuardedBy("this")
    private zzvt zzgcr;

    public final synchronized void zzb(zzvt zzvt) {
        this.zzgcr = zzvt;
    }

    public final synchronized zzvt zzalj() {
        return this.zzgcr;
    }

    public final synchronized void onAppEvent(String str, String str2) {
        if (this.zzgcr != null) {
            try {
                this.zzgcr.onAppEvent(str, str2);
            } catch (RemoteException e) {
                zzaug.zzd("Remote Exception at onAppEvent.", e);
            }
        }
    }
}
