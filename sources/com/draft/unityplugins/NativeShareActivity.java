package com.draft.unityplugins;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.StrictMode;
import androidx.core.app.NotificationCompat;
import com.facebook.appevents.AppEventsConstants;
import com.unity3d.player.UnityPlayer;
import java.util.ArrayList;
import java.util.Iterator;

public class NativeShareActivity extends Activity {
    private static int RESULT_SHARE = 101;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 24) {
            try {
                StrictMode.class.getMethod("disableDeathOnFileUriExposure", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Intent intent = getIntent();
        String string = intent.getExtras().getString("type");
        String string2 = intent.getExtras().getString("subject");
        String string3 = intent.getExtras().getString(NotificationCompat.CATEGORY_MESSAGE);
        String string4 = intent.getExtras().getString("shareType");
        String[] stringArray = intent.getExtras().getStringArray("emails");
        String string5 = intent.getExtras().getString("packagename");
        String[] stringArray2 = intent.getExtras().getStringArray("filespath");
        if (string.equals("sharefile")) {
            ShareFile(stringArray2, string2, string3, stringArray, string4, string5);
        }
    }

    /* access modifiers changed from: 0000 */
    public void ShareFile(String[] strArr, String str, String str2, String[] strArr2, String str3, String str4) {
        String str5;
        Intent intent;
        String[] strArr3 = strArr;
        String[] strArr4 = strArr2;
        String str6 = "android.intent.action.SEND";
        if (strArr3 != null) {
            String str7 = "android.intent.extra.STREAM";
            String str8 = "file://";
            if (strArr3.length > 1) {
                Intent intent2 = new Intent("android.intent.action.SEND_MULTIPLE");
                ArrayList arrayList = new ArrayList();
                for (String str9 : strArr3) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str8);
                    sb.append(str9);
                    arrayList.add(Uri.parse(sb.toString()));
                }
                intent2.setFlags(1);
                intent2.putParcelableArrayListExtra(str7, arrayList);
                intent = intent2;
                str5 = str3;
            } else {
                Intent intent3 = new Intent(str6);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str8);
                sb2.append(strArr3[0]);
                Uri parse = Uri.parse(sb2.toString());
                intent3.setFlags(1);
                intent3.putExtra(str7, parse);
                str5 = str3;
                intent = intent3;
            }
        } else {
            intent = new Intent(str6);
            str5 = "text/plain";
        }
        if (NullorEmpty(str5).booleanValue()) {
            str5 = "*/*";
        }
        intent.setType(str5);
        if (strArr4 != null) {
            intent.putExtra("android.intent.extra.EMAIL", strArr4);
        }
        if (!NullorEmpty(str).booleanValue()) {
            String str10 = str;
            intent.putExtra("android.intent.extra.SUBJECT", str);
        }
        if (!NullorEmpty(str2).booleanValue()) {
            intent.putExtra("android.intent.extra.TEXT", str2);
        }
        String str11 = "Share to";
        if (!NullorEmpty(str4).booleanValue()) {
            Boolean valueOf = Boolean.valueOf(false);
            Iterator it = getPackageManager().queryIntentActivities(intent, 0).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ResolveInfo resolveInfo = (ResolveInfo) it.next();
                if (resolveInfo.activityInfo.packageName.startsWith(str4)) {
                    intent.setPackage(resolveInfo.activityInfo.packageName);
                    valueOf = Boolean.valueOf(true);
                    break;
                }
            }
            if (valueOf.booleanValue()) {
                startActivityForResult(intent, RESULT_SHARE);
            } else {
                startActivityForResult(Intent.createChooser(intent, str11), RESULT_SHARE);
            }
        } else {
            startActivityForResult(Intent.createChooser(intent, str11), RESULT_SHARE);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        UnityPlayer.UnitySendMessage("NativeShareListener", "NativeShare_OnShareCompleted", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        finish();
        System.gc();
    }

    private static Boolean NullorEmpty(String str) {
        return (str == null || str.length() == 0) ? Boolean.valueOf(true) : Boolean.valueOf(false);
    }
}
