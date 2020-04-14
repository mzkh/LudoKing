package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import android.support.p000v4.media.session.PlaybackStateCompat;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1109e;
import com.applovin.impl.sdk.p020c.C1113g;
import com.applovin.impl.sdk.utils.C1245f;
import com.applovin.impl.sdk.utils.C1277l;
import com.appsflyer.share.Constants;
import com.google.ads.mediation.inmobi.InMobiNetworkValues;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.m */
public class C1206m {

    /* renamed from: a */
    private final String f3030a = "FileManager";

    /* renamed from: b */
    private final C1192i f3031b;

    /* renamed from: c */
    private final C1227o f3032c;

    /* renamed from: d */
    private final Object f3033d = new Object();

    C1206m(C1192i iVar) {
        this.f3031b = iVar;
        this.f3032c = iVar.mo10249v();
    }

    /* renamed from: a */
    private long m2677a() {
        long longValue = ((Long) this.f3031b.mo10202a(C1096c.f2344bF)).longValue();
        if (longValue < 0 || !m2681b()) {
            return -1;
        }
        return longValue;
    }

    /* renamed from: a */
    private long m2678a(long j) {
        return j / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    }

    /* renamed from: a */
    private void m2679a(long j, Context context) {
        C1227o oVar;
        String str;
        if (m2681b()) {
            long intValue = (long) ((Integer) this.f3031b.mo10202a(C1096c.f2345bG)).intValue();
            String str2 = "FileManager";
            if (intValue == -1) {
                oVar = this.f3032c;
                str = "Cache has no maximum size set; skipping drop...";
            } else if (m2678a(j) > intValue) {
                this.f3032c.mo10378b(str2, "Cache has exceeded maximum size; dropping...");
                for (File b : m2686e(context)) {
                    m2683b(b);
                }
                this.f3031b.mo10186L().mo10036a(C1113g.f2661f);
            } else {
                oVar = this.f3032c;
                str = "Cache is present but under size limit; not dropping...";
            }
            oVar.mo10378b(str2, str);
        }
    }

    /* renamed from: a */
    private boolean m2680a(File file, String str, List<String> list, boolean z, C1109e eVar) {
        if (file == null || !file.exists() || file.isDirectory()) {
            ByteArrayOutputStream a = mo10272a(str, list, z);
            if (!(eVar == null || a == null)) {
                eVar.mo10020a((long) a.size());
            }
            return mo10277a(a, file);
        }
        C1227o oVar = this.f3032c;
        StringBuilder sb = new StringBuilder();
        sb.append("File exists for ");
        sb.append(str);
        oVar.mo10378b("FileManager", sb.toString());
        if (eVar != null) {
            eVar.mo10021b(file.length());
        }
        return true;
    }

