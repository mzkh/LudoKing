package com.tapjoy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.google.android.gms.drive.DriveFile;
import com.tapjoy.internal.C1830gy;
import com.tapjoy.internal.C1831gz;
import com.tapjoy.internal.C1833hb;
import com.tapjoy.internal.C3026ev.C3027a;
import com.tapjoy.internal.C3035ey;
import com.tapjoy.internal.C3047fc;
import com.tapjoy.internal.C3124gw;
import com.tapjoy.internal.C3145hk;
import java.util.List;

public class TapjoyReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Intent intent2;
        C1833hb.m3584b(context);
        if ("com.tapjoy.PUSH_CLICK".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("com.tapjoy.PUSH_ID");
            String str = Tapjoy.INTENT_EXTRA_PUSH_PAYLOAD;
            String stringExtra2 = intent.getStringExtra(str);
            String stringExtra3 = intent.getStringExtra("com.tapjoy.PUSH_PLACEMENT");
            if (!(stringExtra == null || stringExtra.length() == 0)) {
                PackageManager packageManager = context.getPackageManager();
                String packageName = context.getPackageName();
                Intent intent3 = new Intent("android.intent.action.MAIN");
                intent3.setPackage(packageName);
                intent3.addCategory("android.intent.category.LAUNCHER");
                List queryIntentActivities = packageManager.queryIntentActivities(intent3, 0);
                if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                    intent2 = null;
                } else {
                    intent2 = new Intent(intent3);
                    intent2.setFlags(DriveFile.MODE_READ_ONLY);
                    intent2.setClassName(((ResolveInfo) queryIntentActivities.get(0)).activityInfo.packageName, ((ResolveInfo) queryIntentActivities.get(0)).activityInfo.name);
                }
                if (intent2 != null) {
                    if (stringExtra2 != null) {
                        intent2.putExtra(str, stringExtra2);
                    }
                    C1831gz a = C1831gz.m3555a(context);
                    if (a.f3822f.mo18167c(stringExtra)) {
                        C1830gy gyVar = a.f3823g;
                        C3027a a2 = gyVar.mo18113a(C3035ey.APP, "push_click");
                        a2.f7026s = new C3047fc(null, null, stringExtra);
                        gyVar.mo18114a(a2);
                    }
                    if (stringExtra3 != null) {
                        C3145hk.m7274a(stringExtra, stringExtra3);
                    }
                    context.startActivity(intent2);
                } else {
                    C3124gw.m7221b("No intent that can be used to launch the main activity.");
                }
            }
        }
        if (isOrderedBroadcast()) {
            setResult(-1, null, null);
        }
    }
}
