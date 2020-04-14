package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.DisplayOpenMeasurement;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzabe implements DisplayOpenMeasurement {
    private final zzace zzcwb;

    public zzabe(zzace zzace) {
        this.zzcwb = zzace;
        try {
            zzace.zzqu();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }

    public final boolean start() {
        try {
            return this.zzcwb.zzqt();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            return false;
        }
    }

    public final void setView(View view) {
        try {
            this.zzcwb.zzv(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }
}
