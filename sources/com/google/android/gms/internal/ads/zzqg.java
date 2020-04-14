package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzqg {
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;
    private final int zzbqe;

    @VisibleForTesting
    public zzqg(float f, float f2, float f3, float f4, int i) {
        this.left = f;
        this.top = f2;
        this.right = f + f3;
        this.bottom = f2 + f4;
        this.zzbqe = i;
    }

    /* access modifiers changed from: 0000 */
    public final float zzma() {
        return this.left;
    }

    /* access modifiers changed from: 0000 */
    public final float zzmb() {
        return this.top;
    }

    /* access modifiers changed from: 0000 */
    public final float zzmc() {
        return this.right;
    }

    /* access modifiers changed from: 0000 */
    public final float zzmd() {
        return this.bottom;
    }

    /* access modifiers changed from: 0000 */
    public final int zzme() {
        return this.zzbqe;
    }
}
