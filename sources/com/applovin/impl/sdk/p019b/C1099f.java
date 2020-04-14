package com.applovin.impl.sdk.p019b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.b.f */
public final class C1099f {

    /* renamed from: a */
    private static SharedPreferences f2583a;

    /* renamed from: b */
    private final SharedPreferences f2584b;

    public C1099f(C1192i iVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("com.applovin.sdk.preferences.");
        sb.append(iVar.mo10246t());
        this.f2584b = iVar.mo10179D().getSharedPreferences(sb.toString(), 0);
    }

    /* renamed from: a */
    private static SharedPreferences m2147a(Context context) {
        if (f2583a == null) {
            f2583a = context.getSharedPreferences("com.applovin.sdk.shared", 0);
        }
        return f2583a;
    }

    /* renamed from: a */
    public static <T> T m2148a(String str, T t, Class cls, SharedPreferences sharedPreferences) {
        T t2;
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (sharedPreferences.contains(str)) {
                if (Boolean.class.equals(cls)) {
                    t2 = Boolean.valueOf(t != null ? sharedPreferences.getBoolean(str, ((Boolean) t).booleanValue()) : sharedPreferences.getBoolean(str, false));
                } else if (Float.class.equals(cls)) {
                    t2 = Float.valueOf(t != null ? sharedPreferences.getFloat(str, ((Float) t).floatValue()) : sharedPreferences.getFloat(str, 0.0f));
                } else if (Integer.class.equals(cls)) {
                    t2 = Integer.valueOf(t != null ? sharedPreferences.getInt(str, ((Integer) t).intValue()) : sharedPreferences.getInt(str, 0));
                } else if (Long.class.equals(cls)) {
                    t2 = Long.valueOf(t != null ? sharedPreferences.getLong(str, ((Long) t).longValue()) : sharedPreferences.getLong(str, 0));
                } else {
                    t2 = String.class.equals(cls) ? sharedPreferences.getString(str, (String) t) : Set.class.isAssignableFrom(cls) ? sharedPreferences.getStringSet(str, (Set) t) : t;
                }
                if (t2 != null) {
                    return cls.cast(t2);
                }
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return t;
            }
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return t;
        } catch (Throwable th) {
            String str2 = "SharedPreferencesManager";
            StringBuilder sb = new StringBuilder();
            sb.append("Error getting value for key: ");
            sb.append(str);
            C1227o.m2837c(str2, sb.toString(), th);
            return t;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* renamed from: a */
    public static <T> void m2149a(C1098e<T> eVar, Context context) {
        m2147a(context).edit().remove(eVar.mo9960a()).apply();
    }

    /* renamed from: a */
    public static <T> void m2150a(C1098e<T> eVar, T t, Context context) {
        m2151a(eVar.mo9960a(), t, m2147a(context), (Editor) null);
    }

    /* renamed from: a */
    private static <T> void m2151a(String str, T t, SharedPreferences sharedPreferences, Editor editor) {
        boolean z = true;
        boolean z2 = editor != null;
        if (!z2) {
            editor = sharedPreferences.edit();
        }
        if (t instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) t).booleanValue());
        } else if (t instanceof Float) {
            editor.putFloat(str, ((Float) t).floatValue());
        } else if (t instanceof Integer) {
            editor.putInt(str, ((Integer) t).intValue());
        } else if (t instanceof Long) {
            editor.putLong(str, ((Long) t).longValue());
        } else if (t instanceof String) {
            editor.putString(str, (String) t);
        } else if (t instanceof Set) {
            editor.putStringSet(str, (Set) t);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to put default value of invalid type: ");
            sb.append(t);
            C1227o.m2841i("SharedPreferencesManager", sb.toString());
            z = false;
        }
        if (z && !z2) {
            editor.apply();
        }
    }

    /* renamed from: b */
    public static <T> T m2152b(C1098e<T> eVar, T t, Context context) {
        return m2148a(eVar.mo9960a(), t, eVar.mo9961b(), m2147a(context));
    }

    /* renamed from: a */
    public void mo9963a(SharedPreferences sharedPreferences) {
        sharedPreferences.edit().clear().apply();
    }

    /* renamed from: a */
    public <T> void mo9964a(C1098e<T> eVar) {
        this.f2584b.edit().remove(eVar.mo9960a()).apply();
    }

    /* renamed from: a */
    public <T> void mo9965a(C1098e<T> eVar, T t) {
        mo9966a(eVar, t, this.f2584b);
    }

    /* renamed from: a */
    public <T> void mo9966a(C1098e<T> eVar, T t, SharedPreferences sharedPreferences) {
        mo9968a(eVar.mo9960a(), t, sharedPreferences);
    }

    /* renamed from: a */
    public <T> void mo9967a(String str, T t, Editor editor) {
        m2151a(str, t, (SharedPreferences) null, editor);
    }

    /* renamed from: a */
    public <T> void mo9968a(String str, T t, SharedPreferences sharedPreferences) {
        m2151a(str, t, sharedPreferences, (Editor) null);
    }

    /* renamed from: b */
    public <T> T mo9969b(C1098e<T> eVar, T t) {
        return mo9970b(eVar, t, this.f2584b);
    }

    /* renamed from: b */
    public <T> T mo9970b(C1098e<T> eVar, T t, SharedPreferences sharedPreferences) {
        return m2148a(eVar.mo9960a(), t, eVar.mo9961b(), sharedPreferences);
    }
}
