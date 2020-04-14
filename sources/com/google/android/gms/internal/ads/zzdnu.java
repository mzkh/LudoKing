package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdnt;
import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdnu<T_WRAPPER extends zzdnt<T_ENGINE>, T_ENGINE> {
    private static final Logger logger = Logger.getLogger(zzdnu.class.getName());
    private static final List<Provider> zzhdy;
    public static final zzdnu<zzdnw, Cipher> zzhdz = new zzdnu<>(new zzdnw());
    public static final zzdnu<zzdoa, Mac> zzhea = new zzdnu<>(new zzdoa());
    public static final zzdnu<zzdoc, Signature> zzheb = new zzdnu<>(new zzdoc());
    public static final zzdnu<zzdnz, MessageDigest> zzhec = new zzdnu<>(new zzdnz());
    public static final zzdnu<zzdnv, KeyAgreement> zzhed = new zzdnu<>(new zzdnv());
    public static final zzdnu<zzdnx, KeyPairGenerator> zzhee = new zzdnu<>(new zzdnx());
    public static final zzdnu<zzdny, KeyFactory> zzhef = new zzdnu<>(new zzdny());
    private T_WRAPPER zzheg;
    private List<Provider> zzheh = zzhdy;
    private boolean zzhei = true;

    private zzdnu(T_WRAPPER t_wrapper) {
        this.zzheg = t_wrapper;
    }

    public final T_ENGINE zzhf(String str) throws GeneralSecurityException {
        Throwable th = null;
        for (Provider zza : this.zzheh) {
            try {
                return this.zzheg.zza(str, zza);
            } catch (Exception e) {
                if (th == null) {
                    th = e;
                }
            }
        }
        if (this.zzhei) {
            return this.zzheg.zza(str, null);
        }
        throw new GeneralSecurityException("No good Provider found.", th);
    }

    static {
        if (zzdos.zzaxd()) {
            String[] strArr = {ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    logger.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", new Object[]{str}));
                }
            }
            zzhdy = arrayList;
        } else {
            zzhdy = new ArrayList();
        }
    }
}
