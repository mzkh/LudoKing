package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzapm {
    private float zzbog;
    private int zzdgn;
    private int zzdgo;
    private int zzdme;
    private boolean zzdmf;
    private boolean zzdmg;
    private String zzdmh;
    private String zzdmi;
    private boolean zzdmj;
    private final boolean zzdmk;
    private boolean zzdml;
    private boolean zzdmm;
    private boolean zzdmn;
    private String zzdmo;
    private String zzdmp;
    private String zzdmq;
    private int zzdmr;
    private int zzdms;
    private int zzdmt;
    private int zzdmu;
    private int zzdmv;
    private int zzdmw;
    private double zzdmx;
    private boolean zzdmy;
    private boolean zzdmz;
    private int zzdna;
    private String zzdnb;
    private String zzdnc;
    private boolean zzdnd;

    public zzapm(Context context) {
        PackageManager packageManager = context.getPackageManager();
        zzu(context);
        zzv(context);
        zzw(context);
        Locale locale = Locale.getDefault();
        boolean z = true;
        this.zzdmf = zza(packageManager, "geo:0,0?q=donuts") != null;
        if (zza(packageManager, "http://www.google.com") == null) {
            z = false;
        }
        this.zzdmg = z;
        this.zzdmi = locale.getCountry();
        zzuv.zzoj();
        this.zzdmj = zzawy.zzwj();
        this.zzdmk = DeviceProperties.isLatchsky(context);
        this.zzdml = DeviceProperties.isSidewinder(context);
        this.zzdmo = locale.getLanguage();
        this.zzdmp = zza(context, packageManager);
        this.zzdmq = zzx(context);
        Resources resources = context.getResources();
        if (resources != null) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            if (displayMetrics != null) {
                this.zzbog = displayMetrics.density;
                this.zzdgn = displayMetrics.widthPixels;
                this.zzdgo = displayMetrics.heightPixels;
            }
        }
    }

    public zzapm(Context context, zzapj zzapj) {
        zzu(context);
        zzv(context);
        zzw(context);
        this.zzdnb = Build.FINGERPRINT;
        this.zzdnc = Build.DEVICE;
        this.zzdnd = PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzaal.zzk(context);
        this.zzdmf = zzapj.zzdmf;
        this.zzdmg = zzapj.zzdmg;
        this.zzdmi = zzapj.zzdmi;
        this.zzdmj = zzapj.zzdmj;
        this.zzdmk = zzapj.zzdmk;
        this.zzdml = zzapj.zzdml;
        this.zzdmo = zzapj.zzdmo;
        this.zzdmp = zzapj.zzdmp;
        this.zzdmq = zzapj.zzdmq;
        this.zzbog = zzapj.zzbog;
        this.zzdgn = zzapj.zzdgn;
        this.zzdgo = zzapj.zzdgo;
    }

    private final void zzu(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            try {
                this.zzdme = audioManager.getMode();
                this.zzdmm = audioManager.isMusicActive();
                this.zzdmn = audioManager.isSpeakerphoneOn();
                this.zzdmr = audioManager.getStreamVolume(3);
                this.zzdmv = audioManager.getRingerMode();
                this.zzdmw = audioManager.getStreamVolume(2);
                return;
            } catch (Throwable th) {
                zzq.zzkn().zza(th, "DeviceInfo.gatherAudioInfo");
            }
        }
        this.zzdme = -2;
        this.zzdmm = false;
        this.zzdmn = false;
        this.zzdmr = 0;
        this.zzdmv = 2;
        this.zzdmw = 0;
    }

    @TargetApi(16)
    private final void zzv(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.zzdmh = telephonyManager.getNetworkOperator();
        this.zzdmt = telephonyManager.getNetworkType();
        this.zzdmu = telephonyManager.getPhoneType();
        this.zzdms = -2;
        this.zzdmz = false;
        this.zzdna = -1;
        zzq.zzkj();
        if (zzaul.zzq(context, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                this.zzdms = activeNetworkInfo.getType();
                this.zzdna = activeNetworkInfo.getDetailedState().ordinal();
            } else {
                this.zzdms = -1;
            }
            if (VERSION.SDK_INT >= 16) {
                this.zzdmz = connectivityManager.isActiveNetworkMetered();
            }
        }
    }

    private final void zzw(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            this.zzdmx = (double) (((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
            this.zzdmy = z;
            return;
        }
        this.zzdmx = -1.0d;
        this.zzdmy = false;
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
        try {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        } catch (Throwable th) {
            zzq.zzkn().zza(th, "DeviceInfo.getResolveInfo");
            return null;
        }
    }

    public final zzapj zzti() {
        zzapj zzapj = new zzapj(this.zzdme, this.zzdmf, this.zzdmg, this.zzdmh, this.zzdmi, this.zzdmj, this.zzdmk, this.zzdml, this.zzdmm, this.zzdmn, this.zzdmo, this.zzdmp, this.zzdmq, this.zzdmr, this.zzdms, this.zzdmt, this.zzdmu, this.zzdmv, this.zzdmw, this.zzbog, this.zzdgn, this.zzdgo, this.zzdmx, this.zzdmy, this.zzdmz, this.zzdna, this.zzdnb, this.zzdnd, this.zzdnc);
        return zzapj;
    }
}
