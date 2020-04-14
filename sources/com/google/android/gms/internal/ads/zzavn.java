package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzavn extends zzak {
    private final Context zzlk;

    public static zzu zzbg(Context context) {
        zzu zzu = new zzu(new zzal(new File(context.getCacheDir(), "admob_volley"), 20971520), new zzavn(context, new zzar()));
        zzu.start();
        return zzu;
    }

    private zzavn(Context context, zzah zzah) {
        super(zzah);
        this.zzlk = context;
    }

    public final zzo zzc(zzq<?> zzq) throws zzae {
        if (zzq.zzg() && zzq.getMethod() == 0) {
            if (Pattern.matches((String) zzuv.zzon().zzd(zzza.zzcpw), zzq.getUrl())) {
                zzuv.zzoj();
                if (zzawy.zzc(this.zzlk, 13400000)) {
                    zzo zzc = new zzafl(this.zzlk).zzc(zzq);
                    if (zzc != null) {
                        String str = "Got gmscore asset response: ";
                        String valueOf = String.valueOf(zzq.getUrl());
                        zzaug.zzdy(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                        return zzc;
                    }
                    String str2 = "Failed to get gmscore asset response: ";
                    String valueOf2 = String.valueOf(zzq.getUrl());
                    zzaug.zzdy(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
                }
            }
        }
        return super.zzc(zzq);
    }
}
