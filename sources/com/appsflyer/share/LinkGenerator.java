package com.appsflyer.share;

import android.content.Context;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.CreateOneLinkHttpTask.ResponseListener;
import com.appsflyer.ServerConfigHandler;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LinkGenerator {

    /* renamed from: ʻ */
    private String f3644;

    /* renamed from: ʼ */
    private String f3645;

    /* renamed from: ʽ */
    private String f3646;

    /* renamed from: ˊ */
    String f3647;

    /* renamed from: ˋ */
    private String f3648;

    /* renamed from: ˎ */
    String f3649;

    /* renamed from: ˏ */
    private String f3650;

    /* renamed from: ˏॱ */
    private Map<String, String> f3651 = new HashMap();

    /* renamed from: ͺ */
    private Map<String, String> f3652 = new HashMap();

    /* renamed from: ॱ */
    private String f3653;

    /* renamed from: ॱˊ */
    private String f3654;

    /* renamed from: ॱॱ */
    private String f3655;

    /* renamed from: ᐝ */
    private String f3656;

    public LinkGenerator(String str) {
        this.f3653 = str;
    }

    public LinkGenerator setDeeplinkPath(String str) {
        this.f3656 = str;
        return this;
    }

    public LinkGenerator setBaseDeeplink(String str) {
        this.f3654 = str;
        return this;
    }

    public String getChannel() {
        return this.f3648;
    }

    public LinkGenerator setChannel(String str) {
        this.f3648 = str;
        return this;
    }

    public LinkGenerator setReferrerCustomerId(String str) {
        this.f3644 = str;
        return this;
    }

    public String getMediaSource() {
        return this.f3653;
    }

    public Map<String, String> getParameters() {
        return this.f3652;
    }

    public String getCampaign() {
        return this.f3650;
    }

    public LinkGenerator setCampaign(String str) {
        this.f3650 = str;
        return this;
    }

    public LinkGenerator addParameter(String str, String str2) {
        this.f3652.put(str, str2);
        return this;
    }

    public LinkGenerator addParameters(Map<String, String> map) {
        if (map != null) {
            this.f3652.putAll(map);
        }
        return this;
    }

    public LinkGenerator setReferrerUID(String str) {
        this.f3645 = str;
        return this;
    }

    public LinkGenerator setReferrerName(String str) {
        this.f3655 = str;
        return this;
    }

    public LinkGenerator setReferrerImageURL(String str) {
        this.f3646 = str;
        return this;
    }

    public LinkGenerator setBaseURL(String str, String str2, String str3) {
        String str4 = Constants.AF_BASE_URL_FORMAT;
        if (str == null || str.length() <= 0) {
            this.f3647 = String.format(str4, new Object[]{ServerConfigHandler.getUrl(Constants.APPSFLYER_DEFAULT_APP_DOMAIN), str3});
        } else {
            if (str2 == null || str2.length() < 5) {
                str2 = Constants.ONELINK_DEFAULT_DOMAIN;
            }
            this.f3647 = String.format(str4, new Object[]{str2, str});
        }
        return this;
    }

    /* renamed from: ˏ */
    private StringBuilder m3374() {
        StringBuilder sb = new StringBuilder();
        String str = this.f3647;
        if (str == null || !str.startsWith("http")) {
            sb.append(ServerConfigHandler.getUrl(Constants.BASE_URL_APP_APPSFLYER_COM));
        } else {
            sb.append(this.f3647);
        }
        if (this.f3649 != null) {
            sb.append('/');
            sb.append(this.f3649);
        }
        this.f3651.put(Constants.URL_MEDIA_SOURCE, this.f3653);
        sb.append('?');
        sb.append("pid=");
        sb.append(m3373(this.f3653, "media source"));
        String str2 = this.f3645;
        if (str2 != null) {
            this.f3651.put(Constants.URL_REFERRER_UID, str2);
            sb.append('&');
            sb.append("af_referrer_uid=");
            sb.append(m3373(this.f3645, "referrerUID"));
        }
        String str3 = this.f3648;
        if (str3 != null) {
            this.f3651.put("af_channel", str3);
            sb.append('&');
            sb.append("af_channel=");
            sb.append(m3373(this.f3648, AppsFlyerProperties.CHANNEL));
        }
        String str4 = this.f3644;
        if (str4 != null) {
            this.f3651.put(Constants.URL_REFERRER_CUSTOMER_ID, str4);
            sb.append('&');
            sb.append("af_referrer_customer_id=");
            sb.append(m3373(this.f3644, "referrerCustomerId"));
        }
        String str5 = this.f3650;
        if (str5 != null) {
            this.f3651.put(Constants.URL_CAMPAIGN, str5);
            sb.append('&');
            sb.append("c=");
            sb.append(m3373(this.f3650, Param.CAMPAIGN));
        }
        String str6 = this.f3655;
        if (str6 != null) {
            this.f3651.put(Constants.URL_REFERRER_NAME, str6);
            sb.append('&');
            sb.append("af_referrer_name=");
            sb.append(m3373(this.f3655, "referrerName"));
        }
        String str7 = this.f3646;
        if (str7 != null) {
            this.f3651.put(Constants.URL_REFERRER_IMAGE_URL, str7);
            sb.append('&');
            sb.append("af_referrer_image_url=");
            sb.append(m3373(this.f3646, "referrerImageURL"));
        }
        if (this.f3654 != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f3654);
            String str8 = this.f3654;
            String str9 = Constants.URL_PATH_DELIMITER;
            String str10 = "";
            sb2.append(str8.endsWith(str9) ? str10 : str9);
            String str11 = this.f3656;
            if (str11 != null) {
                sb2.append(str11);
            }
            this.f3651.put(Constants.URL_BASE_DEEPLINK, sb2.toString());
            sb.append('&');
            sb.append("af_dp=");
            sb.append(m3373(this.f3654, "baseDeeplink"));
            if (this.f3656 != null) {
                if (!this.f3654.endsWith(str9)) {
                    str10 = "%2F";
                }
                sb.append(str10);
                sb.append(m3373(this.f3656, "deeplinkPath"));
            }
        }
        for (String str12 : this.f3652.keySet()) {
            String obj = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str12);
            sb3.append("=");
            sb3.append(m3373((String) this.f3652.get(str12), str12));
            if (!obj.contains(sb3.toString())) {
                sb.append('&');
                sb.append(str12);
                sb.append('=');
                sb.append(m3373((String) this.f3652.get(str12), str12));
            }
        }
        return sb;
    }

    /* renamed from: ˎ */
    private static String m3373(String str, String str2) {
        String str3 = "";
        try {
            return URLEncoder.encode(str, "utf8");
        } catch (UnsupportedEncodingException unused) {
            StringBuilder sb = new StringBuilder("Illegal ");
            sb.append(str2);
            sb.append(": ");
            sb.append(str);
            AFLogger.afInfoLog(sb.toString());
            return str3;
        } catch (Throwable unused2) {
            return str3;
        }
    }

    public String generateLink() {
        return m3374().toString();
    }

    public void generateLink(Context context, ResponseListener responseListener) {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID);
        if (!this.f3652.isEmpty()) {
            for (Entry entry : this.f3652.entrySet()) {
                this.f3651.put(entry.getKey(), entry.getValue());
            }
        }
        m3374();
        ShareInviteHelper.generateUserInviteLink(context, string, this.f3651, responseListener);
    }
}
