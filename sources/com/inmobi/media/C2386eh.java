package com.inmobi.media;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.inmobi.ads.viewsv2.NativeRecyclerViewAdapter;

/* renamed from: com.inmobi.media.eh */
/* compiled from: NativeScrollableDataSourceFactory */
final class C2386eh {
    @Nullable
    /* renamed from: a */
    public static C2385eg m4963a(int i, @NonNull C2220bg bgVar, @NonNull C2368ec ecVar) {
        if (i == 0) {
            return new C2362ea(bgVar, ecVar);
        }
        if (i != 1) {
            return null;
        }
        try {
            return new NativeRecyclerViewAdapter(bgVar, ecVar);
        } catch (NoClassDefFoundError e) {
            C2514gh.m5342a(1, "InMobi", "Error rendering ad! RecyclerView not found. Please check if the recyclerview support library was included");
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return null;
        }
    }
}
