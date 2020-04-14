package com.tapjoy;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class TapjoyCachedAssetData implements Serializable {

    /* renamed from: a */
    private long f6468a;

    /* renamed from: b */
    private long f6469b;

    /* renamed from: c */
    private String f6470c;

    /* renamed from: d */
    private String f6471d;

    /* renamed from: e */
    private String f6472e;

    /* renamed from: f */
    private long f6473f;

    /* renamed from: g */
    private String f6474g;

    /* renamed from: h */
    private String f6475h;

    public TapjoyCachedAssetData(String str, String str2, long j) {
        this(str, str2, j, System.currentTimeMillis() / 1000);
    }

    public TapjoyCachedAssetData(String str, String str2, long j, long j2) {
        setAssetURL(str);
        setLocalFilePath(str2);
        this.f6469b = j;
        this.f6468a = j2;
        this.f6473f = j2 + j;
    }

    public void setAssetURL(String str) {
        this.f6470c = str;
        this.f6474g = TapjoyUtil.determineMimeType(str);
    }

    public void setLocalFilePath(String str) {
        this.f6471d = str;
        StringBuilder sb = new StringBuilder("file://");
        sb.append(str);
        this.f6472e = sb.toString();
    }

    public void resetTimeToLive(long j) {
        this.f6469b = j;
        this.f6473f = (System.currentTimeMillis() / 1000) + j;
    }

    public void setOfferID(String str) {
        this.f6475h = str;
    }

    public long getTimestampInSeconds() {
        return this.f6468a;
    }

    public long getTimeToLiveInSeconds() {
        return this.f6469b;
    }

    public long getTimeOfDeathInSeconds() {
        return this.f6473f;
    }

    public String getAssetURL() {
        return this.f6470c;
    }

    public String getLocalFilePath() {
        return this.f6471d;
    }

    public String getLocalURL() {
        return this.f6472e;
    }

    public String getMimeType() {
        return this.f6474g;
    }

    public String getOfferId() {
        return this.f6475h;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timestamp", getTimestampInSeconds());
            jSONObject.put(TapjoyConstants.TJC_TIME_TO_LIVE, getTimeToLiveInSeconds());
            jSONObject.put("assetURL", getAssetURL());
            jSONObject.put("localFilePath", getLocalFilePath());
            jSONObject.put("offerID", getOfferId());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String toRawJSONString() {
        return toJSON().toString();
    }

    public static TapjoyCachedAssetData fromRawJSONString(String str) {
        try {
            return fromJSONObject(new JSONObject(str));
        } catch (JSONException unused) {
            TapjoyLog.m6553i("TapjoyCachedAssetData", "Can not build TapjoyVideoObject -- error reading json string");
            return null;
        }
    }

    public static TapjoyCachedAssetData fromJSONObject(JSONObject jSONObject) {
        TapjoyCachedAssetData tapjoyCachedAssetData;
        try {
            tapjoyCachedAssetData = new TapjoyCachedAssetData(jSONObject.getString("assetURL"), jSONObject.getString("localFilePath"), jSONObject.getLong(TapjoyConstants.TJC_TIME_TO_LIVE), jSONObject.getLong("timestamp"));
            try {
                tapjoyCachedAssetData.setOfferID(jSONObject.optString("offerID"));
            } catch (JSONException unused) {
            }
        } catch (JSONException unused2) {
            tapjoyCachedAssetData = null;
            TapjoyLog.m6553i("TapjoyCachedAssetData", "Can not build TapjoyVideoObject -- not enough data.");
            return tapjoyCachedAssetData;
        }
        return tapjoyCachedAssetData;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nURL=");
        sb.append(this.f6472e);
        String str = "\n";
        sb.append(str);
        sb.append("AssetURL=");
        sb.append(this.f6470c);
        sb.append(str);
        sb.append("MimeType=");
        sb.append(this.f6474g);
        sb.append(str);
        sb.append("Timestamp=");
        sb.append(getTimestampInSeconds());
        sb.append(str);
        sb.append("TimeOfDeath=");
        sb.append(this.f6473f);
        sb.append(str);
        sb.append("TimeToLive=");
        sb.append(this.f6469b);
        sb.append(str);
        return sb.toString();
    }
}
