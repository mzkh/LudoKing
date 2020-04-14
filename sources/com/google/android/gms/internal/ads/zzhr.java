package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzhr extends Thread {
    private final /* synthetic */ AudioTrack zzajx;
    private final /* synthetic */ zzho zzajy;

    zzhr(zzho zzho, AudioTrack audioTrack) {
        this.zzajy = zzho;
        this.zzajx = audioTrack;
    }

    public final void run() {
        try {
            this.zzajx.flush();
            this.zzajx.release();
        } finally {
            this.zzajy.zzahu.open();
        }
    }
}
