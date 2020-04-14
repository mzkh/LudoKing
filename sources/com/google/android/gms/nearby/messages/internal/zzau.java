package com.google.android.gms.nearby.messages.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.nearby.messages.MessagesOptions;

final class zzau extends AbstractClientBuilder<zzah, MessagesOptions> {
    zzau() {
    }

    public final /* synthetic */ Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        zzah zzah = new zzah(context, looper, connectionCallbacks, onConnectionFailedListener, clientSettings, (MessagesOptions) obj);
        return zzah;
    }

    public final int getPriority() {
        return Integer.MAX_VALUE;
    }
}
