package com.applovin.impl.mediation.p006a.p007a;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

/* renamed from: com.applovin.impl.mediation.a.a.a */
public class C0910a {

    /* renamed from: a */
    public TextView f1690a;

    /* renamed from: b */
    public TextView f1691b;

    /* renamed from: c */
    public ImageView f1692c;

    /* renamed from: d */
    private C0911b f1693d;

    /* renamed from: a */
    public C0911b mo9309a() {
        return this.f1693d;
    }

    /* renamed from: a */
    public void mo9310a(C0911b bVar) {
        this.f1693d = bVar;
        this.f1690a.setText(bVar.mo9312c());
        if (this.f1691b != null) {
            if (!TextUtils.isEmpty(bVar.mo9313d())) {
                this.f1691b.setVisibility(0);
                this.f1691b.setText(bVar.mo9313d());
            } else {
                this.f1691b.setVisibility(8);
            }
        }
        if (this.f1692c == null) {
            return;
        }
        if (bVar.mo9316g() > 0) {
            this.f1692c.setImageResource(bVar.mo9316g());
            this.f1692c.setColorFilter(bVar.mo9317h());
            this.f1692c.setVisibility(0);
            return;
        }
        this.f1692c.setVisibility(8);
    }
}
