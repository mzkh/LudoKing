package com.google.android.gms.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.Task;

public class ActivityRecognitionClient extends GoogleApi<NoOptions> {
    public ActivityRecognitionClient(@NonNull Activity activity) {
        super(activity, LocationServices.API, null, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    public ActivityRecognitionClient(@NonNull Context context) {
        super(context, LocationServices.API, null, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
    public Task<Void> removeActivityTransitionUpdates(PendingIntent pendingIntent) {
        return PendingResultUtil.toVoidTask(ActivityRecognition.ActivityRecognitionApi.zza(asGoogleApiClient(), pendingIntent));
    }

    @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
    public Task<Void> removeActivityUpdates(PendingIntent pendingIntent) {
        return PendingResultUtil.toVoidTask(ActivityRecognition.ActivityRecognitionApi.removeActivityUpdates(asGoogleApiClient(), pendingIntent));
    }

    @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
    public Task<Void> requestActivityTransitionUpdates(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent) {
        return PendingResultUtil.toVoidTask(ActivityRecognition.ActivityRecognitionApi.zza(asGoogleApiClient(), activityTransitionRequest, pendingIntent));
    }

    @RequiresPermission("com.google.android.gms.permission.ACTIVITY_RECOGNITION")
    public Task<Void> requestActivityUpdates(long j, PendingIntent pendingIntent) {
        return PendingResultUtil.toVoidTask(ActivityRecognition.ActivityRecognitionApi.requestActivityUpdates(asGoogleApiClient(), j, pendingIntent));
    }
}
