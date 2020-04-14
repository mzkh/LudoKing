package com.applovin.impl.mediation.p006a.p009c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.applovin.impl.mediation.p006a.p007a.C0910a;
import com.applovin.impl.mediation.p006a.p007a.C0911b;
import com.applovin.sdk.C1314R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.applovin.impl.mediation.a.c.a */
public abstract class C0920a extends BaseAdapter implements OnClickListener {

    /* renamed from: a */
    protected final Context f1728a;

    /* renamed from: b */
    protected final List<C0911b> f1729b = new ArrayList();

    /* renamed from: c */
    private final LayoutInflater f1730c;

    protected C0920a(Context context) {
        this.f1728a = context;
        this.f1730c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* renamed from: a */
    public C0911b getItem(int i) {
        return (C0911b) this.f1729b.get(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo9343a(C0911b bVar);

    public boolean areAllItemsEnabled() {
        return false;
    }

    public int getCount() {
        return this.f1729b.size();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return getItem(i).mo9314e();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C0910a aVar;
        C0911b a = getItem(i);
        if (view == null) {
            view = this.f1730c.inflate(a.mo9315f(), viewGroup, false);
            aVar = new C0910a();
            aVar.f1690a = (TextView) view.findViewById(16908308);
            aVar.f1691b = (TextView) view.findViewById(16908309);
            aVar.f1692c = (ImageView) view.findViewById(C1314R.C1316id.imageView);
            view.setTag(aVar);
            view.setOnClickListener(this);
        } else {
            aVar = (C0910a) view.getTag();
        }
        aVar.mo9310a(a);
        view.setEnabled(a.mo9311b());
        return view;
    }

    public int getViewTypeCount() {
        return C0911b.m1442a();
    }

    public boolean isEnabled(int i) {
        return getItem(i).mo9311b();
    }

    public void onClick(View view) {
        mo9343a(((C0910a) view.getTag()).mo9309a());
    }
}
