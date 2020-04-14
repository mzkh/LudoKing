package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbaj implements zznd {
    private final byte[] zzdlz;
    private final zznd zzecu;

    zzbaj(zznd zznd, byte[] bArr) {
        this.zzecu = zznd;
        this.zzdlz = bArr;
    }

    public final zzne zzib() {
        zznd zznd = this.zzecu;
        byte[] bArr = this.zzdlz;
        return new zzban(new zznb(bArr), bArr.length, zznd.zzib());
    }
}
