package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzate {
    public static String zzd(String str, Context context, boolean z) {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcjq)).booleanValue() && !z) {
            return str;
        }
        if (zzq.zzlh().zzab(context) && !TextUtils.isEmpty(str)) {
            String zzag = zzq.zzlh().zzag(context);
            if (zzag == null) {
                return str;
            }
            if (((Boolean) zzuv.zzon().zzd(zzza.zzcji)).booleanValue()) {
                String str2 = (String) zzuv.zzon().zzd(zzza.zzcjj);
                if (str.contains(str2)) {
                    if (zzq.zzkj().zzef(str)) {
                        zzq.zzlh().zzh(context, zzag);
                        return str.replace(str2, zzag);
                    } else if (zzq.zzkj().zzeg(str)) {
                        zzq.zzlh().zzi(context, zzag);
                        return str.replace(str2, zzag);
                    }
                }
            } else {
                String str3 = "fbs_aeid";
                if (!str.contains(str3)) {
                    if (zzq.zzkj().zzef(str)) {
                        zzq.zzlh().zzh(context, zzag);
                        return zza(str, str3, zzag).toString();
                    } else if (zzq.zzkj().zzeg(str)) {
                        zzq.zzlh().zzi(context, zzag);
                        str = zza(str, str3, zzag).toString();
                    }
                }
            }
        }
        return str;
    }

    public static String zzc(Uri uri, Context context) {
        if (!zzq.zzlh().zzab(context)) {
            return uri.toString();
        }
        String zzag = zzq.zzlh().zzag(context);
        if (zzag == null) {
            return uri.toString();
        }
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcji)).booleanValue()) {
            String str = (String) zzuv.zzon().zzd(zzza.zzcjj);
            String uri2 = uri.toString();
            if (uri2.contains(str)) {
                zzq.zzlh().zzh(context, zzag);
                return uri2.replace(str, zzag);
            }
        } else {
            String str2 = "fbs_aeid";
            if (TextUtils.isEmpty(uri.getQueryParameter(str2))) {
                uri = zza(uri.toString(), str2, zzag);
                zzq.zzlh().zzh(context, zzag);
            }
        }
        return uri.toString();
    }

    @VisibleForTesting
    private static Uri zza(String str, String str2, String str3) {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        if (indexOf == -1) {
            return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
        }
        int i = indexOf + 1;
        StringBuilder sb = new StringBuilder(str.substring(0, i));
        sb.append(str2);
        sb.append("=");
        sb.append(str3);
        sb.append("&");
        sb.append(str.substring(i));
        return Uri.parse(sb.toString());
    }
}
