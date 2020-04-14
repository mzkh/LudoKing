package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import java.io.InputStream;
import java.util.concurrent.Future;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzrv {
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    @Nullable
    public zzrq zzbrc;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public boolean zzbrp;
    private final Context zzlk;

    zzrv(Context context) {
        this.zzlk = context;
    }

    /* access modifiers changed from: 0000 */
    public final Future<InputStream> zzb(zzrp zzrp) {
        zzry zzry = new zzry(this);
        zzrx zzrx = new zzrx(this, zzrp, zzry);
        zzsb zzsb = new zzsb(this, zzry);
        synchronized (this.lock) {
            this.zzbrc = new zzrq(this.zzlk, zzq.zzkx().zzwd(), zzrx, zzsb);
            this.zzbrc.checkAvailabilityAndConnect();
        }
        return zzry;
    }

    /* access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.lock) {
            if (this.zzbrc != null) {
                this.zzbrc.disconnect();
                this.zzbrc = null;
                Binder.flushPendingCommands();
            }
        }
    }
}
