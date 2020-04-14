package com.tapjoy.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;

/* renamed from: com.tapjoy.internal.ej */
public abstract class C2991ej {

    /* renamed from: c */
    public static final C2991ej f6899c = new C2991ej(C2986eg.VARINT, Boolean.class) {
        /* renamed from: a */
        public final /* bridge */ /* synthetic */ int mo29978a(Object obj) {
            return 1;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo29981a(C3008el elVar, Object obj) {
            elVar.mo30005c(((Boolean) obj).booleanValue() ? 1 : 0);
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29980a(C3007ek ekVar) {
            int d = ekVar.mo29999d();
            if (d == 0) {
                return Boolean.FALSE;
            }
            if (d == 1) {
                return Boolean.TRUE;
            }
            throw new IOException(String.format("Invalid boolean value 0x%02x", new Object[]{Integer.valueOf(d)}));
        }
    };

    /* renamed from: d */
    public static final C2991ej f6900d = new C2991ej(C2986eg.VARINT, Integer.class) {
        /* renamed from: a */
        public final /* synthetic */ int mo29978a(Object obj) {
            int intValue = ((Integer) obj).intValue();
            if (intValue >= 0) {
                return C3008el.m6874a(intValue);
            }
            return 10;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo29981a(C3008el elVar, Object obj) {
            int intValue = ((Integer) obj).intValue();
            if (intValue >= 0) {
                elVar.mo30005c(intValue);
            } else {
                elVar.mo30006c((long) intValue);
            }
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29980a(C3007ek ekVar) {
            return Integer.valueOf(ekVar.mo29999d());
        }
    };

    /* renamed from: e */
    public static final C2991ej f6901e = new C2991ej(C2986eg.VARINT, Integer.class) {
        /* renamed from: a */
        public final /* synthetic */ int mo29978a(Object obj) {
            return C3008el.m6874a(((Integer) obj).intValue());
        }

        /* renamed from: a */
        public final /* synthetic */ void mo29981a(C3008el elVar, Object obj) {
            elVar.mo30005c(((Integer) obj).intValue());
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29980a(C3007ek ekVar) {
            return Integer.valueOf(ekVar.mo29999d());
        }
    };

    /* renamed from: f */
    public static final C2991ej f6902f = new C2991ej(C2986eg.VARINT, Integer.class) {
        /* renamed from: a */
        public final /* synthetic */ int mo29978a(Object obj) {
            return C3008el.m6874a(C3008el.m6877b(((Integer) obj).intValue()));
        }

        /* renamed from: a */
        public final /* synthetic */ void mo29981a(C3008el elVar, Object obj) {
            elVar.mo30005c(C3008el.m6877b(((Integer) obj).intValue()));
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29980a(C3007ek ekVar) {
            int d = ekVar.mo29999d();
            return Integer.valueOf((-(d & 1)) ^ (d >>> 1));
        }
    };

    /* renamed from: g */
    public static final C2991ej f6903g;

    /* renamed from: h */
    public static final C2991ej f6904h;

    /* renamed from: i */
    public static final C2991ej f6905i = new C2991ej(C2986eg.VARINT, Long.class) {
        /* renamed from: a */
        public final /* synthetic */ int mo29978a(Object obj) {
            return C3008el.m6876a(((Long) obj).longValue());
        }

        /* renamed from: a */
        public final /* synthetic */ void mo29981a(C3008el elVar, Object obj) {
            elVar.mo30006c(((Long) obj).longValue());
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29980a(C3007ek ekVar) {
            return Long.valueOf(ekVar.mo30000e());
        }
    };

    /* renamed from: j */
    public static final C2991ej f6906j = new C2991ej(C2986eg.VARINT, Long.class) {
        /* renamed from: a */
        public final /* synthetic */ int mo29978a(Object obj) {
            return C3008el.m6876a(((Long) obj).longValue());
        }

        /* renamed from: a */
        public final /* synthetic */ void mo29981a(C3008el elVar, Object obj) {
            elVar.mo30006c(((Long) obj).longValue());
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29980a(C3007ek ekVar) {
            return Long.valueOf(ekVar.mo30000e());
        }
    };

    /* renamed from: k */
    public static final C2991ej f6907k = new C2991ej(C2986eg.VARINT, Long.class) {
        /* renamed from: a */
        public final /* synthetic */ int mo29978a(Object obj) {
            return C3008el.m6876a(C3008el.m6878b(((Long) obj).longValue()));
        }

        /* renamed from: a */
        public final /* synthetic */ void mo29981a(C3008el elVar, Object obj) {
            elVar.mo30006c(C3008el.m6878b(((Long) obj).longValue()));
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29980a(C3007ek ekVar) {
            long e = ekVar.mo30000e();
            return Long.valueOf((-(e & 1)) ^ (e >>> 1));
        }
    };

    /* renamed from: l */
    public static final C2991ej f6908l;

    /* renamed from: m */
    public static final C2991ej f6909m;

    /* renamed from: n */
    public static final C2991ej f6910n = new C2991ej(C2986eg.FIXED32, Float.class) {
        /* renamed from: a */
        public final /* bridge */ /* synthetic */ int mo29978a(Object obj) {
            return 4;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo29981a(C3008el elVar, Object obj) {
            elVar.mo30007d(Float.floatToIntBits(((Float) obj).floatValue()));
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29980a(C3007ek ekVar) {
            return Float.valueOf(Float.intBitsToFloat(ekVar.mo30001f()));
        }
    };

    /* renamed from: o */
    public static final C2991ej f6911o = new C2991ej(C2986eg.FIXED64, Double.class) {
        /* renamed from: a */
        public final /* bridge */ /* synthetic */ int mo29978a(Object obj) {
            return 8;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo29981a(C3008el elVar, Object obj) {
            elVar.mo30008d(Double.doubleToLongBits(((Double) obj).doubleValue()));
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29980a(C3007ek ekVar) {
            return Double.valueOf(Double.longBitsToDouble(ekVar.mo30002g()));
        }
    };

    /* renamed from: p */
    public static final C2991ej f6912p = new C2991ej(C2986eg.LENGTH_DELIMITED, String.class) {
        /* renamed from: a */
        public final /* synthetic */ int mo29978a(Object obj) {
            String str = (String) obj;
            int length = str.length();
            int i = 0;
            int i2 = 0;
            while (i < length) {
                char charAt = str.charAt(i);
                if (charAt >= 128) {
                    if (charAt < 2048) {
                        i2 += 2;
                    } else if (charAt < 55296 || charAt > 57343) {
                        i2 += 3;
                    } else if (charAt <= 56319) {
                        int i3 = i + 1;
                        if (i3 < length && str.charAt(i3) >= 56320 && str.charAt(i3) <= 57343) {
                            i2 += 4;
                            i = i3;
                        }
                    }
                    i++;
                }
                i2++;
                i++;
            }
            return i2;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo29981a(C3008el elVar, Object obj) {
            elVar.f6927a.mo30280b((String) obj);
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29980a(C3007ek ekVar) {
            return ekVar.f6919a.mo30285c(ekVar.mo30003h());
        }
    };

    /* renamed from: q */
    public static final C2991ej f6913q = new C2991ej(C2986eg.LENGTH_DELIMITED, C3197iu.class) {
        /* renamed from: a */
        public final /* synthetic */ int mo29978a(Object obj) {
            return ((C3197iu) obj).mo30308c();
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo29981a(C3008el elVar, Object obj) {
            elVar.mo30004a((C3197iu) obj);
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29980a(C3007ek ekVar) {
            return ekVar.f6919a.mo30281b(ekVar.mo30003h());
        }
    };

    /* renamed from: a */
    final Class f6914a;

    /* renamed from: b */
    C2991ej f6915b;

    /* renamed from: r */
    private final C2986eg f6916r;

    /* renamed from: com.tapjoy.internal.ej$a */
    public static final class C3006a extends IllegalArgumentException {

        /* renamed from: a */
        public final int f6918a;

        C3006a(int i, Class cls) {
            StringBuilder sb = new StringBuilder("Unknown enum tag ");
            sb.append(i);
            sb.append(" for ");
            sb.append(cls.getCanonicalName());
            super(sb.toString());
            this.f6918a = i;
        }
    }

    /* renamed from: a */
    public abstract int mo29978a(Object obj);

    /* renamed from: a */
    public abstract Object mo29980a(C3007ek ekVar);

    /* renamed from: a */
    public abstract void mo29981a(C3008el elVar, Object obj);

    public C2991ej(C2986eg egVar, Class cls) {
        this.f6916r = egVar;
        this.f6914a = cls;
    }

    /* renamed from: a */
    public int mo29988a(int i, Object obj) {
        int a = mo29978a(obj);
        if (this.f6916r == C2986eg.LENGTH_DELIMITED) {
            a += C3008el.m6874a(a);
        }
        return a + C3008el.m6874a(C3008el.m6875a(i, C2986eg.VARINT));
    }

    /* renamed from: a */
    public void mo29992a(C3008el elVar, int i, Object obj) {
        elVar.mo30005c(C3008el.m6875a(i, this.f6916r));
        if (this.f6916r == C2986eg.LENGTH_DELIMITED) {
            elVar.mo30005c(mo29978a(obj));
        }
        mo29981a(elVar, obj);
    }

    /* renamed from: a */
    private void m6806a(C3195is isVar, Object obj) {
        C2990ei.m6804a(obj, "value == null");
        C2990ei.m6804a(isVar, "sink == null");
        mo29981a(new C3008el(isVar), obj);
    }

    /* renamed from: b */
    public final byte[] mo29994b(Object obj) {
        C2990ei.m6804a(obj, "value == null");
        C3194ir irVar = new C3194ir();
        try {
            m6806a((C3195is) irVar, obj);
            return irVar.mo30298g();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public final void mo29993a(OutputStream outputStream, Object obj) {
        C2990ei.m6804a(obj, "value == null");
        C2990ei.m6804a(outputStream, "stream == null");
        C3195is a = C3198iv.m7414a(C3198iv.m7416a(outputStream));
        m6806a(a, obj);
        a.mo30274a();
    }

    /* renamed from: a */
    public final Object mo29991a(byte[] bArr) {
        C2990ei.m6804a(bArr, "bytes == null");
        C3194ir irVar = new C3194ir();
        if (bArr != null) {
            return m6805a((C3196it) irVar.mo30273a(bArr, 0, bArr.length));
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public final Object mo29990a(InputStream inputStream) {
        C2990ei.m6804a(inputStream, "stream == null");
        return m6805a(C3198iv.m7415a(C3198iv.m7417a(inputStream)));
    }

    /* renamed from: a */
    private Object m6805a(C3196it itVar) {
        C2990ei.m6804a(itVar, "source == null");
        return mo29980a(new C3007ek(itVar));
    }

    /* renamed from: c */
    public static String m6807c(Object obj) {
        return obj.toString();
    }

    static {
        C299310 r0 = new C2991ej(C2986eg.FIXED32, Integer.class) {
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ int mo29978a(Object obj) {
                return 4;
            }

            /* renamed from: a */
            public final /* synthetic */ void mo29981a(C3008el elVar, Object obj) {
                elVar.mo30007d(((Integer) obj).intValue());
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo29980a(C3007ek ekVar) {
                return Integer.valueOf(ekVar.mo30001f());
            }
        };
        f6903g = r0;
        f6904h = r0;
        C299714 r02 = new C2991ej(C2986eg.FIXED64, Long.class) {
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ int mo29978a(Object obj) {
                return 8;
            }

            /* renamed from: a */
            public final /* synthetic */ void mo29981a(C3008el elVar, Object obj) {
                elVar.mo30008d(((Long) obj).longValue());
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo29980a(C3007ek ekVar) {
                return Long.valueOf(ekVar.mo30002g());
            }
        };
        f6908l = r02;
        f6909m = r02;
    }

    /* renamed from: a */
    public final C2991ej mo29989a() {
        C2991ej ejVar = this.f6915b;
        if (ejVar != null) {
            return ejVar;
        }
        C30026 r0 = new C2991ej(this.f6916r, List.class) {
            /* renamed from: a */
            public final /* synthetic */ int mo29988a(int i, Object obj) {
                List list = (List) obj;
                int i2 = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    i2 += C2991ej.this.mo29988a(i, list.get(i3));
                }
                return i2;
            }

            /* renamed from: a */
            public final /* synthetic */ void mo29992a(C3008el elVar, int i, Object obj) {
                List list = (List) obj;
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    C2991ej.this.mo29992a(elVar, i, list.get(i2));
                }
            }

            /* renamed from: a */
            public final /* synthetic */ Object mo29980a(C3007ek ekVar) {
                return Collections.singletonList(C2991ej.this.mo29980a(ekVar));
            }

            /* renamed from: a */
            public final /* synthetic */ void mo29981a(C3008el elVar, Object obj) {
                throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
            }

            /* renamed from: a */
            public final /* synthetic */ int mo29978a(Object obj) {
                throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
            }
        };
        this.f6915b = r0;
        return r0;
    }
}
