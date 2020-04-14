package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
public abstract class zzdpy {
    int zzhgj;
    int zzhgk;
    private int zzhgl;
    zzdqd zzhgm;
    private boolean zzhgn;

    static zzdpy zzc(byte[] bArr, int i, int i2, boolean z) {
        zzdqa zzdqa = new zzdqa(bArr, i, i2, z);
        try {
            zzdqa.zzfr(i2);
            return zzdqa;
        } catch (zzdrg e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static long zzez(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int zzft(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract int zzaxu() throws IOException;

    public abstract long zzaxv() throws IOException;

    public abstract long zzaxw() throws IOException;

    public abstract int zzaxx() throws IOException;

    public abstract long zzaxy() throws IOException;

    public abstract int zzaxz() throws IOException;

    public abstract boolean zzaya() throws IOException;

    public abstract String zzayb() throws IOException;

    public abstract zzdpm zzayc() throws IOException;

    public abstract int zzayd() throws IOException;

    public abstract int zzaye() throws IOException;

    public abstract int zzayf() throws IOException;

    public abstract long zzayg() throws IOException;

    public abstract int zzayh() throws IOException;

    public abstract long zzayi() throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract long zzayj() throws IOException;

    public abstract boolean zzayk() throws IOException;

    public abstract int zzayl();

    public abstract void zzfp(int i) throws zzdrg;

    public abstract boolean zzfq(int i) throws IOException;

    public abstract int zzfr(int i) throws zzdrg;

    public abstract void zzfs(int i);

    private zzdpy() {
        this.zzhgk = 100;
        this.zzhgl = Integer.MAX_VALUE;
        this.zzhgn = false;
    }
}
