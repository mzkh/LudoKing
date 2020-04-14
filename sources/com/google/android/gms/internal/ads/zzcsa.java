package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.LocaleList;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcsa implements zzcru<zzcrx> {
    private final zzddl zzfoa;
    private final Context zzlk;

    public zzcsa(zzddl zzddl, Context context) {
        this.zzfoa = zzddl;
        this.zzlk = context;
    }

    public final zzddi<zzcrx> zzalv() {
        return this.zzfoa.zzd(new zzcrz(this));
    }

    private static String zzx(Context context) {
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo("com.android.vending", 128);
            if (packageInfo != null) {
                int i = packageInfo.versionCode;
                String str = packageInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static String zza(Context context, PackageManager packageManager) {
        ResolveInfo zza = zza(packageManager, "market://details?id=com.google.android.gms.ads");
        if (zza == null) {
            return null;
        }
        ActivityInfo activityInfo = zza.activityInfo;
        if (activityInfo == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo != null) {
                int i = packageInfo.versionCode;
                String str = activityInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (NameNotFoundException unused) {
        }
        return null;
    }

    private static ResolveInfo zza(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzcrx zzami() throws Exception {
        boolean z;
        PackageManager packageManager = this.zzlk.getPackageManager();
        Locale locale = Locale.getDefault();
        boolean z2 = zza(packageManager, "geo:0,0?q=donuts") != null;
        boolean z3 = zza(packageManager, "http://www.google.com") != null;
        String country = locale.getCountry();
        boolean startsWith = Build.DEVICE.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE);
        boolean isLatchsky = DeviceProperties.isLatchsky(this.zzlk);
        boolean isSidewinder = DeviceProperties.isSidewinder(this.zzlk);
        String language = locale.getLanguage();
        ArrayList arrayList = new ArrayList();
        if (VERSION.SDK_INT >= 24) {
            LocaleList localeList = LocaleList.getDefault();
            for (int i = 0; i < localeList.size(); i++) {
                arrayList.add(localeList.get(i).getLanguage());
            }
        }
        String zza = zza(this.zzlk, packageManager);
        String zzx = zzx(this.zzlk);
        String str = Build.FINGERPRINT;
        Context context = this.zzlk;
        if (packageManager != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
            List queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null && resolveActivity != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= queryIntentActivities.size()) {
                        break;
                    }
                    if (resolveActivity.activityInfo.name.equals(((ResolveInfo) queryIntentActivities.get(i2)).activityInfo.name)) {
                        z = resolveActivity.activityInfo.packageName.equals(zzdwn.zzcb(context));
                        break;
                    }
                    i2++;
                }
                zzcrx zzcrx = new zzcrx(z2, z3, country, startsWith, isLatchsky, isSidewinder, language, arrayList, zza, zzx, str, z, Build.MODEL, zzq.zzkl().zzvu());
                return zzcrx;
            }
        }
        z = false;
        zzcrx zzcrx2 = new zzcrx(z2, z3, country, startsWith, isLatchsky, isSidewinder, language, arrayList, zza, zzx, str, z, Build.MODEL, zzq.zzkl().zzvu());
        return zzcrx2;
    }
}
