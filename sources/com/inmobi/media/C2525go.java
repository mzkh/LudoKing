package com.inmobi.media;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.security.NetworkSecurityPolicy;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.inmobi.media.go */
/* compiled from: AppInfo */
public class C2525go {

    /* renamed from: e */
    private static final String f5531e = "go";

    /* renamed from: a */
    public String f5532a;

    /* renamed from: b */
    public String f5533b;

    /* renamed from: c */
    public Map<String, String> f5534c;

    /* renamed from: d */
    public int f5535d;

    /* renamed from: f */
    private String f5536f;

    /* renamed from: g */
    private String f5537g;

    /* renamed from: com.inmobi.media.go$a */
    /* compiled from: AppInfo */
    static class C2526a {

        /* renamed from: a */
        static final C2525go f5538a = new C2525go(0);
    }

    /* synthetic */ C2525go(byte b) {
        this();
    }

    private C2525go() {
        this.f5534c = new HashMap();
        Context c = C2505gd.m5298c();
        try {
            PackageManager packageManager = c.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(c.getPackageName(), 128);
            if (applicationInfo != null) {
                this.f5532a = applicationInfo.packageName;
                this.f5536f = applicationInfo.loadLabel(packageManager).toString();
                this.f5533b = packageManager.getInstallerPackageName(this.f5532a);
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(c.getPackageName(), 128);
            String str = null;
            String str2 = "";
            if (packageInfo != null) {
                str = packageInfo.versionName;
                if (str == null || str2.equals(str)) {
                    if (VERSION.SDK_INT < 28) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(packageInfo.versionCode);
                        str = sb.toString();
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(packageInfo.getLongVersionCode());
                        str = sb2.toString();
                    }
                }
            }
            if (str != null && !str2.equals(str)) {
                this.f5537g = str;
            }
        } catch (Exception unused) {
        }
        this.f5535d = m5385b();
        this.f5534c.put("u-appbid", this.f5532a);
        this.f5534c.put("u-appdnm", this.f5536f);
        this.f5534c.put("u-appver", this.f5537g);
        this.f5534c.put("u-appsecure", Integer.toString(this.f5535d));
    }

    /* renamed from: a */
    public static C2525go m5384a() {
        return C2526a.f5538a;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    private static int m5385b() {
        try {
            if (VERSION.SDK_INT < 23 || NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                return 0;
            }
            return 1;
        } catch (Exception unused) {
            return 2;
        }
    }
}
