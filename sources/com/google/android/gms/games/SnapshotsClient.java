package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.internal.zzbe;
import com.google.android.gms.games.internal.zzbl;
import com.google.android.gms.games.internal.zzbn;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.google.android.gms.internal.games.zzt;
import com.google.android.gms.tasks.Task;

public class SnapshotsClient extends zzt {
    public static final int DISPLAY_LIMIT_NONE = -1;
    public static final String EXTRA_SNAPSHOT_METADATA = "com.google.android.gms.games.SNAPSHOT_METADATA";
    public static final String EXTRA_SNAPSHOT_NEW = "com.google.android.gms.games.SNAPSHOT_NEW";
    public static final int RESOLUTION_POLICY_HIGHEST_PROGRESS = 4;
    public static final int RESOLUTION_POLICY_LAST_KNOWN_GOOD = 2;
    public static final int RESOLUTION_POLICY_LONGEST_PLAYTIME = 1;
    public static final int RESOLUTION_POLICY_MANUAL = -1;
    public static final int RESOLUTION_POLICY_MOST_RECENTLY_MODIFIED = 3;
    private static final zzbl<OpenSnapshotResult> zzdw = new zzby();
    private static final ResultConverter<DeleteSnapshotResult, String> zzdx = new zzbz();
    private static final ResultConverter<CommitSnapshotResult, SnapshotMetadata> zzdy = new zzca();
    private static final ResultConverter<OpenSnapshotResult, OpenSnapshotResult> zzdz = new zzcb();
    private static final zzbn zzea = new zzcc();
    private static final ResultConverter<OpenSnapshotResult, DataOrConflict<Snapshot>> zzeb = new zzbt();
    private static final ResultConverter<LoadSnapshotsResult, SnapshotMetadataBuffer> zzec = new zzbu();

    public static class DataOrConflict<T> {
        private final T data;
        private final SnapshotConflict zzei;

        DataOrConflict(@Nullable T t, @Nullable SnapshotConflict snapshotConflict) {
            this.data = t;
            this.zzei = snapshotConflict;
        }

        public boolean isConflict() {
            return this.zzei != null;
        }

        @Nullable
        public T getData() {
            if (!isConflict()) {
                return this.data;
            }
            throw new IllegalStateException("getData called when there is a conflict.");
        }

        @Nullable
        public SnapshotConflict getConflict() {
            if (isConflict()) {
                return this.zzei;
            }
            throw new IllegalStateException("getConflict called when there is no conflict.");
        }
    }

    public static class SnapshotConflict {
        private final Snapshot zzej;
        private final String zzek;
        private final Snapshot zzel;
        private final SnapshotContents zzem;

        SnapshotConflict(@NonNull Snapshot snapshot, @NonNull String str, @NonNull Snapshot snapshot2, @NonNull SnapshotContents snapshotContents) {
            this.zzej = snapshot;
            this.zzek = str;
            this.zzel = snapshot2;
            this.zzem = snapshotContents;
        }

        public Snapshot getSnapshot() {
            return this.zzej;
        }

        public Snapshot getConflictingSnapshot() {
            return this.zzel;
        }

        public String getConflictId() {
            return this.zzek;
        }

        public SnapshotContents getResolutionSnapshotContents() {
            return this.zzem;
        }
    }

    public static class SnapshotContentUnavailableApiException extends ApiException {
        protected final SnapshotMetadata metadata;

        SnapshotContentUnavailableApiException(@NonNull Status status, @NonNull SnapshotMetadata snapshotMetadata) {
            super(status);
            this.metadata = snapshotMetadata;
        }

        public SnapshotMetadata getSnapshotMetadata() {
            return this.metadata;
        }
    }

    SnapshotsClient(@NonNull Context context, @NonNull GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    SnapshotsClient(@NonNull Activity activity, @NonNull GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public Task<Integer> getMaxDataSize() {
        return doRead((TaskApiCall<A, TResult>) new zzbs<A,TResult>(this));
    }

    public Task<Integer> getMaxCoverImageSize() {
        return doRead((TaskApiCall<A, TResult>) new zzbv<A,TResult>(this));
    }

    public Task<Intent> getSelectSnapshotIntent(@NonNull String str, boolean z, boolean z2, int i) {
        zzbw zzbw = new zzbw(this, str, z, z2, i);
        return doRead((TaskApiCall<A, TResult>) zzbw);
    }

    public Task<AnnotatedData<SnapshotMetadataBuffer>> load(boolean z) {
        return zzbe.zzb(Games.Snapshots.load(asGoogleApiClient(), z), zzec);
    }

    public Task<DataOrConflict<Snapshot>> open(@NonNull String str, boolean z) {
        return zzc(Games.Snapshots.open(asGoogleApiClient(), str, z));
    }

    public Task<DataOrConflict<Snapshot>> open(@NonNull String str, boolean z, int i) {
        return zzc(Games.Snapshots.open(asGoogleApiClient(), str, z, i));
    }

    public Task<DataOrConflict<Snapshot>> open(@NonNull SnapshotMetadata snapshotMetadata) {
        return zzc(Games.Snapshots.open(asGoogleApiClient(), snapshotMetadata));
    }

    public Task<DataOrConflict<Snapshot>> open(@NonNull SnapshotMetadata snapshotMetadata, int i) {
        return zzc(Games.Snapshots.open(asGoogleApiClient(), snapshotMetadata, i));
    }

    public Task<SnapshotMetadata> commitAndClose(@NonNull Snapshot snapshot, @NonNull SnapshotMetadataChange snapshotMetadataChange) {
        return zzbe.toTask(Games.Snapshots.commitAndClose(asGoogleApiClient(), snapshot, snapshotMetadataChange), zzdy);
    }

    public Task<Void> discardAndClose(@NonNull Snapshot snapshot) {
        return doWrite((TaskApiCall<A, TResult>) new zzbx<A,TResult>(this, snapshot));
    }

    public Task<String> delete(@NonNull SnapshotMetadata snapshotMetadata) {
        return zzbe.toTask(Games.Snapshots.delete(asGoogleApiClient(), snapshotMetadata), zzdx);
    }

    @Nullable
    public static SnapshotMetadata getSnapshotFromBundle(@NonNull Bundle bundle) {
        return Games.Snapshots.getSnapshotFromBundle(bundle);
    }

    public Task<DataOrConflict<Snapshot>> resolveConflict(@NonNull String str, @NonNull Snapshot snapshot) {
        return zzc(Games.Snapshots.resolveConflict(asGoogleApiClient(), str, snapshot));
    }

    public Task<DataOrConflict<Snapshot>> resolveConflict(@NonNull String str, @NonNull String str2, @NonNull SnapshotMetadataChange snapshotMetadataChange, @NonNull SnapshotContents snapshotContents) {
        return zzc(Games.Snapshots.resolveConflict(asGoogleApiClient(), str, str2, snapshotMetadataChange, snapshotContents));
    }

    private static Task<DataOrConflict<Snapshot>> zzc(@NonNull PendingResult<OpenSnapshotResult> pendingResult) {
        return zzbe.zza(pendingResult, zzea, zzeb, zzdz, zzdw);
    }
}
