package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.zzk;
import com.google.android.gms.internal.drive.zzaw;
import com.google.android.gms.internal.drive.zzeo;
import com.google.android.gms.internal.drive.zzgg;

@Deprecated
public class OpenFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private String zzay;
    private String[] zzaz;
    private Filter zzba;
    private DriveId zzbb;

    public IntentSender build(GoogleApiClient googleApiClient) {
        Preconditions.checkState(googleApiClient.isConnected(), "Client must be connected");
        zzf();
        Filter filter = this.zzba;
        try {
            return ((zzeo) ((zzaw) googleApiClient.getClient(Drive.CLIENT_KEY)).getService()).zza(new zzgg(this.zzay, this.zzaz, this.zzbb, filter == null ? null : new FilterHolder(filter)));
        } catch (RemoteException e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    /* access modifiers changed from: 0000 */
    public final String getTitle() {
        return this.zzay;
    }

    public OpenFileActivityBuilder setActivityStartFolder(DriveId driveId) {
        this.zzbb = (DriveId) Preconditions.checkNotNull(driveId);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String str) {
        this.zzay = (String) Preconditions.checkNotNull(str);
        return this;
    }

    public OpenFileActivityBuilder setMimeType(String[] strArr) {
        Preconditions.checkArgument(strArr != null, "mimeTypes may not be null");
        this.zzaz = strArr;
        return this;
    }

    public OpenFileActivityBuilder setSelectionFilter(Filter filter) {
        Preconditions.checkArgument(filter != null, "filter may not be null");
        Preconditions.checkArgument(true ^ zzk.zza(filter), "FullTextSearchFilter cannot be used as a selection filter");
        this.zzba = filter;
        return this;
    }

    /* access modifiers changed from: 0000 */
    public final void zzf() {
        if (this.zzaz == null) {
            this.zzaz = new String[0];
        }
        if (this.zzaz.length > 0 && this.zzba != null) {
            throw new IllegalStateException("Cannot use a selection filter and set mimetypes simultaneously");
        }
    }

    /* access modifiers changed from: 0000 */
    public final String[] zzr() {
        return this.zzaz;
    }

    /* access modifiers changed from: 0000 */
    public final Filter zzs() {
        return this.zzba;
    }

    /* access modifiers changed from: 0000 */
    public final DriveId zzt() {
        return this.zzbb;
    }
}
