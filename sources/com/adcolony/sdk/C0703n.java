package com.adcolony.sdk;

import android.content.Context;
import com.appsflyer.share.Constants;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.n */
class C0703n implements Runnable {

    /* renamed from: a */
    String f1042a;

    /* renamed from: b */
    String f1043b;

    /* renamed from: c */
    boolean f1044c;

    /* renamed from: d */
    int f1045d;

    /* renamed from: e */
    int f1046e;

    /* renamed from: f */
    private HttpURLConnection f1047f;

    /* renamed from: g */
    private InputStream f1048g;

    /* renamed from: h */
    private C0480ab f1049h;

    /* renamed from: i */
    private C0704a f1050i;

    /* renamed from: j */
    private final int f1051j = 4096;

    /* renamed from: k */
    private String f1052k;

    /* renamed from: l */
    private int f1053l = 0;

    /* renamed from: m */
    private boolean f1054m = false;

    /* renamed from: n */
    private Map<String, List<String>> f1055n;

    /* renamed from: o */
    private String f1056o;

    /* renamed from: p */
    private String f1057p;

    /* renamed from: com.adcolony.sdk.n$a */
    interface C0704a {
        /* renamed from: a */
        void mo8554a(C0703n nVar, C0480ab abVar, Map<String, List<String>> map);
    }

    C0703n(C0480ab abVar, C0704a aVar) {
        String str = "";
        this.f1056o = str;
        this.f1057p = str;
        this.f1042a = str;
        this.f1043b = str;
        this.f1049h = abVar;
        this.f1050i = aVar;
    }

    public void run() {
        boolean z = false;
        this.f1044c = false;
        try {
            if (m800b()) {
                this.f1044c = m801c();
                if (this.f1049h.mo8221d().equals("WebServices.post") && this.f1046e != 200) {
                    this.f1044c = false;
                }
            }
        } catch (MalformedURLException e) {
            new C0749a().mo8726a("MalformedURLException: ").mo8726a(e.toString()).mo8728a(C0748w.f1172h);
            this.f1044c = true;
        } catch (OutOfMemoryError unused) {
            C0749a a = new C0749a().mo8726a("Out of memory error - disabling AdColony. (").mo8724a(this.f1045d).mo8726a(Constants.URL_PATH_DELIMITER).mo8724a(this.f1053l);
            StringBuilder sb = new StringBuilder();
            sb.append("): ");
            sb.append(this.f1042a);
            a.mo8726a(sb.toString()).mo8728a(C0748w.f1171g);
            C0476a.m77a().mo8556a(true);
        } catch (IOException e2) {
            new C0749a().mo8726a("Download of ").mo8726a(this.f1042a).mo8726a(" failed: ").mo8726a(e2.toString()).mo8728a(C0748w.f1170f);
            int i = this.f1046e;
            if (i == 0) {
                i = 504;
            }
            this.f1046e = i;
        } catch (IllegalStateException e3) {
            new C0749a().mo8726a("okhttp error: ").mo8726a(e3.toString()).mo8728a(C0748w.f1171g);
            e3.printStackTrace();
        } catch (Exception e4) {
            new C0749a().mo8726a("Exception: ").mo8726a(e4.toString()).mo8728a(C0748w.f1171g);
            e4.printStackTrace();
        }
        z = true;
        if (this.f1044c) {
            new C0749a().mo8726a("Downloaded ").mo8726a(this.f1042a).mo8728a(C0748w.f1168d);
        }
        if (z) {
            if (this.f1049h.mo8221d().equals("WebServices.download")) {
                m798a(this.f1057p, this.f1056o);
            }
            this.f1050i.mo8554a(this, this.f1049h, this.f1055n);
        }
    }

