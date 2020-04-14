package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.appsflyer.share.Constants;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaea {
    public static final zzaer<zzbbw> zzcxe = zzaed.zzcxw;
    public static final zzaer<zzbbw> zzcxf = zzaec.zzcxw;
    public static final zzaer<zzbbw> zzcxg = zzaef.zzcxw;
    public static final zzaer<zzbbw> zzcxh = new zzaeg();
    public static final zzaer<zzbbw> zzcxi = new zzaej();
    public static final zzaer<zzbbw> zzcxj = zzaee.zzcxw;
    public static final zzaer<Object> zzcxk = new zzaei();
    public static final zzaer<zzbbw> zzcxl = new zzael();
    public static final zzaer<zzbbw> zzcxm = zzaeh.zzcxw;
    public static final zzaer<zzbbw> zzcxn = new zzaek();
    public static final zzaer<zzbbw> zzcxo = new zzaen();
    public static final zzaer<zzazj> zzcxp = new zzbau();
    public static final zzaer<zzazj> zzcxq = new zzbat();
    public static final zzaer<zzbbw> zzcxr = new zzaeb();
    public static final zzaex zzcxs = new zzaex();
    public static final zzaer<zzbbw> zzcxt = new zzaem();
    public static final zzaer<zzbbw> zzcxu = new zzaep();
    public static final zzaer<zzbbw> zzcxv = new zzaeo();

    static final /* synthetic */ void zza(zzbdb zzbdb, Map map) {
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            zzdf zzzs = zzbdb.zzzs();
            if (zzzs != null) {
                zzzs.zzcd().zza(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException unused) {
            zzaug.zzeu("Could not parse touch parameters from gmsg.");
        }
    }

    static final /* synthetic */ void zza(zzbct zzbct, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            zzaug.zzeu("URL missing from httpTrack GMSG.");
        } else {
            new zzawl(zzbct.getContext(), ((zzbde) zzbct).zzxr().zzblz, str).zzut();
        }
    }

    static final /* synthetic */ void zza(zzagn zzagn, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            zzaug.zzeu("URL missing from click GMSG.");
            return;
        }
        Uri parse = Uri.parse(str);
        try {
            zzdf zzzs = ((zzbdb) zzagn).zzzs();
            if (zzzs != null && zzzs.zzc(parse)) {
                parse = zzzs.zza(parse, ((zzbct) zzagn).getContext(), ((zzbdd) zzagn).getView(), ((zzbct) zzagn).zzxn());
            }
        } catch (zzdi unused) {
            String str2 = "Unable to append parameter to URL: ";
            String valueOf = String.valueOf(str);
            zzaug.zzeu(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        zzbct zzbct = (zzbct) zzagn;
        new zzawl(zzbct.getContext(), ((zzbde) zzagn).zzxr().zzblz, zzate.zzc(parse, zzbct.getContext())).zzut();
    }

    static final /* synthetic */ void zzb(zzbct zzbct, Map map) {
        String str = "openableIntents";
        PackageManager packageManager = zzbct.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("id");
                        String optString2 = jSONObject2.optString("u");
                        String optString3 = jSONObject2.optString("i");
                        String optString4 = jSONObject2.optString("m");
                        String optString5 = jSONObject2.optString("p");
                        String optString6 = jSONObject2.optString(Constants.URL_CAMPAIGN);
                        jSONObject2.optString("f");
                        jSONObject2.optString("e");
                        String optString7 = jSONObject2.optString("intent_url");
                        Intent intent = null;
                        if (!TextUtils.isEmpty(optString7)) {
                            try {
                                intent = Intent.parseUri(optString7, 0);
                            } catch (URISyntaxException e) {
                                URISyntaxException uRISyntaxException = e;
                                String str2 = "Error parsing the url: ";
                                String valueOf = String.valueOf(optString7);
                                zzaug.zzc(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), uRISyntaxException);
                            }
                        }
                        boolean z = true;
                        if (intent == null) {
                            intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split(Constants.URL_PATH_DELIMITER, 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                        }
                        if (packageManager.resolveActivity(intent, 65536) == null) {
                            z = false;
                        }
                        try {
                            jSONObject.put(optString, z);
                        } catch (JSONException e2) {
                            zzaug.zzc("Error constructing openable urls response.", e2);
                        }
                    } catch (JSONException e3) {
                        zzaug.zzc("Error parsing the intent data.", e3);
                    }
                }
                ((zzagn) zzbct).zzb(str, jSONObject);
            } catch (JSONException unused) {
                ((zzagn) zzbct).zzb(str, new JSONObject());
            }
        } catch (JSONException unused2) {
            ((zzagn) zzbct).zzb(str, new JSONObject());
        }
    }

    static final /* synthetic */ void zzc(zzbct zzbct, Map map) {
        String str = (String) map.get("urls");
        if (TextUtils.isEmpty(str)) {
            zzaug.zzeu("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] split = str.split(",");
        HashMap hashMap = new HashMap();
        PackageManager packageManager = zzbct.getContext().getPackageManager();
        for (String str2 : split) {
            String[] split2 = str2.split(";", 2);
            boolean z = true;
            if (packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) == null) {
                z = false;
            }
            hashMap.put(str2, Boolean.valueOf(z));
        }
        ((zzagn) zzbct).zza("openableURLs", hashMap);
    }
}
