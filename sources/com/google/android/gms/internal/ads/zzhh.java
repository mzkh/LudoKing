package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzhh extends Exception {
    public zzhh(int i, int i2, int i3) {
        StringBuilder sb = new StringBuilder(78);
        sb.append("Unhandled format: ");
        sb.append(i);
        sb.append(" Hz, ");
        sb.append(i2);
        sb.append(" channels in encoding ");
        sb.append(i3);
        super(sb.toString());
    }
}
