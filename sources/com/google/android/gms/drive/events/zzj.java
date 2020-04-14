package com.google.android.gms.drive.events;

import androidx.annotation.Nullable;
import com.google.android.gms.drive.DriveId;

public final class zzj {
    public static boolean zza(int i, @Nullable DriveId driveId) {
        if (i != 1) {
            if (i == 4 || i == 7) {
                return driveId == null;
            }
            if (i != 8) {
                return false;
            }
        }
        return driveId != null;
    }
}
