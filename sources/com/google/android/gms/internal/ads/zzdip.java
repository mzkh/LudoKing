package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdip extends zzdqw<zzdip, zza> implements zzdsi {
    private static volatile zzdsp<zzdip> zzdv;
    /* access modifiers changed from: private */
    public static final zzdip zzgwf;
    private zzdiw zzgwc;
    private zzdik zzgwd;
    private int zzgwe;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdip, zza> implements zzdsi {
        private zza() {
            super(zzdip.zzgwf);
        }

        /* synthetic */ zza(zzdiq zzdiq) {
            this();
        }
    }

    private zzdip() {
    }

    public final zzdiw zzasq() {
        zzdiw zzdiw = this.zzgwc;
        return zzdiw == null ? zzdiw.zzatd() : zzdiw;
    }

    public final zzdik zzasr() {
        zzdik zzdik = this.zzgwd;
        return zzdik == null ? zzdik.zzasm() : zzdik;
    }

    public final zzdhz zzass() {
        zzdhz zzeb = zzdhz.zzeb(this.zzgwe);
        return zzeb == null ? zzdhz.UNRECOGNIZED : zzeb;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdiq.zzdi[i - 1]) {
            case 1:
                return new zzdip();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgwf, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zzgwc", "zzgwd", "zzgwe"});
            case 4:
                return zzgwf;
            case 5:
                zzdsp<zzdip> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdip.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgwf);
                            zzdv = zzdsp;
                        }
                    }
                }
                return zzdsp;
            case 6:
                return Byte.valueOf(1);
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static zzdip zzast() {
        return zzgwf;
    }

    static {
        zzdip zzdip = new zzdip();
        zzgwf = zzdip;
        zzdqw.zza(zzdip.class, zzdip);
    }
}
