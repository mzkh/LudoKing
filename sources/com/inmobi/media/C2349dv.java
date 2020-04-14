package com.inmobi.media;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import androidx.annotation.Nullable;
import com.inmobi.media.C2228bl.C2229a;
import com.inmobi.media.C2359dz.C2360a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.inmobi.media.dv */
/* compiled from: AnimationManager */
public class C2349dv {

    /* renamed from: b */
    private static final String f4980b = "dv";

    /* renamed from: a */
    public List<C2352a> f4981a = new ArrayList();

    /* renamed from: c */
    private boolean f4982c = false;

    /* renamed from: com.inmobi.media.dv$a */
    /* compiled from: AnimationManager */
    public class C2352a {

        /* renamed from: a */
        public Animator f4989a;

        /* renamed from: b */
        long f4990b;

        /* renamed from: c */
        boolean f4991c;

        C2352a(Animator animator) {
            this.f4989a = animator;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final List<C2352a> mo28210a(final View view, C2214bc bcVar) {
        LinkedList linkedList = new LinkedList();
        try {
            float c = (float) C2404el.m5028c(bcVar.f4523c.f4548c.x);
            float c2 = (float) C2404el.m5028c(bcVar.f4523c.f4549d.x);
            if (c != c2) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) ((int) c), (float) ((int) c2)});
                final C2360a aVar = (C2360a) view.getLayoutParams();
                ofFloat.addUpdateListener(new AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        aVar.f5007a = ((Float) valueAnimator.getAnimatedValue()).intValue();
                        view.setLayoutParams(aVar);
                        view.requestLayout();
                    }
                });
                linkedList.add(m4893a((Animator) ofFloat, bcVar));
            }
            float c3 = (float) C2404el.m5028c(bcVar.f4523c.f4548c.y);
            float c4 = (float) C2404el.m5028c(bcVar.f4523c.f4549d.y);
            if (c3 != c4) {
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{(float) ((int) c3), (float) ((int) c4)});
                final C2360a aVar2 = (C2360a) view.getLayoutParams();
                ofFloat2.addUpdateListener(new AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        aVar2.f5008b = ((Float) valueAnimator.getAnimatedValue()).intValue();
                        view.setLayoutParams(aVar2);
                        view.requestLayout();
                    }
                });
                linkedList.add(m4893a((Animator) ofFloat2, bcVar));
            }
            float c5 = (float) C2404el.m5028c(bcVar.f4523c.f4546a.x);
            float c6 = (float) C2404el.m5028c(bcVar.f4523c.f4547b.x);
            if (c5 != c6) {
                linkedList.add(m4893a(m4892a(view, "scaleX", c5, c6), bcVar));
            }
            float c7 = (float) C2404el.m5028c(bcVar.f4523c.f4546a.y);
            float c8 = (float) C2404el.m5028c(bcVar.f4523c.f4547b.y);
            if (c7 != c8) {
                linkedList.add(m4893a(m4892a(view, "scaleY", c7, c8), bcVar));
            }
        } catch (Exception unused) {
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        return linkedList;
    }

    /* renamed from: a */
    private C2352a m4893a(Animator animator, C2214bc bcVar) {
        m4894b(animator, bcVar);
        return new C2352a(animator);
    }

    /* renamed from: b */
    private static void m4894b(Animator animator, C2214bc bcVar) {
        animator.setDuration(0);
        animator.setStartDelay(0);
        C2228bl g = bcVar.f4523c.mo27949g();
        if (g != null) {
            C2229a aVar = g.f4603a;
            C2229a aVar2 = g.f4604b;
            if (aVar2 != null) {
                animator.setDuration(aVar2.mo27968a() * 1000);
            }
            if (aVar != null) {
                animator.setStartDelay(aVar.mo27968a() * 1000);
            }
        }
    }

    /* renamed from: a */
    private static Animator m4892a(View view, String str, float f, float f2) {
        float f3 = f2 / f;
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        return ObjectAnimator.ofFloat(view, str, new float[]{f3});
    }

    /* renamed from: a */
    public final void mo28211a() {
        if (!this.f4982c) {
            this.f4982c = true;
            mo28212a(this.f4981a);
        }
    }

    /* renamed from: a */
    public final void mo28212a(@Nullable List<C2352a> list) {
        if (list != null) {
            for (C2352a aVar : list) {
                if (!aVar.f4991c) {
                    ValueAnimator valueAnimator = (ValueAnimator) aVar.f4989a;
                    valueAnimator.setCurrentPlayTime(aVar.f4990b);
                    valueAnimator.start();
                }
                if (!this.f4981a.contains(aVar)) {
                    this.f4981a.add(aVar);
                }
            }
        }
    }

    /* renamed from: b */
    public final void mo28213b() {
        if (this.f4982c) {
            this.f4982c = false;
            for (C2352a aVar : this.f4981a) {
                ValueAnimator valueAnimator = (ValueAnimator) aVar.f4989a;
                aVar.f4990b = valueAnimator.getCurrentPlayTime();
                if (((double) valueAnimator.getAnimatedFraction()) == 1.0d) {
                    aVar.f4991c = true;
                }
                valueAnimator.cancel();
            }
        }
    }
}
