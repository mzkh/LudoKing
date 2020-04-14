package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzawe extends zzq<zzo> {
    private final Map<String, String> zzab;
    private final zzaxv<zzo> zzdur;
    private final zzaxc zzdus;

    public zzawe(String str, zzaxv<zzo> zzaxv) {
        this(str, null, zzaxv);
    }

    private zzawe(String str, Map<String, String> map, zzaxv<zzo> zzaxv) {
        super(0, str, new zzawd(zzaxv));
        this.zzab = null;
        this.zzdur = zzaxv;
        this.zzdus = new zzaxc();
        this.zzdus.zza(str, "GET", null, null);
    }

    /* access modifiers changed from: protected */
    public final zzz<zzo> zza(zzo zzo) {
        return zzz.zza(zzo, zzaq.zzb(zzo));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zza(Object obj) {
        zzo zzo = (zzo) obj;
        this.zzdus.zza(zzo.zzab, zzo.statusCode);
        zzaxc zzaxc = this.zzdus;
        byte[] bArr = zzo.data;
        if (zzaxc.isEnabled() && bArr != null) {
            zzaxc.zzi(bArr);
        }
        this.zzdur.set(zzo);
    }
}
