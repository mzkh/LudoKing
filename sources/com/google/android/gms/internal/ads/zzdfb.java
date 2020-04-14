package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdjy.zza;
import com.google.android.gms.internal.ads.zzdjy.zzb;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdfb {
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    public static zzdjy zzc(zzdjx zzdjx) {
        zza zzev = zzdjy.zzaus().zzev(zzdjx.zzaui());
        for (zzdjx.zza zza : zzdjx.zzauj()) {
            zzev.zzb((zzb) ((zzdqw) zzb.zzauu().zzhc(zza.zzauo().zzatu()).zzc(zza.zzaps()).zzc(zza.zzapt()).zzew(zza.zzaup()).zzazr()));
        }
        return (zzdjy) ((zzdqw) zzev.zzazr());
    }

    public static void zzd(zzdjx zzdjx) throws GeneralSecurityException {
        int zzaui = zzdjx.zzaui();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzdjx.zza zza : zzdjx.zzauj()) {
            if (zza.zzaps() == zzdjr.ENABLED) {
                if (!zza.zzaun()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(zza.zzaup())}));
                } else if (zza.zzapt() == zzdkj.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(zza.zzaup())}));
                } else if (zza.zzaps() != zzdjr.UNKNOWN_STATUS) {
                    if (zza.zzaup() == zzaui) {
                        if (!z) {
                            z = true;
                        } else {
                            throw new GeneralSecurityException("keyset contains multiple primary keys");
                        }
                    }
                    if (zza.zzauo().zzatw() != zzdjn.zzb.ASYMMETRIC_PUBLIC) {
                        z2 = false;
                    }
                    i++;
                } else {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(zza.zzaup())}));
                }
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        } else if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }

    public static byte[] zzg(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
