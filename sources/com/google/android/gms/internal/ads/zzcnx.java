package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcnx implements zzcrr<Bundle> {
    private final String zzabd;
    private final zzua zzbll;
    private final float zzbog;
    private final boolean zzcco;
    private final int zzdgn;
    private final int zzdgo;
    private final String zzgea;
    private final String zzgeb;

    public zzcnx(zzua zzua, String str, boolean z, String str2, float f, int i, int i2, String str3) {
        Preconditions.checkNotNull(zzua, "the adSize must not be null");
        this.zzbll = zzua;
        this.zzabd = str;
        this.zzcco = z;
        this.zzgea = str2;
        this.zzbog = f;
        this.zzdgn = i;
        this.zzdgo = i2;
        this.zzgeb = str3;
    }

    public final /* synthetic */ void zzr(Object obj) {
        zzua[] zzuaArr;
        Bundle bundle = (Bundle) obj;
        zzcwk.zza(bundle, "smart_w", MessengerShareContentUtility.WEBVIEW_RATIO_FULL, this.zzbll.width == -1);
        zzcwk.zza(bundle, "smart_h", "auto", this.zzbll.height == -2);
        zzcwk.zza(bundle, "ene", Boolean.valueOf(true), this.zzbll.zzccp);
        zzcwk.zza(bundle, "rafmt", "102", this.zzbll.zzccs);
        zzcwk.zza(bundle, "format", this.zzabd);
        String str = "height";
        zzcwk.zza(bundle, "fluid", str, this.zzcco);
        String str2 = this.zzgea;
        zzcwk.zza(bundle, "sz", str2, !TextUtils.isEmpty(str2));
        bundle.putFloat("u_sd", this.zzbog);
        bundle.putInt("sw", this.zzdgn);
        bundle.putInt("sh", this.zzdgo);
        String str3 = this.zzgeb;
        zzcwk.zza(bundle, "sc", str3, true ^ TextUtils.isEmpty(str3));
        ArrayList arrayList = new ArrayList();
        String str4 = "is_fluid_height";
        String str5 = "width";
        if (this.zzbll.zzccn == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt(str, this.zzbll.height);
            bundle2.putInt(str5, this.zzbll.width);
            bundle2.putBoolean(str4, this.zzbll.zzcco);
            arrayList.add(bundle2);
        } else {
            for (zzua zzua : this.zzbll.zzccn) {
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean(str4, zzua.zzcco);
                bundle3.putInt(str, zzua.height);
                bundle3.putInt(str5, zzua.width);
                arrayList.add(bundle3);
            }
        }
        bundle.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
