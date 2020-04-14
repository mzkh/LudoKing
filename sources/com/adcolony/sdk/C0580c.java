package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.annotation.FloatRange;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.iab.omid.library.adcolony.adsession.AdSession;
import com.tapjoy.TJAdUnitConstants.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.c */
class C0580c extends FrameLayout {

    /* renamed from: A */
    private boolean f544A;

    /* renamed from: B */
    private AdSession f545B;

    /* renamed from: a */
    boolean f546a;

    /* renamed from: b */
    boolean f547b;

    /* renamed from: c */
    Context f548c;

    /* renamed from: d */
    VideoView f549d;

    /* renamed from: e */
    private HashMap<Integer, C0546au> f550e;

    /* renamed from: f */
    private HashMap<Integer, C0531ar> f551f;

    /* renamed from: g */
    private HashMap<Integer, C0557av> f552g;

    /* renamed from: h */
    private HashMap<Integer, C0630f> f553h;

    /* renamed from: i */
    private HashMap<Integer, C0709p> f554i;

    /* renamed from: j */
    private HashMap<Integer, C0741s> f555j;

    /* renamed from: k */
    private HashMap<Integer, Boolean> f556k;

    /* renamed from: l */
    private HashMap<Integer, View> f557l;

    /* renamed from: m */
    private int f558m;

    /* renamed from: n */
    private int f559n;

    /* renamed from: o */
    private int f560o;

    /* renamed from: p */
    private int f561p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public String f562q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public float f563r = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public double f564s = 0.0d;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public long f565t = 0;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f566u = 0;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f567v = 0;

    /* renamed from: w */
    private ArrayList<C0484ad> f568w;

    /* renamed from: x */
    private ArrayList<String> f569x;

    /* renamed from: y */
    private boolean f570y;

    /* renamed from: z */
    private boolean f571z;

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    private C0580c(Context context) {
        super(context);
    }

