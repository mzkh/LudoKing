package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdjn.zzb;
import com.google.android.gms.internal.ads.zzdjx.zza;
import com.google.android.gms.internal.ads.zzdjx.zza.C3504zza;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdek implements zzdeo {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final InputStream zzbey;
    private final JSONObject zzgsj;
    private boolean zzgsk = false;

    private zzdek(InputStream inputStream) {
        this.zzbey = inputStream;
        this.zzgsj = null;
    }

    public static zzdeo zzf(InputStream inputStream) throws IOException {
        return new zzdek(inputStream);
    }

    public final zzdjx zzapn() throws IOException {
        zzdjr zzdjr;
        zzdkj zzdkj;
        zzb zzb;
        String str = "keyMaterialType";
        String str2 = "value";
        String str3 = "typeUrl";
        String str4 = "outputPrefixType";
        String str5 = "keyId";
        String str6 = "status";
        String str7 = "keyData";
        String str8 = "primaryKeyId";
        String str9 = "key";
        try {
            JSONObject jSONObject = new JSONObject(new String(zzdfb.zzg(this.zzbey), UTF_8));
            if (!jSONObject.has(str9) || jSONObject.getJSONArray(str9).length() == 0) {
                throw new JSONException("invalid keyset");
            }
            zzdjx.zzb zzaul = zzdjx.zzaul();
            if (jSONObject.has(str8)) {
                zzaul.zzet(jSONObject.getInt(str8));
            }
            JSONArray jSONArray = jSONObject.getJSONArray(str9);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (!jSONObject2.has(str7) || !jSONObject2.has(str6) || !jSONObject2.has(str5) || !jSONObject2.has(str4)) {
                    throw new JSONException("invalid key");
                }
                C3504zza zzauq = zza.zzauq();
                String string = jSONObject2.getString(str6);
                if (string.equals("ENABLED")) {
                    zzdjr = zzdjr.ENABLED;
                } else if (string.equals("DISABLED")) {
                    zzdjr = zzdjr.DISABLED;
                } else {
                    String str10 = "unknown status: ";
                    String valueOf = String.valueOf(string);
                    throw new JSONException(valueOf.length() != 0 ? str10.concat(valueOf) : new String(str10));
                }
                C3504zza zzeu = zzauq.zzb(zzdjr).zzeu(jSONObject2.getInt(str5));
                String string2 = jSONObject2.getString(str4);
                if (string2.equals("TINK")) {
                    zzdkj = zzdkj.TINK;
                } else if (string2.equals("RAW")) {
                    zzdkj = zzdkj.RAW;
                } else if (string2.equals("LEGACY")) {
                    zzdkj = zzdkj.LEGACY;
                } else if (string2.equals("CRUNCHY")) {
                    zzdkj = zzdkj.CRUNCHY;
                } else {
                    String str11 = "unknown output prefix type: ";
                    String valueOf2 = String.valueOf(string2);
                    throw new JSONException(valueOf2.length() != 0 ? str11.concat(valueOf2) : new String(str11));
                }
                C3504zza zzb2 = zzeu.zzb(zzdkj);
                JSONObject jSONObject3 = jSONObject2.getJSONObject(str7);
                if (!jSONObject3.has(str3) || !jSONObject3.has(str2) || !jSONObject3.has(str)) {
                    throw new JSONException("invalid keyData");
                }
                zzdjn.zza zzbo = zzdjn.zzatx().zzgw(jSONObject3.getString(str3)).zzbo(zzdpm.zzy(zzdmm.decode(jSONObject3.getString(str2))));
                String string3 = jSONObject3.getString(str);
                if (string3.equals("SYMMETRIC")) {
                    zzb = zzb.SYMMETRIC;
                } else if (string3.equals("ASYMMETRIC_PRIVATE")) {
                    zzb = zzb.ASYMMETRIC_PRIVATE;
                } else if (string3.equals("ASYMMETRIC_PUBLIC")) {
                    zzb = zzb.ASYMMETRIC_PUBLIC;
                } else if (string3.equals("REMOTE")) {
                    zzb = zzb.REMOTE;
                } else {
                    String str12 = "unknown key material type: ";
                    String valueOf3 = String.valueOf(string3);
                    throw new JSONException(valueOf3.length() != 0 ? str12.concat(valueOf3) : new String(str12));
                }
                zzaul.zzb((zza) ((zzdqw) zzb2.zzb((zzdjn) ((zzdqw) zzbo.zzb(zzb).zzazr())).zzazr()));
            }
            return (zzdjx) ((zzdqw) zzaul.zzazr());
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }
}
