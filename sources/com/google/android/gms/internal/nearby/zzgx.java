package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.internal.Update;
import java.util.List;

final class zzgx extends zzha<MessageListener> {
    private final /* synthetic */ List zzjk;

    zzgx(zzgw zzgw, List list) {
        this.zzjk = list;
    }

    public final /* synthetic */ void notifyListener(Object obj) {
        zzgw.zza((Iterable<Update>) this.zzjk, (MessageListener) obj);
    }
}
