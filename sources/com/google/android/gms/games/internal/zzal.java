package com.google.android.gms.games.internal;

import com.google.android.gms.games.request.OnRequestReceivedListener;

final /* synthetic */ class zzal implements zzap {
    private final String zzhv;

    zzal(String str) {
        this.zzhv = str;
    }

    public final void accept(Object obj) {
        ((OnRequestReceivedListener) obj).onRequestRemoved(this.zzhv);
    }
}
