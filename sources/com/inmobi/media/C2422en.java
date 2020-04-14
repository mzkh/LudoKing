package com.inmobi.media;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.inmobi.ads.viewsv2.NativeRecyclerViewAdapter;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.inmobi.media.en */
/* compiled from: ScrollableDeckFreeContainer */
class C2422en extends C2383ef {

    /* renamed from: a */
    private RecyclerView f5160a;

    /* renamed from: b */
    private boolean f5161b = false;

    public C2422en(Context context) {
        super(context, 1);
    }

    /* renamed from: a */
    public final void mo28256a(@NonNull C2216be beVar, C2385eg egVar, int i, int i2, C2384a aVar) {
        LayoutParams layoutParams = (LayoutParams) C2404el.m5006a(beVar.mo27950a(0), (ViewGroup) this);
        if (VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(20);
            layoutParams.setMarginEnd(20);
        } else {
            layoutParams.setMargins(20, 0, 20, 0);
        }
        layoutParams.gravity = i2;
        this.f5160a = new RecyclerView(getContext());
        this.f5160a.setLayoutParams(new LayoutParams(-1, -1));
        this.f5160a.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        addView(this.f5160a);
        this.f5160a.setAdapter((NativeRecyclerViewAdapter) egVar);
    }
}
