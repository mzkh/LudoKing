package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcea extends zzcec {
    public zzcea(Context context) {
        this.zzfva = new zzaom(context, zzq.zzkx().zzwd(), this, this);
    }

    public final zzddi<InputStream> zzf(zzape zzape) {
        synchronized (this.mLock) {
            if (this.zzfux) {
                zzaxv zzaxv = this.zzdbn;
                return zzaxv;
            }
            this.zzfux = true;
            this.zzfuz = zzape;
            this.zzfva.checkAvailabilityAndConnect();
            this.zzdbn.addListener(new zzced(this), zzaxn.zzdwn);
            zzaxv zzaxv2 = this.zzdbn;
            return zzaxv2;
        }
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzaug.zzdv("Cannot connect to remote service, fallback to local instance.");
        this.zzdbn.setException(new zzcel(0));
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.mLock) {
            if (!this.zzfuy) {
                this.zzfuy = true;
                try {
                    this.zzfva.zzta().zza(this.zzfuz, (zzaoy) new zzcef(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zzdbn.setException(new zzcel(0));
                } catch (Throwable th) {
                    zzq.zzkn().zza(th, "RemoteAdRequestClientTask.onConnected");
                    this.zzdbn.setException(new zzcel(0));
                }
            }
        }
    }
}
