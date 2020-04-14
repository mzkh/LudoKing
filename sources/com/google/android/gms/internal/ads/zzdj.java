package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdj extends zzce<Integer, Long> {
    public long zzxe;
    public long zzxf;

    public zzdj() {
        this.zzxe = -1;
        this.zzxf = -1;
    }

    public zzdj(String str) {
        this();
        zzan(str);
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Long> zzbw() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf(0), Long.valueOf(this.zzxe));
        hashMap.put(Integer.valueOf(1), Long.valueOf(this.zzxf));
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public final void zzan(String str) {
        HashMap zzao = zzao(str);
        if (zzao != null) {
            this.zzxe = ((Long) zzao.get(Integer.valueOf(0))).longValue();
            this.zzxf = ((Long) zzao.get(Integer.valueOf(1))).longValue();
        }
    }
}
