package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzbmk {
    private final zzcwe zzfga;
    private Bundle zzfgs;
    @Nullable
    private final String zzfgt;
    @Nullable
    private final zzcwc zzfgu;
    private final Context zzlk;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static class zza {
        /* access modifiers changed from: private */
        public zzcwe zzfga;
        /* access modifiers changed from: private */
        public Bundle zzfgs;
        /* access modifiers changed from: private */
        @Nullable
        public String zzfgt;
        /* access modifiers changed from: private */
        @Nullable
        public zzcwc zzfgu;
        /* access modifiers changed from: private */
        public Context zzlk;

        public final zza zzby(Context context) {
            this.zzlk = context;
            return this;
        }

        public final zza zza(zzcwe zzcwe) {
            this.zzfga = zzcwe;
            return this;
        }

        public final zza zze(Bundle bundle) {
            this.zzfgs = bundle;
            return this;
        }

        public final zza zzfn(String str) {
            this.zzfgt = str;
            return this;
        }

        public final zzbmk zzafy() {
            return new zzbmk(this);
        }

        public final zza zza(zzcwc zzcwc) {
            this.zzfgu = zzcwc;
            return this;
        }
    }

    private zzbmk(zza zza2) {
        this.zzlk = zza2.zzlk;
        this.zzfga = zza2.zzfga;
        this.zzfgs = zza2.zzfgs;
        this.zzfgt = zza2.zzfgt;
        this.zzfgu = zza2.zzfgu;
    }

    /* access modifiers changed from: 0000 */
    public final zza zzaft() {
        return new zza().zzby(this.zzlk).zza(this.zzfga).zzfn(this.zzfgt).zze(this.zzfgs);
    }

    /* access modifiers changed from: 0000 */
    public final zzcwe zzafu() {
        return this.zzfga;
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    public final zzcwc zzafv() {
        return this.zzfgu;
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    public final Bundle zzafw() {
        return this.zzfgs;
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    public final String zzafx() {
        return this.zzfgt;
    }

    /* access modifiers changed from: 0000 */
    public final Context zzbx(Context context) {
        if (this.zzfgt != null) {
            return context;
        }
        return this.zzlk;
    }
}
