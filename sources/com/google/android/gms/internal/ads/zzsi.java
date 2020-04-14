package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzsi {
    @VisibleForTesting
    zzfx zzbtw;
    @VisibleForTesting
    boolean zzbtx;

    public final zzsm zzf(byte[] bArr) {
        return new zzsm(this, bArr);
    }

    public zzsi(Context context, String str, String str2) {
        zzza.initialize(context);
        try {
            this.zzbtw = (zzfx) zzaxh.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zzsl.zzbty);
            ObjectWrapper.wrap(context);
            this.zzbtw.zza(ObjectWrapper.wrap(context), str, null);
            this.zzbtx = true;
        } catch (RemoteException | zzaxj | NullPointerException unused) {
            zzaxi.zzdv("Cannot dynamite load clearcut");
        }
    }

    public zzsi(Context context) {
        zzza.initialize(context);
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcql)).booleanValue()) {
            try {
                this.zzbtw = (zzfx) zzaxh.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zzsk.zzbty);
                ObjectWrapper.wrap(context);
                this.zzbtw.zzb(ObjectWrapper.wrap(context), "GMA_SDK");
                this.zzbtx = true;
            } catch (RemoteException | zzaxj | NullPointerException unused) {
                zzaxi.zzdv("Cannot dynamite load clearcut");
            }
        }
    }

    public zzsi() {
    }
}
