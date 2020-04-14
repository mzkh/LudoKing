package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tapjoy.internal.io */
public final class C3187io extends RelativeLayout {

    /* renamed from: a */
    private C3151hr f7594a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C3190a f7595b;

    /* renamed from: c */
    private C2859aa f7596c = C2859aa.UNSPECIFIED;

    /* renamed from: d */
    private int f7597d = 0;

    /* renamed from: e */
    private int f7598e = 0;

    /* renamed from: f */
    private C3170ia f7599f = null;

    /* renamed from: g */
    private ArrayList f7600g = null;

    /* renamed from: h */
    private ArrayList f7601h = null;

    /* renamed from: com.tapjoy.internal.io$a */
    public interface C3190a {
        /* renamed from: a */
        void mo30196a();

        /* renamed from: a */
        void mo30197a(C3167hz hzVar);
    }

    public C3187io(Context context, C3151hr hrVar, C3190a aVar) {
        super(context);
        this.f7594a = hrVar;
        this.f7595b = aVar;
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f7595b.mo30196a();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r17, int r18) {
        /*
            r16 = this;
            r0 = r16
            int r1 = android.view.View.MeasureSpec.getSize(r17)
            int r2 = android.view.View.MeasureSpec.getSize(r18)
            if (r1 < r2) goto L_0x001a
            com.tapjoy.internal.aa r3 = r0.f7596c
            com.tapjoy.internal.aa r4 = com.tapjoy.internal.C2859aa.LANDSCAPE
            if (r3 == r4) goto L_0x0027
            com.tapjoy.internal.aa r3 = com.tapjoy.internal.C2859aa.LANDSCAPE
            r0.f7596c = r3
            r16.m7357a()
            goto L_0x0027
        L_0x001a:
            com.tapjoy.internal.aa r3 = r0.f7596c
            com.tapjoy.internal.aa r4 = com.tapjoy.internal.C2859aa.PORTRAIT
            if (r3 == r4) goto L_0x0027
            com.tapjoy.internal.aa r3 = com.tapjoy.internal.C2859aa.PORTRAIT
            r0.f7596c = r3
            r16.m7357a()
        L_0x0027:
            int r3 = r0.f7597d
            if (r3 != r1) goto L_0x002f
            int r3 = r0.f7598e
            if (r3 == r2) goto L_0x0114
        L_0x002f:
            r0.f7597d = r1
            r0.f7598e = r2
            float r1 = (float) r1
            float r2 = (float) r2
            com.tapjoy.internal.ia r3 = r0.f7599f
            r4 = 0
            r5 = 1073741824(0x40000000, float:2.0)
            if (r3 == 0) goto L_0x007f
            android.graphics.PointF r3 = r3.f7526b
            if (r3 == 0) goto L_0x007f
            com.tapjoy.internal.ia r3 = r0.f7599f
            android.graphics.PointF r3 = r3.f7526b
            float r3 = r3.y
            float r3 = r3 * r1
            com.tapjoy.internal.ia r6 = r0.f7599f
            android.graphics.PointF r6 = r6.f7526b
            float r6 = r6.x
            float r3 = r3 / r6
            float r3 = r3 / r2
            r6 = 1065353216(0x3f800000, float:1.0)
            int r7 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r7 >= 0) goto L_0x0068
            com.tapjoy.internal.ia r3 = r0.f7599f
            android.graphics.PointF r3 = r3.f7526b
            float r3 = r3.y
            float r3 = r3 * r1
            com.tapjoy.internal.ia r6 = r0.f7599f
            android.graphics.PointF r6 = r6.f7526b
            float r6 = r6.x
            float r3 = r3 / r6
            float r2 = r2 - r3
            float r2 = r2 / r5
            goto L_0x0081
        L_0x0068:
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x007f
            com.tapjoy.internal.ia r3 = r0.f7599f
            android.graphics.PointF r3 = r3.f7526b
            float r3 = r3.x
            float r3 = r3 * r2
            com.tapjoy.internal.ia r6 = r0.f7599f
            android.graphics.PointF r6 = r6.f7526b
            float r6 = r6.y
            float r3 = r3 / r6
            float r1 = r1 - r3
            float r1 = r1 / r5
            r4 = r1
            r1 = r3
        L_0x007f:
            r3 = r2
            r2 = 0
        L_0x0081:
            java.lang.Iterable r6 = com.tapjoy.internal.C2861ac.m6563a(r16)
            java.util.Iterator r6 = r6.iterator()
        L_0x0089:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0114
            java.lang.Object r7 = r6.next()
            android.view.View r7 = (android.view.View) r7
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r8 = (android.widget.RelativeLayout.LayoutParams) r8
            java.lang.Object r7 = r7.getTag()
            com.tapjoy.internal.hz r7 = (com.tapjoy.internal.C3167hz) r7
            com.tapjoy.internal.ib r9 = r7.f7510a
            float r9 = r9.mo30234a(r1, r3)
            com.tapjoy.internal.ib r10 = r7.f7511b
            float r10 = r10.mo30234a(r1, r3)
            com.tapjoy.internal.ib r11 = r7.f7512c
            float r11 = r11.mo30234a(r1, r3)
            com.tapjoy.internal.ib r12 = r7.f7513d
            float r12 = r12.mo30234a(r1, r3)
            int r13 = r7.f7514e
            int r7 = r7.f7515f
            r14 = 14
            if (r13 != r14) goto L_0x00c7
            float r13 = r1 - r11
            float r13 = r13 / r5
            float r9 = r9 + r13
            r13 = 9
        L_0x00c7:
            r14 = 15
            r15 = 10
            if (r7 != r14) goto L_0x00d3
            float r7 = r3 - r12
            float r7 = r7 / r5
            float r10 = r10 + r7
            r7 = 10
        L_0x00d3:
            r14 = -1
            r8.addRule(r13, r14)
            r8.addRule(r7, r14)
            int r11 = java.lang.Math.round(r11)
            r8.width = r11
            int r11 = java.lang.Math.round(r12)
            r8.height = r11
            r11 = 9
            if (r13 != r11) goto L_0x00f2
            float r9 = r9 + r4
            int r9 = java.lang.Math.round(r9)
            r8.leftMargin = r9
            goto L_0x00fd
        L_0x00f2:
            r11 = 11
            if (r13 != r11) goto L_0x00fd
            float r9 = r9 + r4
            int r9 = java.lang.Math.round(r9)
            r8.rightMargin = r9
        L_0x00fd:
            if (r7 != r15) goto L_0x0107
            float r10 = r10 + r2
            int r7 = java.lang.Math.round(r10)
            r8.topMargin = r7
            goto L_0x0089
        L_0x0107:
            r9 = 12
            if (r7 != r9) goto L_0x0089
            float r10 = r10 + r2
            int r7 = java.lang.Math.round(r10)
            r8.bottomMargin = r7
            goto L_0x0089
        L_0x0114:
            super.onMeasure(r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3187io.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            ArrayList arrayList = this.f7601h;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    C3176ig igVar = (C3176ig) ((WeakReference) it.next()).get();
                    if (igVar != null) {
                        igVar.setVisibility(4);
                        igVar.mo30239b();
                    }
                }
            }
            ArrayList arrayList2 = this.f7600g;
            if (arrayList2 != null) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    C3176ig igVar2 = (C3176ig) ((WeakReference) it2.next()).get();
                    if (igVar2 != null) {
                        igVar2.setVisibility(0);
                        igVar2.mo30237a();
                    }
                }
            }
        } else {
            ArrayList arrayList3 = this.f7600g;
            if (arrayList3 != null) {
                Iterator it3 = arrayList3.iterator();
                while (it3.hasNext()) {
                    C3176ig igVar3 = (C3176ig) ((WeakReference) it3.next()).get();
                    if (igVar3 != null) {
                        igVar3.mo30239b();
                    }
                }
            }
            ArrayList arrayList4 = this.f7601h;
            if (arrayList4 != null) {
                Iterator it4 = arrayList4.iterator();
                while (it4.hasNext()) {
                    C3176ig igVar4 = (C3176ig) ((WeakReference) it4.next()).get();
                    if (igVar4 != null) {
                        igVar4.mo30239b();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m7357a() {
        C3176ig igVar;
        C3176ig igVar2;
        Bitmap bitmap;
        Iterator it = this.f7594a.f7468a.iterator();
        C3170ia iaVar = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C3170ia iaVar2 = (C3170ia) it.next();
            if (iaVar2.f7525a == this.f7596c) {
                iaVar = iaVar2;
                break;
            } else if (iaVar2.f7525a == C2859aa.UNSPECIFIED) {
                iaVar = iaVar2;
            }
        }
        removeAllViews();
        ArrayList arrayList = this.f7600g;
        if (arrayList != null) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                C3176ig igVar3 = (C3176ig) ((WeakReference) it2.next()).get();
                if (igVar3 != null) {
                    igVar3.mo30240c();
                }
            }
            this.f7600g.clear();
        }
        ArrayList arrayList2 = this.f7601h;
        if (arrayList2 != null) {
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                C3176ig igVar4 = (C3176ig) ((WeakReference) it3.next()).get();
                if (igVar4 != null) {
                    igVar4.mo30240c();
                }
            }
            this.f7601h.clear();
        }
        if (iaVar != null) {
            this.f7599f = iaVar;
            Context context = getContext();
            Iterator it4 = iaVar.f7527c.iterator();
            while (it4.hasNext()) {
                C3167hz hzVar = (C3167hz) it4.next();
                RelativeLayout relativeLayout = new RelativeLayout(context);
                if (hzVar.f7521l.f7502c != null) {
                    C3176ig igVar5 = new C3176ig(context);
                    igVar5.setScaleType(ScaleType.FIT_XY);
                    igVar5.mo30238a(hzVar.f7521l.f7503d, hzVar.f7521l.f7502c);
                    if (this.f7600g == null) {
                        this.f7600g = new ArrayList();
                    }
                    this.f7600g.add(new WeakReference(igVar5));
                    igVar = igVar5;
                } else {
                    igVar = null;
                }
                if (hzVar.f7522m == null || hzVar.f7522m.f7502c == null) {
                    igVar2 = null;
                } else {
                    C3176ig igVar6 = new C3176ig(context);
                    igVar6.setScaleType(ScaleType.FIT_XY);
                    igVar6.mo30238a(hzVar.f7522m.f7503d, hzVar.f7522m.f7502c);
                    if (this.f7601h == null) {
                        this.f7601h = new ArrayList();
                    }
                    this.f7601h.add(new WeakReference(igVar6));
                    igVar2 = igVar6;
                }
                LayoutParams layoutParams = new LayoutParams(0, 0);
                LayoutParams layoutParams2 = new LayoutParams(-1, -1);
                Bitmap bitmap2 = hzVar.f7521l.f7501b;
                if (hzVar.f7522m != null) {
                    bitmap = hzVar.f7522m.f7501b;
                } else {
                    bitmap = null;
                }
                final BitmapDrawable bitmapDrawable = bitmap2 != null ? new BitmapDrawable(null, bitmap2) : null;
                final BitmapDrawable bitmapDrawable2 = bitmap != null ? new BitmapDrawable(null, bitmap) : null;
                if (bitmapDrawable != null) {
                    C2860ab.m6562a(relativeLayout, bitmapDrawable);
                }
                if (igVar != null) {
                    relativeLayout.addView(igVar, layoutParams2);
                    igVar.mo30237a();
                }
                if (igVar2 != null) {
                    relativeLayout.addView(igVar2, layoutParams2);
                    igVar2.setVisibility(4);
                }
                final C3176ig igVar7 = igVar2;
                final C3176ig igVar8 = igVar;
                C31881 r0 = new OnTouchListener() {
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            if (!(igVar7 == null && bitmapDrawable2 == null)) {
                                C3176ig igVar = igVar8;
                                if (igVar != null) {
                                    igVar.mo30239b();
                                    igVar8.setVisibility(4);
                                }
                                C2860ab.m6562a(view, null);
                            }
                            BitmapDrawable bitmapDrawable = bitmapDrawable2;
                            if (bitmapDrawable != null) {
                                C2860ab.m6562a(view, bitmapDrawable);
                            } else {
                                C3176ig igVar2 = igVar7;
                                if (igVar2 != null) {
                                    igVar2.setVisibility(0);
                                    igVar7.mo30237a();
                                }
                            }
                        } else {
                            boolean z = true;
                            if (motionEvent.getAction() == 1) {
                                float x = motionEvent.getX();
                                float y = motionEvent.getY();
                                if (x >= 0.0f && x < ((float) view.getWidth()) && y >= 0.0f && y < ((float) view.getHeight())) {
                                    z = false;
                                }
                                if (z) {
                                    BitmapDrawable bitmapDrawable2 = bitmapDrawable;
                                    if (bitmapDrawable2 != null) {
                                        C2860ab.m6562a(view, bitmapDrawable2);
                                    } else if (bitmapDrawable2 != null) {
                                        C2860ab.m6562a(view, null);
                                    }
                                }
                                C3176ig igVar3 = igVar7;
                                if (igVar3 != null) {
                                    igVar3.mo30239b();
                                    igVar7.setVisibility(4);
                                }
                                if (!(igVar7 == null && bitmapDrawable2 == null)) {
                                    C3176ig igVar4 = igVar8;
                                    if (igVar4 != null && z) {
                                        igVar4.setVisibility(0);
                                        igVar8.mo30237a();
                                    }
                                }
                            }
                        }
                        return false;
                    }
                };
                relativeLayout.setOnTouchListener(r0);
                final RelativeLayout relativeLayout2 = relativeLayout;
                final C3167hz hzVar2 = hzVar;
                C31892 r02 = new OnClickListener() {
                    public final void onClick(View view) {
                        C3176ig igVar = igVar7;
                        if (igVar != null) {
                            igVar.mo30239b();
                            relativeLayout2.removeView(igVar7);
                        }
                        C3176ig igVar2 = igVar8;
                        if (igVar2 != null) {
                            igVar2.mo30239b();
                            relativeLayout2.removeView(igVar8);
                        }
                        C3187io.this.f7595b.mo30197a(hzVar2);
                    }
                };
                relativeLayout.setOnClickListener(r02);
                relativeLayout.setTag(hzVar);
                addView(relativeLayout, layoutParams);
            }
        }
    }
}
