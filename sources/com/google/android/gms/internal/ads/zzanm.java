package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzanm extends RemoteCreator<zzanp> {
    public zzanm() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public final zzano zzc(Activity activity) {
        String str = "Could not create remote AdOverlay.";
        try {
            IBinder zzah = ((zzanp) getRemoteCreatorInstance(activity)).zzah(ObjectWrapper.wrap(activity));
            if (zzah == null) {
                return null;
            }
            IInterface queryLocalInterface = zzah.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            if (queryLocalInterface instanceof zzano) {
                return (zzano) queryLocalInterface;
            }
            return new zzanq(zzah);
        } catch (RemoteException e) {
            zzaxi.zzd(str, e);
            return null;
        } catch (RemoteCreatorException e2) {
            zzaxi.zzd(str, e2);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        if (queryLocalInterface instanceof zzanp) {
            return (zzanp) queryLocalInterface;
        }
        return new zzans(iBinder);
    }
}
