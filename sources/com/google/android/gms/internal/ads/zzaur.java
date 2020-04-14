package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import com.google.android.gms.ads.internal.zzq;
import java.io.InputStream;
import java.util.Map;

@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzaur {
    public String getDefaultUserAgent(Context context) {
        return "";
    }

    public boolean isAttachedToWindow(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public boolean zza(Activity activity, Configuration configuration) {
        return false;
    }

    public void zzbc(Context context) {
    }

    public void zzg(Activity activity) {
    }

    public int zzvq() {
        return 5;
    }

    public int zzvt() {
        return 1;
    }

    public long zzvu() {
        return -1;
    }

    public boolean zza(Context context, WebSettings webSettings) {
        zzawq.zza(context, new zzauu(context, webSettings));
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        return true;
    }

    public static boolean zza(zzbbw zzbbw) {
        if (zzbbw == null) {
            return false;
        }
        zzbbw.onPause();
        return true;
    }

    public static boolean zzb(zzbbw zzbbw) {
        if (zzbbw == null) {
            return false;
        }
        zzbbw.onResume();
        return true;
    }

    public zzbbv zza(zzbbw zzbbw, zzsd zzsd, boolean z) {
        return new zzbcv(zzbbw, zzsd, z);
    }

    public LayoutParams zzvr() {
        return new LayoutParams(-2, -2);
    }

    public Drawable zza(Context context, Bitmap bitmap, boolean z, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public static boolean zzvs() {
        int myUid = Process.myUid();
        return myUid == 0 || myUid == 1000;
    }

    public CookieManager zzbd(Context context) {
        if (zzvs()) {
            return null;
        }
        try {
            CookieSyncManager.createInstance(context);
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzaug.zzc("Failed to obtain CookieManager.", th);
            zzq.zzkn().zza(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public zzsv zza(Context context, TelephonyManager telephonyManager) {
        return zzsv.ENUM_UNKNOWN;
    }

    public int zza(ContentResolver contentResolver) {
        return System.getInt(contentResolver, "wifi_on", 0);
    }

    public int zzb(ContentResolver contentResolver) {
        return System.getInt(contentResolver, "airplane_mode_on", 0);
    }

    public WebResourceResponse zza(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, inputStream);
    }

    private zzaur() {
    }

    public static zzaur zzco(int i) {
        if (i >= 28) {
            return new zzavc();
        }
        if (i >= 26) {
            return new zzauz();
        }
        if (i >= 24) {
            return new zzava();
        }
        if (i >= 21) {
            return new zzaux();
        }
        if (i >= 19) {
            return new zzauy();
        }
        if (i >= 18) {
            return new zzauv();
        }
        if (i >= 17) {
            return new zzauw();
        }
        return new zzaur();
    }
}
