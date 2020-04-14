package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzef extends zzce<Integer, Long> {
    public Long zzyq;
    public Long zzyr;
    public Long zzys;
    public Long zzyt;
    public Long zzyu;
    public Long zzyv;
    public Long zzyw;
    public Long zzyx;
    public Long zzyy;
    public Long zzyz;
    public Long zzza;

    public zzef() {
    }

    public zzef(String str) {
        zzan(str);
    }

    /* access modifiers changed from: protected */
    public final void zzan(String str) {
        HashMap zzao = zzao(str);
        if (zzao != null) {
            this.zzyq = (Long) zzao.get(Integer.valueOf(0));
            this.zzyr = (Long) zzao.get(Integer.valueOf(1));
            this.zzys = (Long) zzao.get(Integer.valueOf(2));
            this.zzyt = (Long) zzao.get(Integer.valueOf(3));
            this.zzyu = (Long) zzao.get(Integer.valueOf(4));
            this.zzyv = (Long) zzao.get(Integer.valueOf(5));
            this.zzyw = (Long) zzao.get(Integer.valueOf(6));
            this.zzyx = (Long) zzao.get(Integer.valueOf(7));
            this.zzyy = (Long) zzao.get(Integer.valueOf(8));
            this.zzyz = (Long) zzao.get(Integer.valueOf(9));
            this.zzza = (Long) zzao.get(Integer.valueOf(10));
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Long> zzbw() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf(0), this.zzyq);
        hashMap.put(Integer.valueOf(1), this.zzyr);
        hashMap.put(Integer.valueOf(2), this.zzys);
        hashMap.put(Integer.valueOf(3), this.zzyt);
        hashMap.put(Integer.valueOf(4), this.zzyu);
        hashMap.put(Integer.valueOf(5), this.zzyv);
        hashMap.put(Integer.valueOf(6), this.zzyw);
        hashMap.put(Integer.valueOf(7), this.zzyx);
        hashMap.put(Integer.valueOf(8), this.zzyy);
        hashMap.put(Integer.valueOf(9), this.zzyz);
        hashMap.put(Integer.valueOf(10), this.zzza);
        return hashMap;
    }
}
