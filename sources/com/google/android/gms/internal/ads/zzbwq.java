package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.games.GamesStatusCodes;
import com.tapjoy.TJAdUnitConstants.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbwq {
    private final Executor executor;
    private final zzaxl zzblk;
    private final zzaay zzdeh;
    private final zzsd zzeen;
    private final zzdf zzegb;
    private final ScheduledExecutorService zzffn;
    private final zzbwl zzfoo;
    private final zza zzfop;
    private final zzbxe zzfoq;
    private final Context zzlk;

    public zzbwq(Context context, zzbwl zzbwl, zzdf zzdf, zzaxl zzaxl, zza zza, zzsd zzsd, Executor executor2, zzcwe zzcwe, zzbxe zzbxe, ScheduledExecutorService scheduledExecutorService) {
        this.zzlk = context;
        this.zzfoo = zzbwl;
        this.zzegb = zzdf;
        this.zzblk = zzaxl;
        this.zzfop = zza;
        this.zzeen = zzsd;
        this.executor = executor2;
        this.zzdeh = zzcwe.zzdeh;
        this.zzfoq = zzbxe;
        this.zzffn = scheduledExecutorService;
    }

    public static List<zzxk> zzi(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("mute");
        if (optJSONObject == null) {
            return Collections.emptyList();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("reasons");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            zzxk zzk = zzk(optJSONArray.optJSONObject(i));
            if (zzk != null) {
                arrayList.add(zzk);
            }
        }
        return arrayList;
    }

    @Nullable
    public static zzxk zzj(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("mute");
        if (optJSONObject == null) {
            return null;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("default_reason");
        if (optJSONObject2 == null) {
            return null;
        }
        return zzk(optJSONObject2);
    }

    @Nullable
    private static zzxk zzk(@Nullable JSONObject jSONObject) {
        zzxk zzxk = null;
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("reason");
        String optString2 = jSONObject.optString("ping_url");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            zzxk = new zzxk(optString, optString2);
        }
        return zzxk;
    }

    public final zzddi<zzaau> zzc(JSONObject jSONObject, String str) {
        return zza(jSONObject.optJSONObject(str), this.zzdeh.zzcvz);
    }

    public final zzddi<List<zzaau>> zzd(JSONObject jSONObject, String str) {
        return zza(jSONObject.optJSONArray(str), this.zzdeh.zzcvz, this.zzdeh.zzbjx);
    }

    private final zzddi<List<zzaau>> zza(@Nullable JSONArray jSONArray, boolean z, boolean z2) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzdcy.zzah(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            arrayList.add(zza(jSONArray.optJSONObject(i), z));
        }
        return zzdcy.zzb(zzdcy.zzg(arrayList), zzbwt.zzdos, this.executor);
    }

    private final zzddi<zzaau> zza(@Nullable JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzdcy.zzah(null);
        }
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            return zzdcy.zzah(null);
        }
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        int optInt = jSONObject.optInt("width", -1);
        int optInt2 = jSONObject.optInt("height", -1);
        if (z) {
            zzaau zzaau = new zzaau(null, Uri.parse(optString), optDouble, optInt, optInt2);
            return zzdcy.zzah(zzaau);
        }
        zzddi zza = this.zzfoo.zza(optString, optDouble, optBoolean);
        zzbws zzbws = new zzbws(optString, optDouble, optInt, optInt2);
        return zza(jSONObject.optBoolean("require"), zzdcy.zzb(zza, (zzdal<? super I, ? extends O>) zzbws, this.executor), (T) null);
    }

    public final zzddi<zzaat> zze(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return zzdcy.zzah(null);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("images");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(MessengerShareContentUtility.MEDIA_IMAGE);
        if (optJSONArray == null && optJSONObject2 != null) {
            optJSONArray = new JSONArray();
            optJSONArray.put(optJSONObject2);
        }
        return zza(optJSONObject.optBoolean("require"), zzdcy.zzb(zza(optJSONArray, false, true), (zzdal<? super I, ? extends O>) new zzbwv<Object,Object>(this, optJSONObject), this.executor), (T) null);
    }

    private static Integer zzf(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final zzddi<zzbbw> zzl(JSONObject jSONObject) {
        JSONObject zza = zzawg.zza(jSONObject, "html_containers", "instream");
        if (zza == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("video");
            if (optJSONObject == null) {
                return zzdcy.zzah(null);
            }
            if (TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
                zzaug.zzeu("Required field 'vast_xml' is missing");
                return zzdcy.zzah(null);
            }
            return zza(zzdcy.zza(this.zzfoq.zzm(optJSONObject), (long) ((Integer) zzuv.zzon().zzd(zzza.zzcoe)).intValue(), TimeUnit.SECONDS, this.zzffn), (T) null);
        }
        return zza(zza.optBoolean("require"), this.zzfoq.zzp(zza.optString("base_url"), zza.optString(String.HTML)), (T) null);
    }

    private static <T> zzddi<T> zza(zzddi<T> zzddi, T t) {
        return zzdcy.zzb(zzddi, Exception.class, new zzbwx(null), zzaxn.zzdwn);
    }

    private static <T> zzddi<T> zza(boolean z, zzddi<T> zzddi, T t) {
        if (z) {
            return zzdcy.zzb(zzddi, (zzdcj<? super I, ? extends O>) new zzbww<Object,Object>(zzddi), (Executor) zzaxn.zzdwn);
        }
        return zza(zzddi, (T) null);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzddi zzb(String str, Object obj) throws Exception {
        zzq.zzkk();
        zzbbw zza = zzbcb.zza(this.zzlk, zzbdj.zzaar(), "native-omid", false, false, this.zzegb, this.zzblk, null, null, this.zzfop, this.zzeen, null, false);
        zzaxw zzl = zzaxw.zzl(zza);
        zza.zzzp().zza((zzbdf) new zzbwz(zzl));
        zza.loadData(str, "text/html", "UTF-8");
        return zzl;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzaat zza(JSONObject jSONObject, List list) {
        Integer num = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        String optString = jSONObject.optString(ViewHierarchyConstants.TEXT_KEY);
        Integer zzf = zzf(jSONObject, "bg_color");
        Integer zzf2 = zzf(jSONObject, "text_color");
        int optInt = jSONObject.optInt("text_size", -1);
        boolean optBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int optInt2 = jSONObject.optInt("animation_ms", 1000);
        int optInt3 = jSONObject.optInt("presentation_ms", GamesStatusCodes.STATUS_SNAPSHOT_NOT_FOUND);
        if (optInt > 0) {
            num = Integer.valueOf(optInt);
        }
        zzaat zzaat = new zzaat(optString, list, zzf, zzf2, num, optInt3 + optInt2, this.zzdeh.zzbjy, optBoolean);
        return zzaat;
    }
}
