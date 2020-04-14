package com.google.games.bridge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public final class NativeBridgeActivity extends Activity {
    private static final int BG_COLOR = 1090519039;
    private static final String BRIDGED_INTENT = "BRIDGED_INTENT";
    private static final int GPG_RESPONSE_CODE = 4673607;
    private static final String TAG = "NativeBridgeActivity";
    private boolean pendingResult;

    private native void forwardActivityResult(int i, int i2, Intent intent);

    static {
        System.loadLibrary("gpg");
    }

    public void onCreate(Bundle bundle) {
        View view = new View(this);
        view.setBackgroundColor(BG_COLOR);
        setContentView(view);
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        Intent intent = (Intent) getIntent().getParcelableExtra(BRIDGED_INTENT);
        if (intent != null) {
            startActivityForResult(intent, GPG_RESPONSE_CODE);
        }
        super.onStart();
    }

    public void startActivityForResult(Intent intent, int i) {
        this.pendingResult = i == GPG_RESPONSE_CODE;
        boolean z = this.pendingResult;
        String str = TAG;
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("starting GPG activity: ");
            sb.append(intent);
            Log.d(str, sb.toString());
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("starting non-GPG activity: ");
            sb2.append(i);
            sb2.append(" ");
            sb2.append(intent);
            Log.i(str, sb2.toString());
        }
        super.startActivityForResult(intent, i);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        String str = TAG;
        if (i == GPG_RESPONSE_CODE) {
            Log.d(str, "Forwarding activity result to native SDK.");
            forwardActivityResult(i, i2, intent);
            this.pendingResult = false;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("onActivityResult for unknown request code: ");
            sb.append(i);
            sb.append(" calling finish()");
            Log.d(str, sb.toString());
        }
        finish();
        super.onActivityResult(i, i2, intent);
    }

    public static void launchBridgeIntent(Activity activity, Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append("Launching bridge activity: parent:");
        sb.append(activity);
        sb.append(" intent ");
        sb.append(intent);
        Log.d(TAG, sb.toString());
        Intent intent2 = new Intent(activity, NativeBridgeActivity.class);
        intent2.putExtra(BRIDGED_INTENT, intent);
        activity.startActivity(intent2);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (this.pendingResult) {
            Log.w(TAG, "onDestroy called with pendingResult == true.  forwarding canceled result");
            forwardActivityResult(GPG_RESPONSE_CODE, 0, null);
            this.pendingResult = false;
        }
        super.onDestroy();
    }
}
