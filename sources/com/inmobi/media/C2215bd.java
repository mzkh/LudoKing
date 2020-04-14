package com.inmobi.media;

import android.graphics.Point;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;

/* renamed from: com.inmobi.media.bd */
/* compiled from: NativeAssetStyle */
public class C2215bd {

    /* renamed from: a */
    public Point f4546a;

    /* renamed from: b */
    public Point f4547b;

    /* renamed from: c */
    public Point f4548c;

    /* renamed from: d */
    public Point f4549d;

    /* renamed from: e */
    protected String f4550e;

    /* renamed from: f */
    protected String f4551f;

    /* renamed from: g */
    protected String f4552g;

    /* renamed from: h */
    protected float f4553h;

    /* renamed from: i */
    protected String f4554i;

    /* renamed from: j */
    protected String f4555j;

    /* renamed from: k */
    protected C2228bl f4556k;

    public C2215bd() {
        this.f4546a = new Point(0, 0);
        this.f4548c = new Point(0, 0);
        this.f4547b = new Point(0, 0);
        this.f4549d = new Point(0, 0);
        this.f4550e = "none";
        this.f4551f = "straight";
        this.f4553h = 10.0f;
        this.f4554i = "#ff000000";
        this.f4555j = "#00000000";
        this.f4552g = "fill";
        this.f4556k = null;
    }

    public C2215bd(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String str, String str2, @NonNull String str3, @NonNull String str4, @Nullable C2228bl blVar) {
        this(i, i2, i3, i4, i5, i6, i7, i8, "fill", str, str2, str3, str4, blVar);
    }

    public C2215bd(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String str, String str2, String str3, @NonNull String str4, @NonNull String str5, @Nullable C2228bl blVar) {
        this.f4546a = new Point(i3, i4);
        this.f4547b = new Point(i7, i8);
        this.f4548c = new Point(i, i2);
        this.f4549d = new Point(i5, i6);
        this.f4550e = str2;
        this.f4551f = str3;
        this.f4553h = 10.0f;
        this.f4552g = str;
        if (str4.length() == 0) {
            str4 = "#ff000000";
        }
        this.f4554i = str4;
        if (str5.length() == 0) {
            str5 = "#00000000";
        }
        this.f4555j = str5;
        this.f4556k = blVar;
    }

    /* renamed from: a */
    public final String mo27943a() {
        return this.f4550e;
    }

    /* renamed from: b */
    public final String mo27944b() {
        return this.f4551f;
    }

    /* renamed from: c */
    public final float mo27945c() {
        return this.f4553h;
    }

    /* renamed from: d */
    public final String mo27946d() {
        return this.f4554i.toLowerCase(Locale.US);
    }

    /* renamed from: e */
    public String mo27947e() {
        return this.f4555j.toLowerCase(Locale.US);
    }

    /* renamed from: f */
    public final String mo27948f() {
        return this.f4552g;
    }

    /* renamed from: g */
    public final C2228bl mo27949g() {
        return this.f4556k;
    }
}
