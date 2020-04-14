package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.appsflyer.share.Constants;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.ads.zzaug;
import com.google.android.gms.internal.ads.zzaul;
import com.google.android.gms.internal.ads.zzuv;
import com.google.android.gms.internal.ads.zzza;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzb {
    public static boolean zza(Context context, zzd zzd, zzt zzt) {
        int i = 0;
        if (zzd == null) {
            zzaug.zzeu("No intent data for launcher overlay.");
            return false;
        }
        zzza.initialize(context);
        if (zzd.intent != null) {
            return zza(context, zzd.intent, zzt);
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(zzd.url)) {
            zzaug.zzeu("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(zzd.mimeType)) {
            intent.setDataAndType(Uri.parse(zzd.url), zzd.mimeType);
        } else {
            intent.setData(Uri.parse(zzd.url));
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(zzd.packageName)) {
            intent.setPackage(zzd.packageName);
        }
        if (!TextUtils.isEmpty(zzd.zzdhn)) {
            String[] split = zzd.zzdhn.split(Constants.URL_PATH_DELIMITER, 2);
            if (split.length < 2) {
                String str = "Could not parse component name from open GMSG: ";
                String valueOf = String.valueOf(zzd.zzdhn);
                zzaug.zzeu(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        String str2 = zzd.zzdho;
        if (!TextUtils.isEmpty(str2)) {
            try {
                i = Integer.parseInt(str2);
            } catch (NumberFormatException unused) {
                zzaug.zzeu("Could not parse intent flags.");
            }
            intent.addFlags(i);
        }
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcpz)).booleanValue()) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            intent.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) zzuv.zzon().zzd(zzza.zzcpy)).booleanValue()) {
                zzq.zzkj();
                zzaul.zzb(context, intent);
            }
        }
        return zza(context, intent, zzt);
    }

    private static boolean zza(Context context, Intent intent, zzt zzt) {
        String str = "Launching an intent: ";
        try {
            String valueOf = String.valueOf(intent.toURI());
            zzaug.zzdy(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            zzq.zzkj();
            zzaul.zza(context, intent);
            if (zzt != null) {
                zzt.zzsy();
            }
            return true;
        } catch (ActivityNotFoundException e) {
            zzaug.zzeu(e.getMessage());
            return false;
        }
    }
}
