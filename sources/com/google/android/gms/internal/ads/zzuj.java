package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzuj extends zzus<zzvl> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzcdd;
    private final /* synthetic */ zzajx zzcde;
    private final /* synthetic */ zzug zzcdf;
    private final /* synthetic */ zzua zzcdg;

    zzuj(zzug zzug, Context context, zzua zzua, String str, zzajx zzajx) {
        this.zzcdf = zzug;
        this.val$context = context;
        this.zzcdg = zzua;
        this.zzcdd = str;
        this.zzcde = zzajx;
    }

    public final /* synthetic */ Object zzoe() {
        zzug.zza(this.val$context, "banner");
        return new zzxq();
    }

    public final /* synthetic */ Object zzof() throws RemoteException {
        return this.zzcdf.zzccu.zza(this.val$context, this.zzcdg, this.zzcdd, this.zzcde, 1);
    }

    public final /* synthetic */ Object zza(zzvu zzvu) throws RemoteException {
        return zzvu.zza(ObjectWrapper.wrap(this.val$context), this.zzcdg, this.zzcdd, this.zzcde, 15601000);
    }
}
