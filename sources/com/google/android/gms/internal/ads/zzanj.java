package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzanj {
    private final zzbbw zzczi;
    private final String zzdgr;

    public zzanj(zzbbw zzbbw) {
        this(zzbbw, "");
    }

    public zzanj(zzbbw zzbbw, String str) {
        this.zzczi = zzbbw;
        this.zzdgr = str;
    }

    public final void zzdn(String str) {
        try {
            JSONObject put = new JSONObject().put("message", str).put(NativeProtocol.WEB_DIALOG_ACTION, this.zzdgr);
            if (this.zzczi != null) {
                this.zzczi.zzb("onError", put);
            }
        } catch (JSONException e) {
            zzaug.zzc("Error occurred while dispatching error event.", e);
        }
    }

    public final void zzdo(String str) {
        try {
            this.zzczi.zzb("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            zzaug.zzc("Error occurred while dispatching ready Event.", e);
        }
    }

    public final void zzb(int i, int i2, int i3, int i4) {
        try {
            this.zzczi.zzb("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzaug.zzc("Error occurred while dispatching size change.", e);
        }
    }

    public final void zzc(int i, int i2, int i3, int i4) {
        try {
            this.zzczi.zzb("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzaug.zzc("Error occurred while dispatching default position.", e);
        }
    }

    public final void zzdp(String str) {
        try {
            this.zzczi.zzb("onStateChanged", new JSONObject().put(ServerProtocol.DIALOG_PARAM_STATE, str));
        } catch (JSONException e) {
            zzaug.zzc("Error occurred while dispatching state change.", e);
        }
    }

    public final void zza(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.zzczi.zzb("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", (double) f).put("rotation", i5));
        } catch (JSONException e) {
            zzaug.zzc("Error occurred while obtaining screen information.", e);
        }
    }
}
