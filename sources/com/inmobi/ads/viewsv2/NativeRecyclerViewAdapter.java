package com.inmobi.ads.viewsv2;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.inmobi.media.C2214bc;
import com.inmobi.media.C2216be;
import com.inmobi.media.C2220bg;
import com.inmobi.media.C2368ec;
import com.inmobi.media.C2385eg;
import com.inmobi.media.C2404el;
import java.lang.ref.WeakReference;

public class NativeRecyclerViewAdapter extends Adapter<C2137a> implements C2385eg {

    /* renamed from: a */
    private static final String f4276a = "NativeRecyclerViewAdapter";
    @Nullable

    /* renamed from: b */
    private C2220bg f4277b;

    /* renamed from: c */
    private C2368ec f4278c;

    /* renamed from: d */
    private SparseArray<WeakReference<View>> f4279d = new SparseArray<>();

    /* renamed from: com.inmobi.ads.viewsv2.NativeRecyclerViewAdapter$a */
    class C2137a extends ViewHolder {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public ViewGroup f4281b;

        C2137a(View view) {
            super(view);
            this.f4281b = (ViewGroup) view;
        }
    }

    public NativeRecyclerViewAdapter(@NonNull C2220bg bgVar, @NonNull C2368ec ecVar) {
        this.f4277b = bgVar;
        this.f4278c = ecVar;
    }

    @NonNull
    public C2137a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new C2137a(new FrameLayout(viewGroup.getContext()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        if (r1 == null) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(@androidx.annotation.NonNull com.inmobi.ads.viewsv2.NativeRecyclerViewAdapter.C2137a r5, int r6) {
        /*
            r4 = this;
            com.inmobi.media.bg r0 = r4.f4277b
            if (r0 != 0) goto L_0x0006
            r0 = 0
            goto L_0x000a
        L_0x0006:
            com.inmobi.media.be r0 = r0.mo27957a(r6)
        L_0x000a:
            android.util.SparseArray<java.lang.ref.WeakReference<android.view.View>> r1 = r4.f4279d
            java.lang.Object r1 = r1.get(r6)
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1
            if (r0 == 0) goto L_0x004b
            if (r1 == 0) goto L_0x001e
            java.lang.Object r1 = r1.get()
            android.view.View r1 = (android.view.View) r1
            if (r1 != 0) goto L_0x0026
        L_0x001e:
            android.view.ViewGroup r1 = r5.f4281b
            android.view.ViewGroup r1 = r4.buildScrollableView(r6, r1, r0)
        L_0x0026:
            if (r1 == 0) goto L_0x004b
            int r0 = r4.getItemCount()
            int r0 = r0 + -1
            if (r6 == r0) goto L_0x003a
            android.view.ViewGroup r0 = r5.f4281b
            r2 = 16
            r3 = 0
            r0.setPadding(r3, r3, r2, r3)
        L_0x003a:
            android.view.ViewGroup r5 = r5.f4281b
            r5.addView(r1)
            android.util.SparseArray<java.lang.ref.WeakReference<android.view.View>> r5 = r4.f4279d
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r1)
            r5.put(r6, r0)
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.viewsv2.NativeRecyclerViewAdapter.onBindViewHolder(com.inmobi.ads.viewsv2.NativeRecyclerViewAdapter$a, int):void");
    }

    public void onViewRecycled(@NonNull C2137a aVar) {
        aVar.f4281b.removeAllViews();
        super.onViewRecycled(aVar);
    }

    public ViewGroup buildScrollableView(int i, @NonNull ViewGroup viewGroup, @NonNull C2216be beVar) {
        ViewGroup a = this.f4278c.mo28239a(viewGroup, beVar);
        this.f4278c.mo28242b(a, beVar);
        a.setLayoutParams(C2404el.m5006a((C2214bc) beVar, viewGroup));
        return a;
    }

    public int getItemCount() {
        C2220bg bgVar = this.f4277b;
        if (bgVar == null) {
            return 0;
        }
        return bgVar.mo27961c();
    }

    public void destroy() {
        C2220bg bgVar = this.f4277b;
        if (bgVar != null) {
            bgVar.f4571h = null;
            bgVar.f4569f = null;
            this.f4277b = null;
        }
        this.f4278c = null;
    }
}
