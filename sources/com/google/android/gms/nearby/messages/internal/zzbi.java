package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.content.Intent;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.nearby.zzgw;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.SubscribeOptions;

public final class zzbi implements Messages {
    public static final AbstractClientBuilder<zzah, MessagesOptions> CLIENT_BUILDER = new zzbj();
    public static final ClientKey<zzah> CLIENT_KEY = new ClientKey<>();
    public static final zzbi zzij = new zzbi();

    private zzbi() {
    }

    public final PendingResult<Status> getPermissionStatus(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new zzbr(this, googleApiClient));
    }

    public final void handleIntent(Intent intent, MessageListener messageListener) {
        zzgw.zza(intent, messageListener);
    }

    public final PendingResult<Status> publish(GoogleApiClient googleApiClient, Message message) {
        return publish(googleApiClient, message, PublishOptions.DEFAULT);
    }

    public final PendingResult<Status> publish(GoogleApiClient googleApiClient, Message message, PublishOptions publishOptions) {
        Preconditions.checkNotNull(message);
        Preconditions.checkNotNull(publishOptions);
        zzbt zzbt = null;
        ListenerHolder registerListener = publishOptions.getCallback() == null ? null : googleApiClient.registerListener(publishOptions.getCallback());
        if (registerListener != null) {
            zzbt = new zzbt(registerListener);
        }
        zzbl zzbl = new zzbl(this, googleApiClient, message, zzbt, publishOptions);
        return googleApiClient.execute(zzbl);
    }

    public final PendingResult<Status> registerStatusCallback(GoogleApiClient googleApiClient, StatusCallback statusCallback) {
        Preconditions.checkNotNull(statusCallback);
        return googleApiClient.execute(new zzbs(this, googleApiClient, googleApiClient.registerListener(statusCallback)));
    }

    public final PendingResult<Status> subscribe(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return subscribe(googleApiClient, pendingIntent, SubscribeOptions.DEFAULT);
    }

    public final PendingResult<Status> subscribe(GoogleApiClient googleApiClient, PendingIntent pendingIntent, SubscribeOptions subscribeOptions) {
        Preconditions.checkNotNull(pendingIntent);
        Preconditions.checkNotNull(subscribeOptions);
        zzbw zzbw = null;
        ListenerHolder registerListener = subscribeOptions.getCallback() == null ? null : googleApiClient.registerListener(subscribeOptions.getCallback());
        if (registerListener != null) {
            zzbw = new zzbw(registerListener);
        }
        zzbo zzbo = new zzbo(this, googleApiClient, pendingIntent, zzbw, subscribeOptions);
        return googleApiClient.execute(zzbo);
    }

    public final PendingResult<Status> subscribe(GoogleApiClient googleApiClient, MessageListener messageListener) {
        return subscribe(googleApiClient, messageListener, SubscribeOptions.DEFAULT);
    }

    public final PendingResult<Status> subscribe(GoogleApiClient googleApiClient, MessageListener messageListener, SubscribeOptions subscribeOptions) {
        Preconditions.checkNotNull(messageListener);
        Preconditions.checkNotNull(subscribeOptions);
        Preconditions.checkArgument(subscribeOptions.getStrategy().zzae() == 0, "Strategy.setBackgroundScanMode() is only supported by background subscribe (the version which takes a PendingIntent).");
        ListenerHolder registerListener = googleApiClient.registerListener(messageListener);
        zzbw zzbw = null;
        ListenerHolder registerListener2 = subscribeOptions.getCallback() == null ? null : googleApiClient.registerListener(subscribeOptions.getCallback());
        if (registerListener2 != null) {
            zzbw = new zzbw(registerListener2);
        }
        zzbn zzbn = new zzbn(this, googleApiClient, registerListener, zzbw, subscribeOptions);
        return googleApiClient.execute(zzbn);
    }

    public final PendingResult<Status> unpublish(GoogleApiClient googleApiClient, Message message) {
        Preconditions.checkNotNull(message);
        return googleApiClient.execute(new zzbm(this, googleApiClient, message));
    }

    public final PendingResult<Status> unregisterStatusCallback(GoogleApiClient googleApiClient, StatusCallback statusCallback) {
        Preconditions.checkNotNull(statusCallback);
        return googleApiClient.execute(new zzbk(this, googleApiClient, googleApiClient.registerListener(statusCallback)));
    }

    public final PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        Preconditions.checkNotNull(pendingIntent);
        return googleApiClient.execute(new zzbq(this, googleApiClient, pendingIntent));
    }

    public final PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, MessageListener messageListener) {
        Preconditions.checkNotNull(messageListener);
        return googleApiClient.execute(new zzbp(this, googleApiClient, googleApiClient.registerListener(messageListener)));
    }
}
