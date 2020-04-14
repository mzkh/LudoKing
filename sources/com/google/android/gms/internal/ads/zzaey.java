package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaey implements zzaer<Object> {
    private final zzafb zzcyf;

    public static void zza(zzbbw zzbbw, zzafb zzafb) {
        zzbbw.zza("/reward", (zzaer<? super zzbbw>) new zzaey<Object>(zzafb));
    }

    private zzaey(zzafb zzafb) {
        this.zzcyf = zzafb;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = (String) map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if ("grant".equals(str)) {
            zzaqt zzaqt = null;
            try {
                int parseInt = Integer.parseInt((String) map.get("amount"));
                String str2 = (String) map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    zzaqt = new zzaqt(str2, parseInt);
                }
            } catch (NumberFormatException e) {
                zzaug.zzd("Unable to parse reward amount.", e);
            }
            this.zzcyf.zza(zzaqt);
        } else if ("video_start".equals(str)) {
            this.zzcyf.zzra();
        } else {
            if ("video_complete".equals(str)) {
                this.zzcyf.zzrb();
            }
        }
    }
}
