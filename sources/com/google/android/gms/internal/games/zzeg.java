package com.google.android.gms.internal.games;

public final class zzeg {
    public static String zzn(int i) {
        if (i == 0) {
            return "DAILY";
        }
        if (i == 1) {
            return "WEEKLY";
        }
        if (i == 2) {
            return "ALL_TIME";
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Unknown time span ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }
}
