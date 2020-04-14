package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzawv {
    private final View view;
    private boolean zzbny;
    private boolean zzbsc;
    private Activity zzdvj;
    private boolean zzdvk;
    private OnGlobalLayoutListener zzdvl;
    private OnScrollChangedListener zzdvm = null;

    public zzawv(Activity activity, View view2, OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
        this.zzdvj = activity;
        this.view = view2;
        this.zzdvl = onGlobalLayoutListener;
    }

    public final void zzh(Activity activity) {
        this.zzdvj = activity;
    }

    public final void zzwf() {
        this.zzbsc = true;
        if (this.zzbny) {
            zzwh();
        }
    }

    public final void zzwg() {
        this.zzbsc = false;
        zzwi();
    }

    public final void onAttachedToWindow() {
        this.zzbny = true;
        if (this.zzbsc) {
            zzwh();
        }
    }

    public final void onDetachedFromWindow() {
        this.zzbny = false;
        zzwi();
    }

    private final void zzwh() {
        if (!this.zzdvk) {
            OnGlobalLayoutListener onGlobalLayoutListener = this.zzdvl;
            if (onGlobalLayoutListener != null) {
                Activity activity = this.zzdvj;
                if (activity != null) {
                    ViewTreeObserver zzi = zzi(activity);
                    if (zzi != null) {
                        zzi.addOnGlobalLayoutListener(onGlobalLayoutListener);
                    }
                }
                zzq.zzlg();
                zzayd.zza(this.view, this.zzdvl);
            }
            this.zzdvk = true;
        }
    }

    private final void zzwi() {
        Activity activity = this.zzdvj;
        if (activity != null && this.zzdvk) {
            OnGlobalLayoutListener onGlobalLayoutListener = this.zzdvl;
            if (onGlobalLayoutListener != null) {
                ViewTreeObserver zzi = zzi(activity);
                if (zzi != null) {
                    zzq.zzkl();
                    zzi.removeOnGlobalLayoutListener(onGlobalLayoutListener);
                }
            }
            this.zzdvk = false;
        }
    }

    private static ViewTreeObserver zzi(Activity activity) {
        if (activity == null) {
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            return null;
        }
        View decorView = window.getDecorView();
        if (decorView == null) {
            return null;
        }
        return decorView.getViewTreeObserver();
    }
}
