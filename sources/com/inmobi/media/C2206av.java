package com.inmobi.media;

import androidx.annotation.NonNull;

/* renamed from: com.inmobi.media.av */
/* compiled from: RawAsset */
public final class C2206av {

    /* renamed from: a */
    final int f4509a;
    @NonNull

    /* renamed from: b */
    final String f4510b;

    public C2206av(int i, @NonNull String str) {
        this.f4509a = i;
        this.f4510b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2206av)) {
            return false;
        }
        C2206av avVar = (C2206av) obj;
        return this.f4509a == avVar.f4509a && this.f4510b.equals(avVar.f4510b);
    }

    public final int hashCode() {
        return (this.f4509a * 31) + this.f4510b.hashCode();
    }
}
