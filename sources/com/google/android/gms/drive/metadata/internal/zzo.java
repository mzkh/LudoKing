package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public final class zzo extends zzl<DriveId> implements SearchableCollectionMetadataField<DriveId> {
    public static final zzg zziu = new zzp();

    public zzo(int i) {
        String str = "parents";
        super(str, Collections.emptySet(), Arrays.asList(new String[]{"parentsExtra", "dbInstanceId", "parentsExtraHolder"}), GmsVersion.VERSION_HALLOUMI);
    }

    /* access modifiers changed from: private */
    public static void zzc(DataHolder dataHolder) {
        Bundle metadata = dataHolder.getMetadata();
        if (metadata != null) {
            synchronized (dataHolder) {
                DataHolder dataHolder2 = (DataHolder) metadata.getParcelable("parentsExtraHolder");
                if (dataHolder2 != null) {
                    dataHolder2.close();
                    metadata.remove("parentsExtraHolder");
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzb(Bundle bundle) {
        return zzb(bundle);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzc(dataHolder, i, i2);
    }

    /* access modifiers changed from: protected */
    public final Collection<DriveId> zzc(Bundle bundle) {
        Collection zzc = super.zzb(bundle);
        if (zzc == null) {
            return null;
        }
        return new HashSet(zzc);
    }

    /* access modifiers changed from: protected */
    public final Collection<DriveId> zzd(DataHolder dataHolder, int i, int i2) {
        DataHolder dataHolder2 = dataHolder;
        Bundle metadata = dataHolder.getMetadata();
        ArrayList parcelableArrayList = metadata.getParcelableArrayList("parentsExtra");
        if (parcelableArrayList == null) {
            if (metadata.getParcelable("parentsExtraHolder") != null) {
                synchronized (dataHolder) {
                    DataHolder dataHolder3 = (DataHolder) dataHolder.getMetadata().getParcelable("parentsExtraHolder");
                    if (dataHolder3 != null) {
                        try {
                            int count = dataHolder.getCount();
                            ArrayList arrayList = new ArrayList(count);
                            HashMap hashMap = new HashMap(count);
                            for (int i3 = 0; i3 < count; i3++) {
                                int windowIndex = dataHolder2.getWindowIndex(i3);
                                ParentDriveIdSet parentDriveIdSet = new ParentDriveIdSet();
                                arrayList.add(parentDriveIdSet);
                                hashMap.put(Long.valueOf(dataHolder2.getLong("sqlId", i3, windowIndex)), parentDriveIdSet);
                            }
                            Bundle metadata2 = dataHolder3.getMetadata();
                            String string = metadata2.getString("childSqlIdColumn");
                            String string2 = metadata2.getString("parentSqlIdColumn");
                            String string3 = metadata2.getString("parentResIdColumn");
                            int count2 = dataHolder3.getCount();
                            for (int i4 = 0; i4 < count2; i4++) {
                                int windowIndex2 = dataHolder3.getWindowIndex(i4);
                                ParentDriveIdSet parentDriveIdSet2 = (ParentDriveIdSet) hashMap.get(Long.valueOf(dataHolder3.getLong(string, i4, windowIndex2)));
                                parentDriveIdSet2.zzit.add(new zzq(dataHolder3.getString(string3, i4, windowIndex2), dataHolder3.getLong(string2, i4, windowIndex2), 1));
                            }
                            dataHolder.getMetadata().putParcelableArrayList("parentsExtra", arrayList);
                        } finally {
                            dataHolder3.close();
                            dataHolder.getMetadata().remove("parentsExtraHolder");
                        }
                    }
                }
                parcelableArrayList = metadata.getParcelableArrayList("parentsExtra");
            }
            if (parcelableArrayList == null) {
                return null;
            }
        }
        long j = metadata.getLong("dbInstanceId");
        ParentDriveIdSet parentDriveIdSet3 = (ParentDriveIdSet) parcelableArrayList.get(i);
        HashSet hashSet = new HashSet();
        for (zzq zzq : parentDriveIdSet3.zzit) {
            DriveId driveId = new DriveId(zzq.zzab, zzq.zzac, j, zzq.zzad);
            hashSet.add(driveId);
        }
        return hashSet;
    }
}
