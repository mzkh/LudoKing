package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzwn implements MuteThisAdReason {
    private final String description;
    private zzwi zzcdz;

    public zzwn(zzwi zzwi) {
        String str;
        this.zzcdz = zzwi;
        try {
            str = zzwi.getDescription();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
            str = null;
        }
        this.description = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final zzwi zzow() {
        return this.zzcdz;
    }

    public final String toString() {
        return this.description;
    }
}
