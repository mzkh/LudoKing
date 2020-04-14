package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzclw extends zzvk {
    private final ViewGroup zzfdl;
    private final zzcwe zzfga;
    private final zzuy zzfjf;
    private final zzbio zzgbk;
    private final Context zzlk;

    public zzclw(Context context, @Nullable zzuy zzuy, zzcwe zzcwe, zzbio zzbio) {
        this.zzlk = context;
        this.zzfjf = zzuy;
        this.zzfga = zzcwe;
        this.zzgbk = zzbio;
        FrameLayout frameLayout = new FrameLayout(this.zzlk);
        frameLayout.removeAllViews();
        frameLayout.addView(this.zzgbk.zzaeu(), zzq.zzkl().zzvr());
        frameLayout.setMinimumHeight(zzjt().heightPixels);
        frameLayout.setMinimumWidth(zzjt().widthPixels);
        this.zzfdl = frameLayout;
    }

    public final boolean isLoading() throws RemoteException {
        return false;
    }

    public final boolean isReady() throws RemoteException {
        return false;
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
    }

    public final void setUserId(String str) throws RemoteException {
    }

    public final void showInterstitial() throws RemoteException {
    }

    public final void stopLoading() throws RemoteException {
    }

    public final void zza(zzant zzant) throws RemoteException {
    }

    public final void zza(zzanz zzanz, String str) throws RemoteException {
    }

    public final void zza(zzaqi zzaqi) throws RemoteException {
    }

    public final void zza(zzqx zzqx) throws RemoteException {
    }

    public final void zza(zzuf zzuf) throws RemoteException {
    }

    public final void zza(zzwx zzwx) throws RemoteException {
    }

    public final void zzbm(String str) throws RemoteException {
    }

    public final IObjectWrapper zzjr() throws RemoteException {
        return ObjectWrapper.wrap(this.zzfdl);
    }

    public final void destroy() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzgbk.destroy();
    }

    public final boolean zza(zztx zztx) throws RemoteException {
        zzaug.zzet("loadAd is not supported for a Publisher AdView returned from AdLoader.");
        return false;
    }

    public final void pause() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzgbk.zzafm().zzbu(null);
    }

    public final void resume() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzgbk.zzafm().zzbv(null);
    }

    public final void zzjs() throws RemoteException {
        this.zzgbk.zzjs();
    }

    public final zzua zzjt() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        return zzcwi.zza(this.zzlk, Collections.singletonList(this.zzgbk.zzaet()));
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        return this.zzgbk.getMediationAdapterClassName();
    }

    public final zzwr getVideoController() throws RemoteException {
        return this.zzgbk.getVideoController();
    }

    public final String getAdUnitId() throws RemoteException {
        return this.zzfga.zzgkh;
    }

    public final zzvt zzjv() throws RemoteException {
        return this.zzfga.zzgkm;
    }

    public final zzuy zzjw() throws RemoteException {
        return this.zzfjf;
    }

    public final String zzju() throws RemoteException {
        return this.zzgbk.zzju();
    }

    public final void zza(zzyj zzyj) throws RemoteException {
        zzaug.zzet("setVideoOptions is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzua zzua) throws RemoteException {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        zzbio zzbio = this.zzgbk;
        if (zzbio != null) {
            zzbio.zza(this.zzfdl, zzua);
        }
    }

    public final void zza(zzaah zzaah) throws RemoteException {
        zzaug.zzet("setOnCustomRenderedAdLoadedListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzux zzux) throws RemoteException {
        zzaug.zzet("setAdClickListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzvz zzvz) throws RemoteException {
        zzaug.zzet("setCorrelationIdProvider is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
        zzaug.zzet("setManualImpressionsEnabled is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzuy zzuy) throws RemoteException {
        zzaug.zzet("setAdListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzvt zzvt) throws RemoteException {
        zzaug.zzet("setAppEventListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzvo zzvo) throws RemoteException {
        zzaug.zzet("setAdMetadataListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final Bundle getAdMetadata() throws RemoteException {
        zzaug.zzet("getAdMetadata is not supported in Publisher AdView returned by AdLoader.");
        return new Bundle();
    }
}