    C0580c(Context context, String str) {
        super(context);
        this.f548c = context;
        this.f562q = str;
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo8462a(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        return C0746u.m914c(c, "container_id") == this.f560o && C0746u.m908b(c, "ad_session_id").equals(this.f562q);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8465b(C0480ab abVar) {
        int i;
        this.f550e = new HashMap<>();
        this.f551f = new HashMap<>();
        this.f552g = new HashMap<>();
        this.f553h = new HashMap<>();
        this.f554i = new HashMap<>();
        this.f555j = new HashMap<>();
        this.f556k = new HashMap<>();
        this.f557l = new HashMap<>();
        this.f568w = new ArrayList<>();
        this.f569x = new ArrayList<>();
        JSONObject c = abVar.mo8220c();
        if (C0746u.m918d(c, String.TRANSPARENT)) {
            setBackgroundColor(0);
        }
        this.f560o = C0746u.m914c(c, "id");
        this.f558m = C0746u.m914c(c, "width");
        this.f559n = C0746u.m914c(c, "height");
        this.f561p = C0746u.m914c(c, "module_id");
        this.f547b = C0746u.m918d(c, "viewability_enabled");
        this.f570y = this.f560o == 1;
        C0666j a = C0476a.m77a();
        if (this.f558m == 0 && this.f559n == 0) {
            this.f558m = a.mo8579m().mo8641q();
            if (a.mo8567d().getMultiWindowEnabled()) {
                i = a.mo8579m().mo8642r() - C0543at.m321c(C0476a.m85c());
            } else {
                i = a.mo8579m().mo8642r();
            }
            this.f559n = i;
        } else {
            setLayoutParams(new LayoutParams(this.f558m, this.f559n));
        }
        String str = "VideoView.create";
        this.f568w.add(C0476a.m76a(str, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0580c.this.mo8462a(abVar)) {
                    C0580c cVar = C0580c.this;
                    cVar.mo8458a((View) cVar.mo8476g(abVar));
                }
            }
        }, true));
        String str2 = "VideoView.destroy";
        this.f568w.add(C0476a.m76a(str2, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0580c.this.mo8462a(abVar)) {
                    C0580c.this.mo8479h(abVar);
                }
            }
        }, true));
        String str3 = "WebView.create";
        this.f568w.add(C0476a.m76a(str3, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(final C0480ab abVar) {
                if (C0580c.this.mo8462a(abVar)) {
                    C0543at.m309a((Runnable) new Runnable() {
                        public void run() {
                            C0580c.this.mo8458a((View) C0580c.this.mo8480i(abVar));
                        }
                    });
                }
            }
        }, true));
        String str4 = "WebView.destroy";
        this.f568w.add(C0476a.m76a(str4, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(final C0480ab abVar) {
                if (C0580c.this.mo8462a(abVar)) {
                    C0543at.m309a((Runnable) new Runnable() {
                        public void run() {
                            C0580c.this.mo8483j(abVar);
                        }
                    });
                }
            }
        }, true));
        String str5 = "TextView.create";
        this.f568w.add(C0476a.m76a(str5, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0580c.this.mo8462a(abVar)) {
                    C0580c cVar = C0580c.this;
                    cVar.mo8458a(cVar.mo8484k(abVar));
                }
            }
        }, true));
        String str6 = "TextView.destroy";
        this.f568w.add(C0476a.m76a(str6, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0580c.this.mo8462a(abVar)) {
                    C0580c.this.mo8487l(abVar);
                }
            }
        }, true));
        String str7 = "ImageView.create";
        this.f568w.add(C0476a.m76a(str7, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0580c.this.mo8462a(abVar)) {
                    C0580c cVar = C0580c.this;
                    cVar.mo8458a((View) cVar.mo8472e(abVar));
                }
            }
        }, true));
        String str8 = "ImageView.destroy";
        this.f568w.add(C0476a.m76a(str8, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0580c.this.mo8462a(abVar)) {
                    C0580c.this.mo8475f(abVar);
                }
            }
        }, true));
        String str9 = "ColorView.create";
        this.f568w.add(C0476a.m76a(str9, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0580c.this.mo8462a(abVar)) {
                    C0580c cVar = C0580c.this;
                    cVar.mo8458a((View) cVar.mo8468c(abVar));
                }
            }
        }, true));
        String str10 = "ColorView.destroy";
        this.f568w.add(C0476a.m76a(str10, (C0484ad) new C0484ad() {
            /* renamed from: a */
            public void mo8235a(C0480ab abVar) {
                if (C0580c.this.mo8462a(abVar)) {
                    C0580c.this.mo8471d(abVar);
                }
            }
        }, true));
        this.f569x.add(str);
        this.f569x.add(str2);
        this.f569x.add(str3);
        this.f569x.add(str4);
        this.f569x.add(str5);
        this.f569x.add(str6);
        this.f569x.add(str7);
        this.f569x.add(str8);
        this.f569x.add(str9);
        this.f569x.add(str10);
        this.f549d = new VideoView(this.f548c);
        this.f549d.setVisibility(8);
        addView(this.f549d);
        setClipToPadding(false);
        if (this.f547b) {
            m501d(C0746u.m918d(abVar.mo8220c(), "advanced_viewability"));
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent.getAction() & 255;
        if (action != 0 && action != 1 && action != 3 && action != 2 && action != 5 && action != 6) {
            return false;
        }
        C0666j a = C0476a.m77a();
        C0595d l = a.mo8578l();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        JSONObject a2 = C0746u.m892a();
        C0746u.m912b(a2, "view_id", -1);
        C0746u.m902a(a2, "ad_session_id", this.f562q);
        String str = "container_x";
        C0746u.m912b(a2, str, x);
        String str2 = "container_y";
        C0746u.m912b(a2, str2, y);
        String str3 = "view_x";
        C0746u.m912b(a2, str3, x);
        String str4 = "view_y";
        C0746u.m912b(a2, str4, y);
        C0746u.m912b(a2, "id", this.f560o);
        String str5 = "AdContainer.on_touch_began";
        if (action != 0) {
            String str6 = "AdContainer.on_touch_ended";
            if (action == 1) {
                if (!this.f570y) {
                    a.mo8548a((AdColonyAdView) l.mo8512e().get(this.f562q));
                }
                new C0480ab(str6, this.f561p, a2).mo8217b();
            } else if (action == 2) {
                new C0480ab("AdContainer.on_touch_moved", this.f561p, a2).mo8217b();
            } else if (action == 3) {
                new C0480ab("AdContainer.on_touch_cancelled", this.f561p, a2).mo8217b();
            } else if (action == 5) {
                int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                C0746u.m912b(a2, str, (int) motionEvent2.getX(action2));
                C0746u.m912b(a2, str2, (int) motionEvent2.getY(action2));
                C0746u.m912b(a2, str3, (int) motionEvent2.getX(action2));
                C0746u.m912b(a2, str4, (int) motionEvent2.getY(action2));
                new C0480ab(str5, this.f561p, a2).mo8217b();
            } else if (action == 6) {
                int action3 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                C0746u.m912b(a2, str, (int) motionEvent2.getX(action3));
                C0746u.m912b(a2, str2, (int) motionEvent2.getY(action3));
                C0746u.m912b(a2, str3, (int) motionEvent2.getX(action3));
                C0746u.m912b(a2, str4, (int) motionEvent2.getY(action3));
                C0746u.m912b(a2, "x", (int) motionEvent2.getX(action3));
                C0746u.m912b(a2, "y", (int) motionEvent2.getY(action3));
                if (!this.f570y) {
                    a.mo8548a((AdColonyAdView) l.mo8512e().get(this.f562q));
                }
                new C0480ab(str6, this.f561p, a2).mo8217b();
            }
        } else {
            new C0480ab(str5, this.f561p, a2).mo8217b();
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C0630f mo8468c(C0480ab abVar) {
        int c = C0746u.m914c(abVar.mo8220c(), "id");
        C0630f fVar = new C0630f(this.f548c, abVar, c, this);
        fVar.mo8535a();
        this.f553h.put(Integer.valueOf(c), fVar);
        this.f557l.put(Integer.valueOf(c), fVar);
        return fVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo8471d(C0480ab abVar) {
        int c = C0746u.m914c(abVar.mo8220c(), "id");
        C0630f fVar = (C0630f) this.f553h.remove(Integer.valueOf(c));
        if (((View) this.f557l.remove(Integer.valueOf(c))) == null || fVar == null) {
            C0595d l = C0476a.m77a().mo8578l();
            String d = abVar.mo8221d();
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(c);
            l.mo8505a(d, sb.toString());
            return false;
        }
        removeView(fVar);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public C0741s mo8472e(C0480ab abVar) {
        int c = C0746u.m914c(abVar.mo8220c(), "id");
        C0741s sVar = new C0741s(this.f548c, abVar, c, this);
        sVar.mo8714a();
        this.f555j.put(Integer.valueOf(c), sVar);
        this.f557l.put(Integer.valueOf(c), sVar);
        return sVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public boolean mo8475f(C0480ab abVar) {
        int c = C0746u.m914c(abVar.mo8220c(), "id");
        C0741s sVar = (C0741s) this.f555j.remove(Integer.valueOf(c));
        if (((View) this.f557l.remove(Integer.valueOf(c))) == null || sVar == null) {
            C0595d l = C0476a.m77a().mo8578l();
            String d = abVar.mo8221d();
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(c);
            l.mo8505a(d, sb.toString());
            return false;
        }
        removeView(sVar);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public C0546au mo8476g(C0480ab abVar) {
        int c = C0746u.m914c(abVar.mo8220c(), "id");
        C0546au auVar = new C0546au(this.f548c, abVar, c, this);
        auVar.mo8378b();
        this.f550e.put(Integer.valueOf(c), auVar);
        this.f557l.put(Integer.valueOf(c), auVar);
        return auVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public boolean mo8479h(C0480ab abVar) {
        int c = C0746u.m914c(abVar.mo8220c(), "id");
        C0546au auVar = (C0546au) this.f550e.remove(Integer.valueOf(c));
        if (((View) this.f557l.remove(Integer.valueOf(c))) == null || auVar == null) {
            C0595d l = C0476a.m77a().mo8578l();
            String d = abVar.mo8221d();
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(c);
            l.mo8505a(d, sb.toString());
            return false;
        }
        if (auVar.mo8384h()) {
            auVar.mo8380d();
        }
        auVar.mo8377a();
        removeView(auVar);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public C0557av mo8480i(C0480ab abVar) {
        C0557av avVar;
        JSONObject c = abVar.mo8220c();
        int c2 = C0746u.m914c(c, "id");
        boolean d = C0746u.m918d(c, "is_module");
        C0666j a = C0476a.m77a();
        String str = "module_id";
        if (d) {
            avVar = (C0557av) a.mo8591y().get(Integer.valueOf(C0746u.m914c(c, str)));
            if (avVar == null) {
                new C0749a().mo8726a("Module WebView created with invalid id").mo8728a(C0748w.f1171g);
                return null;
            }
            avVar.mo8402a(abVar, c2, this);
        } else {
            try {
                avVar = new C0557av(this.f548c, abVar, c2, a.mo8583q().mo8231d(), this);
            } catch (RuntimeException e) {
                C0749a aVar = new C0749a();
                StringBuilder sb = new StringBuilder();
                sb.append(e.toString());
                sb.append(": during WebView initialization.");
                aVar.mo8726a(sb.toString()).mo8726a(" Disabling AdColony.").mo8728a(C0748w.f1171g);
                AdColony.disable();
                return null;
            }
        }
        this.f552g.put(Integer.valueOf(c2), avVar);
        this.f557l.put(Integer.valueOf(c2), avVar);
        JSONObject a2 = C0746u.m892a();
        C0746u.m912b(a2, str, avVar.mo8236a());
        C0746u.m912b(a2, "mraid_module_id", avVar.mo8238b());
        abVar.mo8216a(a2).mo8217b();
        return avVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public boolean mo8483j(C0480ab abVar) {
        int c = C0746u.m914c(abVar.mo8220c(), "id");
        C0666j a = C0476a.m77a();
        View view = (View) this.f557l.remove(Integer.valueOf(c));
        C0557av avVar = (C0557av) this.f552g.remove(Integer.valueOf(c));
        if (avVar == null || view == null) {
            C0595d l = a.mo8578l();
            String d = abVar.mo8221d();
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(c);
            l.mo8505a(d, sb.toString());
            return false;
        }
        a.mo8583q().mo8222a(avVar.mo8236a());
        removeView(avVar);
        return true;
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"InlinedApi"})
    /* renamed from: k */
    public View mo8484k(C0480ab abVar) {
        JSONObject c = abVar.mo8220c();
        int c2 = C0746u.m914c(c, "id");
        if (C0746u.m918d(c, "editable")) {
            C0709p pVar = new C0709p(this.f548c, abVar, c2, this);
            pVar.mo8674a();
            this.f554i.put(Integer.valueOf(c2), pVar);
            this.f557l.put(Integer.valueOf(c2), pVar);
            this.f556k.put(Integer.valueOf(c2), Boolean.valueOf(true));
            return pVar;
        } else if (!C0746u.m918d(c, "button")) {
            C0531ar arVar = new C0531ar(this.f548c, abVar, c2, this);
            arVar.mo8344a();
            this.f551f.put(Integer.valueOf(c2), arVar);
            this.f557l.put(Integer.valueOf(c2), arVar);
            this.f556k.put(Integer.valueOf(c2), Boolean.valueOf(false));
            return arVar;
        } else {
            C0531ar arVar2 = new C0531ar(this.f548c, 16974145, abVar, c2, this);
            arVar2.mo8344a();
            this.f551f.put(Integer.valueOf(c2), arVar2);
            this.f557l.put(Integer.valueOf(c2), arVar2);
            this.f556k.put(Integer.valueOf(c2), Boolean.valueOf(false));
            return arVar2;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public boolean mo8487l(C0480ab abVar) {
        TextView textView;
        int c = C0746u.m914c(abVar.mo8220c(), "id");
        View view = (View) this.f557l.remove(Integer.valueOf(c));
        if (((Boolean) this.f556k.remove(Integer.valueOf(this.f560o))).booleanValue()) {
            textView = (TextView) this.f554i.remove(Integer.valueOf(c));
        } else {
            textView = (TextView) this.f551f.remove(Integer.valueOf(c));
        }
        if (view == null || textView == null) {
            C0595d l = C0476a.m77a().mo8578l();
            String d = abVar.mo8221d();
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(c);
            l.mo8505a(d, sb.toString());
            return false;
        }
        removeView(textView);
        return true;
    }

    /* renamed from: d */
    private void m501d(final boolean z) {
        final C05863 r0 = new Runnable() {
            public void run() {
                C0557av avVar;
                double d;
                if (C0580c.this.f565t == 0) {
                    C0580c.this.f565t = System.currentTimeMillis();
                }
                View view = (View) C0580c.this.getParent();
                AdColonyAdView adColonyAdView = (AdColonyAdView) C0476a.m77a().mo8578l().mo8512e().get(C0580c.this.f562q);
                if (adColonyAdView == null) {
                    avVar = null;
                } else {
                    avVar = adColonyAdView.getWebView();
                }
                C0557av avVar2 = avVar;
                Context c = C0476a.m85c();
                boolean z = true;
                float a = C0575ax.m472a(view, c, true, z, true, adColonyAdView != null);
                if (c == null) {
                    d = 0.0d;
                } else {
                    d = C0543at.m314b(C0543at.m299a(c));
                }
                int a2 = C0543at.m297a((View) avVar2);
                int b = C0543at.m315b((View) avVar2);
                if (a2 == C0580c.this.f566u && b == C0580c.this.f567v) {
                    z = false;
                }
                if (z) {
                    C0580c.this.f566u = a2;
                    C0580c.this.f567v = b;
                    C0580c.this.m494a(a2, b, avVar2);
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (C0580c.this.f565t + 200 < currentTimeMillis) {
                    C0580c.this.f565t = currentTimeMillis;
                    if (!(C0580c.this.f563r == a && C0580c.this.f564s == d && !z)) {
                        C0580c.this.m493a(a, d);
                    }
                    C0580c.this.f563r = a;
                    C0580c.this.f564s = d;
                }
            }
        };
        new Thread(new Runnable() {
            public void run() {
                while (!C0580c.this.f546a) {
                    C0543at.m309a(r0);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m494a(int i, int i2, C0557av avVar) {
        float p = C0476a.m77a().mo8579m().mo8640p();
        if (avVar != null) {
            JSONObject a = C0746u.m892a();
            C0746u.m912b(a, "app_orientation", C0543at.m335j(C0543at.m332h()));
            C0746u.m912b(a, "width", (int) (((float) avVar.mo8424s()) / p));
            C0746u.m912b(a, "height", (int) (((float) avVar.mo8425t()) / p));
            C0746u.m912b(a, "x", i);
            C0746u.m912b(a, "y", i2);
            C0746u.m902a(a, "ad_session_id", this.f562q);
            new C0480ab("MRAID.on_size_change", this.f561p, a).mo8217b();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m493a(@FloatRange(from = 0.0d, mo650to = 100.0d) float f, @FloatRange(from = 0.0d, mo650to = 1.0d) double d) {
        JSONObject a = C0746u.m892a();
        C0746u.m912b(a, "id", this.f560o);
        C0746u.m902a(a, "ad_session_id", this.f562q);
        C0746u.m900a(a, "exposure", (double) f);
        C0746u.m900a(a, "volume", d);
        new C0480ab("AdContainer.on_exposure_change", this.f561p, a).mo8217b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8456a() {
        JSONObject a = C0746u.m892a();
        C0746u.m902a(a, "id", this.f562q);
        new C0480ab("AdSession.on_error", this.f561p, a).mo8217b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo8463b() {
        return this.f562q;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo8467c() {
        return this.f561p;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public int mo8470d() {
        return this.f560o;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public HashMap<Integer, C0546au> mo8473e() {
        return this.f550e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public HashMap<Integer, C0531ar> mo8474f() {
        return this.f551f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public HashMap<Integer, C0557av> mo8477g() {
        return this.f552g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public HashMap<Integer, C0630f> mo8478h() {
        return this.f553h;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public HashMap<Integer, C0709p> mo8481i() {
        return this.f554i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public HashMap<Integer, C0741s> mo8482j() {
        return this.f555j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public HashMap<Integer, Boolean> mo8485k() {
        return this.f556k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public HashMap<Integer, View> mo8486l() {
        return this.f557l;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public ArrayList<C0484ad> mo8488m() {
        return this.f568w;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public ArrayList<String> mo8489n() {
        return this.f569x;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public int mo8490o() {
        return this.f559n;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8457a(int i) {
        this.f559n = i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: p */
    public int mo8493p() {
        return this.f558m;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8464b(int i) {
        this.f558m = i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public boolean mo8494q() {
        return this.f570y;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8461a(boolean z) {
        this.f570y = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public boolean mo8495r() {
        return this.f544A;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8466b(boolean z) {
        this.f544A = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: s */
    public boolean mo8496s() {
        return this.f571z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo8469c(boolean z) {
        this.f571z = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8459a(AdSession adSession) {
        this.f545B = adSession;
        mo8460a((Map) this.f557l);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8460a(Map map) {
        if (this.f545B != null && map != null) {
            for (Entry value : map.entrySet()) {
                this.f545B.addFriendlyObstruction((View) value.getValue());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8458a(View view) {
        AdSession adSession = this.f545B;
        if (adSession != null && view != null) {
            adSession.addFriendlyObstruction(view);
        }
    }
}
