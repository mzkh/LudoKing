package com.facebook.unity;

import android.os.Bundle;
import android.util.Log;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class UnityParams {
    JSONObject json;

    public UnityParams(String str) throws JSONException {
        this.json = new JSONObject(str);
    }

    public UnityParams(JSONObject jSONObject) {
        this.json = jSONObject;
    }

    public UnityParams(Map<String, Serializable> map) {
        this.json = new JSONObject(map);
    }

    public static UnityParams parse(String str, String str2) {
        try {
            return new UnityParams(str);
        } catch (JSONException unused) {
            Log.e(C1713FB.TAG, str2);
            return null;
        }
    }

    public static UnityParams parse(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("couldn't parse params: ");
        sb.append(str);
        return parse(str, sb.toString());
    }

    public String getString(String str) {
        try {
            return this.json.getString(str);
        } catch (JSONException unused) {
            String str2 = C1713FB.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("cannot get string ");
            sb.append(str);
            sb.append(" from ");
            sb.append(toString());
            Log.e(str2, sb.toString());
            return "";
        }
    }

    public double getDouble(String str) {
        try {
            return this.json.getDouble(str);
        } catch (JSONException unused) {
            String str2 = C1713FB.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("cannot get double ");
            sb.append(str);
            sb.append(" from ");
            sb.append(toString());
            Log.e(str2, sb.toString());
            return 0.0d;
        }
    }

    public UnityParams getParamsObject(String str) {
        try {
            return new UnityParams(this.json.getJSONObject(str));
        } catch (JSONException unused) {
            String str2 = C1713FB.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("cannot get object ");
            sb.append(str);
            sb.append(" from ");
            sb.append(toString());
            Log.e(str2, sb.toString());
            return null;
        }
    }

    public void put(String str, Object obj) {
        try {
            this.json.put(str, obj);
        } catch (JSONException unused) {
            String str2 = C1713FB.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("couldn't add key ");
            sb.append(str);
            sb.append(" to ");
            sb.append(toString());
            Log.e(str2, sb.toString());
        }
    }

    public boolean has(String str) {
        return this.json.has(str) && !this.json.isNull(str);
    }

    public Boolean hasString(String str) {
        return Boolean.valueOf(has(str) && getString(str) != "");
    }

    public Bundle getStringParams() {
        Bundle bundle = new Bundle();
        Iterator keys = this.json.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            try {
                String string = this.json.getString(str);
                if (string != null) {
                    bundle.putString(str, string);
                }
            } catch (JSONException unused) {
            }
        }
        return bundle;
    }

    public String toString() {
        return this.json.toString();
    }
}
