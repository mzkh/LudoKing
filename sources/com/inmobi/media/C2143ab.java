package com.inmobi.media;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.media.C2620l.C2636a;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.ab */
/* compiled from: UnifiedAdManager */
public abstract class C2143ab extends C2636a {
    @VisibleForTesting(otherwise = 3)

    /* renamed from: a */
    public static final String f4298a = "An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad for placement id: ";

    /* renamed from: b */
    public static final String f4299b = "Ad show is already called. Please wait for the the ad to be shown.";

    /* renamed from: f */
    private static final String f4300f = "ab";

    /* renamed from: c */
    int f4301c = 0;
    @NonNull

    /* renamed from: d */
    final C2674z f4302d;
    @NonNull

    /* renamed from: e */
    final Handler f4303e;

    @Nullable
    /* renamed from: p */
    public abstract C2620l mo27795p();

    C2143ab(@NonNull C2674z zVar) {
        this.f4302d = zVar;
        this.f4303e = new Handler(Looper.getMainLooper());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo27789c(C2620l lVar, final InMobiAdRequestStatus inMobiAdRequestStatus) {
        this.f4301c = 3;
        if (lVar != null) {
            lVar.mo28763c(1);
        }
        this.f4303e.post(new Runnable() {
            public final void run() {
                C2143ab.this.f4302d.mo27686a(inMobiAdRequestStatus);
            }
        });
    }

    /* renamed from: d */
    public final void mo27791d() {
        int i = this.f4301c;
        if (i != 4 && i != 5) {
            this.f4303e.post(new Runnable() {
                public final void run() {
                    C2143ab.this.f4302d.mo27707f();
                }
            });
            this.f4301c = 4;
        }
    }

    /* renamed from: e */
    public final void mo27792e() {
        if (this.f4301c != 5) {
            this.f4303e.post(new Runnable() {
                public final void run() {
                    C2143ab.this.f4302d.mo27689b();
                }
            });
            this.f4301c = 5;
        }
    }

    /* renamed from: a */
    public void mo27778a(@Nullable C2620l lVar, InMobiAdRequestStatus inMobiAdRequestStatus) {
        if (!mo27790c(inMobiAdRequestStatus) || lVar == null) {
            mo27789c(lVar, inMobiAdRequestStatus);
        } else {
            lVar.mo28742a(inMobiAdRequestStatus);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo27790c(@Nullable InMobiAdRequestStatus inMobiAdRequestStatus) {
        return inMobiAdRequestStatus == null || StatusCode.INTERNAL_ERROR == inMobiAdRequestStatus.getStatusCode() || StatusCode.AD_NO_LONGER_AVAILABLE == inMobiAdRequestStatus.getStatusCode();
    }

    /* renamed from: a */
    public void mo27780a(@NonNull final Map<Object, Object> map) {
        this.f4303e.post(new Runnable() {
            public final void run() {
                C2143ab.this.f4302d.mo27687a(map);
            }
        });
    }

    /* renamed from: H */
    public void mo27775H() {
        C2620l p = mo27795p();
        if (p != null) {
            p.mo28789x();
        }
    }

    /* renamed from: a */
    public final void mo27779a(@NonNull C2620l lVar, boolean z, @NonNull InMobiAdRequestStatus inMobiAdRequestStatus) {
        if (z) {
            lVar.mo28736P();
        } else {
            lVar.mo28722B();
        }
        mo27786b(lVar, z, inMobiAdRequestStatus);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo27786b(@NonNull C2620l lVar, boolean z, InMobiAdRequestStatus inMobiAdRequestStatus) {
        if (!z) {
            mo27789c(lVar, inMobiAdRequestStatus);
        }
    }

    @NonNull
    /* renamed from: u */
    public String mo27796u() {
        return mo27795p() == null ? "" : mo27795p().mo28778m();
    }

    /* renamed from: b */
    public void mo27788b(byte[] bArr) {
        C2620l p = mo27795p();
        if (p != null) {
            p.mo28755a(bArr);
        }
    }

    /* renamed from: v */
    public JSONObject mo27797v() {
        return mo27795p() == null ? new JSONObject() : mo27795p().mo28784s();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: I */
    public void mo27776I() {
        C2620l p = mo27795p();
        if (p != null) {
            p.mo28758b(4);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: J */
    public void mo27777J() {
        C2620l p = mo27795p();
        if (p != null) {
            p.mo28763c(4);
        }
    }

    /* renamed from: b */
    public void mo27783b() {
        C2620l p = mo27795p();
        if (p != null) {
            p.mo28763c(1);
        }
    }

    /* renamed from: b */
    public void mo27785b(C2620l lVar, InMobiAdRequestStatus inMobiAdRequestStatus) {
        mo27789c(lVar, inMobiAdRequestStatus);
    }

    /* renamed from: g */
    public void mo27794g() {
        this.f4303e.post(new Runnable() {
            public final void run() {
                C2143ab.this.f4302d.mo27693d();
            }
        });
    }

    /* renamed from: b */
    public void mo27787b(@NonNull final Map<Object, Object> map) {
        this.f4303e.post(new Runnable() {
            public final void run() {
                C2143ab.this.f4302d.mo27691b(map);
            }
        });
    }

    /* renamed from: a */
    public void mo27781a(final byte[] bArr) {
        this.f4303e.post(new Runnable() {
            public final void run() {
                C2143ab.this.f4302d.mo27688a(bArr);
            }
        });
    }

    /* renamed from: b */
    public void mo27784b(final InMobiAdRequestStatus inMobiAdRequestStatus) {
        this.f4303e.post(new Runnable() {
            public final void run() {
                C2143ab.this.f4302d.mo27690b(inMobiAdRequestStatus);
            }
        });
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"SwitchIntDef"})
    /* renamed from: a */
    public boolean mo27782a(@NonNull String str, @NonNull String str2) {
        int i = this.f4301c;
        if (i == 1) {
            C2514gh.m5342a(1, str, "An ad load is already in progress. Please wait for the load to complete before requesting for another ad for placement id: ".concat(String.valueOf(str2)));
            return false;
        } else if (i != 5) {
            return true;
        } else {
            C2514gh.m5342a(1, str, f4298a.concat(String.valueOf(str2)));
            mo27789c(mo27795p(), new InMobiAdRequestStatus(StatusCode.AD_ACTIVE));
            return false;
        }
    }

    /* renamed from: f */
    public void mo27793f() {
        this.f4303e.post(new Runnable() {
            public final void run() {
                C2143ab.this.f4302d.mo27692c();
            }
        });
    }
}
