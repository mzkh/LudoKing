package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdsz extends zzdta<FieldDescriptorType, Object> {
    zzdsz(int i) {
        super(i, null);
    }

    public final void zzaxj() {
        if (!isImmutable()) {
            for (int i = 0; i < zzbbo(); i++) {
                Entry zzgz = zzgz(i);
                if (((zzdqo) zzgz.getKey()).zzazj()) {
                    zzgz.setValue(Collections.unmodifiableList((List) zzgz.getValue()));
                }
            }
            for (Entry entry : zzbbp()) {
                if (((zzdqo) entry.getKey()).zzazj()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzaxj();
    }
}
