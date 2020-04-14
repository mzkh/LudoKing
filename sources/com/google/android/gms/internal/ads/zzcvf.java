package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcvf extends zzaqz {
    private final String zzbqy;
    private final zzcwc zzfgu;
    private final zzcvb zzgij;
    private final zzcui zzgik;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public zzbyz zzgil;

    public zzcvf(@Nullable String str, zzcvb zzcvb, zzcui zzcui, zzcwc zzcwc) {
        this.zzbqy = str;
        this.zzgij = zzcvb;
        this.zzgik = zzcui;
        this.zzfgu = zzcwc;
    }

    public final synchronized void zza(zztx zztx, zzari zzari) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzgik.zza(zzari);
        if (this.zzgil == null) {
            this.zzgij.zza(zztx, this.zzbqy, new zzcvc(null), new zzcvi(this));
        }
    }

    public final synchronized void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
        zza(iObjectWrapper, false);
    }

    public final synchronized void zza(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzgil == null) {
            zzaug.zzeu("Rewarded can not be shown before loaded");
            this.zzgik.zzcl(2);
            return;
        }
        this.zzgil.zzb(z, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final synchronized String getMediationAdapterClassName() throws RemoteException {
        if (this.zzgil == null) {
            return null;
        }
        return this.zzgil.getMediationAdapterClassName();
    }

    public final boolean isLoaded() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbyz zzbyz = this.zzgil;
        return zzbyz != null && !zzbyz.zzajh();
    }

    public final void zza(zzarb zzarb) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzgik.zzb(zzarb);
    }

    public final void zza(zzarj zzarj) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzgik.zzb(zzarj);
    }

    public final void zza(zzwm zzwm) {
        if (zzwm == null) {
            this.zzgik.zza((AdMetadataListener) null);
        } else {
            this.zzgik.zza((AdMetadataListener) new zzcvh(this, zzwm));
        }
    }

    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbyz zzbyz = this.zzgil;
        return zzbyz != null ? zzbyz.getAdMetadata() : new Bundle();
    }

    @Nullable
    public final zzaqv zzpk() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbyz zzbyz = this.zzgil;
        if (zzbyz != null) {
            return zzbyz.zzpk();
        }
        return null;
    }

    public final synchronized void zza(zzarr zzarr) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcwc zzcwc = this.zzfgu;
        zzcwc.zzdnz = zzarr.zzdnz;
        if (((Boolean) zzuv.zzon().zzd(zzza.zzckm)).booleanValue()) {
            zzcwc.zzdoa = zzarr.zzdoa;
        }
    }
}
