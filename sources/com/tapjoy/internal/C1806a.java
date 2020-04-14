package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.a */
public final class C1806a {
    @Nullable
    /* renamed from: a */
    public static Activity m3444a(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }
}
