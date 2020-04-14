package com.applovin.impl.adview;

import android.content.Context;
import android.view.View;
import com.applovin.impl.sdk.C1192i;

/* renamed from: com.applovin.impl.adview.h */
public abstract class C0826h extends View {

    /* renamed from: a */
    protected final C1192i f1455a;

    /* renamed from: b */
    protected final Context f1456b;

    /* renamed from: com.applovin.impl.adview.h$a */
    public enum C0827a {
        WhiteXOnOpaqueBlack(0),
        WhiteXOnTransparentGrey(1),
        Invisible(2);
        

        /* renamed from: d */
        private final int f1461d;

        private C0827a(int i) {
            this.f1461d = i;
        }

        /* renamed from: a */
        public int mo9082a() {
            return this.f1461d;
        }
    }

    C0826h(C1192i iVar, Context context) {
        super(context);
        this.f1456b = context;
        this.f1455a = iVar;
    }

    /* renamed from: a */
    public static C0826h m1172a(C1192i iVar, Context context, C0827a aVar) {
        return aVar.equals(C0827a.Invisible) ? new C0882o(iVar, context) : aVar.equals(C0827a.WhiteXOnTransparentGrey) ? new C0886q(iVar, context) : new C0895x(iVar, context);
    }

    /* renamed from: a */
    public abstract void mo9078a(int i);

    public abstract C0827a getStyle();

    public abstract float getViewScale();

    public abstract void setViewScale(float f);
}
