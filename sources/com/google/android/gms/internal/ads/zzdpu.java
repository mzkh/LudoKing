package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdpu {
    private final byte[] buffer;
    private final zzdqf zzhgh;

    private zzdpu(int i) {
        this.buffer = new byte[i];
        this.zzhgh = zzdqf.zzaa(this.buffer);
    }

    public final zzdpm zzaxs() {
        this.zzhgh.zzayv();
        return new zzdpw(this.buffer);
    }

    public final zzdqf zzaxt() {
        return this.zzhgh;
    }

    /* synthetic */ zzdpu(int i, zzdpp zzdpp) {
        this(i);
    }
}
