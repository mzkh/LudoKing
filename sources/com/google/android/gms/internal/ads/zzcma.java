package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbmk.zza;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcma extends zzvk implements zzy, zzbol, zzqr {
    /* access modifiers changed from: private */
    public final ViewGroup zzfdl;
    private final zzbei zzfza;
    private final Context zzgbp;
    @GuardedBy("this")
    private final zzcwg zzgbq = new zzcwg();
    private AtomicBoolean zzgbu = new AtomicBoolean();
    /* access modifiers changed from: private */
    public zzqx zzgbv;
    private final zzcmg zzgbw = new zzcmg();
    @Nullable
    private zzbib zzgbx;
    @GuardedBy("this")
    @Nullable
    protected zzbii zzgby;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public zzddi<zzbii> zzgbz;

    public zzcma(zzbei zzbei, Context context, zzua zzua, String str) {
        this.zzfdl = new FrameLayout(context);
        this.zzfza = zzbei;
        this.zzgbp = context;
        this.zzgbq.zzd(zzua).zzgf(str);
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

    public final void zza(zzux zzux) {
    }

    public final void zza(zzuy zzuy) {
    }

    public final void zza(zzvo zzvo) {
    }

    public final void zza(zzvt zzvt) {
    }

    public final void zza(zzwx zzwx) {
    }

    public final void zzbm(String str) {
    }

    public final zzvt zzjv() {
        return null;
    }

    public final zzuy zzjw() {
        return null;
    }

    public final IObjectWrapper zzjr() {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzfdl);
    }

    public final void zza(zzuf zzuf) {
        this.zzgbq.zzb(zzuf);
    }

    public final synchronized boolean zza(zztx zztx) {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (this.zzgbz != null) {
            return false;
        }
        this.zzgbu = new AtomicBoolean();
        zzcwj.zze(this.zzgbp, zztx.zzcca);
        zzbie zzb = zzb(this.zzgbq.zzg(zztx).zzane());
        this.zzgbz = zzb.zzaca().zzafs();
        zzdcy.zza(this.zzgbz, new zzcmf(this, zzb), this.zzfza.zzabb());
        return true;
    }

    /* access modifiers changed from: private */
    public final zzq zza(zzbii zzbii) {
        boolean zzyw = zzbii.zzyw();
        int intValue = ((Integer) zzuv.zzon().zzd(zzza.zzcqk)).intValue();
        zzp zzp = new zzp();
        zzp.size = 50;
        zzp.paddingLeft = zzyw ? intValue : 0;
        zzp.paddingRight = zzyw ? 0 : intValue;
        zzp.paddingTop = 0;
        zzp.paddingBottom = intValue;
        return new zzq(this.zzgbp, zzp, this);
    }

    /* access modifiers changed from: private */
    public static LayoutParams zzb(zzbii zzbii) {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(zzbii.zzyw() ? 11 : 9);
        return layoutParams;
    }

    /* access modifiers changed from: private */
    public final void zzc(zzbii zzbii) {
        zzbii.zza((zzqr) this);
    }

    public final void zzso() {
        zzalg();
    }

    public final void zzmf() {
        zzalg();
    }

    public final void zzafz() {
        zzbii zzbii = this.zzgby;
        if (zzbii != null) {
            int zzaer = zzbii.zzaer();
            if (zzaer > 0) {
                this.zzgbx = new zzbib(this.zzfza.zzabc(), com.google.android.gms.ads.internal.zzq.zzkq());
                this.zzgbx.zza(zzaer, new zzcmc(this));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzald */
    public final void zzalg() {
        if (this.zzgbu.compareAndSet(false, true)) {
            zzbii zzbii = this.zzgby;
            zzrc zzaew = zzbii != null ? zzbii.zzaew() : null;
            if (zzaew != null) {
                try {
                    zzaew.onAppOpenAdClosed();
                } catch (RemoteException e) {
                    zzaxi.zzc("", e);
                }
            }
            this.zzfdl.removeAllViews();
            zzbib zzbib = this.zzgbx;
            if (zzbib != null) {
                com.google.android.gms.ads.internal.zzq.zzkm().zzb(zzbib);
            }
            destroy();
        }
    }

    /* access modifiers changed from: private */
    public final zzua zzale() {
        return zzcwi.zza(this.zzgbp, Collections.singletonList(this.zzgby.zzaet()));
    }

    private final synchronized zzbie zzb(zzcwe zzcwe) {
        return this.zzfza.zzabj().zzb(new zza().zzby(this.zzgbp).zza(zzcwe).zzafy()).zzb(new zzbpn.zza().zza((zzbnb) this.zzgbw, this.zzfza.zzabb()).zza((zzbol) this, this.zzfza.zzabb()).zzagm()).zza(new zzbin(this.zzfdl)).zzacp();
    }

    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzgby != null) {
            this.zzgby.destroy();
        }
    }

    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    public final void zza(zzqx zzqx) {
        this.zzgbv = zzqx;
        this.zzgbw.zzb(zzqx);
    }

    public final synchronized zzua zzjt() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        if (this.zzgby == null) {
            return null;
        }
        return zzcwi.zza(this.zzgbp, Collections.singletonList(this.zzgby.zzaet()));
    }

    public final synchronized void zza(zzua zzua) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
    }

    public final synchronized String getMediationAdapterClassName() {
        return null;
    }

    public final synchronized String zzju() {
        return null;
    }

    public final synchronized boolean isLoading() {
        return this.zzgbz != null && !this.zzgbz.isDone();
    }

    public final synchronized String getAdUnitId() {
        return this.zzgbq.zzand();
    }

    public final synchronized void zzjs() {
    }

    public final synchronized void zza(zzvz zzvz) {
    }

    public final synchronized void setManualImpressionsEnabled(boolean z) {
    }

    public final synchronized zzwr getVideoController() {
        return null;
    }

    public final synchronized void zza(zzyj zzyj) {
    }

    public final synchronized void zza(zzaah zzaah) {
    }

    public final Bundle getAdMetadata() {
        return new Bundle();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzalf() {
        this.zzfza.zzabb().execute(new zzcmd(this));
    }
}
