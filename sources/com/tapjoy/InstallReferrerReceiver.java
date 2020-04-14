package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import com.tapjoy.internal.C1831gz;
import com.tapjoy.internal.C3205j;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class InstallReferrerReceiver extends C3205j {
    public void onReceive(Context context, Intent intent) {
        String a = C1831gz.m3556a(context, intent);
        int a2 = mo30321a(context, intent);
        if (intent.getBooleanExtra("fiverocks:verify", false) && isOrderedBroadcast()) {
            setResultCode(a2 + 1);
            if (a != null) {
                try {
                    StringBuilder sb = new StringBuilder("http://play.google.com/store/apps/details?id=");
                    sb.append(context.getPackageName());
                    sb.append("&referrer=");
                    sb.append(URLEncoder.encode(a, "UTF-8"));
                    setResultData(sb.toString());
                } catch (UnsupportedEncodingException unused) {
                }
            }
        }
    }
}
