package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzxn extends RemoteCreator<zzwc> {
    public zzxn() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    public final zzwb zzi(Context context) {
        try {
            IBinder zzb = ((zzwc) getRemoteCreatorInstance(context)).zzb(ObjectWrapper.wrap(context), 15601000);
            if (zzb == null) {
                return null;
            }
            IInterface queryLocalInterface = zzb.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzwb) {
                return (zzwb) queryLocalInterface;
            }
            return new zzwd(zzb);
        } catch (RemoteException | RemoteCreatorException e) {
            zzaxi.zzd("Could not get remote MobileAdsSettingManager.", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        if (queryLocalInterface instanceof zzwc) {
            return (zzwc) queryLocalInterface;
        }
        return new zzwf(iBinder);
    }
}
