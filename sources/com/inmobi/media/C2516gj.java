package com.inmobi.media;

import android.content.Context;

/* renamed from: com.inmobi.media.gj */
/* compiled from: PermissionUtils */
public class C2516gj {

    /* renamed from: a */
    private static final String f5516a = "gj";

    /* renamed from: a */
    public static boolean m5357a(Context context, String str) {
        try {
            if (context.checkCallingOrSelfPermission(str) == 0) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
