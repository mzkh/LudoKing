package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzatz implements zzqa {
    private final Object lock = new Object();
    private final zzaui zzdrp;
    private final zzaua zzdrs;
    @VisibleForTesting
    private final zzaty zzdrt;
    @VisibleForTesting
    private final HashSet<zzatq> zzdru = new HashSet<>();
    @VisibleForTesting
    private final HashSet<Object> zzdrv = new HashSet<>();

    public zzatz(String str, zzaui zzaui) {
        this.zzdrt = new zzaty(str, zzaui);
        this.zzdrp = zzaui;
        this.zzdrs = new zzaua();
    }

    public final void zzb(zzatq zzatq) {
        synchronized (this.lock) {
            this.zzdru.add(zzatq);
        }
    }

    public final void zzb(HashSet<zzatq> hashSet) {
        synchronized (this.lock) {
            this.zzdru.addAll(hashSet);
        }
    }

    public final Bundle zza(Context context, zzatx zzatx) {
        HashSet hashSet = new HashSet();
        synchronized (this.lock) {
            hashSet.addAll(this.zzdru);
            this.zzdru.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle(TapjoyConstants.TJC_APP_PLACEMENT, this.zzdrt.zzo(context, this.zzdrs.zzus()));
        Bundle bundle2 = new Bundle();
        Iterator it = this.zzdrv.iterator();
        if (!it.hasNext()) {
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                arrayList.add(((zzatq) it2.next()).toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zzatx.zza(hashSet);
            return bundle;
        }
        it.next();
        throw new NoSuchMethodError();
    }

    public final void zzo(boolean z) {
        long currentTimeMillis = zzq.zzkq().currentTimeMillis();
        if (z) {
            if (currentTimeMillis - this.zzdrp.zzvf() > ((Long) zzuv.zzon().zzd(zzza.zzcko)).longValue()) {
                this.zzdrt.zzdrm = -1;
                return;
            }
            this.zzdrt.zzdrm = this.zzdrp.zzvg();
            return;
        }
        this.zzdrp.zzet(currentTimeMillis);
        this.zzdrp.zzcn(this.zzdrt.zzdrm);
    }

    public final void zzty() {
        synchronized (this.lock) {
            this.zzdrt.zzty();
        }
    }

    public final void zztx() {
        synchronized (this.lock) {
            this.zzdrt.zztx();
        }
    }

    public final void zza(zztx zztx, long j) {
        synchronized (this.lock) {
            this.zzdrt.zza(zztx, j);
        }
    }

    public final zzatq zza(Clock clock, String str) {
        return new zzatq(clock, this, this.zzdrs.zzur(), str);
    }
}
