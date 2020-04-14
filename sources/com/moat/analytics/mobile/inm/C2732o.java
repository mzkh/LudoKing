package com.moat.analytics.mobile.inm;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.moat.analytics.mobile.inm.o */
class C2732o implements LocationListener {

    /* renamed from: a */
    private static C2732o f6125a;

    /* renamed from: b */
    private ScheduledExecutorService f6126b;

    /* renamed from: c */
    private ScheduledFuture<?> f6127c;

    /* renamed from: d */
    private ScheduledFuture<?> f6128d;

    /* renamed from: e */
    private LocationManager f6129e;

    /* renamed from: f */
    private boolean f6130f;

    /* renamed from: g */
    private Location f6131g;

    /* renamed from: h */
    private boolean f6132h;

    private C2732o() {
        try {
            this.f6130f = ((C2724k) MoatAnalytics.getInstance()).f6102c;
            String str = "LocationManager";
            if (this.f6130f) {
                C2735p.m6310a(3, str, (Object) this, "Moat location services disabled");
                return;
            }
            this.f6126b = Executors.newScheduledThreadPool(1);
            this.f6129e = (LocationManager) C2695a.m6141a().getSystemService(Param.LOCATION);
            if (this.f6129e.getAllProviders().size() == 0) {
                C2735p.m6310a(3, str, (Object) this, "Device has no location providers");
            } else {
                m6295e();
            }
        } catch (Exception e) {
            C2726m.m6274a(e);
        }
    }

    /* renamed from: a */
    static C2732o m6286a() {
        if (f6125a == null) {
            f6125a = new C2732o();
        }
        return f6125a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6289a(boolean z) {
        try {
            C2735p.m6310a(3, "LocationManager", (Object) this, "stopping location fetch");
            m6298h();
            m6299i();
            if (z) {
                m6301k();
            } else {
                m6300j();
            }
        } catch (Exception e) {
            C2726m.m6274a(e);
        }
    }

    /* renamed from: a */
    private static boolean m6290a(Location location) {
        if (location == null) {
            return false;
        }
        return !(location.getLatitude() == 0.0d && location.getLongitude() == 0.0d) && location.getAccuracy() >= 0.0f && m6293b(location) < 600.0f;
    }

    /* renamed from: a */
    static boolean m6291a(Location location, Location location2) {
        if (location == location2) {
            return true;
        }
        return (location == null || location2 == null || location.getTime() != location2.getTime()) ? false : true;
    }

    /* renamed from: a */
    private static boolean m6292a(String str) {
        return ContextCompat.checkSelfPermission(C2695a.m6141a().getApplicationContext(), str) == 0;
    }

    /* renamed from: b */
    private static float m6293b(Location location) {
        return (float) ((System.currentTimeMillis() - location.getTime()) / 1000);
    }

    /* renamed from: b */
    private static Location m6294b(Location location, Location location2) {
        boolean a = m6290a(location);
        boolean a2 = m6290a(location2);
        if (a) {
            return (a2 && location.getAccuracy() >= location.getAccuracy()) ? location2 : location;
        }
        if (!a2) {
            return null;
        }
        return location2;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m6295e() {
        try {
            if (!this.f6130f) {
                if (this.f6129e != null) {
                    String str = "LocationManager";
                    if (this.f6132h) {
                        C2735p.m6310a(3, str, (Object) this, "already updating location");
                    }
                    C2735p.m6310a(3, str, (Object) this, "starting location fetch");
                    this.f6131g = m6294b(this.f6131g, m6296f());
                    if (this.f6131g != null) {
                        StringBuilder sb = new StringBuilder("Have a valid location, won't fetch = ");
                        sb.append(this.f6131g.toString());
                        C2735p.m6310a(3, str, (Object) this, sb.toString());
                        m6301k();
                        return;
                    }
                    m6297g();
                }
            }
        } catch (Exception e) {
            C2726m.m6274a(e);
        }
    }

    /* renamed from: f */
    private Location m6296f() {
        try {
            boolean l = m6302l();
            boolean m = m6303m();
            String str = "network";
            String str2 = "gps";
            if (l && m) {
                return m6294b(this.f6129e.getLastKnownLocation(str2), this.f6129e.getLastKnownLocation(str));
            }
            if (l) {
                return this.f6129e.getLastKnownLocation(str2);
            }
            if (m) {
                return this.f6129e.getLastKnownLocation(str);
            }
            return null;
        } catch (SecurityException e) {
            C2726m.m6274a(e);
            return null;
        }
    }

    /* renamed from: g */
    private void m6297g() {
        String str = "LocationManager";
        try {
            if (!this.f6132h) {
                C2735p.m6310a(3, str, (Object) this, "Attempting to start update");
                if (m6302l()) {
                    C2735p.m6310a(3, str, (Object) this, "start updating gps location");
                    this.f6129e.requestLocationUpdates("gps", 0, 0.0f, this, Looper.getMainLooper());
                    this.f6132h = true;
                }
                if (m6303m()) {
                    C2735p.m6310a(3, str, (Object) this, "start updating network location");
                    this.f6129e.requestLocationUpdates("network", 0, 0.0f, this, Looper.getMainLooper());
                    this.f6132h = true;
                }
                if (this.f6132h) {
                    m6299i();
                    this.f6128d = this.f6126b.schedule(new Runnable() {
                        public void run() {
                            try {
                                C2735p.m6310a(3, "LocationManager", (Object) this, "fetchTimedOut");
                                C2732o.this.m6289a(true);
                            } catch (Exception e) {
                                C2726m.m6274a(e);
                            }
                        }
                    }, 60, TimeUnit.SECONDS);
                }
            }
        } catch (SecurityException e) {
            C2726m.m6274a(e);
        }
    }

    /* renamed from: h */
    private void m6298h() {
        try {
            C2735p.m6310a(3, "LocationManager", (Object) this, "Stopping to update location");
            if (m6304n() && this.f6129e != null) {
                this.f6129e.removeUpdates(this);
                this.f6132h = false;
            }
        } catch (SecurityException e) {
            C2726m.m6274a(e);
        }
    }

    /* renamed from: i */
    private void m6299i() {
        ScheduledFuture<?> scheduledFuture = this.f6128d;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.f6128d.cancel(true);
            this.f6128d = null;
        }
    }

    /* renamed from: j */
    private void m6300j() {
        ScheduledFuture<?> scheduledFuture = this.f6127c;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.f6127c.cancel(true);
            this.f6127c = null;
        }
    }

