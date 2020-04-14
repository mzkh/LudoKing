package com.google.android.gms.internal.ads;

import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdam {
    private final String className;
    private final zzdap zzgor;
    private zzdap zzgos;
    private boolean zzgot;

    private zzdam(String str) {
        this.zzgor = new zzdap();
        this.zzgos = this.zzgor;
        this.zzgot = false;
        this.className = (String) zzdaq.checkNotNull(str);
    }

    public final zzdam zzy(@NullableDecl Object obj) {
        zzdap zzdap = new zzdap();
        this.zzgos.zzgou = zzdap;
        this.zzgos = zzdap;
        zzdap.value = obj;
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.className);
        sb.append('{');
        zzdap zzdap = this.zzgor.zzgou;
        String str = "";
        while (zzdap != null) {
            Object obj = zzdap.value;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append(deepToString, 1, deepToString.length() - 1);
            }
            zzdap = zzdap.zzgou;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
