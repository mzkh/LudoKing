package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbpn.zza;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcmk extends zzvk {
    private final Executor zzfbx;
    private final zzbei zzfza;
    private final Context zzgbp;
    @GuardedBy("this")
    private final zzcwg zzgbq = new zzcwg();
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public zzddi<zzbrs> zzgbz;
    private final zzcmi zzgcc = new zzcmi();
    private final zzcml zzgce = new zzcml();
    @GuardedBy("this")
    @Nullable
    private zzaah zzgcg;
    private final zzcui zzgco = new zzcui();
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public zzbrs zzgcp;
    @GuardedBy("this")
    private boolean zzgcq = false;

    public zzcmk(zzbei zzbei, Context context, zzua zzua, String str) {
        this.zzfza = zzbei;
        this.zzgbq.zzd(zzua).zzgf(str);
        this.zzfbx = zzbei.zzabb();
        this.zzgbp = context;
    }

    public final zzwr getVideoController() {
        return null;
    }

    public final void setUserId(String str) {
    }

    public final void stopLoading() {
    }

    public final void zza(zzant zzant) {
    }

    public final void zza(zzanz zzanz, String str) {
    }

    public final void zza(zzqx zzqx) {
    }

    public final void zza(zzua zzua) {
    }

    public final void zza(zzuf zzuf) {
    }

    public final void zza(zzux zzux) {
    }

    public final void zza(zzwx zzwx) {
    }

    public final void zzbm(String str) {
    }

    public final IObjectWrapper zzjr() {
        return null;
    }

    public final void zzjs() {
    }

    public final zzua zzjt() {
        return null;
    }

    public final synchronized boolean zza(zztx zztx) {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (this.zzgbz == null) {
            if (!zzali()) {
                zzcwj.zze(this.zzgbp, zztx.zzcca);
                this.zzgcp = null;
                zzcwe zzane = this.zzgbq.zzg(zztx).zzane();
                zza zza = new zza();
                if (this.zzgco != null) {
                    zza.zza((zzbna) this.zzgco, this.zzfza.zzabb()).zza((zzbog) this.zzgco, this.zzfza.zzabb()).zza((zzbnb) this.zzgco, this.zzfza.zzabb());
                }
                zzbso zzadf = this.zzfza.zzabk().zzd(new zzbmk.zza().zzby(this.zzgbp).zza(zzane).zzafy()).zzd(zza.zza((zzbna) this.zzgcc, this.zzfza.zzabb()).zza((zzbog) this.zzgcc, this.zzfza.zzabb()).zza((zzbnb) this.zzgcc, this.zzfza.zzabb()).zza((zztp) this.zzgcc, this.zzfza.zzabb()).zza((AppEventListener) this.zzgce, this.zzfza.zzabb()).zzagm()).zzb(new zzcle(this.zzgcg)).zzadf();
                this.zzgbz = zzadf.zzaca().zzafs();
                zzdcy.zza(this.zzgbz, new zzcmn(this, zzadf), this.zzfbx);
                return true;
            }
        }
        return false;
    }

    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzgcp != null) {
            this.zzgcp.zzafm().zzbw(null);
        }
    }

    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzgcp != null) {
            this.zzgcp.zzafm().zzbu(null);
        }
    }

    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzgcp != null) {
            this.zzgcp.zzafm().zzbv(null);
        }
    }

    public final void zza(zzuy zzuy) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzgcc.zzc(zzuy);
    }

    public final void zza(zzvt zzvt) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.zzgce.zzb(zzvt);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void showInterstitial() {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "showInterstitial must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x001d }
            com.google.android.gms.internal.ads.zzbrs r0 = r2.zzgcp     // Catch:{ all -> 0x001d }
            if (r0 != 0) goto L_0x000c
            monitor-exit(r2)
            return
        L_0x000c:
            com.google.android.gms.internal.ads.zzbrs r0 = r2.zzgcp     // Catch:{ all -> 0x001d }
            boolean r0 = r0.zzags()     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x001b
            com.google.android.gms.internal.ads.zzbrs r0 = r2.zzgcp     // Catch:{ all -> 0x001d }
            boolean r1 = r2.zzgcq     // Catch:{ all -> 0x001d }
            r0.zzay(r1)     // Catch:{ all -> 0x001d }
        L_0x001b:
            monitor-exit(r2)
            return
        L_0x001d:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcmk.showInterstitial():void");
    }

    public final synchronized String getMediationAdapterClassName() {
        if (this.zzgcp == null) {
            return null;
        }
        return this.zzgcp.getMediationAdapterClassName();
    }

    public final synchronized String zzju() {
        if (this.zzgcp == null) {
            return null;
        }
        return this.zzgcp.zzju();
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

    public final synchronized boolean isReady() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzali();
    }

    public final synchronized String getAdUnitId() {
        return this.zzgbq.zzand();
    }

    public final zzvt zzjv() {
        return this.zzgce.zzalj();
    }

    public final zzuy zzjw() {
        return this.zzgcc.zzalh();
    }

    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzgcq = z;
    }

    public final synchronized void zza(zzyj zzyj) {
        this.zzgbq.zzc(zzyj);
    }

    public final synchronized void zza(zzaah zzaah) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzgcg = zzaah;
    }

    private final synchronized boolean zzali() {
        return this.zzgcp != null && !this.zzgcp.isClosed();
    }

    public final void zza(zzvo zzvo) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    public final void zza(zzaqi zzaqi) {
        this.zzgco.zzb(zzaqi);
    }
}
