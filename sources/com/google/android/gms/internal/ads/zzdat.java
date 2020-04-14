package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdat<T> extends zzdar<T> {
    private final T zzczg;

    zzdat(T t) {
        this.zzczg = t;
    }

    public final T zzaof() {
        return this.zzczg;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof zzdat)) {
            return false;
        }
        return this.zzczg.equals(((zzdat) obj).zzczg);
    }

    public final int hashCode() {
        return this.zzczg.hashCode() + 1502476572;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzczg);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 13);
        sb.append("Optional.of(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }
}
