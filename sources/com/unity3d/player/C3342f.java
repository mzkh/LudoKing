package com.unity3d.player;

import android.util.Log;
import com.adcolony.sdk.AdColonyAppOptions;

/* renamed from: com.unity3d.player.f */
final class C3342f {

    /* renamed from: a */
    protected static boolean f8002a = false;

    protected static void Log(int i, String str) {
        if (!f8002a) {
            String str2 = AdColonyAppOptions.UNITY;
            if (i == 6) {
                Log.e(str2, str);
            }
            if (i == 5) {
                Log.w(str2, str);
            }
        }
    }
}
