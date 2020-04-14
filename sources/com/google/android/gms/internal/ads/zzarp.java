package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final /* synthetic */ class zzarp implements zzaxk {
    static final zzaxk zzbty = new zzarp();

    private zzarp() {
    }

    public final Object apply(Object obj) {
        IBinder iBinder = (IBinder) obj;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator");
        if (queryLocalInterface instanceof zzarg) {
            return (zzarg) queryLocalInterface;
        }
        return new zzarf(iBinder);
    }
}
