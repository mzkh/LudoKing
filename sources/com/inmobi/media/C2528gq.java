package com.inmobi.media;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.inmobi.media.gq */
/* compiled from: DisplayInfo */
public class C2528gq {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f5539a = "gq";

    /* renamed from: com.inmobi.media.gq$a */
    /* compiled from: DisplayInfo */
    static class C2530a extends Thread {
        @NonNull

        /* renamed from: a */
        String f5540a;

        public C2530a(@NonNull String str) {
            this.f5540a = str;
        }

        public final void run() {
            String str = "\"";
            Context c = C2505gd.m5298c();
            if (c != null) {
                try {
                    String[] split = this.f5540a.split("Insets");
                    StringBuffer stringBuffer = new StringBuffer();
                    if (split.length > 1) {
                        String[] split2 = split[1].replaceAll("[^0-9,=a-zA-Z]*", "").split(",");
                        stringBuffer.append("{");
                        for (int i = 0; i < split2.length; i++) {
                            String[] split3 = split2[i].split("=");
                            PrintStream printStream = System.out;
                            StringBuilder sb = new StringBuilder("The individual String is  - ");
                            sb.append(split3[0]);
                            printStream.println(sb.toString());
                            if (split3.length == 2) {
                                StringBuilder sb2 = new StringBuilder(str);
                                sb2.append(split3[0]);
                                sb2.append(str);
                                stringBuffer.append(sb2.toString());
                                stringBuffer.append(":");
                                stringBuffer.append(C2528gq.m5396b(Integer.parseInt(split3[1])));
                                if (i < split2.length - 1) {
                                    stringBuffer.append(", ");
                                }
                            }
                        }
                        stringBuffer.append("}");
                    }
                    if (stringBuffer.length() > 0) {
                        C2494fy.m5249a(c, "gesture_info_store").mo28439a("gesture_margin", stringBuffer.toString());
                    }
                } catch (Exception unused) {
                    C2528gq.f5539a;
                }
            }
        }
    }

    /* renamed from: a */
    public static int m5392a(int i) {
        return Math.round(((float) i) * m5393a().f5543c);
    }

    /* renamed from: a */
    public static C2531gr m5393a() {
        Context c = C2505gd.m5298c();
        if (c == null) {
            return new C2531gr(0, 0, 2.0f);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) c.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        float f = displayMetrics.density;
        return new C2531gr(Math.round(((float) displayMetrics.widthPixels) / f), Math.round(((float) displayMetrics.heightPixels) / f), f);
    }

    /* renamed from: b */
    public static int m5396b(int i) {
        return Math.round(((float) i) / m5393a().f5543c);
    }

    /* renamed from: b */
    public static int m5395b() {
        Context c = C2505gd.m5298c();
        if (c == null) {
            return 1;
        }
        int rotation = ((WindowManager) c.getSystemService("window")).getDefaultDisplay().getRotation();
        int i = c.getResources().getConfiguration().orientation;
        if (i != 1) {
            if (i != 2) {
                return 1;
            }
            return (rotation == 0 || rotation == 1) ? 3 : 4;
        } else if (rotation == 1 || rotation == 2) {
            return 2;
        } else {
            return 1;
        }
    }

    /* renamed from: c */
    public static Map<String, String> m5397c() {
        String str;
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("d-device-screen-density", String.valueOf(m5393a().f5543c));
            C2531gr a = m5393a();
            StringBuilder sb = new StringBuilder();
            sb.append(a.f5541a);
            sb.append("X");
            sb.append(a.f5542b);
            hashMap.put("d-device-screen-size", sb.toString());
            String str2 = "d-density-dependent-screen-size";
            Context c = C2505gd.m5298c();
            if (c == null) {
                str = "0x0";
            } else {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) c.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                int i = displayMetrics.widthPixels;
                int i2 = displayMetrics.heightPixels;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i);
                sb2.append("x");
                sb2.append(i2);
                str = sb2.toString();
            }
            hashMap.put(str2, str);
            hashMap.put("d-orientation", String.valueOf(m5395b()));
            hashMap.put("d-textsize", String.valueOf(new TextView(C2505gd.m5298c()).getTextSize()));
        } catch (Exception unused) {
        }
        return hashMap;
    }

    @UiThread
    @TargetApi(29)
    /* renamed from: a */
    public static void m5394a(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    try {
                        C2528gq.f5539a;
                        windowInsets.getSystemGestureInsets();
                        new C2530a(windowInsets.getSystemGestureInsets().toString()).start();
                    } catch (Exception unused) {
                        C2528gq.f5539a;
                    }
                    return view.onApplyWindowInsets(windowInsets);
                }
            });
            activity.getWindow().getDecorView().requestApplyInsets();
        }
    }

    @Nullable
    /* renamed from: d */
    public static String m5398d() {
        Context c = C2505gd.m5298c();
        if (c == null) {
            return null;
        }
        return C2494fy.m5249a(c, "gesture_info_store").mo28442b("gesture_margin");
    }
}
