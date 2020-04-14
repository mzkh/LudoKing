package com.appsflyer.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.OneLinkHttpTask;
import com.appsflyer.ServerConfigHandler;
import com.appsflyer.share.Constants;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.appsflyer.internal.ai */
public final class C1351ai extends OneLinkHttpTask {

    /* renamed from: ॱ */
    private static List<String> f3450 = Arrays.asList(new String[]{"onelink.me", "onelnk.com", "app.aflink.com"});

    /* renamed from: ˋ */
    public C1352e f3451;

    /* renamed from: ˏ */
    public String f3452;

    /* renamed from: com.appsflyer.internal.ai$e */
    public interface C1352e {
        /* renamed from: ˋ */
        void mo10740(String str);

        /* renamed from: ˎ */
        void mo10741(Map<String, String> map);
    }

    public C1351ai(Uri uri, AppsFlyerLibCore appsFlyerLibCore) {
        String[] strArr;
        super(appsFlyerLibCore);
        if (!TextUtils.isEmpty(uri.getHost()) && !TextUtils.isEmpty(uri.getPath())) {
            boolean z = false;
            for (String contains : f3450) {
                if (uri.getHost().contains(contains)) {
                    z = true;
                }
            }
            if (C1366f.f3546 != null) {
                StringBuilder sb = new StringBuilder("Validate custom domain URLs: ");
                sb.append(Arrays.asList(C1366f.f3546));
                AFLogger.afRDLog(sb.toString());
                for (String str : C1366f.f3546) {
                    if (uri.getHost().contains(str) && str != "") {
                        StringBuilder sb2 = new StringBuilder("DeepLink matches customDomain: ");
                        sb2.append(uri.toString());
                        AFLogger.afDebugLog(sb2.toString());
                        z = true;
                    }
                }
            }
            String[] split = uri.getPath().split(Constants.URL_PATH_DELIMITER);
            if (z && split.length == 3) {
                this.f3408 = split[1];
                this.f3452 = split[2];
            }
        }
    }

    /* renamed from: ˎ */
    public final void mo10778(HttpsURLConnection httpsURLConnection) throws JSONException, IOException {
        httpsURLConnection.setRequestMethod("GET");
    }

    /* renamed from: ॱ */
    public final String mo10780() {
        StringBuilder sb = new StringBuilder();
        sb.append(ServerConfigHandler.getUrl("https://%sonelink.%s/shortlink-sdk/v1"));
        sb.append(Constants.URL_PATH_DELIMITER);
        sb.append(this.f3408);
        sb.append("?id=");
        sb.append(this.f3452);
        return sb.toString();
    }

    /* renamed from: ˊ */
    public final void mo10777(String str) {
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                hashMap.put(str2, jSONObject.optString(str2));
            }
            this.f3451.mo10741(hashMap);
        } catch (JSONException e) {
            this.f3451.mo10740("Can't parse one link data");
            AFLogger.afErrorLog("Error while parsing to json ".concat(String.valueOf(str)), e);
        }
    }

    /* renamed from: ˏ */
    public final void mo10779() {
        this.f3451.mo10740("Can't get one link data");
    }
}
