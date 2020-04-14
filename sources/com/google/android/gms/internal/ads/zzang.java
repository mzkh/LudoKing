package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzq;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzang extends zzanj implements zzaer<zzbbw> {
    private float density;
    private int maxHeight = -1;
    private int maxWidth = -1;
    private int rotation;
    private final WindowManager zzbnk;
    private final zzbbw zzczi;
    private final zzyl zzdgm;
    private int zzdgn = -1;
    private int zzdgo = -1;
    private int zzdgp = -1;
    private int zzdgq = -1;
    private final Context zzlk;
    private DisplayMetrics zzwl;

    public zzang(zzbbw zzbbw, Context context, zzyl zzyl) {
        super(zzbbw);
        this.zzczi = zzbbw;
        this.zzlk = context;
        this.zzdgm = zzyl;
        this.zzbnk = (WindowManager) context.getSystemService("window");
    }

    public final void zzi(int i, int i2) {
        int i3 = 0;
        if (this.zzlk instanceof Activity) {
            i3 = zzq.zzkj().zzf((Activity) this.zzlk)[0];
        }
        if (this.zzczi.zzzn() == null || !this.zzczi.zzzn().zzaau()) {
            int width = this.zzczi.getWidth();
            int height = this.zzczi.getHeight();
            if (((Boolean) zzuv.zzon().zzd(zzza.zzcij)).booleanValue()) {
                if (width == 0 && this.zzczi.zzzn() != null) {
                    width = this.zzczi.zzzn().widthPixels;
                }
                if (height == 0 && this.zzczi.zzzn() != null) {
                    height = this.zzczi.zzzn().heightPixels;
                }
            }
            this.zzdgp = zzuv.zzoj().zzb(this.zzlk, width);
            this.zzdgq = zzuv.zzoj().zzb(this.zzlk, height);
        }
        zzc(i, i2 - i3, this.zzdgp, this.zzdgq);
        this.zzczi.zzzp().zzh(i, i2);
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        this.zzwl = new DisplayMetrics();
        Display defaultDisplay = this.zzbnk.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zzwl);
        this.density = this.zzwl.density;
        this.rotation = defaultDisplay.getRotation();
        zzuv.zzoj();
        DisplayMetrics displayMetrics = this.zzwl;
        this.zzdgn = zzawy.zzb(displayMetrics, displayMetrics.widthPixels);
        zzuv.zzoj();
        DisplayMetrics displayMetrics2 = this.zzwl;
        this.zzdgo = zzawy.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzxn = this.zzczi.zzxn();
        if (zzxn == null || zzxn.getWindow() == null) {
            this.maxWidth = this.zzdgn;
            this.maxHeight = this.zzdgo;
        } else {
            zzq.zzkj();
            int[] zzd = zzaul.zzd(zzxn);
            zzuv.zzoj();
            this.maxWidth = zzawy.zzb(this.zzwl, zzd[0]);
            zzuv.zzoj();
            this.maxHeight = zzawy.zzb(this.zzwl, zzd[1]);
        }
        if (this.zzczi.zzzn().zzaau()) {
            this.zzdgp = this.zzdgn;
            this.zzdgq = this.zzdgo;
        } else {
            this.zzczi.measure(0, 0);
        }
        zza(this.zzdgn, this.zzdgo, this.maxWidth, this.maxHeight, this.density, this.rotation);
        String str = "onDeviceFeaturesReceived";
        this.zzczi.zzb(str, new zzanf(new zzanh().zzx(this.zzdgm.zzpm()).zzw(this.zzdgm.zzpn()).zzy(this.zzdgm.zzpp()).zzz(this.zzdgm.zzpo()).zzaa(true)).toJson());
        int[] iArr = new int[2];
        this.zzczi.getLocationOnScreen(iArr);
        zzi(zzuv.zzoj().zzb(this.zzlk, iArr[0]), zzuv.zzoj().zzb(this.zzlk, iArr[1]));
        if (zzaug.isLoggable(2)) {
            zzaug.zzet("Dispatching Ready Event.");
        }
        zzdo(this.zzczi.zzxr().zzblz);
    }
}
