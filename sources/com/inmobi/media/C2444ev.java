package com.inmobi.media;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.inmobi.media.C2447ex.C2448a;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.inmobi.media.ev */
/* compiled from: ConfigNetworkClient */
class C2444ev implements Runnable {

    /* renamed from: a */
    private static final String f5260a = "ev";

    /* renamed from: b */
    private C2446ew f5261b;

    /* renamed from: c */
    private C2445a f5262c;

    /* renamed from: d */
    private final C2446ew f5263d;

    /* renamed from: com.inmobi.media.ev$a */
    /* compiled from: ConfigNetworkClient */
    public interface C2445a {
        /* renamed from: a */
        void mo28347a(C2448a aVar);

        /* renamed from: a */
        void mo28348a(String str);
    }

    C2444ev(C2445a aVar, C2446ew ewVar, C2446ew ewVar2) {
        this.f5262c = aVar;
        this.f5261b = ewVar;
        this.f5263d = ewVar2;
    }

    /* renamed from: a */
    private void m5108a(C2446ew ewVar, Map<String, C2448a> map) {
        for (Entry entry : map.entrySet()) {
            C2448a aVar = (C2448a) entry.getValue();
            String str = (String) entry.getKey();
            if (!aVar.mo28355a()) {
                this.f5262c.mo28347a(aVar);
                ewVar.f5269c.remove(str);
            }
        }
    }

    @NonNull
    /* renamed from: a */
    private static C2447ex m5107a(C2446ew ewVar) {
        return new C2447ex(ewVar, new C2488ft(ewVar).mo28422a(), SystemClock.elapsedRealtime() - SystemClock.elapsedRealtime());
    }

    /* renamed from: a */
    private boolean m5109a(C2446ew ewVar, int i, Map<String, C2448a> map) throws InterruptedException {
        if (i > ewVar.f5267a) {
            for (Entry key : ewVar.f5269c.entrySet()) {
                String str = (String) key.getKey();
                if (map.containsKey(str)) {
                    this.f5262c.mo28347a((C2448a) map.get(str));
                }
            }
            return true;
        }
        Thread.sleep((long) (ewVar.f5268b * 1000));
        return false;
    }

    public void run() {
        Map<String, C2448a> map;
        int i = 0;
        int i2 = 0;
        do {
            try {
                if (i2 > this.f5261b.f5267a) {
                    break;
                }
                C2447ex a = m5107a(this.f5261b);
                map = a.f5271a;
                if (!(a.mo28354a() && this.f5263d != null)) {
                    m5108a(this.f5261b, map);
                    if (this.f5261b.f5269c.isEmpty()) {
                        break;
                    }
                    i2++;
                } else {
                    while (i <= this.f5263d.f5267a) {
                        C2447ex a2 = m5107a(this.f5263d);
                        Map<String, C2448a> map2 = a2.f5271a;
                        if (a2.mo28354a()) {
                            break;
                        }
                        m5108a(this.f5263d, map2);
                        if (this.f5263d.f5269c.isEmpty()) {
                            break;
                        }
                        i++;
                        if (m5109a(this.f5263d, i, map2)) {
                            break;
                        }
                    }
                    this.f5262c.mo28348a(this.f5263d.mo28353c());
                    return;
                }
            } catch (InterruptedException unused) {
            }
        } while (!m5109a(this.f5261b, i2, map));
        this.f5262c.mo28348a(this.f5261b.mo28353c());
    }
}
