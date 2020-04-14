package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zze;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
public class zzdqj {
    private static volatile boolean zzhhi = false;
    private static boolean zzhhj = true;
    private static final Class<?> zzhhk = zzayz();
    private static volatile zzdqj zzhhl;
    private static volatile zzdqj zzhhm;
    private static final zzdqj zzhhn = new zzdqj(true);
    private final Map<zza, zze<?, ?>> zzhho;

    /* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
    static final class zza {
        private final int number;
        private final Object object;

        zza(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.object == zza.object && this.number == zza.number) {
                return true;
            }
            return false;
        }
    }

    private static Class<?> zzayz() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzdqj zzaza() {
        zzdqj zzdqj = zzhhl;
        if (zzdqj == null) {
            synchronized (zzdqj.class) {
                zzdqj = zzhhl;
                if (zzdqj == null) {
                    zzdqj = zzhhn;
                    zzhhl = zzdqj;
                }
            }
        }
        return zzdqj;
    }

    public static zzdqj zzazb() {
        zzdqj zzdqj = zzhhm;
        if (zzdqj == null) {
            synchronized (zzdqj.class) {
                zzdqj = zzhhm;
                if (zzdqj == null) {
                    zzdqj = zzdqv.zze(zzdqj.class);
                    zzhhm = zzdqj;
                }
            }
        }
        return zzdqj;
    }

    public final <ContainingType extends zzdsg> zze<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zze) this.zzhho.get(new zza(containingtype, i));
    }

    zzdqj() {
        this.zzhho = new HashMap();
    }

    private zzdqj(boolean z) {
        this.zzhho = Collections.emptyMap();
    }
}
