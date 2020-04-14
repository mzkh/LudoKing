package com.inmobi.media;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;

/* renamed from: com.inmobi.media.bk */
/* compiled from: NativeTextAsset */
public class C2226bk extends C2214bc {

    /* renamed from: com.inmobi.media.bk$a */
    /* compiled from: NativeTextAsset */
    public static class C2227a extends C2215bd {

        /* renamed from: l */
        protected int f4598l;

        /* renamed from: m */
        protected String f4599m;

        /* renamed from: n */
        protected int f4600n;

        /* renamed from: o */
        protected String[] f4601o;

        /* renamed from: p */
        public int f4602p;

        public C2227a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String str, String str2, @NonNull String str3, @NonNull String str4, @Nullable C2228bl blVar) {
            int i9 = i;
            int i10 = i2;
            int i11 = i3;
            int i12 = i4;
            int i13 = i5;
            int i14 = i6;
            int i15 = i7;
            int i16 = i8;
            String str5 = str;
            String str6 = str2;
            String str7 = str3;
            String str8 = str4;
            C2228bl blVar2 = blVar;
            String[] strArr = new String[1];
            String[] strArr2 = strArr;
            strArr[0] = "none";
            this(i9, i10, i11, i12, i13, i14, i15, i16, str5, str6, str7, str8, 12, 0, Integer.MAX_VALUE, "#ff000000", strArr2, blVar2);
        }

        public C2227a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String str, String str2, @NonNull String str3, @NonNull String str4, int i9, int i10, int i11, @NonNull String str5, String[] strArr, @Nullable C2228bl blVar) {
            String[] strArr2 = strArr;
            super(i, i2, i3, i4, i5, i6, i7, i8, str, str2, str3, str4, blVar);
            this.f4598l = i9;
            this.f4599m = str5.length() == 0 ? "#ff000000" : str5;
            this.f4600n = i11;
            int min = Math.min(strArr2.length, 4);
            this.f4601o = new String[min];
            this.f4602p = i10;
            System.arraycopy(strArr2, 0, this.f4601o, 0, min);
        }

        /* renamed from: h */
        public final int mo27965h() {
            return this.f4598l;
        }

        /* renamed from: i */
        public final String mo27966i() {
            return this.f4599m.toLowerCase(Locale.US);
        }

        /* renamed from: j */
        public final String[] mo27967j() {
            return this.f4601o;
        }

        /* renamed from: e */
        public final String mo27947e() {
            return this.f4555j.toLowerCase(Locale.US);
        }
    }

    public C2226bk(String str, String str2, C2215bd bdVar, String str3) {
        super(str, str2, "TEXT", bdVar);
        this.f4525e = str3;
    }

    public C2226bk(String str, String str2, String str3, C2215bd bdVar, String str4) {
        super(str, str2, str3, bdVar);
        this.f4525e = str4;
    }
}
