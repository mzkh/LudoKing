package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzann;
import com.google.android.gms.internal.ads.zzaug;
import com.google.android.gms.internal.ads.zzaul;
import com.google.android.gms.internal.ads.zzaur;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbcb;
import com.google.android.gms.internal.ads.zzbdf;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzsd;
import com.google.android.gms.internal.ads.zzuv;
import com.google.android.gms.internal.ads.zzza;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzc extends zzann implements zzy {
    @VisibleForTesting
    private static final int zzdgu = Color.argb(0, 0, 0, 0);
    @VisibleForTesting
    private boolean zzbkw = false;
    @VisibleForTesting
    zzbbw zzczi;
    @VisibleForTesting
    AdOverlayInfoParcel zzdgv;
    @VisibleForTesting
    private zzi zzdgw;
    @VisibleForTesting
    private zzq zzdgx;
    @VisibleForTesting
    private boolean zzdgy = false;
    @VisibleForTesting
    private FrameLayout zzdgz;
    @VisibleForTesting
    private CustomViewCallback zzdha;
    @VisibleForTesting
    private boolean zzdhb = false;
    @VisibleForTesting
    private zzj zzdhc;
    @VisibleForTesting
    private boolean zzdhd = false;
    @VisibleForTesting
    int zzdhe = 0;
    private final Object zzdhf = new Object();
    private Runnable zzdhg;
    private boolean zzdhh;
    private boolean zzdhi;
    private boolean zzdhj = false;
    private boolean zzdhk = false;
    private boolean zzdhl = true;
    protected final Activity zzzr;

    public zzc(Activity activity) {
        this.zzzr = activity;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void onRestart() {
    }

    public final void close() {
        this.zzdhe = 2;
        this.zzzr.finish();
    }

    public final void zzsn() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdgv;
        if (adOverlayInfoParcel != null && this.zzdgy) {
            setRequestedOrientation(adOverlayInfoParcel.orientation);
        }
        if (this.zzdgz != null) {
            this.zzzr.setContentView(this.zzdhc);
            this.zzdhi = true;
            this.zzdgz.removeAllViews();
            this.zzdgz = null;
        }
        CustomViewCallback customViewCallback = this.zzdha;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzdha = null;
        }
        this.zzdgy = false;
    }

    public final void zzso() {
        this.zzdhe = 1;
        this.zzzr.finish();
    }

    public final void onBackPressed() {
        this.zzdhe = 0;
    }

    public final boolean zzsp() {
        this.zzdhe = 0;
        zzbbw zzbbw = this.zzczi;
        if (zzbbw == null) {
            return true;
        }
        boolean zzzw = zzbbw.zzzw();
        if (!zzzw) {
            this.zzczi.zza("onbackblocked", Collections.emptyMap());
        }
        return zzzw;
    }

    public void onCreate(Bundle bundle) {
        this.zzzr.requestWindowFeature(1);
        this.zzdhb = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            this.zzdgv = AdOverlayInfoParcel.zzc(this.zzzr.getIntent());
            if (this.zzdgv != null) {
                if (this.zzdgv.zzblk.zzdwf > 7500000) {
                    this.zzdhe = 3;
                }
                if (this.zzzr.getIntent() != null) {
                    this.zzdhl = this.zzzr.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
                }
                if (this.zzdgv.zzdif != null) {
                    this.zzbkw = this.zzdgv.zzdif.zzbkw;
                } else {
                    this.zzbkw = false;
                }
                if (this.zzbkw && this.zzdgv.zzdif.zzblb != -1) {
                    new zzl(this).zzut();
                }
                if (bundle == null) {
                    if (this.zzdgv.zzdhy != null && this.zzdhl) {
                        this.zzdgv.zzdhy.zzsj();
                    }
                    if (!(this.zzdgv.zzdid == 1 || this.zzdgv.zzcbs == null)) {
                        this.zzdgv.zzcbs.onAdClicked();
                    }
                }
                this.zzdhc = new zzj(this.zzzr, this.zzdgv.zzdie, this.zzdgv.zzblk.zzblz);
                this.zzdhc.setId(1000);
                zzq.zzkl().zzg(this.zzzr);
                int i = this.zzdgv.zzdid;
                if (i == 1) {
                    zzac(false);
                } else if (i == 2) {
                    this.zzdgw = new zzi(this.zzdgv.zzczi);
                    zzac(false);
                } else if (i == 3) {
                    zzac(true);
                } else {
                    throw new zzg("Could not determine ad overlay type.");
                }
            } else {
                throw new zzg("Could not get info for ad overlay.");
            }
        } catch (zzg e) {
            zzaug.zzeu(e.getMessage());
            this.zzdhe = 3;
            this.zzzr.finish();
        }
    }

    public final void onStart() {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcqi)).booleanValue()) {
            zzbbw zzbbw = this.zzczi;
            if (zzbbw == null || zzbbw.isDestroyed()) {
                zzaug.zzeu("The webview does not exist. Ignoring action.");
            } else {
                zzq.zzkl();
                zzaur.zzb(this.zzczi);
            }
        }
    }

    public final void onResume() {
        if (this.zzdgv.zzdhy != null) {
            this.zzdgv.zzdhy.onResume();
        }
        zza(this.zzzr.getResources().getConfiguration());
        if (!((Boolean) zzuv.zzon().zzd(zzza.zzcqi)).booleanValue()) {
            zzbbw zzbbw = this.zzczi;
            if (zzbbw == null || zzbbw.isDestroyed()) {
                zzaug.zzeu("The webview does not exist. Ignoring action.");
            } else {
                zzq.zzkl();
                zzaur.zzb(this.zzczi);
            }
        }
    }

    public final void onPause() {
        zzsn();
        if (this.zzdgv.zzdhy != null) {
            this.zzdgv.zzdhy.onPause();
        }
        if (!((Boolean) zzuv.zzon().zzd(zzza.zzcqi)).booleanValue() && this.zzczi != null && (!this.zzzr.isFinishing() || this.zzdgw == null)) {
            zzq.zzkl();
            zzaur.zza(this.zzczi);
        }
        zzsr();
    }

    public final void zzag(IObjectWrapper iObjectWrapper) {
        zza((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzdhb);
    }

    public final void onStop() {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcqi)).booleanValue() && this.zzczi != null && (!this.zzzr.isFinishing() || this.zzdgw == null)) {
            zzq.zzkl();
            zzaur.zza(this.zzczi);
        }
        zzsr();
    }

    public final void onDestroy() {
        zzbbw zzbbw = this.zzczi;
        if (zzbbw != null) {
            this.zzdhc.removeView(zzbbw.getView());
        }
        zzsr();
    }

    private final void zzab(boolean z) {
        int intValue = ((Integer) zzuv.zzon().zzd(zzza.zzcqk)).intValue();
        zzp zzp = new zzp();
        zzp.size = 50;
        zzp.paddingLeft = z ? intValue : 0;
        zzp.paddingRight = z ? 0 : intValue;
        zzp.paddingTop = 0;
        zzp.paddingBottom = intValue;
        this.zzdgx = new zzq(this.zzzr, zzp, this);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        zza(z, this.zzdgv.zzdia);
        this.zzdhc.addView(this.zzdgx, layoutParams);
    }

    public final void zzda() {
        this.zzdhi = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(boolean r7, boolean r8) {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzyp<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzza.zzcku
            com.google.android.gms.internal.ads.zzyw r1 = com.google.android.gms.internal.ads.zzuv.zzon()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0026
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r6.zzdgv
            if (r0 == 0) goto L_0x0026
            com.google.android.gms.ads.internal.zzg r0 = r0.zzdif
            if (r0 == 0) goto L_0x0026
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r6.zzdgv
            com.google.android.gms.ads.internal.zzg r0 = r0.zzdif
            boolean r0 = r0.zzbld
            if (r0 == 0) goto L_0x0026
            r0 = 1
            goto L_0x0027
        L_0x0026:
            r0 = 0
        L_0x0027:
            com.google.android.gms.internal.ads.zzyp<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzza.zzckv
            com.google.android.gms.internal.ads.zzyw r4 = com.google.android.gms.internal.ads.zzuv.zzon()
            java.lang.Object r3 = r4.zzd(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x004b
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r6.zzdgv
            if (r3 == 0) goto L_0x004b
            com.google.android.gms.ads.internal.zzg r3 = r3.zzdif
            if (r3 == 0) goto L_0x004b
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r6.zzdgv
            com.google.android.gms.ads.internal.zzg r3 = r3.zzdif
            boolean r3 = r3.zzble
            if (r3 == 0) goto L_0x004b
            r3 = 1
            goto L_0x004c
        L_0x004b:
            r3 = 0
        L_0x004c:
            if (r7 == 0) goto L_0x0062
            if (r8 == 0) goto L_0x0062
            if (r0 == 0) goto L_0x0062
            if (r3 != 0) goto L_0x0062
            com.google.android.gms.internal.ads.zzanj r7 = new com.google.android.gms.internal.ads.zzanj
            com.google.android.gms.internal.ads.zzbbw r4 = r6.zzczi
            java.lang.String r5 = "useCustomClose"
            r7.<init>(r4, r5)
            java.lang.String r4 = "Custom close has been disabled for interstitial ads in this ad slot."
            r7.zzdn(r4)
        L_0x0062:
            com.google.android.gms.ads.internal.overlay.zzq r7 = r6.zzdgx
            if (r7 == 0) goto L_0x0071
            if (r3 != 0) goto L_0x006e
            if (r8 == 0) goto L_0x006d
            if (r0 != 0) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r1 = 0
        L_0x006e:
            r7.zzae(r1)
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzc.zza(boolean, boolean):void");
    }

    public final void zzsq() {
        this.zzdhc.removeView(this.zzdgx);
        zzab(true);
    }

    public final void setRequestedOrientation(int i) {
        if (this.zzzr.getApplicationInfo().targetSdkVersion >= ((Integer) zzuv.zzon().zzd(zzza.zzcsn)).intValue()) {
            if (this.zzzr.getApplicationInfo().targetSdkVersion <= ((Integer) zzuv.zzon().zzd(zzza.zzcso)).intValue()) {
                if (VERSION.SDK_INT >= ((Integer) zzuv.zzon().zzd(zzza.zzcsp)).intValue()) {
                    if (VERSION.SDK_INT <= ((Integer) zzuv.zzon().zzd(zzza.zzcsq)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.zzzr.setRequestedOrientation(i);
        } catch (Throwable th) {
            zzq.zzkn().zzb(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zza(View view, CustomViewCallback customViewCallback) {
        this.zzdgz = new FrameLayout(this.zzzr);
        this.zzdgz.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.zzdgz.addView(view, -1, -1);
        this.zzzr.setContentView(this.zzdgz);
        this.zzdhi = true;
        this.zzdha = customViewCallback;
        this.zzdgy = true;
    }

    private final void zzac(boolean z) throws zzg {
        if (!this.zzdhi) {
            this.zzzr.requestWindowFeature(1);
        }
        Window window = this.zzzr.getWindow();
        if (window != null) {
            zzbdg zzzp = this.zzdgv.zzczi != null ? this.zzdgv.zzczi.zzzp() : null;
            boolean z2 = false;
            boolean z3 = zzzp != null && zzzp.zzyw();
            this.zzdhd = false;
            if (z3) {
                int i = this.zzdgv.orientation;
                zzq.zzkl();
                if (i == 6) {
                    if (this.zzzr.getResources().getConfiguration().orientation == 1) {
                        z2 = true;
                    }
                    this.zzdhd = z2;
                } else {
                    int i2 = this.zzdgv.orientation;
                    zzq.zzkl();
                    if (i2 == 7) {
                        if (this.zzzr.getResources().getConfiguration().orientation == 2) {
                            z2 = true;
                        }
                        this.zzdhd = z2;
                    }
                }
            }
            boolean z4 = this.zzdhd;
            StringBuilder sb = new StringBuilder(46);
            sb.append("Delay onShow to next orientation change: ");
            sb.append(z4);
            zzaug.zzdv(sb.toString());
            setRequestedOrientation(this.zzdgv.orientation);
            zzq.zzkl();
            window.setFlags(16777216, 16777216);
            zzaug.zzdv("Hardware acceleration on the AdActivity window enabled.");
            if (!this.zzbkw) {
                this.zzdhc.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            } else {
                this.zzdhc.setBackgroundColor(zzdgu);
            }
            this.zzzr.setContentView(this.zzdhc);
            this.zzdhi = true;
            if (z) {
                try {
                    zzq.zzkk();
                    this.zzczi = zzbcb.zza(this.zzzr, this.zzdgv.zzczi != null ? this.zzdgv.zzczi.zzzn() : null, this.zzdgv.zzczi != null ? this.zzdgv.zzczi.zzzo() : null, true, z3, null, this.zzdgv.zzblk, null, null, this.zzdgv.zzczi != null ? this.zzdgv.zzczi.zzxo() : null, zzsd.zzmm(), null, false);
                    this.zzczi.zzzp().zza(null, this.zzdgv.zzcxc, null, this.zzdgv.zzcxd, this.zzdgv.zzdic, true, null, this.zzdgv.zzczi != null ? this.zzdgv.zzczi.zzzp().zzyv() : null, null, null);
                    this.zzczi.zzzp().zza((zzbdf) new zzf(this));
                    if (this.zzdgv.url != null) {
                        this.zzczi.loadUrl(this.zzdgv.url);
                    } else if (this.zzdgv.zzdib != null) {
                        this.zzczi.loadDataWithBaseURL(this.zzdgv.zzdhz, this.zzdgv.zzdib, "text/html", "UTF-8", null);
                    } else {
                        throw new zzg("No URL or HTML to display in ad overlay.");
                    }
                    if (this.zzdgv.zzczi != null) {
                        this.zzdgv.zzczi.zzb(this);
                    }
                } catch (Exception e) {
                    zzaug.zzc("Error obtaining webview.", e);
                    throw new zzg("Could not obtain webview for the overlay.");
                }
            } else {
                this.zzczi = this.zzdgv.zzczi;
                this.zzczi.zzbr(this.zzzr);
            }
            this.zzczi.zza(this);
            if (this.zzdgv.zzczi != null) {
                zzc(this.zzdgv.zzczi.zzzt(), this.zzdhc);
            }
            ViewParent parent = this.zzczi.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.zzczi.getView());
            }
            if (this.zzbkw) {
                this.zzczi.zzaab();
            }
            this.zzczi.zza(null, this.zzzr, this.zzdgv.zzdhz, this.zzdgv.zzdib);
            this.zzdhc.addView(this.zzczi.getView(), -1, -1);
            if (!z && !this.zzdhd) {
                zzsu();
            }
            zzab(z3);
            if (this.zzczi.zzzr()) {
                zza(z3, true);
                return;
            }
            return;
        }
        throw new zzg("Invalid activity, no window available.");
    }

    private final void zzsr() {
        if (this.zzzr.isFinishing() && !this.zzdhj) {
            this.zzdhj = true;
            zzbbw zzbbw = this.zzczi;
            if (zzbbw != null) {
                zzbbw.zzdb(this.zzdhe);
                synchronized (this.zzdhf) {
                    if (!this.zzdhh && this.zzczi.zzzx()) {
                        this.zzdhg = new zze(this);
                        zzaul.zzdsu.postDelayed(this.zzdhg, ((Long) zzuv.zzon().zzd(zzza.zzckt)).longValue());
                        return;
                    }
                }
            }
            zzss();
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public final void zzss() {
        if (!this.zzdhk) {
            this.zzdhk = true;
            zzbbw zzbbw = this.zzczi;
            if (zzbbw != null) {
                this.zzdhc.removeView(zzbbw.getView());
                zzi zzi = this.zzdgw;
                if (zzi != null) {
                    this.zzczi.zzbr(zzi.zzlk);
                    this.zzczi.zzas(false);
                    this.zzdgw.parent.addView(this.zzczi.getView(), this.zzdgw.index, this.zzdgw.zzdhr);
                    this.zzdgw = null;
                } else if (this.zzzr.getApplicationContext() != null) {
                    this.zzczi.zzbr(this.zzzr.getApplicationContext());
                }
                this.zzczi = null;
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.zzdgv;
            if (!(adOverlayInfoParcel == null || adOverlayInfoParcel.zzdhy == null)) {
                this.zzdgv.zzdhy.zzsi();
            }
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdgv;
            if (!(adOverlayInfoParcel2 == null || adOverlayInfoParcel2.zzczi == null)) {
                zzc(this.zzdgv.zzczi.zzzt(), this.zzdgv.zzczi.getView());
            }
        }
    }

    private static void zzc(@Nullable IObjectWrapper iObjectWrapper, @Nullable View view) {
        if (iObjectWrapper != null && view != null) {
            zzq.zzky().zza(iObjectWrapper, view);
        }
    }

    public final void zzst() {
        if (this.zzdhd) {
            this.zzdhd = false;
            zzsu();
        }
    }

    private final void zzsu() {
        this.zzczi.zzsu();
    }

    public final void zzsv() {
        this.zzdhc.zzdht = true;
    }

    public final void zzsw() {
        synchronized (this.zzdhf) {
            this.zzdhh = true;
            if (this.zzdhg != null) {
                zzaul.zzdsu.removeCallbacks(this.zzdhg);
                zzaul.zzdsu.post(this.zzdhg);
            }
        }
    }

    private final void zza(Configuration configuration) {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdgv;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = (adOverlayInfoParcel == null || adOverlayInfoParcel.zzdif == null || !this.zzdgv.zzdif.zzbkx) ? false : true;
        boolean zza = zzq.zzkl().zza(this.zzzr, configuration);
        if ((this.zzbkw && !z3) || zza) {
            z = false;
        } else if (VERSION.SDK_INT >= 19) {
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdgv;
            if (!(adOverlayInfoParcel2 == null || adOverlayInfoParcel2.zzdif == null || !this.zzdgv.zzdif.zzblc)) {
                z2 = true;
            }
        }
        Window window = this.zzzr.getWindow();
        if (!((Boolean) zzuv.zzon().zzd(zzza.zzckw)).booleanValue() || VERSION.SDK_INT < 19) {
            if (z) {
                window.addFlags(1024);
                window.clearFlags(2048);
                if (VERSION.SDK_INT >= 19 && z2) {
                    window.getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
                    return;
                }
            } else {
                window.addFlags(2048);
                window.clearFlags(1024);
            }
            return;
        }
        View decorView = window.getDecorView();
        int i = 256;
        if (z) {
            i = 5380;
            if (z2) {
                i = 5894;
            }
        }
        decorView.setSystemUiVisibility(i);
    }
}
