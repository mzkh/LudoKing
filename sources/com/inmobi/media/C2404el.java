package com.inmobi.media;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils.TruncateAt;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.inmobi.ads.rendering.InMobiAdActivity;
import com.inmobi.media.C2218bf.C2219a;
import com.inmobi.media.C2226bk.C2227a;
import com.inmobi.media.C2228bl.C2229a;
import com.inmobi.media.C2359dz.C2360a;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

/* renamed from: com.inmobi.media.el */
/* compiled from: NativeViewFactory */
public class C2404el {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f5129a = "el";
    @NonNull

    /* renamed from: c */
    private static final Map<Class, Integer> f5130c;
    @Nullable

    /* renamed from: e */
    private static volatile WeakReference<C2404el> f5131e = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static WeakReference<Context> f5132f = null;

    /* renamed from: g */
    private static int f5133g = 1;

    /* renamed from: h */
    private static int f5134h = 1;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f5135b;
    @NonNull

    /* renamed from: d */
    private Map<Integer, C2420d> f5136d = new HashMap();

    /* renamed from: com.inmobi.media.el$a */
    /* compiled from: NativeViewFactory */
    static final class C2417a implements Runnable {

        /* renamed from: a */
        private WeakReference<Context> f5151a;

        /* renamed from: b */
        private WeakReference<ImageView> f5152b;

        C2417a(Context context, ImageView imageView) {
            this.f5151a = new WeakReference<>(context);
            this.f5152b = new WeakReference<>(imageView);
        }

        public final void run() {
            Context context = (Context) this.f5151a.get();
            ImageView imageView = (ImageView) this.f5152b.get();
            if (context != null && imageView != null) {
                C2404el.m5026b(context, imageView);
            }
        }
    }

    @SuppressLint({"AppCompatCustomView"})
    /* renamed from: com.inmobi.media.el$b */
    /* compiled from: NativeViewFactory */
    static final class C2418b extends TextView {
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public C2418b(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public final void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            int lineHeight = getLineHeight() > 0 ? i2 / getLineHeight() : 0;
            if (lineHeight > 0) {
                setSingleLine(false);
                setLines(lineHeight);
            }
            if (lineHeight == 1) {
                setSingleLine();
            }
        }
    }

    /* renamed from: com.inmobi.media.el$c */
    /* compiled from: NativeViewFactory */
    static class C2419c implements InvocationHandler {

        /* renamed from: a */
        private WeakReference<Context> f5153a;

        /* renamed from: b */
        private WeakReference<ImageView> f5154b;

        /* renamed from: c */
        private C2214bc f5155c;

        C2419c(Context context, ImageView imageView, C2214bc bcVar) {
            this.f5153a = new WeakReference<>(context);
            this.f5154b = new WeakReference<>(imageView);
            this.f5155c = bcVar;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            C2404el.f5129a;
            if (method != null) {
                if ("onError".equalsIgnoreCase(method.getName())) {
                    C2404el.m5012a((Context) this.f5153a.get(), (ImageView) this.f5154b.get(), this.f5155c);
                }
            }
            return null;
        }
    }

    /* renamed from: com.inmobi.media.el$d */
    /* compiled from: NativeViewFactory */
    abstract class C2420d {

        /* renamed from: a */
        private int f5156a = 0;
        @NonNull

        /* renamed from: b */
        LinkedList<View> f5157b = new LinkedList<>();

        /* renamed from: d */
        private int f5159d = 0;

        /* access modifiers changed from: protected */
        @Nullable
        /* renamed from: a */
        public abstract View mo28324a(@NonNull Context context);

        public C2420d() {
        }

        /* renamed from: a */
        public boolean mo28326a(@NonNull View view) {
            C2404el.m5027b(view);
            view.setOnClickListener(null);
            this.f5157b.addLast(view);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            C2404el.this.f5135b = C2404el.this.f5135b + 1;
            return true;
        }

        /* renamed from: a */
        public final View mo28332a(@NonNull Context context, C2214bc bcVar, C2426eq eqVar) {
            View view;
            C2404el.f5132f = new WeakReference(context);
            if (this.f5157b.isEmpty()) {
                this.f5156a++;
                view = mo28324a(context);
            } else {
                this.f5159d++;
                view = (View) this.f5157b.removeFirst();
                C2404el.this.f5135b = C2404el.this.f5135b - 1;
            }
            if (view != null) {
                mo28325a(view, bcVar, eqVar);
            }
            return view;
        }

