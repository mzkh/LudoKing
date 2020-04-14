package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public interface zzakm extends IInterface {
    String getAdvertiser() throws RemoteException;

    String getBody() throws RemoteException;

    String getCallToAction() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    String getHeadline() throws RemoteException;

    List getImages() throws RemoteException;

    float getMediaContentAspectRatio() throws RemoteException;

    boolean getOverrideClickHandling() throws RemoteException;

    boolean getOverrideImpressionRecording() throws RemoteException;

    String getPrice() throws RemoteException;

    double getStarRating() throws RemoteException;

    String getStore() throws RemoteException;

    zzwr getVideoController() throws RemoteException;

    void recordImpression() throws RemoteException;

    void zzaa(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    zzabi zzqn() throws RemoteException;

    zzaba zzqo() throws RemoteException;

    IObjectWrapper zzqp() throws RemoteException;

    IObjectWrapper zzry() throws RemoteException;

    IObjectWrapper zzrz() throws RemoteException;

    void zzy(IObjectWrapper iObjectWrapper) throws RemoteException;
}
