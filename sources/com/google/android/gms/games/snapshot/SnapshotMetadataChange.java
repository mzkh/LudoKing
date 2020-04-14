package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.data.BitmapTeleporter;

public interface SnapshotMetadataChange {
    public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChangeEntity();

    public static final class Builder {
        private String description;
        private Long zzrt;
        private Long zzru;
        private BitmapTeleporter zzrv;
        private Uri zzrw;

        public final Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        public final Builder setPlayedTimeMillis(long j) {
            this.zzrt = Long.valueOf(j);
            return this;
        }

        public final Builder setProgressValue(long j) {
            this.zzru = Long.valueOf(j);
            return this;
        }

        public final Builder setCoverImage(Bitmap bitmap) {
            this.zzrv = new BitmapTeleporter(bitmap);
            this.zzrw = null;
            return this;
        }

        public final Builder fromMetadata(SnapshotMetadata snapshotMetadata) {
            this.description = snapshotMetadata.getDescription();
            this.zzrt = Long.valueOf(snapshotMetadata.getPlayedTime());
            this.zzru = Long.valueOf(snapshotMetadata.getProgressValue());
            if (this.zzrt.longValue() == -1) {
                this.zzrt = null;
            }
            this.zzrw = snapshotMetadata.getCoverImageUri();
            if (this.zzrw != null) {
                this.zzrv = null;
            }
            return this;
        }

        public final SnapshotMetadataChange build() {
            SnapshotMetadataChangeEntity snapshotMetadataChangeEntity = new SnapshotMetadataChangeEntity(this.description, this.zzrt, this.zzrv, this.zzrw, this.zzru);
            return snapshotMetadataChangeEntity;
        }
    }

    Bitmap getCoverImage();

    String getDescription();

    Long getPlayedTimeMillis();

    Long getProgressValue();

    BitmapTeleporter zzdt();
}
