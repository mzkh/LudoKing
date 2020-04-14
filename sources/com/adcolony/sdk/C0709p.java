package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import androidx.core.view.GravityCompat;
import androidx.core.view.MotionEventCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.tapjoy.TJAdUnitConstants.String;
import org.json.JSONObject;

@SuppressLint({"AppCompatCustomView"})
/* renamed from: com.adcolony.sdk.p */
class C0709p extends EditText {

    /* renamed from: A */
    private C0580c f1065A;

    /* renamed from: B */
    private C0480ab f1066B;

    /* renamed from: a */
    private final int f1067a = 0;

    /* renamed from: b */
    private final int f1068b = 1;

    /* renamed from: c */
    private final int f1069c = 2;

    /* renamed from: d */
    private final int f1070d = 3;

    /* renamed from: e */
    private final int f1071e = 1;

    /* renamed from: f */
    private final int f1072f = 2;

    /* renamed from: g */
    private final int f1073g = 3;

    /* renamed from: h */
    private final int f1074h = 0;

    /* renamed from: i */
    private final int f1075i = 1;

    /* renamed from: j */
    private final int f1076j = 2;

    /* renamed from: k */
    private final int f1077k = 1;

    /* renamed from: l */
    private final int f1078l = 2;

    /* renamed from: m */
    private int f1079m;

    /* renamed from: n */
    private int f1080n;

    /* renamed from: o */
    private int f1081o;

    /* renamed from: p */
    private int f1082p;

    /* renamed from: q */
    private int f1083q;

    /* renamed from: r */
    private int f1084r;

    /* renamed from: s */
    private int f1085s;

    /* renamed from: t */
    private int f1086t;

    /* renamed from: u */
    private int f1087u;

    /* renamed from: v */
    private int f1088v;

    /* renamed from: w */
    private String f1089w;

    /* renamed from: x */
    private String f1090x;

    /* renamed from: y */
    private String f1091y;

