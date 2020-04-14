package com.tapjoy.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

/* renamed from: com.tapjoy.internal.iv */
public final class C3198iv {

    /* renamed from: a */
    static final Logger f7632a = Logger.getLogger(C3198iv.class.getName());

    private C3198iv() {
    }

    /* renamed from: a */
    public static C3196it m7415a(C3208jc jcVar) {
        if (jcVar != null) {
            return new C3202ix(jcVar);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public static C3195is m7414a(C3207jb jbVar) {
        if (jbVar != null) {
            return new C3201iw(jbVar);
        }
        throw new IllegalArgumentException("sink == null");
    }

    /* renamed from: a */
    public static C3207jb m7416a(final OutputStream outputStream) {
        final C3209jd jdVar = new C3209jd();
        if (outputStream != null) {
            return new C3207jb() {
                /* renamed from: a */
                public final void mo30276a(C3194ir irVar, long j) {
                    C3211je.m7460a(irVar.f7626b, 0, j);
                    while (j > 0) {
                        jdVar.mo30322a();
                        C3203iy iyVar = irVar.f7625a;
                        int min = (int) Math.min(j, (long) (iyVar.f7645c - iyVar.f7644b));
                        outputStream.write(iyVar.f7643a, iyVar.f7644b, min);
                        iyVar.f7644b += min;
                        long j2 = (long) min;
                        j -= j2;
                        irVar.f7626b -= j2;
                        if (iyVar.f7644b == iyVar.f7645c) {
                            irVar.f7625a = iyVar.mo30318a();
                            C3204iz.m7442a(iyVar);
                        }
                    }
                }

                public final void flush() {
                    outputStream.flush();
                }

                public final void close() {
                    outputStream.close();
                }

                public final String toString() {
                    StringBuilder sb = new StringBuilder("sink(");
                    sb.append(outputStream);
                    sb.append(")");
                    return sb.toString();
                }
            };
        }
        throw new IllegalArgumentException("out == null");
    }

    /* renamed from: a */
    public static C3208jc m7417a(final InputStream inputStream) {
        final C3209jd jdVar = new C3209jd();
        if (inputStream != null) {
            return new C3208jc() {
                /* renamed from: b */
                public final long mo30277b(C3194ir irVar, long j) {
                    if (j < 0) {
                        StringBuilder sb = new StringBuilder("byteCount < 0: ");
                        sb.append(j);
                        throw new IllegalArgumentException(sb.toString());
                    } else if (j == 0) {
                        return 0;
                    } else {
                        try {
                            jdVar.mo30322a();
                            C3203iy c = irVar.mo30284c(1);
                            int read = inputStream.read(c.f7643a, c.f7645c, (int) Math.min(j, (long) (8192 - c.f7645c)));
                            if (read == -1) {
                                return -1;
                            }
                            c.f7645c += read;
                            long j2 = (long) read;
                            irVar.f7626b += j2;
                            return j2;
                        } catch (AssertionError e) {
                            if (C3198iv.m7418a(e)) {
                                throw new IOException(e);
                            }
                            throw e;
                        }
                    }
                }

                public final void close() {
                    inputStream.close();
                }

                public final String toString() {
                    StringBuilder sb = new StringBuilder("source(");
                    sb.append(inputStream);
                    sb.append(")");
                    return sb.toString();
                }
            };
        }
        throw new IllegalArgumentException("in == null");
    }

    /* renamed from: a */
    static boolean m7418a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
