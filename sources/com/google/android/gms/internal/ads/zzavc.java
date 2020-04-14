package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager.LayoutParams;
import com.google.android.gms.ads.internal.zzq;
import java.util.Locale;
import javax.annotation.ParametersAreNonnullByDefault;

@TargetApi(28)
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzavc extends zzauz {
    public final void zzg(Activity activity) {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzckx)).booleanValue() && zzq.zzkn().zzuh().zzvk() == null && !activity.isInMultiWindowMode()) {
            zza(true, activity);
            activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new zzavb(this, activity));
        }
    }

    private static void zza(boolean z, Activity activity) {
        Window window = activity.getWindow();
        LayoutParams attributes = window.getAttributes();
        int i = attributes.layoutInDisplayCutoutMode;
        int i2 = z ? 1 : 2;
        if (i2 != i) {
            attributes.layoutInDisplayCutoutMode = i2;
            window.setAttributes(attributes);
        }
    }

    static /* synthetic */ WindowInsets zza(Activity activity, View view, WindowInsets windowInsets) {
        if (zzq.zzkn().zzuh().zzvk() == null) {
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            String str = "";
            if (displayCutout != null) {
                zzaui zzuh = zzq.zzkn().zzuh();
                for (Rect rect : displayCutout.getBoundingRects()) {
                    String format = String.format(Locale.US, "%d,%d,%d,%d", new Object[]{Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.right), Integer.valueOf(rect.bottom)});
                    if (!TextUtils.isEmpty(str)) {
                        str = String.valueOf(str).concat("|");
                    }
                    String valueOf = String.valueOf(str);
                    String valueOf2 = String.valueOf(format);
                    str = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                }
                zzuh.zzec(str);
            } else {
                zzq.zzkn().zzuh().zzec(str);
            }
        }
        zza(false, activity);
        return view.onApplyWindowInsets(windowInsets);
    }
}
