package com.google.android.gms.internal.ads;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzdar<T> implements Serializable {
    @NullableDecl
    public abstract T zzaof();

    public static <T> zzdar<T> zzz(@NullableDecl T t) {
        if (t == null) {
            return zzdaj.zzgoq;
        }
        return new zzdat(t);
    }

    zzdar() {
    }
}
