package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzajm extends zzbee {
    private final AppMeasurementSdk zzdbr;

    zzajm(AppMeasurementSdk appMeasurementSdk) {
        this.zzdbr = appMeasurementSdk;
    }

    public final void performAction(Bundle bundle) throws RemoteException {
        this.zzdbr.performAction(bundle);
    }

    public final Bundle performActionWithResponse(Bundle bundle) throws RemoteException {
        return this.zzdbr.performActionWithResponse(bundle);
    }

    public final void logEvent(String str, String str2, Bundle bundle) throws RemoteException {
        this.zzdbr.logEvent(str, str2, bundle);
    }

    public final void zza(String str, String str2, IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zzdbr.setUserProperty(str, str2, iObjectWrapper != null ? ObjectWrapper.unwrap(iObjectWrapper) : null);
    }

    public final Map getUserProperties(String str, String str2, boolean z) throws RemoteException {
        return this.zzdbr.getUserProperties(str, str2, z);
    }

    public final int getMaxUserProperties(String str) throws RemoteException {
        return this.zzdbr.getMaxUserProperties(str);
    }

    public final void setConditionalUserProperty(Bundle bundle) throws RemoteException {
        this.zzdbr.setConditionalUserProperty(bundle);
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        this.zzdbr.clearConditionalUserProperty(str, str2, bundle);
    }

    public final List getConditionalUserProperties(String str, String str2) throws RemoteException {
        return this.zzdbr.getConditionalUserProperties(str, str2);
    }

    public final String getAppInstanceId() throws RemoteException {
        return this.zzdbr.getAppInstanceId();
    }

    public final String getGmpAppId() throws RemoteException {
        return this.zzdbr.getGmpAppId();
    }

    public final long generateEventId() throws RemoteException {
        return this.zzdbr.generateEventId();
    }

    public final void beginAdUnitExposure(String str) throws RemoteException {
        this.zzdbr.beginAdUnitExposure(str);
    }

    public final void endAdUnitExposure(String str) throws RemoteException {
        this.zzdbr.endAdUnitExposure(str);
    }

    public final void zzb(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        this.zzdbr.setCurrentScreen(iObjectWrapper != null ? (Activity) ObjectWrapper.unwrap(iObjectWrapper) : null, str, str2);
    }

    public final String getCurrentScreenName() throws RemoteException {
        return this.zzdbr.getCurrentScreenName();
    }

    public final String getCurrentScreenClass() throws RemoteException {
        return this.zzdbr.getCurrentScreenClass();
    }

    public final String getAppIdOrigin() throws RemoteException {
        return this.zzdbr.getAppIdOrigin();
    }
}
