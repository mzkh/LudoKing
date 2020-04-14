package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzxb {
    private final zzty zzaax;
    private VideoOptions zzbjz;
    private boolean zzbkg;
    private AppEventListener zzbki;
    private zzvl zzbqx;
    private String zzbqy;
    private final zzaju zzbra;
    private zztp zzcbs;
    private AdListener zzcbv;
    private AdSize[] zzcdc;
    private final AtomicBoolean zzcem;
    /* access modifiers changed from: private */
    public final VideoController zzcen;
    @VisibleForTesting
    private final zzuu zzceo;
    private OnCustomRenderedAdLoadedListener zzcep;
    private ViewGroup zzceq;
    private int zzcer;

    private static boolean zzci(int i) {
        return i == 1;
    }

    public zzxb(ViewGroup viewGroup) {
        this(viewGroup, null, false, zzty.zzccl, 0);
    }

    public zzxb(ViewGroup viewGroup, int i) {
        this(viewGroup, null, false, zzty.zzccl, i);
    }

    public zzxb(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzty.zzccl, 0);
    }

    public zzxb(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, false, zzty.zzccl, i);
    }

    @VisibleForTesting
    private zzxb(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzty zzty, zzvl zzvl, int i) {
        zzua zzua;
        this.zzbra = new zzaju();
        this.zzcen = new VideoController();
        this.zzceo = new zzxa(this);
        this.zzceq = viewGroup;
        this.zzaax = zzty;
        this.zzbqx = null;
        this.zzcem = new AtomicBoolean(false);
        this.zzcer = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzuh zzuh = new zzuh(context, attributeSet);
                this.zzcdc = zzuh.zzr(z);
                this.zzbqy = zzuh.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    zzawy zzoj = zzuv.zzoj();
                    AdSize adSize = this.zzcdc[0];
                    int i2 = this.zzcer;
                    if (adSize.equals(AdSize.INVALID)) {
                        zzua = zzua.zzoc();
                    } else {
                        zzua zzua2 = new zzua(context, adSize);
                        zzua2.zzccp = zzci(i2);
                        zzua = zzua2;
                    }
                    zzoj.zza(viewGroup, zzua, "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzuv.zzoj().zza(viewGroup, new zzua(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    @VisibleForTesting
    private zzxb(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzty zzty, int i) {
        this(viewGroup, attributeSet, z, zzty, null, i);
    }

    public final void destroy() {
        try {
            if (this.zzbqx != null) {
                this.zzbqx.destroy();
            }
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final AdListener getAdListener() {
        return this.zzcbv;
    }

    public final AdSize getAdSize() {
        try {
            if (this.zzbqx != null) {
                zzua zzjt = this.zzbqx.zzjt();
                if (zzjt != null) {
                    return zzjt.zzod();
                }
            }
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
        AdSize[] adSizeArr = this.zzcdc;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    public final AdSize[] getAdSizes() {
        return this.zzcdc;
    }

    public final String getAdUnitId() {
        if (this.zzbqy == null) {
            zzvl zzvl = this.zzbqx;
            if (zzvl != null) {
                try {
                    this.zzbqy = zzvl.getAdUnitId();
                } catch (RemoteException e) {
                    zzaxi.zze("#007 Could not call remote method.", e);
                }
            }
        }
        return this.zzbqy;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzbki;
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzcep;
    }

    public final void zza(zzwz zzwz) {
        zzvl zzvl;
        String str = "#007 Could not call remote method.";
        try {
            if (this.zzbqx == null) {
                if ((this.zzcdc == null || this.zzbqy == null) && this.zzbqx == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = this.zzceq.getContext();
                zzua zza = zza(context, this.zzcdc, this.zzcer);
                if ("search_v2".equals(zza.zzabd)) {
                    zzvl = (zzvl) new zzun(zzuv.zzok(), context, zza, this.zzbqy).zzd(context, false);
                } else {
                    zzuj zzuj = new zzuj(zzuv.zzok(), context, zza, this.zzbqy, this.zzbra);
                    zzvl = (zzvl) zzuj.zzd(context, false);
                }
                this.zzbqx = zzvl;
                this.zzbqx.zza((zzuy) new zztt(this.zzceo));
                if (this.zzcbs != null) {
                    this.zzbqx.zza((zzux) new zzto(this.zzcbs));
                }
                if (this.zzbki != null) {
                    this.zzbqx.zza((zzvt) new zzuc(this.zzbki));
                }
                if (this.zzcep != null) {
                    this.zzbqx.zza((zzaah) new zzaai(this.zzcep));
                }
                if (this.zzbjz != null) {
                    this.zzbqx.zza(new zzyj(this.zzbjz));
                }
                this.zzbqx.setManualImpressionsEnabled(this.zzbkg);
                try {
                    IObjectWrapper zzjr = this.zzbqx.zzjr();
                    if (zzjr != null) {
                        this.zzceq.addView((View) ObjectWrapper.unwrap(zzjr));
                    }
                } catch (RemoteException e) {
                    zzaxi.zze(str, e);
                }
            }
            if (this.zzbqx.zza(zzty.zza(this.zzceq.getContext(), zzwz))) {
                this.zzbra.zzf(zzwz.zzpc());
            }
        } catch (RemoteException e2) {
            zzaxi.zze(str, e2);
        }
    }

    public final void pause() {
        try {
            if (this.zzbqx != null) {
                this.zzbqx.pause();
            }
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void recordManualImpression() {
        if (!this.zzcem.getAndSet(true)) {
            try {
                if (this.zzbqx != null) {
                    this.zzbqx.zzjs();
                }
            } catch (RemoteException e) {
                zzaxi.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final void resume() {
        try {
            if (this.zzbqx != null) {
                this.zzbqx.resume();
            }
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setAdListener(AdListener adListener) {
        this.zzcbv = adListener;
        this.zzceo.zza(adListener);
    }

    public final void zza(zztp zztp) {
        try {
            this.zzcbs = zztp;
            if (this.zzbqx != null) {
                this.zzbqx.zza((zzux) zztp != null ? new zzto(zztp) : null);
            }
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (this.zzcdc == null) {
            zza(adSizeArr);
            return;
        }
        throw new IllegalStateException("The ad size can only be set once on AdView.");
    }

    public final void zza(AdSize... adSizeArr) {
        this.zzcdc = adSizeArr;
        try {
            if (this.zzbqx != null) {
                this.zzbqx.zza(zza(this.zzceq.getContext(), this.zzcdc, this.zzcer));
            }
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
        this.zzceq.requestLayout();
    }

    public final void setAdUnitId(String str) {
        if (this.zzbqy == null) {
            this.zzbqy = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzbki = appEventListener;
            if (this.zzbqx != null) {
                this.zzbqx.zza((zzvt) appEventListener != null ? new zzuc(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzcep = onCustomRenderedAdLoadedListener;
        try {
            if (this.zzbqx != null) {
                this.zzbqx.zza((zzaah) onCustomRenderedAdLoadedListener != null ? new zzaai(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzbkg = z;
        try {
            if (this.zzbqx != null) {
                this.zzbqx.setManualImpressionsEnabled(this.zzbkg);
            }
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.zzbqx != null) {
                return this.zzbqx.zzju();
            }
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
        return null;
    }

    public final boolean isLoading() {
        try {
            if (this.zzbqx != null) {
                return this.zzbqx.isLoading();
            }
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
        return false;
    }

    public final VideoController getVideoController() {
        return this.zzcen;
    }

    public final zzwr zzde() {
        zzvl zzvl = this.zzbqx;
        if (zzvl == null) {
            return null;
        }
        try {
            return zzvl.getVideoController();
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        zzyj zzyj;
        this.zzbjz = videoOptions;
        try {
            if (this.zzbqx != null) {
                zzvl zzvl = this.zzbqx;
                if (videoOptions == null) {
                    zzyj = null;
                } else {
                    zzyj = new zzyj(videoOptions);
                }
                zzvl.zza(zzyj);
            }
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }

    public final VideoOptions getVideoOptions() {
        return this.zzbjz;
    }

    public final boolean zza(zzvl zzvl) {
        if (zzvl == null) {
            return false;
        }
        try {
            IObjectWrapper zzjr = zzvl.zzjr();
            if (zzjr == null || ((View) ObjectWrapper.unwrap(zzjr)).getParent() != null) {
                return false;
            }
            this.zzceq.addView((View) ObjectWrapper.unwrap(zzjr));
            this.zzbqx = zzvl;
            return true;
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    private static zzua zza(Context context, AdSize[] adSizeArr, int i) {
        for (AdSize equals : adSizeArr) {
            if (equals.equals(AdSize.INVALID)) {
                return zzua.zzoc();
            }
        }
        zzua zzua = new zzua(context, adSizeArr);
        zzua.zzccp = zzci(i);
        return zzua;
    }
}
