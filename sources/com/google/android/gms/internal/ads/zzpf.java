package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@TargetApi(14)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzpf implements ActivityLifecycleCallbacks, OnAttachStateChangeListener, OnGlobalLayoutListener, OnScrollChangedListener {
    private static final long zzbnj = ((Long) zzuv.zzon().zzd(zzza.zzclx)).longValue();
    private final WindowManager zzbnk;
    @Nullable
    @VisibleForTesting
    private BroadcastReceiver zzbnl;
    private WeakReference<View> zzbnm;
    private zzpm zzbnn;
    private zzawo zzbno = new zzawo(zzbnj);
    private boolean zzbnp = false;
    private final HashSet<zzpj> zzbnq = new HashSet<>();
    private final Rect zzbnr;
    private final DisplayMetrics zzwl;
    private Application zzxh;
    private final Context zzzc;
    private final PowerManager zzzd;
    private final KeyguardManager zzze;
    private WeakReference<ViewTreeObserver> zzzg;
    private int zzzk = -1;

    public zzpf(Context context, View view) {
        this.zzzc = context.getApplicationContext();
        this.zzbnk = (WindowManager) context.getSystemService("window");
        this.zzzd = (PowerManager) this.zzzc.getSystemService("power");
        this.zzze = (KeyguardManager) context.getSystemService("keyguard");
        Context context2 = this.zzzc;
        if (context2 instanceof Application) {
            this.zzxh = (Application) context2;
            this.zzbnn = new zzpm((Application) context2, this);
        }
        this.zzwl = context.getResources().getDisplayMetrics();
        this.zzbnr = new Rect();
        this.zzbnr.right = this.zzbnk.getDefaultDisplay().getWidth();
        this.zzbnr.bottom = this.zzbnk.getDefaultDisplay().getHeight();
        WeakReference<View> weakReference = this.zzbnm;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzf(view2);
        }
        this.zzbnm = new WeakReference<>(view);
        if (view != null) {
            if (zzq.zzkl().isAttachedToWindow(view)) {
                zze(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    public final void zza(zzpj zzpj) {
        this.zzbnq.add(zzpj);
        zzbm(3);
    }

    public final void zzb(zzpj zzpj) {
        this.zzbnq.remove(zzpj);
    }

    private final void zzcr() {
        zzaul.zzdsu.post(new zzpi(this));
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzzk = -1;
        zze(view);
        zzbm(3);
    }

    public final void onViewDetachedFromWindow(View view) {
        this.zzzk = -1;
        zzbm(3);
        zzcr();
        zzf(view);
    }

    private final void zza(Activity activity, int i) {
        if (this.zzbnm != null) {
            Window window = activity.getWindow();
            if (window != null) {
                View peekDecorView = window.peekDecorView();
                View view = (View) this.zzbnm.get();
                if (!(view == null || peekDecorView == null || view.getRootView() != peekDecorView.getRootView())) {
                    this.zzzk = i;
                }
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(activity, 0);
        zzbm(3);
        zzcr();
    }

    public final void onActivityStarted(Activity activity) {
        zza(activity, 0);
        zzbm(3);
        zzcr();
    }

    public final void onActivityResumed(Activity activity) {
        zza(activity, 0);
        zzbm(3);
        zzcr();
    }

    public final void onActivityPaused(Activity activity) {
        zza(activity, 4);
        zzbm(3);
        zzcr();
    }

    public final void onActivityStopped(Activity activity) {
        zzbm(3);
        zzcr();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzbm(3);
        zzcr();
    }

    public final void onActivityDestroyed(Activity activity) {
        zzbm(3);
        zzcr();
    }

    public final void onGlobalLayout() {
        zzbm(2);
        zzcr();
    }

    public final void onScrollChanged() {
        zzbm(1);
    }

    /* access modifiers changed from: private */
    public final void zzbm(int i) {
        boolean z;
        boolean z2;
        List list;
        int i2 = i;
        if (this.zzbnq.size() != 0) {
            WeakReference<View> weakReference = this.zzbnm;
            if (weakReference != null) {
                View view = (View) weakReference.get();
                boolean z3 = i2 == 1;
                boolean z4 = view == null;
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                Rect rect3 = new Rect();
                Rect rect4 = new Rect();
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                if (view != null) {
                    boolean globalVisibleRect = view.getGlobalVisibleRect(rect2);
                    boolean localVisibleRect = view.getLocalVisibleRect(rect3);
                    view.getHitRect(rect4);
                    try {
                        view.getLocationOnScreen(iArr);
                        view.getLocationInWindow(iArr2);
                    } catch (Exception e) {
                        zzaug.zzc("Failure getting view location.", e);
                    }
                    rect.left = iArr[0];
                    rect.top = iArr[1];
                    rect.right = rect.left + view.getWidth();
                    rect.bottom = rect.top + view.getHeight();
                    z2 = globalVisibleRect;
                    z = localVisibleRect;
                } else {
                    z2 = false;
                    z = false;
                }
                if (!((Boolean) zzuv.zzon().zzd(zzza.zzcma)).booleanValue() || view == null) {
                    list = Collections.emptyList();
                } else {
                    list = zzh(view);
                }
                List list2 = list;
                int windowVisibility = view != null ? view.getWindowVisibility() : 8;
                int i3 = this.zzzk;
                if (i3 != -1) {
                    windowVisibility = i3;
                }
                boolean z5 = !z4 && zzq.zzkj().zza(view, this.zzzd, this.zzze) && z2 && z && windowVisibility == 0;
                if (z3 && !this.zzbno.tryAcquire() && z5 == this.zzbnp) {
                    return;
                }
                if (z5 || this.zzbnp || i2 != 1) {
                    zzpk zzpk = new zzpk(zzq.zzkq().elapsedRealtime(), this.zzzd.isScreenOn(), view != null && zzq.zzkl().isAttachedToWindow(view), view != null ? view.getWindowVisibility() : 8, zza(this.zzbnr), zza(rect), zza(rect2), z2, zza(rect3), z, zza(rect4), this.zzwl.density, z5, list2);
                    Iterator it = this.zzbnq.iterator();
                    while (it.hasNext()) {
                        ((zzpj) it.next()).zza(zzpk);
                    }
                    this.zzbnp = z5;
                }
            }
        }
    }

    private final Rect zza(Rect rect) {
        return new Rect(zzbn(rect.left), zzbn(rect.top), zzbn(rect.right), zzbn(rect.bottom));
    }

    private final int zzbn(int i) {
        return (int) (((float) i) / this.zzwl.density);
    }

    private final List<Rect> zzh(View view) {
        boolean z;
        try {
            ArrayList arrayList = new ArrayList();
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                View view2 = (View) parent;
                Rect rect = new Rect();
                if (VERSION.SDK_INT >= 16) {
                    z = view2.isScrollContainer();
                } else {
                    if (!(view2 instanceof ScrollView)) {
                        if (!(view2 instanceof ListView)) {
                            z = false;
                        }
                    }
                    z = true;
                }
                if (z && view2.getGlobalVisibleRect(rect)) {
                    arrayList.add(zza(rect));
                }
            }
            return arrayList;
        } catch (Exception e) {
            zzq.zzkn().zza(e, "PositionWatcher.getParentScrollViewRects");
            return Collections.emptyList();
        }
    }

    private final void zze(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzzg = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zzbnl == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zzbnl = new zzph(this);
            zzq.zzle().zza(this.zzzc, this.zzbnl, intentFilter);
        }
        Application application = this.zzxh;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzbnn);
            } catch (Exception e) {
                zzaug.zzc("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    private final void zzf(View view) {
        try {
            if (this.zzzg != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.zzzg.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzzg = null;
            }
        } catch (Exception e) {
            zzaug.zzc("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e2) {
            zzaug.zzc("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        if (this.zzbnl != null) {
            try {
                zzq.zzle().zza(this.zzzc, this.zzbnl);
            } catch (IllegalStateException e3) {
                zzaug.zzc("Failed trying to unregister the receiver", e3);
            } catch (Exception e4) {
                zzq.zzkn().zza(e4, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.zzbnl = null;
        }
        Application application = this.zzxh;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzbnn);
            } catch (Exception e5) {
                zzaug.zzc("Error registering activity lifecycle callbacks.", e5);
            }
        }
    }

    public final void zzeh(long j) {
        this.zzbno.zzev(j);
    }

    public final void zzli() {
        this.zzbno.zzev(zzbnj);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzlj() {
        zzbm(3);
    }
}
