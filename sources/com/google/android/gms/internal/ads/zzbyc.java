package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbyc extends zzadj {
    @Nullable
    private final String zzffi;
    private final zzbur zzfjl;
    private final zzbuj zzfml;

    public zzbyc(@Nullable String str, zzbuj zzbuj, zzbur zzbur) {
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

    public final List<?> getMuteThisAdReasons() throws RemoteException {
        if (isCustomMuteThisAdEnabled()) {
            return this.zzfjl.getMuteThisAdReasons();
        }
        return Collections.emptyList();
    }

    public final boolean isCustomMuteThisAdEnabled() throws RemoteException {
        return !this.zzfjl.getMuteThisAdReasons().isEmpty() && this.zzfjl.zzahs() != null;
    }

    public final String getBody() throws RemoteException {
        return this.zzfjl.getBody();
    }

    public final zzabi zzqn() throws RemoteException {
        return this.zzfjl.zzqn();
    }

    public final String getCallToAction() throws RemoteException {
        return this.zzfjl.getCallToAction();
    }

    public final String getAdvertiser() throws RemoteException {
        return this.zzfjl.getAdvertiser();
    }

    public final double getStarRating() throws RemoteException {
        return this.zzfjl.getStarRating();
    }

    public final String getStore() throws RemoteException {
        return this.zzfjl.getStore();
    }

    public final String getPrice() throws RemoteException {
        return this.zzfjl.getPrice();
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

    public final Bundle getExtras() throws RemoteException {
        return this.zzfjl.getExtras();
    }

    public final void zza(zzadf zzadf) throws RemoteException {
        this.zzfml.zza(zzadf);
    }

    public final void zza(@Nullable zzwi zzwi) throws RemoteException {
        this.zzfml.zza(zzwi);
    }

    public final void zza(zzwe zzwe) throws RemoteException {
        this.zzfml.zza(zzwe);
    }

    public final void zzqw() {
        this.zzfml.zzqw();
    }

    public final void recordCustomClickGesture() {
        this.zzfml.recordCustomClickGesture();
    }

    public final boolean isCustomClickGestureEnabled() {
        return this.zzfml.isCustomClickGestureEnabled();
    }

    public final void cancelUnconfirmedClick() throws RemoteException {
        this.zzfml.cancelUnconfirmedClick();
    }

    public final zzabh zzqx() throws RemoteException {
        return this.zzfml.zzahm().zzqx();
    }
}
