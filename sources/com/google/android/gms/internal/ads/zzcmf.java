package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcmf implements zzdcz<zzbii> {
    private final /* synthetic */ zzbie zzgch;
    private final /* synthetic */ zzcma zzgci;

    zzcmf(zzcma zzcma, zzbie zzbie) {
        this.zzgci = zzcma;
        this.zzgch = zzbie;
    }

    public final void zzb(Throwable th) {
        synchronized (this.zzgci) {
            this.zzgci.zzgbz = null;
            this.zzgch.zzacb().onAdFailedToLoad(zzccu.zzd(th));
            zzcwj.zzc(th, "AppOpenAdManagerShim.onFailure");
        }
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzbii zzbii = (zzbii) obj;
        synchronized (this.zzgci) {
            this.zzgci.zzgbz = null;
            if (this.zzgci.zzgby != null) {
                this.zzgci.zzgby.destroy();
            }
            this.zzgci.zzgby = zzbii;
            this.zzgci.zzfdl.removeAllViews();
            this.zzgci.zzfdl.addView(zzbii.zzaeu(), zzq.zzkl().zzvr());
            com.google.android.gms.ads.internal.overlay.zzq zza = this.zzgci.zza(zzbii);
            LayoutParams zzb = zzcma.zzb(zzbii);
            zza.zzae(zzbii.zzaev());
            this.zzgci.zzfdl.addView(zza, zzb);
            this.zzgci.zzc(zzbii);
            this.zzgci.zzfdl.setMinimumHeight(this.zzgci.zzale().heightPixels);
            this.zzgci.zzfdl.setMinimumWidth(this.zzgci.zzale().widthPixels);
            try {
                this.zzgci.zzgbv.zza(new zzbik(zzbii, this.zzgci));
            } catch (RemoteException e) {
                zzaug.zzc("RemoteException when onAppOpenAdLoaded is called", e);
            }
            zzbii.zzafa();
        }
    }
}
