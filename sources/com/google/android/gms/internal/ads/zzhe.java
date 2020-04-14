package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public interface zzhe {
    public static final ByteBuffer zzagy = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    void flush();

    boolean isActive();

    void reset();

    boolean zzb(int i, int i2, int i3) throws zzhh;

    boolean zzeo();

    int zzet();

    int zzeu();

    void zzev();

    ByteBuffer zzew();

    void zzi(ByteBuffer byteBuffer);
}
