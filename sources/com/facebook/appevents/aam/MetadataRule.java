package com.facebook.appevents.aam;

import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;
import com.facebook.appevents.UserDataStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({Scope.LIBRARY_GROUP})
final class MetadataRule {
    private static final String FIELD_K = "k";
    private static final String FIELD_V = "v";
    private static final String FILED_K_DELIMITER = ",";
    private static final String TAG = "com.facebook.appevents.aam.MetadataRule";
    private static List<MetadataRule> rules = new ArrayList();
    private List<String> keyRules;
    private String name;
    private String valRule;

    private MetadataRule(String str, List<String> list, String str2) {
        this.name = str;
        this.keyRules = list;
        this.valRule = str2;
    }

    static List<MetadataRule> getRules() {
        return new ArrayList(rules);
    }

    /* access modifiers changed from: 0000 */
    public String getName() {
        return this.name;
    }

    /* access modifiers changed from: 0000 */
    public List<String> getKeyRules() {
        return new ArrayList(this.keyRules);
    }

    /* access modifiers changed from: 0000 */
    public String getValRule() {
        return this.valRule;
    }

    static void updateRules(String str) {
        try {
            rules.clear();
            constructRules(new JSONObject(str));
            removeUnusedRules();
        } catch (JSONException unused) {
        }
    }

    private static void constructRules(JSONObject jSONObject) {
        String str = "v";
        String str2 = FIELD_K;
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                if (jSONObject.get(str3) instanceof JSONObject) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str3);
                    if (jSONObject2.has(str2) && jSONObject2.has(str) && !jSONObject2.getString(str2).isEmpty()) {
                        if (!jSONObject2.getString(str).isEmpty()) {
                            rules.add(new MetadataRule(str3, Arrays.asList(jSONObject2.getString(str2).split(FILED_K_DELIMITER)), jSONObject2.getString(str)));
                        }
                    }
                }
            }
        } catch (JSONException unused) {
        }
    }

    private static void removeUnusedRules() {
        Map internalHashedUserData = UserDataStore.getInternalHashedUserData();
        if (!internalHashedUserData.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (MetadataRule name2 : rules) {
                hashSet.add(name2.getName());
            }
            ArrayList arrayList = new ArrayList();
            for (String str : internalHashedUserData.keySet()) {
                if (!hashSet.contains(str)) {
                    arrayList.add(str);
                }
            }
            if (!arrayList.isEmpty()) {
                UserDataStore.removeRules(arrayList);
            }
        }
    }
}
