package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

@TargetApi(19)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzht extends zzhq {
    private final AudioTimestamp zzajz = new AudioTimestamp();
    private long zzaka;
    private long zzakb;
    private long zzakc;

    public zzht() {
        super(null);
    }

    public final void zza(AudioTrack audioTrack, boolean z) {
        super.zza(audioTrack, z);
        this.zzaka = 0;
        this.zzakb = 0;
        this.zzakc = 0;
    }

    public final boolean zzfk() {
        boolean timestamp = this.zzahy.getTimestamp(this.zzajz);
        if (timestamp) {
            long j = this.zzajz.framePosition;
            if (this.zzakb > j) {
                this.zzaka++;
            }
            this.zzakb = j;
            this.zzakc = j + (this.zzaka << 32);
        }
        return timestamp;
    }

    public final long zzfl() {
        return this.zzajz.nanoTime;
    }

    public final long zzfm() {
        return this.zzakc;
    }
}
