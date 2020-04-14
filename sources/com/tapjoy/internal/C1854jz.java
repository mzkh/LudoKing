package com.tapjoy.internal;

import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.jz */
public final class C1854jz {

    /* renamed from: a */
    static final Logger f3904a = Logger.getLogger(C1854jz.class.getName());

    private C1854jz() {
    }

    /* renamed from: a */
    public static void m3672a(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                try {
                    f3904a.log(Level.WARNING, "IOException thrown while closing Closeable.", e);
                } catch (IOException e2) {
                    f3904a.log(Level.SEVERE, "IOException should not have been thrown.", e2);
                }
            }
        }
    }
}
