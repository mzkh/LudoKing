package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;

final class zzx extends zzv<T> {
    private final /* synthetic */ DataHolder zzhf;
    private final /* synthetic */ zzaz zzhi;

    zzx(zzaz zzaz, DataHolder dataHolder) {
        this.zzhi = zzaz;
        this.zzhf = dataHolder;
        super(null);
    }

    public final void notifyListener(T t) {
        this.zzhi.zza(t, this.zzhf.getStatusCode(), zze.zzay(this.zzhf));
    }
}
