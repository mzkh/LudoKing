package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzts extends RemoteCreator<zzvj> {
    public zzts() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public final zzve zza(Context context, String str, zzajx zzajx) {
        try {
            IBinder zzc = ((zzvj) getRemoteCreatorInstance(context)).zzc(ObjectWrapper.wrap(context), str, zzajx, 15601000);
            if (zzc == null) {
                return null;
            }
            IInterface queryLocalInterface = zzc.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzve) {
                return (zzve) queryLocalInterface;
            }
            return new zzvg(zzc);
        } catch (RemoteException | RemoteCreatorException e) {
            zzaxi.zzd("Could not create remote builder for AdLoader.", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        if (queryLocalInterface instanceof zzvj) {
            return (zzvj) queryLocalInterface;
        }
        return new zzvi(iBinder);
    }
}
