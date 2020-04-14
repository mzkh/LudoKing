package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcvl extends zzaqe {
    private final zzcwc zzfgu;
    @GuardedBy("this")
    private boolean zzgcq = false;
    private final zzcvb zzgij;
    private final zzcui zzgik;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public zzbyz zzgil;

    public zzcvl(zzcvb zzcvb, zzcui zzcui, zzcwc zzcwc) {
        this.zzgij = zzcvb;
        this.zzgik = zzcui;
        this.zzfgu = zzcwc;
    }

    public final void setAppPackageName(String str) throws RemoteException {
    }

    public final synchronized void zza(zzaqo zzaqo) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (!zzzc.zzck(zzaqo.zzbqy)) {
            if (zzali()) {
                if (!((Boolean) zzuv.zzon().zzd(zzza.zzcrk)).booleanValue()) {
                    return;
                }
            }
            zzcvc zzcvc = new zzcvc(null);
            this.zzgil = null;
            this.zzgij.zza(zzaqo.zzdiu, zzaqo.zzbqy, zzcvc, new zzcvo(this));
        }
    }

    public final void destroy() throws RemoteException {
        zzp(null);
    }

    public final synchronized void zzp(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        Context context = null;
        this.zzgik.zza((AdMetadataListener) null);
        if (this.zzgil != null) {
            if (iObjectWrapper != null) {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzgil.zzafm().zzbw(context);
        }
    }

    public final void pause() {
        zzn(null);
    }

    public final synchronized void zzn(IObjectWrapper iObjectWrapper) {
        Context context;
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzgil != null) {
            if (iObjectWrapper == null) {
                context = null;
            } else {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzgil.zzafm().zzbu(context);
        }
    }

    public final void resume() {
        zzo(null);
    }

    public final synchronized void zzo(IObjectWrapper iObjectWrapper) {
        Context context;
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzgil != null) {
            if (iObjectWrapper == null) {
                context = null;
            } else {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzgil.zzafm().zzbv(context);
        }
    }

    public final synchronized void show() throws RemoteException {
        zzm(null);
    }

    public final synchronized void zzm(@Nullable IObjectWrapper iObjectWrapper) throws RemoteException {
        Activity activity;
        Preconditions.checkMainThread("showAd must be called on the main UI thread.");
        if (this.zzgil != null) {
            if (iObjectWrapper != null) {
                Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
                if (unwrap instanceof Activity) {
                    activity = (Activity) unwrap;
                    this.zzgil.zzb(this.zzgcq, activity);
                }
            }
            activity = null;
            this.zzgil.zzb(this.zzgcq, activity);
        }
    }

    public final boolean zzpl() {
        zzbyz zzbyz = this.zzgil;
        return zzbyz != null && zzbyz.zzpl();
    }

    public final synchronized String getMediationAdapterClassName() throws RemoteException {
        if (this.zzgil == null) {
            return null;
        }
        return this.zzgil.getMediationAdapterClassName();
    }

    public final boolean isLoaded() throws RemoteException {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzali();
    }

    public final void zza(zzaqi zzaqi) throws RemoteException {
        Preconditions.checkMainThread("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzgik.zzb(zzaqi);
    }

    public final void zza(zzapz zzapz) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.zzgik.zzb(zzapz);
    }

    public final void zza(zzvo zzvo) {
        Preconditions.checkMainThread("setAdMetadataListener can only be called from the UI thread.");
        if (zzvo == null) {
            this.zzgik.zza((AdMetadataListener) null);
        } else {
            this.zzgik.zza((AdMetadataListener) new zzcvn(this, zzvo));
        }
    }

    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata can only be called from the UI thread.");
        zzbyz zzbyz = this.zzgil;
        return zzbyz != null ? zzbyz.getAdMetadata() : new Bundle();
    }

    public final synchronized void setUserId(String str) throws RemoteException {
        Preconditions.checkMainThread("setUserId must be called on the main UI thread.");
        this.zzfgu.zzdnz = str;
    }

    public final synchronized void setCustomData(String str) throws RemoteException {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzckm)).booleanValue()) {
            Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setCustomData");
            this.zzfgu.zzdoa = str;
        }
    }

    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzgcq = z;
    }

    private final synchronized boolean zzali() {
        return this.zzgil != null && !this.zzgil.isClosed();
    }
}
