package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import java.math.BigInteger;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaua {
    @GuardedBy("this")
    private String zzdix = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    @GuardedBy("this")
    private BigInteger zzdrw = BigInteger.ONE;

    public final synchronized String zzur() {
        String bigInteger;
        bigInteger = this.zzdrw.toString();
        this.zzdrw = this.zzdrw.add(BigInteger.ONE);
        this.zzdix = bigInteger;
        return bigInteger;
    }

    public final synchronized String zzus() {
        return this.zzdix;
    }
}
