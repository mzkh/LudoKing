package com.google.android.gms.drive;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.zzf;
import com.google.android.gms.internal.drive.zzaa;
import com.google.android.gms.internal.drive.zzhp;

public final class MetadataBuffer extends AbstractDataBuffer<Metadata> {
    private zza zzas;

    static class zza extends Metadata {
        /* access modifiers changed from: private */
        public final int row;
        private final DataHolder zzat;
        private final int zzau;

        public zza(DataHolder dataHolder, int i) {
            this.zzat = dataHolder;
            this.row = i;
            this.zzau = dataHolder.getWindowIndex(i);
        }

        public final /* synthetic */ Object freeze() {
            MetadataBundle zzaw = MetadataBundle.zzaw();
            for (MetadataField<BitmapTeleporter> metadataField : zzf.zzau()) {
                if (metadataField != zzhp.zzka) {
                    metadataField.zza(this.zzat, zzaw, this.row, this.zzau);
                }
            }
            return new zzaa(zzaw);
        }

        public final boolean isDataValid() {
            return !this.zzat.isClosed();
        }

        public final <T> T zza(MetadataField<T> metadataField) {
            return metadataField.zza(this.zzat, this.row, this.zzau);
        }
    }

    public MetadataBuffer(DataHolder dataHolder) {
        super(dataHolder);
        dataHolder.getMetadata().setClassLoader(MetadataBuffer.class.getClassLoader());
    }

    public final Metadata get(int i) {
        zza zza2 = this.zzas;
        if (zza2 != null && zza2.row == i) {
            return zza2;
        }
        zza zza3 = new zza(this.mDataHolder, i);
        this.zzas = zza3;
        return zza3;
    }

    @Deprecated
    public final String getNextPageToken() {
        return null;
    }

    public final void release() {
        if (this.mDataHolder != null) {
            zzf.zza(this.mDataHolder);
        }
        super.release();
    }
}
