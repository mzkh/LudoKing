package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzuo extends zzus<zzwb> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzug zzcdf;

    zzuo(zzug zzug, Context context) {
        this.zzcdf = zzug;
        this.val$context = context;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzoe() {
        zzug.zza(this.val$context, "mobile_ads_settings");
        return new zzxs();
    }

    public final /* synthetic */ Object zzof() throws RemoteException {
        return this.zzcdf.zzccw.zzi(this.val$context);
    }

    public final /* synthetic */ Object zza(zzvu zzvu) throws RemoteException {
        return zzvu.zza(ObjectWrapper.wrap(this.val$context), 15601000);
    }
}
