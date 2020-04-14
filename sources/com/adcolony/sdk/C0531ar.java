package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import androidx.core.view.GravityCompat;
import androidx.core.view.MotionEventCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.tapjoy.TJAdUnitConstants.String;
import org.json.JSONObject;

@SuppressLint({"AppCompatCustomView"})
/* renamed from: com.adcolony.sdk.ar */
class C0531ar extends Button {

    /* renamed from: A */
    private C0580c f352A;

    /* renamed from: B */
    private C0480ab f353B;

    /* renamed from: a */
    private final int f354a = 0;

    /* renamed from: b */
    private final int f355b = 1;

    /* renamed from: c */
    private final int f356c = 2;

    /* renamed from: d */
    private final int f357d = 3;

    /* renamed from: e */
    private final int f358e = 1;

    /* renamed from: f */
    private final int f359f = 2;

    /* renamed from: g */
    private final int f360g = 3;

    /* renamed from: h */
    private final int f361h = 0;

    /* renamed from: i */
    private final int f362i = 1;

    /* renamed from: j */
    private final int f363j = 2;

    /* renamed from: k */
    private final int f364k = 1;

    /* renamed from: l */
    private final int f365l = 2;

    /* renamed from: m */
    private int f366m;

    /* renamed from: n */
    private int f367n;

    /* renamed from: o */
    private int f368o;

    /* renamed from: p */
    private int f369p;

    /* renamed from: q */
    private int f370q;

    /* renamed from: r */
    private int f371r;

    /* renamed from: s */
    private int f372s;

    /* renamed from: t */
    private int f373t;

    /* renamed from: u */
    private int f374u;

    /* renamed from: v */
    private int f375v;

    /* renamed from: w */
    private String f376w;

    /* renamed from: x */
    private String f377x;

    /* renamed from: y */
    private String f378y;

    /* renamed from: z */
    private String f379z;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo8343a(boolean z, int i) {
        if (i == 0) {
            return z ? 1 : 16;
        }
        if (i != 1) {
            if (i != 2) {
                return 17;
            }
            if (z) {
                return GravityCompat.END;
            }
            return 80;
        } else if (z) {
            return GravityCompat.START;
        } else {
            return 48;
        }
    }

    private C0531ar(Context context) {
        super(context);
    }

    C0531ar(Context context, C0480ab abVar, int i, C0580c cVar) {
        super(context);
        this.f366m = i;
        this.f353B = abVar;
        this.f352A = cVar;
    }

