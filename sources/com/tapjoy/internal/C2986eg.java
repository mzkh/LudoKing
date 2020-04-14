package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.eg */
public enum C2986eg {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    FIXED32(5);
    

    /* renamed from: e */
    final int f6891e;

    /* renamed from: com.tapjoy.internal.eg$1 */
    static /* synthetic */ class C29871 {

        /* renamed from: a */
        static final /* synthetic */ int[] f6892a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.tapjoy.internal.eg[] r0 = com.tapjoy.internal.C2986eg.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6892a = r0
                int[] r0 = f6892a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.tapjoy.internal.eg r1 = com.tapjoy.internal.C2986eg.VARINT     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f6892a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.tapjoy.internal.eg r1 = com.tapjoy.internal.C2986eg.FIXED32     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f6892a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.tapjoy.internal.eg r1 = com.tapjoy.internal.C2986eg.FIXED64     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f6892a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.tapjoy.internal.eg r1 = com.tapjoy.internal.C2986eg.LENGTH_DELIMITED     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C2986eg.C29871.<clinit>():void");
        }
    }

    private C2986eg(int i) {
        this.f6891e = i;
    }

    /* renamed from: a */
    public final C2991ej mo29982a() {
        int i = C29871.f6892a[ordinal()];
        if (i == 1) {
            return C2991ej.f6906j;
        }
        if (i == 2) {
            return C2991ej.f6903g;
        }
        if (i == 3) {
            return C2991ej.f6908l;
        }
        if (i == 4) {
            return C2991ej.f6913q;
        }
        throw new AssertionError();
    }
}
