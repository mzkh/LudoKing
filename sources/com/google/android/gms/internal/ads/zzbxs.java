package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbxs extends zzage implements OnGlobalLayoutListener, OnScrollChangedListener, zzaav {
    private boolean zzegn = false;
    private zzwr zzflj;
    private View zzflo;
    private zzbuj zzfml;
    private boolean zzfpi = false;

    public zzbxs(zzbuj zzbuj, zzbur zzbur) {
        this.zzflo = zzbur.zzaht();
        this.zzflj = zzbur.getVideoController();
        this.zzfml = zzbuj;
        if (zzbur.zzahu() != null) {
            zzbur.zzahu().zza((zzaav) this);
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzagh zzagh) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzegn) {
            zzaug.zzes("Instream ad is destroyed already.");
            zza(zzagh, 2);
        } else if (this.zzflo == null || this.zzflj == null) {
            String str = "Instream internal error: ";
            String str2 = this.zzflo == null ? "can not get video view." : "can not get video controller.";
            zzaug.zzes(str2.length() != 0 ? str.concat(str2) : new String(str));
            zza(zzagh, 0);
        } else if (this.zzfpi) {
            zzaug.zzes("Instream ad should not be used again.");
            zza(zzagh, 1);
        } else {
            this.zzfpi = true;
            zzajc();
            ((ViewGroup) ObjectWrapper.unwrap(iObjectWrapper)).addView(this.zzflo, new LayoutParams(-1, -1));
            zzq.zzlg();
            zzayd.zza(this.zzflo, (OnGlobalLayoutListener) this);
            zzq.zzlg();
            zzayd.zza(this.zzflo, (OnScrollChangedListener) this);
            zzajd();
            try {
                zzagh.zzrc();
            } catch (RemoteException e) {
                zzaug.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final zzwr getVideoController() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (!this.zzegn) {
            return this.zzflj;
        }
        zzaug.zzes("getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    public final void destroy() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzajc();
        zzbuj zzbuj = this.zzfml;
        if (zzbuj != null) {
            zzbuj.destroy();
        }
        this.zzfml = null;
        this.zzflo = null;
        this.zzflj = null;
        this.zzegn = true;
    }

    private final void zzajc() {
        View view = this.zzflo;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.zzflo);
            }
        }
    }

    public final void onGlobalLayout() {
        zzajd();
    }

    public final void onScrollChanged() {
        zzajd();
    }

    public final void zzqj() {
        zzaul.zzdsu.post(new zzbxv(this));
    }

    private final void zzajd() {
        zzbuj zzbuj = this.zzfml;
        if (zzbuj != null) {
            View view = this.zzflo;
            if (view != null) {
                zzbuj.zzb(view, Collections.emptyMap(), Collections.emptyMap(), zzbuj.zzx(this.zzflo));
            }
        }
    }

    private static void zza(zzagh zzagh, int i) {
        try {
            zzagh.zzcj(i);
        } catch (RemoteException e) {
            zzaug.zze("#007 Could not call remote method.", e);
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzaje() {
        try {
            destroy();
        } catch (RemoteException e) {
            zzaug.zze("#007 Could not call remote method.", e);
        }
    }
}
