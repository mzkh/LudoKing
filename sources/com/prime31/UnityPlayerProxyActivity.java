package com.prime31;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;

public class UnityPlayerProxyActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        char c = 0;
        String[] strArr = {"com.prime31.UnityPlayerActivity", "com.prime31.UnityPlayerNativeActivity"};
        try {
            if (VERSION.SDK_INT >= 9) {
                c = 1;
            }
            Intent intent = new Intent(this, Class.forName(strArr[c]));
            intent.addFlags(65536);
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                intent.putExtras(extras);
            }
            Uri data = getIntent().getData();
            if (data != null) {
                intent.setData(data);
            }
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            finish();
            throw th;
        }
        finish();
    }
}
