package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbvp implements zzaer {
    private final zzbvm zzfnj;
    private final zzadf zzfnk;

    zzbvp(zzbvm zzbvm, zzadf zzadf) {
        this.zzfnj = zzbvm;
        this.zzfnk = zzadf;
    }

    public final void zza(Object obj, Map map) {
        zzbvm zzbvm = this.zzfnj;
        zzadf zzadf = this.zzfnk;
        try {
            zzbvm.zzfnh = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
        } catch (NumberFormatException unused) {
            zzaug.zzes("Failed to call parse unconfirmedClickTimestamp.");
        }
        zzbvm.zzfng = (String) map.get("id");
        String str = (String) map.get("asset_id");
        if (zzadf == null) {
            zzaug.zzdv("Received unconfirmed click but UnconfirmedClickListener is null.");
            return;
        }
        try {
            zzadf.onUnconfirmedClickReceived(str);
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }
}
