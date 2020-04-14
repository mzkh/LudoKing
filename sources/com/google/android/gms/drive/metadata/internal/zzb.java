package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import com.google.android.gms.drive.metadata.zza;
import java.util.Collection;

public class zzb extends zza<Boolean> {
    public zzb(String str, int i) {
        super(str, i);
    }

    public zzb(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, GmsVersion.VERSION_ORLA);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zza(Bundle bundle, Object obj) {
        bundle.putBoolean(getName(), ((Boolean) obj).booleanValue());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzb(Bundle bundle) {
        return Boolean.valueOf(bundle.getBoolean(getName()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: zze */
    public Boolean zzc(DataHolder dataHolder, int i, int i2) {
        return Boolean.valueOf(dataHolder.getBoolean(getName(), i, i2));
    }
}
