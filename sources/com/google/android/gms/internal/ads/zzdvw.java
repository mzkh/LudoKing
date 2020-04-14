package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdvw {
    public static final zzdvw zzhxh;
    private static final zzdvw zzhxi;
    private static final zzdvw zzhxj;
    private static final zzdvw zzhxk;

    /* renamed from: a */
    private final double f3914a;

    /* renamed from: b */
    private final double f3915b;

    /* renamed from: c */
    private final double f3916c;

    /* renamed from: d */
    private final double f3917d;

    /* renamed from: w */
    private final double f3918w;
    private final double zzhxd;
    private final double zzhxe;
    private final double zzhxf;
    private final double zzhxg;

    private zzdvw(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.zzhxd = d5;
        this.zzhxe = d6;
        this.f3918w = d7;
        this.f3914a = d;
        this.f3915b = d2;
        this.f3916c = d3;
        this.f3917d = d4;
        this.zzhxf = d8;
        this.zzhxg = d9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzdvw zzdvw = (zzdvw) obj;
        return Double.compare(zzdvw.f3914a, this.f3914a) == 0 && Double.compare(zzdvw.f3915b, this.f3915b) == 0 && Double.compare(zzdvw.f3916c, this.f3916c) == 0 && Double.compare(zzdvw.f3917d, this.f3917d) == 0 && Double.compare(zzdvw.zzhxf, this.zzhxf) == 0 && Double.compare(zzdvw.zzhxg, this.zzhxg) == 0 && Double.compare(zzdvw.zzhxd, this.zzhxd) == 0 && Double.compare(zzdvw.zzhxe, this.zzhxe) == 0 && Double.compare(zzdvw.f3918w, this.f3918w) == 0;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.zzhxd);
        int i = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        long doubleToLongBits2 = Double.doubleToLongBits(this.zzhxe);
        int i2 = (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.f3918w);
        int i3 = (i2 * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.f3914a);
        int i4 = (i3 * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
        long doubleToLongBits5 = Double.doubleToLongBits(this.f3915b);
        int i5 = (i4 * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)));
        long doubleToLongBits6 = Double.doubleToLongBits(this.f3916c);
        int i6 = (i5 * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)));
        long doubleToLongBits7 = Double.doubleToLongBits(this.f3917d);
        int i7 = (i6 * 31) + ((int) (doubleToLongBits7 ^ (doubleToLongBits7 >>> 32)));
        long doubleToLongBits8 = Double.doubleToLongBits(this.zzhxf);
        int i8 = (i7 * 31) + ((int) (doubleToLongBits8 ^ (doubleToLongBits8 >>> 32)));
        long doubleToLongBits9 = Double.doubleToLongBits(this.zzhxg);
        return (i8 * 31) + ((int) (doubleToLongBits9 ^ (doubleToLongBits9 >>> 32)));
    }

    public final String toString() {
        if (equals(zzhxh)) {
            return "Rotate 0°";
        }
        if (equals(zzhxi)) {
            return "Rotate 90°";
        }
        if (equals(zzhxj)) {
            return "Rotate 180°";
        }
        if (equals(zzhxk)) {
            return "Rotate 270°";
        }
        double d = this.zzhxd;
        double d2 = this.zzhxe;
        double d3 = this.f3918w;
        double d4 = this.f3914a;
        double d5 = this.f3915b;
        double d6 = this.f3916c;
        double d7 = this.f3917d;
        double d8 = this.zzhxf;
        double d9 = this.zzhxg;
        double d10 = d7;
        StringBuilder sb = new StringBuilder(260);
        sb.append("Matrix{u=");
        sb.append(d);
        sb.append(", v=");
        sb.append(d2);
        sb.append(", w=");
        sb.append(d3);
        sb.append(", a=");
        sb.append(d4);
        sb.append(", b=");
        sb.append(d5);
        sb.append(", c=");
        sb.append(d6);
        sb.append(", d=");
        sb.append(d10);
        sb.append(", tx=");
        sb.append(d8);
        sb.append(", ty=");
        sb.append(d9);
        sb.append("}");
        return sb.toString();
    }

    public static zzdvw zzp(ByteBuffer byteBuffer) {
        double zzd = zzbc.zzd(byteBuffer);
        double zzd2 = zzbc.zzd(byteBuffer);
        double zze = zzbc.zze(byteBuffer);
        zzdvw zzdvw = new zzdvw(zzd, zzd2, zzbc.zzd(byteBuffer), zzbc.zzd(byteBuffer), zze, zzbc.zze(byteBuffer), zzbc.zze(byteBuffer), zzbc.zzd(byteBuffer), zzbc.zzd(byteBuffer));
        return zzdvw;
    }

    static {
        zzdvw zzdvw = new zzdvw(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
        zzhxh = zzdvw;
        zzdvw zzdvw2 = new zzdvw(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
        zzhxi = zzdvw2;
        zzdvw zzdvw3 = new zzdvw(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
        zzhxj = zzdvw3;
        zzdvw zzdvw4 = new zzdvw(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
        zzhxk = zzdvw4;
    }
}