    C0531ar(Context context, int i, C0480ab abVar, int i2, C0580c cVar) {
        super(context, null, i);
        this.f366m = i2;
        this.f353B = abVar;
        this.f352A = cVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8345a(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        this.f374u = C0746u.m914c(c, "x");
        this.f375v = C0746u.m914c(c, "y");
        setGravity(mo8343a(true, this.f374u) | mo8343a(false, this.f375v));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8346b(C0480ab abVar) {
        JSONObject a = C0746u.m892a();
        C0746u.m902a(a, ViewHierarchyConstants.TEXT_KEY, getText().toString());
        abVar.mo8216a(a).mo8217b();
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
        C0746u.m912b(a2, "view_id", this.f366m);
        C0746u.m902a(a2, "ad_session_id", this.f379z);
        String str = "container_x";
        C0746u.m912b(a2, str, this.f367n + x);
        String str2 = "container_y";
        C0746u.m912b(a2, str2, this.f368o + y);
        String str3 = "view_x";
        C0746u.m912b(a2, str3, x);
        String str4 = "view_y";
        C0746u.m912b(a2, str4, y);
        C0746u.m912b(a2, "id", this.f352A.getId());
        String str5 = "AdContainer.on_touch_began";
        if (action != 0) {
            String str6 = "AdContainer.on_touch_ended";
            int i = y;
            String str7 = "AdContainer.on_touch_cancelled";
            if (action == 1) {
                if (!this.f352A.mo8494q()) {
                    a.mo8548a((AdColonyAdView) l.mo8512e().get(this.f379z));
                }
                if (x <= 0 || x >= getWidth() || i <= 0 || i >= getHeight()) {
                    new C0480ab(str7, this.f352A.mo8467c(), a2).mo8217b();
                } else {
                    new C0480ab(str6, this.f352A.mo8467c(), a2).mo8217b();
                }
            } else if (action == 2) {
                new C0480ab("AdContainer.on_touch_moved", this.f352A.mo8467c(), a2).mo8217b();
            } else if (action == 3) {
                new C0480ab(str7, this.f352A.mo8467c(), a2).mo8217b();
            } else if (action == 5) {
                int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                C0746u.m912b(a2, str, ((int) motionEvent2.getX(action2)) + this.f367n);
                C0746u.m912b(a2, str2, ((int) motionEvent2.getY(action2)) + this.f368o);
                C0746u.m912b(a2, str3, (int) motionEvent2.getX(action2));
                C0746u.m912b(a2, str4, (int) motionEvent2.getY(action2));
                new C0480ab(str5, this.f352A.mo8467c(), a2).mo8217b();
            } else if (action == 6) {
                int action3 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                int x2 = (int) motionEvent2.getX(action3);
                int y2 = (int) motionEvent2.getY(action3);
                C0746u.m912b(a2, str, ((int) motionEvent2.getX(action3)) + this.f367n);
                C0746u.m912b(a2, str2, ((int) motionEvent2.getY(action3)) + this.f368o);
                C0746u.m912b(a2, str3, (int) motionEvent2.getX(action3));
                C0746u.m912b(a2, str4, (int) motionEvent2.getY(action3));
                if (!this.f352A.mo8494q()) {
                    a.mo8548a((AdColonyAdView) l.mo8512e().get(this.f379z));
                }
                if (x2 <= 0 || x2 >= getWidth() || y2 <= 0 || y2 >= getHeight()) {
                    new C0480ab(str7, this.f352A.mo8467c(), a2).mo8217b();
                } else {
                    new C0480ab(str6, this.f352A.mo8467c(), a2).mo8217b();
                }
            }
        } else {
            new C0480ab(str5, this.f352A.mo8467c(), a2).mo8217b();
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo8347c(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        return C0746u.m914c(c, "id") == this.f366m && C0746u.m914c(c, "container_id") == this.f352A.mo8470d() && C0746u.m908b(c, "ad_session_id").equals(this.f352A.mo8463b());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8344a() {
        int i;
        int i2;
        JSONObject c = this.f353B.mo8220c();
        this.f379z = C0746u.m908b(c, "ad_session_id");
        this.f367n = C0746u.m914c(c, "x");
        this.f368o = C0746u.m914c(c, "y");
        this.f369p = C0746u.m914c(c, "width");
        this.f370q = C0746u.m914c(c, "height");
        this.f372s = C0746u.m914c(c, "font_family");
        this.f371r = C0746u.m914c(c, "font_style");
        this.f373t = C0746u.m914c(c, ViewHierarchyConstants.TEXT_SIZE);
        this.f376w = C0746u.m908b(c, "background_color");
        this.f377x = C0746u.m908b(c, "font_color");
        this.f378y = C0746u.m908b(c, ViewHierarchyConstants.TEXT_KEY);
        this.f374u = C0746u.m914c(c, "align_x");
        this.f375v = C0746u.m914c(c, "align_y");
        C0666j a = C0476a.m77a();
        String str = "";
        if (this.f378y.equals(str)) {
            this.f378y = "Learn More";
        }
        setVisibility(4);
        LayoutParams layoutParams = C0746u.m918d(c, "wrap_content") ? new LayoutParams(-2, -2) : new LayoutParams(this.f369p, this.f370q);
        layoutParams.gravity = 0;
        setText(this.f378y);
        setTextSize((float) this.f373t);
        if (C0746u.m918d(c, "overlay")) {
            this.f367n = 0;
            this.f368o = 0;
            i2 = (int) (a.mo8579m().mo8640p() * 6.0f);
            i = (int) (a.mo8579m().mo8640p() * 6.0f);
            int p = (int) (a.mo8579m().mo8640p() * 4.0f);
            setPadding(p, p, p, p);
            layoutParams.gravity = 8388693;
        } else {
            i2 = 0;
            i = 0;
        }
        layoutParams.setMargins(this.f367n, this.f368o, i2, i);
        this.f352A.addView(this, layoutParams);
        int i3 = this.f372s;
        if (i3 == 0) {
            setTypeface(Typeface.DEFAULT);
        } else if (i3 == 1) {
            setTypeface(Typeface.SERIF);
        } else if (i3 == 2) {
            setTypeface(Typeface.SANS_SERIF);
        } else if (i3 == 3) {
            setTypeface(Typeface.MONOSPACE);
        }
        int i4 = this.f371r;
        if (i4 == 0) {
            setTypeface(getTypeface(), 0);
        } else if (i4 == 1) {
            setTypeface(getTypeface(), 1);
        } else if (i4 == 2) {
            setTypeface(getTypeface(), 2);
        } else if (i4 == 3) {
            setTypeface(getTypeface(), 3);
        }
        setGravity(mo8343a(true, this.f374u) | mo8343a(false, this.f375v));
        if (!this.f376w.equals(str)) {
            setBackgroundColor(C0543at.m330g(this.f376w));
        }
        if (!this.f377x.equals(str)) {
            setTextColor(C0543at.m330g(this.f377x));
        }
        String str2 = "TextView.set_visible";
        this.f352A.mo8488m().add(C0476a.m76a(str2, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0531ar.this.mo8347c(abVar)) {
                    C0531ar.this.mo8355k(abVar);
                }
            }
        }, true));
        String str3 = "TextView.set_bounds";
        this.f352A.mo8488m().add(C0476a.m76a(str3, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0531ar.this.mo8347c(abVar)) {
                    C0531ar.this.mo8348d(abVar);
                }
            }
        }, true));
        String str4 = "TextView.set_font_color";
        this.f352A.mo8488m().add(C0476a.m76a(str4, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0531ar.this.mo8347c(abVar)) {
                    C0531ar.this.mo8350f(abVar);
                }
            }
        }, true));
        String str5 = "TextView.set_background_color";
        this.f352A.mo8488m().add(C0476a.m76a(str5, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0531ar.this.mo8347c(abVar)) {
                    C0531ar.this.mo8349e(abVar);
                }
            }
        }, true));
        String str6 = "TextView.set_typeface";
        this.f352A.mo8488m().add(C0476a.m76a(str6, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0531ar.this.mo8347c(abVar)) {
                    C0531ar.this.mo8354j(abVar);
                }
            }
        }, true));
        String str7 = "TextView.set_font_size";
        this.f352A.mo8488m().add(C0476a.m76a(str7, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0531ar.this.mo8347c(abVar)) {
                    C0531ar.this.mo8351g(abVar);
                }
            }
        }, true));
        String str8 = "TextView.set_font_style";
        this.f352A.mo8488m().add(C0476a.m76a(str8, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0531ar.this.mo8347c(abVar)) {
                    C0531ar.this.mo8352h(abVar);
                }
            }
        }, true));
        String str9 = "TextView.get_text";
        this.f352A.mo8488m().add(C0476a.m76a(str9, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0531ar.this.mo8347c(abVar)) {
                    C0531ar.this.mo8346b(abVar);
                }
            }
        }, true));
        this.f352A.mo8488m().add(C0476a.m76a("TextView.set_text", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0531ar.this.mo8347c(abVar)) {
                    C0531ar.this.mo8353i(abVar);
                }
            }
        }, true));
        this.f352A.mo8488m().add(C0476a.m76a("TextView.align", (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0531ar.this.mo8347c(abVar)) {
                    C0531ar.this.mo8345a(abVar);
                }
            }
        }, true));
        this.f352A.mo8489n().add(str2);
        this.f352A.mo8489n().add(str3);
        this.f352A.mo8489n().add(str4);
        this.f352A.mo8489n().add(str5);
        this.f352A.mo8489n().add(str6);
        this.f352A.mo8489n().add(str7);
        this.f352A.mo8489n().add(str8);
        this.f352A.mo8489n().add(str9);
        this.f352A.mo8489n().add("TextView.set_text");
        this.f352A.mo8489n().add("TextView.align");
        new C0749a().mo8726a("TextView added to layout").mo8728a(C0748w.f1168d);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo8348d(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        this.f367n = C0746u.m914c(c, "x");
        this.f368o = C0746u.m914c(c, "y");
        this.f369p = C0746u.m914c(c, "width");
        this.f370q = C0746u.m914c(c, "height");
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        layoutParams.setMargins(this.f367n, this.f368o, 0, 0);
        layoutParams.width = this.f369p;
        layoutParams.height = this.f370q;
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo8349e(C0480ab abVar) {
        this.f376w = C0746u.m908b(abVar.mo8220c(), "background_color");
        setBackgroundColor(C0543at.m330g(this.f376w));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo8350f(C0480ab abVar) {
        this.f377x = C0746u.m908b(abVar.mo8220c(), "font_color");
        setTextColor(C0543at.m330g(this.f377x));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo8351g(C0480ab abVar) {
        this.f373t = C0746u.m914c(abVar.mo8220c(), ViewHierarchyConstants.TEXT_SIZE);
        setTextSize((float) this.f373t);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo8352h(C0480ab abVar) {
        int c = C0746u.m914c(abVar.mo8220c(), "font_style");
        this.f371r = c;
        if (c == 0) {
            setTypeface(getTypeface(), 0);
        } else if (c == 1) {
            setTypeface(getTypeface(), 1);
        } else if (c == 2) {
            setTypeface(getTypeface(), 2);
        } else if (c == 3) {
            setTypeface(getTypeface(), 3);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public void mo8353i(C0480ab abVar) {
        this.f378y = C0746u.m908b(abVar.mo8220c(), ViewHierarchyConstants.TEXT_KEY);
        setText(this.f378y);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo8354j(C0480ab abVar) {
        int c = C0746u.m914c(abVar.mo8220c(), "font_family");
        this.f372s = c;
        if (c == 0) {
            setTypeface(Typeface.DEFAULT);
        } else if (c == 1) {
            setTypeface(Typeface.SERIF);
        } else if (c == 2) {
            setTypeface(Typeface.SANS_SERIF);
        } else if (c == 3) {
            setTypeface(Typeface.MONOSPACE);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public void mo8355k(C0480ab abVar) {
        if (C0746u.m918d(abVar.mo8220c(), String.VISIBLE)) {
            setVisibility(0);
        } else {
            setVisibility(4);
        }
    }
}