    /* renamed from: z */
    private String f1092z;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo8673a(boolean z, int i) {
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

    private C0709p(Context context) {
        super(context);
    }

    C0709p(Context context, C0480ab abVar, int i, C0580c cVar) {
        super(context);
        this.f1079m = i;
        this.f1066B = abVar;
        this.f1065A = cVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8675a(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        this.f1087u = C0746u.m914c(c, "x");
        this.f1088v = C0746u.m914c(c, "y");
        setGravity(mo8673a(true, this.f1087u) | mo8673a(false, this.f1088v));
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
        C0746u.m912b(a2, "view_id", this.f1079m);
        C0746u.m902a(a2, "ad_session_id", this.f1089w);
        String str = "container_x";
        C0746u.m912b(a2, str, this.f1080n + x);
        String str2 = "container_y";
        C0746u.m912b(a2, str2, this.f1081o + y);
        String str3 = "view_x";
        C0746u.m912b(a2, str3, x);
        String str4 = "view_y";
        C0746u.m912b(a2, str4, y);
        C0746u.m912b(a2, "id", this.f1065A.mo8470d());
        String str5 = "AdContainer.on_touch_began";
        if (action != 0) {
            String str6 = "AdContainer.on_touch_ended";
            if (action == 1) {
                if (!this.f1065A.mo8494q()) {
                    a.mo8548a((AdColonyAdView) l.mo8512e().get(this.f1089w));
                }
                new C0480ab(str6, this.f1065A.mo8467c(), a2).mo8217b();
            } else if (action == 2) {
                new C0480ab("AdContainer.on_touch_moved", this.f1065A.mo8467c(), a2).mo8217b();
            } else if (action == 3) {
                new C0480ab("AdContainer.on_touch_cancelled", this.f1065A.mo8467c(), a2).mo8217b();
            } else if (action == 5) {
                int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                C0746u.m912b(a2, str, ((int) motionEvent2.getX(action2)) + this.f1080n);
                C0746u.m912b(a2, str2, ((int) motionEvent2.getY(action2)) + this.f1081o);
                C0746u.m912b(a2, str3, (int) motionEvent2.getX(action2));
                C0746u.m912b(a2, str4, (int) motionEvent2.getY(action2));
                new C0480ab(str5, this.f1065A.mo8467c(), a2).mo8217b();
            } else if (action == 6) {
                int action3 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                C0746u.m912b(a2, str, ((int) motionEvent2.getX(action3)) + this.f1080n);
                C0746u.m912b(a2, str2, ((int) motionEvent2.getY(action3)) + this.f1081o);
                C0746u.m912b(a2, str3, (int) motionEvent2.getX(action3));
                C0746u.m912b(a2, str4, (int) motionEvent2.getY(action3));
                if (!this.f1065A.mo8494q()) {
                    a.mo8548a((AdColonyAdView) l.mo8512e().get(this.f1089w));
                }
                new C0480ab(str6, this.f1065A.mo8467c(), a2).mo8217b();
            }
        } else {
            new C0480ab(str5, this.f1065A.mo8467c(), a2).mo8217b();
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo8676b(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        return C0746u.m914c(c, "id") == this.f1079m && C0746u.m914c(c, "container_id") == this.f1065A.mo8470d() && C0746u.m908b(c, "ad_session_id").equals(this.f1065A.mo8463b());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8674a() {
        JSONObject c = this.f1066B.mo8220c();
        this.f1089w = C0746u.m908b(c, "ad_session_id");
        this.f1080n = C0746u.m914c(c, "x");
        this.f1081o = C0746u.m914c(c, "y");
        this.f1082p = C0746u.m914c(c, "width");
        this.f1083q = C0746u.m914c(c, "height");
        this.f1085s = C0746u.m914c(c, "font_family");
        this.f1084r = C0746u.m914c(c, "font_style");
        this.f1086t = C0746u.m914c(c, ViewHierarchyConstants.TEXT_SIZE);
        this.f1090x = C0746u.m908b(c, "background_color");
        this.f1091y = C0746u.m908b(c, "font_color");
        this.f1092z = C0746u.m908b(c, ViewHierarchyConstants.TEXT_KEY);
        this.f1087u = C0746u.m914c(c, "align_x");
        this.f1088v = C0746u.m914c(c, "align_y");
        setVisibility(4);
        LayoutParams layoutParams = new LayoutParams(this.f1082p, this.f1083q);
        layoutParams.setMargins(this.f1080n, this.f1081o, 0, 0);
        layoutParams.gravity = 0;
        this.f1065A.addView(this, layoutParams);
        int i = this.f1085s;
        if (i == 0) {
            setTypeface(Typeface.DEFAULT);
        } else if (i == 1) {
            setTypeface(Typeface.SERIF);
        } else if (i == 2) {
            setTypeface(Typeface.SANS_SERIF);
        } else if (i == 3) {
            setTypeface(Typeface.MONOSPACE);
        }
        int i2 = this.f1084r;
        if (i2 == 0) {
            setTypeface(getTypeface(), 0);
        } else if (i2 == 1) {
            setTypeface(getTypeface(), 1);
        } else if (i2 == 2) {
            setTypeface(getTypeface(), 2);
        } else if (i2 == 3) {
            setTypeface(getTypeface(), 3);
        }
        setText(this.f1092z);
        setTextSize((float) this.f1086t);
        setGravity(mo8673a(true, this.f1087u) | mo8673a(false, this.f1088v));
        String str = "";
        if (!this.f1090x.equals(str)) {
            setBackgroundColor(C0543at.m330g(this.f1090x));
        }
        if (!this.f1091y.equals(str)) {
            setTextColor(C0543at.m330g(this.f1091y));
        }
        String str2 = "TextView.set_visible";
        this.f1065A.mo8488m().add(C0476a.m76a(str2, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0709p.this.mo8676b(abVar)) {
                    C0709p.this.mo8685k(abVar);
                }
            }
        }, true));
        String str3 = "TextView.set_bounds";
        this.f1065A.mo8488m().add(C0476a.m76a(str3, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0709p.this.mo8676b(abVar)) {
                    C0709p.this.mo8678d(abVar);
                }
            }
        }, true));
        String str4 = "TextView.set_font_color";
        this.f1065A.mo8488m().add(C0476a.m76a(str4, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0709p.this.mo8676b(abVar)) {
                    C0709p.this.mo8680f(abVar);
                }
            }
        }, true));
        String str5 = "TextView.set_background_color";
        this.f1065A.mo8488m().add(C0476a.m76a(str5, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0709p.this.mo8676b(abVar)) {
                    C0709p.this.mo8679e(abVar);
                }
            }
        }, true));
        String str6 = "TextView.set_typeface";
        this.f1065A.mo8488m().add(C0476a.m76a(str6, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0709p.this.mo8676b(abVar)) {
                    C0709p.this.mo8684j(abVar);
                }
            }
        }, true));
        String str7 = "TextView.set_font_size";
        this.f1065A.mo8488m().add(C0476a.m76a(str7, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0709p.this.mo8676b(abVar)) {
                    C0709p.this.mo8681g(abVar);
                }
            }
        }, true));
        String str8 = "TextView.set_font_style";
        this.f1065A.mo8488m().add(C0476a.m76a(str8, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0709p.this.mo8676b(abVar)) {
                    C0709p.this.mo8682h(abVar);
                }
            }
        }, true));
        String str9 = "TextView.get_text";
        this.f1065A.mo8488m().add(C0476a.m76a(str9, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0709p.this.mo8676b(abVar)) {
                    C0709p.this.mo8677c(abVar);
                }
            }
        }, true));
        String str10 = "TextView.set_text";
        this.f1065A.mo8488m().add(C0476a.m76a(str10, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0709p.this.mo8676b(abVar)) {
                    C0709p.this.mo8683i(abVar);
                }
            }
        }, true));
        String str11 = "TextView.align";
        this.f1065A.mo8488m().add(C0476a.m76a(str11, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0709p.this.mo8676b(abVar)) {
                    C0709p.this.mo8675a(abVar);
                }
            }
        }, true));
        this.f1065A.mo8489n().add(str2);
        this.f1065A.mo8489n().add(str3);
        this.f1065A.mo8489n().add(str4);
        this.f1065A.mo8489n().add(str5);
        this.f1065A.mo8489n().add(str6);
        this.f1065A.mo8489n().add(str7);
        this.f1065A.mo8489n().add(str8);
        this.f1065A.mo8489n().add(str9);
        this.f1065A.mo8489n().add(str10);
        this.f1065A.mo8489n().add(str11);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo8677c(C0480ab abVar) {
        JSONObject a = C0746u.m892a();
        C0746u.m902a(a, ViewHierarchyConstants.TEXT_KEY, getText().toString());
        abVar.mo8216a(a).mo8217b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo8678d(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        this.f1080n = C0746u.m914c(c, "x");
        this.f1081o = C0746u.m914c(c, "y");
        this.f1082p = C0746u.m914c(c, "width");
        this.f1083q = C0746u.m914c(c, "height");
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        layoutParams.setMargins(this.f1080n, this.f1081o, 0, 0);
        layoutParams.width = this.f1082p;
        layoutParams.height = this.f1083q;
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo8679e(C0480ab abVar) {
        this.f1090x = C0746u.m908b(abVar.mo8220c(), "background_color");
        setBackgroundColor(C0543at.m330g(this.f1090x));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo8680f(C0480ab abVar) {
        this.f1091y = C0746u.m908b(abVar.mo8220c(), "font_color");
        setTextColor(C0543at.m330g(this.f1091y));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo8681g(C0480ab abVar) {
        this.f1086t = C0746u.m914c(abVar.mo8220c(), ViewHierarchyConstants.TEXT_SIZE);
        setTextSize((float) this.f1086t);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo8682h(C0480ab abVar) {
        int c = C0746u.m914c(abVar.mo8220c(), "font_style");
        this.f1084r = c;
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
    public void mo8683i(C0480ab abVar) {
        this.f1092z = C0746u.m908b(abVar.mo8220c(), ViewHierarchyConstants.TEXT_KEY);
        setText(this.f1092z);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo8684j(C0480ab abVar) {
        int c = C0746u.m914c(abVar.mo8220c(), "font_family");
        this.f1085s = c;
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
    public void mo8685k(C0480ab abVar) {
        if (C0746u.m918d(abVar.mo8220c(), String.VISIBLE)) {
            setVisibility(0);
        } else {
            setVisibility(4);
        }
    }
}
