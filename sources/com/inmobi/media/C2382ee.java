package com.inmobi.media;

import android.content.Context;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* renamed from: com.inmobi.media.ee */
/* compiled from: NativeRootContainerLayout */
public final class C2382ee extends C2359dz {

    /* renamed from: a */
    private WeakReference<C2542h> f5070a;

    public C2382ee(@NonNull Context context) {
        super(context);
    }

    public final void setNativeStrandAd(@NonNull C2542h hVar) {
        this.f5070a = new WeakReference<>(hVar);
    }

    public final C2542h getNativeStrandAd() {
        return (C2542h) this.f5070a.get();
    }
}
