package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzsa implements Runnable {
    private final zzrx zzbrv;
    private final zzrq zzbrw;
    private final zzrp zzbrx;
    private final zzaxv zzbry;

    zzsa(zzrx zzrx, zzrq zzrq, zzrp zzrp, zzaxv zzaxv) {
        this.zzbrv = zzrx;
        this.zzbrw = zzrq;
        this.zzbrx = zzrp;
        this.zzbry = zzaxv;
    }

    public final void run() {
        zzrx zzrx = this.zzbrv;
        zzrq zzrq = this.zzbrw;
        zzrp zzrp = this.zzbrx;
        zzaxv zzaxv = this.zzbry;
        try {
            zzro zza = zzrq.zzml().zza(zzrp);
            if (!zza.zzmi()) {
                zzaxv.setException(new RuntimeException("No entry contents."));
                zzrx.zzbrs.disconnect();
                return;
            }
            zzsc zzsc = new zzsc(zzrx, zza.zzmj(), 1);
            int read = zzsc.read();
            if (read != -1) {
                zzsc.unread(read);
                zzaxv.set(zzsc);
                return;
            }
            throw new IOException("Unable to read from cache.");
        } catch (RemoteException | IOException e) {
            zzaug.zzc("Unable to obtain a cache service instance.", e);
            zzaxv.setException(e);
            zzrx.zzbrs.disconnect();
        }
    }
}
