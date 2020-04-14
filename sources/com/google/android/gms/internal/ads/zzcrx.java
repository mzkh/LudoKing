package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcrx implements zzcrr<Bundle> {
    private final boolean zzdmf;
    private final boolean zzdmg;
    private final String zzdmi;
    private final boolean zzdmj;
    private final boolean zzdmk;
    private final boolean zzdml;
    private final String zzdmo;
    private final String zzdmp;
    private final String zzdmq;
    private final boolean zzdnd;
    private final ArrayList<String> zzggk;
    private final String zzggl;
    private final String zzggm;
    private final long zzggn;

    public zzcrx(boolean z, boolean z2, String str, boolean z3, boolean z4, boolean z5, String str2, ArrayList<String> arrayList, @Nullable String str3, @Nullable String str4, String str5, boolean z6, String str6, long j) {
        this.zzdmf = z;
        this.zzdmg = z2;
        this.zzdmi = str;
        this.zzdmj = z3;
        this.zzdmk = z4;
        this.zzdml = z5;
        this.zzdmo = str2;
        this.zzggk = arrayList;
        this.zzdmp = str3;
        this.zzdmq = str4;
        this.zzggl = str5;
        this.zzdnd = z6;
        this.zzggm = str6;
        this.zzggn = j;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putBoolean("cog", this.zzdmf);
        bundle.putBoolean("coh", this.zzdmg);
        bundle.putString("gl", this.zzdmi);
        bundle.putBoolean("simulator", this.zzdmj);
        bundle.putBoolean("is_latchsky", this.zzdmk);
        bundle.putBoolean("is_sidewinder", this.zzdml);
        bundle.putString("hl", this.zzdmo);
        if (!this.zzggk.isEmpty()) {
            bundle.putStringArrayList("hl_list", this.zzggk);
        }
        bundle.putString("mv", this.zzdmp);
        bundle.putString("submodel", this.zzggm);
        String str = TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX;
        Bundle zza = zzcwk.zza(bundle, str);
        bundle.putBundle(str, zza);
        zza.putString("build", this.zzggl);
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcnt)).booleanValue()) {
            zza.putLong("remaining_data_partition_space", this.zzggn);
        }
        String str2 = "browser";
        Bundle zza2 = zzcwk.zza(zza, str2);
        zza.putBundle(str2, zza2);
        zza2.putBoolean("is_browser_custom_tabs_capable", this.zzdnd);
        if (!TextUtils.isEmpty(this.zzdmq)) {
            String str3 = "play_store";
            Bundle zza3 = zzcwk.zza(zza, str3);
            zza.putBundle(str3, zza3);
            zza3.putString("package_version", this.zzdmq);
        }
    }
}
