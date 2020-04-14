package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbbk {
    private final ArrayList<zznh> zzeea = new ArrayList<>();
    private long zzeeb;

    zzbbk() {
    }

    /* access modifiers changed from: 0000 */
    public final long zzyt() {
        Iterator it = this.zzeea.iterator();
        while (it.hasNext()) {
            Map responseHeaders = ((zznh) it.next()).getResponseHeaders();
            if (responseHeaders != null) {
                for (Entry entry : responseHeaders.entrySet()) {
                    try {
                        if ("content-length".equalsIgnoreCase((String) entry.getKey())) {
                            this.zzeeb = Math.max(this.zzeeb, Long.parseLong((String) ((List) entry.getValue()).get(0)));
                        }
                    } catch (RuntimeException unused) {
                    }
                }
                it.remove();
            }
        }
        return this.zzeeb;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zznh zznh) {
        this.zzeea.add(zznh);
    }
}
