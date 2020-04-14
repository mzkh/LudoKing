package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaas extends RelativeLayout {
    private static final float[] zzcvl = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    @Nullable
    private AnimationDrawable zzcvm;

    public zzaas(Context context, zzaat zzaat, LayoutParams layoutParams) {
        super(context);
        Preconditions.checkNotNull(zzaat);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(zzcvl, null, null));
        shapeDrawable.getPaint().setColor(zzaat.getBackgroundColor());
        setLayoutParams(layoutParams);
        zzq.zzkl();
        setBackground(shapeDrawable);
        LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(zzaat.getText())) {
            LayoutParams layoutParams3 = new LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(zzaat.getText());
            textView.setTextColor(zzaat.getTextColor());
            textView.setTextSize((float) zzaat.getTextSize());
            zzuv.zzoj();
            int zza = zzawy.zza(context, 4);
            zzuv.zzoj();
            textView.setPadding(zza, 0, zzawy.zza(context, 4), 0);
            addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List<zzaau> zzqf = zzaat.zzqf();
        String str = "Error while getting drawable.";
        if (zzqf != null && zzqf.size() > 1) {
            this.zzcvm = new AnimationDrawable();
            for (zzaau zzqi : zzqf) {
                try {
                    this.zzcvm.addFrame((Drawable) ObjectWrapper.unwrap(zzqi.zzqi()), zzaat.zzqg());
                } catch (Exception e) {
                    zzaug.zzc(str, e);
                }
            }
            zzq.zzkl();
            imageView.setBackground(this.zzcvm);
        } else if (zzqf.size() == 1) {
            try {
                imageView.setImageDrawable((Drawable) ObjectWrapper.unwrap(((zzaau) zzqf.get(0)).zzqi()));
            } catch (Exception e2) {
                zzaug.zzc(str, e2);
            }
        }
        addView(imageView);
    }

    public final void onAttachedToWindow() {
        AnimationDrawable animationDrawable = this.zzcvm;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
        super.onAttachedToWindow();
    }
}
