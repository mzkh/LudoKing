package com.inmobi.media;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.iab.omid.library.inmobi.adsession.AdSession;
import com.iab.omid.library.inmobi.adsession.AdSessionConfiguration;
import com.iab.omid.library.inmobi.adsession.AdSessionContext;
import com.iab.omid.library.inmobi.adsession.ErrorType;
import com.iab.omid.library.inmobi.adsession.Owner;
import com.iab.omid.library.inmobi.adsession.video.InteractionType;
import com.iab.omid.library.inmobi.adsession.video.PlayerState;
import com.iab.omid.library.inmobi.adsession.video.VastProperties;
import com.iab.omid.library.inmobi.adsession.video.VideoEvents;

/* renamed from: com.inmobi.media.dm */
/* compiled from: OmidAdSessionManagerImpl */
public final class C2337dm implements C2336dl {

    /* renamed from: a */
    String f4949a;

    /* renamed from: b */
    int f4950b;

    /* renamed from: c */
    private AdSessionContext f4951c;

    /* renamed from: d */
    private final boolean f4952d;

    /* renamed from: e */
    private AdSession f4953e;

    /* renamed from: f */
    private C2335dk f4954f;

    public C2337dm(String str, @Nullable AdSessionContext adSessionContext) {
        this(str, adSessionContext, false);
    }

    public C2337dm(String str, @Nullable AdSessionContext adSessionContext, boolean z) {
        this.f4950b = 0;
        this.f4949a = str;
        this.f4951c = adSessionContext;
        this.f4952d = z;
    }

    /* renamed from: a */
    private static boolean m4836a(int i, int i2) {
        if (i == i2) {
            return true;
        }
        C2463fd a = C2463fd.m5161a();
        StringBuilder sb = new StringBuilder("Omid AdSession State Error currentState :: ");
        sb.append(i);
        sb.append(", expectedState :: ");
        sb.append(i2);
        a.mo28382a(new C2495fz(new Exception(sb.toString())));
        return false;
    }

    /* renamed from: a */
    public final void mo28192a(int i, int i2, float f, VastProperties vastProperties) {
        if (m4836a(this.f4950b, 2)) {
            if (i == 0) {
                this.f4954f.mo28189a();
            } else if (i == 17) {
                ErrorType errorType = ErrorType.VIDEO;
                if (m4836a(this.f4950b, 2)) {
                    this.f4953e.error(errorType, "Unknown Player error");
                }
            }
            C2335dk dkVar = this.f4954f;
            if (dkVar.f4947a != null) {
                switch (i) {
                    case 1:
                        dkVar.f4947a.playerStateChange(PlayerState.FULLSCREEN);
                        break;
                    case 2:
                        dkVar.f4947a.playerStateChange(PlayerState.NORMAL);
                        return;
                    case 4:
                        dkVar.f4947a.adUserInteraction(InteractionType.CLICK);
                        return;
                    case 5:
                        dkVar.f4947a.loaded(vastProperties);
                        return;
                    case 6:
                        dkVar.f4947a.start((float) i2, f);
                        return;
                    case 7:
                        dkVar.f4947a.pause();
                        return;
                    case 8:
                        dkVar.f4947a.resume();
                        return;
                    case 9:
                        dkVar.f4947a.firstQuartile();
                        return;
                    case 10:
                        dkVar.f4947a.midpoint();
                        return;
                    case 11:
                        dkVar.f4947a.thirdQuartile();
                        return;
                    case 12:
                        dkVar.f4947a.complete();
                        return;
                    case 13:
                    case 14:
                        VideoEvents videoEvents = dkVar.f4947a;
                        if (13 == i) {
                            f = 0.0f;
                        }
                        videoEvents.volumeChange(f);
                        return;
                    case 15:
                        dkVar.f4947a.skipped();
                        return;
                    case 16:
                        dkVar.f4947a.resume();
                        break;
                    case 18:
                        dkVar.f4947a.adUserInteraction(InteractionType.INVITATION_ACCEPTED);
                        return;
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo28191a(int i) {
        if (m4836a(this.f4950b, 2) && i == 0) {
            this.f4954f.mo28189a();
        }
    }

    /* renamed from: a */
    private void m4834a(View view) {
        if (m4836a(this.f4950b, 1)) {
            this.f4953e.addFriendlyObstruction(view);
        }
    }

    /* renamed from: a */
    public final void mo28190a() {
        if (m4836a(this.f4950b, 2)) {
            this.f4953e.finish();
            this.f4953e = null;
            this.f4950b = 3;
        }
    }

    /* renamed from: a */
    public final void mo28194a(@Nullable AdSessionContext adSessionContext) {
        if (adSessionContext != null) {
            this.f4951c = adSessionContext;
        }
    }

    /* renamed from: a */
    private void m4835a(View view, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (!childAt.equals(view)) {
                m4834a(childAt);
                if (childAt instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) childAt;
                    if (viewGroup2.getChildCount() > 0) {
                        m4835a(view, viewGroup2);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo28193a(View view, @Nullable View[] viewArr, @Nullable View view2) {
        if (this.f4953e == null) {
            boolean z = this.f4952d;
            Owner owner = Owner.JAVASCRIPT;
            String str = this.f4949a;
            char c = 65535;
            switch (str.hashCode()) {
                case -2139264536:
                    if (str.equals("native_display_ad")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1329992236:
                    if (str.equals("html_display_ad")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1191784049:
                    if (str.equals("native_video_ad")) {
                        c = 0;
                        break;
                    }
                    break;
                case 538665083:
                    if (str.equals("html_video_ad")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            Owner owner2 = null;
            if (c == 0) {
                owner = Owner.NATIVE;
                owner2 = Owner.NATIVE;
            } else if (c == 1) {
                owner = Owner.NATIVE;
            } else if (c == 2) {
                owner = Owner.JAVASCRIPT;
                owner2 = Owner.JAVASCRIPT;
            } else if (c == 3) {
                owner = Owner.JAVASCRIPT;
            }
            this.f4953e = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(owner, owner2, z), this.f4951c);
            this.f4954f = new C2335dk(this.f4953e, this.f4949a);
            this.f4950b = 1;
        }
        if (m4836a(this.f4950b, 1)) {
            this.f4953e.registerAdView(view);
        }
        if (viewArr != null) {
            for (View a : viewArr) {
                m4834a(a);
            }
        }
        if (!(view2 == null || view == null || !(view2 instanceof ViewGroup))) {
            m4835a(view, (ViewGroup) view2);
        }
        if (m4836a(this.f4950b, 1)) {
            this.f4953e.start();
            this.f4950b = 2;
        }
    }
}
