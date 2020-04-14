package com.inmobi.media;

import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

/* renamed from: com.inmobi.media.cf */
/* compiled from: BidManager */
public final class C2276cf {

    /* renamed from: d */
    private static final String f4779d = "cf";
    @VisibleForTesting

    /* renamed from: a */
    public byte[] f4780a = C2524gn.m5376a(16);
    @VisibleForTesting

    /* renamed from: b */
    public final byte[] f4781b = C2524gn.m5375a();

    /* renamed from: c */
    public final byte[] f4782c = C2524gn.m5376a(8);

    @Nullable
    /* renamed from: a */
    public final String mo28108a(String str, String str2) {
        try {
            byte[] a = C2524gn.m5377a(this.f4781b);
            return new String(Base64.encode(C2524gn.m5378a(C2524gn.m5379a(C2524gn.m5379a(a, C2524gn.m5377a(this.f4782c)), C2524gn.m5377a(this.f4780a)), str2, str), 8));
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    /* renamed from: a */
    public final String mo28107a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return C2487fs.m5228a(C2524gn.m5380a(Base64.decode(str, 0), this.f4781b, this.f4780a));
        } catch (Exception unused) {
            return null;
        }
    }
}
