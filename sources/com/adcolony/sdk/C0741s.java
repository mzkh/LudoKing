package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import androidx.core.view.MotionEventCompat;
import com.tapjoy.TJAdUnitConstants.String;
import java.io.File;
import org.json.JSONObject;

@SuppressLint({"AppCompatCustomView"})
/* renamed from: com.adcolony.sdk.s */
class C0741s extends ImageView {

    /* renamed from: a */
    private int f1145a;

    /* renamed from: b */
    private int f1146b;

    /* renamed from: c */
    private int f1147c;

    /* renamed from: d */
    private int f1148d;

    /* renamed from: e */
    private int f1149e;

    /* renamed from: f */
    private boolean f1150f;

    /* renamed from: g */
    private boolean f1151g;

    /* renamed from: h */
    private boolean f1152h;

    /* renamed from: i */
    private String f1153i;

    /* renamed from: j */
    private String f1154j;

    /* renamed from: k */
    private C0480ab f1155k;

    /* renamed from: l */
    private C0580c f1156l;

    private C0741s(Context context) {
        super(context);
    }

    C0741s(Context context, C0480ab abVar, int i, C0580c cVar) {
        super(context);
        this.f1145a = i;
        this.f1155k = abVar;
        this.f1156l = cVar;
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
        C0746u.m912b(a2, "view_id", this.f1145a);
        C0746u.m902a(a2, "ad_session_id", this.f1154j);
        String str = "container_x";
        C0746u.m912b(a2, str, this.f1146b + x);
        String str2 = "container_y";
        C0746u.m912b(a2, str2, this.f1147c + y);
        String str3 = "view_x";
        C0746u.m912b(a2, str3, x);
        String str4 = "view_y";
        C0746u.m912b(a2, str4, y);
        C0746u.m912b(a2, "id", this.f1156l.getId());
        String str5 = "AdContainer.on_touch_began";
        if (action != 0) {
            String str6 = "AdContainer.on_touch_ended";
            int i = y;
            String str7 = "AdContainer.on_touch_cancelled";
            if (action == 1) {
                if (!this.f1156l.mo8494q()) {
                    a.mo8548a((AdColonyAdView) l.mo8512e().get(this.f1154j));
                }
                if (x <= 0 || x >= this.f1148d || i <= 0 || i >= this.f1149e) {
                    new C0480ab(str7, this.f1156l.mo8467c(), a2).mo8217b();
                } else {
                    new C0480ab(str6, this.f1156l.mo8467c(), a2).mo8217b();
                }
            } else if (action == 2) {
                new C0480ab("AdContainer.on_touch_moved", this.f1156l.mo8467c(), a2).mo8217b();
            } else if (action == 3) {
                new C0480ab(str7, this.f1156l.mo8467c(), a2).mo8217b();
            } else if (action == 5) {
                int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                C0746u.m912b(a2, str, ((int) motionEvent2.getX(action2)) + this.f1146b);
                C0746u.m912b(a2, str2, ((int) motionEvent2.getY(action2)) + this.f1147c);
                C0746u.m912b(a2, str3, (int) motionEvent2.getX(action2));
                C0746u.m912b(a2, str4, (int) motionEvent2.getY(action2));
                new C0480ab(str5, this.f1156l.mo8467c(), a2).mo8217b();
            } else if (action == 6) {
                int action3 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                int x2 = (int) motionEvent2.getX(action3);
                int y2 = (int) motionEvent2.getY(action3);
                C0746u.m912b(a2, str, ((int) motionEvent2.getX(action3)) + this.f1146b);
                C0746u.m912b(a2, str2, ((int) motionEvent2.getY(action3)) + this.f1147c);
                C0746u.m912b(a2, str3, (int) motionEvent2.getX(action3));
                C0746u.m912b(a2, str4, (int) motionEvent2.getY(action3));
                if (!this.f1156l.mo8494q()) {
                    a.mo8548a((AdColonyAdView) l.mo8512e().get(this.f1154j));
                }
                if (x2 <= 0 || x2 >= this.f1148d || y2 <= 0 || y2 >= this.f1149e) {
                    new C0480ab(str7, this.f1156l.mo8467c(), a2).mo8217b();
                } else {
                    new C0480ab(str6, this.f1156l.mo8467c(), a2).mo8217b();
                }
            }
        } else {
            new C0480ab(str5, this.f1156l.mo8467c(), a2).mo8217b();
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m871a(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        return C0746u.m914c(c, "id") == this.f1145a && C0746u.m914c(c, "container_id") == this.f1156l.mo8470d() && C0746u.m908b(c, "ad_session_id").equals(this.f1156l.mo8463b());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8714a() {
        JSONObject c = this.f1155k.mo8220c();
        this.f1154j = C0746u.m908b(c, "ad_session_id");
        this.f1146b = C0746u.m914c(c, "x");
        this.f1147c = C0746u.m914c(c, "y");
        this.f1148d = C0746u.m914c(c, "width");
        this.f1149e = C0746u.m914c(c, "height");
        this.f1153i = C0746u.m908b(c, "filepath");
        this.f1150f = C0746u.m918d(c, "dpi");
        this.f1151g = C0746u.m918d(c, "invert_y");
        this.f1152h = C0746u.m918d(c, "wrap_content");
        setImageURI(Uri.fromFile(new File(this.f1153i)));
        if (this.f1150f) {
            float p = (((float) this.f1149e) * C0476a.m77a().mo8579m().mo8640p()) / ((float) getDrawable().getIntrinsicHeight());
            this.f1149e = (int) (((float) getDrawable().getIntrinsicHeight()) * p);
            this.f1148d = (int) (((float) getDrawable().getIntrinsicWidth()) * p);
            this.f1146b -= this.f1148d;
            this.f1147c = this.f1151g ? this.f1147c + this.f1149e : this.f1147c - this.f1149e;
        }
        setVisibility(4);
        LayoutParams layoutParams = this.f1152h ? new LayoutParams(-2, -2) : new LayoutParams(this.f1148d, this.f1149e);
        layoutParams.setMargins(this.f1146b, this.f1147c, 0, 0);
        layoutParams.gravity = 0;
        this.f1156l.addView(this, layoutParams);
        String str = "ImageView.set_visible";
        this.f1156l.mo8488m().add(C0476a.m76a(str, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0741s.this.m871a(abVar)) {
                    C0741s.this.m877d(abVar);
                }
            }
        }, true));
        String str2 = "ImageView.set_bounds";
        this.f1156l.mo8488m().add(C0476a.m76a(str2, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0741s.this.m871a(abVar)) {
                    C0741s.this.m873b(abVar);
                }
            }
        }, true));
        String str3 = "ImageView.set_image";
        this.f1156l.mo8488m().add(C0476a.m76a(str3, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0741s.this.m871a(abVar)) {
                    C0741s.this.m875c(abVar);
                }
            }
        }, true));
        this.f1156l.mo8489n().add(str);
        this.f1156l.mo8489n().add(str2);
        this.f1156l.mo8489n().add(str3);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m873b(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        this.f1146b = C0746u.m914c(c, "x");
        this.f1147c = C0746u.m914c(c, "y");
        this.f1148d = C0746u.m914c(c, "width");
        this.f1149e = C0746u.m914c(c, "height");
        if (this.f1150f) {
            float p = (((float) this.f1149e) * C0476a.m77a().mo8579m().mo8640p()) / ((float) getDrawable().getIntrinsicHeight());
            this.f1149e = (int) (((float) getDrawable().getIntrinsicHeight()) * p);
            this.f1148d = (int) (((float) getDrawable().getIntrinsicWidth()) * p);
            this.f1146b -= this.f1148d;
            this.f1147c -= this.f1149e;
        }
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        layoutParams.setMargins(this.f1146b, this.f1147c, 0, 0);
        layoutParams.width = this.f1148d;
        layoutParams.height = this.f1149e;
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m875c(C0480ab abVar) {
        this.f1153i = C0746u.m908b(abVar.mo8220c(), "filepath");
        setImageURI(Uri.fromFile(new File(this.f1153i)));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m877d(C0480ab abVar) {
        if (C0746u.m918d(abVar.mo8220c(), String.VISIBLE)) {
            setVisibility(0);
        } else {
            setVisibility(4);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int[] mo8715b() {
        return new int[]{this.f1146b, this.f1147c, this.f1148d, this.f1149e};
    }
}
