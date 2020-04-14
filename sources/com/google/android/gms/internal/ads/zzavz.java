package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzavz extends zzav {
    private final /* synthetic */ byte[] zzdul;
    private final /* synthetic */ Map zzdum;
    private final /* synthetic */ zzaxc zzdun;

    zzavz(zzavy zzavy, int i, String str, zzab zzab, zzy zzy, byte[] bArr, Map map, zzaxc zzaxc) {
        this.zzdul = bArr;
        this.zzdum = map;
        this.zzdun = zzaxc;
        super(i, str, zzab, zzy);
    }

    public final byte[] zzf() throws zzb {
        byte[] bArr = this.zzdul;
        return bArr == null ? super.zzf() : bArr;
    }

    public final Map<String, String> getHeaders() throws zzb {
        Map<String, String> map = this.zzdum;
        return map == null ? super.getHeaders() : map;
    }

    /* access modifiers changed from: protected */
    public final void zzh(String str) {
        this.zzdun.zzep(str);
        super.zza(str);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zza(Object obj) {
        zza((String) obj);
    }
}
