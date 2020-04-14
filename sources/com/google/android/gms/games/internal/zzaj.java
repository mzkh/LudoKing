package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;

final /* synthetic */ class zzaj implements zzap {
    private final int zzhc;
    private final int zzip;
    private final String zziq;

    zzaj(int i, int i2, String str) {
        this.zzhc = i;
        this.zzip = i2;
        this.zziq = str;
    }

    public final void accept(Object obj) {
        ((ReliableMessageSentCallback) obj).onRealTimeMessageSent(this.zzhc, this.zzip, this.zziq);
    }
}
