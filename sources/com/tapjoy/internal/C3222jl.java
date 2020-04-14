package com.tapjoy.internal;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import java.util.Set;

/* renamed from: com.tapjoy.internal.jl */
public final class C3222jl {

    /* renamed from: a */
    final String f7726a;

    /* renamed from: b */
    final CharSequence f7727b;

    /* renamed from: c */
    final CharSequence[] f7728c;

    /* renamed from: d */
    final boolean f7729d;

    /* renamed from: e */
    final Bundle f7730e;

    /* renamed from: f */
    final Set f7731f;

    @RequiresApi(20)
    /* renamed from: a */
    static RemoteInput[] m7499a(C3222jl[] jlVarArr) {
        if (jlVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[jlVarArr.length];
        for (int i = 0; i < jlVarArr.length; i++) {
            C3222jl jlVar = jlVarArr[i];
            remoteInputArr[i] = new Builder(jlVar.f7726a).setLabel(jlVar.f7727b).setChoices(jlVar.f7728c).setAllowFreeFormInput(jlVar.f7729d).addExtras(jlVar.f7730e).build();
        }
        return remoteInputArr;
    }
}
