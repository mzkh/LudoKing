package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzc;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbzn {
    private final zzasi zzbks;
    private final zzdf zzegb;
    private final Executor zzfbx;
    /* access modifiers changed from: private */
    public final zzbnr zzffv;
    private final zzboo zzfio;
    private final zzbmv zzfjn;
    private final zzbhk zzfjo;
    private final zzbqv zzfjq;
    private final zzbof zzfpy;
    private final zzbpf zzfpz;
    private final zzc zzfqp;
    private final zzbnl zzfqq;
    /* access modifiers changed from: private */
    public final zzbpb zzfqr;

    public zzbzn(zzbmv zzbmv, zzbnr zzbnr, zzbof zzbof, zzboo zzboo, zzbpf zzbpf, Executor executor, zzbqv zzbqv, zzbhk zzbhk, zzc zzc, zzbnl zzbnl, @Nullable zzasi zzasi, zzdf zzdf, zzbpb zzbpb) {
        this.zzfjn = zzbmv;
        this.zzffv = zzbnr;
        this.zzfpy = zzbof;
        this.zzfio = zzboo;
        this.zzfpz = zzbpf;
        this.zzfbx = executor;
        this.zzfjq = zzbqv;
        this.zzfjo = zzbhk;
        this.zzfqp = zzc;
        this.zzfqq = zzbnl;
        this.zzbks = zzasi;
        this.zzegb = zzdf;
        this.zzfqr = zzbpb;
    }

    public final void zzb(zzbbw zzbbw, boolean z) {
        zzbbw.zzzp().zza(new zzbzm(this), this.zzfpy, this.zzfio, new zzbzp(this), new zzbzo(this), z, null, this.zzfqp, new zzbzx(this), this.zzbks);
        zzbbw.setOnTouchListener(new zzbzr(this));
        zzbbw.setOnClickListener(new zzbzq(this));
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcnb)).booleanValue()) {
            zzdc zzcd = this.zzegb.zzcd();
            if (zzcd != null) {
                zzcd.zzb(zzbbw.getView());
            }
        }
        this.zzfjq.zza(zzbbw, this.zzfbx);
        this.zzfjq.zza(new zzbzt(zzbbw), this.zzfbx);
        this.zzfjq.zzq(zzbbw.getView());
        zzbbw.zza("/trackActiveViewUnit", (zzaer<? super zzbbw>) new zzbzs<Object>(this, zzbbw));
        this.zzfjo.zzo(zzbbw);
        if (!((Boolean) zzuv.zzon().zzd(zzza.zzckg)).booleanValue()) {
            zzbnl zzbnl = this.zzfqq;
            zzbbw.getClass();
            zzbnl.zza(zzbzv.zzn(zzbbw), this.zzfbx);
        }
    }

    public static zzddi<?> zza(zzbbw zzbbw, String str, String str2) {
        zzaxv zzaxv = new zzaxv();
        zzbbw.zzzp().zza((zzbdf) new zzbzu(zzaxv));
        zzbbw.zzb(str, str2, null);
        return zzaxv;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(zzbbw zzbbw, zzbbw zzbbw2, Map map) {
        this.zzfjo.zzf(zzbbw);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzac(View view) {
        this.zzfqp.recordClick();
        zzasi zzasi = this.zzbks;
        if (zzasi != null) {
            zzasi.zzto();
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ boolean zza(View view, MotionEvent motionEvent) {
        this.zzfqp.recordClick();
        zzasi zzasi = this.zzbks;
        if (zzasi != null) {
            zzasi.zzto();
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzajk() {
        this.zzffv.onAdLeftApplication();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzq(String str, String str2) {
        this.zzfpz.onAppEvent(str, str2);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzajl() {
        this.zzfjn.onAdClicked();
    }
}