        /* renamed from: a */
        public final void mo28333a() {
            if (this.f5157b.size() > 0) {
                this.f5157b.removeFirst();
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Size:");
            sb.append(this.f5157b.size());
            sb.append(" Miss Count:");
            sb.append(this.f5156a);
            sb.append(" Hit Count:");
            sb.append(this.f5159d);
            return sb.toString();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo28325a(@NonNull View view, @NonNull C2214bc bcVar, @NonNull C2426eq eqVar) {
            view.setVisibility(bcVar.f4544x);
            view.setOnClickListener(null);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f5130c = hashMap;
        hashMap.put(C2382ee.class, Integer.valueOf(0));
        f5130c.put(C2423eo.class, Integer.valueOf(1));
        f5130c.put(C2422en.class, Integer.valueOf(2));
        f5130c.put(C2359dz.class, Integer.valueOf(3));
        f5130c.put(ImageView.class, Integer.valueOf(6));
        f5130c.put(C2403ek.class, Integer.valueOf(7));
        f5130c.put(C2418b.class, Integer.valueOf(4));
        f5130c.put(Button.class, Integer.valueOf(5));
        f5130c.put(C2231bn.class, Integer.valueOf(8));
        f5130c.put(C2600j.class, Integer.valueOf(9));
        f5130c.put(C2358dy.class, Integer.valueOf(10));
    }

    /* renamed from: a */
    static void m5010a(int i) {
        f5133g = i;
    }

    /* renamed from: b */
    static void m5025b(int i) {
        f5134h = i;
    }

    /* renamed from: c */
    static int m5028c(int i) {
        Context context = (Context) f5132f.get();
        if (context != null && (context instanceof InMobiAdActivity)) {
            return i;
        }
        int i2 = f5133g;
        if (i2 == 0) {
            return i;
        }
        double d = (double) i;
        double d2 = (double) i2;
        Double.isNaN(d2);
        double d3 = d2 * 1.0d;
        double d4 = (double) f5134h;
        Double.isNaN(d4);
        double d5 = d3 / d4;
        Double.isNaN(d);
        return (int) (d * d5);
    }

    @SuppressLint({"UseSparseArrays"})
    private C2404el(Context context) {
        f5132f = new WeakReference<>(context);
        this.f5136d.put(Integer.valueOf(0), new C2420d() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final View mo28324a(@NonNull Context context) {
                return new C2382ee(context.getApplicationContext());
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final void mo28325a(@NonNull View view, @NonNull C2214bc bcVar, @NonNull C2426eq eqVar) {
                super.mo28325a(view, bcVar, eqVar);
                C2404el.m5013a(view, bcVar.f4523c);
            }
        });
        this.f5136d.put(Integer.valueOf(3), new C2420d() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final View mo28324a(@NonNull Context context) {
                return new C2359dz(context.getApplicationContext());
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final void mo28325a(@NonNull View view, @NonNull C2214bc bcVar, @NonNull C2426eq eqVar) {
                super.mo28325a(view, bcVar, eqVar);
                C2404el.m5013a(view, bcVar.f4523c);
            }
        });
        this.f5136d.put(Integer.valueOf(1), new C2420d() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final View mo28324a(@NonNull Context context) {
                return new C2423eo(context.getApplicationContext());
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final void mo28325a(@NonNull View view, @NonNull C2214bc bcVar, @NonNull C2426eq eqVar) {
                super.mo28325a(view, bcVar, eqVar);
                C2404el.m5013a(view, bcVar.f4523c);
            }

            /* renamed from: a */
            public final boolean mo28326a(@NonNull View view) {
                ((C2423eo) view).f5163a = null;
                return super.mo28326a(view);
            }
        });
        this.f5136d.put(Integer.valueOf(2), new C2420d() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final View mo28324a(@NonNull Context context) {
                return new C2422en(context.getApplicationContext());
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final void mo28325a(@NonNull View view, @NonNull C2214bc bcVar, @NonNull C2426eq eqVar) {
                super.mo28325a(view, bcVar, eqVar);
                C2404el.m5013a(view, bcVar.f4523c);
            }
        });
        this.f5136d.put(Integer.valueOf(6), new C2420d() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final View mo28324a(@NonNull Context context) {
                return new ImageView(context.getApplicationContext());
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final void mo28325a(@NonNull View view, @NonNull C2214bc bcVar, @NonNull C2426eq eqVar) {
                super.mo28325a(view, bcVar, eqVar);
                C2404el.m5015a((ImageView) view, bcVar);
            }

            /* renamed from: a */
            public final boolean mo28326a(@NonNull View view) {
                if (!(view instanceof ImageView)) {
                    return false;
                }
                ((ImageView) view).setImageDrawable(null);
                return super.mo28326a(view);
            }
        });
        this.f5136d.put(Integer.valueOf(10), new C2420d() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final View mo28324a(@NonNull Context context) {
                return new C2358dy(context.getApplicationContext());
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final void mo28325a(@NonNull View view, @NonNull C2214bc bcVar, @NonNull C2426eq eqVar) {
                super.mo28325a(view, bcVar, eqVar);
                C2404el.m5019a((C2358dy) view, bcVar);
            }

            /* renamed from: a */
            public final boolean mo28326a(@NonNull View view) {
                if (!(view instanceof C2358dy)) {
                    return false;
                }
                ((C2358dy) view).setGifImpl(null);
                return super.mo28326a(view);
            }
        });
        this.f5136d.put(Integer.valueOf(7), new C2420d() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final View mo28324a(@NonNull Context context) {
                return new C2403ek(context.getApplicationContext());
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final void mo28325a(@NonNull View view, @NonNull C2214bc bcVar, @NonNull C2426eq eqVar) {
                super.mo28325a(view, bcVar, eqVar);
                C2404el.m5020a((C2403ek) view, bcVar);
            }

            /* renamed from: a */
            public final boolean mo28326a(@NonNull View view) {
                if (!(view instanceof C2403ek)) {
                    return false;
                }
                C2403ek ekVar = (C2403ek) view;
                ekVar.getProgressBar().setVisibility(8);
                ekVar.getPoster().setImageBitmap(null);
                ekVar.getVideoView().mo28268a();
                return super.mo28326a(view);
            }
        });
        this.f5136d.put(Integer.valueOf(4), new C2420d() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final View mo28324a(@NonNull Context context) {
                return new C2418b(context.getApplicationContext());
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final void mo28325a(@NonNull View view, @NonNull C2214bc bcVar, @NonNull C2426eq eqVar) {
                super.mo28325a(view, bcVar, eqVar);
                C2404el.m5017a((TextView) view, bcVar);
            }

            /* renamed from: a */
            public final boolean mo28326a(@NonNull View view) {
                if (!(view instanceof TextView)) {
                    return false;
                }
                C2404el.m5016a((TextView) view);
                return super.mo28326a(view);
            }
        });
        this.f5136d.put(Integer.valueOf(5), new C2420d() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final View mo28324a(@NonNull Context context) {
                return new Button(context.getApplicationContext());
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final void mo28325a(@NonNull View view, @NonNull C2214bc bcVar, @NonNull C2426eq eqVar) {
                super.mo28325a(view, bcVar, eqVar);
                C2404el.m5014a((Button) view, bcVar);
            }

            /* renamed from: a */
            public final boolean mo28326a(@NonNull View view) {
                if (!(view instanceof Button)) {
                    return false;
                }
                C2404el.m5016a((TextView) (Button) view);
                return super.mo28326a(view);
            }
        });
        this.f5136d.put(Integer.valueOf(8), new C2420d() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final View mo28324a(@NonNull Context context) {
                return new C2231bn(context.getApplicationContext());
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final void mo28325a(@NonNull View view, @NonNull C2214bc bcVar, @NonNull C2426eq eqVar) {
                super.mo28325a(view, bcVar, eqVar);
                C2404el.m5021a(C2404el.this, (C2231bn) view, bcVar);
            }

            /* renamed from: a */
            public final boolean mo28326a(@NonNull View view) {
                return (view instanceof C2231bn) && super.mo28326a(view);
            }
        });
        this.f5136d.put(Integer.valueOf(9), new C2420d() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final View mo28324a(@NonNull Context context) {
                C2600j jVar;
                try {
                    jVar = new C2600j(context.getApplicationContext(), 0, null, null);
                    try {
                        jVar.setShouldFireRenderBeacon(false);
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Exception e2) {
                    e = e2;
                    jVar = null;
                    C2404el.f5129a;
                    C2463fd.m5161a().mo28382a(new C2495fz(e));
                    return jVar;
                }
                return jVar;
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public final void mo28325a(@NonNull View view, @NonNull C2214bc bcVar, @NonNull C2426eq eqVar) {
                super.mo28325a(view, bcVar, eqVar);
                C2404el.m5022a((C2600j) view, bcVar, eqVar);
            }

            /* renamed from: a */
            public final boolean mo28326a(@NonNull View view) {
                return (view instanceof C2600j) && !((C2600j) view).f5815u && super.mo28326a(view);
            }
        });
    }

    /* renamed from: a */
    public static C2404el m5007a(Context context) {
        C2404el elVar;
        C2404el elVar2;
        C2404el elVar3 = null;
        if (f5131e == null) {
            elVar = null;
        } else {
            elVar = (C2404el) f5131e.get();
        }
        if (elVar == null) {
            synchronized (C2404el.class) {
                if (f5131e != null) {
                    elVar3 = (C2404el) f5131e.get();
                }
                if (elVar3 == null) {
                    elVar2 = new C2404el(context);
                    f5131e = new WeakReference<>(elVar2);
                } else {
                    elVar2 = elVar3;
                }
            }
        }
        return elVar;
    }

    @Nullable
    /* renamed from: a */
    public final View mo28321a(@NonNull Context context, @NonNull C2214bc bcVar, @NonNull C2426eq eqVar) {
        int a = m5004a(bcVar);
        if (-1 == a) {
            return null;
        }
        C2420d dVar = (C2420d) this.f5136d.get(Integer.valueOf(a));
        if (dVar == null) {
            return null;
        }
        return dVar.mo28332a(context, bcVar, eqVar);
    }

    /* renamed from: a */
    public final void mo28323a(@NonNull ViewGroup viewGroup) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            viewGroup.removeViewAt(childCount);
            mo28322a(childAt);
        }
    }

    /* renamed from: a */
    public final void mo28322a(@NonNull View view) {
        if ((view instanceof C2382ee) || (view instanceof C2359dz)) {
            C2359dz dzVar = (C2359dz) view;
            if (dzVar.getChildCount() != 0) {
                Stack stack = new Stack();
                stack.push(dzVar);
                while (!stack.isEmpty()) {
                    C2359dz dzVar2 = (C2359dz) stack.pop();
                    for (int childCount = dzVar2.getChildCount() - 1; childCount >= 0; childCount--) {
                        View childAt = dzVar2.getChildAt(childCount);
                        dzVar2.removeViewAt(childCount);
                        if (childAt instanceof C2359dz) {
                            stack.push((C2359dz) childAt);
                        } else {
                            m5030c(childAt);
                        }
                    }
                    m5030c((View) dzVar2);
                }
                return;
            }
        }
        m5030c(view);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        if (r10.equals(com.facebook.share.internal.ShareConstants.VIDEO_URL) != false) goto L_0x007d;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m5004a(com.inmobi.media.C2214bc r10) {
        /*
            boolean r0 = r10 instanceof com.inmobi.media.C2216be
            r1 = 3
            r2 = 2
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L_0x001e
            com.inmobi.media.be r10 = (com.inmobi.media.C2216be) r10
            boolean r0 = r10.mo27951a()
            if (r0 == 0) goto L_0x0011
            return r3
        L_0x0011:
            boolean r0 = r10.mo27952b()
            if (r0 == 0) goto L_0x001d
            int r10 = r10.f4557A
            if (r10 == r4) goto L_0x001c
            return r4
        L_0x001c:
            return r2
        L_0x001d:
            return r1
        L_0x001e:
            java.lang.String r10 = r10.f4522b
            int r0 = r10.hashCode()
            r5 = 5
            r6 = 7
            r7 = 6
            r8 = 4
            r9 = -1
            switch(r0) {
                case 67056: goto L_0x0072;
                case 70564: goto L_0x0068;
                case 2241657: goto L_0x005e;
                case 2571565: goto L_0x0054;
                case 69775675: goto L_0x004a;
                case 79826725: goto L_0x0040;
                case 81665115: goto L_0x0037;
                case 1942407129: goto L_0x002d;
                default: goto L_0x002c;
            }
        L_0x002c:
            goto L_0x007c
        L_0x002d:
            java.lang.String r0 = "WEBVIEW"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x007c
            r1 = 6
            goto L_0x007d
        L_0x0037:
            java.lang.String r0 = "VIDEO"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x007c
            goto L_0x007d
        L_0x0040:
            java.lang.String r0 = "TIMER"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x007c
            r1 = 5
            goto L_0x007d
        L_0x004a:
            java.lang.String r0 = "IMAGE"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x007c
            r1 = 1
            goto L_0x007d
        L_0x0054:
            java.lang.String r0 = "TEXT"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x007c
            r1 = 0
            goto L_0x007d
        L_0x005e:
            java.lang.String r0 = "ICON"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x007c
            r1 = 2
            goto L_0x007d
        L_0x0068:
            java.lang.String r0 = "GIF"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x007c
            r1 = 7
            goto L_0x007d
        L_0x0072:
            java.lang.String r0 = "CTA"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x007c
            r1 = 4
            goto L_0x007d
        L_0x007c:
            r1 = -1
        L_0x007d:
            switch(r1) {
                case 0: goto L_0x008d;
                case 1: goto L_0x008c;
                case 2: goto L_0x008c;
                case 3: goto L_0x008b;
                case 4: goto L_0x008a;
                case 5: goto L_0x0087;
                case 6: goto L_0x0084;
                case 7: goto L_0x0081;
                default: goto L_0x0080;
            }
        L_0x0080:
            return r9
        L_0x0081:
            r10 = 10
            return r10
        L_0x0084:
            r10 = 9
            return r10
        L_0x0087:
            r10 = 8
            return r10
        L_0x008a:
            return r5
        L_0x008b:
            return r6
        L_0x008c:
            return r7
        L_0x008d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2404el.m5004a(com.inmobi.media.bc):int");
    }

    /* renamed from: c */
    private void m5030c(@NonNull View view) {
        int intValue = ((Integer) f5130c.get(view.getClass())).intValue();
        if (-1 != intValue) {
            C2420d dVar = (C2420d) this.f5136d.get(Integer.valueOf(intValue));
            if (dVar != null) {
                if (this.f5135b >= 300) {
                    m5029c();
                }
                dVar.mo28326a(view);
            }
        }
    }

    /* renamed from: c */
    private void m5029c() {
        C2420d d = m5031d();
        if (d != null) {
            d.mo28333a();
        }
    }

    @Nullable
    /* renamed from: d */
    private C2420d m5031d() {
        int i = 0;
        C2420d dVar = null;
        for (Entry entry : this.f5136d.entrySet()) {
            if (((C2420d) entry.getValue()).f5157b.size() > i) {
                C2420d dVar2 = (C2420d) entry.getValue();
                dVar = dVar2;
                i = dVar2.f5157b.size();
            }
        }
        return dVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m5026b(Context context, ImageView imageView) {
        Bitmap bitmap;
        if (imageView.getDrawable() == null) {
            float f = C2528gq.m5393a().f5543c;
            C2242bv bvVar = new C2242bv(context, f, 0);
            if (VERSION.SDK_INT < 28) {
                bvVar.layout(0, 0, (int) (((float) m5028c(40)) * f), (int) (((float) m5028c(40)) * f));
                bvVar.setDrawingCacheEnabled(true);
                bvVar.buildDrawingCache();
                bitmap = bvVar.getDrawingCache();
            } else {
                bvVar.layout(0, 0, (int) (((float) m5028c(40)) * f), (int) (((float) m5028c(40)) * f));
                bitmap = Bitmap.createBitmap((int) (((float) m5028c(40)) * f), (int) (((float) m5028c(40)) * f), Config.ARGB_8888);
                bvVar.draw(new Canvas(bitmap));
            }
            imageView.setImageBitmap(bitmap);
        }
    }

    /* renamed from: a */
    private static void m5018a(@NonNull TextView textView, String[] strArr) {
        int paintFlags = textView.getPaintFlags();
        int i = paintFlags;
        int i2 = 0;
        for (String str : strArr) {
            char c = 65535;
            switch (str.hashCode()) {
                case -1178781136:
                    if (str.equals("italic")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1026963764:
                    if (str.equals("underline")) {
                        c = 3;
                        break;
                    }
                    break;
                case -891985998:
                    if (str.equals("strike")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3029637:
                    if (str.equals("bold")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                i2 |= 1;
            } else if (c == 1) {
                i2 |= 2;
            } else if (c == 2) {
                i |= 16;
            } else if (c == 3) {
                i |= 8;
            }
        }
        textView.setTypeface(Typeface.DEFAULT, i2);
        textView.setPaintFlags(i);
    }

    @TargetApi(21)
    /* renamed from: a */
    static void m5013a(View view, @NonNull C2215bd bdVar) {
        int parseColor = Color.parseColor("#00000000");
        try {
            parseColor = Color.parseColor(bdVar.mo27947e());
        } catch (IllegalArgumentException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        }
        view.setBackgroundColor(parseColor);
        if ("line".equals(bdVar.mo27943a())) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(parseColor);
            if ("curved".equals(bdVar.mo27944b())) {
                gradientDrawable.setCornerRadius(bdVar.mo27945c());
            }
            int parseColor2 = Color.parseColor("#ff000000");
            try {
                parseColor2 = Color.parseColor(bdVar.mo27946d());
            } catch (IllegalArgumentException e2) {
                C2463fd.m5161a().mo28382a(new C2495fz(e2));
            }
            gradientDrawable.setStroke(1, parseColor2);
            if (VERSION.SDK_INT < 16) {
                view.setBackgroundDrawable(gradientDrawable);
                return;
            }
            view.setBackground(gradientDrawable);
        }
    }

    /* renamed from: a */
    public static LayoutParams m5006a(@NonNull C2214bc bcVar, @NonNull ViewGroup viewGroup) {
        Point point = bcVar.f4523c.f4546a;
        Point point2 = bcVar.f4523c.f4548c;
        LayoutParams layoutParams = new LayoutParams(m5028c(point.x), m5028c(point.y));
        if (viewGroup instanceof C2359dz) {
            layoutParams = new C2360a(m5028c(point.x), m5028c(point.y));
            C2360a aVar = (C2360a) layoutParams;
            int c = m5028c(point2.x);
            int c2 = m5028c(point2.y);
            aVar.f5007a = c;
            aVar.f5008b = c2;
        } else if (viewGroup instanceof LinearLayout) {
            layoutParams = new LinearLayout.LayoutParams(m5028c(point.x), m5028c(point.y));
            ((LinearLayout.LayoutParams) layoutParams).setMargins(m5028c(point2.x), m5028c(point2.y), 0, 0);
        } else if (viewGroup instanceof AbsListView) {
            return new AbsListView.LayoutParams(m5028c(point.x), m5028c(point.y));
        } else {
            if (viewGroup instanceof FrameLayout) {
                layoutParams = new FrameLayout.LayoutParams(m5028c(point.x), m5028c(point.y));
                ((FrameLayout.LayoutParams) layoutParams).setMargins(m5028c(point2.x), m5028c(point2.y), 0, 0);
            }
        }
        return layoutParams;
    }

    /* renamed from: b */
    static /* synthetic */ void m5027b(View view) {
        if (VERSION.SDK_INT < 16) {
            view.setBackgroundDrawable(null);
        } else {
            view.setBackground(null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x014d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m5015a(android.widget.ImageView r9, com.inmobi.media.C2214bc r10) {
        /*
            java.lang.Object r0 = r10.f4525e
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x0155
            com.inmobi.media.bd r1 = r10.f4523c
            android.graphics.Point r1 = r1.f4546a
            int r1 = r1.x
            int r1 = m5028c(r1)
            com.inmobi.media.bd r2 = r10.f4523c
            android.graphics.Point r2 = r2.f4546a
            int r2 = r2.y
            int r2 = m5028c(r2)
            com.inmobi.media.bd r3 = r10.f4523c
            java.lang.String r3 = r3.mo27948f()
            r4 = -1
            int r5 = r3.hashCode()
            r6 = -1362001767(0xffffffffaed18099, float:-9.527063E-11)
            r7 = 0
            r8 = 1
            if (r5 == r6) goto L_0x003c
            r6 = 727618043(0x2b5e91fb, float:7.907283E-13)
            if (r5 == r6) goto L_0x0032
            goto L_0x0045
        L_0x0032:
            java.lang.String r5 = "aspectFill"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0045
            r4 = 1
            goto L_0x0045
        L_0x003c:
            java.lang.String r5 = "aspectFit"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0045
            r4 = 0
        L_0x0045:
            if (r4 == 0) goto L_0x0055
            if (r4 == r8) goto L_0x004f
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.FIT_XY
            r9.setScaleType(r3)
            goto L_0x005a
        L_0x004f:
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.CENTER_CROP
            r9.setScaleType(r3)
            goto L_0x005a
        L_0x0055:
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.FIT_CENTER
            r9.setScaleType(r3)
        L_0x005a:
            java.lang.ref.WeakReference<android.content.Context> r3 = f5132f
            java.lang.Object r3 = r3.get()
            android.content.Context r3 = (android.content.Context) r3
            if (r3 == 0) goto L_0x00a9
            if (r1 <= 0) goto L_0x00a9
            if (r2 <= 0) goto L_0x00a9
            java.lang.String r1 = r0.trim()
            int r1 = r1.length()
            if (r1 == 0) goto L_0x00a9
            com.squareup.picasso.Picasso r1 = com.inmobi.media.C2277cg.m4616a(r3)
            com.squareup.picasso.RequestCreator r0 = r1.load(r0)
            com.inmobi.media.el$c r1 = new com.inmobi.media.el$c
            r1.<init>(r3, r9, r10)
            java.lang.Object r1 = com.inmobi.media.C2277cg.m4618a(r1)
            com.squareup.picasso.Callback r1 = (com.squareup.picasso.Callback) r1
            r0.into(r9, r1)
            java.lang.String r0 = r10.f4524d
            java.lang.String r1 = "cross_button"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x00a9
            java.lang.String r0 = r10.f4538r
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00a9
            android.os.Handler r0 = new android.os.Handler
            r0.<init>()
            com.inmobi.media.el$a r1 = new com.inmobi.media.el$a
            r1.<init>(r3, r9)
            r2 = 2000(0x7d0, double:9.88E-321)
            r0.postDelayed(r1, r2)
        L_0x00a9:
            com.inmobi.media.bc r0 = r10.f4540t
            if (r0 == 0) goto L_0x0140
            com.inmobi.media.bd r1 = r0.f4523c
            java.lang.String r1 = r1.mo27943a()
            java.lang.String r2 = "line"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0140
            com.inmobi.media.bd r1 = r0.f4523c
            android.graphics.Point r1 = r1.f4548c
            int r1 = r1.x
            com.inmobi.media.bd r2 = r10.f4523c
            android.graphics.Point r2 = r2.f4548c
            int r2 = r2.x
            if (r1 != r2) goto L_0x00cb
            r1 = 1
            goto L_0x00cc
        L_0x00cb:
            r1 = 0
        L_0x00cc:
            com.inmobi.media.bd r2 = r0.f4523c
            android.graphics.Point r2 = r2.f4546a
            int r2 = r2.x
            int r2 = m5028c(r2)
            com.inmobi.media.bd r3 = r10.f4523c
            android.graphics.Point r3 = r3.f4546a
            int r3 = r3.x
            int r3 = m5028c(r3)
            com.inmobi.media.bd r4 = r10.f4523c
            android.graphics.Point r4 = r4.f4548c
            int r4 = r4.x
            int r3 = r3 + r4
            if (r2 != r3) goto L_0x00eb
            r2 = 1
            goto L_0x00ec
        L_0x00eb:
            r2 = 0
        L_0x00ec:
            com.inmobi.media.bd r3 = r0.f4523c
            android.graphics.Point r3 = r3.f4548c
            int r3 = r3.y
            int r3 = m5028c(r3)
            com.inmobi.media.bd r4 = r10.f4523c
            android.graphics.Point r4 = r4.f4548c
            int r4 = r4.y
            int r4 = m5028c(r4)
            if (r3 != r4) goto L_0x0104
            r3 = 1
            goto L_0x0105
        L_0x0104:
            r3 = 0
        L_0x0105:
            com.inmobi.media.bd r4 = r0.f4523c
            android.graphics.Point r4 = r4.f4546a
            int r4 = r4.y
            int r4 = m5028c(r4)
            com.inmobi.media.bd r5 = r10.f4523c
            android.graphics.Point r5 = r5.f4546a
            int r5 = r5.y
            int r5 = m5028c(r5)
            com.inmobi.media.bd r6 = r10.f4523c
            android.graphics.Point r6 = r6.f4548c
            int r6 = r6.y
            int r6 = m5028c(r6)
            int r5 = r5 + r6
            if (r4 != r5) goto L_0x0127
            r7 = 1
        L_0x0127:
            com.inmobi.media.bd r0 = r0.f4523c
            android.graphics.Point r0 = r0.f4546a
            int r0 = r0.x
            int r0 = m5028c(r0)
            com.inmobi.media.bd r4 = r10.f4523c
            android.graphics.Point r4 = r4.f4546a
            int r4 = r4.x
            int r4 = m5028c(r4)
            if (r0 != r4) goto L_0x0143
            r1 = 1
            r2 = 1
            goto L_0x0143
        L_0x0140:
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x0143:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 17
            if (r0 >= r4) goto L_0x014d
            r9.setPadding(r1, r3, r2, r7)
            goto L_0x0150
        L_0x014d:
            r9.setPaddingRelative(r1, r3, r2, r7)
        L_0x0150:
            com.inmobi.media.bd r10 = r10.f4523c
            m5013a(r9, r10)
        L_0x0155:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2404el.m5015a(android.widget.ImageView, com.inmobi.media.bc):void");
    }

    /* renamed from: a */
    static /* synthetic */ void m5019a(C2358dy dyVar, C2214bc bcVar) {
        dyVar.setLayoutParams(new LayoutParams(m5028c(bcVar.f4523c.f4546a.x), m5028c(bcVar.f4523c.f4546a.y)));
        dyVar.setContentMode(bcVar.f4523c.mo27948f());
        dyVar.setGifImpl(((C2223bh) bcVar).f4597z);
        m5013a((View) dyVar, bcVar.f4523c);
    }

    /* renamed from: a */
    static /* synthetic */ void m5020a(C2403ek ekVar, C2214bc bcVar) {
        m5013a((View) ekVar, bcVar.f4523c);
        if (bcVar.f4543w != null) {
            ekVar.setPosterImage((Bitmap) bcVar.f4543w);
        }
        ekVar.getProgressBar().setVisibility(0);
    }

    /* renamed from: a */
    static /* synthetic */ void m5017a(TextView textView, C2214bc bcVar) {
        C2227a aVar = (C2227a) bcVar.f4523c;
        textView.setLayoutParams(new LayoutParams(m5028c(aVar.f4546a.x), m5028c(aVar.f4546a.y)));
        textView.setText((CharSequence) bcVar.f4525e);
        textView.setTypeface(Typeface.DEFAULT);
        int i = aVar.f4602p;
        if (i == 1) {
            textView.setGravity(8388629);
        } else if (i != 2) {
            textView.setGravity(8388627);
        } else {
            textView.setGravity(17);
        }
        textView.setTextSize(1, (float) m5028c(aVar.mo27965h()));
        int parseColor = Color.parseColor("#ff000000");
        try {
            parseColor = Color.parseColor(aVar.mo27966i());
        } catch (IllegalArgumentException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        }
        textView.setTextColor(parseColor);
        int parseColor2 = Color.parseColor("#00000000");
        try {
            parseColor2 = Color.parseColor(aVar.mo27947e());
        } catch (IllegalArgumentException e2) {
            C2463fd.m5161a().mo28382a(new C2495fz(e2));
        }
        textView.setBackgroundColor(parseColor2);
        if (VERSION.SDK_INT >= 17) {
            textView.setTextAlignment(1);
        }
        m5018a(textView, aVar.mo27967j());
        textView.setEllipsize(TruncateAt.END);
        textView.setHorizontallyScrolling(true);
        textView.setFocusable(true);
        textView.setFocusableInTouchMode(true);
        m5013a((View) textView, (C2215bd) aVar);
    }

    /* renamed from: a */
    static /* synthetic */ void m5016a(TextView textView) {
        textView.setTypeface(Typeface.DEFAULT, 0);
        textView.setPaintFlags(textView.getPaintFlags() & -17);
        textView.setPaintFlags(textView.getPaintFlags() & -9);
    }

    /* renamed from: a */
    static /* synthetic */ void m5014a(Button button, C2214bc bcVar) {
        C2219a aVar = (C2219a) bcVar.f4523c;
        button.setLayoutParams(new LayoutParams(m5028c(aVar.f4546a.x), m5028c(aVar.f4546a.y)));
        button.setText((CharSequence) bcVar.f4525e);
        button.setTextSize(1, (float) m5028c(aVar.mo27965h()));
        int parseColor = Color.parseColor("#ff000000");
        try {
            parseColor = Color.parseColor(aVar.mo27966i());
        } catch (IllegalArgumentException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        }
        button.setTextColor(parseColor);
        int parseColor2 = Color.parseColor("#00000000");
        try {
            parseColor2 = Color.parseColor(aVar.mo27947e());
        } catch (IllegalArgumentException e2) {
            C2463fd.m5161a().mo28382a(new C2495fz(e2));
        }
        button.setBackgroundColor(parseColor2);
        if (VERSION.SDK_INT >= 17) {
            button.setTextAlignment(4);
        }
        button.setGravity(17);
        m5018a((TextView) button, aVar.mo27967j());
        m5013a((View) button, (C2215bd) aVar);
    }

    /* renamed from: a */
    static /* synthetic */ void m5021a(C2404el elVar, final C2231bn bnVar, C2214bc bcVar) {
        long j;
        bnVar.setVisibility(4);
        final C2230bm bmVar = (C2230bm) bcVar;
        C2229a aVar = bmVar.f4609A.f4603a;
        C2229a aVar2 = bmVar.f4609A.f4604b;
        if (aVar != null) {
            try {
                j = aVar.mo27968a();
            } catch (Exception e) {
                C2463fd.m5161a().mo28382a(new C2495fz(e));
                return;
            }
        } else {
            j = 0;
        }
        long a = aVar2 != null ? aVar2.mo27968a() : 0;
        if (a >= 0) {
            bnVar.setTimerValue(a);
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    if (C2404el.f5132f.get() != null) {
                        if (bmVar.f4610z) {
                            bnVar.setVisibility(0);
                        }
                        bnVar.mo27969a();
                    }
                }
            }, j * 1000);
        }
    }

    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m5022a(com.inmobi.media.C2600j r4, com.inmobi.media.C2214bc r5, com.inmobi.media.C2426eq r6) {
        /*
            r0 = r5
            com.inmobi.media.bq r0 = (com.inmobi.media.C2237bq) r0     // Catch:{ Exception -> 0x004f }
            com.inmobi.media.j$a r1 = com.inmobi.media.C2600j.f5757a     // Catch:{ Exception -> 0x004f }
            r2 = 0
            r4.mo28623a(r1, r6, r2, r2)     // Catch:{ Exception -> 0x004f }
            r6 = 1
            r4.f5802h = r6     // Catch:{ Exception -> 0x004f }
            java.lang.Object r5 = r5.f4525e     // Catch:{ Exception -> 0x004f }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x004f }
            java.lang.String r0 = r0.f4645z     // Catch:{ Exception -> 0x004f }
            r1 = -1
            int r3 = r0.hashCode()     // Catch:{ Exception -> 0x004f }
            switch(r3) {
                case -1081286672: goto L_0x0038;
                case 84303: goto L_0x002e;
                case 2228139: goto L_0x0024;
                case 83774455: goto L_0x001b;
                default: goto L_0x001a;
            }     // Catch:{ Exception -> 0x004f }
        L_0x001a:
            goto L_0x0042
        L_0x001b:
            java.lang.String r3 = "REF_HTML"
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x004f }
            if (r0 == 0) goto L_0x0042
            goto L_0x0043
        L_0x0024:
            java.lang.String r2 = "HTML"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x004f }
            if (r0 == 0) goto L_0x0042
            r2 = 1
            goto L_0x0043
        L_0x002e:
            java.lang.String r2 = "URL"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x004f }
            if (r0 == 0) goto L_0x0042
            r2 = 3
            goto L_0x0043
        L_0x0038:
            java.lang.String r2 = "REF_IFRAME"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x004f }
            if (r0 == 0) goto L_0x0042
            r2 = 2
            goto L_0x0043
        L_0x0042:
            r2 = -1
        L_0x0043:
            if (r2 == 0) goto L_0x004b
            if (r2 == r6) goto L_0x004b
            r4.mo28630c(r5)     // Catch:{ Exception -> 0x004f }
            return
        L_0x004b:
            r4.mo28627b(r5)     // Catch:{ Exception -> 0x004f }
            return
        L_0x004f:
            r4 = move-exception
            com.inmobi.media.fd r5 = com.inmobi.media.C2463fd.m5161a()
            com.inmobi.media.fz r6 = new com.inmobi.media.fz
            r6.<init>(r4)
            r5.mo28382a(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2404el.m5022a(com.inmobi.media.j, com.inmobi.media.bc, com.inmobi.media.eq):void");
    }

    /* renamed from: a */
    static /* synthetic */ void m5012a(Context context, ImageView imageView, C2214bc bcVar) {
        if (!(context == null || imageView == null)) {
            String str = bcVar.f4538r;
            if ("cross_button".equalsIgnoreCase(bcVar.f4524d) && str.trim().length() == 0) {
                m5026b(context, imageView);
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("[ERRORCODE]", "603");
        bcVar.mo27940a("error", (Map<String, String>) hashMap);
    }
}
