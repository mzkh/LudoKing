package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import com.unity3d.player.C3358o.C3359a;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.unity3d.player.p */
final class C3361p {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public UnityPlayer f8069a = null;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f8070b = null;

    /* renamed from: c */
    private C3368a f8071c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Semaphore f8072d = new Semaphore(0);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Lock f8073e = new ReentrantLock();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C3358o f8074f = null;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f8075g = 2;

    /* renamed from: h */
    private boolean f8076h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f8077i = false;

    /* renamed from: com.unity3d.player.p$a */
    public interface C3368a {
        /* renamed from: a */
        void mo30655a();
    }

    C3361p(UnityPlayer unityPlayer) {
        this.f8069a = unityPlayer;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m7781d() {
        C3358o oVar = this.f8074f;
        if (oVar != null) {
            this.f8069a.removeViewFromPlayer(oVar);
            this.f8077i = false;
            this.f8074f.destroyPlayer();
            this.f8074f = null;
            C3368a aVar = this.f8071c;
            if (aVar != null) {
                aVar.mo30655a();
            }
        }
    }

    /* renamed from: a */
    public final void mo30779a() {
        this.f8073e.lock();
        C3358o oVar = this.f8074f;
        if (oVar != null) {
            if (this.f8075g == 0) {
                oVar.CancelOnPrepare();
            } else if (this.f8077i) {
                this.f8076h = oVar.mo30753a();
                if (!this.f8076h) {
                    this.f8074f.pause();
                }
            }
        }
        this.f8073e.unlock();
    }

    /* renamed from: a */
    public final boolean mo30780a(Context context, String str, int i, int i2, int i3, boolean z, long j, long j2, C3368a aVar) {
        this.f8073e.lock();
        this.f8071c = aVar;
        this.f8070b = context;
        this.f8072d.drainPermits();
        this.f8075g = 2;
        final String str2 = str;
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        final boolean z2 = z;
        final long j3 = j;
        final long j4 = j2;
        C33621 r0 = new Runnable() {
            public final void run() {
                if (C3361p.this.f8074f != null) {
                    C3342f.Log(5, "Video already playing");
                    C3361p.this.f8075g = 2;
                    C3361p.this.f8072d.release();
                    return;
                }
                C3361p pVar = C3361p.this;
                C3358o oVar = new C3358o(pVar.f8070b, str2, i4, i5, i6, z2, j3, j4, new C3359a() {
                    /* renamed from: a */
                    public final void mo30776a(int i) {
                        C3361p.this.f8073e.lock();
                        C3361p.this.f8075g = i;
                        if (i == 3 && C3361p.this.f8077i) {
                            C3361p.this.runOnUiThread(new Runnable() {
                                public final void run() {
                                    C3361p.this.m7781d();
                                    C3361p.this.f8069a.resume();
                                }
                            });
                        }
                        if (i != 0) {
                            C3361p.this.f8072d.release();
                        }
                        C3361p.this.f8073e.unlock();
                    }
                });
                pVar.f8074f = oVar;
                if (C3361p.this.f8074f != null) {
                    C3361p.this.f8069a.addView(C3361p.this.f8074f);
                }
            }
        };
        runOnUiThread(r0);
        boolean z3 = false;
        try {
            this.f8073e.unlock();
            this.f8072d.acquire();
            this.f8073e.lock();
            if (this.f8075g != 2) {
                z3 = true;
            }
        } catch (InterruptedException unused) {
        }
        runOnUiThread(new Runnable() {
            public final void run() {
                C3361p.this.f8069a.pause();
            }
        });
        runOnUiThread((!z3 || this.f8075g == 3) ? new Runnable() {
            public final void run() {
                C3361p.this.m7781d();
                C3361p.this.f8069a.resume();
            }
        } : new Runnable() {
            public final void run() {
                if (C3361p.this.f8074f != null) {
                    C3361p.this.f8069a.addViewToPlayer(C3361p.this.f8074f, true);
                    C3361p.this.f8077i = true;
                    C3361p.this.f8074f.requestFocus();
                }
            }
        });
        this.f8073e.unlock();
        return z3;
    }

    /* renamed from: b */
    public final void mo30781b() {
        this.f8073e.lock();
        C3358o oVar = this.f8074f;
        if (oVar != null && this.f8077i && !this.f8076h) {
            oVar.start();
        }
        this.f8073e.unlock();
    }

    /* renamed from: c */
    public final void mo30782c() {
        this.f8073e.lock();
        C3358o oVar = this.f8074f;
        if (oVar != null) {
            oVar.updateVideoLayout();
        }
        this.f8073e.unlock();
    }

    /* access modifiers changed from: protected */
    public final void runOnUiThread(Runnable runnable) {
        Context context = this.f8070b;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(runnable);
        } else {
            C3342f.Log(5, "Not running from an Activity; Ignoring execution request...");
        }
    }
}
