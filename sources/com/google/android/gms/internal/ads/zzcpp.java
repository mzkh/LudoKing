package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcpp implements Callable {
    private final zzcpq zzgfg;

    zzcpp(zzcpq zzcpq) {
        this.zzgfg = zzcpq;
    }

    public final Object call() {
        String str;
        String str2;
        String str3;
        zzcpq zzcpq = this.zzgfg;
        zzq.zzkj();
        zzpz zzux = zzq.zzkn().zzuh().zzux();
        Bundle bundle = null;
        if (!(zzux == null || zzux == null || (zzq.zzkn().zzuh().zzuy() && zzq.zzkn().zzuh().zzva()))) {
            if (zzux.zzly()) {
                zzux.wakeup();
            }
            zzpt zzlw = zzux.zzlw();
            if (zzlw != null) {
                str2 = zzlw.zzll();
                str = zzlw.zzlm();
                str3 = zzlw.zzln();
                if (str2 != null) {
                    zzq.zzkn().zzuh().zzdz(str2);
                }
                if (str3 != null) {
                    zzq.zzkn().zzuh().zzea(str3);
                }
            } else {
                str2 = zzq.zzkn().zzuh().zzuz();
                str3 = zzq.zzkn().zzuh().zzvb();
                str = null;
            }
            Bundle bundle2 = new Bundle(1);
            if (!zzq.zzkn().zzuh().zzva()) {
                String str4 = "v_fp_vertical";
                if (str3 == null || TextUtils.isEmpty(str3)) {
                    bundle2.putString(str4, "no_hash");
                } else {
                    bundle2.putString(str4, str3);
                }
            }
            if (str2 != null && !zzq.zzkn().zzuh().zzuy()) {
                bundle2.putString("fingerprint", str2);
                if (!str2.equals(str)) {
                    bundle2.putString("v_fp", str);
                }
            }
            if (!bundle2.isEmpty()) {
                bundle = bundle2;
            }
        }
        return new zzcpn(bundle);
    }
}
