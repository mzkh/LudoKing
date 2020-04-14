package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcde implements Callable {
    private final zzaxl zzfdz;
    private final zzddi zzfov;
    private final String zzfqz;
    private final ApplicationInfo zzftv;
    private final List zzftw;
    private final PackageInfo zzftx;
    private final zzddi zzfty;
    private final zzaui zzftz;
    private final String zzfua;

    zzcde(zzddi zzddi, zzaxl zzaxl, ApplicationInfo applicationInfo, String str, List list, PackageInfo packageInfo, zzddi zzddi2, zzaui zzaui, String str2) {
        this.zzfov = zzddi;
        this.zzfdz = zzaxl;
        this.zzftv = applicationInfo;
        this.zzfqz = str;
        this.zzftw = list;
        this.zzftx = packageInfo;
        this.zzfty = zzddi2;
        this.zzftz = zzaui;
        this.zzfua = str2;
    }

    public final Object call() {
        zzddi zzddi = this.zzfov;
        zzaxl zzaxl = this.zzfdz;
        ApplicationInfo applicationInfo = this.zzftv;
        String str = this.zzfqz;
        List list = this.zzftw;
        PackageInfo packageInfo = this.zzftx;
        zzddi zzddi2 = this.zzfty;
        zzaui zzaui = this.zzftz;
        String str2 = this.zzfua;
        zzape zzape = new zzape((Bundle) zzddi.get(), zzaxl, applicationInfo, str, list, packageInfo, (String) zzddi2.get(), zzaui.zzvc(), str2);
        return zzape;
    }
}
