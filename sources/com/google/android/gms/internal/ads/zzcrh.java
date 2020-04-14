package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcrh implements zzcru<zzcri> {
    private final zzasl zzbnf;
    private final zzddl zzfoa;
    private final Context zzlk;

    public zzcrh(zzasl zzasl, zzddl zzddl, Context context) {
        this.zzbnf = zzasl;
        this.zzfoa = zzddl;
        this.zzlk = context;
    }

    public final zzddi<zzcri> zzalv() {
        return this.zzfoa.zzd(new zzcrk(this));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzcri zzamg() throws Exception {
        if (!this.zzbnf.zzab(this.zzlk)) {
            zzcri zzcri = new zzcri(null, null, null, null, null);
            return zzcri;
        }
        String zzae = this.zzbnf.zzae(this.zzlk);
        String str = "";
        String str2 = zzae == null ? str : zzae;
        String zzaf = this.zzbnf.zzaf(this.zzlk);
        String str3 = zzaf == null ? str : zzaf;
        String zzag = this.zzbnf.zzag(this.zzlk);
        String str4 = zzag == null ? str : zzag;
        String zzah = this.zzbnf.zzah(this.zzlk);
        zzcri zzcri2 = new zzcri(str2, str3, str4, zzah == null ? str : zzah, "TIME_OUT".equals(str3) ? (Long) zzuv.zzon().zzd(zzza.zzcjk) : null);
        return zzcri2;
    }
}
