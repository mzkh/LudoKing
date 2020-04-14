package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbrs extends zzbkk {
    private final WeakReference<zzbbw> zzfif;
    private final zzbqi zzfig;
    private final zzbsu zzfih;
    private final zzble zzfii;
    private final zzczf zzfij;
    private boolean zzfik = false;
    private final Context zzlk;

    zzbrs(zzbkn zzbkn, Context context, @Nullable zzbbw zzbbw, zzbqi zzbqi, zzbsu zzbsu, zzble zzble, zzczf zzczf) {
        super(zzbkn);
        this.zzlk = context;
        this.zzfif = new WeakReference<>(zzbbw);
        this.zzfig = zzbqi;
        this.zzfih = zzbsu;
        this.zzfii = zzble;
        this.zzfij = zzczf;
    }

    public final void zzay(boolean z) {
        this.zzfig.zzagn();
        this.zzfih.zza(z, this.zzlk);
        this.zzfik = true;
    }

    public final boolean isClosed() {
        return this.zzfii.isClosed();
    }

    public final boolean zzags() {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcjt)).booleanValue()) {
            zzq.zzkj();
            if (zzaul.zzau(this.zzlk)) {
                zzaug.zzeu("It is not recommended to show an interstitial when app is not in foreground.");
                if (((Boolean) zzuv.zzon().zzd(zzza.zzcju)).booleanValue()) {
                    this.zzfij.zzgl(this.zzfbd.zzgkb.zzgjy.zzbzn);
                }
                return false;
            }
        }
        if (!this.zzfik) {
            return true;
        }
        return false;
    }

    public final void finalize() throws Throwable {
        try {
            zzbbw zzbbw = (zzbbw) this.zzfif.get();
            if (((Boolean) zzuv.zzon().zzd(zzza.zzctv)).booleanValue()) {
                if (!this.zzfik && zzbbw != null) {
                    zzddl zzddl = zzaxn.zzdwm;
                    zzbbw.getClass();
                    zzddl.execute(zzbrv.zzh(zzbbw));
                }
            } else if (zzbbw != null) {
                zzbbw.destroy();
            }
        } finally {
            super.finalize();
        }
    }
}
