package com.google.android.gms.auth.api.credentials;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.internal.auth-api.zzq;
import com.google.android.gms.tasks.Task;

public class CredentialsClient extends GoogleApi<AuthCredentialsOptions> {
    CredentialsClient(@NonNull Context context, @NonNull AuthCredentialsOptions authCredentialsOptions) {
        super(context, Auth.CREDENTIALS_API, authCredentialsOptions, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    CredentialsClient(@NonNull Activity activity, @NonNull AuthCredentialsOptions authCredentialsOptions) {
        super(activity, Auth.CREDENTIALS_API, authCredentialsOptions, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    public Task<CredentialRequestResponse> request(@NonNull CredentialRequest credentialRequest) {
        return PendingResultUtil.toResponseTask(Auth.CredentialsApi.request(asGoogleApiClient(), credentialRequest), new CredentialRequestResponse());
    }

    public PendingIntent getHintPickerIntent(@NonNull HintRequest hintRequest) {
        return zzq.zzc(getApplicationContext(), (AuthCredentialsOptions) getApiOptions(), hintRequest);
    }

    public Task<Void> save(@NonNull Credential credential) {
        return PendingResultUtil.toVoidTask(Auth.CredentialsApi.save(asGoogleApiClient(), credential));
    }

    public Task<Void> delete(@NonNull Credential credential) {
        return PendingResultUtil.toVoidTask(Auth.CredentialsApi.delete(asGoogleApiClient(), credential));
    }

    public Task<Void> disableAutoSignIn() {
        return PendingResultUtil.toVoidTask(Auth.CredentialsApi.disableAutoSignIn(asGoogleApiClient()));
    }
}
