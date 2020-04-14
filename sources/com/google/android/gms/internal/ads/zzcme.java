package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbmk.zza;
import java.util.Collections;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcme extends zzvk implements zzboy {
    /* access modifiers changed from: private */
    public final ViewGroup zzfdl;
    private final zzbei zzfza;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public zzbio zzgbk;
    private final Context zzgbp;
    @GuardedBy("this")
    private final zzcwg zzgbq = new zzcwg();
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public zzddi<zzbio> zzgbz;
    private final zzcmi zzgcc = new zzcmi();
    private final zzcmj zzgcd = new zzcmj();
    private final zzcml zzgce = new zzcml();
    /* access modifiers changed from: private */
    public final zzbou zzgcf;
    @GuardedBy("this")
    @Nullable
    private zzaah zzgcg;

    public zzcme(zzbei zzbei, Context context, zzua zzua, String str) {
        this.zzfdl = new FrameLayout(context);
        this.zzfza = zzbei;
        this.zzgbp = context;
        this.zzgbq.zzd(zzua).zzgf(str);
        this.zzgcf = zzbei.zzabf();
        this.zzgcf.zza(this, this.zzfza.zzabb());
    }

    public final boolean isReady() {
        return false;
    }

    public final void setImmersiveMode(boolean z) {
    }

    public final void setUserId(String str) {
    }

    public final void showInterstitial() {
    }

    public final void stopLoading() {
    }

    public final void zza(zzant zzant) {
    }

    public final void zza(zzanz zzanz, String str) {
    }

    public final void zza(zzaqi zzaqi) {
    }

    public final void zza(zzqx zzqx) {
    }

    public final void zza(zzuf zzuf) {
    }

    public final void zza(zzwx zzwx) {
    }

    public final void zzbm(String str) {
    }

    public final IObjectWrapper zzjr() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzfdl);
    }

    public final synchronized boolean zza(zztx zztx) {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (this.zzgbz != null) {
            return false;
        }
        zzcwj.zze(this.zzgbp, zztx.zzcca);
        zzcwe zzane = this.zzgbq.zzg(zztx).zzane();
        if (!((Boolean) zzuv.zzon().zzd(zzza.zzcqw)).booleanValue() || !this.zzgbq.zzjt().zzccq || this.zzgcc == null) {
            zzbjn zzc = zzc(zzane);
            this.zzgbz = zzc.zzaca().zzafs();
            zzdcy.zza(this.zzgbz, new zzcmh(this, zzc), this.zzfza.zzabb());
            return true;
        }
        this.zzgcc.onAdFailedToLoad(1);
        return false;
    }

    private final synchronized zzbjn zzc(zzcwe zzcwe) {
        return this.zzfza.zzabi().zzc(new zza().zzby(this.zzgbp).zza(zzcwe).zzafy()).zzc(new zzbpn.zza().zza((zztp) this.zzgcc, this.zzfza.zzabb()).zza((zztp) this.zzgcd, this.zzfza.zzabb()).zza((zzbna) this.zzgcc, this.zzfza.zzabb()).zza((zzbog) this.zzgcc, this.zzfza.zzabb()).zza((zzbnb) this.zzgcc, this.zzfza.zzabb()).zza((AppEventListener) this.zzgce, this.zzfza.zzabb()).zzagm()).zza(new zzcle(this.zzgcg)).zzb(new zzbth(zzbuy.zzfmf, null)).zza(new zzbkh(this.zzgcf)).zzb(new zzbin(this.zzfdl)).zzacz();
    }

    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzgbk != null) {
            this.zzgbk.destroy();
        }
    }

    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzgbk != null) {
            this.zzgbk.zzafm().zzbu(null);
        }
    }

    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzgbk != null) {
            this.zzgbk.zzafm().zzbv(null);
        }
    }

    public final void zza(zzuy zzuy) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzgcc.zzc(zzuy);
    }

    public final zzuy zzjw() {
        return this.zzgcc.zzalh();
    }

    public final void zza(zzvt zzvt) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.zzgce.zzb(zzvt);
    }

    public final zzvt zzjv() {
        return this.zzgce.zzalj();
    }

    public final synchronized void zzjs() {
        Preconditions.checkMainThread("recordManualImpression must be called on the main UI thread.");
        if (this.zzgbk != null) {
            this.zzgbk.zzjs();
        }
    }

    public final synchronized zzua zzjt() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        if (this.zzgbk != null) {
            return zzcwi.zza(this.zzgbp, Collections.singletonList(this.zzgbk.zzaet()));
        }
        return this.zzgbq.zzjt();
    }

    public final synchronized void zza(zzua zzua) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        this.zzgbq.zzd(zzua);
        if (this.zzgbk != null) {
            this.zzgbk.zza(this.zzfdl, zzua);
        }
    }

    public final synchronized String getMediationAdapterClassName() {
        if (this.zzgbk == null) {
            return null;
        }
        return this.zzgbk.getMediationAdapterClassName();
    }

    public final synchronized String zzju() {
        if (this.zzgbk == null) {
            return null;
        }
        return this.zzgbk.zzju();
    }

    public final synchronized void zza(zzvz zzvz) {
        Preconditions.checkMainThread("setCorrelationIdProvider must be called on the main UI thread");
        this.zzgbq.zzc(zzvz);
    }

    public final synchronized void setManualImpressionsEnabled(boolean z) {
        Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
        this.zzgbq.zzbe(z);
    }

    public final synchronized boolean isLoading() {
        return this.zzgbz != null && !this.zzgbz.isDone();
    }

    public final synchronized zzwr getVideoController() {
        Preconditions.checkMainThread("getVideoController must be called from the main thread.");
        if (this.zzgbk == null) {
            return null;
        }
        return this.zzgbk.getVideoController();
    }

    public final synchronized String getAdUnitId() {
        return this.zzgbq.zzand();
    }

    public final synchronized void zza(zzyj zzyj) {
        Preconditions.checkMainThread("setVideoOptions must be called on the main UI thread.");
        this.zzgbq.zzc(zzyj);
    }

    public final void zza(zzux zzux) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzgcd.zzb(zzux);
    }

    public final synchronized void zza(zzaah zzaah) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzgcg = zzaah;
    }

    public final synchronized void zzagc() {
        boolean z;
        ViewParent parent = this.zzfdl.getParent();
        if (!(parent instanceof View)) {
            z = false;
        } else {
            View view = (View) parent;
            z = zzq.zzkj().zza(view, view.getContext());
        }
        if (z) {
            zza(this.zzgbq.zzanc());
        } else {
            this.zzgcf.zzdd(60);
        }
    }

    public final void zza(zzvo zzvo) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }
}
