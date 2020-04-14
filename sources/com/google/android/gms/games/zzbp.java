package com.google.android.gms.games;

import com.google.android.gms.common.api.internal.ListenerHolder.Notifier;
import com.google.android.gms.games.multiplayer.realtime.zzh;

final class zzbp implements Notifier<zzh> {
    private final /* synthetic */ zzbo zzdu;

    zzbp(zzbo zzbo) {
        this.zzdu = zzbo;
    }

    public final void onNotifyListenerFailed() {
        this.zzdu.zzdt.zzdq.getRoomUpdateCallback().onLeftRoom(0, this.zzdu.zzdt.zzdi);
    }

    public final /* synthetic */ void notifyListener(Object obj) {
        ((zzh) obj).onLeftRoom(0, this.zzdu.zzdt.zzdi);
    }
}
