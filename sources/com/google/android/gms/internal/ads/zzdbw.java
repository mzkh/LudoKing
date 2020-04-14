package com.google.android.gms.internal.ads;

import java.lang.Throwable;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
abstract class zzdbw<V, X extends Throwable, F, T> extends zzdcv<V> implements Runnable {
    @NullableDecl
    private zzddi<? extends V> zzgpz;
    @NullableDecl
    private Class<X> zzgqa;
    @NullableDecl
    private F zzgqb;

    static <X extends Throwable, V> zzddi<V> zza(zzddi<? extends V> zzddi, Class<X> cls, zzdcj<? super X, ? extends V> zzdcj, Executor executor) {
        zzdbz zzdbz = new zzdbz(zzddi, cls, zzdcj);
        zzddi.addListener(zzdbz, zzddk.zza(executor, zzdbz));
        return zzdbz;
    }

    /* access modifiers changed from: 0000 */
    public abstract void setResult(@NullableDecl T t);

    /* access modifiers changed from: 0000 */
    @NullableDecl
    public abstract T zza(F f, X x) throws Exception;

    zzdbw(zzddi<? extends V> zzddi, Class<X> cls, F f) {
        this.zzgpz = (zzddi) zzdaq.checkNotNull(zzddi);
        this.zzgqa = (Class) zzdaq.checkNotNull(cls);
        this.zzgqb = zzdaq.checkNotNull(f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzddi<? extends V> r0 = r7.zzgpz
            java.lang.Class<X> r1 = r7.zzgqa
            F r2 = r7.zzgqb
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x000c
            r5 = 1
            goto L_0x000d
        L_0x000c:
            r5 = 0
        L_0x000d:
            if (r1 != 0) goto L_0x0011
            r6 = 1
            goto L_0x0012
        L_0x0011:
            r6 = 0
        L_0x0012:
            r5 = r5 | r6
            if (r2 != 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r3 = 0
        L_0x0017:
            r3 = r3 | r5
            boolean r4 = r7.isCancelled()
            r3 = r3 | r4
            if (r3 == 0) goto L_0x0020
            return
        L_0x0020:
            r3 = 0
            r7.zzgpz = r3
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzdcy.zzb(r0)     // Catch:{ ExecutionException -> 0x002c, Throwable -> 0x002a }
            r5 = r4
            r4 = r3
            goto L_0x0038
        L_0x002a:
            r4 = move-exception
            goto L_0x0037
        L_0x002c:
            r4 = move-exception
            java.lang.Throwable r4 = r4.getCause()
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzdaq.checkNotNull(r4)
            java.lang.Throwable r4 = (java.lang.Throwable) r4
        L_0x0037:
            r5 = r3
        L_0x0038:
            if (r4 != 0) goto L_0x003e
            r7.set(r5)
            return
        L_0x003e:
            boolean r1 = r1.isInstance(r4)
            if (r1 != 0) goto L_0x0048
            r7.setFuture(r0)
            return
        L_0x0048:
            java.lang.Object r0 = r7.zza(r2, r4)     // Catch:{ Throwable -> 0x0056 }
            r7.zzgqa = r3
            r7.zzgqb = r3
            r7.setResult(r0)
            return
        L_0x0054:
            r0 = move-exception
            goto L_0x005f
        L_0x0056:
            r0 = move-exception
            r7.setException(r0)     // Catch:{ all -> 0x0054 }
            r7.zzgqa = r3
            r7.zzgqb = r3
            return
        L_0x005f:
            r7.zzgqa = r3
            r7.zzgqb = r3
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdbw.run():void");
    }

    /* access modifiers changed from: protected */
    public final String pendingToString() {
        String str;
        zzddi<? extends V> zzddi = this.zzgpz;
        Class<X> cls = this.zzgqa;
        F f = this.zzgqb;
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
        if (cls != null && f != null) {
            String valueOf2 = String.valueOf(cls);
            String valueOf3 = String.valueOf(f);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 29 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
            sb2.append(str);
            sb2.append("exceptionType=[");
            sb2.append(valueOf2);
            sb2.append("], fallback=[");
            sb2.append(valueOf3);
            sb2.append("]");
            return sb2.toString();
        } else if (pendingToString == null) {
            return null;
        } else {
            String valueOf4 = String.valueOf(str);
            String valueOf5 = String.valueOf(pendingToString);
            return valueOf5.length() != 0 ? valueOf4.concat(valueOf5) : new String(valueOf4);
        }
    }

    /* access modifiers changed from: protected */
    public final void afterDone() {
        maybePropagateCancellationTo(this.zzgpz);
        this.zzgpz = null;
        this.zzgqa = null;
        this.zzgqb = null;
    }
}
