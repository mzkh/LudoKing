package bolts;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public final class AppLinks {
    static final String KEY_NAME_APPLINK_DATA = "al_applink_data";
    static final String KEY_NAME_EXTRAS = "extras";
    static final String KEY_NAME_TARGET = "target_url";

    public static Bundle getAppLinkData(Intent intent) {
        return intent.getBundleExtra(KEY_NAME_APPLINK_DATA);
    }

    public static Bundle getAppLinkExtras(Intent intent) {
        Bundle appLinkData = getAppLinkData(intent);
        if (appLinkData == null) {
            return null;
        }
        return appLinkData.getBundle("extras");
    }

    public static Uri getTargetUrl(Intent intent) {
        Bundle appLinkData = getAppLinkData(intent);
        if (appLinkData != null) {
            String string = appLinkData.getString(KEY_NAME_TARGET);
            if (string != null) {
                return Uri.parse(string);
            }
        }
        return intent.getData();
    }

    public static Uri getTargetUrlFromInboundIntent(Context context, Intent intent) {
        Bundle appLinkData = getAppLinkData(intent);
        if (appLinkData != null) {
            String string = appLinkData.getString(KEY_NAME_TARGET);
            if (string != null) {
                MeasurementEvent.sendBroadcastEvent(context, MeasurementEvent.APP_LINK_NAVIGATE_IN_EVENT_NAME, intent, null);
                return Uri.parse(string);
            }
        }
        return null;
    }
}
