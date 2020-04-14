package com.google.android.gms.nearby.messages.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.nearby.zzha;
import com.google.android.gms.nearby.messages.PublishCallback;

class zzbe extends zzv {
    private static final zzha<PublishCallback> zzih = new zzbf();
    @Nullable
    private final ListenerHolder<PublishCallback> zzii;

    public zzbe(@Nullable ListenerHolder<PublishCallback> listenerHolder) {
        this.zzii = listenerHolder;
    }

    public void onExpired() {
        ListenerHolder<PublishCallback> listenerHolder = this.zzii;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(zzih);
        }
    }
}
