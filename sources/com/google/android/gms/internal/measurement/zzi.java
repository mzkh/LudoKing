package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.UserHandle;
import android.util.Log;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@TargetApi(24)
public final class zzi {
    @Nullable
    private static final Method zzg = zza();
    @Nullable
    private static final Method zzh = zzb();
    private final JobScheduler zzf;

    @Nullable
    private static Method zza() {
        if (VERSION.SDK_INT >= 24) {
            try {
                return JobScheduler.class.getDeclaredMethod("scheduleAsPackage", new Class[]{JobInfo.class, String.class, Integer.TYPE, String.class});
            } catch (NoSuchMethodException unused) {
                String str = "JobSchedulerCompat";
                if (Log.isLoggable(str, 6)) {
                    Log.e(str, "No scheduleAsPackage method available, falling back to schedule");
                }
            }
        }
        return null;
    }

    @Nullable
    private static Method zzb() {
        if (VERSION.SDK_INT >= 24) {
            try {
                return UserHandle.class.getDeclaredMethod("myUserId", null);
            } catch (NoSuchMethodException unused) {
                String str = "JobSchedulerCompat";
                if (Log.isLoggable(str, 6)) {
                    Log.e(str, "No myUserId method available");
                }
            }
        }
        return null;
    }

    private static int zzc() {
        Method method = zzh;
        if (method != null) {
            try {
                return ((Integer) method.invoke(null, new Object[0])).intValue();
            } catch (IllegalAccessException | InvocationTargetException e) {
                String str = "JobSchedulerCompat";
                if (Log.isLoggable(str, 6)) {
                    Log.e(str, "myUserId invocation illegal", e);
                }
            }
        }
        return 0;
    }

    private zzi(JobScheduler jobScheduler) {
        this.zzf = jobScheduler;
    }

    private final int zza(JobInfo jobInfo, String str, int i, String str2) {
        Method method = zzg;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.zzf, new Object[]{jobInfo, str, Integer.valueOf(i), str2})).intValue();
            } catch (IllegalAccessException | InvocationTargetException e) {
                Log.e(str2, "error calling scheduleAsPackage", e);
            }
        }
        return this.zzf.schedule(jobInfo);
    }

    public static int zza(Context context, JobInfo jobInfo, String str, String str2) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (zzg == null || context.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") != 0) {
            return jobScheduler.schedule(jobInfo);
        }
        return new zzi(jobScheduler).zza(jobInfo, str, zzc(), str2);
    }
}
