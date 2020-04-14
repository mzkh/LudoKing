package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzgk;
import com.google.android.gms.measurement.internal.zzgn;
import com.tapjoy.TapjoyConstants;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class zzz {
    private static volatile zzz zzab = null;
    private static Boolean zzah = null;
    /* access modifiers changed from: private */
    public static Boolean zzai = null;
    private static boolean zzaj = false;
    private static Boolean zzak = null;
    @VisibleForTesting
    private static String zzal = "use_dynamite_api";
    @VisibleForTesting
    private static String zzam = "allow_remote_dynamite";
    private static boolean zzan = false;
    private static boolean zzao = false;
    protected final Clock zzac;
    private final ExecutorService zzad;
    private final AppMeasurementSdk zzae;
    /* access modifiers changed from: private */
    public List<Pair<zzgn, zzd>> zzaf;
    private int zzag;
    /* access modifiers changed from: private */
    public boolean zzap;
    private String zzaq;
    /* access modifiers changed from: private */
    public zzk zzar;
    /* access modifiers changed from: private */
    public final String zzu;

    static class zza extends zzt {
        private final zzgk zzbs;

        zza(zzgk zzgk) {
            this.zzbs = zzgk;
        }

        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            this.zzbs.interceptEvent(str, str2, bundle, j);
        }

        /* renamed from: id */
        public final int mo24243id() {
            return System.identityHashCode(this.zzbs);
        }
    }

    abstract class zzb implements Runnable {
        final long timestamp;
        final long zzbt;
        private final boolean zzbu;

        zzb(zzz zzz) {
            this(true);
        }

        /* access modifiers changed from: 0000 */
        public abstract void zzf() throws RemoteException;

        /* access modifiers changed from: protected */
        public void zzk() {
        }

        zzb(boolean z) {
            this.timestamp = zzz.this.zzac.currentTimeMillis();
            this.zzbt = zzz.this.zzac.elapsedRealtime();
            this.zzbu = z;
        }

        public void run() {
            if (zzz.this.zzap) {
                zzk();
                return;
            }
            try {
                zzf();
            } catch (Exception e) {
                zzz.this.zza(e, false, this.zzbu);
                zzk();
            }
        }
    }

    class zzc implements ActivityLifecycleCallbacks {
        zzc() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            zzz.this.zza((zzb) new zzbd(this, activity, bundle));
        }

        public final void onActivityStarted(Activity activity) {
            zzz.this.zza((zzb) new zzbc(this, activity));
        }

        public final void onActivityResumed(Activity activity) {
            zzz.this.zza((zzb) new zzbf(this, activity));
        }

        public final void onActivityPaused(Activity activity) {
            zzz.this.zza((zzb) new zzbe(this, activity));
        }

        public final void onActivityStopped(Activity activity) {
            zzz.this.zza((zzb) new zzbh(this, activity));
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            zzl zzl = new zzl();
            zzz.this.zza((zzb) new zzbg(this, activity, zzl));
            Bundle zzb = zzl.zzb(50);
            if (zzb != null) {
                bundle.putAll(zzb);
            }
        }

        public final void onActivityDestroyed(Activity activity) {
            zzz.this.zza((zzb) new zzbi(this, activity));
        }
    }

    static class zzd extends zzt {
        private final zzgn zzbv;

        zzd(zzgn zzgn) {
            this.zzbv = zzgn;
        }

        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            this.zzbv.onEvent(str, str2, bundle, j);
        }

        /* renamed from: id */
        public final int mo24243id() {
            return System.identityHashCode(this.zzbv);
        }
    }

    public static zzz zza(@NonNull Context context) {
        return zza(context, (String) null, (String) null, (String) null, (Bundle) null);
    }

    public static zzz zza(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzab == null) {
            synchronized (zzz.class) {
                if (zzab == null) {
                    zzz zzz = new zzz(context, str, str2, str3, bundle);
                    zzab = zzz;
                }
            }
        }
        return zzab;
    }

    public final AppMeasurementSdk zzg() {
        return this.zzae;
    }

    private zzz(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !zza(str2, str3)) {
            this.zzu = "FA";
        } else {
            this.zzu = str;
        }
        this.zzac = DefaultClock.getInstance();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.zzad = threadPoolExecutor;
        this.zzae = new AppMeasurementSdk(this);
        boolean z = false;
        if (!(!zzb(context) || zzh())) {
            this.zzaq = null;
            this.zzap = true;
            Log.w(this.zzu, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!zza(str2, str3)) {
            this.zzaq = "fa";
            if (str2 == null || str3 == null) {
                boolean z2 = str2 == null;
                if (str3 == null) {
                    z = true;
                }
                if (z2 ^ z) {
                    Log.w(this.zzu, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.zzu, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
                this.zzap = true;
                return;
            }
        } else {
            this.zzaq = str2;
        }
        zzy zzy = new zzy(this, str2, str3, context, bundle);
        zza((zzb) zzy);
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzu, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zzc());
        }
    }

    private static boolean zzb(Context context) {
        try {
            GoogleServices.initialize(context);
            if (GoogleServices.getGoogleAppId() != null) {
                return true;
            }
        } catch (IllegalStateException unused) {
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean zza(String str, String str2) {
        return (str2 == null || str == null || zzh()) ? false : true;
    }

    /* access modifiers changed from: private */
    public final void zza(zzb zzb2) {
        this.zzad.execute(zzb2);
    }

    /* access modifiers changed from: protected */
    public final zzk zza(Context context, boolean z) {
        VersionPolicy versionPolicy;
        if (z) {
            try {
                versionPolicy = DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION;
            } catch (LoadingException e) {
                zza((Exception) e, true, false);
                return null;
            }
        } else {
            versionPolicy = DynamiteModule.PREFER_LOCAL;
        }
        return zzn.asInterface(DynamiteModule.load(context, versionPolicy, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
    }

    /* access modifiers changed from: private */
    public static int zzc(Context context) {
        return DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID);
    }

    /* access modifiers changed from: private */
    public static int zzd(Context context) {
        return DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID);
    }

    /* access modifiers changed from: private */
    public final void zza(Exception exc, boolean z, boolean z2) {
        this.zzap |= z;
        if (z) {
            Log.w(this.zzu, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        String str = "Error with data collection. Data lost.";
        if (z2) {
            zza(5, str, (Object) exc, (Object) null, (Object) null);
        }
        Log.w(this.zzu, str, exc);
    }

    private static boolean zzh() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void zza(zzgk zzgk) {
        zza((zzb) new zzal(this, zzgk));
    }

    public final void zza(zzgn zzgn) {
        Preconditions.checkNotNull(zzgn);
        zza((zzb) new zzau(this, zzgn));
    }

    public final void zzb(zzgn zzgn) {
        Preconditions.checkNotNull(zzgn);
        zza((zzb) new zzaz(this, zzgn));
    }

    public final void logEvent(@NonNull String str, Bundle bundle) {
        zza(null, str, bundle, false, true, null);
    }

    public final void logEventInternal(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, null);
    }

    public final void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j) {
        zza(str, str2, bundle, true, false, Long.valueOf(j));
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        zzay zzay = new zzay(this, l, str, str2, bundle, z, z2);
        zza((zzb) zzay);
    }

    public final void setUserProperty(String str, String str2) {
        zza((String) null, str, (Object) str2, false);
    }

    public final void setUserPropertyInternal(String str, String str2, Object obj) {
        zza(str, str2, obj, true);
    }

    private final void zza(String str, String str2, Object obj, boolean z) {
        zzbb zzbb = new zzbb(this, str, str2, obj, z);
        zza((zzb) zzbb);
    }

    public final void setConditionalUserProperty(Bundle bundle) {
        zza((zzb) new zzba(this, bundle));
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zza((zzb) new zzab(this, str, str2, bundle));
    }

    public final List<Bundle> getConditionalUserProperties(String str, String str2) {
        zzl zzl = new zzl();
        zza((zzb) new zzaa(this, str, str2, zzl));
        List<Bundle> list = (List) zzl.zza(zzl.zzb(5000), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final void setUserId(String str) {
        zza((zzb) new zzad(this, str));
    }

    public final void setCurrentScreen(Activity activity, String str, String str2) {
        zza((zzb) new zzac(this, activity, str, str2));
    }

    public final void setMeasurementEnabled(boolean z) {
        zza((zzb) new zzaf(this, z));
    }

    public final void resetAnalyticsData() {
        zza((zzb) new zzae(this));
    }

    public final void setMinimumSessionDuration(long j) {
        zza((zzb) new zzah(this, j));
    }

    public final void setSessionTimeoutDuration(long j) {
        zza((zzb) new zzag(this, j));
    }

    public final void beginAdUnitExposure(String str) {
        zza((zzb) new zzaj(this, str));
    }

    public final void endAdUnitExposure(String str) {
        zza((zzb) new zzai(this, str));
    }

    public final String getGmpAppId() {
        zzl zzl = new zzl();
        zza((zzb) new zzak(this, zzl));
        return zzl.zza(500);
    }

    public final String zzi() {
        zzl zzl = new zzl();
        zza((zzb) new zzan(this, zzl));
        return zzl.zza(50);
    }

    public final long generateEventId() {
        zzl zzl = new zzl();
        zza((zzb) new zzam(this, zzl));
        Long l = (Long) zzl.zza(zzl.zzb(500), Long.class);
        if (l != null) {
            return l.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.zzac.currentTimeMillis()).nextLong();
        int i = this.zzag + 1;
        this.zzag = i;
        return nextLong + ((long) i);
    }

    public final String getCurrentScreenName() {
        zzl zzl = new zzl();
        zza((zzb) new zzap(this, zzl));
        return zzl.zza(500);
    }

    public final String getCurrentScreenClass() {
        zzl zzl = new zzl();
        zza((zzb) new zzao(this, zzl));
        return zzl.zza(500);
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        zzl zzl = new zzl();
        zzar zzar2 = new zzar(this, str, str2, z, zzl);
        zza((zzb) zzar2);
        Bundle zzb2 = zzl.zzb(5000);
        if (zzb2 == null || zzb2.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(zzb2.size());
        for (String str3 : zzb2.keySet()) {
            Object obj = zzb2.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    public final void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        zzaq zzaq2 = new zzaq(this, false, 5, str, obj, null, null);
        zza((zzb) zzaq2);
    }

    public final Bundle zza(Bundle bundle, boolean z) {
        zzl zzl = new zzl();
        zza((zzb) new zzat(this, bundle, zzl));
        if (z) {
            return zzl.zzb(5000);
        }
        return null;
    }

    public final int getMaxUserProperties(String str) {
        zzl zzl = new zzl();
        zza((zzb) new zzas(this, str, zzl));
        Integer num = (Integer) zzl.zza(zzl.zzb((long) TapjoyConstants.TIMER_INCREMENT), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    @WorkerThread
    public final String getAppInstanceId() {
        zzl zzl = new zzl();
        zza((zzb) new zzav(this, zzl));
        return zzl.zza(120000);
    }

    public final String getAppIdOrigin() {
        return this.zzaq;
    }

    public final Object zzb(int i) {
        zzl zzl = new zzl();
        zza((zzb) new zzax(this, zzl, i));
        return zzl.zza(zzl.zzb(15000), Object.class);
    }

    public final void setDataCollectionEnabled(boolean z) {
        zza((zzb) new zzaw(this, z));
    }

    /* access modifiers changed from: private */
    public static void zze(Context context) {
        synchronized (zzz.class) {
            try {
                if (zzah != null && zzai != null) {
                    return;
                }
                if (zza(context, "app_measurement_internal_disable_startup_flags")) {
                    zzah = Boolean.valueOf(false);
                    zzai = Boolean.valueOf(false);
                    return;
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
                zzah = Boolean.valueOf(sharedPreferences.getBoolean(zzal, false));
                zzai = Boolean.valueOf(sharedPreferences.getBoolean(zzam, false));
                Editor edit = sharedPreferences.edit();
                edit.remove(zzal);
                edit.remove(zzam);
                edit.apply();
            } catch (ClassCastException | IllegalStateException | NullPointerException e) {
                Log.e("FA", "Exception reading flag from SharedPreferences.", e);
                zzah = Boolean.valueOf(false);
                zzai = Boolean.valueOf(false);
            }
        }
    }

    public static boolean zzf(Context context) {
        zze(context);
        synchronized (zzz.class) {
            if (!zzaj) {
                try {
                    String str = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{"measurement.dynamite.enabled", ""});
                    if ("true".equals(str)) {
                        zzak = Boolean.valueOf(true);
                    } else if ("false".equals(str)) {
                        zzak = Boolean.valueOf(false);
                    } else {
                        zzak = null;
                    }
                    zzaj = true;
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    try {
                        Log.e("FA", "Unable to call SystemProperties.get()", e);
                        zzak = null;
                    } finally {
                        zzaj = true;
                    }
                }
            }
        }
        Boolean bool = zzak;
        if (bool == null) {
            bool = zzah;
        }
        return bool.booleanValue();
    }

    private static boolean zza(Context context, @Size(min = 1) String str) {
        Preconditions.checkNotEmpty(str);
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                if (applicationInfo.metaData != null) {
                    return applicationInfo.metaData.getBoolean(str);
                }
            }
        } catch (NameNotFoundException unused) {
        }
        return false;
    }
}
