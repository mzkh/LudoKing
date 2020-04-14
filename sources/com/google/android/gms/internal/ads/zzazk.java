package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzazk {
    public final boolean zzeai;
    public final int zzeaj;
    public final int zzeak;
    public final int zzeal;
    public final String zzeam;
    public final int zzean;
    public final int zzeao;
    public final int zzeap;
    public final int zzeaq;
    public final boolean zzear;
    public final int zzeas;

    public zzazk(String str) {
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        this.zzeai = zza(jSONObject, "aggressive_media_codec_release", zzza.zzchu);
        this.zzeaj = zzb(jSONObject, "byte_buffer_precache_limit", zzza.zzchb);
        this.zzeak = zzb(jSONObject, "exo_cache_buffer_size", zzza.zzchi);
        this.zzeal = zzb(jSONObject, "exo_connect_timeout_millis", zzza.zzcgx);
        this.zzeam = zzc(jSONObject, "exo_player_version", zzza.zzcgw);
        this.zzean = zzb(jSONObject, "exo_read_timeout_millis", zzza.zzcgy);
        this.zzeao = zzb(jSONObject, "load_check_interval_bytes", zzza.zzcgz);
        this.zzeap = zzb(jSONObject, "player_precache_limit", zzza.zzcha);
        this.zzeaq = zzb(jSONObject, "socket_receive_buffer_size", zzza.zzchc);
        this.zzear = zza(jSONObject, "use_cache_data_source", zzza.zzcpr);
        this.zzeas = zzb(jSONObject, "min_retry_count", zzza.zzche);
    }

    private static boolean zza(JSONObject jSONObject, String str, zzyp<Boolean> zzyp) {
        return zza(jSONObject, str, ((Boolean) zzuv.zzon().zzd(zzyp)).booleanValue());
    }

    private static boolean zza(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null) {
            try {
                return jSONObject.getBoolean(str);
            } catch (JSONException unused) {
            }
        }
        return z;
    }

    private static int zzb(JSONObject jSONObject, String str, zzyp<Integer> zzyp) {
        if (jSONObject != null) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
            }
        }
        return ((Integer) zzuv.zzon().zzd(zzyp)).intValue();
    }

    private static String zzc(JSONObject jSONObject, String str, zzyp<String> zzyp) {
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException unused) {
            }
        }
        return (String) zzuv.zzon().zzd(zzyp);
    }
}
