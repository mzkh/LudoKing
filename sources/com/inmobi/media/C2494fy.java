package com.inmobi.media;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.annotation.NonNull;
import java.util.HashMap;

/* renamed from: com.inmobi.media.fy */
/* compiled from: KeyValueStore */
public final class C2494fy {

    /* renamed from: b */
    private static HashMap<String, C2494fy> f5471b = new HashMap<>();

    /* renamed from: c */
    private static final Object f5472c = new Object();

    /* renamed from: a */
    public SharedPreferences f5473a;

    private C2494fy(@NonNull Context context, String str) {
        this.f5473a = context.getSharedPreferences(str, 0);
    }

    /* renamed from: a */
    public static String m5250a(String str) {
        return "com.im.keyValueStore.".concat(String.valueOf(str));
    }

    @NonNull
    /* renamed from: a */
    public static C2494fy m5249a(@NonNull Context context, String str) {
        String a = m5250a(str);
        C2494fy fyVar = (C2494fy) f5471b.get(a);
        if (fyVar != null) {
            return fyVar;
        }
        synchronized (f5472c) {
            C2494fy fyVar2 = (C2494fy) f5471b.get(a);
            if (fyVar2 != null) {
                return fyVar2;
            }
            C2494fy fyVar3 = new C2494fy(context, a);
            f5471b.put(a, fyVar3);
            return fyVar3;
        }
    }

    /* renamed from: a */
    public final void mo28439a(String str, String str2) {
        Editor edit = this.f5473a.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    /* renamed from: b */
    public final String mo28442b(String str) {
        return this.f5473a.getString(str, null);
    }

    /* renamed from: a */
    public final void mo28437a(String str, int i) {
        Editor edit = this.f5473a.edit();
        edit.putInt(str, i);
        edit.apply();
    }

    /* renamed from: c */
    public final int mo28444c(String str) {
        return this.f5473a.getInt(str, Integer.MIN_VALUE);
    }

    /* renamed from: a */
    public final void mo28438a(String str, long j) {
        Editor edit = this.f5473a.edit();
        edit.putLong(str, j);
        edit.apply();
    }

    /* renamed from: b */
    public final long mo28441b(String str, long j) {
        return this.f5473a.getLong(str, j);
    }

    /* renamed from: a */
    public final void mo28440a(String str, boolean z) {
        Editor edit = this.f5473a.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    /* renamed from: b */
    public final boolean mo28443b(String str, boolean z) {
        return this.f5473a.getBoolean(str, z);
    }
}
