package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdh {
    private static Cipher zzxb;
    private static final Object zzxc = new Object();
    private static final Object zzxd = new Object();
    private final SecureRandom zzxa = null;

    public zzdh(SecureRandom secureRandom) {
    }

    public final byte[] zzaq(String str) throws zzdk {
        try {
            byte[] zza = zzcg.zza(str, false);
            if (zza.length == 32) {
                byte[] bArr = new byte[16];
                ByteBuffer.wrap(zza, 4, 16).get(bArr);
                for (int i = 0; i < 16; i++) {
                    bArr[i] = (byte) (bArr[i] ^ 68);
                }
                return bArr;
            }
            throw new zzdk(this);
        } catch (IllegalArgumentException e) {
            throw new zzdk(this, e);
        }
    }

    public final String zzb(byte[] bArr, byte[] bArr2) throws zzdk {
        byte[] doFinal;
        byte[] iv;
        if (bArr.length == 16) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                synchronized (zzxc) {
                    getCipher().init(1, secretKeySpec, null);
                    doFinal = getCipher().doFinal(bArr2);
                    iv = getCipher().getIV();
                }
                int length = doFinal.length + iv.length;
                ByteBuffer allocate = ByteBuffer.allocate(length);
                allocate.put(iv).put(doFinal);
                allocate.flip();
                byte[] bArr3 = new byte[length];
                allocate.get(bArr3);
                return zzcg.zza(bArr3, false);
            } catch (NoSuchAlgorithmException e) {
                throw new zzdk(this, e);
            } catch (InvalidKeyException e2) {
                throw new zzdk(this, e2);
            } catch (IllegalBlockSizeException e3) {
                throw new zzdk(this, e3);
            } catch (NoSuchPaddingException e4) {
                throw new zzdk(this, e4);
            } catch (BadPaddingException e5) {
                throw new zzdk(this, e5);
            }
        } else {
            throw new zzdk(this);
        }
    }

    public final byte[] zza(byte[] bArr, String str) throws zzdk {
        byte[] doFinal;
        if (bArr.length == 16) {
            try {
                byte[] zza = zzcg.zza(str, false);
                if (zza.length > 16) {
                    ByteBuffer allocate = ByteBuffer.allocate(zza.length);
                    allocate.put(zza);
                    allocate.flip();
                    byte[] bArr2 = new byte[16];
                    byte[] bArr3 = new byte[(zza.length - 16)];
                    allocate.get(bArr2);
                    allocate.get(bArr3);
                    SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                    synchronized (zzxc) {
                        getCipher().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                        doFinal = getCipher().doFinal(bArr3);
                    }
                    return doFinal;
                }
                throw new zzdk(this);
            } catch (NoSuchAlgorithmException e) {
                throw new zzdk(this, e);
            } catch (InvalidKeyException e2) {
                throw new zzdk(this, e2);
            } catch (IllegalBlockSizeException e3) {
                throw new zzdk(this, e3);
            } catch (NoSuchPaddingException e4) {
                throw new zzdk(this, e4);
            } catch (BadPaddingException e5) {
                throw new zzdk(this, e5);
            } catch (InvalidAlgorithmParameterException e6) {
                throw new zzdk(this, e6);
            } catch (IllegalArgumentException e7) {
                throw new zzdk(this, e7);
            }
        } else {
            throw new zzdk(this);
        }
    }

    private static Cipher getCipher() throws NoSuchAlgorithmException, NoSuchPaddingException {
        Cipher cipher;
        synchronized (zzxd) {
            if (zzxb == null) {
                zzxb = Cipher.getInstance("AES/CBC/PKCS5Padding");
            }
            cipher = zzxb;
        }
        return cipher;
    }
}
