package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;

final class zzv extends zzv<T> {
    private final /* synthetic */ zzaw zzhe;
    private final /* synthetic */ DataHolder zzhf;

    zzv(zzaw zzaw, DataHolder dataHolder) {
        this.zzhe = zzaw;
        this.zzhf = dataHolder;
        super(null);
    }

    public final void notifyListener(T t) {
        this.zzhe.zza(t, zze.zzay(this.zzhf));
    }
}
