package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzck implements Runnable {
    private zzck() {
    }

    public final void run() {
        try {
            zzci.zznu = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException unused) {
        } finally {
            zzci.zznx.countDown();
        }
    }
}
