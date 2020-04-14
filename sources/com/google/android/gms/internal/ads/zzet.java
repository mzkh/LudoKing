package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import com.google.android.gms.internal.ads.zzbo.zza.zzc;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzet extends zzfl {
    public zzet(zzdx zzdx, String str, String str2, zzb zzb, int i, int i2) {
        super(zzdx, str, str2, zzb, i, 24);
    }

    public final Void zzcw() throws Exception {
        if (this.zzvo.isInitialized()) {
            return super.call();
        }
        if (this.zzvo.zzci()) {
            zzcx();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final void zzcu() throws IllegalAccessException, InvocationTargetException {
        if (this.zzvo.zzci()) {
            zzcx();
            return;
        }
        synchronized (this.zzaaa) {
            this.zzaaa.zzah((String) this.zzaal.invoke(null, new Object[]{this.zzvo.getContext()}));
        }
    }

    private final void zzcx() {
        AdvertisingIdClient zzcq = this.zzvo.zzcq();
        if (zzcq != null) {
            try {
                Info info = zzcq.getInfo();
                String zzas = zzee.zzas(info.getId());
                if (zzas != null) {
                    synchronized (this.zzaaa) {
                        this.zzaaa.zzah(zzas);
                        this.zzaaa.zzb(info.isLimitAdTrackingEnabled());
                        this.zzaaa.zzb(zzc.DEVICE_IDENTIFIER_ANDROID_AD_ID);
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    public final /* synthetic */ Object call() throws Exception {
        return call();
    }
}
