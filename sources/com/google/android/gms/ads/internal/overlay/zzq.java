package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzawy;
import com.google.android.gms.internal.ads.zzuv;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzq extends FrameLayout implements OnClickListener {
    private final ImageButton zzdig;
    private final zzy zzdih;

    public zzq(Context context, zzp zzp, @Nullable zzy zzy) {
        super(context);
        this.zzdih = zzy;
        setOnClickListener(this);
        this.zzdig = new ImageButton(context);
        this.zzdig.setImageResource(17301527);
        this.zzdig.setBackgroundColor(0);
        this.zzdig.setOnClickListener(this);
        ImageButton imageButton = this.zzdig;
        zzuv.zzoj();
        int zza = zzawy.zza(context, zzp.paddingLeft);
        zzuv.zzoj();
        int zza2 = zzawy.zza(context, 0);
        zzuv.zzoj();
        int zza3 = zzawy.zza(context, zzp.paddingRight);
        zzuv.zzoj();
        imageButton.setPadding(zza, zza2, zza3, zzawy.zza(context, zzp.paddingBottom));
        this.zzdig.setContentDescription("Interstitial close button");
        ImageButton imageButton2 = this.zzdig;
        zzuv.zzoj();
        int zza4 = zzawy.zza(context, zzp.size + zzp.paddingLeft + zzp.paddingRight);
        zzuv.zzoj();
        addView(imageButton2, new LayoutParams(zza4, zzawy.zza(context, zzp.size + zzp.paddingBottom), 17));
    }

    public final void onClick(View view) {
        zzy zzy = this.zzdih;
        if (zzy != null) {
            zzy.zzso();
        }
    }

    public final void zzae(boolean z) {
        if (z) {
            this.zzdig.setVisibility(8);
        } else {
            this.zzdig.setVisibility(0);
        }
    }
}
