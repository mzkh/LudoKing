package com.inmobi.media;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;

/* renamed from: com.inmobi.media.ad */
/* compiled from: AdAsset */
public class C2154ad {
    /* access modifiers changed from: private */

    /* renamed from: m */
    public static final String f4332m = "ad";

    /* renamed from: a */
    long f4333a = 0;

    /* renamed from: b */
    int f4334b;

    /* renamed from: c */
    int f4335c;

    /* renamed from: d */
    public String f4336d;

    /* renamed from: e */
    public String f4337e;

    /* renamed from: f */
    long f4338f;

    /* renamed from: g */
    long f4339g;

    /* renamed from: h */
    long f4340h;

    /* renamed from: i */
    long f4341i;

    /* renamed from: j */
    boolean f4342j;

    /* renamed from: k */
    public String f4343k;

    /* renamed from: l */
    public int f4344l;

    /* renamed from: com.inmobi.media.ad$a */
    /* compiled from: AdAsset */
    public static final class C2155a {

        /* renamed from: a */
        int f4345a = (new Random().nextInt() & Integer.MAX_VALUE);

        /* renamed from: b */
        int f4346b;

        /* renamed from: c */
        String f4347c;

        /* renamed from: d */
        String f4348d;

        /* renamed from: e */
        long f4349e = System.currentTimeMillis();

        /* renamed from: f */
        long f4350f = System.currentTimeMillis();

        /* renamed from: g */
        long f4351g;

        /* renamed from: h */
        long f4352h;

        /* renamed from: a */
        public final C2155a mo27836a(String str, int i, long j) {
            this.f4347c = str;
            this.f4346b = i;
            this.f4351g = System.currentTimeMillis() + j;
            return this;
        }

        /* renamed from: a */
        private static long m4272a(String str) {
            try {
                return new SimpleDateFormat("EEE,dd MMM yyyy HH:mm:ss z", Locale.ENGLISH).parse(str).getTime();
            } catch (ParseException e) {
                C2463fd.m5161a().mo28382a(new C2495fz(e));
                return 0;
            }
        }