    /* renamed from: b */
    private boolean m2681b() {
        return ((Boolean) this.f3031b.mo10202a(C1096c.f2343bE)).booleanValue();
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:18:0x003b=Splitter:B:18:0x003b, B:24:0x004b=Splitter:B:24:0x004b} */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m2682b(java.io.ByteArrayOutputStream r5, java.io.File r6) {
        /*
            r4 = this;
            com.applovin.impl.sdk.o r0 = r4.f3032c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Writing resource to filesystem: "
            r1.append(r2)
            java.lang.String r2 = r6.getName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "FileManager"
            r0.mo10378b(r2, r1)
            java.lang.Object r0 = r4.f3033d
            monitor-enter(r0)
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x004a, Throwable -> 0x003a }
            r2.<init>(r6)     // Catch:{ IOException -> 0x004a, Throwable -> 0x003a }
            r5.writeTo(r2)     // Catch:{ IOException -> 0x0035, Throwable -> 0x0032, all -> 0x002f }
            r5 = 1
            com.applovin.impl.sdk.i r6 = r4.f3031b     // Catch:{ all -> 0x0060 }
            com.applovin.impl.sdk.utils.C1281o.m3083a(r2, r6)     // Catch:{ all -> 0x0060 }
            goto L_0x0058
        L_0x002f:
            r5 = move-exception
            r1 = r2
            goto L_0x005a
        L_0x0032:
            r5 = move-exception
            r1 = r2
            goto L_0x003b
        L_0x0035:
            r5 = move-exception
            r1 = r2
            goto L_0x004b
        L_0x0038:
            r5 = move-exception
            goto L_0x005a
        L_0x003a:
            r5 = move-exception
        L_0x003b:
            com.applovin.impl.sdk.o r6 = r4.f3032c     // Catch:{ all -> 0x0038 }
            java.lang.String r2 = "FileManager"
            java.lang.String r3 = "Unknown failure to write file."
            r6.mo10379b(r2, r3, r5)     // Catch:{ all -> 0x0038 }
            com.applovin.impl.sdk.i r5 = r4.f3031b     // Catch:{ all -> 0x0060 }
        L_0x0046:
            com.applovin.impl.sdk.utils.C1281o.m3083a(r1, r5)     // Catch:{ all -> 0x0060 }
            goto L_0x0057
        L_0x004a:
            r5 = move-exception
        L_0x004b:
            com.applovin.impl.sdk.o r6 = r4.f3032c     // Catch:{ all -> 0x0038 }
            java.lang.String r2 = "FileManager"
            java.lang.String r3 = "Unable to write data to file."
            r6.mo10379b(r2, r3, r5)     // Catch:{ all -> 0x0038 }
            com.applovin.impl.sdk.i r5 = r4.f3031b     // Catch:{ all -> 0x0060 }
            goto L_0x0046
        L_0x0057:
            r5 = 0
        L_0x0058:
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            return r5
        L_0x005a:
            com.applovin.impl.sdk.i r6 = r4.f3031b     // Catch:{ all -> 0x0060 }
            com.applovin.impl.sdk.utils.C1281o.m3083a(r1, r6)     // Catch:{ all -> 0x0060 }
            throw r5     // Catch:{ all -> 0x0060 }
        L_0x0060:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            throw r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1206m.m2682b(java.io.ByteArrayOutputStream, java.io.File):boolean");
    }

    /* renamed from: b */
    private boolean m2683b(File file) {
        boolean delete;
        C1227o oVar = this.f3032c;
        StringBuilder sb = new StringBuilder();
        sb.append("Removing file ");
        sb.append(file.getName());
        sb.append(" from filesystem...");
        oVar.mo10378b("FileManager", sb.toString());
        synchronized (this.f3033d) {
            try {
                delete = file.delete();
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to remove file ");
                sb2.append(file.getName());
                sb2.append(" from filesystem!");
                this.f3032c.mo10379b("FileManager", sb2.toString(), e);
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
        return delete;
    }

    /* renamed from: c */
    private long m2684c(Context context) {
        long j;
        long a = m2677a();
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        synchronized (this.f3033d) {
            j = 0;
            for (File file : m2686e(context)) {
                boolean z = true;
                if (!(a != -1) || seconds - TimeUnit.MILLISECONDS.toSeconds(file.lastModified()) <= a) {
                    z = false;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("File ");
                    sb.append(file.getName());
                    sb.append(" has expired, removing...");
                    this.f3032c.mo10378b("FileManager", sb.toString());
                    m2683b(file);
                }
                if (z) {
                    this.f3031b.mo10186L().mo10036a(C1113g.f2660e);
                } else {
                    j += file.length();
                }
            }
        }
        return j;
    }

    /* renamed from: d */
    private boolean m2685d(Context context) {
        if (C1245f.m2934e() || C1245f.m2930a("android.permission.WRITE_EXTERNAL_STORAGE", context)) {
            return true;
        }
        C1227o.m2841i("FileManager", "Application lacks required WRITE_EXTERNAL_STORAGE manifest permission.");
        return false;
    }

    /* renamed from: e */
    private List<File> m2686e(Context context) {
        List<File> asList;
        File f = m2687f(context);
        if (!f.isDirectory()) {
            return Collections.emptyList();
        }
        synchronized (this.f3033d) {
            asList = Arrays.asList(f.listFiles());
        }
        return asList;
    }

    /* renamed from: f */
    private File m2687f(Context context) {
        String str = (String) this.f3031b.mo10202a(C1096c.f2342bD);
        String str2 = "al";
        return "external".equals(str) ? m2685d(context) ? new File(context.getExternalFilesDir(null), str2) : new File(context.getCacheDir(), str2) : "file".equals(str) ? new File(context.getFilesDir(), str2) : new File(context.getCacheDir(), str2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:11|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        com.applovin.impl.sdk.utils.C1281o.m3083a((java.io.Closeable) r3, r8.f3031b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        com.applovin.impl.sdk.utils.C1281o.m3083a((java.io.Closeable) r2, r8.f3031b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0048, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:45:0x0095=Splitter:B:45:0x0095, B:29:0x005b=Splitter:B:29:0x005b, B:37:0x006d=Splitter:B:37:0x006d} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.ByteArrayOutputStream mo10271a(java.io.File r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.applovin.impl.sdk.o r1 = r8.f3032c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Reading resource from filesystem: "
            r2.append(r3)
            java.lang.String r3 = r9.getName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "FileManager"
            r1.mo10378b(r3, r2)
            java.lang.Object r1 = r8.f3033d
            monitor-enter(r1)
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0093, IOException -> 0x006b, Throwable -> 0x0059, all -> 0x0056 }
            r2.<init>(r9)     // Catch:{ FileNotFoundException -> 0x0093, IOException -> 0x006b, Throwable -> 0x0059, all -> 0x0056 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0052, Throwable -> 0x0050 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0052, Throwable -> 0x0050 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0052, Throwable -> 0x0050 }
        L_0x0031:
            int r5 = r4.length     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0052, Throwable -> 0x0050 }
            r6 = 0
            int r5 = r2.read(r4, r6, r5)     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0052, Throwable -> 0x0050 }
            if (r5 < 0) goto L_0x0049
            r3.write(r4, r6, r5)     // Catch:{ Exception -> 0x003d }
            goto L_0x0031
        L_0x003d:
            com.applovin.impl.sdk.i r4 = r8.f3031b     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0052, Throwable -> 0x0050 }
            com.applovin.impl.sdk.utils.C1281o.m3083a(r3, r4)     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0052, Throwable -> 0x0050 }
            com.applovin.impl.sdk.i r9 = r8.f3031b     // Catch:{ all -> 0x00bb }
            com.applovin.impl.sdk.utils.C1281o.m3083a(r2, r9)     // Catch:{ all -> 0x00bb }
            monitor-exit(r1)     // Catch:{ all -> 0x00bb }
            return r0
        L_0x0049:
            com.applovin.impl.sdk.i r9 = r8.f3031b     // Catch:{ all -> 0x00bb }
            com.applovin.impl.sdk.utils.C1281o.m3083a(r2, r9)     // Catch:{ all -> 0x00bb }
            monitor-exit(r1)     // Catch:{ all -> 0x00bb }
            return r3
        L_0x0050:
            r9 = move-exception
            goto L_0x005b
        L_0x0052:
            r3 = move-exception
            goto L_0x006d
        L_0x0054:
            r9 = move-exception
            goto L_0x0095
        L_0x0056:
            r9 = move-exception
            r2 = r0
            goto L_0x00b5
        L_0x0059:
            r9 = move-exception
            r2 = r0
        L_0x005b:
            com.applovin.impl.sdk.o r3 = r8.f3032c     // Catch:{ all -> 0x00b4 }
            java.lang.String r4 = "FileManager"
            java.lang.String r5 = "Unknown failure to read file."
            r3.mo10379b(r4, r5, r9)     // Catch:{ all -> 0x00b4 }
            com.applovin.impl.sdk.i r9 = r8.f3031b     // Catch:{ all -> 0x00bb }
            com.applovin.impl.sdk.utils.C1281o.m3083a(r2, r9)     // Catch:{ all -> 0x00bb }
            monitor-exit(r1)     // Catch:{ all -> 0x00bb }
            return r0
        L_0x006b:
            r3 = move-exception
            r2 = r0
        L_0x006d:
            com.applovin.impl.sdk.o r4 = r8.f3032c     // Catch:{ all -> 0x00b4 }
            java.lang.String r5 = "FileManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b4 }
            r6.<init>()     // Catch:{ all -> 0x00b4 }
            java.lang.String r7 = "Failed to read file: "
            r6.append(r7)     // Catch:{ all -> 0x00b4 }
            java.lang.String r9 = r9.getName()     // Catch:{ all -> 0x00b4 }
            r6.append(r9)     // Catch:{ all -> 0x00b4 }
            r6.append(r3)     // Catch:{ all -> 0x00b4 }
            java.lang.String r9 = r6.toString()     // Catch:{ all -> 0x00b4 }
            r4.mo10378b(r5, r9)     // Catch:{ all -> 0x00b4 }
            com.applovin.impl.sdk.i r9 = r8.f3031b     // Catch:{ all -> 0x00bb }
            com.applovin.impl.sdk.utils.C1281o.m3083a(r2, r9)     // Catch:{ all -> 0x00bb }
            monitor-exit(r1)     // Catch:{ all -> 0x00bb }
            return r0
        L_0x0093:
            r9 = move-exception
            r2 = r0
        L_0x0095:
            com.applovin.impl.sdk.o r3 = r8.f3032c     // Catch:{ all -> 0x00b4 }
            java.lang.String r4 = "FileManager"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b4 }
            r5.<init>()     // Catch:{ all -> 0x00b4 }
            java.lang.String r6 = "File not found. "
            r5.append(r6)     // Catch:{ all -> 0x00b4 }
            r5.append(r9)     // Catch:{ all -> 0x00b4 }
            java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x00b4 }
            r3.mo10380c(r4, r9)     // Catch:{ all -> 0x00b4 }
            com.applovin.impl.sdk.i r9 = r8.f3031b     // Catch:{ all -> 0x00bb }
            com.applovin.impl.sdk.utils.C1281o.m3083a(r2, r9)     // Catch:{ all -> 0x00bb }
            monitor-exit(r1)     // Catch:{ all -> 0x00bb }
            return r0
        L_0x00b4:
            r9 = move-exception
        L_0x00b5:
            com.applovin.impl.sdk.i r0 = r8.f3031b     // Catch:{ all -> 0x00bb }
            com.applovin.impl.sdk.utils.C1281o.m3083a(r2, r0)     // Catch:{ all -> 0x00bb }
            throw r9     // Catch:{ all -> 0x00bb }
        L_0x00bb:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00bb }
            throw r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1206m.mo10271a(java.io.File):java.io.ByteArrayOutputStream");
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r10v4, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r10v5, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r10v6 */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r10v8 */
    /* JADX WARNING: type inference failed for: r10v10 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r10v18 */
    /* JADX WARNING: type inference failed for: r10v19 */
    /* JADX WARNING: type inference failed for: r10v20 */
    /* JADX WARNING: type inference failed for: r10v21 */
    /* JADX WARNING: type inference failed for: r10v22 */
    /* JADX WARNING: type inference failed for: r2v18 */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:28|29|30) */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        com.applovin.impl.sdk.utils.C1281o.m3083a((java.io.Closeable) r9, r7.f3031b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c7, code lost:
        com.applovin.impl.sdk.utils.C1281o.m3083a((java.io.Closeable) r2, r7.f3031b);
        com.applovin.impl.sdk.utils.C1281o.m3083a((java.io.Closeable) r9, r7.f3031b);
        com.applovin.impl.sdk.utils.C1281o.m3087a(r10, r7.f3031b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d6, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x00c2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.ByteArrayOutputStream mo10272a(java.lang.String r8, java.util.List<java.lang.String> r9, boolean r10) {
        /*
            r7 = this;
            java.lang.String r0 = "FileManager"
            r1 = 0
            if (r10 == 0) goto L_0x0022
            boolean r9 = com.applovin.impl.sdk.utils.C1281o.m3094a(r8, r9)
            if (r9 != 0) goto L_0x0022
            com.applovin.impl.sdk.o r9 = r7.f3032c
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r2 = "Domain is not whitelisted, skipping precache for url: "
            r10.append(r2)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.mo10378b(r0, r8)
            return r1
        L_0x0022:
            com.applovin.impl.sdk.i r9 = r7.f3031b
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r10 = com.applovin.impl.sdk.p019b.C1096c.f2493dy
            java.lang.Object r9 = r9.mo10202a(r10)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0047
            java.lang.String r9 = "https://"
            boolean r10 = r8.contains(r9)
            if (r10 != 0) goto L_0x0047
            com.applovin.impl.sdk.o r10 = r7.f3032c
            java.lang.String r2 = "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting..."
            r10.mo10381d(r0, r2)
            java.lang.String r10 = "http://"
            java.lang.String r8 = r8.replace(r10, r9)
        L_0x0047:
            com.applovin.impl.sdk.o r9 = r7.f3032c
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r2 = "Loading "
            r10.append(r2)
            r10.append(r8)
            java.lang.String r2 = "..."
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            r9.mo10378b(r0, r10)
            java.io.ByteArrayOutputStream r9 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x011e, all -> 0x011a }
            r9.<init>()     // Catch:{ IOException -> 0x011e, all -> 0x011a }
            java.net.URL r10 = new java.net.URL     // Catch:{ IOException -> 0x0117, all -> 0x0114 }
            r10.<init>(r8)     // Catch:{ IOException -> 0x0117, all -> 0x0114 }
            java.net.URLConnection r10 = r10.openConnection()     // Catch:{ IOException -> 0x0117, all -> 0x0114 }
            java.net.HttpURLConnection r10 = (java.net.HttpURLConnection) r10     // Catch:{ IOException -> 0x0117, all -> 0x0114 }
            com.applovin.impl.sdk.i r2 = r7.f3031b     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            com.applovin.impl.sdk.b.c<java.lang.Integer> r3 = com.applovin.impl.sdk.p019b.C1096c.f2491dw     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            java.lang.Object r2 = r2.mo10202a(r3)     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            int r2 = r2.intValue()     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            r10.setConnectTimeout(r2)     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            com.applovin.impl.sdk.i r2 = r7.f3031b     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            com.applovin.impl.sdk.b.c<java.lang.Integer> r3 = com.applovin.impl.sdk.p019b.C1096c.f2492dx     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            java.lang.Object r2 = r2.mo10202a(r3)     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            int r2 = r2.intValue()     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            r10.setReadTimeout(r2)     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            r2 = 1
            r10.setDefaultUseCaches(r2)     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            r10.setUseCaches(r2)     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            r3 = 0
            r10.setAllowUserInteraction(r3)     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            r10.setInstanceFollowRedirects(r2)     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            int r2 = r10.getResponseCode()     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            r4 = 200(0xc8, float:2.8E-43)
            if (r2 < r4) goto L_0x00ff
            r4 = 300(0x12c, float:4.2E-43)
            if (r2 < r4) goto L_0x00af
            goto L_0x00ff
        L_0x00af:
            java.io.InputStream r2 = r10.getInputStream()     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x00fd }
        L_0x00b7:
            int r5 = r4.length     // Catch:{ IOException -> 0x00fd }
            int r5 = r2.read(r4, r3, r5)     // Catch:{ IOException -> 0x00fd }
            if (r5 < 0) goto L_0x00d7
            r9.write(r4, r3, r5)     // Catch:{ Exception -> 0x00c2 }
            goto L_0x00b7
        L_0x00c2:
            com.applovin.impl.sdk.i r3 = r7.f3031b     // Catch:{ IOException -> 0x00fd }
            com.applovin.impl.sdk.utils.C1281o.m3083a(r9, r3)     // Catch:{ IOException -> 0x00fd }
            com.applovin.impl.sdk.i r8 = r7.f3031b
            com.applovin.impl.sdk.utils.C1281o.m3083a(r2, r8)
            com.applovin.impl.sdk.i r8 = r7.f3031b
            com.applovin.impl.sdk.utils.C1281o.m3083a(r9, r8)
            com.applovin.impl.sdk.i r8 = r7.f3031b
            com.applovin.impl.sdk.utils.C1281o.m3087a(r10, r8)
            return r1
        L_0x00d7:
            com.applovin.impl.sdk.o r3 = r7.f3032c     // Catch:{ IOException -> 0x00fd }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00fd }
            r4.<init>()     // Catch:{ IOException -> 0x00fd }
            java.lang.String r5 = "Loaded resource at "
            r4.append(r5)     // Catch:{ IOException -> 0x00fd }
            r4.append(r8)     // Catch:{ IOException -> 0x00fd }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x00fd }
            r3.mo10378b(r0, r4)     // Catch:{ IOException -> 0x00fd }
            com.applovin.impl.sdk.i r8 = r7.f3031b
            com.applovin.impl.sdk.utils.C1281o.m3083a(r2, r8)
            com.applovin.impl.sdk.i r8 = r7.f3031b
            com.applovin.impl.sdk.utils.C1281o.m3083a(r9, r8)
            com.applovin.impl.sdk.i r8 = r7.f3031b
            com.applovin.impl.sdk.utils.C1281o.m3087a(r10, r8)
            return r9
        L_0x00fd:
            r3 = move-exception
            goto L_0x0122
        L_0x00ff:
            com.applovin.impl.sdk.i r8 = r7.f3031b
            com.applovin.impl.sdk.utils.C1281o.m3083a(r1, r8)
            com.applovin.impl.sdk.i r8 = r7.f3031b
            com.applovin.impl.sdk.utils.C1281o.m3083a(r9, r8)
            com.applovin.impl.sdk.i r8 = r7.f3031b
            com.applovin.impl.sdk.utils.C1281o.m3087a(r10, r8)
            return r1
        L_0x010f:
            r8 = move-exception
            goto L_0x014a
        L_0x0111:
            r3 = move-exception
            r2 = r1
            goto L_0x0122
        L_0x0114:
            r8 = move-exception
            r10 = r1
            goto L_0x014a
        L_0x0117:
            r3 = move-exception
            r10 = r1
            goto L_0x0121
        L_0x011a:
            r8 = move-exception
            r9 = r1
            r10 = r9
            goto L_0x014a
        L_0x011e:
            r3 = move-exception
            r9 = r1
            r10 = r9
        L_0x0121:
            r2 = r10
        L_0x0122:
            com.applovin.impl.sdk.o r4 = r7.f3032c     // Catch:{ all -> 0x0148 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0148 }
            r5.<init>()     // Catch:{ all -> 0x0148 }
            java.lang.String r6 = "Error loading "
            r5.append(r6)     // Catch:{ all -> 0x0148 }
            r5.append(r8)     // Catch:{ all -> 0x0148 }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x0148 }
            r4.mo10379b(r0, r8, r3)     // Catch:{ all -> 0x0148 }
            com.applovin.impl.sdk.i r8 = r7.f3031b
            com.applovin.impl.sdk.utils.C1281o.m3083a(r2, r8)
            com.applovin.impl.sdk.i r8 = r7.f3031b
            com.applovin.impl.sdk.utils.C1281o.m3083a(r9, r8)
            com.applovin.impl.sdk.i r8 = r7.f3031b
            com.applovin.impl.sdk.utils.C1281o.m3087a(r10, r8)
            return r1
        L_0x0148:
            r8 = move-exception
            r1 = r2
        L_0x014a:
            com.applovin.impl.sdk.i r0 = r7.f3031b
            com.applovin.impl.sdk.utils.C1281o.m3083a(r1, r0)
            com.applovin.impl.sdk.i r0 = r7.f3031b
            com.applovin.impl.sdk.utils.C1281o.m3083a(r9, r0)
            com.applovin.impl.sdk.i r9 = r7.f3031b
            com.applovin.impl.sdk.utils.C1281o.m3087a(r10, r9)
            throw r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1206m.mo10272a(java.lang.String, java.util.List, boolean):java.io.ByteArrayOutputStream");
    }

    /* renamed from: a */
    public File mo10273a(String str, Context context) {
        File file;
        if (!C1277l.m3042b(str)) {
            this.f3032c.mo10378b("FileManager", "Nothing to look up, skipping...");
            return null;
        }
        C1227o oVar = this.f3032c;
        StringBuilder sb = new StringBuilder();
        sb.append("Looking up cached resource: ");
        sb.append(str);
        oVar.mo10378b("FileManager", sb.toString());
        if (str.contains(InMobiNetworkValues.ICON)) {
            str = str.replace(Constants.URL_PATH_DELIMITER, "_").replace(".", "_");
        }
        synchronized (this.f3033d) {
            File f = m2687f(context);
            file = new File(f, str);
            try {
                f.mkdirs();
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to make cache directory at ");
                sb2.append(f);
                this.f3032c.mo10379b("FileManager", sb2.toString(), th);
                return null;
            }
        }
        return file;
    }

    /* renamed from: a */
    public String mo10274a(Context context, String str, String str2, List<String> list, boolean z, C1109e eVar) {
        return mo10275a(context, str, str2, list, z, false, eVar);
    }

    /* renamed from: a */
    public String mo10275a(Context context, String str, String str2, List<String> list, boolean z, boolean z2, C1109e eVar) {
        String str3 = "FileManager";
        if (!C1277l.m3042b(str)) {
            this.f3032c.mo10378b(str3, "Nothing to cache, skipping...");
            return null;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        if (C1277l.m3042b(lastPathSegment) && C1277l.m3042b(str2)) {
            StringBuilder sb = new StringBuilder();
            String str4 = str2;
            sb.append(str2);
            sb.append(lastPathSegment);
            lastPathSegment = sb.toString();
        }
        String str5 = lastPathSegment;
        Context context2 = context;
        File a = mo10273a(str5, context);
        if (!m2680a(a, str, list, z, eVar)) {
            return null;
        }
        C1227o oVar = this.f3032c;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Caching succeeded for file ");
        sb2.append(str5);
        oVar.mo10378b(str3, sb2.toString());
        if (z2) {
            str5 = Uri.fromFile(a).toString();
        }
        return str5;
    }

    /* renamed from: a */
    public void mo10276a(Context context) {
        if (m2681b() && this.f3031b.mo10229c()) {
            this.f3032c.mo10378b("FileManager", "Compacting cache...");
            synchronized (this.f3033d) {
                m2679a(m2684c(context), context);
            }
        }
    }

    /* renamed from: a */
    public boolean mo10277a(ByteArrayOutputStream byteArrayOutputStream, File file) {
        if (file == null) {
            return false;
        }
        C1227o oVar = this.f3032c;
        StringBuilder sb = new StringBuilder();
        sb.append("Caching ");
        sb.append(file.getAbsolutePath());
        sb.append("...");
        String str = "FileManager";
        oVar.mo10378b(str, sb.toString());
        if (byteArrayOutputStream == null || byteArrayOutputStream.size() <= 0) {
            C1227o oVar2 = this.f3032c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No data for ");
            sb2.append(file.getAbsolutePath());
            oVar2.mo10381d(str, sb2.toString());
            return false;
        } else if (!m2682b(byteArrayOutputStream, file)) {
            C1227o oVar3 = this.f3032c;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unable to cache ");
            sb3.append(file.getAbsolutePath());
            oVar3.mo10382e(str, sb3.toString());
            return false;
        } else {
            C1227o oVar4 = this.f3032c;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Caching completed for ");
            sb4.append(file);
            oVar4.mo10378b(str, sb4.toString());
            return true;
        }
    }

    /* renamed from: a */
    public boolean mo10278a(File file, String str, List<String> list, C1109e eVar) {
        return m2680a(file, str, list, true, eVar);
    }

    /* renamed from: b */
    public void mo10279b(Context context) {
        String str = "Failed to create .nomedia file";
        String str2 = ".nomedia";
        String str3 = "FileManager";
        try {
            mo10273a(str2, context);
            File file = new File(m2687f(context), str2);
            if (!file.exists()) {
                C1227o oVar = this.f3032c;
                StringBuilder sb = new StringBuilder();
                sb.append("Creating .nomedia file at ");
                sb.append(file.getAbsolutePath());
                oVar.mo10378b(str3, sb.toString());
                if (!file.createNewFile()) {
                    this.f3032c.mo10382e(str3, str);
                }
            }
        } catch (IOException e) {
            this.f3032c.mo10379b(str3, str, e);
        }
    }
}
