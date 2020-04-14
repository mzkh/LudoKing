package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcjf {
    /* access modifiers changed from: private */
    public final Clock zzbmp;
    private final List<String> zzfzh = Collections.synchronizedList(new ArrayList());

    public zzcjf(Clock clock) {
        this.zzbmp = clock;
    }

    public final <T> zzddi<T> zza(zzcvr zzcvr, zzddi<T> zzddi) {
        long elapsedRealtime = this.zzbmp.elapsedRealtime();
        String str = zzcvr.zzdcu;
        if (str != null) {
            zzdcy.zza(zzddi, new zzcje(this, str, elapsedRealtime), zzaxn.zzdwn);
        }
        return zzddi;
    }

    /* access modifiers changed from: private */
    public final void zza(String str, int i, long j) {
        List<String> list = this.zzfzh;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33);
        sb.append(str);
        String str2 = ".";
        sb.append(str2);
        sb.append(i);
        sb.append(str2);
        sb.append(j);
        list.add(sb.toString());
    }

    public final String zzakw() {
        return TextUtils.join("_", this.zzfzh);
    }
}
