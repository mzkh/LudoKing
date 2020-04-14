package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbyz extends zzbkk {
    private final zzaqv zzdoe;
    private final WeakReference<zzbbw> zzfif;
    private final zzbqi zzfig;
    private final zzble zzfii;
    private final zzczf zzfij;
    private final zzbsu zzfim;
    private boolean zzfpi = false;
    private final zzbof zzfpy;
    private final zzbne zzfqi;
    private final Context zzlk;

    zzbyz(zzbkn zzbkn, Context context, @Nullable zzbbw zzbbw, zzbsu zzbsu, zzbqi zzbqi, zzbne zzbne, zzbof zzbof, zzble zzble, zzcvr zzcvr, zzczf zzczf) {
        super(zzbkn);
        this.zzlk = context;
        this.zzfim = zzbsu;
        this.zzfif = new WeakReference<>(zzbbw);
        this.zzfig = zzbqi;
        this.zzfqi = zzbne;
        this.zzfpy = zzbof;
        this.zzfii = zzble;
        this.zzfij = zzczf;
        this.zzdoe = new zzarw(zzcvr.zzdle);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=android.app.Activity, code=android.content.Context, for r4v0, types: [android.content.Context, android.app.Activity] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(boolean r3, @androidx.annotation.Nullable android.content.Context r4) {
        /*
            r2 = this;
            com.google.android.gms.internal.ads.zzyp<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzza.zzcjt
            com.google.android.gms.internal.ads.zzyw r1 = com.google.android.gms.internal.ads.zzuv.zzon()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0048
            com.google.android.gms.ads.internal.zzq.zzkj()
            android.content.Context r0 = r2.zzlk
            boolean r0 = com.google.android.gms.internal.ads.zzaul.zzau(r0)
            if (r0 == 0) goto L_0x0048
            java.lang.String r3 = "Rewarded ad can not be shown when app is not in foreground."
            com.google.android.gms.internal.ads.zzaug.zzeu(r3)
            com.google.android.gms.internal.ads.zzbne r3 = r2.zzfqi
            r4 = 3
            r3.zzcl(r4)
            com.google.android.gms.internal.ads.zzyp<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzza.zzcju
            com.google.android.gms.internal.ads.zzyw r4 = com.google.android.gms.internal.ads.zzuv.zzon()
            java.lang.Object r3 = r4.zzd(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0047
            com.google.android.gms.internal.ads.zzczf r3 = r2.zzfij
            com.google.android.gms.internal.ads.zzcvz r4 = r2.zzfbd
            com.google.android.gms.internal.ads.zzcvx r4 = r4.zzgkb
            com.google.android.gms.internal.ads.zzcvt r4 = r4.zzgjy
            java.lang.String r4 = r4.zzbzn
            r3.zzgl(r4)
        L_0x0047:
            return
        L_0x0048:
            boolean r0 = r2.zzfpi
            r1 = 1
            if (r0 == 0) goto L_0x0058
            java.lang.String r3 = "The rewarded ad have been showed."
            com.google.android.gms.internal.ads.zzaug.zzeu(r3)
            com.google.android.gms.internal.ads.zzbne r3 = r2.zzfqi
            r3.zzcl(r1)
            return
        L_0x0058:
            r2.zzfpi = r1
            com.google.android.gms.internal.ads.zzbqi r0 = r2.zzfig
            r0.zzagn()
            if (r4 != 0) goto L_0x0063
            android.content.Context r4 = r2.zzlk
        L_0x0063:
            com.google.android.gms.internal.ads.zzbsu r0 = r2.zzfim
            r0.zza(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbyz.zzb(boolean, android.app.Activity):void");
    }

    public final boolean zzajh() {
        return this.zzfpi;
    }

    public final zzaqv zzpk() {
        return this.zzdoe;
    }

    public final boolean isClosed() {
        return this.zzfii.isClosed();
    }

    public final boolean zzpl() {
        zzbbw zzbbw = (zzbbw) this.zzfif.get();
        return zzbbw != null && !zzbbw.zzaae();
    }

    public final Bundle getAdMetadata() {
        return this.zzfpy.getAdMetadata();
    }

    public final void finalize() throws Throwable {
        try {
            zzbbw zzbbw = (zzbbw) this.zzfif.get();
            if (((Boolean) zzuv.zzon().zzd(zzza.zzctv)).booleanValue()) {
                if (!this.zzfpi && zzbbw != null) {
                    zzddl zzddl = zzaxn.zzdwm;
                    zzbbw.getClass();
                    zzddl.execute(zzbyy.zzh(zzbbw));
                }
            } else if (zzbbw != null) {
                zzbbw.destroy();
            }
        } finally {
            super.finalize();
        }
    }
}
