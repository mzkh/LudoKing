package com.google.android.gms.internal.ads;

import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdvs extends zzdvt {
    private Logger logger;

    public zzdvs(String str) {
        this.logger = Logger.getLogger(str);
    }

    public final void zzhr(String str) {
        this.logger.logp(Level.FINE, "com.googlecode.mp4parser.util.JuliLogger", "logDebug", str);
    }
}