    /* renamed from: k */
    private void m6301k() {
        C2735p.m6310a(3, "LocationManager", (Object) this, "Resetting fetch timer");
        m6300j();
        Location location = this.f6131g;
        float f = 600.0f;
        if (location != null) {
            f = Math.max(600.0f - m6293b(location), 0.0f);
        }
        this.f6127c = this.f6126b.schedule(new Runnable() {
            public void run() {
                try {
                    C2735p.m6310a(3, "LocationManager", (Object) this, "fetchTimerCompleted");
                    C2732o.this.m6295e();
                } catch (Exception e) {
                    C2726m.m6274a(e);
                }
            }
        }, (long) f, TimeUnit.SECONDS);
    }

    /* renamed from: l */
    private boolean m6302l() {
        if (m6292a("android.permission.ACCESS_FINE_LOCATION")) {
            String str = "gps";
            if (this.f6129e.getProvider(str) != null && this.f6129e.isProviderEnabled(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: m */
    private boolean m6303m() {
        if (m6304n()) {
            String str = "network";
            if (this.f6129e.getProvider(str) != null && this.f6129e.isProviderEnabled(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: n */
    private static boolean m6304n() {
        return m6292a("android.permission.ACCESS_FINE_LOCATION") || m6292a("android.permission.ACCESS_COARSE_LOCATION");
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    /* renamed from: b */
    public Location mo29073b() {
        if (this.f6130f || this.f6129e == null) {
            return null;
        }
        return this.f6131g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo29074c() {
        m6295e();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo29075d() {
        m6289a(false);
    }

    public void onLocationChanged(Location location) {
        String str = "LocationManager";
        try {
            StringBuilder sb = new StringBuilder("Received an updated location = ");
            sb.append(location.toString());
            C2735p.m6310a(3, str, (Object) this, sb.toString());
            float b = m6293b(location);
            if (location.hasAccuracy() && location.getAccuracy() <= 100.0f && b < 600.0f) {
                this.f6131g = m6294b(this.f6131g, location);
                C2735p.m6310a(3, str, (Object) this, "fetchCompleted");
                m6289a(true);
            }
        } catch (Exception e) {
            C2726m.m6274a(e);
        }
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
