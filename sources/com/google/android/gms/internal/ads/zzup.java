package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzup extends zzus<zzve> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzcdd;
    private final /* synthetic */ zzajx zzcde;
    private final /* synthetic */ zzug zzcdf;

    zzup(zzug zzug, Context context, String str, zzajx zzajx) {
        this.zzcdf = zzug;
        this.val$context = context;
        this.zzcdd = str;
        this.zzcde = zzajx;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzoe() {
        zzug.zza(this.val$context, "native_ad");
        return new zzxm();
    }

    public final /* synthetic */ Object zzof() throws RemoteException {
        return this.zzcdf.zzccv.zza(this.val$context, this.zzcdd, this.zzcde);
    }

    public final /* synthetic */ Object zza(zzvu zzvu) throws RemoteException {
        return zzvu.zza(ObjectWrapper.wrap(this.val$context), this.zzcdd, this.zzcde, 15601000);
    }
}
