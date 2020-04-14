package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzqk {
    @VisibleForTesting
    private ByteArrayOutputStream zzbqj = new ByteArrayOutputStream(4096);
    @VisibleForTesting
    private Base64OutputStream zzbqk = new Base64OutputStream(this.zzbqj, 10);

    public final void write(byte[] bArr) throws IOException {
        this.zzbqk.write(bArr);
    }

    public final String toString() {
        String str = "HashManager: Unable to convert to Base64.";
        try {
            this.zzbqk.close();
        } catch (IOException e) {
            zzaug.zzc(str, e);
        }
        try {
            this.zzbqj.close();
            return this.zzbqj.toString();
        } catch (IOException e2) {
            zzaug.zzc(str, e2);
            return "";
        } finally {
            this.zzbqj = null;
            this.zzbqk = null;
        }
    }
}
