package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zznp extends IOException {
    public zznp(Throwable th) {
        String simpleName = th.getClass().getSimpleName();
        String message = th.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(simpleName).length() + 13 + String.valueOf(message).length());
        sb.append("Unexpected ");
        sb.append(simpleName);
        sb.append(": ");
        sb.append(message);
        super(sb.toString(), th);
    }
}
