package com.appsflyer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class GetDeepLinkingActivity extends Activity {
    private static String TAG = "AppsFlyerDeepLinkActivity";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        startActivity(new Intent(this, getMainActivityClass()));
        AppsFlyerLib.getInstance().setPluginDeepLinkData(getIntent());
        finish();
    }

    private Class<?> getMainActivityClass() {
        try {
            return Class.forName(getPackageManager().getLaunchIntentForPackage(getPackageName()).getComponent().getClassName());
        } catch (Exception unused) {
            Log.e(TAG, "Unable to find Main Activity Class");
            return null;
        }
    }
}
