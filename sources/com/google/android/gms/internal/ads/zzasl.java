package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.reflect.Method;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzasl {
    private final AtomicReference<ThreadPoolExecutor> zzdph = new AtomicReference<>(null);
    private final Object zzdpi = new Object();
    @GuardedBy("gmpAppIdLock")
    @Nullable
    private String zzdpj = null;
    @GuardedBy("gmpAppIdLock")
    @Nullable
    private String zzdpk = null;
    @VisibleForTesting
    private final AtomicBoolean zzdpl = new AtomicBoolean(false);
    private final AtomicInteger zzdpm = new AtomicInteger(-1);
    private final AtomicReference<Object> zzdpn = new AtomicReference<>(null);
    private final AtomicReference<Object> zzdpo = new AtomicReference<>(null);
    private final ConcurrentMap<String, Method> zzdpp = new ConcurrentHashMap(9);
    private final AtomicReference<zzbeb> zzdpq = new AtomicReference<>(null);
    @GuardedBy("proxyReference")
    private final BlockingQueue<FutureTask<?>> zzdpr = new ArrayBlockingQueue(20);
    private final Object zzdps = new Object();

    public final boolean zzab(Context context) {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcjf)).booleanValue() && !this.zzdpl.get()) {
            if (((Boolean) zzuv.zzon().zzd(zzza.zzcjp)).booleanValue()) {
                return true;
            }
            if (this.zzdpm.get() == -1) {
                zzuv.zzoj();
                if (!zzawy.zzc(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                    zzuv.zzoj();
                    if (zzawy.zzbk(context)) {
                        zzaug.zzeu("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                        this.zzdpm.set(0);
                    }
                }
                this.zzdpm.set(1);
            }
            if (this.zzdpm.get() == 1) {
                return true;
            }
        }
        return false;
    }

    @VisibleForTesting
    private static boolean zzac(Context context) {
        if (!((Boolean) zzuv.zzon().zzd(zzza.zzcjn)).booleanValue()) {
            if (!((Boolean) zzuv.zzon().zzd(zzza.zzcjm)).booleanValue()) {
                return false;
            }
        }
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcjo)).booleanValue()) {
            try {
                context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                return false;
            } catch (ClassNotFoundException unused) {
            }
        }
        return true;
    }

    public final void zza(Context context, zzyd zzyd) {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcjs)).booleanValue() && zzab(context) && zzac(context)) {
            synchronized (this.zzdps) {
            }
        }
    }

    public final void zza(Context context, zztx zztx) {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcjs)).booleanValue() && zzab(context) && zzac(context)) {
            synchronized (this.zzdps) {
            }
        }
    }

    public final void zze(Context context, String str) {
        if (zzab(context)) {
            String str2 = "beginAdUnitExposure";
            if (zzac(context)) {
                zza(str2, (zzatb) new zzaso(str));
            } else {
                zza(context, str, str2);
            }
        }
    }

    public final void zzf(Context context, String str) {
        if (zzab(context)) {
            String str2 = "endAdUnitExposure";
            if (zzac(context)) {
                zza(str2, (zzatb) new zzasr(str));
            } else {
                zza(context, str, str2);
            }
        }
    }

    public final String zzad(Context context) {
        String str = "getCurrentScreenName";
        String str2 = "";
        if (!zzab(context)) {
            return str2;
        }
        if (zzac(context)) {
            return (String) zza("getCurrentScreenNameOrScreenClass", (T) str2, zzasu.zzdpu);
        }
        if (!zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdpn, true)) {
            return str2;
        }
        try {
            String str3 = (String) zzm(context, str).invoke(this.zzdpn.get(), new Object[0]);
            if (str3 == null) {
                str3 = (String) zzm(context, "getCurrentScreenClass").invoke(this.zzdpn.get(), new Object[0]);
            }
            return str3 != null ? str3 : str2;
        } catch (Exception e) {
            zza(e, str, false);
            return str2;
        }
    }

    public final void zzg(Context context, String str) {
        if (!zzab(context) || !(context instanceof Activity)) {
            return;
        }
        if (zzac(context)) {
            zza("setScreenName", (zzatb) new zzast(context, str));
            return;
        }
        if (zza(context, "com.google.firebase.analytics.FirebaseAnalytics", this.zzdpo, false)) {
            String str2 = "setCurrentScreen";
            Method zzn = zzn(context, str2);
            try {
                Activity activity = (Activity) context;
                zzn.invoke(this.zzdpo.get(), new Object[]{activity, str, context.getPackageName()});
            } catch (Exception e) {
                zza(e, str2, false);
            }
        }
    }

    @Nullable
    public final String zzae(Context context) {
        if (!zzab(context)) {
            return null;
        }
        synchronized (this.zzdpi) {
            if (this.zzdpj != null) {
                String str = this.zzdpj;
                return str;
            }
            if (zzac(context)) {
                this.zzdpj = (String) zza("getGmpAppId", (T) this.zzdpj, zzasw.zzdpu);
            } else {
                this.zzdpj = (String) zza("getGmpAppId", context);
            }
            String str2 = this.zzdpj;
            return str2;
        }
    }

    @Nullable
    public final String zzaf(Context context) {
        if (!zzab(context)) {
            return null;
        }
        long longValue = ((Long) zzuv.zzon().zzd(zzza.zzcjk)).longValue();
        String str = "TIME_OUT";
        String str2 = "getAppInstanceId";
        if (zzac(context)) {
            if (longValue >= 0) {
                return (String) zzts().submit(new zzasy(this)).get(longValue, TimeUnit.MILLISECONDS);
            }
            try {
                return (String) zza(str2, (T) null, zzasv.zzdpu);
            } catch (TimeoutException unused) {
                return str;
            } catch (Exception unused2) {
                return null;
            }
        } else if (longValue < 0) {
            return (String) zza(str2, context);
        } else {
            try {
                return (String) zzts().submit(new zzasx(this, context)).get(longValue, TimeUnit.MILLISECONDS);
            } catch (TimeoutException unused3) {
                return str;
            } catch (Exception unused4) {
                return null;
            }
        }
    }

    @Nullable
    public final String zzag(Context context) {
        if (!zzab(context)) {
            return null;
        }
        if (zzac(context)) {
            Long l = (Long) zza("getAdEventId", (T) null, zzata.zzdpu);
            if (l != null) {
                return Long.toString(l.longValue());
            }
            return null;
        }
        Object zza = zza("generateEventId", context);
        if (zza != null) {
            return zza.toString();
        }
        return null;
    }

    @Nullable
    public final String zzah(Context context) {
        if (!zzab(context)) {
            return null;
        }
        synchronized (this.zzdpi) {
            if (this.zzdpk != null) {
                String str = this.zzdpk;
                return str;
            }
            if (zzac(context)) {
                this.zzdpk = (String) zza("getAppIdOrigin", (T) this.zzdpk, zzasn.zzdpu);
            } else {
                this.zzdpk = "fa";
            }
            String str2 = this.zzdpk;
            return str2;
        }
    }

    public final void zzh(Context context, String str) {
        zza(context, "_ac", str, (Bundle) null);
    }

    public final void zzi(Context context, String str) {
        zza(context, "_ai", str, (Bundle) null);
    }

    public final void zzj(Context context, String str) {
        zza(context, "_aq", str, (Bundle) null);
    }

    public final void zzk(Context context, String str) {
        zza(context, "_aa", str, (Bundle) null);
    }

    public final void zza(Context context, String str, String str2, String str3, int i) {
        if (zzab(context)) {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str2);
            bundle.putString("type", str3);
            bundle.putInt("value", i);
            zza(context, "_ar", str, bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 75);
            sb.append("Log a Firebase reward video event, reward type: ");
            sb.append(str3);
            sb.append(", reward value: ");
            sb.append(i);
            zzaug.zzdy(sb.toString());
        }
    }

    private final void zza(Context context, String str, String str2, @Nullable Bundle bundle) {
        if (zzab(context)) {
            Bundle zzl = zzl(str2, str);
            if (bundle != null) {
                zzl.putAll(bundle);
            }
            String str3 = "logEventInternal";
            if (zzac(context)) {
                zza(str3, (zzatb) new zzasq(str, zzl));
                return;
            }
            if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdpn, true)) {
                Method zzai = zzai(context);
                try {
                    zzai.invoke(this.zzdpn.get(), new Object[]{"am", str, zzl});
                } catch (Exception e) {
                    zza(e, str3, true);
                }
            }
        }
    }

    private static Bundle zzl(String str, String str2) {
        Bundle bundle = new Bundle();
        try {
            bundle.putLong("_aeid", Long.parseLong(str));
        } catch (NullPointerException | NumberFormatException e) {
            String str3 = "Invalid event ID: ";
            String valueOf = String.valueOf(str);
            zzaug.zzc(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), e);
        }
        if ("_ac".equals(str2)) {
            bundle.putInt("_r", 1);
        }
        return bundle;
    }

    @Nullable
    private final Method zzai(Context context) {
        String str = "logEventInternal";
        Method method = (Method) this.zzdpp.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[]{String.class, String.class, Bundle.class});
            this.zzdpp.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, str, true);
            return null;
        }
    }

    @Nullable
    private final Method zzl(Context context, String str) {
        Method method = (Method) this.zzdpp.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[]{String.class});
            this.zzdpp.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, str, false);
            return null;
        }
    }

    @Nullable
    private final Method zzm(Context context, String str) {
        Method method = (Method) this.zzdpp.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[0]);
            this.zzdpp.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, str, false);
            return null;
        }
    }

    private final Method zzn(Context context, String str) {
        Method method = (Method) this.zzdpp.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod(str, new Class[]{Activity.class, String.class, String.class});
            this.zzdpp.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, str, false);
            return null;
        }
    }

    private final void zza(Context context, String str, String str2) {
        if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdpn, true)) {
            Method zzl = zzl(context, str2);
            try {
                zzl.invoke(this.zzdpn.get(), new Object[]{str});
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 37 + String.valueOf(str).length());
                sb.append("Invoke Firebase method ");
                sb.append(str2);
                sb.append(", Ad Unit Id: ");
                sb.append(str);
                zzaug.zzdy(sb.toString());
            } catch (Exception e) {
                zza(e, str2, false);
            }
        }
    }

    private final Object zza(String str, Context context) {
        if (!zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdpn, true)) {
            return null;
        }
        try {
            return zzm(context, str).invoke(this.zzdpn.get(), new Object[0]);
        } catch (Exception e) {
            zza(e, str, true);
            return null;
        }
    }

    private final void zza(Exception exc, String str, boolean z) {
        if (!this.zzdpl.get()) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30);
            sb.append("Invoke Firebase method ");
            sb.append(str);
            sb.append(" error.");
            zzaug.zzeu(sb.toString());
            if (z) {
                zzaug.zzeu("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
                this.zzdpl.set(true);
            }
        }
    }

    private final ThreadPoolExecutor zzts() {
        if (this.zzdph.get() == null) {
            AtomicReference<ThreadPoolExecutor> atomicReference = this.zzdph;
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(((Integer) zzuv.zzon().zzd(zzza.zzcjl)).intValue(), ((Integer) zzuv.zzon().zzd(zzza.zzcjl)).intValue(), 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), new zzasz(this));
            atomicReference.compareAndSet(null, threadPoolExecutor);
        }
        return (ThreadPoolExecutor) this.zzdph.get();
    }

    private final boolean zza(Context context, String str, AtomicReference<Object> atomicReference, boolean z) {
        String str2 = "getInstance";
        if (atomicReference.get() == null) {
            try {
                atomicReference.compareAndSet(null, context.getClassLoader().loadClass(str).getDeclaredMethod(str2, new Class[]{Context.class}).invoke(null, new Object[]{context}));
            } catch (Exception e) {
                zza(e, str2, z);
                return false;
            }
        }
        return true;
    }

    private final void zza(String str, zzatb zzatb) {
        synchronized (this.zzdpq) {
            FutureTask futureTask = new FutureTask(new zzasp(this, zzatb, str), null);
            if (this.zzdpq.get() != null) {
                futureTask.run();
            } else {
                this.zzdpr.offer(futureTask);
            }
        }
    }

    private final <T> T zza(String str, @Nullable T t, zzatc<T> zzatc) {
        synchronized (this.zzdpq) {
            if (((zzbeb) this.zzdpq.get()) != null) {
                try {
                    T zza = zzatc.zza((zzbeb) this.zzdpq.get());
                    return zza;
                } catch (Exception e) {
                    zza(e, str, false);
                    return t;
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(zzatb zzatb, String str) {
        if (((zzbeb) this.zzdpq.get()) != null) {
            try {
                zzatb.zzb((zzbeb) this.zzdpq.get());
            } catch (Exception e) {
                zza(e, str, false);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ String zzaj(Context context) throws Exception {
        return (String) zza("getAppInstanceId", context);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ String zztt() throws Exception {
        return (String) zza("getAppInstanceId", (T) null, zzass.zzdpu);
    }
}
