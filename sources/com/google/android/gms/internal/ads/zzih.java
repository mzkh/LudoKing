package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzih {
    private int flags;

    public void clear() {
        this.flags = 0;
    }

    public final boolean zzfu() {
        return zzw(Integer.MIN_VALUE);
    }

    public final boolean zzfv() {
        return zzw(4);
    }

    public final boolean zzfw() {
        return zzw(1);
    }

    public final void setFlags(int i) {
        this.flags = i;
    }

    public final void zzv(int i) {
        this.flags |= Integer.MIN_VALUE;
    }

    /* access modifiers changed from: protected */
    public final boolean zzw(int i) {
        return (this.flags & i) == i;
    }
}
