package com.draft.unityplugins;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.unity3d.player.UnityPlayer;

public class NativeShare extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public static void Native_Share(String[] strArr, String str, String str2, String[] strArr2, String str3, String str4) {
        Activity activity = UnityPlayer.currentActivity;
        Intent intent = new Intent(activity, NativeShareActivity.class);
        intent.putExtra("type", "sharefile");
        intent.putExtra("filespath", strArr);
        intent.putExtra("subject", str);
        intent.putExtra(NotificationCompat.CATEGORY_MESSAGE, str2);
        intent.putExtra("emails", strArr2);
        intent.putExtra("shareType", str3);
        intent.putExtra("packagename", str4);
        activity.startActivity(intent);
    }
}
