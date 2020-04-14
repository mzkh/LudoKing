package com.tapjoy.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* renamed from: com.tapjoy.internal.n */
public final class C3249n {
    /* renamed from: a */
    public static void m7542a(SharedPreferences sharedPreferences, String str, boolean z) {
        Editor edit = sharedPreferences.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    /* renamed from: a */
    public static void m7540a(SharedPreferences sharedPreferences, String str, int i) {
        Editor edit = sharedPreferences.edit();
        edit.putInt(str, i);
        edit.apply();
    }

    /* renamed from: a */
    public static void m7541a(SharedPreferences sharedPreferences, String str, String str2) {
        Editor edit = sharedPreferences.edit();
        edit.putString(str, str2);
        edit.apply();
    }
}
