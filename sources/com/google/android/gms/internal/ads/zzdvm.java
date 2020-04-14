package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzdvm extends zzdvk implements zzbb {
    private int flags;
    private int version;

    protected zzdvm(String str) {
        super(str);
    }

    public final int getVersion() {
        if (!this.zzhwo) {
            zzbdb();
        }
        return this.version;
    }

    /* access modifiers changed from: protected */
    public final long zzo(ByteBuffer byteBuffer) {
        this.version = zzbc.zza(byteBuffer.get());
        this.flags = (zzbc.zzb(byteBuffer) << 8) + 0 + zzbc.zza(byteBuffer.get());
        return 4;
    }
}
