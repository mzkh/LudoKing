package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbhk implements zzo, zzbnj, zzbnm, zzpj {
    private final Clock zzbmp;
    private final zzbhf zzfbt;
    private final zzbhi zzfbu;
    private final Set<zzbbw> zzfbv = new HashSet();
    private final zzajj<JSONObject, JSONObject> zzfbw;
    private final Executor zzfbx;
    private final AtomicBoolean zzfby = new AtomicBoolean(false);
    @GuardedBy("this")
    private final zzbhm zzfbz = new zzbhm();
    private boolean zzfca = false;
    private WeakReference<?> zzfcb = new WeakReference<>(this);

    public zzbhk(zzajc zzajc, zzbhi zzbhi, Executor executor, zzbhf zzbhf, Clock clock) {
        this.zzfbt = zzbhf;
        this.zzfbw = zzajc.zzb("google.afma.activeView.handleUpdate", zzais.zzday, zzais.zzday);
        this.zzfbu = zzbhi;
        this.zzfbx = executor;
        this.zzbmp = clock;
    }

    public final void zzsi() {
    }

    public final void zzsj() {
    }

    public final synchronized void zzaei() {
        if (!(this.zzfcb.get() != null)) {
            zzaek();
        } else if (!this.zzfca && this.zzfby.get()) {
            try {
                this.zzfbz.timestamp = this.zzbmp.elapsedRealtime();
                JSONObject zza = this.zzfbu.zzj(this.zzfbz);
                for (zzbbw zzbhn : this.zzfbv) {
                    this.zzfbx.execute(new zzbhn(zzbhn, zza));
                }
                zzaxr.zzb(this.zzfbw.zzf(zza), "ActiveViewListener.callActiveViewJs");
            } catch (Exception e) {
                zzaug.zza("Failed to call ActiveViewJS", e);
            }
        }
    }

    private final void zzaej() {
        for (zzbbw zze : this.zzfbv) {
            this.zzfbt.zze(zze);
        }
        this.zzfbt.zzaeh();
    }

    public final synchronized void zzaek() {
        zzaej();
        this.zzfca = true;
    }

    public final synchronized void zzf(zzbbw zzbbw) {
        this.zzfbv.add(zzbbw);
        this.zzfbt.zzd(zzbbw);
    }

    public final void zzo(Object obj) {
        this.zzfcb = new WeakReference<>(obj);
    }

    public final synchronized void zza(zzpk zzpk) {
        this.zzfbz.zzbnp = zzpk.zzbnp;
        this.zzfbz.zzfcg = zzpk;
        zzaei();
    }

    public final synchronized void zzbu(@Nullable Context context) {
        this.zzfbz.zzfcd = true;
        zzaei();
    }

    public final synchronized void zzbv(@Nullable Context context) {
        this.zzfbz.zzfcd = false;
        zzaei();
    }

    public final synchronized void zzbw(@Nullable Context context) {
        this.zzfbz.zzfcf = "u";
        zzaei();
        zzaej();
        this.zzfca = true;
    }

    public final synchronized void onPause() {
        this.zzfbz.zzfcd = true;
        zzaei();
    }

    public final synchronized void onResume() {
        this.zzfbz.zzfcd = false;
        zzaei();
    }

    public final synchronized void onAdImpression() {
        if (this.zzfby.compareAndSet(false, true)) {
            this.zzfbt.zza(this);
            zzaei();
        }
    }
}
