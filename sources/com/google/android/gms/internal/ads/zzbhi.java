package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzq;
import com.tapjoy.TJAdUnitConstants.String;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbhi implements zzaiq<zzbhm> {
    private final zzpe zzfbr;
    private final Context zzlk;
    private final PowerManager zzzd;

    public zzbhi(Context context, zzpe zzpe) {
        this.zzlk = context;
        this.zzfbr = zzpe;
        this.zzzd = (PowerManager) context.getSystemService("power");
    }

    /* renamed from: zza */
    public final JSONObject zzj(zzbhm zzbhm) throws JSONException {
        JSONObject jSONObject;
        boolean z;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        if (zzbhm.zzfcg == null) {
            jSONObject = new JSONObject();
        } else {
            zzpk zzpk = zzbhm.zzfcg;
            if (this.zzfbr.zzke() != null) {
                boolean z2 = zzpk.zzbny;
                JSONObject jSONObject3 = new JSONObject();
                String str = "activeViewJSON";
                String str2 = "timestamp";
                String str3 = "adFormat";
                String str4 = "hashCode";
                JSONObject put = jSONObject3.put("afmaVersion", this.zzfbr.zzkd()).put(str, this.zzfbr.zzke()).put(str2, zzbhm.timestamp).put(str3, this.zzfbr.zzkc()).put(str4, this.zzfbr.zzkf());
                zzpe zzpe = this.zzfbr;
                String str5 = "isNative";
                JSONObject put2 = put.put("isMraid", false).put("isStopped", false).put("isPaused", zzbhm.zzfcd).put(str5, this.zzfbr.zzkg());
                if (VERSION.SDK_INT >= 20) {
                    z = this.zzzd.isInteractive();
                } else {
                    z = this.zzzd.isScreenOn();
                }
                String str6 = "appVolume";
                String str7 = "deviceVolume";
                put2.put("isScreenOn", z).put("appMuted", zzq.zzko().zzot()).put(str6, (double) zzq.zzko().zzos()).put(str7, (double) zzave.zzbe(this.zzlk.getApplicationContext()));
                Rect rect = new Rect();
                Display defaultDisplay = ((WindowManager) this.zzlk.getSystemService("window")).getDefaultDisplay();
                rect.right = defaultDisplay.getWidth();
                rect.bottom = defaultDisplay.getHeight();
                DisplayMetrics displayMetrics = this.zzlk.getResources().getDisplayMetrics();
                JSONObject put3 = jSONObject3.put("windowVisibility", zzpk.zzzk).put("isAttachedToWindow", z2);
                String str8 = "top";
                JSONObject put4 = new JSONObject().put(str8, zzpk.zzbnz.top);
                int i = zzpk.zzbnz.bottom;
                String str9 = String.BOTTOM;
                String str10 = "left";
                JSONObject put5 = put4.put(str9, i).put(str10, zzpk.zzbnz.left);
                int i2 = zzpk.zzbnz.right;
                String str11 = String.RIGHT;
                String str12 = "globalVisibleBoxVisible";
                String str13 = "localVisibleBoxVisible";
                String str14 = "screenDensity";
                put3.put("viewBox", put5.put(str11, i2)).put("adBox", new JSONObject().put(str8, zzpk.zzboa.top).put(str9, zzpk.zzboa.bottom).put(str10, zzpk.zzboa.left).put(str11, zzpk.zzboa.right)).put("globalVisibleBox", new JSONObject().put(str8, zzpk.zzbob.top).put(str9, zzpk.zzbob.bottom).put(str10, zzpk.zzbob.left).put(str11, zzpk.zzbob.right)).put(str12, zzpk.zzboc).put("localVisibleBox", new JSONObject().put(str8, zzpk.zzbod.top).put(str9, zzpk.zzbod.bottom).put(str10, zzpk.zzbod.left).put(str11, zzpk.zzbod.right)).put(str13, zzpk.zzboe).put("hitBox", new JSONObject().put(str8, zzpk.zzbof.top).put(str9, zzpk.zzbof.bottom).put(str10, zzpk.zzbof.left).put(str11, zzpk.zzbof.right)).put(str14, (double) displayMetrics.density);
                jSONObject3.put("isVisible", zzbhm.zzbnp);
                if (((Boolean) zzuv.zzon().zzd(zzza.zzcma)).booleanValue()) {
                    JSONArray jSONArray2 = new JSONArray();
                    if (zzpk.zzboh != null) {
                        for (Rect rect2 : zzpk.zzboh) {
                            jSONArray2.put(new JSONObject().put(str8, rect2.top).put(str9, rect2.bottom).put(str10, rect2.left).put(str11, rect2.right));
                        }
                    }
                    jSONObject3.put("scrollableContainerBoxes", jSONArray2);
                }
                if (!TextUtils.isEmpty(zzbhm.zzfcf)) {
                    jSONObject3.put("doneReasonCode", "u");
                }
                jSONObject = jSONObject3;
            } else {
                throw new JSONException("Active view Info cannot be null.");
            }
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
