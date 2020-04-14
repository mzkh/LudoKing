package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzpk {
    private final long timestamp;
    public final boolean zzbnp;
    private final boolean zzbnx;
    public final boolean zzbny;
    public final Rect zzbnz;
    public final Rect zzboa;
    public final Rect zzbob;
    public final boolean zzboc;
    public final Rect zzbod;
    public final boolean zzboe;
    public final Rect zzbof;
    private final float zzbog;
    public final List<Rect> zzboh;
    public final int zzzk;

    public zzpk(long j, boolean z, boolean z2, int i, Rect rect, Rect rect2, Rect rect3, boolean z3, Rect rect4, boolean z4, Rect rect5, float f, boolean z5, List<Rect> list) {
        this.timestamp = j;
        this.zzbnx = z;
        this.zzbny = z2;
        this.zzzk = i;
        this.zzbnz = rect;
        this.zzboa = rect2;
        this.zzbob = rect3;
        this.zzboc = z3;
        this.zzbod = rect4;
        this.zzboe = z4;
        this.zzbof = rect5;
        this.zzbog = f;
        this.zzbnp = z5;
        this.zzboh = list;
    }
}