        @NonNull
        /* renamed from: a */
        public final C2154ad mo27838a() {
            C2154ad adVar = new C2154ad(this.f4345a, this.f4347c, this.f4348d, this.f4346b, this.f4349e, this.f4350f, this.f4351g, this.f4352h);
            return adVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x004e  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00de  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x00e9  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x00fc  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.inmobi.media.C2154ad.C2155a mo27837a(java.lang.String r20, java.lang.String r21, com.inmobi.media.C2487fs r22, int r23, long r24) {
            /*
                r19 = this;
                r0 = r19
                r1 = r22
                java.util.Map<java.lang.String, java.util.List<java.lang.String>> r1 = r1.f5454c
                long r2 = java.lang.System.currentTimeMillis()
                java.lang.String r4 = "Date"
                java.lang.Object r5 = r1.get(r4)
                java.util.List r5 = (java.util.List) r5
                r6 = 0
                if (r5 == 0) goto L_0x002e
                int r5 = r5.size()
                if (r5 <= 0) goto L_0x002e
                java.lang.Object r4 = r1.get(r4)
                java.util.List r4 = (java.util.List) r4
                java.lang.Object r4 = r4.get(r6)
                java.lang.String r4 = (java.lang.String) r4
                if (r4 == 0) goto L_0x002e
                long r4 = m4272a(r4)
                goto L_0x0030
            L_0x002e:
                r4 = 0
            L_0x0030:
                java.lang.String r9 = "Cache-Control"
                java.lang.Object r10 = r1.get(r9)
                java.util.List r10 = (java.util.List) r10
                if (r10 == 0) goto L_0x00b9
                int r10 = r10.size()
                if (r10 <= 0) goto L_0x00b9
                java.lang.Object r9 = r1.get(r9)
                java.util.List r9 = (java.util.List) r9
                java.lang.Object r9 = r9.get(r6)
                java.lang.String r9 = (java.lang.String) r9
                if (r9 == 0) goto L_0x00b9
                java.lang.String r10 = ","
                java.lang.String[] r9 = r9.split(r10)
                int r10 = r9.length
                r12 = 0
                r13 = 0
                r15 = 0
                r17 = 0
            L_0x005c:
                if (r12 >= r10) goto L_0x00b7
                r18 = r9[r12]
                java.lang.String r11 = r18.trim()
                java.lang.String r7 = "no-cache"
                boolean r7 = r7.equals(r11)
                if (r7 != 0) goto L_0x00b4
                java.lang.String r7 = "no-store"
                boolean r7 = r7.equals(r11)
                if (r7 != 0) goto L_0x00b4
                java.lang.String r7 = "max-age="
                boolean r7 = r11.startsWith(r7)
                if (r7 == 0) goto L_0x008b
                r7 = 8
                java.lang.String r7 = r11.substring(r7)     // Catch:{ Exception -> 0x0087 }
                long r13 = java.lang.Long.parseLong(r7)     // Catch:{ Exception -> 0x0087 }
                goto L_0x00b4
            L_0x0087:
                com.inmobi.media.C2154ad.f4332m
                goto L_0x00b4
            L_0x008b:
                java.lang.String r7 = "stale-while-revalidate="
                boolean r7 = r11.startsWith(r7)
                if (r7 == 0) goto L_0x00a2
                r7 = 23
                java.lang.String r7 = r11.substring(r7)     // Catch:{ Exception -> 0x009e }
                long r15 = java.lang.Long.parseLong(r7)     // Catch:{ Exception -> 0x009e }
                goto L_0x00b4
            L_0x009e:
                com.inmobi.media.C2154ad.f4332m
                goto L_0x00b4
            L_0x00a2:
                java.lang.String r7 = "must-revalidate"
                boolean r7 = r7.equals(r11)
                if (r7 != 0) goto L_0x00b2
                java.lang.String r7 = "proxy-revalidate"
                boolean r7 = r7.equals(r11)
                if (r7 == 0) goto L_0x00b4
            L_0x00b2:
                r17 = 1
            L_0x00b4:
                int r12 = r12 + 1
                goto L_0x005c
            L_0x00b7:
                r7 = 1
                goto L_0x00c0
            L_0x00b9:
                r7 = 0
                r13 = 0
                r15 = 0
                r17 = 0
            L_0x00c0:
                java.lang.String r8 = "Expires"
                java.lang.Object r9 = r1.get(r8)
                java.util.List r9 = (java.util.List) r9
                if (r9 == 0) goto L_0x00e3
                int r9 = r9.size()
                if (r9 <= 0) goto L_0x00e3
                java.lang.Object r1 = r1.get(r8)
                java.util.List r1 = (java.util.List) r1
                java.lang.Object r1 = r1.get(r6)
                java.lang.String r1 = (java.lang.String) r1
                if (r1 == 0) goto L_0x00e3
                long r8 = m4272a(r1)
                goto L_0x00e5
            L_0x00e3:
                r8 = 0
            L_0x00e5:
                r10 = 1000(0x3e8, double:4.94E-321)
                if (r7 == 0) goto L_0x00fc
                long r13 = r13 * r10
                long r7 = r2 + r13
                if (r17 == 0) goto L_0x00f1
                r15 = r7
                goto L_0x00f7
            L_0x00f1:
                java.lang.Long.signum(r15)
                long r15 = r15 * r10
                long r15 = r15 + r7
            L_0x00f7:
                r1 = r20
                r4 = r7
                r6 = r15
                goto L_0x0110
            L_0x00fc:
                r6 = 0
                int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r1 <= 0) goto L_0x010d
                int r1 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                if (r1 < 0) goto L_0x010d
                long r8 = r8 - r4
                long r4 = r2 + r8
                r1 = r20
                r6 = r4
                goto L_0x0110
            L_0x010d:
                r1 = r20
                r4 = r6
            L_0x0110:
                r0.f4347c = r1
                r1 = r21
                r0.f4348d = r1
                r1 = r23
                r0.f4346b = r1
                long r8 = r24 * r10
                long r2 = r2 + r8
                r0.f4351g = r2
                r0.f4352h = r4
                long r1 = r0.f4351g
                long r1 = java.lang.Math.min(r1, r6)
                r0.f4351g = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2154ad.C2155a.mo27837a(java.lang.String, java.lang.String, com.inmobi.media.fs, int, long):com.inmobi.media.ad$a");
        }
    }

    C2154ad(int i, @NonNull String str, @Nullable String str2, int i2, long j, long j2, long j3, long j4) {
        this.f4334b = i;
        this.f4336d = str;
        this.f4337e = str2;
        this.f4335c = i2;
        this.f4338f = j;
        this.f4339g = j2;
        this.f4340h = j3;
        this.f4341i = j4;
        this.f4342j = false;
        this.f4343k = null;
    }

    /* renamed from: a */
    public final boolean mo27832a() {
        String str = this.f4337e;
        return (str == null || str.length() == 0 || !new File(this.f4337e).exists()) ? false : true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f4336d.equals(((C2154ad) obj).f4336d);
    }

    public int hashCode() {
        return this.f4336d.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AdAsset{url='");
        sb.append(this.f4336d);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
