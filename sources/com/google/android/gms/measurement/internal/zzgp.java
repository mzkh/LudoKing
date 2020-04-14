package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.api.AppMeasurementSdk.ConditionalUserProperty;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public final class zzgp extends zzg {
    @VisibleForTesting
    protected zzhj zzpu;
    private zzgk zzpv;
    private final Set<zzgn> zzpw = new CopyOnWriteArraySet();
    private boolean zzpx;
    private final AtomicReference<String> zzpy = new AtomicReference<>();
    @VisibleForTesting
    protected boolean zzpz = true;

    protected zzgp(zzfj zzfj) {
        super(zzfj);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbk() {
        return false;
    }

    public final void zzif() {
        if (getContext().getApplicationContext() instanceof Application) {
            ((Application) getContext().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zzpu);
        }
    }

    public final Boolean zzig() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzaa().zza(atomicReference, 15000, "boolean test flag value", new zzgo(this, atomicReference));
    }

    public final String zzih() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzaa().zza(atomicReference, 15000, "String test flag value", new zzgy(this, atomicReference));
    }

    public final Long zzii() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzaa().zza(atomicReference, 15000, "long test flag value", new zzha(this, atomicReference));
    }

    public final Integer zzij() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzaa().zza(atomicReference, 15000, "int test flag value", new zzhd(this, atomicReference));
    }

    public final Double zzik() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzaa().zza(atomicReference, 15000, "double test flag value", new zzhc(this, atomicReference));
    }

    public final void setMeasurementEnabled(boolean z) {
        zzbi();
        zzm();
        zzaa().zza((Runnable) new zzhf(this, z));
    }

    public final void zza(boolean z) {
        zzbi();
        zzm();
        zzaa().zza((Runnable) new zzhe(this, z));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzg(boolean z) {
        zzo();
        zzm();
        zzbi();
        zzab().zzgr().zza("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzac().setMeasurementEnabled(z);
        zzil();
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzil() {
        if (zzad().zze(zzr().zzag(), zzak.zzik)) {
            zzo();
            String zzho = zzac().zzlx.zzho();
            if (zzho != null) {
                if ("unset".equals(zzho)) {
                    zza(TapjoyConstants.TJC_APP_PLACEMENT, "_npa", (Object) null, zzx().currentTimeMillis());
                } else {
                    zza(TapjoyConstants.TJC_APP_PLACEMENT, "_npa", (Object) Long.valueOf("true".equals(zzho) ? 1 : 0), zzx().currentTimeMillis());
                }
            }
        }
        if (!this.zzj.isEnabled() || !this.zzpz) {
            zzab().zzgr().zzao("Updating Scion state (FE)");
            zzs().zzip();
            return;
        }
        zzab().zzgr().zzao("Recording app launch after enabling measurement for the first time (FE)");
        zzim();
    }

    public final void setMinimumSessionDuration(long j) {
        zzm();
        zzaa().zza((Runnable) new zzhh(this, j));
    }

    public final void setSessionTimeoutDuration(long j) {
        zzm();
        zzaa().zza((Runnable) new zzhg(this, j));
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z) {
        logEvent(str, str2, bundle, false, true, zzx().currentTimeMillis());
    }

    public final void logEvent(String str, String str2, Bundle bundle) {
        logEvent(str, str2, bundle, true, true, zzx().currentTimeMillis());
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zza(String str, String str2, Bundle bundle) {
        zzm();
        zzo();
        zza(str, str2, zzx().currentTimeMillis(), bundle);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zza(String str, String str2, long j, Bundle bundle) {
        zzm();
        zzo();
        zza(str, str2, j, bundle, true, this.zzpv == null || zzjs.zzbq(str2), false, null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0136  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r28, java.lang.String r29, long r30, android.os.Bundle r32, boolean r33, boolean r34, boolean r35, java.lang.String r36) {
        /*
            r27 = this;
            r7 = r27
            r8 = r28
            r15 = r29
            r13 = r30
            r12 = r32
            r11 = r36
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r28)
            com.google.android.gms.measurement.internal.zzs r0 = r27.zzad()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzak.zzip
            boolean r0 = r0.zze(r11, r1)
            if (r0 != 0) goto L_0x001e
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r29)
        L_0x001e:
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r32)
            r27.zzo()
            r27.zzbi()
            com.google.android.gms.measurement.internal.zzfj r0 = r7.zzj
            boolean r0 = r0.isEnabled()
            if (r0 != 0) goto L_0x003d
            com.google.android.gms.measurement.internal.zzef r0 = r27.zzab()
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgr()
            java.lang.String r1 = "Event not sent since app measurement is disabled"
            r0.zzao(r1)
            return
        L_0x003d:
            com.google.android.gms.measurement.internal.zzs r0 = r27.zzad()
            com.google.android.gms.measurement.internal.zzdy r1 = r27.zzr()
            java.lang.String r1 = r1.zzag()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzak.zzix
            boolean r0 = r0.zze(r1, r2)
            if (r0 == 0) goto L_0x006f
            com.google.android.gms.measurement.internal.zzdy r0 = r27.zzr()
            java.util.List r0 = r0.zzbh()
            if (r0 == 0) goto L_0x006f
            boolean r0 = r0.contains(r15)
            if (r0 != 0) goto L_0x006f
            com.google.android.gms.measurement.internal.zzef r0 = r27.zzab()
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgr()
            java.lang.String r1 = "Dropping non-safelisted event. event name, origin"
            r0.zza(r1, r15, r8)
            return
        L_0x006f:
            boolean r0 = r7.zzpx
            r10 = 0
            r16 = 0
            r9 = 1
            if (r0 != 0) goto L_0x00c8
            r7.zzpx = r9
            com.google.android.gms.measurement.internal.zzfj r0 = r7.zzj     // Catch:{ ClassNotFoundException -> 0x00bb }
            boolean r0 = r0.zzia()     // Catch:{ ClassNotFoundException -> 0x00bb }
            java.lang.String r1 = "com.google.android.gms.tagmanager.TagManagerService"
            if (r0 != 0) goto L_0x0090
            android.content.Context r0 = r27.getContext()     // Catch:{ ClassNotFoundException -> 0x00bb }
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00bb }
            java.lang.Class r0 = java.lang.Class.forName(r1, r9, r0)     // Catch:{ ClassNotFoundException -> 0x00bb }
            goto L_0x0094
        L_0x0090:
            java.lang.Class r0 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x00bb }
        L_0x0094:
            java.lang.String r1 = "initialize"
            java.lang.Class[] r2 = new java.lang.Class[r9]     // Catch:{ Exception -> 0x00ac }
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r2[r16] = r3     // Catch:{ Exception -> 0x00ac }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ Exception -> 0x00ac }
            java.lang.Object[] r1 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x00ac }
            android.content.Context r2 = r27.getContext()     // Catch:{ Exception -> 0x00ac }
            r1[r16] = r2     // Catch:{ Exception -> 0x00ac }
            r0.invoke(r10, r1)     // Catch:{ Exception -> 0x00ac }
            goto L_0x00c8
        L_0x00ac:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzef r1 = r27.zzab()     // Catch:{ ClassNotFoundException -> 0x00bb }
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgn()     // Catch:{ ClassNotFoundException -> 0x00bb }
            java.lang.String r2 = "Failed to invoke Tag Manager's initialize() method"
            r1.zza(r2, r0)     // Catch:{ ClassNotFoundException -> 0x00bb }
            goto L_0x00c8
        L_0x00bb:
            com.google.android.gms.measurement.internal.zzef r0 = r27.zzab()
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgq()
            java.lang.String r1 = "Tag Manager is not found and thus will not be used"
            r0.zzao(r1)
        L_0x00c8:
            com.google.android.gms.measurement.internal.zzs r0 = r27.zzad()
            com.google.android.gms.measurement.internal.zzdy r1 = r27.zzr()
            java.lang.String r1 = r1.zzag()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzak.zzje
            boolean r0 = r0.zze(r1, r2)
            if (r0 == 0) goto L_0x0101
            java.lang.String r0 = "_cmp"
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x0101
            java.lang.String r0 = "gclid"
            boolean r1 = r12.containsKey(r0)
            if (r1 == 0) goto L_0x0101
            java.lang.String r4 = r12.getString(r0)
            com.google.android.gms.common.util.Clock r0 = r27.zzx()
            long r5 = r0.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_lgclid"
            r1 = r27
            r1.zza(r2, r3, r4, r5)
        L_0x0101:
            r0 = 40
            r1 = 2
            if (r35 == 0) goto L_0x016a
            r27.zzae()
            java.lang.String r2 = "_iap"
            boolean r2 = r2.equals(r15)
            if (r2 != 0) goto L_0x016a
            com.google.android.gms.measurement.internal.zzfj r2 = r7.zzj
            com.google.android.gms.measurement.internal.zzjs r2 = r2.zzz()
            java.lang.String r3 = "event"
            boolean r4 = r2.zzp(r3, r15)
            if (r4 != 0) goto L_0x0121
        L_0x011f:
            r2 = 2
            goto L_0x0134
        L_0x0121:
            java.lang.String[] r4 = com.google.android.gms.measurement.internal.zzgj.zzpn
            boolean r4 = r2.zza(r3, r4, r15)
            if (r4 != 0) goto L_0x012c
            r2 = 13
            goto L_0x0134
        L_0x012c:
            boolean r2 = r2.zza(r3, r0, r15)
            if (r2 != 0) goto L_0x0133
            goto L_0x011f
        L_0x0133:
            r2 = 0
        L_0x0134:
            if (r2 == 0) goto L_0x016a
            com.google.android.gms.measurement.internal.zzef r1 = r27.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgm()
            com.google.android.gms.measurement.internal.zzed r3 = r27.zzy()
            java.lang.String r3 = r3.zzaj(r15)
            java.lang.String r4 = "Invalid public event name. Event will not be logged (FE)"
            r1.zza(r4, r3)
            com.google.android.gms.measurement.internal.zzfj r1 = r7.zzj
            r1.zzz()
            java.lang.String r0 = com.google.android.gms.measurement.internal.zzjs.zza(r15, r0, r9)
            if (r15 == 0) goto L_0x015d
            int r16 = r29.length()
            r1 = r16
            goto L_0x015e
        L_0x015d:
            r1 = 0
        L_0x015e:
            com.google.android.gms.measurement.internal.zzfj r3 = r7.zzj
            com.google.android.gms.measurement.internal.zzjs r3 = r3.zzz()
            java.lang.String r4 = "_ev"
            r3.zza(r2, r4, r0, r1)
            return
        L_0x016a:
            r27.zzae()
            com.google.android.gms.measurement.internal.zzhq r2 = r27.zzt()
            com.google.android.gms.measurement.internal.zzhr r2 = r2.zzin()
            java.lang.String r3 = "_sc"
            if (r2 == 0) goto L_0x0181
            boolean r4 = r12.containsKey(r3)
            if (r4 != 0) goto L_0x0181
            r2.zzqx = r9
        L_0x0181:
            if (r33 == 0) goto L_0x0187
            if (r35 == 0) goto L_0x0187
            r4 = 1
            goto L_0x0188
        L_0x0187:
            r4 = 0
        L_0x0188:
            com.google.android.gms.measurement.internal.zzhq.zza(r2, r12, r4)
            java.lang.String r4 = "am"
            boolean r17 = r4.equals(r8)
            boolean r4 = com.google.android.gms.measurement.internal.zzjs.zzbq(r29)
            if (r33 == 0) goto L_0x01ca
            com.google.android.gms.measurement.internal.zzgk r5 = r7.zzpv
            if (r5 == 0) goto L_0x01ca
            if (r4 != 0) goto L_0x01ca
            if (r17 != 0) goto L_0x01ca
            com.google.android.gms.measurement.internal.zzef r0 = r27.zzab()
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgr()
            com.google.android.gms.measurement.internal.zzed r1 = r27.zzy()
            java.lang.String r1 = r1.zzaj(r15)
            com.google.android.gms.measurement.internal.zzed r2 = r27.zzy()
            java.lang.String r2 = r2.zzc(r12)
            java.lang.String r3 = "Passing event to registered event handler (FE)"
            r0.zza(r3, r1, r2)
            com.google.android.gms.measurement.internal.zzgk r1 = r7.zzpv
            r2 = r28
            r3 = r29
            r4 = r32
            r5 = r30
            r1.interceptEvent(r2, r3, r4, r5)
            return
        L_0x01ca:
            com.google.android.gms.measurement.internal.zzfj r4 = r7.zzj
            boolean r4 = r4.zzie()
            if (r4 != 0) goto L_0x01d3
            return
        L_0x01d3:
            com.google.android.gms.measurement.internal.zzjs r4 = r27.zzz()
            int r4 = r4.zzbl(r15)
            if (r4 == 0) goto L_0x0219
            com.google.android.gms.measurement.internal.zzef r1 = r27.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgm()
            com.google.android.gms.measurement.internal.zzed r2 = r27.zzy()
            java.lang.String r2 = r2.zzaj(r15)
            java.lang.String r3 = "Invalid event name. Event will not be logged (FE)"
            r1.zza(r3, r2)
            r27.zzz()
            java.lang.String r0 = com.google.android.gms.measurement.internal.zzjs.zza(r15, r0, r9)
            if (r15 == 0) goto L_0x0201
            int r1 = r29.length()
            r16 = r1
        L_0x0201:
            com.google.android.gms.measurement.internal.zzfj r1 = r7.zzj
            com.google.android.gms.measurement.internal.zzjs r1 = r1.zzz()
            java.lang.String r2 = "_ev"
            r28 = r1
            r29 = r36
            r30 = r4
            r31 = r2
            r32 = r0
            r33 = r16
            r28.zza(r29, r30, r31, r32, r33)
            return
        L_0x0219:
            r0 = 4
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.String r5 = "_o"
            r0[r16] = r5
            java.lang.String r4 = "_sn"
            r0[r9] = r4
            r0[r1] = r3
            r1 = 3
            java.lang.String r6 = "_si"
            r0[r1] = r6
            java.util.List r0 = com.google.android.gms.common.util.CollectionUtils.listOf((T[]) r0)
            com.google.android.gms.measurement.internal.zzjs r1 = r27.zzz()
            r18 = 1
            r9 = r1
            r1 = r10
            r10 = r36
            r11 = r29
            r12 = r32
            r7 = r13
            r13 = r0
            r14 = r35
            r33 = r5
            r5 = r15
            r15 = r18
            android.os.Bundle r15 = r9.zza(r10, r11, r12, r13, r14, r15)
            if (r15 == 0) goto L_0x0273
            boolean r9 = r15.containsKey(r3)
            if (r9 == 0) goto L_0x0273
            boolean r9 = r15.containsKey(r6)
            if (r9 != 0) goto L_0x0259
            goto L_0x0273
        L_0x0259:
            java.lang.String r1 = r15.getString(r4)
            java.lang.String r3 = r15.getString(r3)
            long r9 = r15.getLong(r6)
            java.lang.Long r4 = java.lang.Long.valueOf(r9)
            com.google.android.gms.measurement.internal.zzhr r10 = new com.google.android.gms.measurement.internal.zzhr
            long r11 = r4.longValue()
            r10.<init>(r1, r3, r11)
            goto L_0x0274
        L_0x0273:
            r10 = r1
        L_0x0274:
            if (r10 != 0) goto L_0x0278
            r14 = r2
            goto L_0x0279
        L_0x0278:
            r14 = r10
        L_0x0279:
            com.google.android.gms.measurement.internal.zzs r1 = r27.zzad()
            r13 = r36
            boolean r1 = r1.zzz(r13)
            java.lang.String r12 = "_ae"
            r9 = 0
            if (r1 == 0) goto L_0x02af
            r27.zzae()
            com.google.android.gms.measurement.internal.zzhq r1 = r27.zzt()
            com.google.android.gms.measurement.internal.zzhr r1 = r1.zzin()
            if (r1 == 0) goto L_0x02af
            boolean r1 = r12.equals(r5)
            if (r1 == 0) goto L_0x02af
            com.google.android.gms.measurement.internal.zziw r1 = r27.zzv()
            long r1 = r1.zzjb()
            int r3 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r3 <= 0) goto L_0x02af
            com.google.android.gms.measurement.internal.zzjs r3 = r27.zzz()
            r3.zzb(r15, r1)
        L_0x02af:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r11.add(r15)
            com.google.android.gms.measurement.internal.zzjs r1 = r27.zzz()
            java.security.SecureRandom r1 = r1.zzjw()
            long r3 = r1.nextLong()
            com.google.android.gms.measurement.internal.zzs r1 = r27.zzad()
            com.google.android.gms.measurement.internal.zzdy r2 = r27.zzr()
            java.lang.String r2 = r2.zzag()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzak.zzid
            boolean r1 = r1.zze(r2, r6)
            if (r1 == 0) goto L_0x0363
            com.google.android.gms.measurement.internal.zzeo r1 = r27.zzac()
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzma
            long r1 = r1.get()
            int r6 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r6 <= 0) goto L_0x0363
            com.google.android.gms.measurement.internal.zzeo r1 = r27.zzac()
            boolean r1 = r1.zzx(r7)
            if (r1 == 0) goto L_0x0363
            com.google.android.gms.measurement.internal.zzeo r1 = r27.zzac()
            com.google.android.gms.measurement.internal.zzeq r1 = r1.zzmd
            boolean r1 = r1.get()
            if (r1 == 0) goto L_0x0363
            com.google.android.gms.measurement.internal.zzef r1 = r27.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            java.lang.String r2 = "Current session is expired, remove the session number and Id"
            r1.zzao(r2)
            com.google.android.gms.measurement.internal.zzs r1 = r27.zzad()
            com.google.android.gms.measurement.internal.zzdy r2 = r27.zzr()
            java.lang.String r2 = r2.zzag()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzak.zzhz
            boolean r1 = r1.zze(r2, r6)
            if (r1 == 0) goto L_0x0338
            r6 = 0
            com.google.android.gms.common.util.Clock r1 = r27.zzx()
            long r19 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r18 = "_sid"
            r1 = r27
            r21 = r3
            r3 = r18
            r4 = r6
            r23 = r33
            r5 = r19
            r1.zza(r2, r3, r4, r5)
            goto L_0x033c
        L_0x0338:
            r23 = r33
            r21 = r3
        L_0x033c:
            com.google.android.gms.measurement.internal.zzs r1 = r27.zzad()
            com.google.android.gms.measurement.internal.zzdy r2 = r27.zzr()
            java.lang.String r2 = r2.zzag()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzak.zzia
            boolean r1 = r1.zze(r2, r3)
            if (r1 == 0) goto L_0x0367
            r4 = 0
            com.google.android.gms.common.util.Clock r1 = r27.zzx()
            long r5 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_sno"
            r1 = r27
            r1.zza(r2, r3, r4, r5)
            goto L_0x0367
        L_0x0363:
            r23 = r33
            r21 = r3
        L_0x0367:
            com.google.android.gms.measurement.internal.zzs r1 = r27.zzad()
            com.google.android.gms.measurement.internal.zzdy r2 = r27.zzr()
            java.lang.String r2 = r2.zzag()
            boolean r1 = r1.zzy(r2)
            if (r1 == 0) goto L_0x03a0
            java.lang.String r1 = "extend_session"
            long r1 = r15.getLong(r1, r9)
            r3 = 1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x03a0
            com.google.android.gms.measurement.internal.zzef r1 = r27.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            java.lang.String r2 = "EXTEND_SESSION param attached: initiate a new session or extend the current active session"
            r1.zzao(r2)
            r5 = r7
            r7 = r27
            com.google.android.gms.measurement.internal.zzfj r1 = r7.zzj
            com.google.android.gms.measurement.internal.zziw r1 = r1.zzv()
            r8 = 1
            r1.zza(r5, r8)
            goto L_0x03a4
        L_0x03a0:
            r5 = r7
            r8 = 1
            r7 = r27
        L_0x03a4:
            java.util.Set r1 = r15.keySet()
            int r2 = r32.size()
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.Object[] r1 = r1.toArray(r2)
            java.lang.String[] r1 = (java.lang.String[]) r1
            java.util.Arrays.sort(r1)
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L_0x03ba:
            java.lang.String r10 = "_eid"
            if (r3 >= r2) goto L_0x046b
            r9 = r1[r3]
            java.lang.Object r18 = r15.get(r9)
            r27.zzz()
            android.os.Bundle[] r8 = com.google.android.gms.measurement.internal.zzjs.zzb(r18)
            if (r8 == 0) goto L_0x0444
            r32 = r1
            int r1 = r8.length
            r15.putInt(r9, r1)
            r18 = r2
            r1 = 0
        L_0x03d6:
            int r2 = r8.length
            if (r1 >= r2) goto L_0x0434
            r2 = r8[r1]
            r5 = 1
            com.google.android.gms.measurement.internal.zzhq.zza(r14, r2, r5)
            com.google.android.gms.measurement.internal.zzjs r5 = r27.zzz()
            r6 = 0
            java.lang.String r19 = "_ep"
            r24 = r9
            r9 = r5
            r5 = r10
            r10 = r36
            r25 = r11
            r11 = r19
            r26 = r12
            r12 = r2
            r2 = r13
            r13 = r0
            r19 = r14
            r14 = r35
            r33 = r0
            r0 = r15
            r15 = r6
            android.os.Bundle r6 = r9.zza(r10, r11, r12, r13, r14, r15)
            java.lang.String r9 = "_en"
            r10 = r29
            r6.putString(r9, r10)
            r11 = r21
            r6.putLong(r5, r11)
            java.lang.String r9 = "_gn"
            r13 = r24
            r6.putString(r9, r13)
            int r9 = r8.length
            java.lang.String r14 = "_ll"
            r6.putInt(r14, r9)
            java.lang.String r9 = "_i"
            r6.putInt(r9, r1)
            r9 = r25
            r9.add(r6)
            int r1 = r1 + 1
            r15 = r0
            r10 = r5
            r14 = r19
            r12 = r26
            r5 = r30
            r0 = r33
            r11 = r9
            r9 = r13
            r13 = r2
            goto L_0x03d6
        L_0x0434:
            r10 = r29
            r33 = r0
            r9 = r11
            r26 = r12
            r2 = r13
            r19 = r14
            r0 = r15
            r11 = r21
            int r1 = r8.length
            int r4 = r4 + r1
            goto L_0x0455
        L_0x0444:
            r10 = r29
            r33 = r0
            r32 = r1
            r18 = r2
            r9 = r11
            r26 = r12
            r2 = r13
            r19 = r14
            r0 = r15
            r11 = r21
        L_0x0455:
            int r3 = r3 + 1
            r5 = r30
            r1 = r32
            r15 = r0
            r13 = r2
            r21 = r11
            r2 = r18
            r14 = r19
            r12 = r26
            r8 = 1
            r0 = r33
            r11 = r9
            goto L_0x03ba
        L_0x046b:
            r5 = r10
            r9 = r11
            r26 = r12
            r2 = r13
            r0 = r15
            r11 = r21
            r10 = r29
            if (r4 == 0) goto L_0x047f
            r0.putLong(r5, r11)
            java.lang.String r1 = "_epc"
            r0.putInt(r1, r4)
        L_0x047f:
            r0 = 0
        L_0x0480:
            int r1 = r9.size()
            if (r0 >= r1) goto L_0x050b
            java.lang.Object r1 = r9.get(r0)
            android.os.Bundle r1 = (android.os.Bundle) r1
            if (r0 == 0) goto L_0x0490
            r3 = 1
            goto L_0x0491
        L_0x0490:
            r3 = 0
        L_0x0491:
            if (r3 == 0) goto L_0x0498
            java.lang.String r3 = "_ep"
            r8 = r28
            goto L_0x049b
        L_0x0498:
            r8 = r28
            r3 = r10
        L_0x049b:
            r11 = r23
            r1.putString(r11, r8)
            if (r34 == 0) goto L_0x04aa
            com.google.android.gms.measurement.internal.zzjs r4 = r27.zzz()
            android.os.Bundle r1 = r4.zzg(r1)
        L_0x04aa:
            r12 = r1
            com.google.android.gms.measurement.internal.zzef r1 = r27.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgr()
            com.google.android.gms.measurement.internal.zzed r4 = r27.zzy()
            java.lang.String r4 = r4.zzaj(r10)
            com.google.android.gms.measurement.internal.zzed r5 = r27.zzy()
            java.lang.String r5 = r5.zzc(r12)
            java.lang.String r6 = "Logging event (FE)"
            r1.zza(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzai r13 = new com.google.android.gms.measurement.internal.zzai
            com.google.android.gms.measurement.internal.zzah r4 = new com.google.android.gms.measurement.internal.zzah
            r4.<init>(r12)
            r1 = r13
            r14 = r2
            r2 = r3
            r3 = r4
            r4 = r28
            r5 = r30
            r1.<init>(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzhv r1 = r27.zzs()
            r1.zzc(r13, r14)
            if (r17 != 0) goto L_0x0504
            java.util.Set<com.google.android.gms.measurement.internal.zzgn> r1 = r7.zzpw
            java.util.Iterator r13 = r1.iterator()
        L_0x04e9:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L_0x0504
            java.lang.Object r1 = r13.next()
            com.google.android.gms.measurement.internal.zzgn r1 = (com.google.android.gms.measurement.internal.zzgn) r1
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>(r12)
            r2 = r28
            r3 = r29
            r5 = r30
            r1.onEvent(r2, r3, r4, r5)
            goto L_0x04e9
        L_0x0504:
            int r0 = r0 + 1
            r23 = r11
            r2 = r14
            goto L_0x0480
        L_0x050b:
            r27.zzae()
            com.google.android.gms.measurement.internal.zzhq r0 = r27.zzt()
            com.google.android.gms.measurement.internal.zzhr r0 = r0.zzin()
            if (r0 == 0) goto L_0x0528
            r0 = r26
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0528
            com.google.android.gms.measurement.internal.zziw r0 = r27.zzv()
            r1 = 1
            r0.zza(r1, r1)
        L_0x0528:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgp.zza(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        boolean z3;
        zzm();
        String str3 = str == null ? TapjoyConstants.TJC_APP_PLACEMENT : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (z2) {
            if (this.zzpv != null && !zzjs.zzbq(str2)) {
                z3 = false;
                zzb(str3, str2, j, bundle2, z2, z3, !z, null);
            }
        }
        z3 = true;
        zzb(str3, str2, j, bundle2, z2, z3, !z, null);
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle zzh = zzjs.zzh(bundle);
        zzfc zzaa = zzaa();
        zzgr zzgr = new zzgr(this, str, str2, j, zzh, z, z2, z3, str3);
        zzaa.zza((Runnable) zzgr);
    }

    public final void zzb(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, z, zzx().currentTimeMillis());
    }

    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        if (str == null) {
            str = TapjoyConstants.TJC_APP_PLACEMENT;
        }
        String str3 = str;
        int i = 6;
        int i2 = 0;
        if (z) {
            i = zzz().zzbm(str2);
        } else {
            zzjs zzz = zzz();
            String str4 = "user property";
            if (zzz.zzp(str4, str2)) {
                if (!zzz.zza(str4, zzgl.zzpp, str2)) {
                    i = 15;
                } else if (zzz.zza(str4, 24, str2)) {
                    i = 0;
                }
            }
        }
        String str5 = "_ev";
        if (i != 0) {
            zzz();
            String zza = zzjs.zza(str2, 24, true);
            if (str2 != null) {
                i2 = str2.length();
            }
            this.zzj.zzz().zza(i, str5, zza, i2);
        } else if (obj != null) {
            int zzc = zzz().zzc(str2, obj);
            if (zzc != 0) {
                zzz();
                String zza2 = zzjs.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i2 = String.valueOf(obj).length();
                }
                this.zzj.zzz().zza(zzc, str5, zza2, i2);
                return;
            }
            Object zzd = zzz().zzd(str2, obj);
            if (zzd != null) {
                zza(str3, str2, j, zzd);
            }
        } else {
            zza(str3, str2, j, (Object) null);
        }
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzfc zzaa = zzaa();
        zzgq zzgq = new zzgq(this, str, str2, obj, j);
        zzaa.zza((Runnable) zzgq);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0092  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzo()
            r8.zzm()
            r8.zzbi()
            com.google.android.gms.measurement.internal.zzs r0 = r8.zzad()
            com.google.android.gms.measurement.internal.zzdy r1 = r8.zzr()
            java.lang.String r1 = r1.zzag()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzak.zzik
            boolean r0 = r0.zze(r1, r2)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L_0x007a
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x007a
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L_0x006a
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x006a
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            java.lang.String r11 = "false"
            boolean r10 = r11.equals(r10)
            r2 = 1
            if (r10 == 0) goto L_0x004c
            r4 = r2
            goto L_0x004e
        L_0x004c:
            r4 = 0
        L_0x004e:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            com.google.android.gms.measurement.internal.zzeo r0 = r8.zzac()
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzlx
            r4 = r10
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0065
            java.lang.String r11 = "true"
        L_0x0065:
            r0.zzau(r11)
            r6 = r10
            goto L_0x0078
        L_0x006a:
            if (r11 != 0) goto L_0x007a
            com.google.android.gms.measurement.internal.zzeo r10 = r8.zzac()
            com.google.android.gms.measurement.internal.zzev r10 = r10.zzlx
            java.lang.String r0 = "unset"
            r10.zzau(r0)
            r6 = r11
        L_0x0078:
            r3 = r1
            goto L_0x007c
        L_0x007a:
            r3 = r10
            r6 = r11
        L_0x007c:
            com.google.android.gms.measurement.internal.zzfj r10 = r8.zzj
            boolean r10 = r10.isEnabled()
            if (r10 != 0) goto L_0x0092
            com.google.android.gms.measurement.internal.zzef r9 = r8.zzab()
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzgr()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zzao(r10)
            return
        L_0x0092:
            com.google.android.gms.measurement.internal.zzfj r10 = r8.zzj
            boolean r10 = r10.zzie()
            if (r10 != 0) goto L_0x009b
            return
        L_0x009b:
            com.google.android.gms.measurement.internal.zzef r10 = r8.zzab()
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzgr()
            com.google.android.gms.measurement.internal.zzed r11 = r8.zzy()
            java.lang.String r11 = r11.zzaj(r3)
            java.lang.String r0 = "Setting user property (FE)"
            r10.zza(r0, r11, r6)
            com.google.android.gms.measurement.internal.zzjn r10 = new com.google.android.gms.measurement.internal.zzjn
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.zzhv r9 = r8.zzs()
            r9.zzb(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgp.zza(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final List<zzjn> zzh(boolean z) {
        zzm();
        zzbi();
        zzab().zzgr().zzao("Fetching user attributes (FE)");
        if (zzaa().zzhp()) {
            zzab().zzgk().zzao("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        } else if (zzr.isMainThread()) {
            zzab().zzgk().zzao("Cannot get all user properties from main thread");
            return Collections.emptyList();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                this.zzj.zzaa().zza((Runnable) new zzgt(this, atomicReference, z));
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e) {
                    zzab().zzgn().zza("Interrupted waiting for get user properties", e);
                }
            }
            List<zzjn> list = (List) atomicReference.get();
            if (list == null) {
                zzab().zzgn().zzao("Timed out waiting for get user properties");
                list = Collections.emptyList();
            }
            return list;
        }
    }

    @Nullable
    public final String zzi() {
        zzm();
        return (String) this.zzpy.get();
    }

    @Nullable
    public final String zzy(long j) {
        if (zzaa().zzhp()) {
            zzab().zzgk().zzao("Cannot retrieve app instance id from analytics worker thread");
            return null;
        } else if (zzr.isMainThread()) {
            zzab().zzgk().zzao("Cannot retrieve app instance id from main thread");
            return null;
        } else {
            long elapsedRealtime = zzx().elapsedRealtime();
            String zzz = zzz(120000);
            long elapsedRealtime2 = zzx().elapsedRealtime() - elapsedRealtime;
            if (zzz == null && elapsedRealtime2 < 120000) {
                zzz = zzz(120000 - elapsedRealtime2);
            }
            return zzz;
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzbg(@Nullable String str) {
        this.zzpy.set(str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:10|11|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        zzab().zzgn().zzao("Interrupted waiting for app instance id");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001d */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String zzz(long r4) {
        /*
            r3 = this;
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference
            r0.<init>()
            monitor-enter(r0)
            com.google.android.gms.measurement.internal.zzfc r1 = r3.zzaa()     // Catch:{ all -> 0x002d }
            com.google.android.gms.measurement.internal.zzgs r2 = new com.google.android.gms.measurement.internal.zzgs     // Catch:{ all -> 0x002d }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x002d }
            r1.zza(r2)     // Catch:{ all -> 0x002d }
            r0.wait(r4)     // Catch:{ InterruptedException -> 0x001d }
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            java.lang.Object r4 = r0.get()
            java.lang.String r4 = (java.lang.String) r4
            return r4
        L_0x001d:
            com.google.android.gms.measurement.internal.zzef r4 = r3.zzab()     // Catch:{ all -> 0x002d }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgn()     // Catch:{ all -> 0x002d }
            java.lang.String r5 = "Interrupted waiting for app instance id"
            r4.zzao(r5)     // Catch:{ all -> 0x002d }
            r4 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r4
        L_0x002d:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgp.zzz(long):java.lang.String");
    }

    public final void resetAnalyticsData(long j) {
        zzbg(null);
        zzaa().zza((Runnable) new zzgv(this, j));
    }

    @WorkerThread
    public final void zzim() {
        zzo();
        zzm();
        zzbi();
        if (this.zzj.zzie()) {
            zzs().zzim();
            this.zzpz = false;
            String zzhh = zzac().zzhh();
            if (!TextUtils.isEmpty(zzhh)) {
                zzw().zzbi();
                if (!zzhh.equals(VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzhh);
                    logEvent("auto", "_ou", bundle);
                }
            }
        }
    }

    @WorkerThread
    public final void zza(zzgk zzgk) {
        zzo();
        zzm();
        zzbi();
        if (zzgk != null) {
            zzgk zzgk2 = this.zzpv;
            if (zzgk != zzgk2) {
                Preconditions.checkState(zzgk2 == null, "EventInterceptor already set.");
            }
        }
        this.zzpv = zzgk;
    }

    public final void zza(zzgn zzgn) {
        zzm();
        zzbi();
        Preconditions.checkNotNull(zzgn);
        if (!this.zzpw.add(zzgn)) {
            zzab().zzgn().zzao("OnEventListener already registered");
        }
    }

    public final void zzb(zzgn zzgn) {
        zzm();
        zzbi();
        Preconditions.checkNotNull(zzgn);
        if (!this.zzpw.remove(zzgn)) {
            zzab().zzgn().zzao("OnEventListener had not been registered");
        }
    }

    public final void setConditionalUserProperty(Bundle bundle) {
        setConditionalUserProperty(bundle, zzx().currentTimeMillis());
    }

    public final void setConditionalUserProperty(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzm();
        Bundle bundle2 = new Bundle(bundle);
        String str = "app_id";
        if (!TextUtils.isEmpty(bundle2.getString(str))) {
            zzab().zzgn().zzao("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove(str);
        zza(bundle2, j);
    }

    public final void zzd(Bundle bundle) {
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString("app_id"));
        zzl();
        zza(new Bundle(bundle), zzx().currentTimeMillis());
    }

    private final void zza(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzgg.zza(bundle, "app_id", String.class, null);
        String str = "origin";
        zzgg.zza(bundle, str, String.class, null);
        String str2 = "name";
        zzgg.zza(bundle, str2, String.class, null);
        String str3 = "value";
        zzgg.zza(bundle, str3, Object.class, null);
        String str4 = ConditionalUserProperty.TRIGGER_EVENT_NAME;
        zzgg.zza(bundle, str4, String.class, null);
        Long valueOf = Long.valueOf(0);
        String str5 = ConditionalUserProperty.TRIGGER_TIMEOUT;
        zzgg.zza(bundle, str5, Long.class, valueOf);
        zzgg.zza(bundle, ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzgg.zza(bundle, ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzgg.zza(bundle, ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzgg.zza(bundle, ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        String str6 = ConditionalUserProperty.TIME_TO_LIVE;
        zzgg.zza(bundle, str6, Long.class, valueOf);
        zzgg.zza(bundle, ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzgg.zza(bundle, ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle.getString(str2));
        Preconditions.checkNotEmpty(bundle.getString(str));
        Preconditions.checkNotNull(bundle.get(str3));
        bundle.putLong(ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle.getString(str2);
        Object obj = bundle.get(str3);
        if (zzz().zzbm(string) != 0) {
            zzab().zzgk().zza("Invalid conditional user property name", zzy().zzal(string));
        } else if (zzz().zzc(string, obj) != 0) {
            zzab().zzgk().zza("Invalid conditional user property value", zzy().zzal(string), obj);
        } else {
            Object zzd = zzz().zzd(string, obj);
            if (zzd == null) {
                zzab().zzgk().zza("Unable to normalize conditional user property value", zzy().zzal(string), obj);
                return;
            }
            zzgg.zza(bundle, zzd);
            long j2 = bundle.getLong(str5);
            if (TextUtils.isEmpty(bundle.getString(str4)) || (j2 <= 15552000000L && j2 >= 1)) {
                long j3 = bundle.getLong(str6);
                if (j3 > 15552000000L || j3 < 1) {
                    zzab().zzgk().zza("Invalid conditional user property time to live", zzy().zzal(string), Long.valueOf(j3));
                    return;
                }
                zzaa().zza((Runnable) new zzgx(this, bundle));
                return;
            }
            zzab().zzgk().zza("Invalid conditional user property timeout", zzy().zzal(string), Long.valueOf(j2));
        }
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zzm();
        zza((String) null, str, str2, bundle);
    }

    public final void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotEmpty(str);
        zzl();
        zza(str, str2, str3, bundle);
    }

    private final void zza(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzx().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        Bundle bundle2 = new Bundle();
        if (str != null) {
            bundle2.putString("app_id", str);
        }
        bundle2.putString("name", str2);
        bundle2.putLong(ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str3 != null) {
            bundle2.putString(ConditionalUserProperty.EXPIRED_EVENT_NAME, str3);
            bundle2.putBundle(ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzaa().zza((Runnable) new zzgw(this, bundle2));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zze(Bundle bundle) {
        Bundle bundle2 = bundle;
        String str = "app_id";
        zzo();
        zzbi();
        Preconditions.checkNotNull(bundle);
        String str2 = "name";
        Preconditions.checkNotEmpty(bundle2.getString(str2));
        String str3 = "origin";
        Preconditions.checkNotEmpty(bundle2.getString(str3));
        String str4 = "value";
        Preconditions.checkNotNull(bundle2.get(str4));
        if (!this.zzj.isEnabled()) {
            zzab().zzgr().zzao("Conditional property not sent since collection is disabled");
            return;
        }
        zzjn zzjn = new zzjn(bundle2.getString(str2), bundle2.getLong(ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle2.get(str4), bundle2.getString(str3));
        try {
            zzai zza = zzz().zza(bundle2.getString(str), bundle2.getString(ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle2.getBundle(ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), bundle2.getString(str3), 0, true, false);
            zzq zzq = new zzq(bundle2.getString(str), bundle2.getString(str3), zzjn, bundle2.getLong(ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle2.getString(ConditionalUserProperty.TRIGGER_EVENT_NAME), zzz().zza(bundle2.getString(str), bundle2.getString(ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle2.getBundle(ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), bundle2.getString(str3), 0, true, false), bundle2.getLong(ConditionalUserProperty.TRIGGER_TIMEOUT), zza, bundle2.getLong(ConditionalUserProperty.TIME_TO_LIVE), zzz().zza(bundle2.getString(str), bundle2.getString(ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle2.getString(str3), 0, true, false));
            zzs().zzd(zzq);
        } catch (IllegalArgumentException unused) {
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzf(Bundle bundle) {
        Bundle bundle2 = bundle;
        String str = ConditionalUserProperty.CREATION_TIMESTAMP;
        String str2 = "origin";
        String str3 = "app_id";
        zzo();
        zzbi();
        Preconditions.checkNotNull(bundle);
        String str4 = "name";
        Preconditions.checkNotEmpty(bundle2.getString(str4));
        if (!this.zzj.isEnabled()) {
            zzab().zzgr().zzao("Conditional property not cleared since collection is disabled");
            return;
        }
        zzjn zzjn = new zzjn(bundle2.getString(str4), 0, null, null);
        try {
            zzai zza = zzz().zza(bundle2.getString(str3), bundle2.getString(ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle2.getString(str2), bundle2.getLong(str), true, false);
            zzjn zzjn2 = zzjn;
            zzq zzq = new zzq(bundle2.getString(str3), bundle2.getString(str2), zzjn2, bundle2.getLong(str), bundle2.getBoolean(ConditionalUserProperty.ACTIVE), bundle2.getString(ConditionalUserProperty.TRIGGER_EVENT_NAME), null, bundle2.getLong(ConditionalUserProperty.TRIGGER_TIMEOUT), null, bundle2.getLong(ConditionalUserProperty.TIME_TO_LIVE), zza);
            zzs().zzd(zzq);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final ArrayList<Bundle> zzn(String str, String str2) {
        zzm();
        return zze(null, str, str2);
    }

    public final ArrayList<Bundle> zzd(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzl();
        return zze(str, str2, str3);
    }

    @VisibleForTesting
    private final ArrayList<Bundle> zze(String str, String str2, String str3) {
        if (zzaa().zzhp()) {
            zzab().zzgk().zzao("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        } else if (zzr.isMainThread()) {
            zzab().zzgk().zzao("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                zzfc zzaa = this.zzj.zzaa();
                zzgz zzgz = new zzgz(this, atomicReference, str, str2, str3);
                zzaa.zza((Runnable) zzgz);
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e) {
                    zzab().zzgn().zza("Interrupted waiting for get conditional user properties", str, e);
                }
            }
            List list = (List) atomicReference.get();
            if (list != null) {
                return zzjs.zzd(list);
            }
            zzab().zzgn().zza("Timed out waiting for get conditional user properties", str);
            return new ArrayList<>();
        }
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        zzm();
        return zzb((String) null, str, str2, z);
    }

    public final Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        Preconditions.checkNotEmpty(str);
        zzl();
        return zzb(str, str2, str3, z);
    }

    @VisibleForTesting
    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        if (zzaa().zzhp()) {
            zzab().zzgk().zzao("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        } else if (zzr.isMainThread()) {
            zzab().zzgk().zzao("Cannot get user properties from main thread");
            return Collections.emptyMap();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                zzfc zzaa = this.zzj.zzaa();
                zzhb zzhb = new zzhb(this, atomicReference, str, str2, str3, z);
                zzaa.zza((Runnable) zzhb);
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e) {
                    zzab().zzgn().zza("Interrupted waiting for get user properties", e);
                }
            }
            List<zzjn> list = (List) atomicReference.get();
            if (list == null) {
                zzab().zzgn().zzao("Timed out waiting for get user properties");
                return Collections.emptyMap();
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (zzjn zzjn : list) {
                arrayMap.put(zzjn.name, zzjn.getValue());
            }
            return arrayMap;
        }
    }

    @Nullable
    public final String getCurrentScreenName() {
        zzhr zzio = this.zzj.zzt().zzio();
        if (zzio != null) {
            return zzio.zzqu;
        }
        return null;
    }

    @Nullable
    public final String getCurrentScreenClass() {
        zzhr zzio = this.zzj.zzt().zzio();
        if (zzio != null) {
            return zzio.zzqv;
        }
        return null;
    }

    @Nullable
    public final String getGmpAppId() {
        if (this.zzj.zzhx() != null) {
            return this.zzj.zzhx();
        }
        try {
            return GoogleServices.getGoogleAppId();
        } catch (IllegalStateException e) {
            this.zzj.zzab().zzgk().zza("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzl() {
        super.zzl();
    }

    public final /* bridge */ /* synthetic */ void zzm() {
        super.zzm();
    }

    public final /* bridge */ /* synthetic */ void zzn() {
        super.zzn();
    }

    public final /* bridge */ /* synthetic */ void zzo() {
        super.zzo();
    }

    public final /* bridge */ /* synthetic */ zza zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzgp zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzdy zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzhv zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzhq zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzeb zzu() {
        return super.zzu();
    }

    public final /* bridge */ /* synthetic */ zziw zzv() {
        return super.zzv();
    }

    public final /* bridge */ /* synthetic */ zzac zzw() {
        return super.zzw();
    }

    public final /* bridge */ /* synthetic */ Clock zzx() {
        return super.zzx();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final /* bridge */ /* synthetic */ zzed zzy() {
        return super.zzy();
    }

    public final /* bridge */ /* synthetic */ zzjs zzz() {
        return super.zzz();
    }

    public final /* bridge */ /* synthetic */ zzfc zzaa() {
        return super.zzaa();
    }

    public final /* bridge */ /* synthetic */ zzef zzab() {
        return super.zzab();
    }

    public final /* bridge */ /* synthetic */ zzeo zzac() {
        return super.zzac();
    }

    public final /* bridge */ /* synthetic */ zzs zzad() {
        return super.zzad();
    }

    public final /* bridge */ /* synthetic */ zzr zzae() {
        return super.zzae();
    }
}
