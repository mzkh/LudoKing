package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzckg implements zzbrj {
    private final /* synthetic */ zzcvz zzfzu;
    private final /* synthetic */ zzcvr zzfzv;
    private final /* synthetic */ zzcgf zzfzw;
    final /* synthetic */ zzcke zzfzx;

    zzckg(zzcke zzcke, zzcvz zzcvz, zzcvr zzcvr, zzcgf zzcgf) {
        this.zzfzx = zzcke;
        this.zzfzu = zzcvz;
        this.zzfzv = zzcvr;
        this.zzfzw = zzcgf;
    }

    public final void onInitializationSucceeded() {
        this.zzfzx.zzfbx.execute(new zzckj(this, this.zzfzu, this.zzfzv, this.zzfzw));
    }

    public final void zzde(int i) {
        String valueOf = String.valueOf(this.zzfzw.zzffi);
        String str = "Fail to initialize adapter ";
        zzaug.zzeu(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }
}
