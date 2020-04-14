package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcjt extends zzckt {
    private zzbrc zzfzo;
    private zzbne zzfzp;

    public zzcjt(zzbmv zzbmv, zzbni zzbni, zzbnr zzbnr, zzbob zzbob, zzbne zzbne, zzbpf zzbpf, zzbrl zzbrl, zzboo zzboo, zzbrc zzbrc) {
        super(zzbmv, zzbni, zzbnr, zzbob, zzbpf, zzboo, zzbrl);
        this.zzfzo = zzbrc;
        this.zzfzp = zzbne;
    }

    public final void zzb(Bundle bundle) throws RemoteException {
    }

    public final void zzrw() {
        this.zzfzo.zzra();
    }

    public final void zzcl(int i) throws RemoteException {
        this.zzfzp.zzcl(i);
    }

    public final void zzrx() throws RemoteException {
        this.zzfzo.zzrb();
    }

    public final void zza(zzaqv zzaqv) throws RemoteException {
        this.zzfzo.zza(new zzaqt(zzaqv.getType(), zzaqv.getAmount()));
    }

    public final void zzb(zzaqt zzaqt) {
        this.zzfzo.zza(zzaqt);
    }

    public final void onVideoEnd() {
        this.zzfzo.zzrb();
    }
}
