package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzavu {
    private final String[] zzdtx;
    private final double[] zzdty;
    private final double[] zzdtz;
    private final int[] zzdua;
    private int zzdub;

    private zzavu(zzavv zzavv) {
        int size = zzavv.zzdud.size();
        this.zzdtx = (String[]) zzavv.zzduc.toArray(new String[size]);
        this.zzdty = zze(zzavv.zzdud);
        this.zzdtz = zze(zzavv.zzdue);
        this.zzdua = new int[size];
        this.zzdub = 0;
    }

    private static double[] zze(List<Double> list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = ((Double) list.get(i)).doubleValue();
        }
        return dArr;
    }

    public final void zza(double d) {
        this.zzdub++;
        int i = 0;
        while (true) {
            double[] dArr = this.zzdtz;
            if (i < dArr.length) {
                if (dArr[i] <= d && d < this.zzdty[i]) {
                    int[] iArr = this.zzdua;
                    iArr[i] = iArr[i] + 1;
                }
                if (d >= this.zzdtz[i]) {
                    i++;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final List<zzavw> zzwb() {
        ArrayList arrayList = new ArrayList(this.zzdtx.length);
        int i = 0;
        while (true) {
            String[] strArr = this.zzdtx;
            if (i >= strArr.length) {
                return arrayList;
            }
            String str = strArr[i];
            double d = this.zzdtz[i];
            double d2 = this.zzdty[i];
            int[] iArr = this.zzdua;
            double d3 = (double) iArr[i];
            double d4 = (double) this.zzdub;
            Double.isNaN(d3);
            Double.isNaN(d4);
            zzavw zzavw = new zzavw(str, d, d2, d3 / d4, iArr[i]);
            arrayList.add(zzavw);
            i++;
        }
    }
}
