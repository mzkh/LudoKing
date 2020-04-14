package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import androidx.core.view.MotionEventCompat;
import com.tapjoy.TJAdUnitConstants.String;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.f */
class C0630f extends View {

    /* renamed from: a */
    private int f653a;

    /* renamed from: b */
    private int f654b;

    /* renamed from: c */
    private int f655c;

    /* renamed from: d */
    private int f656d;

    /* renamed from: e */
    private int f657e;

    /* renamed from: f */
    private String f658f;

    /* renamed from: g */
    private String f659g;

    /* renamed from: h */
    private C0580c f660h;

    /* renamed from: i */
    private C0480ab f661i;

    private C0630f(Context context) {
        super(context);
    }

    C0630f(Context context, C0480ab abVar, int i, C0580c cVar) {
        super(context);
        this.f660h = cVar;
        this.f661i = abVar;
        this.f653a = i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo8536a(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        return C0746u.m914c(c, "id") == this.f653a && C0746u.m914c(c, "container_id") == this.f660h.mo8470d() && C0746u.m908b(c, "ad_session_id").equals(this.f660h.mo8463b());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8535a() {
        JSONObject c = this.f661i.mo8220c();
        this.f659g = C0746u.m908b(c, "ad_session_id");
        this.f654b = C0746u.m914c(c, "x");
        this.f655c = C0746u.m914c(c, "y");
        this.f656d = C0746u.m914c(c, "width");
        this.f657e = C0746u.m914c(c, "height");
        this.f658f = C0746u.m908b(c, "color");
        setVisibility(4);
        LayoutParams layoutParams = new LayoutParams(this.f656d, this.f657e);
        layoutParams.setMargins(this.f654b, this.f655c, 0, 0);
        layoutParams.gravity = 0;
        this.f660h.addView(this, layoutParams);
        setBackgroundColor(C0543at.m330g(this.f658f));
        String str = "ColorView.set_bounds";
        this.f660h.mo8488m().add(C0476a.m76a(str, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0630f.this.mo8536a(abVar)) {
                    C0630f.this.mo8537b(abVar);
                }
            }
        }, true));
        String str2 = "ColorView.set_visible";
        this.f660h.mo8488m().add(C0476a.m76a(str2, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0630f.this.mo8536a(abVar)) {
                    C0630f.this.mo8539d(abVar);
                }
            }
        }, true));
        String str3 = "ColorView.set_color";
        this.f660h.mo8488m().add(C0476a.m76a(str3, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0630f.this.mo8536a(abVar)) {
                    C0630f.this.mo8538c(abVar);
                }
            }
        }, true));
        this.f660h.mo8489n().add(str);
        this.f660h.mo8489n().add(str2);
        this.f660h.mo8489n().add(str3);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        C0666j a = C0476a.m77a();
        C0595d l = a.mo8578l();
        int action = motionEvent.getAction() & 255;
        if (action != 0 && action != 1 && action != 3 && action != 2 && action != 5 && action != 6) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        JSONObject a2 = C0746u.m892a();
        C0746u.m912b(a2, "view_id", this.f653a);
        C0746u.m902a(a2, "ad_session_id", this.f659g);
        String str = "container_x";
        C0746u.m912b(a2, str, this.f654b + x);
        String str2 = "container_y";
        C0746u.m912b(a2, str2, this.f655c + y);
        String str3 = "view_x";
        C0746u.m912b(a2, str3, x);
        String str4 = "view_y";
        C0746u.m912b(a2, str4, y);
        C0746u.m912b(a2, "id", this.f660h.mo8470d());
        String str5 = "AdContainer.on_touch_began";
        if (action != 0) {
            String str6 = "AdContainer.on_touch_ended";
            if (action == 1) {
                if (!this.f660h.mo8494q()) {
                    a.mo8548a((AdColonyAdView) l.mo8512e().get(this.f659g));
                }
                new C0480ab(str6, this.f660h.mo8467c(), a2).mo8217b();
            } else if (action == 2) {
                new C0480ab("AdContainer.on_touch_moved", this.f660h.mo8467c(), a2).mo8217b();
            } else if (action == 3) {
                new C0480ab("AdContainer.on_touch_cancelled", this.f660h.mo8467c(), a2).mo8217b();
            } else if (action == 5) {
                int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                C0746u.m912b(a2, str, ((int) motionEvent2.getX(action2)) + this.f654b);
                C0746u.m912b(a2, str2, ((int) motionEvent2.getY(action2)) + this.f655c);
                C0746u.m912b(a2, str3, (int) motionEvent2.getX(action2));
                C0746u.m912b(a2, str4, (int) motionEvent2.getY(action2));
                new C0480ab(str5, this.f660h.mo8467c(), a2).mo8217b();
            } else if (action == 6) {
                int action3 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                C0746u.m912b(a2, str, ((int) motionEvent2.getX(action3)) + this.f654b);
                C0746u.m912b(a2, str2, ((int) motionEvent2.getY(action3)) + this.f655c);
                C0746u.m912b(a2, str3, (int) motionEvent2.getX(action3));
                C0746u.m912b(a2, str4, (int) motionEvent2.getY(action3));
                if (!this.f660h.mo8494q()) {
                    a.mo8548a((AdColonyAdView) l.mo8512e().get(this.f659g));
                }
                new C0480ab(str6, this.f660h.mo8467c(), a2).mo8217b();
            }
        } else {
            new C0480ab(str5, this.f660h.mo8467c(), a2).mo8217b();
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8537b(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        this.f654b = C0746u.m914c(c, "x");
        this.f655c = C0746u.m914c(c, "y");
        this.f656d = C0746u.m914c(c, "width");
        this.f657e = C0746u.m914c(c, "height");
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        layoutParams.setMargins(this.f654b, this.f655c, 0, 0);
        layoutParams.width = this.f656d;
        layoutParams.height = this.f657e;
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo8538c(C0480ab abVar) {
        setBackgroundColor(C0543at.m330g(C0746u.m908b(abVar.mo8220c(), "color")));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo8539d(C0480ab abVar) {
        if (C0746u.m918d(abVar.mo8220c(), String.VISIBLE)) {
            setVisibility(0);
        } else {
            setVisibility(4);
        }
    }
}
