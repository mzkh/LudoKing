package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzur extends zzus<zzabm> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzug zzcdf;
    private final /* synthetic */ FrameLayout zzcdk;
    private final /* synthetic */ FrameLayout zzcdl;

    zzur(zzug zzug, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.zzcdf = zzug;
        this.zzcdk = frameLayout;
        this.zzcdl = frameLayout2;
        this.val$context = context;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzoe() {
        zzug.zza(this.val$context, "native_ad_view_delegate");
        return new zzxu();
    }

    public final /* synthetic */ Object zzof() throws RemoteException {
        return this.zzcdf.zzccx.zzb(this.val$context, this.zzcdk, this.zzcdl);
    }

    public final /* synthetic */ Object zza(zzvu zzvu) throws RemoteException {
        return zzvu.zzc(ObjectWrapper.wrap(this.zzcdk), ObjectWrapper.wrap(this.zzcdl));
    }
}
