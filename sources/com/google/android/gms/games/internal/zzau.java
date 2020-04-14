package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;

final /* synthetic */ class zzau implements zzap {
    private final RealTimeMessage zziy;

    zzau(RealTimeMessage realTimeMessage) {
        this.zziy = realTimeMessage;
    }

    public final void accept(Object obj) {
        ((RealTimeMessageReceivedListener) obj).onRealTimeMessageReceived(this.zziy);
    }
}
