package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbf extends zzdvk {
    private ByteBuffer zzcq;

    public zzbf(String str) {
        super(str);
    }

    public final void zzg(ByteBuffer byteBuffer) {
        this.zzcq = byteBuffer;
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
    }
}
