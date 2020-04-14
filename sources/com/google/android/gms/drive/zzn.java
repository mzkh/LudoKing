package com.google.android.gms.drive;

import androidx.annotation.Nullable;

@Deprecated
public final class zzn extends ExecutionOptions {
    private boolean zzar;

    private zzn(@Nullable String str, boolean z, int i, boolean z2) {
        super(str, z, i);
        this.zzar = z2;
    }

    public static zzn zza(@Nullable ExecutionOptions executionOptions) {
        zzp zzp = new zzp();
        if (executionOptions != null) {
            zzp.setConflictStrategy(executionOptions.zzm());
            zzp.setNotifyOnCompletion(executionOptions.zzl());
            String zzk = executionOptions.zzk();
            if (zzk != null) {
                zzp.setTrackingTag(zzk);
            }
        }
        return (zzn) zzp.build();
    }

    public final boolean zzo() {
        return this.zzar;
    }
}
