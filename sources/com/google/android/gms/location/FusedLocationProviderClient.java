package com.google.android.gms.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.internal.location.zzad;
import com.google.android.gms.internal.location.zzaj;
import com.google.android.gms.internal.location.zzak;
import com.google.android.gms.internal.location.zzbd;
import com.google.android.gms.internal.location.zzbm;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public class FusedLocationProviderClient extends GoogleApi<NoOptions> {
    public static final String KEY_VERTICAL_ACCURACY = "verticalAccuracy";

    private static class zza extends zzak {
        private final TaskCompletionSource<Void> zzac;

        public zza(TaskCompletionSource<Void> taskCompletionSource) {
            this.zzac = taskCompletionSource;
        }

        public final void zza(zzad zzad) {
            TaskUtil.setResultOrApiException(zzad.getStatus(), this.zzac);
        }
    }

    public FusedLocationProviderClient(@NonNull Activity activity) {
        super(activity, LocationServices.API, null, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    public FusedLocationProviderClient(@NonNull Context context) {
        super(context, LocationServices.API, null, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    /* access modifiers changed from: private */
    public final zzaj zza(TaskCompletionSource<Boolean> taskCompletionSource) {
        return new zzp(this, taskCompletionSource);
    }

    public Task<Void> flushLocations() {
        return PendingResultUtil.toVoidTask(LocationServices.FusedLocationApi.flushLocations(asGoogleApiClient()));
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public Task<Location> getLastLocation() {
        return doRead((TaskApiCall<A, TResult>) new zzl<A,TResult>(this));
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public Task<LocationAvailability> getLocationAvailability() {
        return doRead((TaskApiCall<A, TResult>) new zzm<A,TResult>(this));
    }

    public Task<Void> removeLocationUpdates(PendingIntent pendingIntent) {
        return PendingResultUtil.toVoidTask(LocationServices.FusedLocationApi.removeLocationUpdates(asGoogleApiClient(), pendingIntent));
    }

    public Task<Void> removeLocationUpdates(LocationCallback locationCallback) {
        return TaskUtil.toVoidTaskThatFailsOnFalse(doUnregisterEventListener(ListenerHolders.createListenerKey(locationCallback, LocationCallback.class.getSimpleName())));
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public Task<Void> requestLocationUpdates(LocationRequest locationRequest, PendingIntent pendingIntent) {
        return PendingResultUtil.toVoidTask(LocationServices.FusedLocationApi.requestLocationUpdates(asGoogleApiClient(), locationRequest, pendingIntent));
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public Task<Void> requestLocationUpdates(LocationRequest locationRequest, LocationCallback locationCallback, @Nullable Looper looper) {
        zzbd zza2 = zzbd.zza(locationRequest);
        ListenerHolder createListenerHolder = ListenerHolders.createListenerHolder(locationCallback, zzbm.zza(looper), LocationCallback.class.getSimpleName());
        return doRegisterEventListener(new zzn(this, createListenerHolder, zza2, createListenerHolder), new zzo(this, createListenerHolder.getListenerKey()));
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public Task<Void> setMockLocation(Location location) {
        return PendingResultUtil.toVoidTask(LocationServices.FusedLocationApi.setMockLocation(asGoogleApiClient(), location));
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public Task<Void> setMockMode(boolean z) {
        return PendingResultUtil.toVoidTask(LocationServices.FusedLocationApi.setMockMode(asGoogleApiClient(), z));
    }
}
