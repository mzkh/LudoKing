package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzeh extends zzce<Integer, Long> {
    public Long zzzm;
    public Long zzzn;
    public Long zzzo;
    public Long zzzp;

    public zzeh() {
    }

    public zzeh(String str) {
        zzan(str);
    }

    /* access modifiers changed from: protected */
    public final void zzan(String str) {
        HashMap zzao = zzao(str);
        if (zzao != null) {
            this.zzzm = (Long) zzao.get(Integer.valueOf(0));
            this.zzzn = (Long) zzao.get(Integer.valueOf(1));
            this.zzzo = (Long) zzao.get(Integer.valueOf(2));
            this.zzzp = (Long) zzao.get(Integer.valueOf(3));
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Long> zzbw() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf(0), this.zzzm);
        hashMap.put(Integer.valueOf(1), this.zzzn);
        hashMap.put(Integer.valueOf(2), this.zzzo);
        hashMap.put(Integer.valueOf(3), this.zzzp);
        return hashMap;
    }
}
