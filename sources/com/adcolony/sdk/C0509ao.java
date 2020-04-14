package com.adcolony.sdk;

import android.content.Context;
import android.os.StatFs;
import java.io.File;

/* renamed from: com.adcolony.sdk.ao */
class C0509ao {

    /* renamed from: a */
    private String f321a;

    /* renamed from: b */
    private String f322b;

    /* renamed from: c */
    private String f323c;

    /* renamed from: d */
    private String f324d;

    /* renamed from: e */
    private File f325e;

    /* renamed from: f */
    private File f326f;

    /* renamed from: g */
    private File f327g;

    C0509ao() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo8312a() {
        new C0749a().mo8726a("Configuring storage").mo8728a(C0748w.f1168d);
        C0666j a = C0476a.m77a();
        StringBuilder sb = new StringBuilder();
        sb.append(mo8314c());
        sb.append("/adc3/");
        this.f321a = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f321a);
        sb2.append("media/");
        this.f322b = sb2.toString();
        this.f325e = new File(this.f322b);
        if (!this.f325e.isDirectory()) {
            this.f325e.delete();
            this.f325e.mkdirs();
        }
        if (!this.f325e.isDirectory()) {
            a.mo8556a(true);
            return false;
        } else if (mo8311a(this.f322b) < 2.097152E7d) {
            new C0749a().mo8726a("Not enough memory available at media path, disabling AdColony.").mo8728a(C0748w.f1169e);
            a.mo8556a(true);
            return false;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(mo8314c());
            sb3.append("/adc3/data/");
            this.f323c = sb3.toString();
            this.f326f = new File(this.f323c);
            if (!this.f326f.isDirectory()) {
                this.f326f.delete();
            }
            this.f326f.mkdirs();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(this.f321a);
            sb4.append("tmp/");
            this.f324d = sb4.toString();
            this.f327g = new File(this.f324d);
            if (!this.f327g.isDirectory()) {
                this.f327g.delete();
                this.f327g.mkdirs();
            }
            return true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo8313b() {
        File file = this.f325e;
        if (file == null || this.f326f == null || this.f327g == null) {
            return false;
        }
        if (!file.isDirectory()) {
            this.f325e.delete();
        }
        if (!this.f326f.isDirectory()) {
            this.f326f.delete();
        }
        if (!this.f327g.isDirectory()) {
            this.f327g.delete();
        }
        this.f325e.mkdirs();
        this.f326f.mkdirs();
        this.f327g.mkdirs();
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public String mo8314c() {
        Context c = C0476a.m85c();
        if (c == null) {
            return "";
        }
        return c.getFilesDir().getAbsolutePath();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public double mo8311a(String str) {
        try {
            StatFs statFs = new StatFs(str);
            return (double) (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()));
        } catch (RuntimeException unused) {
            return 0.0d;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public String mo8315d() {
        return this.f322b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public String mo8316e() {
        return this.f323c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public String mo8317f() {
        return this.f324d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public String mo8318g() {
        return this.f321a;
    }
}
