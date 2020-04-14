package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.internal.zzq;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaeb implements zzaer<zzbbw> {
    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbbw zzbbw = (zzbbw) obj;
        String str = (String) map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if ("tick".equals(str)) {
            String str2 = (String) map.get("label");
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str2)) {
                zzaug.zzeu("No label given for CSI tick.");
            } else if (TextUtils.isEmpty(str4)) {
                zzaug.zzeu("No timestamp given for CSI tick.");
            } else {
                try {
                    long elapsedRealtime = zzq.zzkq().elapsedRealtime() + (Long.parseLong(str4) - zzq.zzkq().currentTimeMillis());
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "native:view_load";
                    }
                    zzbbw.zzxq().zza(str2, str3, elapsedRealtime);
                } catch (NumberFormatException e) {
                    zzaug.zzd("Malformed timestamp for CSI tick.", e);
                }
            }
        } else {
            String str5 = "value";
            if ("experiment".equals(str)) {
                String str6 = (String) map.get(str5);
                if (TextUtils.isEmpty(str6)) {
                    zzaug.zzeu("No value given for CSI experiment.");
                    return;
                }
                zzaab zzpy = zzbbw.zzxq().zzpy();
                if (zzpy == null) {
                    zzaug.zzeu("No ticker for WebView, dropping experiment ID.");
                } else {
                    zzpy.zzj("e", str6);
                }
            } else {
                if ("extra".equals(str)) {
                    String str7 = (String) map.get("name");
                    String str8 = (String) map.get(str5);
                    if (TextUtils.isEmpty(str8)) {
                        zzaug.zzeu("No value given for CSI extra.");
                    } else if (TextUtils.isEmpty(str7)) {
                        zzaug.zzeu("No name given for CSI extra.");
                    } else {
                        zzaab zzpy2 = zzbbw.zzxq().zzpy();
                        if (zzpy2 == null) {
                            zzaug.zzeu("No ticker for WebView, dropping extra parameter.");
                            return;
                        }
                        zzpy2.zzj(str7, str8);
                    }
                }
            }
        }
    }
}
