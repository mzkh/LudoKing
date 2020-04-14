package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcrl implements zzcru<zzcrm> {
    private final zzaxl zzblk;
    private final zzddl zzfoa;
    private final Context zzlk;

    public zzcrl(zzddl zzddl, Context context, zzaxl zzaxl) {
        this.zzfoa = zzddl;
        this.zzlk = context;
        this.zzblk = zzaxl;
    }

    public final zzddi<zzcrm> zzalv() {
        return this.zzfoa.zzd(new zzcro(this));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzcrm zzamh() throws Exception {
        boolean isCallerInstantApp = Wrappers.packageManager(this.zzlk).isCallerInstantApp();
        zzq.zzkj();
        boolean zzay = zzaul.zzay(this.zzlk);
        String str = this.zzblk.zzblz;
        zzq.zzkl();
        boolean zzvs = zzaur.zzvs();
        zzq.zzkj();
        int zzav = zzaul.zzav(this.zzlk);
        Context context = this.zzlk;
        String str2 = ModuleDescriptor.MODULE_ID;
        zzcrm zzcrm = new zzcrm(isCallerInstantApp, zzay, str, zzvs, zzav, DynamiteModule.getRemoteVersion(context, str2), DynamiteModule.getLocalVersion(this.zzlk, str2));
        return zzcrm;
    }
}
