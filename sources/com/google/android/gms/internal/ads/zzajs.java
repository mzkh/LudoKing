package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzajs {
    public final List<zzajt> zzdbw;
    private final long zzdbx;
    private final List<String> zzdby;
    private final List<String> zzdbz;
    private final List<String> zzdca;
    private final List<String> zzdcb;
    private final List<String> zzdcc;
    private final boolean zzdcd;
    private final String zzdce;
    private final long zzdcf;
    private final String zzdcg;
    private final int zzdch;
    private final int zzdci;
    private final long zzdcj;
    private final boolean zzdck;
    private final boolean zzdcl;
    private final boolean zzdcm;
    private final boolean zzdcn;
    private int zzdco;
    private int zzdcp;
    private boolean zzdcq;

    public zzajs(JSONObject jSONObject) throws JSONException {
        if (zzaug.isLoggable(2)) {
            String str = "Mediation Response JSON: ";
            String valueOf = String.valueOf(jSONObject.toString(2));
            zzaug.zzdy(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                zzajt zzajt = new zzajt(jSONArray.getJSONObject(i2));
                boolean z = true;
                if ("banner".equalsIgnoreCase(zzajt.zzddm)) {
                    this.zzdcq = true;
                }
                arrayList.add(zzajt);
                if (i < 0) {
                    Iterator it = zzajt.zzdct.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((String) it.next()).equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        i = i2;
                    }
                }
            } catch (JSONException unused) {
            }
        }
        this.zzdco = i;
        this.zzdcp = jSONArray.length();
        this.zzdbw = Collections.unmodifiableList(arrayList);
        this.zzdce = jSONObject.optString("qdata");
        this.zzdci = jSONObject.optInt("fs_model_type", -1);
        long j = -1;
        this.zzdcj = jSONObject.optLong("timeout_ms", -1);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.zzdbx = optJSONObject.optLong("ad_network_timeout_millis", -1);
            zzq.zzlb();
            this.zzdby = zzajv.zza(optJSONObject, "click_urls");
            zzq.zzlb();
            this.zzdbz = zzajv.zza(optJSONObject, "imp_urls");
            zzq.zzlb();
            this.zzdca = zzajv.zza(optJSONObject, "downloaded_imp_urls");
            zzq.zzlb();
            this.zzdcb = zzajv.zza(optJSONObject, "nofill_urls");
            zzq.zzlb();
            this.zzdcc = zzajv.zza(optJSONObject, "remote_ping_urls");
            this.zzdcd = optJSONObject.optBoolean("render_in_browser", false);
            long optLong = optJSONObject.optLong("refresh", -1);
            if (optLong > 0) {
                j = 1000 * optLong;
            }
            this.zzdcf = j;
            zzaqt zza = zzaqt.zza(optJSONObject.optJSONArray("rewards"));
            if (zza == null) {
                this.zzdcg = null;
                this.zzdch = 0;
            } else {
                this.zzdcg = zza.type;
                this.zzdch = zza.zzdnv;
            }
            this.zzdck = optJSONObject.optBoolean("use_displayed_impression", false);
            this.zzdcl = optJSONObject.optBoolean("allow_pub_rendered_attribution", false);
            this.zzdcm = optJSONObject.optBoolean("allow_pub_owned_ad_view", false);
            this.zzdcn = optJSONObject.optBoolean("allow_custom_click_gesture", false);
            return;
        }
        this.zzdbx = -1;
        this.zzdby = null;
        this.zzdbz = null;
        this.zzdca = null;
        this.zzdcb = null;
        this.zzdcc = null;
        this.zzdcf = -1;
        this.zzdcg = null;
        this.zzdch = 0;
        this.zzdck = false;
        this.zzdcd = false;
        this.zzdcl = false;
        this.zzdcm = false;
        this.zzdcn = false;
    }
}
