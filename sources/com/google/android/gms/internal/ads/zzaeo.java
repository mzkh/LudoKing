package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzq;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzaeo implements zzaer<zzbbw> {
    zzaeo() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbbw zzbbw = (zzbbw) obj;
        WindowManager windowManager = (WindowManager) zzbbw.getContext().getSystemService("window");
        zzq.zzkj();
        View view = (View) zzbbw;
        DisplayMetrics zza = zzaul.zza(windowManager);
        int i = zza.widthPixels;
        int i2 = zza.heightPixels;
        int[] iArr = new int[2];
        HashMap hashMap = new HashMap();
        view.getLocationInWindow(iArr);
        hashMap.put("xInPixels", Integer.valueOf(iArr[0]));
        hashMap.put("yInPixels", Integer.valueOf(iArr[1]));
        hashMap.put("windowWidthInPixels", Integer.valueOf(i));
        hashMap.put("windowHeightInPixels", Integer.valueOf(i2));
        zzbbw.zza("locationReady", hashMap);
        zzaug.zzeu("GET LOCATION COMPILED");
    }
}
