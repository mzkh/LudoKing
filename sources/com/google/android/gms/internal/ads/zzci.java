package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbo.zza;
import com.google.android.gms.internal.ads.zzbo.zza.zzb;
import com.google.android.gms.internal.ads.zzbo.zza.zzd;
import com.google.android.gms.internal.ads.zzbo.zzc;
import com.google.android.gms.internal.ads.zzbo.zzg;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzci {
    private static boolean zznt = false;
    /* access modifiers changed from: private */
    public static MessageDigest zznu;
    private static final Object zznv = new Object();
    private static final Object zznw = new Object();
    static CountDownLatch zznx = new CountDownLatch(1);

    static void zzbx() {
        synchronized (zznw) {
            if (!zznt) {
                zznt = true;
                new Thread(new zzck()).start();
            }
        }
    }

    private static MessageDigest zzby() {
        boolean z;
        zzbx();
        try {
            z = zznx.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            z = false;
        }
        if (!z) {
            return null;
        }
        MessageDigest messageDigest = zznu;
        if (messageDigest == null) {
            return null;
        }
        return messageDigest;
    }

    static String zzj(zza zza, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] bArr;
        byte[] byteArray = zza.toByteArray();
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcni)).booleanValue()) {
            Vector zza2 = zza(byteArray, 255);
            if (zza2 == null || zza2.size() == 0) {
                bArr = zza(zza(zzd.PSN_ENCODE_SIZE_FAIL).toByteArray(), str, true);
            } else {
                zzg.zza zzbj = zzg.zzbj();
                Iterator it = zza2.iterator();
                while (it.hasNext()) {
                    zzbj.zzm(zzdpm.zzy(zza((byte[]) it.next(), str, false)));
                }
                zzbj.zzn(zzdpm.zzy(zzb(byteArray)));
                bArr = ((zzg) ((zzdqw) zzbj.zzazr())).toByteArray();
            }
        } else if (zzed.zzyo != null) {
            bArr = ((zzg) ((zzdqw) zzg.zzbj().zzm(zzdpm.zzy(zzed.zzyo.zzc(byteArray, str != null ? str.getBytes() : new byte[0]))).zza(zzbv.TINK_HYBRID).zzazr())).toByteArray();
        } else {
            throw new GeneralSecurityException();
        }
        return zzcg.zza(bArr, true);
    }

    private static Vector<byte[]> zza(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + 255) - 1) / 255;
        Vector<byte[]> vector = new Vector<>();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 * 255;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > 255 ? i3 + 255 : bArr.length));
                i2++;
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    private static zza zza(zzd zzd) {
        zzb zzal = zza.zzal();
        zzal.zzau((long) zzd.zzab());
        return (zza) ((zzdqw) zzal.zzazr());
    }

    private static byte[] zza(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] bArr2;
        int i = z ? 239 : 255;
        if (bArr.length > i) {
            bArr = zza(zzd.PSN_ENCODE_SIZE_FAIL).toByteArray();
        }
        if (bArr.length < i) {
            byte[] bArr3 = new byte[(i - bArr.length)];
            new SecureRandom().nextBytes(bArr3);
            bArr2 = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).put(bArr3).array();
        } else {
            bArr2 = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            bArr2 = ByteBuffer.allocate(256).put(zzb(bArr2)).put(bArr2).array();
        }
        byte[] bArr4 = new byte[256];
        for (zzcl zza : new zzcj().zzvl) {
            zza.zza(bArr2, bArr4);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzdpc(str.getBytes("UTF-8")).zzx(bArr4);
        }
        return bArr4;
    }

    public static byte[] zzb(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] digest;
        synchronized (zznv) {
            MessageDigest zzby = zzby();
            if (zzby != null) {
                zzby.reset();
                zzby.update(bArr);
                digest = zznu.digest();
            } else {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
        }
        return digest;
    }

    static String zza(String str, String str2, boolean z) {
        byte[] zzb = zzb(str, str2, true);
        if (zzb != null) {
            return zzcg.zza(zzb, true);
        }
        return Integer.toString(7);
    }

    private static byte[] zzb(String str, String str2, boolean z) {
        byte[] bArr;
        zzc.zza zzav = zzc.zzav();
        try {
            String str3 = "ISO-8859-1";
            if (str.length() < 3) {
                bArr = str.getBytes(str3);
            } else {
                bArr = zzcg.zza(str, true);
            }
            zzav.zzg(zzdpm.zzy(bArr));
            zzav.zzh(zzdpm.zzy(str2.length() < 3 ? str2.getBytes(str3) : zzcg.zza(str2, true)));
            return ((zzc) ((zzdqw) zzav.zzazr())).toByteArray();
        } catch (UnsupportedEncodingException | GeneralSecurityException unused) {
            return null;
        }
    }
}
