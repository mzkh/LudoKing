package com.adcolony.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.appsflyer.share.Constants;
import com.tapjoy.TJAdUnitConstants.String;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.CRC32;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.at */
class C0543at {

    /* renamed from: a */
    static final int f401a = 128;

    /* renamed from: b */
    static ExecutorService f402b = Executors.newSingleThreadExecutor();

    /* renamed from: c */
    static Handler f403c;

    /* renamed from: com.adcolony.sdk.at$a */
    static class C0545a {

        /* renamed from: a */
        double f407a;

        /* renamed from: b */
        double f408b = ((double) System.currentTimeMillis());

        C0545a(double d) {
            mo8373a(d);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo8372a() {
            mo8373a(this.f407a);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo8373a(double d) {
            this.f407a = d;
            double currentTimeMillis = (double) System.currentTimeMillis();
            Double.isNaN(currentTimeMillis);
            this.f408b = (currentTimeMillis / 1000.0d) + this.f407a;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public boolean mo8374b() {
            return mo8375c() == 0.0d;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public double mo8375c() {
            double currentTimeMillis = (double) System.currentTimeMillis();
            Double.isNaN(currentTimeMillis);
            double d = this.f408b - (currentTimeMillis / 1000.0d);
            if (d <= 0.0d) {
                return 0.0d;
            }
            return d;
        }

        public String toString() {
            return C0543at.m300a(mo8375c(), 2);
        }
    }

    C0543at() {
    }

    /* renamed from: a */
    static boolean m310a(String str) {
        Application application;
        Context c = C0476a.m85c();
        if (c == null) {
            return false;
        }
        try {
            if (c instanceof Application) {
                application = (Application) c;
            } else {
                application = ((Activity) c).getApplication();
            }
            application.getPackageManager().getApplicationInfo(str, 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    static boolean m305a() {
        boolean z = false;
        try {
            C0666j a = C0476a.m77a();
            StringBuilder sb = new StringBuilder();
            sb.append(a.mo8581o().mo8318g());
            sb.append("026ae9c9824b3e483fa6c71fa88f57ae27816141");
            File file = new File(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a.mo8581o().mo8318g());
            sb2.append("7bf3a1e7bbd31e612eda3310c2cdb8075c43c6b5");
            File file2 = new File(sb2.toString());
            boolean a2 = a.mo8576j().mo8697a(file);
            boolean a3 = a.mo8576j().mo8697a(file2);
            if (a2 && a3) {
                z = true;
            }
            return z;
        } catch (Exception unused) {
            new C0749a().mo8726a("Unable to delete controller or launch response.").mo8728a(C0748w.f1172h);
            return false;
        }
    }

    /* renamed from: b */
    static String m317b() {
        Context c = C0476a.m85c();
        String str = "1.0";
        if (c == null) {
            return str;
        }
        try {
            return c.getPackageManager().getPackageInfo(c.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            new C0749a().mo8726a("Failed to retrieve package info.").mo8728a(C0748w.f1172h);
            return str;
        }
    }

    /* renamed from: c */
    static int m320c() {
        Context c = C0476a.m85c();
        if (c == null) {
            return 0;
        }
        try {
            return c.getPackageManager().getPackageInfo(c.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            new C0749a().mo8726a("Failed to retrieve package info.").mo8728a(C0748w.f1172h);
            return 0;
        }
    }

    /* renamed from: d */
    static String m323d() {
        Application application;
        Context c = C0476a.m85c();
        String str = "";
        if (c == null) {
            return str;
        }
        if (c instanceof Application) {
            application = (Application) c;
        } else {
            application = ((Activity) c).getApplication();
        }
        PackageManager packageManager = application.getPackageManager();
        try {
            CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(c.getPackageName(), 0));
            return applicationLabel == null ? str : applicationLabel.toString();
        } catch (Exception unused) {
            new C0749a().mo8726a("Failed to retrieve application label.").mo8728a(C0748w.f1172h);
            return str;
        }
    }

    /* renamed from: b */
    static int m316b(String str) {
        CRC32 crc32 = new CRC32();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            crc32.update(str.charAt(i));
        }
        return (int) crc32.getValue();
    }

    /* renamed from: c */
    static String m322c(String str) {
        try {
            return C0574aw.m469a(str);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: e */
    static String m326e() {
        return UUID.randomUUID().toString();
    }

    /* renamed from: a */
    static JSONArray m303a(int i) {
        JSONArray b = C0746u.m909b();
        for (int i2 = 0; i2 < i; i2++) {
            C0746u.m898a(b, m326e());
        }
        return b;
    }

    /* renamed from: a */
    static boolean m313a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        Arrays.sort(strArr);
        Arrays.sort(strArr2);
        return Arrays.equals(strArr, strArr2);
    }

    /* renamed from: a */
    static boolean m309a(Runnable runnable) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null) {
            return false;
        }
        if (f403c == null) {
            f403c = new Handler(mainLooper);
        }
        if (mainLooper == Looper.myLooper()) {
            runnable.run();
        } else {
            f403c.post(runnable);
        }
        return true;
    }

    /* renamed from: f */
    static double m328f() {
        double currentTimeMillis = (double) System.currentTimeMillis();
        Double.isNaN(currentTimeMillis);
        return currentTimeMillis / 1000.0d;
    }

    /* renamed from: d */
    static boolean m325d(String str) {
        if (str != null && str.length() <= 128) {
            return true;
        }
        new C0749a().mo8726a("String must be non-null and the max length is 128 characters.").mo8728a(C0748w.f1169e);
        return false;
    }

    /* renamed from: a */
    static boolean m308a(AudioManager audioManager) {
        boolean z = false;
        if (audioManager == null) {
            new C0749a().mo8726a("isAudioEnabled() called with a null AudioManager").mo8728a(C0748w.f1172h);
            return false;
        }
        try {
            if (audioManager.getStreamVolume(3) > 0) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            new C0749a().mo8726a("Exception occurred when accessing AudioManager.getStreamVolume: ").mo8726a(e.toString()).mo8728a(C0748w.f1172h);
            return false;
        }
    }

    /* renamed from: b */
    static double m314b(AudioManager audioManager) {
        if (audioManager == null) {
            new C0749a().mo8726a("getAudioVolume() called with a null AudioManager").mo8728a(C0748w.f1172h);
            return 0.0d;
        }
        try {
            double streamVolume = (double) audioManager.getStreamVolume(3);
            double streamMaxVolume = (double) audioManager.getStreamMaxVolume(3);
            if (streamMaxVolume == 0.0d) {
                return 0.0d;
            }
            Double.isNaN(streamVolume);
            Double.isNaN(streamMaxVolume);
            return streamVolume / streamMaxVolume;
        } catch (Exception e) {
            new C0749a().mo8726a("Exception occurred when accessing AudioManager: ").mo8726a(e.toString()).mo8728a(C0748w.f1172h);
            return 0.0d;
        }
    }

    /* renamed from: a */
    static AudioManager m299a(Context context) {
        if (context != null) {
            return (AudioManager) context.getSystemService("audio");
        }
        new C0749a().mo8726a("getAudioManager called with a null Context").mo8728a(C0748w.f1172h);
        return null;
    }

    /* renamed from: e */
    static void m327e(String str) {
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    new C0749a().mo8726a(">").mo8726a(file.getAbsolutePath()).mo8728a(C0748w.f1166b);
                    m327e(file.getAbsolutePath());
                } else {
                    new C0749a().mo8726a(file.getAbsolutePath()).mo8728a(C0748w.f1166b);
                }
            }
        }
    }

    /* renamed from: a */
    static String m300a(double d, int i) {
        StringBuilder sb = new StringBuilder();
        m304a(d, i, sb);
        return sb.toString();
    }

    /* renamed from: a */
    static void m304a(double d, int i, StringBuilder sb) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            sb.append(d);
            return;
        }
        if (d < 0.0d) {
            d = -d;
            sb.append('-');
        }
        if (i == 0) {
            sb.append(Math.round(d));
            return;
        }
        long pow = (long) Math.pow(10.0d, (double) i);
        double d2 = (double) pow;
        Double.isNaN(d2);
        long round = Math.round(d * d2);
        sb.append(round / pow);
        sb.append('.');
        long j = round % pow;
        if (j == 0) {
            for (int i2 = 0; i2 < i; i2++) {
                sb.append('0');
            }
            return;
        }
        for (long j2 = j * 10; j2 < pow; j2 *= 10) {
            sb.append('0');
        }
        sb.append(j);
    }

