package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzbel {
    private final zzaxl zzblh;
    private final WeakReference<Context> zzeju;
    private final Context zzlk;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static class zza {
        /* access modifiers changed from: private */
        public zzaxl zzblh;
        /* access modifiers changed from: private */
        public WeakReference<Context> zzeju;
        /* access modifiers changed from: private */
        public Context zzzc;

        public final zza zza(zzaxl zzaxl) {
            this.zzblh = zzaxl;
            return this;
        }

        public final zza zzbs(Context context) {
            this.zzeju = new WeakReference<>(context);
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zzzc = context;
            return this;
        }
    }

    private zzbel(zza zza2) {
        this.zzblh = zza2.zzblh;
        this.zzlk = zza2.zzzc;
        this.zzeju = zza2.zzeju;
    }

    /* access modifiers changed from: 0000 */
    public final Context zzabp() {
        return this.zzlk;
    }

    /* access modifiers changed from: 0000 */
    public final WeakReference<Context> zzabq() {
        return this.zzeju;
    }

    /* access modifiers changed from: 0000 */
    public final zzaxl zzabr() {
        return this.zzblh;
    }

    /* access modifiers changed from: 0000 */
    public final String zzabs() {
        return zzq.zzkj().zzr(this.zzlk, this.zzblh.zzblz);
    }
}
