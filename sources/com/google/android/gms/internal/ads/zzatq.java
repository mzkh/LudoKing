package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzatq {
    private final Object lock = new Object();
    /* access modifiers changed from: private */
    public final Clock zzbmp;
    private final String zzdjg;
    @GuardedBy("lock")
    private boolean zzdkq = false;
    @GuardedBy("lock")
    private long zzdku = -1;
    private final zzatz zzdqe;
    @GuardedBy("lock")
    private final LinkedList<zzatp> zzdqf;
    private final String zzdqg;
    @GuardedBy("lock")
    private long zzdqh = -1;
    @GuardedBy("lock")
    private long zzdqi = -1;
    @GuardedBy("lock")
    private long zzdqj = 0;
    @GuardedBy("lock")
    private long zzdqk = -1;
    @GuardedBy("lock")
    private long zzdql = -1;

    zzatq(Clock clock, zzatz zzatz, String str, String str2) {
        this.zzbmp = clock;
        this.zzdqe = zzatz;
        this.zzdqg = str;
        this.zzdjg = str2;
        this.zzdqf = new LinkedList<>();
    }

    public final void zze(zztx zztx) {
        synchronized (this.lock) {
            this.zzdqk = this.zzbmp.elapsedRealtime();
            this.zzdqe.zza(zztx, this.zzdqk);
        }
    }

    public final void zzes(long j) {
        synchronized (this.lock) {
            this.zzdql = j;
            if (this.zzdql != -1) {
                this.zzdqe.zzb(this);
            }
        }
    }

    public final void zztx() {
        synchronized (this.lock) {
            if (this.zzdql != -1 && this.zzdqh == -1) {
                this.zzdqh = this.zzbmp.elapsedRealtime();
                this.zzdqe.zzb(this);
            }
            this.zzdqe.zztx();
        }
    }

    public final void zzty() {
        synchronized (this.lock) {
            if (this.zzdql != -1) {
                zzatp zzatp = new zzatp(this);
                zzatp.zztw();
                this.zzdqf.add(zzatp);
                this.zzdqj++;
                this.zzdqe.zzty();
                this.zzdqe.zzb(this);
            }
        }
    }

    public final void zztz() {
        synchronized (this.lock) {
            if (this.zzdql != -1 && !this.zzdqf.isEmpty()) {
                zzatp zzatp = (zzatp) this.zzdqf.getLast();
                if (zzatp.zztu() == -1) {
                    zzatp.zztv();
                    this.zzdqe.zzb(this);
                }
            }
        }
    }

    public final void zzag(boolean z) {
        synchronized (this.lock) {
            if (this.zzdql != -1) {
                this.zzdqi = this.zzbmp.elapsedRealtime();
            }
        }
    }

    public final Bundle toBundle() {
        Bundle bundle;
        synchronized (this.lock) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.zzdqg);
            bundle.putString("slotid", this.zzdjg);
            bundle.putBoolean("ismediation", false);
            bundle.putLong("treq", this.zzdqk);
            bundle.putLong("tresponse", this.zzdql);
            bundle.putLong("timp", this.zzdqh);
            bundle.putLong("tload", this.zzdqi);
            bundle.putLong("pcc", this.zzdqj);
            bundle.putLong("tfetch", this.zzdku);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.zzdqf.iterator();
            while (it.hasNext()) {
                arrayList.add(((zzatp) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public final String zzua() {
        return this.zzdqg;
    }
}
