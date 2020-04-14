package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzap {
    private final int zzcf;
    private final List<zzk> zzcg;
    private final int zzch;
    private final InputStream zzci;

    public zzap(int i, List<zzk> list) {
        this(i, list, -1, null);
    }

    public zzap(int i, List<zzk> list, int i2, InputStream inputStream) {
        this.zzcf = i;
        this.zzcg = list;
        this.zzch = i2;
        this.zzci = inputStream;
    }

    public final int getStatusCode() {
        return this.zzcf;
    }

    public final List<zzk> zzo() {
        return Collections.unmodifiableList(this.zzcg);
    }

    public final int getContentLength() {
        return this.zzch;
    }

    public final InputStream getContent() {
        return this.zzci;
    }
}
