package com.inmobi.media;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.HandlerThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.inmobi.media.hh */
/* compiled from: LocationInfo */
public class C2562hh implements LocationListener {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final String f5643c = "hh";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static boolean f5644e = false;
    @Nullable

    /* renamed from: a */
    LocationManager f5645a;

    /* renamed from: b */
    GoogleApiClient f5646b;

    /* renamed from: d */
    private HandlerThread f5647d;

    /* renamed from: com.inmobi.media.hh$a */
    /* compiled from: LocationInfo */
    static class C2565a {

        /* renamed from: a */
        static final C2562hh f5650a = new C2562hh(0);
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    /* synthetic */ C2562hh(byte b) {
        this();
    }

    /* renamed from: a */
    public static C2562hh m5557a() {
        return C2565a.f5650a;
    }

    private C2562hh() {
        this.f5647d = new HandlerThread("LThread");
        this.f5647d.start();
        Context c = C2505gd.m5298c();
        if (c != null) {
            this.f5645a = (LocationManager) c.getSystemService(Param.LOCATION);
        }
    }

    /* renamed from: g */
    private static boolean m5563g() {
        try {
            GoogleApiClient.class.getName();
            FusedLocationProviderClient.class.getName();
            LocationServices.class.getName();
            return false;
        } catch (NoClassDefFoundError unused) {
            return true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007a, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo28557b() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = m5561c()     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            if (r0 == 0) goto L_0x0074
            boolean r0 = r3.mo28559e()     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            if (r0 == 0) goto L_0x0074
            android.location.LocationManager r0 = r3.f5645a     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            if (r0 == 0) goto L_0x0035
            android.location.Criteria r0 = new android.location.Criteria     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            r0.<init>()     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            r1 = 2
            r0.setBearingAccuracy(r1)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            r0.setPowerRequirement(r1)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            r1 = 0
            r0.setCostAllowed(r1)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            android.location.LocationManager r1 = r3.f5645a     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            r2 = 1
            java.lang.String r0 = r1.getBestProvider(r0, r2)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            if (r0 == 0) goto L_0x0035
            android.location.LocationManager r1 = r3.f5645a     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            android.os.HandlerThread r2 = r3.f5647d     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            android.os.Looper r2 = r2.getLooper()     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            r1.requestSingleUpdate(r0, r3, r2)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
        L_0x0035:
            boolean r0 = m5563g()     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            if (r0 != 0) goto L_0x0074
            android.content.Context r0 = com.inmobi.media.C2505gd.m5298c()     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            com.google.android.gms.common.api.GoogleApiClient r1 = r3.f5646b     // Catch:{ Exception -> 0x0074, all -> 0x0076 }
            if (r1 != 0) goto L_0x006d
            com.google.android.gms.common.api.GoogleApiClient$Builder r1 = new com.google.android.gms.common.api.GoogleApiClient$Builder     // Catch:{ Exception -> 0x0074, all -> 0x0076 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0074, all -> 0x0076 }
            com.inmobi.media.hh$2 r0 = new com.inmobi.media.hh$2     // Catch:{ Exception -> 0x0074, all -> 0x0076 }
            r0.<init>()     // Catch:{ Exception -> 0x0074, all -> 0x0076 }
            com.google.android.gms.common.api.GoogleApiClient$Builder r0 = r1.addConnectionCallbacks(r0)     // Catch:{ Exception -> 0x0074, all -> 0x0076 }
            com.inmobi.media.hh$1 r1 = new com.inmobi.media.hh$1     // Catch:{ Exception -> 0x0074, all -> 0x0076 }
            r1.<init>()     // Catch:{ Exception -> 0x0074, all -> 0x0076 }
            com.google.android.gms.common.api.GoogleApiClient$Builder r0 = r0.addOnConnectionFailedListener(r1)     // Catch:{ Exception -> 0x0074, all -> 0x0076 }
            com.google.android.gms.common.api.Api<com.google.android.gms.common.api.Api$ApiOptions$NoOptions> r1 = com.google.android.gms.location.LocationServices.API     // Catch:{ Exception -> 0x0074, all -> 0x0076 }
            com.google.android.gms.common.api.GoogleApiClient$Builder r0 = r0.addApi(r1)     // Catch:{ Exception -> 0x0074, all -> 0x0076 }
            com.google.android.gms.common.api.GoogleApiClient r0 = r0.build()     // Catch:{ Exception -> 0x0074, all -> 0x0076 }
            r3.f5646b = r0     // Catch:{ Exception -> 0x0074, all -> 0x0076 }
            com.google.android.gms.common.api.GoogleApiClient r0 = r3.f5646b     // Catch:{ Exception -> 0x0074, all -> 0x0076 }
            r0.connect()     // Catch:{ Exception -> 0x0074, all -> 0x0076 }
            monitor-exit(r3)
            return
        L_0x006d:
            com.google.android.gms.common.api.GoogleApiClient r0 = r3.f5646b     // Catch:{ Exception -> 0x0074, all -> 0x0076 }
            r0.connect()     // Catch:{ Exception -> 0x0074, all -> 0x0076 }
            monitor-exit(r3)
            return
        L_0x0074:
            monitor-exit(r3)
            return
        L_0x0076:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L_0x0079:
            monitor-exit(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2562hh.mo28557b():void");
    }

    /* renamed from: c */
    public static boolean m5561c() {
        boolean z = false;
        try {
            if (!C2516gj.m5357a(C2505gd.m5298c(), "android.permission.ACCESS_FINE_LOCATION") && !C2516gj.m5357a(C2505gd.m5298c(), "android.permission.ACCESS_COARSE_LOCATION")) {
                return false;
            }
            z = true;
            return z;
        } catch (Exception unused) {
        }
    }

    public void onLocationChanged(Location location) {
        if (location != null) {
            try {
                location.getTime();
                location.getLatitude();
                location.getLongitude();
                location.getAccuracy();
            } catch (Exception e) {
                C2463fd.m5161a().mo28382a(new C2495fz(e));
                return;
            }
        }
        if (m5561c() && this.f5645a != null) {
            this.f5645a.removeUpdates(this);
        }
    }

    /* renamed from: d */
    public final synchronized HashMap<String, String> mo28558d() {
        HashMap<String, String> hashMap;
        HashMap hashMap2;
        hashMap = new HashMap<>();
        Location location = null;
        C2568hj.m5581a();
        if (C2568hj.m5585g()) {
            location = m5564h();
        }
        if (location != null) {
            hashMap2 = m5559a(location, true);
        } else {
            hashMap2 = m5559a(C2534gu.m5413b(), false);
        }
        for (Entry entry : hashMap2.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().toString());
        }
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x005d A[ADDED_TO_REGION] */
    @android.annotation.SuppressLint({"newApi"})
    @android.annotation.TargetApi(19)
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo28559e() {
        /*
            r5 = this;
            android.content.Context r0 = com.inmobi.media.C2505gd.m5298c()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 28
            r4 = 1
            if (r2 < r3) goto L_0x001b
            android.location.LocationManager r0 = r5.f5645a
            if (r0 == 0) goto L_0x001a
            boolean r0 = r0.isLocationEnabled()
            if (r0 == 0) goto L_0x001a
            return r4
        L_0x001a:
            return r1
        L_0x001b:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 19
            if (r2 < r3) goto L_0x0031
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ SettingNotFoundException -> 0x002c }
            java.lang.String r2 = "location_mode"
            int r0 = android.provider.Settings.Secure.getInt(r0, r2)     // Catch:{ SettingNotFoundException -> 0x002c }
            goto L_0x002d
        L_0x002c:
            r0 = 0
        L_0x002d:
            if (r0 == 0) goto L_0x0030
            return r4
        L_0x0030:
            return r1
        L_0x0031:
            android.location.LocationManager r2 = r5.f5645a
            if (r2 == 0) goto L_0x0062
            java.lang.String r2 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r2 = com.inmobi.media.C2516gj.m5357a(r0, r2)     // Catch:{ Exception -> 0x0059 }
            if (r2 == 0) goto L_0x0048
            android.location.LocationManager r0 = r5.f5645a     // Catch:{ Exception -> 0x0059 }
            java.lang.String r2 = "gps"
            boolean r0 = r0.isProviderEnabled(r2)     // Catch:{ Exception -> 0x0059 }
            r2 = r0
            r0 = 0
            goto L_0x005b
        L_0x0048:
            java.lang.String r2 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r0 = com.inmobi.media.C2516gj.m5357a(r0, r2)     // Catch:{ Exception -> 0x0059 }
            if (r0 == 0) goto L_0x0059
            android.location.LocationManager r0 = r5.f5645a     // Catch:{ Exception -> 0x0059 }
            java.lang.String r2 = "network"
            boolean r0 = r0.isProviderEnabled(r2)     // Catch:{ Exception -> 0x0059 }
            goto L_0x005a
        L_0x0059:
            r0 = 0
        L_0x005a:
            r2 = 0
        L_0x005b:
            if (r0 != 0) goto L_0x0061
            if (r2 == 0) goto L_0x0060
            goto L_0x0061
        L_0x0060:
            return r1
        L_0x0061:
            return r4
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2562hh.mo28559e():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0027 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0030  */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.location.Location m5564h() {
        /*
            r11 = this;
            r0 = 0
            boolean r1 = r11.mo28559e()     // Catch:{ Exception -> 0x0023 }
            if (r1 == 0) goto L_0x0020
            boolean r1 = m5561c()     // Catch:{ Exception -> 0x0023 }
            if (r1 == 0) goto L_0x0020
            boolean r1 = f5644e     // Catch:{ Exception -> 0x0023 }
            if (r1 == 0) goto L_0x0016
            android.location.Location r1 = m5566j()     // Catch:{ Exception -> 0x0023 }
            goto L_0x0017
        L_0x0016:
            r1 = r0
        L_0x0017:
            android.location.LocationManager r2 = r11.f5645a     // Catch:{ Exception -> 0x0024 }
            if (r2 == 0) goto L_0x0024
            android.location.Location r2 = r11.m5565i()     // Catch:{ Exception -> 0x0024 }
            goto L_0x0025
        L_0x0020:
            r1 = r0
            r2 = r1
            goto L_0x0025
        L_0x0023:
            r1 = r0
        L_0x0024:
            r2 = r0
        L_0x0025:
            if (r1 != 0) goto L_0x002a
            if (r2 != 0) goto L_0x002a
            return r0
        L_0x002a:
            if (r1 != 0) goto L_0x0030
            r2.getTime()
            return r2
        L_0x0030:
            if (r2 != 0) goto L_0x0036
            r1.getTime()
            return r1
        L_0x0036:
            long r3 = r1.getTime()
            long r5 = r2.getTime()
            long r3 = r3 - r5
            r5 = 120000(0x1d4c0, double:5.9288E-319)
            r0 = 1
            r7 = 0
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 <= 0) goto L_0x004a
            r5 = 1
            goto L_0x004b
        L_0x004a:
            r5 = 0
        L_0x004b:
            r8 = -120000(0xfffffffffffe2b40, double:NaN)
            int r6 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r6 >= 0) goto L_0x0054
            r6 = 1
            goto L_0x0055
        L_0x0054:
            r6 = 0
        L_0x0055:
            r8 = 0
            int r10 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x005d
            r3 = 1
            goto L_0x005e
        L_0x005d:
            r3 = 0
        L_0x005e:
            if (r5 == 0) goto L_0x0064
            r1.getTime()
            return r1
        L_0x0064:
            if (r6 == 0) goto L_0x006a
            r2.getTime()
            return r2
        L_0x006a:
            float r4 = r1.getAccuracy()
            float r5 = r2.getAccuracy()
            float r4 = r4 - r5
            int r4 = (int) r4
            if (r4 <= 0) goto L_0x0078
            r5 = 1
            goto L_0x0079
        L_0x0078:
            r5 = 0
        L_0x0079:
            if (r4 >= 0) goto L_0x007d
            r6 = 1
            goto L_0x007e
        L_0x007d:
            r6 = 0
        L_0x007e:
            r8 = 200(0xc8, float:2.8E-43)
            if (r4 <= r8) goto L_0x0083
            goto L_0x0084
        L_0x0083:
            r0 = 0
        L_0x0084:
            if (r6 != 0) goto L_0x0091
            if (r3 == 0) goto L_0x008d
            if (r5 == 0) goto L_0x0091
            if (r0 != 0) goto L_0x008d
            goto L_0x0091
        L_0x008d:
            r2.getTime()
            return r2
        L_0x0091:
            r1.getTime()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2562hh.m5564h():android.location.Location");
    }

    /* renamed from: i */
    private Location m5565i() {
        Criteria criteria = new Criteria();
        if (C2516gj.m5357a(C2505gd.m5298c(), "android.permission.ACCESS_FINE_LOCATION")) {
            criteria.setAccuracy(1);
        } else if (C2516gj.m5357a(C2505gd.m5298c(), "android.permission.ACCESS_COARSE_LOCATION")) {
            criteria.setAccuracy(2);
        }
        criteria.setCostAllowed(false);
        LocationManager locationManager = this.f5645a;
        Location location = null;
        if (locationManager == null) {
            return null;
        }
        String bestProvider = locationManager.getBestProvider(criteria, true);
        if (bestProvider == null) {
            return null;
        }
        try {
            location = this.f5645a.getLastKnownLocation(bestProvider);
        } catch (Exception unused) {
        }
        return location == null ? m5567k() : location;
    }

    /* renamed from: j */
    private static Location m5566j() {
        try {
            return (Location) LocationServices.getFusedLocationProviderClient(C2505gd.m5298c()).getLastLocation().getResult();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: k */
    private Location m5567k() {
        LocationManager locationManager = this.f5645a;
        Location location = null;
        if (locationManager != null) {
            List providers = locationManager.getProviders(true);
            for (int size = providers.size() - 1; size >= 0; size--) {
                String str = (String) providers.get(size);
                try {
                    if (this.f5645a.isProviderEnabled(str)) {
                        try {
                            location = this.f5645a.getLastKnownLocation(str);
                        } catch (SecurityException unused) {
                        }
                        if (location != null) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } catch (Exception unused2) {
                }
            }
        }
        return location;
    }

    /* renamed from: a */
    private HashMap<String, Object> m5559a(Location location, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Context c = C2505gd.m5298c();
        if (c == null) {
            return hashMap;
        }
        if (location != null) {
            if (location.getTime() > 0) {
                hashMap.put("u-ll-ts", Long.valueOf(location.getTime()));
            }
            hashMap.put("u-latlong-accu", m5558a(location));
            hashMap.put("sdk-collected", Integer.valueOf(z ? 1 : 0));
        }
        C2568hj.m5581a();
        if (C2568hj.m5585g()) {
            hashMap.put("loc-allowed", Integer.valueOf(mo28559e() ? 1 : 0));
        }
        String str = "loc-granularity";
        if (!mo28559e() || !m5561c()) {
            hashMap.put(str, "none");
        } else {
            if (C2516gj.m5357a(c, "android.permission.ACCESS_COARSE_LOCATION")) {
                hashMap.put(str, "coarse");
            }
            if (C2516gj.m5357a(c, "android.permission.ACCESS_FINE_LOCATION")) {
                hashMap.put(str, "fine");
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    private static String m5558a(Location location) {
        StringBuilder sb = new StringBuilder();
        sb.append(location.getLatitude());
        String str = ",";
        sb.append(str);
        sb.append(location.getLongitude());
        sb.append(str);
        sb.append((int) location.getAccuracy());
        return sb.toString();
    }
}
