package com.google.android.gms.internal.ads;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzaat extends zzabd {
    private static final int zzcvn = Color.rgb(12, 174, 206);
    private static final int zzcvo;
    private static final int zzcvp;
    private static final int zzcvq = zzcvn;
    private final int backgroundColor;
    private final int textColor;
    private final int textSize;
    private final String zzcvr;
    private final List<zzaau> zzcvs = new ArrayList();
    private final List<zzabi> zzcvt = new ArrayList();
    private final int zzcvu;
    private final int zzcvv;
    private final boolean zzcvw;

    public zzaat(String str, List<zzaau> list, Integer num, Integer num2, Integer num3, int i, int i2, boolean z) {
        this.zzcvr = str;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                zzaau zzaau = (zzaau) list.get(i3);
                this.zzcvs.add(zzaau);
                this.zzcvt.add(zzaau);
            }
        }
        this.backgroundColor = num != null ? num.intValue() : zzcvp;
        this.textColor = num2 != null ? num2.intValue() : zzcvq;
        this.textSize = num3 != null ? num3.intValue() : 12;
        this.zzcvu = i;
        this.zzcvv = i2;
        this.zzcvw = z;
    }

    public final String getText() {
        return this.zzcvr;
    }

    public final List<zzabi> zzqe() {
        return this.zzcvt;
    }

    public final List<zzaau> zzqf() {
        return this.zzcvs;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    public final int zzqg() {
        return this.zzcvu;
    }

    public final int zzqh() {
        return this.zzcvv;
    }

    static {
        int rgb = Color.rgb(204, 204, 204);
        zzcvo = rgb;
        zzcvp = rgb;
    }
}
