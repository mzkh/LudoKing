package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zztv extends RemoteCreator<zzvm> {
    @VisibleForTesting
    public zztv() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public final zzvl zza(Context context, zzua zzua, String str, zzajx zzajx, int i) {
        try {
            IBinder zza = ((zzvm) getRemoteCreatorInstance(context)).zza(ObjectWrapper.wrap(context), zzua, str, zzajx, 15601000, i);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzvl) {
                return (zzvl) queryLocalInterface;
            }
            return new zzvn(zza);
        } catch (RemoteException | RemoteCreatorException e) {
            zzaxi.zzb("Could not create remote AdManager.", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if (queryLocalInterface instanceof zzvm) {
            return (zzvm) queryLocalInterface;
        }
        return new zzvp(iBinder);
    }
}
