package com.tapjoy.internal;

import android.view.animation.Animation;

/* renamed from: com.tapjoy.internal.ad */
public class C2864ad {

    /* renamed from: a */
    protected final Animation f6633a;

    /* renamed from: com.tapjoy.internal.ad$1 */
    public static /* synthetic */ class C28651 {

        /* renamed from: a */
        public static final /* synthetic */ int[] f6634a = new int[C2866a.m6566a().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0011 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0021 */
        static {
            /*
                int[] r0 = com.tapjoy.internal.C2864ad.C2866a.m6566a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6634a = r0
                r0 = 1
                int[] r1 = f6634a     // Catch:{ NoSuchFieldError -> 0x0011 }
                int r2 = com.tapjoy.internal.C2864ad.C2866a.f6635a     // Catch:{ NoSuchFieldError -> 0x0011 }
                int r2 = r2 - r0
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0011 }
            L_0x0011:
                int[] r1 = f6634a     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r2 = com.tapjoy.internal.C2864ad.C2866a.f6636b     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r2 = r2 - r0
                r3 = 2
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                int[] r1 = f6634a     // Catch:{ NoSuchFieldError -> 0x0021 }
                int r2 = com.tapjoy.internal.C2864ad.C2866a.f6637c     // Catch:{ NoSuchFieldError -> 0x0021 }
                int r2 = r2 - r0
                r3 = 3
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0021 }
            L_0x0021:
                int[] r1 = f6634a     // Catch:{ NoSuchFieldError -> 0x0029 }
                int r2 = com.tapjoy.internal.C2864ad.C2866a.f6638d     // Catch:{ NoSuchFieldError -> 0x0029 }
                int r2 = r2 - r0
                r0 = 4
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0029 }
            L_0x0029:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C2864ad.C28651.<clinit>():void");
        }
    }

    /* renamed from: com.tapjoy.internal.ad$a */
    public enum C2866a {
        ;
        

        /* renamed from: a */
        public static final int f6635a = 1;

        /* renamed from: b */
        public static final int f6636b = 2;

        /* renamed from: c */
        public static final int f6637c = 3;

        /* renamed from: d */
        public static final int f6638d = 4;

        static {
            f6639e = new int[]{f6635a, f6636b, f6637c, f6638d};
        }

        /* renamed from: a */
        public static int[] m6566a() {
            return (int[]) f6639e.clone();
        }
    }

    public C2864ad(Animation animation) {
        this.f6633a = animation;
        animation.setDuration(400);
    }

    /* renamed from: a */
    public Animation mo29794a() {
        return this.f6633a;
    }

    /* renamed from: b */
    public final C2864ad mo29795b() {
        this.f6633a.setDuration(600);
        return this;
    }
}
