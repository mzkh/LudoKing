package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.PlatformVersion;

@TargetApi(19)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcab {
    @Nullable
    private PopupWindow zzfqx;
    @Nullable
    private Context zzlk;

    public final void zza(Context context, View view) {
        if (PlatformVersion.isAtLeastKitKat() && !PlatformVersion.isAtLeastLollipop()) {
            this.zzfqx = zzb(context, view);
            if (this.zzfqx == null) {
                context = null;
            }
            this.zzlk = context;
        }
    }

    public final void zzajm() {
        Context context = this.zzlk;
        if (!(context == null || this.zzfqx == null)) {
            if (!(context instanceof Activity) || !((Activity) context).isDestroyed()) {
                if (this.zzfqx.isShowing()) {
                    this.zzfqx.dismiss();
                }
                this.zzlk = null;
                this.zzfqx = null;
            } else {
                this.zzlk = null;
                this.zzfqx = null;
            }
        }
    }

    private static PopupWindow zzb(Context context, View view) {
        Window window = context instanceof Activity ? ((Activity) context).getWindow() : null;
        if (window == null || window.getDecorView() == null || ((Activity) context).isDestroyed()) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        frameLayout.addView(view, -1, -1);
        PopupWindow popupWindow = new PopupWindow(frameLayout, 1, 1, false);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setClippingEnabled(false);
        zzaug.zzdv("Displaying the 1x1 popup off the screen.");
        try {
            popupWindow.showAtLocation(window.getDecorView(), 0, -1, -1);
            return popupWindow;
        } catch (Exception unused) {
            return null;
        }
    }
}
