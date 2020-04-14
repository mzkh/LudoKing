package com.google.android.gms.internal.nearby;

import android.util.Log;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class zzff {
    private final ExecutorService zzdo = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */
    public volatile InputStream zzdp = null;
    /* access modifiers changed from: private */
    public volatile boolean zzdq = false;

    /* access modifiers changed from: private */
    public static void zza(OutputStream outputStream, boolean z, long j) {
        try {
            outputStream.write(z ? 1 : 0);
        } catch (IOException e) {
            Log.w("NearbyConnections", String.format("Unable to deliver status for Payload %d", new Object[]{Long.valueOf(j)}), e);
        } finally {
            IOUtils.closeQuietly((Closeable) outputStream);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void shutdown() {
        this.zzdq = true;
        this.zzdo.shutdownNow();
        IOUtils.closeQuietly((Closeable) this.zzdp);
    }

    /* access modifiers changed from: 0000 */
    public final void zza(InputStream inputStream, OutputStream outputStream, OutputStream outputStream2, long j) {
        ExecutorService executorService = this.zzdo;
        zzfg zzfg = new zzfg(this, inputStream, outputStream, j, outputStream2);
        executorService.execute(zzfg);
    }
}
