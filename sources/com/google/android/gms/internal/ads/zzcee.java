package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzq;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcee extends zzcec {
    public zzcee(Context context) {
        this.zzfva = new zzaom(context, zzq.zzkx().zzwd(), this, this);
    }

    public final zzddi<InputStream> zzg(zzape zzape) {
        synchronized (this.mLock) {
            if (this.zzfux) {
                zzaxv zzaxv = this.zzdbn;
                return zzaxv;
            }
            this.zzfux = true;
            this.zzfuz = zzape;
            this.zzfva.checkAvailabilityAndConnect();
            this.zzdbn.addListener(new zzceh(this), zzaxn.zzdwn);
            zzaxv zzaxv2 = this.zzdbn;
            return zzaxv2;
        }
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.mLock) {
            if (!this.zzfuy) {
                this.zzfuy = true;
                try {
                    this.zzfva.zzta().zzb(this.zzfuz, new zzcef(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zzdbn.setException(new zzcel(0));
                } catch (Throwable th) {
                    zzq.zzkn().zza(th, "RemoteSignalsClientTask.onConnected");
                    this.zzdbn.setException(new zzcel(0));
                }
            }
        }
    }
}
