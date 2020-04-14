package com.inmobi.media;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.share.internal.ShareConstants;
import com.tapjoy.TJAdUnitConstants.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.bp */
/* compiled from: NativeVideoAsset */
public final class C2235bp extends C2214bc {

    /* renamed from: A */
    public boolean f4634A;

    /* renamed from: B */
    public boolean f4635B;

    /* renamed from: C */
    public boolean f4636C;

    /* renamed from: D */
    public boolean f4637D;

    /* renamed from: E */
    public int f4638E;

    /* renamed from: F */
    public int f4639F;

    /* renamed from: G */
    public Map<String, Object> f4640G;

    /* renamed from: H */
    private boolean f4641H;

    /* renamed from: z */
    List<C2214bc> f4642z;

    /* renamed from: com.inmobi.media.bp$a */
    /* compiled from: NativeVideoAsset */
    static class C2236a extends C2215bd {
        public C2236a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, @Nullable C2228bl blVar) {
            super(i, i2, i3, i4, i5, i6, i7, i8, "none", "straight", "#ff000000", "#00000000", blVar);
        }
    }

    public C2235bp(String str, String str2, C2215bd bdVar, C2297cr crVar, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, List<C2234bo> list, JSONObject jSONObject, boolean z6) {
        super(str, str2, ShareConstants.VIDEO_URL, bdVar);
        this.f4525e = crVar;
        this.f4529i = 2;
        this.f4634A = z;
        this.f4635B = z2;
        this.f4636C = z3;
        this.f4637D = z4;
        this.f4642z = new ArrayList();
        this.f4641H = z6;
        if (crVar != null) {
            this.f4538r = crVar.mo28135a();
            List<C2234bo> d = crVar.mo28140d();
            Map<String, String> map = null;
            String str3 = "OMID_VIEWABILITY";
            if (list != null) {
                for (C2234bo boVar : list) {
                    if (str3.equals(boVar.f4631d)) {
                        map = boVar.f4632e;
                        if (!TextUtils.isEmpty(boVar.f4629b)) {
                            d.add(boVar);
                        }
                    } else {
                        d.add(boVar);
                    }
                }
            }
            for (C2234bo boVar2 : d) {
                if (str3.equals(boVar2.f4631d)) {
                    boVar2.f4632e = map;
                }
            }
            if (!d.isEmpty()) {
                mo27941a(d);
            }
        }
        if (jSONObject != null) {
            this.f4526f = jSONObject;
        }
        this.f4542v.put("placementType", Integer.valueOf(0));
        this.f4542v.put("lastVisibleTimestamp", Integer.valueOf(Integer.MIN_VALUE));
        this.f4542v.put(String.VISIBLE, Boolean.FALSE);
        this.f4542v.put("seekPosition", Integer.valueOf(0));
        this.f4542v.put("didStartPlaying", Boolean.FALSE);
        this.f4542v.put("didPause", Boolean.FALSE);
        this.f4542v.put("didCompleteQ1", Boolean.FALSE);
        this.f4542v.put("didCompleteQ2", Boolean.FALSE);
        this.f4542v.put("didCompleteQ3", Boolean.FALSE);
        this.f4542v.put("didCompleteQ4", Boolean.FALSE);
        this.f4542v.put("didRequestFullScreen", Boolean.FALSE);
        this.f4542v.put("isFullScreen", Boolean.FALSE);
        this.f4542v.put("didImpressionFire", Boolean.FALSE);
        this.f4542v.put("mapViewabilityParams", new HashMap());
        this.f4542v.put("didSignalVideoCompleted", Boolean.FALSE);
        this.f4542v.put("shouldAutoPlay", Boolean.valueOf(z5));
        this.f4542v.put("lastMediaVolume", Integer.valueOf(0));
        this.f4542v.put("currentMediaVolume", Integer.valueOf(0));
        this.f4542v.put("didQ4Fire", Boolean.FALSE);
    }

    /* renamed from: a */
    public final boolean mo27981a() {
        if (this.f4641H) {
            return this.f4634A && !C2505gd.m5305e();
        }
        return this.f4634A;
    }

    /* renamed from: a */
    public final void mo27980a(C2235bp bpVar) {
        this.f4542v.putAll(bpVar.f4542v);
        this.f4640G.putAll(bpVar.f4640G);
        this.f4541u = bpVar.f4541u;
    }

    /* renamed from: b */
    public final C2297cr mo27982b() {
        if (this.f4525e == null) {
            return null;
        }
        return (C2297cr) this.f4525e;
    }
}
