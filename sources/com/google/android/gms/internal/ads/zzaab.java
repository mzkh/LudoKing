package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaab {
    private final Object lock = new Object();
    @VisibleForTesting
    boolean zzcut = true;
    private final List<zzzz> zzcuu = new LinkedList();
    private final Map<String, String> zzcuv = new LinkedHashMap();
    @Nullable
    private zzaab zzcuw;

    public zzaab(boolean z, String str, String str2) {
        this.zzcuv.put(NativeProtocol.WEB_DIALOG_ACTION, str);
        this.zzcuv.put("ad_format", str2);
    }

    public final void zzc(@Nullable zzaab zzaab) {
        synchronized (this.lock) {
            this.zzcuw = zzaab;
        }
    }

    @Nullable
    public final zzzz zzer(long j) {
        if (!this.zzcut) {
            return null;
        }
        return new zzzz(j, null, null);
    }

    public final boolean zza(zzzz zzzz, long j, String... strArr) {
        synchronized (this.lock) {
            for (String zzzz2 : strArr) {
                this.zzcuu.add(new zzzz(j, zzzz2, zzzz));
            }
        }
        return true;
    }

    public final String zzqc() {
        String sb;
        StringBuilder sb2 = new StringBuilder();
        synchronized (this.lock) {
            for (zzzz zzzz : this.zzcuu) {
                long time = zzzz.getTime();
                String zzpz = zzzz.zzpz();
                zzzz zzqa = zzzz.zzqa();
                if (zzqa != null && time > 0) {
                    long time2 = time - zzqa.getTime();
                    sb2.append(zzpz);
                    sb2.append('.');
                    sb2.append(time2);
                    sb2.append(',');
                }
            }
            this.zzcuu.clear();
            if (!TextUtils.isEmpty(null)) {
                sb2.append(null);
            } else if (sb2.length() > 0) {
                sb2.setLength(sb2.length() - 1);
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public final void zzj(String str, String str2) {
        if (this.zzcut && !TextUtils.isEmpty(str2)) {
            zzzr zzub = zzq.zzkn().zzub();
            if (zzub != null) {
                synchronized (this.lock) {
                    zzzv zzcl = zzub.zzcl(str);
                    Map<String, String> map = this.zzcuv;
                    map.put(str, zzcl.zzi((String) map.get(str), str2));
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public final Map<String, String> zzqd() {
        synchronized (this.lock) {
            zzzr zzub = zzq.zzkn().zzub();
            if (zzub != null) {
                if (this.zzcuw != null) {
                    Map<String, String> zza = zzub.zza(this.zzcuv, this.zzcuw.zzqd());
                    return zza;
                }
            }
            Map<String, String> map = this.zzcuv;
            return map;
        }
    }
}
