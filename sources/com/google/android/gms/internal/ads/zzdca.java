package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
abstract class zzdca<I, O, F, T> extends zzdcv<O> implements Runnable {
    @NullableDecl
    private zzddi<? extends I> zzgpz;
    @NullableDecl
    private F zzgqq;

    static <I, O> zzddi<O> zza(zzddi<I> zzddi, zzdcj<? super I, ? extends O> zzdcj, Executor executor) {
        zzdaq.checkNotNull(executor);
        zzdcd zzdcd = new zzdcd(zzddi, zzdcj);
        zzddi.addListener(zzdcd, zzddk.zza(executor, zzdcd));
        return zzdcd;
    }

    /* access modifiers changed from: 0000 */
    public abstract void setResult(@NullableDecl T t);

    /* access modifiers changed from: 0000 */
    @NullableDecl
    public abstract T zzc(F f, @NullableDecl I i) throws Exception;

    static <I, O> zzddi<O> zza(zzddi<I> zzddi, zzdal<? super I, ? extends O> zzdal, Executor executor) {
        zzdaq.checkNotNull(zzdal);
        zzdcc zzdcc = new zzdcc(zzddi, zzdal);
        zzddi.addListener(zzdcc, zzddk.zza(executor, zzdcc));
        return zzdcc;
    }

    zzdca(zzddi<? extends I> zzddi, F f) {
        this.zzgpz = (zzddi) zzdaq.checkNotNull(zzddi);
        this.zzgqq = zzdaq.checkNotNull(f);
    }

    public final void run() {
        zzddi<? extends I> zzddi = this.zzgpz;
        F f = this.zzgqq;
        boolean z = true;
        boolean isCancelled = isCancelled() | (zzddi == null);
        if (f != null) {
            z = false;
        }
        if (!isCancelled && !z) {
            this.zzgpz = null;
            if (zzddi.isCancelled()) {
                setFuture(zzddi);
                return;
            }
            try {
                try {
                    Object zzc = zzc(f, zzdcy.zzb(zzddi));
                    this.zzgqq = null;
                    setResult(zzc);
                } catch (Throwable th) {
                    this.zzgqq = null;
                    throw th;
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e) {
                setException(e.getCause());
            } catch (RuntimeException e2) {
                setException(e2);
            } catch (Error e3) {
                setException(e3);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void afterDone() {
        maybePropagateCancellationTo(this.zzgpz);
        this.zzgpz = null;
        this.zzgqq = null;
    }

    /* access modifiers changed from: protected */
    public final String pendingToString() {
        String str;
        zzddi<? extends I> zzddi = this.zzgpz;
        F f = this.zzgqq;
        String pendingToString = super.pendingToString();
        if (zzddi != null) {
            String valueOf = String.valueOf(zzddi);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("inputFuture=[");
            sb.append(valueOf);
            sb.append("], ");
            str = sb.toString();
        } else {
            str = "";
        }
        if (f != null) {
            String valueOf2 = String.valueOf(f);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(valueOf2).length());
            sb2.append(str);
            sb2.append("function=[");
            sb2.append(valueOf2);
            sb2.append("]");
            return sb2.toString();
        } else if (pendingToString == null) {
            return null;
        } else {
            String valueOf3 = String.valueOf(str);
            String valueOf4 = String.valueOf(pendingToString);
            return valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
        }
    }
}
