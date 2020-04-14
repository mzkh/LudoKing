package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdjx.zza;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdev<P> {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final Class<P> zzgsl;
    private ConcurrentMap<String, List<zzdeu<P>>> zzgsv = new ConcurrentHashMap();
    private zzdeu<P> zzgsw;

    public final zzdeu<P> zzapv() {
        return this.zzgsw;
    }

    private zzdev(Class<P> cls) {
        this.zzgsl = cls;
    }

    public static <P> zzdev<P> zza(Class<P> cls) {
        return new zzdev<>(cls);
    }

    public final void zza(zzdeu<P> zzdeu) {
        if (zzdeu == null) {
            throw new IllegalArgumentException("the primary entry must be non-null");
        } else if (zzdeu.zzaps() == zzdjr.ENABLED) {
            List list = (List) this.zzgsv.get(new String(zzdeu.zzapu(), UTF_8));
            if (list == null) {
                list = Collections.emptyList();
            }
            if (!list.isEmpty()) {
                this.zzgsw = zzdeu;
                return;
            }
            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        } else {
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        }
    }

    public final zzdeu<P> zza(P p, zza zza) throws GeneralSecurityException {
        byte[] bArr;
        if (zza.zzaps() == zzdjr.ENABLED) {
            int i = zzdeg.zzgsh[zza.zzapt().ordinal()];
            if (i == 1 || i == 2) {
                bArr = ByteBuffer.allocate(5).put(0).putInt(zza.zzaup()).array();
            } else if (i == 3) {
                bArr = ByteBuffer.allocate(5).put(1).putInt(zza.zzaup()).array();
            } else if (i == 4) {
                bArr = zzdeh.zzgsi;
            } else {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            zzdeu<P> zzdeu = new zzdeu<>(p, bArr, zza.zzaps(), zza.zzapt());
            ArrayList arrayList = new ArrayList();
            arrayList.add(zzdeu);
            String str = new String(zzdeu.zzapu(), UTF_8);
            List list = (List) this.zzgsv.put(str, Collections.unmodifiableList(arrayList));
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(list);
                arrayList2.add(zzdeu);
                this.zzgsv.put(str, Collections.unmodifiableList(arrayList2));
            }
            return zzdeu;
        }
        throw new GeneralSecurityException("only ENABLED key is allowed");
    }

    public final Class<P> zzapo() {
        return this.zzgsl;
    }
}
