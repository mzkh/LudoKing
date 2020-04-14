package com.google.android.gms.nearby.connection;

import androidx.annotation.NonNull;

public abstract class ConnectionLifecycleCallback {
    public abstract void onConnectionInitiated(@NonNull String str, @NonNull ConnectionInfo connectionInfo);

    public abstract void onConnectionResult(@NonNull String str, @NonNull ConnectionResolution connectionResolution);

    public abstract void onDisconnected(@NonNull String str);
}
