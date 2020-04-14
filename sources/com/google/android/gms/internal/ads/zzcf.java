package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcf extends zzce<Integer, Object> {
    public String zzno;
    public long zznp;
    public String zznq;
    public String zznr;
    public String zzns;

    public zzcf(String str) {
        this();
        zzan(str);
    }

    public zzcf() {
        String str = ExifInterface.LONGITUDE_EAST;
        this.zzno = str;
        this.zznp = -1;
        this.zznq = str;
        this.zznr = str;
        this.zzns = str;
    }

    /* access modifiers changed from: protected */
    public final void zzan(String str) {
        String str2;
        long j;
        String str3;
        String str4;
        HashMap zzao = zzao(str);
        if (zzao != null) {
            Object obj = zzao.get(Integer.valueOf(0));
            String str5 = ExifInterface.LONGITUDE_EAST;
            if (obj == null) {
                str2 = str5;
            } else {
                str2 = (String) zzao.get(Integer.valueOf(0));
            }
            this.zzno = str2;
            if (zzao.get(Integer.valueOf(1)) == null) {
                j = -1;
            } else {
                j = ((Long) zzao.get(Integer.valueOf(1))).longValue();
            }
            this.zznp = j;
            if (zzao.get(Integer.valueOf(2)) == null) {
                str3 = str5;
            } else {
                str3 = (String) zzao.get(Integer.valueOf(2));
            }
            this.zznq = str3;
            if (zzao.get(Integer.valueOf(3)) == null) {
                str4 = str5;
            } else {
                str4 = (String) zzao.get(Integer.valueOf(3));
            }
            this.zznr = str4;
            if (zzao.get(Integer.valueOf(4)) != null) {
                str5 = (String) zzao.get(Integer.valueOf(4));
            }
            this.zzns = str5;
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Object> zzbw() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf(0), this.zzno);
        hashMap.put(Integer.valueOf(4), this.zzns);
        hashMap.put(Integer.valueOf(3), this.zznr);
        hashMap.put(Integer.valueOf(2), this.zznq);
        hashMap.put(Integer.valueOf(1), Long.valueOf(this.zznp));
        return hashMap;
    }
}
