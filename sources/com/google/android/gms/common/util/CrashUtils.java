package com.google.android.gms.common.util;

import android.content.Context;
import android.os.DropBoxManager;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.DriveFile;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public final class CrashUtils {
    private static final String[] zzgg = {"android.", "com.android.", "dalvik.", "java.", "javax."};
    private static DropBoxManager zzgh = null;
    private static boolean zzgi = false;
    private static int zzgj = -1;
    @GuardedBy("CrashUtils.class")
    private static int zzgk = 0;
    @GuardedBy("CrashUtils.class")
    private static int zzgl = 0;

    @KeepForSdk
    public static boolean addDynamiteErrorToDropBox(Context context, Throwable th) {
        return zza(context, th, DriveFile.MODE_WRITE_ONLY);
    }

    private static boolean zza(Context context, Throwable th, int i) {
        try {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(th);
            return false;
        } catch (Exception e) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e);
            return false;
        }
    }
}
