package com.google.android.gms.internal.ads;

import com.google.ads.mediation.inmobi.InMobiNetworkValues;
import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbwp implements Callable {
    private final zzcvr zzfea;
    private final zzbwm zzfod;
    private final zzcvz zzfom;
    private final JSONObject zzfon;

    zzbwp(zzbwm zzbwm, zzcvz zzcvz, zzcvr zzcvr, JSONObject jSONObject) {
        this.zzfod = zzbwm;
        this.zzfom = zzcvz;
        this.zzfea = zzcvr;
        this.zzfon = jSONObject;
    }

    public final Object call() {
        zzbwm zzbwm = this.zzfod;
        zzcvz zzcvz = this.zzfom;
        zzcvr zzcvr = this.zzfea;
        JSONObject jSONObject = this.zzfon;
        zzbur zzbur = new zzbur();
        zzbur.zzdg(jSONObject.optInt("template_id", -1));
        zzbur.zzfr(jSONObject.optString("custom_template_id"));
        JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
        zzbur.zzfs(optJSONObject != null ? optJSONObject.optString("omid_partner_name") : null);
        zzcwe zzcwe = zzcvz.zzgka.zzfga;
        if (zzcwe.zzgki.contains(Integer.toString(zzbur.zzahp()))) {
            if (zzbur.zzahp() == 3) {
                if (zzbur.getCustomTemplateId() == null) {
                    throw new zzcjh("No custom template id for custom template ad response.", 0);
                } else if (!zzcwe.zzgkj.contains(zzbur.getCustomTemplateId())) {
                    throw new zzcjh("Unexpected custom template id in the response.", 0);
                }
            }
            zzbur.setStarRating(jSONObject.optDouble(InMobiNetworkValues.RATING, -1.0d));
            String str = "headline";
            String optString = jSONObject.optString(str, null);
            if (zzcvr.zzdnj) {
                zzq.zzkj();
                String zzvp = zzaul.zzvp();
                StringBuilder sb = new StringBuilder(String.valueOf(zzvp).length() + 3 + String.valueOf(optString).length());
                sb.append(zzvp);
                sb.append(" : ");
                sb.append(optString);
                optString = sb.toString();
            }
            zzbur.zzo(str, optString);
            String str2 = "body";
            zzbur.zzo(str2, jSONObject.optString(str2, null));
            String str3 = "call_to_action";
            zzbur.zzo(str3, jSONObject.optString(str3, null));
            String str4 = "store";
            zzbur.zzo(str4, jSONObject.optString(str4, null));
            String str5 = "price";
            zzbur.zzo(str5, jSONObject.optString(str5, null));
            String str6 = "advertiser";
            zzbur.zzo(str6, jSONObject.optString(str6, null));
            return zzbur;
        }
        int zzahp = zzbur.zzahp();
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append("Invalid template ID: ");
        sb2.append(zzahp);
        throw new zzcjh(sb2.toString(), 0);
    }
}
