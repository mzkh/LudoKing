package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import com.google.android.gms.drive.metadata.zza;

public final class zzh extends zza<Integer> {
    public zzh(String str, int i) {
        super(str, GmsVersion.VERSION_JARLSBERG);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zza(Bundle bundle, Object obj) {
        bundle.putInt(getName(), ((Integer) obj).intValue());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzb(Bundle bundle) {
        return Integer.valueOf(bundle.getInt(getName()));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return Integer.valueOf(dataHolder.getInteger(getName(), i, i2));
    }
}
