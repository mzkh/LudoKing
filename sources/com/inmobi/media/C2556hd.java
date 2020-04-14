package com.inmobi.media;

import android.os.SystemClock;

/* renamed from: com.inmobi.media.hd */
/* compiled from: CarbNetworkClient */
public class C2556hd {

    /* renamed from: a */
    private static final String f5630a = "hd";

    /* renamed from: a */
    static C2554hb m5545a(C2553ha haVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C2487fs a = new C2488ft(haVar).mo28422a();
        C2554hb hbVar = new C2554hb(a);
        try {
            C2566hi.m5571a().mo28564a(haVar.mo28416i());
            C2566hi.m5571a().mo28565b(a.mo28421d());
            C2566hi.m5571a().mo28566c(SystemClock.elapsedRealtime() - elapsedRealtime);
        } catch (Exception unused) {
        }
        return hbVar;
    }

    /* renamed from: a */
    static void m5546a(C2557he heVar) {
        int i = 0;
        while (i <= heVar.f5631a) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            C2487fs a = new C2488ft(heVar).mo28422a();
            try {
                C2566hi.m5571a().mo28564a(heVar.mo28416i());
                C2566hi.m5571a().mo28565b(a.mo28421d());
                C2566hi.m5571a().mo28566c(SystemClock.elapsedRealtime() - elapsedRealtime);
            } catch (Exception unused) {
            }
            if (a.mo28417a()) {
                i++;
                if (i <= heVar.f5631a) {
                    try {
                        Thread.sleep((long) (heVar.f5632b * 1000));
                    } catch (InterruptedException unused2) {
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }
}
