package com.appsflyer;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.appsflyer.share.Constants;
import com.appsflyer.share.LinkGenerator;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateOneLinkHttpTask extends OneLinkHttpTask {

    /* renamed from: ʽ */
    private boolean f3400 = false;

    /* renamed from: ˊ */
    private Map<String, String> f3401;

    /* renamed from: ˋ */
    private String f3402;

    /* renamed from: ˏ */
    private ResponseListener f3403;

    /* renamed from: ॱ */
    private String f3404 = "";

    /* renamed from: ᐝ */
    private Context f3405;

    public interface ResponseListener {
        @WorkerThread
        void onResponse(String str);

        @WorkerThread
        void onResponseError(String str);
    }

    public CreateOneLinkHttpTask(@NonNull String str, @NonNull Map<String, String> map, AppsFlyerLibCore appsFlyerLibCore, @NonNull Context context, boolean z) {
        super(appsFlyerLibCore);
        this.f3400 = z;
        this.f3405 = context;
        if (this.f3405 != null) {
            this.f3404 = context.getPackageName();
        } else {
            AFLogger.afWarnLog("CreateOneLinkHttpTask: context can't be null");
        }
        this.f3408 = str;
        this.f3402 = "-1";
        this.f3401 = map;
    }

    public void setListener(@NonNull ResponseListener responseListener) {
        this.f3403 = responseListener;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˎ */
    public final void mo10778(HttpsURLConnection httpsURLConnection) throws JSONException, IOException {
        if (!this.f3400) {
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setUseCaches(false);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject(this.f3401);
            jSONObject.put("ttl", this.f3402);
            jSONObject.put("data", jSONObject2);
            httpsURLConnection.connect();
            DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
            dataOutputStream.writeBytes(jSONObject.toString());
            dataOutputStream.flush();
            dataOutputStream.close();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ॱ */
    public final String mo10780() {
        StringBuilder sb = new StringBuilder();
        sb.append(ServerConfigHandler.getUrl("https://%sonelink.%s/shortlink-sdk/v1"));
        sb.append(Constants.URL_PATH_DELIMITER);
        sb.append(this.f3408);
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˊ */
    public final void mo10777(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                this.f3403.onResponse(jSONObject.optString((String) keys.next()));
            }
        } catch (JSONException e) {
            this.f3403.onResponseError("Can't parse one link data");
            AFLogger.afErrorLog("Error while parsing to json ".concat(String.valueOf(str)), e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏ */
    public final void mo10779() {
        LinkGenerator addParameters = new LinkGenerator(Constants.USER_INVITE_LINK_TYPE).setBaseURL(this.f3408, AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_DOMAIN), this.f3404).addParameter(Constants.URL_SITE_ID, this.f3404).addParameters(this.f3401);
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID);
        if (string != null) {
            addParameters.setReferrerCustomerId(string);
        }
        this.f3403.onResponse(addParameters.generateLink());
    }
}
