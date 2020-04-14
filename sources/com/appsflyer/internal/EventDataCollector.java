package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class EventDataCollector {

    /* renamed from: ˏ */
    private final Context f3409;

    public EventDataCollector(Context context) {
        this.f3409 = context;
    }

    public String signature() throws CertificateException, NoSuchAlgorithmException, NameNotFoundException {
        X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(this.f3409.getPackageManager().getPackageInfo(this.f3409.getPackageName(), 64).signatures[0].toByteArray()));
        MessageDigest instance = MessageDigest.getInstance("SHA256");
        instance.update(x509Certificate.getEncoded());
        return String.format("%032X", new Object[]{new BigInteger(1, instance.digest())});
    }
}
