package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzuq extends zzus<zzabt> {
    private final /* synthetic */ zzug zzcdf;
    private final /* synthetic */ View zzcdh;
    private final /* synthetic */ HashMap zzcdi;
    private final /* synthetic */ HashMap zzcdj;

    zzuq(zzug zzug, View view, HashMap hashMap, HashMap hashMap2) {
        this.zzcdf = zzug;
        this.zzcdh = view;
        this.zzcdi = hashMap;
        this.zzcdj = hashMap2;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzoe() {
        zzug.zza(this.zzcdh.getContext(), "native_ad_view_holder_delegate");
        return new zzxx();
    }

    public final /* synthetic */ Object zzof() throws RemoteException {
        return this.zzcdf.zzcdb.zzb(this.zzcdh, this.zzcdi, this.zzcdj);
    }

    public final /* synthetic */ Object zza(zzvu zzvu) throws RemoteException {
        return zzvu.zza(ObjectWrapper.wrap(this.zzcdh), ObjectWrapper.wrap(this.zzcdi), ObjectWrapper.wrap(this.zzcdj));
    }
}
