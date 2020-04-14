package com.google.android.gms.internal.nearby;

import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import java.util.Set;

@VisibleForTesting
final class zzz extends zzdk {
    private final ListenerHolder<ConnectionLifecycleCallback> zzbe;
    private final Set<String> zzbf = new ArraySet();
    private final Set<String> zzbg = new ArraySet();

    zzz(ListenerHolder<ConnectionLifecycleCallback> listenerHolder) {
        this.zzbe = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    /* access modifiers changed from: 0000 */
    public final synchronized void shutdown() {
        for (String zzae : this.zzbf) {
            this.zzbe.notifyListener(new zzae(this, zzae));
        }
        this.zzbf.clear();
        for (String zzaf : this.zzbg) {
            this.zzbe.notifyListener(new zzaf(this, zzaf));
        }
        this.zzbg.clear();
    }

    public final void zza(zzef zzef) {
        this.zzbe.notifyListener(new zzad(this, zzef));
    }

    public final synchronized void zza(zzeh zzeh) {
        this.zzbf.add(zzeh.zzg());
        this.zzbe.notifyListener(new zzaa(this, zzeh));
    }

    public final synchronized void zza(zzen zzen) {
        this.zzbf.remove(zzen.zzg());
        Status zzb = zzx.zza(zzen.getStatusCode());
        if (zzb.isSuccess()) {
            this.zzbg.add(zzen.zzg());
        }
        this.zzbe.notifyListener(new zzab(this, zzen, zzb));
    }

    public final synchronized void zza(zzep zzep) {
        this.zzbg.remove(zzep.zzg());
        this.zzbe.notifyListener(new zzac(this, zzep));
    }
}
