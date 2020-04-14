package com.inmobi.media;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.drive.DriveFile;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.inmobi.media.gd */
/* compiled from: SdkContext */
public final class C2505gd {

    /* renamed from: a */
    private static final String f5495a = "gd";

    /* renamed from: b */
    private static Context f5496b = null;

    /* renamed from: c */
    private static String f5497c = "";

    /* renamed from: d */
    private static String f5498d;

    /* renamed from: e */
    private static String f5499e;

    /* renamed from: f */
    private static AtomicBoolean f5500f = new AtomicBoolean();

    /* renamed from: g */
    private static boolean f5501g = false;

    /* renamed from: h */
    private static final ExecutorService f5502h = Executors.newSingleThreadExecutor();

    /* renamed from: a */
    public static void m5290a(@NonNull Runnable runnable) {
        f5502h.submit(runnable);
    }

    /* renamed from: e */
    private static void m5304e(@NonNull Context context) {
        m5285a(context.getApplicationContext());
        f5500f.set(true);
        if (VERSION.SDK_INT < 17 && f5497c == null) {
            try {
                f5497c = new WebView(context).getSettings().getUserAgentString();
            } catch (Exception unused) {
                m5285a((Context) null);
            }
        }
        m5315m();
        m5313k();
    }

    /* renamed from: a */
    public static void m5288a(@NonNull Context context, @NonNull String str) {
        m5304e(context);
        f5498d = str;
    }

    /* renamed from: b */
    public static void m5294b(@NonNull Context context, @NonNull String str) {
        m5304e(context);
        f5499e = str;
    }

    /* renamed from: a */
    public static boolean m5292a() {
        return f5496b != null;
    }

    /* renamed from: b */
    public static boolean m5297b() {
        return (f5496b == null || f5498d == null) ? false : true;
    }

    @Nullable
    /* renamed from: c */
    public static Context m5298c() {
        return f5496b;
    }

    @Nullable
    /* renamed from: d */
    public static Application m5301d() {
        Context context = f5496b;
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            return (Application) applicationContext;
        }
        return null;
    }

    /* renamed from: a */
    public static void m5285a(@Nullable Context context) {
        f5496b = context;
    }

    /* renamed from: a */
    public static void m5291a(boolean z) {
        f5501g = z;
    }

    /* renamed from: e */
    public static boolean m5305e() {
        return f5501g;
    }

    @Nullable
    /* renamed from: f */
    public static String m5306f() {
        String str = f5498d;
        return str == null ? f5499e : str;
    }

    @Nullable
    /* renamed from: g */
    public static String m5308g() {
        return f5498d;
    }

    @Nullable
    /* renamed from: h */
    public static String m5310h() {
        return f5499e;
    }

    /* renamed from: i */
    public static String m5311i() {
        if (TextUtils.isEmpty(f5497c) && VERSION.SDK_INT >= 17) {
            f5497c = m5307f(f5496b);
        }
        return f5497c;
    }

    /* renamed from: j */
    public static boolean m5312j() {
        return f5500f.get();
    }

    /* renamed from: b */
    public static void m5296b(boolean z) {
        f5500f.set(z);
    }

    /* renamed from: b */
    public static File m5293b(Context context) {
        return new File(context.getFilesDir(), "im_cached_content");
    }

    /* renamed from: c */
    public static File m5299c(@NonNull Context context) {
        return new File(context.getFilesDir(), "as_cached_content");
    }

    /* renamed from: a */
    public static void m5289a(File file, String str) {
        if (str == null || str.trim().length() == 0) {
            C2541gz.m5442a(file);
        } else {
            C2541gz.m5442a(new File(file, str));
        }
    }

    /* renamed from: m */
    private static void m5315m() {
        File b = m5293b(m5298c());
        if (!b.mkdir()) {
            b.isDirectory();
        }
    }

    /* renamed from: k */
    public static void m5313k() {
        Context c = m5298c();
        if (c != null) {
            File c2 = m5299c(c);
            if (!c2.mkdir()) {
                c2.isDirectory();
            }
        }
    }

    @TargetApi(17)
    /* renamed from: f */
    private static String m5307f(Context context) {
        String str;
        String str2 = "";
        try {
            return m5309g(context);
        } catch (C2210az e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            try {
                str = System.getProperty("http.agent");
                if (str == null) {
                    return str2;
                }
                return str;
            } catch (Exception e2) {
                C2463fd.m5161a().mo28382a(new C2495fz(e2));
                str = str2;
            }
        }
    }

    @TargetApi(17)
    /* renamed from: g */
    private static String m5309g(Context context) throws C2210az {
        try {
            return WebSettings.getDefaultUserAgent(context.getApplicationContext());
        } catch (Exception e) {
            throw new C2210az(e.getMessage());
        }
    }

    /* renamed from: c */
    public static boolean m5300c(Context context, String str) {
        if (context == null || str == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (VERSION.SDK_INT >= 23) {
            return m5303d(context, str);
        }
        if (packageManager.checkPermission(str, packageManager.getNameForUid(Binder.getCallingUid())) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    private static boolean m5303d(Context context, String str) {
        if (!(context == null || str == null)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
                if (packageInfo.requestedPermissions != null) {
                    for (String equals : packageInfo.requestedPermissions) {
                        if (equals.equals(str)) {
                            return true;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* renamed from: a */
    public static void m5286a(Context context, ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            activity.getApplication().unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            activity.getApplication().registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    /* renamed from: a */
    public static void m5287a(Context context, Intent intent) {
        if (!(context instanceof Activity)) {
            intent.setFlags(DriveFile.MODE_READ_ONLY);
        }
        context.startActivity(intent);
    }

    /* renamed from: a */
    public static File m5284a(String str) {
        m5315m();
        File b = m5293b(m5298c());
        int length = str.length() / 2;
        String valueOf = String.valueOf(str.substring(0, length).hashCode() & Integer.MAX_VALUE);
        StringBuilder sb = new StringBuilder();
        sb.append(valueOf);
        sb.append(String.valueOf(str.substring(length).hashCode() & Integer.MAX_VALUE));
        return new File(b, sb.toString());
    }

    @WorkerThread
    /* renamed from: b */
    public static void m5295b(String str) {
        if (m5298c() != null) {
            C2494fy.m5249a(m5298c(), "coppa_store").mo28439a("im_accid", str);
        }
    }

    @WorkerThread
    @Nullable
    /* renamed from: l */
    public static String m5314l() {
        if (m5298c() != null) {
            return C2494fy.m5249a(m5298c(), "coppa_store").mo28442b("im_accid");
        }
        return null;
    }

    /* renamed from: d */
    public static void m5302d(@NonNull Context context) {
        try {
            File file = new File(context.getCacheDir(), "im_cached_content");
            if (file.exists()) {
                C2541gz.m5442a(file);
            }
        } catch (Exception unused) {
        }
    }
}
