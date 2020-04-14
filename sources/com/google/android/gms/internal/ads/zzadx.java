package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.tapjoy.TJAdUnitConstants.String;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzadx implements zzaer<Object> {
    private final zzadw zzcxc;

    public zzadx(zzadw zzadw) {
        this.zzcxc = zzadw;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (this.zzcxc != null) {
            String str = (String) map.get("name");
            if (str == null) {
                zzaug.zzet("Ad metadata with no name parameter.");
                str = "";
            }
            String str2 = String.VIDEO_INFO;
            Bundle bundle = null;
            if (map.containsKey(str2)) {
                try {
                    bundle = zzb(new JSONObject((String) map.get(str2)));
                } catch (JSONException e) {
                    zzaug.zzc("Failed to convert ad metadata to JSON.", e);
                }
            }
            if (bundle == null) {
                zzaug.zzes("Failed to convert ad metadata to Bundle.");
            } else {
                this.zzcxc.zza(str, bundle);
            }
        }
    }

    private static Bundle zzb(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        Iterator keys = jSONObject.keys();
        Bundle bundle = new Bundle();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jSONObject.get(str);
            if (obj != null) {
                if (obj instanceof Boolean) {
                    bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Double) {
                    bundle.putDouble(str, ((Double) obj).doubleValue());
                } else if (obj instanceof Integer) {
                    bundle.putInt(str, ((Integer) obj).intValue());
                } else if (obj instanceof Long) {
                    bundle.putLong(str, ((Long) obj).longValue());
                } else if (obj instanceof String) {
                    bundle.putString(str, (String) obj);
                } else if (obj instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) obj;
                    if (!(jSONArray == null || jSONArray.length() == 0)) {
                        int length = jSONArray.length();
                        int i = 0;
                        Object obj2 = null;
                        int i2 = 0;
                        while (obj2 == null && i2 < length) {
                            obj2 = !jSONArray.isNull(i2) ? jSONArray.get(i2) : null;
                            i2++;
                        }
                        if (obj2 == null) {
                            String str2 = "Expected JSONArray with at least 1 non-null element for key:";
                            String valueOf = String.valueOf(str);
                            zzaug.zzeu(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                        } else if (obj2 instanceof JSONObject) {
                            Bundle[] bundleArr = new Bundle[length];
                            while (i < length) {
                                bundleArr[i] = !jSONArray.isNull(i) ? zzb(jSONArray.optJSONObject(i)) : null;
                                i++;
                            }
                            bundle.putParcelableArray(str, bundleArr);
                        } else if (obj2 instanceof Number) {
                            double[] dArr = new double[jSONArray.length()];
                            while (i < length) {
                                dArr[i] = jSONArray.optDouble(i);
                                i++;
                            }
                            bundle.putDoubleArray(str, dArr);
                        } else if (obj2 instanceof CharSequence) {
                            String[] strArr = new String[length];
                            while (i < length) {
                                strArr[i] = !jSONArray.isNull(i) ? jSONArray.optString(i) : null;
                                i++;
                            }
                            bundle.putStringArray(str, strArr);
                        } else if (obj2 instanceof Boolean) {
                            boolean[] zArr = new boolean[length];
                            while (i < length) {
                                zArr[i] = jSONArray.optBoolean(i);
                                i++;
                            }
                            bundle.putBooleanArray(str, zArr);
                        } else {
                            zzaug.zzeu(String.format("JSONArray with unsupported type %s for key:%s", new Object[]{obj2.getClass().getCanonicalName(), str}));
                        }
                    }
                } else if (obj instanceof JSONObject) {
                    bundle.putBundle(str, zzb((JSONObject) obj));
                } else {
                    String str3 = "Unsupported type for key:";
                    String valueOf2 = String.valueOf(str);
                    zzaug.zzeu(valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
                }
            }
        }
        return bundle;
    }
}
