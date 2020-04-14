package com.adcolony.sdk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.r */
class C0722r {

    /* renamed from: a */
    private LinkedList<Runnable> f1116a = new LinkedList<>();

    /* renamed from: b */
    private boolean f1117b;

    C0722r() {
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public boolean m845f(C0480ab abVar) {
        String str = "size";
        String str2 = "success";
        JSONObject c = abVar.mo8220c();
        String b = C0746u.m908b(c, "filepath");
        C0476a.m77a().mo8581o().mo8313b();
        JSONObject a = C0746u.m892a();
        try {
            int c2 = C0746u.m914c(c, "offset");
            int c3 = C0746u.m914c(c, str);
            boolean d = C0746u.m918d(c, "gunzip");
            String b2 = C0746u.m908b(c, "output_filepath");
            InputStream apVar = new C0510ap(new FileInputStream(b), c2, c3);
            InputStream gZIPInputStream = d ? new GZIPInputStream(apVar, 1024) : apVar;
            if (b2.equals("")) {
                StringBuilder sb = new StringBuilder(gZIPInputStream.available());
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = gZIPInputStream.read(bArr, 0, 1024);
                    if (read < 0) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read, "ISO-8859-1"));
                }
                C0746u.m912b(a, str, sb.length());
                C0746u.m902a(a, "data", sb.toString());
            } else {
                FileOutputStream fileOutputStream = new FileOutputStream(b2);
                byte[] bArr2 = new byte[1024];
                int i = 0;
                while (true) {
                    int read2 = gZIPInputStream.read(bArr2, 0, 1024);
                    if (read2 < 0) {
                        break;
                    }
                    fileOutputStream.write(bArr2, 0, read2);
                    i += read2;
                }
                fileOutputStream.close();
                C0746u.m912b(a, str, i);
            }
            gZIPInputStream.close();
            C0746u.m913b(a, str2, true);
            abVar.mo8216a(a).mo8217b();
            return true;
        } catch (IOException unused) {
            C0746u.m913b(a, str2, false);
            abVar.mo8216a(a).mo8217b();
            return false;
        } catch (OutOfMemoryError unused2) {
            new C0749a().mo8726a("Out of memory error - disabling AdColony.").mo8728a(C0748w.f1171g);
            C0476a.m77a().mo8556a(true);
            C0746u.m913b(a, str2, false);
            abVar.mo8216a(a).mo8217b();
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0100, code lost:
        new com.adcolony.sdk.C0748w.C0749a().mo8726a("Out of memory error - disabling AdColony.").mo8728a(com.adcolony.sdk.C0748w.f1171g);
        com.adcolony.sdk.C0476a.m77a().mo8556a(true);
        com.adcolony.sdk.C0746u.m913b(r5, r1, false);
        r0.mo8216a(r5).mo8217b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0123, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0124, code lost:
        r2 = false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ExcHandler: OutOfMemoryError (unused java.lang.OutOfMemoryError), SYNTHETIC, Splitter:B:1:0x0029] */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m846g(com.adcolony.sdk.C0480ab r20) {
        /*
            r19 = this;
            r0 = r20
            java.lang.String r1 = "success"
            org.json.JSONObject r2 = r20.mo8220c()
            java.lang.String r3 = "filepath"
            java.lang.String r3 = com.adcolony.sdk.C0746u.m908b(r2, r3)
            java.lang.String r4 = "bundle_path"
            java.lang.String r4 = com.adcolony.sdk.C0746u.m908b(r2, r4)
            java.lang.String r5 = "bundle_filenames"
            org.json.JSONArray r2 = com.adcolony.sdk.C0746u.m922g(r2, r5)
            com.adcolony.sdk.j r5 = com.adcolony.sdk.C0476a.m77a()
            com.adcolony.sdk.ao r5 = r5.mo8581o()
            r5.mo8313b()
            org.json.JSONObject r5 = com.adcolony.sdk.C0746u.m892a()
            java.io.File r8 = new java.io.File     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            r8.<init>(r4)     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            java.io.RandomAccessFile r9 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            java.lang.String r10 = "r"
            r9.<init>(r8, r10)     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            r10 = 4
            byte[] r10 = new byte[r10]     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            r10 = 32
            byte[] r10 = new byte[r10]     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            r9.readInt()     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            int r11 = r9.readInt()     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            org.json.JSONArray r12 = new org.json.JSONArray     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            r12.<init>()     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            r13 = 1024(0x400, float:1.435E-42)
            byte[] r14 = new byte[r13]     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            r15 = 0
        L_0x004d:
            if (r15 >= r11) goto L_0x00e7
            r16 = 8
            int r17 = r15 * 44
            int r6 = r16 + r17
            r17 = r8
            long r7 = (long) r6     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            r9.seek(r7)     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            r9.read(r10)     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            java.lang.String r6 = new java.lang.String     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            r6.<init>(r10)     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            r9.readInt()     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            int r6 = r9.readInt()     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            int r7 = r9.readInt()     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            r12.put(r7)     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00bd }
            r8.<init>()     // Catch:{ JSONException -> 0x00bd }
            r8.append(r3)     // Catch:{ JSONException -> 0x00bd }
            java.lang.Object r13 = r2.get(r15)     // Catch:{ JSONException -> 0x00bd }
            r8.append(r13)     // Catch:{ JSONException -> 0x00bd }
            java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x00bd }
            r18 = r2
            r13 = r3
            long r2 = (long) r6
            r9.seek(r2)     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            r2.<init>(r8)     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            int r3 = r7 / 1024
            int r7 = r7 % 1024
            r6 = 0
        L_0x0095:
            if (r6 >= r3) goto L_0x00a7
            r16 = r3
            r3 = 1024(0x400, float:1.435E-42)
            r8 = 0
            r9.read(r14, r8, r3)     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            r2.write(r14, r8, r3)     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            int r6 = r6 + 1
            r3 = r16
            goto L_0x0095
        L_0x00a7:
            r3 = 1024(0x400, float:1.435E-42)
            r8 = 0
            r9.read(r14, r8, r7)     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            r2.write(r14, r8, r7)     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            r2.close()     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            int r15 = r15 + 1
            r3 = r13
            r8 = r17
            r2 = r18
            r13 = 1024(0x400, float:1.435E-42)
            goto L_0x004d
        L_0x00bd:
            com.adcolony.sdk.w$a r2 = new com.adcolony.sdk.w$a     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            r2.<init>()     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            java.lang.String r3 = "Could extract file name at index "
            com.adcolony.sdk.w$a r2 = r2.mo8726a(r3)     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            com.adcolony.sdk.w$a r2 = r2.mo8724a(r15)     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            java.lang.String r3 = " unpacking ad unit bundle at "
            com.adcolony.sdk.w$a r2 = r2.mo8726a(r3)     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            com.adcolony.sdk.w$a r2 = r2.mo8726a(r4)     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            com.adcolony.sdk.w r3 = com.adcolony.sdk.C0748w.f1171g     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            r2.mo8728a(r3)     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            r2 = 0
            com.adcolony.sdk.C0746u.m913b(r5, r1, r2)     // Catch:{ IOException -> 0x0125, OutOfMemoryError -> 0x0100 }
            com.adcolony.sdk.ab r3 = r0.mo8216a(r5)     // Catch:{ IOException -> 0x0125, OutOfMemoryError -> 0x0100 }
            r3.mo8217b()     // Catch:{ IOException -> 0x0125, OutOfMemoryError -> 0x0100 }
            return r2
        L_0x00e7:
            r17 = r8
            r9.close()     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            r17.delete()     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            r2 = 1
            com.adcolony.sdk.C0746u.m913b(r5, r1, r2)     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            java.lang.String r3 = "file_sizes"
            com.adcolony.sdk.C0746u.m903a(r5, r3, r12)     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            com.adcolony.sdk.ab r3 = r0.mo8216a(r5)     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            r3.mo8217b()     // Catch:{ IOException -> 0x0124, OutOfMemoryError -> 0x0100 }
            return r2
        L_0x0100:
            com.adcolony.sdk.w$a r2 = new com.adcolony.sdk.w$a
            r2.<init>()
            java.lang.String r3 = "Out of memory error - disabling AdColony."
            com.adcolony.sdk.w$a r2 = r2.mo8726a(r3)
            com.adcolony.sdk.w r3 = com.adcolony.sdk.C0748w.f1171g
            r2.mo8728a(r3)
            com.adcolony.sdk.j r2 = com.adcolony.sdk.C0476a.m77a()
            r3 = 1
            r2.mo8556a(r3)
            r2 = 0
            com.adcolony.sdk.C0746u.m913b(r5, r1, r2)
            com.adcolony.sdk.ab r0 = r0.mo8216a(r5)
            r0.mo8217b()
            return r2
        L_0x0124:
            r2 = 0
        L_0x0125:
            com.adcolony.sdk.w$a r3 = new com.adcolony.sdk.w$a
            r3.<init>()
            java.lang.String r6 = "Failed to find or open ad unit bundle at path: "
            com.adcolony.sdk.w$a r3 = r3.mo8726a(r6)
            com.adcolony.sdk.w$a r3 = r3.mo8726a(r4)
            com.adcolony.sdk.w r4 = com.adcolony.sdk.C0748w.f1172h
            r3.mo8728a(r4)
            com.adcolony.sdk.C0746u.m913b(r5, r1, r2)
            com.adcolony.sdk.ab r0 = r0.mo8216a(r5)
            r0.mo8217b()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C0722r.m846g(com.adcolony.sdk.ab):boolean");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8692a() {
        C0476a.m81a("FileSystem.save", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(final C0480ab abVar) {
                C0722r.this.mo8693a((Runnable) new Runnable() {
                    public void run() {
                        C0722r.this.mo8695a(abVar);
                        C0722r.this.mo8700b();
                    }
                });
            }
        });
        C0476a.m81a("FileSystem.delete", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(final C0480ab abVar) {
                C0722r.this.mo8693a((Runnable) new Runnable() {
                    public void run() {
                        C0722r.this.mo8696a(abVar, new File(C0746u.m908b(abVar.mo8220c(), "filepath")));
                        C0722r.this.mo8700b();
                    }
                });
            }
        });
        C0476a.m81a("FileSystem.listing", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(final C0480ab abVar) {
                C0722r.this.mo8693a((Runnable) new Runnable() {
                    public void run() {
                        C0722r.this.mo8701b(abVar);
                        C0722r.this.mo8700b();
                    }
                });
            }
        });
        C0476a.m81a("FileSystem.load", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(final C0480ab abVar) {
                C0722r.this.mo8693a((Runnable) new Runnable() {
                    public void run() {
                        C0722r.this.mo8702c(abVar);
                        C0722r.this.mo8700b();
                    }
                });
            }
        });
        C0476a.m81a("FileSystem.rename", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(final C0480ab abVar) {
                C0722r.this.mo8693a((Runnable) new Runnable() {
                    public void run() {
                        C0722r.this.mo8703d(abVar);
                        C0722r.this.mo8700b();
                    }
                });
            }
        });
        C0476a.m81a("FileSystem.exists", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(final C0480ab abVar) {
                C0722r.this.mo8693a((Runnable) new Runnable() {
                    public void run() {
                        C0722r.this.mo8704e(abVar);
                        C0722r.this.mo8700b();
                    }
                });
            }
        });
        C0476a.m81a("FileSystem.extract", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(final C0480ab abVar) {
                C0722r.this.mo8693a((Runnable) new Runnable() {
                    public void run() {
                        C0722r.this.m845f(abVar);
                        C0722r.this.mo8700b();
                    }
                });
            }
        });
        C0476a.m81a("FileSystem.unpack_bundle", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(final C0480ab abVar) {
                C0722r.this.mo8693a((Runnable) new Runnable() {
                    public void run() {
                        C0722r.this.m846g(abVar);
                        C0722r.this.mo8700b();
                    }
                });
            }
        });
        C0476a.m81a("FileSystem.create_directory", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(final C0480ab abVar) {
                C0722r.this.mo8693a((Runnable) new Runnable() {
                    public void run() {
                        C0722r.this.m847h(abVar);
                        C0722r.this.mo8700b();
                    }
                });
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo8695a(C0480ab abVar) {
        String str = "success";
        JSONObject c = abVar.mo8220c();
        String b = C0746u.m908b(c, "filepath");
        String b2 = C0746u.m908b(c, "data");
        String b3 = C0746u.m908b(c, "encoding");
        boolean z = b3 != null && b3.equals("utf8");
        C0476a.m77a().mo8581o().mo8313b();
        JSONObject a = C0746u.m892a();
        try {
            mo8694a(b, b2, z);
            C0746u.m913b(a, str, true);
            abVar.mo8216a(a).mo8217b();
            return true;
        } catch (IOException unused) {
            C0746u.m913b(a, str, false);
            abVar.mo8216a(a).mo8217b();
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8694a(String str, String str2, boolean z) throws IOException {
        BufferedWriter bufferedWriter = z ? new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str), "UTF-8")) : new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str)));
        bufferedWriter.write(str2);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo8696a(C0480ab abVar, File file) {
        C0476a.m77a().mo8581o().mo8313b();
        JSONObject a = C0746u.m892a();
        String str = "success";
        if (mo8697a(file)) {
            C0746u.m913b(a, str, true);
            abVar.mo8216a(a).mo8217b();
            return true;
        }
        C0746u.m913b(a, str, false);
        abVar.mo8216a(a).mo8217b();
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo8697a(File file) {
        try {
            if (!file.isDirectory()) {
                return file.delete();
            }
            if (file.list().length == 0) {
                return file.delete();
            }
            String[] list = file.list();
            if (list.length > 0) {
                return mo8697a(new File(file, list[0]));
            }
            if (file.list().length == 0) {
                return file.delete();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo8701b(C0480ab abVar) {
        String b = C0746u.m908b(abVar.mo8220c(), "filepath");
        C0476a.m77a().mo8581o().mo8313b();
        JSONObject a = C0746u.m892a();
        String[] list = new File(b).list();
        String str = "success";
        if (list != null) {
            JSONArray b2 = C0746u.m909b();
            for (String str2 : list) {
                JSONObject a2 = C0746u.m892a();
                C0746u.m902a(a2, "filename", str2);
                StringBuilder sb = new StringBuilder();
                sb.append(b);
                sb.append(str2);
                boolean isDirectory = new File(sb.toString()).isDirectory();
                String str3 = "is_folder";
                if (isDirectory) {
                    C0746u.m913b(a2, str3, true);
                } else {
                    C0746u.m913b(a2, str3, false);
                }
                C0746u.m897a(b2, (Object) a2);
            }
            C0746u.m913b(a, str, true);
            C0746u.m903a(a, "entries", b2);
            abVar.mo8216a(a).mo8217b();
            return true;
        }
        C0746u.m913b(a, str, false);
        abVar.mo8216a(a).mo8217b();
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public String mo8702c(C0480ab abVar) {
        String str = "success";
        JSONObject c = abVar.mo8220c();
        String b = C0746u.m908b(c, "filepath");
        String b2 = C0746u.m908b(c, "encoding");
        boolean z = b2 != null && b2.equals("utf8");
        C0476a.m77a().mo8581o().mo8313b();
        JSONObject a = C0746u.m892a();
        try {
            StringBuilder a2 = mo8691a(b, z);
            C0746u.m913b(a, str, true);
            C0746u.m902a(a, "data", a2.toString());
            abVar.mo8216a(a).mo8217b();
            return a2.toString();
        } catch (IOException unused) {
            C0746u.m913b(a, str, false);
            abVar.mo8216a(a).mo8217b();
            return "";
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public StringBuilder mo8691a(String str, boolean z) throws IOException {
        BufferedReader bufferedReader;
        File file = new File(str);
        StringBuilder sb = new StringBuilder((int) file.length());
        if (z) {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath()), "UTF-8"));
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath())));
        }
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
                sb.append("\n");
            } else {
                bufferedReader.close();
                return sb;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public List<String> mo8699b(String str, boolean z) throws IOException {
        BufferedReader bufferedReader;
        File file = new File(str);
        file.length();
        ArrayList arrayList = new ArrayList();
        if (z) {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath()), "UTF-8"));
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath())));
        }
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                arrayList.add(readLine);
            } else {
                bufferedReader.close();
                return arrayList;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo8703d(C0480ab abVar) {
        String str = "success";
        JSONObject c = abVar.mo8220c();
        String b = C0746u.m908b(c, "filepath");
        String b2 = C0746u.m908b(c, "new_filepath");
        C0476a.m77a().mo8581o().mo8313b();
        JSONObject a = C0746u.m892a();
        try {
            if (new File(b).renameTo(new File(b2))) {
                C0746u.m913b(a, str, true);
                abVar.mo8216a(a).mo8217b();
                return true;
            }
            C0746u.m913b(a, str, false);
            abVar.mo8216a(a).mo8217b();
            return false;
        } catch (Exception unused) {
            C0746u.m913b(a, str, false);
            abVar.mo8216a(a).mo8217b();
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public boolean mo8704e(C0480ab abVar) {
        String str = "success";
        String str2 = "result";
        String b = C0746u.m908b(abVar.mo8220c(), "filepath");
        C0476a.m77a().mo8581o().mo8313b();
        JSONObject a = C0746u.m892a();
        try {
            boolean a2 = mo8698a(b);
            C0746u.m913b(a, str2, a2);
            C0746u.m913b(a, str, true);
            abVar.mo8216a(a).mo8217b();
            return a2;
        } catch (Exception e) {
            C0746u.m913b(a, str2, false);
            C0746u.m913b(a, str, false);
            abVar.mo8216a(a).mo8217b();
            e.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo8698a(String str) throws Exception {
        return new File(str).exists();
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public boolean m847h(C0480ab abVar) {
        String str = "success";
        String b = C0746u.m908b(abVar.mo8220c(), "filepath");
        C0476a.m77a().mo8581o().mo8313b();
        JSONObject a = C0746u.m892a();
        try {
            if (new File(b).mkdir()) {
                C0746u.m913b(a, str, true);
                abVar.mo8216a(a).mo8217b();
                return true;
            }
            C0746u.m913b(a, str, false);
            return false;
        } catch (Exception unused) {
            C0746u.m913b(a, str, false);
            abVar.mo8216a(a).mo8217b();
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8693a(Runnable runnable) {
        if (!this.f1116a.isEmpty() || this.f1117b) {
            this.f1116a.push(runnable);
            return;
        }
        this.f1117b = true;
        runnable.run();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8700b() {
        this.f1117b = false;
        if (!this.f1116a.isEmpty()) {
            this.f1117b = true;
            ((Runnable) this.f1116a.removeLast()).run();
        }
    }
}
