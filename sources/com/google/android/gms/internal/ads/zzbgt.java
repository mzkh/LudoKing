package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbgt implements zzdcj<zzcvz, zzcvz> {
    private Map<String, zzbgs> zzfba;

    public zzbgt(Map<String, zzbgs> map) {
        this.zzfba = map;
    }

    public final /* synthetic */ zzddi zzf(Object obj) throws Exception {
        zzcvz zzcvz = (zzcvz) obj;
        for (zzcwa zzcwa : zzcvz.zzgkb.zzgjz) {
            if (this.zzfba.containsKey(zzcwa.name)) {
                ((zzbgs) this.zzfba.get(zzcwa.name)).zzk(zzcwa.zzgkc);
            }
        }
        return zzdcy.zzah(zzcvz);
    }
}
