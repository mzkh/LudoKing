package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.Preconditions;
import com.tapjoy.TJAdUnitConstants.String;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzayw extends FrameLayout implements zzayr {
    private final zzazj zzdya;
    private final FrameLayout zzdyb;
    private final zzaab zzdyc;
    private final zzazl zzdyd;
    private final long zzdye;
    @Nullable
    private zzayu zzdyf;
    private boolean zzdyg;
    private boolean zzdyh;
    private boolean zzdyi;
    private boolean zzdyj;
    private long zzdyk;
    private long zzdyl;
    private String zzdym;
    private String[] zzdyn;
    private Bitmap zzdyo;
    private ImageView zzdyp;
    private boolean zzdyq;

    public static void zzb(zzazj zzazj) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "no_video_view");
        zzazj.zza("onVideoEvent", hashMap);
    }

    public static void zza(zzazj zzazj, Map<String, List<Map<String, Object>>> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "decoderProps");
        hashMap.put("mimeTypes", map);
        zzazj.zza("onVideoEvent", hashMap);
    }

    public static void zza(zzazj zzazj, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "decoderProps");
        hashMap.put("error", str);
        zzazj.zza("onVideoEvent", hashMap);
    }

    public zzayw(Context context, zzazj zzazj, int i, boolean z, zzaab zzaab, zzazk zzazk) {
        Context context2 = context;
        super(context);
        zzazj zzazj2 = zzazj;
        this.zzdya = zzazj2;
        zzaab zzaab2 = zzaab;
        this.zzdyc = zzaab2;
        this.zzdyb = new FrameLayout(context);
        addView(this.zzdyb, new LayoutParams(-1, -1));
        Preconditions.checkNotNull(zzazj.zzxo());
        this.zzdyf = zzazj.zzxo().zzbko.zza(context, zzazj2, i, z, zzaab2, zzazk);
        zzayu zzayu = this.zzdyf;
        if (zzayu != null) {
            this.zzdyb.addView(zzayu, new LayoutParams(-1, -1, 17));
            if (((Boolean) zzuv.zzon().zzd(zzza.zzchp)).booleanValue()) {
                zzxc();
            }
        }
        this.zzdyp = new ImageView(context);
        this.zzdye = ((Long) zzuv.zzon().zzd(zzza.zzcht)).longValue();
        this.zzdyj = ((Boolean) zzuv.zzon().zzd(zzza.zzchr)).booleanValue();
        zzaab zzaab3 = this.zzdyc;
        if (zzaab3 != null) {
            zzaab3.zzj("spinner_used", this.zzdyj ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        this.zzdyd = new zzazl(this);
        zzayu zzayu2 = this.zzdyf;
        if (zzayu2 != null) {
            zzayu2.zza(this);
        }
        if (this.zzdyf == null) {
            zzn("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    public final void zzd(int i, int i2, int i3, int i4) {
        if (i3 != 0 && i4 != 0) {
            LayoutParams layoutParams = new LayoutParams(i3, i4);
            layoutParams.setMargins(i, i2, 0, 0);
            this.zzdyb.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public final void zzc(String str, String[] strArr) {
        this.zzdym = str;
        this.zzdyn = strArr;
    }

    public final void zza(float f, float f2) {
        zzayu zzayu = this.zzdyf;
        if (zzayu != null) {
            zzayu.zza(f, f2);
        }
    }

    public final void zzhk() {
        if (this.zzdyf != null) {
            if (!TextUtils.isEmpty(this.zzdym)) {
                this.zzdyf.zzb(this.zzdym, this.zzdyn);
                return;
            }
            zzd("no_src", new String[0]);
        }
    }

    public final void pause() {
        zzayu zzayu = this.zzdyf;
        if (zzayu != null) {
            zzayu.pause();
        }
    }

    public final void play() {
        zzayu zzayu = this.zzdyf;
        if (zzayu != null) {
            zzayu.play();
        }
    }

    public final void seekTo(int i) {
        zzayu zzayu = this.zzdyf;
        if (zzayu != null) {
            zzayu.seekTo(i);
        }
    }

    public final void zzxa() {
        zzayu zzayu = this.zzdyf;
        if (zzayu != null) {
            zzayu.zzdxy.setMuted(true);
            zzayu.zzwu();
        }
    }

    public final void zzxb() {
        zzayu zzayu = this.zzdyf;
        if (zzayu != null) {
            zzayu.zzdxy.setMuted(false);
            zzayu.zzwu();
        }
    }

    public final void setVolume(float f) {
        zzayu zzayu = this.zzdyf;
        if (zzayu != null) {
            zzayu.zzdxy.setVolume(f);
            zzayu.zzwu();
        }
    }

    public final void zzcs(int i) {
        this.zzdyf.zzcs(i);
    }

    public final void zzct(int i) {
        this.zzdyf.zzct(i);
    }

    public final void zzcu(int i) {
        this.zzdyf.zzcu(i);
    }

    public final void zzcv(int i) {
        this.zzdyf.zzcv(i);
    }

    public final void zzcw(int i) {
        this.zzdyf.zzcw(i);
    }

    @TargetApi(14)
    public final void zze(MotionEvent motionEvent) {
        zzayu zzayu = this.zzdyf;
        if (zzayu != null) {
            zzayu.dispatchTouchEvent(motionEvent);
        }
    }

    @TargetApi(14)
    public final void zzxc() {
        zzayu zzayu = this.zzdyf;
        if (zzayu != null) {
            TextView textView = new TextView(zzayu.getContext());
            String str = "AdMob - ";
            String valueOf = String.valueOf(this.zzdyf.zzwq());
            textView.setText(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            textView.setTextColor(SupportMenu.CATEGORY_MASK);
            textView.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
            this.zzdyb.addView(textView, new LayoutParams(-2, -2, 17));
            this.zzdyb.bringChildToFront(textView);
        }
    }

    public final void zzwv() {
        this.zzdyd.resume();
        zzaul.zzdsu.post(new zzayx(this));
    }

    public final void zzel() {
        zzayu zzayu = this.zzdyf;
        if (zzayu != null && this.zzdyl == 0) {
            zzd("canplaythrough", "duration", String.valueOf(((float) zzayu.getDuration()) / 1000.0f), String.VIDEO_WIDTH, String.valueOf(this.zzdyf.getVideoWidth()), String.VIDEO_HEIGHT, String.valueOf(this.zzdyf.getVideoHeight()));
        }
    }

    public final void zzww() {
        if (this.zzdya.zzxn() != null && !this.zzdyh) {
            this.zzdyi = (this.zzdya.zzxn().getWindow().getAttributes().flags & 128) != 0;
            if (!this.zzdyi) {
                this.zzdya.zzxn().getWindow().addFlags(128);
                this.zzdyh = true;
            }
        }
        this.zzdyg = true;
    }

    public final void onPaused() {
        zzd("pause", new String[0]);
        zzxf();
        this.zzdyg = false;
    }

    public final void zzwx() {
        zzd("ended", new String[0]);
        zzxf();
    }

    public final void zzn(String str, @Nullable String str2) {
        zzd("error", "what", str, "extra", str2);
    }

    public final void zzwy() {
        if (this.zzdyq && this.zzdyo != null && !zzxe()) {
            this.zzdyp.setImageBitmap(this.zzdyo);
            this.zzdyp.invalidate();
            this.zzdyb.addView(this.zzdyp, new LayoutParams(-1, -1));
            this.zzdyb.bringChildToFront(this.zzdyp);
        }
        this.zzdyd.pause();
        this.zzdyl = this.zzdyk;
        zzaul.zzdsu.post(new zzaza(this));
    }

    public final void destroy() {
        this.zzdyd.pause();
        zzayu zzayu = this.zzdyf;
        if (zzayu != null) {
            zzayu.stop();
        }
        zzxf();
    }

    public final void finalize() throws Throwable {
        try {
            this.zzdyd.pause();
            if (this.zzdyf != null) {
                zzayu zzayu = this.zzdyf;
                zzddl zzddl = zzaxn.zzdwm;
                zzayu.getClass();
                zzddl.execute(zzayv.zza(zzayu));
            }
        } finally {
            super.finalize();
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzxd() {
        zzayu zzayu = this.zzdyf;
        if (zzayu != null) {
            long currentPosition = (long) zzayu.getCurrentPosition();
            if (this.zzdyk != currentPosition && currentPosition > 0) {
                zzd("timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
                this.zzdyk = currentPosition;
            }
        }
    }

    public final void zzwz() {
        if (this.zzdyg && zzxe()) {
            this.zzdyb.removeView(this.zzdyp);
        }
        if (this.zzdyo != null) {
            long elapsedRealtime = zzq.zzkq().elapsedRealtime();
            if (this.zzdyf.getBitmap(this.zzdyo) != null) {
                this.zzdyq = true;
            }
            long elapsedRealtime2 = zzq.zzkq().elapsedRealtime() - elapsedRealtime;
            if (zzaug.zzuu()) {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Spinner frame grab took ");
                sb.append(elapsedRealtime2);
                sb.append("ms");
                zzaug.zzdy(sb.toString());
            }
            if (elapsedRealtime2 > this.zzdye) {
                zzaug.zzeu("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.zzdyj = false;
                this.zzdyo = null;
                zzaab zzaab = this.zzdyc;
                if (zzaab != null) {
                    zzaab.zzj("spinner_jank", Long.toString(elapsedRealtime2));
                }
            }
        }
    }

    public final void zzj(int i, int i2) {
        if (this.zzdyj) {
            int max = Math.max(i / ((Integer) zzuv.zzon().zzd(zzza.zzchs)).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) zzuv.zzon().zzd(zzza.zzchs)).intValue(), 1);
            Bitmap bitmap = this.zzdyo;
            if (bitmap == null || bitmap.getWidth() != max || this.zzdyo.getHeight() != max2) {
                this.zzdyo = Bitmap.createBitmap(max, max2, Config.ARGB_8888);
                this.zzdyq = false;
            }
        }
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.zzdyd.resume();
        } else {
            this.zzdyd.pause();
            this.zzdyl = this.zzdyk;
        }
        zzaul.zzdsu.post(new zzayy(this, z));
    }

    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.zzdyd.resume();
            z = true;
        } else {
            this.zzdyd.pause();
            this.zzdyl = this.zzdyk;
            z = false;
        }
        zzaul.zzdsu.post(new zzayz(this, z));
    }

    private final boolean zzxe() {
        return this.zzdyp.getParent() != null;
    }

    /* access modifiers changed from: private */
    public final void zzd(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                hashMap.put(str2, str3);
                str2 = null;
            }
        }
        this.zzdya.zza("onVideoEvent", hashMap);
    }

    private final void zzxf() {
        if (this.zzdya.zzxn() != null && this.zzdyh && !this.zzdyi) {
            this.zzdya.zzxn().getWindow().clearFlags(128);
            this.zzdyh = false;
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzan(boolean z) {
        zzd("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
    }
}
