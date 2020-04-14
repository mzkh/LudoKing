package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbvh extends zzabp implements OnGlobalLayoutListener, OnScrollChangedListener, zzbvz {
    public static final String[] zzfmp = {NativeAppInstallAd.ASSET_MEDIA_VIDEO, NativeContentAd.ASSET_MEDIA_VIDEO, UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO};
    private FrameLayout zzbkb;
    private zzabh zzcwp;
    private final int zzdwf;
    private boolean zzegn = false;
    @GuardedBy("this")
    private zzbuj zzfml;
    private zzpf zzfmm;
    private final String zzfmo;
    @GuardedBy("this")
    private Map<String, WeakReference<View>> zzfmq = new HashMap();
    private FrameLayout zzfmr;
    private zzddl zzfms;
    private View zzfmt;
    private IObjectWrapper zzfmu = null;
    private boolean zzfmv;

    public zzbvh(FrameLayout frameLayout, FrameLayout frameLayout2, int i) {
        String str;
        this.zzfmr = frameLayout;
        this.zzbkb = frameLayout2;
        this.zzdwf = i;
        String canonicalName = frameLayout.getClass().getCanonicalName();
        if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(canonicalName)) {
            str = NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(canonicalName)) {
            str = NativeAppInstallAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else {
            "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(canonicalName);
            str = "3012";
        }
        this.zzfmo = str;
        zzq.zzlg();
        zzayd.zza((View) frameLayout, (OnGlobalLayoutListener) this);
        zzq.zzlg();
        zzayd.zza((View) frameLayout, (OnScrollChangedListener) this);
        this.zzfms = zzaxn.zzdwm;
        this.zzfmm = new zzpf(this.zzfmr.getContext(), this.zzfmr);
        frameLayout.setOnTouchListener(this);
        frameLayout.setOnClickListener(this);
    }

    public final synchronized void zzc(String str, IObjectWrapper iObjectWrapper) {
        zza(str, (View) ObjectWrapper.unwrap(iObjectWrapper), true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(java.lang.String r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r4 = r1.zzegn     // Catch:{ all -> 0x0041 }
            if (r4 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            if (r3 != 0) goto L_0x0010
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzfmq     // Catch:{ all -> 0x0041 }
            r3.remove(r2)     // Catch:{ all -> 0x0041 }
            monitor-exit(r1)
            return
        L_0x0010:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.zzfmq     // Catch:{ all -> 0x0041 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0041 }
            r0.<init>(r3)     // Catch:{ all -> 0x0041 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0041 }
            java.lang.String r4 = "1098"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0041 }
            if (r4 != 0) goto L_0x003f
            java.lang.String r4 = "3011"
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x002b
            goto L_0x003f
        L_0x002b:
            int r2 = r1.zzdwf     // Catch:{ all -> 0x0041 }
            boolean r2 = com.google.android.gms.internal.ads.zzawm.zzcp(r2)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0036
            r3.setOnTouchListener(r1)     // Catch:{ all -> 0x0041 }
        L_0x0036:
            r2 = 1
            r3.setClickable(r2)     // Catch:{ all -> 0x0041 }
            r3.setOnClickListener(r1)     // Catch:{ all -> 0x0041 }
            monitor-exit(r1)
            return
        L_0x003f:
            monitor-exit(r1)
            return
        L_0x0041:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbvh.zza(java.lang.String, android.view.View, boolean):void");
    }

    public final synchronized IObjectWrapper zzcj(String str) {
        return ObjectWrapper.wrap(zzfw(str));
    }

    public final synchronized View zzfw(String str) {
        if (this.zzegn) {
            return null;
        }
        WeakReference weakReference = (WeakReference) this.zzfmq.get(str);
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0049, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zze(com.google.android.gms.dynamic.IObjectWrapper r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.zzegn     // Catch:{ all -> 0x004a }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            java.lang.Object r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)     // Catch:{ all -> 0x004a }
            boolean r0 = r2 instanceof com.google.android.gms.internal.ads.zzbuj     // Catch:{ all -> 0x004a }
            if (r0 != 0) goto L_0x0016
            java.lang.String r2 = "Not an instance of native engine. This is most likely a transient error"
            com.google.android.gms.internal.ads.zzaug.zzeu(r2)     // Catch:{ all -> 0x004a }
            monitor-exit(r1)
            return
        L_0x0016:
            com.google.android.gms.internal.ads.zzbuj r0 = r1.zzfml     // Catch:{ all -> 0x004a }
            if (r0 == 0) goto L_0x001f
            com.google.android.gms.internal.ads.zzbuj r0 = r1.zzfml     // Catch:{ all -> 0x004a }
            r0.zzb(r1)     // Catch:{ all -> 0x004a }
        L_0x001f:
            r1.zzaiu()     // Catch:{ all -> 0x004a }
            com.google.android.gms.internal.ads.zzbuj r2 = (com.google.android.gms.internal.ads.zzbuj) r2     // Catch:{ all -> 0x004a }
            r1.zzfml = r2     // Catch:{ all -> 0x004a }
            com.google.android.gms.internal.ads.zzbuj r2 = r1.zzfml     // Catch:{ all -> 0x004a }
            r2.zza(r1)     // Catch:{ all -> 0x004a }
            com.google.android.gms.internal.ads.zzbuj r2 = r1.zzfml     // Catch:{ all -> 0x004a }
            android.widget.FrameLayout r0 = r1.zzfmr     // Catch:{ all -> 0x004a }
            r2.zzy(r0)     // Catch:{ all -> 0x004a }
            com.google.android.gms.internal.ads.zzbuj r2 = r1.zzfml     // Catch:{ all -> 0x004a }
            android.widget.FrameLayout r0 = r1.zzbkb     // Catch:{ all -> 0x004a }
            r2.zzz(r0)     // Catch:{ all -> 0x004a }
            boolean r2 = r1.zzfmv     // Catch:{ all -> 0x004a }
            if (r2 == 0) goto L_0x0048
            com.google.android.gms.internal.ads.zzbuj r2 = r1.zzfml     // Catch:{ all -> 0x004a }
            com.google.android.gms.internal.ads.zzbup r2 = r2.zzahm()     // Catch:{ all -> 0x004a }
            com.google.android.gms.internal.ads.zzabh r0 = r1.zzcwp     // Catch:{ all -> 0x004a }
            r2.zza(r0)     // Catch:{ all -> 0x004a }
        L_0x0048:
            monitor-exit(r1)
            return
        L_0x004a:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbvh.zze(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    private final synchronized void zzaiu() {
        this.zzfms.execute(new zzbvg(this));
    }

    public final synchronized void destroy() {
        if (!this.zzegn) {
            if (this.zzfml != null) {
                this.zzfml.zzb(this);
                this.zzfml = null;
            }
            this.zzfmq.clear();
            this.zzfmr.removeAllViews();
            this.zzbkb.removeAllViews();
            this.zzfmq = null;
            this.zzfmr = null;
            this.zzbkb = null;
            this.zzfmt = null;
            this.zzfmm = null;
            this.zzegn = true;
        }
    }

    public final synchronized void zzc(IObjectWrapper iObjectWrapper, int i) {
    }

    public final synchronized void onClick(View view) {
        if (this.zzfml != null) {
            this.zzfml.cancelUnconfirmedClick();
            this.zzfml.zza(view, this.zzfmr, zzaip(), zzaiq(), false);
        }
    }

    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zzfml != null) {
            this.zzfml.zza(view, motionEvent, this.zzfmr);
        }
        return false;
    }

    public final synchronized void onGlobalLayout() {
        if (this.zzfml != null) {
            this.zzfml.zzb(this.zzfmr, zzaip(), zzaiq(), zzbuj.zzx(this.zzfmr));
        }
    }

    public final synchronized void onScrollChanged() {
        if (this.zzfml != null) {
            this.zzfml.zzb(this.zzfmr, zzaip(), zzaiq(), zzbuj.zzx(this.zzfmr));
        }
    }

    public final synchronized Map<String, WeakReference<View>> zzaip() {
        return this.zzfmq;
    }

    public final synchronized Map<String, WeakReference<View>> zzaiq() {
        return this.zzfmq;
    }

    @Nullable
    public final synchronized Map<String, WeakReference<View>> zzair() {
        return null;
    }

    public final synchronized String zzais() {
        return this.zzfmo;
    }

    public final FrameLayout zzain() {
        return this.zzbkb;
    }

    public final zzpf zzaio() {
        return this.zzfmm;
    }

    public final synchronized void zzi(IObjectWrapper iObjectWrapper) {
        this.zzfml.setClickConfirmingView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final synchronized void zzk(IObjectWrapper iObjectWrapper) {
        if (!this.zzegn) {
            this.zzfmu = iObjectWrapper;
        }
    }

    @Nullable
    public final IObjectWrapper zzait() {
        return this.zzfmu;
    }

    public final void zzj(IObjectWrapper iObjectWrapper) {
        onTouch(this.zzfmr, (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(com.google.android.gms.internal.ads.zzabh r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.zzegn     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            r0 = 1
            r1.zzfmv = r0     // Catch:{ all -> 0x001b }
            r1.zzcwp = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.ads.zzbuj r0 = r1.zzfml     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0019
            com.google.android.gms.internal.ads.zzbuj r0 = r1.zzfml     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.ads.zzbup r0 = r0.zzahm()     // Catch:{ all -> 0x001b }
            r0.zza(r2)     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r1)
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbvh.zza(com.google.android.gms.internal.ads.zzabh):void");
    }

    public final /* synthetic */ View zzaeu() {
        return this.zzfmr;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzaiv() {
        if (this.zzfmt == null) {
            this.zzfmt = new View(this.zzfmr.getContext());
            this.zzfmt.setLayoutParams(new LayoutParams(-1, 0));
        }
        if (this.zzfmr != this.zzfmt.getParent()) {
            this.zzfmr.addView(this.zzfmt);
        }
    }
}
