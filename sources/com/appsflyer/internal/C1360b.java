package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;

/* renamed from: com.appsflyer.internal.b */
public final class C1360b {

    /* renamed from: ˋ */
    private IntentFilter f3515 = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* renamed from: com.appsflyer.internal.b$a */
    public static final class C1361a {

        /* renamed from: ˎ */
        public final float f3516;

        /* renamed from: ॱ */
        public final String f3517;

        C1361a(float f, String str) {
            this.f3516 = f;
            this.f3517 = str;
        }

        C1361a() {
        }
    }

    /* renamed from: com.appsflyer.internal.b$d */
    public static final class C1362d {

        /* renamed from: ˋ */
        public static final C1360b f3518 = new C1360b();
    }

    C1360b() {
    }

    @NonNull
    /* renamed from: ˋ */
    public final C1361a mo10828(Context context) {
        String str = null;
        float f = 0.0f;
        try {
            Intent registerReceiver = context.registerReceiver(null, this.f3515);
            if (registerReceiver != null) {
                if (2 == registerReceiver.getIntExtra("status", -1)) {
                    int intExtra = registerReceiver.getIntExtra("plugged", -1);
                    str = intExtra != 1 ? intExtra != 2 ? intExtra != 4 ? "other" : "wireless" : "usb" : "ac";
                } else {
                    str = "no";
                }
                int intExtra2 = registerReceiver.getIntExtra("level", -1);
                int intExtra3 = registerReceiver.getIntExtra("scale", -1);
                if (!(-1 == intExtra2 || -1 == intExtra3)) {
                    f = (((float) intExtra2) * 100.0f) / ((float) intExtra3);
                }
            }
        } catch (Throwable unused) {
        }
        return new C1361a(f, str);
    }
}
