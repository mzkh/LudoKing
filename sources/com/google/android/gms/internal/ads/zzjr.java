package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzjr extends zzjs {
    public final long zzaqu;
    public final List<zzju> zzaqv = new ArrayList();
    public final List<zzjr> zzaqw = new ArrayList();

    public zzjr(int i, long j) {
        super(i);
        this.zzaqu = j;
    }

    public final zzju zzak(int i) {
        int size = this.zzaqv.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzju zzju = (zzju) this.zzaqv.get(i2);
            if (zzju.type == i) {
                return zzju;
            }
        }
        return null;
    }

    public final zzjr zzal(int i) {
        int size = this.zzaqw.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzjr zzjr = (zzjr) this.zzaqw.get(i2);
            if (zzjr.type == i) {
                return zzjr;
            }
        }
        return null;
    }

    public final String toString() {
        String zzao = zzao(this.type);
        String arrays = Arrays.toString(this.zzaqv.toArray());
        String arrays2 = Arrays.toString(this.zzaqw.toArray());
        StringBuilder sb = new StringBuilder(String.valueOf(zzao).length() + 22 + String.valueOf(arrays).length() + String.valueOf(arrays2).length());
        sb.append(zzao);
        sb.append(" leaves: ");
        sb.append(arrays);
        sb.append(" containers: ");
        sb.append(arrays2);
        return sb.toString();
    }
}
