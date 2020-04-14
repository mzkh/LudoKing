package com.tapjoy;

import com.tapjoy.internal.C1829gl;
import com.tapjoy.internal.C1831gz;
import com.tapjoy.internal.C2888az;
import com.tapjoy.internal.C3109gm;
import com.tapjoy.internal.C3111go;
import com.tapjoy.internal.C3128ha;

public class FiveRocksIntegration {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static C2888az f6214a = new C2888az();

    public static void addPlacementCallback(String str, TJPlacement tJPlacement) {
        synchronized (f6214a) {
            f6214a.put(str, tJPlacement);
        }
    }

    /* renamed from: a */
    public static void m6416a() {
        C1831gz a = C1831gz.m3554a();
        if (!a.f3819c) {
            a.f3819c = true;
        }
        C27871 r0 = new C3111go() {
            /* renamed from: a */
            public final void mo29403a(String str) {
            }

            /* renamed from: d */
            public final void mo29408d(String str) {
            }

            /* renamed from: b */
            public final void mo29406b(String str) {
                TJPlacement tJPlacement;
                synchronized (FiveRocksIntegration.f6214a) {
                    tJPlacement = (TJPlacement) FiveRocksIntegration.f6214a.get(str);
                }
                if (tJPlacement != null && tJPlacement.f6372a != null) {
                    tJPlacement.f6372a.onContentReady(tJPlacement);
                }
            }

            /* renamed from: c */
            public final void mo29407c(String str) {
                TJPlacement tJPlacement;
                synchronized (FiveRocksIntegration.f6214a) {
                    tJPlacement = (TJPlacement) FiveRocksIntegration.f6214a.get(str);
                }
                if (tJPlacement != null && tJPlacement.f6372a != null) {
                    tJPlacement.f6372a.onContentShow(tJPlacement);
                }
            }

            /* renamed from: a */
            public final void mo29404a(String str, C1829gl glVar) {
                if (glVar != null) {
                    glVar.mo18112a(m6418e(str));
                }
            }

            /* renamed from: a */
            public final void mo29405a(String str, String str2, C1829gl glVar) {
                TJPlacement tJPlacement;
                if (glVar != null) {
                    glVar.mo18112a(m6418e(str));
                }
                synchronized (FiveRocksIntegration.f6214a) {
                    tJPlacement = (TJPlacement) FiveRocksIntegration.f6214a.get(str);
                }
                if (tJPlacement != null) {
                    TapjoyConnectCore.viewDidClose(str2);
                    if (tJPlacement.f6372a != null) {
                        tJPlacement.f6372a.onContentDismiss(tJPlacement);
                    }
                }
            }

            /* renamed from: e */
            private C3109gm m6418e(final String str) {
                return new C3109gm() {
                    /* renamed from: a */
                    public final void mo29409a(final String str, String str2) {
                        TJPlacement tJPlacement;
                        synchronized (FiveRocksIntegration.f6214a) {
                            tJPlacement = (TJPlacement) FiveRocksIntegration.f6214a.get(str);
                        }
                        if (tJPlacement != null && tJPlacement.f6372a != null) {
                            tJPlacement.f6372a.onPurchaseRequest(tJPlacement, new TJActionRequest() {
                                public final void cancelled() {
                                }

                                public final void completed() {
                                }

                                public final String getToken() {
                                    return null;
                                }

                                public final String getRequestId() {
                                    return str;
                                }
                            }, str2);
                        }
                    }

                    /* renamed from: a */
                    public final void mo29410a(final String str, String str2, int i, final String str3) {
                        TJPlacement tJPlacement;
                        synchronized (FiveRocksIntegration.f6214a) {
                            tJPlacement = (TJPlacement) FiveRocksIntegration.f6214a.get(str);
                        }
                        if (tJPlacement != null && tJPlacement.f6372a != null) {
                            tJPlacement.f6372a.onRewardRequest(tJPlacement, new TJActionRequest() {
                                public final void cancelled() {
                                }

                                public final void completed() {
                                }

                                public final String getRequestId() {
                                    return str;
                                }

                                public final String getToken() {
                                    return str3;
                                }
                            }, str2, i);
                        }
                    }
                };
            }
        };
        C1831gz.m3554a().f3832p = C3128ha.m7230a((C3111go) r0);
    }
}
