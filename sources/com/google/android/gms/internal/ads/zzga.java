package com.google.android.gms.internal.ads;

import androidx.core.view.PointerIconCompat;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzga {
    public static final int CHANNEL_OUT_7POINT1_SURROUND = (zzof.SDK_INT < 23 ? PointerIconCompat.TYPE_GRAB : 6396);
    public static final UUID zzaca = new UUID(0, 0);
    private static final UUID zzacb = new UUID(1186680826959645954L, -5988876978535335093L);
    private static final UUID zzacc = new UUID(-1301668207276963122L, -6645017420763422227L);
    private static final UUID zzacd = new UUID(-7348484286925749626L, -6083546864340672619L);

    public static long zzdg(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j / 1000;
    }

    public static long zzdh(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j * 1000;
    }
}
