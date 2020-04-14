package com.inmobi.media;

import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.inmobi.media.ae */
/* compiled from: AdAssetBatch */
public final class C2156ae {

    /* renamed from: a */
    public List<C2154ad> f4353a = new ArrayList();

    /* renamed from: b */
    Set<C2206av> f4354b;

    /* renamed from: c */
    Set<String> f4355c = new HashSet();

    /* renamed from: d */
    int f4356d;

    /* renamed from: e */
    int f4357e;
    @Nullable

    /* renamed from: f */
    public String f4358f;

    /* renamed from: g */
    public String f4359g;

    /* renamed from: h */
    private String f4360h;

    /* renamed from: i */
    private String f4361i;

    /* renamed from: j */
    private final WeakReference<C2182ap> f4362j;

    public C2156ae(String str, String str2, Set<C2206av> set, C2182ap apVar) {
        this.f4360h = str;
        this.f4361i = str2;
        this.f4354b = set;
        this.f4362j = new WeakReference<>(apVar);
    }

    public C2156ae(String str, Set<C2206av> set, C2182ap apVar, String str2) {
        this.f4360h = str;
        this.f4359g = str2;
        this.f4354b = set;
        this.f4362j = new WeakReference<>(apVar);
    }

    @Nullable
    /* renamed from: a */
    public final C2182ap mo27839a() {
        return (C2182ap) this.f4362j.get();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AdAssetBatch{mRawAssets=");
        sb.append(this.f4354b);
        sb.append(", mBatchDownloadSuccessCount=");
        sb.append(this.f4356d);
        sb.append(", mBatchDownloadFailureCount=");
        sb.append(this.f4357e);
        sb.append('}');
        return sb.toString();
    }
}
