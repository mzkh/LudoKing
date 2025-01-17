package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcjp implements zzbsu {
    private final zzcgf zzfxr;
    private final zzcgc zzfys;

    zzcjp(zzcgf zzcgf, zzcgc zzcgc) {
        this.zzfxr = zzcgf;
        this.zzfys = zzcgc;
    }

    public final void zza(boolean z, Context context) {
        String str = "Can't show rewarded video.";
        zzcgf zzcgf = this.zzfxr;
        zzcgc zzcgc = this.zzfys;
        try {
            if (((zzamd) zzcgf.zzddv).zzad(ObjectWrapper.wrap(context))) {
                zzcgc.zzaks();
            } else {
                zzaug.zzeu(str);
            }
        } catch (RemoteException e) {
            zzaug.zzd(str, e);
        }
    }
}