    /* renamed from: f */
    static String m329f(String str) {
        return str == null ? "" : URLDecoder.decode(str);
    }

    /* renamed from: b */
    static String m318b(@NonNull Context context) {
        try {
            return context.getPackageName();
        } catch (Exception unused) {
            return "unknown";
        }
    }

    /* renamed from: a */
    static String m301a(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /* renamed from: g */
    static int m330g(String str) {
        try {
            return (int) Long.parseLong(str, 16);
        } catch (NumberFormatException unused) {
            new C0749a().mo8726a("Unable to parse '").mo8726a(str).mo8726a("' as a color.").mo8728a(C0748w.f1170f);
            return ViewCompat.MEASURED_STATE_MASK;
        }
    }

    /* renamed from: c */
    static int m321c(Context context) {
        if (context == null) {
            return 0;
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* renamed from: g */
    static boolean m331g() {
        Context c = C0476a.m85c();
        return c != null && VERSION.SDK_INT >= 24 && (c instanceof Activity) && ((Activity) c).isInMultiWindowMode();
    }

    /* renamed from: a */
    static boolean m312a(String str, File file) {
        String str2 = "Exception on closing MD5 input stream";
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                    } catch (IOException e) {
                        throw new RuntimeException("Unable to process file for MD5", e);
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                            new C0749a().mo8726a(str2).mo8728a(C0748w.f1172h);
                        }
                        throw th;
                    }
                }
                boolean equals = str.equals(String.format("%40s", new Object[]{new BigInteger(1, instance.digest()).toString(16)}).replace(' ', '0'));
                try {
                    fileInputStream.close();
                } catch (IOException unused2) {
                    new C0749a().mo8726a(str2).mo8728a(C0748w.f1172h);
                }
                return equals;
            } catch (FileNotFoundException unused3) {
                new C0749a().mo8726a("Exception while getting FileInputStream").mo8728a(C0748w.f1172h);
                return false;
            }
        } catch (NoSuchAlgorithmException unused4) {
            new C0749a().mo8726a("Exception while getting Digest").mo8728a(C0748w.f1172h);
            return false;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
        return new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", java.util.Locale.US).parse(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        return new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.US).parse(r5);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0020 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0025 */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.Date m333h(java.lang.String r5) {
        /*
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r1 = java.util.Locale.US
            java.lang.String r2 = "yyyy-MM-dd'T'HH:mmZ"
            r0.<init>(r2, r1)
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.util.Locale r2 = java.util.Locale.US
            java.lang.String r3 = "yyyy-MM-dd'T'HH:mm:ssZ"
            r1.<init>(r3, r2)
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.util.Locale r3 = java.util.Locale.US
            java.lang.String r4 = "yyyy-MM-dd"
            r2.<init>(r4, r3)
            java.util.Date r5 = r0.parse(r5)     // Catch:{ Exception -> 0x0020 }
            return r5
        L_0x0020:
            java.util.Date r5 = r1.parse(r5)     // Catch:{ Exception -> 0x0025 }
            return r5
        L_0x0025:
            java.util.Date r5 = r2.parse(r5)     // Catch:{ Exception -> 0x002a }
            return r5
        L_0x002a:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C0543at.m333h(java.lang.String):java.util.Date");
    }

    /* renamed from: a */
    static String m302a(JSONArray jSONArray) throws JSONException {
        String str = "";
        for (int i = 0; i < jSONArray.length(); i++) {
            if (i > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(",");
                str = sb.toString();
            }
            switch (jSONArray.getInt(i)) {
                case 1:
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append("MO");
                    str = sb2.toString();
                    break;
                case 2:
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str);
                    sb3.append("TU");
                    str = sb3.toString();
                    break;
                case 3:
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str);
                    sb4.append("WE");
                    str = sb4.toString();
                    break;
                case 4:
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str);
                    sb5.append("TH");
                    str = sb5.toString();
                    break;
                case 5:
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(str);
                    sb6.append("FR");
                    str = sb6.toString();
                    break;
                case 6:
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(str);
                    sb7.append("SA");
                    str = sb7.toString();
                    break;
                case 7:
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(str);
                    sb8.append("SU");
                    str = sb8.toString();
                    break;
            }
        }
        return str;
    }

    /* renamed from: b */
    static String m319b(JSONArray jSONArray) throws JSONException {
        String str = "";
        for (int i = 0; i < jSONArray.length(); i++) {
            if (i > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(",");
                str = sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(jSONArray.getInt(i));
            str = sb2.toString();
        }
        return str;
    }

    /* renamed from: a */
    static boolean m307a(Intent intent, boolean z) {
        try {
            Context c = C0476a.m85c();
            if (c == null) {
                return false;
            }
            AdColonyInterstitial v = C0476a.m77a().mo8588v();
            if (v != null && v.mo8143g()) {
                v.mo8146h().mo8251d();
            }
            if (z) {
                c.startActivity(Intent.createChooser(intent, "Handle this via..."));
            } else {
                c.startActivity(intent);
            }
            return true;
        } catch (Exception e) {
            new C0749a().mo8726a(e.toString()).mo8728a(C0748w.f1170f);
            return false;
        }
    }

    /* renamed from: a */
    static boolean m306a(Intent intent) {
        return m307a(intent, false);
    }

    /* renamed from: a */
    static boolean m311a(final String str, final int i) {
        final Context c = C0476a.m85c();
        if (c == null) {
            return false;
        }
        m309a((Runnable) new Runnable() {
            public void run() {
                Toast.makeText(c, str, i).show();
            }
        });
        return true;
    }

    /* renamed from: k */
    private static void m336k(String str) {
        Context c = C0476a.m85c();
        if (c != null) {
            try {
                InputStream open = c.getAssets().open(str);
                StringBuilder sb = new StringBuilder();
                sb.append(C0476a.m77a().mo8581o().mo8315d());
                sb.append(str);
                FileOutputStream fileOutputStream = new FileOutputStream(sb.toString());
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                open.close();
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception e) {
                new C0749a().mo8726a("Failed copy hardcoded ad unit file named: ").mo8726a(str).mo8726a(" with error: ").mo8726a(e.getMessage()).mo8728a(C0748w.f1172h);
            }
        }
    }

    /* renamed from: i */
    public static void m334i(String str) {
        Context c = C0476a.m85c();
        if (c != null) {
            try {
                String[] list = c.getAssets().list(str);
                if (list.length == 0) {
                    m336k(str);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(C0476a.m77a().mo8581o().mo8315d());
                    sb.append(str);
                    File file = new File(sb.toString());
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    for (String append : list) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(Constants.URL_PATH_DELIMITER);
                        sb2.append(append);
                        m334i(sb2.toString());
                    }
                }
            } catch (IOException e) {
                new C0749a().mo8726a("Failed copy hardcoded ad unit with error: ").mo8726a(e.getMessage()).mo8728a(C0748w.f1172h);
            }
        }
    }

    /* renamed from: a */
    static int m298a(C0509ao aoVar) {
        String str = "AppVersion";
        int i = 0;
        try {
            Context c = C0476a.m85c();
            if (c != null) {
                int i2 = (int) (c.getPackageManager().getPackageInfo(c.getPackageName(), 0).lastUpdateTime / 1000);
                StringBuilder sb = new StringBuilder();
                sb.append(aoVar.mo8318g());
                sb.append(str);
                boolean exists = new File(sb.toString()).exists();
                String str2 = "last_update";
                boolean z = true;
                if (exists) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(aoVar.mo8318g());
                    sb2.append(str);
                    if (C0746u.m914c(C0746u.m916c(sb2.toString()), str2) != i2) {
                        i = 1;
                    } else {
                        z = false;
                    }
                } else {
                    i = 2;
                }
                if (z) {
                    JSONObject a = C0746u.m892a();
                    C0746u.m912b(a, str2, i2);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(aoVar.mo8318g());
                    sb3.append(str);
                    C0746u.m923h(a, sb3.toString());
                }
            }
        } catch (Exception unused) {
        }
        return i;
    }

    /* renamed from: d */
    static JSONArray m324d(Context context) {
        JSONArray b = C0746u.m909b();
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
                if (packageInfo.requestedPermissions != null) {
                    b = C0746u.m909b();
                    for (String put : packageInfo.requestedPermissions) {
                        b.put(put);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return b;
    }

    /* renamed from: h */
    static String m332h() {
        Context c = C0476a.m85c();
        boolean z = c instanceof Activity;
        String str = String.LANDSCAPE;
        return (!z || c.getResources().getConfiguration().orientation != 1) ? str : String.PORTRAIT;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int m335j(java.lang.String r5) {
        /*
            int r0 = r5.hashCode()
            r1 = 729267099(0x2b77bb9b, float:8.8012383E-13)
            r2 = 0
            r3 = -1
            r4 = 1
            if (r0 == r1) goto L_0x001c
            r1 = 1430647483(0x5545f2bb, float:1.36028944E13)
            if (r0 == r1) goto L_0x0012
            goto L_0x0026
        L_0x0012:
            java.lang.String r0 = "landscape"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0026
            r5 = 1
            goto L_0x0027
        L_0x001c:
            java.lang.String r0 = "portrait"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0026
            r5 = 0
            goto L_0x0027
        L_0x0026:
            r5 = -1
        L_0x0027:
            if (r5 == 0) goto L_0x002e
            if (r5 == r4) goto L_0x002d
            r2 = -1
            goto L_0x002e
        L_0x002d:
            r2 = 1
        L_0x002e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C0543at.m335j(java.lang.String):int");
    }

    /* renamed from: a */
    static int m297a(View view) {
        if (view == null) {
            return 0;
        }
        int[] iArr = {0, 0};
        view.getLocationOnScreen(iArr);
        return (int) (((float) iArr[0]) / C0476a.m77a().mo8579m().mo8640p());
    }

    /* renamed from: b */
    static int m315b(View view) {
        if (view == null) {
            return 0;
        }
        int[] iArr = {0, 0};
        view.getLocationOnScreen(iArr);
        return (int) (((float) iArr[1]) / C0476a.m77a().mo8579m().mo8640p());
    }
}
