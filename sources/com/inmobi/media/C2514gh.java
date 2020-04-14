package com.inmobi.media;

import android.util.Log;
import com.google.android.gms.games.GamesStatusCodes;

/* renamed from: com.inmobi.media.gh */
/* compiled from: Logger */
public final class C2514gh {

    /* renamed from: a */
    private static int f5514a;

    /* renamed from: a */
    public static void m5342a(int i, String str, String str2) {
        String str3 = "[InMobi]";
        if (i == 1) {
            Log.e(str3, str2);
        } else if (i != 2) {
            if (i == 3) {
                if (str2.length() > 4000) {
                    while (str2.length() > 4000) {
                        Log.d(str, str2.substring(0, GamesStatusCodes.STATUS_SNAPSHOT_NOT_FOUND));
                        str2 = str2.substring(GamesStatusCodes.STATUS_SNAPSHOT_NOT_FOUND);
                    }
                    Log.d(str, str2);
                    return;
                }
                Log.d(str, str2);
            }
        } else {
            Log.d(str3, str2);
        }
    }

    /* renamed from: a */
    public static void m5344a(String str, String str2) {
        m5342a(3, str, str2);
    }

    /* renamed from: a */
    public static void m5345a(String str, String str2, Throwable th) {
        m5343a(3, str, str2, th);
    }

    /* renamed from: a */
    public static void m5343a(int i, String str, String str2, Throwable th) {
        String str3 = "[InMobi]";
        if (i == 1) {
            Log.e(str3, str2, th);
        } else if (i != 2) {
            if (i == 3) {
                Log.d(str, str2, th);
            }
        } else {
            Log.d(str3, str2, th);
        }
    }

    /* renamed from: a */
    public static void m5341a(int i) {
        f5514a = i;
    }
}
