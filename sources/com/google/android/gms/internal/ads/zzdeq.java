package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdeq {
    private static final CopyOnWriteArrayList<zzder> zzgsq = new CopyOnWriteArrayList<>();

    public static zzder zzgp(String str) throws GeneralSecurityException {
        Iterator it = zzgsq.iterator();
        while (it.hasNext()) {
            zzder zzder = (zzder) it.next();
            if (zzder.zzgq(str)) {
                return zzder;
            }
        }
        String str2 = "No KMS client does support: ";
        String valueOf = String.valueOf(str);
        throw new GeneralSecurityException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }
}
