package com.inmobi.media;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/* renamed from: com.inmobi.media.fs */
/* compiled from: NetworkResponse */
public class C2487fs {

    /* renamed from: d */
    private static final String f5451d = "fs";

    /* renamed from: a */
    public C2485fq f5452a;

    /* renamed from: b */
    public int f5453b;

    /* renamed from: c */
    public Map<String, List<String>> f5454c;

    /* renamed from: e */
    private String f5455e;

    /* renamed from: f */
    private byte[] f5456f;

    /* renamed from: a */
    public final boolean mo28417a() {
        return this.f5452a != null;
    }

    /* renamed from: b */
    public final String mo28418b() {
        if (this.f5455e == null) {
            this.f5455e = m5228a(this.f5456f);
        }
        return this.f5455e;
    }

    /* renamed from: a */
    public static String m5228a(byte[] bArr) {
        String str = "";
        if (!(bArr == null || bArr.length == 0)) {
            try {
                return new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return str;
    }

    /* renamed from: c */
    public final byte[] mo28420c() {
        byte[] bArr = this.f5456f;
        if (bArr == null || bArr.length == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* renamed from: b */
    public final void mo28419b(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            this.f5456f = new byte[0];
            return;
        }
        this.f5456f = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.f5456f, 0, bArr.length);
    }

    /* renamed from: d */
    public final long mo28421d() {
        try {
            if (this.f5455e != null) {
                return ((long) this.f5455e.length()) + 0;
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }
}
