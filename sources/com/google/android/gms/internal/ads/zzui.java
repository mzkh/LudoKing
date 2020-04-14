package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzui extends zzus<zzara> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzcdd;
    private final /* synthetic */ zzajx zzcde;
    private final /* synthetic */ zzug zzcdf;

    zzui(zzug zzug, Context context, String str, zzajx zzajx) {
        this.zzcdf = zzug;
        this.val$context = context;
        this.zzcdd = str;
        this.zzcde = zzajx;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzoe() {
        zzug.zza(this.val$context, "rewarded");
        return new zzxw();
    }

    public final /* synthetic */ Object zzof() throws RemoteException {
        return zzarq.zzd(this.val$context, this.zzcdd, this.zzcde);
    }

    public final /* synthetic */ Object zza(zzvu zzvu) throws RemoteException {
        return zzvu.zzb(ObjectWrapper.wrap(this.val$context), this.zzcdd, this.zzcde, 15601000);
    }
}
