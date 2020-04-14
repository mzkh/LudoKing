package com.inmobi.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.NonNull;

/* renamed from: com.inmobi.media.ek */
/* compiled from: NativeVideoWrapper */
public class C2403ek extends RelativeLayout {

    /* renamed from: a */
    private static final String f5125a = "ek";

    /* renamed from: b */
    private C2390ej f5126b = new C2390ej(getContext());

    /* renamed from: c */
    private ImageView f5127c;

    /* renamed from: d */
    private ProgressBar f5128d;

    public C2403ek(Context context) {
        super(context);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(this.f5126b, layoutParams);
        this.f5127c = new ImageView(getContext());
        this.f5127c.setScaleType(ScaleType.FIT_XY);
        this.f5127c.setVisibility(8);
        addView(this.f5127c, layoutParams);
        this.f5128d = new ProgressBar(getContext());
        this.f5128d.setVisibility(8);
        LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        addView(this.f5128d, layoutParams2);
        C2387ei eiVar = new C2387ei(getContext());
        LayoutParams layoutParams3 = new LayoutParams(-1, -1);
        layoutParams3.addRule(13);
        this.f5126b.setMediaController(eiVar);
        addView(eiVar, layoutParams3);
    }

    /* renamed from: a */
    public final void mo28316a() {
        LayoutParams layoutParams;
        double d;
        double d2;
        C2235bp bpVar = (C2235bp) this.f5126b.getTag();
        if (bpVar != null) {
            try {
                String b = bpVar.mo27982b().mo28138b();
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(b);
                int intValue = Integer.valueOf(mediaMetadataRetriever.extractMetadata(18)).intValue();
                int intValue2 = Integer.valueOf(mediaMetadataRetriever.extractMetadata(19)).intValue();
                mediaMetadataRetriever.release();
                Point point = bpVar.f4523c.f4546a;
                double c = (double) C2404el.m5028c(point.x);
                double c2 = (double) C2404el.m5028c(point.y);
                Double.isNaN(c);
                Double.isNaN(c2);
                double d3 = c / c2;
                double d4 = (double) intValue;
                double d5 = (double) intValue2;
                Double.isNaN(d4);
                Double.isNaN(d5);
                if (d3 > d4 / d5) {
                    double c3 = (double) C2404el.m5028c(point.y);
                    Double.isNaN(c3);
                    double d6 = c3 * 1.0d;
                    Double.isNaN(d5);
                    double d7 = d6 / d5;
                    Double.isNaN(d4);
                    d2 = d4 * d7;
                    d = (double) C2404el.m5028c(point.y);
                } else {
                    double c4 = (double) C2404el.m5028c(point.x);
                    double c5 = (double) C2404el.m5028c(point.x);
                    Double.isNaN(c5);
                    double d8 = c5 * 1.0d;
                    Double.isNaN(d4);
                    double d9 = d8 / d4;
                    Double.isNaN(d5);
                    d2 = c4;
                    d = d5 * d9;
                }
                layoutParams = new LayoutParams((int) d2, (int) d);
            } catch (Exception e) {
                LayoutParams layoutParams2 = new LayoutParams(-1, -1);
                C2463fd.m5161a().mo28382a(new C2495fz(e));
                layoutParams = layoutParams2;
            }
            layoutParams.addRule(13);
            this.f5126b.setLayoutParams(layoutParams);
        }
    }

    public void setPosterImage(@NonNull Bitmap bitmap) {
        this.f5127c.setImageBitmap(bitmap);
    }

    @NonNull
    public C2390ej getVideoView() {
        return this.f5126b;
    }

    @NonNull
    public ImageView getPoster() {
        return this.f5127c;
    }

    @NonNull
    public ProgressBar getProgressBar() {
        return this.f5128d;
    }
}
