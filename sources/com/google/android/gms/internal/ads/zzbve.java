package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbve extends zzabs implements OnGlobalLayoutListener, OnScrollChangedListener, zzbvz {
    private final WeakReference<View> zzfmh;
    private final Map<String, WeakReference<View>> zzfmi = new HashMap();
    private final Map<String, WeakReference<View>> zzfmj = new HashMap();
    private final Map<String, WeakReference<View>> zzfmk = new HashMap();
    @GuardedBy("this")
    private zzbuj zzfml;
    private zzpf zzfmm;

    public zzbve(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        zzq.zzlg();
        zzayd.zza(view, (OnGlobalLayoutListener) this);
        zzq.zzlg();
        zzayd.zza(view, (OnScrollChangedListener) this);
        this.zzfmh = new WeakReference<>(view);
        for (Entry entry : hashMap.entrySet()) {
            String str = (String) entry.getKey();
            View view2 = (View) entry.getValue();
            if (view2 != null) {
                this.zzfmi.put(str, new WeakReference(view2));
                if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str) && !UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str)) {
                    view2.setOnTouchListener(this);
                    view2.setClickable(true);
                    view2.setOnClickListener(this);
                }
            }
        }
        this.zzfmk.putAll(this.zzfmi);
        for (Entry entry2 : hashMap2.entrySet()) {
            View view3 = (View) entry2.getValue();
            if (view3 != null) {
                this.zzfmj.put((String) entry2.getKey(), new WeakReference(view3));
                view3.setOnTouchListener(this);
                view3.setClickable(false);
            }
        }
        this.zzfmk.putAll(this.zzfmj);
        this.zzfmm = new zzpf(view.getContext(), view);
    }

    @Nullable
    public final FrameLayout zzain() {
        return null;
    }

    public final synchronized void unregisterNativeAd() {
        if (this.zzfml != null) {
            this.zzfml.zzb(this);
            this.zzfml = null;
        }
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof zzbuj)) {
            zzaug.zzeu("Not an instance of InternalNativeAd. This is most likely a transient error");
            return;
        }
        if (this.zzfml != null) {
            this.zzfml.zzb(this);
        }
        if (((zzbuj) unwrap).zzahk()) {
            this.zzfml = (zzbuj) unwrap;
            this.zzfml.zza((zzbvz) this);
            this.zzfml.zzy(zzaeu());
            return;
        }
        zzaug.zzes("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
    }

    @Nullable
    public final View zzaeu() {
        return (View) this.zzfmh.get();
    }

    public final zzpf zzaio() {
        return this.zzfmm;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(java.lang.String r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r3 != 0) goto L_0x0014
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzfmk     // Catch:{ all -> 0x0047 }
            r3.remove(r2)     // Catch:{ all -> 0x0047 }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzfmi     // Catch:{ all -> 0x0047 }
            r3.remove(r2)     // Catch:{ all -> 0x0047 }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzfmj     // Catch:{ all -> 0x0047 }
            r3.remove(r2)     // Catch:{ all -> 0x0047 }
            monitor-exit(r1)
            return
        L_0x0014:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.zzfmk     // Catch:{ all -> 0x0047 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0047 }
            r0.<init>(r3)     // Catch:{ all -> 0x0047 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0047 }
            java.lang.String r4 = "1098"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0047 }
            if (r4 != 0) goto L_0x0045
            java.lang.String r4 = "3011"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0047 }
            if (r4 == 0) goto L_0x002f
            goto L_0x0045
        L_0x002f:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.zzfmi     // Catch:{ all -> 0x0047 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0047 }
            r0.<init>(r3)     // Catch:{ all -> 0x0047 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0047 }
            r2 = 1
            r3.setClickable(r2)     // Catch:{ all -> 0x0047 }
            r3.setOnClickListener(r1)     // Catch:{ all -> 0x0047 }
            r3.setOnTouchListener(r1)     // Catch:{ all -> 0x0047 }
            monitor-exit(r1)
            return
        L_0x0045:
            monitor-exit(r1)
            return
        L_0x0047:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbve.zza(java.lang.String, android.view.View, boolean):void");
    }

    public final synchronized Map<String, WeakReference<View>> zzaip() {
        return this.zzfmk;
    }

    public final synchronized Map<String, WeakReference<View>> zzaiq() {
        return this.zzfmi;
    }

    @Nullable
    public final synchronized Map<String, WeakReference<View>> zzair() {
        return this.zzfmj;
    }

    public final synchronized View zzfw(String str) {
        WeakReference weakReference = (WeakReference) this.zzfmk.get(str);
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    public final synchronized String zzais() {
        return NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
    }

    @Nullable
    public final synchronized IObjectWrapper zzait() {
        return null;
    }

    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zzfml != null) {
            this.zzfml.zza(view, motionEvent, zzaeu());
        }
        return false;
    }

    public final synchronized void onClick(View view) {
        if (this.zzfml != null) {
            this.zzfml.zza(view, zzaeu(), zzaip(), zzaiq(), true);
        }
    }

    public final synchronized void onGlobalLayout() {
        if (this.zzfml != null) {
            this.zzfml.zzb(zzaeu(), zzaip(), zzaiq(), zzbuj.zzx(zzaeu()));
        }
    }

    public final synchronized void onScrollChanged() {
        if (this.zzfml != null) {
            this.zzfml.zzb(zzaeu(), zzaip(), zzaiq(), zzbuj.zzx(zzaeu()));
        }
    }

    public final synchronized void zzi(IObjectWrapper iObjectWrapper) {
        if (this.zzfml != null) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (!(unwrap instanceof View)) {
                zzaug.zzeu("Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object");
            }
            this.zzfml.setClickConfirmingView((View) unwrap);
        }
    }
}
