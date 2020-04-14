package com.tapjoy.internal;

import android.app.Dialog;
import android.content.Context;

/* renamed from: com.tapjoy.internal.c */
public final class C2916c extends Dialog {

    /* renamed from: a */
    private boolean f6742a = false;

    public C2916c(Context context) {
        super(context, 16973835);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawableResource(17170445);
    }

    public final void show() {
        this.f6742a = false;
        super.show();
    }

    public final void cancel() {
        this.f6742a = true;
        super.cancel();
    }
}
