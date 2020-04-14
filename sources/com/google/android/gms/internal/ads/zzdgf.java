package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdgf {
    public static void zza(zzdip zzdip) throws GeneralSecurityException {
        zzdno.zza(zza(zzdip.zzasq().zzatb()));
        zza(zzdip.zzasq().zzaqp());
        if (zzdip.zzass() != zzdhz.UNKNOWN_FORMAT) {
            zzdey.zza(zzdip.zzasr().zzasl());
            return;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }

    public static String zza(zzdjg zzdjg) throws NoSuchAlgorithmException {
        int i = zzdge.zzgtk[zzdjg.ordinal()];
        if (i == 1) {
            return "HmacSha1";
        }
        if (i == 2) {
            return "HmacSha256";
        }
        if (i == 3) {
            return "HmacSha512";
        }
        String valueOf = String.valueOf(zzdjg);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("hash unsupported for HMAC: ");
        sb.append(valueOf);
        throw new NoSuchAlgorithmException(sb.toString());
    }

    public static zzdnq zza(zzdjb zzdjb) throws GeneralSecurityException {
        int i = zzdge.zzgtl[zzdjb.ordinal()];
        if (i == 1) {
            return zzdnq.NIST_P256;
        }
        if (i == 2) {
            return zzdnq.NIST_P384;
        }
        if (i == 3) {
            return zzdnq.NIST_P521;
        }
        String valueOf = String.valueOf(zzdjb);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
        sb.append("unknown curve type: ");
        sb.append(valueOf);
        throw new GeneralSecurityException(sb.toString());
    }

    public static zzdns zza(zzdhz zzdhz) throws GeneralSecurityException {
        int i = zzdge.zzgtm[zzdhz.ordinal()];
        if (i == 1) {
            return zzdns.UNCOMPRESSED;
        }
        if (i == 2) {
            return zzdns.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
        }
        if (i == 3) {
            return zzdns.COMPRESSED;
        }
        String valueOf = String.valueOf(zzdhz);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("unknown point format: ");
        sb.append(valueOf);
        throw new GeneralSecurityException(sb.toString());
    }
}
