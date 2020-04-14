package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.tapjoy.TapjoyConstants;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcoo implements zzcru<Object> {
    private static final Object lock = new Object();
    private final String zzcdr;
    private final String zzdix;
    private final zzcwe zzfga;
    private final zzblr zzgem;
    private final zzcwu zzgen;

    public zzcoo(String str, String str2, zzblr zzblr, zzcwu zzcwu, zzcwe zzcwe) {
        this.zzdix = str;
        this.zzcdr = str2;
        this.zzgem = zzblr;
        this.zzgen = zzcwu;
        this.zzfga = zzcwe;
    }

    public final zzddi<Object> zzalv() {
        Bundle bundle = new Bundle();
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcrv)).booleanValue()) {
            this.zzgem.zzf(this.zzfga.zzgkg);
            bundle.putAll(this.zzgen.zzang());
        }
        return zzdcy.zzah(new zzcon(this, bundle));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzb(Bundle bundle, Bundle bundle2) {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcrv)).booleanValue()) {
            bundle2.putBundle("quality_signals", bundle);
        } else {
            if (((Boolean) zzuv.zzon().zzd(zzza.zzcru)).booleanValue()) {
                synchronized (lock) {
                    this.zzgem.zzf(this.zzfga.zzgkg);
                    bundle2.putBundle("quality_signals", this.zzgen.zzang());
                }
            } else {
                this.zzgem.zzf(this.zzfga.zzgkg);
                bundle2.putBundle("quality_signals", this.zzgen.zzang());
            }
        }
        bundle2.putString("seq_num", this.zzdix);
        bundle2.putString(TapjoyConstants.TJC_SESSION_ID, this.zzcdr);
    }
}
