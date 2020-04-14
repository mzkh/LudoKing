package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;

/* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
final class zzcze implements BaseConnectionCallbacks, BaseOnConnectionFailedListener {
    private final Object lock = new Object();
    private boolean zzfux = false;
    private boolean zzfuy = false;
    private final zzczq zzgnl;
    private final zzczl zzgnm;

    zzcze(@NonNull Context context, @NonNull Looper looper, @NonNull zzczl zzczl) {
        this.zzgnm = zzczl;
        this.zzgnl = new zzczq(context, looper, this, this);
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    public final void onConnectionSuspended(int i) {
    }

    /* access modifiers changed from: 0000 */
    public final void zzanw() {
        synchronized (this.lock) {
            if (!this.zzfux) {
                this.zzfux = true;
                this.zzgnl.checkAvailabilityAndConnect();
            }
        }
    }

    private final void zzakj() {
        synchronized (this.lock) {
            if (this.zzgnl.isConnected() || this.zzgnl.isConnecting()) {
                this.zzgnl.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.lock) {
            if (!this.zzfuy) {
                this.zzfuy = true;
                try {
                    this.zzgnl.zzaob().zza(new zzczo(this.zzgnm.toByteArray()));
                    zzakj();
                } catch (Exception unused) {
                    zzakj();
                } catch (Throwable th) {
                    zzakj();
                    throw th;
                }
            }
        }
    }
}
