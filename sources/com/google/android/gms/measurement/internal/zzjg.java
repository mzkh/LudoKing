package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzbs.zzc;
import com.google.android.gms.internal.measurement.zzbs.zze;
import com.google.android.gms.internal.measurement.zzbs.zzg;
import com.google.android.gms.internal.measurement.zzbs.zzk;
import com.google.android.gms.internal.measurement.zzbw;
import com.google.android.gms.internal.measurement.zzey;
import com.google.android.gms.internal.measurement.zzx;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzjg implements zzgh {
    private static volatile zzjg zzsn;
    private boolean zzdh;
    private final zzfj zzj;
    private zzfd zzso;
    private zzej zzsp;
    private zzx zzsq;
    private zzem zzsr;
    private zzjc zzss;
    private zzp zzst;
    private final zzjo zzsu;
    private zzhp zzsv;
    private boolean zzsw;
    private boolean zzsx;
    @VisibleForTesting
    private long zzsy;
    private List<Runnable> zzsz;
    private int zzta;
    private int zztb;
    private boolean zztc;
    private boolean zztd;
    private boolean zzte;
    private FileLock zztf;
    private FileChannel zztg;
    private List<Long> zzth;
    private List<Long> zzti;
    private long zztj;

    class zza implements zzz {
        zzg zztn;
        List<Long> zzto;
        List<zzc> zztp;
        private long zztq;

        private zza() {
        }

        public final void zzb(zzg zzg) {
            Preconditions.checkNotNull(zzg);
            this.zztn = zzg;
        }

        public final boolean zza(long j, zzc zzc) {
            Preconditions.checkNotNull(zzc);
            if (this.zztp == null) {
                this.zztp = new ArrayList();
            }
            if (this.zzto == null) {
                this.zzto = new ArrayList();
            }
            if (this.zztp.size() > 0 && zza((zzc) this.zztp.get(0)) != zza(zzc)) {
                return false;
            }
            long zzuk = this.zztq + ((long) zzc.zzuk());
            if (zzuk >= ((long) Math.max(0, ((Integer) zzak.zzgn.get(null)).intValue()))) {
                return false;
            }
            this.zztq = zzuk;
            this.zztp.add(zzc);
            this.zzto.add(Long.valueOf(j));
            if (this.zztp.size() >= Math.max(1, ((Integer) zzak.zzgo.get(null)).intValue())) {
                return false;
            }
            return true;
        }

        private static long zza(zzc zzc) {
            return ((zzc.getTimestampMillis() / 1000) / 60) / 60;
        }

        /* synthetic */ zza(zzjg zzjg, zzjj zzjj) {
            this();
        }
    }

    public static zzjg zzm(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzsn == null) {
            synchronized (zzjg.class) {
                if (zzsn == null) {
                    zzsn = new zzjg(new zzjm(context));
                }
            }
        }
        return zzsn;
    }

    private zzjg(zzjm zzjm) {
        this(zzjm, null);
    }

    private zzjg(zzjm zzjm, zzfj zzfj) {
        this.zzdh = false;
        Preconditions.checkNotNull(zzjm);
        this.zzj = zzfj.zza(zzjm.zzob, (zzx) null);
        this.zztj = -1;
        zzjo zzjo = new zzjo(this);
        zzjo.initialize();
        this.zzsu = zzjo;
        zzej zzej = new zzej(this);
        zzej.initialize();
        this.zzsp = zzej;
        zzfd zzfd = new zzfd(this);
        zzfd.initialize();
        this.zzso = zzfd;
        this.zzj.zzaa().zza((Runnable) new zzjj(this, zzjm));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzjm zzjm) {
        this.zzj.zzaa().zzo();
        zzx zzx = new zzx(this);
        zzx.initialize();
        this.zzsq = zzx;
        this.zzj.zzad().zza((zzu) this.zzso);
        zzp zzp = new zzp(this);
        zzp.initialize();
        this.zzst = zzp;
        zzhp zzhp = new zzhp(this);
        zzhp.initialize();
        this.zzsv = zzhp;
        zzjc zzjc = new zzjc(this);
        zzjc.initialize();
        this.zzss = zzjc;
        this.zzsr = new zzem(this);
        if (this.zzta != this.zztb) {
            this.zzj.zzab().zzgk().zza("Not all upload components initialized", Integer.valueOf(this.zzta), Integer.valueOf(this.zztb));
        }
        this.zzdh = true;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void start() {
        this.zzj.zzaa().zzo();
        zzgy().zzca();
        if (this.zzj.zzac().zzlj.get() == 0) {
            this.zzj.zzac().zzlj.set(this.zzj.zzx().currentTimeMillis());
        }
        zzjn();
    }

    public final zzr zzae() {
        return this.zzj.zzae();
    }

    public final zzs zzad() {
        return this.zzj.zzad();
    }

    public final zzef zzab() {
        return this.zzj.zzab();
    }

    public final zzfc zzaa() {
        return this.zzj.zzaa();
    }

    public final zzfd zzgz() {
        zza((zzjh) this.zzso);
        return this.zzso;
    }

    public final zzej zzjf() {
        zza((zzjh) this.zzsp);
        return this.zzsp;
    }

    public final zzx zzgy() {
        zza((zzjh) this.zzsq);
        return this.zzsq;
    }

    private final zzem zzjg() {
        zzem zzem = this.zzsr;
        if (zzem != null) {
            return zzem;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzjc zzjh() {
        zza((zzjh) this.zzss);
        return this.zzss;
    }

    public final zzp zzgx() {
        zza((zzjh) this.zzst);
        return this.zzst;
    }

    public final zzhp zzji() {
        zza((zzjh) this.zzsv);
        return this.zzsv;
    }

    public final zzjo zzgw() {
        zza((zzjh) this.zzsu);
        return this.zzsu;
    }

    public final zzed zzy() {
        return this.zzj.zzy();
    }

    public final Context getContext() {
        return this.zzj.getContext();
    }

    public final Clock zzx() {
        return this.zzj.zzx();
    }

    public final zzjs zzz() {
        return this.zzj.zzz();
    }

    @WorkerThread
    private final void zzo() {
        this.zzj.zzaa().zzo();
    }

    /* access modifiers changed from: 0000 */
    public final void zzjj() {
        if (!this.zzdh) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    private static void zza(zzjh zzjh) {
        if (zzjh == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!zzjh.isInitialized()) {
            String valueOf = String.valueOf(zzjh.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zze(zzn zzn) {
        zzo();
        zzjj();
        Preconditions.checkNotEmpty(zzn.packageName);
        zzg(zzn);
    }

    private final long zzjk() {
        long currentTimeMillis = this.zzj.zzx().currentTimeMillis();
        zzeo zzac = this.zzj.zzac();
        zzac.zzbi();
        zzac.zzo();
        long j = zzac.zzln.get();
        if (j == 0) {
            j = 1 + ((long) zzac.zzz().zzjw().nextInt(86400000));
            zzac.zzln.set(j);
        }
        return ((((currentTimeMillis + j) / 1000) / 60) / 60) / 24;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzd(zzai zzai, String str) {
        zzai zzai2 = zzai;
        String str2 = str;
        zzf zzab = zzgy().zzab(str2);
        if (zzab == null || TextUtils.isEmpty(zzab.zzal())) {
            this.zzj.zzab().zzgr().zza("No app data available; dropping event", str2);
            return;
        }
        Boolean zzc = zzc(zzab);
        if (zzc == null) {
            if (!"_ui".equals(zzai2.name)) {
                this.zzj.zzab().zzgn().zza("Could not find package. appId", zzef.zzam(str));
            }
        } else if (!zzc.booleanValue()) {
            this.zzj.zzab().zzgk().zza("App version does not match; dropping event. appId", zzef.zzam(str));
            return;
        }
        zzn zzn = r2;
        zzf zzf = zzab;
        zzn zzn2 = new zzn(str, zzab.getGmpAppId(), zzab.zzal(), zzab.zzam(), zzab.zzan(), zzab.zzao(), zzab.zzap(), (String) null, zzab.isMeasurementEnabled(), false, zzf.getFirebaseInstanceId(), zzf.zzbd(), 0, 0, zzf.zzbe(), zzf.zzbf(), false, zzf.zzah(), zzf.zzbg(), zzf.zzaq(), zzf.zzbh());
        zzc(zzai2, zzn);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzc(zzai zzai, zzn zzn) {
        List<zzq> list;
        List<zzq> list2;
        List<zzq> list3;
        zzai zzai2 = zzai;
        zzn zzn2 = zzn;
        Preconditions.checkNotNull(zzn);
        Preconditions.checkNotEmpty(zzn2.packageName);
        zzo();
        zzjj();
        String str = zzn2.packageName;
        long j = zzai2.zzfu;
        if (zzgw().zze(zzai2, zzn2)) {
            if (!zzn2.zzcq) {
                zzg(zzn2);
                return;
            }
            if (this.zzj.zzad().zze(str, zzak.zzix) && zzn2.zzcw != null) {
                if (zzn2.zzcw.contains(zzai2.name)) {
                    Bundle zzcv = zzai2.zzfq.zzcv();
                    zzcv.putLong("ga_safelisted", 1);
                    zzai zzai3 = new zzai(zzai2.name, new zzah(zzcv), zzai2.origin, zzai2.zzfu);
                    zzai2 = zzai3;
                } else {
                    this.zzj.zzab().zzgr().zza("Dropping non-safelisted event. appId, event name, origin", str, zzai2.name, zzai2.origin);
                    return;
                }
            }
            zzgy().beginTransaction();
            try {
                zzx zzgy = zzgy();
                Preconditions.checkNotEmpty(str);
                zzgy.zzo();
                zzgy.zzbi();
                if (j < 0) {
                    zzgy.zzab().zzgn().zza("Invalid time querying timed out conditional properties", zzef.zzam(str), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zzgy.zzb("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzq zzq : list) {
                    if (zzq != null) {
                        this.zzj.zzab().zzgr().zza("User property timed out", zzq.packageName, this.zzj.zzy().zzal(zzq.zzdw.name), zzq.zzdw.getValue());
                        if (zzq.zzdx != null) {
                            zzd(new zzai(zzq.zzdx, j), zzn2);
                        }
                        zzgy().zzg(str, zzq.zzdw.name);
                    }
                }
                zzx zzgy2 = zzgy();
                Preconditions.checkNotEmpty(str);
                zzgy2.zzo();
                zzgy2.zzbi();
                if (j < 0) {
                    zzgy2.zzab().zzgn().zza("Invalid time querying expired conditional properties", zzef.zzam(str), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zzgy2.zzb("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzq zzq2 : list2) {
                    if (zzq2 != null) {
                        this.zzj.zzab().zzgr().zza("User property expired", zzq2.packageName, this.zzj.zzy().zzal(zzq2.zzdw.name), zzq2.zzdw.getValue());
                        zzgy().zzd(str, zzq2.zzdw.name);
                        if (zzq2.zzdz != null) {
                            arrayList.add(zzq2.zzdz);
                        }
                        zzgy().zzg(str, zzq2.zzdw.name);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    zzd(new zzai((zzai) obj, j), zzn2);
                }
                zzx zzgy3 = zzgy();
                String str2 = zzai2.name;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zzgy3.zzo();
                zzgy3.zzbi();
                if (j < 0) {
                    zzgy3.zzab().zzgn().zza("Invalid time querying triggered conditional properties", zzef.zzam(str), zzgy3.zzy().zzaj(str2), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zzgy3.zzb("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList3 = new ArrayList(list3.size());
                for (zzq zzq3 : list3) {
                    if (zzq3 != null) {
                        zzjn zzjn = zzq3.zzdw;
                        zzjp zzjp = r4;
                        zzjp zzjp2 = new zzjp(zzq3.packageName, zzq3.origin, zzjn.name, j, zzjn.getValue());
                        if (zzgy().zza(zzjp)) {
                            this.zzj.zzab().zzgr().zza("User property triggered", zzq3.packageName, this.zzj.zzy().zzal(zzjp.name), zzjp.value);
                        } else {
                            this.zzj.zzab().zzgk().zza("Too many active user properties, ignoring", zzef.zzam(zzq3.packageName), this.zzj.zzy().zzal(zzjp.name), zzjp.value);
                        }
                        if (zzq3.zzdy != null) {
                            arrayList3.add(zzq3.zzdy);
                        }
                        zzq3.zzdw = new zzjn(zzjp);
                        zzq3.active = true;
                        zzgy().zza(zzq3);
                    }
                }
                zzd(zzai2, zzn2);
                ArrayList arrayList4 = arrayList3;
                int size2 = arrayList4.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList4.get(i2);
                    i2++;
                    zzd(new zzai((zzai) obj2, j), zzn2);
                }
                zzgy().setTransactionSuccessful();
            } finally {
                zzgy().endTransaction();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:249:0x0853 A[Catch:{ SQLiteException -> 0x023a, all -> 0x08c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0883 A[Catch:{ SQLiteException -> 0x023a, all -> 0x08c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0272 A[Catch:{ SQLiteException -> 0x023a, all -> 0x08c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x02a9 A[Catch:{ SQLiteException -> 0x023a, all -> 0x08c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02f7 A[Catch:{ SQLiteException -> 0x023a, all -> 0x08c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0324  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzd(com.google.android.gms.measurement.internal.zzai r28, com.google.android.gms.measurement.internal.zzn r29) {
        /*
            r27 = this;
            r1 = r27
            r2 = r28
            r3 = r29
            java.lang.String r4 = "_s"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r29)
            java.lang.String r5 = r3.packageName
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            long r5 = java.lang.System.nanoTime()
            r27.zzo()
            r27.zzjj()
            java.lang.String r15 = r3.packageName
            com.google.android.gms.measurement.internal.zzjo r7 = r27.zzgw()
            boolean r7 = r7.zze(r2, r3)
            if (r7 != 0) goto L_0x0027
            return
        L_0x0027:
            boolean r7 = r3.zzcq
            if (r7 != 0) goto L_0x002f
            r1.zzg(r3)
            return
        L_0x002f:
            com.google.android.gms.measurement.internal.zzfd r7 = r27.zzgz()
            java.lang.String r8 = r2.name
            boolean r7 = r7.zzk(r15, r8)
            java.lang.String r14 = "_err"
            r13 = 0
            r12 = 1
            if (r7 == 0) goto L_0x00db
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzab()
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgn()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzef.zzam(r15)
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj
            com.google.android.gms.measurement.internal.zzed r5 = r5.zzy()
            java.lang.String r6 = r2.name
            java.lang.String r5 = r5.zzaj(r6)
            java.lang.String r6 = "Dropping blacklisted event. appId"
            r3.zza(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzfd r3 = r27.zzgz()
            boolean r3 = r3.zzbc(r15)
            if (r3 != 0) goto L_0x0075
            com.google.android.gms.measurement.internal.zzfd r3 = r27.zzgz()
            boolean r3 = r3.zzbd(r15)
            if (r3 == 0) goto L_0x0073
            goto L_0x0075
        L_0x0073:
            r3 = 0
            goto L_0x0076
        L_0x0075:
            r3 = 1
        L_0x0076:
            if (r3 != 0) goto L_0x0091
            java.lang.String r4 = r2.name
            boolean r4 = r14.equals(r4)
            if (r4 != 0) goto L_0x0091
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj
            com.google.android.gms.measurement.internal.zzjs r7 = r4.zzz()
            r9 = 11
            java.lang.String r11 = r2.name
            r12 = 0
            java.lang.String r10 = "_ev"
            r8 = r15
            r7.zza(r8, r9, r10, r11, r12)
        L_0x0091:
            if (r3 == 0) goto L_0x00da
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()
            com.google.android.gms.measurement.internal.zzf r2 = r2.zzab(r15)
            if (r2 == 0) goto L_0x00da
            long r3 = r2.zzat()
            long r5 = r2.zzas()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj
            com.google.android.gms.common.util.Clock r5 = r5.zzx()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            com.google.android.gms.measurement.internal.zzdu<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzak.zzhe
            java.lang.Object r5 = r5.get(r13)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00da
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzab()
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgr()
            java.lang.String r4 = "Fetching config for blacklisted app"
            r3.zzao(r4)
            r1.zzb(r2)
        L_0x00da:
            return
        L_0x00db:
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzab()
            r10 = 2
            boolean r7 = r7.isLoggable(r10)
            if (r7 == 0) goto L_0x0101
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzab()
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgs()
            com.google.android.gms.measurement.internal.zzfj r8 = r1.zzj
            com.google.android.gms.measurement.internal.zzed r8 = r8.zzy()
            java.lang.String r8 = r8.zzb(r2)
            java.lang.String r9 = "Logging event"
            r7.zza(r9, r8)
        L_0x0101:
            com.google.android.gms.measurement.internal.zzx r7 = r27.zzgy()
            r7.beginTransaction()
            r1.zzg(r3)     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = "_iap"
            java.lang.String r8 = r2.name     // Catch:{ all -> 0x08c8 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x08c8 }
            java.lang.String r8 = "ecommerce_purchase"
            if (r7 != 0) goto L_0x0125
            java.lang.String r7 = r2.name     // Catch:{ all -> 0x08c8 }
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x0120
            goto L_0x0125
        L_0x0120:
            r23 = r5
            r6 = 0
            goto L_0x02b8
        L_0x0125:
            com.google.android.gms.measurement.internal.zzah r7 = r2.zzfq     // Catch:{ all -> 0x08c8 }
            java.lang.String r9 = "currency"
            java.lang.String r7 = r7.getString(r9)     // Catch:{ all -> 0x08c8 }
            java.lang.String r9 = r2.name     // Catch:{ all -> 0x08c8 }
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x08c8 }
            java.lang.String r9 = "value"
            if (r8 == 0) goto L_0x018c
            com.google.android.gms.measurement.internal.zzah r8 = r2.zzfq     // Catch:{ all -> 0x08c8 }
            java.lang.Double r8 = r8.zzah(r9)     // Catch:{ all -> 0x08c8 }
            double r16 = r8.doubleValue()     // Catch:{ all -> 0x08c8 }
            r18 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r16 = r16 * r18
            r20 = 0
            int r8 = (r16 > r20 ? 1 : (r16 == r20 ? 0 : -1))
            if (r8 != 0) goto L_0x015e
            com.google.android.gms.measurement.internal.zzah r8 = r2.zzfq     // Catch:{ all -> 0x08c8 }
            java.lang.Long r8 = r8.getLong(r9)     // Catch:{ all -> 0x08c8 }
            long r8 = r8.longValue()     // Catch:{ all -> 0x08c8 }
            double r8 = (double) r8
            java.lang.Double.isNaN(r8)
            double r16 = r8 * r18
        L_0x015e:
            r8 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r18 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1))
            if (r18 > 0) goto L_0x016f
            r8 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r18 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1))
            if (r18 < 0) goto L_0x016f
            long r8 = java.lang.Math.round(r16)     // Catch:{ all -> 0x08c8 }
            goto L_0x0196
        L_0x016f:
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzab()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgn()     // Catch:{ all -> 0x08c8 }
            java.lang.String r8 = "Data lost. Currency value is too big. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzef.zzam(r15)     // Catch:{ all -> 0x08c8 }
            java.lang.Double r10 = java.lang.Double.valueOf(r16)     // Catch:{ all -> 0x08c8 }
            r7.zza(r8, r9, r10)     // Catch:{ all -> 0x08c8 }
            r23 = r5
            r6 = 0
            r11 = 0
            goto L_0x02a7
        L_0x018c:
            com.google.android.gms.measurement.internal.zzah r8 = r2.zzfq     // Catch:{ all -> 0x08c8 }
            java.lang.Long r8 = r8.getLong(r9)     // Catch:{ all -> 0x08c8 }
            long r8 = r8.longValue()     // Catch:{ all -> 0x08c8 }
        L_0x0196:
            boolean r10 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x08c8 }
            if (r10 != 0) goto L_0x02a3
            java.util.Locale r10 = java.util.Locale.US     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r7.toUpperCase(r10)     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = "[A-Z]{3}"
            boolean r10 = r7.matches(r10)     // Catch:{ all -> 0x08c8 }
            if (r10 == 0) goto L_0x02a3
            java.lang.String r10 = "_ltv_"
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x08c8 }
            int r16 = r7.length()     // Catch:{ all -> 0x08c8 }
            if (r16 == 0) goto L_0x01bb
            java.lang.String r7 = r10.concat(r7)     // Catch:{ all -> 0x08c8 }
            goto L_0x01c0
        L_0x01bb:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x08c8 }
            r7.<init>(r10)     // Catch:{ all -> 0x08c8 }
        L_0x01c0:
            r10 = r7
            com.google.android.gms.measurement.internal.zzx r7 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjp r7 = r7.zze(r15, r10)     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x0201
            java.lang.Object r11 = r7.value     // Catch:{ all -> 0x08c8 }
            boolean r11 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x08c8 }
            if (r11 != 0) goto L_0x01d2
            goto L_0x0201
        L_0x01d2:
            java.lang.Object r7 = r7.value     // Catch:{ all -> 0x08c8 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x08c8 }
            long r19 = r7.longValue()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjp r17 = new com.google.android.gms.measurement.internal.zzjp     // Catch:{ all -> 0x08c8 }
            java.lang.String r11 = r2.origin     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.common.util.Clock r7 = r7.zzx()     // Catch:{ all -> 0x08c8 }
            long r21 = r7.currentTimeMillis()     // Catch:{ all -> 0x08c8 }
            long r19 = r19 + r8
            java.lang.Long r19 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x08c8 }
            r7 = r17
            r8 = r15
            r9 = r11
            r11 = 2
            r23 = r5
            r5 = 1
            r6 = 0
            r11 = r21
            r13 = r19
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x08c8 }
            r5 = r17
            goto L_0x0268
        L_0x0201:
            r23 = r5
            r5 = 1
            r6 = 0
            com.google.android.gms.measurement.internal.zzx r7 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r11 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzs r11 = r11.zzad()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Integer> r12 = com.google.android.gms.measurement.internal.zzak.zzhj     // Catch:{ all -> 0x08c8 }
            int r11 = r11.zzb(r15, r12)     // Catch:{ all -> 0x08c8 }
            int r11 = r11 - r5
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x08c8 }
            r7.zzo()     // Catch:{ all -> 0x08c8 }
            r7.zzbi()     // Catch:{ all -> 0x08c8 }
            android.database.sqlite.SQLiteDatabase r12 = r7.getWritableDatabase()     // Catch:{ SQLiteException -> 0x023a }
            java.lang.String r13 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r5 = 3
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x023a }
            r5[r6] = r15     // Catch:{ SQLiteException -> 0x023a }
            r16 = 1
            r5[r16] = r15     // Catch:{ SQLiteException -> 0x023a }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ SQLiteException -> 0x023a }
            r16 = 2
            r5[r16] = r11     // Catch:{ SQLiteException -> 0x023a }
            r12.execSQL(r13, r5)     // Catch:{ SQLiteException -> 0x023a }
            goto L_0x024d
        L_0x023a:
            r0 = move-exception
            r5 = r0
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzab()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgk()     // Catch:{ all -> 0x08c8 }
            java.lang.String r11 = "Error pruning currencies. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzef.zzam(r15)     // Catch:{ all -> 0x08c8 }
            r7.zza(r11, r12, r5)     // Catch:{ all -> 0x08c8 }
        L_0x024d:
            com.google.android.gms.measurement.internal.zzjp r5 = new com.google.android.gms.measurement.internal.zzjp     // Catch:{ all -> 0x08c8 }
            java.lang.String r11 = r2.origin     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.common.util.Clock r7 = r7.zzx()     // Catch:{ all -> 0x08c8 }
            long r12 = r7.currentTimeMillis()     // Catch:{ all -> 0x08c8 }
            java.lang.Long r16 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x08c8 }
            r7 = r5
            r8 = r15
            r9 = r11
            r11 = r12
            r13 = r16
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x08c8 }
        L_0x0268:
            com.google.android.gms.measurement.internal.zzx r7 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            boolean r7 = r7.zza(r5)     // Catch:{ all -> 0x08c8 }
            if (r7 != 0) goto L_0x02a6
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzab()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgk()     // Catch:{ all -> 0x08c8 }
            java.lang.String r8 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzef.zzam(r15)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r10 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzed r10 = r10.zzy()     // Catch:{ all -> 0x08c8 }
            java.lang.String r11 = r5.name     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = r10.zzal(r11)     // Catch:{ all -> 0x08c8 }
            java.lang.Object r5 = r5.value     // Catch:{ all -> 0x08c8 }
            r7.zza(r8, r9, r10, r5)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjs r7 = r5.zzz()     // Catch:{ all -> 0x08c8 }
            r9 = 9
            r10 = 0
            r11 = 0
            r12 = 0
            r8 = r15
            r7.zza(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x08c8 }
            goto L_0x02a6
        L_0x02a3:
            r23 = r5
            r6 = 0
        L_0x02a6:
            r11 = 1
        L_0x02a7:
            if (r11 != 0) goto L_0x02b8
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()
            r2.endTransaction()
            return
        L_0x02b8:
            java.lang.String r5 = r2.name     // Catch:{ all -> 0x08c8 }
            boolean r5 = com.google.android.gms.measurement.internal.zzjs.zzbk(r5)     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r2.name     // Catch:{ all -> 0x08c8 }
            boolean r16 = r14.equals(r7)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r7 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            long r8 = r27.zzjk()     // Catch:{ all -> 0x08c8 }
            r11 = 1
            r13 = 0
            r17 = 0
            r10 = r15
            r12 = r5
            r14 = r16
            r18 = r15
            r15 = r17
            com.google.android.gms.measurement.internal.zzw r7 = r7.zza(r8, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x08c8 }
            long r8 = r7.zzeg     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Integer> r10 = com.google.android.gms.measurement.internal.zzak.zzgp     // Catch:{ all -> 0x08c8 }
            r14 = 0
            java.lang.Object r10 = r10.get(r14)     // Catch:{ all -> 0x08c8 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x08c8 }
            int r10 = r10.intValue()     // Catch:{ all -> 0x08c8 }
            long r10 = (long) r10     // Catch:{ all -> 0x08c8 }
            long r8 = r8 - r10
            r10 = 1000(0x3e8, double:4.94E-321)
            r12 = 1
            r14 = 0
            int r17 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r17 <= 0) goto L_0x0324
            long r8 = r8 % r10
            int r2 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x0315
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzab()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgk()     // Catch:{ all -> 0x08c8 }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzef.zzam(r18)     // Catch:{ all -> 0x08c8 }
            long r5 = r7.zzeg     // Catch:{ all -> 0x08c8 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x08c8 }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x08c8 }
        L_0x0315:
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()
            r2.endTransaction()
            return
        L_0x0324:
            if (r5 == 0) goto L_0x037c
            long r8 = r7.zzef     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Integer> r6 = com.google.android.gms.measurement.internal.zzak.zzgr     // Catch:{ all -> 0x08c8 }
            r12 = 0
            java.lang.Object r6 = r6.get(r12)     // Catch:{ all -> 0x08c8 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x08c8 }
            int r6 = r6.intValue()     // Catch:{ all -> 0x08c8 }
            long r12 = (long) r6     // Catch:{ all -> 0x08c8 }
            long r8 = r8 - r12
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 <= 0) goto L_0x037c
            long r8 = r8 % r10
            r3 = 1
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x035b
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzab()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch:{ all -> 0x08c8 }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzef.zzam(r18)     // Catch:{ all -> 0x08c8 }
            long r6 = r7.zzef     // Catch:{ all -> 0x08c8 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x08c8 }
            r3.zza(r4, r5, r6)     // Catch:{ all -> 0x08c8 }
        L_0x035b:
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjs r7 = r3.zzz()     // Catch:{ all -> 0x08c8 }
            r9 = 16
            java.lang.String r10 = "_ev"
            java.lang.String r11 = r2.name     // Catch:{ all -> 0x08c8 }
            r12 = 0
            r8 = r18
            r7.zza(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()
            r2.endTransaction()
            return
        L_0x037c:
            if (r16 == 0) goto L_0x03ce
            long r8 = r7.zzei     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzad()     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = r3.packageName     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Integer> r11 = com.google.android.gms.measurement.internal.zzak.zzgq     // Catch:{ all -> 0x08c8 }
            int r6 = r6.zzb(r10, r11)     // Catch:{ all -> 0x08c8 }
            r10 = 1000000(0xf4240, float:1.401298E-39)
            int r6 = java.lang.Math.min(r10, r6)     // Catch:{ all -> 0x08c8 }
            r12 = 0
            int r6 = java.lang.Math.max(r12, r6)     // Catch:{ all -> 0x08c8 }
            long r10 = (long) r6     // Catch:{ all -> 0x08c8 }
            long r8 = r8 - r10
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 <= 0) goto L_0x03cf
            r10 = 1
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 != 0) goto L_0x03bf
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzab()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgk()     // Catch:{ all -> 0x08c8 }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzef.zzam(r18)     // Catch:{ all -> 0x08c8 }
            long r5 = r7.zzei     // Catch:{ all -> 0x08c8 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x08c8 }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x08c8 }
        L_0x03bf:
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()
            r2.endTransaction()
            return
        L_0x03ce:
            r12 = 0
        L_0x03cf:
            com.google.android.gms.measurement.internal.zzah r6 = r2.zzfq     // Catch:{ all -> 0x08c8 }
            android.os.Bundle r6 = r6.zzcv()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjs r7 = r7.zzz()     // Catch:{ all -> 0x08c8 }
            java.lang.String r8 = "_o"
            java.lang.String r9 = r2.origin     // Catch:{ all -> 0x08c8 }
            r7.zza(r6, r8, r9)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjs r7 = r7.zzz()     // Catch:{ all -> 0x08c8 }
            r13 = r18
            boolean r7 = r7.zzbr(r13)     // Catch:{ all -> 0x08c8 }
            java.lang.String r11 = "_r"
            if (r7 == 0) goto L_0x0410
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjs r7 = r7.zzz()     // Catch:{ all -> 0x08c8 }
            java.lang.String r8 = "_dbg"
            r9 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x08c8 }
            r7.zza(r6, r8, r12)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjs r7 = r7.zzz()     // Catch:{ all -> 0x08c8 }
            java.lang.Long r8 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x08c8 }
            r7.zza(r6, r11, r8)     // Catch:{ all -> 0x08c8 }
        L_0x0410:
            java.lang.String r7 = r2.name     // Catch:{ all -> 0x08c8 }
            boolean r7 = r4.equals(r7)     // Catch:{ all -> 0x08c8 }
            java.lang.String r8 = "_sno"
            if (r7 == 0) goto L_0x0445
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzs r7 = r7.zzad()     // Catch:{ all -> 0x08c8 }
            java.lang.String r9 = r3.packageName     // Catch:{ all -> 0x08c8 }
            boolean r7 = r7.zzw(r9)     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x0445
            com.google.android.gms.measurement.internal.zzx r7 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            java.lang.String r9 = r3.packageName     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjp r7 = r7.zze(r9, r8)     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x0445
            java.lang.Object r9 = r7.value     // Catch:{ all -> 0x08c8 }
            boolean r9 = r9 instanceof java.lang.Long     // Catch:{ all -> 0x08c8 }
            if (r9 == 0) goto L_0x0445
            com.google.android.gms.measurement.internal.zzfj r9 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjs r9 = r9.zzz()     // Catch:{ all -> 0x08c8 }
            java.lang.Object r7 = r7.value     // Catch:{ all -> 0x08c8 }
            r9.zza(r6, r8, r7)     // Catch:{ all -> 0x08c8 }
        L_0x0445:
            java.lang.String r7 = r2.name     // Catch:{ all -> 0x08c8 }
            boolean r4 = r4.equals(r7)     // Catch:{ all -> 0x08c8 }
            if (r4 == 0) goto L_0x0475
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzs r4 = r4.zzad()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.packageName     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzak.zzif     // Catch:{ all -> 0x08c8 }
            boolean r4 = r4.zze(r7, r9)     // Catch:{ all -> 0x08c8 }
            if (r4 == 0) goto L_0x0475
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzs r4 = r4.zzad()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.packageName     // Catch:{ all -> 0x08c8 }
            boolean r4 = r4.zzw(r7)     // Catch:{ all -> 0x08c8 }
            if (r4 != 0) goto L_0x0475
            com.google.android.gms.measurement.internal.zzjn r4 = new com.google.android.gms.measurement.internal.zzjn     // Catch:{ all -> 0x08c8 }
            r12 = 0
            r4.<init>(r8, r14, r12)     // Catch:{ all -> 0x08c8 }
            r1.zzc(r4, r3)     // Catch:{ all -> 0x08c8 }
            goto L_0x0476
        L_0x0475:
            r12 = 0
        L_0x0476:
            com.google.android.gms.measurement.internal.zzx r4 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            long r7 = r4.zzac(r13)     // Catch:{ all -> 0x08c8 }
            int r4 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            if (r4 <= 0) goto L_0x0499
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgn()     // Catch:{ all -> 0x08c8 }
            java.lang.String r9 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzef.zzam(r13)     // Catch:{ all -> 0x08c8 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x08c8 }
            r4.zza(r9, r10, r7)     // Catch:{ all -> 0x08c8 }
        L_0x0499:
            com.google.android.gms.measurement.internal.zzaf r4 = new com.google.android.gms.measurement.internal.zzaf     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r8 = r1.zzj     // Catch:{ all -> 0x08c8 }
            java.lang.String r9 = r2.origin     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = r2.name     // Catch:{ all -> 0x08c8 }
            long r14 = r2.zzfu     // Catch:{ all -> 0x08c8 }
            r19 = 0
            r7 = r4
            r2 = r10
            r10 = r13
            r26 = r11
            r11 = r2
            r16 = r12
            r2 = r13
            r25 = 0
            r12 = r14
            r28 = r16
            r14 = r19
            r16 = r6
            r7.<init>(r8, r9, r10, r11, r12, r14, r16)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r6 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r4.name     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzae r6 = r6.zzc(r2, r7)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x052c
            com.google.android.gms.measurement.internal.zzx r6 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            long r6 = r6.zzag(r2)     // Catch:{ all -> 0x08c8 }
            r8 = 500(0x1f4, double:2.47E-321)
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 < 0) goto L_0x0512
            if (r5 == 0) goto L_0x0512
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzab()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch:{ all -> 0x08c8 }
            java.lang.String r5 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzef.zzam(r2)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzed r7 = r7.zzy()     // Catch:{ all -> 0x08c8 }
            java.lang.String r4 = r4.name     // Catch:{ all -> 0x08c8 }
            java.lang.String r4 = r7.zzaj(r4)     // Catch:{ all -> 0x08c8 }
            r7 = 500(0x1f4, float:7.0E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x08c8 }
            r3.zza(r5, r6, r4, r7)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjs r7 = r3.zzz()     // Catch:{ all -> 0x08c8 }
            r9 = 8
            r10 = 0
            r11 = 0
            r12 = 0
            r8 = r2
            r7.zza(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()
            r2.endTransaction()
            return
        L_0x0512:
            com.google.android.gms.measurement.internal.zzae r5 = new com.google.android.gms.measurement.internal.zzae     // Catch:{ all -> 0x08c8 }
            java.lang.String r9 = r4.name     // Catch:{ all -> 0x08c8 }
            r10 = 0
            r12 = 0
            long r14 = r4.timestamp     // Catch:{ all -> 0x08c8 }
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r7 = r5
            r8 = r2
            r7.<init>(r8, r9, r10, r12, r14, r16, r18, r19, r20, r21)     // Catch:{ all -> 0x08c8 }
            goto L_0x053a
        L_0x052c:
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj     // Catch:{ all -> 0x08c8 }
            long r7 = r6.zzfj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzaf r4 = r4.zza(r2, r7)     // Catch:{ all -> 0x08c8 }
            long r7 = r4.timestamp     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzae r5 = r6.zzw(r7)     // Catch:{ all -> 0x08c8 }
        L_0x053a:
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            r2.zza(r5)     // Catch:{ all -> 0x08c8 }
            r27.zzo()     // Catch:{ all -> 0x08c8 }
            r27.zzjj()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r29)     // Catch:{ all -> 0x08c8 }
            java.lang.String r2 = r4.zzce     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x08c8 }
            java.lang.String r2 = r4.zzce     // Catch:{ all -> 0x08c8 }
            java.lang.String r5 = r3.packageName     // Catch:{ all -> 0x08c8 }
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r2 = com.google.android.gms.internal.measurement.zzbs.zzg.zzpr()     // Catch:{ all -> 0x08c8 }
            r5 = 1
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r2 = r2.zzp(r5)     // Catch:{ all -> 0x08c8 }
            java.lang.String r6 = "android"
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r2 = r2.zzcc(r6)     // Catch:{ all -> 0x08c8 }
            java.lang.String r6 = r3.packageName     // Catch:{ all -> 0x08c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x0579
            java.lang.String r6 = r3.packageName     // Catch:{ all -> 0x08c8 }
            r2.zzch(r6)     // Catch:{ all -> 0x08c8 }
        L_0x0579:
            java.lang.String r6 = r3.zzco     // Catch:{ all -> 0x08c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x0586
            java.lang.String r6 = r3.zzco     // Catch:{ all -> 0x08c8 }
            r2.zzcg(r6)     // Catch:{ all -> 0x08c8 }
        L_0x0586:
            java.lang.String r6 = r3.zzcm     // Catch:{ all -> 0x08c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x0593
            java.lang.String r6 = r3.zzcm     // Catch:{ all -> 0x08c8 }
            r2.zzci(r6)     // Catch:{ all -> 0x08c8 }
        L_0x0593:
            long r6 = r3.zzcn     // Catch:{ all -> 0x08c8 }
            r8 = -2147483648(0xffffffff80000000, double:NaN)
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x05a2
            long r6 = r3.zzcn     // Catch:{ all -> 0x08c8 }
            int r7 = (int) r6     // Catch:{ all -> 0x08c8 }
            r2.zzv(r7)     // Catch:{ all -> 0x08c8 }
        L_0x05a2:
            long r6 = r3.zzr     // Catch:{ all -> 0x08c8 }
            r2.zzas(r6)     // Catch:{ all -> 0x08c8 }
            java.lang.String r6 = r3.zzcg     // Catch:{ all -> 0x08c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x05b4
            java.lang.String r6 = r3.zzcg     // Catch:{ all -> 0x08c8 }
            r2.zzcm(r6)     // Catch:{ all -> 0x08c8 }
        L_0x05b4:
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzad()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzak.zzit     // Catch:{ all -> 0x08c8 }
            boolean r6 = r6.zza(r7)     // Catch:{ all -> 0x08c8 }
            if (r6 == 0) goto L_0x05da
            java.lang.String r6 = r2.getGmpAppId()     // Catch:{ all -> 0x08c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c8 }
            if (r6 == 0) goto L_0x05e7
            java.lang.String r6 = r3.zzcu     // Catch:{ all -> 0x08c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x05e7
            java.lang.String r6 = r3.zzcu     // Catch:{ all -> 0x08c8 }
            r2.zzcq(r6)     // Catch:{ all -> 0x08c8 }
            goto L_0x05e7
        L_0x05da:
            java.lang.String r6 = r3.zzcu     // Catch:{ all -> 0x08c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x05e7
            java.lang.String r6 = r3.zzcu     // Catch:{ all -> 0x08c8 }
            r2.zzcq(r6)     // Catch:{ all -> 0x08c8 }
        L_0x05e7:
            long r6 = r3.zzcp     // Catch:{ all -> 0x08c8 }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x05f4
            long r6 = r3.zzcp     // Catch:{ all -> 0x08c8 }
            r2.zzau(r6)     // Catch:{ all -> 0x08c8 }
        L_0x05f4:
            long r6 = r3.zzs     // Catch:{ all -> 0x08c8 }
            r2.zzax(r6)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzad()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.packageName     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzak.zzin     // Catch:{ all -> 0x08c8 }
            boolean r6 = r6.zze(r7, r10)     // Catch:{ all -> 0x08c8 }
            if (r6 == 0) goto L_0x0616
            com.google.android.gms.measurement.internal.zzjo r6 = r27.zzgw()     // Catch:{ all -> 0x08c8 }
            java.util.List r6 = r6.zzju()     // Catch:{ all -> 0x08c8 }
            if (r6 == 0) goto L_0x0616
            r2.zzd(r6)     // Catch:{ all -> 0x08c8 }
        L_0x0616:
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeo r6 = r6.zzac()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.packageName     // Catch:{ all -> 0x08c8 }
            android.util.Pair r6 = r6.zzap(r7)     // Catch:{ all -> 0x08c8 }
            if (r6 == 0) goto L_0x0649
            java.lang.Object r7 = r6.first     // Catch:{ all -> 0x08c8 }
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x08c8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x08c8 }
            if (r7 != 0) goto L_0x0649
            boolean r7 = r3.zzcs     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x06ab
            java.lang.Object r7 = r6.first     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x08c8 }
            r2.zzcj(r7)     // Catch:{ all -> 0x08c8 }
            java.lang.Object r7 = r6.second     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x06ab
            java.lang.Object r6 = r6.second     // Catch:{ all -> 0x08c8 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x08c8 }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x08c8 }
            r2.zzm(r6)     // Catch:{ all -> 0x08c8 }
            goto L_0x06ab
        L_0x0649:
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzac r6 = r6.zzw()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            android.content.Context r7 = r7.getContext()     // Catch:{ all -> 0x08c8 }
            boolean r6 = r6.zzj(r7)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x06ab
            boolean r6 = r3.zzct     // Catch:{ all -> 0x08c8 }
            if (r6 == 0) goto L_0x06ab
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            android.content.Context r6 = r6.getContext()     // Catch:{ all -> 0x08c8 }
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = "android_id"
            java.lang.String r6 = android.provider.Settings.Secure.getString(r6, r7)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x068b
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzab()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzgn()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = "null secure ID. appId"
            java.lang.String r10 = r2.zzag()     // Catch:{ all -> 0x08c8 }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzef.zzam(r10)     // Catch:{ all -> 0x08c8 }
            r6.zza(r7, r10)     // Catch:{ all -> 0x08c8 }
            java.lang.String r6 = "null"
            goto L_0x06a8
        L_0x068b:
            boolean r7 = r6.isEmpty()     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x06a8
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzab()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgn()     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = "empty secure ID. appId"
            java.lang.String r11 = r2.zzag()     // Catch:{ all -> 0x08c8 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzef.zzam(r11)     // Catch:{ all -> 0x08c8 }
            r7.zza(r10, r11)     // Catch:{ all -> 0x08c8 }
        L_0x06a8:
            r2.zzco(r6)     // Catch:{ all -> 0x08c8 }
        L_0x06ab:
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzac r6 = r6.zzw()     // Catch:{ all -> 0x08c8 }
            r6.zzbi()     // Catch:{ all -> 0x08c8 }
            java.lang.String r6 = android.os.Build.MODEL     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r6 = r2.zzce(r6)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzac r7 = r7.zzw()     // Catch:{ all -> 0x08c8 }
            r7.zzbi()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r6 = r6.zzcd(r7)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzac r7 = r7.zzw()     // Catch:{ all -> 0x08c8 }
            long r10 = r7.zzcq()     // Catch:{ all -> 0x08c8 }
            int r7 = (int) r10     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r6 = r6.zzt(r7)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzac r7 = r7.zzw()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r7.zzcr()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r6 = r6.zzcf(r7)     // Catch:{ all -> 0x08c8 }
            long r10 = r3.zzcr     // Catch:{ all -> 0x08c8 }
            r6.zzaw(r10)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            boolean r6 = r6.isEnabled()     // Catch:{ all -> 0x08c8 }
            if (r6 == 0) goto L_0x0707
            boolean r6 = com.google.android.gms.measurement.internal.zzs.zzbv()     // Catch:{ all -> 0x08c8 }
            if (r6 == 0) goto L_0x0707
            r2.zzag()     // Catch:{ all -> 0x08c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r28)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x0707
            r6 = r28
            r2.zzcp(r6)     // Catch:{ all -> 0x08c8 }
        L_0x0707:
            com.google.android.gms.measurement.internal.zzx r6 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.packageName     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzf r6 = r6.zzab(r7)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x077a
            com.google.android.gms.measurement.internal.zzf r6 = new com.google.android.gms.measurement.internal.zzf     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = r3.packageName     // Catch:{ all -> 0x08c8 }
            r6.<init>(r7, r10)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjs r7 = r7.zzz()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r7.zzjy()     // Catch:{ all -> 0x08c8 }
            r6.zza(r7)     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.zzci     // Catch:{ all -> 0x08c8 }
            r6.zze(r7)     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.zzcg     // Catch:{ all -> 0x08c8 }
            r6.zzb(r7)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzac()     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = r3.packageName     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r7.zzaq(r10)     // Catch:{ all -> 0x08c8 }
            r6.zzd(r7)     // Catch:{ all -> 0x08c8 }
            r6.zzk(r8)     // Catch:{ all -> 0x08c8 }
            r6.zze(r8)     // Catch:{ all -> 0x08c8 }
            r6.zzf(r8)     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.zzcm     // Catch:{ all -> 0x08c8 }
            r6.zzf(r7)     // Catch:{ all -> 0x08c8 }
            long r10 = r3.zzcn     // Catch:{ all -> 0x08c8 }
            r6.zzg(r10)     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.zzco     // Catch:{ all -> 0x08c8 }
            r6.zzg(r7)     // Catch:{ all -> 0x08c8 }
            long r10 = r3.zzr     // Catch:{ all -> 0x08c8 }
            r6.zzh(r10)     // Catch:{ all -> 0x08c8 }
            long r10 = r3.zzcp     // Catch:{ all -> 0x08c8 }
            r6.zzi(r10)     // Catch:{ all -> 0x08c8 }
            boolean r7 = r3.zzcq     // Catch:{ all -> 0x08c8 }
            r6.setMeasurementEnabled(r7)     // Catch:{ all -> 0x08c8 }
            long r10 = r3.zzcr     // Catch:{ all -> 0x08c8 }
            r6.zzt(r10)     // Catch:{ all -> 0x08c8 }
            long r10 = r3.zzs     // Catch:{ all -> 0x08c8 }
            r6.zzj(r10)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r7 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            r7.zza(r6)     // Catch:{ all -> 0x08c8 }
        L_0x077a:
            java.lang.String r7 = r6.getAppInstanceId()     // Catch:{ all -> 0x08c8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x08c8 }
            if (r7 != 0) goto L_0x078b
            java.lang.String r7 = r6.getAppInstanceId()     // Catch:{ all -> 0x08c8 }
            r2.zzck(r7)     // Catch:{ all -> 0x08c8 }
        L_0x078b:
            java.lang.String r7 = r6.getFirebaseInstanceId()     // Catch:{ all -> 0x08c8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x08c8 }
            if (r7 != 0) goto L_0x079c
            java.lang.String r6 = r6.getFirebaseInstanceId()     // Catch:{ all -> 0x08c8 }
            r2.zzcn(r6)     // Catch:{ all -> 0x08c8 }
        L_0x079c:
            com.google.android.gms.measurement.internal.zzx r6 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            java.lang.String r3 = r3.packageName     // Catch:{ all -> 0x08c8 }
            java.util.List r3 = r6.zzaa(r3)     // Catch:{ all -> 0x08c8 }
            r6 = 0
        L_0x07a7:
            int r7 = r3.size()     // Catch:{ all -> 0x08c8 }
            if (r6 >= r7) goto L_0x07de
            com.google.android.gms.internal.measurement.zzbs$zzk$zza r7 = com.google.android.gms.internal.measurement.zzbs.zzk.zzqu()     // Catch:{ all -> 0x08c8 }
            java.lang.Object r10 = r3.get(r6)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjp r10 = (com.google.android.gms.measurement.internal.zzjp) r10     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = r10.name     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.internal.measurement.zzbs$zzk$zza r7 = r7.zzdb(r10)     // Catch:{ all -> 0x08c8 }
            java.lang.Object r10 = r3.get(r6)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjp r10 = (com.google.android.gms.measurement.internal.zzjp) r10     // Catch:{ all -> 0x08c8 }
            long r10 = r10.zztr     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.internal.measurement.zzbs$zzk$zza r7 = r7.zzbk(r10)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjo r10 = r27.zzgw()     // Catch:{ all -> 0x08c8 }
            java.lang.Object r11 = r3.get(r6)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjp r11 = (com.google.android.gms.measurement.internal.zzjp) r11     // Catch:{ all -> 0x08c8 }
            java.lang.Object r11 = r11.value     // Catch:{ all -> 0x08c8 }
            r10.zza(r7, r11)     // Catch:{ all -> 0x08c8 }
            r2.zza(r7)     // Catch:{ all -> 0x08c8 }
            int r6 = r6 + 1
            goto L_0x07a7
        L_0x07de:
            com.google.android.gms.measurement.internal.zzx r3 = r27.zzgy()     // Catch:{ IOException -> 0x0856 }
            com.google.android.gms.internal.measurement.zzgi r6 = r2.zzug()     // Catch:{ IOException -> 0x0856 }
            com.google.android.gms.internal.measurement.zzey r6 = (com.google.android.gms.internal.measurement.zzey) r6     // Catch:{ IOException -> 0x0856 }
            com.google.android.gms.internal.measurement.zzbs$zzg r6 = (com.google.android.gms.internal.measurement.zzbs.zzg) r6     // Catch:{ IOException -> 0x0856 }
            long r2 = r3.zza(r6)     // Catch:{ IOException -> 0x0856 }
            com.google.android.gms.measurement.internal.zzx r6 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzah r7 = r4.zzfq     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x084c
            com.google.android.gms.measurement.internal.zzah r7 = r4.zzfq     // Catch:{ all -> 0x08c8 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x08c8 }
        L_0x07fc:
            boolean r10 = r7.hasNext()     // Catch:{ all -> 0x08c8 }
            if (r10 == 0) goto L_0x0814
            java.lang.Object r10 = r7.next()     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x08c8 }
            r11 = r26
            boolean r10 = r11.equals(r10)     // Catch:{ all -> 0x08c8 }
            if (r10 == 0) goto L_0x0811
            goto L_0x084d
        L_0x0811:
            r26 = r11
            goto L_0x07fc
        L_0x0814:
            com.google.android.gms.measurement.internal.zzfd r7 = r27.zzgz()     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = r4.zzce     // Catch:{ all -> 0x08c8 }
            java.lang.String r11 = r4.name     // Catch:{ all -> 0x08c8 }
            boolean r7 = r7.zzl(r10, r11)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r10 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            long r11 = r27.zzjk()     // Catch:{ all -> 0x08c8 }
            java.lang.String r13 = r4.zzce     // Catch:{ all -> 0x08c8 }
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            com.google.android.gms.measurement.internal.zzw r10 = r10.zza(r11, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x084c
            long r10 = r10.zzej     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzs r7 = r7.zzad()     // Catch:{ all -> 0x08c8 }
            java.lang.String r12 = r4.zzce     // Catch:{ all -> 0x08c8 }
            int r7 = r7.zzi(r12)     // Catch:{ all -> 0x08c8 }
            long r12 = (long) r7     // Catch:{ all -> 0x08c8 }
            int r7 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r7 >= 0) goto L_0x084c
            goto L_0x084d
        L_0x084c:
            r5 = 0
        L_0x084d:
            boolean r2 = r6.zza(r4, r2, r5)     // Catch:{ all -> 0x08c8 }
            if (r2 == 0) goto L_0x086f
            r1.zzsy = r8     // Catch:{ all -> 0x08c8 }
            goto L_0x086f
        L_0x0856:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzab()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzgk()     // Catch:{ all -> 0x08c8 }
            java.lang.String r6 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r2 = r2.zzag()     // Catch:{ all -> 0x08c8 }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzef.zzam(r2)     // Catch:{ all -> 0x08c8 }
            r5.zza(r6, r2, r3)     // Catch:{ all -> 0x08c8 }
        L_0x086f:
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzab()     // Catch:{ all -> 0x08c8 }
            r3 = 2
            boolean r2 = r2.isLoggable(r3)     // Catch:{ all -> 0x08c8 }
            if (r2 == 0) goto L_0x089c
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzab()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgs()     // Catch:{ all -> 0x08c8 }
            java.lang.String r3 = "Event recorded"
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzed r5 = r5.zzy()     // Catch:{ all -> 0x08c8 }
            java.lang.String r4 = r5.zza(r4)     // Catch:{ all -> 0x08c8 }
            r2.zza(r3, r4)     // Catch:{ all -> 0x08c8 }
        L_0x089c:
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()
            r2.endTransaction()
            r27.zzjn()
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgs()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r23
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.zza(r4, r3)
            return
        L_0x08c8:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzx r3 = r27.zzgy()
            r3.endTransaction()
            throw r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjg.zzd(com.google.android.gms.measurement.internal.zzai, com.google.android.gms.measurement.internal.zzn):void");
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:95|96) */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        r1.zzj.zzab().zzgk().zza("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.zzef.zzam(r5), r9);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x02c6 */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzjl() {
        /*
            r17 = this;
            r1 = r17
            r17.zzo()
            r17.zzjj()
            r0 = 1
            r1.zzte = r0
            r2 = 0
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x0302 }
            r3.zzae()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzhv r3 = r3.zzs()     // Catch:{ all -> 0x0302 }
            java.lang.Boolean r3 = r3.zzit()     // Catch:{ all -> 0x0302 }
            if (r3 != 0) goto L_0x0032
            com.google.android.gms.measurement.internal.zzfj r0 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzab()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgn()     // Catch:{ all -> 0x0302 }
            java.lang.String r3 = "Upload data called on the client side before use of service was decided"
            r0.zzao(r3)     // Catch:{ all -> 0x0302 }
            r1.zzte = r2
            r17.zzjo()
            return
        L_0x0032:
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0302 }
            if (r3 == 0) goto L_0x004d
            com.google.android.gms.measurement.internal.zzfj r0 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzab()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgk()     // Catch:{ all -> 0x0302 }
            java.lang.String r3 = "Upload called in the client side when service should be used"
            r0.zzao(r3)     // Catch:{ all -> 0x0302 }
            r1.zzte = r2
            r17.zzjo()
            return
        L_0x004d:
            long r3 = r1.zzsy     // Catch:{ all -> 0x0302 }
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x005e
            r17.zzjn()     // Catch:{ all -> 0x0302 }
            r1.zzte = r2
            r17.zzjo()
            return
        L_0x005e:
            r17.zzo()     // Catch:{ all -> 0x0302 }
            java.util.List<java.lang.Long> r3 = r1.zzth     // Catch:{ all -> 0x0302 }
            if (r3 == 0) goto L_0x0067
            r3 = 1
            goto L_0x0068
        L_0x0067:
            r3 = 0
        L_0x0068:
            if (r3 == 0) goto L_0x007f
            com.google.android.gms.measurement.internal.zzfj r0 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzab()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgs()     // Catch:{ all -> 0x0302 }
            java.lang.String r3 = "Uploading requested multiple times"
            r0.zzao(r3)     // Catch:{ all -> 0x0302 }
            r1.zzte = r2
            r17.zzjo()
            return
        L_0x007f:
            com.google.android.gms.measurement.internal.zzej r3 = r17.zzjf()     // Catch:{ all -> 0x0302 }
            boolean r3 = r3.zzgv()     // Catch:{ all -> 0x0302 }
            if (r3 != 0) goto L_0x00a1
            com.google.android.gms.measurement.internal.zzfj r0 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzab()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgs()     // Catch:{ all -> 0x0302 }
            java.lang.String r3 = "Network not connected, ignoring upload request"
            r0.zzao(r3)     // Catch:{ all -> 0x0302 }
            r17.zzjn()     // Catch:{ all -> 0x0302 }
            r1.zzte = r2
            r17.zzjo()
            return
        L_0x00a1:
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.common.util.Clock r3 = r3.zzx()     // Catch:{ all -> 0x0302 }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x0302 }
            long r7 = com.google.android.gms.measurement.internal.zzs.zzbt()     // Catch:{ all -> 0x0302 }
            long r7 = r3 - r7
            r9 = 0
            r1.zzd(r9, r7)     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzac()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzlj     // Catch:{ all -> 0x0302 }
            long r7 = r7.get()     // Catch:{ all -> 0x0302 }
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 == 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzab()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzgr()     // Catch:{ all -> 0x0302 }
            java.lang.String r6 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r7 = r3 - r7
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x0302 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0302 }
            r5.zza(r6, r7)     // Catch:{ all -> 0x0302 }
        L_0x00de:
            com.google.android.gms.measurement.internal.zzx r5 = r17.zzgy()     // Catch:{ all -> 0x0302 }
            java.lang.String r5 = r5.zzby()     // Catch:{ all -> 0x0302 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0302 }
            r7 = -1
            if (r6 != 0) goto L_0x02da
            long r10 = r1.zztj     // Catch:{ all -> 0x0302 }
            int r6 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x00fe
            com.google.android.gms.measurement.internal.zzx r6 = r17.zzgy()     // Catch:{ all -> 0x0302 }
            long r6 = r6.zzcf()     // Catch:{ all -> 0x0302 }
            r1.zztj = r6     // Catch:{ all -> 0x0302 }
        L_0x00fe:
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzad()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzak.zzgl     // Catch:{ all -> 0x0302 }
            int r6 = r6.zzb(r5, r7)     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzs r7 = r7.zzad()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzak.zzgm     // Catch:{ all -> 0x0302 }
            int r7 = r7.zzb(r5, r8)     // Catch:{ all -> 0x0302 }
            int r7 = java.lang.Math.max(r2, r7)     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzx r8 = r17.zzgy()     // Catch:{ all -> 0x0302 }
            java.util.List r6 = r8.zza(r5, r6, r7)     // Catch:{ all -> 0x0302 }
            boolean r7 = r6.isEmpty()     // Catch:{ all -> 0x0302 }
            if (r7 != 0) goto L_0x02fc
            java.util.Iterator r7 = r6.iterator()     // Catch:{ all -> 0x0302 }
        L_0x012c:
            boolean r8 = r7.hasNext()     // Catch:{ all -> 0x0302 }
            if (r8 == 0) goto L_0x014b
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x0302 }
            android.util.Pair r8 = (android.util.Pair) r8     // Catch:{ all -> 0x0302 }
            java.lang.Object r8 = r8.first     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbs$zzg r8 = (com.google.android.gms.internal.measurement.zzbs.zzg) r8     // Catch:{ all -> 0x0302 }
            java.lang.String r10 = r8.zzot()     // Catch:{ all -> 0x0302 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0302 }
            if (r10 != 0) goto L_0x012c
            java.lang.String r7 = r8.zzot()     // Catch:{ all -> 0x0302 }
            goto L_0x014c
        L_0x014b:
            r7 = r9
        L_0x014c:
            if (r7 == 0) goto L_0x017b
            r8 = 0
        L_0x014f:
            int r10 = r6.size()     // Catch:{ all -> 0x0302 }
            if (r8 >= r10) goto L_0x017b
            java.lang.Object r10 = r6.get(r8)     // Catch:{ all -> 0x0302 }
            android.util.Pair r10 = (android.util.Pair) r10     // Catch:{ all -> 0x0302 }
            java.lang.Object r10 = r10.first     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbs$zzg r10 = (com.google.android.gms.internal.measurement.zzbs.zzg) r10     // Catch:{ all -> 0x0302 }
            java.lang.String r11 = r10.zzot()     // Catch:{ all -> 0x0302 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0302 }
            if (r11 != 0) goto L_0x0178
            java.lang.String r10 = r10.zzot()     // Catch:{ all -> 0x0302 }
            boolean r10 = r10.equals(r7)     // Catch:{ all -> 0x0302 }
            if (r10 != 0) goto L_0x0178
            java.util.List r6 = r6.subList(r2, r8)     // Catch:{ all -> 0x0302 }
            goto L_0x017b
        L_0x0178:
            int r8 = r8 + 1
            goto L_0x014f
        L_0x017b:
            com.google.android.gms.internal.measurement.zzbs$zzf$zza r7 = com.google.android.gms.internal.measurement.zzbs.zzf.zznj()     // Catch:{ all -> 0x0302 }
            int r8 = r6.size()     // Catch:{ all -> 0x0302 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x0302 }
            int r11 = r6.size()     // Catch:{ all -> 0x0302 }
            r10.<init>(r11)     // Catch:{ all -> 0x0302 }
            boolean r11 = com.google.android.gms.measurement.internal.zzs.zzbv()     // Catch:{ all -> 0x0302 }
            if (r11 == 0) goto L_0x01a0
            com.google.android.gms.measurement.internal.zzfj r11 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzs r11 = r11.zzad()     // Catch:{ all -> 0x0302 }
            boolean r11 = r11.zzl(r5)     // Catch:{ all -> 0x0302 }
            if (r11 == 0) goto L_0x01a0
            r11 = 1
            goto L_0x01a1
        L_0x01a0:
            r11 = 0
        L_0x01a1:
            r12 = 0
        L_0x01a2:
            if (r12 >= r8) goto L_0x020d
            java.lang.Object r13 = r6.get(r12)     // Catch:{ all -> 0x0302 }
            android.util.Pair r13 = (android.util.Pair) r13     // Catch:{ all -> 0x0302 }
            java.lang.Object r13 = r13.first     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbs$zzg r13 = (com.google.android.gms.internal.measurement.zzbs.zzg) r13     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzey$zza r13 = r13.zzuj()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzey$zza r13 = (com.google.android.gms.internal.measurement.zzey.zza) r13     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r13 = (com.google.android.gms.internal.measurement.zzbs.zzg.zza) r13     // Catch:{ all -> 0x0302 }
            java.lang.Object r14 = r6.get(r12)     // Catch:{ all -> 0x0302 }
            android.util.Pair r14 = (android.util.Pair) r14     // Catch:{ all -> 0x0302 }
            java.lang.Object r14 = r14.second     // Catch:{ all -> 0x0302 }
            java.lang.Long r14 = (java.lang.Long) r14     // Catch:{ all -> 0x0302 }
            r10.add(r14)     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzfj r14 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzs r14 = r14.zzad()     // Catch:{ all -> 0x0302 }
            long r14 = r14.zzao()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r14 = r13.zzat(r14)     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r14 = r14.zzan(r3)     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzfj r15 = r1.zzj     // Catch:{ all -> 0x0302 }
            r15.zzae()     // Catch:{ all -> 0x0302 }
            r14.zzn(r2)     // Catch:{ all -> 0x0302 }
            if (r11 != 0) goto L_0x01e2
            r13.zznw()     // Catch:{ all -> 0x0302 }
        L_0x01e2:
            com.google.android.gms.measurement.internal.zzfj r14 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzs r14 = r14.zzad()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzak.zzis     // Catch:{ all -> 0x0302 }
            boolean r14 = r14.zze(r5, r15)     // Catch:{ all -> 0x0302 }
            if (r14 == 0) goto L_0x0207
            com.google.android.gms.internal.measurement.zzgi r14 = r13.zzug()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzey r14 = (com.google.android.gms.internal.measurement.zzey) r14     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbs$zzg r14 = (com.google.android.gms.internal.measurement.zzbs.zzg) r14     // Catch:{ all -> 0x0302 }
            byte[] r14 = r14.toByteArray()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzjo r15 = r17.zzgw()     // Catch:{ all -> 0x0302 }
            long r14 = r15.zza(r14)     // Catch:{ all -> 0x0302 }
            r13.zzay(r14)     // Catch:{ all -> 0x0302 }
        L_0x0207:
            r7.zza(r13)     // Catch:{ all -> 0x0302 }
            int r12 = r12 + 1
            goto L_0x01a2
        L_0x020d:
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzab()     // Catch:{ all -> 0x0302 }
            r11 = 2
            boolean r6 = r6.isLoggable(r11)     // Catch:{ all -> 0x0302 }
            if (r6 == 0) goto L_0x022b
            com.google.android.gms.measurement.internal.zzjo r6 = r17.zzgw()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzgi r11 = r7.zzug()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzey r11 = (com.google.android.gms.internal.measurement.zzey) r11     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbs$zzf r11 = (com.google.android.gms.internal.measurement.zzbs.zzf) r11     // Catch:{ all -> 0x0302 }
            java.lang.String r6 = r6.zza(r11)     // Catch:{ all -> 0x0302 }
            goto L_0x022c
        L_0x022b:
            r6 = r9
        L_0x022c:
            r17.zzgw()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzgi r11 = r7.zzug()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzey r11 = (com.google.android.gms.internal.measurement.zzey) r11     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbs$zzf r11 = (com.google.android.gms.internal.measurement.zzbs.zzf) r11     // Catch:{ all -> 0x0302 }
            byte[] r14 = r11.toByteArray()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.String> r11 = com.google.android.gms.measurement.internal.zzak.zzgv     // Catch:{ all -> 0x0302 }
            java.lang.Object r9 = r11.get(r9)     // Catch:{ all -> 0x0302 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0302 }
            java.net.URL r13 = new java.net.URL     // Catch:{ MalformedURLException -> 0x02c6 }
            r13.<init>(r9)     // Catch:{ MalformedURLException -> 0x02c6 }
            boolean r11 = r10.isEmpty()     // Catch:{ MalformedURLException -> 0x02c6 }
            if (r11 != 0) goto L_0x0250
            r11 = 1
            goto L_0x0251
        L_0x0250:
            r11 = 0
        L_0x0251:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r11)     // Catch:{ MalformedURLException -> 0x02c6 }
            java.util.List<java.lang.Long> r11 = r1.zzth     // Catch:{ MalformedURLException -> 0x02c6 }
            if (r11 == 0) goto L_0x0268
            com.google.android.gms.measurement.internal.zzfj r10 = r1.zzj     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzab()     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzgk()     // Catch:{ MalformedURLException -> 0x02c6 }
            java.lang.String r11 = "Set uploading progress before finishing the previous upload"
            r10.zzao(r11)     // Catch:{ MalformedURLException -> 0x02c6 }
            goto L_0x026f
        L_0x0268:
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x02c6 }
            r11.<init>(r10)     // Catch:{ MalformedURLException -> 0x02c6 }
            r1.zzth = r11     // Catch:{ MalformedURLException -> 0x02c6 }
        L_0x026f:
            com.google.android.gms.measurement.internal.zzfj r10 = r1.zzj     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzeo r10 = r10.zzac()     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzet r10 = r10.zzlk     // Catch:{ MalformedURLException -> 0x02c6 }
            r10.set(r3)     // Catch:{ MalformedURLException -> 0x02c6 }
            java.lang.String r3 = "?"
            if (r8 <= 0) goto L_0x0286
            com.google.android.gms.internal.measurement.zzbs$zzg r3 = r7.zzo(r2)     // Catch:{ MalformedURLException -> 0x02c6 }
            java.lang.String r3 = r3.zzag()     // Catch:{ MalformedURLException -> 0x02c6 }
        L_0x0286:
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgs()     // Catch:{ MalformedURLException -> 0x02c6 }
            java.lang.String r7 = "Uploading data. app, uncompressed size, data"
            int r8 = r14.length     // Catch:{ MalformedURLException -> 0x02c6 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ MalformedURLException -> 0x02c6 }
            r4.zza(r7, r3, r8, r6)     // Catch:{ MalformedURLException -> 0x02c6 }
            r1.zztd = r0     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzej r11 = r17.zzjf()     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzji r0 = new com.google.android.gms.measurement.internal.zzji     // Catch:{ MalformedURLException -> 0x02c6 }
            r0.<init>(r1, r5)     // Catch:{ MalformedURLException -> 0x02c6 }
            r11.zzo()     // Catch:{ MalformedURLException -> 0x02c6 }
            r11.zzbi()     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzfc r3 = r11.zzaa()     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzen r4 = new com.google.android.gms.measurement.internal.zzen     // Catch:{ MalformedURLException -> 0x02c6 }
            r15 = 0
            r10 = r4
            r12 = r5
            r16 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ MalformedURLException -> 0x02c6 }
            r3.zzb(r4)     // Catch:{ MalformedURLException -> 0x02c6 }
            goto L_0x02fc
        L_0x02c6:
            com.google.android.gms.measurement.internal.zzfj r0 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzab()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgk()     // Catch:{ all -> 0x0302 }
            java.lang.String r3 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzef.zzam(r5)     // Catch:{ all -> 0x0302 }
            r0.zza(r3, r4, r9)     // Catch:{ all -> 0x0302 }
            goto L_0x02fc
        L_0x02da:
            r1.zztj = r7     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzx r0 = r17.zzgy()     // Catch:{ all -> 0x0302 }
            long r5 = com.google.android.gms.measurement.internal.zzs.zzbt()     // Catch:{ all -> 0x0302 }
            long r3 = r3 - r5
            java.lang.String r0 = r0.zzu(r3)     // Catch:{ all -> 0x0302 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0302 }
            if (r3 != 0) goto L_0x02fc
            com.google.android.gms.measurement.internal.zzx r3 = r17.zzgy()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzf r0 = r3.zzab(r0)     // Catch:{ all -> 0x0302 }
            if (r0 == 0) goto L_0x02fc
            r1.zzb(r0)     // Catch:{ all -> 0x0302 }
        L_0x02fc:
            r1.zzte = r2
            r17.zzjo()
            return
        L_0x0302:
            r0 = move-exception
            r1.zzte = r2
            r17.zzjo()
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjg.zzjl():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0250, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0251, code lost:
        r8 = r3;
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0041, code lost:
        r4 = r1;
        r8 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        r7 = null;
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:481:0x0c5d, code lost:
        if (r5 != r14) goto L_0x0c5f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:584:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0040 A[ExcHandler: all (th java.lang.Throwable), PHI: r3 
      PHI: (r3v169 android.database.Cursor) = (r3v164 android.database.Cursor), (r3v164 android.database.Cursor), (r3v164 android.database.Cursor), (r3v172 android.database.Cursor), (r3v172 android.database.Cursor), (r3v172 android.database.Cursor), (r3v172 android.database.Cursor), (r3v0 android.database.Cursor), (r3v0 android.database.Cursor) binds: [B:47:0x00da, B:53:0x00e7, B:54:?, B:24:0x007c, B:30:0x0089, B:32:0x008d, B:33:?, B:9:0x0031, B:10:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:9:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0272 A[SYNTHETIC, Splitter:B:132:0x0272] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0279 A[Catch:{ IOException -> 0x0228, all -> 0x0f12 }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0287 A[Catch:{ IOException -> 0x0228, all -> 0x0f12 }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x03c6 A[Catch:{ IOException -> 0x0228, all -> 0x0f12 }] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x03d1 A[Catch:{ IOException -> 0x0228, all -> 0x0f12 }] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x03d2 A[Catch:{ IOException -> 0x0228, all -> 0x0f12 }] */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x03ef A[SYNTHETIC, Splitter:B:200:0x03ef] */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x0489 A[Catch:{ IOException -> 0x0228, all -> 0x0f12 }] */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x04eb A[Catch:{ IOException -> 0x0228, all -> 0x0f12 }] */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x04ef A[Catch:{ IOException -> 0x0228, all -> 0x0f12 }] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0555 A[Catch:{ IOException -> 0x0228, all -> 0x0f12 }] */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0586 A[Catch:{ IOException -> 0x0228, all -> 0x0f12 }] */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x05a5 A[Catch:{ IOException -> 0x0228, all -> 0x0f12 }] */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x05e5 A[Catch:{ IOException -> 0x0228, all -> 0x0f12 }] */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0612 A[Catch:{ IOException -> 0x0228, all -> 0x0f12 }] */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x06ae A[Catch:{ IOException -> 0x0228, all -> 0x0f12 }] */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x076a A[Catch:{ IOException -> 0x0228, all -> 0x0f12 }] */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x0784 A[Catch:{ IOException -> 0x0228, all -> 0x0f12 }] */
    /* JADX WARNING: Removed duplicated region for block: B:426:0x0abb A[Catch:{ IOException -> 0x0228, all -> 0x0f12 }] */
    /* JADX WARNING: Removed duplicated region for block: B:427:0x0ace A[Catch:{ IOException -> 0x0228, all -> 0x0f12 }] */
    /* JADX WARNING: Removed duplicated region for block: B:429:0x0ad1 A[Catch:{ IOException -> 0x0228, all -> 0x0f12 }] */
    /* JADX WARNING: Removed duplicated region for block: B:430:0x0af8 A[SYNTHETIC, Splitter:B:430:0x0af8] */
    /* JADX WARNING: Removed duplicated region for block: B:444:0x0ba8 A[Catch:{ all -> 0x0ef1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:445:0x0baa A[Catch:{ all -> 0x0ef1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:449:0x0bb2 A[SYNTHETIC, Splitter:B:449:0x0bb2] */
    /* JADX WARNING: Removed duplicated region for block: B:460:0x0be0 A[SYNTHETIC, Splitter:B:460:0x0be0] */
    /* JADX WARNING: Removed duplicated region for block: B:488:0x0c7a A[Catch:{ all -> 0x0ef1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:492:0x0cc2 A[Catch:{ all -> 0x0ef1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:575:0x0ef5  */
    /* JADX WARNING: Removed duplicated region for block: B:583:0x0f0c A[SYNTHETIC, Splitter:B:583:0x0f0c] */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x0453 A[EDGE_INSN: B:596:0x0453->B:208:0x0453 ?: BREAK  
    EDGE_INSN: B:596:0x0453->B:208:0x0453 ?: BREAK  , SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzd(java.lang.String r61, long r62) {
        /*
            r60 = this;
            r1 = r60
            com.google.android.gms.measurement.internal.zzx r2 = r60.zzgy()
            r2.beginTransaction()
            com.google.android.gms.measurement.internal.zzjg$zza r2 = new com.google.android.gms.measurement.internal.zzjg$zza     // Catch:{ all -> 0x0f12 }
            r3 = 0
            r2.<init>(r1, r3)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzx r4 = r60.zzgy()     // Catch:{ all -> 0x0f12 }
            long r5 = r1.zztj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x0f12 }
            r4.zzo()     // Catch:{ all -> 0x0f12 }
            r4.zzbi()     // Catch:{ all -> 0x0f12 }
            r8 = -1
            r10 = 2
            r11 = 0
            r12 = 1
            android.database.sqlite.SQLiteDatabase r15 = r4.getWritableDatabase()     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            boolean r13 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            if (r13 == 0) goto L_0x009c
            int r13 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r13 == 0) goto L_0x004b
            java.lang.String[] r13 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
            java.lang.String r14 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
            r13[r11] = r14     // Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
            java.lang.String r14 = java.lang.String.valueOf(r62)     // Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
            r13[r12] = r14     // Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
            goto L_0x0053
        L_0x0040:
            r0 = move-exception
            r4 = r1
            r8 = r3
            goto L_0x0258
        L_0x0045:
            r0 = move-exception
            r7 = r3
            r8 = r7
        L_0x0048:
            r3 = r0
            goto L_0x025f
        L_0x004b:
            java.lang.String[] r13 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            java.lang.String r14 = java.lang.String.valueOf(r62)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            r13[r11] = r14     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
        L_0x0053:
            int r14 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r14 == 0) goto L_0x005a
            java.lang.String r14 = "rowid <= ? and "
            goto L_0x005c
        L_0x005a:
            java.lang.String r14 = ""
        L_0x005c:
            int r7 = r14.length()     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            int r7 = r7 + 148
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            r3.<init>(r7)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            java.lang.String r7 = "select app_id, metadata_fingerprint from raw_events where "
            r3.append(r7)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            r3.append(r14)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            java.lang.String r7 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r3.append(r7)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            java.lang.String r3 = r3.toString()     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            android.database.Cursor r3 = r15.rawQuery(r3, r13)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            boolean r7 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0250, all -> 0x0040 }
            if (r7 != 0) goto L_0x0089
            if (r3 == 0) goto L_0x0275
            r3.close()     // Catch:{ all -> 0x0f12 }
            goto L_0x0275
        L_0x0089:
            java.lang.String r7 = r3.getString(r11)     // Catch:{ SQLiteException -> 0x0250, all -> 0x0040 }
            java.lang.String r13 = r3.getString(r12)     // Catch:{ SQLiteException -> 0x0099, all -> 0x0040 }
            r3.close()     // Catch:{ SQLiteException -> 0x0099, all -> 0x0040 }
            r22 = r3
            r3 = r7
            r7 = r13
            goto L_0x00f2
        L_0x0099:
            r0 = move-exception
            r8 = r3
            goto L_0x0048
        L_0x009c:
            int r3 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r3 == 0) goto L_0x00ac
            java.lang.String[] r3 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            r7 = 0
            r3[r11] = r7     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            java.lang.String r7 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            r3[r12] = r7     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            goto L_0x00b1
        L_0x00ac:
            java.lang.String[] r3 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            r7 = 0
            r3[r11] = r7     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
        L_0x00b1:
            int r7 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r7 == 0) goto L_0x00b8
            java.lang.String r7 = " and rowid <= ?"
            goto L_0x00ba
        L_0x00b8:
            java.lang.String r7 = ""
        L_0x00ba:
            int r13 = r7.length()     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            int r13 = r13 + 84
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            r14.<init>(r13)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            java.lang.String r13 = "select metadata_fingerprint from raw_events where app_id = ?"
            r14.append(r13)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            r14.append(r7)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            java.lang.String r7 = " order by rowid limit 1;"
            r14.append(r7)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            java.lang.String r7 = r14.toString()     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            android.database.Cursor r3 = r15.rawQuery(r7, r3)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            boolean r7 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0250, all -> 0x0040 }
            if (r7 != 0) goto L_0x00e7
            if (r3 == 0) goto L_0x0275
            r3.close()     // Catch:{ all -> 0x0f12 }
            goto L_0x0275
        L_0x00e7:
            java.lang.String r13 = r3.getString(r11)     // Catch:{ SQLiteException -> 0x0250, all -> 0x0040 }
            r3.close()     // Catch:{ SQLiteException -> 0x0250, all -> 0x0040 }
            r22 = r3
            r7 = r13
            r3 = 0
        L_0x00f2:
            java.lang.String r14 = "raw_events_metadata"
            java.lang.String[] r13 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x024a, all -> 0x0245 }
            java.lang.String r16 = "metadata"
            r13[r11] = r16     // Catch:{ SQLiteException -> 0x024a, all -> 0x0245 }
            java.lang.String r16 = "app_id = ? and metadata_fingerprint = ?"
            java.lang.String[] r8 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x024a, all -> 0x0245 }
            r8[r11] = r3     // Catch:{ SQLiteException -> 0x024a, all -> 0x0245 }
            r8[r12] = r7     // Catch:{ SQLiteException -> 0x024a, all -> 0x0245 }
            r18 = 0
            r19 = 0
            java.lang.String r20 = "rowid"
            java.lang.String r21 = "2"
            r9 = r13
            r13 = r15
            r23 = r15
            r15 = r9
            r17 = r8
            android.database.Cursor r8 = r13.query(r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ SQLiteException -> 0x024a, all -> 0x0245 }
            boolean r9 = r8.moveToFirst()     // Catch:{ SQLiteException -> 0x0241 }
            if (r9 != 0) goto L_0x0133
            com.google.android.gms.measurement.internal.zzef r5 = r4.zzab()     // Catch:{ SQLiteException -> 0x0241 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzgk()     // Catch:{ SQLiteException -> 0x0241 }
            java.lang.String r6 = "Raw event metadata record is missing. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzef.zzam(r3)     // Catch:{ SQLiteException -> 0x0241 }
            r5.zza(r6, r7)     // Catch:{ SQLiteException -> 0x0241 }
            if (r8 == 0) goto L_0x0275
            r8.close()     // Catch:{ all -> 0x0f12 }
            goto L_0x0275
        L_0x0133:
            byte[] r9 = r8.getBlob(r11)     // Catch:{ SQLiteException -> 0x0241 }
            com.google.android.gms.internal.measurement.zzel r13 = com.google.android.gms.internal.measurement.zzel.zztq()     // Catch:{ IOException -> 0x0228 }
            com.google.android.gms.internal.measurement.zzbs$zzg r9 = com.google.android.gms.internal.measurement.zzbs.zzg.zzd(r9, r13)     // Catch:{ IOException -> 0x0228 }
            boolean r13 = r8.moveToNext()     // Catch:{ SQLiteException -> 0x0241 }
            if (r13 == 0) goto L_0x0156
            com.google.android.gms.measurement.internal.zzef r13 = r4.zzab()     // Catch:{ SQLiteException -> 0x0241 }
            com.google.android.gms.measurement.internal.zzeh r13 = r13.zzgn()     // Catch:{ SQLiteException -> 0x0241 }
            java.lang.String r14 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzef.zzam(r3)     // Catch:{ SQLiteException -> 0x0241 }
            r13.zza(r14, r15)     // Catch:{ SQLiteException -> 0x0241 }
        L_0x0156:
            r8.close()     // Catch:{ SQLiteException -> 0x0241 }
            r2.zzb(r9)     // Catch:{ SQLiteException -> 0x0241 }
            r13 = -1
            int r9 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r9 == 0) goto L_0x0176
            java.lang.String r9 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            r13 = 3
            java.lang.String[] r14 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x0241 }
            r14[r11] = r3     // Catch:{ SQLiteException -> 0x0241 }
            r14[r12] = r7     // Catch:{ SQLiteException -> 0x0241 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0241 }
            r14[r10] = r5     // Catch:{ SQLiteException -> 0x0241 }
            r16 = r9
            r17 = r14
            goto L_0x0182
        L_0x0176:
            java.lang.String r5 = "app_id = ? and metadata_fingerprint = ?"
            java.lang.String[] r6 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0241 }
            r6[r11] = r3     // Catch:{ SQLiteException -> 0x0241 }
            r6[r12] = r7     // Catch:{ SQLiteException -> 0x0241 }
            r16 = r5
            r17 = r6
        L_0x0182:
            java.lang.String r14 = "raw_events"
            r5 = 4
            java.lang.String[] r15 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0241 }
            java.lang.String r5 = "rowid"
            r15[r11] = r5     // Catch:{ SQLiteException -> 0x0241 }
            java.lang.String r5 = "name"
            r15[r12] = r5     // Catch:{ SQLiteException -> 0x0241 }
            java.lang.String r5 = "timestamp"
            r15[r10] = r5     // Catch:{ SQLiteException -> 0x0241 }
            java.lang.String r5 = "data"
            r6 = 3
            r15[r6] = r5     // Catch:{ SQLiteException -> 0x0241 }
            r18 = 0
            r19 = 0
            java.lang.String r20 = "rowid"
            r21 = 0
            r13 = r23
            android.database.Cursor r5 = r13.query(r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ SQLiteException -> 0x0241 }
            boolean r6 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0223, all -> 0x021f }
            if (r6 != 0) goto L_0x01c4
            com.google.android.gms.measurement.internal.zzef r6 = r4.zzab()     // Catch:{ SQLiteException -> 0x0223, all -> 0x021f }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzgn()     // Catch:{ SQLiteException -> 0x0223, all -> 0x021f }
            java.lang.String r7 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzef.zzam(r3)     // Catch:{ SQLiteException -> 0x0223, all -> 0x021f }
            r6.zza(r7, r8)     // Catch:{ SQLiteException -> 0x0223, all -> 0x021f }
            if (r5 == 0) goto L_0x0275
            r5.close()     // Catch:{ all -> 0x0f12 }
            goto L_0x0275
        L_0x01c4:
            long r6 = r5.getLong(r11)     // Catch:{ SQLiteException -> 0x0223, all -> 0x021f }
            r8 = 3
            byte[] r9 = r5.getBlob(r8)     // Catch:{ SQLiteException -> 0x0223, all -> 0x021f }
            com.google.android.gms.internal.measurement.zzbs$zzc$zza r8 = com.google.android.gms.internal.measurement.zzbs.zzc.zzmq()     // Catch:{ IOException -> 0x01ff }
            com.google.android.gms.internal.measurement.zzel r13 = com.google.android.gms.internal.measurement.zzel.zztq()     // Catch:{ IOException -> 0x01ff }
            com.google.android.gms.internal.measurement.zzdh r8 = r8.zzf(r9, r13)     // Catch:{ IOException -> 0x01ff }
            com.google.android.gms.internal.measurement.zzbs$zzc$zza r8 = (com.google.android.gms.internal.measurement.zzbs.zzc.zza) r8     // Catch:{ IOException -> 0x01ff }
            java.lang.String r9 = r5.getString(r12)     // Catch:{ SQLiteException -> 0x0223, all -> 0x021f }
            com.google.android.gms.internal.measurement.zzbs$zzc$zza r9 = r8.zzbx(r9)     // Catch:{ SQLiteException -> 0x0223, all -> 0x021f }
            long r13 = r5.getLong(r10)     // Catch:{ SQLiteException -> 0x0223, all -> 0x021f }
            r9.zzag(r13)     // Catch:{ SQLiteException -> 0x0223, all -> 0x021f }
            com.google.android.gms.internal.measurement.zzgi r8 = r8.zzug()     // Catch:{ SQLiteException -> 0x0223, all -> 0x021f }
            com.google.android.gms.internal.measurement.zzey r8 = (com.google.android.gms.internal.measurement.zzey) r8     // Catch:{ SQLiteException -> 0x0223, all -> 0x021f }
            com.google.android.gms.internal.measurement.zzbs$zzc r8 = (com.google.android.gms.internal.measurement.zzbs.zzc) r8     // Catch:{ SQLiteException -> 0x0223, all -> 0x021f }
            boolean r6 = r2.zza(r6, r8)     // Catch:{ SQLiteException -> 0x0223, all -> 0x021f }
            if (r6 != 0) goto L_0x0212
            if (r5 == 0) goto L_0x0275
            r5.close()     // Catch:{ all -> 0x0f12 }
            goto L_0x0275
        L_0x01ff:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzef r7 = r4.zzab()     // Catch:{ SQLiteException -> 0x0223, all -> 0x021f }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgk()     // Catch:{ SQLiteException -> 0x0223, all -> 0x021f }
            java.lang.String r8 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzef.zzam(r3)     // Catch:{ SQLiteException -> 0x0223, all -> 0x021f }
            r7.zza(r8, r9, r6)     // Catch:{ SQLiteException -> 0x0223, all -> 0x021f }
        L_0x0212:
            boolean r6 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0223, all -> 0x021f }
            if (r6 != 0) goto L_0x01c4
            if (r5 == 0) goto L_0x0275
            r5.close()     // Catch:{ all -> 0x0f12 }
            goto L_0x0275
        L_0x021f:
            r0 = move-exception
            r4 = r1
            r8 = r5
            goto L_0x0258
        L_0x0223:
            r0 = move-exception
            r7 = r3
            r8 = r5
            goto L_0x0048
        L_0x0228:
            r0 = move-exception
            r5 = r0
            com.google.android.gms.measurement.internal.zzef r6 = r4.zzab()     // Catch:{ SQLiteException -> 0x0241 }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzgk()     // Catch:{ SQLiteException -> 0x0241 }
            java.lang.String r7 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzef.zzam(r3)     // Catch:{ SQLiteException -> 0x0241 }
            r6.zza(r7, r9, r5)     // Catch:{ SQLiteException -> 0x0241 }
            if (r8 == 0) goto L_0x0275
            r8.close()     // Catch:{ all -> 0x0f12 }
            goto L_0x0275
        L_0x0241:
            r0 = move-exception
            r7 = r3
            goto L_0x0048
        L_0x0245:
            r0 = move-exception
            r4 = r1
            r8 = r22
            goto L_0x0258
        L_0x024a:
            r0 = move-exception
            r7 = r3
            r8 = r22
            goto L_0x0048
        L_0x0250:
            r0 = move-exception
            r8 = r3
            r7 = 0
            goto L_0x0048
        L_0x0255:
            r0 = move-exception
            r4 = r1
            r8 = 0
        L_0x0258:
            r1 = r0
            goto L_0x0f0a
        L_0x025b:
            r0 = move-exception
            r3 = r0
            r7 = 0
            r8 = 0
        L_0x025f:
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ all -> 0x0f06 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgk()     // Catch:{ all -> 0x0f06 }
            java.lang.String r5 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzef.zzam(r7)     // Catch:{ all -> 0x0f06 }
            r4.zza(r5, r6, r3)     // Catch:{ all -> 0x0f06 }
            if (r8 == 0) goto L_0x0275
            r8.close()     // Catch:{ all -> 0x0f12 }
        L_0x0275:
            java.util.List<com.google.android.gms.internal.measurement.zzbs$zzc> r3 = r2.zztp     // Catch:{ all -> 0x0f12 }
            if (r3 == 0) goto L_0x0284
            java.util.List<com.google.android.gms.internal.measurement.zzbs$zzc> r3 = r2.zztp     // Catch:{ all -> 0x0f12 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0f12 }
            if (r3 == 0) goto L_0x0282
            goto L_0x0284
        L_0x0282:
            r3 = 0
            goto L_0x0285
        L_0x0284:
            r3 = 1
        L_0x0285:
            if (r3 != 0) goto L_0x0ef5
            com.google.android.gms.internal.measurement.zzbs$zzg r3 = r2.zztn     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzey$zza r3 = r3.zzuj()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzey$zza r3 = (com.google.android.gms.internal.measurement.zzey.zza) r3     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r3 = (com.google.android.gms.internal.measurement.zzbs.zzg.zza) r3     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r3 = r3.zznn()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzs r4 = r4.zzad()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzg r5 = r2.zztn     // Catch:{ all -> 0x0f12 }
            java.lang.String r5 = r5.zzag()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzak.zzii     // Catch:{ all -> 0x0f12 }
            boolean r4 = r4.zze(r5, r6)     // Catch:{ all -> 0x0f12 }
            r5 = -1
            r6 = 0
            r8 = 0
            r9 = 0
            r11 = -1
            r13 = 0
            r15 = 0
            r17 = 0
        L_0x02b1:
            java.util.List<com.google.android.gms.internal.measurement.zzbs$zzc> r7 = r2.zztp     // Catch:{ all -> 0x0f12 }
            int r7 = r7.size()     // Catch:{ all -> 0x0f12 }
            java.lang.String r10 = "_et"
            java.lang.String r12 = "_e"
            r23 = r13
            if (r8 >= r7) goto L_0x07df
            java.util.List<com.google.android.gms.internal.measurement.zzbs$zzc> r7 = r2.zztp     // Catch:{ all -> 0x0f12 }
            java.lang.Object r7 = r7.get(r8)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzc r7 = (com.google.android.gms.internal.measurement.zzbs.zzc) r7     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzey$zza r7 = r7.zzuj()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzey$zza r7 = (com.google.android.gms.internal.measurement.zzey.zza) r7     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzc$zza r7 = (com.google.android.gms.internal.measurement.zzbs.zzc.zza) r7     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzfd r13 = r60.zzgz()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzg r14 = r2.zztn     // Catch:{ all -> 0x0f12 }
            java.lang.String r14 = r14.zzag()     // Catch:{ all -> 0x0f12 }
            r21 = r9
            java.lang.String r9 = r7.getName()     // Catch:{ all -> 0x0f12 }
            boolean r9 = r13.zzk(r14, r9)     // Catch:{ all -> 0x0f12 }
            java.lang.String r13 = "_err"
            if (r9 == 0) goto L_0x036b
            com.google.android.gms.measurement.internal.zzfj r9 = r1.zzj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzab()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzgn()     // Catch:{ all -> 0x0f12 }
            java.lang.String r10 = "Dropping blacklisted raw event. appId"
            com.google.android.gms.internal.measurement.zzbs$zzg r12 = r2.zztn     // Catch:{ all -> 0x0f12 }
            java.lang.String r12 = r12.zzag()     // Catch:{ all -> 0x0f12 }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzef.zzam(r12)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzfj r14 = r1.zzj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzed r14 = r14.zzy()     // Catch:{ all -> 0x0f12 }
            r22 = r15
            java.lang.String r15 = r7.getName()     // Catch:{ all -> 0x0f12 }
            java.lang.String r14 = r14.zzaj(r15)     // Catch:{ all -> 0x0f12 }
            r9.zza(r10, r12, r14)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzfd r9 = r60.zzgz()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzg r10 = r2.zztn     // Catch:{ all -> 0x0f12 }
            java.lang.String r10 = r10.zzag()     // Catch:{ all -> 0x0f12 }
            boolean r9 = r9.zzbc(r10)     // Catch:{ all -> 0x0f12 }
            if (r9 != 0) goto L_0x0333
            com.google.android.gms.measurement.internal.zzfd r9 = r60.zzgz()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzg r10 = r2.zztn     // Catch:{ all -> 0x0f12 }
            java.lang.String r10 = r10.zzag()     // Catch:{ all -> 0x0f12 }
            boolean r9 = r9.zzbd(r10)     // Catch:{ all -> 0x0f12 }
            if (r9 == 0) goto L_0x0331
            goto L_0x0333
        L_0x0331:
            r9 = 0
            goto L_0x0334
        L_0x0333:
            r9 = 1
        L_0x0334:
            if (r9 != 0) goto L_0x0359
            java.lang.String r9 = r7.getName()     // Catch:{ all -> 0x0f12 }
            boolean r9 = r13.equals(r9)     // Catch:{ all -> 0x0f12 }
            if (r9 != 0) goto L_0x0359
            com.google.android.gms.measurement.internal.zzfj r9 = r1.zzj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzjs r25 = r9.zzz()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzg r9 = r2.zztn     // Catch:{ all -> 0x0f12 }
            java.lang.String r26 = r9.zzag()     // Catch:{ all -> 0x0f12 }
            r27 = 11
            java.lang.String r28 = "_ev"
            java.lang.String r29 = r7.getName()     // Catch:{ all -> 0x0f12 }
            r30 = 0
            r25.zza(r26, r27, r28, r29, r30)     // Catch:{ all -> 0x0f12 }
        L_0x0359:
            r28 = r4
            r9 = r21
            r15 = r22
            r13 = r23
            r4 = -1
            r10 = 3
            r59 = r8
            r8 = r3
            r3 = r11
            r11 = r59
            goto L_0x07d4
        L_0x036b:
            r22 = r15
            com.google.android.gms.measurement.internal.zzfd r9 = r60.zzgz()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzg r14 = r2.zztn     // Catch:{ all -> 0x0f12 }
            java.lang.String r14 = r14.zzag()     // Catch:{ all -> 0x0f12 }
            java.lang.String r15 = r7.getName()     // Catch:{ all -> 0x0f12 }
            boolean r9 = r9.zzl(r14, r15)     // Catch:{ all -> 0x0f12 }
            java.lang.String r14 = "_c"
            if (r9 != 0) goto L_0x03dc
            r60.zzgw()     // Catch:{ all -> 0x0f12 }
            java.lang.String r15 = r7.getName()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x0f12 }
            r27 = r8
            int r8 = r15.hashCode()     // Catch:{ all -> 0x0f12 }
            r28 = r4
            r4 = 94660(0x171c4, float:1.32647E-40)
            if (r8 == r4) goto L_0x03b9
            r4 = 95025(0x17331, float:1.33158E-40)
            if (r8 == r4) goto L_0x03af
            r4 = 95027(0x17333, float:1.33161E-40)
            if (r8 == r4) goto L_0x03a5
            goto L_0x03c3
        L_0x03a5:
            java.lang.String r4 = "_ui"
            boolean r4 = r15.equals(r4)     // Catch:{ all -> 0x0f12 }
            if (r4 == 0) goto L_0x03c3
            r4 = 1
            goto L_0x03c4
        L_0x03af:
            java.lang.String r4 = "_ug"
            boolean r4 = r15.equals(r4)     // Catch:{ all -> 0x0f12 }
            if (r4 == 0) goto L_0x03c3
            r4 = 2
            goto L_0x03c4
        L_0x03b9:
            java.lang.String r4 = "_in"
            boolean r4 = r15.equals(r4)     // Catch:{ all -> 0x0f12 }
            if (r4 == 0) goto L_0x03c3
            r4 = 0
            goto L_0x03c4
        L_0x03c3:
            r4 = -1
        L_0x03c4:
            if (r4 == 0) goto L_0x03ce
            r8 = 1
            if (r4 == r8) goto L_0x03ce
            r8 = 2
            if (r4 == r8) goto L_0x03ce
            r4 = 0
            goto L_0x03cf
        L_0x03ce:
            r4 = 1
        L_0x03cf:
            if (r4 == 0) goto L_0x03d2
            goto L_0x03e0
        L_0x03d2:
            r8 = r3
            r30 = r6
            r31 = r10
            r29 = r11
        L_0x03d9:
            r6 = r5
            goto L_0x05bf
        L_0x03dc:
            r28 = r4
            r27 = r8
        L_0x03e0:
            r29 = r11
            r4 = 0
            r8 = 0
            r15 = 0
        L_0x03e5:
            int r11 = r7.zzmk()     // Catch:{ all -> 0x0f12 }
            r30 = r6
            java.lang.String r6 = "_r"
            if (r4 >= r11) goto L_0x0453
            com.google.android.gms.internal.measurement.zzbs$zze r11 = r7.zzl(r4)     // Catch:{ all -> 0x0f12 }
            java.lang.String r11 = r11.getName()     // Catch:{ all -> 0x0f12 }
            boolean r11 = r14.equals(r11)     // Catch:{ all -> 0x0f12 }
            if (r11 == 0) goto L_0x041e
            com.google.android.gms.internal.measurement.zzbs$zze r6 = r7.zzl(r4)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzey$zza r6 = r6.zzuj()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzey$zza r6 = (com.google.android.gms.internal.measurement.zzey.zza) r6     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r6 = (com.google.android.gms.internal.measurement.zzbs.zze.zza) r6     // Catch:{ all -> 0x0f12 }
            r31 = r10
            r10 = 1
            com.google.android.gms.internal.measurement.zzbs$zze$zza r6 = r6.zzam(r10)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzgi r6 = r6.zzug()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzey r6 = (com.google.android.gms.internal.measurement.zzey) r6     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zze r6 = (com.google.android.gms.internal.measurement.zzbs.zze) r6     // Catch:{ all -> 0x0f12 }
            r7.zza(r4, r6)     // Catch:{ all -> 0x0f12 }
            r8 = 1
            goto L_0x044c
        L_0x041e:
            r31 = r10
            com.google.android.gms.internal.measurement.zzbs$zze r10 = r7.zzl(r4)     // Catch:{ all -> 0x0f12 }
            java.lang.String r10 = r10.getName()     // Catch:{ all -> 0x0f12 }
            boolean r6 = r6.equals(r10)     // Catch:{ all -> 0x0f12 }
            if (r6 == 0) goto L_0x044c
            com.google.android.gms.internal.measurement.zzbs$zze r6 = r7.zzl(r4)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzey$zza r6 = r6.zzuj()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzey$zza r6 = (com.google.android.gms.internal.measurement.zzey.zza) r6     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r6 = (com.google.android.gms.internal.measurement.zzbs.zze.zza) r6     // Catch:{ all -> 0x0f12 }
            r10 = 1
            com.google.android.gms.internal.measurement.zzbs$zze$zza r6 = r6.zzam(r10)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzgi r6 = r6.zzug()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzey r6 = (com.google.android.gms.internal.measurement.zzey) r6     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zze r6 = (com.google.android.gms.internal.measurement.zzbs.zze) r6     // Catch:{ all -> 0x0f12 }
            r7.zza(r4, r6)     // Catch:{ all -> 0x0f12 }
            r15 = 1
        L_0x044c:
            int r4 = r4 + 1
            r6 = r30
            r10 = r31
            goto L_0x03e5
        L_0x0453:
            r31 = r10
            if (r8 != 0) goto L_0x0487
            if (r9 == 0) goto L_0x0487
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgs()     // Catch:{ all -> 0x0f12 }
            java.lang.String r8 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzfj r10 = r1.zzj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzed r10 = r10.zzy()     // Catch:{ all -> 0x0f12 }
            java.lang.String r11 = r7.getName()     // Catch:{ all -> 0x0f12 }
            java.lang.String r10 = r10.zzaj(r11)     // Catch:{ all -> 0x0f12 }
            r4.zza(r8, r10)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = com.google.android.gms.internal.measurement.zzbs.zze.zzng()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = r4.zzbz(r14)     // Catch:{ all -> 0x0f12 }
            r10 = 1
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = r4.zzam(r10)     // Catch:{ all -> 0x0f12 }
            r7.zza(r4)     // Catch:{ all -> 0x0f12 }
        L_0x0487:
            if (r15 != 0) goto L_0x04b7
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgs()     // Catch:{ all -> 0x0f12 }
            java.lang.String r8 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzfj r10 = r1.zzj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzed r10 = r10.zzy()     // Catch:{ all -> 0x0f12 }
            java.lang.String r11 = r7.getName()     // Catch:{ all -> 0x0f12 }
            java.lang.String r10 = r10.zzaj(r11)     // Catch:{ all -> 0x0f12 }
            r4.zza(r8, r10)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = com.google.android.gms.internal.measurement.zzbs.zze.zzng()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = r4.zzbz(r6)     // Catch:{ all -> 0x0f12 }
            r10 = 1
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = r4.zzam(r10)     // Catch:{ all -> 0x0f12 }
            r7.zza(r4)     // Catch:{ all -> 0x0f12 }
        L_0x04b7:
            com.google.android.gms.measurement.internal.zzx r32 = r60.zzgy()     // Catch:{ all -> 0x0f12 }
            long r33 = r60.zzjk()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzg r4 = r2.zztn     // Catch:{ all -> 0x0f12 }
            java.lang.String r35 = r4.zzag()     // Catch:{ all -> 0x0f12 }
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 1
            com.google.android.gms.measurement.internal.zzw r4 = r32.zza(r33, r35, r36, r37, r38, r39, r40)     // Catch:{ all -> 0x0f12 }
            long r10 = r4.zzej     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzs r4 = r4.zzad()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzg r8 = r2.zztn     // Catch:{ all -> 0x0f12 }
            java.lang.String r8 = r8.zzag()     // Catch:{ all -> 0x0f12 }
            int r4 = r4.zzi(r8)     // Catch:{ all -> 0x0f12 }
            r8 = r3
            long r3 = (long) r4     // Catch:{ all -> 0x0f12 }
            int r15 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r15 <= 0) goto L_0x04ef
            zza(r7, r6)     // Catch:{ all -> 0x0f12 }
            goto L_0x04f1
        L_0x04ef:
            r21 = 1
        L_0x04f1:
            java.lang.String r3 = r7.getName()     // Catch:{ all -> 0x0f12 }
            boolean r3 = com.google.android.gms.measurement.internal.zzjs.zzbk(r3)     // Catch:{ all -> 0x0f12 }
            if (r3 == 0) goto L_0x03d9
            if (r9 == 0) goto L_0x03d9
            com.google.android.gms.measurement.internal.zzx r32 = r60.zzgy()     // Catch:{ all -> 0x0f12 }
            long r33 = r60.zzjk()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzg r3 = r2.zztn     // Catch:{ all -> 0x0f12 }
            java.lang.String r35 = r3.zzag()     // Catch:{ all -> 0x0f12 }
            r36 = 0
            r37 = 0
            r38 = 1
            r39 = 0
            r40 = 0
            com.google.android.gms.measurement.internal.zzw r3 = r32.zza(r33, r35, r36, r37, r38, r39, r40)     // Catch:{ all -> 0x0f12 }
            long r3 = r3.zzeh     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzad()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzg r10 = r2.zztn     // Catch:{ all -> 0x0f12 }
            java.lang.String r10 = r10.zzag()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Integer> r11 = com.google.android.gms.measurement.internal.zzak.zzgs     // Catch:{ all -> 0x0f12 }
            int r6 = r6.zzb(r10, r11)     // Catch:{ all -> 0x0f12 }
            long r10 = (long) r6     // Catch:{ all -> 0x0f12 }
            int r6 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r6 <= 0) goto L_0x03d9
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzab()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgn()     // Catch:{ all -> 0x0f12 }
            java.lang.String r4 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzbs$zzg r6 = r2.zztn     // Catch:{ all -> 0x0f12 }
            java.lang.String r6 = r6.zzag()     // Catch:{ all -> 0x0f12 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzef.zzam(r6)     // Catch:{ all -> 0x0f12 }
            r3.zza(r4, r6)     // Catch:{ all -> 0x0f12 }
            r3 = 0
            r4 = 0
            r6 = 0
            r10 = -1
        L_0x054f:
            int r11 = r7.zzmk()     // Catch:{ all -> 0x0f12 }
            if (r3 >= r11) goto L_0x057b
            com.google.android.gms.internal.measurement.zzbs$zze r11 = r7.zzl(r3)     // Catch:{ all -> 0x0f12 }
            java.lang.String r15 = r11.getName()     // Catch:{ all -> 0x0f12 }
            boolean r15 = r14.equals(r15)     // Catch:{ all -> 0x0f12 }
            if (r15 == 0) goto L_0x056d
            com.google.android.gms.internal.measurement.zzey$zza r6 = r11.zzuj()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzey$zza r6 = (com.google.android.gms.internal.measurement.zzey.zza) r6     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r6 = (com.google.android.gms.internal.measurement.zzbs.zze.zza) r6     // Catch:{ all -> 0x0f12 }
            r10 = r3
            goto L_0x0578
        L_0x056d:
            java.lang.String r11 = r11.getName()     // Catch:{ all -> 0x0f12 }
            boolean r11 = r13.equals(r11)     // Catch:{ all -> 0x0f12 }
            if (r11 == 0) goto L_0x0578
            r4 = 1
        L_0x0578:
            int r3 = r3 + 1
            goto L_0x054f
        L_0x057b:
            if (r4 == 0) goto L_0x0584
            if (r6 == 0) goto L_0x0584
            r7.zzm(r10)     // Catch:{ all -> 0x0f12 }
            goto L_0x03d9
        L_0x0584:
            if (r6 == 0) goto L_0x05a5
            java.lang.Object r3 = r6.clone()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzey$zza r3 = (com.google.android.gms.internal.measurement.zzey.zza) r3     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r3 = (com.google.android.gms.internal.measurement.zzbs.zze.zza) r3     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r3 = r3.zzbz(r13)     // Catch:{ all -> 0x0f12 }
            r6 = r5
            r4 = 10
            com.google.android.gms.internal.measurement.zzbs$zze$zza r3 = r3.zzam(r4)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzgi r3 = r3.zzug()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzey r3 = (com.google.android.gms.internal.measurement.zzey) r3     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zze r3 = (com.google.android.gms.internal.measurement.zzbs.zze) r3     // Catch:{ all -> 0x0f12 }
            r7.zza(r10, r3)     // Catch:{ all -> 0x0f12 }
            goto L_0x05bf
        L_0x05a5:
            r6 = r5
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzab()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch:{ all -> 0x0f12 }
            java.lang.String r4 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzbs$zzg r5 = r2.zztn     // Catch:{ all -> 0x0f12 }
            java.lang.String r5 = r5.zzag()     // Catch:{ all -> 0x0f12 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzef.zzam(r5)     // Catch:{ all -> 0x0f12 }
            r3.zza(r4, r5)     // Catch:{ all -> 0x0f12 }
        L_0x05bf:
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzs r3 = r3.zzad()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzg r4 = r2.zztn     // Catch:{ all -> 0x0f12 }
            java.lang.String r4 = r4.zzag()     // Catch:{ all -> 0x0f12 }
            boolean r3 = r3.zzs(r4)     // Catch:{ all -> 0x0f12 }
            if (r3 == 0) goto L_0x0698
            if (r9 == 0) goto L_0x0698
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0f12 }
            java.util.List r4 = r7.zzmj()     // Catch:{ all -> 0x0f12 }
            r3.<init>(r4)     // Catch:{ all -> 0x0f12 }
            r4 = 0
            r5 = -1
            r9 = -1
        L_0x05df:
            int r10 = r3.size()     // Catch:{ all -> 0x0f12 }
            if (r4 >= r10) goto L_0x060f
            java.lang.String r10 = "value"
            java.lang.Object r11 = r3.get(r4)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zze r11 = (com.google.android.gms.internal.measurement.zzbs.zze) r11     // Catch:{ all -> 0x0f12 }
            java.lang.String r11 = r11.getName()     // Catch:{ all -> 0x0f12 }
            boolean r10 = r10.equals(r11)     // Catch:{ all -> 0x0f12 }
            if (r10 == 0) goto L_0x05f9
            r5 = r4
            goto L_0x060c
        L_0x05f9:
            java.lang.String r10 = "currency"
            java.lang.Object r11 = r3.get(r4)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zze r11 = (com.google.android.gms.internal.measurement.zzbs.zze) r11     // Catch:{ all -> 0x0f12 }
            java.lang.String r11 = r11.getName()     // Catch:{ all -> 0x0f12 }
            boolean r10 = r10.equals(r11)     // Catch:{ all -> 0x0f12 }
            if (r10 == 0) goto L_0x060c
            r9 = r4
        L_0x060c:
            int r4 = r4 + 1
            goto L_0x05df
        L_0x060f:
            r4 = -1
            if (r5 == r4) goto L_0x0699
            java.lang.Object r4 = r3.get(r5)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zze r4 = (com.google.android.gms.internal.measurement.zzbs.zze) r4     // Catch:{ all -> 0x0f12 }
            boolean r4 = r4.zzna()     // Catch:{ all -> 0x0f12 }
            if (r4 != 0) goto L_0x0647
            java.lang.Object r4 = r3.get(r5)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zze r4 = (com.google.android.gms.internal.measurement.zzbs.zze) r4     // Catch:{ all -> 0x0f12 }
            boolean r4 = r4.zznd()     // Catch:{ all -> 0x0f12 }
            if (r4 != 0) goto L_0x0647
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzab()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgp()     // Catch:{ all -> 0x0f12 }
            java.lang.String r4 = "Value must be specified with a numeric type."
            r3.zzao(r4)     // Catch:{ all -> 0x0f12 }
            r7.zzm(r5)     // Catch:{ all -> 0x0f12 }
            zza(r7, r14)     // Catch:{ all -> 0x0f12 }
            r3 = 18
            java.lang.String r4 = "value"
            zza(r7, r3, r4)     // Catch:{ all -> 0x0f12 }
            goto L_0x0698
        L_0x0647:
            r4 = -1
            if (r9 != r4) goto L_0x064d
            r3 = 1
            r10 = 3
            goto L_0x0679
        L_0x064d:
            java.lang.Object r3 = r3.get(r9)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zze r3 = (com.google.android.gms.internal.measurement.zzbs.zze) r3     // Catch:{ all -> 0x0f12 }
            java.lang.String r3 = r3.zzmy()     // Catch:{ all -> 0x0f12 }
            int r9 = r3.length()     // Catch:{ all -> 0x0f12 }
            r10 = 3
            if (r9 == r10) goto L_0x0660
        L_0x065e:
            r3 = 1
            goto L_0x0679
        L_0x0660:
            r9 = 0
        L_0x0661:
            int r11 = r3.length()     // Catch:{ all -> 0x0f12 }
            if (r9 >= r11) goto L_0x0678
            int r11 = r3.codePointAt(r9)     // Catch:{ all -> 0x0f12 }
            boolean r13 = java.lang.Character.isLetter(r11)     // Catch:{ all -> 0x0f12 }
            if (r13 != 0) goto L_0x0672
            goto L_0x065e
        L_0x0672:
            int r11 = java.lang.Character.charCount(r11)     // Catch:{ all -> 0x0f12 }
            int r9 = r9 + r11
            goto L_0x0661
        L_0x0678:
            r3 = 0
        L_0x0679:
            if (r3 == 0) goto L_0x069a
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzab()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgp()     // Catch:{ all -> 0x0f12 }
            java.lang.String r9 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r3.zzao(r9)     // Catch:{ all -> 0x0f12 }
            r7.zzm(r5)     // Catch:{ all -> 0x0f12 }
            zza(r7, r14)     // Catch:{ all -> 0x0f12 }
            r3 = 19
            java.lang.String r5 = "currency"
            zza(r7, r3, r5)     // Catch:{ all -> 0x0f12 }
            goto L_0x069a
        L_0x0698:
            r4 = -1
        L_0x0699:
            r10 = 3
        L_0x069a:
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzs r3 = r3.zzad()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzg r5 = r2.zztn     // Catch:{ all -> 0x0f12 }
            java.lang.String r5 = r5.zzag()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzak.zzih     // Catch:{ all -> 0x0f12 }
            boolean r3 = r3.zze(r5, r9)     // Catch:{ all -> 0x0f12 }
            if (r3 == 0) goto L_0x0755
            java.lang.String r3 = r7.getName()     // Catch:{ all -> 0x0f12 }
            boolean r3 = r12.equals(r3)     // Catch:{ all -> 0x0f12 }
            if (r3 == 0) goto L_0x0702
            r60.zzgw()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzgi r3 = r7.zzug()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzey r3 = (com.google.android.gms.internal.measurement.zzey) r3     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzc r3 = (com.google.android.gms.internal.measurement.zzbs.zzc) r3     // Catch:{ all -> 0x0f12 }
            java.lang.String r5 = "_fr"
            com.google.android.gms.internal.measurement.zzbs$zze r3 = com.google.android.gms.measurement.internal.zzjo.zza(r3, r5)     // Catch:{ all -> 0x0f12 }
            if (r3 != 0) goto L_0x0755
            if (r17 == 0) goto L_0x06fb
            long r13 = r17.getTimestampMillis()     // Catch:{ all -> 0x0f12 }
            long r25 = r7.getTimestampMillis()     // Catch:{ all -> 0x0f12 }
            long r13 = r13 - r25
            long r13 = java.lang.Math.abs(r13)     // Catch:{ all -> 0x0f12 }
            r25 = 1000(0x3e8, double:4.94E-321)
            int r3 = (r13 > r25 ? 1 : (r13 == r25 ? 0 : -1))
            if (r3 > 0) goto L_0x06fb
            java.lang.Object r3 = r17.clone()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzey$zza r3 = (com.google.android.gms.internal.measurement.zzey.zza) r3     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzc$zza r3 = (com.google.android.gms.internal.measurement.zzbs.zzc.zza) r3     // Catch:{ all -> 0x0f12 }
            boolean r5 = r1.zza(r7, r3)     // Catch:{ all -> 0x0f12 }
            if (r5 == 0) goto L_0x06fb
            r8.zza(r6, r3)     // Catch:{ all -> 0x0f12 }
            r9 = r29
            r5 = r31
        L_0x06f6:
            r17 = 0
            r30 = 0
            goto L_0x0758
        L_0x06fb:
            r30 = r7
            r9 = r22
        L_0x06ff:
            r5 = r31
            goto L_0x0758
        L_0x0702:
            java.lang.String r3 = "_vs"
            java.lang.String r5 = r7.getName()     // Catch:{ all -> 0x0f12 }
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0f12 }
            if (r3 == 0) goto L_0x0755
            r60.zzgw()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzgi r3 = r7.zzug()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzey r3 = (com.google.android.gms.internal.measurement.zzey) r3     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzc r3 = (com.google.android.gms.internal.measurement.zzbs.zzc) r3     // Catch:{ all -> 0x0f12 }
            r5 = r31
            com.google.android.gms.internal.measurement.zzbs$zze r3 = com.google.android.gms.measurement.internal.zzjo.zza(r3, r5)     // Catch:{ all -> 0x0f12 }
            if (r3 != 0) goto L_0x0752
            if (r30 == 0) goto L_0x074b
            long r13 = r30.getTimestampMillis()     // Catch:{ all -> 0x0f12 }
            long r17 = r7.getTimestampMillis()     // Catch:{ all -> 0x0f12 }
            long r13 = r13 - r17
            long r13 = java.lang.Math.abs(r13)     // Catch:{ all -> 0x0f12 }
            r17 = 1000(0x3e8, double:4.94E-321)
            int r3 = (r13 > r17 ? 1 : (r13 == r17 ? 0 : -1))
            if (r3 > 0) goto L_0x074b
            java.lang.Object r3 = r30.clone()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzey$zza r3 = (com.google.android.gms.internal.measurement.zzey.zza) r3     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzc$zza r3 = (com.google.android.gms.internal.measurement.zzbs.zzc.zza) r3     // Catch:{ all -> 0x0f12 }
            boolean r9 = r1.zza(r3, r7)     // Catch:{ all -> 0x0f12 }
            if (r9 == 0) goto L_0x074b
            r9 = r29
            r8.zza(r9, r3)     // Catch:{ all -> 0x0f12 }
            goto L_0x06f6
        L_0x074b:
            r9 = r29
            r17 = r7
            r6 = r22
            goto L_0x0758
        L_0x0752:
            r9 = r29
            goto L_0x0758
        L_0x0755:
            r9 = r29
            goto L_0x06ff
        L_0x0758:
            if (r28 != 0) goto L_0x07b8
            java.lang.String r3 = r7.getName()     // Catch:{ all -> 0x0f12 }
            boolean r3 = r12.equals(r3)     // Catch:{ all -> 0x0f12 }
            if (r3 == 0) goto L_0x07b8
            int r3 = r7.zzmk()     // Catch:{ all -> 0x0f12 }
            if (r3 != 0) goto L_0x0784
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzab()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgn()     // Catch:{ all -> 0x0f12 }
            java.lang.String r5 = "Engagement event does not contain any parameters. appId"
            com.google.android.gms.internal.measurement.zzbs$zzg r11 = r2.zztn     // Catch:{ all -> 0x0f12 }
            java.lang.String r11 = r11.zzag()     // Catch:{ all -> 0x0f12 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzef.zzam(r11)     // Catch:{ all -> 0x0f12 }
            r3.zza(r5, r11)     // Catch:{ all -> 0x0f12 }
            goto L_0x07b8
        L_0x0784:
            r60.zzgw()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzgi r3 = r7.zzug()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzey r3 = (com.google.android.gms.internal.measurement.zzey) r3     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzc r3 = (com.google.android.gms.internal.measurement.zzbs.zzc) r3     // Catch:{ all -> 0x0f12 }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzjo.zzb(r3, r5)     // Catch:{ all -> 0x0f12 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x0f12 }
            if (r3 != 0) goto L_0x07b1
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzab()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgn()     // Catch:{ all -> 0x0f12 }
            java.lang.String r5 = "Engagement event does not include duration. appId"
            com.google.android.gms.internal.measurement.zzbs$zzg r11 = r2.zztn     // Catch:{ all -> 0x0f12 }
            java.lang.String r11 = r11.zzag()     // Catch:{ all -> 0x0f12 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzef.zzam(r11)     // Catch:{ all -> 0x0f12 }
            r3.zza(r5, r11)     // Catch:{ all -> 0x0f12 }
            goto L_0x07b8
        L_0x07b1:
            long r11 = r3.longValue()     // Catch:{ all -> 0x0f12 }
            long r13 = r23 + r11
            goto L_0x07ba
        L_0x07b8:
            r13 = r23
        L_0x07ba:
            java.util.List<com.google.android.gms.internal.measurement.zzbs$zzc> r3 = r2.zztp     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzgi r5 = r7.zzug()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzey r5 = (com.google.android.gms.internal.measurement.zzey) r5     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzc r5 = (com.google.android.gms.internal.measurement.zzbs.zzc) r5     // Catch:{ all -> 0x0f12 }
            r11 = r27
            r3.set(r11, r5)     // Catch:{ all -> 0x0f12 }
            int r15 = r22 + 1
            r8.zza(r7)     // Catch:{ all -> 0x0f12 }
            r5 = r6
            r3 = r9
            r9 = r21
            r6 = r30
        L_0x07d4:
            int r7 = r11 + 1
            r11 = r3
            r3 = r8
            r4 = r28
            r10 = 2
            r12 = 1
            r8 = r7
            goto L_0x02b1
        L_0x07df:
            r8 = r3
            r28 = r4
            r21 = r9
            r5 = r10
            r22 = r15
            if (r28 == 0) goto L_0x083e
            r4 = r22
            r13 = r23
            r3 = 0
        L_0x07ee:
            if (r3 >= r4) goto L_0x0840
            com.google.android.gms.internal.measurement.zzbs$zzc r6 = r8.zzq(r3)     // Catch:{ all -> 0x0f12 }
            java.lang.String r7 = r6.getName()     // Catch:{ all -> 0x0f12 }
            boolean r7 = r12.equals(r7)     // Catch:{ all -> 0x0f12 }
            if (r7 == 0) goto L_0x0811
            r60.zzgw()     // Catch:{ all -> 0x0f12 }
            java.lang.String r7 = "_fr"
            com.google.android.gms.internal.measurement.zzbs$zze r7 = com.google.android.gms.measurement.internal.zzjo.zza(r6, r7)     // Catch:{ all -> 0x0f12 }
            if (r7 == 0) goto L_0x0811
            r8.zzr(r3)     // Catch:{ all -> 0x0f12 }
            int r4 = r4 + -1
            int r3 = r3 + -1
            goto L_0x083b
        L_0x0811:
            r60.zzgw()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zze r6 = com.google.android.gms.measurement.internal.zzjo.zza(r6, r5)     // Catch:{ all -> 0x0f12 }
            if (r6 == 0) goto L_0x083b
            boolean r7 = r6.zzna()     // Catch:{ all -> 0x0f12 }
            if (r7 == 0) goto L_0x0829
            long r6 = r6.zznb()     // Catch:{ all -> 0x0f12 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0f12 }
            goto L_0x082a
        L_0x0829:
            r6 = 0
        L_0x082a:
            if (r6 == 0) goto L_0x083b
            long r9 = r6.longValue()     // Catch:{ all -> 0x0f12 }
            r17 = 0
            int r7 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r7 <= 0) goto L_0x083b
            long r6 = r6.longValue()     // Catch:{ all -> 0x0f12 }
            long r13 = r13 + r6
        L_0x083b:
            r6 = 1
            int r3 = r3 + r6
            goto L_0x07ee
        L_0x083e:
            r13 = r23
        L_0x0840:
            r3 = 0
            r1.zza(r8, r13, r3)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzs r3 = r3.zzad()     // Catch:{ all -> 0x0f12 }
            java.lang.String r4 = r8.zzag()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzak.zzja     // Catch:{ all -> 0x0f12 }
            boolean r3 = r3.zze(r4, r5)     // Catch:{ all -> 0x0f12 }
            if (r3 == 0) goto L_0x088d
            java.util.List r3 = r8.zznl()     // Catch:{ all -> 0x0f12 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0f12 }
        L_0x085e:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0f12 }
            if (r4 == 0) goto L_0x0878
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzc r4 = (com.google.android.gms.internal.measurement.zzbs.zzc) r4     // Catch:{ all -> 0x0f12 }
            java.lang.String r5 = "_s"
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x0f12 }
            boolean r4 = r5.equals(r4)     // Catch:{ all -> 0x0f12 }
            if (r4 == 0) goto L_0x085e
            r3 = 1
            goto L_0x0879
        L_0x0878:
            r3 = 0
        L_0x0879:
            if (r3 == 0) goto L_0x0888
            com.google.android.gms.measurement.internal.zzx r3 = r60.zzgy()     // Catch:{ all -> 0x0f12 }
            java.lang.String r4 = r8.zzag()     // Catch:{ all -> 0x0f12 }
            java.lang.String r5 = "_se"
            r3.zzd(r4, r5)     // Catch:{ all -> 0x0f12 }
        L_0x0888:
            r3 = 1
            r1.zza(r8, r13, r3)     // Catch:{ all -> 0x0f12 }
            goto L_0x08ac
        L_0x088d:
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzs r3 = r3.zzad()     // Catch:{ all -> 0x0f12 }
            java.lang.String r4 = r8.zzag()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzak.zzjb     // Catch:{ all -> 0x0f12 }
            boolean r3 = r3.zze(r4, r5)     // Catch:{ all -> 0x0f12 }
            if (r3 == 0) goto L_0x08ac
            com.google.android.gms.measurement.internal.zzx r3 = r60.zzgy()     // Catch:{ all -> 0x0f12 }
            java.lang.String r4 = r8.zzag()     // Catch:{ all -> 0x0f12 }
            java.lang.String r5 = "_se"
            r3.zzd(r4, r5)     // Catch:{ all -> 0x0f12 }
        L_0x08ac:
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzs r3 = r3.zzad()     // Catch:{ all -> 0x0f12 }
            java.lang.String r4 = r8.zzag()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzak.zzij     // Catch:{ all -> 0x0f12 }
            boolean r3 = r3.zze(r4, r5)     // Catch:{ all -> 0x0f12 }
            if (r3 == 0) goto L_0x0951
            com.google.android.gms.measurement.internal.zzjo r3 = r60.zzgw()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzef r4 = r3.zzab()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgs()     // Catch:{ all -> 0x0f12 }
            java.lang.String r5 = "Checking account type status for ad personalization signals"
            r4.zzao(r5)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzfd r4 = r3.zzgz()     // Catch:{ all -> 0x0f12 }
            java.lang.String r5 = r8.zzag()     // Catch:{ all -> 0x0f12 }
            boolean r4 = r4.zzba(r5)     // Catch:{ all -> 0x0f12 }
            if (r4 == 0) goto L_0x0951
            com.google.android.gms.measurement.internal.zzx r4 = r3.zzgy()     // Catch:{ all -> 0x0f12 }
            java.lang.String r5 = r8.zzag()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzf r4 = r4.zzab(r5)     // Catch:{ all -> 0x0f12 }
            if (r4 == 0) goto L_0x0951
            boolean r4 = r4.zzbe()     // Catch:{ all -> 0x0f12 }
            if (r4 == 0) goto L_0x0951
            com.google.android.gms.measurement.internal.zzac r4 = r3.zzw()     // Catch:{ all -> 0x0f12 }
            boolean r4 = r4.zzcu()     // Catch:{ all -> 0x0f12 }
            if (r4 == 0) goto L_0x0951
            com.google.android.gms.measurement.internal.zzef r4 = r3.zzab()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgr()     // Catch:{ all -> 0x0f12 }
            java.lang.String r5 = "Turning off ad personalization due to account type"
            r4.zzao(r5)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzk$zza r4 = com.google.android.gms.internal.measurement.zzbs.zzk.zzqu()     // Catch:{ all -> 0x0f12 }
            java.lang.String r5 = "_npa"
            com.google.android.gms.internal.measurement.zzbs$zzk$zza r4 = r4.zzdb(r5)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzac r3 = r3.zzw()     // Catch:{ all -> 0x0f12 }
            long r5 = r3.zzcs()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzk$zza r3 = r4.zzbk(r5)     // Catch:{ all -> 0x0f12 }
            r4 = 1
            com.google.android.gms.internal.measurement.zzbs$zzk$zza r3 = r3.zzbl(r4)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzgi r3 = r3.zzug()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzey r3 = (com.google.android.gms.internal.measurement.zzey) r3     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzk r3 = (com.google.android.gms.internal.measurement.zzbs.zzk) r3     // Catch:{ all -> 0x0f12 }
            r4 = 0
        L_0x092d:
            int r5 = r8.zznp()     // Catch:{ all -> 0x0f12 }
            if (r4 >= r5) goto L_0x094b
            java.lang.String r5 = "_npa"
            com.google.android.gms.internal.measurement.zzbs$zzk r6 = r8.zzs(r4)     // Catch:{ all -> 0x0f12 }
            java.lang.String r6 = r6.getName()     // Catch:{ all -> 0x0f12 }
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x0f12 }
            if (r5 == 0) goto L_0x0948
            r8.zza(r4, r3)     // Catch:{ all -> 0x0f12 }
            r4 = 1
            goto L_0x094c
        L_0x0948:
            int r4 = r4 + 1
            goto L_0x092d
        L_0x094b:
            r4 = 0
        L_0x094c:
            if (r4 != 0) goto L_0x0951
            r8.zza(r3)     // Catch:{ all -> 0x0f12 }
        L_0x0951:
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r3 = r8.zznv()     // Catch:{ all -> 0x0f12 }
            java.lang.String r4 = r8.zzag()     // Catch:{ all -> 0x0f12 }
            java.util.List r5 = r8.zzno()     // Catch:{ all -> 0x0f12 }
            java.util.List r6 = r8.zznl()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzp r7 = r60.zzgx()     // Catch:{ all -> 0x0f12 }
            java.util.List r4 = r7.zza(r4, r6, r5)     // Catch:{ all -> 0x0f12 }
            r3.zzc(r4)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzs r3 = r3.zzad()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzg r4 = r2.zztn     // Catch:{ all -> 0x0f12 }
            java.lang.String r4 = r4.zzag()     // Catch:{ all -> 0x0f12 }
            boolean r3 = r3.zzm(r4)     // Catch:{ all -> 0x0f12 }
            if (r3 == 0) goto L_0x0d1b
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x0ef1 }
            r3.<init>()     // Catch:{ all -> 0x0ef1 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0ef1 }
            r4.<init>()     // Catch:{ all -> 0x0ef1 }
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj     // Catch:{ all -> 0x0ef1 }
            com.google.android.gms.measurement.internal.zzjs r5 = r5.zzz()     // Catch:{ all -> 0x0ef1 }
            java.security.SecureRandom r5 = r5.zzjw()     // Catch:{ all -> 0x0ef1 }
            r6 = 0
        L_0x0996:
            int r7 = r8.zznm()     // Catch:{ all -> 0x0ef1 }
            if (r6 >= r7) goto L_0x0ce6
            com.google.android.gms.internal.measurement.zzbs$zzc r7 = r8.zzq(r6)     // Catch:{ all -> 0x0ef1 }
            com.google.android.gms.internal.measurement.zzey$zza r7 = r7.zzuj()     // Catch:{ all -> 0x0ef1 }
            com.google.android.gms.internal.measurement.zzey$zza r7 = (com.google.android.gms.internal.measurement.zzey.zza) r7     // Catch:{ all -> 0x0ef1 }
            com.google.android.gms.internal.measurement.zzbs$zzc$zza r7 = (com.google.android.gms.internal.measurement.zzbs.zzc.zza) r7     // Catch:{ all -> 0x0ef1 }
            java.lang.String r9 = r7.getName()     // Catch:{ all -> 0x0ef1 }
            java.lang.String r10 = "_ep"
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x0ef1 }
            java.lang.String r10 = "_sr"
            if (r9 == 0) goto L_0x0a2b
            r60.zzgw()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzgi r9 = r7.zzug()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzey r9 = (com.google.android.gms.internal.measurement.zzey) r9     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzc r9 = (com.google.android.gms.internal.measurement.zzbs.zzc) r9     // Catch:{ all -> 0x0f12 }
            java.lang.String r11 = "_en"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzjo.zzb(r9, r11)     // Catch:{ all -> 0x0f12 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0f12 }
            java.lang.Object r11 = r3.get(r9)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzae r11 = (com.google.android.gms.measurement.internal.zzae) r11     // Catch:{ all -> 0x0f12 }
            if (r11 != 0) goto L_0x09e2
            com.google.android.gms.measurement.internal.zzx r11 = r60.zzgy()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzg r12 = r2.zztn     // Catch:{ all -> 0x0f12 }
            java.lang.String r12 = r12.zzag()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzae r11 = r11.zzc(r12, r9)     // Catch:{ all -> 0x0f12 }
            r3.put(r9, r11)     // Catch:{ all -> 0x0f12 }
        L_0x09e2:
            java.lang.Long r9 = r11.zzfm     // Catch:{ all -> 0x0f12 }
            if (r9 != 0) goto L_0x0a1f
            java.lang.Long r9 = r11.zzfn     // Catch:{ all -> 0x0f12 }
            long r12 = r9.longValue()     // Catch:{ all -> 0x0f12 }
            r14 = 1
            int r9 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r9 <= 0) goto L_0x09fa
            r60.zzgw()     // Catch:{ all -> 0x0f12 }
            java.lang.Long r9 = r11.zzfn     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzjo.zza(r7, r10, r9)     // Catch:{ all -> 0x0f12 }
        L_0x09fa:
            java.lang.Boolean r9 = r11.zzfo     // Catch:{ all -> 0x0f12 }
            if (r9 == 0) goto L_0x0a14
            java.lang.Boolean r9 = r11.zzfo     // Catch:{ all -> 0x0f12 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0f12 }
            if (r9 == 0) goto L_0x0a14
            r60.zzgw()     // Catch:{ all -> 0x0f12 }
            java.lang.String r9 = "_efs"
            r10 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzjo.zza(r7, r9, r12)     // Catch:{ all -> 0x0f12 }
        L_0x0a14:
            com.google.android.gms.internal.measurement.zzgi r9 = r7.zzug()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzey r9 = (com.google.android.gms.internal.measurement.zzey) r9     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzc r9 = (com.google.android.gms.internal.measurement.zzbs.zzc) r9     // Catch:{ all -> 0x0f12 }
            r4.add(r9)     // Catch:{ all -> 0x0f12 }
        L_0x0a1f:
            r8.zza(r6, r7)     // Catch:{ all -> 0x0f12 }
        L_0x0a22:
            r18 = r2
            r61 = r5
            r1 = r6
            r5 = 1
            goto L_0x0cdb
        L_0x0a2b:
            com.google.android.gms.measurement.internal.zzfd r9 = r60.zzgz()     // Catch:{ all -> 0x0ef1 }
            com.google.android.gms.internal.measurement.zzbs$zzg r11 = r2.zztn     // Catch:{ all -> 0x0ef1 }
            java.lang.String r11 = r11.zzag()     // Catch:{ all -> 0x0ef1 }
            long r11 = r9.zzbb(r11)     // Catch:{ all -> 0x0ef1 }
            com.google.android.gms.measurement.internal.zzfj r9 = r1.zzj     // Catch:{ all -> 0x0ef1 }
            r9.zzz()     // Catch:{ all -> 0x0ef1 }
            long r13 = r7.getTimestampMillis()     // Catch:{ all -> 0x0ef1 }
            long r13 = com.google.android.gms.measurement.internal.zzjs.zzc(r13, r11)     // Catch:{ all -> 0x0ef1 }
            com.google.android.gms.internal.measurement.zzgi r9 = r7.zzug()     // Catch:{ all -> 0x0ef1 }
            com.google.android.gms.internal.measurement.zzey r9 = (com.google.android.gms.internal.measurement.zzey) r9     // Catch:{ all -> 0x0ef1 }
            com.google.android.gms.internal.measurement.zzbs$zzc r9 = (com.google.android.gms.internal.measurement.zzbs.zzc) r9     // Catch:{ all -> 0x0ef1 }
            java.lang.String r15 = "_dbg"
            r23 = r11
            r17 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x0ef1 }
            boolean r12 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x0ef1 }
            if (r12 != 0) goto L_0x0ab8
            if (r11 != 0) goto L_0x0a61
            goto L_0x0ab8
        L_0x0a61:
            java.util.List r9 = r9.zzmj()     // Catch:{ all -> 0x0f12 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0f12 }
        L_0x0a69:
            boolean r12 = r9.hasNext()     // Catch:{ all -> 0x0f12 }
            if (r12 == 0) goto L_0x0ab8
            java.lang.Object r12 = r9.next()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zze r12 = (com.google.android.gms.internal.measurement.zzbs.zze) r12     // Catch:{ all -> 0x0f12 }
            r61 = r9
            java.lang.String r9 = r12.getName()     // Catch:{ all -> 0x0f12 }
            boolean r9 = r15.equals(r9)     // Catch:{ all -> 0x0f12 }
            if (r9 == 0) goto L_0x0ab5
            boolean r9 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0f12 }
            if (r9 == 0) goto L_0x0a93
            long r17 = r12.zznb()     // Catch:{ all -> 0x0f12 }
            java.lang.Long r9 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x0f12 }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x0f12 }
            if (r9 != 0) goto L_0x0ab3
        L_0x0a93:
            boolean r9 = r11 instanceof java.lang.String     // Catch:{ all -> 0x0f12 }
            if (r9 == 0) goto L_0x0aa1
            java.lang.String r9 = r12.zzmy()     // Catch:{ all -> 0x0f12 }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x0f12 }
            if (r9 != 0) goto L_0x0ab3
        L_0x0aa1:
            boolean r9 = r11 instanceof java.lang.Double     // Catch:{ all -> 0x0f12 }
            if (r9 == 0) goto L_0x0ab8
            double r17 = r12.zzne()     // Catch:{ all -> 0x0f12 }
            java.lang.Double r9 = java.lang.Double.valueOf(r17)     // Catch:{ all -> 0x0f12 }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x0f12 }
            if (r9 == 0) goto L_0x0ab8
        L_0x0ab3:
            r9 = 1
            goto L_0x0ab9
        L_0x0ab5:
            r9 = r61
            goto L_0x0a69
        L_0x0ab8:
            r9 = 0
        L_0x0ab9:
            if (r9 != 0) goto L_0x0ace
            com.google.android.gms.measurement.internal.zzfd r9 = r60.zzgz()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzg r11 = r2.zztn     // Catch:{ all -> 0x0f12 }
            java.lang.String r11 = r11.zzag()     // Catch:{ all -> 0x0f12 }
            java.lang.String r12 = r7.getName()     // Catch:{ all -> 0x0f12 }
            int r12 = r9.zzm(r11, r12)     // Catch:{ all -> 0x0f12 }
            goto L_0x0acf
        L_0x0ace:
            r12 = 1
        L_0x0acf:
            if (r12 > 0) goto L_0x0af8
            com.google.android.gms.measurement.internal.zzfj r9 = r1.zzj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzab()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzgn()     // Catch:{ all -> 0x0f12 }
            java.lang.String r10 = "Sample rate must be positive. event, rate"
            java.lang.String r11 = r7.getName()     // Catch:{ all -> 0x0f12 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0f12 }
            r9.zza(r10, r11, r12)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzgi r9 = r7.zzug()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzey r9 = (com.google.android.gms.internal.measurement.zzey) r9     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzc r9 = (com.google.android.gms.internal.measurement.zzbs.zzc) r9     // Catch:{ all -> 0x0f12 }
            r4.add(r9)     // Catch:{ all -> 0x0f12 }
            r8.zza(r6, r7)     // Catch:{ all -> 0x0f12 }
            goto L_0x0a22
        L_0x0af8:
            java.lang.String r9 = r7.getName()     // Catch:{ all -> 0x0ef1 }
            java.lang.Object r9 = r3.get(r9)     // Catch:{ all -> 0x0ef1 }
            com.google.android.gms.measurement.internal.zzae r9 = (com.google.android.gms.measurement.internal.zzae) r9     // Catch:{ all -> 0x0ef1 }
            if (r9 != 0) goto L_0x0b91
            com.google.android.gms.measurement.internal.zzx r9 = r60.zzgy()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzg r11 = r2.zztn     // Catch:{ all -> 0x0f12 }
            java.lang.String r11 = r11.zzag()     // Catch:{ all -> 0x0f12 }
            java.lang.String r15 = r7.getName()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzae r9 = r9.zzc(r11, r15)     // Catch:{ all -> 0x0f12 }
            if (r9 != 0) goto L_0x0b91
            com.google.android.gms.measurement.internal.zzfj r9 = r1.zzj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzab()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzgn()     // Catch:{ all -> 0x0f12 }
            java.lang.String r11 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzbs$zzg r15 = r2.zztn     // Catch:{ all -> 0x0f12 }
            java.lang.String r15 = r15.zzag()     // Catch:{ all -> 0x0f12 }
            r17 = r13
            java.lang.String r13 = r7.getName()     // Catch:{ all -> 0x0f12 }
            r9.zza(r11, r15, r13)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzfj r9 = r1.zzj     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzs r9 = r9.zzad()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzg r11 = r2.zztn     // Catch:{ all -> 0x0f12 }
            java.lang.String r11 = r11.zzag()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzak.zziz     // Catch:{ all -> 0x0f12 }
            boolean r9 = r9.zze(r11, r13)     // Catch:{ all -> 0x0f12 }
            if (r9 == 0) goto L_0x0b6d
            com.google.android.gms.measurement.internal.zzae r9 = new com.google.android.gms.measurement.internal.zzae     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzg r11 = r2.zztn     // Catch:{ all -> 0x0f12 }
            java.lang.String r28 = r11.zzag()     // Catch:{ all -> 0x0f12 }
            java.lang.String r29 = r7.getName()     // Catch:{ all -> 0x0f12 }
            r30 = 1
            r32 = 1
            r34 = 1
            long r36 = r7.getTimestampMillis()     // Catch:{ all -> 0x0f12 }
            r38 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r27 = r9
            r27.<init>(r28, r29, r30, r32, r34, r36, r38, r40, r41, r42, r43)     // Catch:{ all -> 0x0f12 }
            goto L_0x0b93
        L_0x0b6d:
            com.google.android.gms.measurement.internal.zzae r9 = new com.google.android.gms.measurement.internal.zzae     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzg r11 = r2.zztn     // Catch:{ all -> 0x0f12 }
            java.lang.String r45 = r11.zzag()     // Catch:{ all -> 0x0f12 }
            java.lang.String r46 = r7.getName()     // Catch:{ all -> 0x0f12 }
            r47 = 1
            r49 = 1
            long r51 = r7.getTimestampMillis()     // Catch:{ all -> 0x0f12 }
            r53 = 0
            r55 = 0
            r56 = 0
            r57 = 0
            r58 = 0
            r44 = r9
            r44.<init>(r45, r46, r47, r49, r51, r53, r55, r56, r57, r58)     // Catch:{ all -> 0x0f12 }
            goto L_0x0b93
        L_0x0b91:
            r17 = r13
        L_0x0b93:
            r60.zzgw()     // Catch:{ all -> 0x0ef1 }
            com.google.android.gms.internal.measurement.zzgi r11 = r7.zzug()     // Catch:{ all -> 0x0ef1 }
            com.google.android.gms.internal.measurement.zzey r11 = (com.google.android.gms.internal.measurement.zzey) r11     // Catch:{ all -> 0x0ef1 }
            com.google.android.gms.internal.measurement.zzbs$zzc r11 = (com.google.android.gms.internal.measurement.zzbs.zzc) r11     // Catch:{ all -> 0x0ef1 }
            java.lang.String r13 = "_eid"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzjo.zzb(r11, r13)     // Catch:{ all -> 0x0ef1 }
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x0ef1 }
            if (r11 == 0) goto L_0x0baa
            r13 = 1
            goto L_0x0bab
        L_0x0baa:
            r13 = 0
        L_0x0bab:
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)     // Catch:{ all -> 0x0ef1 }
            r14 = 1
            if (r12 != r14) goto L_0x0be0
            com.google.android.gms.internal.measurement.zzgi r10 = r7.zzug()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzey r10 = (com.google.android.gms.internal.measurement.zzey) r10     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzc r10 = (com.google.android.gms.internal.measurement.zzbs.zzc) r10     // Catch:{ all -> 0x0f12 }
            r4.add(r10)     // Catch:{ all -> 0x0f12 }
            boolean r10 = r13.booleanValue()     // Catch:{ all -> 0x0f12 }
            if (r10 == 0) goto L_0x0bdb
            java.lang.Long r10 = r9.zzfm     // Catch:{ all -> 0x0f12 }
            if (r10 != 0) goto L_0x0bcf
            java.lang.Long r10 = r9.zzfn     // Catch:{ all -> 0x0f12 }
            if (r10 != 0) goto L_0x0bcf
            java.lang.Boolean r10 = r9.zzfo     // Catch:{ all -> 0x0f12 }
            if (r10 == 0) goto L_0x0bdb
        L_0x0bcf:
            r10 = 0
            com.google.android.gms.measurement.internal.zzae r9 = r9.zza(r10, r10, r10)     // Catch:{ all -> 0x0f12 }
            java.lang.String r10 = r7.getName()     // Catch:{ all -> 0x0f12 }
            r3.put(r10, r9)     // Catch:{ all -> 0x0f12 }
        L_0x0bdb:
            r8.zza(r6, r7)     // Catch:{ all -> 0x0f12 }
            goto L_0x0a22
        L_0x0be0:
            int r14 = r5.nextInt(r12)     // Catch:{ all -> 0x0ef1 }
            if (r14 != 0) goto L_0x0c25
            r60.zzgw()     // Catch:{ all -> 0x0f12 }
            long r11 = (long) r12     // Catch:{ all -> 0x0f12 }
            java.lang.Long r14 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.measurement.internal.zzjo.zza(r7, r10, r14)     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzgi r10 = r7.zzug()     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzey r10 = (com.google.android.gms.internal.measurement.zzey) r10     // Catch:{ all -> 0x0f12 }
            com.google.android.gms.internal.measurement.zzbs$zzc r10 = (com.google.android.gms.internal.measurement.zzbs.zzc) r10     // Catch:{ all -> 0x0f12 }
            r4.add(r10)     // Catch:{ all -> 0x0f12 }
            boolean r10 = r13.booleanValue()     // Catch:{ all -> 0x0f12 }
            if (r10 == 0) goto L_0x0c0b
            java.lang.Long r10 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0f12 }
            r11 = 0
            com.google.android.gms.measurement.internal.zzae r9 = r9.zza(r11, r10, r11)     // Catch:{ all -> 0x0f12 }
        L_0x0c0b:
            java.lang.String r10 = r7.getName()     // Catch:{ all -> 0x0f12 }
            long r11 = r7.getTimestampMillis()     // Catch:{ all -> 0x0f12 }
            r14 = r17
            com.google.android.gms.measurement.internal.zzae r9 = r9.zza(r11, r14)     // Catch:{ all -> 0x0f12 }
            r3.put(r10, r9)     // Catch:{ all -> 0x0f12 }
            r18 = r2
            r61 = r5
            r1 = r6
            r5 = 1
            goto L_0x0cd8
        L_0x0c25:
            r61 = r5
            r14 = r17
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj     // Catch:{ all -> 0x0ef1 }
            com.google.android.gms.measurement.internal.zzs r5 = r5.zzad()     // Catch:{ all -> 0x0ef1 }
            r17 = r6
            com.google.android.gms.internal.measurement.zzbs$zzg r6 = r2.zztn     // Catch:{ all -> 0x0ef1 }
            java.lang.String r6 = r6.zzag()     // Catch:{ all -> 0x0ef1 }
            boolean r5 = r5.zzu(r6)     // Catch:{ all -> 0x0ef1 }
            if (r5 == 0) goto L_0x0c63
            java.lang.Long r5 = r9.zzfl     // Catch:{ all -> 0x0ef1 }
            if (r5 == 0) goto L_0x0c4a
            java.lang.Long r5 = r9.zzfl     // Catch:{ all -> 0x0f12 }
            long r5 = r5.longValue()     // Catch:{ all -> 0x0f12 }
            r18 = r2
            goto L_0x0c5b
        L_0x0c4a:
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj     // Catch:{ all -> 0x0ef1 }
            r5.zzz()     // Catch:{ all -> 0x0ef1 }
            long r5 = r7.zzmm()     // Catch:{ all -> 0x0ef1 }
            r18 = r2
            r1 = r23
            long r5 = com.google.android.gms.measurement.internal.zzjs.zzc(r5, r1)     // Catch:{ all -> 0x0ef1 }
        L_0x0c5b:
            int r1 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r1 == 0) goto L_0x0c61
        L_0x0c5f:
            r1 = 1
            goto L_0x0c78
        L_0x0c61:
            r1 = 0
            goto L_0x0c78
        L_0x0c63:
            r18 = r2
            long r1 = r9.zzfk     // Catch:{ all -> 0x0ef1 }
            long r5 = r7.getTimestampMillis()     // Catch:{ all -> 0x0ef1 }
            long r5 = r5 - r1
            long r1 = java.lang.Math.abs(r5)     // Catch:{ all -> 0x0ef1 }
            r5 = 86400000(0x5265c00, double:4.2687272E-316)
            int r22 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r22 < 0) goto L_0x0c61
            goto L_0x0c5f
        L_0x0c78:
            if (r1 == 0) goto L_0x0cc2
            r60.zzgw()     // Catch:{ all -> 0x0ef1 }
            java.lang.String r1 = "_efs"
            r5 = 1
            java.lang.Long r2 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0ef1 }
            com.google.android.gms.measurement.internal.zzjo.zza(r7, r1, r2)     // Catch:{ all -> 0x0ef1 }
            r60.zzgw()     // Catch:{ all -> 0x0ef1 }
            long r1 = (long) r12     // Catch:{ all -> 0x0ef1 }
            java.lang.Long r11 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0ef1 }
            com.google.android.gms.measurement.internal.zzjo.zza(r7, r10, r11)     // Catch:{ all -> 0x0ef1 }
            com.google.android.gms.internal.measurement.zzgi r10 = r7.zzug()     // Catch:{ all -> 0x0ef1 }
            com.google.android.gms.internal.measurement.zzey r10 = (com.google.android.gms.internal.measurement.zzey) r10     // Catch:{ all -> 0x0ef1 }
            com.google.android.gms.internal.measurement.zzbs$zzc r10 = (com.google.android.gms.internal.measurement.zzbs.zzc) r10     // Catch:{ all -> 0x0ef1 }
            r4.add(r10)     // Catch:{ all -> 0x0ef1 }
            boolean r10 = r13.booleanValue()     // Catch:{ all -> 0x0ef1 }
            if (r10 == 0) goto L_0x0cb2
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0ef1 }
            r2 = 1
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x0ef1 }
            r2 = 0
            com.google.android.gms.measurement.internal.zzae r9 = r9.zza(r2, r1, r10)     // Catch:{ all -> 0x0ef1 }
        L_0x0cb2:
            java.lang.String r1 = r7.getName()     // Catch:{ all -> 0x0ef1 }
            long r10 = r7.getTimestampMillis()     // Catch:{ all -> 0x0ef1 }
            com.google.android.gms.measurement.internal.zzae r2 = r9.zza(r10, r14)     // Catch:{ all -> 0x0ef1 }
            r3.put(r1, r2)     // Catch:{ all -> 0x0ef1 }
            goto L_0x0cd6
        L_0x0cc2:
            r5 = 1
            boolean r1 = r13.booleanValue()     // Catch:{ all -> 0x0ef1 }
            if (r1 == 0) goto L_0x0cd6
            java.lang.String r1 = r7.getName()     // Catch:{ all -> 0x0ef1 }
            r2 = 0
            com.google.android.gms.measurement.internal.zzae r9 = r9.zza(r11, r2, r2)     // Catch:{ all -> 0x0ef1 }
            r3.put(r1, r9)     // Catch:{ all -> 0x0ef1 }
        L_0x0cd6:
            r1 = r17
        L_0x0cd8:
            r8.zza(r1, r7)     // Catch:{ all -> 0x0ef1 }
        L_0x0cdb:
            int r1 = r1 + 1
            r5 = r61
            r6 = r1
            r2 = r18
            r1 = r60
            goto L_0x0996
        L_0x0ce6:
            r18 = r2
            int r1 = r4.size()     // Catch:{ all -> 0x0ef1 }
            int r2 = r8.zznm()     // Catch:{ all -> 0x0ef1 }
            if (r1 >= r2) goto L_0x0cf9
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r1 = r8.zznn()     // Catch:{ all -> 0x0ef1 }
            r1.zza(r4)     // Catch:{ all -> 0x0ef1 }
        L_0x0cf9:
            java.util.Set r1 = r3.entrySet()     // Catch:{ all -> 0x0ef1 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0ef1 }
        L_0x0d01:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0ef1 }
            if (r2 == 0) goto L_0x0d1d
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0ef1 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x0ef1 }
            com.google.android.gms.measurement.internal.zzx r3 = r60.zzgy()     // Catch:{ all -> 0x0ef1 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x0ef1 }
            com.google.android.gms.measurement.internal.zzae r2 = (com.google.android.gms.measurement.internal.zzae) r2     // Catch:{ all -> 0x0ef1 }
            r3.zza(r2)     // Catch:{ all -> 0x0ef1 }
            goto L_0x0d01
        L_0x0d1b:
            r18 = r2
        L_0x0d1d:
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r1 = r8.zzao(r1)     // Catch:{ all -> 0x0ef1 }
            r2 = -9223372036854775808
            r1.zzap(r2)     // Catch:{ all -> 0x0ef1 }
            r1 = 0
        L_0x0d2c:
            int r2 = r8.zznm()     // Catch:{ all -> 0x0ef1 }
            if (r1 >= r2) goto L_0x0d5f
            com.google.android.gms.internal.measurement.zzbs$zzc r2 = r8.zzq(r1)     // Catch:{ all -> 0x0ef1 }
            long r3 = r2.getTimestampMillis()     // Catch:{ all -> 0x0ef1 }
            long r5 = r8.zznq()     // Catch:{ all -> 0x0ef1 }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x0d49
            long r3 = r2.getTimestampMillis()     // Catch:{ all -> 0x0ef1 }
            r8.zzao(r3)     // Catch:{ all -> 0x0ef1 }
        L_0x0d49:
            long r3 = r2.getTimestampMillis()     // Catch:{ all -> 0x0ef1 }
            long r5 = r8.zznr()     // Catch:{ all -> 0x0ef1 }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0d5c
            long r2 = r2.getTimestampMillis()     // Catch:{ all -> 0x0ef1 }
            r8.zzap(r2)     // Catch:{ all -> 0x0ef1 }
        L_0x0d5c:
            int r1 = r1 + 1
            goto L_0x0d2c
        L_0x0d5f:
            r1 = r18
            com.google.android.gms.internal.measurement.zzbs$zzg r2 = r1.zztn     // Catch:{ all -> 0x0ef1 }
            java.lang.String r2 = r2.zzag()     // Catch:{ all -> 0x0ef1 }
            com.google.android.gms.measurement.internal.zzx r3 = r60.zzgy()     // Catch:{ all -> 0x0ef1 }
            com.google.android.gms.measurement.internal.zzf r3 = r3.zzab(r2)     // Catch:{ all -> 0x0ef1 }
            if (r3 != 0) goto L_0x0d8d
            r4 = r60
            com.google.android.gms.measurement.internal.zzfj r3 = r4.zzj     // Catch:{ all -> 0x0f10 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzab()     // Catch:{ all -> 0x0f10 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch:{ all -> 0x0f10 }
            java.lang.String r5 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzbs$zzg r6 = r1.zztn     // Catch:{ all -> 0x0f10 }
            java.lang.String r6 = r6.zzag()     // Catch:{ all -> 0x0f10 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzef.zzam(r6)     // Catch:{ all -> 0x0f10 }
            r3.zza(r5, r6)     // Catch:{ all -> 0x0f10 }
            goto L_0x0dea
        L_0x0d8d:
            r4 = r60
            int r5 = r8.zznm()     // Catch:{ all -> 0x0f10 }
            if (r5 <= 0) goto L_0x0dea
            long r5 = r3.zzak()     // Catch:{ all -> 0x0f10 }
            r9 = 0
            int r7 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r7 == 0) goto L_0x0da3
            r8.zzar(r5)     // Catch:{ all -> 0x0f10 }
            goto L_0x0da6
        L_0x0da3:
            r8.zznt()     // Catch:{ all -> 0x0f10 }
        L_0x0da6:
            long r9 = r3.zzaj()     // Catch:{ all -> 0x0f10 }
            r11 = 0
            int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x0db1
            goto L_0x0db2
        L_0x0db1:
            r5 = r9
        L_0x0db2:
            int r7 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r7 == 0) goto L_0x0dba
            r8.zzaq(r5)     // Catch:{ all -> 0x0f10 }
            goto L_0x0dbd
        L_0x0dba:
            r8.zzns()     // Catch:{ all -> 0x0f10 }
        L_0x0dbd:
            r3.zzau()     // Catch:{ all -> 0x0f10 }
            long r5 = r3.zzar()     // Catch:{ all -> 0x0f10 }
            int r6 = (int) r5     // Catch:{ all -> 0x0f10 }
            r8.zzu(r6)     // Catch:{ all -> 0x0f10 }
            long r5 = r8.zznq()     // Catch:{ all -> 0x0f10 }
            r3.zze(r5)     // Catch:{ all -> 0x0f10 }
            long r5 = r8.zznr()     // Catch:{ all -> 0x0f10 }
            r3.zzf(r5)     // Catch:{ all -> 0x0f10 }
            java.lang.String r5 = r3.zzbc()     // Catch:{ all -> 0x0f10 }
            if (r5 == 0) goto L_0x0de0
            r8.zzcl(r5)     // Catch:{ all -> 0x0f10 }
            goto L_0x0de3
        L_0x0de0:
            r8.zznu()     // Catch:{ all -> 0x0f10 }
        L_0x0de3:
            com.google.android.gms.measurement.internal.zzx r5 = r60.zzgy()     // Catch:{ all -> 0x0f10 }
            r5.zza(r3)     // Catch:{ all -> 0x0f10 }
        L_0x0dea:
            int r3 = r8.zznm()     // Catch:{ all -> 0x0f10 }
            if (r3 <= 0) goto L_0x0e50
            com.google.android.gms.measurement.internal.zzfj r3 = r4.zzj     // Catch:{ all -> 0x0f10 }
            r3.zzae()     // Catch:{ all -> 0x0f10 }
            com.google.android.gms.measurement.internal.zzfd r3 = r60.zzgz()     // Catch:{ all -> 0x0f10 }
            com.google.android.gms.internal.measurement.zzbs$zzg r5 = r1.zztn     // Catch:{ all -> 0x0f10 }
            java.lang.String r5 = r5.zzag()     // Catch:{ all -> 0x0f10 }
            com.google.android.gms.internal.measurement.zzbw r3 = r3.zzaw(r5)     // Catch:{ all -> 0x0f10 }
            if (r3 == 0) goto L_0x0e14
            java.lang.Long r5 = r3.zzzk     // Catch:{ all -> 0x0f10 }
            if (r5 != 0) goto L_0x0e0a
            goto L_0x0e14
        L_0x0e0a:
            java.lang.Long r3 = r3.zzzk     // Catch:{ all -> 0x0f10 }
            long r5 = r3.longValue()     // Catch:{ all -> 0x0f10 }
            r8.zzav(r5)     // Catch:{ all -> 0x0f10 }
            goto L_0x0e3f
        L_0x0e14:
            com.google.android.gms.internal.measurement.zzbs$zzg r3 = r1.zztn     // Catch:{ all -> 0x0f10 }
            java.lang.String r3 = r3.getGmpAppId()     // Catch:{ all -> 0x0f10 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0f10 }
            if (r3 == 0) goto L_0x0e26
            r5 = -1
            r8.zzav(r5)     // Catch:{ all -> 0x0f10 }
            goto L_0x0e3f
        L_0x0e26:
            com.google.android.gms.measurement.internal.zzfj r3 = r4.zzj     // Catch:{ all -> 0x0f10 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzab()     // Catch:{ all -> 0x0f10 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgn()     // Catch:{ all -> 0x0f10 }
            java.lang.String r5 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzbs$zzg r6 = r1.zztn     // Catch:{ all -> 0x0f10 }
            java.lang.String r6 = r6.zzag()     // Catch:{ all -> 0x0f10 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzef.zzam(r6)     // Catch:{ all -> 0x0f10 }
            r3.zza(r5, r6)     // Catch:{ all -> 0x0f10 }
        L_0x0e3f:
            com.google.android.gms.measurement.internal.zzx r3 = r60.zzgy()     // Catch:{ all -> 0x0f10 }
            com.google.android.gms.internal.measurement.zzgi r5 = r8.zzug()     // Catch:{ all -> 0x0f10 }
            com.google.android.gms.internal.measurement.zzey r5 = (com.google.android.gms.internal.measurement.zzey) r5     // Catch:{ all -> 0x0f10 }
            com.google.android.gms.internal.measurement.zzbs$zzg r5 = (com.google.android.gms.internal.measurement.zzbs.zzg) r5     // Catch:{ all -> 0x0f10 }
            r9 = r21
            r3.zza(r5, r9)     // Catch:{ all -> 0x0f10 }
        L_0x0e50:
            com.google.android.gms.measurement.internal.zzx r3 = r60.zzgy()     // Catch:{ all -> 0x0f10 }
            java.util.List<java.lang.Long> r1 = r1.zzto     // Catch:{ all -> 0x0f10 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)     // Catch:{ all -> 0x0f10 }
            r3.zzo()     // Catch:{ all -> 0x0f10 }
            r3.zzbi()     // Catch:{ all -> 0x0f10 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0f10 }
            java.lang.String r6 = "rowid in ("
            r5.<init>(r6)     // Catch:{ all -> 0x0f10 }
            r6 = 0
        L_0x0e67:
            int r7 = r1.size()     // Catch:{ all -> 0x0f10 }
            if (r6 >= r7) goto L_0x0e84
            if (r6 == 0) goto L_0x0e74
            java.lang.String r7 = ","
            r5.append(r7)     // Catch:{ all -> 0x0f10 }
        L_0x0e74:
            java.lang.Object r7 = r1.get(r6)     // Catch:{ all -> 0x0f10 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0f10 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0f10 }
            r5.append(r7)     // Catch:{ all -> 0x0f10 }
            int r6 = r6 + 1
            goto L_0x0e67
        L_0x0e84:
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x0f10 }
            android.database.sqlite.SQLiteDatabase r6 = r3.getWritableDatabase()     // Catch:{ all -> 0x0f10 }
            java.lang.String r7 = "raw_events"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0f10 }
            r8 = 0
            int r5 = r6.delete(r7, r5, r8)     // Catch:{ all -> 0x0f10 }
            int r6 = r1.size()     // Catch:{ all -> 0x0f10 }
            if (r5 == r6) goto L_0x0eb7
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzab()     // Catch:{ all -> 0x0f10 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch:{ all -> 0x0f10 }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0f10 }
            int r1 = r1.size()     // Catch:{ all -> 0x0f10 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0f10 }
            r3.zza(r6, r5, r1)     // Catch:{ all -> 0x0f10 }
        L_0x0eb7:
            com.google.android.gms.measurement.internal.zzx r1 = r60.zzgy()     // Catch:{ all -> 0x0f10 }
            android.database.sqlite.SQLiteDatabase r3 = r1.getWritableDatabase()     // Catch:{ all -> 0x0f10 }
            java.lang.String r5 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0ece }
            r7 = 0
            r6[r7] = r2     // Catch:{ SQLiteException -> 0x0ece }
            r7 = 1
            r6[r7] = r2     // Catch:{ SQLiteException -> 0x0ece }
            r3.execSQL(r5, r6)     // Catch:{ SQLiteException -> 0x0ece }
            goto L_0x0ee1
        L_0x0ece:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzab()     // Catch:{ all -> 0x0f10 }
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgk()     // Catch:{ all -> 0x0f10 }
            java.lang.String r5 = "Failed to remove unused event metadata. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzef.zzam(r2)     // Catch:{ all -> 0x0f10 }
            r1.zza(r5, r2, r3)     // Catch:{ all -> 0x0f10 }
        L_0x0ee1:
            com.google.android.gms.measurement.internal.zzx r1 = r60.zzgy()     // Catch:{ all -> 0x0f10 }
            r1.setTransactionSuccessful()     // Catch:{ all -> 0x0f10 }
            com.google.android.gms.measurement.internal.zzx r1 = r60.zzgy()
            r1.endTransaction()
            r1 = 1
            return r1
        L_0x0ef1:
            r0 = move-exception
            r4 = r60
            goto L_0x0f14
        L_0x0ef5:
            r4 = r1
            com.google.android.gms.measurement.internal.zzx r1 = r60.zzgy()     // Catch:{ all -> 0x0f10 }
            r1.setTransactionSuccessful()     // Catch:{ all -> 0x0f10 }
            com.google.android.gms.measurement.internal.zzx r1 = r60.zzgy()
            r1.endTransaction()
            r1 = 0
            return r1
        L_0x0f06:
            r0 = move-exception
            r4 = r1
            goto L_0x0258
        L_0x0f0a:
            if (r8 == 0) goto L_0x0f0f
            r8.close()     // Catch:{ all -> 0x0f10 }
        L_0x0f0f:
            throw r1     // Catch:{ all -> 0x0f10 }
        L_0x0f10:
            r0 = move-exception
            goto L_0x0f14
        L_0x0f12:
            r0 = move-exception
            r4 = r1
        L_0x0f14:
            r1 = r0
            com.google.android.gms.measurement.internal.zzx r2 = r60.zzgy()
            r2.endTransaction()
            throw r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjg.zzd(java.lang.String, long):boolean");
    }

    @VisibleForTesting
    private final void zza(com.google.android.gms.internal.measurement.zzbs.zzg.zza zza2, long j, boolean z) {
        zzjp zzjp;
        String str = z ? "_se" : "_lte";
        zzjp zze = zzgy().zze(zza2.zzag(), str);
        if (zze == null || zze.value == null) {
            zzjp = new zzjp(zza2.zzag(), "auto", str, this.zzj.zzx().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzjp = new zzjp(zza2.zzag(), "auto", str, this.zzj.zzx().currentTimeMillis(), Long.valueOf(((Long) zze.value).longValue() + j));
        }
        zzk zzk = (zzk) ((zzey) zzk.zzqu().zzdb(str).zzbk(this.zzj.zzx().currentTimeMillis()).zzbl(((Long) zzjp.value).longValue()).zzug());
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (i >= zza2.zznp()) {
                break;
            } else if (str.equals(zza2.zzs(i).getName())) {
                zza2.zza(i, zzk);
                z2 = true;
                break;
            } else {
                i++;
            }
        }
        if (!z2) {
            zza2.zza(zzk);
        }
        if (j > 0) {
            zzgy().zza(zzjp);
            this.zzj.zzab().zzgr().zza("Updated engagement user property. scope, value", z ? "session-scoped" : "lifetime", zzjp.value);
        }
    }

    private final boolean zza(com.google.android.gms.internal.measurement.zzbs.zzc.zza zza2, com.google.android.gms.internal.measurement.zzbs.zzc.zza zza3) {
        Object obj;
        Preconditions.checkArgument("_e".equals(zza2.getName()));
        zzgw();
        zze zza4 = zzjo.zza((zzc) ((zzey) zza2.zzug()), "_sc");
        String str = null;
        if (zza4 == null) {
            obj = null;
        } else {
            obj = zza4.zzmy();
        }
        zzgw();
        zze zza5 = zzjo.zza((zzc) ((zzey) zza3.zzug()), "_pc");
        if (zza5 != null) {
            str = zza5.zzmy();
        }
        if (str == null || !str.equals(obj)) {
            return false;
        }
        zzgw();
        String str2 = "_et";
        zze zza6 = zzjo.zza((zzc) ((zzey) zza2.zzug()), str2);
        if (zza6.zzna() && zza6.zznb() > 0) {
            long zznb = zza6.zznb();
            zzgw();
            zze zza7 = zzjo.zza((zzc) ((zzey) zza3.zzug()), str2);
            if (zza7 != null && zza7.zznb() > 0) {
                zznb += zza7.zznb();
            }
            zzgw();
            zzjo.zza(zza3, str2, (Object) Long.valueOf(zznb));
            zzgw();
            zzjo.zza(zza2, "_fr", (Object) Long.valueOf(1));
        }
        return true;
    }

    @VisibleForTesting
    private static void zza(com.google.android.gms.internal.measurement.zzbs.zzc.zza zza2, @NonNull String str) {
        List zzmj = zza2.zzmj();
        for (int i = 0; i < zzmj.size(); i++) {
            if (str.equals(((zze) zzmj.get(i)).getName())) {
                zza2.zzm(i);
                return;
            }
        }
    }

    @VisibleForTesting
    private static void zza(com.google.android.gms.internal.measurement.zzbs.zzc.zza zza2, int i, String str) {
        List zzmj = zza2.zzmj();
        int i2 = 0;
        while (true) {
            String str2 = "_err";
            if (i2 >= zzmj.size()) {
                zze zze = (zze) ((zzey) zze.zzng().zzbz("_ev").zzca(str).zzug());
                zza2.zza((zze) ((zzey) zze.zzng().zzbz(str2).zzam(Long.valueOf((long) i).longValue()).zzug())).zza(zze);
                return;
            } else if (!str2.equals(((zze) zzmj.get(i2)).getName())) {
                i2++;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: 0000 */
    @WorkerThread
    @VisibleForTesting
    public final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzx zzgy;
        zzo();
        zzjj();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zztd = false;
                zzjo();
                throw th2;
            }
        }
        List<Long> list = this.zzth;
        this.zzth = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                this.zzj.zzac().zzlj.set(this.zzj.zzx().currentTimeMillis());
                this.zzj.zzac().zzlk.set(0);
                zzjn();
                this.zzj.zzab().zzgs().zza("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzgy().beginTransaction();
                try {
                    for (Long l : list) {
                        try {
                            zzgy = zzgy();
                            long longValue = l.longValue();
                            zzgy.zzo();
                            zzgy.zzbi();
                            if (zzgy.getWritableDatabase().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zzgy.zzab().zzgk().zza("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            if (this.zzti == null || !this.zzti.contains(l)) {
                                throw e2;
                            }
                        }
                    }
                    zzgy().setTransactionSuccessful();
                    zzgy().endTransaction();
                    this.zzti = null;
                    if (!zzjf().zzgv() || !zzjm()) {
                        this.zztj = -1;
                        zzjn();
                    } else {
                        zzjl();
                    }
                    this.zzsy = 0;
                } catch (Throwable th3) {
                    zzgy().endTransaction();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                this.zzj.zzab().zzgk().zza("Database error while trying to delete uploaded bundles", e3);
                this.zzsy = this.zzj.zzx().elapsedRealtime();
                this.zzj.zzab().zzgs().zza("Disable upload, time", Long.valueOf(this.zzsy));
            }
        } else {
            this.zzj.zzab().zzgs().zza("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzj.zzac().zzlk.set(this.zzj.zzx().currentTimeMillis());
            if (i != 503) {
                if (i != 429) {
                    z = false;
                }
            }
            if (z) {
                this.zzj.zzac().zzll.set(this.zzj.zzx().currentTimeMillis());
            }
            zzgy().zzb(list);
            zzjn();
        }
        this.zztd = false;
        zzjo();
    }

    private final boolean zzjm() {
        zzo();
        zzjj();
        return zzgy().zzcd() || !TextUtils.isEmpty(zzgy().zzby());
    }

    @WorkerThread
    private final void zzb(zzf zzf) {
        zzo();
        if (!TextUtils.isEmpty(zzf.getGmpAppId()) || (zzs.zzbx() && !TextUtils.isEmpty(zzf.zzah()))) {
            zzs zzad = this.zzj.zzad();
            Builder builder = new Builder();
            String gmpAppId = zzf.getGmpAppId();
            if (TextUtils.isEmpty(gmpAppId) && zzs.zzbx()) {
                gmpAppId = zzf.zzah();
            }
            ArrayMap arrayMap = null;
            Builder encodedAuthority = builder.scheme((String) zzak.zzgj.get(null)).encodedAuthority((String) zzak.zzgk.get(null));
            String str = "config/app/";
            String valueOf = String.valueOf(gmpAppId);
            encodedAuthority.path(valueOf.length() != 0 ? str.concat(valueOf) : new String(str)).appendQueryParameter("app_instance_id", zzf.getAppInstanceId()).appendQueryParameter(TapjoyConstants.TJC_PLATFORM, "android").appendQueryParameter("gmp_version", String.valueOf(zzad.zzao()));
            String uri = builder.build().toString();
            try {
                URL url = new URL(uri);
                this.zzj.zzab().zzgs().zza("Fetching remote configuration", zzf.zzag());
                zzbw zzaw = zzgz().zzaw(zzf.zzag());
                String zzax = zzgz().zzax(zzf.zzag());
                if (zzaw != null && !TextUtils.isEmpty(zzax)) {
                    arrayMap = new ArrayMap();
                    arrayMap.put("If-Modified-Since", zzax);
                }
                ArrayMap arrayMap2 = arrayMap;
                this.zztc = true;
                zzej zzjf = zzjf();
                String zzag = zzf.zzag();
                zzjl zzjl = new zzjl(this);
                zzjf.zzo();
                zzjf.zzbi();
                Preconditions.checkNotNull(url);
                Preconditions.checkNotNull(zzjl);
                zzfc zzaa = zzjf.zzaa();
                zzen zzen = new zzen(zzjf, zzag, url, null, arrayMap2, zzjl);
                zzaa.zzb((Runnable) zzen);
            } catch (MalformedURLException unused) {
                this.zzj.zzab().zzgk().zza("Failed to parse config URL. Not fetching. appId", zzef.zzam(zzf.zzag()), uri);
            }
        } else {
            zzb(zzf.zzag(), 204, null, null, null);
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x013a A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x014a A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    @androidx.annotation.WorkerThread
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            r6 = this;
            r6.zzo()
            r6.zzjj()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            r0 = 0
            if (r10 != 0) goto L_0x000e
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x0196 }
        L_0x000e:
            com.google.android.gms.measurement.internal.zzfj r1 = r6.zzj     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzab()     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()     // Catch:{ all -> 0x0196 }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r10.length     // Catch:{ all -> 0x0196 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0196 }
            r1.zza(r2, r3)     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzx r1 = r6.zzgy()     // Catch:{ all -> 0x0196 }
            r1.beginTransaction()     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzx r1 = r6.zzgy()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzf r1 = r1.zzab(r7)     // Catch:{ all -> 0x018d }
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 304(0x130, float:4.26E-43)
            r4 = 1
            if (r8 == r2) goto L_0x003e
            r2 = 204(0xcc, float:2.86E-43)
            if (r8 == r2) goto L_0x003e
            if (r8 != r3) goto L_0x0042
        L_0x003e:
            if (r9 != 0) goto L_0x0042
            r2 = 1
            goto L_0x0043
        L_0x0042:
            r2 = 0
        L_0x0043:
            if (r1 != 0) goto L_0x005a
            com.google.android.gms.measurement.internal.zzfj r8 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzef r8 = r8.zzab()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzeh r8 = r8.zzgn()     // Catch:{ all -> 0x018d }
            java.lang.String r9 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzef.zzam(r7)     // Catch:{ all -> 0x018d }
            r8.zza(r9, r7)     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x005a:
            r5 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto L_0x00ca
            if (r8 != r5) goto L_0x0061
            goto L_0x00ca
        L_0x0061:
            com.google.android.gms.measurement.internal.zzfj r10 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r10 = r10.zzx()     // Catch:{ all -> 0x018d }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r1.zzm(r10)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzx r10 = r6.zzgy()     // Catch:{ all -> 0x018d }
            r10.zza(r1)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfj r10 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzab()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzgs()     // Catch:{ all -> 0x018d }
            java.lang.String r11 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x018d }
            r10.zza(r11, r1, r9)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfd r9 = r6.zzgz()     // Catch:{ all -> 0x018d }
            r9.zzay(r7)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfj r7 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzac()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzlk     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfj r9 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r9 = r9.zzx()     // Catch:{ all -> 0x018d }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r7.set(r9)     // Catch:{ all -> 0x018d }
            r7 = 503(0x1f7, float:7.05E-43)
            if (r8 == r7) goto L_0x00ae
            r7 = 429(0x1ad, float:6.01E-43)
            if (r8 != r7) goto L_0x00ad
            goto L_0x00ae
        L_0x00ad:
            r4 = 0
        L_0x00ae:
            if (r4 == 0) goto L_0x00c5
            com.google.android.gms.measurement.internal.zzfj r7 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzac()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzll     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfj r8 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r8 = r8.zzx()     // Catch:{ all -> 0x018d }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r7.set(r8)     // Catch:{ all -> 0x018d }
        L_0x00c5:
            r6.zzjn()     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x00ca:
            r9 = 0
            if (r11 == 0) goto L_0x00d6
            java.lang.String r2 = "Last-Modified"
            java.lang.Object r11 = r11.get(r2)     // Catch:{ all -> 0x018d }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x018d }
            goto L_0x00d7
        L_0x00d6:
            r11 = r9
        L_0x00d7:
            if (r11 == 0) goto L_0x00e6
            int r2 = r11.size()     // Catch:{ all -> 0x018d }
            if (r2 <= 0) goto L_0x00e6
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x018d }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x018d }
            goto L_0x00e7
        L_0x00e6:
            r11 = r9
        L_0x00e7:
            if (r8 == r5) goto L_0x0103
            if (r8 != r3) goto L_0x00ec
            goto L_0x0103
        L_0x00ec:
            com.google.android.gms.measurement.internal.zzfd r9 = r6.zzgz()     // Catch:{ all -> 0x018d }
            boolean r9 = r9.zza(r7, r10, r11)     // Catch:{ all -> 0x018d }
            if (r9 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzx r7 = r6.zzgy()     // Catch:{ all -> 0x0196 }
            r7.endTransaction()     // Catch:{ all -> 0x0196 }
            r6.zztc = r0
            r6.zzjo()
            return
        L_0x0103:
            com.google.android.gms.measurement.internal.zzfd r11 = r6.zzgz()     // Catch:{ all -> 0x018d }
            com.google.android.gms.internal.measurement.zzbw r11 = r11.zzaw(r7)     // Catch:{ all -> 0x018d }
            if (r11 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzfd r11 = r6.zzgz()     // Catch:{ all -> 0x018d }
            boolean r9 = r11.zza(r7, r9, r9)     // Catch:{ all -> 0x018d }
            if (r9 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzx r7 = r6.zzgy()     // Catch:{ all -> 0x0196 }
            r7.endTransaction()     // Catch:{ all -> 0x0196 }
            r6.zztc = r0
            r6.zzjo()
            return
        L_0x0124:
            com.google.android.gms.measurement.internal.zzfj r9 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r9 = r9.zzx()     // Catch:{ all -> 0x018d }
            long r2 = r9.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r1.zzl(r2)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzx r9 = r6.zzgy()     // Catch:{ all -> 0x018d }
            r9.zza(r1)     // Catch:{ all -> 0x018d }
            if (r8 != r5) goto L_0x014a
            com.google.android.gms.measurement.internal.zzfj r8 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzef r8 = r8.zzab()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzeh r8 = r8.zzgp()     // Catch:{ all -> 0x018d }
            java.lang.String r9 = "Config not found. Using empty config. appId"
            r8.zza(r9, r7)     // Catch:{ all -> 0x018d }
            goto L_0x0162
        L_0x014a:
            com.google.android.gms.measurement.internal.zzfj r7 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzab()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgs()     // Catch:{ all -> 0x018d }
            java.lang.String r9 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x018d }
            int r10 = r10.length     // Catch:{ all -> 0x018d }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x018d }
            r7.zza(r9, r8, r10)     // Catch:{ all -> 0x018d }
        L_0x0162:
            com.google.android.gms.measurement.internal.zzej r7 = r6.zzjf()     // Catch:{ all -> 0x018d }
            boolean r7 = r7.zzgv()     // Catch:{ all -> 0x018d }
            if (r7 == 0) goto L_0x0176
            boolean r7 = r6.zzjm()     // Catch:{ all -> 0x018d }
            if (r7 == 0) goto L_0x0176
            r6.zzjl()     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x0176:
            r6.zzjn()     // Catch:{ all -> 0x018d }
        L_0x0179:
            com.google.android.gms.measurement.internal.zzx r7 = r6.zzgy()     // Catch:{ all -> 0x018d }
            r7.setTransactionSuccessful()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzx r7 = r6.zzgy()     // Catch:{ all -> 0x0196 }
            r7.endTransaction()     // Catch:{ all -> 0x0196 }
            r6.zztc = r0
            r6.zzjo()
            return
        L_0x018d:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzx r8 = r6.zzgy()     // Catch:{ all -> 0x0196 }
            r8.endTransaction()     // Catch:{ all -> 0x0196 }
            throw r7     // Catch:{ all -> 0x0196 }
        L_0x0196:
            r7 = move-exception
            r6.zztc = r0
            r6.zzjo()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjg.zzb(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01c0  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzjn() {
        /*
            r21 = this;
            r0 = r21
            r21.zzo()
            r21.zzjj()
            boolean r1 = r21.zzjr()
            if (r1 != 0) goto L_0x001d
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzs r1 = r1.zzad()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzak.zzim
            boolean r1 = r1.zza(r2)
            if (r1 != 0) goto L_0x001d
            return
        L_0x001d:
            long r1 = r0.zzsy
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0062
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.common.util.Clock r1 = r1.zzx()
            long r1 = r1.elapsedRealtime()
            r5 = 3600000(0x36ee80, double:1.7786363E-317)
            long r7 = r0.zzsy
            long r1 = r1 - r7
            long r1 = java.lang.Math.abs(r1)
            long r5 = r5 - r1
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0060
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            java.lang.Long r2 = java.lang.Long.valueOf(r5)
            java.lang.String r3 = "Upload has been suspended. Will update scheduling later in approximately ms"
            r1.zza(r3, r2)
            com.google.android.gms.measurement.internal.zzem r1 = r21.zzjg()
            r1.unregister()
            com.google.android.gms.measurement.internal.zzjc r1 = r21.zzjh()
            r1.cancel()
            return
        L_0x0060:
            r0.zzsy = r3
        L_0x0062:
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            boolean r1 = r1.zzie()
            if (r1 == 0) goto L_0x026b
            boolean r1 = r21.zzjm()
            if (r1 != 0) goto L_0x0072
            goto L_0x026b
        L_0x0072:
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.common.util.Clock r1 = r1.zzx()
            long r1 = r1.currentTimeMillis()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzak.zzhf
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.zzx r5 = r21.zzgy()
            boolean r5 = r5.zzce()
            if (r5 != 0) goto L_0x00a4
            com.google.android.gms.measurement.internal.zzx r5 = r21.zzgy()
            boolean r5 = r5.zzbz()
            if (r5 == 0) goto L_0x00a2
            goto L_0x00a4
        L_0x00a2:
            r5 = 0
            goto L_0x00a5
        L_0x00a4:
            r5 = 1
        L_0x00a5:
            if (r5 == 0) goto L_0x00e1
            com.google.android.gms.measurement.internal.zzfj r10 = r0.zzj
            com.google.android.gms.measurement.internal.zzs r10 = r10.zzad()
            java.lang.String r10 = r10.zzbu()
            boolean r11 = android.text.TextUtils.isEmpty(r10)
            if (r11 != 0) goto L_0x00d0
            java.lang.String r11 = ".none."
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L_0x00d0
            com.google.android.gms.measurement.internal.zzdu<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzak.zzha
            java.lang.Object r10 = r10.get(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
            goto L_0x00f1
        L_0x00d0:
            com.google.android.gms.measurement.internal.zzdu<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzak.zzgz
            java.lang.Object r10 = r10.get(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
            goto L_0x00f1
        L_0x00e1:
            com.google.android.gms.measurement.internal.zzdu<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzak.zzgy
            java.lang.Object r10 = r10.get(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
        L_0x00f1:
            com.google.android.gms.measurement.internal.zzfj r12 = r0.zzj
            com.google.android.gms.measurement.internal.zzeo r12 = r12.zzac()
            com.google.android.gms.measurement.internal.zzet r12 = r12.zzlj
            long r12 = r12.get()
            com.google.android.gms.measurement.internal.zzfj r14 = r0.zzj
            com.google.android.gms.measurement.internal.zzeo r14 = r14.zzac()
            com.google.android.gms.measurement.internal.zzet r14 = r14.zzlk
            long r14 = r14.get()
            com.google.android.gms.measurement.internal.zzx r16 = r21.zzgy()
            r17 = r10
            long r9 = r16.zzcb()
            com.google.android.gms.measurement.internal.zzx r11 = r21.zzgy()
            r19 = r7
            long r6 = r11.zzcc()
            long r6 = java.lang.Math.max(r9, r6)
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 != 0) goto L_0x0128
        L_0x0125:
            r8 = r3
            goto L_0x019e
        L_0x0128:
            long r6 = r6 - r1
            long r6 = java.lang.Math.abs(r6)
            long r6 = r1 - r6
            long r12 = r12 - r1
            long r8 = java.lang.Math.abs(r12)
            long r8 = r1 - r8
            long r14 = r14 - r1
            long r10 = java.lang.Math.abs(r14)
            long r1 = r1 - r10
            long r8 = java.lang.Math.max(r8, r1)
            long r10 = r6 + r19
            if (r5 == 0) goto L_0x014e
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x014e
            long r10 = java.lang.Math.min(r6, r8)
            long r10 = r10 + r17
        L_0x014e:
            com.google.android.gms.measurement.internal.zzjo r5 = r21.zzgw()
            r12 = r17
            boolean r5 = r5.zzb(r8, r12)
            if (r5 != 0) goto L_0x015c
            long r8 = r8 + r12
            goto L_0x015d
        L_0x015c:
            r8 = r10
        L_0x015d:
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x019e
            int r5 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r5 < 0) goto L_0x019e
            r5 = 0
        L_0x0166:
            r6 = 20
            com.google.android.gms.measurement.internal.zzdu<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzak.zzhh
            r10 = 0
            java.lang.Object r7 = r7.get(r10)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r11 = 0
            int r7 = java.lang.Math.max(r11, r7)
            int r6 = java.lang.Math.min(r6, r7)
            if (r5 >= r6) goto L_0x0125
            r6 = 1
            long r6 = r6 << r5
            com.google.android.gms.measurement.internal.zzdu<java.lang.Long> r12 = com.google.android.gms.measurement.internal.zzak.zzhg
            java.lang.Object r12 = r12.get(r10)
            java.lang.Long r12 = (java.lang.Long) r12
            long r12 = r12.longValue()
            long r12 = java.lang.Math.max(r3, r12)
            long r12 = r12 * r6
            long r8 = r8 + r12
            int r6 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x019b
            goto L_0x019e
        L_0x019b:
            int r5 = r5 + 1
            goto L_0x0166
        L_0x019e:
            int r1 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x01c0
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            java.lang.String r2 = "Next upload time is 0"
            r1.zzao(r2)
            com.google.android.gms.measurement.internal.zzem r1 = r21.zzjg()
            r1.unregister()
            com.google.android.gms.measurement.internal.zzjc r1 = r21.zzjh()
            r1.cancel()
            return
        L_0x01c0:
            com.google.android.gms.measurement.internal.zzej r1 = r21.zzjf()
            boolean r1 = r1.zzgv()
            if (r1 != 0) goto L_0x01e8
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            java.lang.String r2 = "No network"
            r1.zzao(r2)
            com.google.android.gms.measurement.internal.zzem r1 = r21.zzjg()
            r1.zzha()
            com.google.android.gms.measurement.internal.zzjc r1 = r21.zzjh()
            r1.cancel()
            return
        L_0x01e8:
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzeo r1 = r1.zzac()
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzll
            long r1 = r1.get()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzak.zzgw
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzjo r7 = r21.zzgw()
            boolean r7 = r7.zzb(r1, r5)
            if (r7 != 0) goto L_0x0214
            long r1 = r1 + r5
            long r8 = java.lang.Math.max(r8, r1)
        L_0x0214:
            com.google.android.gms.measurement.internal.zzem r1 = r21.zzjg()
            r1.unregister()
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.common.util.Clock r1 = r1.zzx()
            long r1 = r1.currentTimeMillis()
            long r8 = r8 - r1
            int r1 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0250
            com.google.android.gms.measurement.internal.zzdu<java.lang.Long> r1 = com.google.android.gms.measurement.internal.zzak.zzhb
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r8 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzeo r1 = r1.zzac()
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzlj
            com.google.android.gms.measurement.internal.zzfj r2 = r0.zzj
            com.google.android.gms.common.util.Clock r2 = r2.zzx()
            long r2 = r2.currentTimeMillis()
            r1.set(r2)
        L_0x0250:
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            java.lang.Long r2 = java.lang.Long.valueOf(r8)
            java.lang.String r3 = "Upload scheduled in approximately ms"
            r1.zza(r3, r2)
            com.google.android.gms.measurement.internal.zzjc r1 = r21.zzjh()
            r1.zzv(r8)
            return
        L_0x026b:
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.zzao(r2)
            com.google.android.gms.measurement.internal.zzem r1 = r21.zzjg()
            r1.unregister()
            com.google.android.gms.measurement.internal.zzjc r1 = r21.zzjh()
            r1.cancel()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjg.zzjn():void");
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzf(Runnable runnable) {
        zzo();
        if (this.zzsz == null) {
            this.zzsz = new ArrayList();
        }
        this.zzsz.add(runnable);
    }

    @WorkerThread
    private final void zzjo() {
        zzo();
        if (this.zztc || this.zztd || this.zzte) {
            this.zzj.zzab().zzgs().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zztc), Boolean.valueOf(this.zztd), Boolean.valueOf(this.zzte));
            return;
        }
        this.zzj.zzab().zzgs().zzao("Stopping uploading service(s)");
        List<Runnable> list = this.zzsz;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            this.zzsz.clear();
        }
    }

    @WorkerThread
    private final Boolean zzc(zzf zzf) {
        try {
            if (zzf.zzam() != -2147483648L) {
                if (zzf.zzam() == ((long) Wrappers.packageManager(this.zzj.getContext()).getPackageInfo(zzf.zzag(), 0).versionCode)) {
                    return Boolean.valueOf(true);
                }
            } else {
                String str = Wrappers.packageManager(this.zzj.getContext()).getPackageInfo(zzf.zzag(), 0).versionName;
                if (zzf.zzal() != null && zzf.zzal().equals(str)) {
                    return Boolean.valueOf(true);
                }
            }
            return Boolean.valueOf(false);
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final boolean zzjp() {
        zzo();
        String str = "Storage concurrent access okay";
        if (this.zzj.zzad().zza(zzak.zzjh)) {
            FileLock fileLock = this.zztf;
            if (fileLock != null && fileLock.isValid()) {
                this.zzj.zzab().zzgs().zzao(str);
                return true;
            }
        }
        try {
            this.zztg = new RandomAccessFile(new File(this.zzj.getContext().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.zztf = this.zztg.tryLock();
            if (this.zztf != null) {
                this.zzj.zzab().zzgs().zzao(str);
                return true;
            }
            this.zzj.zzab().zzgk().zzao("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            this.zzj.zzab().zzgk().zza("Failed to acquire storage lock", e);
        } catch (IOException e2) {
            this.zzj.zzab().zzgk().zza("Failed to access storage lock file", e2);
        } catch (OverlappingFileLockException e3) {
            this.zzj.zzab().zzgn().zza("Storage lock already acquired", e3);
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final int zza(FileChannel fileChannel) {
        zzo();
        int i = 0;
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzab().zzgk().zzao("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    this.zzj.zzab().zzgn().zza("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            i = allocate.getInt();
            return i;
        } catch (IOException e) {
            this.zzj.zzab().zzgk().zza("Failed to read from channel", e);
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final boolean zza(int i, FileChannel fileChannel) {
        zzo();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzab().zzgk().zzao("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.zzj.zzab().zzgk().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.zzj.zzab().zzgk().zza("Failed to write to channel", e);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzjq() {
        zzo();
        zzjj();
        if (!this.zzsx) {
            this.zzsx = true;
            zzo();
            zzjj();
            if ((this.zzj.zzad().zza(zzak.zzim) || zzjr()) && zzjp()) {
                int zza2 = zza(this.zztg);
                int zzgf = this.zzj.zzr().zzgf();
                zzo();
                if (zza2 > zzgf) {
                    this.zzj.zzab().zzgk().zza("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzgf));
                } else if (zza2 < zzgf) {
                    if (zza(zzgf, this.zztg)) {
                        this.zzj.zzab().zzgs().zza("Storage version upgraded. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzgf));
                    } else {
                        this.zzj.zzab().zzgk().zza("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzgf));
                    }
                }
            }
        }
        if (!this.zzsw && !this.zzj.zzad().zza(zzak.zzim)) {
            this.zzj.zzab().zzgq().zzao("This instance being marked as an uploader");
            this.zzsw = true;
            zzjn();
        }
    }

    @WorkerThread
    private final boolean zzjr() {
        zzo();
        zzjj();
        return this.zzsw;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    @VisibleForTesting
    public final void zzd(zzn zzn) {
        String str = "app_id=?";
        if (this.zzth != null) {
            this.zzti = new ArrayList();
            this.zzti.addAll(this.zzth);
        }
        zzx zzgy = zzgy();
        String str2 = zzn.packageName;
        Preconditions.checkNotEmpty(str2);
        zzgy.zzo();
        zzgy.zzbi();
        try {
            SQLiteDatabase writableDatabase = zzgy.getWritableDatabase();
            String[] strArr = {str2};
            int delete = writableDatabase.delete("apps", str, strArr) + 0 + writableDatabase.delete("events", str, strArr) + writableDatabase.delete("user_attributes", str, strArr) + writableDatabase.delete("conditional_properties", str, strArr) + writableDatabase.delete("raw_events", str, strArr) + writableDatabase.delete("raw_events_metadata", str, strArr) + writableDatabase.delete("queue", str, strArr) + writableDatabase.delete("audience_filter_values", str, strArr) + writableDatabase.delete("main_event_params", str, strArr);
            if (delete > 0) {
                zzgy.zzab().zzgs().zza("Reset analytics data. app, records", str2, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzgy.zzab().zzgk().zza("Error resetting analytics data. appId, error", zzef.zzam(str2), e);
        }
        zzn zza2 = zza(this.zzj.getContext(), zzn.packageName, zzn.zzcg, zzn.zzcq, zzn.zzcs, zzn.zzct, zzn.zzdr, zzn.zzcu);
        if (zzn.zzcq) {
            zzf(zza2);
        }
    }

    private final zzn zza(Context context, String str, String str2, boolean z, boolean z2, boolean z3, long j, String str3) {
        String str4;
        String str5;
        int i;
        String str6 = str;
        String str7 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            this.zzj.zzab().zzgk().zzao("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            str4 = packageManager.getInstallerPackageName(str6);
        } catch (IllegalArgumentException unused) {
            this.zzj.zzab().zzgk().zza("Error retrieving installer package name. appId", zzef.zzam(str));
            str4 = str7;
        }
        if (str4 == null) {
            str4 = "manual_install";
        } else if ("com.android.vending".equals(str4)) {
            str4 = "";
        }
        String str8 = str4;
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str6, 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = Wrappers.packageManager(context).getApplicationLabel(str6);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    String charSequence = applicationLabel.toString();
                }
                String str9 = packageInfo.versionName;
                i = packageInfo.versionCode;
                str5 = str9;
            } else {
                i = Integer.MIN_VALUE;
                str5 = str7;
            }
            this.zzj.zzae();
            zzn zzn = new zzn(str, str2, str5, (long) i, str8, this.zzj.zzad().zzao(), this.zzj.zzz().zzc(context, str6), (String) null, z, false, "", 0, this.zzj.zzad().zzr(str6) ? j : 0, 0, z2, z3, false, str3, (Boolean) null, 0, null);
            return zzn;
        } catch (NameNotFoundException unused2) {
            this.zzj.zzab().zzgk().zza("Error retrieving newly installed package info. appId, appName", zzef.zzam(str), str7);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzb(zzjn zzjn, zzn zzn) {
        zzo();
        zzjj();
        if (TextUtils.isEmpty(zzn.zzcg) && TextUtils.isEmpty(zzn.zzcu)) {
            return;
        }
        if (!zzn.zzcq) {
            zzg(zzn);
            return;
        }
        int zzbm = this.zzj.zzz().zzbm(zzjn.name);
        if (zzbm != 0) {
            this.zzj.zzz();
            this.zzj.zzz().zza(zzn.packageName, zzbm, "_ev", zzjs.zza(zzjn.name, 24, true), zzjn.name != null ? zzjn.name.length() : 0);
            return;
        }
        int zzc = this.zzj.zzz().zzc(zzjn.name, zzjn.getValue());
        if (zzc != 0) {
            this.zzj.zzz();
            String zza2 = zzjs.zza(zzjn.name, 24, true);
            Object value = zzjn.getValue();
            this.zzj.zzz().zza(zzn.packageName, zzc, "_ev", zza2, (value == null || (!(value instanceof String) && !(value instanceof CharSequence))) ? 0 : String.valueOf(value).length());
            return;
        }
        Object zzd = this.zzj.zzz().zzd(zzjn.name, zzjn.getValue());
        if (zzd != null) {
            if ("_sid".equals(zzjn.name) && this.zzj.zzad().zzw(zzn.packageName)) {
                long j = zzjn.zztr;
                String str = zzjn.origin;
                long j2 = 0;
                zzjp zze = zzgy().zze(zzn.packageName, "_sno");
                if (zze == null || !(zze.value instanceof Long)) {
                    if (zze != null) {
                        this.zzj.zzab().zzgn().zza("Retrieved last session number from database does not contain a valid (long) value", zze.value);
                    }
                    if (this.zzj.zzad().zze(zzn.packageName, zzak.zzie)) {
                        zzae zzc2 = zzgy().zzc(zzn.packageName, "_s");
                        if (zzc2 != null) {
                            j2 = zzc2.zzfg;
                            this.zzj.zzab().zzgs().zza("Backfill the session number. Last used session number", Long.valueOf(j2));
                        }
                    }
                } else {
                    j2 = ((Long) zze.value).longValue();
                }
                zzjn zzjn2 = new zzjn("_sno", j, Long.valueOf(j2 + 1), str);
                zzb(zzjn2, zzn);
            }
            zzjp zzjp = new zzjp(zzn.packageName, zzjn.origin, zzjn.name, zzjn.zztr, zzd);
            this.zzj.zzab().zzgr().zza("Setting user property", this.zzj.zzy().zzal(zzjp.name), zzd);
            zzgy().beginTransaction();
            try {
                zzg(zzn);
                boolean zza3 = zzgy().zza(zzjp);
                zzgy().setTransactionSuccessful();
                if (zza3) {
                    this.zzj.zzab().zzgr().zza("User property set", this.zzj.zzy().zzal(zzjp.name), zzjp.value);
                } else {
                    this.zzj.zzab().zzgk().zza("Too many unique user properties are set. Ignoring user property", this.zzj.zzy().zzal(zzjp.name), zzjp.value);
                    this.zzj.zzz().zza(zzn.packageName, 9, (String) null, (String) null, 0);
                }
            } finally {
                zzgy().endTransaction();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzc(zzjn zzjn, zzn zzn) {
        zzo();
        zzjj();
        if (TextUtils.isEmpty(zzn.zzcg) && TextUtils.isEmpty(zzn.zzcu)) {
            return;
        }
        if (!zzn.zzcq) {
            zzg(zzn);
            return;
        }
        String str = "User property removed";
        String str2 = "Removing user property";
        if (this.zzj.zzad().zze(zzn.packageName, zzak.zzij)) {
            if (!"_npa".equals(zzjn.name) || zzn.zzcv == null) {
                this.zzj.zzab().zzgr().zza(str2, this.zzj.zzy().zzal(zzjn.name));
                zzgy().beginTransaction();
                try {
                    zzg(zzn);
                    zzgy().zzd(zzn.packageName, zzjn.name);
                    zzgy().setTransactionSuccessful();
                    this.zzj.zzab().zzgr().zza(str, this.zzj.zzy().zzal(zzjn.name));
                } finally {
                    zzgy().endTransaction();
                }
            } else {
                this.zzj.zzab().zzgr().zzao("Falling back to manifest metadata value for ad personalization");
                zzjn zzjn2 = new zzjn("_npa", this.zzj.zzx().currentTimeMillis(), Long.valueOf(zzn.zzcv.booleanValue() ? 1 : 0), "auto");
                zzb(zzjn2, zzn);
            }
        } else {
            this.zzj.zzab().zzgr().zza(str2, this.zzj.zzy().zzal(zzjn.name));
            zzgy().beginTransaction();
            try {
                zzg(zzn);
                zzgy().zzd(zzn.packageName, zzjn.name);
                zzgy().setTransactionSuccessful();
                this.zzj.zzab().zzgr().zza(str, this.zzj.zzy().zzal(zzjn.name));
            } finally {
                zzgy().endTransaction();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(zzjh zzjh) {
        this.zzta++;
    }

    /* access modifiers changed from: 0000 */
    public final void zzjs() {
        this.zztb++;
    }

    /* access modifiers changed from: 0000 */
    public final zzfj zzjt() {
        return this.zzj;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x04a7 A[Catch:{ NameNotFoundException -> 0x0347, all -> 0x04d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0140 A[Catch:{ NameNotFoundException -> 0x0347, all -> 0x04d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01f5 A[Catch:{ NameNotFoundException -> 0x0347, all -> 0x04d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0266 A[Catch:{ NameNotFoundException -> 0x0347, all -> 0x04d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0273 A[Catch:{ NameNotFoundException -> 0x0347, all -> 0x04d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0285 A[Catch:{ NameNotFoundException -> 0x0347, all -> 0x04d2 }] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf(com.google.android.gms.measurement.internal.zzn r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            java.lang.String r3 = "_sys"
            java.lang.String r4 = "_pfo"
            java.lang.String r5 = "_uwa"
            java.lang.String r0 = "app_id=?"
            r21.zzo()
            r21.zzjj()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r22)
            java.lang.String r6 = r2.packageName
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r6)
            java.lang.String r6 = r2.zzcg
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L_0x002b
            java.lang.String r6 = r2.zzcu
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L_0x002b
            return
        L_0x002b:
            com.google.android.gms.measurement.internal.zzx r6 = r21.zzgy()
            java.lang.String r7 = r2.packageName
            com.google.android.gms.measurement.internal.zzf r6 = r6.zzab(r7)
            r7 = 0
            if (r6 == 0) goto L_0x005e
            java.lang.String r9 = r6.getGmpAppId()
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 == 0) goto L_0x005e
            java.lang.String r9 = r2.zzcg
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x005e
            r6.zzl(r7)
            com.google.android.gms.measurement.internal.zzx r9 = r21.zzgy()
            r9.zza(r6)
            com.google.android.gms.measurement.internal.zzfd r6 = r21.zzgz()
            java.lang.String r9 = r2.packageName
            r6.zzaz(r9)
        L_0x005e:
            boolean r6 = r2.zzcq
            if (r6 != 0) goto L_0x0066
            r21.zzg(r22)
            return
        L_0x0066:
            long r9 = r2.zzdr
            int r6 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x0076
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj
            com.google.android.gms.common.util.Clock r6 = r6.zzx()
            long r9 = r6.currentTimeMillis()
        L_0x0076:
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzad()
            java.lang.String r11 = r2.packageName
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzak.zzij
            boolean r6 = r6.zze(r11, r12)
            if (r6 == 0) goto L_0x008f
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj
            com.google.android.gms.measurement.internal.zzac r6 = r6.zzw()
            r6.zzct()
        L_0x008f:
            int r6 = r2.zzds
            r15 = 0
            r13 = 1
            if (r6 == 0) goto L_0x00b1
            if (r6 == r13) goto L_0x00b1
            com.google.android.gms.measurement.internal.zzfj r11 = r1.zzj
            com.google.android.gms.measurement.internal.zzef r11 = r11.zzab()
            com.google.android.gms.measurement.internal.zzeh r11 = r11.zzgn()
            java.lang.String r12 = r2.packageName
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzef.zzam(r12)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r14 = "Incorrect app type, assuming installed app. appId, appType"
            r11.zza(r14, r12, r6)
            r6 = 0
        L_0x00b1:
            com.google.android.gms.measurement.internal.zzx r11 = r21.zzgy()
            r11.beginTransaction()
            com.google.android.gms.measurement.internal.zzfj r11 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzs r11 = r11.zzad()     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = r2.packageName     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzak.zzij     // Catch:{ all -> 0x04d2 }
            boolean r11 = r11.zze(r12, r14)     // Catch:{ all -> 0x04d2 }
            if (r11 == 0) goto L_0x0131
            com.google.android.gms.measurement.internal.zzx r11 = r21.zzgy()     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = r2.packageName     // Catch:{ all -> 0x04d2 }
            java.lang.String r14 = "_npa"
            com.google.android.gms.measurement.internal.zzjp r14 = r11.zze(r12, r14)     // Catch:{ all -> 0x04d2 }
            if (r14 == 0) goto L_0x00e0
            java.lang.String r11 = "auto"
            java.lang.String r12 = r14.origin     // Catch:{ all -> 0x04d2 }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x04d2 }
            if (r11 == 0) goto L_0x0131
        L_0x00e0:
            java.lang.Boolean r11 = r2.zzcv     // Catch:{ all -> 0x04d2 }
            if (r11 == 0) goto L_0x011b
            com.google.android.gms.measurement.internal.zzjn r12 = new com.google.android.gms.measurement.internal.zzjn     // Catch:{ all -> 0x04d2 }
            java.lang.String r16 = "_npa"
            java.lang.Boolean r11 = r2.zzcv     // Catch:{ all -> 0x04d2 }
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x04d2 }
            if (r11 == 0) goto L_0x00f3
            r17 = 1
            goto L_0x00f5
        L_0x00f3:
            r17 = 0
        L_0x00f5:
            java.lang.Long r17 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x04d2 }
            java.lang.String r18 = "auto"
            r11 = r12
            r7 = r12
            r12 = r16
            r19 = r3
            r8 = r14
            r3 = 1
            r13 = r9
            r15 = r17
            r16 = r18
            r11.<init>(r12, r13, r15, r16)     // Catch:{ all -> 0x04d2 }
            if (r8 == 0) goto L_0x0117
            java.lang.Object r8 = r8.value     // Catch:{ all -> 0x04d2 }
            java.lang.Long r11 = r7.zzts     // Catch:{ all -> 0x04d2 }
            boolean r8 = r8.equals(r11)     // Catch:{ all -> 0x04d2 }
            if (r8 != 0) goto L_0x0134
        L_0x0117:
            r1.zzb(r7, r2)     // Catch:{ all -> 0x04d2 }
            goto L_0x0134
        L_0x011b:
            r19 = r3
            r8 = r14
            r3 = 1
            if (r8 == 0) goto L_0x0134
            com.google.android.gms.measurement.internal.zzjn r7 = new com.google.android.gms.measurement.internal.zzjn     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_npa"
            r15 = 0
            java.lang.String r16 = "auto"
            r11 = r7
            r13 = r9
            r11.<init>(r12, r13, r15, r16)     // Catch:{ all -> 0x04d2 }
            r1.zzc(r7, r2)     // Catch:{ all -> 0x04d2 }
            goto L_0x0134
        L_0x0131:
            r19 = r3
            r3 = 1
        L_0x0134:
            com.google.android.gms.measurement.internal.zzx r7 = r21.zzgy()     // Catch:{ all -> 0x04d2 }
            java.lang.String r8 = r2.packageName     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzf r7 = r7.zzab(r8)     // Catch:{ all -> 0x04d2 }
            if (r7 == 0) goto L_0x01f2
            com.google.android.gms.measurement.internal.zzfj r11 = r1.zzj     // Catch:{ all -> 0x04d2 }
            r11.zzz()     // Catch:{ all -> 0x04d2 }
            java.lang.String r11 = r2.zzcg     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = r7.getGmpAppId()     // Catch:{ all -> 0x04d2 }
            java.lang.String r13 = r2.zzcu     // Catch:{ all -> 0x04d2 }
            java.lang.String r14 = r7.zzah()     // Catch:{ all -> 0x04d2 }
            boolean r11 = com.google.android.gms.measurement.internal.zzjs.zza(r11, r12, r13, r14)     // Catch:{ all -> 0x04d2 }
            if (r11 == 0) goto L_0x01f2
            com.google.android.gms.measurement.internal.zzfj r11 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzef r11 = r11.zzab()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzeh r11 = r11.zzgn()     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r13 = r7.zzag()     // Catch:{ all -> 0x04d2 }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzef.zzam(r13)     // Catch:{ all -> 0x04d2 }
            r11.zza(r12, r13)     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzx r11 = r21.zzgy()     // Catch:{ all -> 0x04d2 }
            java.lang.String r7 = r7.zzag()     // Catch:{ all -> 0x04d2 }
            r11.zzbi()     // Catch:{ all -> 0x04d2 }
            r11.zzo()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)     // Catch:{ all -> 0x04d2 }
            android.database.sqlite.SQLiteDatabase r12 = r11.getWritableDatabase()     // Catch:{ SQLiteException -> 0x01dd }
            java.lang.String[] r13 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x01dd }
            r15 = 0
            r13[r15] = r7     // Catch:{ SQLiteException -> 0x01db }
            java.lang.String r14 = "events"
            int r14 = r12.delete(r14, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r15
            java.lang.String r8 = "user_attributes"
            int r8 = r12.delete(r8, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r8
            java.lang.String r8 = "conditional_properties"
            int r8 = r12.delete(r8, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r8
            java.lang.String r8 = "apps"
            int r8 = r12.delete(r8, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r8
            java.lang.String r8 = "raw_events"
            int r8 = r12.delete(r8, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r8
            java.lang.String r8 = "raw_events_metadata"
            int r8 = r12.delete(r8, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r8
            java.lang.String r8 = "event_filters"
            int r8 = r12.delete(r8, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r8
            java.lang.String r8 = "property_filters"
            int r8 = r12.delete(r8, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r8
            java.lang.String r8 = "audience_filter_values"
            int r0 = r12.delete(r8, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r0
            if (r14 <= 0) goto L_0x01f0
            com.google.android.gms.measurement.internal.zzef r0 = r11.zzab()     // Catch:{ SQLiteException -> 0x01db }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgs()     // Catch:{ SQLiteException -> 0x01db }
            java.lang.String r8 = "Deleted application data. app, records"
            java.lang.Integer r12 = java.lang.Integer.valueOf(r14)     // Catch:{ SQLiteException -> 0x01db }
            r0.zza(r8, r7, r12)     // Catch:{ SQLiteException -> 0x01db }
            goto L_0x01f0
        L_0x01db:
            r0 = move-exception
            goto L_0x01df
        L_0x01dd:
            r0 = move-exception
            r15 = 0
        L_0x01df:
            com.google.android.gms.measurement.internal.zzef r8 = r11.zzab()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzeh r8 = r8.zzgk()     // Catch:{ all -> 0x04d2 }
            java.lang.String r11 = "Error deleting application data. appId, error"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzef.zzam(r7)     // Catch:{ all -> 0x04d2 }
            r8.zza(r11, r7, r0)     // Catch:{ all -> 0x04d2 }
        L_0x01f0:
            r7 = 0
            goto L_0x01f3
        L_0x01f2:
            r15 = 0
        L_0x01f3:
            if (r7 == 0) goto L_0x0260
            long r11 = r7.zzam()     // Catch:{ all -> 0x04d2 }
            r13 = -2147483648(0xffffffff80000000, double:NaN)
            java.lang.String r0 = "_pv"
            int r8 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r8 == 0) goto L_0x022d
            long r11 = r7.zzam()     // Catch:{ all -> 0x04d2 }
            long r13 = r2.zzcn     // Catch:{ all -> 0x04d2 }
            int r8 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r8 == 0) goto L_0x0260
            android.os.Bundle r8 = new android.os.Bundle     // Catch:{ all -> 0x04d2 }
            r8.<init>()     // Catch:{ all -> 0x04d2 }
            java.lang.String r7 = r7.zzal()     // Catch:{ all -> 0x04d2 }
            r8.putString(r0, r7)     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzai r0 = new com.google.android.gms.measurement.internal.zzai     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_au"
            com.google.android.gms.measurement.internal.zzah r13 = new com.google.android.gms.measurement.internal.zzah     // Catch:{ all -> 0x04d2 }
            r13.<init>(r8)     // Catch:{ all -> 0x04d2 }
            java.lang.String r14 = "auto"
            r11 = r0
            r8 = 0
            r15 = r9
            r11.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x04d2 }
            r1.zzc(r0, r2)     // Catch:{ all -> 0x04d2 }
            goto L_0x0261
        L_0x022d:
            r8 = 0
            java.lang.String r11 = r7.zzal()     // Catch:{ all -> 0x04d2 }
            if (r11 == 0) goto L_0x0261
            java.lang.String r11 = r7.zzal()     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = r2.zzcm     // Catch:{ all -> 0x04d2 }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x04d2 }
            if (r11 != 0) goto L_0x0261
            android.os.Bundle r11 = new android.os.Bundle     // Catch:{ all -> 0x04d2 }
            r11.<init>()     // Catch:{ all -> 0x04d2 }
            java.lang.String r7 = r7.zzal()     // Catch:{ all -> 0x04d2 }
            r11.putString(r0, r7)     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzai r0 = new com.google.android.gms.measurement.internal.zzai     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_au"
            com.google.android.gms.measurement.internal.zzah r13 = new com.google.android.gms.measurement.internal.zzah     // Catch:{ all -> 0x04d2 }
            r13.<init>(r11)     // Catch:{ all -> 0x04d2 }
            java.lang.String r14 = "auto"
            r11 = r0
            r15 = r9
            r11.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x04d2 }
            r1.zzc(r0, r2)     // Catch:{ all -> 0x04d2 }
            goto L_0x0261
        L_0x0260:
            r8 = 0
        L_0x0261:
            r21.zzg(r22)     // Catch:{ all -> 0x04d2 }
            if (r6 != 0) goto L_0x0273
            com.google.android.gms.measurement.internal.zzx r0 = r21.zzgy()     // Catch:{ all -> 0x04d2 }
            java.lang.String r7 = r2.packageName     // Catch:{ all -> 0x04d2 }
            java.lang.String r11 = "_f"
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc(r7, r11)     // Catch:{ all -> 0x04d2 }
            goto L_0x0283
        L_0x0273:
            if (r6 != r3) goto L_0x0282
            com.google.android.gms.measurement.internal.zzx r0 = r21.zzgy()     // Catch:{ all -> 0x04d2 }
            java.lang.String r7 = r2.packageName     // Catch:{ all -> 0x04d2 }
            java.lang.String r11 = "_v"
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc(r7, r11)     // Catch:{ all -> 0x04d2 }
            goto L_0x0283
        L_0x0282:
            r0 = 0
        L_0x0283:
            if (r0 != 0) goto L_0x04a7
            r11 = 3600000(0x36ee80, double:1.7786363E-317)
            long r13 = r9 / r11
            r15 = 1
            long r13 = r13 + r15
            long r13 = r13 * r11
            java.lang.String r0 = "_dac"
            java.lang.String r7 = "_r"
            java.lang.String r15 = "_c"
            java.lang.String r12 = "_et"
            if (r6 != 0) goto L_0x040a
            com.google.android.gms.measurement.internal.zzjn r6 = new com.google.android.gms.measurement.internal.zzjn     // Catch:{ all -> 0x04d2 }
            java.lang.String r16 = "_fot"
            java.lang.Long r18 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x04d2 }
            java.lang.String r20 = "auto"
            r11 = r6
            r13 = r12
            r12 = r16
            r3 = r13
            r13 = r9
            r8 = r15
            r15 = r18
            r16 = r20
            r11.<init>(r12, r13, r15, r16)     // Catch:{ all -> 0x04d2 }
            r1.zzb(r6, r2)     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzad()     // Catch:{ all -> 0x04d2 }
            java.lang.String r11 = r2.zzcg     // Catch:{ all -> 0x04d2 }
            boolean r6 = r6.zzt(r11)     // Catch:{ all -> 0x04d2 }
            if (r6 == 0) goto L_0x02d0
            r21.zzo()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzeu r6 = r6.zzht()     // Catch:{ all -> 0x04d2 }
            java.lang.String r11 = r2.packageName     // Catch:{ all -> 0x04d2 }
            r6.zzat(r11)     // Catch:{ all -> 0x04d2 }
        L_0x02d0:
            r21.zzo()     // Catch:{ all -> 0x04d2 }
            r21.zzjj()     // Catch:{ all -> 0x04d2 }
            android.os.Bundle r6 = new android.os.Bundle     // Catch:{ all -> 0x04d2 }
            r6.<init>()     // Catch:{ all -> 0x04d2 }
            r11 = 1
            r6.putLong(r8, r11)     // Catch:{ all -> 0x04d2 }
            r6.putLong(r7, r11)     // Catch:{ all -> 0x04d2 }
            r7 = 0
            r6.putLong(r5, r7)     // Catch:{ all -> 0x04d2 }
            r6.putLong(r4, r7)     // Catch:{ all -> 0x04d2 }
            r15 = r19
            r6.putLong(r15, r7)     // Catch:{ all -> 0x04d2 }
            java.lang.String r11 = "_sysu"
            r6.putLong(r11, r7)     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzs r7 = r7.zzad()     // Catch:{ all -> 0x04d2 }
            java.lang.String r8 = r2.packageName     // Catch:{ all -> 0x04d2 }
            boolean r7 = r7.zzz(r8)     // Catch:{ all -> 0x04d2 }
            if (r7 == 0) goto L_0x0309
            r7 = 1
            r6.putLong(r3, r7)     // Catch:{ all -> 0x04d2 }
            goto L_0x030b
        L_0x0309:
            r7 = 1
        L_0x030b:
            boolean r11 = r2.zzdt     // Catch:{ all -> 0x04d2 }
            if (r11 == 0) goto L_0x0312
            r6.putLong(r0, r7)     // Catch:{ all -> 0x04d2 }
        L_0x0312:
            com.google.android.gms.measurement.internal.zzfj r0 = r1.zzj     // Catch:{ all -> 0x04d2 }
            android.content.Context r0 = r0.getContext()     // Catch:{ all -> 0x04d2 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x04d2 }
            if (r0 != 0) goto L_0x0335
            com.google.android.gms.measurement.internal.zzfj r0 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzab()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgk()     // Catch:{ all -> 0x04d2 }
            java.lang.String r5 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.String r7 = r2.packageName     // Catch:{ all -> 0x04d2 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzef.zzam(r7)     // Catch:{ all -> 0x04d2 }
            r0.zza(r5, r7)     // Catch:{ all -> 0x04d2 }
            goto L_0x03d8
        L_0x0335:
            com.google.android.gms.measurement.internal.zzfj r0 = r1.zzj     // Catch:{ NameNotFoundException -> 0x0347 }
            android.content.Context r0 = r0.getContext()     // Catch:{ NameNotFoundException -> 0x0347 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x0347 }
            java.lang.String r7 = r2.packageName     // Catch:{ NameNotFoundException -> 0x0347 }
            r8 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r7, r8)     // Catch:{ NameNotFoundException -> 0x0347 }
            goto L_0x035e
        L_0x0347:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzab()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgk()     // Catch:{ all -> 0x04d2 }
            java.lang.String r8 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.String r11 = r2.packageName     // Catch:{ all -> 0x04d2 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzef.zzam(r11)     // Catch:{ all -> 0x04d2 }
            r7.zza(r8, r11, r0)     // Catch:{ all -> 0x04d2 }
            r0 = 0
        L_0x035e:
            if (r0 == 0) goto L_0x0394
            long r7 = r0.firstInstallTime     // Catch:{ all -> 0x04d2 }
            r11 = 0
            int r13 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r13 == 0) goto L_0x0394
            long r7 = r0.firstInstallTime     // Catch:{ all -> 0x04d2 }
            long r11 = r0.lastUpdateTime     // Catch:{ all -> 0x04d2 }
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x0377
            r7 = 1
            r6.putLong(r5, r7)     // Catch:{ all -> 0x04d2 }
            r0 = 0
            goto L_0x0378
        L_0x0377:
            r0 = 1
        L_0x0378:
            com.google.android.gms.measurement.internal.zzjn r5 = new com.google.android.gms.measurement.internal.zzjn     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_fi"
            if (r0 == 0) goto L_0x0381
            r7 = 1
            goto L_0x0383
        L_0x0381:
            r7 = 0
        L_0x0383:
            java.lang.Long r0 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x04d2 }
            java.lang.String r16 = "auto"
            r11 = r5
            r13 = r9
            r7 = r15
            r15 = r0
            r11.<init>(r12, r13, r15, r16)     // Catch:{ all -> 0x04d2 }
            r1.zzb(r5, r2)     // Catch:{ all -> 0x04d2 }
            goto L_0x0395
        L_0x0394:
            r7 = r15
        L_0x0395:
            com.google.android.gms.measurement.internal.zzfj r0 = r1.zzj     // Catch:{ NameNotFoundException -> 0x03a7 }
            android.content.Context r0 = r0.getContext()     // Catch:{ NameNotFoundException -> 0x03a7 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x03a7 }
            java.lang.String r5 = r2.packageName     // Catch:{ NameNotFoundException -> 0x03a7 }
            r8 = 0
            android.content.pm.ApplicationInfo r8 = r0.getApplicationInfo(r5, r8)     // Catch:{ NameNotFoundException -> 0x03a7 }
            goto L_0x03be
        L_0x03a7:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzab()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzgk()     // Catch:{ all -> 0x04d2 }
            java.lang.String r8 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.String r11 = r2.packageName     // Catch:{ all -> 0x04d2 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzef.zzam(r11)     // Catch:{ all -> 0x04d2 }
            r5.zza(r8, r11, r0)     // Catch:{ all -> 0x04d2 }
            r8 = 0
        L_0x03be:
            if (r8 == 0) goto L_0x03d8
            int r0 = r8.flags     // Catch:{ all -> 0x04d2 }
            r5 = 1
            r0 = r0 & r5
            if (r0 == 0) goto L_0x03cb
            r11 = 1
            r6.putLong(r7, r11)     // Catch:{ all -> 0x04d2 }
        L_0x03cb:
            int r0 = r8.flags     // Catch:{ all -> 0x04d2 }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x03d8
            java.lang.String r0 = "_sysu"
            r7 = 1
            r6.putLong(r0, r7)     // Catch:{ all -> 0x04d2 }
        L_0x03d8:
            com.google.android.gms.measurement.internal.zzx r0 = r21.zzgy()     // Catch:{ all -> 0x04d2 }
            java.lang.String r5 = r2.packageName     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)     // Catch:{ all -> 0x04d2 }
            r0.zzo()     // Catch:{ all -> 0x04d2 }
            r0.zzbi()     // Catch:{ all -> 0x04d2 }
            java.lang.String r7 = "first_open_count"
            long r7 = r0.zzj(r5, r7)     // Catch:{ all -> 0x04d2 }
            r11 = 0
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 < 0) goto L_0x03f6
            r6.putLong(r4, r7)     // Catch:{ all -> 0x04d2 }
        L_0x03f6:
            com.google.android.gms.measurement.internal.zzai r0 = new com.google.android.gms.measurement.internal.zzai     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_f"
            com.google.android.gms.measurement.internal.zzah r13 = new com.google.android.gms.measurement.internal.zzah     // Catch:{ all -> 0x04d2 }
            r13.<init>(r6)     // Catch:{ all -> 0x04d2 }
            java.lang.String r14 = "auto"
            r11 = r0
            r15 = r9
            r11.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x04d2 }
            r1.zzc(r0, r2)     // Catch:{ all -> 0x04d2 }
            goto L_0x0464
        L_0x040a:
            r3 = r12
            r8 = r15
            r4 = 1
            if (r6 != r4) goto L_0x0464
            com.google.android.gms.measurement.internal.zzjn r4 = new com.google.android.gms.measurement.internal.zzjn     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_fvt"
            java.lang.Long r15 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x04d2 }
            java.lang.String r16 = "auto"
            r11 = r4
            r13 = r9
            r11.<init>(r12, r13, r15, r16)     // Catch:{ all -> 0x04d2 }
            r1.zzb(r4, r2)     // Catch:{ all -> 0x04d2 }
            r21.zzo()     // Catch:{ all -> 0x04d2 }
            r21.zzjj()     // Catch:{ all -> 0x04d2 }
            android.os.Bundle r4 = new android.os.Bundle     // Catch:{ all -> 0x04d2 }
            r4.<init>()     // Catch:{ all -> 0x04d2 }
            r5 = 1
            r4.putLong(r8, r5)     // Catch:{ all -> 0x04d2 }
            r4.putLong(r7, r5)     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzs r5 = r5.zzad()     // Catch:{ all -> 0x04d2 }
            java.lang.String r6 = r2.packageName     // Catch:{ all -> 0x04d2 }
            boolean r5 = r5.zzz(r6)     // Catch:{ all -> 0x04d2 }
            if (r5 == 0) goto L_0x0448
            r5 = 1
            r4.putLong(r3, r5)     // Catch:{ all -> 0x04d2 }
            goto L_0x044a
        L_0x0448:
            r5 = 1
        L_0x044a:
            boolean r7 = r2.zzdt     // Catch:{ all -> 0x04d2 }
            if (r7 == 0) goto L_0x0451
            r4.putLong(r0, r5)     // Catch:{ all -> 0x04d2 }
        L_0x0451:
            com.google.android.gms.measurement.internal.zzai r0 = new com.google.android.gms.measurement.internal.zzai     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_v"
            com.google.android.gms.measurement.internal.zzah r13 = new com.google.android.gms.measurement.internal.zzah     // Catch:{ all -> 0x04d2 }
            r13.<init>(r4)     // Catch:{ all -> 0x04d2 }
            java.lang.String r14 = "auto"
            r11 = r0
            r15 = r9
            r11.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x04d2 }
            r1.zzc(r0, r2)     // Catch:{ all -> 0x04d2 }
        L_0x0464:
            com.google.android.gms.measurement.internal.zzfj r0 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzs r0 = r0.zzad()     // Catch:{ all -> 0x04d2 }
            java.lang.String r4 = r2.packageName     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzak.zzii     // Catch:{ all -> 0x04d2 }
            boolean r0 = r0.zze(r4, r5)     // Catch:{ all -> 0x04d2 }
            if (r0 != 0) goto L_0x04c3
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04d2 }
            r0.<init>()     // Catch:{ all -> 0x04d2 }
            r4 = 1
            r0.putLong(r3, r4)     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzs r3 = r3.zzad()     // Catch:{ all -> 0x04d2 }
            java.lang.String r4 = r2.packageName     // Catch:{ all -> 0x04d2 }
            boolean r3 = r3.zzz(r4)     // Catch:{ all -> 0x04d2 }
            if (r3 == 0) goto L_0x0493
            java.lang.String r3 = "_fr"
            r4 = 1
            r0.putLong(r3, r4)     // Catch:{ all -> 0x04d2 }
        L_0x0493:
            com.google.android.gms.measurement.internal.zzai r3 = new com.google.android.gms.measurement.internal.zzai     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_e"
            com.google.android.gms.measurement.internal.zzah r13 = new com.google.android.gms.measurement.internal.zzah     // Catch:{ all -> 0x04d2 }
            r13.<init>(r0)     // Catch:{ all -> 0x04d2 }
            java.lang.String r14 = "auto"
            r11 = r3
            r15 = r9
            r11.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x04d2 }
            r1.zzc(r3, r2)     // Catch:{ all -> 0x04d2 }
            goto L_0x04c3
        L_0x04a7:
            boolean r0 = r2.zzdq     // Catch:{ all -> 0x04d2 }
            if (r0 == 0) goto L_0x04c3
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04d2 }
            r0.<init>()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzai r3 = new com.google.android.gms.measurement.internal.zzai     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_cd"
            com.google.android.gms.measurement.internal.zzah r13 = new com.google.android.gms.measurement.internal.zzah     // Catch:{ all -> 0x04d2 }
            r13.<init>(r0)     // Catch:{ all -> 0x04d2 }
            java.lang.String r14 = "auto"
            r11 = r3
            r15 = r9
            r11.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x04d2 }
            r1.zzc(r3, r2)     // Catch:{ all -> 0x04d2 }
        L_0x04c3:
            com.google.android.gms.measurement.internal.zzx r0 = r21.zzgy()     // Catch:{ all -> 0x04d2 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzx r0 = r21.zzgy()
            r0.endTransaction()
            return
        L_0x04d2:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzx r2 = r21.zzgy()
            r2.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjg.zzf(com.google.android.gms.measurement.internal.zzn):void");
    }

    @WorkerThread
    private final zzn zzbi(String str) {
        String str2 = str;
        zzf zzab = zzgy().zzab(str2);
        if (zzab == null || TextUtils.isEmpty(zzab.zzal())) {
            this.zzj.zzab().zzgr().zza("No app data available; dropping", str2);
            return null;
        }
        Boolean zzc = zzc(zzab);
        if (zzc == null || zzc.booleanValue()) {
            zzf zzf = zzab;
            zzn zzn = new zzn(str, zzab.getGmpAppId(), zzab.zzal(), zzab.zzam(), zzab.zzan(), zzab.zzao(), zzab.zzap(), (String) null, zzab.isMeasurementEnabled(), false, zzab.getFirebaseInstanceId(), zzf.zzbd(), 0, 0, zzf.zzbe(), zzf.zzbf(), false, zzf.zzah(), zzf.zzbg(), zzf.zzaq(), zzf.zzbh());
            return zzn;
        }
        this.zzj.zzab().zzgk().zza("App version does not match; dropping. appId", zzef.zzam(str));
        return null;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zze(zzq zzq) {
        zzn zzbi = zzbi(zzq.packageName);
        if (zzbi != null) {
            zzb(zzq, zzbi);
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzb(zzq zzq, zzn zzn) {
        Preconditions.checkNotNull(zzq);
        Preconditions.checkNotEmpty(zzq.packageName);
        Preconditions.checkNotNull(zzq.origin);
        Preconditions.checkNotNull(zzq.zzdw);
        Preconditions.checkNotEmpty(zzq.zzdw.name);
        zzo();
        zzjj();
        if (TextUtils.isEmpty(zzn.zzcg) && TextUtils.isEmpty(zzn.zzcu)) {
            return;
        }
        if (!zzn.zzcq) {
            zzg(zzn);
            return;
        }
        zzq zzq2 = new zzq(zzq);
        boolean z = false;
        zzq2.active = false;
        zzgy().beginTransaction();
        try {
            zzq zzf = zzgy().zzf(zzq2.packageName, zzq2.zzdw.name);
            if (zzf != null && !zzf.origin.equals(zzq2.origin)) {
                this.zzj.zzab().zzgn().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzj.zzy().zzal(zzq2.zzdw.name), zzq2.origin, zzf.origin);
            }
            if (zzf != null && zzf.active) {
                zzq2.origin = zzf.origin;
                zzq2.creationTimestamp = zzf.creationTimestamp;
                zzq2.triggerTimeout = zzf.triggerTimeout;
                zzq2.triggerEventName = zzf.triggerEventName;
                zzq2.zzdy = zzf.zzdy;
                zzq2.active = zzf.active;
                zzjn zzjn = new zzjn(zzq2.zzdw.name, zzf.zzdw.zztr, zzq2.zzdw.getValue(), zzf.zzdw.origin);
                zzq2.zzdw = zzjn;
            } else if (TextUtils.isEmpty(zzq2.triggerEventName)) {
                zzjn zzjn2 = new zzjn(zzq2.zzdw.name, zzq2.creationTimestamp, zzq2.zzdw.getValue(), zzq2.zzdw.origin);
                zzq2.zzdw = zzjn2;
                zzq2.active = true;
                z = true;
            }
            if (zzq2.active) {
                zzjn zzjn3 = zzq2.zzdw;
                zzjp zzjp = new zzjp(zzq2.packageName, zzq2.origin, zzjn3.name, zzjn3.zztr, zzjn3.getValue());
                if (zzgy().zza(zzjp)) {
                    this.zzj.zzab().zzgr().zza("User property updated immediately", zzq2.packageName, this.zzj.zzy().zzal(zzjp.name), zzjp.value);
                } else {
                    this.zzj.zzab().zzgk().zza("(2)Too many active user properties, ignoring", zzef.zzam(zzq2.packageName), this.zzj.zzy().zzal(zzjp.name), zzjp.value);
                }
                if (z && zzq2.zzdy != null) {
                    zzd(new zzai(zzq2.zzdy, zzq2.creationTimestamp), zzn);
                }
            }
            if (zzgy().zza(zzq2)) {
                this.zzj.zzab().zzgr().zza("Conditional property added", zzq2.packageName, this.zzj.zzy().zzal(zzq2.zzdw.name), zzq2.zzdw.getValue());
            } else {
                this.zzj.zzab().zzgk().zza("Too many conditional properties, ignoring", zzef.zzam(zzq2.packageName), this.zzj.zzy().zzal(zzq2.zzdw.name), zzq2.zzdw.getValue());
            }
            zzgy().setTransactionSuccessful();
        } finally {
            zzgy().endTransaction();
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzf(zzq zzq) {
        zzn zzbi = zzbi(zzq.packageName);
        if (zzbi != null) {
            zzc(zzq, zzbi);
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzc(zzq zzq, zzn zzn) {
        Preconditions.checkNotNull(zzq);
        Preconditions.checkNotEmpty(zzq.packageName);
        Preconditions.checkNotNull(zzq.zzdw);
        Preconditions.checkNotEmpty(zzq.zzdw.name);
        zzo();
        zzjj();
        if (TextUtils.isEmpty(zzn.zzcg) && TextUtils.isEmpty(zzn.zzcu)) {
            return;
        }
        if (!zzn.zzcq) {
            zzg(zzn);
            return;
        }
        zzgy().beginTransaction();
        try {
            zzg(zzn);
            zzq zzf = zzgy().zzf(zzq.packageName, zzq.zzdw.name);
            if (zzf != null) {
                this.zzj.zzab().zzgr().zza("Removing conditional user property", zzq.packageName, this.zzj.zzy().zzal(zzq.zzdw.name));
                zzgy().zzg(zzq.packageName, zzq.zzdw.name);
                if (zzf.active) {
                    zzgy().zzd(zzq.packageName, zzq.zzdw.name);
                }
                if (zzq.zzdz != null) {
                    Bundle bundle = null;
                    if (zzq.zzdz.zzfq != null) {
                        bundle = zzq.zzdz.zzfq.zzcv();
                    }
                    Bundle bundle2 = bundle;
                    zzd(this.zzj.zzz().zza(zzq.packageName, zzq.zzdz.name, bundle2, zzf.origin, zzq.zzdz.zzfu, true, false), zzn);
                }
            } else {
                this.zzj.zzab().zzgn().zza("Conditional user property doesn't exist", zzef.zzam(zzq.packageName), this.zzj.zzy().zzal(zzq.zzdw.name));
            }
            zzgy().setTransactionSuccessful();
        } finally {
            zzgy().endTransaction();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x018e  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzf zzg(com.google.android.gms.measurement.internal.zzn r11) {
        /*
            r10 = this;
            r10.zzo()
            r10.zzjj()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)
            java.lang.String r0 = r11.packageName
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r0)
            com.google.android.gms.measurement.internal.zzx r0 = r10.zzgy()
            java.lang.String r1 = r11.packageName
            com.google.android.gms.measurement.internal.zzf r0 = r0.zzab(r1)
            com.google.android.gms.measurement.internal.zzfj r1 = r10.zzj
            com.google.android.gms.measurement.internal.zzeo r1 = r1.zzac()
            java.lang.String r2 = r11.packageName
            java.lang.String r1 = r1.zzaq(r2)
            r2 = 1
            if (r0 != 0) goto L_0x0042
            com.google.android.gms.measurement.internal.zzf r0 = new com.google.android.gms.measurement.internal.zzf
            com.google.android.gms.measurement.internal.zzfj r3 = r10.zzj
            java.lang.String r4 = r11.packageName
            r0.<init>(r3, r4)
            com.google.android.gms.measurement.internal.zzfj r3 = r10.zzj
            com.google.android.gms.measurement.internal.zzjs r3 = r3.zzz()
            java.lang.String r3 = r3.zzjy()
            r0.zza(r3)
            r0.zzd(r1)
        L_0x0040:
            r1 = 1
            goto L_0x005e
        L_0x0042:
            java.lang.String r3 = r0.zzai()
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x005d
            r0.zzd(r1)
            com.google.android.gms.measurement.internal.zzfj r1 = r10.zzj
            com.google.android.gms.measurement.internal.zzjs r1 = r1.zzz()
            java.lang.String r1 = r1.zzjy()
            r0.zza(r1)
            goto L_0x0040
        L_0x005d:
            r1 = 0
        L_0x005e:
            java.lang.String r3 = r11.zzcg
            java.lang.String r4 = r0.getGmpAppId()
            boolean r3 = android.text.TextUtils.equals(r3, r4)
            if (r3 != 0) goto L_0x0070
            java.lang.String r1 = r11.zzcg
            r0.zzb(r1)
            r1 = 1
        L_0x0070:
            java.lang.String r3 = r11.zzcu
            java.lang.String r4 = r0.zzah()
            boolean r3 = android.text.TextUtils.equals(r3, r4)
            if (r3 != 0) goto L_0x0082
            java.lang.String r1 = r11.zzcu
            r0.zzc(r1)
            r1 = 1
        L_0x0082:
            java.lang.String r3 = r11.zzci
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x009c
            java.lang.String r3 = r11.zzci
            java.lang.String r4 = r0.getFirebaseInstanceId()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x009c
            java.lang.String r1 = r11.zzci
            r0.zze(r1)
            r1 = 1
        L_0x009c:
            long r3 = r11.zzr
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x00b4
            long r3 = r11.zzr
            long r7 = r0.zzao()
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x00b4
            long r3 = r11.zzr
            r0.zzh(r3)
            r1 = 1
        L_0x00b4:
            java.lang.String r3 = r11.zzcm
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x00ce
            java.lang.String r3 = r11.zzcm
            java.lang.String r4 = r0.zzal()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00ce
            java.lang.String r1 = r11.zzcm
            r0.zzf(r1)
            r1 = 1
        L_0x00ce:
            long r3 = r11.zzcn
            long r7 = r0.zzam()
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x00de
            long r3 = r11.zzcn
            r0.zzg(r3)
            r1 = 1
        L_0x00de:
            java.lang.String r3 = r11.zzco
            if (r3 == 0) goto L_0x00f4
            java.lang.String r3 = r11.zzco
            java.lang.String r4 = r0.zzan()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00f4
            java.lang.String r1 = r11.zzco
            r0.zzg(r1)
            r1 = 1
        L_0x00f4:
            long r3 = r11.zzcp
            long r7 = r0.zzap()
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x0104
            long r3 = r11.zzcp
            r0.zzi(r3)
            r1 = 1
        L_0x0104:
            boolean r3 = r11.zzcq
            boolean r4 = r0.isMeasurementEnabled()
            if (r3 == r4) goto L_0x0112
            boolean r1 = r11.zzcq
            r0.setMeasurementEnabled(r1)
            r1 = 1
        L_0x0112:
            java.lang.String r3 = r11.zzdp
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x012c
            java.lang.String r3 = r11.zzdp
            java.lang.String r4 = r0.zzbb()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x012c
            java.lang.String r1 = r11.zzdp
            r0.zzh(r1)
            r1 = 1
        L_0x012c:
            long r3 = r11.zzcr
            long r7 = r0.zzbd()
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x013c
            long r3 = r11.zzcr
            r0.zzt(r3)
            r1 = 1
        L_0x013c:
            boolean r3 = r11.zzcs
            boolean r4 = r0.zzbe()
            if (r3 == r4) goto L_0x014a
            boolean r1 = r11.zzcs
            r0.zzb(r1)
            r1 = 1
        L_0x014a:
            boolean r3 = r11.zzct
            boolean r4 = r0.zzbf()
            if (r3 == r4) goto L_0x0158
            boolean r1 = r11.zzct
            r0.zzc(r1)
            r1 = 1
        L_0x0158:
            com.google.android.gms.measurement.internal.zzfj r3 = r10.zzj
            com.google.android.gms.measurement.internal.zzs r3 = r3.zzad()
            java.lang.String r4 = r11.packageName
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzak.zzij
            boolean r3 = r3.zze(r4, r7)
            if (r3 == 0) goto L_0x0176
            java.lang.Boolean r3 = r11.zzcv
            java.lang.Boolean r4 = r0.zzbg()
            if (r3 == r4) goto L_0x0176
            java.lang.Boolean r1 = r11.zzcv
            r0.zza(r1)
            r1 = 1
        L_0x0176:
            long r3 = r11.zzs
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x018c
            long r3 = r11.zzs
            long r5 = r0.zzaq()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x018c
            long r3 = r11.zzs
            r0.zzj(r3)
            r1 = 1
        L_0x018c:
            if (r1 == 0) goto L_0x0195
            com.google.android.gms.measurement.internal.zzx r11 = r10.zzgy()
            r11.zza(r0)
        L_0x0195:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjg.zzg(com.google.android.gms.measurement.internal.zzn):com.google.android.gms.measurement.internal.zzf");
    }

    /* access modifiers changed from: 0000 */
    public final String zzh(zzn zzn) {
        try {
            return (String) this.zzj.zzaa().zza((Callable<V>) new zzjk<V>(this, zzn)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zzj.zzab().zzgk().zza("Failed to get app instance id. appId", zzef.zzam(zzn.packageName), e);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzj(boolean z) {
        zzjn();
    }
}
