package com.applovin.impl.sdk;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import com.applovin.impl.mediation.p014b.C0959b;
import com.applovin.impl.sdk.utils.C1245f;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.sdk.u */
public class C1238u {

    /* renamed from: a */
    private final C1192i f3133a;

    /* renamed from: b */
    private final C1227o f3134b;

    /* renamed from: c */
    private final MaxAdView f3135c;

    public C1238u(MaxAdView maxAdView, C1192i iVar) {
        this.f3133a = iVar;
        this.f3134b = iVar.mo10249v();
        this.f3135c = maxAdView;
    }

    /* renamed from: a */
    public long mo10405a(C0959b bVar) {
        long j;
        String str = "ViewabilityTracker";
        this.f3134b.mo10378b(str, "Checking visibility...");
        if (!this.f3135c.isShown()) {
            this.f3134b.mo10382e(str, "View is hidden");
            j = 2;
        } else {
            j = 0;
        }
        if (this.f3135c.getAlpha() < bVar.mo9443p()) {
            this.f3134b.mo10382e(str, "View is transparent");
            j |= 4;
        }
        Animation animation = this.f3135c.getAnimation();
        if (animation != null && animation.hasStarted() && !animation.hasEnded()) {
            this.f3134b.mo10382e(str, "View is animating");
            j |= 8;
        }
        if (this.f3135c.getParent() == null) {
            this.f3134b.mo10382e(str, "No parent view found");
            j |= 16;
        }
        int pxToDp = AppLovinSdkUtils.pxToDp(this.f3135c.getContext(), this.f3135c.getWidth());
        String str2 = ") below threshold";
        if (pxToDp < bVar.mo9441n()) {
            C1227o oVar = this.f3134b;
            StringBuilder sb = new StringBuilder();
            sb.append("View has width (");
            sb.append(pxToDp);
            sb.append(str2);
            oVar.mo10382e(str, sb.toString());
            j |= 32;
        }
        int pxToDp2 = AppLovinSdkUtils.pxToDp(this.f3135c.getContext(), this.f3135c.getHeight());
        if (pxToDp2 < bVar.mo9442o()) {
            C1227o oVar2 = this.f3134b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("View has height (");
            sb2.append(pxToDp2);
            sb2.append(str2);
            oVar2.mo10382e(str, sb2.toString());
            j |= 64;
        }
        Point a = C1245f.m2928a(this.f3135c.getContext());
        Rect rect = new Rect(0, 0, a.x, a.y);
        int[] iArr = {-1, -1};
        this.f3135c.getLocationOnScreen(iArr);
        Rect rect2 = new Rect(iArr[0], iArr[1], iArr[0] + this.f3135c.getWidth(), iArr[1] + this.f3135c.getHeight());
        if (!Rect.intersects(rect, rect2)) {
            C1227o oVar3 = this.f3134b;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Rect (");
            sb3.append(rect2);
            sb3.append(") outside of screen's bounds (");
            sb3.append(rect);
            sb3.append(")");
            oVar3.mo10382e(str, sb3.toString());
            j |= 128;
        }
        Activity a2 = this.f3133a.mo10217aa().mo9735a();
        if (a2 != null && !C1281o.m3091a((View) this.f3135c, a2)) {
            this.f3134b.mo10382e(str, "View is not in top activity's view hierarchy");
            j |= 256;
        }
        C1227o oVar4 = this.f3134b;
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Returning flags: ");
        sb4.append(Long.toBinaryString(j));
        oVar4.mo10378b(str, sb4.toString());
        return j;
    }
}
