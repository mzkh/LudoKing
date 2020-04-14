package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzfl implements Callable {
    private final String TAG = getClass().getSimpleName();
    private final String className;
    protected final zzb zzaaa;
    private final String zzaaj;
    protected Method zzaal;
    private final int zzaap;
    private final int zzaaq;
    protected final zzdx zzvo;

    public zzfl(zzdx zzdx, String str, String str2, zzb zzb, int i, int i2) {
        this.zzvo = zzdx;
        this.className = str;
        this.zzaaj = str2;
        this.zzaaa = zzb;
        this.zzaap = i;
        this.zzaaq = i2;
    }

    /* access modifiers changed from: protected */
    public abstract void zzcu() throws IllegalAccessException, InvocationTargetException;

    /* renamed from: zzcw */
    public Void call() throws Exception {
        try {
            long nanoTime = System.nanoTime();
            this.zzaal = this.zzvo.zzc(this.className, this.zzaaj);
            if (this.zzaal == null) {
                return null;
            }
            zzcu();
            zzda zzcj = this.zzvo.zzcj();
            if (!(zzcj == null || this.zzaap == Integer.MIN_VALUE)) {
                zzcj.zza(this.zzaaq, this.zzaap, (System.nanoTime() - nanoTime) / 1000);
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }
}
