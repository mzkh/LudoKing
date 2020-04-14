package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdgc implements zzdel {
    private final zzdev<zzdel> zzgtj;

    public zzdgc(zzdev<zzdel> zzdev) {
        this.zzgtj = zzdev;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzdmn.zza(this.zzgtj.zzapv().zzapu(), ((zzdel) this.zzgtj.zzapv().zzapr()).zzc(bArr, bArr2));
    }
}
