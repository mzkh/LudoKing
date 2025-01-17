package com.google.android.gms.internal.ads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaq {
    public static zzd zzb(zzo zzo) {
        boolean z;
        long j;
        long j2;
        long j3;
        long j4;
        zzo zzo2 = zzo;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = zzo2.zzab;
        String str = (String) map.get("Date");
        long zzf = str != null ? zzf(str) : 0;
        String str2 = (String) map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            j2 = 0;
            int i2 = 0;
            j = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    i2 = 1;
                }
                i++;
            }
            i = i2;
            z = true;
        } else {
            j2 = 0;
            j = 0;
            z = false;
        }
        String str3 = (String) map.get("Expires");
        long zzf2 = str3 != null ? zzf(str3) : 0;
        String str4 = (String) map.get("Last-Modified");
        long zzf3 = str4 != null ? zzf(str4) : 0;
        String str5 = (String) map.get("ETag");
        if (z) {
            j4 = currentTimeMillis + (j2 * 1000);
            if (i == 0) {
                Long.signum(j);
                j3 = (j * 1000) + j4;
                zzd zzd = new zzd();
                zzd.data = zzo2.data;
                zzd.zzg = str5;
                zzd.zzk = j4;
                zzd.zzj = j3;
                zzd.zzh = zzf;
                zzd.zzi = zzf3;
                zzd.zzl = map;
                zzd.zzm = zzo2.allHeaders;
                return zzd;
            }
        } else if (zzf <= 0 || zzf2 < zzf) {
            j4 = 0;
        } else {
            j3 = (zzf2 - zzf) + currentTimeMillis;
            j4 = j3;
            zzd zzd2 = new zzd();
            zzd2.data = zzo2.data;
            zzd2.zzg = str5;
            zzd2.zzk = j4;
            zzd2.zzj = j3;
            zzd2.zzh = zzf;
            zzd2.zzi = zzf3;
            zzd2.zzl = map;
            zzd2.zzm = zzo2.allHeaders;
            return zzd2;
        }
        j3 = j4;
        zzd zzd22 = new zzd();
        zzd22.data = zzo2.data;
        zzd22.zzg = str5;
        zzd22.zzk = j4;
        zzd22.zzj = j3;
        zzd22.zzh = zzf;
        zzd22.zzi = zzf3;
        zzd22.zzl = map;
        zzd22.zzm = zzo2.allHeaders;
        return zzd22;
    }

    private static long zzf(String str) {
        try {
            return zzp().parse(str).getTime();
        } catch (ParseException e) {
            zzag.zza(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0;
        }
    }

    static String zzb(long j) {
        return zzp().format(new Date(j));
    }

    private static SimpleDateFormat zzp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
