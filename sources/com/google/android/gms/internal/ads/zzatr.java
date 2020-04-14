package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzatr {
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    /* access modifiers changed from: private */
    public zzaxl zzblk;
    private final zzatz zzdqe = new zzatz(zzuv.zzoo(), this.zzdqn);
    private zzpg zzdqm;
    private final zzauh zzdqn = new zzauh();
    /* access modifiers changed from: private */
    @Nullable
    public zzzr zzdqo = null;
    @Nullable
    private Boolean zzdqp = null;
    private final AtomicInteger zzdqq = new AtomicInteger(0);
    private final zzatw zzdqr = new zzatw(null);
    private final Object zzdqs = new Object();
    @GuardedBy("grantedPermissionLock")
    private zzddi<ArrayList<String>> zzdqt;
    /* access modifiers changed from: private */
    public Context zzlk;
    private boolean zzye = false;

    @Nullable
    public final zzzr zzub() {
        zzzr zzzr;
        synchronized (this.lock) {
            zzzr = this.zzdqo;
        }
        return zzzr;
    }

    public final void zza(Boolean bool) {
        synchronized (this.lock) {
            this.zzdqp = bool;
        }
    }

    public final Boolean zzuc() {
        Boolean bool;
        synchronized (this.lock) {
            bool = this.zzdqp;
        }
        return bool;
    }

    public final void zzud() {
        this.zzdqr.zzud();
    }

    @TargetApi(23)
    public final void zzd(Context context, zzaxl zzaxl) {
        synchronized (this.lock) {
            if (!this.zzye) {
                this.zzlk = context.getApplicationContext();
                this.zzblk = zzaxl;
                zzq.zzkm().zza(this.zzdqe);
                zzzr zzzr = null;
                this.zzdqn.zza(this.zzlk, null, true);
                zzaod.zzc(this.zzlk, this.zzblk);
                this.zzdqm = new zzpg(context.getApplicationContext(), this.zzblk);
                zzq.zzks();
                if (!((Boolean) zzuv.zzon().zzd(zzza.zzcik)).booleanValue()) {
                    zzaug.zzdy("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                } else {
                    zzzr = new zzzr();
                }
                this.zzdqo = zzzr;
                if (this.zzdqo != null) {
                    zzaxr.zza(new zzatt(this).zzut(), "AppState.registerCsiReporter");
                }
                this.zzye = true;
                zzui();
            }
        }
        zzq.zzkj().zzr(context, zzaxl.zzblz);
    }

    @Nullable
    public final Resources getResources() {
        if (this.zzblk.zzdwg) {
            return this.zzlk.getResources();
        }
        try {
            zzaxh.zzbp(this.zzlk).getResources();
            return null;
        } catch (zzaxj e) {
            zzaug.zzd("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public final void zza(Throwable th, String str) {
        zzaod.zzc(this.zzlk, this.zzblk).zza(th, str);
    }

    public final void zzb(Throwable th, String str) {
        zzaod.zzc(this.zzlk, this.zzblk).zza(th, str, ((Float) zzuv.zzon().zzd(zzza.zzcgs)).floatValue());
    }

    public final void zzue() {
        this.zzdqq.incrementAndGet();
    }

    public final void zzuf() {
        this.zzdqq.decrementAndGet();
    }

    public final int zzug() {
        return this.zzdqq.get();
    }

    public final zzaui zzuh() {
        zzauh zzauh;
        synchronized (this.lock) {
            zzauh = this.zzdqn;
        }
        return zzauh;
    }

    @Nullable
    public final Context getApplicationContext() {
        return this.zzlk;
    }

    public final zzddi<ArrayList<String>> zzui() {
        if (PlatformVersion.isAtLeastJellyBean() && this.zzlk != null) {
            if (!((Boolean) zzuv.zzon().zzd(zzza.zzcne)).booleanValue()) {
                synchronized (this.zzdqs) {
                    if (this.zzdqt != null) {
                        zzddi<ArrayList<String>> zzddi = this.zzdqt;
                        return zzddi;
                    }
                    zzddi<ArrayList<String>> zzd = zzaxn.zzdwi.zzd(new zzatu(this));
                    this.zzdqt = zzd;
                    return zzd;
                }
            }
        }
        return zzdcy.zzah(new ArrayList());
    }

    @TargetApi(16)
    private static ArrayList<String> zzal(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(context.getApplicationInfo().packageName, 4096);
            if (!(packageInfo.requestedPermissions == null || packageInfo.requestedPermissionsFlags == null)) {
                for (int i = 0; i < packageInfo.requestedPermissions.length; i++) {
                    if ((packageInfo.requestedPermissionsFlags[i] & 2) != 0) {
                        arrayList.add(packageInfo.requestedPermissions[i]);
                    }
                }
            }
        } catch (NameNotFoundException unused) {
        }
        return arrayList;
    }

    public final zzatz zzuj() {
        return this.zzdqe;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ ArrayList zzuk() throws Exception {
        return zzal(zzapv.zzaa(this.zzlk));
    }
}
