package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzann;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzu extends zzann {
    private boolean zzdhb = false;
    private AdOverlayInfoParcel zzdii;
    private boolean zzdij = false;
    private Activity zzzr;

    public zzu(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzdii = adOverlayInfoParcel;
        this.zzzr = activity;
    }

    public final void onActivityResult(int i, int i2, Intent intent) throws RemoteException {
    }

    public final void onBackPressed() throws RemoteException {
    }

    public final void onRestart() throws RemoteException {
    }

    public final void onStart() throws RemoteException {
    }

    public final void zzag(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzda() throws RemoteException {
    }

    public final boolean zzsp() throws RemoteException {
        return false;
    }

    public final void onCreate(Bundle bundle) {
        boolean z = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdii;
        if (adOverlayInfoParcel == null) {
            this.zzzr.finish();
        } else if (z) {
            this.zzzr.finish();
        } else {
            if (bundle == null) {
                if (adOverlayInfoParcel.zzcbs != null) {
                    this.zzdii.zzcbs.onAdClicked();
                }
                if (!(this.zzzr.getIntent() == null || !this.zzzr.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) || this.zzdii.zzdhy == null)) {
                    this.zzdii.zzdhy.zzsj();
                }
            }
            zzq.zzkh();
            if (!zzb.zza((Context) this.zzzr, this.zzdii.zzdhx, this.zzdii.zzdic)) {
                this.zzzr.finish();
            }
        }
    }

    public final void onResume() throws RemoteException {
        if (this.zzdhb) {
            this.zzzr.finish();
            return;
        }
        this.zzdhb = true;
        if (this.zzdii.zzdhy != null) {
            this.zzdii.zzdhy.onResume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzdhb);
    }

    public final void onPause() throws RemoteException {
        if (this.zzdii.zzdhy != null) {
            this.zzdii.zzdhy.onPause();
        }
        if (this.zzzr.isFinishing()) {
            zzsz();
        }
    }

    public final void onStop() throws RemoteException {
        if (this.zzzr.isFinishing()) {
            zzsz();
        }
    }

    public final void onDestroy() throws RemoteException {
        if (this.zzzr.isFinishing()) {
            zzsz();
        }
    }

    private final synchronized void zzsz() {
        if (!this.zzdij) {
            if (this.zzdii.zzdhy != null) {
                this.zzdii.zzdhy.zzsi();
            }
            this.zzdij = true;
        }
    }
}
