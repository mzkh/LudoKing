package com.google.android.gms.nearby.connection;

import androidx.annotation.NonNull;

public abstract class PayloadCallback {
    public abstract void onPayloadReceived(@NonNull String str, @NonNull Payload payload);

    public abstract void onPayloadTransferUpdate(@NonNull String str, @NonNull PayloadTransferUpdate payloadTransferUpdate);
}
