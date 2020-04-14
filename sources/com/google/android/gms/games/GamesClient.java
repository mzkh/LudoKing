package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.internal.games.zzt;
import com.google.android.gms.tasks.Task;

public class GamesClient extends zzt {
    GamesClient(@NonNull Context context, @NonNull GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    GamesClient(@NonNull Activity activity, @NonNull GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public Task<Void> setGravityForPopups(int i) {
        return doWrite((TaskApiCall<A, TResult>) new zzn<A,TResult>(this, i));
    }

    public Task<Void> setViewForPopups(@NonNull View view) {
        return doWrite((TaskApiCall<A, TResult>) new zzo<A,TResult>(this, view));
    }

    @RequiresPermission("android.permission.GET_ACCOUNTS")
    public Task<String> getCurrentAccountName() {
        return doRead((TaskApiCall<A, TResult>) new zzp<A,TResult>(this));
    }

    public Task<String> getAppId() {
        return doRead((TaskApiCall<A, TResult>) new zzq<A,TResult>(this));
    }

    public Task<Intent> getSettingsIntent() {
        return doRead((TaskApiCall<A, TResult>) new zzr<A,TResult>(this));
    }

    public Task<Bundle> getActivationHint() {
        return doRead((TaskApiCall<A, TResult>) new zzs<A,TResult>(this));
    }

    @KeepForSdk
    public Task<Integer> getSdkVariant() {
        return doRead((TaskApiCall<A, TResult>) new zzt<A,TResult>(this));
    }
}