    /* renamed from: b */
    private boolean m800b() throws IOException {
        JSONObject c = this.f1049h.mo8220c();
        String b = C0746u.m908b(c, Param.CONTENT_TYPE);
        String b2 = C0746u.m908b(c, "content");
        boolean d = C0746u.m918d(c, "no_redirect");
        this.f1042a = C0746u.m908b(c, "url");
        this.f1056o = C0746u.m908b(c, "filepath");
        StringBuilder sb = new StringBuilder();
        sb.append(C0476a.m77a().mo8581o().mo8317f());
        String str = this.f1056o;
        sb.append(str.substring(str.lastIndexOf(Constants.URL_PATH_DELIMITER) + 1));
        this.f1057p = sb.toString();
        this.f1052k = C0746u.m908b(c, "encoding");
        this.f1053l = C0746u.m888a(c, "max_size", 0);
        this.f1054m = this.f1053l != 0;
        this.f1045d = 0;
        this.f1048g = null;
        this.f1047f = null;
        this.f1055n = null;
        if (!this.f1042a.startsWith("file://")) {
            this.f1047f = (HttpURLConnection) new URL(this.f1042a).openConnection();
            this.f1047f.setInstanceFollowRedirects(!d);
            String str2 = "UTF-8";
            this.f1047f.setRequestProperty("Accept-Charset", str2);
            this.f1047f.setRequestProperty("User-Agent", C0476a.m77a().mo8579m().mo8616G());
            if (!b.equals("")) {
                this.f1047f.setRequestProperty("Content-Type", b);
            }
            if (this.f1049h.mo8221d().equals("WebServices.post")) {
                this.f1047f.setDoOutput(true);
                this.f1047f.setFixedLengthStreamingMode(b2.getBytes(str2).length);
                new PrintStream(this.f1047f.getOutputStream()).print(b2);
            }
        } else if (this.f1042a.startsWith("file:///android_asset/")) {
            Context c2 = C0476a.m85c();
            if (c2 != null) {
                this.f1048g = c2.getAssets().open(this.f1042a.substring(22));
            }
        } else {
            this.f1048g = new FileInputStream(this.f1042a.substring(7));
        }
        if (this.f1047f == null && this.f1048g == null) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private boolean m801c() throws Exception {
        OutputStream outputStream;
        String d = this.f1049h.mo8221d();
        if (this.f1048g != null) {
            outputStream = this.f1056o.length() == 0 ? new ByteArrayOutputStream(4096) : new FileOutputStream(new File(this.f1056o).getAbsolutePath());
        } else if (d.equals("WebServices.download")) {
            this.f1048g = this.f1047f.getInputStream();
            outputStream = new FileOutputStream(this.f1057p);
        } else if (d.equals("WebServices.get")) {
            this.f1048g = this.f1047f.getInputStream();
            outputStream = new ByteArrayOutputStream(4096);
        } else if (d.equals("WebServices.post")) {
            this.f1047f.connect();
            this.f1048g = this.f1047f.getResponseCode() == 200 ? this.f1047f.getInputStream() : this.f1047f.getErrorStream();
            outputStream = new ByteArrayOutputStream(4096);
        } else {
            outputStream = null;
        }
        HttpURLConnection httpURLConnection = this.f1047f;
        if (httpURLConnection != null) {
            this.f1046e = httpURLConnection.getResponseCode();
            this.f1055n = this.f1047f.getHeaderFields();
        }
        return m799a(this.f1048g, outputStream);
    }

    /* renamed from: a */
    private boolean m799a(InputStream inputStream, OutputStream outputStream) throws Exception {
        BufferedInputStream bufferedInputStream;
        Throwable e;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 4096);
                    if (read != -1) {
                        this.f1045d += read;
                        if (this.f1054m) {
                            if (this.f1045d > this.f1053l) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Data exceeds expected maximum (");
                                sb.append(this.f1045d);
                                sb.append(Constants.URL_PATH_DELIMITER);
                                sb.append(this.f1053l);
                                sb.append("): ");
                                sb.append(this.f1047f.getURL().toString());
                                throw new Exception(sb.toString());
                            }
                        }
                        outputStream.write(bArr, 0, read);
                    } else {
                        String str = "UTF-8";
                        if (this.f1052k != null && !this.f1052k.isEmpty()) {
                            str = this.f1052k;
                        }
                        if (outputStream instanceof ByteArrayOutputStream) {
                            this.f1043b = ((ByteArrayOutputStream) outputStream).toString(str);
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        bufferedInputStream.close();
                        return true;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                }
            }
        } catch (Exception e3) {
            Throwable th2 = e3;
            bufferedInputStream = null;
            e = th2;
            throw e;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            bufferedInputStream = null;
            th = th4;
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    private void m798a(String str, String str2) {
        try {
            String substring = str2.substring(0, str2.lastIndexOf(Constants.URL_PATH_DELIMITER) + 1);
            if (str2 != null && !"".equals(str2) && !substring.equals(C0476a.m77a().mo8581o().mo8317f()) && !new File(str).renameTo(new File(str2))) {
                C0749a a = new C0749a().mo8726a("Moving of ");
                if (str == null) {
                    str = "temp folder's asset file";
                }
                a.mo8726a(str).mo8726a(" failed.").mo8728a(C0748w.f1170f);
            }
        } catch (Exception e) {
            new C0749a().mo8726a("Exception: ").mo8726a(e.toString()).mo8728a(C0748w.f1171g);
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0480ab mo8666a() {
        return this.f1049h;
    }
}
