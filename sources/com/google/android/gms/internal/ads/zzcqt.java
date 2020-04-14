package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcqt implements zzcru<zzcqu> {
    private final Bundle zzfgs;
    private final zzddl zzfoa;

    public zzcqt(zzddl zzddl, @Nullable Bundle bundle) {
        this.zzfoa = zzddl;
        this.zzfgs = bundle;
    }

    public final zzddi<zzcqu> zzalv() {
        return this.zzfoa.zzd(new zzcqw(this));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzcqu zzame() throws Exception {
        return new zzcqu(this.zzfgs);
    }
}
