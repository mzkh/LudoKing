package com.unity3d.services.p040ar;

import android.annotation.TargetApi;
import android.content.Context;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.ArCoreApk.Availability;
import com.google.ar.core.Config;
import com.google.ar.core.Config.LightEstimationMode;
import com.google.ar.core.Config.PlaneFindingMode;
import com.google.ar.core.Config.UpdateMode;
import com.google.ar.core.Session;
import com.google.ar.core.exceptions.FatalException;
import com.google.ar.core.exceptions.UnavailableException;
import com.unity3d.services.core.log.DeviceLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.unity3d.services.ar.ARUtils */
public class ARUtils {
    public static final int AR_CHECK_NOT_SUPPORTED = 0;
    public static final int AR_CHECK_SUPPORTED = 1;
    public static final int AR_CHECK_TRANSIENT = 2;
    private static LightEstimationMode[] lightEstimationModes;
    private static PlaneFindingMode[] planeFindingModes;
    private static UpdateMode[] updateModes;

    public static int isSupported(Context context) {
        if (!ARCheck.isFrameworkPresent()) {
            return 0;
        }
        if (planeFindingModes == null) {
            planeFindingModes = PlaneFindingMode.values();
            lightEstimationModes = LightEstimationMode.values();
            updateModes = UpdateMode.values();
        }
        Availability checkAvailability = ArCoreApk.getInstance().checkAvailability(context);
        if (checkAvailability.isTransient()) {
            return 2;
        }
        if (checkAvailability == Availability.SUPPORTED_INSTALLED) {
            try {
                new Session(context);
            } catch (FatalException | UnavailableException unused) {
            } catch (SecurityException unused2) {
            }
            return 1;
        }
        return 0;
    }

    public static Config createConfiguration(JSONObject jSONObject, Session session) {
        Config config = new Config(session);
        String str = "lightEstimationMode";
        int i = 0;
        if (jSONObject.has(str)) {
            try {
                String string = jSONObject.getString(str);
                LightEstimationMode[] lightEstimationModeArr = lightEstimationModes;
                int length = lightEstimationModeArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    LightEstimationMode lightEstimationMode = lightEstimationModeArr[i2];
                    if (string.equalsIgnoreCase(lightEstimationMode.name())) {
                        config.setLightEstimationMode(lightEstimationMode);
                        break;
                    }
                    i2++;
                }
            } catch (JSONException unused) {
                DeviceLog.warning("lightEstimationEnabled is not a string.");
            }
        }
        String str2 = "planeFindingMode";
        if (jSONObject.has(str2)) {
            try {
                String string2 = jSONObject.getString(str2);
                PlaneFindingMode[] planeFindingModeArr = planeFindingModes;
                int length2 = planeFindingModeArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        break;
                    }
                    PlaneFindingMode planeFindingMode = planeFindingModeArr[i3];
                    if (string2.equalsIgnoreCase(planeFindingMode.name())) {
                        config.setPlaneFindingMode(planeFindingMode);
                        break;
                    }
                    i3++;
                }
            } catch (JSONException unused2) {
                DeviceLog.warning("planeFindingMode is not a string.");
            }
        }
        String str3 = "updateMode";
        if (jSONObject.has(str3)) {
            try {
                String string3 = jSONObject.getString(str3);
                UpdateMode[] updateModeArr = updateModes;
                int length3 = updateModeArr.length;
                while (true) {
                    if (i >= length3) {
                        break;
                    }
                    UpdateMode updateMode = updateModeArr[i];
                    if (string3.equalsIgnoreCase(updateMode.name())) {
                        config.setUpdateMode(updateMode);
                        break;
                    }
                    i++;
                }
            } catch (JSONException unused3) {
                DeviceLog.warning("updateMode is not a string.");
            }
        }
        return config;
    }

    @TargetApi(19)
    public static JSONObject getConfigEnums() {
        JSONObject jSONObject = new JSONObject();
        try {
            ArrayList arrayList = new ArrayList();
            for (LightEstimationMode name : LightEstimationMode.values()) {
                arrayList.add(name.name());
            }
            jSONObject.put("lightEstimationMode", new JSONArray(arrayList.toArray()));
            arrayList.clear();
            for (PlaneFindingMode name2 : PlaneFindingMode.values()) {
                arrayList.add(name2.name());
            }
            jSONObject.put("planeFindingMode", new JSONArray(arrayList.toArray()));
            arrayList.clear();
            for (UpdateMode name3 : UpdateMode.values()) {
                arrayList.add(name3.name());
            }
            jSONObject.put("updateMode", new JSONArray(arrayList.toArray()));
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
