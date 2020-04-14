package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcns implements zzcrr<Bundle> {
    private final zzcwe zzfga;

    public zzcns(zzcwe zzcwe) {
        Preconditions.checkNotNull(zzcwe, "the targeting must not be null");
        this.zzfga = zzcwe;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        zztx zztx = this.zzfga.zzgkg;
        bundle.putString("slotname", this.zzfga.zzgkh);
        boolean z = true;
        if (this.zzfga.zzgkn.contains("new_rewarded")) {
            bundle.putBoolean("is_new_rewarded", true);
        }
        zzcwk.zza(bundle, "cust_age", new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(zztx.zzcbx)), zztx.zzcbx != -1);
        zzcwk.zza(bundle, "extras", zztx.extras);
        zzcwk.zza(bundle, "cust_gender", Integer.valueOf(zztx.zzcby), zztx.zzcby != -1);
        zzcwk.zza(bundle, "kw", zztx.zzcbz);
        zzcwk.zza(bundle, "tag_for_child_directed_treatment", Integer.valueOf(zztx.zzabj), zztx.zzabj != -1);
        if (zztx.zzcca) {
            bundle.putBoolean("test_request", zztx.zzcca);
        }
        zzcwk.zza(bundle, "d_imp_hdr", Integer.valueOf(1), zztx.versionCode >= 2 && zztx.zzbkg);
        zzcwk.zza(bundle, "ppid", zztx.zzccb, zztx.versionCode >= 2 && !TextUtils.isEmpty(zztx.zzccb));
        if (zztx.zzng != null) {
            Location location = zztx.zzng;
            Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
            Long valueOf2 = Long.valueOf(location.getTime() * 1000);
            Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
            Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
            Bundle bundle2 = new Bundle();
            bundle2.putFloat("radius", valueOf.floatValue());
            bundle2.putLong("lat", valueOf3.longValue());
            bundle2.putLong("long", valueOf4.longValue());
            bundle2.putLong("time", valueOf2.longValue());
            bundle.putBundle("uule", bundle2);
        }
        zzcwk.zza(bundle, "url", zztx.zzccd);
        zzcwk.zza(bundle, "custom_targeting", zztx.zzccf);
        zzcwk.zza(bundle, "category_exclusions", zztx.zzccg);
        zzcwk.zza(bundle, "request_agent", zztx.zzcch);
        zzcwk.zza(bundle, "request_pkg", zztx.zzcci);
        zzcwk.zza(bundle, "is_designed_for_families", Boolean.valueOf(zztx.zzccj), zztx.versionCode >= 7);
        if (zztx.versionCode >= 8) {
            Integer valueOf5 = Integer.valueOf(zztx.zzabk);
            if (zztx.zzabk == -1) {
                z = false;
            }
            zzcwk.zza(bundle, "tag_for_under_age_of_consent", valueOf5, z);
            zzcwk.zza(bundle, "max_ad_content_rating", zztx.zzabl);
        }
    }
}
