package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzqf {
    @Nullable
    private static MessageDigest zzbqd;
    protected Object mLock = new Object();

    /* access modifiers changed from: 0000 */
    public abstract byte[] zzbq(String str);

    /* access modifiers changed from: protected */
    @Nullable
    public final MessageDigest zzlz() {
        synchronized (this.mLock) {
            if (zzbqd != null) {
                MessageDigest messageDigest = zzbqd;
                return messageDigest;
            }
            for (int i = 0; i < 2; i++) {
                try {
                    zzbqd = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            MessageDigest messageDigest2 = zzbqd;
            return messageDigest2;
        }
    }
}
