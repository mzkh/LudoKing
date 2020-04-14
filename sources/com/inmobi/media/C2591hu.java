package com.inmobi.media;

import androidx.annotation.NonNull;
import java.io.Serializable;

/* renamed from: com.inmobi.media.hu */
/* compiled from: TimeoutConfigurations */
public final class C2591hu implements Serializable {

    /* renamed from: a */
    private int f5714a;

    /* renamed from: b */
    private int f5715b;

    /* renamed from: c */
    private int f5716c;

    /* renamed from: d */
    private int f5717d;

    /* renamed from: e */
    private int f5718e;

    /* renamed from: f */
    private int f5719f;

    /* renamed from: g */
    private int f5720g;

    /* renamed from: h */
    private int f5721h;

    /* renamed from: i */
    private int f5722i;

    /* renamed from: j */
    private int f5723j;

    /* renamed from: com.inmobi.media.hu$a */
    /* compiled from: TimeoutConfigurations */
    public static class C2592a {

        /* renamed from: a */
        private int f5724a = 5000;

        /* renamed from: b */
        private int f5725b = 20000;

        /* renamed from: c */
        private int f5726c = 8000;

        /* renamed from: d */
        private int f5727d = 15000;

        /* renamed from: e */
        private int f5728e = 15000;

        /* renamed from: f */
        private int f5729f = 15000;

        /* renamed from: g */
        private int f5730g = 15000;

        /* renamed from: h */
        private int f5731h = 15000;

        /* renamed from: i */
        private int f5732i = 6300;

        /* renamed from: j */
        private int f5733j = 15000;

        @NonNull
        /* renamed from: a */
        public final C2591hu mo28600a() {
            int i = this.f5733j;
            if (i == 15000 || i == 1000) {
                this.f5733j = this.f5730g;
            }
            C2591hu huVar = new C2591hu(this.f5724a, this.f5725b, this.f5726c, this.f5727d, this.f5728e, this.f5729f, this.f5730g, this.f5731h, this.f5732i, this.f5733j);
            return huVar;
        }

        @NonNull
        /* renamed from: a */
        public final C2592a mo28599a(int i) {
            if (i < 1000) {
                i = 1000;
            }
            this.f5724a = i;
            return this;
        }

        @NonNull
        /* renamed from: b */
        public final C2592a mo28601b(int i) {
            if (i < 1000) {
                i = 1000;
            }
            this.f5725b = i;
            return this;
        }

        @NonNull
        /* renamed from: c */
        public final C2592a mo28602c(int i) {
            if (i < 1000) {
                i = 1000;
            }
            this.f5726c = i;
            return this;
        }

        @NonNull
        /* renamed from: d */
        public final C2592a mo28603d(int i) {
            if (i < 1000) {
                i = 1000;
            }
            this.f5727d = i;
            return this;
        }

        @NonNull
        /* renamed from: e */
        public final C2592a mo28604e(int i) {
            if (i < 1000) {
                i = 1000;
            }
            this.f5728e = i;
            return this;
        }

        @NonNull
        /* renamed from: f */
        public final C2592a mo28605f(int i) {
            if (i < 1000) {
                i = 1000;
            }
            this.f5729f = i;
            return this;
        }

        @NonNull
        /* renamed from: g */
        public final C2592a mo28606g(int i) {
            if (i < 1000) {
                i = 1000;
            }
            this.f5730g = i;
            return this;
        }

        @NonNull
        /* renamed from: h */
        public final C2592a mo28607h(int i) {
            if (i < 1000) {
                i = 1000;
            }
            this.f5731h = i;
            return this;
        }

        @NonNull
        /* renamed from: i */
        public final C2592a mo28608i(int i) {
            if (i < 1000) {
                i = 1000;
            }
            this.f5732i = i;
            return this;
        }

        @NonNull
        /* renamed from: j */
        public final C2592a mo28609j(int i) {
            if (i < 1000) {
                i = 1000;
            }
            this.f5733j = i;
            return this;
        }
    }

    /* renamed from: com.inmobi.media.hu$b */
    /* compiled from: TimeoutConfigurations */
    public static class C2593b {

        /* renamed from: a */
        public int f5734a = 5000;

        /* renamed from: b */
        public int f5735b = 15000;

        /* renamed from: c */
        public int f5736c = 15000;

        /* renamed from: d */
        public int f5737d = 15000;

        /* renamed from: e */
        public int f5738e = 15000;

        /* renamed from: f */
        public int f5739f = 15000;

        /* renamed from: g */
        public int f5740g = 6300;

        /* renamed from: h */
        public int f5741h = 15000;

        /* renamed from: i */
        private int f5742i = 20000;

        /* renamed from: j */
        private int f5743j = 8000;

        @NonNull
        /* renamed from: a */
        public final C2591hu mo28610a() {
            C2591hu huVar = new C2591hu(this.f5734a, this.f5742i, this.f5743j, this.f5735b, this.f5736c, this.f5737d, this.f5738e, this.f5739f, this.f5740g, this.f5741h);
            return huVar;
        }
    }

    @NonNull
    /* renamed from: a */
    public static C2592a m5638a() {
        return new C2592a();
    }

    @NonNull
    /* renamed from: b */
    public static C2593b m5639b() {
        return new C2593b();
    }

    C2591hu(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f5714a = i;
        this.f5715b = i2;
        this.f5716c = i3;
        this.f5717d = i4;
        this.f5718e = i5;
        this.f5719f = i6;
        this.f5720g = i7;
        this.f5721h = i8;
        this.f5722i = i9;
        this.f5723j = i10;
    }

    /* renamed from: c */
    public final int mo28589c() {
        return this.f5714a;
    }

    /* renamed from: d */
    public final int mo28590d() {
        return this.f5715b;
    }

    /* renamed from: e */
    public final int mo28591e() {
        return this.f5716c;
    }

    /* renamed from: f */
    public final int mo28592f() {
        return this.f5717d;
    }

    /* renamed from: g */
    public final int mo28593g() {
        return this.f5718e;
    }

    /* renamed from: h */
    public final int mo28594h() {
        return this.f5719f;
    }

    /* renamed from: i */
    public final int mo28595i() {
        return this.f5720g;
    }

    /* renamed from: j */
    public final int mo28596j() {
        return this.f5721h;
    }

    /* renamed from: k */
    public final int mo28597k() {
        return this.f5722i;
    }

    /* renamed from: l */
    public final int mo28598l() {
        return this.f5723j;
    }
}
