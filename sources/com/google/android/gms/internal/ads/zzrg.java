package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd.AppOpenAdLoadCallback;
import com.google.android.gms.ads.appopen.AppOpenAd.AppOpenAdOrientation;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzrg {
    @AppOpenAdOrientation
    private final int orientation;
    private final zzty zzaax;
    private final zzwz zzaaz;
    private zzvl zzbqx;
    private final String zzbqy;
    private final AppOpenAdLoadCallback zzbqz;
    private final zzaju zzbra = new zzaju();
    private final Context zzlk;

    public zzrg(Context context, String str, zzwz zzwz, @AppOpenAdOrientation int i, AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zzlk = context;
        this.zzbqy = str;
        this.zzaaz = zzwz;
        this.orientation = i;
        this.zzbqz = appOpenAdLoadCallback;
        this.zzaax = zzty.zzccl;
    }

    public final void zzmg() {
        try {
            this.zzbqx = zzuv.zzok().zza(this.zzlk, zzua.zzob(), this.zzbqy, this.zzbra);
            this.zzbqx.zza(new zzuf(this.orientation));
            this.zzbqx.zza((zzqx) new zzqu(this.zzbqz));
            this.zzbqx.zza(zzty.zza(this.zzlk, this.zzaaz));
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }
}
