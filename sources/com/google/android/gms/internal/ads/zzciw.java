package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzciw<AdT> implements zzcga<AdT> {
    /* access modifiers changed from: protected */
    public abstract zzddi<AdT> zza(zzcwe zzcwe, Bundle bundle);

    public final boolean zza(zzcvz zzcvz, zzcvr zzcvr) {
        return !TextUtils.isEmpty(zzcvr.zzgjh.optString("pubid", ""));
    }

    public final zzddi<AdT> zzb(zzcvz zzcvz, zzcvr zzcvr) {
        zzcvz zzcvz2 = zzcvz;
        zzcvr zzcvr2 = zzcvr;
        String optString = zzcvr2.zzgjh.optString("pubid", "");
        zzcwe zzcwe = zzcvz2.zzgka.zzfga;
        zzcwg zzgf = new zzcwg().zzg(zzcwe.zzgkg).zzd(zzcwe.zzbll).zzc(zzcwe.zzgke).zzgf(zzcwe.zzgkh).zzc(zzcwe.zzgkf).zzb(zzcwe.zzgki).zzc(zzcwe.zzgkj).zzb(zzcwe.zzdeh).zzb(zzcwe.zzgkk).zzb(zzcwe.zzgkl).zzgf(optString);
        Bundle zzm = zzm(zzcwe.zzgkg.zzcce);
        String str = "com.google.ads.mediation.admob.AdMobAdapter";
        Bundle zzm2 = zzm(zzm.getBundle(str));
        zzm2.putInt("gw", 1);
        String str2 = "mad_hac";
        String optString2 = zzcvr2.zzgjh.optString(str2, null);
        if (optString2 != null) {
            zzm2.putString(str2, optString2);
        }
        String optString3 = zzcvr2.zzgjh.optString("adJson", null);
        if (optString3 != null) {
            zzm2.putString("_ad", optString3);
        }
        zzm2.putBoolean("_noRefresh", true);
        Iterator keys = zzcvr2.zzgjk.keys();
        while (keys.hasNext()) {
            String str3 = (String) keys.next();
            String optString4 = zzcvr2.zzgjk.optString(str3, null);
            if (str3 != null) {
                zzm2.putString(str3, optString4);
            }
        }
        zzm.putBundle(str, zzm2);
        zztx zztx = r5;
        zztx zztx2 = new zztx(zzcwe.zzgkg.versionCode, zzcwe.zzgkg.zzcbx, zzm2, zzcwe.zzgkg.zzcby, zzcwe.zzgkg.zzcbz, zzcwe.zzgkg.zzcca, zzcwe.zzgkg.zzabj, zzcwe.zzgkg.zzbkg, zzcwe.zzgkg.zzccb, zzcwe.zzgkg.zzccc, zzcwe.zzgkg.zzng, zzcwe.zzgkg.zzccd, zzm, zzcwe.zzgkg.zzccf, zzcwe.zzgkg.zzccg, zzcwe.zzgkg.zzcch, zzcwe.zzgkg.zzcci, zzcwe.zzgkg.zzccj, zzcwe.zzgkg.zzcck, zzcwe.zzgkg.zzabk, zzcwe.zzgkg.zzabl);
        zzcwe zzane = zzgf.zzg(zztx).zzane();
        Bundle bundle = new Bundle();
        zzcvz zzcvz3 = zzcvz;
        zzcvt zzcvt = zzcvz3.zzgkb.zzgjy;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList(zzcvt.zzdcb));
        bundle2.putInt("refresh_interval", zzcvt.zzgju);
        bundle2.putString("gws_query_id", zzcvt.zzbzn);
        bundle.putBundle("parent_common_config", bundle2);
        String str4 = zzcvz3.zzgka.zzfga.zzgkh;
        Bundle bundle3 = new Bundle();
        bundle3.putString("initial_ad_unit_id", str4);
        zzcvr zzcvr3 = zzcvr;
        bundle3.putString("allocation_id", zzcvr3.zzdcu);
        bundle3.putStringArrayList("click_urls", new ArrayList(zzcvr3.zzdby));
        bundle3.putStringArrayList("imp_urls", new ArrayList(zzcvr3.zzdbz));
        bundle3.putStringArrayList("manual_tracking_urls", new ArrayList(zzcvr3.zzdks));
        bundle3.putStringArrayList("fill_urls", new ArrayList(zzcvr3.zzgjc));
        bundle3.putStringArrayList("video_start_urls", new ArrayList(zzcvr3.zzdlf));
        bundle3.putStringArrayList("video_reward_urls", new ArrayList(zzcvr3.zzdlg));
        bundle3.putStringArrayList("video_complete_urls", new ArrayList(zzcvr3.zzgjb));
        bundle3.putString("transaction_id", zzcvr3.zzddf);
        bundle3.putString("valid_from_timestamp", zzcvr3.zzddg);
        bundle3.putBoolean("is_closable_area_disabled", zzcvr3.zzble);
        if (zzcvr3.zzdle != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("rb_amount", zzcvr3.zzdle.zzdnv);
            bundle4.putString("rb_type", zzcvr3.zzdle.type);
            bundle3.putParcelableArray("rewards", new Bundle[]{bundle4});
        }
        bundle.putBundle("parent_ad_config", bundle3);
        return zza(zzane, bundle);
    }

    private static Bundle zzm(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }
}
