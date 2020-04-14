package com.google.android.gms.internal.nearby;

import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate.Builder;
import java.util.Map;
import java.util.Map.Entry;

@VisibleForTesting
final class zzav extends zzdx {
    private final ListenerHolder<PayloadCallback> zzbv;
    private final Map<zzaz, PayloadTransferUpdate> zzbw = new ArrayMap();

    zzav(ListenerHolder<PayloadCallback> listenerHolder) {
        this.zzbv = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    /* access modifiers changed from: 0000 */
    public final synchronized void shutdown() {
        for (Entry entry : this.zzbw.entrySet()) {
            this.zzbv.notifyListener(new zzay(this, ((zzaz) entry.getKey()).zze(), (PayloadTransferUpdate) entry.getValue()));
        }
        this.zzbw.clear();
    }

    public final synchronized void zza(zzev zzev) {
        Payload zza = zzfl.zza(zzev.zzl());
        if (zza == null) {
            Log.w("NearbyConnectionsClient", String.format("Failed to convert incoming ParcelablePayload %d to Payload.", new Object[]{Long.valueOf(zzev.zzl().getId())}));
            return;
        }
        this.zzbw.put(new zzaz(zzev.zzg(), zzev.zzl().getId()), new Builder().setPayloadId(zzev.zzl().getId()).build());
        this.zzbv.notifyListener(new zzaw(this, zzev, zza));
    }

    public final synchronized void zza(zzex zzex) {
        if (zzex.zzn().getStatus() == 3) {
            this.zzbw.put(new zzaz(zzex.zzg(), zzex.zzn().getPayloadId()), zzex.zzn());
        } else {
            this.zzbw.remove(new zzaz(zzex.zzg(), zzex.zzn().getPayloadId()));
        }
        this.zzbv.notifyListener(new zzax(this, zzex));
    }
}
