package com.google.android.gms.internal.firebase_messaging;

import com.tapjoy.TJAdUnitConstants.String;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.firebase:firebase-messaging@@19.0.1 */
public final class zzk {
    private static final Logger zza = Logger.getLogger(zzk.class.getName());

    private zzk() {
    }

    public static void zza(@NullableDecl InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                try {
                    zza.logp(Level.WARNING, "com.google.common.io.Closeables", String.CLOSE, "IOException thrown while closing Closeable.", e);
                } catch (IOException e2) {
                    throw new AssertionError(e2);
                }
            }
        }
    }
}
