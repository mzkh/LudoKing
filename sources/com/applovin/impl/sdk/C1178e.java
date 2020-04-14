package com.applovin.impl.sdk;

import android.os.Bundle;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.communicator.AppLovinSdkTopic;
import com.applovin.impl.communicator.CommunicatorMessageImpl;
import com.applovin.impl.mediation.p014b.C0958a;
import com.applovin.impl.mediation.p014b.C0960c;
import com.applovin.impl.sdk.network.C1222f.C1224a;
import com.applovin.impl.sdk.p019b.C1094a;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.tapjoy.TapjoyConstants;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e */
public class C1178e implements AppLovinCommunicatorPublisher, AppLovinCommunicatorSubscriber {

    /* renamed from: a */
    private final C1192i f2880a;

    /* renamed from: b */
    private final AppLovinCommunicator f2881b;

    C1178e(C1192i iVar) {
        this.f2880a = iVar;
        this.f2881b = AppLovinCommunicator.getInstance(iVar.mo10179D());
        if (!"HSrCHRtOan6wp2kwOIGJC1RDtuSrF2mWVbio2aBcMHX9KF3iTJ1lLSzCKP1ZSo5yNolPNw1kCTtWpxELFF4ah1".equalsIgnoreCase(iVar.mo10246t())) {
            this.f2881b.mo8862a(iVar);
            this.f2881b.subscribe((AppLovinCommunicatorSubscriber) this, AppLovinSdkTopic.ALL_TOPICS);
        }
    }

    /* renamed from: a */
    private void m2523a(Bundle bundle, String str) {
        if (!"log".equals(str)) {
            C1227o v = this.f2880a.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append("Sending message ");
            sb.append(bundle);
            sb.append(" for topic: ");
            sb.append(str);
            sb.append("...");
            v.mo10378b("CommunicatorService", sb.toString());
        }
        this.f2881b.getMessagingService().publish(CommunicatorMessageImpl.create(bundle, str, this, this.f2880a.mo10224b((C1096c) C1094a.f2232a).contains(str)));
    }

    /* renamed from: a */
    public void mo10159a(C0958a aVar, String str) {
        boolean j = aVar instanceof C0960c ? ((C0960c) aVar).mo9437j() : false;
        Bundle bundle = new Bundle();
        bundle.putString("type", str);
        bundle.putString("id", aVar.mo9427b());
        bundle.putString("network_name", aVar.mo9495z());
        bundle.putString("max_ad_unit_id", aVar.getAdUnitId());
        bundle.putString("third_party_ad_placement_id", aVar.mo9430e());
        bundle.putString("ad_format", aVar.getFormat().getLabel());
        bundle.putString("is_fallback_ad", String.valueOf(j));
        m2523a(bundle, "max_ad_events");
    }

    /* renamed from: a */
    public void mo10160a(JSONObject jSONObject, boolean z) {
        Bundle c = C1247h.m2991c(C1247h.m2989b(C1247h.m2989b(jSONObject, "communicator_settings", new JSONObject(), this.f2880a), "safedk_settings", new JSONObject(), this.f2880a));
        Bundle bundle = new Bundle();
        bundle.putString(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f2880a.mo10246t());
        bundle.putString("applovin_random_token", this.f2880a.mo10237k());
        bundle.putString(TapjoyConstants.TJC_DEVICE_TYPE_NAME, AppLovinSdkUtils.isTablet(this.f2880a.mo10179D()) ? "tablet" : "phone");
        bundle.putString("init_success", String.valueOf(z));
        bundle.putBundle("settings", c);
        bundle.putBoolean("debug_mode", ((Boolean) this.f2880a.mo10202a(C1096c.f2507eM)).booleanValue());
        m2523a(bundle, "safedk_init");
    }

    public String getCommunicatorId() {
        return "applovin_sdk";
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if (AppLovinSdkTopic.HTTP_REQUEST.equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            Map a = C1247h.m2971a(messageData.getBundle("query_params"));
            Map map = BundleUtils.toMap(messageData.getBundle("post_body"));
            Map a2 = C1247h.m2971a(messageData.getBundle("headers"));
            String str = AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY;
            if (!map.containsKey(str)) {
                map.put(str, this.f2880a.mo10246t());
            }
            this.f2880a.mo10188N().mo10338a(new C1224a().mo10355a(messageData.getString("url")).mo10359b(messageData.getString("backup_url")).mo10356a(a).mo10361c(map).mo10360b(a2).mo10357a(((Boolean) this.f2880a.mo10202a(C1096c.f2507eM)).booleanValue()).mo10358a());
        }
    }
}
