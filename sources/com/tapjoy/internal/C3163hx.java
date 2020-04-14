package com.tapjoy.internal;

import android.graphics.Bitmap;
import com.tapjoy.internal.C2877ap.C2878a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

/* renamed from: com.tapjoy.internal.hx */
public final class C3163hx {

    /* renamed from: e */
    public static final C2896bi f7498e = new C2896bi() {
        /* renamed from: a */
        public final /* synthetic */ Object mo18189a(C1812bn bnVar) {
            return new C3163hx(bnVar);
        }
    };

    /* renamed from: f */
    private static final C1807an f7499f;

    /* renamed from: a */
    public URL f7500a;

    /* renamed from: b */
    public Bitmap f7501b;

    /* renamed from: c */
    public byte[] f7502c;

    /* renamed from: d */
    public C3174ie f7503d;

    static {
        C1808aq arVar = new C2879ar();
        if (!(arVar instanceof C2880as)) {
            arVar = new C2878a(arVar);
        }
        f7499f = arVar;
    }

    public C3163hx(URL url) {
        this.f7500a = url;
    }

    /* renamed from: a */
    public final boolean mo30229a() {
        return (this.f7501b == null && this.f7502c == null) ? false : true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0055  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo30230b() {
        /*
            r14 = this;
            com.tapjoy.internal.fy r0 = com.tapjoy.internal.C3091ga.m7138b()
            r1 = 1
            java.lang.String r2 = "mm_external_cache_enabled"
            boolean r0 = r0.mo18107a(r2, r1)
            r1 = r0 ^ 1
            if (r1 == 0) goto L_0x0020
            com.tapjoy.internal.an r2 = f7499f
            java.net.URL r3 = r14.f7500a
            java.lang.Object r2 = r2.mo18047a(r3)
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
            r14.f7501b = r2
            android.graphics.Bitmap r2 = r14.f7501b
            if (r2 == 0) goto L_0x0020
            return
        L_0x0020:
            if (r0 == 0) goto L_0x0061
            com.tapjoy.internal.ht r2 = com.tapjoy.internal.C3155ht.f7479a
            java.net.URL r3 = r14.f7500a
            java.io.File r2 = r2.mo30222a(r3)
            if (r2 == 0) goto L_0x0061
            r3 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0043, all -> 0x003e }
            r4.<init>(r2)     // Catch:{ IOException -> 0x0043, all -> 0x003e }
            r14.m7306a(r4)     // Catch:{ IOException -> 0x003c, all -> 0x0039 }
            com.tapjoy.internal.C1854jz.m3672a(r4)
            goto L_0x0046
        L_0x0039:
            r0 = move-exception
            r3 = r4
            goto L_0x003f
        L_0x003c:
            r3 = r4
            goto L_0x0043
        L_0x003e:
            r0 = move-exception
        L_0x003f:
            com.tapjoy.internal.C1854jz.m3672a(r3)
            throw r0
        L_0x0043:
            com.tapjoy.internal.C1854jz.m3672a(r3)
        L_0x0046:
            android.graphics.Bitmap r3 = r14.f7501b
            if (r3 != 0) goto L_0x0053
            byte[] r3 = r14.f7502c
            if (r3 == 0) goto L_0x004f
            goto L_0x0053
        L_0x004f:
            r2.delete()
            goto L_0x0061
        L_0x0053:
            if (r1 == 0) goto L_0x0060
            android.graphics.Bitmap r0 = r14.f7501b
            if (r0 == 0) goto L_0x0060
            com.tapjoy.internal.an r1 = f7499f
            java.net.URL r2 = r14.f7500a
            r1.mo18048a(r2, r0)
        L_0x0060:
            return
        L_0x0061:
            java.net.URL r2 = r14.f7500a
            java.net.URLConnection r2 = com.tapjoy.internal.C3066fj.m7086a(r2)
            r3 = 0
            java.lang.String r5 = "Cache-Control"
            java.lang.String r5 = r2.getHeaderField(r5)
            boolean r6 = com.tapjoy.internal.C1852jq.m3669c(r5)
            if (r6 != 0) goto L_0x009b
            java.lang.String r6 = ","
            java.lang.String[] r5 = r5.split(r6)
            int r6 = r5.length
            r7 = 0
        L_0x007d:
            if (r7 >= r6) goto L_0x009b
            r8 = r5[r7]
            java.lang.String r8 = r8.trim()
            java.lang.String r9 = "max-age="
            boolean r9 = r8.startsWith(r9)
            if (r9 == 0) goto L_0x0098
            r5 = 8
            java.lang.String r5 = r8.substring(r5)
            long r3 = java.lang.Long.parseLong(r5)     // Catch:{ NumberFormatException -> 0x009b }
            goto L_0x009b
        L_0x0098:
            int r7 = r7 + 1
            goto L_0x007d
        L_0x009b:
            r12 = r3
            java.io.InputStream r2 = r2.getInputStream()
            java.io.ByteArrayInputStream r11 = r14.m7306a(r2)
            com.tapjoy.internal.C1854jz.m3672a(r2)
            com.tapjoy.internal.ht r2 = com.tapjoy.internal.C3155ht.f7479a
            boolean r2 = com.tapjoy.internal.C3155ht.m7292a(r12)
            if (r2 == 0) goto L_0x00cc
            if (r0 == 0) goto L_0x00cc
            android.graphics.Bitmap r0 = r14.f7501b
            if (r0 != 0) goto L_0x00b9
            byte[] r0 = r14.f7502c
            if (r0 == 0) goto L_0x00cc
        L_0x00b9:
            com.tapjoy.internal.ht r9 = com.tapjoy.internal.C3155ht.f7479a
            java.net.URL r10 = r14.f7500a
            android.content.Context r0 = r9.f7480b
            if (r0 == 0) goto L_0x00cc
            java.util.concurrent.ExecutorService r0 = r9.f7483e
            com.tapjoy.internal.ht$2 r2 = new com.tapjoy.internal.ht$2
            r8 = r2
            r8.<init>(r10, r11, r12)
            r0.submit(r2)
        L_0x00cc:
            if (r1 == 0) goto L_0x00d9
            android.graphics.Bitmap r0 = r14.f7501b
            if (r0 == 0) goto L_0x00d9
            com.tapjoy.internal.an r1 = f7499f
            java.net.URL r2 = r14.f7500a
            r1.mo18048a(r2, r0)
        L_0x00d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3163hx.mo30230b():void");
    }

    /* renamed from: a */
    private ByteArrayInputStream m7306a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C3234jx.m7506a(inputStream, byteArrayOutputStream);
        byteArrayOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        C3175if ifVar = new C3175if();
        ifVar.mo30236a(byteArray);
        C3174ie a = ifVar.mo30235a();
        if (a.f7542b == 0) {
            this.f7502c = byteArray;
            this.f7503d = a;
        } else {
            C1860s sVar = C1860s.f3912a;
            this.f7501b = C1860s.m3695a((InputStream) byteArrayInputStream);
            byteArrayInputStream.reset();
        }
        return byteArrayInputStream;
    }

    C3163hx(C1812bn bnVar) {
        if (bnVar.mo18070k() == C2908bs.STRING) {
            this.f7500a = bnVar.mo18060e();
            return;
        }
        bnVar.mo18067h();
        String l = bnVar.mo18071l();
        while (bnVar.mo18069j()) {
            if ("url".equals(l)) {
                this.f7500a = bnVar.mo18060e();
            } else {
                bnVar.mo18078s();
            }
        }
        bnVar.mo18068i();
    }
}
