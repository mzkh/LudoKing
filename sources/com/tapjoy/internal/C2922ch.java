package com.tapjoy.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.tapjoy.internal.ch */
public final class C2922ch {
    /* renamed from: a */
    public static byte[] m6677a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-1").digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
