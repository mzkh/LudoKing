package com.tapjoy;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class TapjoyDisplayMetricsUtil {

    /* renamed from: a */
    private Context f6579a;

    /* renamed from: b */
    private Configuration f6580b;

    /* renamed from: c */
    private DisplayMetrics f6581c = new DisplayMetrics();

    public TapjoyDisplayMetricsUtil(Context context) {
        this.f6579a = context;
        ((WindowManager) this.f6579a.getSystemService("window")).getDefaultDisplay().getMetrics(this.f6581c);
        this.f6580b = this.f6579a.getResources().getConfiguration();
    }

    public int getScreenDensityDPI() {
        return this.f6581c.densityDpi;
    }

    public float getScreenDensityScale() {
        return this.f6581c.density;
    }

    public int getScreenLayoutSize() {
        return this.f6580b.screenLayout & 15;
    }
}
