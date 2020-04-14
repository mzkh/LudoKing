package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzhv extends Exception {
    private final int zzakd;

    public zzhv(int i, int i2, int i3, int i4) {
        StringBuilder sb = new StringBuilder(82);
        sb.append("AudioTrack init failed: ");
        sb.append(i);
        sb.append(", Config(");
        sb.append(i2);
        String str = ", ";
        sb.append(str);
        sb.append(i3);
        sb.append(str);
        sb.append(i4);
        sb.append(")");
        super(sb.toString());
        this.zzakd = i;
    }
}
