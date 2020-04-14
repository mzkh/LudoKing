package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
class zzdce<InputT, OutputT> extends zzj<OutputT> {
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(zzdce.class.getName());
    /* access modifiers changed from: private */
    @NullableDecl
    public zza zzgqv;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    abstract class zza extends zzdcf implements Runnable {
        /* access modifiers changed from: private */
        public zzday<? extends zzddi<? extends InputT>> zzgqr;
        private final boolean zzgqs;
        private final boolean zzgqt;

        zza(zzday<? extends zzddi<? extends InputT>> zzday, boolean z, boolean z2) {
            super(zzday.size());
            this.zzgqr = (zzday) zzdaq.checkNotNull(zzday);
            this.zzgqs = z;
            this.zzgqt = z2;
        }

        /* access modifiers changed from: 0000 */
        public void interruptTask() {
        }

        /* access modifiers changed from: 0000 */
        public abstract void zza(boolean z, int i, @NullableDecl InputT inputt);

        /* access modifiers changed from: 0000 */
        public abstract void zzapc();

        public final void run() {
            zzapa();
        }

        /* access modifiers changed from: private */
        public final void zzaoz() {
            if (this.zzgqr.isEmpty()) {
                zzapc();
            } else if (this.zzgqs) {
                int i = 0;
                zzdbu zzdbu = (zzdbu) this.zzgqr.iterator();
                while (zzdbu.hasNext()) {
                    zzddi zzddi = (zzddi) zzdbu.next();
                    int i2 = i + 1;
                    zzddi.addListener(new zzdcg(this, i, zzddi), zzdcq.INSTANCE);
                    i = i2;
                }
            } else {
                zzdbu zzdbu2 = (zzdbu) this.zzgqr.iterator();
                while (zzdbu2.hasNext()) {
                    ((zzddi) zzdbu2.next()).addListener(this, zzdcq.INSTANCE);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x002e  */
        /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void zzh(java.lang.Throwable r8) {
            /*
                r7 = this;
                com.google.android.gms.internal.ads.zzdaq.checkNotNull(r8)
                boolean r0 = r7.zzgqs
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L_0x001e
                com.google.android.gms.internal.ads.zzdce r0 = com.google.android.gms.internal.ads.zzdce.this
                boolean r0 = r0.setException(r8)
                if (r0 == 0) goto L_0x0015
                r7.zzapb()
                goto L_0x001f
            L_0x0015:
                java.util.Set r3 = r7.zzape()
                boolean r3 = com.google.android.gms.internal.ads.zzdce.zza(r3, r8)
                goto L_0x0020
            L_0x001e:
                r0 = 0
            L_0x001f:
                r3 = 1
            L_0x0020:
                boolean r4 = r8 instanceof java.lang.Error
                boolean r5 = r7.zzgqs
                if (r0 != 0) goto L_0x0027
                goto L_0x0028
            L_0x0027:
                r1 = 0
            L_0x0028:
                r0 = r5 & r1
                r0 = r0 & r3
                r0 = r0 | r4
                if (r0 == 0) goto L_0x0044
                if (r4 == 0) goto L_0x0033
                java.lang.String r0 = "Input Future failed with Error"
                goto L_0x0035
            L_0x0033:
                java.lang.String r0 = "Got more than one input Future failure. Logging failures after the first"
            L_0x0035:
                r5 = r0
                java.util.logging.Logger r1 = com.google.android.gms.internal.ads.zzdce.logger
                java.util.logging.Level r2 = java.util.logging.Level.SEVERE
                java.lang.String r3 = "com.google.common.util.concurrent.AggregateFuture$RunningState"
                java.lang.String r4 = "handleException"
                r6 = r8
                r1.logp(r2, r3, r4, r5, r6)
            L_0x0044:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdce.zza.zzh(java.lang.Throwable):void");
        }

        /* access modifiers changed from: 0000 */
        public final void zzg(Set<Throwable> set) {
            if (!zzdce.this.isCancelled()) {
                zzdce.zza(set, zzdce.this.zzaow());
            }
        }

        /* access modifiers changed from: private */
        public final void zza(int i, Future<? extends InputT> future) {
            zzdaq.checkState(this.zzgqs || !zzdce.this.isDone() || zzdce.this.isCancelled(), "Future was done before all dependencies completed");
            try {
                zzdaq.checkState(future.isDone(), "Tried to set value from future which is not done");
                if (!this.zzgqs) {
                    if (this.zzgqt && !future.isCancelled()) {
                        zza(this.zzgqs, i, (InputT) zzdcy.zzb(future));
                    }
                } else if (future.isCancelled()) {
                    zzdce.this.zzgqv = null;
                    zzdce.this.cancel(false);
                } else {
                    Object zzb = zzdcy.zzb(future);
                    if (this.zzgqt) {
                        zza(this.zzgqs, i, (InputT) zzb);
                    }
                }
            } catch (ExecutionException e) {
                zzh(e.getCause());
            } catch (Throwable th) {
                zzh(th);
            }
        }

        /* access modifiers changed from: private */
        public final void zzapa() {
            int zzapf = zzapf();
            int i = 0;
            zzdaq.checkState(zzapf >= 0, "Less than 0 remaining futures");
            if (zzapf == 0) {
                if (this.zzgqt && (true ^ this.zzgqs)) {
                    zzdbu zzdbu = (zzdbu) this.zzgqr.iterator();
                    while (zzdbu.hasNext()) {
                        int i2 = i + 1;
                        zza(i, (zzddi) zzdbu.next());
                        i = i2;
                    }
                }
                zzapc();
            }
        }

        /* access modifiers changed from: 0000 */
        public void zzapb() {
            this.zzgqr = null;
        }
    }

    zzdce() {
    }

    /* access modifiers changed from: protected */
    public final void afterDone() {
        super.afterDone();
        zza zza2 = this.zzgqv;
        if (zza2 != null) {
            this.zzgqv = null;
            zzday zza3 = zza2.zzgqr;
            boolean wasInterrupted = wasInterrupted();
            if (wasInterrupted) {
                zza2.interruptTask();
            }
            if (isCancelled() && (zza3 != null)) {
                zzdbu zzdbu = (zzdbu) zza3.iterator();
                while (zzdbu.hasNext()) {
                    ((zzddi) zzdbu.next()).cancel(wasInterrupted);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final String pendingToString() {
        zza zza2 = this.zzgqv;
        if (zza2 == null) {
            return null;
        }
        zzday zza3 = zza2.zzgqr;
        if (zza3 == null) {
            return null;
        }
        String valueOf = String.valueOf(zza3);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 10);
        sb.append("futures=[");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public final void zzd(zza zza2) {
        this.zzgqv = zza2;
        zza2.zzaoz();
    }

    /* access modifiers changed from: private */
    public static boolean zza(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }
}
