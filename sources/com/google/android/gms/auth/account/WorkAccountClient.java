package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.internal.auth.zzh;
import com.google.android.gms.tasks.Task;

public class WorkAccountClient extends GoogleApi<NoOptions> {
    private final WorkAccountApi zzac = new zzh();

    WorkAccountClient(@NonNull Context context) {
        super(context, WorkAccount.API, null, Settings.DEFAULT_SETTINGS);
    }

    WorkAccountClient(@NonNull Activity activity) {
        super(activity, WorkAccount.API, null, Settings.DEFAULT_SETTINGS);
    }

    public Task<Void> setWorkAuthenticatorEnabled(boolean z) {
        return PendingResultUtil.toVoidTask(this.zzac.setWorkAuthenticatorEnabledWithResult(asGoogleApiClient(), z));
    }

    public Task<Account> addWorkAccount(String str) {
        return PendingResultUtil.toTask(this.zzac.addWorkAccount(asGoogleApiClient(), str), new zzg(this));
    }

    public Task<Void> removeWorkAccount(Account account) {
        return PendingResultUtil.toVoidTask(this.zzac.removeWorkAccount(asGoogleApiClient(), account));
    }
}
