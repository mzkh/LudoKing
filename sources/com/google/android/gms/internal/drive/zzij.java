package com.google.android.gms.internal.drive;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.zzm;
import java.util.Arrays;

public final class zzij extends zzm<DriveId> {
    public static final zzij zzkt = new zzij();

    private zzij() {
        super("driveId", Arrays.asList(new String[]{"sqlId", "resourceId", "mimeType"}), Arrays.asList(new String[]{"dbInstanceId"}), GmsVersion.VERSION_HALLOUMI);
    }

    /* access modifiers changed from: protected */
    public final boolean zzb(DataHolder dataHolder, int i, int i2) {
        for (String hasColumn : zzar()) {
            if (!dataHolder.hasColumn(hasColumn)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        long j = dataHolder.getMetadata().getLong("dbInstanceId");
        boolean equals = DriveFolder.MIME_TYPE.equals(dataHolder.getString(zzhp.zzjs.getName(), i, i2));
        String string = dataHolder.getString("resourceId", i, i2);
        DriveId driveId = new DriveId("generated-android-null".equals(string) ? null : string, Long.valueOf(dataHolder.getLong("sqlId", i, i2)).longValue(), j, equals ? 1 : 0);
        return driveId;
    }
}
