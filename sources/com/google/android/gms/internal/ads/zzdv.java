package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdv extends zzce<Integer, Object> {
    public Long zzxo;
    public Boolean zzxp;
    public Boolean zzxq;

    public zzdv() {
    }

    public zzdv(String str) {
        zzan(str);
    }

    /* access modifiers changed from: protected */
    public final void zzan(String str) {
        HashMap zzao = zzao(str);
        if (zzao != null) {
            this.zzxo = (Long) zzao.get(Integer.valueOf(0));
            this.zzxp = (Boolean) zzao.get(Integer.valueOf(1));
            this.zzxq = (Boolean) zzao.get(Integer.valueOf(2));
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Object> zzbw() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf(0), this.zzxo);
        hashMap.put(Integer.valueOf(1), this.zzxp);
        hashMap.put(Integer.valueOf(2), this.zzxq);
        return hashMap;
    }
}
