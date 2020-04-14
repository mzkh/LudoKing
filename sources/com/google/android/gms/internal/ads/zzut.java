package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzut extends zzus<zzaqb> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzajx zzcde;
    private final /* synthetic */ zzug zzcdf;

    zzut(zzug zzug, Context context, zzajx zzajx) {
        this.zzcdf = zzug;
        this.val$context = context;
        this.zzcde = zzajx;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzoe() {
        zzug.zza(this.val$context, "rewarded_video");
        return new zzxy();
    }

    public final /* synthetic */ Object zzof() throws RemoteException {
        return this.zzcdf.zzccy.zza(this.val$context, this.zzcde);
    }

    public final /* synthetic */ Object zza(zzvu zzvu) throws RemoteException {
        return zzvu.zza(ObjectWrapper.wrap(this.val$context), this.zzcde, 15601000);
    }
}
