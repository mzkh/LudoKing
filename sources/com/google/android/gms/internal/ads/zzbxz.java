package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbxz extends zzacd {
    @Nullable
    private final String zzffi;
    private final zzbur zzfjl;
    private final zzbuj zzfml;

    public zzbxz(@Nullable String str, zzbuj zzbuj, zzbur zzbur) {
        this.zzffi = str;
        this.zzfml = zzbuj;
        this.zzfjl = zzbur;
    }

    public final IObjectWrapper zzqm() throws RemoteException {
        return ObjectWrapper.wrap(this.zzfml);
    }

    public final String getHeadline() throws RemoteException {
        return this.zzfjl.getHeadline();
    }

    public final List<?> getImages() throws RemoteException {
        return this.zzfjl.getImages();
    }

    public final String getBody() throws RemoteException {
        return this.zzfjl.getBody();
    }

    public final zzabi zzqq() throws RemoteException {
        return this.zzfjl.zzqq();
    }

    public final String getCallToAction() throws RemoteException {
        return this.zzfjl.getCallToAction();
    }

    public final String getAdvertiser() throws RemoteException {
        return this.zzfjl.getAdvertiser();
    }

    public final Bundle getExtras() throws RemoteException {
        return this.zzfjl.getExtras();
    }

    public final void destroy() throws RemoteException {
        this.zzfml.destroy();
    }

    public final zzwr getVideoController() throws RemoteException {
        return this.zzfjl.getVideoController();
    }

    public final void performClick(Bundle bundle) throws RemoteException {
        this.zzfml.zzf(bundle);
    }

    public final boolean recordImpression(Bundle bundle) throws RemoteException {
        return this.zzfml.zzh(bundle);
    }

    public final void reportTouchEvent(Bundle bundle) throws RemoteException {
        this.zzfml.zzg(bundle);
    }

    public final zzaba zzqo() throws RemoteException {
        return this.zzfjl.zzqo();
    }

    public final IObjectWrapper zzqp() throws RemoteException {
        return this.zzfjl.zzqp();
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        return this.zzffi;
    }
}
