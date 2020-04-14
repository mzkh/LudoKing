package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdy extends zzce<Integer, Long> {
    public Long zzyh;
    public Long zzyi;

    public zzdy() {
    }

    public zzdy(String str) {
        zzan(str);
    }

    /* access modifiers changed from: protected */
    public final void zzan(String str) {
        HashMap zzao = zzao(str);
        if (zzao != null) {
            this.zzyh = (Long) zzao.get(Integer.valueOf(0));
            this.zzyi = (Long) zzao.get(Integer.valueOf(1));
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Long> zzbw() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf(0), this.zzyh);
        hashMap.put(Integer.valueOf(1), this.zzyi);
        return hashMap;
    }
}
