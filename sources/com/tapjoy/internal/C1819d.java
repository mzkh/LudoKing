package com.tapjoy.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tapjoy.TapjoyConstants;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.d */
public final class C1819d extends BroadcastReceiver {
    public final void onReceive(Context context, Intent intent) {
        String a = m3508a(intent);
        if (a != null) {
            m3509a(context, "install_referrer", a);
        }
    }

    @Nullable
    /* renamed from: a */
    public static String m3508a(Intent intent) {
        if ("com.android.vending.INSTALL_REFERRER".equals(intent.getAction())) {
            return intent.getStringExtra(TapjoyConstants.TJC_REFERRER);
        }
        return null;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[ExcHandler: FileNotFoundException (unused java.io.FileNotFoundException), SYNTHETIC, Splitter:B:1:0x0001] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m3509a(android.content.Context r1, java.lang.String r2, java.lang.String r3) {
        /*
            r0 = 0
            java.io.FileOutputStream r2 = r1.openFileOutput(r2, r0)     // Catch:{ FileNotFoundException -> 0x0016, IOException -> 0x000d }
            com.tapjoy.internal.C1810bg.m3459a(r2, r3)     // Catch:{ FileNotFoundException -> 0x0016, IOException -> 0x000e }
            r2.close()     // Catch:{ FileNotFoundException -> 0x0016, IOException -> 0x000e }
            r1 = 1
            return r1
        L_0x000d:
            r2 = 0
        L_0x000e:
            com.tapjoy.internal.C1854jz.m3672a(r2)
            java.lang.String r2 = "install_referrer"
            r1.deleteFile(r2)
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C1819d.m3509a(android.content.Context, java.lang.String, java.lang.String):boolean");
    }
}
