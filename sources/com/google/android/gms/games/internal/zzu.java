package com.google.android.gms.games.internal;

final class zzu extends zzv<T> {
    private final /* synthetic */ zzap zzhd;

    zzu(zzap zzap) {
        this.zzhd = zzap;
        super(null);
    }

    public final void notifyListener(T t) {
        this.zzhd.accept(t);
    }
}
