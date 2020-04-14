package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzul extends zzus<zzano> {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ zzug zzcdf;

    zzul(zzug zzug, Activity activity) {
        this.zzcdf = zzug;
        this.val$activity = activity;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzoe() {
        zzug.zza(this.val$activity, "ad_overlay");
        return null;
    }

    public final /* synthetic */ Object zzof() throws RemoteException {
        return this.zzcdf.zzcda.zzc(this.val$activity);
    }

    public final /* synthetic */ Object zza(zzvu zzvu) throws RemoteException {
        return zzvu.zzf(ObjectWrapper.wrap(this.val$activity));
    }
}
