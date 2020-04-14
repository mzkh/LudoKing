package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

final class zzw extends zzv<T> {
    private final /* synthetic */ DataHolder zzhf;
    private final /* synthetic */ zzav zzhg;
    private final /* synthetic */ ArrayList zzhh;

    zzw(zzav zzav, DataHolder dataHolder, ArrayList arrayList) {
        this.zzhg = zzav;
        this.zzhf = dataHolder;
        this.zzhh = arrayList;
        super(null);
    }

    public final void notifyListener(T t) {
        this.zzhg.zza(t, zze.zzay(this.zzhf), this.zzhh);
    }
}
