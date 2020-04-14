package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.zzq;

@TargetApi(24)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzava extends zzaux {
    public final boolean zza(Activity activity, Configuration configuration) {
        if (!((Boolean) zzuv.zzon().zzd(zzza.zzcqh)).booleanValue()) {
            return false;
        }
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcqj)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        zzuv.zzoj();
        int zza = zzawy.zza((Context) activity, configuration.screenHeightDp);
        int zza2 = zzawy.zza((Context) activity, configuration.screenWidthDp);
        WindowManager windowManager = (WindowManager) activity.getApplicationContext().getSystemService("window");
        zzq.zzkj();
        DisplayMetrics zza3 = zzaul.zza(windowManager);
        int i = zza3.heightPixels;
        int i2 = zza3.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        double d = (double) activity.getResources().getDisplayMetrics().density;
        Double.isNaN(d);
        int round = ((int) Math.round(d + 0.5d)) * ((Integer) zzuv.zzon().zzd(zzza.zzcqg)).intValue();
        if (!(zze(i, zza + dimensionPixelSize, round) && zze(i2, zza2, round))) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    private static boolean zze(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }
}
