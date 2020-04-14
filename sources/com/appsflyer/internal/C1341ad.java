package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.appsflyer.internal.ad */
public final class C1341ad {

    /* renamed from: ˏ */
    final Context f3429;

    public C1341ad(Context context) {
        this.f3429 = context;
    }

    /* renamed from: ˋ */
    public final String mo10794() {
        String str;
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        try {
            str = (String) newSingleThreadExecutor.submit(new Callable<String>() {
                public final /* synthetic */ Object call() throws Exception {
                    ProviderInfo resolveContentProvider = C1341ad.this.f3429.getPackageManager().resolveContentProvider("com.facebook.katana.provider.AttributionIdProvider", 128);
                    String str = null;
                    if (resolveContentProvider != null) {
                        X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(C1341ad.this.f3429.getPackageManager().getPackageInfo(resolveContentProvider.packageName, 64).signatures[0].toByteArray()));
                        MessageDigest instance = MessageDigest.getInstance("SHA1");
                        instance.update(x509Certificate.getEncoded());
                        if (Base64.encodeToString(instance.digest(), 2).equals("ijxLJi1yGs1JpL+X1SExmchvork=")) {
                            String str2 = "aid";
                            Cursor query = C1341ad.this.f3429.getContentResolver().query(Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider"), new String[]{str2}, null, null, null);
                            if (query != null && query.moveToFirst()) {
                                str = query.getString(query.getColumnIndex(str2));
                            }
                            if (query != null) {
                                query.close();
                            }
                        }
                    }
                    return str;
                }
            }).get(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException unused) {
            str = null;
        }
        newSingleThreadExecutor.shutdown();
        return str;
    }
}
