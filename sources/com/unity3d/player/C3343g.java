package com.unity3d.player;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* renamed from: com.unity3d.player.g */
public final class C3343g implements C3340d {
    /* renamed from: a */
    private static boolean m7735a(PackageItemInfo packageItemInfo) {
        try {
            return packageItemInfo.metaData.getBoolean("unityplayer.SkipPermissionsDialog");
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public final void mo30717a(Activity activity, String str) {
        if (activity != null && str != null) {
            FragmentManager fragmentManager = activity.getFragmentManager();
            String str2 = "96489";
            if (fragmentManager.findFragmentByTag(str2) == null) {
                C3344h hVar = new C3344h();
                Bundle bundle = new Bundle();
                bundle.putString("PermissionNames", str);
                hVar.setArguments(bundle);
                FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                beginTransaction.add(0, hVar, str2);
                beginTransaction.commit();
            }
        }
    }

    /* renamed from: a */
    public final boolean mo30718a(Activity activity) {
        try {
            PackageManager packageManager = activity.getPackageManager();
            ActivityInfo activityInfo = packageManager.getActivityInfo(activity.getComponentName(), 128);
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(activity.getPackageName(), 128);
            if (m7735a((PackageItemInfo) activityInfo) || m7735a((PackageItemInfo) applicationInfo)) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
