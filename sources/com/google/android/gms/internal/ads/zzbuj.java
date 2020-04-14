package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbuj extends zzbkk {
    private final zzaxl zzblk;
    private final zzdf zzegb;
    private final Executor zzfbx;
    private final zzbuy zzfdo;
    private final zzasm zzfff;
    private final zzbur zzfjl;
    private final zzbuz zzfkp;
    private final zzbvj zzfkq;
    private final zzbuv zzfkr;
    private final zzdvv<zzbxz> zzfks;
    private final zzdvv<zzbxx> zzfkt;
    private final zzdvv<zzbyc> zzfku;
    private final zzdvv<zzbxs> zzfkv;
    private final zzdvv<zzbyb> zzfkw;
    private zzbvz zzfkx;
    private boolean zzfky;
    private final zzbup zzfkz;
    private final Context zzlk;

    public zzbuj(zzbkn zzbkn, Executor executor, zzbur zzbur, zzbuz zzbuz, zzbvj zzbvj, zzbuv zzbuv, zzbuy zzbuy, zzdvv<zzbxz> zzdvv, zzdvv<zzbxx> zzdvv2, zzdvv<zzbyc> zzdvv3, zzdvv<zzbxs> zzdvv4, zzdvv<zzbyb> zzdvv5, zzasm zzasm, zzdf zzdf, zzaxl zzaxl, Context context, zzbup zzbup) {
        super(zzbkn);
        this.zzfbx = executor;
        this.zzfjl = zzbur;
        this.zzfkp = zzbuz;
        this.zzfkq = zzbvj;
        this.zzfkr = zzbuv;
        this.zzfdo = zzbuy;
        this.zzfks = zzdvv;
        this.zzfkt = zzdvv2;
        this.zzfku = zzdvv3;
        this.zzfkv = zzdvv4;
        this.zzfkw = zzdvv5;
        this.zzfff = zzasm;
        this.zzegb = zzdf;
        this.zzblk = zzaxl;
        this.zzlk = context;
        this.zzfkz = zzbup;
    }

    @AnyThread
    public final void zzafa() {
        this.zzfbx.execute(new zzbui(this));
        if (this.zzfjl.zzahp() != 7) {
            Executor executor = this.zzfbx;
            zzbuz zzbuz = this.zzfkp;
            zzbuz.getClass();
            executor.execute(zzbul.zza(zzbuz));
        }
        super.zzafa();
    }

    public final synchronized void zzfp(String str) {
        this.zzfkp.zzfp(str);
    }

    public final synchronized void zzahd() {
        if (!this.zzfky) {
            this.zzfkp.zzahd();
        }
    }

    public final synchronized void zzf(Bundle bundle) {
        this.zzfkp.zzf(bundle);
    }

    public final synchronized boolean zzh(Bundle bundle) {
        if (this.zzfky) {
            return true;
        }
        boolean zzh = this.zzfkp.zzh(bundle);
        this.zzfky = zzh;
        return zzh;
    }

    public final synchronized void zzg(Bundle bundle) {
        this.zzfkp.zzg(bundle);
    }

    public final synchronized void destroy() {
        this.zzfbx.execute(new zzbuk(this));
        super.destroy();
    }

    public final synchronized void zza(zzbvz zzbvz) {
        this.zzfkx = zzbvz;
        this.zzfkq.zza(zzbvz);
        this.zzfkp.zza(zzbvz.zzaeu(), zzbvz.zzaiq(), zzbvz.zzair(), (OnTouchListener) zzbvz, (OnClickListener) zzbvz);
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcnb)).booleanValue()) {
            zzdc zzcd = this.zzegb.zzcd();
            if (zzcd != null) {
                zzcd.zzb(zzbvz.zzaeu());
            }
        }
        if (zzbvz.zzaio() != null) {
            zzbvz.zzaio().zza((zzpj) this.zzfff);
        }
    }

    public final synchronized void zzb(zzbvz zzbvz) {
        this.zzfkp.zza(zzbvz.zzaeu(), zzbvz.zzaip());
        if (zzbvz.zzain() != null) {
            zzbvz.zzain().setClickable(false);
            zzbvz.zzain().removeAllViews();
        }
        if (zzbvz.zzaio() != null) {
            zzbvz.zzaio().zzb(this.zzfff);
        }
        this.zzfkx = null;
    }

    public final synchronized void zza(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcsx)).booleanValue()) {
            this.zzfkq.zzc(this.zzfkx);
        }
        this.zzfkp.zza(view, view2, map, map2, z);
    }

    public final synchronized void zza(View view, MotionEvent motionEvent, View view2) {
        this.zzfkp.zza(view, motionEvent, view2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzb(android.view.View r3, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r5, boolean r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzfky     // Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            r0 = 1
            if (r6 == 0) goto L_0x0013
            com.google.android.gms.internal.ads.zzbuz r6 = r2.zzfkp     // Catch:{ all -> 0x005c }
            r6.zza(r3, r4, r5)     // Catch:{ all -> 0x005c }
            r2.zzfky = r0     // Catch:{ all -> 0x005c }
            monitor-exit(r2)
            return
        L_0x0013:
            if (r6 != 0) goto L_0x005a
            com.google.android.gms.internal.ads.zzyp<java.lang.Boolean> r6 = com.google.android.gms.internal.ads.zzza.zzcom     // Catch:{ all -> 0x005c }
            com.google.android.gms.internal.ads.zzyw r1 = com.google.android.gms.internal.ads.zzuv.zzon()     // Catch:{ all -> 0x005c }
            java.lang.Object r6 = r1.zzd(r6)     // Catch:{ all -> 0x005c }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x005c }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x005c }
            if (r6 == 0) goto L_0x005a
            if (r4 == 0) goto L_0x005a
            java.util.Set r6 = r4.entrySet()     // Catch:{ all -> 0x005c }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x005c }
        L_0x0031:
            boolean r1 = r6.hasNext()     // Catch:{ all -> 0x005c }
            if (r1 == 0) goto L_0x005a
            java.lang.Object r1 = r6.next()     // Catch:{ all -> 0x005c }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x005c }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x005c }
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1     // Catch:{ all -> 0x005c }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x005c }
            android.view.View r1 = (android.view.View) r1     // Catch:{ all -> 0x005c }
            if (r1 == 0) goto L_0x0031
            boolean r1 = zzx(r1)     // Catch:{ all -> 0x005c }
            if (r1 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzbuz r6 = r2.zzfkp     // Catch:{ all -> 0x005c }
            r6.zza(r3, r4, r5)     // Catch:{ all -> 0x005c }
            r2.zzfky = r0     // Catch:{ all -> 0x005c }
            monitor-exit(r2)
            return
        L_0x005a:
            monitor-exit(r2)
            return
        L_0x005c:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbuj.zzb(android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized void setClickConfirmingView(View view) {
        this.zzfkp.setClickConfirmingView(view);
    }

    public final synchronized void zza(zzadf zzadf) {
        this.zzfkp.zza(zzadf);
    }

    public final synchronized void cancelUnconfirmedClick() {
        this.zzfkp.cancelUnconfirmedClick();
    }

    public final synchronized void zza(@Nullable zzwi zzwi) {
        this.zzfkp.zza(zzwi);
    }

    public final synchronized void zza(zzwe zzwe) {
        this.zzfkp.zza(zzwe);
    }

    public final synchronized void zzqw() {
        this.zzfkp.zzqw();
    }

    public final synchronized void recordCustomClickGesture() {
        if (this.zzfkx == null) {
            zzaug.zzdv("Ad should be associated with an ad view before calling recordCustomClickGesture()");
            return;
        }
        this.zzfbx.execute(new zzbun(this, this.zzfkx instanceof zzbve));
    }

    public final synchronized boolean isCustomClickGestureEnabled() {
        return this.zzfkp.isCustomClickGestureEnabled();
    }

    public static boolean zzx(View view) {
        return view.isShown() && view.getGlobalVisibleRect(new Rect(), null);
    }

    public final boolean zzahk() {
        return this.zzfkr.zzaic();
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0076 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzg(java.lang.String r11, boolean r12) {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzbuv r0 = r10.zzfkr
            boolean r0 = r0.zzahl()
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            com.google.android.gms.internal.ads.zzbur r0 = r10.zzfjl
            com.google.android.gms.internal.ads.zzbbw r0 = r0.zzahv()
            com.google.android.gms.internal.ads.zzbur r1 = r10.zzfjl
            com.google.android.gms.internal.ads.zzbbw r1 = r1.zzahu()
            if (r0 != 0) goto L_0x001a
            if (r1 != 0) goto L_0x001a
            return
        L_0x001a:
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0020
            r4 = 1
            goto L_0x0021
        L_0x0020:
            r4 = 0
        L_0x0021:
            if (r1 == 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r2 = 0
        L_0x0025:
            r3 = 0
            if (r4 == 0) goto L_0x002a
        L_0x0028:
            r8 = r3
            goto L_0x0032
        L_0x002a:
            if (r2 == 0) goto L_0x0030
            java.lang.String r3 = "javascript"
            r0 = r1
            goto L_0x0028
        L_0x0030:
            r0 = r3
            r8 = r0
        L_0x0032:
            android.webkit.WebView r3 = r0.getWebView()
            if (r3 != 0) goto L_0x0039
            return
        L_0x0039:
            com.google.android.gms.internal.ads.zzanl r3 = com.google.android.gms.ads.internal.zzq.zzky()
            android.content.Context r4 = r10.zzlk
            boolean r3 = r3.zzp(r4)
            if (r3 == 0) goto L_0x0097
            com.google.android.gms.internal.ads.zzaxl r3 = r10.zzblk
            int r3 = r3.zzdwe
            com.google.android.gms.internal.ads.zzaxl r4 = r10.zzblk
            int r4 = r4.zzdwf
            r5 = 23
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            r6.append(r3)
            java.lang.String r3 = "."
            r6.append(r3)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            com.google.android.gms.internal.ads.zzanl r3 = com.google.android.gms.ads.internal.zzq.zzky()
            android.webkit.WebView r5 = r0.getWebView()
            java.lang.String r6 = ""
            java.lang.String r7 = "javascript"
            r9 = r11
            com.google.android.gms.dynamic.IObjectWrapper r11 = r3.zza(r4, r5, r6, r7, r8, r9)
            if (r11 != 0) goto L_0x0077
            return
        L_0x0077:
            com.google.android.gms.internal.ads.zzbur r3 = r10.zzfjl
            r3.zzas(r11)
            r0.zzaq(r11)
            if (r2 == 0) goto L_0x008e
            android.view.View r0 = r1.getView()
            if (r0 == 0) goto L_0x008e
            com.google.android.gms.internal.ads.zzanl r1 = com.google.android.gms.ads.internal.zzq.zzky()
            r1.zza(r11, r0)
        L_0x008e:
            if (r12 == 0) goto L_0x0097
            com.google.android.gms.internal.ads.zzanl r12 = com.google.android.gms.ads.internal.zzq.zzky()
            r12.zzae(r11)
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbuj.zzg(java.lang.String, boolean):void");
    }

    public final boolean zzahl() {
        return this.zzfkr.zzahl();
    }

    public final void zzy(View view) {
        IObjectWrapper zzahw = this.zzfjl.zzahw();
        boolean z = this.zzfjl.zzahv() != null;
        if (this.zzfkr.zzahl() && zzahw != null && z && view != null) {
            zzq.zzky().zza(zzahw, view);
        }
    }

    public final void zzz(View view) {
        IObjectWrapper zzahw = this.zzfjl.zzahw();
        if (this.zzfkr.zzahl() && zzahw != null && view != null) {
            zzq.zzky().zzb(zzahw, view);
        }
    }

    public final zzbup zzahm() {
        return this.zzfkz;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzaz(boolean z) {
        this.zzfkp.zza(this.zzfkx.zzaeu(), this.zzfkx.zzaip(), this.zzfkx.zzaiq(), z);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzahn() {
        this.zzfkp.destroy();
        this.zzfjl.destroy();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzaho() {
        try {
            int zzahp = this.zzfjl.zzahp();
            String str = "Google";
            if (zzahp == 1) {
                if (this.zzfdo.zzaie() != null) {
                    zzg(str, true);
                    this.zzfdo.zzaie().zza((zzaca) this.zzfks.get());
                }
            } else if (zzahp == 2) {
                if (this.zzfdo.zzaif() != null) {
                    zzg(str, true);
                    this.zzfdo.zzaif().zza((zzabw) this.zzfkt.get());
                }
            } else if (zzahp == 3) {
                if (this.zzfdo.zzfu(this.zzfjl.getCustomTemplateId()) != null) {
                    if (this.zzfjl.zzahu() != null) {
                        zzg(str, true);
                    }
                    this.zzfdo.zzfu(this.zzfjl.getCustomTemplateId()).zzb((zzace) this.zzfkw.get());
                }
            } else if (zzahp == 6) {
                if (this.zzfdo.zzaig() != null) {
                    zzg(str, true);
                    this.zzfdo.zzaig().zza((zzadg) this.zzfku.get());
                }
            } else if (zzahp != 7) {
                zzaug.zzes("Wrong native template id!");
            } else {
                if (this.zzfdo.zzaii() != null) {
                    this.zzfdo.zzaii().zza((zzagf) this.zzfkv.get());
                }
            }
        } catch (RemoteException e) {
            zzaug.zzc("RemoteException when notifyAdLoad is called", e);
        }
    }
}
