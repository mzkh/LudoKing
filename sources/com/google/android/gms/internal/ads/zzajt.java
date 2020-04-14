package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.internal.zzq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzajt {
    private final long zzdbx;
    private final String zzdcr;
    private final String zzdcs;
    public final List<String> zzdct;
    private final String zzdcu;
    private final String zzdcv;
    private final List<String> zzdcw;
    private final List<String> zzdcx;
    private final List<String> zzdcy;
    private final List<String> zzdcz;
    private final List<String> zzdda;
    public final String zzddb;
    private final List<String> zzddc;
    private final List<String> zzddd;
    private final List<String> zzdde;
    private final String zzddf;
    private final String zzddg;
    @Nullable
    private final String zzddh;
    @Nullable
    private final String zzddi;
    private final String zzddj;
    @Nullable
    private final List<String> zzddk;
    private final String zzddl;
    @Nullable
    public final String zzddm;

    public zzajt(JSONObject jSONObject) throws JSONException {
        List<String> list;
        this.zzdcs = jSONObject.optString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.zzdct = Collections.unmodifiableList(arrayList);
        this.zzdcu = jSONObject.optString("allocation_id", null);
        zzq.zzlb();
        this.zzdcw = zzajv.zza(jSONObject, "clickurl");
        zzq.zzlb();
        this.zzdcx = zzajv.zza(jSONObject, "imp_urls");
        zzq.zzlb();
        this.zzdcy = zzajv.zza(jSONObject, "downloaded_imp_urls");
        zzq.zzlb();
        this.zzdda = zzajv.zza(jSONObject, "fill_urls");
        zzq.zzlb();
        this.zzddc = zzajv.zza(jSONObject, "video_start_urls");
        zzq.zzlb();
        this.zzdde = zzajv.zza(jSONObject, "video_complete_urls");
        zzq.zzlb();
        this.zzddd = zzajv.zza(jSONObject, "video_reward_urls");
        this.zzddf = jSONObject.optString("transaction_id");
        this.zzddg = jSONObject.optString("valid_from_timestamp");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        if (optJSONObject != null) {
            zzq.zzlb();
            list = zzajv.zza(optJSONObject, "manual_impression_urls");
        } else {
            list = null;
        }
        this.zzdcz = list;
        this.zzdcr = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        this.zzddb = optJSONObject2 != null ? optJSONObject2.toString() : null;
        this.zzdcv = optJSONObject2 != null ? optJSONObject2.optString("class_name") : null;
        this.zzddh = jSONObject.optString("html_template", null);
        this.zzddi = jSONObject.optString("ad_base_url", null);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("assets");
        this.zzddj = optJSONObject3 != null ? optJSONObject3.toString() : null;
        zzq.zzlb();
        this.zzddk = zzajv.zza(jSONObject, "template_ids");
        JSONObject optJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        this.zzddl = optJSONObject4 != null ? optJSONObject4.toString() : null;
        this.zzddm = jSONObject.optString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, null);
        this.zzdbx = jSONObject.optLong("ad_network_timeout_millis", -1);
    }
}
