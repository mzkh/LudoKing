package com.facebook.appevents.p022ml;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.restrictivedatafilter.AddressFilterManager;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FeatureManager.Callback;
import com.facebook.internal.FeatureManager.Feature;
import com.facebook.internal.Utility;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({Scope.LIBRARY})
/* renamed from: com.facebook.appevents.ml.ModelManager */
public final class ModelManager {
    private static final String[] APP_SETTING_FIELDS = {"version_id", "asset_uri", "use_case", "thresholds", "rules_uri"};
    private static final String CACHE_KEY_MODELS = "models";
    public static final String MODEL_ADDRESS_DETECTION = "DATA_DETECTION_ADDRESS";
    private static final String MODEL_ASSERT_STORE = "com.facebook.internal.MODEL_STORE";
    public static final String MODEL_SUGGESTED_EVENTS = "SUGGEST_EVENT";
    private static final String SDK_MODEL_ASSET = "%s/model_asset";
    /* access modifiers changed from: private */
    public static final ConcurrentMap<String, Model> models = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public static SharedPreferences shardPreferences;

    public static void enable() {
        initialize();
    }

    public static void initialize() {
        shardPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(MODEL_ASSERT_STORE, 0);
        initializeModels();
    }

    private static void initializeModels() {
        Utility.runOnNonUiThread(new Runnable() {
            public void run() {
                try {
                    JSONObject access$000 = ModelManager.fetchFromServer();
                    String str = ModelManager.CACHE_KEY_MODELS;
                    if (access$000 != null) {
                        ModelManager.shardPreferences.edit().putString(str, access$000.toString()).apply();
                    } else {
                        access$000 = new JSONObject(ModelManager.shardPreferences.getString(str, ""));
                    }
                    ModelManager.addModelsFromModelJson(access$000);
                    ModelManager.enableSuggestedEvents();
                    ModelManager.enablePIIFiltering();
                } catch (Exception unused) {
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static void addModelsFromModelJson(JSONObject jSONObject) {
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String str = (String) keys.next();
                Model jsonObjectToModel = jsonObjectToModel(jSONObject.getJSONObject(str));
                if (jsonObjectToModel != null) {
                    models.put(str, jsonObjectToModel);
                }
            } catch (JSONException unused) {
                return;
            }
        }
    }

    private static JSONObject parseRawJsonObject(JSONObject jSONObject) {
        String str = "asset_uri";
        String str2 = "thresholds";
        String str3 = "version_id";
        String str4 = "rules_uri";
        String str5 = "use_case";
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(str3, jSONObject3.getString(str3));
                jSONObject4.put(str5, jSONObject3.getString(str5));
                jSONObject4.put(str2, jSONObject3.getJSONArray(str2));
                jSONObject4.put(str, jSONObject3.getString(str));
                if (jSONObject3.has(str4)) {
                    jSONObject4.put(str4, jSONObject3.getString(str4));
                }
                jSONObject2.put(jSONObject3.getString(str5), jSONObject4);
            }
            return jSONObject2;
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    /* access modifiers changed from: private */
    @Nullable
    public static JSONObject fetchFromServer() {
        ArrayList arrayList = new ArrayList(Arrays.asList(APP_SETTING_FIELDS));
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, TextUtils.join(",", arrayList));
        GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest(null, String.format(SDK_MODEL_ASSET, new Object[]{FacebookSdk.getApplicationId()}), null);
        newGraphPathRequest.setSkipClientToken(true);
        newGraphPathRequest.setParameters(bundle);
        JSONObject jSONObject = newGraphPathRequest.executeAndWait().getJSONObject();
        if (jSONObject == null) {
            return null;
        }
        return parseRawJsonObject(jSONObject);
    }

    @Nullable
    private static Model jsonObjectToModel(JSONObject jSONObject) {
        try {
            Model model = new Model(jSONObject.getString("use_case"), Integer.parseInt(jSONObject.getString("version_id")), jSONObject.getString("asset_uri"), jSONObject.optString("rules_uri", null), parseJsonArray(jSONObject.getJSONArray("thresholds")));
            return model;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void enableSuggestedEvents() {
        if (models.containsKey(MODEL_SUGGESTED_EVENTS)) {
            Locale resourceLocale = Utility.getResourceLocale();
            if (resourceLocale == null || resourceLocale.getLanguage().contains("en")) {
                FeatureManager.checkFeature(Feature.SuggestedEvents, new Callback() {
                    public void onCompleted(boolean z) {
                        if (z) {
                            ((Model) ModelManager.models.get(ModelManager.MODEL_SUGGESTED_EVENTS)).initialize(new Runnable() {
                                public void run() {
                                    SuggestedEventsManager.enable();
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    public static void enablePIIFiltering() {
        if (models.containsKey(MODEL_ADDRESS_DETECTION)) {
            FeatureManager.checkFeature(Feature.PIIFiltering, new Callback() {
                public void onCompleted(boolean z) {
                    if (z) {
                        ((Model) ModelManager.models.get(ModelManager.MODEL_ADDRESS_DETECTION)).initialize(new Runnable() {
                            public void run() {
                                AddressFilterManager.enable();
                            }
                        });
                    }
                }
            });
        }
    }

    private static float[] parseJsonArray(JSONArray jSONArray) {
        float[] fArr = new float[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                fArr[i] = Float.parseFloat(jSONArray.getString(i));
            } catch (JSONException unused) {
            }
        }
        return fArr;
    }

    @Nullable
    public static String predict(String str, float[] fArr, String str2) {
        if (!models.containsKey(str)) {
            return null;
        }
        return ((Model) models.get(str)).predict(fArr, str2);
    }

    @Nullable
    public static File getRuleFile(String str) {
        if (!models.containsKey(str)) {
            return null;
        }
        return ((Model) models.get(str)).getRuleFile();
    }
}
