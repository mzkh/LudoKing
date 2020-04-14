package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzavv {
    /* access modifiers changed from: private */
    public final List<String> zzduc = new ArrayList();
    /* access modifiers changed from: private */
    public final List<Double> zzdud = new ArrayList();
    /* access modifiers changed from: private */
    public final List<Double> zzdue = new ArrayList();

    public final zzavv zza(String str, double d, double d2) {
        int i = 0;
        while (i < this.zzduc.size()) {
            double doubleValue = ((Double) this.zzdue.get(i)).doubleValue();
            double doubleValue2 = ((Double) this.zzdud.get(i)).doubleValue();
            if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                break;
            }
            i++;
        }
        this.zzduc.add(i, str);
        this.zzdue.add(i, Double.valueOf(d));
        this.zzdud.add(i, Double.valueOf(d2));
        return this;
    }

    public final zzavu zzwc() {
        return new zzavu(this);
    }
}
