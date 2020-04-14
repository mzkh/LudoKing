package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzlq implements zzlt, zzlu {
    private final Uri uri;
    private final Handler zzacs;
    private final zzha zzacw;
    private zzgy zzadd;
    private final int zzazt;
    private final zzlp zzazu;
    private zzlt zzazv;
    private final String zzazx = null;
    private final zznd zzbbb;
    private final zzix zzbbc;
    private final int zzbbd;
    private boolean zzbbe;

    public zzlq(Uri uri2, zznd zznd, zzix zzix, int i, Handler handler, zzlp zzlp, String str, int i2) {
        this.uri = uri2;
        this.zzbbb = zznd;
        this.zzbbc = zzix;
        this.zzazt = i;
        this.zzacs = handler;
        this.zzazu = zzlp;
        this.zzbbd = i2;
        this.zzacw = new zzha();
    }

    public final void zzhl() throws IOException {
    }

    public final void zza(zzgc zzgc, boolean z, zzlt zzlt) {
        this.zzazv = zzlt;
        this.zzadd = new zzmi(-9223372036854775807L, false);
        zzlt.zzb(this.zzadd, null);
    }

    public final zzls zza(int i, zznc zznc) {
        zznr.checkArgument(i == 0);
        zzli zzli = new zzli(this.uri, this.zzbbb.zzib(), this.zzbbc.zzgd(), this.zzazt, this.zzacs, this.zzazu, this, zznc, null, this.zzbbd);
        return zzli;
    }

    public final void zzb(zzls zzls) {
        ((zzli) zzls).release();
    }

    public final void zzhm() {
        this.zzazv = null;
    }

    public final void zzb(zzgy zzgy, Object obj) {
        boolean z = false;
        if (zzgy.zza(0, this.zzacw, false).zzagh != -9223372036854775807L) {
            z = true;
        }
        if (!this.zzbbe || z) {
            this.zzadd = zzgy;
            this.zzbbe = z;
            this.zzazv.zzb(this.zzadd, null);
        }
    }
}
