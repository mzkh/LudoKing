package com.google.android.gms.internal.drive;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.CreateFileActivityOptions;
import com.google.android.gms.drive.Drive.zza;
import com.google.android.gms.drive.DriveClient;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.OpenFileActivityOptions;
import com.google.android.gms.drive.TransferPreferences;
import com.google.android.gms.tasks.Task;

public final class zzbb extends DriveClient {
    public zzbb(@NonNull Activity activity, @Nullable zza zza) {
        super(activity, zza);
    }

    public zzbb(@NonNull Context context, @Nullable zza zza) {
        super(context, zza);
    }

    public final Task<DriveId> getDriveId(@NonNull String str) {
        Preconditions.checkNotNull(str, "resourceId must not be null");
        return doRead((TaskApiCall<A, TResult>) new zzbc<A,TResult>(this, str));
    }

    public final Task<TransferPreferences> getUploadPreferences() {
        return doRead((TaskApiCall<A, TResult>) new zzbd<A,TResult>(this));
    }

    public final Task<IntentSender> newCreateFileActivityIntentSender(CreateFileActivityOptions createFileActivityOptions) {
        return doRead((TaskApiCall<A, TResult>) new zzbg<A,TResult>(this, createFileActivityOptions));
    }

    public final Task<IntentSender> newOpenFileActivityIntentSender(OpenFileActivityOptions openFileActivityOptions) {
        return doRead((TaskApiCall<A, TResult>) new zzbf<A,TResult>(this, openFileActivityOptions));
    }

    public final Task<Void> requestSync() {
        return doWrite((TaskApiCall<A, TResult>) new zzbh<A,TResult>(this));
    }

    public final Task<Void> setUploadPreferences(@NonNull TransferPreferences transferPreferences) {
        Preconditions.checkNotNull(transferPreferences, "transferPreferences cannot be null.");
        return doWrite((TaskApiCall<A, TResult>) new zzbe<A,TResult>(this, transferPreferences));
    }
}
