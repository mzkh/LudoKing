package com.google.android.gms.internal.drive;

import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.zzn;
import com.google.android.gms.drive.zzp;
import java.io.InputStream;
import java.io.OutputStream;

public final class zzbi implements DriveContents {
    /* access modifiers changed from: private */
    public static final GmsLogger zzbx = new GmsLogger("DriveContentsImpl", "");
    private boolean closed = false;
    /* access modifiers changed from: private */
    public final Contents zzeq;
    private boolean zzer = false;
    private boolean zzes = false;

    public zzbi(Contents contents) {
        this.zzeq = (Contents) Preconditions.checkNotNull(contents);
    }

    private final PendingResult<Status> zza(GoogleApiClient googleApiClient, @Nullable MetadataChangeSet metadataChangeSet, @Nullable zzn zzn) {
        if (zzn == null) {
            zzn = (zzn) new zzp().build();
        }
        if (this.zzeq.getMode() == 268435456) {
            throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
        } else if (!ExecutionOptions.zza(zzn.zzm()) || this.zzeq.zza()) {
            zzn.zza(googleApiClient);
            if (this.closed) {
                throw new IllegalStateException("DriveContents already closed.");
            } else if (getDriveId() != null) {
                if (metadataChangeSet == null) {
                    metadataChangeSet = MetadataChangeSet.zzav;
                }
                zzi();
                return googleApiClient.execute(new zzbk(this, googleApiClient, metadataChangeSet, zzn));
            } else {
                throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
            }
        } else {
            throw new IllegalStateException("DriveContents must be valid for conflict detection.");
        }
    }

    public final PendingResult<Status> commit(GoogleApiClient googleApiClient, @Nullable MetadataChangeSet metadataChangeSet) {
        return zza(googleApiClient, metadataChangeSet, null);
    }

    public final PendingResult<Status> commit(GoogleApiClient googleApiClient, @Nullable MetadataChangeSet metadataChangeSet, @Nullable ExecutionOptions executionOptions) {
        return zza(googleApiClient, metadataChangeSet, executionOptions == null ? null : zzn.zza(executionOptions));
    }

    public final void discard(GoogleApiClient googleApiClient) {
        if (!this.closed) {
            zzi();
            ((zzbm) googleApiClient.execute(new zzbm(this, googleApiClient))).setResultCallback(new zzbl(this));
            return;
        }
        throw new IllegalStateException("DriveContents already closed.");
    }

    public final DriveId getDriveId() {
        return this.zzeq.getDriveId();
    }

    public final InputStream getInputStream() {
        if (this.closed) {
            throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
        } else if (this.zzeq.getMode() != 268435456) {
            throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
        } else if (!this.zzer) {
            this.zzer = true;
            return this.zzeq.getInputStream();
        } else {
            throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
        }
    }

    public final int getMode() {
        return this.zzeq.getMode();
    }

    public final OutputStream getOutputStream() {
        if (this.closed) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        } else if (this.zzeq.getMode() != 536870912) {
            throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
        } else if (!this.zzes) {
            this.zzes = true;
            return this.zzeq.getOutputStream();
        } else {
            throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
        }
    }

    public final ParcelFileDescriptor getParcelFileDescriptor() {
        if (!this.closed) {
            return this.zzeq.getParcelFileDescriptor();
        }
        throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }

    public final PendingResult<DriveContentsResult> reopenForWrite(GoogleApiClient googleApiClient) {
        if (this.closed) {
            throw new IllegalStateException("DriveContents already closed.");
        } else if (this.zzeq.getMode() == 268435456) {
            zzi();
            return googleApiClient.enqueue(new zzbj(this, googleApiClient));
        } else {
            throw new IllegalStateException("reopenForWrite can only be used with DriveContents opened with MODE_READ_ONLY.");
        }
    }

    public final Contents zzh() {
        return this.zzeq;
    }

    public final void zzi() {
        IOUtils.closeQuietly(this.zzeq.getParcelFileDescriptor());
        this.closed = true;
    }

    public final boolean zzj() {
        return this.closed;
    }
}
