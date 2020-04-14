package com.google.android.gms.internal.drive;

import android.os.Bundle;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza;
import com.google.android.gms.drive.metadata.internal.zzc;
import com.google.android.gms.drive.metadata.internal.zzg;
import com.google.android.gms.drive.metadata.internal.zzm;
import java.util.Arrays;

public class zzia extends zzm<AppVisibleCustomProperties> {
    public static final zzg zzkm = new zzib();

    public zzia(int i) {
        String str = "customProperties";
        super(str, Arrays.asList(new String[]{"hasCustomProperties", "sqlId"}), Arrays.asList(new String[]{"customPropertiesExtra", "customPropertiesExtraHolder"}), GmsVersion.VERSION_LONGHORN);
    }

    /* access modifiers changed from: private */
    public static void zzc(DataHolder dataHolder) {
        Bundle metadata = dataHolder.getMetadata();
        if (metadata != null) {
            synchronized (dataHolder) {
                DataHolder dataHolder2 = (DataHolder) metadata.getParcelable("customPropertiesExtraHolder");
                if (dataHolder2 != null) {
                    dataHolder2.close();
                    metadata.remove("customPropertiesExtraHolder");
                }
            }
        }
    }

    private static AppVisibleCustomProperties zzf(DataHolder dataHolder, int i, int i2) {
        DataHolder dataHolder2 = dataHolder;
        Bundle metadata = dataHolder.getMetadata();
        SparseArray sparseParcelableArray = metadata.getSparseParcelableArray("customPropertiesExtra");
        if (sparseParcelableArray == null) {
            if (metadata.getParcelable("customPropertiesExtraHolder") != null) {
                synchronized (dataHolder) {
                    DataHolder dataHolder3 = (DataHolder) dataHolder.getMetadata().getParcelable("customPropertiesExtraHolder");
                    if (dataHolder3 != null) {
                        try {
                            Bundle metadata2 = dataHolder3.getMetadata();
                            String string = metadata2.getString("entryIdColumn");
                            String string2 = metadata2.getString("keyColumn");
                            String string3 = metadata2.getString("visibilityColumn");
                            String string4 = metadata2.getString("valueColumn");
                            LongSparseArray longSparseArray = new LongSparseArray();
                            for (int i3 = 0; i3 < dataHolder3.getCount(); i3++) {
                                int windowIndex = dataHolder3.getWindowIndex(i3);
                                long j = dataHolder3.getLong(string, i3, windowIndex);
                                String string5 = dataHolder3.getString(string2, i3, windowIndex);
                                int integer = dataHolder3.getInteger(string3, i3, windowIndex);
                                zzc zzc = new zzc(new CustomPropertyKey(string5, integer), dataHolder3.getString(string4, i3, windowIndex));
                                zza zza = (zza) longSparseArray.get(j);
                                if (zza == null) {
                                    zza = new zza();
                                    longSparseArray.put(j, zza);
                                }
                                zza.zza(zzc);
                            }
                            SparseArray sparseArray = new SparseArray();
                            for (int i4 = 0; i4 < dataHolder.getCount(); i4++) {
                                zza zza2 = (zza) longSparseArray.get(dataHolder2.getLong("sqlId", i4, dataHolder2.getWindowIndex(i4)));
                                if (zza2 != null) {
                                    sparseArray.append(i4, zza2.zzat());
                                }
                            }
                            dataHolder.getMetadata().putSparseParcelableArray("customPropertiesExtra", sparseArray);
                        } finally {
                            dataHolder3.close();
                            dataHolder.getMetadata().remove("customPropertiesExtraHolder");
                        }
                    }
                }
                sparseParcelableArray = metadata.getSparseParcelableArray("customPropertiesExtra");
            }
            if (sparseParcelableArray == null) {
                return AppVisibleCustomProperties.zzil;
            }
        }
        return (AppVisibleCustomProperties) sparseParcelableArray.get(i, AppVisibleCustomProperties.zzil);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzf(dataHolder, i, i2);
    }
}
