package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaet implements zzaer<Object> {
    private final Context zzlk;

    public zzaet(Context context) {
        this.zzlk = context;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (zzq.zzlh().zzab(this.zzlk)) {
            String str = (String) map.get("eventName");
            String str2 = (String) map.get("eventId");
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 94399) {
                if (hashCode != 94401) {
                    if (hashCode == 94407 && str.equals("_ai")) {
                        c = 1;
                    }
                } else if (str.equals("_ac")) {
                    c = 0;
                }
            } else if (str.equals("_aa")) {
                c = 2;
            }
            if (c == 0) {
                zzq.zzlh().zzh(this.zzlk, str2);
            } else if (c == 1) {
                zzq.zzlh().zzi(this.zzlk, str2);
            } else if (c != 2) {
                zzaug.zzes("logScionEvent gmsg contained unsupported eventName");
            } else {
                zzq.zzlh().zzk(this.zzlk, str2);
            }
        }
    }
}
